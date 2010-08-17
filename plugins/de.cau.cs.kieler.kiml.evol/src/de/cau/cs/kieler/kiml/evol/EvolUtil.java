/*
 * KIELER - Kiel Integrated Environment for Layout Eclipse RichClient
 *
 * http://www.informatik.uni-kiel.de/rtsys/kieler/
 *
 * Copyright 2010 by
 *   + Christian-Albrechts-University of Kiel
 *     + Department of Computer Science
 *       + Real-Time and Embedded Systems Group
 *
 * This code is provided under the terms of the Eclipse Public License (EPL).
 * See the file epl-v10.html for the license text.
 */
package de.cau.cs.kieler.kiml.evol;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.views.properties.IPropertyDescriptor;

import de.cau.cs.kieler.core.alg.BasicProgressMonitor;
import de.cau.cs.kieler.core.alg.IKielerProgressMonitor;
import de.cau.cs.kieler.core.kgraph.KNode;
import de.cau.cs.kieler.core.ui.util.MonitoredOperation;
import de.cau.cs.kieler.kiml.LayoutOptionData;
import de.cau.cs.kieler.kiml.LayoutOptionData.Type;
import de.cau.cs.kieler.kiml.LayoutProviderData;
import de.cau.cs.kieler.kiml.LayoutServices;
import de.cau.cs.kieler.kiml.evol.genetic.Distribution;
import de.cau.cs.kieler.kiml.evol.genetic.EnumGene;
import de.cau.cs.kieler.kiml.evol.genetic.FloatTypeInfo;
import de.cau.cs.kieler.kiml.evol.genetic.Genome;
import de.cau.cs.kieler.kiml.evol.genetic.IGene;
import de.cau.cs.kieler.kiml.evol.genetic.IGeneFactory;
import de.cau.cs.kieler.kiml.evol.genetic.IValueFormatter;
import de.cau.cs.kieler.kiml.evol.genetic.MutationInfo;
import de.cau.cs.kieler.kiml.evol.genetic.Population;
import de.cau.cs.kieler.kiml.evol.genetic.TypeInfo;
import de.cau.cs.kieler.kiml.evol.genetic.UniversalGene;
import de.cau.cs.kieler.kiml.grana.AbstractInfoAnalysis;
import de.cau.cs.kieler.kiml.grana.AnalysisServices;
import de.cau.cs.kieler.kiml.grana.ui.DiagramAnalyser;
import de.cau.cs.kieler.kiml.options.LayoutOptions;
import de.cau.cs.kieler.kiml.ui.layout.DiagramLayoutManager;
import de.cau.cs.kieler.kiml.ui.layout.EclipseLayoutServices;
import de.cau.cs.kieler.kiml.ui.layout.ILayoutInspector;
import de.cau.cs.kieler.kiml.ui.views.LayoutPropertySource;
import de.cau.cs.kieler.kiml.ui.views.LayoutViewPart;

/**
 * Utility methods for Evolutionary Meta Layout.
 *
 * @author bdu
 *
 */
public final class EvolUtil {
    /**
     * Auto-rater for an individual.
     *
     * @author bdu
     *
     */
    private static final class AutoRateIndividualRunnable implements Runnable {
        /**
         * Creates a new {@link AutoRateIndividualRunnable} instance.
         *
         * @param theIndividual
         * @param theEditor
         */
        AutoRateIndividualRunnable(final Genome theIndividual, final IEditorPart theEditor) {
            this.individual = theIndividual;
            this.editor = theEditor;
        }

        /**
        *
        */
        private final Genome individual;

        /**
        *
        */
        private IEditorPart editor;

        public void run() {
            // Must be run in the UI thread.
            if (this.editor == null) {
                this.editor = getCurrentEditor();
            }

            autoRateIndividual(this.individual, this.editor);

        }
    }

    /**
     * A factory for genes.
     *
     * @author bdu
     *
     */
    private static class GeneFactory implements IGeneFactory {
        /**
         * The absolute value is scaled by this factor to get the default
         * variance.
         */
        private static final double VARIANCE_SCALING_FACTOR = .20;

        private static final String ATTRIBUTE_LOWER_BOUND = "lowerBound";
        private static final String ATTRIBUTE_UPPER_BOUND = "upperBound";
        private static final String ATTRIBUTE_DISTRIBUTION = "distribution";
        private static final String ATTRIBUTE_VARIANCE = "variance";

        /**
         * Creates a new {@link GeneFactory}.
         */
        GeneFactory() {
            // nothing to do here
        }

        /**
         * Creates a gene with the specified value.
         *
         * @param theId
         *            an identifier
         * @param theValue
         *            a value
         * @param theMutationProbability
         *            the mutation probability
         * @return a gene
         */
        public IGene<?> newGene(
                final Object theId, final Object theValue, final double theMutationProbability) {

            IGene<?> result;

            final IConfigurationElement evolutionData =
                    EvolutionServices.getInstance().getEvolutionData((String) theId);
            // FIXME: evolutionData might be null
            Assert.isNotNull(evolutionData);

            final String lowerBoundAttr = evolutionData.getAttribute(ATTRIBUTE_LOWER_BOUND);
            final String upperBoundAttr = evolutionData.getAttribute(ATTRIBUTE_UPPER_BOUND);
            final String distrNameAttr = evolutionData.getAttribute(ATTRIBUTE_DISTRIBUTION);
            final String varianceAttr = evolutionData.getAttribute(ATTRIBUTE_VARIANCE);

            final Distribution distr = Distribution.valueOf(distrNameAttr);
            // FIXME: distrNameAttr might be wrong

            final LayoutOptionData layoutOptionData =
                    LayoutServices.getInstance().getLayoutOptionData((String) theId);
            // FIXME: layoutOptionData might be null
            Assert.isNotNull(layoutOptionData);

            final Type layoutOptionDataType = layoutOptionData.getType();

            switch (layoutOptionDataType) {
            case BOOLEAN:
                result = newBooleanGene(theId, theValue, theMutationProbability, distr);
                break;

            case ENUM:
                result = newEnumGene(theId, theValue, theMutationProbability, layoutOptionData);
                break;

            case INT:
                result =
                        newIntegerGene(theId, theValue, theMutationProbability, lowerBoundAttr,
                                upperBoundAttr, varianceAttr, distr);
                break;

            case FLOAT:
                result =
                        newFloatGene(theId, theValue, theMutationProbability, lowerBoundAttr,
                                upperBoundAttr, varianceAttr, distr);
                break;

            default:
                result = null;
                break;
            }
            return result;
        }

        public IGene<?> newGene(
                final Object theId, final Object theValue, final TypeInfo<?> theTypeInfo,
                final MutationInfo theMutationInfo) {
            Assert.isLegal(theTypeInfo instanceof FloatTypeInfo);

            if (theTypeInfo instanceof FloatTypeInfo) {
                return new UniversalGene(theId, (Float) theValue, (FloatTypeInfo) theTypeInfo,
                        theMutationInfo);
            }

            return null;
        }

        /**
         *
         * @param theId
         * @param theValue
         * @param theMutationProbability
         * @param distr
         * @return
         */
        private IGene<?> newBooleanGene(
                final Object theId, final Object theValue, final double theMutationProbability,
                final Distribution distr) {
            IGene<?> result;
            final boolean booleanValue = (Integer.parseInt(theValue.toString()) == 1);
            final Float floatValue = Float.valueOf((booleanValue ? 1.0f : 0.0f));
            final MutationInfo mutationInfo = new MutationInfo(theMutationProbability, distr);
            result =
                    new UniversalGene(theId, floatValue, UniversalGene.BOOLEAN_TYPE_INFO,
                            mutationInfo);
            System.out.println(theId + ": " + result);
            return result;
        }

        /**
         * @param theId
         * @param theRawValue
         * @param theMutationProbability
         * @param layoutOptionData
         * @return
         */
        private IGene<?> newEnumGene(
                final Object theId, final Object theRawValue,
                final double theMutationProbability, final LayoutOptionData layoutOptionData) {
            IGene<?> result;
            final int choicesCount = layoutOptionData.getChoices().length;
            final Class<? extends Enum<?>> enumClass = LayoutOptions.getEnumClass((String) theId);
            Assert.isNotNull(enumClass);
            Assert.isTrue(enumClass.getEnumConstants().length == choicesCount);
            final Integer value = Integer.valueOf(theRawValue.toString());
            result = new EnumGene(theId, value.intValue(), enumClass, theMutationProbability);
            System.out.println("Enum " + enumClass.getSimpleName() + "(" + choicesCount + "): "
                    + value);
            return result;
        }

        /**
         * @param theId
         * @param theRawValue
         *            an object containing a string that represents a float
         * @param theMutationProbability
         * @param lowerBoundAttr
         * @param upperBoundAttr
         * @param varianceAttr
         * @param distr
         * @return
         */
        private IGene<?> newFloatGene(
                final Object theId, final Object theRawValue,
                final double theMutationProbability, final String lowerBoundAttr,
                final String upperBoundAttr, final String varianceAttr, final Distribution distr) {
            IGene<?> result;
            final Float value = Float.valueOf((String) theRawValue);
            final Float lowerBound =
                    Float.valueOf((lowerBoundAttr == null ? Float.NEGATIVE_INFINITY : Float
                            .parseFloat(lowerBoundAttr)));
            final Float upperBound =
                    Float.valueOf(((upperBoundAttr == null) ? Float.POSITIVE_INFINITY : Float
                            .parseFloat(upperBoundAttr)));

            final double variance;
            if (varianceAttr != null) {
                // get variance from evolution data
                variance = Double.parseDouble(varianceAttr);

            } else {
                // threshold to prevent very small variances
                final float verySmall = 1e-3f;

                // estimate desired variance from the absolute value
                if ((Math.abs(value.floatValue()) < verySmall)) {
                    variance = MutationInfo.DEFAULT_VARIANCE;
                } else {
                    variance = Math.abs(value.floatValue()) * VARIANCE_SCALING_FACTOR;
                }
            }

            final IValueFormatter formatter;
            if (lowerBound.floatValue() >= 0.0f) {
                // we need a strictly positive float gene
                formatter = UniversalGene.STRICTLY_POSITIVE_FLOAT_FORMATTER;

            } else {
                // we use a general float gene
                formatter = UniversalGene.FLOAT_FORMATTER;
            }

            final TypeInfo<Float> typeInfo =
                    new FloatTypeInfo(value, lowerBound, upperBound, formatter, Float.class);

            final MutationInfo mutationInfo =
                    new MutationInfo(theMutationProbability, variance, distr);
            result = new UniversalGene(theId, value, typeInfo, mutationInfo);
            System.out.println(theId + ": " + result);
            return result;
        }

        /**
         * @param theId
         * @param theRawValue
         * @param theMutationProbability
         * @param lowerBoundAttr
         * @param upperBoundAttr
         * @param varianceAttr
         * @param distr
         * @return
         */
        private IGene<?> newIntegerGene(
                final Object theId, final Object theRawValue,
                final double theMutationProbability, final String lowerBoundAttr,
                final String upperBoundAttr, final String varianceAttr, final Distribution distr) {
            IGene<?> result;
            final Integer value = Integer.valueOf((String) theRawValue);

            final double variance;
            if (varianceAttr != null) {
                // get variance from evolution data
                variance = Double.parseDouble(varianceAttr);
            } else {
                // estimate desired variance from the absolute value
                variance = Math.abs(value.intValue()) * VARIANCE_SCALING_FACTOR;
            }

            final Integer lowerBound =
                    Integer.valueOf(((lowerBoundAttr == null) ? Integer.MIN_VALUE : (Integer
                            .parseInt(lowerBoundAttr))));

            final Integer upperBound =
                    Integer.valueOf(((upperBoundAttr == null) ? Integer.MAX_VALUE : (Integer
                            .parseInt(upperBoundAttr))));

            final IValueFormatter formatter = UniversalGene.INTEGER_FORMATTER;

            final TypeInfo<Float> typeInfo =
                    new FloatTypeInfo(Float.valueOf(value.floatValue()), Float.valueOf(lowerBound
                            .floatValue()), Float.valueOf(upperBound.floatValue()), formatter,
                            Integer.class);

            final MutationInfo mutationInfo =
                    new MutationInfo(theMutationProbability, variance, distr);
            result =
                    new UniversalGene(theId, Float.valueOf(value.floatValue()), typeInfo,
                            mutationInfo);
            System.out.println(theId + ": " + result);
            return result;
        }
    }

    /**
     * Applier for an individual. Can adopt, layout and measure an individual in
     * the appropriate editor(s).
     *
     * @author bdu
     *
     */
    private static final class IndividualApplierRunnable implements Runnable {
        /**
         * Creates a new {@link IndividualApplierRunnable} instance.
         *
         * @param theIndividual
         * @param theLayoutProviderId
         */
        IndividualApplierRunnable(final Genome theIndividual, final String theLayoutProviderId) {
            this.layoutProviderId = theLayoutProviderId;
            this.individual = theIndividual;
        }

        /**
         * The expected layout provider ID.
         */
        private final String layoutProviderId;

        /**
         * The individual.
         */
        private final Genome individual;

        public void run() {
            // Adopt, layout and measure the given individual in the appropriate
            // editor(s).
            applyIndividual(this.individual, this.layoutProviderId);
        }
    }

    /**
     * Refresher for the layout view.
     *
     * @author bdu
     *
     */
    private static class LayoutViewRefreshRunnable implements Runnable {
        /**
         * Constructs a new {@link LayoutViewRefreshRunnable} instance.
         */
        LayoutViewRefreshRunnable() {
            // nothing to do here.
        }

        public void run() {
            final LayoutViewPart layoutView = LayoutViewPart.findView();
            if (layoutView != null) {
                layoutView.refresh(); // async!
            }
        }
    }

    /**
     * Asynchronously refreshes the layout view, if it can be found.
     */
    public static void asyncRefreshLayoutView() {
        MonitoredOperation.runInUI(new LayoutViewRefreshRunnable(), false);
    }

    /**
     * Auto-rate the given population in the given editor.
     *
     * @param thePopulation
     *            the {@link Population} to be rated
     * @param theEditor
     *            an {@link IEditorPart}; must not be {@code null}
     * @param theMonitor
     *            a progress monitor; may be {@code null}
     */
    public static void autoRate(
            final Population thePopulation, final IEditorPart theEditor,
            final IProgressMonitor theMonitor) {
        Assert.isLegal((thePopulation != null));
        if (thePopulation == null) {
            return;
        }

        // TODO: don't need theEditor

        // Ensure there is a monitor of some sort.
        final IProgressMonitor monitor;
        monitor = ((theMonitor != null) ? theMonitor : new NullProgressMonitor());

        final int size = thePopulation.size();
        final int total = size;
        final int scale = 100;

        try {
            monitor.beginTask("Auto-rating individuals.", total * scale);

            // Calculate auto-rating for each individual.
            for (final Genome ind : thePopulation) {
                if (monitor.isCanceled()) {
                    throw new OperationCanceledException();
                }

                // syncAutoRate(ind, theEditor);
                syncAutoRate(ind, theEditor);
                monitor.worked(1 * scale);
            }

        } finally {
            monitor.done();
        }
    }

    /**
     * Creates a population of the default size, taking initial values from the
     * given diagram editors.
     *
     * @param editors
     *            a set of {@link IEditorPart} instances. Must be
     *            DiagramEditors.
     * @return a new {@link Population} of default size, or an empty
     *         {@link Population} in case of an error
     */
    public static Population createPopulation(final Set<IEditorPart> editors) {
        if ((editors == null) || editors.isEmpty()) {
            return new Population();
        }

        final List<LayoutPropertySource> sources = getLayoutPropertySources(editors);
        Assert.isNotNull(sources);

        if (sources.isEmpty()) {
            return new Population();
        }

        final Population result = createPopulation(sources);
        return result;
    }

    /**
     * @param editors
     * @return
     */
    private static List<LayoutPropertySource> getLayoutPropertySources(
            final Set<IEditorPart> editors) {
        final List<LayoutPropertySource> sources = new LinkedList<LayoutPropertySource>();

        // Collect the layout property sources of the editors.
        for (final IEditorPart editor : editors) {
            if (!(editor instanceof DiagramEditor)) {
                // Editor is not a DiagramEditor. Skip it.
                continue;
            }

            final EditPart editPart = ((DiagramEditor) editor).getDiagramEditPart().getRoot();

            final DiagramLayoutManager manager =
                    EclipseLayoutServices.getInstance().getManager(editor, editPart);
            if (manager == null) {
                // No layout manager found. Ignore this editor.
                continue;
            }

            final ILayoutInspector inspector = manager.getInspector(editPart);
            Assert.isNotNull(inspector);
            final LayoutPropertySource propertySource = new LayoutPropertySource(inspector);
            sources.add(propertySource);
        }
        return sources;
    }

    /**
     * Creates a population of the default size, taking initial values from the
     * given diagram editor and edit part.
     *
     * @param editor
     *            an {@link IEditorPart}
     * @param part
     *            an {@link EditPart}
     * @return a new {@link Population} of default size, or an empty
     *         {@link Population} in case of an error
     * @deprecated
     */
    @Deprecated
    public static Population createPopulation(final IEditorPart editor, final EditPart part) {
        if ((editor == null) || !(editor instanceof DiagramEditor)) {
            return new Population();
        }

        final DiagramLayoutManager manager =
                EclipseLayoutServices.getInstance().getManager(editor, part);
        if (manager == null) {
            return new Population();
        }

        final ILayoutInspector inspector = manager.getInspector(part);
        Assert.isNotNull(inspector);
        final LayoutPropertySource propertySource = new LayoutPropertySource(inspector);
        final Population result = createPopulation(propertySource);

        return result;
    }

    /**
     * Returns the current editor (if any). Returns {@code null} if called from
     * a non-UI thread.
     *
     * @return the current editor or {@code null} if none exists or if called
     *         from a non-UI thread.
     */
    public static IEditorPart getCurrentEditor() {
        // Try to get the editor that is tracked by the layout view (must be in
        // UI thread).
        final LayoutViewPart layoutViewPart = LayoutViewPart.findView();
        if (layoutViewPart != null) {
            final IEditorPart editor = layoutViewPart.getCurrentEditor();
            if (editor != null) {
                return editor;
            }
        }

        // Try to get the active editor of the workbench (must be in UI thread).
        final IWorkbench workbench = PlatformUI.getWorkbench();
        final IWorkbenchWindow window = workbench.getActiveWorkbenchWindow();
        if (window == null) {
            return null;
        }
        final IWorkbenchPage page = window.getActivePage();
        if (page == null) {
            return null;
        }
        final IEditorPart editor = page.getActiveEditor();
        if (editor != null) {
            return editor;
        }

        // No active editor could be found.
        return null;
    }

    /**
     * Find all the visible graphical editors in the workbench.
     *
     * @return a collection of the visible graphical editors; may be empty.
     */
    public static Set<IEditorPart> getEditors() {

        final Set<IEditorPart> result = new HashSet<IEditorPart>();

        // Try to get the editors of the workbench.
        final IWorkbench workbench = PlatformUI.getWorkbench();
        final IWorkbenchWindow window = workbench.getActiveWorkbenchWindow();
        if (window == null) {
            return result;
        }

        final IWorkbenchPage[] pages = window.getPages();
        for (final IWorkbenchPage page : pages) {
            if (page.isEditorAreaVisible()) {
                final IEditorReference[] references = page.getEditorReferences();
                Assert.isNotNull(references);

                for (final IEditorReference ref : references) {
                    final IEditorPart editor = ref.getEditor(false);
                    if (editor instanceof DiagramEditor) {
                        result.add(editor);
                    }
                }
            }
        }

        return result;
    }

    /**
     * Returns the current edit part of the given editor.
     *
     * @param editor
     *            an editor
     * @return the current edit part or {@code null} if none exists.
     */
    public static EditPart getEditPart(final IEditorPart editor) {
        EditPart result = null;
        if (editor != null) {
            final ISelection selection =
                    editor.getEditorSite().getSelectionProvider().getSelection();
            Object element = null;
            if (selection != null) {
                if (selection instanceof StructuredSelection) {
                    element = ((StructuredSelection) selection).getFirstElement();
                    if (element instanceof IGraphicalEditPart) {
                        result = (IGraphicalEditPart) element;
                    }
                }
            }
        }
        return result;
    }


    /**
     *
     * @param editor
     *            an {@link IEditorPart}
     * @return a {@link LayoutPropertySource} for the given editor.
     */
    public static LayoutPropertySource getLayoutPropertySource(final IEditorPart editor) {
        return getLayoutPropertySource(editor, getEditPart(editor));
    }

    /**
     * Finds a layout provider for the given {@link IEditorPart} and
     * {@link EditPart}.
     *
     * @param editor
     *            a {@link IEditorPart}
     * @param editPart
     *            an {@link EditPart}
     * @return the id of the layouter, or {@code null} if none can be found.
     */
    public static String getLayoutProviderId(final IEditorPart editor, final EditPart editPart) {
        final DiagramLayoutManager manager =
                EclipseLayoutServices.getInstance().getManager(editor, editPart);
        if (manager == null) {
            return null;
        }
        final String result = getLayoutProviderId(manager, editPart);
        return result;
    }

    /**
     * Synchronously applies the given individual.
     *
     * @param individual
     *            the {@link Genome}
     * @param providerId
     *            the expected layout provider id
     */
    public static void syncApplyIndividual(final Genome individual, final String providerId) {
        MonitoredOperation.runInUI(new IndividualApplierRunnable(individual, providerId), true);
    }

    /**
     * Adopts layout options from the given {@link Genome} into the given
     * {@link IEditorPart}.
     *
     * @param individual
     *            the {@link Genome}; must not be {@code null}
     * @param editor
     *            the {@link IEditorPart}
     */
    private static void adoptIndividual(final Genome individual, final IEditorPart editor) {
        Assert.isLegal(individual != null);

        final LayoutPropertySource propertySource = getLayoutPropertySource(editor);
        Assert.isNotNull(propertySource);
        adoptIndividual(individual, propertySource);
    }

    /**
     * Adopts layout options from the given {@link Genome} into the given
     * {@link LayoutPropertySource}.
     *
     * @param individual
     *            the {@link Genome}; must not be {@code null}
     * @param propertySource
     *            the {@link LayoutPropertySource}; must not be {@code null}
     */
    private static void adoptIndividual(
            final Genome individual, final LayoutPropertySource propertySource) {
        Assert.isLegal((individual != null) && (propertySource != null));
        if ((individual == null) || (propertySource == null)) {
            return;
        }

        System.out.println("adopt " + individual.toString());
        final LayoutServices layoutServices = LayoutServices.getInstance();
        final EvolutionServices evolServices = EvolutionServices.getInstance();
        final Set<String> metricIds = evolServices.getLayoutMetricsIds();

        // Set layout options according to the genome.
        for (final IGene<?> gene : individual) {
            Assert.isNotNull(gene);

            final Object value = gene.getValue();
            final Object id = gene.getId();

            if (metricIds.contains(id)) {
                // it is a metric id --> skip
                continue;
            }

            final LayoutOptionData data = layoutServices.getLayoutOptionData((String) id);
            Assert.isNotNull(data, "No layout option data for " + id);

            final Type layoutOptionType = data.getType();
            switch (layoutOptionType) {

            case BOOLEAN:
                if (value instanceof Boolean) {
                    propertySource.setPropertyValue(id,
                            Integer.valueOf((((Boolean) value).booleanValue() ? 1 : 0)));
                } else {
                    propertySource.setPropertyValue(id,
                            Integer.valueOf(Math.round(((Float) value).floatValue())));
                }
                break;

            case ENUM:
                try {
                    propertySource.setPropertyValue(id, value);
                } catch (final NullPointerException e) {
                    System.out.println("WARNING: enum property could not be set: " + id);
                    Assert.isTrue(false);
                }
                break;

            case INT:
                if (value instanceof Integer) {
                    propertySource.setPropertyValue(id, value);
                } else {
                    propertySource.setPropertyValue(id, gene.toString());
                }
                break;

            default:
                propertySource.setPropertyValue(id, value.toString());
                break;
            }
        }
    }

    /**
     * Adopt, layout and measure the given individual in the appropriate
     * editor(s). The obtained layout is applied to the diagrams.
     *
     * @param individual
     *            a {@link Genome}; may not be {@code null}
     * @param expectedLayoutProviderId
     *            the expected layout provider id
     */
    private static void applyIndividual(
            final Genome individual, final String expectedLayoutProviderId) {
        Assert.isLegal((individual != null) && (expectedLayoutProviderId != null));
        if ((individual == null) || (expectedLayoutProviderId == null)) {
            return;
        }

        final LayoutServices layoutServices = LayoutServices.getInstance();
        Assert.isNotNull(layoutServices);

        // Get the expected layout type id.
        final LayoutProviderData expectedProviderData =
                layoutServices.getLayoutProviderData(expectedLayoutProviderId);
        Assert.isNotNull(expectedProviderData);
        final String expectedLayoutTypeId = expectedProviderData.getType();
        Assert.isNotNull(expectedLayoutTypeId);

        // Get the appropriate editors.
        final Collection<IEditorPart> editors = getWantedEditors();
        Assert.isNotNull(editors);

        // Get the current editor (may be null).
        final IEditorPart currentEditor = getCurrentEditor();

        // Do the layout in each appropriate editor.
        for (final IEditorPart editor : editors) {
            System.out.println();
            System.out.print("--- Editor: " + editor.getTitle() + " ");

            final EditPart editPart = getEditPart(editor);

            // See which layout provider suits for the editor.
            final String layoutProviderId = getLayoutProviderId(editor, editPart);
            System.out.println("(" + layoutProviderId + ")");

            // Check if we can handle its type.
            final LayoutProviderData data =
                    layoutServices.getLayoutProviderData(layoutProviderId);
            final String layoutTypeId = data.getType();

            if (!expectedLayoutTypeId.equalsIgnoreCase(layoutTypeId)) {
                // The editor is not compatible to the current population.
                // --> skip it
                System.err.println("Cannot adopt " + individual.getId() + " to "
                        + layoutProviderId + ", expecting an editor for " + expectedLayoutTypeId);
                continue;
            }

            // Use the options that are encoded in the individual.
            adoptIndividual(individual, editor);

            // We don't specify the edit part because we want a manager for
            // the whole diagram.
            final DiagramLayoutManager manager =
                    EclipseLayoutServices.getInstance().getManager(editor, null);
            Assert.isNotNull(manager);

            final Map<String, Double> weightsMap = extractMetricWeights(individual);
            Assert.isNotNull(weightsMap);

            final KNode layoutGraph = calculateLayout(manager, editor);

            // Update the rating.
            // XXX: This should not be done here.
            if ((editor == currentEditor) && !individual.hasUserRating()) {
                final int rating = measure(layoutGraph, weightsMap);
                individual.setUserRating(rating);
            }

            // Apply the layout to the diagram in the editor.
            // XXX it would be more straightforward to call
            // manager.applyLayout();
            // directly, but that method is protected

            final boolean showAnimation = false;
            final boolean showProgressBar = false;
            EclipseLayoutServices.getInstance().layout(editor, null, showAnimation,
                    showProgressBar);
        }
    }

    /**
     * Layouts the given individual in the given editor and calculates automatic
     * ratings for it. This must be run in the UI thread.
     *
     * @param individual
     *            the {@link Genome} to be rated; must not be {@code null}
     * @param editor
     *            Specifies the editor in which the individual shall be
     *            layouted.
     */
    private static void autoRateIndividual(final Genome individual, final IEditorPart editor) {
        Assert.isLegal(individual != null);

        // We don't specify the edit part because we want a manager for
        // the whole diagram.
        final DiagramLayoutManager manager =
                EclipseLayoutServices.getInstance().getManager(editor, null);
        Assert.isNotNull(manager);

        final LayoutPropertySource source = getLayoutPropertySource(editor);
        Assert.isNotNull(source);

        autoRateIndividual(individual, editor, manager, source);
    }

    /**
     * Layouts the given individual in the given editor and calculates automatic
     * ratings for it, using the given manager and layout property source.
     *
     * @param ind
     * @param editor
     * @param monitor
     * @param manager
     * @param source
     */
    private static void autoRateIndividual(
            final Genome ind, final IEditorPart editor,
            final DiagramLayoutManager manager, final LayoutPropertySource source) {
        Assert.isLegal((ind != null) && (source != null));
        if ((ind == null) || (source == null)) {
            return;
        }

        adoptIndividual(ind, source);

        final Map<String, Double> weightsMap = extractMetricWeights(ind);
        Assert.isNotNull(weightsMap);

        final KNode layoutGraph = calculateLayout(manager, editor);
        final int rating = measure(layoutGraph, weightsMap);

        ind.setUserRating(rating);
    }

    /**
     * Builds the layout graph for the given editor, using the given manager,
     * and performs layout on it. NOTE: The resulting layout is not applied to
     * the diagram.
     *
     * @param manager
     *            a {@link DiagramLayoutManager}
     * @param editor
     *            an {@link IEditorPart}
     * @return the layout graph, or {@code null} in case of an error.
     */
    private static KNode calculateLayout(final DiagramLayoutManager manager, final IEditorPart editor) {
        if ((editor == null) || (manager == null)) {
            // We cannot perform the layout.
            return null;
        }

        // First phase: build the layout graph.
        final KNode layoutGraph = manager.buildLayoutGraph(editor, null, false);

        // Second phase: execute layout algorithms.
        // We need a new monitor each time because the old one
        // gets closed.
        final IKielerProgressMonitor monitor =
                new BasicProgressMonitor(DiagramLayoutManager.MAX_PROGRESS_LEVELS);
        final boolean layoutAncestors = false;
        final boolean cacheLayout = false;
        final IStatus status = manager.layout(monitor, layoutAncestors, cacheLayout);

        if (!status.isOK()) {
            // TODO: what to do about the layouting failure? Log it? Abort?
            System.err.println(status.getMessage());
            return null;
        }

        final KNode layoutGraphAfterLayout = manager.getLayoutGraph();
        Assert.isTrue(layoutGraph == layoutGraphAfterLayout);
        return layoutGraphAfterLayout;
    }

    /**
     * Count the learnable properties of the given list of IPropertyDescriptor
     * objects.
     *
     * @return number of learnable properties
     */
    private static int countLearnableProperties(final Collection<IPropertyDescriptor> descriptors) {
        int result = 0;
        final Set<String> learnables = EvolutionServices.getInstance().getEvolutionDataIds();
        for (final IPropertyDescriptor p : descriptors) {
            final String id = (String) p.getId();
            // check property descriptor id
            if (!LayoutOptions.LAYOUT_HINT.equals(id)) {
                final LayoutOptionData layoutOptionData =
                        LayoutServices.getInstance().getLayoutOptionData(id);
                final Type type = layoutOptionData.getType();
                switch (type) {
                case BOOLEAN:
                case ENUM:
                case INT:
                case FLOAT:
                    if (learnables.contains(id)) {
                        // learnable --> count it
                        result++;
                    }
                    break;
                default:
                    // technically not learnable --> don't count
                    break;
                }
            }
        }
        return result;
    }

    /**
     * Create a {@link Genome} from the given layout property sources.
     * Meta-evolution genes are appended for the given metric ids.
     *
     * @param propertySources
     *            a list of {@link LayoutPropertySource} instances
     * @param metricIds
     *            a set of layout metric ids; may not be {@code null}.
     * @return a genome, or {@code null}.
     */
    private static Genome createGenome(
            final List<LayoutPropertySource> propertySources, final Set<String> metricIds) {
        Assert.isLegal(metricIds != null);
        if ((propertySources == null) || (metricIds == null)) {
            return null;
        }

        /*
         * TODO: Discuss:
         * If more than one LayoutPropertySource is contained in the given list, they may
         * stem from different editors containing different layout providers.
         * Should the genes from different layout providers
         *   - be pooled without hierarchy?
         *   - be mapped to their layout provider id?
         *   - or be grouped together as "chromosomes" in the individual?
         * What about duplicate properties?
         * */

        // Get the set of all learnable elements that are registered.
        final Set<String> learnables = EvolutionServices.getInstance().getEvolutionDataIds();
        final Genome result = new Genome();

        // Get data from property descriptors.
        final Map<String, IPropertyDescriptor> allPropertyDescriptors =
                new HashMap<String, IPropertyDescriptor>();

        for (final LayoutPropertySource source : propertySources) {
            final IPropertyDescriptor[] propertyDescriptorsArray =
                    source.getPropertyDescriptors();

            final List<IPropertyDescriptor> propertyDescriptorsList =
                    Arrays.asList(propertyDescriptorsArray);

            for (final IPropertyDescriptor pd : propertyDescriptorsList) {
                allPropertyDescriptors.put((String) pd.getId(), pd);
            }
        }

        final int learnableCount;
        learnableCount = countLearnableProperties(allPropertyDescriptors.values());

        // Determine uniformly distributed mutation probability.
        final double uniformProb;
        if (learnableCount > 0) {
            uniformProb = 1.0 / learnableCount;
        } else {
            System.err.println("No learnable properties found.");
            uniformProb = 0.0;
        }

        System.out.println("Creating genome of " + learnableCount + " genes ...");
        final GeneFactory gf = new GeneFactory();
        final SortedSet<Integer> layoutHintValues = new TreeSet<Integer>();

        // Iterate the layout property sources.
        for (final LayoutPropertySource propertySource : propertySources) {

            // Iterate the property descriptors of the layout property source.
            for (final IPropertyDescriptor p : propertySource.getPropertyDescriptors()) {

                final String id = (String) p.getId();
                final Object value = propertySource.getPropertyValue(id);
                // Check the property descriptor id.
                if (LayoutOptions.LAYOUT_HINT.equals(id)) {
                    // layout hint --> store it for later

                    if (value != null) {
                        layoutHintValues.add((Integer) value);
                    }

                    final ILabelProvider labelProvider = p.getLabelProvider();
                    String text;
                    if ((value != null) && (labelProvider != null)) {
                        try {
                            text = labelProvider.getText(value);
                        } catch (final ArrayIndexOutOfBoundsException e) {
                            text = "*** EXCEPTION";
                        }
                    } else {
                        text = "???";
                    }
                    System.out.println("--- LAYOUT_HINT: " + value + "=" + text);

                } else if (result.find(id) != null) {
                    // already added this option
                    System.out.println("Duplicate property: " + id);

                } else {
                    // learnable option?
                    if (learnables.contains(id)) {
                        final IGene<?> gene = gf.newGene(id, value, uniformProb);
                        Assert.isNotNull(gene, "Failed to create gene for " + id);
                        result.add(gene);
                    } else {
                        System.out.println("Not registered: " + id);
                    }
                }
            }
        } // propertySource : propertySources

        Assert.isTrue(learnableCount == result.size(),
                "The number of genes is does not have the predicted count of " + learnableCount);

// // Add a gene for the layout hint.
        // if (!layoutHintValues.isEmpty()) {
        // // XXX we are regarding only the layout hint with the lowest value,
        // // which is actually random.
        //
        // final LayoutOptionData data =
        // LayoutServices.getInstance().getLayoutOptionData(LayoutOptions.LAYOUT_HINT);
        // final IGene<?> gene =
        // gf.newEnumGene(LayoutOptions.LAYOUT_HINT, layoutHintValues.first(),
        // 0.01,
        // data);
        //
        // Assert.isNotNull(gene, "Failed to create layout hint gene.");
        // result.add(gene);
        // }

        // Add meta-evolution genes for the layout metrics.
        System.out.println("Adding metric weights ...");
        final TypeInfo<Float> typeInfo =
                new FloatTypeInfo(Float.valueOf(1.0f), Float.valueOf(0.0f), Float.valueOf(10.0f),
                        UniversalGene.STRICTLY_POSITIVE_FLOAT_FORMATTER, Float.class);
        final MutationInfo mutationInfo = new MutationInfo(0.001, .05, Distribution.GAUSSIAN);

        for (final String id : metricIds) {
            final IGene<?> gene = gf.newGene(id, Float.valueOf(1.0f), typeInfo, mutationInfo);
            Assert.isNotNull(gene, "Failed to create gene for " + id);
            result.add(gene);
        }

        System.out.println("Created genome: " + result.size() + " genes.");
        System.out.println();

        return result;
    }

    /**
     * Creates a population of the default size, taking initial values from the
     * given {@link LayoutPropertySource}.
     *
     * @param propertySource
     *            where the initial data is taken from; may not be {@code null}
     * @return the new population
     */
    private static Population createPopulation(final LayoutPropertySource propertySource) {
        Assert.isLegal(propertySource != null);
        final int size =
                EvolPlugin.getDefault().getPreferenceStore()
                        .getInt(EvolPlugin.PREF_POPULATION_SIZE);
        return createPopulation(propertySource, size);
    }

    /**
     * Create a population of default size, taking initial values from the given
     * list of {@link LayoutPropertySource} instances.
     *
     * @param propertySources
     * @return
     */
    private static Population createPopulation(
            final List<LayoutPropertySource> propertySources) {
       Assert.isLegal(propertySources != null);
       final int size =
           EvolPlugin.getDefault().getPreferenceStore()
                   .getInt(EvolPlugin.PREF_POPULATION_SIZE);
        return createPopulation(propertySources, size);
    }

    /**
     * Create a population of the given size, taking initial values from the
     * given list of {@link LayoutPropertySource} instances.
     *
     * @param propertySources
     * @param size
     * @return
     */
    private static Population createPopulation(
            final List<LayoutPropertySource> propertySources, final int size) {
        Assert.isLegal(propertySources != null);
        Assert.isLegal(size >= 0);

        final Population result = new Population();
        final Set<String> metricIds = EvolutionServices.getInstance().getLayoutMetricsIds();

        for (int i = 0; i < size; i++) {
            final Genome genome = createGenome(propertySources, metricIds);
            result.add(genome);
        }
        return result;
    }

    /**
     * Create a population of the given size, taking initial values from the
     * given {@link LayoutPropertySource}.
     *
     * @param propertySource
     *            where the initial data is taken from; may not be {@code null}
     * @param size
     *            a non-negative value that specifies the initial size of the
     *            population.
     * @return population
     */
    private static Population createPopulation(
            final LayoutPropertySource propertySource, final int size) {
        Assert.isLegal(propertySource != null);
        Assert.isLegal(size >= 0);

        final List<LayoutPropertySource> sources = new ArrayList<LayoutPropertySource>(1);
        sources.add(propertySource);

        return createPopulation(sources, size);
    }

    /**
     * Extracts the metric weight from the given genome.
     *
     * @param genome
     *            a {@link Genome}
     * @return a map associating metric weights to metric ids.
     */
    private static Map<String, Double> extractMetricWeights(final Genome genome) {
        // TODO: Discuss whether this method should be moved into Genome.
        final EvolutionServices evolService = EvolutionServices.getInstance();
        Assert.isNotNull(evolService);

        final Set<String> metricIds = evolService.getLayoutMetricsIds();
        Assert.isNotNull(metricIds);

        final Map<String, Double> result = new HashMap<String, Double>(metricIds.size());

        for (final IGene<?> gene : genome) {
            Assert.isNotNull(gene);
            final String id = (String) gene.getId();

            if (!metricIds.contains(id)) {
                // not a metric id --> skip
                continue;
            }

            final Float value = (Float) gene.getValue();
            result.put(id, Double.valueOf(value.doubleValue()));
        }

        return result;
    }

    /**
     *
     * @param editor
     *            an {@link IEditorPart}
     * @param editPart
     *            an {@link EditPart}
     * @return a {@link LayoutPropertySource} for the given editor and edit
     *         part, or {@code null} if none can be found.
     */
    private static LayoutPropertySource getLayoutPropertySource(
            final IEditorPart editor, final EditPart editPart) {

        // use root edit part
        EditPart rootPart = editPart;

        if (rootPart != null) {
            while (rootPart.getParent() != null) {
                rootPart = rootPart.getParent();
            }
        }

        final DiagramLayoutManager manager =
                EclipseLayoutServices.getInstance().getManager(editor, rootPart);
        if (manager == null) {
            return null;
        }

        final ILayoutInspector inspector = manager.getInspector(rootPart);
        final LayoutPropertySource result = new LayoutPropertySource(inspector);
        return result;
    }

    /**
     * Finds a layout provider for the given manager and the given edit part.
     *
     * @param manager
     *            a {@link DiagramLayoutManager}; must not be {@code null}
     * @param editPart
     *            an {@link EditPart}
     * @return the id of the layouter, or {@code null} if none can be found.
     */
    private static String getLayoutProviderId(
            final DiagramLayoutManager manager, final EditPart editPart) {
        Assert.isLegal(manager != null);
        if (manager == null) {
            return null;
        }
        final ILayoutInspector inspector = manager.getInspector(editPart);
        if (inspector == null) {
            return null;
        }
        inspector.initOptions();
        final LayoutProviderData data = inspector.getContainerLayouterData();
        if (data == null) {
            return null;
        }
        return data.getId();
    }

    /**
     *
     * @return a collection of editors, may be empty.
     */
    private static Collection<IEditorPart> getWantedEditors() {
        // Get the current editor (may be null).
        final IEditorPart currentEditor = getCurrentEditor();

        final String prefEditors =
                EvolPlugin.getDefault().getPreferenceStore().getString(EvolPlugin.PREF_EDITORS);

        final boolean wantAllEditors = EvolPlugin.ALL_EDITORS.equalsIgnoreCase(prefEditors);

        // Collect the editor(s).
        final Collection<IEditorPart> editors;
        if (wantAllEditors) {
            editors = getEditors();
        } else {
            editors = new ArrayList<IEditorPart>(1);
            if (currentEditor != null) {
                editors.add(currentEditor);
            }
        }
        return editors;
    }

    /**
     * Measures the given layout graph, according to the given metric weights.
     * The given map is modified so that its values are normalized to yield a
     * sum of one.
     *
     * @param parentNode
     *            the KGraph to be analyzed.
     * @param weightsMap
     *            a map that associates weights to metric ids; must not be
     *            {@code null}
     * @return a rating proposal
     */
    private static int measure(final KNode parentNode, final Map<String, Double> weightsMap) {
        Assert.isLegal(weightsMap != null);

        if ((parentNode == null) || (weightsMap == null)) {
            return 0;
        }

        // Get the metric ids.
        final Set<String> metricIds = EvolutionServices.getInstance().getLayoutMetricsIds();

        // We have the metric ids, now get the metrics.
        final AnalysisServices as = AnalysisServices.getInstance();
        final List<AbstractInfoAnalysis> metricsList =
                new ArrayList<AbstractInfoAnalysis>(metricIds.size());
        for (final String metricId : metricIds) {
            final AbstractInfoAnalysis metric = as.getAnalysisById(metricId);
            Assert.isNotNull(metric, "Could not find analysis: " + metricId);
            metricsList.add(metric);
        }

        // Make sure the metric weights are normalized.
        // XXX discard this and require weightsMap to be normalized before
        normalize(weightsMap);

        // Perform the measurement.
        final boolean showProgressBar = false;
        final Map<String, Object> results =
                DiagramAnalyser.analyse(parentNode, metricsList, showProgressBar);

        // final double[] scaledResults = new double[metrics.length];
        double sum = 0.0;
        double scaledSum = 0;
        for (final AbstractInfoAnalysis metric : metricsList) {
            final String metricResult = results.get(metric.getID()).toString();
            final double coeff = weightsMap.get(metric.getID()).doubleValue();

            double val;
            try {
                final double parsedVal = Double.parseDouble(metricResult);
                val = parsedVal;

            } catch (final NumberFormatException exception) {
                val = 0.0;
            }

            final double scaled = val * coeff;
            // scaledResults[i] = scaled;
            scaledSum += scaled;
            sum += val;
            // System.out.println(metric.getID() + ": " + val + " ");
        }
        // System.out.println();
        // System.out.println("Difference from uniform scaling: "
        // + Math.abs(scaledSum - (sum / metricsList.size())));
        final int newRating = (int) Math.round((scaledSum * 10000));
        return newRating;
    }

    /**
     * Scales the values in the given map so that their sum equals one. This
     * operation modifies the map entries of the given map.
     *
     * @param map
     *            a map containing {@link Double} values; must not be
     *            {@code null}
     */
    private static void normalize(final Map<String, Double> map) {
        Assert.isLegal(map != null);

        if (map == null) {
            return;
        }

        // Calculate sum.
        double sum = 0.0;
        for (final Double value : map.values()) {
            sum += value.doubleValue();
        }

        if (sum != 1.0) {
            // Need to scale values.
            final double factor = 1.0 / sum;

            for (final Entry<String, Double> entry : map.entrySet()) {
                final double value = entry.getValue().doubleValue();
                entry.setValue(Double.valueOf(value * factor));
            }
        }
    }

    /**
     * @param individual
     * @param editor
     */
    private static void syncAutoRate(final Genome individual, final IEditorPart editor) {
        // the editor may be null
        MonitoredOperation.runInUI(new AutoRateIndividualRunnable(individual, editor), true);
    }

    /** Hidden constructor to avoid instantiation. **/
    private EvolUtil() {
        // nothing
    }

}

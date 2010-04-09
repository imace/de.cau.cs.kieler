/*
 * KIELER - Kiel Integrated Environment for Layout Eclipse RichClient
 *
 * http://www.informatik.uni-kiel.de/rtsys/kieler/
 * 
 * Copyright 2008 by
 * + Christian-Albrechts-University of Kiel
 *   + Department of Computer Science
 *     + Real-Time and Embedded Systems Group
 * 
 * This code is provided under the terms of the Eclipse Public License (EPL).
 * See the file epl-v10.html for the license text.
 */
package de.cau.cs.kieler.kivik.internal;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.compare.CompareConfiguration;
import org.eclipse.compare.structuremergeviewer.ICompareInput;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.compare.EMFComparePlugin;

//import org.eclipse.emf.compare.diff.metamodel.ComparisonResourceSetSnapshot;
import org.eclipse.emf.compare.ui.ModelCompareInput;

import org.eclipse.emf.compare.diff.metamodel.ComparisonResourceSetSnapshot;
import org.eclipse.emf.compare.diff.metamodel.ComparisonSnapshot;
import org.eclipse.emf.compare.diff.metamodel.DiffFactory;
import org.eclipse.emf.compare.diff.metamodel.DiffModel;
import org.eclipse.emf.compare.diff.metamodel.ComparisonResourceSnapshot;
import org.eclipse.emf.compare.diff.service.DiffService; //import org.eclipse.emf.compare.match.api.MatchOptions; OPTION_PROGRESS_MONITOR == "match.progress.monitor"
import org.eclipse.emf.compare.match.metamodel.MatchFactory;
import org.eclipse.emf.compare.match.metamodel.MatchModel;
import org.eclipse.emf.compare.match.service.MatchService;
import org.eclipse.emf.compare.match.statistic.MetamodelFilter;
import org.eclipse.emf.compare.ui.EMFCompareUIMessages;
import org.eclipse.emf.compare.ui.internal.ModelComparator;
import org.eclipse.emf.compare.ui.util.EMFCompareConstants;
import org.eclipse.emf.compare.util.EMFCompareMap;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.ui.PlatformUI;

//http://www.eclipse.org/modeling/emf/searchcvs.php?q=ModelComparator&project=0
//2010-01-21 11:09:25
//[297305] MANIFEST.MF (HEAD 1.27 > 1.26)
//      lgoubet
//      [297305] upgrades ModelComparator from restricted access to discouraged access. Referencing is still made at the client's own risks

/**
 * 
 * @author ars
 */
public final class KivikComparator {

    private static final Map<CompareConfiguration, KivikComparator> INSTANCES = new HashMap<CompareConfiguration, KivikComparator>();
    private CompareConfiguration fCompareConfiguration;
    private ComparisonResourceSnapshot fKivikComparisonResult;

    /**
     * Model comparators will only be instantiated via {@link #getComparator(CompareConfiguration)}.
     */
    private KivikComparator(CompareConfiguration compareConfiguration) {
        fCompareConfiguration = compareConfiguration;
    }

    /**
     * This will return the KivikComparator associated to the given CompareConfiguration.
     * 
     * @param configuration
     *            CompareConfiguration of this comparator.
     * @return The comparator for this configuration.
     */
    public static KivikComparator getKivikComparator(CompareConfiguration configuration) {
        if (!INSTANCES.containsKey(configuration))
            INSTANCES.put(configuration, new KivikComparator(configuration));
        return INSTANCES.get(configuration);
    }

    /**
     * Removes the comparator corresponding to a no longer used configuration.
     * 
     * @param configuration
     *            CompareConfiguration which comparator should be removed.
     */
    public static void removeKivikComparator(CompareConfiguration configuration) {
        ModelComparator.removeComparator(configuration);
        INSTANCES.remove(configuration);
    }

    public ModelComparator getComparator() {
        ModelComparator mc = ModelComparator.getComparator(fCompareConfiguration, null);
        return mc;
    }

    private EObject getAncestorDomainEObject() {
        if (getComparator().getAncestorResource() != null) {
            ResourceSet rset = getComparator().getAncestorResource().getResourceSet();
            return getDomainEObject(rset);
        } else
            return null;
    }

    private EObject getLeftDomainEObject() {
        ResourceSet rset = getComparator().getLeftResource().getResourceSet();
        return getDomainEObject(rset);
    }

    private EObject getRightDomainEObject() {
        ResourceSet rset = getComparator().getRightResource().getResourceSet();
        return getDomainEObject(rset);
    }

    private EObject getDomainEObject(ResourceSet rset) {
        EList<Resource> resources = rset.getResources();
        if (resources.size() == 2) {
            Resource modelResource = resources.get(1);
            try {
                modelResource.load(null);
                return modelResource.getContents().get(0);
            } catch (IOException e) {
                System.out
                        .println("Not able to obtain history domain model for selected notation model.");
                System.out.println(e.toString());
                return null;
            }

        } else {
            Resource diagramAndModelResource = resources.get(0);
            return diagramAndModelResource.getContents().get(0);
        }
    }

    public ComparisonResourceSetSnapshot getNotationComparisonResult() {
        ComparisonResourceSetSnapshot crs = getComparator().getComparisonResult();
        return crs;// (new ComparisonResourceSnapshot(crs.getMatchResourceSet(),crs.getDiffResourceSet()));
    }

    public ComparisonResourceSnapshot getDomainComparisonResult() {
        if (fKivikComparisonResult == null) // || fKivikComparisonResult.getDate() == null)
            return null;
        else
            return fKivikComparisonResult;
    }

    public ComparisonResourceSetSnapshot compareNotationModel() {
        ComparisonResourceSetSnapshot crs = getComparator().compare(fCompareConfiguration);
        return crs; //(new ModelCompareInput(crs.getMatchResourceSet(),crs.getDiffResourceSet()));
    }

    /**
     * This will run the comparison process and return the resulting {@link ModelInputSnapshot
     * snapshot}.
     * 
     * @param configuration
     *            Compared configuration of this comparison. Properties will be set on this to hold
     *            comparison data.
     * @return Result of the comparison of the loaded resources.
     */
    public ComparisonResourceSnapshot compareDomainModel() {

        final EObject ancestor = getAncestorDomainEObject();
        final EObject left = getLeftDomainEObject();
        final EObject right = getRightDomainEObject();

        if (left != null && right != null) {
            if (fKivikComparisonResult == null) { // || fKivikComparisonResult.getDate() == null) {

                fKivikComparisonResult = DiffFactory.eINSTANCE.createComparisonResourceSnapshot();
                final Date start = Calendar.getInstance().getTime();

                try {
                    PlatformUI.getWorkbench().getProgressService().busyCursorWhile(
                            new IRunnableWithProgress() {
                                public void run(IProgressMonitor monitor)
                                        throws InterruptedException {
                                    final Map<String, Object> options = new EMFCompareMap<String, Object>();
                                    options.put("match.progress.monitor", monitor);

                                    final MatchModel match;

                                    if (ancestor == null)
                                        match = MatchService.doContentMatch(left, right, options);
                                    else
                                        match = MatchService.doContentMatch(left, right, ancestor,
                                                options);
                                    final DiffModel diff = DiffService.doDiff(match,
                                            getAncestorDomainEObject() != null);

                                    //fKivikComparisonResult = new ModelCompareInput(match,diff);
                                    Date date = Calendar.getInstance().getTime();
                                    fKivikComparisonResult.setDate(date);
                                    fKivikComparisonResult.setDiff(diff);
                                    fKivikComparisonResult.setMatch(match);
                                }
                            });
                } catch (InterruptedException e) {
//                    fKivikComparisonResult = new ModelCompareInput(MatchFactory.eINSTANCE.createMatchModel(),
//                                                                   DiffFactory.eINSTANCE.createDiffModel());
                    fKivikComparisonResult.setDate(Calendar.getInstance().getTime());
                    fKivikComparisonResult.setDiff(DiffFactory.eINSTANCE.createDiffModel());
                    fKivikComparisonResult.setMatch(MatchFactory.eINSTANCE.createMatchModel());
                } catch (InvocationTargetException e) {
                    EMFComparePlugin.log(e, true);
                }

                final Date end = Calendar.getInstance().getTime();
                fCompareConfiguration.setProperty(EMFCompareConstants.PROPERTY_COMPARISON_TIME, end
                        .getTime()
                        - start.getTime());
                fCompareConfiguration.setLeftEditable(!getComparator().isLeftRemote());
                fCompareConfiguration.setRightEditable(!getComparator().isRightRemote());
                if (getComparator().isLeftRemote()) {
                    fCompareConfiguration.setLeftLabel(EMFCompareUIMessages
                            .getString("comparison.label.remoteResource")); //$NON-NLS-1$
                    fCompareConfiguration.setRightLabel(EMFCompareUIMessages
                            .getString("comparison.label.localResource")); //$NON-NLS-1$
                }

            }
            return fKivikComparisonResult;

        } else {
            /* emergency result if one resource was null */
            ComparisonResourceSnapshot result = DiffFactory.eINSTANCE
                    .createComparisonResourceSnapshot();
            result.setDate(Calendar.getInstance().getTime());
            result.setDiff(DiffFactory.eINSTANCE.createDiffModel());
            result.setMatch(MatchFactory.eINSTANCE.createMatchModel());
            return result;
        }
    }

    public void loadResources(ICompareInput input) {

        /* load the.ssm_diagram Resources */
        getComparator().loadResources(input);

        /*
         * maybe use this later to pass a new input, now.ssm instead of .ssm_diagram to another EMF
         * ModelComparator.
         */
        // ResourceNode left = (ResourceNode) input.getLeft();
        // ResourceNode right = (ResourceNode) input.getRight();
        // ResourceNode ancestor = (ResourceNode) input.getAncestor();
        /*
         * And here's the trick. Emma has just the.ssm_diagram resources, as she clicked on these
         * files and these were loaded by the original EMF ModelComparator. Passing the contents of
         * the resources to the MetamodelFilter results in loading also the two domain resources
         * into the ResourceSet, and Emma can use them.
         */
        MetamodelFilter metamodelFilter = new MetamodelFilter();
        for (EObject root : getComparator().getLeftResource().getContents())
            metamodelFilter.analyseModel(root);
        for (EObject root : getComparator().getRightResource().getContents())
            metamodelFilter.analyseModel(root);
    }

}

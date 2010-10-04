/*
 * KIELER - Kiel Integrated Environment for Layout Eclipse RichClient
 *
 * http://www.informatik.uni-kiel.de/rtsys/kieler/
 * 
 * Copyright 2010 by
 * + Christian-Albrechts-University of Kiel
 *   + Department of Computer Science
 *     + Real-Time and Embedded Systems Group
 * 
 * This code is provided under the terms of the Eclipse Public License (EPL).
 * See the file epl-v10.html for the license text.
 */
package de.cau.cs.kieler.synccharts.kivi;

import java.util.Collection;
import java.util.List;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;

import de.cau.cs.kieler.core.kivi.CombinationParameter;
import de.cau.cs.kieler.core.kivi.AbstractCombination;
import de.cau.cs.kieler.core.model.effects.CompartmentCollapseExpandEffect;
import de.cau.cs.kieler.core.model.effects.HighlightEffect;
import de.cau.cs.kieler.core.model.util.ModelingUtil;
import de.cau.cs.kieler.sim.kivi.StateActivityTrigger.ActiveStates;
import de.cau.cs.kieler.synccharts.State;
import de.cau.cs.kieler.synccharts.SyncchartsPackage;
import de.cau.cs.kieler.synccharts.diagram.part.SyncchartsDiagramEditor;

/**
 * A combination that visualizes the simulation of a SyncChart.
 * 
 * @author mmu
 * 
 */
public class SyncChartsCombination extends AbstractCombination {

    /**
     * The preference key for the highlight color.
     */
    public static final String HIGHLIGHT_COLOR = SyncChartsCombination.class.getCanonicalName()
            + ".highlightColor";

    /**
     * The preference key for the history color.
     */
    public static final String HISTORY_COLOR = SyncChartsCombination.class.getCanonicalName()
            + ".historyColor";

    /**
     * The preference key for the black & white mode.
     */
    public static final String BW_MODE = SyncChartsCombination.class.getCanonicalName() + ".bwMode";

    /**
     * The preference key for the focus & context mode.
     */
    public static final String FC_MODE = SyncChartsCombination.class.getCanonicalName() + ".fcMode";

    private static final CombinationParameter[] PARAMETERS = new CombinationParameter[] {
            new CombinationParameter(HIGHLIGHT_COLOR, getPreferenceStore(), "Highlight Color",
                    "The color to use for highlighting active states", ColorConstants.red.getRGB(),
                    CombinationParameter.RGB_TYPE),
            new CombinationParameter(HISTORY_COLOR, getPreferenceStore(), "History Color",
                    "The color to use for highlighting previously active states",
                    ColorConstants.blue.getRGB(), CombinationParameter.RGB_TYPE),
            new CombinationParameter(BW_MODE, getPreferenceStore(), "Black && White",
                    "Dashed lines for active states, dotted lines for history states.", false,
                    CombinationParameter.BOOLEAN_TYPE),
            new CombinationParameter(FC_MODE, getPreferenceStore(), "Focus && Context",
                    "Collapse inactive states, expand active/history states.", true,
                    CombinationParameter.BOOLEAN_TYPE) };

    /**
     * Execute this combination using the active states state.
     * 
     * @param activeStates
     *            the active states
     */
    public void execute(final ActiveStates activeStates) {
        if (!(activeStates.getDiagramEditor() instanceof SyncchartsDiagramEditor)) {
            doNothing();
            return;
        }
        // if there are no active states, the simulation has finished.
        if (activeStates.getActiveStates().isEmpty()) {
            return;
        }

        if (isFC()) {
            // initially collapse all states
            init(activeStates.getDiagramEditor());
        }

        // these were most recently active i steps ago
        for (int i = 0; i < activeStates.getActiveStates().size(); i++) {
            List<EObject> currentStep = activeStates.getActiveStates().get(i);
            for (EObject e : currentStep) {
                if (isBW()) {
                    schedule(new HighlightEffect(e, activeStates.getDiagramEditor(),
                            (i == 0 ? SWT.LINE_DASH : SWT.LINE_DOT)));
                } else {
                    schedule(new HighlightEffect(e, activeStates.getDiagramEditor(), getColor(i,
                            activeStates.getActiveStates().size())));
                }
                if (isFC()) {
                    schedule(new CompartmentCollapseExpandEffect(activeStates.getDiagramEditor(),
                            e, SyncchartsPackage.eINSTANCE.getState_Regions(), 0, false));
                }
            }
        }
    }

    /**
     * Create collapse effects for all macro states (not for simple ones).
     * 
     * @throws KielerModelException
     */
    private void init(final DiagramEditor editor) {
        Collection<EObject> states = ModelingUtil.getAllByType(
                SyncchartsPackage.eINSTANCE.getState(), editor.getDiagramEditPart());
        for (EObject state : states) {
            // remove the root State because it represents the whole SM and will not be active
            if (state.eContainer() == null || state.eContainer().eContainer() == null) {
                continue;
                // remove simple states
            } else if (state instanceof State && ((State) state).getRegions().size() == 0) {
                continue;
            } else {
                schedule(new CompartmentCollapseExpandEffect(editor, state,
                        SyncchartsPackage.eINSTANCE.getState_Regions(), 1, true));
            }
        }
    }

    /**
     * Get the parameters of this combination.
     * 
     * @return the parameters
     */
    public static CombinationParameter[] getParameters() {
        return PARAMETERS;
    }

    /**
     * Get the preference store used by this combination.
     * 
     * @return the preference store
     */
    public static IPreferenceStore getPreferenceStore() {
        return Activator.getDefault().getPreferenceStore();
    }

    private Color getColor(final int step, final int steps) {
        if (step == 0) {
            return new Color(null, PreferenceConverter.getColor(getPreferenceStore(),
                    HIGHLIGHT_COLOR));
        } else {
            float[] hsb = PreferenceConverter.getColor(getPreferenceStore(), HISTORY_COLOR)
                    .getHSB();
            return new Color(null, new RGB(hsb[0], hsb[1], hsb[2] - hsb[2] / steps * (step - 1)));
        }
    }

    private boolean isBW() {
        return getPreferenceStore().getBoolean(BW_MODE);
    }

    private boolean isFC() {
        return getPreferenceStore().getBoolean(FC_MODE);
    }
}

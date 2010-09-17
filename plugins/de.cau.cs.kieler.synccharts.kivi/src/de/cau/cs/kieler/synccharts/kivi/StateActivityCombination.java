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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;

import de.cau.cs.kieler.core.kivi.IEffect;
import de.cau.cs.kieler.core.kivi.AbstractCombination;
import de.cau.cs.kieler.synccharts.kivi.StateActivityTrigger.ActiveStates;

/**
 * A combination that visualizes the simulation of a SyncChart.
 * 
 * @author mmu
 * 
 */
public class StateActivityCombination extends AbstractCombination {

    // private static final CombinationParameter[] PARAMETERS = new CombinationParameter[] {
    // new CombinationParameter("highlightColor", "float", "0.0"),
    // new CombinationParameter("historyColor", "float", "240.0") };

    private Map<EObject, StateActivityHighlightEffect> effects = new HashMap<EObject, StateActivityHighlightEffect>();

    /**
     * Execute this combination using the active states state.
     * 
     * @param activeStates
     *            the active states
     */
    public void execute(final ActiveStates activeStates) {
        // assume every effect needs to be undone
        Map<EObject, IEffect> toUndo = new HashMap<EObject, IEffect>(effects);

        // these were last active i steps ago
        for (int i = 0; i < activeStates.getActiveStates().size(); i++) {
            List<EObject> currentStep = activeStates.getActiveStates().get(i);
            for (EObject e : currentStep) {
                // check if an effect exists for this edit part
                StateActivityHighlightEffect effect = effects.get(e);
                if (effect == null) {
                    // if not then create new one
                    effect = new StateActivityHighlightEffect(e, activeStates.getDiagramEditor());
                    effects.put(e, effect);
                } else {
                    // if it does then don't undo it later
                    toUndo.remove(e);
                }
                // update its color instead of undo and create a new effect to avoid flashing
                effect.setColor(getColor(i, activeStates.getActiveStates().size()));
                effect.schedule();
            }
        }

        // undo any effect that was not found in the active states
        for (Map.Entry<EObject, IEffect> entry : toUndo.entrySet()) {
            entry.getValue().scheduleUndo();
            effects.remove(entry.getKey());
        }
    }

    /**
     * {@inheritDoc}
     */
    public void undo() {
        for (IEffect effect : effects.values()) {
            effect.scheduleUndo();
        }
        effects.clear();
    }

    /**
     * Get the parameters of this combination.
     * 
     * @return the parameters
     */
    // public static CombinationParameter[] getParameters() {
    // return PARAMETERS;
    // }

    private Color getColor(final int step, final int steps) {
        if (step == 0) {
            return new Color(null, new RGB(0.0f, 1.0f, 1.0f));
        } else {
            // a shade of blue
            return new Color(null, new RGB(240.0f, 1.0f, 1.0f - 1.0f / steps * (step - 1)));
        }
    }
}

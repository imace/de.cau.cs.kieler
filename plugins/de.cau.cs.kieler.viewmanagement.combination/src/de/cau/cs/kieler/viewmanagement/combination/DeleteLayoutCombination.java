/*
 * KIELER - Kiel Integrated Environment for Layout Eclipse RichClient
 *
 * http://www.informatik.uni-kiel.de/rtsys/kieler/
 * 
 * Copyright 2009 by
 * + Christian-Albrechts-University of Kiel
 *   + Department of Computer Science
 *     + Real-Time and Embedded Systems Group
 * 
 * This code is provided under the terms of the Eclipse Public License (EPL).
 * See the file epl-v10.html for the license text.
 * 
 *****************************************************************************/
package de.cau.cs.kieler.viewmanagement.combination;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.EditPart;
import org.eclipse.ui.IEditorPart;

import de.cau.cs.kieler.viewmanagement.ACombination;
import de.cau.cs.kieler.viewmanagement.ATrigger;
import de.cau.cs.kieler.viewmanagement.RunLogic;
import de.cau.cs.kieler.viewmanagement.TriggerEventObject;
import de.cau.cs.kieler.viewmanagement.effects.LayoutEffect;
import de.cau.cs.kieler.viewmanagement.triggers.ElementDeletedTrigger;

/**
 * The combination that is used to perform auto layout
 * 
 * @author Michael Matzen
 * 
 */
public class DeleteLayoutCombination extends ACombination {

    ElementDeletedTrigger trigger; // the auto layout trigger
    LayoutEffect effect; // the auto layout effect
    EditPart targetEditPart; // the shape edit part that is used as a target for
                             // the layout action
    IEditorPart activeEditorPart; // the active editor part

    /**
     * Evaluates a trigger event
     */
    @Override
    public boolean evaluate(final TriggerEventObject triggerEvent) {
        EditPart affectedObject = getEditPart(triggerEvent.getAffectedObject());

        this.targetEditPart = affectedObject;
        // Add editorPart if supplied
        if (triggerEvent.getParameters() instanceof IEditorPart) {
            this.activeEditorPart = (IEditorPart) triggerEvent.getParameters();
        }

        return true;
    }

    /**
     * Executes the combination by starting the effect
     */
    @Override
    public void execute() {
        if (effect == null) {
            effect = new LayoutEffect();
        }
        effect.setTarget(targetEditPart);
        effect.setParameters(activeEditorPart);
        effect.execute();

    }

    /**
     * Returns the list of triggers
     */
    @Override
    public List<ATrigger> getTriggers() {
        this.trigger = (ElementDeletedTrigger) RunLogic.getInstance()
                .getTrigger("ElementDeletedTrigger");
        List<ATrigger> triggerList = new ArrayList<ATrigger>();
        triggerList.add(trigger);
        return triggerList;
    }

    /**
     * Undo the last effect, this is unused because the 'undo' is done by the
     * layout command framework
     */
    @Override
    public void undoEffects() {
        // nothing we can undo here
    }

}

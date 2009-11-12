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
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeEditPart;
import de.cau.cs.kieler.viewmanagement.ACombination;
import de.cau.cs.kieler.viewmanagement.ATrigger;
import de.cau.cs.kieler.viewmanagement.RunLogic;
import de.cau.cs.kieler.viewmanagement.TriggerEventObject;
import de.cau.cs.kieler.viewmanagement.effects.FilterEffect;
import de.cau.cs.kieler.viewmanagement.triggers.SelectionTrigger;

/**
 * @author nbe
 * 
 *         Combination that filters the affected object. Listens to SelectionTrigger, the affected
 *         object will be the one that gets selected in the editor.
 */

public class SelectionFilterCombination extends ACombination {

    private FilterEffect effect;
    private SelectionTrigger st;
    private ShapeEditPart affectedObject;
    private Object objectParameters;

    public final List<ATrigger> getTriggers() {
        this.st = (SelectionTrigger) RunLogic.getInstance().getTrigger("SelectionTrigger");
        List<ATrigger> myTriggers = new ArrayList<ATrigger>();
        myTriggers.add(st);
        return myTriggers;
    }

    /*
     * (non-Javadoc)
     * 
     * @see de.cau.cs.kieler.viewmanagement.ACombination#evaluate()
     */

    public final boolean evaluate(final TriggerEventObject triggerEvent) {
        if (triggerEvent.getTriggerState() == true) {
            EditPart affectedObject = getEditPart(triggerEvent.getAffectedObject());
            if (affectedObject instanceof ShapeEditPart) {
                this.affectedObject = (ShapeEditPart) affectedObject;
                this.objectParameters = triggerEvent.getParameters();

            } else {
                return false;
            }
            return true;
        }
        return false;
        
    }

    /*
     * (non-Javadoc)
     * 
     * @see de.cau.cs.kieler.viewmanagement.ACombination#execute()
     */

    public final void execute() {
       
        if (effect == null) {
            effect = new FilterEffect();
        }

        effect.setTarget(this.affectedObject);
        effect.setParameters(this.objectParameters);
        effect.execute();

    }

    public final void undoEffects() {
        if (effect != null) {

            effect.undo();
        }
    }

}

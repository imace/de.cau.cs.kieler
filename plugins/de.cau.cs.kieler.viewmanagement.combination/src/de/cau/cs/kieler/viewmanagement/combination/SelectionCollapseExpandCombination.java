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
import de.cau.cs.kieler.viewmanagement.effects.CompartmentCollapseEffect;
import de.cau.cs.kieler.viewmanagement.effects.CompartmentCollapseExpandEffect;
import de.cau.cs.kieler.viewmanagement.triggers.SelectionTrigger;

/**
 * @author nbe
 * 
 *         Combination that collapses the affected object and all its children (if collapsible).
 *         Listens to SelectionTrigger, the affected object will be the one that gets selected in
 *         the editor.
 */
public class SelectionCollapseExpandCombination extends ACombination {

    private CompartmentCollapseExpandEffect effect;
    private SelectionTrigger st;

    private ShapeEditPart objectToCollapse;

    @Override
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
        EditPart affectedObject = getEditPart(triggerEvent.getAffectedObject());
        if (affectedObject instanceof ShapeEditPart) {
            this.objectToCollapse = (ShapeEditPart) affectedObject;

            return true;

        } else {
            return false;
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see de.cau.cs.kieler.viewmanagement.ACombination#execute()
     */

    public final void execute() {
        if (effect == null) {
            effect = new CompartmentCollapseExpandEffect(1);
        }
        effect.setTarget(this.objectToCollapse);
        effect.execute();
    }

}

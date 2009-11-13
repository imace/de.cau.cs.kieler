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
import de.cau.cs.kieler.viewmanagement.effects.CompartmentExpandEffect;
import de.cau.cs.kieler.viewmanagement.triggers.SelectionTrigger;
import de.cau.cs.kieler.viewmanagement.*;

/**
 * @author nbe
 * 
 *         Combination that expands the affected object and all its children (if expanable). Listens
 *         to SelectionTrigger, the affected object will be the one that gets selected in the
 *         editor.
 */
public class SelectionExpandCombination extends ACombination {

    private CompartmentExpandEffect effect;
    private SelectionTrigger st;

    private ShapeEditPart objectToHighlight;

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
    @Override
    public final boolean evaluate(final TriggerEventObject triggerEvent) {
        EditPart affectedObject = getEditPart(triggerEvent.getAffectedObject());
        if (affectedObject instanceof ShapeEditPart) {
            this.objectToHighlight = (ShapeEditPart) affectedObject;
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
    @Override
    public final void execute() {
        if (effect == null) {
            effect = new CompartmentExpandEffect();
        }
        effect.setTarget(this.objectToHighlight);
        effect.execute();
    }

}

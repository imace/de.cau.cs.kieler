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
 */

public class SelectionFilterCombination extends ACombination {

    FilterEffect effect;
    SelectionTrigger st;
    ShapeEditPart affectedObject;
    Object objectParameters;


    @Override
    public List<ATrigger> getTriggers() {
        this.st = (SelectionTrigger) RunLogic.getTrigger("SelectionTrigger");
        List<ATrigger> myTriggers = new ArrayList<ATrigger>();
        myTriggers.add(st);
        return myTriggers;
    }

    /*
     * (non-Javadoc)
     * 
     * @see de.cau.cs.kieler.viewmanagement.ACombination#evaluate()
     */
   
    public boolean evaluate(TriggerEventObject triggerEvent) {
       
        EditPart affectedObject = getEditPart(triggerEvent.getAffectedObject());
        if (affectedObject instanceof ShapeEditPart) {
            this.affectedObject = (ShapeEditPart) affectedObject;
            this.objectParameters = triggerEvent.getParameters();


            return true;
        } else
            return false;
    }

    /*
     * (non-Javadoc)
     * 
     * @see de.cau.cs.kieler.viewmanagement.ACombination#execute()
     */
   
    public void execute() {
        if (effect == null)
            effect = new FilterEffect();

        effect.setTarget(this.affectedObject);
        effect.setParameters(this.objectParameters);
        effect.execute();

    }

}

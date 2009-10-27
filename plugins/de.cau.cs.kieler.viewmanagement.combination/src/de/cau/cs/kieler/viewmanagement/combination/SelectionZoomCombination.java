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
import de.cau.cs.kieler.viewmanagement.effects.ZoomEffect;
import de.cau.cs.kieler.viewmanagement.triggers.SelectionTrigger;
import de.cau.cs.kieler.viewmanagement.*;

/**
 * @author nbe
 * 
 */
public class SelectionZoomCombination extends ACombination {

    ZoomEffect effect;
    SelectionTrigger st;
    
    ShapeEditPart objectToZoom;
    Object objectParameters;
    boolean triggerActive;
   

    @Override
    public List<ATrigger> getTriggers() {
        this.st = (SelectionTrigger)RunLogic.getTrigger("SelectionTrigger");
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
    public boolean evaluate(TriggerEventObject triggerEvent) {
      //parent may be set if wanted. Will else be RootEP 
		EditPart affectedObject = translateToEditPart(triggerEvent.getAffectedObject(), parent);
        if( affectedObject instanceof ShapeEditPart ){
            this.objectToZoom = (ShapeEditPart)affectedObject;
            this.objectParameters = triggerEvent.getParameters();
            this.triggerActive = triggerEvent.getTriggerState();
            
            return true; 
        }
        else
            return false;
    }

    /* (non-Javadoc)
     * @see de.cau.cs.kieler.viewmanagement.ACombination#execute()
     */
    @Override
    public void execute() {
        if ( effect == null )
            effect = new ZoomEffect();
        
        effect.setTarget(this.objectToZoom);
        effect.setParameters(this.objectParameters);
        effect.execute();
        
    }

	@Override
	public void undoLastEffect() {
		// TODO Auto-generated method stub
		
	}




    
    


}

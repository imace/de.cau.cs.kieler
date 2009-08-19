package de.cau.cs.kieler.viewmanagement.combination;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeEditPart;

import de.cau.cs.kieler.viewmanagement.ACombination;
import de.cau.cs.kieler.viewmanagement.AEffect;
import de.cau.cs.kieler.viewmanagement.ATrigger;
import de.cau.cs.kieler.viewmanagement.effects.CompartmentCollapseEffect;
import de.cau.cs.kieler.viewmanagement.triggers.SelectionTrigger;
import de.cau.cs.kieler.viewmanagement.*;

/**
 * @author nbe
 * 
 */
public class SelectionCollapseCombination extends ACombination {

    CompartmentCollapseEffect effect;
    SelectionTrigger st;
    
    ShapeEditPart objectToHighlight;
    Map <String, String> objectParameters;

   
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
   
    public boolean evaluate(TriggerEventObject triggerEvent) {
        Object affectedObject = triggerEvent.getAffectedObject();
        if( affectedObject instanceof ShapeEditPart ){
            this.objectToHighlight = (ShapeEditPart) affectedObject;
            //this.objectParameters.put("depth", null);
            //apply better method to turn this off or on
            return true; // FIXME: only true under certain conditions
        }
        else
            return false;
    }

    /* (non-Javadoc)
     * @see de.cau.cs.kieler.viewmanagement.ACombination#execute()
     */
   
    public void execute() {
        if ( effect == null )
            effect = new CompartmentCollapseEffect();
        effect.setTarget(this.objectToHighlight);
        effect.setParameters(objectParameters);
        effect.execute();
    }

	@Override
	public void undoLastEffect() {
		// TODO Auto-generated method stub
		
	}


}

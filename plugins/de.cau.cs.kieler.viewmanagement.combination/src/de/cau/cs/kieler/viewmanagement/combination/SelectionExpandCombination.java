package de.cau.cs.kieler.viewmanagement.combination;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeEditPart;

import de.cau.cs.kieler.viewmanagement.ACombination;
import de.cau.cs.kieler.viewmanagement.AEffect;
import de.cau.cs.kieler.viewmanagement.ATrigger;
import de.cau.cs.kieler.viewmanagement.effects.CompartmentExpandEffect;
import de.cau.cs.kieler.viewmanagement.triggers.SelectionTrigger;
import de.cau.cs.kieler.viewmanagement.*;

/**
 * @author nbe
 * 
 */
public class SelectionExpandCombination extends ACombination {

    CompartmentExpandEffect effect;
    SelectionTrigger st;
    
    ShapeEditPart objectToHighlight;
    Map <String, String> objectParameters;

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
        Object affectedObject = triggerEvent.getAffectedObject();
        if( affectedObject instanceof ShapeEditPart ){
            this.objectToHighlight = (ShapeEditPart) affectedObject;
            //this.objectParameters.put("depth", null);
            return false; // FIXME: only true under certain conditions
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
            effect = new CompartmentExpandEffect();
        effect.setTarget(this.objectToHighlight);
        effect.setParameters(objectParameters);
        effect.execute();
    }

	@Override
	public void undoLastEffect() {
		// TODO Auto-generated method stub
		
	}


}

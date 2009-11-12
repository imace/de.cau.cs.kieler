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
import de.cau.cs.kieler.viewmanagement.effects.ZoomEffect;
import de.cau.cs.kieler.viewmanagement.triggers.LayoutTrigger;
import de.cau.cs.kieler.viewmanagement.triggers.SelectionTrigger;

/**
 * 
 * haf: added Zoom to fit effect
 * 
 * @author mim
 * 
 */
public class ManualLayoutCombination extends ACombination {
    
    LayoutTrigger trigger; //the auto layout trigger
    LayoutEffect effect; //the auto layout effect
    ZoomEffect zoomEffect; // the zoom effect
    EditPart targetEditPart; //the shape edit part that is used as a target for the layout action
    IEditorPart activeEditorPart; //the active editor part 
    
    /**
     * Evaluates a trigger event
     */
    @Override
    public boolean evaluate(TriggerEventObject triggerEvent) {
        EditPart affectedObject = getEditPart(triggerEvent
                .getAffectedObject());
       
            this.targetEditPart = (EditPart)affectedObject;
            //Add editorPart if supplied
            if (triggerEvent.getParameters() instanceof IEditorPart)
                this.activeEditorPart = (IEditorPart) triggerEvent.getParameters();
            
            return true;
    }

    /**
     * Executes the combination by starting the effect
     */
    @Override
    public void execute() {
        if (effect == null)
            effect = new LayoutEffect();
        effect.setTarget( targetEditPart );
        effect.setParameters(activeEditorPart);
        effect.execute();
        
        if(zoomEffect == null)
            zoomEffect = new ZoomEffect();
        zoomEffect.execute();
    }

    /**
     * Returns the list of triggers
     */
    @Override
    public List<ATrigger> getTriggers() {
        this.trigger = (LayoutTrigger) RunLogic.getInstance()
                .getTrigger("LayoutTrigger");
        List<ATrigger> triggerList = new ArrayList<ATrigger>();
        triggerList.add(trigger);
        return triggerList;
    }

    /**
     * Undo the last effect, this is unused because
     * the 'undo' is done by the layout command framework
     */
    @Override
    public void undoLastEffect() {
        //nothing we can undo here
    }

}

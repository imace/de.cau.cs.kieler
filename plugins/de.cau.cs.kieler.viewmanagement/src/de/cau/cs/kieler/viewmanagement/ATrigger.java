package de.cau.cs.kieler.viewmanagement;

import java.util.HashMap;


import javax.swing.event.EventListenerList;
import javax.swing.text.View;

import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeEditPart;

public abstract class ATrigger {

    private EventListenerList triggerListener = new EventListenerList();
    
    
    public void addTriggerListener (ITriggerListener triggerlistener)
    {
    	triggerListener.add(ITriggerListener.class, triggerlistener);
    }
    
    public void removeTriggerListener (ITriggerListener triggerlistener){
    	triggerListener.remove(ITriggerListener.class, triggerlistener);
    }
    
    protected synchronized void notifyTrigger (TriggerEventObject triggerEvent){
    	
    	for (ITriggerListener l : triggerListener.getListeners(ITriggerListener.class))
    		l.notifyTrigger (triggerEvent);
    
    }
    
    public String translateToURI(Object sourceObject){
    	if (sourceObject instanceof ShapeEditPart){
    	String result= null;
    	View view = (View) ((ShapeEditPart) sourceObject).getModel();
    	EObject modelElement = view.getElement();
    	result = modelElement.eResource().getEObject((ShapeEditPart)sourceObject).toString();
		return result;
    	}
    	
    }
   
    /**
     * Release all system resources for this object.
     */
    public abstract void finalize();
    	
    
}

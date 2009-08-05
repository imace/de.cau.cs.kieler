package de.cau.cs.kieler.viewmanagement;

import java.util.HashMap;


import javax.swing.event.EventListenerList;


import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeEditPart;
import org.eclipse.gmf.runtime.notation.View;

public abstract class ATrigger {

    private EventListenerList triggerListener = new EventListenerList();
    private String result;
    
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
    //returns URIFragment for given object
    public String translateToURI(Object sourceObject){
    	if (sourceObject instanceof ShapeEditPart){
    
    	View view = (View) ((ShapeEditPart) sourceObject).getModel();
    	EObject modelElement = view.getElement();
    	result = modelElement.eResource().getURIFragment(modelElement);
    	
    	}
		return result;
		
    	
    }
   
    /**
     * Release all system resources for this object.
     */
    public abstract void finalize();
    	
    
}

package de.cau.cs.kieler.viewmanagement;

import javax.swing.event.EventListenerList;

public abstract class ATrigger {

	
	//Observable here
    private EventListenerList triggerListeners = new EventListenerList();
    
    
    public void addTriggerListeners (ITriggerListener triggerlistener)
    {
    	triggerListeners.add(ITriggerListener.class, triggerlistener);
    }
    
    public void removeTriggerListeners (ITriggerListener triggerlistener){
    	
    	triggerListeners.remove(ITriggerListener.class, triggerlistener);
    }
    
    protected synchronized void notifyTrigger (TriggerEvent triggerEvent){
    	
    	for (ITriggerListener l : triggerListeners.getListeners(ITriggerListener.class))
    		l.notifyTrigger (triggerEvent);
    }
    
    /**
     * Release all system resources for this object.
     */
    public abstract void finalize();
}

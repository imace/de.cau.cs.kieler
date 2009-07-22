package de.cau.cs.kieler.viewmanagement;

import javax.swing.event.EventListenerList;

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
    
    
    /**
     * Release all system resources for this object.
     */
    public abstract void finalize();
    	
    
}

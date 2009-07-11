package de.cau.cs.kieler.viewmanagement;

import javax.swing.event.EventListenerList;

public abstract class ATrigger {

	
	//Observable here
    private EventListenerList triggerListener = new EventListenerList();
    
    
    public void addTriggerListeners (ITriggerListener triggerlistener)
    {
    	triggerListener.add(ITriggerListener.class, triggerlistener);
    }
    
    public void removeTriggerListeners (ITriggerListener triggerlistener){
    	
    	triggerListener.remove(ITriggerListener.class, triggerlistener);
    }
    
    protected synchronized void notifyTrigger (TriggerEventObject selectionEvent){
    	
    	for (ITriggerListener l : triggerListener.getListeners(ITriggerListener.class))
    		l.notifyTrigger (selectionEvent);
    }
    
    /**
     * Release all system resources for this object.
     */
    public abstract void finalize();
}

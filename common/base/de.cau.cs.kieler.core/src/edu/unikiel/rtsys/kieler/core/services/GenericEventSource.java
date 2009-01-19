package edu.unikiel.rtsys.kieler.core.services;

import java.util.ArrayList;
import java.util.List;


public class GenericEventSource {

	List<GenericEventListener> eventListeners;
	
	public GenericEventSource() {
		eventListeners = new ArrayList<GenericEventListener>();
	}
	
	public void addGenericEventListener(GenericEventListener listener){
		eventListeners.add(listener);
	}
	public void removeGenericEventListeners(){
		eventListeners.clear();
	}
	
	/**
	 * Notifies all data change listeners about a data change.
	 * A port number can be passed to indicate which item of
	 * the whole data has only been changed. 
	 * @param port index of the changed data
	 * @param data whole data object
	 */
	public void fireGenericEvent(Object data){
		GenericEvent e = new GenericEvent(this, data);
		for (GenericEventListener listener : eventListeners) {
			listener.handleEvent(e);			
		}
	}
	
	
}

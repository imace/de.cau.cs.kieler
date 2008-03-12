package edu.unikiel.rtsys.kieler.kev.extension;

import java.util.ArrayList;
import java.util.List;


public class DataChangeEventSource {

	List<DataChangeListener> eventListeners;
	int size = 0;
	
	public DataChangeEventSource() {
		eventListeners = new ArrayList<DataChangeListener>();
	}
	
	public void setSize(int size){
		this.size = size;
	}
	
	public void addDataChangeListener(DataChangeListener listener){
		eventListeners.add(listener);
		listener.setDataSize(size);
	}
	public void removeDataChangeListeners(){
		eventListeners.clear();
	}
	
	public void fireDataChangeEvent(AnimationData data){
		DataChangeEvent e = new DataChangeEvent(this, data);
		for (DataChangeListener listener : eventListeners) {
			listener.dataChanged(e);			
		}
	}
	
	
}

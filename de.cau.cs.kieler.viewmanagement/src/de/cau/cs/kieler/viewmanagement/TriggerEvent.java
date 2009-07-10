package de.cau.cs.kieler.viewmanagement;

import java.util.EventObject;


public class TriggerEvent extends EventObject{
	private TriggerEventObject triggerEvent;
	
	public TriggerEvent (Object source, TriggerEventObject triggerEvent){
		super(source);
		
	this.triggerEvent = triggerEvent;
		
	}
public TriggerEventObject getTriggerEvent(){
	return triggerEvent;
}


}

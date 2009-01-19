package de.cau.cs.kieler.core.services;

import java.util.EventObject;


public class GenericEvent extends EventObject {

	Object data;
	
	public GenericEvent(Object source, Object data) {
		super(source);
		this.data = data;
	}
	
	public Object getData(){return data;}
	
}

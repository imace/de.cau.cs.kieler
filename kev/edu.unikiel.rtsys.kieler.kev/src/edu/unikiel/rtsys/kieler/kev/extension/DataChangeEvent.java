package edu.unikiel.rtsys.kieler.kev.extension;

import java.util.EventObject;


public class DataChangeEvent extends EventObject {

	private AnimationData data;
	
	public DataChangeEvent(Object source, AnimationData data) {
		super(source);
		this.data = data;
	}
	
	public AnimationData getData(){return data;}
	
}

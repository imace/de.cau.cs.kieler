package de.cau.cs.kieler.klots.editor;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class InputDataPool {

	private static final InputDataPool INSTANCE = new InputDataPool();
	private StringBuffer buffer;
	private PropertyChangeSupport propertyChangeSupport =  new PropertyChangeSupport(this);
	
	public InputDataPool() {	
	}
	
	public static InputDataPool getInstance() {
		return INSTANCE;
	}
	
	public void addPropertyChangeListener(String propertyName, PropertyChangeListener listener) {
		propertyChangeSupport.addPropertyChangeListener(propertyName, listener);
	}
	
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		propertyChangeSupport.addPropertyChangeListener(listener);
	}
	
	public void writeData(StringBuffer data) {
		propertyChangeSupport.firePropertyChange("buffer", this.buffer, this.buffer = data);
	}
	
	public StringBuffer readData() {
		return buffer;
	}
	
	public void setBuffer(StringBuffer data) {
		writeData(data);
	}
	
	public StringBuffer getBuffer() {
		return buffer;
	}
}

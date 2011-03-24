package de.cau.cs.kieler.klots.editor;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class InputDataPool {

	public final int START_ACTION = 1;
	public final int STOP_ACTION = 2;
	public final String DATA_BUFFER = "buffer";
	public final String ACTION_FLAG = "action";
	
	private static final InputDataPool INSTANCE = new InputDataPool();
	private StringBuffer buffer;
	private int actionFlag = 0;
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
		propertyChangeSupport.firePropertyChange(this.DATA_BUFFER, this.buffer, this.buffer = data);
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

	public void setActionFlag(int actionCode) {
		propertyChangeSupport.firePropertyChange(this.ACTION_FLAG, this.actionFlag, this.actionFlag = actionCode);
		this.actionFlag = actionCode;
	}

	public int getActionFlag() {
		return actionFlag;
	}
}

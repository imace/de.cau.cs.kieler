package edu.unikiel.rtsys.kieler.kev.extension;

import java.util.EventListener;



public interface ControlFlowChangeListener extends EventListener {

	void controlFlowChanged(ControlFlowChangeEvent e);
	
}

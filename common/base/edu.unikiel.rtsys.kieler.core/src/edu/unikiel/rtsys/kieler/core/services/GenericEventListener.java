package edu.unikiel.rtsys.kieler.core.services;

import java.util.EventListener;

public interface GenericEventListener extends EventListener {

	void handleEvent( GenericEvent e);
	
}

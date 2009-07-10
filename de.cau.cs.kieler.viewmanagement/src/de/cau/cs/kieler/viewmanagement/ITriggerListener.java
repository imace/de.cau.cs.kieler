package de.cau.cs.kieler.viewmanagement;

import java.util.EventListener;

public interface ITriggerListener extends EventListener{

	void notifyTrigger(TriggerEventObject triggerEvent);
	

}

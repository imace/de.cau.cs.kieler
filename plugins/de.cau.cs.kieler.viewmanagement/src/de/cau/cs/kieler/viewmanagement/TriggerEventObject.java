package de.cau.cs.kieler.viewmanagement;

import org.eclipse.emf.ecore.EObject;



public class TriggerEventObject {
	
	private boolean triggerActive;
	private EObject affectedObject;
	private  Object parameters;



public boolean getTriggerState(){
	return triggerActive;
}

public void setTriggerActive(boolean newState){
	triggerActive=newState;
	
}

public EObject getAffectedObject(){
	return affectedObject;
}

public void setAffectedObject(EObject eObject){
	affectedObject= eObject;
	
}

public Object getParameters(){
	return parameters;
	
}
public void setParameters (Object newParameters){
	parameters = newParameters;
}

}





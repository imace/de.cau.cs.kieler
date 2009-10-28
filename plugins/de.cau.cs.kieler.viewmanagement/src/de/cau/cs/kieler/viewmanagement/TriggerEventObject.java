package de.cau.cs.kieler.viewmanagement;



public class TriggerEventObject {
	
	private boolean triggerActive;
	private String affectedObject;
	private  Object parameters;



public boolean getTriggerState(){
	return triggerActive;
}

public void setTriggerActive(boolean newState){
	triggerActive=newState;
	
}

public String getAffectedObject(){
	return affectedObject;
}

public void setAffectedObject(String newObject){
	affectedObject= newObject;
	
}

public Object getParameters(){
	return parameters;
	
}
public void setParameters (Object newParameters){
	parameters = newParameters;
}

}





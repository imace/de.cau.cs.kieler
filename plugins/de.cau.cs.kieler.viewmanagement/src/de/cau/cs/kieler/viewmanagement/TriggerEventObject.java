package de.cau.cs.kieler.viewmanagement;

import java.util.Map;

public class TriggerEventObject {
	
	private boolean triggerActive;
	private String affectedObject;
	private  Map <String, String> parameters;



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

public Map <String, String> getParameters(){
	return parameters;
	
}
public void setParameters (Map <String, String> newParameters){
	parameters = newParameters;
}

}





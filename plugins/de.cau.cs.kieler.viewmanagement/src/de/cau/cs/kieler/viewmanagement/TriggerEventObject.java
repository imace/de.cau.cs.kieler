package de.cau.cs.kieler.viewmanagement;

import java.util.Map;

public class TriggerEventObject {
	
	private boolean triggerToggle;
	private Object affectedObject;
	private  Map <String, String> parameters;



public boolean getTriggerToggle(){
	return triggerToggle;
}

public void setTriggerToggle(boolean newToggle){
	triggerToggle=newToggle;
	
}

public Object getAffectedObject(){
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





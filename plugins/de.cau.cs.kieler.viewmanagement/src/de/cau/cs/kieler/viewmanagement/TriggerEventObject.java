package de.cau.cs.kieler.viewmanagement;

import java.util.Map;

public class TriggerEventObject {
	
	private boolean triggerActive;
	private Object affectedObject;
	private  Map <String, String> parameters;



public boolean getTriggerToggle(){
	return triggerActive;
}

public void setTriggerActive(boolean newToggle){
	triggerActive=newToggle;
	
}

public Object getAffectedObject(){
	return affectedObject;
}

public void setAffectedObject(Object newObject){
	affectedObject= newObject;
	
}

public Map <String, String> getParameters(){
	return parameters;
	
}
public void setParameters (Map <String, String> newParameters){
	parameters = newParameters;
}

}





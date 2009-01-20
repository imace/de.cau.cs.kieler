
package de.cau.cs.kieler.gems.mealy.mealymachine;

import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.TextPropertyDescriptor;
import org.eclipse.gmt.gems.model.BasicConnectionType;
import org.eclipse.gmt.gems.model.Wire;
import org.eclipse.gmt.gems.model.AttributeValue;

import de.cau.cs.kieler.gems.mealy.emf.mealymachine.*;

import java.util.Vector;


public class TransitionConnectionType extends BasicConnectionType {
    public static final String NAME = "Transition";
    public static final TransitionConnectionType INSTANCE = 
        new TransitionConnectionType();
    
    public static final String ACTION = "Action";
    public static final String CONDITION = "Condition";
    

    public static final IPropertyDescriptor[] TRANSITION_ATTRIBUTE_DESCRIPTORS =
    {
new org.eclipse.ui.views.properties.TextPropertyDescriptor("Action","Action")


            ,
new org.eclipse.ui.views.properties.TextPropertyDescriptor("Condition","Condition")


    };
    public static final Object[] TRANSITION_DEFAULT_ATTRIBUTE_VALUES = {
       
            "0"
             ,
            "0"
    };
    
      	 

    
    protected void getPropertyDescriptors(Vector desc){
    	desc.addAll(java.util.Arrays.asList(TRANSITION_ATTRIBUTE_DESCRIPTORS));    	
    	super.getPropertyDescriptors(desc);
    }
    
   
   
    
    private TransitionConnectionType() {
        super(NAME,State.class,State.class,"OutgoingTransitions","IncomingTransitions");
        registerType(MealyMachineProvider.MODEL_ID,this);
    }
    
    protected TransitionConnectionType(String type) {
        super(type);
        registerType(MealyMachineProvider.MODEL_ID,this);
    }
    
    public String getModelID() {
        return MealyMachineProvider.MODEL_ID;
    }
    
    public void installAttributes(Wire wire) {
    	EMFTransitionProxy proxy = new EMFTransitionProxy();
		installAttributes(wire,proxy);
    }
    
     public void installAttributes(Wire wire, EMFTransitionProxy proxy) {
        AttributeValue[] attributes = proxy.getAttributeValues();
        wire.installAttribute(NAME,attributes[0]);
        for(int i = 0; i < TRANSITION_ATTRIBUTE_DESCRIPTORS.length; i++) {
            wire.installAttribute((String)TRANSITION_ATTRIBUTE_DESCRIPTORS[i].getId(),attributes[i+1]);
        }
        super.installAttributes(wire);
    }
   

    public static String getAction(Wire w){
    	return (String)w.getAttribute(ACTION);
    }
    public static String getCondition(Wire w){
    	return (String)w.getAttribute(CONDITION);
    }
}

 
       
       
   
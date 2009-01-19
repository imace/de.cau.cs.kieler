
package edu.unikiel.rtsys.gems.mealy.mealymachine;

import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.TextPropertyDescriptor;
import org.eclipse.gmt.gems.model.BasicConnectionType;
import org.eclipse.gmt.gems.model.Wire;
import org.eclipse.gmt.gems.model.AttributeValue;

import de.cau.cs.kieler.gems.mealy.emf.mealymachine.*;

import java.util.Vector;


public class EMFTransitionProxy {
    	private TransitionConnection conn_;
    	private AttributeValue[] attributeValues_;
    	
    	
       	private class ActionAttributeValue implements AttributeValue{
        	private AttributeValue value_;
        	
			public ActionAttributeValue(AttributeValue val){
				value_ = val;
				if(conn_ != null)
				   
				   value_.setValue(conn_.getAction());
				   
			}
			
			public Object getPropertyValue() {return value_.getPropertyValue();}		
			public Object getValue() {return value_.getValue();}		
			public void setValue(Object value) {
				value_.setValue(value);
				Object val = value_.getValue();
				conn_.setAction((String)val);
			}		
		}
       	private class ConditionAttributeValue implements AttributeValue{
        	private AttributeValue value_;
        	
			public ConditionAttributeValue(AttributeValue val){
				value_ = val;
				if(conn_ != null)
				   
				   value_.setValue(conn_.getCondition());
				   
			}
			
			public Object getPropertyValue() {return value_.getPropertyValue();}		
			public Object getValue() {return value_.getValue();}		
			public void setValue(Object value) {
				value_.setValue(value);
				Object val = value_.getValue();
				conn_.setCondition((String)val);
			}		
		}
    	
    	public EMFTransitionProxy(){
    		conn_ = de.cau.cs.kieler.gems.mealy.emf.mealymachine.impl.MealyMachineFactoryImpl.eINSTANCE.createTransitionConnection();
    		init();
    	}
    	
    	public EMFTransitionProxy(TransitionConnection con){
    		conn_ = con;
    		init();
    	}
    	
    	protected void init(){
    	   
       	   org.eclipse.gmt.gems.model.AttributeValueFactory factory = 
       new org.eclipse.gmt.gems.model.AttributeValueFactory(AttributeValidators.getInstance());
       
org.eclipse.gmt.gems.model.AttributeValue[] attributes = {
  factory.getStringValue("Action","0"),
  factory.getStringValue("Condition","0")
};



       	   attributeValues_ = new AttributeValue[2 + 1];
       	   attributeValues_[0] = new AttributeValue() {
        	public Object getPropertyValue() {return "EMF";}		
			public Object getValue() {return conn_;}		
			public void setValue(Object value) {}		
			};
       	   
       	   
       	   attributeValues_[1]= new ActionAttributeValue(attributes[0]);
       	  
       	   
       	   
       	   attributeValues_[2]= new ConditionAttributeValue(attributes[1]);
       	  
       	   
    	}
    	
    	public AttributeValue[] getAttributeValues(){
    		return attributeValues_;
    	}
}

 
       
       
   
/******************************************************************************
 * KIELER - Kiel Integrated Environment for Layout for the Eclipse RCP
 *
 * http://www.informatik.uni-kiel.de/rtsys/kieler/
 * 
 * Copyright 2009 by
 * + Christian-Albrechts-University of Kiel
 *   + Department of Computer Science
 *     + Real-Time and Embedded Systems Group
 * 
 * This code is provided under the terms of the Eclipse Public License (EPL).
 * See the file epl-v10.html for the license text.
 * 
 *****************************************************************************/
package de.cau.cs.kieler.viewmanagement;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeEditPart;

/**
 * @author nbe
 *
 */
public abstract class ACombination implements ITriggerListener{

	//private boolean evresult;
	List<ATrigger> triggers;
    List<AEffect> effects;
    ATrigger t;
    List<ATrigger> triggersToEvaluate;
    private boolean comboActive;
    private HashMap<String,EditPart> cachedEditParts;
    
    
    public abstract boolean evaluate(TriggerEventObject triggerEvent);

    public abstract void execute();

    public abstract List<ATrigger> getTriggers();
    
    public abstract void undoLastEffect();
    
    public boolean getActive(){
    	return comboActive;
    }
//    Activate or deactivate a combo
    public void setActive(boolean active){
    	this.comboActive= active;
    }

	public void initialize() {
		triggersToEvaluate=getTriggers();
		for (int i=0; i<triggersToEvaluate.size();i++){
			ATrigger a = triggersToEvaluate.get(i);
			a.addTriggerListener(this);
		}
	}
	
	public void finalize (){
		undoLastEffect();
		triggersToEvaluate=getTriggers();
		for (int i=0; i<triggersToEvaluate.size();i++){
			ATrigger a = triggersToEvaluate.get(i);
			a.removeTriggerListener(this);
			
			
	}
	}
	
	
	public void notifyTrigger(TriggerEventObject triggerEvent) {
	    // this is called whenever trigger want to notify
	    
	    // call evaluate in concrete combo
	    if( this.evaluate(triggerEvent) ) 
	        this.execute();
	    
	}
	

	public EditPart getEditPart(String elementURIFragment,                                                                    
			EditPart parent) {
			            if (cachedEditParts == null) {
			                // if hashmap is not initialized, create it
			                    cachedEditParts = new HashMap<String,EditPart>();
			            }
			            else {
			                //try to get from hashmap first
			                    if (cachedEditParts.containsKey(elementURIFragment))
			                            return cachedEditParts.get(elementURIFragment);
			            }
			            
			        List children = parent.getChildren();
			        for (Object child : children) {
			            if (child instanceof ShapeEditPart) {
			                View view = (View) ((ShapeEditPart) child).getModel();
			                EObject modelElement = view.getElement();
			                            if (modelElement.equals(
			                                    modelElement.eResource()
			                                .getEObject(elementURIFragment))) {
			                        //cache for later calls
			                        cachedEditParts.put(
			                                        elementURIFragment,
			                                        (ShapeEditPart) child);
			                        return (ShapeEditPart) child;
			                            }
			                            
			            }
			            // if node was not found yet, search recursively
			            if (child instanceof EditPart) {
			                EditPart result = getEditPart(elementURIFragment,
			                                                   (EditPart) child);
			                if (result != null) {
			                    return result;
			                }
			            }
			        }
			        // we did not find anything in this trunk
			        return null;
			    }
	

}


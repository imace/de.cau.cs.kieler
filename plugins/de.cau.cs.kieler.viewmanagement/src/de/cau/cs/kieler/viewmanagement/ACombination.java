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

/**
 * @author haf
 *
 */
public class ACombination implements ITriggerListener{

	private boolean evresult;
	List<ATrigger> triggers;
    List<AEffect> effects;
    ATrigger t;
    List<ATrigger> trigToEv;
    

	public void initialize() {
		trigToEv=getTriggers();
		for (int i=0; i<trigToEv.size();i++){
			ATrigger a = trigToEv.get(i);
			a.addTriggerListener(this);
			
		}
	}
	
	public void evaluate() {
		evresult=false;
		/*What does evaluate read? CombinationObject needed?
		 * Needs list of triggers that need to be true to fire, rather a list of TriggerEventObjects.
		 * How to access the listeners here?
		 * Also needs List of effects that should then be executed
		 * Additionally a boolean expression should be there. 
		 */
		if (evresult)
			execute();
		
		
		
	}
	
	public void execute (){
		/*
		 * Needs a list of Effects and affected objects
		 */
		
		
	}
	
	 private void readTriggers() {
	        IConfigurationElement[] myExtensions = Platform.getExtensionRegistry()
	                .getConfigurationElementsFor(
	                        "de.cau.cs.kieler.viewmanagement.triggers");
	        for (int i = 0; i < myExtensions.length; i++) {
	        	
	        	/*
	        	ITriggerListener newlistener = (ITriggerListener) myExtensions[i];
	        	t.addTriggerListener(newlistener);
	        	*/
	        }
	    }
	 


	private void readEffects() {
	        IConfigurationElement[] myExtensions = Platform.getExtensionRegistry()
	                .getConfigurationElementsFor(
	                        "de.cau.cs.kieler.viewmanagement.effects");
	        for (int i = 0; i < myExtensions.length; i++) {
	        	
	            
	            }
	        }

	public void notifyTrigger(TriggerEventObject triggerEvent) {
		// TODO Auto-generated method stub
		
	}
	
	public List<ATrigger> getTriggers() {
		return null;
		
		// TODO Auto-generated method stub
		
	}

}


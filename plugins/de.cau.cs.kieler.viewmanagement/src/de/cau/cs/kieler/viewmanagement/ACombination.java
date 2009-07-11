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
public class ACombination {

	private boolean evresult;
	List<ATrigger> triggers;
    List<AEffect> effects;
    ATrigger t;

	public void initialize() {
		triggers = new ArrayList<ATrigger>();
		effects = new ArrayList<AEffect>();
		
		this.readTriggers();
		this.readEffects();
	}
	
	public boolean evaluate() {
		evresult=false;
		
		return evresult;
		
	}
	
	public void execute (){
		
		
	}
	
	 private void readTriggers() {
	        IConfigurationElement[] myExtensions = Platform.getExtensionRegistry()
	                .getConfigurationElementsFor(
	                        "de.cau.cs.kieler.viewmanagement.triggers");
	        for (int i = 0; i < myExtensions.length; i++) {
	        	
	        	ITriggerListener newlistener = (ITriggerListener) myExtensions[i];
	        	t.addTriggerListener(newlistener);
	        }
	    }
	 


	private void readEffects() {
	        IConfigurationElement[] myExtensions = Platform.getExtensionRegistry()
	                .getConfigurationElementsFor(
	                        "de.cau.cs.kieler.viewmanagement.effects");
	        for (int i = 0; i < myExtensions.length; i++) {
	        	
	            
	            }
	        }

}


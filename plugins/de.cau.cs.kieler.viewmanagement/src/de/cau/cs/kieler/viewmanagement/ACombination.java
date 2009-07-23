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
public abstract class ACombination implements ITriggerListener{

	private boolean evresult;
	List<ATrigger> triggers;
    List<AEffect> effects;
    ATrigger t;
    List<ATrigger> triggersToEvaluate;
    
    public abstract boolean evaluate(TriggerEventObject triggerEvent);

    public abstract void execute();

    public abstract List<ATrigger> getTriggers();

	public void initialize() {
		triggersToEvaluate=getTriggers();
		for (int i=0; i<triggersToEvaluate.size();i++){
			ATrigger a = triggersToEvaluate.get(i);
			a.addTriggerListener(this);
		}
	}
	
	public void finalize (){
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
	

}


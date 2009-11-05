/*
 * KIELER - Kiel Integrated Environment for Layout Eclipse RichClient
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

import java.util.EventObject;

/**
 * @author nbe
 *
 */

public class TriggerEvent extends EventObject{
	private TriggerEventObject triggerEvent;
	
	
	/**
	 * Object that is exchanged between the components of the ViewManagement
	 * @param source where the event stems from
	 * @param triggerEvent the actual object
	 */
	public TriggerEvent (final Object source, final TriggerEventObject triggerEvent){
		super(source);
		
	this.triggerEvent = triggerEvent;
		
	}
/**
 * Returns the TriggerEventObject
 * @return the TriggerEventObject
 */
public TriggerEventObject getTriggerEvent(){
	return triggerEvent;
}


}


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
 ******************************************************************************/

package de.cau.cs.kieler.sim.kiem.extension;

// TODO: Auto-generated Javadoc
/**
 * The Interface IJSONStringDataComponent.
 *
 * @author Christian Motika <cmot@informatik.uni-kiel.de>
 * 
 */
public interface IJSONStringDataComponent  {
	
	//one step function for a Observer and producer
	//for a producer only the argument will always be null
	//for a Observer only this method will be called asynchronous
	/**
	 * Step.
	 * 
	 * @param JSONString the jSON string
	 * 
	 * @return the string
	 * 
	 * @throws KiemExecutionException the kiem execution exception
	 */
	public String step(String JSONString)
										throws KiemExecutionException;   

}

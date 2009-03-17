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
 */
package de.cau.cs.kieler.core.util;

/**
 * A simple pair implementation.
 * 
 * @author msp
 */
public class Pair <F, S> {

	/** the first element */
	public F first;
	/** the second element */
	public S second;
	
	/**
	 * Constructs a pair given both elements.
	 * 
	 * @param first the first element
	 * @param second the second element
	 */
	public Pair (F first, S second) {
		this.first = first;
		this.second = second;
	}
	
}

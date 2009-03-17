/******************************************************************************
 * KIELER - Kiel Integrated Environment for Layout for the Eclipse RCP
 *
 * http://www.informatik.uni-kiel.de/rtsys/kieler/
 * 
 * Copyright 2008 by
 * + Christian-Albrechts-University of Kiel
 *   + Department of Computer Science
 *     + Real-Time and Embedded Systems Group
 * 
 * This code is provided under the terms of the Eclipse Public License (EPL).
 * See the file epl-v10.html for the license text.
 */
package de.cau.cs.kieler.klodd.hierarchical.structures;

/**
 * A routing slot is a place in which layer connections can be routed. 
 * 
 * @author msp
 */
public class RoutingSlot {
	
	/** the slot rank determines the lengthwise distance to the preceding layer */
	public int rank;
	
	/** crosswise starting and ending position of this slot */
	public float start, end;
	
}

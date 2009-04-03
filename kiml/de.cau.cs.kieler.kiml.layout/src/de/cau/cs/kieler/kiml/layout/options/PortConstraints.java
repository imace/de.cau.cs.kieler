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
package de.cau.cs.kieler.kiml.layout.options;

/**
 * Definition of port constraints.
 * 
 * @author msp
 */
public enum PortConstraints {

    /** all ports are free */
    FREE_PORTS,
    /** the side is fixed for each port */
    FIXED_SIDE,
    /** the side is fixed for each port, and the order of ports
     * is fixed for each side
     */
    FIXED_ORDER,
    /** the exact position is fixed for each port */
    FIXED_POS;
    
}

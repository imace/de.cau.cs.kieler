/*
 * KIELER - Kiel Integrated Environment for Layout Eclipse RichClient
 *
 * http://www.informatik.uni-kiel.de/rtsys/kieler/
 * 
 * Copyright 2010 by
 * + Christian-Albrechts-University of Kiel
 *   + Department of Computer Science
 *     + Real-Time and Embedded Systems Group
 * 
 * This code is provided under the terms of the Eclipse Public License (EPL).
 * See the file epl-v10.html for the license text.
 */
package de.cau.cs.kieler.klay.layered.properties;

/**
 * Definition of port types.
 *
 * @kieler.rating 2011-03-14 yellow
 *     reviewed by cmot, cds
 * @author msp
 */
public enum PortType {
    
    /** undefined port type. */
    UNDEFINED,
    /** input port type. */
    INPUT,
    /** output port type. */
    OUTPUT;
    
    /**
     * Returns the enumeration value related to the given ordinal.
     * 
     * @param i ordinal value
     * @return the related enumeration value
     */
    public static PortType valueOf(final int i) {
        return values()[i];
    }

}

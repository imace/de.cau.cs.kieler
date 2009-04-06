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
 * Definition of placement positions for edge labels.
 * 
 * @author msp
 */
public enum EdgeLabelPlacement {

    /** undefined label placement */
    UNDEFINED,
    /** label is centered on the edge */
    CENTER,
    /** label is at the head (target) of the edge */
    HEAD,
    /** label is at the tail (source) of the edge */
    TAIL;
    
    /**
     * Returns the enumeration value related to the given ordinal.
     * 
     * @param i ordinal value
     * @return the related enumeration value
     */
    public static EdgeLabelPlacement valueOf(int i) {
        return values()[i];
    }
    
}

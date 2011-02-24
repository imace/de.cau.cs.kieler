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
package de.cau.cs.kieler.klay.layered.intermediate;

/**
 * Definition of available intermediate layout processors for the layered layouter.
 * 
 * @author cds
 */
public enum IntermediateLayoutProcessor {
    
    /** Takes a layered graph and turns it into a properly layered graph. */
    EDGE_SPLITTER,
    /** Takes a layered graph and inserts dummy nodes for edges connected to ports on strange sides. */
    STRANGE_PORT_SIDE_PROCESSOR;
    
    
    /**
     * Returns the enumeration value related to the given ordinal.
     * 
     * @param i ordinal value
     * @return the related enumeration value
     */
    public static IntermediateLayoutProcessor valueOf(final int i) {
        return values()[i];
    }

}
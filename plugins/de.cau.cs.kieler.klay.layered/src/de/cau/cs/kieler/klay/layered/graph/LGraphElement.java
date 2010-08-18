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
package de.cau.cs.kieler.klay.layered.graph;

import de.cau.cs.kieler.core.util.MapPropertyHolder;

/**
 * Abstract superclass for the layers, nodes, ports, and edges of a layered graph.
 *
 * @author msp
 */
public abstract class LGraphElement extends MapPropertyHolder
        implements Comparable<LGraphElement> {

    // CHECKSTYLEOFF VisibilityModifier
    /** Identifier value, may be arbitrarily used by algorithms. */
    public int id;
    // CHECKSTYLEON VisibilityModifier
    
    /**
     * {@inheritDoc}
     */
    public int compareTo(final LGraphElement other) {
        return this.id - other.id;
    }
    
}

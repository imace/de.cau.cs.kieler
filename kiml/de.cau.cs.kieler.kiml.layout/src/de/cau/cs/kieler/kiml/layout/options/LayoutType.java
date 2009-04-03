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
 * Definition of layout types.
 * 
 * @author msp
 */
public enum LayoutType {

    /** layout based on the topology-shape-metrics approach */
    ORTHOGONAL ("Orthogonal"),
    /** layout based on the layered approach */
    LAYERED ("Layered"),
    /** a spring embedder method */
    SPRING ("Spring Embedder"),
    /** places all nodes on a circle */
    CIRCLE ("Circle"),
    /** emphasizes radial tree structures */
    RADIAL ("Radial"),
    /** method not covered by previous descriptions */
    OTHER ("Other");
    
    /** the readable name of this layout type */
    private String name;
    
    /**
     * Creates a layout type instance.
     * 
     * @param name
     */
    LayoutType(String name) {
        this.name = name;
    }
    
    /*
     * (non-Javadoc)
     * @see java.lang.Enum#toString()
     */
    public String toString() {
        return name;
    }
    
}

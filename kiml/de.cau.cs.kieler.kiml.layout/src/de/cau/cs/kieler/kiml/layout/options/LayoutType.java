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
    /** a method based on physical forces */
    FORCE ("Force"),
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
    
    /**
     * Returns the name of this layout type.
     * 
     * @return the name of layout type
     */
    public String toString() {
        return name;
    }
    
    /**
     * Gets the layout type related to the given name.
     * 
     * @param name name of layout type
     * @return the related type constant
     */
    public static LayoutType fromString(String name) {
        if (name.equals("Orthogonal"))
            return ORTHOGONAL;
        else if (name.equals("Layered"))
            return LAYERED;
        else if (name.equals("Force"))
            return FORCE;
        else if (name.equals("Circle"))
            return CIRCLE;
        else if (name.equals("Radial"))
            return RADIAL;
        else
            return OTHER;
    }
    
    /**
     * Returns the enumeration value related to the given ordinal.
     * 
     * @param i ordinal value
     * @return the related enumeration value
     */
    public static LayoutType valueOf(int i) {
        return values()[i];
    }
    
}

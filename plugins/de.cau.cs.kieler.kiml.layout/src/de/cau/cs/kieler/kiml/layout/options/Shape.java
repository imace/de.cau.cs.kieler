/*
 * KIELER - Kiel Integrated Environment for Layout Eclipse RichClient
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
 * Definition of node shapes.
 * 
 * @kieler.rating 2009-12-11 proposed yellow msp
 * @author msp
 */
public enum Shape {

    /** undefined shape. */
    UNDEFINED,
    /** rectangle shape. */
    RECTANGLE,
    /** ellipse shape. */
    ELLIPSE,
    /** triangle shape. */
    TRIANGLE;

    /**
     * Returns the enumeration value related to the given ordinal.
     * 
     * @param i ordinal value
     * @return the related enumeration value
     */
    public static Shape valueOf(final int i) {
        return values()[i];
    }

}

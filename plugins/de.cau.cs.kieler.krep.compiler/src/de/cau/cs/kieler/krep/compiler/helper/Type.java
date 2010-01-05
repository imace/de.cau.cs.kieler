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
package de.cau.cs.kieler.krep.compiler.helper;

/**
 * @author ctr Basic Lustre types
 */
public enum Type {
    /**
     * integer values (32 Bit).
     */
    INT,
    /**
     * boolean values.
     */
    BOOL,
    /**
     * double values (32 Bit).
     */
    REAL;

    @Override
    public String toString() {
        switch (this) {
        case INT:
            return "int";
        case BOOL:
            return "bool";
        case REAL:
            return "real";
        }
        return "";
    }
}

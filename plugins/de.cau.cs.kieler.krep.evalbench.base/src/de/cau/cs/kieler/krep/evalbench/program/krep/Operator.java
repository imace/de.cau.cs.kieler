/******************************************************************************
 * KIELER - Kiel Integrated Environment for Layout for the Eclipse RCP
 *
 * http://www.informatik.uni-kiel.de/rtsys/kieler/
 * 
 * Copyright ${year} by
 * + Christian-Albrechts-University of Kiel
 *   + Department of Computer Science
 *     + Real-Time and Embedded Systems Group
 * 
 * This code is provided under the terms of the Eclipse Public License (EPL).
 * See the file epl-v10.html for the license text.
 ******************************************************************************/
package de.cau.cs.kieler.krep.evalbench.program.krep;

/**
 * @author ctr
 * 
 *         Arithmetic and boolean operators
 */
public enum Operator {
    /**
     * addition
     */
    ADD,

    /**
     * subtraction
     */
    SUB,

    /**
     * multiplication
     */
    MUL,

    /**
     * division
     */
    DIV,

    /**
     * boolean and
     */
    AND,

    /**
     * boolean or
     */
    OR,

    /**
     * boolean exclusive or
     */
    XOR,

    /**
     * negation
     */
    NOT;
}

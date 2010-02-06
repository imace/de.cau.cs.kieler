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
package de.cau.cs.kieler.krep.compiler.klp;

/**
 * Conditional Jump.
 * 
 * @kieler.rating 2010-02-05 yellow 
 *   review by cmot, msp, tam
 * 
 * @author ctr 
 * 
 */
public class CJmpInstruction extends AbstractInstruction {

    private RegAccess reg;

    private Cond cond;

    private LabelInstruction label;

    /**
     * @author ctr Condition on which a jump can be based
     */
    public enum Cond {
        /**
         * jump when true.
         */
        T,
        /**
         * jump when false.
         */
        F,
        /**
         * jump when zero.
         */
        Z,
        /**
         * jump when not zero.
         */
        NZ;
    }

    /**
     * @param conditional
     *            condition
     * @param read
     *            register to check
     * @param l
     *            label of the target
     */
    public CJmpInstruction(final Cond conditional, final RegAccess read, final LabelInstruction l) {
        super();
        this.cond = conditional;
        this.reg = read;
        label = l;
    }

    @Override
    public String toString() {
        String res = "  ";
        switch (cond) {
        case T:
            res += "JT";
            break;
        case F:
            res += "JF";
            break;
        case Z:
            res += "JZ";
            break;
        case NZ:
            res += "JNZ";
            break;
        }
        res += "\t" + reg.toString() + "\t" + label.getName();
        return res;
    }

}

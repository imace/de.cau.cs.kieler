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

import de.cau.cs.kieler.krep.compiler.ceq.Variable;
import de.cau.cs.kieler.krep.compiler.lustre.Operator;

/**
 * 
 * Binary operation.
 * 
 * @kieler.rating 2010-02-05 yellow review by cmot, msp, tam
 * 
 * @author ctr
 */
public class BinOpInstruction extends AbstractInstruction {
    private Variable to;
    private RegAccess r1, r2;
    private Operator op;

    /**
     * @param toVar
     *            variable that stores the result
     * @param read1
     *            first parameter
     * @param read2
     *            second parameter
     * @param operator
     *            operator
     */
    public BinOpInstruction(final Variable toVar, final RegAccess read1, final RegAccess read2,
            final Operator operator) {
        super();
        this.to = toVar;
        this.r1 = read1;
        this.r2 = read2;
        this.op = operator;
    }

    @Override
    public String toString() {
        return "  " + op.toKlp() + "\t" + to.getName() + "\t" + r1.toString() + "\t"
                + r2.toString();
    }
}

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
package de.cau.cs.kieler.krep.compiler.lustre;

import java.util.HashMap;
import java.util.LinkedList;

import de.cau.cs.kieler.krep.compiler.exceptions.ClockException;
import de.cau.cs.kieler.krep.compiler.exceptions.TypeException;
import de.cau.cs.kieler.krep.compiler.helper.Debug;
import de.cau.cs.kieler.krep.compiler.prog.Type;

/**
 * @author ctr Lustre "not" operator
 */
public class Not extends Expression {
    private Expression expr;

    /**
     * @param name
     *            uniue name of the expression
     * @param e
     *            expression to negate
     */
    public Not(final String name, final Expression e) {
        super(name);
        this.expr = e;
    }

    @Override
    public String toString() {
        return "(not " + expr.toString() + ")";
    }

    @Override
    public Expression propagatePre(final HashMap<String, Expression> eqs) {
        expr = expr.propagatePre(eqs);
        return this;
    }

    @Override
    public boolean isAtom() {
        return false;
    }

    // @Override
    // public ceq.Expression toCEQ() {
    // return new ceq.Not(name, e.toCEQ());
    // }

    @Override
    protected void inferType() throws TypeException {
        expr.inferType();
        type = expr.type;
        if (type != Type.BOOL) {
            throw new TypeException(expr, Type.BOOL.toString(), expr.type.toString());
        }
    }

    @Override
    public ClockList inferClock(final HashMap<String, Variable> env) throws ClockException {
        clock = expr.inferClock(env);
        return clock;
    }

    @Override
    public void propagateClock(final ClockList l) {
        clock = l.clone();
        expr.propagateClock(clock);
        Debug.low(clock.toString() + " " + this.toString());
    }

    @Override
    public de.cau.cs.kieler.krep.compiler.ceq.Equation declock(final String basename, final int stage,
            final String c, final LinkedList<de.cau.cs.kieler.krep.compiler.ceq.Equation> aux) {
        de.cau.cs.kieler.krep.compiler.ceq.Equation eq = expr.declock(basename, 3, c, aux);
        return new de.cau.cs.kieler.krep.compiler.ceq.Equation(name,
                new de.cau.cs.kieler.krep.compiler.ceq.Not(name, eq.getExpr()));

    }

    @Override
    public Expression liftClock() {
        expr = expr.liftClock();
        if (expr instanceof When) {
            When w = (When) expr;
            expr = w.getExpression();
            w.setExpression(this);
            return w;
        } else {
            return this;
        }
    }

    @Override
    public Expression extractPre(final HashMap<String, Expression> eqs) {
        expr = expr.extractPre(eqs);
        return this;
    }
}

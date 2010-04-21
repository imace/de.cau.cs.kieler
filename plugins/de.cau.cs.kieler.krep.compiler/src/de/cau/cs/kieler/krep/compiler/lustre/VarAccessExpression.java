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
import de.cau.cs.kieler.krep.compiler.util.Debug;

/**
 * Implement the possible immediate access to a Lustre variable.
 * 
 * @kieler.rating 2010-02-05 yellow review by cmot, msp, tam
 * 
 * @author ctr
 * 
 */
public class VarAccessExpression extends Expression {

    private final Variable var;

    /**
     * @param name
     *            name of the read variable
     */
    public VarAccessExpression(final String name) {
        this(Variable.get(name));
    }

    /**
     * @param v
     *            variable to read
     */
    public VarAccessExpression(final Variable v) {
        super(v.getName());
        this.var = v;
        setType(var.getType());
        this.setClock(var.getClock().clone());
    }

    /**
     * @param clock
     *            on which the variable shall run
     */
    public void setClock(final String clock) {
        if (getClock() != null) {
            getClock().addClock(clock);
        }
    }

    @Override
    public String toString() {
        return getName();
    }

    @Override
    public Expression propagatePre(final HashMap<String, Expression> eqs) {
        return new PreExpression("pre_" + this.getName(), this);
    }

    @Override
    public boolean isAtom() {
        return true;
    }

    @Override
    protected void inferType() throws TypeException {
        // Noting to do, type defined by constructor
    }

    @Override
    public ClockList inferClock(final HashMap<String, Variable> env) throws ClockException {
        setClock(var.getClock().clone());
        return new ClockList();
    }

    @Override
    public void propagateClock(final ClockList l) {
        setClock(l.clone());
        Debug.low(getClock().toString() + " " + this.toString());
    }

    @Override
    public de.cau.cs.kieler.krep.compiler.ceq.Equation declock(final String basename,
            final int stage, final String c,
            final LinkedList<de.cau.cs.kieler.krep.compiler.ceq.Equation> aux, de.cau.cs.kieler.krep.compiler.ceq.Program prog) {
        return new de.cau.cs.kieler.krep.compiler.ceq.Equation(getName(),
                new de.cau.cs.kieler.krep.compiler.ceq.VarAccessExpression(
                        prog.getVar(var.getName()), false, prog));
    }

    @Override
    public Expression liftClock() {
        if (!getClock().isBase()) {
            return new WhenExpression(this.getName(), this, new VarAccessExpression(Variable
                    .get(getClock().getClock())));
        } else {
            return this;
        }
    }

    @Override
    public boolean equals(final Object o) {
        if (!(o instanceof VarAccessExpression)) {
            return false;
        }
        VarAccessExpression v = (VarAccessExpression) o;
        return v.var.equals(var);
    }

    @Override
    public Expression extractPre(final HashMap<String, Expression> eqs) {
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return super.hashCode();
    }
}

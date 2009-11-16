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
package de.cau.cs.kieler.krep.compiler.ceq;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

import de.cau.cs.kieler.krep.compiler.helper.Debug;
import de.cau.cs.kieler.krep.compiler.klp.instructions.Instruction;
import de.cau.cs.kieler.krep.compiler.klp.instructions.Mov;
import de.cau.cs.kieler.krep.compiler.klp.instructions.Read;

import de.cau.cs.kieler.krep.compiler.prog.Type;

//import klp.Register;

/**
 * @author ctr
 * 
 *         A Variable access in ceq. This includes the information, if the current or previous value
 *         is accessed
 */
public class VarAccess extends Expression {

    private Variable var;
    private int pre;

    /**
     * generate new Variable access.
     * 
     * @param v
     *            Variable that is read
     * @param previous
     *            access current or previous value
     */
    public VarAccess(final Variable v, final boolean previous) {
        super(v.getName());
        this.var = v;
        this.pre = previous ? 1 : 0;
    }

    @Override
    public List<String> getVars() {
        List<String> res = new ArrayList<String>();
        res.add(name);
        return res;
    }

    @Override
    public List<Variable> getDeps() {
        List<Variable> res = new ArrayList<Variable>();
        if (pre == 0) {
            res.add(Variable.get(name));
        }
        return res;
    }

    @Override
    public String toString() {
        String res = "";
        for (int i = 0; i < pre; i++) {
            res += "pre(";
        }
        res += name;
        for (int i = 0; i < pre; i++) {
            res += ")";
        }
        return res;
    }

    @Override
    public Expression flatten(final String name, final HashMap<String, Variable> vars,
            final LinkedList<Expression> es) {
        return this;
    }

    @Override
    public boolean isAtom() {
        return true;
    }

    @Override
    public LinkedList<Instruction> toKlp(final Variable to) {
        LinkedList<Instruction> instr = new LinkedList<Instruction>();
        instr.add(new Mov(to, new Read(this)));
        return instr;
    }

    /**
     * @return true if the previous value is used
     */
    public boolean isPre() {
        return pre != 0;
    }

    @Override
    public Type getType() {
        return var.getType();
    }

    @Override
    public Expression padDelay(final HashMap<String, Integer> delay, final int n) {
        int d = delay.get(var.getName());

        if (d != n) {
            // on different core
            pre += n - d - 1; // reader - writer - communication
        }
        /*
         * if(pre>0){ if(d == n+1){ pre=0; }else{ pre=n+1; }
         * 
         * }else{ pre=d-n; }
         */
        if (pre < 0) {
            System.err.println("try to access future value of " + name);
        }
        return this;
    }

    @Override
    public Const propagateConst(final HashMap<String, Const> con) {
        return con.get(name);
    }

    @Override
    public Expression staticEval() {
        return this;
    }

    @Override
    public void replaceVar(final HashMap<String, Variable> equiv) {
        Variable v = equiv.get(name);
        if (v != null) {
            var = v;
            this.name = v.getName();
        }

    }

    @Override
    public int wcrt() {
        return 1;
    }

    @Override
    public Expression replace(final String variable, final Expression expr) {
        if (variable.equals(name)) {
            if (isPre()) {
                Debug.high("try to replace pre access to " + variable);
            }
            return expr;
        } else {
            return this;
        }
    }
}

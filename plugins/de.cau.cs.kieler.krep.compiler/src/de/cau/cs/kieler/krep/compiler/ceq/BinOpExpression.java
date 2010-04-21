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

import de.cau.cs.kieler.krep.compiler.klp.AbstractInstruction;
import de.cau.cs.kieler.krep.compiler.klp.RegAccess;
import de.cau.cs.kieler.krep.compiler.lustre.Operator;
import de.cau.cs.kieler.krep.compiler.util.Debug;
import de.cau.cs.kieler.krep.compiler.util.Type;

/**
 * CEQ binary operations, this includes comparison, arithmetic and logical operators.
 * 
 * @kieler.rating 2010-02-05 yellow 
 *   review by cmot, msp, tam
 *   
 * @author ctr
 */
public class BinOpExpression extends Expression {
    private Expression e1, e2;

    private Operator op;

    /**
     * Generate binary operator.
     * 
     * @param name
     *            name of this expression
     * @param expr1
     *            first expression
     * @param expr2
     *            second expression
     * @param operator
     *            Operator
     * @param p program that contains the expression
     */
    public BinOpExpression(final String name, final Expression expr1, final Expression expr2,
            final Operator operator, final Program p) {
        super(name, p);
        this.e1 = expr1;
        this.e2 = expr2;
        this.op = operator;
    }

    @Override
    public List<String> getVars() {
        List<String> res = e1.getVars();
        res.addAll(e2.getVars());
        return res;
    }

    @Override
    public List<Variable> getDeps() {
        List<Variable> res = e1.getDeps();
        res.addAll(e2.getDeps());
        return res;
    }

    @Override
    public Expression flatten(final String name, final HashMap<String, Variable> vars,
            final LinkedList<Expression> es) {
        boolean atom1 = e1.isAtom();
        boolean atom2 = e2.isAtom();
        Debug.low("flatten: " + toString());
        if (!atom1) {
            Expression expr = e1.flatten(name, vars, es);
            Variable v = getProg().getTemp(name, e1.getType());
            vars.put(v.getName(), v);
            VarAccessExpression t = new VarAccessExpression(v, false, getProg());
            expr.setName(t.getName());
            Debug.low("flatten: " + expr.toString() + "->" + t.getName());
            es.add(expr);
            e1 = t;
        }
        if (!atom2) {
            Expression expr = e2.flatten(name, vars, es);
            Variable v = getProg().getTemp(name, e2.getType());
            vars.put(v.getName(), v);
            VarAccessExpression t = new VarAccessExpression(v, false, getProg());
            expr.setName(t.getName());
            es.add(expr);
            e2 = t;
        }
        if (!atom1) {
            getProg().destroyTemp(name);
        }
        if (!atom2) {
            getProg().destroyTemp(name);
        }
        return this;
    }

    @Override
    public boolean isAtom() {
        return false;
    }

    @Override
    public Type getType() {
        Type res = null;
        switch (op) {
        case AND:
        case OR:
        case XOR:
        case LT:
        case LE:
        case EQ:
        case GE:
        case GT:
        case NEQ:
        case IMPL:
            res = Type.BOOL;
            break;
        case ADD:
        case SUB:
        case MUL:
        case DIV:
        case MOD:
            res = Type.INT;
            break;
        }
        return res;
    }

    @Override
    public LinkedList<AbstractInstruction> toKlp(final Variable r) {
        LinkedList<AbstractInstruction> instr = new LinkedList<AbstractInstruction>();
        VarAccessExpression v1 = null, v2 = null;
        ConstExpression c1 = null, c2 = null;
        if (e1 instanceof VarAccessExpression) {
            v1 = (VarAccessExpression) e1;
        } else if (e1 instanceof ConstExpression) {
            c1 = (ConstExpression) e1;
        }
        if (e2 instanceof VarAccessExpression) {
            v2 = (VarAccessExpression) e2;
        } else if (e2 instanceof ConstExpression) {
            c2 = (ConstExpression) e2;
        }

        if (v1 != null && v2 != null) {
            instr.add(new de.cau.cs.kieler.krep.compiler.klp.BinOpInstruction(r, new RegAccess(v1),
                    new RegAccess(v2), op));
        } else if (v1 != null && c2 != null) {
            instr.add(new de.cau.cs.kieler.krep.compiler.klp.IBinOpInstruction(r, new RegAccess(v1),
                    c2.getVal(), op));
        } else if (c1 != null && v2 != null) {
            instr.add(new de.cau.cs.kieler.krep.compiler.klp.IMovInstruction(r, c1.getVal()));
            instr.add(new de.cau.cs.kieler.krep.compiler.klp.BinOpInstruction(r, new RegAccess(r,
                    false), new RegAccess(v2), op));
        } else if (v1 != null) {
            instr.addAll(e2.toKlp(r));
            instr.add(new de.cau.cs.kieler.krep.compiler.klp.BinOpInstruction(r, new RegAccess(v1),
                    new RegAccess(r, false), op));
        } else if (v2 != null) {
            instr.addAll(e1.toKlp(r));
            instr.add(new de.cau.cs.kieler.krep.compiler.klp.BinOpInstruction(r, new RegAccess(r,
                    false), new RegAccess(v2), op));
        } else if (c2 != null) {
            instr.addAll(e1.toKlp(r));
            instr.add(new de.cau.cs.kieler.krep.compiler.klp.IBinOpInstruction(r, new RegAccess(r,
                    false), c2.getVal(), op));
        } else {
            Variable var1 = getProg().getTemp(getName(), e1.getType());
            VarAccessExpression temp1 = new VarAccessExpression(var1, false, getProg());
            instr.addAll(e1.toKlp(var1));
            Variable var2 = getProg().getTemp(getName(), e2.getType());
            VarAccessExpression temp2 = new VarAccessExpression(var2, false, getProg());
            instr.addAll(e2.toKlp(var2));

            instr.add(new de.cau.cs.kieler.krep.compiler.klp.BinOpInstruction(r, new RegAccess(temp1),
                    new RegAccess(temp2), op));
            getProg().destroyTemp(getName());
            getProg().destroyTemp(getName());
        }
        return instr;
    }

    @Override
    public String toString() {
        return "(" + e1.toString() + " " + op.toString() + " " + e2.toString() + ")";
    }

    @Override
    public Expression padDelay(final HashMap<String, Integer> delay, final int n) {
        e1 = e1.padDelay(delay, n);
        e2 = e2.padDelay(delay, n);
        return this;
    }

    @Override
    public ConstExpression propagateConst(final HashMap<String, ConstExpression> con) {
        ConstExpression c1 = e1.propagateConst(con);
        ConstExpression c2 = e2.propagateConst(con);
        if (c1 != null) {
            e1 = c1;
        }
        if (c2 != null) {
            e2 = c2;
        }
        if (c1 != null && c2 != null) {
            return new ConstExpression(getName(), Operator.eval(c1.getVal(), c2.getVal(), op), getProg());
        }
        return null;

    }

    @Override
    public Expression staticEval() {
        Expression res;
        ConstExpression c1 = null;
        ConstExpression c2 = null;
        e1 = e1.staticEval();
        e2 = e2.staticEval();
        if (e1 instanceof ConstExpression) {
            c1 = (ConstExpression) e1;
        }
        if (e2 instanceof ConstExpression) {
            c2 = (ConstExpression) e2;
        }
        if (c1 != null && c2 != null) {
            return new ConstExpression(getName(), Operator.eval(c1.getVal(), c2.getVal(), op), getProg());
        } else if (c1 != null) {
            switch (op) {
            case ADD:
                if (c1.getVal() == 0) {
                    res = e2;
                } else {
                    res = this;
                }
                break;
            case AND:
                if (c1.getVal() == 0) {
                    res = c1;
                } else {
                    res = e2;
                }
                break;
            case OR:
                if (c1.getVal() == 0) {
                    res = e2;
                } else {
                    res = c1;
                }
                break;
            case XOR:
                if (c1.getVal() == 0) {
                    res = e2;
                } else {
                    res = this;
                }
                break;
            case IMPL:
                res = this;
                break;
            default:
                // SUB, MUL, DIV, MOD, LT, LE, EQ, GE, GT, NEQ;
                res = this;

            }
        } else if (c2 != null) {
            switch (op) {
            case ADD:
            case SUB:
                if (c2.getVal() == 0) {
                    res = e1;
                } else {
                    res = this;
                }
                break;
            case AND:
                if (c2.getVal() == 0) {
                    res = c2;
                } else {
                    res = e1;
                }
                break;
            case OR:
                if (c2.getVal() == 0) {
                    res = e1;
                } else {
                    res = c2;
                }
                break;
            case XOR:
                if (c2.getVal() == 0) {
                    res = e1;
                } else {
                    res = this;
                }
                break;
            case IMPL:
                res = this;
                break;
            default:
                // SUB, MUL, DIV, MOD, LT, LE, EQ, GE, GT, NEQ;
                res = this;

            }
        } else {
            res = this;
        }
        return res;
    }

    @Override
    public void replaceVar(final HashMap<String, Variable> equiv) {
        e1.replaceVar(equiv);
        e2.replaceVar(equiv);

    }

    @Override
    public int wcrt() {
        int res = 1;
        VarAccessExpression v1 = null, v2 = null;
        ConstExpression c1 = null, c2 = null;
        if (e1 instanceof VarAccessExpression) {
            v1 = (VarAccessExpression) e1;
        } else if (e1 instanceof ConstExpression) {
            c1 = (ConstExpression) e1;
        }
        if (e2 instanceof VarAccessExpression) {
            v2 = (VarAccessExpression) e2;
        } else if (e2 instanceof ConstExpression) {
            c2 = (ConstExpression) e2;
        }

        if (v1 != null && v2 != null) {
            res = 1;
        } else if (v1 != null && c2 != null) {
            res = 1;
        } else if (c1 != null && v2 != null) {
            res = 2;
        } else if (v1 != null) {
            res = e2.wcrt() + 1;
        } else if (v2 != null) {
            res = e1.wcrt() + 1;
        } else if (c2 != null) {
            res = e1.wcrt() + 1;
        } else {
            res = e1.wcrt() + e2.wcrt() + 1;
        }
        Debug.low("wcrt(" + toString() + ") = " + res);
        return res;
    }

    @Override
    public Expression replace(final String var, final Expression expr) {
        e1 = e1.replace(var, expr);
        e2 = e2.replace(var, expr);
        return this;
    }

}

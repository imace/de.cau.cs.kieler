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

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map.Entry;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;

import de.cau.cs.kieler.krep.compiler.ceq.Variable.Kind;
import de.cau.cs.kieler.krep.compiler.exceptions.ClockException;
import de.cau.cs.kieler.krep.compiler.exceptions.TypeException;
import de.cau.cs.kieler.krep.compiler.helper.Debug;
import de.cau.cs.kieler.krep.compiler.parser.lustreLexer;
import de.cau.cs.kieler.krep.compiler.parser.lustreParser;

/**
 * Container class to hold parsed lustre or ec file. Contains methods for type and clock inference.
 * 
 * @kieler.rating 2010-01-05 proposed yellow ctr
 * 
 * @author ctr
 * 
 */
public class Lustre {

    private String name;

    private HashMap<String, Expression> eqs = new HashMap<String, Expression>();

    private HashMap<String, Variable> vars = new HashMap<String, Variable>();

    private LinkedList<Variable> input = new LinkedList<Variable>();

    private LinkedList<Variable> output = new LinkedList<Variable>();

    private LinkedList<Variable> local = new LinkedList<Variable>();

    /**
     * parse input stream which is expected to be a Lustre file.
     * 
     * @param in
     *            the Lustre program
     * @throws IOException
     *             thrown when the input stream cannot be read
     * @throws ClockException
     *             thrown when errors with the clock calculus
     * @throws TypeException
     *             thrown when errors are detected in the type inference
     */
    public Lustre(final InputStream in) throws IOException, ClockException, TypeException {
        super();

        lustreLexer lex = new lustreLexer(new ANTLRInputStream(in));
        CommonTokenStream tokens = new CommonTokenStream(lex);

        lustreParser parser = new lustreParser(tokens);

        try {
            parser.setProg(this);
            parser.prog();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Debug.low("Lift clocks:");
        for (Entry<String, Expression> eq : eqs.entrySet()) {
            String id = eq.getKey();
            Expression expr = eq.getValue();

            eqs.put(id, expr.liftClock());
        }
        Debug.low(toLustre());
        Debug.low("Infer types and clocks:");
        for (Entry<String, Expression> e : eqs.entrySet()) {
            Debug.low(e.toString());
            try {
                e.getValue().inferType();
                e.getValue().inferClock(vars);
                e.getValue().propagateClock(new ClockList());
            } catch (TypeException e1) {
                e1.printStackTrace();
            }
        }

        Debug.low("extract pre expressions");
        HashMap<String, Expression> aux = new HashMap<String, Expression>();
        for (Entry<String, Expression> e : eqs.entrySet()) {
            e.getValue().extractPre(aux);
        }
        eqs.putAll(aux);
        for (Entry<String, Expression> e : aux.entrySet()) {
            local.add(Variable.get(e.getKey()));
        }
    }

    /**
     * Transform Lustre program into simplified ceq.
     * 
     * @return the simplified program
     */
    public de.cau.cs.kieler.krep.compiler.ceq.Program getCEQ() {
        de.cau.cs.kieler.krep.compiler.ceq.Program res = new de.cau.cs.kieler.krep.compiler.ceq.Program(
                name);

        // copy variable declarations
        for (Variable v : input) {
            res.addVar(new de.cau.cs.kieler.krep.compiler.ceq.Variable(v, Kind.INPUT));
        }
        for (Variable v : output) {
            res.addVar(new de.cau.cs.kieler.krep.compiler.ceq.Variable(v, Kind.OUTPUT));
        }
        for (Variable v : local) {
            res.addVar(new de.cau.cs.kieler.krep.compiler.ceq.Variable(v, Kind.LOCAL));
        }

        // copy eqs
        for (Entry<String, Expression> e : eqs.entrySet()) {
            LinkedList<de.cau.cs.kieler.krep.compiler.ceq.Equation> aux = new LinkedList<de.cau.cs.kieler.krep.compiler.ceq.Equation>();
            Expression expr = e.getValue();
            de.cau.cs.kieler.krep.compiler.ceq.Equation eq = expr.declock(e.getKey(), 0, null, aux);
            eq.setName(e.getKey());
            res.addEq(eq);

            for (de.cau.cs.kieler.krep.compiler.ceq.Equation a : aux) {
                res.addVar(de.cau.cs.kieler.krep.compiler.ceq.Variable.get(a.getName()));
                res.addEq(a);
            }

        }
        res.init();
        return res;
    }

    /**
     * @param s
     *            name of the additional equation
     * @param e
     *            expression to compute the value
     */
    public void addEq(final String s, final Expression e) {
        eqs.put(s, e);
    }

    /**
     * @param in
     *            new input list
     */
    public void setInputs(final LinkedList<de.cau.cs.kieler.krep.compiler.lustre.Variable> in) {
        this.input = in;
        for (Variable v : in) {
            vars.put(v.getName(), v);
        }
    }

    /**
     * @param out
     *            new output list
     */
    public void setOutputs(final LinkedList<de.cau.cs.kieler.krep.compiler.lustre.Variable> out) {
        this.output = out;
        for (Variable v : out) {
            vars.put(v.getName(), v);
        }
    }

    /**
     * @param loc
     *            list of local variables
     */
    public void setLocals(final LinkedList<de.cau.cs.kieler.krep.compiler.lustre.Variable> loc) {
        this.local = loc;
        for (Variable v : loc) {
            vars.put(v.getName(), v);
        }
    }

    /**
     * @return write program in Lustre syntax
     */
    public String toLustre() {
        StringBuffer res = new StringBuffer("node " + name + "(");
        for (Variable v : input) {
            res.append(v.getName() + ":" + v.getType() + ";");
        }
        res.append(") returns (");
        for (Variable v : output) {
            res.append(v.getName() + ":" + v.getType() + ";");
        }
        res.append(");\n");

        for (Variable v : local) {
            res.append("  " + v.getName() + ":" + v.getType() + ";\n");
        }
        res.append("let\n");

        for (Entry<String, Expression> e : eqs.entrySet()) {
            res.append("  " + e.getKey() + " = " + e.getValue().toString() + ";\n");
        }
        res.append("tel\n");
        return res.toString();
    }

    /**
     * @param n
     *            name of the program
     */
    public void setName(final String n) {
        this.name = n;
    }

}

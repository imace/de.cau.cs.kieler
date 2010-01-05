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

import java.util.Date;
import java.util.LinkedList;

import de.cau.cs.kieler.krep.compiler.ceq.Automaton;
import de.cau.cs.kieler.krep.compiler.ceq.Equation;
import de.cau.cs.kieler.krep.compiler.ceq.Program;
import de.cau.cs.kieler.krep.compiler.ceq.Variable;
import de.cau.cs.kieler.krep.compiler.ceq.Variable.Kind;
import de.cau.cs.kieler.krep.compiler.helper.Debug;
import de.cau.cs.kieler.krep.compiler.klp.instructions.DeclareReg;
import de.cau.cs.kieler.krep.compiler.klp.instructions.Done;
import de.cau.cs.kieler.krep.compiler.klp.instructions.InitReg;
import de.cau.cs.kieler.krep.compiler.klp.instructions.Instruction;
import de.cau.cs.kieler.krep.compiler.klp.instructions.Label;
import de.cau.cs.kieler.krep.compiler.klp.instructions.Prio;

/**
 * Klp assembler, extends a program by the compiler from CEQs into actual klp assembler.
 * 
 * @kieler.rating 2010-01-05 proposed yellow ctr
 * 
 * @author ctr Klp Assembler
 */
public class Klp extends Program {

    private boolean useClocks;

    /**
     * Number of input output registers.
     */
    public static final int N_IO = 4;

    /**
     * Number of full local registers.
     */
    public static final int N_LOCAL = 4;

    /**
     * Number of temporary registers.
     */
    public static final int N_TEMP = 4;

    private LinkedList<Instruction> instr = new LinkedList<Instruction>();

    /**
     * @param name
     *            name of the main node
     */
    public Klp(final String name) {
        super(name);
    }

    /**
     * Generate a new program from an existing one.
     * 
     * @param name
     *            of the program
     * @param p
     *            the program
     */
    public Klp(final String name, final Program p) {
        super(name, p);
    }

    /**
     * generate KLP instructions for all equations.
     * 
     * @param useHWClocks
     *            use hardware clocks, if false, a software test for clocks is generated
     * @param scope
     *            scope, if the equations is in a state
     * @return klp instructions that implement the program
     */
    public LinkedList<Instruction> compile(final boolean useHWClocks, final String scope) {
        this.useClocks = useHWClocks;
        init();

        // compute priorities
        for (Equation e : getEqs()) {
            e.setPrio(getDepGraph().getPrio(e.getName()));
        }

        int j = 0;
        for (Variable v : getVars().values()) {
            if (v.getKind() != Kind.TEMP) {
                j++;
            }
        }

        j++;
        for (Equation e : getEqs()) {
            Label l = Label.get(e.getName() + "_run" + scope);

            // if(!useClocks && e.hasClock()){
            // done = Label.get(e.getName() + "_done" + scope);
            // instr.add(new CJmp(CJmp.Cond.F, new Read(Variable.get(e.getClock()),false), done));
            // }
            instr.addAll(e.toKlp(useHWClocks, scope, getVars()));
            // if(!useClocks && e.hasClock()){
            // instr.add(done);
            // }
            instr.add(new Done(l));
        }

        for (Automaton a : getSsms()) {
            instr.addAll(a.compile(getDepGraph().getPrio(a.getName())));

        }
        return instr;
    }

    @Override
    public String toString() {
        StringBuffer res = new StringBuffer("# " + getName() + "\n");
        res.append("# compiled: " + new Date().toString() + "\n");
        // Initialize
        res.append("START:\n");
        for (Instruction i : compileInit(useClocks, "", true, true, 0)) {
            res.append(i.toString() + "\n");
        }

        // for(Automaton a: ssms){
        // res += a.getKlpHeader();
        // }

        // Running
        res.append("\n");
        res.append("  DONE START\n\n");

        for (Instruction i : instr) {
            res.append(i.toString() + i.getComment() + "\n");
        }

        return res.toString();
    }

    /**
     * @return number of instructions
     */
    public int nInstr() {
        return instr.size();
    }

    /**
     * @return number of clocked equations
     */
    public int nEq() {
        return getEqs().size();
    }

    /**
     * @return dot description of the dependency graph
     */
    public String toDot() {
        return getDepGraph().toDot(true);
    }

    /**
     * @param useHWClocks should the hw clocks of the klp be used?
     * @param scope scope of this program, if it is inside of an automaton
     * @param setInputs should inputs be initialized (for initial states)
     * @param setOutputs should outputs be initialized (for initial states)
     * @param prioOffset minimal priority to use
     * @return klp code to initialize the registers 
     */
    public LinkedList<Instruction> compileInit(final boolean useHWClocks, final String scope,
            final boolean setInputs, final boolean setOutputs, final int prioOffset) {
        LinkedList<Instruction> res = new LinkedList<Instruction>();
        if (setInputs) {
            for (Variable v : getInputs()) {
                res.add(new DeclareReg(v.getName(), Kind.INPUT));
            }
        }
        for (Equation e : getEqs()) {
            String clock = e.getClock();
            Variable v = getVars().get(e.getName());
            if (v == null) {
                Debug.high("unknown equation " + e.getName());
            } else {
                if (setOutputs) {
                    res.add(new DeclareReg(v.getName(), v.getKind()));
                }
                res.add(new InitReg(v.getName(), v.getKind(), v.getName() + scope,
                        useHWClocks ? clock : null));
                res.add(new Prio(v.getName(), prioOffset + e.getPrio()));
            }
        }

        for (Automaton ssm : getSsms()) {
            res.addAll(ssm.compileInit(setInputs, setOutputs, getDepGraph().getPrio(ssm.getName())));
        }

        return res;
    }

    /**
     * @return number of totally used registers
     */
    public int nReg() {
        return Variable.getMax();
    }

}

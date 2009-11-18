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

import java.util.LinkedList;

/**
 * @author ctr
 * Scope of a program. This is either  a complete program or a state.
 */
public interface Scope {

    /**
     * @param vars local variables
     */
    void add(LinkedList<Variable> vars);

    /**
     * @param ssm additional automaton
     */
    void add(Automaton ssm);

    /**
     * @param eq additional equation.
     */
    void add(Equation eq);

    /**
     * @param eq additional equations.
     */
    void addEq(LinkedList<Equation> eq);

}

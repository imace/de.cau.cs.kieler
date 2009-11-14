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
package de.cau.cs.kieler.krep.compiler.dependencies;

/**
 * @author ctr edge in the dependency graph
 */
public class Edge {

    private Node n;
    private int delay;

    /**
     * @param n
     * @param delay
     *            of this dependency
     */
    public Edge(final Node n, final int delay) {
        super();
        this.n = n;
        this.delay = delay;
    }

    /**
     * @return delay of this dependency
     */
    public int getDelay() {
        return delay;
    }

    /**
     * @return corresponding node
     */
    public Node getNode() {
        return n;
    }

    public String toString() {
        return "->" + n;
    }
}

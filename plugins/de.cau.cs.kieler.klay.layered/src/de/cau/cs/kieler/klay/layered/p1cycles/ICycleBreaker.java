/*
 * KIELER - Kiel Integrated Environment for Layout Eclipse RichClient
 *
 * http://www.informatik.uni-kiel.de/rtsys/kieler/
 * 
 * Copyright 2010 by
 * + Christian-Albrechts-University of Kiel
 *   + Department of Computer Science
 *     + Real-Time and Embedded Systems Group
 * 
 * This code is provided under the terms of the Eclipse Public License (EPL).
 * See the file epl-v10.html for the license text.
 */
package de.cau.cs.kieler.klay.layered.p1cycles;

import java.util.Collection;

import de.cau.cs.kieler.core.alg.IAlgorithm;
import de.cau.cs.kieler.klay.layered.graph.LNode;

//CHECKSTYLEOFF JavadocStyle

/**
 * Interface for cycle breaker modules.
 * <dl>
 *   <dt>Precondition:</dt><dd>none</dd>
 *   <dt>Postcondition:</dt><dd>the graph has no cycles, but possibly
 *     new nodes and edges</dd>
 * </dl>
 *
 * @author msp
 */
public interface ICycleBreaker extends IAlgorithm {

    /**
     * Break cycles in the given collection of nodes. For this purpose some
     * edges may be reversed, and new dummy nodes may be created.
     * 
     * @param nodes a collection of nodes
     */
    void breakCycles(Collection<LNode> nodes);
    
}
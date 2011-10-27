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
package de.cau.cs.kieler.klay.layered.p3order;

import java.util.List;
import java.util.Map;

import com.google.common.collect.Multimap;

import de.cau.cs.kieler.klay.layered.graph.LNode;

/**
 * Determines the node order of a given free layer. Uses heuristic methods to find an ordering that
 * minimizes edge crossings between the given free layer and a neighboring layer with fixed node
 * order. Given constraints are to be respected, possibly by the use of an IConstraintResolver.
 * Port ranks are calculated with the help of a IPortDistributor.
 * 
 * @author msp
 * @author cds
 * @author ima
 */
public interface ICrossingMinimizationHeuristic {

    /**
     * Minimize the number of crossings for the edges between the given layer and either its
     * predecessor or its successor. Resolve violated constraints. Calculate Port Ranks.
     * 
     * @param layer
     *            the free layer whose nodes are reordered.
     * @param layoutUnits
     *            a map associating layout units with their respective members.
     * @param layerIndex
     *            the free layer's index.
     * @param preOrdered
     *            whether the nodes have been ordered in a previous run.
     * @param randomize
     *            {@code true} if this layer's node order should just be randomized. In that case,
     *            {@code preOrdered} is assumed to be {@code false} and the return value is
     *            {@code 0}.
     * @param forward
     *            whether the free layer is after the fixed layer.
     * @param portPos
     *            position array.
     * @param singleNodeNodeGroups
     *            Map of single node vertices for each layer.
     * @return the total number of edges going either in or out of the given layer.
     */
    int minimizeCrossings(final List<NodeGroup> layer, Multimap<LNode, LNode> layoutUnits,
            final int layerIndex, final boolean preOrdered, final boolean randomize,
            boolean forward, final float[] portPos, final Map<LNode, NodeGroup>[] singleNodeNodeGroups);

}

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
package de.cau.cs.kieler.klay.layered.intermediate;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

import de.cau.cs.kieler.core.kgraph.KNode;
import de.cau.cs.kieler.core.alg.AbstractAlgorithm;
import de.cau.cs.kieler.klay.layered.ILayoutProcessor;
import de.cau.cs.kieler.klay.layered.graph.LNode;
import de.cau.cs.kieler.klay.layered.graph.LPort;
import de.cau.cs.kieler.klay.layered.graph.LayeredGraph;
import de.cau.cs.kieler.klay.layered.graph.LEdge;
import de.cau.cs.kieler.klay.layered.properties.EdgeType;
import de.cau.cs.kieler.klay.layered.properties.Properties;

/**
 * Detects cyclic dependencies between compound nodes and reverts edges to remove them before simple
 * cycle removal and layering. Two compound nodes are regarded to be in cyclic dependency, if there
 * are cyclic adjacencies between the compound nodes themselves or between any two of their
 * descendants or between one of the compound nodes and any descendant of the other.
 * 
 * <dl>
 * <dt>Precondition:</dt>
 * <dd>A layered graph. All nodes have the ORIGIN-Property set to the KNode in the original graph
 * that is represented by them.</dd>
 * <dt>Postcondition:</dt>
 * <dd>The layered graph contains no more cyclic dependencies.</dd>
 * <dt>Slots:</dt>
 * <dd>Before phase 1.</dd>
 * <dt>Same-slot dependencies:</dt>
 * <dd>none.</dd>
 * </dl>
 * 
 * @author ima
 */
public class CompoundCyclePreprocessor extends AbstractAlgorithm implements ILayoutProcessor {

    /**
     * {@inheritDoc}
     */
    public void process(final LayeredGraph layeredGraph) {
        getMonitor().begin("Revert edges to remove cyclic dependencies between compound nodes", 1);

        // Initialize a hashmap in which edgeLists for a pair of KNodes can be stored. Pairs are
        // represented as LinkedLists to allow expressing edge directions.
        HashMap<LinkedList<KNode>, LinkedList<LEdge>> hierarchyCrossingEdges 
                = new HashMap<LinkedList<KNode>, LinkedList<LEdge>>();
        // Initialize a hashset in which the pairs of KNodes with adjacency relations can be stored.
        HashSet<LinkedList<KNode>> nodePairs = new HashSet<LinkedList<KNode>>();

        // For each edge crossing the borders of a compound node, make an insertion into the
        // corresponding List in the Hashmap. To find the Pair of KNodes that is the correct key,
        // walk up the nesting tree of the compound graph until a pair of ancestors is found that
        // shares the same parent.
        for (LNode lnode : layeredGraph.getLayerlessNodes()) {
            for (LEdge edge : lnode.getOutgoingEdges()) {

                // only normal edges need to be regarded
                EdgeType edgeType = edge.getProperty(Properties.EDGE_TYPE);
                if (edgeType == EdgeType.NORMAL) {

                    KNode sourceOriginal = (KNode) edge.getSource().getNode()
                            .getProperty(Properties.ORIGIN);
                    KNode targetOriginal = (KNode) edge.getTarget().getNode()
                            .getProperty(Properties.ORIGIN);
                    KNode sourceOriginalParent = sourceOriginal.getParent();
                    KNode targetOriginalParent = targetOriginal.getParent();
                    KNode currentSourceAncestor = sourceOriginalParent;
                    KNode currentTargetAncestor = targetOriginalParent;
                    KNode currentSource = sourceOriginal;
                    KNode currentTarget = targetOriginal;

                    // Establishes the edge an adjacency of two compound nodes (source and target
                    // are one of the compound nodes or any of it's descendants)?
                    if ((currentSourceAncestor != currentTargetAncestor)
                            || ((!sourceOriginal.getChildren().isEmpty()) && (!targetOriginal
                                    .getChildren().isEmpty()))) {

                        KNode layoutNode = (KNode) layeredGraph.getProperty(Properties.ORIGIN);
                        int depthSource = getDepth(currentSource, layoutNode);
                        int depthTarget = getDepth(currentTarget, layoutNode);

                        // If source and target differ in depth in the nesting tree, crawl up the
                        // nesting tree on the deep side to reach even depth level
                        if (depthSource != depthTarget) {
                            for (int i = depthSource; i > depthTarget; i--) {
                                currentSource = currentSource.getParent();
                            }
                            for (int j = depthTarget; j > depthSource; j--) {
                                currentTarget = currentTarget.getParent();
                            }
                        }
                        
                        // Walk up the nesting tree from both sides, until nodes have the same
                        // parent.
                        currentSourceAncestor = currentSource.getParent();
                        currentTargetAncestor = currentTarget.getParent();
                        while (currentSourceAncestor != currentTargetAncestor) {
                            currentSource = currentSource.getParent();
                            currentTarget = currentTarget.getParent();
                            currentSourceAncestor = currentSource.getParent();
                            currentTargetAncestor = currentTarget.getParent();
                        }

                        // Make the entrys to the HashMap and HashSet. Create the tuple that is
                        // to
                        // be the key and
                        // find the corresponding List. If no list is stored yet, create one.
                        // Store
                        // the pair of nodes in the HashSet for later iteration.
                        LinkedList<KNode> keyTuple = new LinkedList<KNode>();
                        keyTuple.add(currentSource);
                        keyTuple.add(currentTarget);
                        LinkedList<KNode> reverseTuple = new LinkedList<KNode>();
                        reverseTuple.add(currentTarget);
                        reverseTuple.add(currentSource);
                        if (hierarchyCrossingEdges.containsKey(keyTuple)) {
                            hierarchyCrossingEdges.get(keyTuple).add(edge);
                        } else {
                            LinkedList<LEdge> newList = new LinkedList<LEdge>();
                            newList.add(edge);
                            hierarchyCrossingEdges.put(keyTuple, newList);
                        }
                        // An entry to the HashSet is needed only, when the pair of Nodes is not
                        // entered in any order.
                        if (!nodePairs.contains(keyTuple)) {
                            if (!nodePairs.contains(reverseTuple)) {
                                nodePairs.add(keyTuple);
                            }
                        }

                    }
                }
            }
        }
        HashSet<LEdge> revertedEdges = revertCyclicEdges(hierarchyCrossingEdges, nodePairs);
        layeredGraph.setProperty(Properties.REVERTED_COMPOUND_EDGES, revertedEdges);

        getMonitor().done();
    }

    /**
     * Removes cyclic dependencies between compound nodes by reverting edges.
     * 
     * @param hierarchyCrossingEdges
     *            HashMap that contains lists of edges that constitute a dependency between two
     *            compound nodes. The pairs of nodes serve as keys. They are represented by
     *            LinkedLists with two KNode-Elements.
     * @param nodePairs
     * @return Returns a set that contains the reverted edges.
     */
    private HashSet<LEdge> revertCyclicEdges(
            final HashMap<LinkedList<KNode>, LinkedList<LEdge>> hierarchyCrossingEdges,
            final HashSet<LinkedList<KNode>> nodePairs) {
        HashSet<LEdge> revertedEdges = null;
        for (LinkedList<KNode> nodePair : nodePairs) {
            // Get the edge list of one direction.
            LinkedList<LEdge> toEdges = hierarchyCrossingEdges.get(nodePair);

            // Get the edge list of the other direction.
            LinkedList<KNode> reverseTuple = new LinkedList<KNode>();
            reverseTuple.add(nodePair.getLast());
            reverseTuple.add(nodePair.getFirst());
            LinkedList<LEdge> froEdges = hierarchyCrossingEdges.get(reverseTuple);

            // Check, if there is a cyclic dependency.
            if (!(toEdges == null || froEdges == null)) {
                // If yes: revert all edges of the smaller list, if the lists are equally sized,
                // revert
                // edges of froEdges. If not: nothing to be done.
                int difference = toEdges.size() - froEdges.size();
                if (difference < 0) {
                    revertedEdges = revertEdges(toEdges);
                } else {
                    revertedEdges = revertEdges(froEdges);
                }
            }
        }
        return revertedEdges;
    }

    /**
     * Reverts edges of a given list of edges.
     * 
     * @param edgeList
     *            The list of edges to be reverted.
     * @return
     */
    private HashSet<LEdge> revertEdges(final LinkedList<LEdge> edgeList) {
        HashSet<LEdge> revertedEdges = new HashSet<LEdge>();
        for (int i = 0; i < edgeList.size(); i++) {
            LEdge edge = edgeList.get(i);
            LPort source = edge.getSource();
            edge.setSource(edge.getTarget());
            edge.setTarget(source);
            revertedEdges.add(edge);
        }
        return revertedEdges;
    }

    /**
     * Returns the depth of the given KNode in the nesting tree of the compound graph.
     * 
     * @param knode
     *            The KNode, whose depth is to be calculated.
     * @param layoutNode
     *            The layoutNode of the original graph.
     * @return The depth of the KNode. The layoutNode is regarded to have depth 0.
     */
    private int getDepth(final KNode knode, final KNode layoutNode) {
        int ret = 0;
        if (knode != layoutNode) {
            ret = 1;
            KNode currentAncestor = knode.getParent();
            while (currentAncestor != layoutNode) {
                ret += 1;
                currentAncestor = currentAncestor.getParent();
            }
        }
        return ret;
    }
}

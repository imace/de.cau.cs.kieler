/*
 * KIELER - Kiel Integrated Environment for Layout Eclipse RichClient
 *
 * http://www.informatik.uni-kiel.de/rtsys/kieler/
 * 
 * Copyright 2012 by
 * + Christian-Albrechts-University of Kiel
 *   + Department of Computer Science
 *     + Real-Time and Embedded Systems Group
 * 
 * This code is provided under the terms of the Eclipse Public License (EPL).
 * See the file epl-v10.html for the license text.
 */
package de.cau.cs.kieler.kiml.grana.analyses;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.google.common.collect.Iterables;

import de.cau.cs.kieler.core.alg.IKielerProgressMonitor;
import de.cau.cs.kieler.core.kgraph.KEdge;
import de.cau.cs.kieler.core.kgraph.KNode;
import de.cau.cs.kieler.kiml.grana.IAnalysis;

/**
 * Analysis for approximate cycle count, that is the number of back edges determined by a
 * heuristic that tries to minimize back edges.
 *
 * @author msp
 */
public class CycleAnalysis implements IAnalysis {

    /** indegree values for the nodes. */
    private int[] indeg;
    /** outdegree values for the nodes. */
    private int[] outdeg;
    /** mark for the nodes. */
    private int[] mark;
    /** node id map. */
    private Map<KNode, Integer> idmap = new HashMap<KNode, Integer>();
    /** list of source nodes. */
    private final LinkedList<KNode> sources = new LinkedList<KNode>();
    /** list of sink nodes. */
    private final LinkedList<KNode> sinks = new LinkedList<KNode>();
    
    /**
     * {@inheritDoc}
     */
    public Object doAnalysis(final KNode parentNode, final Map<String, Object> results,
            final IKielerProgressMonitor progressMonitor) {
        progressMonitor.begin("Approximate cycle count", 1);
        
        // initialize values for the algorithm (sum of priorities of incoming edges and outgoing
        // edges per node, and the "layer" calculated for each node)
        int unprocessedNodes = parentNode.getChildren().size();
        indeg = new int[unprocessedNodes];
        outdeg = new int[unprocessedNodes];
        mark = new int[unprocessedNodes];
        
        // iterate over all nodes, ...
        int index = 0;
        for (KNode node : parentNode.getChildren()) {
            idmap.put(node, index);
            // calculate the sum of edge priorities
            for (KEdge edge : node.getIncomingEdges()) {
                // ignore self-loops
                if (edge.getSource() == node) {
                    continue;
                }
                indeg[index]++;
            }
            
            for (KEdge edge : node.getOutgoingEdges()) {
                // ignore self-loops
                if (edge.getTarget() == node) {
                    continue;
                }
                outdeg[index]++;
            }
            
            // collect sources and sinks
            if (outdeg[index] == 0) {
                sinks.add(node);
            } else if (indeg[index] == 0) {
                sources.add(node);
            }
            index++;
        }
        
        // next rank values used for sinks and sources (from right and from left)
        int nextRight = -1, nextLeft = 1;
        
        // create random number generator
        Random random = new Random(1);

        // assign marks to all nodes
        List<KNode> maxNodes = new ArrayList<KNode>();
        
        while (unprocessedNodes > 0) {
            // while we have sinks left...
            while (!sinks.isEmpty()) {
                KNode sink = sinks.removeFirst();
                mark[idmap.get(sink)] = nextRight--;
                updateNeighbors(sink);
                unprocessedNodes--;
            }
            
            // while we have sources left...
            while (!sources.isEmpty()) {
                KNode source = sources.removeFirst();
                mark[idmap.get(source)] = nextLeft++;
                updateNeighbors(source);
                unprocessedNodes--;
            }
            
            // while there are unprocessed nodes left that are neither sinks nor sources...
            if (unprocessedNodes > 0) {
                int maxOutflow = Integer.MIN_VALUE;
                
                // find the set of unprocessed node (=> mark == 0), with the largest out flow
                for (KNode node : parentNode.getChildren()) {
                    int id = idmap.get(node);
                    if (mark[id] == 0) {
                        int outflow = outdeg[id] - indeg[id];
                        if (outflow >= maxOutflow) {
                            if (outflow > maxOutflow) {
                                maxNodes.clear();
                                maxOutflow = outflow;
                            }
                            maxNodes.add(node);
                        }
                    }
                }
                
                // randomly select a node from the ones with maximal outflow
                KNode maxNode = maxNodes.get(random.nextInt(maxNodes.size()));
                mark[idmap.get(maxNode)] = nextLeft++;
                updateNeighbors(maxNode);
                unprocessedNodes--;
            }
        }

        // shift negative ranks
        int shiftBase = parentNode.getChildren().size() + 1;
        for (index = 0; index < parentNode.getChildren().size(); index++) {
            if (mark[index] < 0) {
                mark[index] += shiftBase;
            }
        }

        // count edges that point left
        int backEdgeCount = 0;
        for (KNode node : parentNode.getChildren()) {
            int sourceIx = idmap.get(node);
            // look at the node's outgoing edges
            for (KEdge edge : node.getOutgoingEdges()) {
                int targetIx = idmap.get(edge.getTarget());
                if (mark[sourceIx] > mark[targetIx]) {
                    backEdgeCount++;
                }
            }
        }

        dispose();
        progressMonitor.done();
        return backEdgeCount;
    }
    
    /**
     * Release all created resources so the GC can reap them.
     */
    private void dispose() {
        this.indeg = null;
        this.outdeg = null;
        this.mark = null;
        sources.clear();
        sinks.clear();
    }

    /**
     * Updates indegree and outdegree values of the neighbors of the given node,
     * simulating its removal from the graph. the sources and sinks lists are
     * also updated.
     * 
     * @param node node for which neighbors are updated
     */
    private void updateNeighbors(final KNode node) {
        for (KEdge edge : Iterables.concat(node.getOutgoingEdges(), node.getIncomingEdges())) {
            KNode endpoint = edge.getSource() == node ? edge.getTarget() : edge.getSource();
            
            // exclude self-loops
            if (node == endpoint) {
                continue;
            }
            
            int index = idmap.get(endpoint);
            if (mark[index] == 0) {
                if (edge.getTarget() == endpoint) {
                    indeg[index]--;
                    if (indeg[index] <= 0 && outdeg[index] > 0) {
                        sources.add(endpoint);
                    }
                } else {
                    outdeg[index]--;
                    if (outdeg[index] <= 0 && indeg[index] > 0) {
                        sinks.add(endpoint);
                    }
                }
            }
        }
    }

}

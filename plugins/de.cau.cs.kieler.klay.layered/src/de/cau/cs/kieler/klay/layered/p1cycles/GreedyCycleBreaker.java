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
import java.util.EnumSet;
import java.util.LinkedList;

import de.cau.cs.kieler.core.alg.AbstractAlgorithm;
import de.cau.cs.kieler.klay.layered.ILayoutPhase;
import de.cau.cs.kieler.klay.layered.IntermediateProcessingStrategy;
import de.cau.cs.kieler.klay.layered.Properties;
import de.cau.cs.kieler.klay.layered.graph.LEdge;
import de.cau.cs.kieler.klay.layered.graph.LNode;
import de.cau.cs.kieler.klay.layered.graph.LPort;
import de.cau.cs.kieler.klay.layered.graph.LayeredGraph;
import de.cau.cs.kieler.klay.layered.intermediate.IntermediateLayoutProcessor;
import de.cau.cs.kieler.klay.layered.p2layers.LayerConstraint;

/**
 * Cycle breaker implementation that uses a greedy algorithm. Inspired by Section 9.4 of
 * <ul>
 *   <li>Giuseppe di Battista, Peter Eades, Roberto Tamassia, Ioannis G. Tollis,
 *     <i>Graph Drawing: Algorithms for the Visualization of Graphs</i>,
 *     Prentice Hall, New Jersey, 1999
 * </ul>
 * 
 * <dl>
 *   <dt>Precondition:</dt><dd>none</dd>
 *   <dt>Postcondition:</dt><dd>the graph has no cycles, but possibly
 *     new nodes and edges</dd>
 * </dl>
 *
 * @author msp
 */
public class GreedyCycleBreaker extends AbstractAlgorithm implements ILayoutPhase {
    
    /** intermediate processing strategy. */
    private static final IntermediateProcessingStrategy INTERMEDIATE_PROCESSING_STRATEGY =
        new IntermediateProcessingStrategy(
                IntermediateProcessingStrategy.AFTER_PHASE_5,
                EnumSet.of(IntermediateLayoutProcessor.REVERSED_EDGE_RESTORER));

    /** indegree values for the nodes. */
    private int[] indeg;
    /** outdegree values for the nodes. */
    private int[] outdeg;
    /** mark for the nodes. */
    private int[] mark;
    /** list of source nodes. */
    private final LinkedList<LNode> sources = new LinkedList<LNode>();
    /** list of sink nodes. */
    private final LinkedList<LNode> sinks = new LinkedList<LNode>();
    
    /**
     * {@inheritDoc}
     */
    public IntermediateProcessingStrategy getIntermediateProcessingStrategy(final LayeredGraph graph) {
        return INTERMEDIATE_PROCESSING_STRATEGY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void reset() {
        super.reset();
        sources.clear();
        sinks.clear();
    }

    /**
     * {@inheritDoc}
     */
    public void process(final LayeredGraph layeredGraph) {
        getMonitor().begin("Greedy cycle removal", 1);
        
        Collection<LNode> nodes = layeredGraph.getLayerlessNodes();

        // initialize values for the algorithm
        int unprocessedNodes = nodes.size();
        indeg = new int[unprocessedNodes];
        outdeg = new int[unprocessedNodes];
        mark = new int[unprocessedNodes];
        int nextRight = -1, nextLeft = 1, index = 0;
        for (LNode node : nodes) {
            node.id = index;
            for (LPort port : node.getPorts()) {
                for (LEdge edge : port.getIncomingEdges()) {
                    int priority = edge.getProperty(Properties.PRIORITY);
                    indeg[index] += priority > 0 ? priority + 1 : 1;
                }
                
                for (LEdge edge : port.getOutgoingEdges()) {
                    int priority = edge.getProperty(Properties.PRIORITY);
                    outdeg[index] += priority > 0 ? priority + 1 : 1;
                }
            }
            LayerConstraint constraint = node.getProperty(Properties.LAYER_CONSTRAINT);
            if (outdeg[index] == 0 || constraint == LayerConstraint.LAST) {
                sinks.add(node);
            } else if (indeg[index] == 0 || constraint == LayerConstraint.FIRST) {
                sources.add(node);
            }
            index++;
        }

        // assign marks to all nodes
        while (unprocessedNodes > 0) {
            while (!sinks.isEmpty()) {
                LNode sink = sinks.removeFirst();
                mark[sink.id] = nextRight--;
                updateNeighbors(sink);
                unprocessedNodes--;
            }
            while (!sources.isEmpty()) {
                LNode source = sources.removeFirst();
                mark[source.id] = nextLeft++;
                updateNeighbors(source);
                unprocessedNodes--;
            }
            if (unprocessedNodes > 0) {
                int maxOutflow = Integer.MIN_VALUE;
                LNode maxNode = null;
                int maxIndex = 0;
                index = 0;
                for (LNode node : nodes) {
                    if (mark[index] == 0) {
                        int outflow = outdeg[index] - indeg[index];
                        if (outflow > maxOutflow) {
                            maxOutflow = outflow;
                            maxNode = node;
                            maxIndex = index;
                        }
                    }
                    index++;
                }
                mark[maxIndex] = nextLeft++;
                updateNeighbors(maxNode);
                unprocessedNodes--;
            }
        }

        // shift negative ranks
        int shiftBase = nodes.size() + 1;
        for (index = 0; index < nodes.size(); index++) {
            if (mark[index] < 0) {
                mark[index] += shiftBase;
            }
        }

        // reverse edges that point left
        index = 0;
        for (LNode node : nodes) {
            for (LPort port : node.getPorts()) {
                // TODO: Won't this cause a ConcurrentModificationException?
                for (LEdge edge : port.getOutgoingEdges()) {
                    int targetIx = edge.getTarget().getNode().id;
                    if (mark[index] > mark[targetIx]) {
                        // TODO extend this to support port constraints
                        edge.reverse();
                    }
                }                
            }
            index++;
        }

        dispose();
        getMonitor().done();
    }
    
    /**
     * Release all created resources so the GC can reap them.
     */
    private void dispose() {
        this.indeg = null;
        this.outdeg = null;
        this.mark = null;
    }

    /**
     * Updates indegree and outdegree values of the neighbors of the given node,
     * simulating its removal from the graph. the sources and sinks lists are
     * also updated.
     * 
     * @param node node for which neighbors are updated
     */
    private void updateNeighbors(final LNode node) {
        for (LPort port : node.getPorts()) {
            for (LEdge edge : port.getConnectedEdges()) {
                LPort connectedPort = edge.getSource() == port ? edge.getTarget() : edge.getSource();
                LNode endpoint = connectedPort.getNode();
                int priority = edge.getProperty(Properties.PRIORITY);
                if (priority < 0) {
                    priority = 0;
                }
                int index = endpoint.id;
                if (mark[index] == 0) {
                    if (edge.getTarget() == connectedPort) {
                        indeg[index] -= priority + 1;
                        if (indeg[index] <= 0 && outdeg[index] > 0) {
                            sources.add(endpoint);
                        }
                    } else {
                        outdeg[index] -= priority + 1;
                        if (outdeg[index] <= 0 && indeg[index] > 0) {
                            sinks.add(endpoint);
                        }
                    }
                }
            }
        }
    }
    
}

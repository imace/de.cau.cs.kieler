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
package de.cau.cs.kieler.kiml.grana.analyses;

import java.util.HashMap;
import java.util.Map;

import de.cau.cs.kieler.core.alg.IKielerProgressMonitor;
import de.cau.cs.kieler.core.kgraph.KEdge;
import de.cau.cs.kieler.core.kgraph.KNode;
import de.cau.cs.kieler.kiml.grana.IAnalysis;

/**
 * A graph analysis that finds the number of biconnected components in a graph. Returns
 * a single-component result of type integer.
 * 
 * @author msp
 */
public class BiconnectedComponentsAnalysis implements IAnalysis {

    /**
     * {@inheritDoc}
     */
    public Object doAnalysis(final KNode parentNode, final Map<String, Object> results,
            final IKielerProgressMonitor progressMonitor) {
        progressMonitor.begin("Biconnected Components Analysis", 1);
        
        int count = findComponents(parentNode);
        
        dfsMap.clear();
        lowpt = null;
        parent = null;
        progressMonitor.done();
        return count;
    }

    /** next DFS number to assign. */
    private int nextDfsnum = 0;
    /** map of DFS numbers. */
    private Map<KNode, Integer> dfsMap = new HashMap<KNode, Integer>();
    /** lowest point numbers. */
    private int[] lowpt;
    /** parent node numbers. */
    private int[] parent;

    /**
     * Calculates the biconnected components of the given graph. The input graph
     * is considered as undirected.
     * 
     * @param graph graph to be processed
     * @return number of biconnected components
     */
    public int findComponents(final KNode graph) {
        nextDfsnum = 1;
        int graphSize = graph.getChildren().size();
        lowpt = new int[graphSize + 1];
        parent = new int[graphSize + 1];
        int count = 0;
        for (KNode node : graph.getChildren()) {
            if (dfsMap.get(node) == null) {
                count += dfsVisit(node);
            }
        }
        
        // find components in the nested subgraphs
        for (KNode node : graph.getChildren()) {
            if (!node.getChildren().isEmpty()) {
                count += findComponents(node);
            }
        }
        return count;
    }
    
    /**
     * Performs a DFS starting at the given node.
     * 
     * @param node node to visit
     * @param the number of biconnected components that were found
     */
    private int dfsVisit(final KNode node) {
        int dfsNum = nextDfsnum++;
        dfsMap.put(node, dfsNum);
        lowpt[dfsNum] = dfsNum;
        int count = 0;
        // follow the outgoing edges
        for (KEdge edge : node.getOutgoingEdges()) {
            KNode endpoint = edge.getTarget();
            if (endpoint.getParent() == node.getParent()) {
                Integer endpointNum = dfsMap.get(endpoint);
                if (endpointNum == null) {
                    endpointNum = nextDfsnum;
                    parent[endpointNum] = dfsNum;
                    count += dfsVisit(endpoint);
                    lowpt[dfsNum] = Math.min(lowpt[dfsNum], lowpt[endpointNum]);
                } else {
                    lowpt[dfsNum] = Math.min(lowpt[dfsNum], endpointNum);
                }
            }
        }
        // follow the incoming edges
        for (KEdge edge : node.getIncomingEdges()) {
            KNode endpoint = edge.getSource();
            if (endpoint.getParent() == node.getParent()) {
                Integer endpointNum = dfsMap.get(endpoint);
                if (endpointNum == null) {
                    endpointNum = nextDfsnum;
                    parent[endpointNum] = dfsNum;
                    count += dfsVisit(endpoint);
                    lowpt[dfsNum] = Math.min(lowpt[dfsNum], lowpt[endpointNum]);
                } else {
                    lowpt[dfsNum] = Math.min(lowpt[dfsNum], endpointNum);
                }
            }
        }
        // analyze the result
        if (dfsNum >= 2 && lowpt[dfsNum] == parent[dfsNum]) {
            count++;
        }
        return count;
    }

}

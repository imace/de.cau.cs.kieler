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
package de.cau.cs.kieler.kiml.smart.rules;

import java.util.HashMap;
import java.util.Map;

import de.cau.cs.kieler.core.alg.IKielerProgressMonitor;
import de.cau.cs.kieler.core.kgraph.KEdge;
import de.cau.cs.kieler.core.kgraph.KNode;
import de.cau.cs.kieler.kiml.service.grana.IAnalysis;

/**
 * Analysis for directed trees.
 *
 * @author msp
 */
public class TreeAnalysis implements IAnalysis {
    
    /** the identifier for the tree analysis. */
    public static final String ID = "de.cau.cs.kieler.kiml.smart.tree";
    
    /** map of marks determined in the DFS run. */
    private Map<KNode, Integer> dfsMark = new HashMap<KNode, Integer>();

    /**
     * {@inheritDoc}
     */
    public Object doAnalysis(final KNode parentNode, final Map<String, Object> results,
            final IKielerProgressMonitor progressMonitor) {
        progressMonitor.begin("Directed tree analysis", 1);
        
        boolean isTree = true;
        for (KNode node : parentNode.getChildren()) {
            if (!dfsMark.containsKey(node)) {
                int faultEdges = dfs(node, 0);
                if (faultEdges > 0) {
                    isTree = false;
                    break;
                }
            }
        }
        
        dfsMark.clear();
        progressMonitor.done();
        return isTree;
    }
    
    /**
     * Perform a DFS on the given node.
     * 
     * @param node a node that hasn't been visited yet
     * @param nextNum the number for marking the node
     * @return the number of fault edges
     */
    private int dfs(final KNode node, final int nextNum) {
        dfsMark.put(node, nextNum);
        int faultEdges = 0;
        for (KEdge edge : node.getOutgoingEdges()) {
            KNode target = edge.getTarget();
            Integer mark = dfsMark.get(target);
            if (mark == null) {
                // the target was not visited yet
                faultEdges += dfs(target, nextNum + 1);
            } else if (mark == 0) {
                // the target was the root of a previous dfs run - mark it as non-root
                dfsMark.put(target, nextNum + 1);
            } else {
                // the target has been already visited and is not a root
                faultEdges++;
            }
        }
        return faultEdges;
    }

}

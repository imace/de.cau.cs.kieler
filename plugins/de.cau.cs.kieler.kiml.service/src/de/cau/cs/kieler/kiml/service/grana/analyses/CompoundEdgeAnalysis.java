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
package de.cau.cs.kieler.kiml.service.grana.analyses;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import de.cau.cs.kieler.core.alg.IKielerProgressMonitor;
import de.cau.cs.kieler.core.kgraph.KEdge;
import de.cau.cs.kieler.core.kgraph.KNode;
import de.cau.cs.kieler.kiml.service.grana.IAnalysis;

/**
 * An analysis for hierarchy level crossing edges in compound graphs. The first returned component
 * is the number of hierarchy crossing edges, the second component is the maximal number of crossed
 * hierarchy levels.
 *
 * @author msp
 */
public class CompoundEdgeAnalysis implements IAnalysis {

    /**
     * {@inheritDoc}
     */
    public Object doAnalysis(KNode parentNode, Map<String, Object> results,
            IKielerProgressMonitor progressMonitor) {
        progressMonitor.begin("Compound edge analysis", 1);

        int edgeCount = 0;
        int maxLevels = 0;
        List<KNode> nodeQueue = new LinkedList<KNode>();
        nodeQueue.addAll(parentNode.getChildren());
        while (!nodeQueue.isEmpty()) {
            KNode node = nodeQueue.remove(0);
            for (KEdge edge : node.getOutgoingEdges()) {
                int crossedLevels = crossedLevels(edge.getSource(), edge.getTarget());
                if (crossedLevels > 0) {
                    edgeCount++;
                }
                if (crossedLevels > maxLevels) {
                    maxLevels = crossedLevels;
                }
            }
            
            nodeQueue.addAll(node.getChildren());
        }
        
        progressMonitor.done();
        return new Object[] { edgeCount, maxLevels };
    }
    
    /**
     * Determine the number of crossed levels between the two nodes.
     * 
     * @param node1 the first node
     * @param node2 the second node
     * @return the number of crossed levels
     */
    private int crossedLevels(final KNode node1, final KNode node2) {
        List<KNode> parentList1 = new LinkedList<KNode>();
        KNode parent1 = node1.getParent();
        while (parent1 != null) {
            parentList1.add(parent1);
            parent1 = parent1.getParent();
        }
        parentList1.add(null);
        
        KNode parent2 = node2.getParent();
        int levels1 = parentList1.indexOf(parent2);
        int levels2 = 0;
        while (levels1 < 0) {
            parent2 = parent2.getParent();
            levels1 = parentList1.indexOf(parent2);
            levels2++;
        }
        
        return levels1 + levels2;
    }

}

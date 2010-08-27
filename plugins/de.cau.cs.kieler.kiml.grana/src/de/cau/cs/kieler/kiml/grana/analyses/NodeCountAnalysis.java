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
package de.cau.cs.kieler.kiml.grana.analyses;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import de.cau.cs.kieler.core.KielerException;
import de.cau.cs.kieler.core.alg.IKielerProgressMonitor;
import de.cau.cs.kieler.core.kgraph.KNode;
import de.cau.cs.kieler.kiml.grana.IAnalysis;

/**
 * A graph analysis that computes the number of nodes in the given graph.
 * 
 * @author mri
 */
public class NodeCountAnalysis implements IAnalysis {

    /**
     * {@inheritDoc}
     */
    public Object doAnalysis(final KNode parentNode,
            final Map<String, Object> results,
            final IKielerProgressMonitor progressMonitor)
            throws KielerException {
        progressMonitor.begin("Number of Nodes analysis", 1);
        Integer numberOfNodes = 0;
        List<KNode> nodes = new LinkedList<KNode>();
        nodes.add(parentNode);
        while (nodes.size() > 0) {
            // pop first element
            KNode node = nodes.remove(0);
            numberOfNodes += node.getChildren().size();

            nodes.addAll(node.getChildren());
        }
        progressMonitor.done();
        return numberOfNodes;
    }
}

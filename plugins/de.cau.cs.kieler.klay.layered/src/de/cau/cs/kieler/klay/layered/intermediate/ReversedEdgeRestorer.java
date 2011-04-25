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

import de.cau.cs.kieler.core.alg.AbstractAlgorithm;
import de.cau.cs.kieler.klay.layered.ILayoutProcessor;
import de.cau.cs.kieler.klay.layered.Properties;
import de.cau.cs.kieler.klay.layered.graph.LEdge;
import de.cau.cs.kieler.klay.layered.graph.LNode;
import de.cau.cs.kieler.klay.layered.graph.LPort;
import de.cau.cs.kieler.klay.layered.graph.Layer;
import de.cau.cs.kieler.klay.layered.graph.LayeredGraph;

/**
 * Restores the direction of reversed edges. (edges with the property
 * {@link de.cau.cs.kieler.klay.layered.Properties#REVERSED} set to {@code true})
 * 
 * <p>All edges are traversed to look for reversed edges. If such edges are found,
 * they are restored, the ports they are connected to being restored as well.</p>
 * 
 * <dl>
 *   <dt>Precondition:</dt><dd>a layered graph.</dd>
 *   <dt>Postcondition:</dt><dd>Reversed edges are restored to their original direction.</dd>
 *   <dt>Slots:</dt><dd>After phase 5.</dd>
 *   <dt>Same-slot dependencies:</dt><dd>None.</dd>
 * </dl>
 *
 * @author cds
 */
public class ReversedEdgeRestorer extends AbstractAlgorithm implements ILayoutProcessor {

    /**
     * {@inheritDoc}
     */
    public void process(final LayeredGraph layeredGraph) {
        getMonitor().begin("Restoring reversed edges", 1);
        
        // Iterate through the layers
        for (Layer layer : layeredGraph.getLayers()) {
            // Iterate through the nodes
            for (LNode node : layer.getNodes()) {
                // Iterate over all the port's, looking for outgoing edges that should
                // be reversed
                for (LPort port : node.getPorts()) {
                    // Iterate over a copy of the edges to avoid concurrent modification
                    // exceptions
                    LEdge[] edgeArray = port.getOutgoingEdges().toArray(new LEdge[0]);
                    
                    for (LEdge edge : edgeArray) {
                        if (edge.getProperty(Properties.REVERSED)) {
                            edge.reverse();
                        }
                    }
                }
            }
        }
        
        getMonitor().done();
    }

}

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

import java.util.LinkedList;
import java.util.List;

import de.cau.cs.kieler.core.alg.AbstractAlgorithm;
import de.cau.cs.kieler.klay.layered.ILayoutProcessor;
import de.cau.cs.kieler.klay.layered.graph.LEdge;
import de.cau.cs.kieler.klay.layered.graph.LNode;
import de.cau.cs.kieler.klay.layered.graph.LPort;
import de.cau.cs.kieler.klay.layered.graph.Layer;
import de.cau.cs.kieler.klay.layered.graph.LayeredGraph;
import de.cau.cs.kieler.klay.layered.properties.EdgeType;
import de.cau.cs.kieler.klay.layered.properties.Properties;

/**
 * Removes dummy edges that were inserted while importing compound graphs to implement constraints
 * for the layering phase (keep dummy nodes representing subgraph borders left resp. right of inner
 * nodes).
 * 
 * <dl>
 * <dt>Precondition:</dt>
 * <dd>a layered graph.</dd>
 * <dt>Postcondition:</dt>
 * <dd>the graph does not contain compound dummy edges</dd>
 * <dt>Slots:</dt>
 * <dd>Before phase 3.</dd>
 * <dt>Same-slot dependencies:</dt>
 * <dd>None.</dd>
 * </dl>
 * 
 * @author ima
 */
public class CompoundDummyEdgeRemover extends AbstractAlgorithm implements ILayoutProcessor {

    /**
     * {@inheritDoc}
     */
    public void process(final LayeredGraph layeredGraph) {
        getMonitor().begin("Removing compound dummy edges", 1);

        List<Layer> layerList = layeredGraph.getLayers();

        LinkedList<LEdge> dummyEdgeList = new LinkedList<LEdge>();

        // Find dummy edges.
        for (Layer layer : layerList) {
            for (LNode lNode : layer.getNodes()) {
                for (LEdge lEdge : lNode.getOutgoingEdges()) {
                    if (lEdge.getProperty(Properties.EDGE_TYPE) == EdgeType.COMPOUND_DUMMY) {
                        dummyEdgeList.add(lEdge);
                    }
                }
            }
        }
        // Remove dummy edges.
        for (LEdge lEdge : dummyEdgeList) {
            lEdge.getSource().getOutgoingEdges().remove(lEdge);
            lEdge.getTarget().getIncomingEdges().remove(lEdge);
        }
        
//         // remove unused ports
//         float edgeSpacing = layeredGraph.getProperty(Properties.EDGE_SPACING_FACTOR)
//                * layeredGraph.getProperty(Properties.OBJ_SPACING);
//         List<LNode> nodes = layeredGraph.getLayerlessNodes();
//         for (int i = 0; i < nodes.size(); i++) {
//         LNode lnode = nodes.get(i);
//         List<LPort> ports = lnode.getPorts();
//         List<LPort> removables = new LinkedList<LPort>();
//         for (int j = 0; j < ports.size(); j++) {
//         LPort port = ports.get(j);
//         if (port.getIncomingEdges().isEmpty() && port.getOutgoingEdges().isEmpty()) {
//         removables.add(port);
//         }
//         }
//         for (int k = 0; k < removables.size(); k++) {
//         if (lnode.getSize().y >= edgeSpacing) {
//         lnode.getSize().y -= edgeSpacing;
//         }
//         ports.remove(removables.get(k));
//        
//         }
//         }
        
        getMonitor().done();
    }

}

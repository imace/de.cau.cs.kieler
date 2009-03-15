/******************************************************************************
 * KIELER - Kiel Integrated Environment for Layout for the Eclipse RCP
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
package de.cau.cs.kieler.kiml.layouter.metrics;

import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.*;

/**
 * Generator for random graphs.
 * 
 * @author msp
 */
public class GraphGenerator {
    
    /** width of generated nodes */
    private static final float NODE_WIDTH = 20.0f;
    /** height of generated nodes */
    private static final float NODE_HEIGHT = 20.0f;

    /**
     * Generates a random graph of given size.
     * 
     * @param nodeCount number of nodes in the graph
     * @param edgesPerNode number of outgoing edges for each node
     * @param withPorts if true, ports a generated and connected to the edges
     * @return a randomly generated graph
     */
    public static KLayoutGraph generateGraph(int nodeCount, int edgesPerNode,
            boolean withPorts) {
        if (nodeCount < 1 || edgesPerNode < 0)
            throw new IllegalArgumentException("Number of nodes and edges per node must be positive.");
        
        // create parent node
        KLayoutGraph layoutGraph = KimlLayoutGraphFactory.eINSTANCE.createKLayoutGraph();
        {
            KNodeLayout nodeLayout = KimlLayoutGraphFactory.eINSTANCE.createKNodeLayout();
            nodeLayout.setLocation(KimlLayoutGraphFactory.eINSTANCE.createKPoint());
            nodeLayout.setSize(KimlLayoutGraphFactory.eINSTANCE.createKDimension());
            nodeLayout.getLayoutOptions().add(KLayoutOption.HORIZONTAL);
            KInsets insets = KimlLayoutGraphFactory.eINSTANCE.createKInsets();
            nodeLayout.setInsets(insets);
            layoutGraph.setLayout(nodeLayout);
        }
        
        // create nodes
        KLayoutNode[] nodes = new KLayoutNode[nodeCount];
        for (int i = 0; i < nodeCount; i++) {
            nodes[i] = KimlLayoutGraphFactory.eINSTANCE.createKLayoutNode();
            KNodeLayout nodeLayout = KimlLayoutGraphFactory.eINSTANCE.createKNodeLayout();
            nodeLayout.setLocation(KimlLayoutGraphFactory.eINSTANCE.createKPoint());
            KDimension nodeSize = KimlLayoutGraphFactory.eINSTANCE.createKDimension();
            nodeSize.setWidth(NODE_WIDTH);
            nodeSize.setHeight(NODE_HEIGHT);
            nodeLayout.setSize(nodeSize);
            nodeLayout.getLayoutOptions().add(KLayoutOption.FIXED_SIZE);
            if (withPorts) {
                nodeLayout.getLayoutOptions().add(KLayoutOption.FIXED_PORTS);
            }
            nodes[i].setLayout(nodeLayout);
            KNodeLabel nodeLabel = KimlLayoutGraphFactory.eINSTANCE.createKNodeLabel();
            KNodeLabelLayout nodeLabelLayout = KimlLayoutGraphFactory.eINSTANCE.createKNodeLabelLayout();
            nodeLabelLayout.setLocation(KimlLayoutGraphFactory.eINSTANCE.createKPoint());
            nodeLabelLayout.setSize(KimlLayoutGraphFactory.eINSTANCE.createKDimension());
            nodeLabel.setLabelLayout(nodeLabelLayout);
            nodes[i].setLabel(nodeLabel);
            nodes[i].setParentNode(layoutGraph);
        }
        
        // create edges
        for (int i = 0; i < nodeCount; i++) {
            for (int j = 0; j < edgesPerNode; j++) {
                KLayoutEdge edge = KimlLayoutGraphFactory.eINSTANCE.createKLayoutEdge();
                KEdgeLayout edgeLayout = KimlLayoutGraphFactory.eINSTANCE.createKEdgeLayout();
                edge.setLayout(edgeLayout);
                edge.setSource(nodes[i]);
                int targetIndex = (int)(Math.random() * nodeCount);
                edge.setTarget(nodes[targetIndex]);
                if (withPorts) {
                    edge.setSourcePort(createPort(nodes[i], edge));
                    edge.setTargetPort(createPort(nodes[targetIndex], edge));
                }
            }
        }
        
        return layoutGraph;
    }
    
    /**
     * Creates a port, adds it to the given node at a random side, and adds the
     * given edge to the new port.
     * 
     * @param node node for the new port
     * @param edge edge to connect to the new port
     * @return a new port
     */
    private static KLayoutPort createPort(KLayoutNode node, KLayoutEdge edge) {
        KLayoutPort port = KimlLayoutGraphFactory.eINSTANCE.createKLayoutPort();
        KPortLayout portLayout = KimlLayoutGraphFactory.eINSTANCE.createKPortLayout();
        KPoint portLocation = KimlLayoutGraphFactory.eINSTANCE.createKPoint();
        switch ((int)(Math.random() * 4)) {
        case 0:
            portLocation.setX((float)(Math.random() * NODE_WIDTH));
            portLocation.setY(0.0f);
            portLayout.setPlacement(KPortPlacement.NORTH);
            break;
        case 1:
            portLocation.setX(NODE_WIDTH);
            portLocation.setY((float)(Math.random() * NODE_HEIGHT));
            portLayout.setPlacement(KPortPlacement.EAST);
            break;
        case 2:
            portLocation.setX((float)(Math.random() * NODE_WIDTH));
            portLocation.setY(NODE_HEIGHT);
            portLayout.setPlacement(KPortPlacement.SOUTH);
            break;
        case 3:
            portLocation.setX(0.0f);
            portLocation.setY((float)(Math.random() * NODE_HEIGHT));
            portLayout.setPlacement(KPortPlacement.WEST);
            break;
        }
        portLayout.setLocation(portLocation);
        portLayout.setSize(KimlLayoutGraphFactory.eINSTANCE.createKDimension());
        port.setLayout(portLayout);
        port.setNode(node);
        port.getEdges().add(edge);
        return port;
    }
    
}

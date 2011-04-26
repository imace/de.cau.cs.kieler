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
package test.layout;

import de.cau.cs.kieler.core.alg.IKielerProgressMonitor;
import de.cau.cs.kieler.core.alg.BasicProgressMonitor;
import de.cau.cs.kieler.core.kgraph.KEdge;
import de.cau.cs.kieler.core.kgraph.KNode;
import de.cau.cs.kieler.core.kgraph.KPort;
import de.cau.cs.kieler.kiml.AbstractLayoutProvider;
import de.cau.cs.kieler.kiml.klayoutdata.KShapeLayout;
import de.cau.cs.kieler.kiml.options.Direction;
import de.cau.cs.kieler.kiml.options.LayoutOptions;
import de.cau.cs.kieler.kiml.options.PortConstraints;
import de.cau.cs.kieler.kiml.options.PortSide;
import de.cau.cs.kieler.kiml.util.KimlUtil;
import de.cau.cs.kieler.klay.layered.LayeredLayoutProvider;

/**
 * Test class for the layout algorithm releases.
 * 
 * @author msp
 */
public final class Test {

    // CHECKSTYLEOFF MagicNumber

    /**
     * Hidden default constructor.
     */
    private Test() {
    }

    /**
     * The main method.
     * 
     * @param args
     *            command-line arguments
     */
    public static void main(final String[] args) {
        // create a KGraph for layout
        KNode parentNode = createGraph();

        // add layout options to the elements of the graph
        addLayoutOptions(parentNode);

        // create a progress monitor
        IKielerProgressMonitor progressMonitor = new BasicProgressMonitor();

        // create the layout provider
        AbstractLayoutProvider layoutProvider = new LayeredLayoutProvider();

        // perform layout on the created graph
        layoutProvider.doLayout(parentNode, progressMonitor);

        // output layout information
        printLayoutInfo(parentNode, progressMonitor);
    }

    /**
     * Creates a KGraph, represented by a parent node that contains the actual
     * nodes and edges of the graph.
     * 
     * @return a parent node that contains graph elements
     */
    private static KNode createGraph() {
        // create parent node
        KNode parentNode = KimlUtil.createInitializedNode();

        // create child nodes
        KNode childNode1 = KimlUtil.createInitializedNode();
        // This automatically adds the child to the list of its parent's children.
        childNode1.setParent(parentNode);
        childNode1.getLabel().setText("node1");
        KNode childNode2 = KimlUtil.createInitializedNode();
        childNode2.setParent(parentNode);
        childNode2.getLabel().setText("node2");

        // create ports (optional)
        KPort port1 = KimlUtil.createInitializedPort();
        // This automatically adds the port to the node's list of ports.
        port1.setNode(childNode1);
        KPort port2 = KimlUtil.createInitializedPort();
        port2.setNode(childNode2);

        // create edges
        KEdge edge1 = KimlUtil.createInitializedEdge();
        // This automatically adds the edge to the node's list of outgoing edges.
        edge1.setSource(childNode1);
        // This automatically adds the edge to the node's list of incoming edges.
        edge1.setTarget(childNode2);
        // As our ports do not distinguish between incoming and outgoing edges,
        // the edges must be added manually to their list of edges.
        edge1.setSourcePort(port1);
        port1.getEdges().add(edge1);
        edge1.setTargetPort(port2);
        port2.getEdges().add(edge1);

        return parentNode;
    }

    /**
     * Adds layout options to the elements of the given parent node.
     * 
     * @param parentNode
     *            parent node representing a graph
     */
    private static void addLayoutOptions(final KNode parentNode) {
        // add options for the parent node
        KShapeLayout parentLayout = parentNode.getData(KShapeLayout.class);
        // set layout direction to horizontal
        parentLayout.setProperty(LayoutOptions.DIRECTION, Direction.RIGHT);
        
        // add options for the child nodes
        for (KNode childNode : parentNode.getChildren()) {
            KShapeLayout childLayout = childNode.getData(KShapeLayout.class);
            // set some width and height for the child
            childLayout.setWidth(30.0f);
            childLayout.setHeight(30.0f);
            // set fixed size for the child
            childLayout.setProperty(LayoutOptions.FIXED_SIZE, Boolean.TRUE);
            // set port constraints to fixed port positions
            childLayout.setProperty(LayoutOptions.PORT_CONSTRAINTS, PortConstraints.FIXED_POS);
            
            // add options for the ports
            int i = 0;
            for (KPort port : childNode.getPorts()) {
                i++;
                KShapeLayout portLayout = port.getData(KShapeLayout.class);
                // set position and side
                portLayout.setYpos(i * 30.0f / (childNode.getPorts().size() + 1));
                if (childNode.getLabel().getText().equals("node1")) {
                    portLayout.setXpos(30.0f);
                    portLayout.setProperty(LayoutOptions.PORT_SIDE, PortSide.EAST);
                } else {
                    portLayout.setXpos(0.0f);
                    portLayout.setProperty(LayoutOptions.PORT_SIDE, PortSide.WEST);
                }
            }
        }
    }

    /**
     * Outputs layout information on the console.
     * 
     * @param parentNode
     *            parent node representing a graph
     * @param progressMonitor
     *            progress monitor for the layout run
     */
    private static void printLayoutInfo(final KNode parentNode,
            final IKielerProgressMonitor progressMonitor) {
        // print execution time of the algorithm run
        System.out.println("Execution time: "
                + progressMonitor.getExecutionTime() * 1000 + " ms");
        
        // print position of each node
        for (KNode childNode : parentNode.getChildren()) {
            KShapeLayout childLayout = childNode.getData(KShapeLayout.class);
            System.out.println(childNode.getLabel().getText() + ": x = "
                    + childLayout.getXpos() + ", y = " + childLayout.getYpos());
        }
    }
}
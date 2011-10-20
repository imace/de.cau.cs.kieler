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
package de.cau.cs.kieler.klay.layered;

import java.util.EnumSet;
import java.util.HashMap;
//import java.util.Iterator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

//import org.eclipse.emf.common.util.EList;

import de.cau.cs.kieler.core.kgraph.KEdge;
import de.cau.cs.kieler.core.kgraph.KGraphElement;
import de.cau.cs.kieler.core.kgraph.KLabel;
import de.cau.cs.kieler.core.kgraph.KNode;
import de.cau.cs.kieler.core.kgraph.KPort;
import de.cau.cs.kieler.core.math.KVector;
import de.cau.cs.kieler.core.math.KVectorChain;
import de.cau.cs.kieler.core.properties.MapPropertyHolder;
import de.cau.cs.kieler.core.util.Pair;
import de.cau.cs.kieler.kiml.klayoutdata.KEdgeLayout;
import de.cau.cs.kieler.kiml.klayoutdata.KInsets;
import de.cau.cs.kieler.kiml.klayoutdata.KPoint;
import de.cau.cs.kieler.kiml.klayoutdata.KShapeLayout;
import de.cau.cs.kieler.kiml.options.Direction;
import de.cau.cs.kieler.kiml.options.EdgeRouting;
import de.cau.cs.kieler.kiml.options.LayoutOptions;
import de.cau.cs.kieler.kiml.options.PortConstraints;
import de.cau.cs.kieler.kiml.options.PortSide;
import de.cau.cs.kieler.kiml.util.KimlUtil;
import de.cau.cs.kieler.klay.layered.graph.LInsets;
import de.cau.cs.kieler.klay.layered.graph.LEdge;
import de.cau.cs.kieler.klay.layered.graph.LGraphElement;
import de.cau.cs.kieler.klay.layered.graph.LLabel;
import de.cau.cs.kieler.klay.layered.graph.LNode;
import de.cau.cs.kieler.klay.layered.graph.LPort;
import de.cau.cs.kieler.klay.layered.graph.LayeredGraph;
import de.cau.cs.kieler.klay.layered.p3order.CrossingMinimizationStrategy;
import de.cau.cs.kieler.klay.layered.properties.GraphProperties;
//import de.cau.cs.kieler.klay.layered.properties.NodeType;
//import de.cau.cs.kieler.klay.layered.properties.NodeType;
import de.cau.cs.kieler.klay.layered.properties.Properties;

/**
 * Manages the transformation of KGraphs to LayeredGraphs. Sets the
 * {@link Properties#GRAPH_PROPERTIES} property on imported graphs.
 * 
 * @author msp
 * @author cds
 */
public class KGraphImporter extends AbstractGraphImporter<KNode> {

    // //////////////////////////////////////////////////////////////////////////////
    // Transformation KGraph -> LGraph

    /**
     * {@inheritDoc}
     */
    public LayeredGraph importGraph(final KNode kgraph) {
        LayeredGraph layeredGraph = new LayeredGraph();
        layeredGraph.setProperty(Properties.ORIGIN, kgraph);

        KShapeLayout sourceShapeLayout = kgraph.getData(KShapeLayout.class);

        // copy the properties of the KGraph to the layered graph and check values
        layeredGraph.copyProperties(sourceShapeLayout);
        layeredGraph.checkProperties(Properties.OBJ_SPACING, Properties.BORDER_SPACING,
                Properties.THOROUGHNESS, Properties.ASPECT_RATIO);
        Direction direction = layeredGraph.getProperty(LayoutOptions.DIRECTION);
        if (direction == Direction.UNDEFINED) {
            direction = Direction.RIGHT;
            layeredGraph.setProperty(LayoutOptions.DIRECTION, direction);
        }

        // copy the insets to the layered graph
        KInsets kinsets = sourceShapeLayout.getInsets();
        LInsets.Double linsets = layeredGraph.getInsets();

        linsets.left = kinsets.getLeft();
        linsets.right = kinsets.getRight();
        linsets.top = kinsets.getTop();
        linsets.bottom = kinsets.getBottom();

        // keep a list of created nodes in the layered graph, as well as a map
        // between KGraph
        // nodes / ports and LGraph nodes / ports
        Map<KGraphElement, LGraphElement> elemMap = new HashMap<KGraphElement, LGraphElement>();

        // the graph properties discovered during the transformations
        EnumSet<GraphProperties> graphProperties = EnumSet.noneOf(GraphProperties.class);

        // method will be called from the subclass CompoundKGraphImporter. The following part is not
        // to be executed in this case.
        boolean isCompound = sourceShapeLayout.getProperty(LayoutOptions.LAYOUT_HIERARCHY);
        if (!isCompound) {
            // see if merged ports are enabled
            Map<LNode, Pair<LPort, LPort>> mergePortsMap = null;
            if (layeredGraph.getProperty(Properties.MERGE_PORTS)) {
                mergePortsMap = new HashMap<LNode, Pair<LPort, LPort>>();
            }
            
            // transform everything
            transformNodesAndPorts(kgraph, layeredGraph, elemMap, graphProperties);
            transformEdges(kgraph, elemMap, mergePortsMap, graphProperties, direction, layeredGraph);
        }
        // set the graph properties property
        layeredGraph.setProperty(Properties.GRAPH_PROPERTIES, graphProperties);

        layeredGraph.setProperty(Properties.ELEMENT_MAP, elemMap);
        return layeredGraph;
    }

    /**
     * Transforms the nodes and ports defined by the given layout node.
     * 
     * @param graph
     *            the original graph.
     * @param layeredGraph
     *            the layered graph.
     * @param elemMap
     *            the element map that maps the original {@code KGraph} elements to the transformed
     *            {@code LGraph} elements.
     * @param graphProperties
     *            graph properties updated during the transformation.
     */
    private void transformNodesAndPorts(final KNode graph, final LayeredGraph layeredGraph,
            final Map<KGraphElement, LGraphElement> elemMap,
            final EnumSet<GraphProperties> graphProperties) {

        List<LNode> layeredNodes = layeredGraph.getLayerlessNodes();

        KShapeLayout layoutNodeLayout = graph.getData(KShapeLayout.class);
        KVector layoutNodeSize = new KVector(layoutNodeLayout.getWidth(),
                layoutNodeLayout.getHeight());

        // Find out whether there are external ports or ports with multiple incident
        // edges that need to be considered
        List<KPort> ports = graph.getPorts();
        for (KPort kport : ports) {
            int hierarchicalEdges = 0;

            for (KEdge kedge : kport.getEdges()) {
                if (graph.equals(kedge.getSource().getParent())
                        || graph.equals(kedge.getTarget().getParent())) {
                    hierarchicalEdges++;
                }
            }

            if (hierarchicalEdges > 0) {
                graphProperties.add(GraphProperties.EXTERNAL_PORTS);
            }

            if (hierarchicalEdges > 1) {
                graphProperties.add(GraphProperties.HYPEREDGES);
            }
        }

        // Transform the external ports
        Direction direction = layeredGraph.getProperty(LayoutOptions.DIRECTION);
        if (graphProperties.contains(GraphProperties.EXTERNAL_PORTS)) {
            for (KPort kport : ports) {
                transformExternalPort(kport, layeredNodes, graph, layoutNodeSize, elemMap,
                        direction);
            }
        }

        // Now transform the node's children
        for (KNode child : graph.getChildren()) {
            transformNode(child, layeredNodes, elemMap, graphProperties, direction);
        }

    }

    /**
     * Transforms the given external port into a dummy node.
     * 
     * @param kport
     *            the port.
     * @param layeredNodes
     *            the list of nodes to add the dummy node to.
     * @param graph
     *            the original graph.
     * @param layoutNodeSize
     *            the layout node's size.
     * @param elemMap
     *            the element map that maps the original {@code KGraph} elements to the transformed
     *            {@code LGraph} elements.
     * @param direction
     *            the overall layout direction
     */
    private void transformExternalPort(final KPort kport, final List<LNode> layeredNodes,
            final KNode graph, final KVector layoutNodeSize,
            final Map<KGraphElement, LGraphElement> elemMap, final Direction direction) {

        KShapeLayout graphLayout = graph.getData(KShapeLayout.class);
        KShapeLayout kportLayout = kport.getData(KShapeLayout.class);

        // Calculate the position of the port's center
        KVector kportPosition = new KVector(kportLayout.getXpos() + kportLayout.getWidth() / 2.0,
                kportLayout.getYpos() + kportLayout.getHeight() / 2.0);

        // Count the number of incoming and outgoing edges
        int inEdges = 0, outEdges = 0;
        for (KEdge edge : kport.getEdges()) {
            if (edge.getSourcePort() == kport && edge.getTarget().getParent() == graph) {
                outEdges++;
            }
            if (edge.getTargetPort() == kport && edge.getSource().getParent() == graph) {
                inEdges++;
            }
        }

        // Create dummy
        PortSide portSide = KimlUtil.calcPortSide(kport, direction);
        LNode dummy = createExternalPortDummy(kport,
                graphLayout.getProperty(LayoutOptions.PORT_CONSTRAINTS), portSide, inEdges
                        - outEdges, layoutNodeSize, kportPosition);
        dummy.setProperty(LayoutOptions.OFFSET, KimlUtil.calcPortOffset(kport, portSide));
        layeredNodes.add(dummy);
        elemMap.put(kport, dummy);
    }

    /**
     * Transforms the given node.
     * 
     * @param node
     *            the node to transform.
     * @param layeredNodes
     *            the list of nodes to add the transformed node to.
     * @param elemMap
     *            the element map that maps the original {@code KGraph} elements to the transformed
     *            {@code LGraph} elements.
     * @param graphProperties
     *            graph properties updated during the transformation.
     * @param direction
     *            the overall layout direction
     */
    protected void transformNode(final KNode node, final List<LNode> layeredNodes,
            final Map<KGraphElement, LGraphElement> elemMap,
            final EnumSet<GraphProperties> graphProperties, final Direction direction) {

        LNode newNode = new LNode();
        newNode.setProperty(Properties.ORIGIN, node);

        // add a new node to the layered graph, copying its size
        KShapeLayout nodeLayout = node.getData(KShapeLayout.class);
        if (!nodeLayout.getProperty(LayoutOptions.FIXED_SIZE)) {
            KVector ratio = KimlUtil.resizeNode(node);
            if (ratio != null && (ratio.x != 1 || ratio.y != 1)) {
                newNode.setProperty(Properties.RESIZE_RATIO, ratio);
            }
        }

        newNode.getPosition().x = nodeLayout.getXpos();
        newNode.getPosition().y = nodeLayout.getYpos();
        newNode.getSize().x = nodeLayout.getWidth();
        newNode.getSize().y = nodeLayout.getHeight();
        layeredNodes.add(newNode);

        elemMap.put(node, newNode);

        // port constraints and sides cannot be undefined
        PortConstraints portConstraints = nodeLayout.getProperty(LayoutOptions.PORT_CONSTRAINTS);
        if (portConstraints == PortConstraints.UNDEFINED) {
            portConstraints = PortConstraints.FREE;
        }
        for (KPort port : node.getPorts()) {
            KShapeLayout portLayout = port.getData(KShapeLayout.class);
            PortSide portSide = portLayout.getProperty(LayoutOptions.PORT_SIDE);
            if (portSide == PortSide.UNDEFINED) {
                portSide = KimlUtil.calcPortSide(port, direction);
                portLayout.setProperty(LayoutOptions.PORT_SIDE, portSide);
            }
        }

        // get a sorted list of the node's ports; if there are any with non-free port
        // constraints, set the appropriate graph property
        KPort[] sortedPorts = KimlUtil.getSortedPorts(node);
        if (sortedPorts.length > 0 && portConstraints != PortConstraints.FREE) {
            graphProperties.add(GraphProperties.NON_FREE_PORTS);
        }

        // transform the ports
        for (KPort kport : sortedPorts) {
            KShapeLayout portLayout = kport.getData(KShapeLayout.class);

            // determine the port type
            int inEdges = 0, outEdges = 0;
            for (KEdge edge : kport.getEdges()) {
                if (edge.getSourcePort() == kport) {
                    outEdges++;
                }
                if (edge.getTargetPort() == kport) {
                    inEdges++;
                }
            }

            // find out if there are hyperedges
            if (inEdges + outEdges > 1) {
                graphProperties.add(GraphProperties.HYPEREDGES);
            }

            // create layered port, copying its position
            LPort newPort = new LPort();
            newPort.setProperty(Properties.ORIGIN, kport);
            newPort.getSize().x = portLayout.getWidth();
            newPort.getSize().y = portLayout.getHeight();
            newPort.getPosition().x = portLayout.getXpos() + portLayout.getWidth() / 2;
            newPort.getPosition().y = portLayout.getYpos() + portLayout.getHeight() / 2;
            newPort.setNode(newNode);

            elemMap.put(kport, newPort);

            // create layered label, if any
            KLabel klabel = kport.getLabel();
            if (klabel != null) {
                KShapeLayout labelLayout = klabel.getData(KShapeLayout.class);

                LLabel newLabel = new LLabel(klabel.getText());
                newLabel.setProperty(Properties.ORIGIN, klabel);
                newLabel.getSize().x = labelLayout.getWidth();
                newLabel.getSize().y = labelLayout.getHeight();
                newLabel.getPosition().x = labelLayout.getXpos() - portLayout.getWidth() / 2;
                newLabel.getPosition().y = labelLayout.getYpos() - portLayout.getHeight() / 2;
                newPort.setLabel(newLabel);
            }

            PortSide portSide = portLayout.getProperty(LayoutOptions.PORT_SIDE);
            float offset = KimlUtil.calcPortOffset(kport, portSide);
            newPort.setSide(portSide);
            newPort.setProperty(LayoutOptions.OFFSET, offset);

            switch (direction) {
            case LEFT:
            case RIGHT:
                if (portSide == PortSide.NORTH || portSide == PortSide.SOUTH) {
                    graphProperties.add(GraphProperties.NORTH_SOUTH_PORTS);
                }
                break;
            case UP:
            case DOWN:
                if (portSide == PortSide.EAST || portSide == PortSide.WEST) {
                    graphProperties.add(GraphProperties.NORTH_SOUTH_PORTS);
                }
                break;
            }
        }

        // add the node's label, if any
        KLabel klabel = node.getLabel();
        if (klabel != null) {
            KShapeLayout labelLayout = klabel.getData(KShapeLayout.class);

            LLabel newLabel = new LLabel(klabel.getText());
            newLabel.setProperty(Properties.ORIGIN, node);
            newLabel.getSize().x = labelLayout.getWidth();
            newLabel.getSize().y = labelLayout.getHeight();
            newLabel.getPosition().x = labelLayout.getXpos();
            newLabel.getPosition().y = labelLayout.getYpos();
            newNode.setLabel(newLabel);
        }

        // set properties of the new node
        newNode.copyProperties(nodeLayout);

        if (newNode.getProperty(LayoutOptions.COMMENT_BOX)) {
            graphProperties.add(GraphProperties.COMMENTS);
        }

        // if we have a hypernode without ports, create a default input and output port
        if (newNode.getProperty(LayoutOptions.HYPERNODE)) {
            graphProperties.add(GraphProperties.HYPERNODES);
            graphProperties.add(GraphProperties.HYPEREDGES);
            newNode.setProperty(LayoutOptions.PORT_CONSTRAINTS, PortConstraints.FREE);
        }
    }

    /**
     * Transforms the edges defined by the given layout node.
     * 
     * @param graph
     *            the original graph.
     * @param elemMap
     *            the element map that maps the original {@code KGraph} elements to the transformed
     *            {@code LGraph} elements.
     * @param mergePortsMap
     *            mapping of nodes to pairs of input and output ports created for them if merged ports
     *            are enabled. {@code null} if they are not enabled.
     * @param graphProperties
     *            graph properties updated during the transformation.
     * @param direction
     *            the overall layout direction
     * @param layeredGraph
     */
    private void transformEdges(final KNode graph, final Map<KGraphElement, LGraphElement> elemMap,
            final Map<LNode, Pair<LPort, LPort>> mergePortsMap,
            final EnumSet<GraphProperties> graphProperties, final Direction direction,
            final MapPropertyHolder layeredGraph) {

        // Transform external port edges
        transformExternalPortEdges(graph, graph.getIncomingEdges(), elemMap, mergePortsMap,
                graphProperties, direction, layeredGraph);
        transformExternalPortEdges(graph, graph.getOutgoingEdges(), elemMap, mergePortsMap,
                graphProperties, direction, layeredGraph);

        // Transform edges originating in the layout node's children
        for (KNode child : graph.getChildren()) {
            for (KEdge kedge : child.getOutgoingEdges()) {
                // exclude edges that pass hierarchy bounds (except for those
                // going into an external port)
                if (kedge.getTarget().getParent() == child.getParent()) {
                    transformEdge(kedge, graph, elemMap, mergePortsMap, graphProperties,
                            direction, layeredGraph);
                } else if (kedge.getTarget().getParent() != kedge.getSource()
                        && kedge.getTarget() != kedge.getSource().getParent()) {

                    // the edge is excluded from layout since it does not
                    // connect two adjacent hierarchy levels
                    KEdgeLayout edgeLayout = kedge.getData(KEdgeLayout.class);
                    edgeLayout.setProperty(LayoutOptions.NO_LAYOUT, true);
                }
            }
        }
    }

    /**
     * Transforms the given list of edges connected to the layout node's external ports.
     * 
     * @param graph
     *            the original graph.
     * @param edges
     *            the list of edges, each connected to an external port of the layout node.
     * @param elemMap
     *            the element map that maps the original {@code KGraph} elements to the transformed
     *            {@code LGraph} elements.
     * @param mergePortsMap
     *            mapping of nodes to pairs of input and output ports created for them if merged ports
     *            are enabled. {@code null} if they are not enabled.
     * @param graphProperties
     *            graph properties updated during the transformation.
     * @param direction
     *            the overall layout direction
     * @param layeredGraph
     */
    private void transformExternalPortEdges(final KNode graph, final List<KEdge> edges,
            final Map<KGraphElement, LGraphElement> elemMap,
            final Map<LNode, Pair<LPort, LPort>> mergePortsMap,
            final EnumSet<GraphProperties> graphProperties, final Direction direction,
            final MapPropertyHolder layeredGraph) {

        for (KEdge kedge : edges) {
            // Only transform edges going into the layout node's direct children
            // (self-loops of the layout node will be processed on level higher)
            if (kedge.getSource().getParent() == graph || kedge.getTarget().getParent() == graph) {

                transformEdge(
                        kedge, graph, elemMap, mergePortsMap, graphProperties, direction, layeredGraph);
            }
        }
    }

    /**
     * Transforms the given edge.
     * 
     * @param kedge
     *            the edge to transform.
     * @param graph
     *            the original graph.
     * @param elemMap
     *            the element map that maps the original {@code KGraph} elements to the transformed
     *            {@code LGraph} elements.
     * @param mergePortsMap
     *            mapping of nodes to pairs of input and output ports created for them if merged ports
     *            are enabled. {@code null} if they are not enabled.
     * @param graphProperties
     *            graph properties updated during the transformation.
     * @param direction
     *            the overall layout direction
     * @param layeredGraph
     *            the layeredGraph.
     */
    protected void transformEdge(final KEdge kedge, final KNode graph,
            final Map<KGraphElement, LGraphElement> elemMap,
            final Map<LNode, Pair<LPort, LPort>> mergePortsMap,
            final EnumSet<GraphProperties> graphProperties, final Direction direction,
            final MapPropertyHolder layeredGraph) {

        KEdgeLayout edgeLayout = kedge.getData(KEdgeLayout.class);
        KNode kgraph = (KNode) layeredGraph.getProperty(Properties.ORIGIN);
        KShapeLayout sourceShapeLayout = kgraph.getData(KShapeLayout.class);
        boolean isCompound = sourceShapeLayout.getProperty(LayoutOptions.LAYOUT_HIERARCHY);

        // create a layered edge
        LEdge newEdge = new LEdge();
        newEdge.setProperty(Properties.ORIGIN, kedge);

        // the following is not needed in case of compound graph handling, as source and target will
        // be set by calling function.

        if (!isCompound) {
            // retrieve source and target
            LNode sourceNode = null;
            LPort sourcePort = null;
            LNode targetNode = null;
            LPort targetPort = null;

            // check if the edge source is an external port
            if (kedge.getSource() == graph) {
                sourceNode = (LNode) elemMap.get(kedge.getSourcePort());
                sourcePort = sourceNode.getPorts().get(0);
            } else {
                sourceNode = (LNode) elemMap.get(kedge.getSource());
                sourcePort = (LPort) elemMap.get(kedge.getSourcePort());
            }

            // check if the edge target is an external port
            if (kedge.getTarget() == graph) {
                targetNode = (LNode) elemMap.get(kedge.getTargetPort());
                targetPort = targetNode.getPorts().get(0);
            } else {
                targetNode = (LNode) elemMap.get(kedge.getTarget());
                targetPort = (LPort) elemMap.get(kedge.getTargetPort());
            }

            // if we have a self-loop, set the appropriate graph property
            if (sourceNode != null && sourceNode != graph && sourceNode == targetNode) {
                graphProperties.add(GraphProperties.SELF_LOOPS);
            }

            // create source and target ports if they do not exist yet
            if (sourcePort == null) {
                if (mergePortsMap != null) {
                    sourcePort = getMergedPortsOfNode(sourceNode, mergePortsMap).getSecond();
                } else {
                    sourcePort = createPort(sourceNode, edgeLayout.getSourcePoint(),
                            PortSide.fromDirection(direction));
                }
            }
            
            if (targetPort == null) {
                if (mergePortsMap != null) {
                    targetPort = getMergedPortsOfNode(targetNode, mergePortsMap).getFirst();
                } else {
                    targetPort = createPort(targetNode, edgeLayout.getTargetPoint(), PortSide
                            .fromDirection(direction).opposed());
                }
            }
            newEdge.setSource(sourcePort);
            newEdge.setTarget(targetPort);
        }

        // transform the edge's labels
        for (KLabel klabel : kedge.getLabels()) {
            KShapeLayout labelLayout = klabel.getData(KShapeLayout.class);
            LLabel newLabel = new LLabel(klabel.getText());
            newLabel.getPosition().x = labelLayout.getXpos();
            newLabel.getPosition().y = labelLayout.getYpos();
            newLabel.getSize().x = labelLayout.getWidth();
            newLabel.getSize().y = labelLayout.getHeight();
            newLabel.setProperty(Properties.ORIGIN, klabel);
            newEdge.getLabels().add(newLabel);
        }
        
        // copy the bend points of the edge if they are needed by anyone
        if (layeredGraph.getProperty(Properties.CROSSMIN)
                == CrossingMinimizationStrategy.INTERACTIVE
                && !edgeLayout.getBendPoints().isEmpty()) {
            KVectorChain bendpoints = new KVectorChain();
            for (KPoint point : edgeLayout.getBendPoints()) {
                bendpoints.add(point.createVector());
            }
            newEdge.setProperty(Properties.ORIGINAL_BENDPOINTS, bendpoints);
        }

        // set properties of the new edge
        newEdge.copyProperties(edgeLayout);
        // method will be called from the subclass CompoundKGraphImporter. The following part is
        // to be executed in this case.

        if (isCompound) {
            // put edge to elementMap
            elemMap.put(kedge, newEdge);
        }
    }
    
    /**
     * Returns the merge ports created for the given node. If none were created yet, creates some
     * and returns those, adding them to the map.
     * 
     * @param node the node whose merge ports to return.
     * @param mergedPorts map from nodes to their merge ports.
     * @return the node's merge ports.
     */
    private Pair<LPort, LPort> getMergedPortsOfNode(final LNode node,
            final Map<LNode, Pair<LPort, LPort>> mergedPorts) {
        
        Pair<LPort, LPort> mergedPortsOfNode = mergedPorts.get(node);
        
        if (mergedPortsOfNode == null) {
            LPort inputPort = new LPort();
            inputPort.setNode(node);
            
            LPort outputPort = new LPort();
            outputPort.setNode(node);
            
            mergedPortsOfNode = new Pair<LPort, LPort>(inputPort, outputPort);
            mergedPorts.put(node, mergedPortsOfNode);
        }
        
        return mergedPortsOfNode;
    }

    /**
     * Create a port for an edge that is not connected to a port. This is necessary because KLay
     * Layered wants all edges to have a source port and a target port.
     * 
     * @param node
     *            the node at which the edge is incident
     * @param endPoint
     *            the absolute point where the edge ends
     * @param defaultSide
     *            the default side for the new port
     * @return a new port
     */
    private LPort createPort(final LNode node, final KPoint endPoint, final PortSide defaultSide) {
        LPort port;
        if (node.getProperty(LayoutOptions.HYPERNODE)) {
            // Hypernodes have one output port and one input port
            Iterator<LPort> portIter = node.getPorts(defaultSide).iterator();
            if (portIter.hasNext()) {
                port = portIter.next();
            } else {
                port = new LPort();
                port.setNode(node);
                Util.centerPoint(port.getPosition(), node.getSize(), defaultSide);
                port.setSide(defaultSide);
            }
        } else {
            port = new LPort();
            port.setNode(node);
            KVector pos = port.getPosition();
            pos.x = endPoint.getX() - node.getPosition().x;
            pos.y = endPoint.getY() - node.getPosition().y;
            KVector resizeRatio = node.getProperty(Properties.RESIZE_RATIO);
            if (resizeRatio != null) {
                pos.x *= resizeRatio.x;
                pos.y *= resizeRatio.y;
            }
            pos.applyBounds(0, 0, node.getSize().x, node.getSize().y);
            port.setSide(calcPortSide(node, port));
        }
        return port;
    }

    /**
     * Calculate the port side from the relative position.
     * 
     * @param node
     *            a node
     * @param port
     *            a port of that node
     * @return the side of the node on which the port is situated
     */
    private static PortSide calcPortSide(final LNode node, final LPort port) {
        double widthPercent = port.getPosition().x / node.getSize().x;
        double heightPercent = port.getPosition().y / node.getSize().y;
        if (widthPercent + heightPercent <= 1 && widthPercent - heightPercent <= 0) {
            // port is on the left
            return PortSide.WEST;
        } else if (widthPercent + heightPercent >= 1 && widthPercent - heightPercent >= 0) {
            // port is on the right
            return PortSide.EAST;
        } else if (heightPercent < 1.0f / 2) {
            // port is on the top
            return PortSide.NORTH;
        } else {
            // port is on the bottom
            return PortSide.SOUTH;
        }
    }

    // //////////////////////////////////////////////////////////////////////////////
    // Apply Layout Results

    /**
     * {@inheritDoc}
     */
    public void applyLayout(final LayeredGraph layeredGraph) {
        Object target = layeredGraph.getProperty(Properties.ORIGIN);
        if (!(target instanceof KNode)) {
            return;
        }
        KNode parentNode = (KNode) target;

        // determine the border spacing, which influences the offset
        KShapeLayout parentLayout = parentNode.getData(KShapeLayout.class);
        float borderSpacing = layeredGraph.getProperty(Properties.BORDER_SPACING);

        // calculate the offset
        KVector offset = new KVector(borderSpacing + layeredGraph.getOffset().x, borderSpacing
                + layeredGraph.getOffset().y);

        // along the way, we collect the list of edges to be processed later
        List<LEdge> edgeList = new LinkedList<LEdge>();

        // process the nodes
        for (LNode lnode : layeredGraph.getLayerlessNodes()) {
            Object origin = lnode.getProperty(Properties.ORIGIN);

            if (origin instanceof KNode) {
                // set the node position
                KShapeLayout nodeLayout = ((KNode) origin).getData(KShapeLayout.class);

                nodeLayout.setXpos((float) (lnode.getPosition().x + offset.x));
                nodeLayout.setYpos((float) (lnode.getPosition().y + offset.y));

                // set port positions
                if (!nodeLayout.getProperty(LayoutOptions.PORT_CONSTRAINTS).isPosFixed()) {
                    for (LPort lport : lnode.getPorts()) {
                        origin = lport.getProperty(Properties.ORIGIN);
                        if (origin instanceof KPort) {
                            KShapeLayout portLayout = ((KPort) origin).getData(KShapeLayout.class);
                            portLayout
                                    .setXpos((float) (lport.getPosition().x - lport.getSize().x / 2.0));
                            portLayout
                                    .setYpos((float) (lport.getPosition().y - lport.getSize().y / 2.0));
                        }
                    }
                }
            } else if (origin instanceof KPort) {
                // It's an external port. Set its position
                KShapeLayout portLayout = ((KPort) origin).getData(KShapeLayout.class);
                KVector portPosition = getExternalPortPosition(layeredGraph, lnode,
                        portLayout.getWidth(), portLayout.getHeight());

                portLayout.setXpos((float) portPosition.x);
                portLayout.setYpos((float) portPosition.y);
            }

            // collect edges
            for (LPort port : lnode.getPorts()) {
                edgeList.addAll(port.getOutgoingEdges());
            }
        }

        // check if the edge routing uses splines
        EdgeRouting routing = parentLayout.getProperty(LayoutOptions.EDGE_ROUTING);
        boolean splinesActive = routing == EdgeRouting.SPLINES;

        // iterate through all edges
        for (LEdge ledge : edgeList) {
            KEdge kedge = (KEdge) ledge.getProperty(Properties.ORIGIN);
            KEdgeLayout edgeLayout = kedge.getData(KEdgeLayout.class);
            KVectorChain bendPoints = ledge.getBendPoints();

            // add the source port and target port positions to the vector chain
            LPort sourcePort = ledge.getSource();
            bendPoints.addFirst(KVector.add(sourcePort.getPosition(), sourcePort.getNode()
                    .getPosition()));
            LPort targetPort = ledge.getTarget();
            bendPoints.addLast(KVector.add(targetPort.getPosition(), targetPort.getNode()
                    .getPosition()));

            // translate the bend points by the offset and apply the bend points
            bendPoints.translate(offset);
            edgeLayout.applyVectorChain(bendPoints);

            // apply layout to labels
            for (LLabel label : ledge.getLabels()) {
                KLabel klabel = (KLabel) label.getProperty(Properties.ORIGIN);
                KShapeLayout klabelLayout = klabel.getData(KShapeLayout.class);

                KVector labelPos = new KVector(ledge.getSource().getPosition().x, ledge.getSource()
                        .getPosition().y);
                labelPos.add(ledge.getSource().getNode().getPosition());
                labelPos.add(label.getPosition());
                klabelLayout.setXpos((float) (labelPos.x + offset.x));
                klabelLayout.setYpos((float) (labelPos.y + offset.y));
            }

            // set spline option
            if (splinesActive) {
                edgeLayout.setProperty(LayoutOptions.EDGE_ROUTING, EdgeRouting.SPLINES);
            }
        }

        // set up the parent node
        KInsets insets = parentLayout.getInsets();
        float width = (float) layeredGraph.getSize().x + 2 * borderSpacing + insets.getLeft()
                + insets.getRight();
        float height = (float) layeredGraph.getSize().y + 2 * borderSpacing + insets.getTop()
                + insets.getBottom();

        if (layeredGraph.getProperty(Properties.GRAPH_PROPERTIES).contains(
                GraphProperties.EXTERNAL_PORTS)) {

            // ports have been positioned using dummy nodes
            parentLayout.setProperty(LayoutOptions.PORT_CONSTRAINTS, PortConstraints.FIXED_POS);
            KimlUtil.resizeNode(parentNode, width, height, false);
        } else {
            // ports have not been positioned yet - leave this for next layouter
            KimlUtil.resizeNode(parentNode, width, height, true);
        }
    }

}
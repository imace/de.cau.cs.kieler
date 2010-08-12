/*
 * KIELER - Kiel Integrated Environment for Layout Eclipse RichClient
 *
 * http://www.informatik.uni-kiel.de/rtsys/kieler/
 * 
 * Copyright 2008 by
 * + Christian-Albrechts-University of Kiel
 *   + Department of Computer Science
 *     + Real-Time and Embedded Systems Group
 * 
 * This code is provided under the terms of the Eclipse Public License (EPL).
 * See the file epl-v10.html for the license text.
 */
package de.cau.cs.kieler.klodd.hierarchical.impl;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import de.cau.cs.kieler.core.alg.AbstractAlgorithm;
import de.cau.cs.kieler.core.kgraph.KEdge;
import de.cau.cs.kieler.core.kgraph.KNode;
import de.cau.cs.kieler.core.kgraph.KPort;
import de.cau.cs.kieler.kiml.klayoutdata.KShapeLayout;
import de.cau.cs.kieler.kiml.options.LayoutDirection;
import de.cau.cs.kieler.kiml.options.LayoutOptions;
import de.cau.cs.kieler.kiml.options.PortSide;
import de.cau.cs.kieler.kiml.util.KimlLayoutUtil;
import de.cau.cs.kieler.klodd.hierarchical.modules.INodewiseEdgePlacer;
import de.cau.cs.kieler.klodd.hierarchical.structures.ElementLoop;
import de.cau.cs.kieler.klodd.hierarchical.structures.Layer;
import de.cau.cs.kieler.klodd.hierarchical.structures.LayerConnection;
import de.cau.cs.kieler.klodd.hierarchical.structures.LayerElement;
import de.cau.cs.kieler.klodd.hierarchical.structures.LayeredGraph;

/**
 * Nodewise edge placer implementation that sorts the edges and gives them slot
 * ranks according to the result.
 * 
 * @kieler.rating 2009-12-11 proposed yellow msp
 * @author msp
 */
public class SortingNodewiseEdgePlacer extends AbstractAlgorithm implements INodewiseEdgePlacer {

    /**
     * Routing slot used to route edges around node elements.
     */
    private static class RoutingSlot implements Comparable<RoutingSlot> {
        private float start = -Float.MAX_VALUE, end = Float.MAX_VALUE;
        private int rank;
        private List<KPort> ports = new LinkedList<KPort>();

        /**
         * {@inheritDoc}
         */
        public int compareTo(final RoutingSlot other) {
            if (this.start <= other.start && this.end >= other.end) {
                return 1;
            } else if (this.start >= other.start && this.end <= other.end) {
                return -1;
            } else {
                return 0;
            }
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean equals(final Object other) {
            if (other instanceof RoutingSlot) {
                return this.compareTo((RoutingSlot) other) == 0;
            } else {
                return false;
            }
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public int hashCode() {
            return ((int) start << (Integer.SIZE / 2)) + (int) end;
        }
    }

    /** layout direction configured for the given layered graph. */
    private LayoutDirection layoutDirection;

    /**
     * {@inheritDoc}
     */
    public void placeEdges(final LayeredGraph layeredGraph) {
        getMonitor().begin("Nodewise edge placement", 1);

        layoutDirection = layeredGraph.getLayoutDirection();
        // calculate the connection routing for each layer element
        for (Layer layer : layeredGraph.getLayers()) {
            for (LayerElement element : layer.getElements()) {
                element.placePorts();
                placeEdges(element);
            }
        }

        getMonitor().done();
    }

    /**
     * Calculates placements for the edges incident with the given layer
     * element, if its element object is a regular node.
     * 
     * @param element layer element to process
     */
    private void placeEdges(final LayerElement element) {
        Object elemObj = element.getElemObj();
        if (!(elemObj instanceof KNode)) {
            return;
        }
        KNode node = (KNode) elemObj;
        if (node.getPorts().isEmpty()) {
            return;
        }
        List<RoutingSlot> northSlots = new LinkedList<RoutingSlot>();
        List<RoutingSlot> eastSlots = new LinkedList<RoutingSlot>();
        List<RoutingSlot> southSlots = new LinkedList<RoutingSlot>();
        List<RoutingSlot> westSlots = new LinkedList<RoutingSlot>();
        Map<KPort, RoutingSlot> northMap = new HashMap<KPort, RoutingSlot>();
        Map<KPort, RoutingSlot> eastMap = new HashMap<KPort, RoutingSlot>();
        Map<KPort, RoutingSlot> southMap = new HashMap<KPort, RoutingSlot>();
        Map<KPort, RoutingSlot> westMap = new HashMap<KPort, RoutingSlot>();
        float nodeWidth = element.getRealWidth();
        float nodeHeight = element.getRealHeight();

        for (KPort port1 : node.getPorts()) {
            KShapeLayout portLayout = KimlLayoutUtil.getShapeLayout(port1);
            PortSide placement = LayoutOptions.getEnum(portLayout, PortSide.class);
            float xPos1 = portLayout.getXpos() + portLayout.getWidth() / 2;
            float yPos1 = portLayout.getYpos() + portLayout.getHeight() / 2;
            // process self-loops over the given port
            for (KEdge edge : port1.getEdges()) {
                if (edge.getSourcePort() == port1 && edge.getTarget() == node) {
                    KPort port2 = edge.getTargetPort();
                    ElementLoop loop = new ElementLoop(edge, element, port1, port2);
                    element.getLoops().add(loop);
                    KShapeLayout targetLayout = KimlLayoutUtil.getShapeLayout(port2);
                    PortSide placement2 = LayoutOptions.getEnum(targetLayout, PortSide.class);
                    float xPos2 = targetLayout.getXpos() + targetLayout.getWidth() / 2;
                    float yPos2 = targetLayout.getYpos() + targetLayout.getHeight() / 2;
                    switch (placement) {
                    case NORTH:
                        switch (placement2) {
                        case NORTH:
                            addToSlot(port1, port2, northSlots, northMap, Math.min(xPos1, xPos2), Math
                                    .max(xPos1, xPos2));
                            break;
                        case EAST:
                            addToSlot(port1, port2, northSlots, northMap, xPos1, nodeWidth + yPos2);
                            addToSlot(port1, port2, eastSlots, eastMap, xPos1 - nodeWidth, yPos2);
                            break;
                        case SOUTH:
                            addToSlot(port1, port2, northSlots, northMap, xPos1, 2 * nodeWidth
                                    + nodeHeight - xPos2);
                            addToSlot(port1, port2, eastSlots, eastMap, xPos1 - nodeWidth, nodeHeight
                                    + nodeWidth - xPos2);
                            addToSlot(port1, port2, southSlots, southMap,
                                    xPos1 - nodeHeight - nodeWidth, nodeWidth - xPos2);
                            break;
                        case WEST:
                            addToSlot(port1, port2, northSlots, northMap, -yPos2, xPos1);
                            addToSlot(port1, port2, westSlots, westMap, nodeHeight - yPos2, nodeHeight
                                    + xPos1);
                            break;
                        }
                        break;
                    case EAST:
                        switch (placement2) {
                        case NORTH:
                            addToSlot(port1, port2, eastSlots, eastMap, xPos2 - nodeWidth, yPos1);
                            addToSlot(port1, port2, northSlots, northMap, xPos2, nodeWidth + yPos1);
                            break;
                        case EAST:
                            addToSlot(port1, port2, eastSlots, eastMap, Math.min(yPos1, yPos2), Math
                                    .max(yPos1, yPos2));
                            break;
                        case SOUTH:
                            addToSlot(port1, port2, eastSlots, eastMap, yPos1, nodeHeight + nodeWidth
                                    - xPos2);
                            addToSlot(port1, port2, southSlots, southMap, yPos1 - nodeHeight, nodeWidth
                                    - xPos2);
                            break;
                        case WEST:
                            addToSlot(port1, port2, eastSlots, eastMap, yPos1, 2 * nodeHeight
                                    + nodeWidth - yPos2);
                            addToSlot(port1, port2, southSlots, southMap, yPos1 - nodeHeight, nodeWidth
                                    + nodeHeight - yPos2);
                            addToSlot(port1, port2, westSlots, westMap, yPos1 - nodeWidth - nodeHeight,
                                    nodeHeight - yPos2);
                            break;
                        }
                        break;
                    case SOUTH:
                        switch (placement2) {
                        case NORTH:
                            addToSlot(port1, port2, southSlots, southMap,
                                    xPos2 - nodeHeight - nodeWidth, nodeWidth - xPos1);
                            addToSlot(port1, port2, eastSlots, eastMap, xPos2 - nodeWidth, nodeHeight
                                    + nodeWidth - xPos1);
                            addToSlot(port1, port2, northSlots, northMap, xPos2, 2 * nodeWidth
                                    + nodeHeight - xPos1);
                            break;
                        case EAST:
                            addToSlot(port1, port2, southSlots, southMap, yPos2 - nodeHeight, nodeWidth
                                    - xPos1);
                            addToSlot(port1, port2, eastSlots, eastMap, yPos2, nodeHeight + nodeWidth
                                    - xPos1);
                            break;
                        case SOUTH:
                            addToSlot(port1, port2, southSlots, southMap, nodeWidth
                                    - Math.max(xPos1, xPos2), nodeWidth - Math.min(xPos1, xPos2));
                            break;
                        case WEST:
                            addToSlot(port1, port2, southSlots, southMap, nodeWidth - xPos1, nodeWidth
                                    + nodeHeight - yPos2);
                            addToSlot(port1, port2, westSlots, westMap, -xPos1, nodeHeight - yPos2);
                            break;
                        }
                        break;
                    case WEST:
                        switch (placement2) {
                        case NORTH:
                            addToSlot(port1, port2, westSlots, westMap, nodeHeight - yPos1, nodeHeight
                                    + xPos2);
                            addToSlot(port1, port2, northSlots, northMap, -yPos1, xPos2);
                            break;
                        case EAST:
                            addToSlot(port1, port2, westSlots, westMap, yPos2 - nodeWidth - nodeHeight,
                                    nodeHeight - yPos1);
                            addToSlot(port1, port2, southSlots, southMap, yPos2 - nodeHeight, nodeWidth
                                    + nodeHeight - yPos1);
                            addToSlot(port1, port2, eastSlots, eastMap, yPos2, 2 * nodeHeight
                                    + nodeWidth - yPos1);
                            break;
                        case SOUTH:
                            addToSlot(port1, port2, westSlots, westMap, -xPos2, nodeHeight - yPos1);
                            addToSlot(port1, port2, southSlots, southMap, nodeWidth - xPos2, nodeWidth
                                    + nodeHeight - yPos1);
                            break;
                        case WEST:
                            addToSlot(port1, port2, westSlots, westMap, nodeHeight
                                    - Math.max(yPos1, yPos2), nodeHeight - Math.min(yPos1, yPos2));
                            break;
                        }
                        break;
                    }
                }
            }

            // process routing to other layers
            if (layoutDirection == LayoutDirection.DOWN) {
                switch (placement) {
                case NORTH:
                    if (hasOutgoing(element, port1)) {
                        addToSlot(node, port1, northSlots, northMap, xPos1, Float.MAX_VALUE);
                        addToSlot(node, port1, eastSlots, eastMap, xPos1 - nodeWidth, Float.MAX_VALUE);
                    }
                    break;
                case EAST:
                    float fromPos = yPos1,
                    toPos = yPos1;
                    if (hasOutgoing(element, port1)) {
                        toPos = Float.MAX_VALUE;
                    }
                    if (hasIncoming(element, port1)) {
                        fromPos = -Float.MAX_VALUE;
                    }
                    if (!equal(fromPos, toPos)) {
                        addToSlot(node, port1, eastSlots, eastMap, fromPos, toPos);
                    }
                    break;
                case SOUTH:
                    if (hasIncoming(element, port1)) {
                        addToSlot(node, port1, southSlots, southMap, -Float.MAX_VALUE,
                                nodeWidth - xPos1);
                        addToSlot(node, port1, eastSlots, eastMap, -Float.MAX_VALUE,
                                nodeHeight + nodeWidth - xPos1);
                    }
                    break;
                case WEST:
                    fromPos = nodeHeight - yPos1;
                    toPos = fromPos;
                    if (hasOutgoing(element, port1)) {
                        fromPos = -Float.MAX_VALUE;
                    }
                    if (hasIncoming(element, port1)) {
                        toPos = Float.MAX_VALUE;
                    }
                    if (fromPos != toPos) {
                        addToSlot(node, port1, westSlots, westMap, fromPos, toPos);
                    }
                    break;
                }
            } else {
                switch (placement) {
                case NORTH:
                    float fromPos = xPos1,
                    toPos = xPos1;
                    if (hasOutgoing(element, port1)) {
                        toPos = Float.MAX_VALUE;
                    }
                    if (hasIncoming(element, port1)) {
                        fromPos = -Float.MAX_VALUE;
                    }
                    if (fromPos != toPos) {
                        addToSlot(node, port1, northSlots, northMap, fromPos, toPos);
                    }
                    break;
                case EAST:
                    if (hasIncoming(element, port1)) {
                        addToSlot(node, port1, eastSlots, eastMap, yPos1, Float.MAX_VALUE);
                        addToSlot(node, port1, southSlots, southMap, yPos1 - nodeHeight,
                                Float.MAX_VALUE);
                    }
                    break;
                case SOUTH:
                    fromPos = nodeWidth - xPos1;
                    toPos = fromPos;
                    if (hasOutgoing(element, port1)) {
                        fromPos = -Float.MAX_VALUE;
                    }
                    if (hasIncoming(element, port1)) {
                        toPos = Float.MAX_VALUE;
                    }
                    if (fromPos != toPos) {
                        addToSlot(node, port1, southSlots, southMap, fromPos, toPos);
                    }
                    break;
                case WEST:
                    if (hasOutgoing(element, port1)) {
                        addToSlot(node, port1, westSlots, westMap, -Float.MAX_VALUE, nodeHeight - yPos1);
                        addToSlot(node, port1, southSlots, southMap, -Float.MAX_VALUE, nodeWidth
                                + nodeHeight - yPos1);
                    }
                    break;
                }
            }
        }

        // assign ranks to all routing slots
        element.setRanks(assignRanks(northSlots), PortSide.NORTH);
        element.setRanks(assignRanks(eastSlots), PortSide.EAST);
        element.setRanks(assignRanks(southSlots), PortSide.SOUTH);
        element.setRanks(assignRanks(westSlots), PortSide.WEST);

        // calculate edge routing for all incoming or outgoing connections
        if (layoutDirection == LayoutDirection.DOWN) {
            for (LayerConnection connection : element.getIncomingConnections()) {
                KPort port = connection.getTargetPort();
                if (port != null) {
                    switch (LayoutOptions.getEnum(KimlLayoutUtil.getShapeLayout(port), PortSide.class)) {
                    case EAST:
                        int rank = getRankFor(port, eastSlots, element.getRanks(PortSide.EAST));
                        connection.setTargetSidePos(rank);
                        break;
                    case SOUTH:
                        rank = getRankFor(port, eastSlots, element.getRanks(PortSide.EAST));
                        connection.setTargetSidePos(rank);
                        rank = getRankFor(port, southSlots, element.getRanks(PortSide.SOUTH));
                        connection.setTargetFrontPos(rank);
                        break;
                    case WEST:
                        rank = getRankFor(port, westSlots, element.getRanks(PortSide.WEST));
                        connection.setTargetSidePos(-rank);
                        break;
                    }
                }
            }
            for (LayerConnection connection : element.getOutgoingConnections()) {
                KPort port = connection.getSourcePort();
                if (port != null) {
                    switch (LayoutOptions.getEnum(KimlLayoutUtil.getShapeLayout(port), PortSide.class)) {
                    case NORTH:
                        int rank = getRankFor(port, eastSlots, element.getRanks(PortSide.EAST));
                        connection.setSourceSidePos(rank);
                        rank = getRankFor(port, northSlots, element.getRanks(PortSide.NORTH));
                        connection.setSourceBackPos(rank);
                        break;
                    case EAST:
                        rank = getRankFor(port, eastSlots, element.getRanks(PortSide.EAST));
                        connection.setSourceSidePos(rank);
                        break;
                    case WEST:
                        rank = getRankFor(port, westSlots, element.getRanks(PortSide.WEST));
                        connection.setSourceSidePos(-rank);
                        break;
                    }
                }
            }
        } else {
            for (LayerConnection connection : element.getIncomingConnections()) {
                KPort port = connection.getTargetPort();
                if (port != null) {
                    switch (LayoutOptions.getEnum(KimlLayoutUtil.getShapeLayout(port), PortSide.class)) {
                    case SOUTH:
                        int rank = getRankFor(port, southSlots, element.getRanks(PortSide.SOUTH));
                        connection.setTargetSidePos(rank);
                        break;
                    case EAST:
                        rank = getRankFor(port, southSlots, element.getRanks(PortSide.SOUTH));
                        connection.setTargetSidePos(rank);
                        rank = getRankFor(port, eastSlots, element.getRanks(PortSide.EAST));
                        connection.setTargetFrontPos(rank);
                        break;
                    case NORTH:
                        rank = getRankFor(port, northSlots, element.getRanks(PortSide.NORTH));
                        connection.setTargetSidePos(-rank);
                        break;
                    }
                }
            }
            for (LayerConnection connection : element.getOutgoingConnections()) {
                KPort port = connection.getSourcePort();
                if (port != null) {
                    switch (LayoutOptions.getEnum(KimlLayoutUtil.getShapeLayout(port), PortSide.class)) {
                    case WEST:
                        int rank = getRankFor(port, southSlots, element.getRanks(PortSide.SOUTH));
                        connection.setSourceSidePos(rank);
                        rank = getRankFor(port, westSlots, element.getRanks(PortSide.WEST));
                        connection.setSourceBackPos(rank);
                        break;
                    case SOUTH:
                        rank = getRankFor(port, southSlots, element.getRanks(PortSide.SOUTH));
                        connection.setSourceSidePos(rank);
                        break;
                    case NORTH:
                        rank = getRankFor(port, northSlots, element.getRanks(PortSide.NORTH));
                        connection.setSourceSidePos(-rank);
                        break;
                    }
                }
            }
        }

        // calculate edge routing for all element loops
        for (ElementLoop loop : element.getLoops()) {
            PortSide placement1 = LayoutOptions.getEnum(KimlLayoutUtil.getShapeLayout(
                    loop.getSourcePort()), PortSide.class);
            PortSide placement2 = LayoutOptions.getEnum(KimlLayoutUtil.getShapeLayout(
                    loop.getTargetPort()), PortSide.class);
            if (placement1 == PortSide.NORTH || placement2 == PortSide.NORTH) {
                int rank = getRankFor(loop.getSourcePort(), northSlots,
                        element.getRanks(PortSide.NORTH));
                loop.setRoutePos(rank, PortSide.NORTH);
            }
            if (placement1 == PortSide.EAST || placement2 == PortSide.EAST
                    || placement1 == PortSide.NORTH && placement2 == PortSide.SOUTH
                    || placement1 == PortSide.SOUTH && placement2 == PortSide.NORTH) {
                int rank = getRankFor(loop.getSourcePort(), eastSlots, element.getRanks(PortSide.EAST));
                loop.setRoutePos(rank, PortSide.EAST);
            }
            if (placement1 == PortSide.SOUTH || placement2 == PortSide.SOUTH
                    || placement1 == PortSide.EAST && placement2 == PortSide.WEST
                    || placement1 == PortSide.WEST && placement2 == PortSide.EAST) {
                int rank = getRankFor(loop.getSourcePort(), southSlots,
                        element.getRanks(PortSide.SOUTH));
                loop.setRoutePos(rank, PortSide.SOUTH);
            }
            if (placement1 == PortSide.WEST || placement2 == PortSide.WEST) {
                int rank = getRankFor(loop.getSourcePort(), westSlots, element.getRanks(PortSide.WEST));
                loop.setRoutePos(rank, PortSide.WEST);
            }
        }
    }

    /**
     * Adds a given port to an appropriate routing slot.
     * 
     * @param node layout node that is being processed
     * @param port port to be inserted
     * @param slotList list of existing routing slots
     * @param slotMap mapping of ports to existing slots
     * @param fromPos starting position for the given port
     * @param toPos ending position for the given port
     */
    private void addToSlot(final KNode node, final KPort port, final List<RoutingSlot> slotList,
            final Map<KPort, RoutingSlot> slotMap, final float fromPos, final float toPos) {
        RoutingSlot slot = slotMap.get(port);
        if (slot == null && port.getEdges().size() == 1) {
            KEdge edge = port.getEdges().get(0);
            if (edge.getSourcePort() != port && edge.getSource() != node) {
                slot = slotMap.get(edge.getSourcePort());
                if (slot == null) {
                    slot = new RoutingSlot();
                    slotList.add(slot);
                    slotMap.put(edge.getSourcePort(), slot);
                }
            } else if (edge.getTargetPort() != port && edge.getTarget() != node) {
                slot = slotMap.get(edge.getTargetPort());
                if (slot == null) {
                    slot = new RoutingSlot();
                    slotList.add(slot);
                    slotMap.put(edge.getTargetPort(), slot);
                }
            }
        }
        if (slot == null) {
            slot = new RoutingSlot();
            slotList.add(slot);
        }
        if (!slot.ports.contains(port)) {
            slot.ports.add(port);
        }
        slot.start = Math.max(slot.start, fromPos);
        slot.end = Math.min(slot.end, toPos);
    }

    /**
     * Adds two ports to an appropriate routing slot.
     * 
     * @param port1 first port to be inserted
     * @param port2 second port to be inserted
     * @param slotList list of existing routing slots
     * @param slotMap mapping of ports to existing slots
     * @param fromPos starting position for the given port
     * @param toPos ending position for the given port
     */
    private void addToSlot(final KPort port1, final KPort port2, final List<RoutingSlot> slotList,
            final Map<KPort, RoutingSlot> slotMap, final float fromPos, final float toPos) {
        RoutingSlot slot = slotMap.get(port1);
        if (slot == null) {
            slot = slotMap.get(port2);
        }
        if (slot == null) {
            slot = new RoutingSlot();
            slotList.add(slot);
            slotMap.put(port1, slot);
            slotMap.put(port2, slot);
        }
        if (!slot.ports.contains(port1)) {
            slot.ports.add(port1);
        }
        if (!slot.ports.contains(port2)) {
            slot.ports.add(port2);
        }
        slot.start = Math.max(slot.start, fromPos);
        slot.end = Math.min(slot.end, toPos);
    }

    /**
     * Determines whether the given port has an outgoing connection.
     * 
     * @param element layer element that is being processed
     * @param port port to check
     * @return true if the given port has an outgoing connection
     */
    private boolean hasOutgoing(final LayerElement element, final KPort port) {
        for (LayerConnection connection : element.getOutgoingConnections()) {
            if (connection.getSourcePort() == port && connection.getTargetElement() != element) {
                return true;
            }
        }
        return false;
    }

    /**
     * Determines whether the given port has an incoming connection.
     * 
     * @param element layer element that is being processed
     * @param port port to check
     * @return true if the given port has an incoming connection
     */
    private boolean hasIncoming(final LayerElement element, final KPort port) {
        for (LayerConnection connection : element.getIncomingConnections()) {
            if (connection.getTargetPort() == port && connection.getSourceElement() != element) {
                return true;
            }
        }
        return false;
    }

    /**
     * Assigns slot ranks to all slots of a given list.
     * 
     * @param slotList list of slot ranks
     * @return number of assigned slot ranks
     */
    private int assignRanks(final List<RoutingSlot> slotList) {
        // sort list by start and end values using insertion sort
        LinkedList<RoutingSlot> sortedList = new LinkedList<RoutingSlot>();
        for (RoutingSlot slot : slotList) {
            ListIterator<RoutingSlot> slotIter = sortedList.listIterator();
            while (slotIter.hasNext()) {
                if (slotIter.next().compareTo(slot) > 0) {
                    slotIter.previous();
                    break;
                }
            }
            slotIter.add(slot);
        }

        // assign ranks to each routing slot
        int slotRanks = 0;
        List<List<RoutingSlot>> routingLayers = new LinkedList<List<RoutingSlot>>();
        for (RoutingSlot slot : sortedList) {
            boolean foundPlace = false;
            int rank = 1;
            for (List<RoutingSlot> routingLayer : routingLayers) {
                boolean feasible = true;
                for (RoutingSlot layerSlot : routingLayer) {
                    if (slot.start < layerSlot.end && slot.end > layerSlot.start) {
                        feasible = false;
                        break;
                    }
                }
                if (feasible) {
                    slot.rank = rank;
                    routingLayer.add(slot);
                    foundPlace = true;
                    break;
                }
                rank++;
            }
            if (!foundPlace) {
                slot.rank = rank;
                List<RoutingSlot> routingLayer = new LinkedList<RoutingSlot>();
                routingLayer.add(slot);
                routingLayers.add(routingLayer);
                slotRanks++;
            }
        }

        return slotRanks;
    }

    /**
     * Returns the routing rank for a given port.
     * 
     * @param port port to look up
     * @param slotList list of available routing slots
     * @param ranks number of assigned ranks
     * @return the assigned rank, or <code>ranks</code> if no rank is found
     */
    private int getRankFor(final KPort port, final List<RoutingSlot> slotList, final int ranks) {
        for (RoutingSlot slot : slotList) {
            if (slot.ports.contains(port)) {
                return slot.rank;
            }
        }
        return ranks;
    }

    private static final float EQUAL_THRES = 0.0001f;

    private static boolean equal(final float f1, final float f2) {
        return Math.abs(f1 - f2) < EQUAL_THRES;
    }

}

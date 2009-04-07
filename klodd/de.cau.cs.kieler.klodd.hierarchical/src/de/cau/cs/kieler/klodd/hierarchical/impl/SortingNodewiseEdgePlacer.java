/******************************************************************************
 * KIELER - Kiel Integrated Environment for Layout for the Eclipse RCP
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

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import de.cau.cs.kieler.core.alg.AbstractAlgorithm;
import de.cau.cs.kieler.core.kgraph.KEdge;
import de.cau.cs.kieler.core.kgraph.KNode;
import de.cau.cs.kieler.core.kgraph.KPort;
import de.cau.cs.kieler.kiml.layout.klayoutdata.KShapeLayout;
import de.cau.cs.kieler.kiml.layout.options.LayoutDirection;
import de.cau.cs.kieler.kiml.layout.options.LayoutOptions;
import de.cau.cs.kieler.kiml.layout.options.PortSide;
import de.cau.cs.kieler.kiml.layout.util.KimlLayoutUtil;
import de.cau.cs.kieler.klodd.hierarchical.modules.INodewiseEdgePlacer;
import de.cau.cs.kieler.klodd.hierarchical.structures.*;


/**
 * Nodewise edge placer implementation that sorts the edges and gives
 * them slot ranks according to the result.
 * 
 * @author msp
 */
public class SortingNodewiseEdgePlacer extends AbstractAlgorithm implements
		INodewiseEdgePlacer {

	/**
	 * Routing slot used to route edges around node elements.
	 */
	private static class RoutingSlot {
		float start = Float.MAX_VALUE, end = Float.MIN_VALUE;
		int rank;
		List<KPort> ports = new LinkedList<KPort>();
	}
	
	/** layout direction configured for the given layered graph */
	private LayoutDirection layoutDirection;
	
	/* (non-Javadoc)
	 * @see de.cau.cs.kieler.klodd.hierarchical.modules.INodewiseEdgePlacer#placeEdges(de.cau.cs.kieler.klodd.hierarchical.structures.LayeredGraph)
	 */
	public void placeEdges(LayeredGraph layeredGraph) {
		getMonitor().begin("Nodewise edge placement", 1);
		
		layoutDirection = layeredGraph.getLayoutDirection();
		// calculate the connection routing for each layer element
		for (Layer layer : layeredGraph.getLayers()) {
			for (LayerElement element : layer.getElements()) {
				placeEdges(element);
			}
		}
		
		getMonitor().done();
	}
	
	/**
	 * Calculates placements for the edges incident with the given layer element,
	 * if its element object is a regular node.
	 * 
	 * @param element layer element to process
	 */
	private void placeEdges(LayerElement element) {
		Object elemObj = element.getElemObj();
		if (elemObj instanceof KNode) {
			KNode node = (KNode)elemObj;
			if (node.getPorts().isEmpty()) return;
			List<RoutingSlot> northSlots = new LinkedList<RoutingSlot>();
			List<RoutingSlot> eastSlots = new LinkedList<RoutingSlot>();
			List<RoutingSlot> southSlots = new LinkedList<RoutingSlot>();
			List<RoutingSlot> westSlots = new LinkedList<RoutingSlot>();
			Map<KPort, RoutingSlot> northMap = new HashMap<KPort, RoutingSlot>();
			Map<KPort, RoutingSlot> eastMap = new HashMap<KPort, RoutingSlot>();
			Map<KPort, RoutingSlot> southMap = new HashMap<KPort, RoutingSlot>();
			Map<KPort, RoutingSlot> westMap = new HashMap<KPort, RoutingSlot>();
			KShapeLayout nodeLayout = KimlLayoutUtil.getShapeLayout(node);
			
			for (KPort port : node.getPorts()) {
			    KShapeLayout portLayout = KimlLayoutUtil.getShapeLayout(port);
				PortSide placement = LayoutOptions.getPortSide(portLayout);
				float xPos = portLayout.getXpos() + portLayout.getWidth() / 2;
				float yPos = portLayout.getYpos() + portLayout.getHeight() / 2;
				// process self-loops over the given port
				for (KEdge edge : port.getEdges()) {
					if (edge.getSourcePort() == port && edge.getTarget() == node) {
						ElementLoop loop = new ElementLoop(edge, element, port, edge.getTargetPort());
						element.getLoops().add(loop);
						KShapeLayout targetLayout = KimlLayoutUtil.getShapeLayout(edge.getTargetPort());
						PortSide placement2 = LayoutOptions.getPortSide(targetLayout);
						float xPos2 = targetLayout.getXpos()
							    + targetLayout.getWidth() / 2;
						float yPos2 = targetLayout.getYpos()
							    + targetLayout.getHeight() / 2;
						switch (placement) {
						case NORTH:
							switch (placement2) {
							case NORTH:
								addToSlot(port, edge.getTargetPort(), northSlots, northMap,
										Math.min(xPos, xPos2), Math.max(xPos, xPos2));
								break;
							case EAST:
								addToSlot(port, edge.getTargetPort(), northSlots, northMap,
										xPos, nodeLayout.getWidth());
								addToSlot(port, edge.getTargetPort(), eastSlots, eastMap,
										0.0f, yPos2);
								break;
							case SOUTH:
								addToSlot(port, edge.getTargetPort(), northSlots, northMap,
										xPos, nodeLayout.getWidth());
								addToSlot(port, edge.getTargetPort(), eastSlots, eastMap,
										0.0f, nodeLayout.getHeight());
								addToSlot(port, edge.getTargetPort(), southSlots, southMap,
										xPos2, nodeLayout.getWidth());
								break;
							case WEST:
								addToSlot(port, edge.getTargetPort(), northSlots, northMap,
										0.0f, xPos);
								addToSlot(port, edge.getTargetPort(), westSlots, westMap,
										0.0f, yPos2);
								break;
							}
							break;
						case EAST:
							switch (placement2) {
							case NORTH:
								addToSlot(port, edge.getTargetPort(), eastSlots, eastMap,
										0.0f, yPos);
								addToSlot(port, edge.getTargetPort(), northSlots, northMap,
										xPos2, nodeLayout.getWidth());
								break;
							case EAST:
								addToSlot(port, edge.getTargetPort(), eastSlots, eastMap,
										Math.min(yPos, yPos2), Math.max(yPos, yPos2));
								break;
							case SOUTH:
								addToSlot(port, edge.getTargetPort(), eastSlots, eastMap,
										yPos, nodeLayout.getHeight());
								addToSlot(port, edge.getTargetPort(), southSlots, southMap,
										xPos2, nodeLayout.getWidth());
								break;
							case WEST:
								addToSlot(port, edge.getTargetPort(), eastSlots, eastMap,
										yPos, nodeLayout.getHeight());
								addToSlot(port, edge.getTargetPort(), southSlots, southMap,
										0.0f, nodeLayout.getWidth());
								addToSlot(port, edge.getTargetPort(), westSlots, westMap,
										yPos2, nodeLayout.getHeight());
								break;
							}
							break;
						case SOUTH:
							switch (placement2) {
							case NORTH:
								addToSlot(port, edge.getTargetPort(), southSlots, southMap,
										xPos, nodeLayout.getWidth());
								addToSlot(port, edge.getTargetPort(), eastSlots, eastMap,
										0.0f, nodeLayout.getHeight());
								addToSlot(port, edge.getTargetPort(), northSlots, northMap,
										xPos2, nodeLayout.getWidth());
								break;
							case EAST:
								addToSlot(port, edge.getTargetPort(), southSlots, southMap,
										xPos, nodeLayout.getWidth());
								addToSlot(port, edge.getTargetPort(), eastSlots, eastMap,
										yPos2, nodeLayout.getHeight());
								break;
							case SOUTH:
								addToSlot(port, edge.getTargetPort(), southSlots, southMap,
										Math.min(xPos, xPos2), Math.max(xPos, xPos2));
								break;
							case WEST:
								addToSlot(port, edge.getTargetPort(), southSlots, southMap,
										0.0f, xPos);
								addToSlot(port, edge.getTargetPort(), westSlots, westMap,
										yPos2, nodeLayout.getHeight());
								break;
							}
							break;
						case WEST:
							switch (placement2) {
							case NORTH:
								addToSlot(port, edge.getTargetPort(), westSlots, westMap,
										0.0f, yPos);
								addToSlot(port, edge.getTargetPort(), northSlots, northMap,
										0.0f, xPos2);
								break;
							case EAST:
								addToSlot(port, edge.getTargetPort(), westSlots, westMap,
										yPos, nodeLayout.getHeight());
								addToSlot(port, edge.getTargetPort(), southSlots, southMap,
										0.0f, nodeLayout.getWidth());
								addToSlot(port, edge.getTargetPort(), eastSlots, eastMap,
										yPos2, nodeLayout.getHeight());
								break;
							case SOUTH:
								addToSlot(port, edge.getTargetPort(), westSlots, westMap,
										yPos, nodeLayout.getHeight());
								addToSlot(port, edge.getTargetPort(), southSlots, southMap,
										0.0f, xPos2);
								break;
							case WEST:
								addToSlot(port, edge.getTargetPort(), westSlots, westMap,
										Math.min(yPos, yPos2), Math.max(yPos, yPos2));
								break;
							}
							break;
						}
					}
				}
				// process routing to other layers
				if (layoutDirection == LayoutDirection.VERTICAL) {
					switch (placement) {
					case NORTH:
						if (hasOutgoing(element, port)) {
							addToSlot(node, port, northSlots, northMap, xPos, nodeLayout.getWidth());
							addToSlot(node, port, eastSlots, eastMap, 0.0f, nodeLayout.getHeight());
						}
						break;
					case EAST:
						if (!port.getEdges().isEmpty()) {
							float fromPos = yPos, toPos = yPos;
							if (hasOutgoing(element, port))
								toPos = nodeLayout.getHeight();
							if (hasIncoming(element, port))
								fromPos = 0.0f;
							addToSlot(node, port, eastSlots, eastMap, fromPos, toPos);
						}
						break;
					case SOUTH:
						if (hasIncoming(element, port)) {
							addToSlot(node, port, southSlots, southMap, xPos, nodeLayout.getWidth());
							addToSlot(node, port, eastSlots, eastMap, 0.0f, nodeLayout.getHeight());
						}
						break;
					case WEST:
						if (!port.getEdges().isEmpty()) {
							float fromPos = yPos, toPos = yPos;
							if (hasOutgoing(element, port))
								toPos = nodeLayout.getHeight();
							if (hasIncoming(element, port))
								fromPos = 0.0f;
							addToSlot(node, port, westSlots, westMap, fromPos, toPos);
						}
						break;
					}
				}
				else {
					switch (placement) {
					case NORTH:
						if (!port.getEdges().isEmpty()) {
							float fromPos = xPos, toPos = xPos;
							if (hasOutgoing(element, port))
								toPos = nodeLayout.getWidth();
							if (hasIncoming(element, port))
								fromPos = 0.0f;
							addToSlot(node, port, northSlots, northMap, fromPos, toPos);
						}
						break;
					case EAST:
						if (hasIncoming(element, port)) {
							addToSlot(node, port, eastSlots, eastMap, yPos, nodeLayout.getHeight());
							addToSlot(node, port, southSlots, southMap, 0.0f, nodeLayout.getWidth());
						}
						break;
					case SOUTH:
						if (!port.getEdges().isEmpty()) {
							float fromPos = xPos, toPos = xPos;
							if (hasOutgoing(element, port))
								toPos = nodeLayout.getWidth();
							if (hasIncoming(element, port))
								fromPos = 0.0f;
							addToSlot(node, port, southSlots, southMap, fromPos, toPos);
						}
						break;
					case WEST:
						if (hasOutgoing(element, port)) {
							addToSlot(node, port, westSlots, westMap, yPos, nodeLayout.getHeight());
							addToSlot(node, port, southSlots, southMap, 0.0f, nodeLayout.getWidth());
						}
						break;
					}
				}
			}
			
			// assign ranks to all routing slots 
			element.northRanks = assignRanks(northSlots, nodeLayout.getWidth());
			element.eastRanks = assignRanks(eastSlots, nodeLayout.getHeight());
			element.southRanks = assignRanks(southSlots, nodeLayout.getWidth());
			element.westRanks = assignRanks(westSlots, nodeLayout.getHeight());
			
			// calculate edge routing for all incoming or outgoing connections
			if (layoutDirection == LayoutDirection.VERTICAL) {
				for (LayerConnection connection : element.getIncomingConnections()) {
					KPort port = connection.getTargetPort();
					switch (LayoutOptions.getPortSide(
					        KimlLayoutUtil.getShapeLayout(port))) {
					case EAST:
						int rank = getRankFor(port, eastSlots, element.eastRanks);
						connection.targetSidePos = rank;
						break;
					case SOUTH:
						rank = getRankFor(port, eastSlots, element.eastRanks);
						connection.targetSidePos = rank;
						rank = getRankFor(port, southSlots, element.southRanks);
						connection.targetFrontPos = rank;
						break;
					case WEST:
						rank = getRankFor(port, westSlots, element.westRanks);
						connection.targetSidePos = -rank;
						break;
					}
				}
				for (LayerConnection connection : element.getOutgoingConnections()) {
					KPort port = connection.getSourcePort();
					switch (LayoutOptions.getPortSide(
                            KimlLayoutUtil.getShapeLayout(port))) {
					case NORTH:
						int rank = getRankFor(port, eastSlots, element.eastRanks);
						connection.sourceSidePos = rank;
						rank = getRankFor(port, northSlots, element.northRanks);
						connection.sourceBackPos = rank;
						break;
					case EAST:
						rank = getRankFor(port, eastSlots, element.eastRanks);
						connection.sourceSidePos = rank;
						break;
					case WEST:
						rank = getRankFor(port, westSlots, element.westRanks);
						connection.sourceSidePos = -rank;
						break;
					}
				}
			}
			else {
				for (LayerConnection connection : element.getIncomingConnections()) {
					KPort port = connection.getTargetPort();
					switch (LayoutOptions.getPortSide(
                            KimlLayoutUtil.getShapeLayout(port))) {
					case SOUTH:
						int rank = getRankFor(port, southSlots, element.southRanks);
						connection.targetSidePos = rank;
						break;
					case EAST:
						rank = getRankFor(port, southSlots, element.southRanks);
						connection.targetSidePos = rank;
						rank = getRankFor(port, eastSlots, element.eastRanks);
						connection.targetFrontPos = rank;
						break;
					case NORTH:
						rank = getRankFor(port, northSlots, element.northRanks);
						connection.targetSidePos = -rank;
						break;
					}
				}
				for (LayerConnection connection : element.getOutgoingConnections()) {
					KPort port = connection.getSourcePort();
					switch (LayoutOptions.getPortSide(
                            KimlLayoutUtil.getShapeLayout(port))) {
					case WEST:
						int rank = getRankFor(port, southSlots, element.southRanks);
						connection.sourceSidePos = rank;
						rank = getRankFor(port, westSlots, element.westRanks);
						connection.sourceBackPos = rank;
						break;
					case SOUTH:
						rank = getRankFor(port, southSlots, element.southRanks);
						connection.sourceSidePos = rank;
						break;
					case NORTH:
						rank = getRankFor(port, northSlots, element.northRanks);
						connection.sourceSidePos = -rank;
						break;
					}
				}
			}
			
			// calculate edge routing for all element loops
			for (ElementLoop loop : element.getLoops()) {
				PortSide placement1 = LayoutOptions.getPortSide(
                        KimlLayoutUtil.getShapeLayout(loop.getSourcePort()));
				PortSide placement2 = LayoutOptions.getPortSide(
                        KimlLayoutUtil.getShapeLayout(loop.getTargetPort()));
				if (placement1 == PortSide.NORTH || placement2 == PortSide.NORTH) {
					int rank = getRankFor(loop.getSourcePort(), northSlots, element.northRanks);
					loop.northRoutePos = rank;
				}
				if (placement1 == PortSide.EAST || placement2 == PortSide.EAST
						|| placement1 == PortSide.NORTH && placement2 == PortSide.SOUTH
						|| placement1 == PortSide.SOUTH && placement2 == PortSide.NORTH) {
					int rank = getRankFor(loop.getSourcePort(), eastSlots, element.eastRanks);
					loop.eastRoutePos = rank;
				}
				if (placement1 == PortSide.SOUTH || placement2 == PortSide.SOUTH
						|| placement1 == PortSide.EAST && placement2 == PortSide.WEST
						|| placement1 == PortSide.WEST && placement2 == PortSide.EAST) {
					int rank = getRankFor(loop.getSourcePort(), southSlots, element.southRanks);
					loop.southRoutePos = rank;
				}
				if (placement1 == PortSide.WEST || placement2 == PortSide.WEST) {
					int rank = getRankFor(loop.getSourcePort(), westSlots, element.westRanks);
					loop.westRoutePos = rank;
				}
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
	private void addToSlot(KNode node, KPort port, List<RoutingSlot> slotList,
			Map<KPort, RoutingSlot> slotMap, float fromPos, float toPos) {
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
			}
			else if (edge.getTargetPort() != port && edge.getTarget() != node) {
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
		if (!slot.ports.contains(port))
			slot.ports.add(port);
		slot.start = Math.min(slot.start, fromPos);
		slot.end = Math.max(slot.end, toPos);
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
	private void addToSlot(KPort port1, KPort port2, List<RoutingSlot> slotList,
			Map<KPort, RoutingSlot> slotMap, float fromPos, float toPos) {
		RoutingSlot slot = slotMap.get(port1);
		if (slot == null)
			slot = slotMap.get(port2);
		if (slot == null) {
			slot = new RoutingSlot();
			slotList.add(slot);
			slotMap.put(port1, slot);
			slotMap.put(port2, slot);
		}
		if (!slot.ports.contains(port1))
			slot.ports.add(port1);
		if (!slot.ports.contains(port2))
			slot.ports.add(port2);
		slot.start = Math.min(slot.start, fromPos);
		slot.end = Math.max(slot.end, toPos);
	}
	
	/**
     * Determines whether the given port has an outgoing connection.
     *
     * @param element layer element that is being processed
     * @param port port to check
     * @return true if the given port has an outgoing connection
     */
    private boolean hasOutgoing(LayerElement element, KPort port) {
        for (LayerConnection connection : element.getOutgoingConnections()) {
                if (connection.getSourcePort() == port) {
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
    private boolean hasIncoming(LayerElement element, KPort port) {
        for (LayerConnection connection : element.getIncomingConnections()) {
                if (connection.getTargetPort() == port) {
                        return true;
                }
        }
        return false;
    }
    
    /**
     * Assigns slot ranks to all slots of a given list.
     * 
     * @param slotList list of slot ranks
     * @param size size of the node side for the given slots
     * @return number of assigned slot ranks
     */
    private int assignRanks(List<RoutingSlot> slotList, final float size) {
    	// sort list by start and end values
    	Collections.sort(slotList, new Comparator<RoutingSlot>() {
			public int compare(RoutingSlot slot1, RoutingSlot slot2) {
				if (slot1.start > 0.0f && slot2.start > 0.0f)
					return -Float.compare(slot1.start, slot2.start);
				else if (slot1.end < size && slot2.end < size)
					return Float.compare(slot1.end, slot2.end);
				else if (slot1.start > 0.0f && slot1.end < size)
					return -1;
				else if (slot2.start > 0.0f && slot2.end < size)
					return 1;
				else return 0;
			}
    	});
    	
    	// assign ranks to each routing slot
    	int slotRanks = 0;
    	List<List<RoutingSlot>> routingLayers = new LinkedList<List<RoutingSlot>>();
    	for (RoutingSlot slot : slotList) {
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
    private int getRankFor(KPort port, List<RoutingSlot> slotList, int ranks) {
    	for (RoutingSlot slot : slotList) {
    		if (slot.ports.contains(port))
    			return slot.rank;
    	}
    	return ranks;
    }

}

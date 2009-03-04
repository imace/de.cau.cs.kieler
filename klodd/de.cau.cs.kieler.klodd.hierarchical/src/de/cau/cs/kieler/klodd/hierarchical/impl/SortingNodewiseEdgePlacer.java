package de.cau.cs.kieler.klodd.hierarchical.impl;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import de.cau.cs.kieler.core.alg.AbstractAlgorithm;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KDimension;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutEdge;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutNode;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutPort;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KPortLayout;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutOption;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KPortPlacement;
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
		List<KLayoutPort> ports = new LinkedList<KLayoutPort>();
	}
	
	/** layout direction configured for the given layered graph */
	private KLayoutOption layoutDirection;
	
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
		if (elemObj instanceof KLayoutNode) {
			KLayoutNode node = (KLayoutNode)elemObj;
			if (node.getPorts().isEmpty()) return;
			List<RoutingSlot> northSlots = new LinkedList<RoutingSlot>();
			List<RoutingSlot> eastSlots = new LinkedList<RoutingSlot>();
			List<RoutingSlot> southSlots = new LinkedList<RoutingSlot>();
			List<RoutingSlot> westSlots = new LinkedList<RoutingSlot>();
			Map<KLayoutPort, RoutingSlot> northMap = new HashMap<KLayoutPort, RoutingSlot>();
			Map<KLayoutPort, RoutingSlot> eastMap = new HashMap<KLayoutPort, RoutingSlot>();
			Map<KLayoutPort, RoutingSlot> southMap = new HashMap<KLayoutPort, RoutingSlot>();
			Map<KLayoutPort, RoutingSlot> westMap = new HashMap<KLayoutPort, RoutingSlot>();
			KDimension nodeSize = node.getLayout().getSize();
			
			for (KLayoutPort port : node.getPorts()) {
				KPortPlacement placement = port.getLayout().getPlacement();
				float xPos = port.getLayout().getLocation().getX()
					+ port.getLayout().getSize().getWidth() / 2;
				float yPos = port.getLayout().getLocation().getY()
					+ port.getLayout().getSize().getHeight() / 2;
				// process self-loops over the given port
				for (KLayoutEdge edge : port.getEdges()) {
					if (edge.getSourcePort() == port && edge.getTarget() == node) {
						ElementLoop loop = new ElementLoop(edge, element, port, edge.getTargetPort());
						element.getLoops().add(loop);
						KPortPlacement placement2 = edge.getTargetPort().getLayout().getPlacement();
						KPortLayout targetLayout = edge.getTargetPort().getLayout();
						float xPos2 = targetLayout.getLocation().getX()
							+ targetLayout.getSize().getWidth() / 2;
						float yPos2 = targetLayout.getLocation().getY()
							+ targetLayout.getSize().getHeight() / 2;
						switch (placement) {
						case NORTH:
							switch (placement2) {
							case NORTH:
								addToSlot(port, edge.getTargetPort(), northSlots, northMap,
										Math.min(xPos, xPos2), Math.max(xPos, xPos2));
								break;
							case EAST:
								addToSlot(port, edge.getTargetPort(), northSlots, northMap,
										xPos, nodeSize.getWidth());
								addToSlot(port, edge.getTargetPort(), eastSlots, eastMap,
										0.0f, yPos2);
								break;
							case SOUTH:
								addToSlot(port, edge.getTargetPort(), northSlots, northMap,
										xPos, nodeSize.getWidth());
								addToSlot(port, edge.getTargetPort(), eastSlots, eastMap,
										0.0f, nodeSize.getHeight());
								addToSlot(port, edge.getTargetPort(), southSlots, southMap,
										xPos2, nodeSize.getWidth());
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
										xPos2, nodeSize.getWidth());
								break;
							case EAST:
								addToSlot(port, edge.getTargetPort(), eastSlots, eastMap,
										Math.min(yPos, yPos2), Math.max(yPos, yPos2));
								break;
							case SOUTH:
								addToSlot(port, edge.getTargetPort(), eastSlots, eastMap,
										yPos, nodeSize.getHeight());
								addToSlot(port, edge.getTargetPort(), southSlots, southMap,
										xPos2, nodeSize.getWidth());
								break;
							case WEST:
								addToSlot(port, edge.getTargetPort(), eastSlots, eastMap,
										yPos, nodeSize.getHeight());
								addToSlot(port, edge.getTargetPort(), southSlots, southMap,
										0.0f, nodeSize.getWidth());
								addToSlot(port, edge.getTargetPort(), westSlots, westMap,
										yPos2, nodeSize.getHeight());
								break;
							}
							break;
						case SOUTH:
							switch (placement2) {
							case NORTH:
								addToSlot(port, edge.getTargetPort(), southSlots, southMap,
										xPos, nodeSize.getWidth());
								addToSlot(port, edge.getTargetPort(), eastSlots, eastMap,
										0.0f, nodeSize.getHeight());
								addToSlot(port, edge.getTargetPort(), northSlots, northMap,
										xPos2, nodeSize.getWidth());
								break;
							case EAST:
								addToSlot(port, edge.getTargetPort(), southSlots, southMap,
										xPos, nodeSize.getWidth());
								addToSlot(port, edge.getTargetPort(), eastSlots, eastMap,
										yPos2, nodeSize.getHeight());
								break;
							case SOUTH:
								addToSlot(port, edge.getTargetPort(), southSlots, southMap,
										Math.min(xPos, xPos2), Math.max(xPos, xPos2));
								break;
							case WEST:
								addToSlot(port, edge.getTargetPort(), southSlots, southMap,
										0.0f, xPos);
								addToSlot(port, edge.getTargetPort(), westSlots, westMap,
										yPos2, nodeSize.getHeight());
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
										yPos, nodeSize.getHeight());
								addToSlot(port, edge.getTargetPort(), southSlots, southMap,
										0.0f, nodeSize.getWidth());
								addToSlot(port, edge.getTargetPort(), eastSlots, eastMap,
										yPos2, nodeSize.getHeight());
								break;
							case SOUTH:
								addToSlot(port, edge.getTargetPort(), westSlots, westMap,
										yPos, nodeSize.getHeight());
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
				if (layoutDirection == KLayoutOption.VERTICAL) {
					switch (placement) {
					case NORTH:
						if (hasOutgoing(element, port)) {
							addToSlot(node, port, northSlots, northMap, xPos, nodeSize.getWidth());
							addToSlot(node, port, eastSlots, eastMap, 0.0f, nodeSize.getHeight());
						}
						break;
					case EAST:
						if (!port.getEdges().isEmpty()) {
							float fromPos = yPos, toPos = yPos;
							if (hasOutgoing(element, port))
								toPos = nodeSize.getHeight();
							if (hasIncoming(element, port))
								fromPos = 0.0f;
							addToSlot(node, port, eastSlots, eastMap, fromPos, toPos);
						}
						break;
					case SOUTH:
						if (hasIncoming(element, port)) {
							addToSlot(node, port, southSlots, southMap, xPos, nodeSize.getWidth());
							addToSlot(node, port, eastSlots, eastMap, 0.0f, nodeSize.getHeight());
						}
						break;
					case WEST:
						if (!port.getEdges().isEmpty()) {
							float fromPos = yPos, toPos = yPos;
							if (hasOutgoing(element, port))
								toPos = nodeSize.getHeight();
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
								toPos = nodeSize.getWidth();
							if (hasIncoming(element, port))
								fromPos = 0.0f;
							addToSlot(node, port, northSlots, northMap, fromPos, toPos);
						}
						break;
					case EAST:
						if (hasIncoming(element, port)) {
							addToSlot(node, port, eastSlots, eastMap, yPos, nodeSize.getHeight());
							addToSlot(node, port, southSlots, southMap, 0.0f, nodeSize.getWidth());
						}
						break;
					case SOUTH:
						if (!port.getEdges().isEmpty()) {
							float fromPos = xPos, toPos = xPos;
							if (hasOutgoing(element, port))
								toPos = nodeSize.getWidth();
							if (hasIncoming(element, port))
								fromPos = 0.0f;
							addToSlot(node, port, southSlots, southMap, fromPos, toPos);
						}
						break;
					case WEST:
						if (hasOutgoing(element, port)) {
							addToSlot(node, port, westSlots, westMap, yPos, nodeSize.getHeight());
							addToSlot(node, port, southSlots, southMap, 0.0f, nodeSize.getWidth());
						}
						break;
					}
				}
			}
			
			// assign ranks to all routing slots 
			element.northRanks = assignRanks(northSlots, nodeSize.getWidth());
			element.eastRanks = assignRanks(eastSlots, nodeSize.getHeight());
			element.southRanks = assignRanks(southSlots, nodeSize.getWidth());
			element.westRanks = assignRanks(westSlots, nodeSize.getHeight());
			
			// calculate edge routing for all incoming or outgoing connections
			if (layoutDirection == KLayoutOption.VERTICAL) {
				for (LayerConnection connection : element.getIncomingConnections()) {
					KLayoutPort port = connection.getTargetPort();
					switch (port.getLayout().getPlacement()) {
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
					KLayoutPort port = connection.getSourcePort();
					switch (port.getLayout().getPlacement()) {
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
					KLayoutPort port = connection.getTargetPort();
					switch (port.getLayout().getPlacement()) {
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
					KLayoutPort port = connection.getSourcePort();
					switch (port.getLayout().getPlacement()) {
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
				KPortPlacement placement1 = loop.getSourcePort().getLayout().getPlacement();
				KPortPlacement placement2 = loop.getTargetPort().getLayout().getPlacement();
				if (placement1 == KPortPlacement.NORTH || placement2 == KPortPlacement.NORTH) {
					int rank = getRankFor(loop.getSourcePort(), northSlots, element.northRanks);
					loop.northRoutePos = rank;
				}
				if (placement1 == KPortPlacement.EAST || placement2 == KPortPlacement.EAST
						|| placement1 == KPortPlacement.NORTH && placement2 == KPortPlacement.SOUTH
						|| placement1 == KPortPlacement.SOUTH && placement2 == KPortPlacement.NORTH) {
					int rank = getRankFor(loop.getSourcePort(), eastSlots, element.eastRanks);
					loop.eastRoutePos = rank;
				}
				if (placement1 == KPortPlacement.SOUTH || placement2 == KPortPlacement.SOUTH
						|| placement1 == KPortPlacement.EAST && placement2 == KPortPlacement.WEST
						|| placement1 == KPortPlacement.WEST && placement2 == KPortPlacement.EAST) {
					int rank = getRankFor(loop.getSourcePort(), southSlots, element.southRanks);
					loop.southRoutePos = rank;
				}
				if (placement1 == KPortPlacement.WEST || placement2 == KPortPlacement.WEST) {
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
	private void addToSlot(KLayoutNode node, KLayoutPort port, List<RoutingSlot> slotList,
			Map<KLayoutPort, RoutingSlot> slotMap, float fromPos, float toPos) {
		RoutingSlot slot = slotMap.get(port);
		if (slot == null && port.getEdges().size() == 1) {
			KLayoutEdge edge = port.getEdges().get(0);
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
	private void addToSlot(KLayoutPort port1, KLayoutPort port2, List<RoutingSlot> slotList,
			Map<KLayoutPort, RoutingSlot> slotMap, float fromPos, float toPos) {
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
    private boolean hasOutgoing(LayerElement element, KLayoutPort port) {
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
    private boolean hasIncoming(LayerElement element, KLayoutPort port) {
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
    private int getRankFor(KLayoutPort port, List<RoutingSlot> slotList, int ranks) {
    	for (RoutingSlot slot : slotList) {
    		if (slot.ports.contains(port))
    			return slot.rank;
    	}
    	return ranks;
    }

}

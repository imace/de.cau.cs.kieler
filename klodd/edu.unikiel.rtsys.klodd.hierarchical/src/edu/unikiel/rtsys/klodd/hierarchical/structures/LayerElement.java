package edu.unikiel.rtsys.klodd.hierarchical.structures;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.*;
import edu.unikiel.rtsys.klodd.core.util.LayoutGraphs;

/**
 * A layer element representing a node or a long edge in the layered graph.
 * 
 * @author msp
 */
public class LayerElement {

	/**
	 * Routing slot used to route edges around node elements.
	 */
	private class RoutingSlot {
		float start = Float.MAX_VALUE, end = Float.MIN_VALUE;
		int rank;
		List<KPort> ports = new LinkedList<KPort>();
	}
	
	/** value to use if the rank is undefined */
	public static final int UNDEF_RANK = -1;
	
	/** rank of this element inside the containing layer */
	public int rank = UNDEF_RANK;
	/** linear segment containing this layer element */
	public LinearSegment linearSegment = null;
	
	/** the element object */
	private Object elemObj;
	/** the containing layer */
	private Layer layer;
	/** are the ports of this layer element fixed? */
	private boolean fixedPorts;
	/** number of rank numbers consumed by this layer element */
	private int rankWidth;
	/** the new position that is determined for this layer element */
	private KPoint position;
	/** the total crosswise dimension */
	private float totalCrosswiseDim = -1.0f;
	/** the number of routing slot ranks on north side */
	private int northRanks = 0;
	/** the number of routing slot ranks on east side */
	private int eastRanks = 0;
	/** the number of routing slot ranks on south side */
	private int southRanks = 0;
	/** the number of routing slot ranks on west side */
	private int westRanks = 0;
	/** the list of incoming layer connections */
	private List<LayerConnection> incoming = new LinkedList<LayerConnection>();
	/** the list of outgoing layer connections */
	private List<LayerConnection> outgoing = new LinkedList<LayerConnection>();
	/** the list of element loop */
	private List<ElementLoop> loops = new LinkedList<ElementLoop>();
	/** map of ports to port ranks for forward layer sweep */
	private Map<KPort, Integer> forwardPortRanks = null;
	/** map of ports to port ranks for backwards layer sweep */
	private Map<KPort, Integer> backwardsPortRanks = null;
	
	/**
	 * Creates a layer element in an existing layer.
	 * 
	 * @param obj the element object
	 * @param layer the containing layer
	 */
	public LayerElement(Object obj, Layer layer) {
		this.elemObj = obj;
		this.layer = layer;
		this.position = KimlLayoutGraphFactory.eINSTANCE.createKPoint();
		
		if (obj instanceof KNodeGroup) {
			// the layer element is a node group
			KNodeGroup node = (KNodeGroup)obj;
			fixedPorts = node.getLayout().getLayoutOptions().contains(LAYOUT_OPTION.FIXED_PORTS)
				|| node.getPorts().isEmpty();
			rankWidth = Math.max(node.getPorts().size(), 1);
		}
		else if (obj instanceof KPort) {
			// the layer element is a port
			fixedPorts = true;
			rankWidth = 1;
		}
		else if (obj instanceof KEdge) {
			// the layer element is a long edge
			fixedPorts = true;
			rankWidth = 1;
		}
		else
			throw new IllegalArgumentException("Unknown object type received.");
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		if (elemObj instanceof KNodeGroup) {
			KNodeGroup node = (KNodeGroup)elemObj;
			return node.getLabel().getText();
		}
		else if (elemObj instanceof KPort) {
			KPort port = (KPort)elemObj;
			return port.getLabel().getText();
		}
		else if (elemObj instanceof KEdge) {
			KEdge edge = (KEdge)elemObj;
			KNodeGroup source = edge.getSource();
			KNodeGroup target = edge.getTarget();
			if (source != null && target != null)
				return "(" + source.getLabel().getText() + ") > ("
					+ target.getLabel().getText() + ")";
			else if (target != null)
				return "(" + edge.getSourcePort().getLabel().getText()
					+ ") > (" + target.getLabel().getText() + ")";
			else if (source != null)
				return "(" + source.getLabel().getText() + ") > ("
					+ edge.getTargetPort().getLabel().getText() + ")";
			else
				return "(" + edge.getSourcePort().getLabel().getText()
					+ ") > (" + edge.getTargetPort().getLabel().getText() + ")";
		}
		else
			return "";
	}
	
	/**
	 * Get the containing layer.
	 * 
	 * @return the layer
	 */
	public Layer getLayer() {
		return layer;
	}
	
	/**
	 * Gets the outgoing edges of the contained object.
	 * 
	 * @return the list of outgoing edges, or null if the object is an edge
	 */
	public List<KEdge> getOutgoingEdges() {
		if (elemObj instanceof KNodeGroup) {
			KNodeGroup node = (KNodeGroup)elemObj;
			LinkedList<KEdge> nonLoopEdges = new LinkedList<KEdge>();
			for (KEdge edge : node.getOutgoingEdges()) {
				// ignore loops over a single node
				if (edge.getSource() != edge.getTarget())
					nonLoopEdges.add(edge);
			}
			return nonLoopEdges;
		}
		else if (elemObj instanceof KPort) {
			KPort port = (KPort)elemObj;
			LinkedList<KEdge> internalEdges = new LinkedList<KEdge>();
			for (KEdge edge : port.getEdges()) {
				// edges going from a parent node group to a child have null source
				if (edge.getSource() == null)
					internalEdges.add(edge);
			}
			return internalEdges;
		}
		else return null;
	}
	
	/**
	 * Adds a new cross-layer connection with given target.
	 * 
	 * @param edge the edge between the two node groups
	 * @param target target layer element
	 */
	public void addOutgoing(KEdge edge, LayerElement target) {
		addOutgoing(edge, target, null, null);
	}
	
	/**
	 * Adds a new cross-layer connection with given target.
	 * 
	 * @param edge the edge between the two node groups
	 * @param target target layer element
	 * @param sourcePort the source port
	 * @param targetPort the target port
	 */
	public void addOutgoing(KEdge edge, LayerElement target,
			KPort sourcePort, KPort targetPort) {
		LayerConnection connection = new LayerConnection(edge, this,
				sourcePort, target, targetPort);
		this.outgoing.add(connection);
		target.incoming.add(connection);
	}
	
	/**
	 * Applies the layout of this layer element to the contained object
	 * and updates position information according to given offset values.
	 * 
	 * @param offset offset to be added to this element's position
	 * @param insets insets of the containing parent node group
	 */
	public void applyLayout(KPoint offset, KInsets insets) {
		if (elemObj instanceof KNodeGroup) {
			KNodeGroup node = (KNodeGroup)elemObj;
			position.setX(position.getX() + offset.getX() + insets.getLeft());
			position.setY(position.getY() + offset.getY() + insets.getTop());
			node.getLayout().getLocation().setX(position.getX());
			node.getLayout().getLocation().setY(position.getY());
		}
		else if (elemObj instanceof KPort) {
			KPort port = (KPort)elemObj;
			switch (port.getLayout().getPlacement()) {
			case NORTH:
				position.setY(position.getY() + offset.getY());
				if (layer.getLayeredGraph().areExternalPortsFixed())
					position.setX(position.getX() + offset.getX());
				else
					position.setX(position.getX() + offset.getX()
							+ insets.getLeft());
				break;
			case EAST:
				position.setX(position.getX() + offset.getX()
						+ insets.getLeft() + insets.getRight());
				if (layer.getLayeredGraph().areExternalPortsFixed())
					position.setY(position.getY() + offset.getY());
				else
					position.setY(position.getY() + offset.getY()
							+ insets.getTop());
				break;
			case SOUTH:
				if (layer.getLayeredGraph().areExternalPortsFixed())
					position.setX(position.getX() + offset.getX());
				else
					position.setX(position.getX() + offset.getX()
							+ insets.getLeft());
				position.setY(position.getY() + offset.getY()
						+ insets.getTop() + insets.getBottom());
				break;
			case WEST:
				position.setX(position.getX() + offset.getX());
				if (layer.getLayeredGraph().areExternalPortsFixed())
					position.setY(position.getY() + offset.getY());
				else
					position.setY(position.getY() + offset.getY()
							+ insets.getTop());
				break;
			}
			port.getLayout().getLocation().setX(position.getX());
			port.getLayout().getLocation().setY(position.getY());
		}
	}

	/**
	 * Are the ports of this layer element fixed?
	 * 
	 * @return the fixedPorts
	 */
	public boolean arePortsFixed() {
		return fixedPorts;
	}
	
	/**
	 * Gets the rank width of this layer element.
	 * 
	 * @return the rankWidth
	 */
	public int getRankWidth() {
		return rankWidth;
	}
	
	/**
	 * Gets the list of incoming layer connections.
	 * 
	 * @return the incoming connections
	 */
	public List<LayerConnection> getIncomingConnections() {
		return incoming;
	}

	/**
	 * Gets the list of outgoing connections.
	 * 
	 * @return the outgoing connections
	 */
	public List<LayerConnection> getOutgoingConnections() {
		return outgoing;
	}

	/**
	 * Gets the loops of this layer element.
	 * 
	 * @return list of element loops
	 */
	public List<ElementLoop> getLoops() {
		return loops;
	}

	/**
	 * Determines the dimension of this layer element.
	 * 
	 * @return the dimension
	 */
	public KDimension getRealDim() {
		if (elemObj instanceof KNodeGroup) {
			KNodeGroup node = (KNodeGroup)elemObj;
			return node.getLayout().getSize();
		}
		else if (elemObj instanceof KPort) {
			KPort port = (KPort)elemObj;
			return port.getLayout().getSize();
		}
		else {
			KDimension zeroDim = KimlLayoutGraphFactory.eINSTANCE.createKDimension();
			return zeroDim;
		}
	}
	
	/**
	 * Sets the crosswise position for this layer element, considering
	 * all edges that are routed before this element.
	 * 
	 * @param pos new crosswise position
	 * @param minDist minimal distance for routed edges
	 */
	public void setCrosswisePos(float pos, float minDist) {
		LAYOUT_OPTION layoutDirection = layer.getLayeredGraph().getLayoutDirection();
		if (layoutDirection == LAYOUT_OPTION.VERTICAL)
			position.setX(pos + westRanks * minDist);
		else
			position.setY(pos + northRanks * minDist);
	}
	
	/**
	 * Gets the total crosswise dimension of this layer element with
	 * routed edges.
	 * 
	 * @param minDist minimal distance for routed edges
	 * @return total crosswise dimension with routed edges
	 */
	public float getTotalCrosswiseDim(float minDist) {
		if (totalCrosswiseDim < 0.0f) {
			LAYOUT_OPTION layoutDirection = layer.getLayeredGraph().getLayoutDirection();
			if (layoutDirection == LAYOUT_OPTION.VERTICAL)
				totalCrosswiseDim = (westRanks + eastRanks)
					* minDist + getRealDim().getWidth();
			else
				totalCrosswiseDim = (northRanks + southRanks)
					* minDist + getRealDim().getHeight();
		}
		return totalCrosswiseDim;
	}
	
	/**
	 * Gets the current position of this layer element.
	 * 
	 * @return the currently set position
	 */
	public KPoint getPosition() {
		return position;
	}
	
	/**
	 * Gets the object contained in this layer element.
	 * 
	 * @return the element object
	 */
	public Object getElemObj() {
		return elemObj;
	}

	/**
	 * Gets the number of edges that are routed in front of this element.
	 * 
	 * @return number of edges in front
	 */
	public int getEdgesFront() {
		LAYOUT_OPTION layoutDirection = layer.getLayeredGraph().getLayoutDirection();
		return layoutDirection == LAYOUT_OPTION.VERTICAL
			? northRanks : westRanks;
	}

	/**
	 * Gets the number of edges that are routed in the back of this element.
	 * 
	 * @return number of edges in the back
	 */
	public int getEdgesBack() {
		LAYOUT_OPTION layoutDirection = layer.getLayeredGraph().getLayoutDirection();
		return layoutDirection == LAYOUT_OPTION.VERTICAL
			? southRanks : eastRanks;
	}

	/**
	 * Gets the port rank for a given port.
	 * 
	 * @param port port for which the rank shall be obtained
	 * @param forward if true, ranks are determined for a forward layer sweep,
	 *     else for a backwards layer sweep
	 * @return port rank, or 0 if <code>port == null</code
	 */
	public int getPortRank(KPort port, boolean forward) {
		if (port != null) {
			if (forward) {
				if (forwardPortRanks == null)
					calcPortRanks(true);
				return forwardPortRanks.get(port).intValue();
			}
			else {
				if (backwardsPortRanks == null)
					calcPortRanks(false);
				return backwardsPortRanks.get(port).intValue();
			}
		}
		else
			return 0;
	}
	
	/**
	 * Gets a list of combined element and port ranks for all incoming
	 * or for all outgoing connections.
	 * 
	 * @param forward if true, only incoming connections are considered,
	 *     else only outgoing connections are considered
	 * @return list of ranks for the specified connections
	 */
	public List<Integer> getConnectionRanks(boolean forward) {
		List<Integer> connectionRanks = new LinkedList<Integer>();
		if (forward) {
			for (LayerConnection connection : incoming) {
				if (connection.getSourcePort() != null) {
					// the source is a node with ports or a port
					connectionRanks.add(new Integer(connection.getSourceElement()
						.getPortRank(connection.getSourcePort(), true)
						+ connection.getSourceElement().rank));
				}
				else {
					// the source is a node without ports or an edge
					connectionRanks.add(new Integer(connection.getSourceElement().rank));
				}
			}
		}
		else {
			for (LayerConnection connection : outgoing) {
				if (connection.getTargetPort() != null) {
					// the target is a node with ports or a port
					connectionRanks.add(new Integer(connection.getTargetElement()
						.getPortRank(connection.getTargetPort(), false)
						+ connection.getTargetElement().rank));
				}
				else {
					// the target is a node without ports or an edge
					connectionRanks.add(new Integer(connection.getTargetElement().rank));
				}
			}
		}
		return connectionRanks;
	}
	
	/**
	 * Gets a list of combined element and port ranks of connections
	 * sorted by the port to which the connection is attached. This only
	 * works if the element object is a node group. The method is expected
	 * to give at least an empty list for each port in the contained node
	 * group.
	 * 
	 * @param forward if true, only incoming connections are considered,
	 *     else only outgoing connections are considered
	 * @return list of connection ranks for each port of this node group,
	 *     or null if the contained object is not a node group
	 */
	public Map<KPort, List<Integer>> getConnectionRanksByPort(boolean forward) {
		if (elemObj instanceof KNodeGroup) {
			KNodeGroup node = (KNodeGroup)elemObj;
			Map<KPort, List<Integer>> connectionRankMap = new LinkedHashMap<KPort, List<Integer>>();
			for (KPort port : node.getPorts()) {
				connectionRankMap.put(port, new LinkedList<Integer>());
			}
			
			if (forward) {
				for (LayerConnection connection : incoming) {
					List<Integer> portList = connectionRankMap.get(connection.getTargetPort());
					if (connection.getSourcePort() != null) {
						// the source is a node or a port
						portList.add(new Integer(connection.getSourceElement()
							.getPortRank(connection.getSourcePort(), forward)
							+ connection.getSourceElement().rank));
					}
					else {
						// the source is an edge
						portList.add(new Integer(connection.getSourceElement().rank));
					}
				}
			}
			else {
				for (LayerConnection connection : outgoing) {
					List<Integer> portList = connectionRankMap.get(connection.getSourcePort());
					if (connection.getTargetPort() != null) {
						// the target is a node or a port
						portList.add(new Integer(connection.getTargetElement()
							.getPortRank(connection.getTargetPort(), forward)
							+ connection.getTargetElement().rank));
					}
					else {
						// the target is an edge
						portList.add(new Integer(connection.getTargetElement().rank));
					}
				}
			}
			
			return connectionRankMap;
		}
		else return null;
	}
	
	/**
	 * Sorts the ports by their abstract ranks and updates the port
	 * positions. This method may only be used if this layer element
	 * contains a node group.
	 * 
	 * @param abstractPortRanks abstract ranks used to sort
	 * @param forward if true, ports are put clockwise on the node's border,
	 *     else counter-clockwise; only valid if not symmetric
	 * @param symmetric if true, ports are put on the node's border depending
	 *     on the layout direction
	 * @throws ClassCastException when the contained object is not a node group
	 */
	public void sortPorts(final Map<KPort, Double> abstractPortRanks,
			boolean forward, boolean symmetric) {
		KNodeGroup node = (KNodeGroup)elemObj;
		KPort[] ports = node.getPorts().toArray(new KPort[0]);
		
		Arrays.sort(ports, new Comparator<KPort>() {
			public int compare(KPort port1, KPort port2) {
				Double d1 = abstractPortRanks.get(port1);
				Double d2 = abstractPortRanks.get(port2);
				if (d1 == null && d2 == null)
					return 0;
				if (d1 == null && d2 != null)
					return 1;
				if (d1 != null && d2 == null)
					return -1;
				else
					return d1.compareTo(d2);
			}
		});
		
		LAYOUT_OPTION layoutDirection = layer.getLayeredGraph().getLayoutDirection();
		LayoutGraphs.positionPortsByOrder(ports, node.getLayout().getSize(),
				layoutDirection, forward, symmetric);
	}
	
	/**
	 * Calculates the connection routing for this layer element.
	 */
	public void calcEdgeRouting() {
		if (elemObj instanceof KNodeGroup) {
			KNodeGroup node = (KNodeGroup)elemObj;
			if (node.getPorts().isEmpty()) return;
			LAYOUT_OPTION layoutDirection = layer.getLayeredGraph().getLayoutDirection();
			List<RoutingSlot> northSlots = new LinkedList<RoutingSlot>();
			List<RoutingSlot> eastSlots = new LinkedList<RoutingSlot>();
			List<RoutingSlot> southSlots = new LinkedList<RoutingSlot>();
			List<RoutingSlot> westSlots = new LinkedList<RoutingSlot>();
			Map<KPort, RoutingSlot> northMap = new HashMap<KPort, RoutingSlot>();
			Map<KPort, RoutingSlot> eastMap = new HashMap<KPort, RoutingSlot>();
			Map<KPort, RoutingSlot> southMap = new HashMap<KPort, RoutingSlot>();
			Map<KPort, RoutingSlot> westMap = new HashMap<KPort, RoutingSlot>();
			KDimension nodeSize = node.getLayout().getSize();
			
			for (KPort port : node.getPorts()) {
				PORT_PLACEMENT placement = port.getLayout().getPlacement();
				float xPos = port.getLayout().getLocation().getX()
					+ port.getLayout().getSize().getWidth() / 2;
				float yPos = port.getLayout().getLocation().getY()
					+ port.getLayout().getSize().getHeight() / 2;
				// process self-loops over the given port
				for (KEdge edge : port.getEdges()) {
					if (edge.getSourcePort() == port && edge.getTarget() == node) {
						ElementLoop loop = new ElementLoop(edge, this, port, edge.getTargetPort());
						loops.add(loop);
						PORT_PLACEMENT placement2 = edge.getTargetPort().getLayout().getPlacement();
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
				if (layoutDirection == LAYOUT_OPTION.VERTICAL) {
					switch (placement) {
					case NORTH:
						if (hasOutgoing(port)) {
							addToSlot(port, northSlots, northMap, xPos, nodeSize.getWidth());
							addToSlot(port, eastSlots, eastMap, 0.0f, nodeSize.getHeight());
						}
						break;
					case EAST:
						if (!port.getEdges().isEmpty()) {
							float fromPos = yPos, toPos = yPos;
							if (hasOutgoing(port))
								toPos = nodeSize.getHeight();
							if (hasIncoming(port))
								fromPos = 0.0f;
							addToSlot(port, eastSlots, eastMap, fromPos, toPos);
						}
						break;
					case SOUTH:
						if (hasIncoming(port)) {
							addToSlot(port, southSlots, southMap, xPos, nodeSize.getWidth());
							addToSlot(port, eastSlots, eastMap, 0.0f, nodeSize.getHeight());
						}
						break;
					case WEST:
						if (!port.getEdges().isEmpty()) {
							float fromPos = yPos, toPos = yPos;
							if (hasOutgoing(port))
								toPos = nodeSize.getHeight();
							if (hasIncoming(port))
								fromPos = 0.0f;
							addToSlot(port, westSlots, westMap, fromPos, toPos);
						}
						break;
					}
				}
				else {
					switch (placement) {
					case NORTH:
						if (!port.getEdges().isEmpty()) {
							float fromPos = xPos, toPos = xPos;
							if (hasOutgoing(port))
								toPos = nodeSize.getWidth();
							if (hasIncoming(port))
								fromPos = 0.0f;
							addToSlot(port, northSlots, northMap, fromPos, toPos);
						}
						break;
					case EAST:
						if (hasIncoming(port)) {
							addToSlot(port, eastSlots, eastMap, yPos, nodeSize.getHeight());
							addToSlot(port, southSlots, southMap, 0.0f, nodeSize.getWidth());
						}
						break;
					case SOUTH:
						if (!port.getEdges().isEmpty()) {
							float fromPos = xPos, toPos = xPos;
							if (hasOutgoing(port))
								toPos = nodeSize.getWidth();
							if (hasIncoming(port))
								fromPos = 0.0f;
							addToSlot(port, southSlots, southMap, fromPos, toPos);
						}
						break;
					case WEST:
						if (hasOutgoing(port)) {
							addToSlot(port, westSlots, westMap, yPos, nodeSize.getHeight());
							addToSlot(port, southSlots, southMap, 0.0f, nodeSize.getWidth());
						}
						break;
					}
				}
			}
			
			// assign ranks to all routing slots 
			northRanks = assignRanks(northSlots, nodeSize.getWidth());
			eastRanks = assignRanks(eastSlots, nodeSize.getHeight());
			southRanks = assignRanks(southSlots, nodeSize.getWidth());
			westRanks = assignRanks(westSlots, nodeSize.getHeight());
			
			// calculate edge routing for all incoming or outgoing connections
			if (layoutDirection == LAYOUT_OPTION.VERTICAL) {
				for (LayerConnection connection : incoming) {
					KPort port = connection.getTargetPort();
					switch (port.getLayout().getPlacement()) {
					case EAST:
						int rank = getRankFor(port, eastSlots, eastRanks);
						connection.targetSidePos = rank;
						break;
					case SOUTH:
						rank = getRankFor(port, eastSlots, eastRanks);
						connection.targetSidePos = rank;
						rank = getRankFor(port, southSlots, southRanks);
						connection.targetFrontPos = rank;
						break;
					case WEST:
						rank = getRankFor(port, westSlots, westRanks);
						connection.targetSidePos = -rank;
						break;
					}
				}
				for (LayerConnection connection : outgoing) {
					KPort port = connection.getSourcePort();
					switch (port.getLayout().getPlacement()) {
					case NORTH:
						int rank = getRankFor(port, eastSlots, eastRanks);
						connection.sourceSidePos = rank;
						rank = getRankFor(port, northSlots, northRanks);
						connection.sourceBackPos = rank;
						break;
					case EAST:
						rank = getRankFor(port, eastSlots, eastRanks);
						connection.sourceSidePos = rank;
						break;
					case WEST:
						rank = getRankFor(port, westSlots, westRanks);
						connection.sourceSidePos = -rank;
						break;
					}
				}
			}
			else {
				for (LayerConnection connection : incoming) {
					KPort port = connection.getTargetPort();
					switch (port.getLayout().getPlacement()) {
					case SOUTH:
						int rank = getRankFor(port, southSlots, southRanks);
						connection.targetSidePos = rank;
						break;
					case EAST:
						rank = getRankFor(port, southSlots, southRanks);
						connection.targetSidePos = rank;
						rank = getRankFor(port, eastSlots, eastRanks);
						connection.targetFrontPos = rank;
						break;
					case NORTH:
						rank = getRankFor(port, northSlots, northRanks);
						connection.targetSidePos = -rank;
						break;
					}
				}
				for (LayerConnection connection : outgoing) {
					KPort port = connection.getSourcePort();
					switch (port.getLayout().getPlacement()) {
					case WEST:
						int rank = getRankFor(port, southSlots, southRanks);
						connection.sourceSidePos = rank;
						rank = getRankFor(port, westSlots, westRanks);
						connection.sourceBackPos = rank;
						break;
					case SOUTH:
						rank = getRankFor(port, southSlots, southRanks);
						connection.sourceSidePos = rank;
						break;
					case NORTH:
						rank = getRankFor(port, northSlots, northRanks);
						connection.sourceSidePos = -rank;
						break;
					}
				}
			}
			
			// calculate edge routing for all element loops
			for (ElementLoop loop : loops) {
				PORT_PLACEMENT placement1 = loop.getSourcePort().getLayout().getPlacement();
				PORT_PLACEMENT placement2 = loop.getTargetPort().getLayout().getPlacement();
				if (placement1 == PORT_PLACEMENT.NORTH || placement2 == PORT_PLACEMENT.NORTH) {
					int rank = getRankFor(loop.getSourcePort(), northSlots, northRanks);
					loop.northRoutePos = rank;
				}
				if (placement1 == PORT_PLACEMENT.EAST || placement2 == PORT_PLACEMENT.EAST
						|| placement1 == PORT_PLACEMENT.NORTH && placement2 == PORT_PLACEMENT.SOUTH
						|| placement1 == PORT_PLACEMENT.SOUTH && placement2 == PORT_PLACEMENT.NORTH) {
					int rank = getRankFor(loop.getSourcePort(), eastSlots, eastRanks);
					loop.eastRoutePos = rank;
				}
				if (placement1 == PORT_PLACEMENT.SOUTH || placement2 == PORT_PLACEMENT.SOUTH
						|| placement1 == PORT_PLACEMENT.EAST && placement2 == PORT_PLACEMENT.WEST
						|| placement1 == PORT_PLACEMENT.WEST && placement2 == PORT_PLACEMENT.EAST) {
					int rank = getRankFor(loop.getSourcePort(), southSlots, southRanks);
					loop.southRoutePos = rank;
				}
				if (placement1 == PORT_PLACEMENT.WEST || placement2 == PORT_PLACEMENT.WEST) {
					int rank = getRankFor(loop.getSourcePort(), westSlots, westRanks);
					loop.westRoutePos = rank;
				}
			}
		}
	}
	
	/**
	 * Determines the rank of each port of a node group.
	 * 
	 * @param forward if true, ranks are determined for a forward layer sweep,
	 *     else for a backwards layer sweep
	 */
	private void calcPortRanks(boolean forward) {
		LAYOUT_OPTION layoutDirection = layer.getLayeredGraph().getLayoutDirection();
		if (forward)
			forwardPortRanks = new HashMap<KPort, Integer>();
		else
			backwardsPortRanks = new HashMap<KPort, Integer>();
		
		if (elemObj instanceof KNodeGroup) {
			// sort all ports by their relative position
			List<KPort> ports = ((KNodeGroup)elemObj).getPorts();
			KPort[] portArray = LayoutGraphs.sortPortsByPosition(ports,
					layoutDirection, forward);
			// set the ranks in the newly sorted list
			if (forward) {
				for (int i = 0; i < portArray.length; i++) {
					forwardPortRanks.put(portArray[i], new Integer(i));
				}
			}
			else {
				for (int i = 0; i < portArray.length; i++) {
					backwardsPortRanks.put(portArray[i], new Integer(i));
				}	
			}
		}
		else if (elemObj instanceof KPort) {
			if (forward)
				forwardPortRanks.put((KPort)elemObj, new Integer(0));
			else
				backwardsPortRanks.put((KPort)elemObj, new Integer(0));
		}
	}

	/**
	 * Adds a given port to an appropriate routing slot. 
	 * 
	 * @param port port to be inserted
	 * @param slotList list of existing routing slots
	 * @param slotMap mapping of ports to existing slots
	 * @param fromPos starting position for the given port
	 * @param toPos ending position for the given port
	 */
	private void addToSlot(KPort port, List<RoutingSlot> slotList,
			Map<KPort, RoutingSlot> slotMap, float fromPos, float toPos) {
		RoutingSlot slot = slotMap.get(port);
		if (slot == null && port.getEdges().size() == 1) {
			KEdge edge = port.getEdges().get(0);
			if (edge.getSourcePort() != port && edge.getSource() != elemObj) {
				slot = slotMap.get(edge.getSourcePort());
				if (slot == null) {
					slot = new RoutingSlot();
					slotList.add(slot);
					slotMap.put(edge.getSourcePort(), slot);
				}
			}
			else if (edge.getTargetPort() != port && edge.getTarget() != elemObj) {
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
     * @param port port to check
     * @return true if the given port has an outgoing connection
     */
    private boolean hasOutgoing(KPort port) {
        for (LayerConnection connection : outgoing) {
                if (connection.getSourcePort() == port) {
                        return true;
                }
        }
        return false;
    }
   
    /**
     * Determines whether the given port has an incoming connection.
     *
     * @param port port to check
     * @return true if the given port has an incoming connection
     */
    private boolean hasIncoming(KPort port) {
        for (LayerConnection connection : incoming) {
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

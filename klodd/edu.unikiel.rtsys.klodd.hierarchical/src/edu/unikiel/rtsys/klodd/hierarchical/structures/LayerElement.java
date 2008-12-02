package edu.unikiel.rtsys.klodd.hierarchical.structures;

import java.util.Arrays;
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
	/** the number of edges that are routed before this element (crosswise) */
	private int edgesBefore = 0;
	/** the number of edges that are routed after this element (crosswise) */
	private int edgesAfter = 0;
	/** the number of edges that are routed in front of this element */
	private int edgesFront = 0;
	/** the number of edges that are routed in the back of this element */
	private int edgesBack = 0;
	/** the list of incoming layer connections */
	private List<LayerConnection> incoming = new LinkedList<LayerConnection>();
	/** the list of outgoing layer connections */
	private List<LayerConnection> outgoing = new LinkedList<LayerConnection>();
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
			fixedPorts = node.getLayout().getLayoutOptions().contains(LAYOUT_OPTION.FIXED_PORTS);
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
		LayerConnection connection = new LayerConnection(edge, this, target);
		this.outgoing.add(connection);
		target.incoming.add(connection);
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
	 * Applies the layout of this layer element to the contained object.
	 * 
	 * @param offset offset to be added to this element's position
	 */
	public void applyLayout(KPoint offset) {
		if (elemObj instanceof KNodeGroup) {
			KNodeGroup node = (KNodeGroup)elemObj;
			node.getLayout().getLocation().setX(position.getX() + offset.getX());
			node.getLayout().getLocation().setY(position.getY() + offset.getY());
		}
		else if (elemObj instanceof KPort) {
			KPort port = (KPort)elemObj;
			if (layer.getLayeredGraph().areExternalPortsFixed()) {
				port.getLayout().getLocation().setX(position.getX());
				port.getLayout().getLocation().setY(position.getY());
			}
			else {
				port.getLayout().getLocation().setX(position.getX() + offset.getX());
				port.getLayout().getLocation().setY(position.getY() + offset.getY());
			}
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
			zeroDim.setWidth(0.0f);
			zeroDim.setHeight(0.0f);
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
			position.setX(pos + edgesBefore * minDist);
		else
			position.setY(pos + edgesBefore * minDist);
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
			totalCrosswiseDim = (edgesBefore + edgesAfter) * minDist
					+ (layoutDirection == LAYOUT_OPTION.VERTICAL
					? getRealDim().getWidth() : getRealDim().getHeight());
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
		return edgesFront;
	}

	/**
	 * Gets the number of edges that are routed in the back of this element.
	 * 
	 * @return number of edges in the back
	 */
	public int getEdgesBack() {
		return edgesBack;
	}

	/**
	 * Gets the port rank for a given port.
	 * 
	 * @param port port for which the rank shall be obtained
	 * @param forward if true, ranks are determined for a forward layer sweep,
	 *     else for a backwards layer sweep
	 * @return port rank
	 */
	public int getPortRank(KPort port, boolean forward) {
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
					// the source is a node or a port
					connectionRanks.add(new Integer(connection.getSourceElement()
						.getPortRank(connection.getSourcePort(), true)
						+ connection.getSourceElement().rank));
				}
				else {
					// the source is an edge
					connectionRanks.add(new Integer(connection.getSourceElement().rank));
				}
			}
		}
		else {
			for (LayerConnection connection : outgoing) {
				if (connection.getTargetPort() != null) {
					// the target is a node or a port
					connectionRanks.add(new Integer(connection.getTargetElement()
						.getPortRank(connection.getTargetPort(), false)
						+ connection.getTargetElement().rank));
				}
				else {
					// the target is an edge
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
	 * Calculates the needed number of edge routing slots and assigns an
	 * appropriate slot to each connection.
	 */
	public void calcEdgeRouting() {
		LAYOUT_OPTION layoutDirection = layer.getLayeredGraph().getLayoutDirection();
		if (elemObj instanceof KNodeGroup) {
			KNodeGroup node = (KNodeGroup)elemObj;
			int size = node.getPorts().size();
			int[] sideRouting = new int[size];
			int[] frontIncoming = new int[size];
			int[] backOutgoing = new int[size];
			for (int i = 0; i < size; i++) {
				frontIncoming[i] = 0;
				backOutgoing[i] = 0;
			}
			
			// determine for each port whether it needs a routing slot
			if (layoutDirection == LAYOUT_OPTION.VERTICAL) {
				for (KPort port : node.getPorts()) {
					int rank = getPortRank(port, true);
					switch (port.getLayout().getPlacement()) {
					case NORTH:
						if (hasOutgoing(port)) {
							sideRouting[rank] = 1;
							backOutgoing[rank] = 1;
						}
						else
							sideRouting[rank] = 0;
						break;
					case EAST:
						sideRouting[rank] = 1;
						break;
					case SOUTH:
						if (hasIncoming(port)) {
							sideRouting[rank] = 1;
							frontIncoming[rank] = 1;
						}
						else
							sideRouting[rank] = 0;
						break;
					case WEST:
						sideRouting[rank] = -1;
						break;
					}
				}				
			}
			else {
				for (KPort port : node.getPorts()) {
					int rank = getPortRank(port, true);
					switch (port.getLayout().getPlacement()) {
					case NORTH:
						sideRouting[rank] = -1;
						break;
					case EAST:
						if (hasIncoming(port)) {
							sideRouting[rank] = 1;
							frontIncoming[rank] = 1;
						}
						else
							sideRouting[rank] = 0;
						break;
					case SOUTH:
						sideRouting[rank] = 1;
						break;
					case WEST:
						if (hasOutgoing(port)) {
							sideRouting[rank] = 1;
							backOutgoing[rank] = 1;
						}
						else
							sideRouting[rank] = 0;
						break;
					}
				}
			}
			
			// determine the number of slots for this node
			for (int i = 0; i < size; i++) {
				if (sideRouting[i] < 0) {
					edgesBefore++;
					sideRouting[i] = -edgesBefore;
				}
				else if (sideRouting[i] > 0) {
					edgesAfter++;
					sideRouting[i] = edgesAfter;
				}
				if (frontIncoming[i] > 0) {
					edgesFront++;
					frontIncoming[i] = edgesFront;
				}
				if (backOutgoing[i] > 0) {
					edgesBack++;
					backOutgoing[i] = edgesBack;
				}
			}
			
			// assign the right routing slot to each connection
			for (LayerConnection connection : incoming) {
				int rank = getPortRank(connection.getTargetPort(), true);
				connection.targetSidePos = sideRouting[rank];
				connection.targetFrontPos = frontIncoming[rank];
			}
			for (LayerConnection connection : outgoing) {
				int rank = getPortRank(connection.getSourcePort(), true);
				connection.sourceSidePos = sideRouting[rank];
				connection.sourceBackPos = backOutgoing[rank];
			}
		}
		else if (elemObj instanceof KPort) {
			KPort port = (KPort)elemObj;
			if (layoutDirection == LAYOUT_OPTION.VERTICAL)
				totalCrosswiseDim = port.getLayout().getSize().getWidth();
			else
				totalCrosswiseDim = port.getLayout().getSize().getHeight();
		}
		else {
			totalCrosswiseDim = 0.0f;
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
	
}

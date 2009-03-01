package de.cau.cs.kieler.klodd.hierarchical.structures;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import de.cau.cs.kieler.core.graph.KEdge;
import de.cau.cs.kieler.core.graph.KNode;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.*;
import de.cau.cs.kieler.kiml.layout.util.LayoutGraphUtil;


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
	/** the number of routing slot ranks on north side */
	public int northRanks = 0;
	/** the number of routing slot ranks on east side */
	public int eastRanks = 0;
	/** the number of routing slot ranks on south side */
	public int southRanks = 0;
	/** the number of routing slot ranks on west side */
	public int westRanks = 0;
	
	/** the element object */
	private Object elemObj;
	/** the containing layer */
	private Layer layer;
	/** the corresponding node in the acyclic KIELER graph */
	private KNode kNode;
	/** are the ports of this layer element fixed? */
	private boolean fixedPorts;
	/** number of rank numbers consumed by this layer element */
	private int rankWidth;
	/** the new position that is determined for this layer element */
	private KPoint position;
	/** the dimension of the contained object */
	private KDimension realDim;
	/** the total crosswise dimension */
	private float totalCrosswiseDim = -1.0f;
	/** the list of incoming layer connections */
	private List<LayerConnection> incoming = new LinkedList<LayerConnection>();
	/** the list of outgoing layer connections */
	private List<LayerConnection> outgoing = new LinkedList<LayerConnection>();
	/** the list of element loop */
	private List<ElementLoop> loops = new LinkedList<ElementLoop>();
	/** map of ports to port ranks for forward layer sweep */
	private Map<KLayoutPort, Integer> forwardPortRanks = null;
	/** map of ports to port ranks for backwards layer sweep */
	private Map<KLayoutPort, Integer> backwardsPortRanks = null;
	
	/**
	 * Creates a layer element in an existing layer.
	 * 
	 * @param obj the element object
	 * @param layer the containing layer
	 * @param kNode the corresponding node in the acyclic KIELER graph
	 */
	public LayerElement(Object obj, Layer layer, KNode kNode) {
		this.elemObj = obj;
		this.layer = layer;
		this.kNode = kNode;
		this.position = KimlLayoutGraphFactory.eINSTANCE.createKPoint();
		
		if (obj instanceof KLayoutNode) {
			// the layer element is a layout node
			KLayoutNode node = (KLayoutNode)obj;
			fixedPorts = node.getLayout().getLayoutOptions().contains(KLayoutOption.FIXED_PORTS)
				|| node.getPorts().isEmpty();
			rankWidth = Math.max(node.getPorts().size(), 1);
			realDim = node.getLayout().getSize();
		}
		else if (obj instanceof KLayoutPort) {
			// the layer element is a port
			KLayoutPort port= (KLayoutPort)obj;
			fixedPorts = true;
			rankWidth = 1;
			realDim = port.getLayout().getSize();
		}
		else if (obj instanceof KLayoutEdge) {
			// the layer element is a long edge
			fixedPorts = true;
			rankWidth = 1;
			realDim = KimlLayoutGraphFactory.eINSTANCE.createKDimension();
		}
		else
			throw new IllegalArgumentException("Unknown object type received.");
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		if (elemObj instanceof KLayoutNode) {
			KLayoutNode node = (KLayoutNode)elemObj;
			return node.getLabel().getText();
		}
		else if (elemObj instanceof KLayoutPort) {
			KLayoutPort port = (KLayoutPort)elemObj;
			return port.getLabel().getText();
		}
		else if (elemObj instanceof KLayoutEdge) {
			KLayoutEdge edge = (KLayoutEdge)elemObj;
			KLayoutNode source = edge.getSource();
			KLayoutNode target = edge.getTarget();
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
	 * Set a new layer for this element. The element is added to the
	 * new layer.
	 * 
	 * @param newLayer the new layer
	 */
	public void setLayer(Layer newLayer) {
		this.layer = newLayer;
		newLayer.getElements().add(this);
	}
	
	/**
	 * Gets the outgoing edges of the contained object.
	 * 
	 * @return the list of outgoing edges, or null if the object is an edge
	 */
	public List<KEdge> getOutgoingEdges() {
		if (kNode != null) {
			LinkedList<KEdge> nonLoopEdges = new LinkedList<KEdge>();
			for (KNode.IncEntry edgeEntry : kNode.incidence) {
				// ignore loops over a single node
				if (edgeEntry.type == KNode.IncEntry.Type.OUT
						&& edgeEntry.edge.source.id != edgeEntry.edge.target.id)
					nonLoopEdges.add(edgeEntry.edge);
			}
			return nonLoopEdges;
		}
		else return null;
	}
	
	/**
	 * Adds a new cross-layer connection with given target.
	 * 
	 * @param edge the edge between the two layout nodes
	 * @param target target layer element
	 */
	public void addOutgoing(KLayoutEdge edge, LayerElement target) {
		addOutgoing(edge, target, null, null);
	}
	
	/**
	 * Adds a new cross-layer connection with given target.
	 * 
	 * @param edge the edge between the two layout nodes
	 * @param target target layer element
	 * @param sourcePort the source port
	 * @param targetPort the target port
	 */
	public void addOutgoing(KLayoutEdge edge, LayerElement target,
			KLayoutPort sourcePort, KLayoutPort targetPort) {
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
	 * @param insets insets of the containing parent layout node
	 */
	public void applyLayout(KPoint offset, KInsets insets) {
		position.setX(position.getX() + offset.getX());
		position.setY(position.getY() + offset.getY());
		if (elemObj instanceof KLayoutNode) {
			KPoint nodeLoc = ((KLayoutNode)elemObj).getLayout().getLocation();
			nodeLoc.setX(position.getX());
			nodeLoc.setY(position.getY());
		}
		else if (elemObj instanceof KLayoutPort) {
			KLayoutPort port = (KLayoutPort)elemObj;
			KPoint portLoc = port.getLayout().getLocation();
			switch (port.getLayout().getPlacement()) {
			case NORTH:
				if (layer.getLayeredGraph().areExternalPortsFixed())
					portLoc.setX(position.getX());
				else
					portLoc.setX(position.getX() + insets.getLeft());
				portLoc.setY(position.getY());
				break;
			case EAST:
				portLoc.setX(position.getX() + insets.getLeft() + insets.getRight());
				if (layer.getLayeredGraph().areExternalPortsFixed())
					portLoc.setY(position.getY());
				else
					portLoc.setY(position.getY() + insets.getTop());
				break;
			case SOUTH:
				if (layer.getLayeredGraph().areExternalPortsFixed())
					portLoc.setX(position.getX());
				else
					portLoc.setX(position.getX() + insets.getLeft());
				portLoc.setY(position.getY() + insets.getTop() + insets.getBottom());
				break;
			case WEST:
				portLoc.setX(position.getX());
				if (layer.getLayeredGraph().areExternalPortsFixed())
					portLoc.setY(position.getY());
				else
					portLoc.setY(position.getY() + insets.getTop());
				break;
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
		return realDim;
	}
	
	/**
	 * Sets the crosswise position for this layer element, considering
	 * all edges that are routed before this element.
	 * 
	 * @param pos new crosswise position
	 * @param minDist minimal distance for routed edges
	 */
	public void setCrosswisePos(float pos, float minDist) {
		KLayoutOption layoutDirection = layer.getLayeredGraph().getLayoutDirection();
		if (layoutDirection == KLayoutOption.VERTICAL)
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
			KLayoutOption layoutDirection = layer.getLayeredGraph().getLayoutDirection();
			if (layoutDirection == KLayoutOption.VERTICAL)
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
	 * Gets the KIELER node associated with this layer element.
	 * 
	 * @return the KIELER node
	 */
	public KNode getKNode() {
		return kNode;
	}

	/**
	 * Gets the number of edges that are routed in front of this element.
	 * 
	 * @return number of edges in front
	 */
	public int getEdgesFront() {
		KLayoutOption layoutDirection = layer.getLayeredGraph().getLayoutDirection();
		return layoutDirection == KLayoutOption.VERTICAL
			? northRanks : westRanks;
	}

	/**
	 * Gets the number of edges that are routed in the back of this element.
	 * 
	 * @return number of edges in the back
	 */
	public int getEdgesBack() {
		KLayoutOption layoutDirection = layer.getLayeredGraph().getLayoutDirection();
		return layoutDirection == KLayoutOption.VERTICAL
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
	public int getPortRank(KLayoutPort port, boolean forward) {
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
	 * works if the element object is a layout node. The method is expected
	 * to give at least an empty list for each port in the contained node
	 * group.
	 * 
	 * @param forward if true, only incoming connections are considered,
	 *     else only outgoing connections are considered
	 * @return list of connection ranks for each port of this layout node,
	 *     or null if the contained object is not a layout node
	 */
	public Map<KLayoutPort, List<Integer>> getConnectionRanksByPort(boolean forward) {
		if (elemObj instanceof KLayoutNode) {
			KLayoutNode node = (KLayoutNode)elemObj;
			Map<KLayoutPort, List<Integer>> connectionRankMap = new LinkedHashMap<KLayoutPort, List<Integer>>();
			for (KLayoutPort port : node.getPorts()) {
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
	 * contains a layout node.
	 * 
	 * @param abstractPortRanks abstract ranks used to sort
	 * @param forward if true, ports are put clockwise on the node's border,
	 *     else counter-clockwise; only valid if not symmetric
	 * @param symmetric if true, ports are put on the node's border depending
	 *     on the layout direction
	 * @throws ClassCastException when the contained object is not a layout node
	 */
	public void sortPorts(final Map<KLayoutPort, Double> abstractPortRanks,
			boolean forward, boolean symmetric) {
		KLayoutNode node = (KLayoutNode)elemObj;
		KLayoutPort[] ports = node.getPorts().toArray(new KLayoutPort[0]);
		
		Arrays.sort(ports, new Comparator<KLayoutPort>() {
			public int compare(KLayoutPort port1, KLayoutPort port2) {
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
		
		KLayoutOption layoutDirection = layer.getLayeredGraph().getLayoutDirection();
		LayoutGraphUtil.positionPortsByOrder(ports, node.getLayout().getSize(),
				layoutDirection, forward, symmetric);
	}
	
	/**
	 * Determines the rank of each port of a layout node.
	 * 
	 * @param forward if true, ranks are determined for a forward layer sweep,
	 *     else for a backwards layer sweep
	 */
	private void calcPortRanks(boolean forward) {
		KLayoutOption layoutDirection = layer.getLayeredGraph().getLayoutDirection();
		if (forward)
			forwardPortRanks = new HashMap<KLayoutPort, Integer>();
		else
			backwardsPortRanks = new HashMap<KLayoutPort, Integer>();
		
		if (elemObj instanceof KLayoutNode) {
			// sort all ports by their relative position
			List<KLayoutPort> ports = ((KLayoutNode)elemObj).getPorts();
			KLayoutPort[] portArray = LayoutGraphUtil.sortPortsByPosition(ports,
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
		else if (elemObj instanceof KLayoutPort) {
			if (forward)
				forwardPortRanks.put((KLayoutPort)elemObj, new Integer(0));
			else
				backwardsPortRanks.put((KLayoutPort)elemObj, new Integer(0));
		}
	}
	
}

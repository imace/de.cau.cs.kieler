package edu.unikiel.rtsys.klodd.hierarchical.structures;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KEdge;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KNodeGroup;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KPort;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.LAYOUT_OPTION;
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
	
	/** the element object */
	private Object elemObj;
	/** the containing layer */
	private Layer layer;
	/** are the ports of this layer element fixed? */
	private boolean fixedPorts;
	/** number of rank numbers consumed by this layer element */
	private int rankWidth;
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
			throw new ClassCastException("Unknown object type received.");
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
	 * @param target target layer element
	 */
	public void addOutgoing(LayerElement target) {
		LayerConnection connection = new LayerConnection(this, target);
		this.outgoing.add(connection);
		target.incoming.add(connection);
	}
	
	/**
	 * Adds a new cross-layer connection with given target.
	 * 
	 * @param target target layer element
	 * @param sourcePort the source port
	 * @param targetPort the target port
	 */
	public void addOutgoing(LayerElement target, KPort sourcePort, KPort targetPort) {
		LayerConnection connection = new LayerConnection(this, sourcePort, target, targetPort);
		this.outgoing.add(connection);
		target.incoming.add(connection);
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
				calcPortRanks(layer.getLayeredGraph().getLayoutDirection(), true);
			return forwardPortRanks.get(port).intValue();
		}
		else {
			if (backwardsPortRanks == null)
				calcPortRanks(layer.getLayeredGraph().getLayoutDirection(), false);
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
						.getPortRank(connection.getSourcePort(), forward)
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
						.getPortRank(connection.getTargetPort(), forward)
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
	 * Determines the rank of each port of a node group.
	 * 
	 * @param layoutDirection direction of graph layout: HORIZONTAL or VERTICAL
	 * @param forward if true, ranks are determined for a forward layer sweep,
	 *     else for a backwards layer sweep
	 */
	private void calcPortRanks(LAYOUT_OPTION layoutDirection, boolean forward) {
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
	
}

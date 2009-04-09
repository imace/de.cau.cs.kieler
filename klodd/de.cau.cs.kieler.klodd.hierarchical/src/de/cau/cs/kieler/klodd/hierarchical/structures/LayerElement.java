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
package de.cau.cs.kieler.klodd.hierarchical.structures;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import de.cau.cs.kieler.core.kgraph.KEdge;
import de.cau.cs.kieler.core.kgraph.KGraphElement;
import de.cau.cs.kieler.core.kgraph.KNode;
import de.cau.cs.kieler.core.kgraph.KPort;
import de.cau.cs.kieler.core.slimgraph.KSlimEdge;
import de.cau.cs.kieler.core.slimgraph.KSlimNode;
import de.cau.cs.kieler.kiml.layout.klayoutdata.KInsets;
import de.cau.cs.kieler.kiml.layout.klayoutdata.KLayoutDataFactory;
import de.cau.cs.kieler.kiml.layout.klayoutdata.KPoint;
import de.cau.cs.kieler.kiml.layout.klayoutdata.KShapeLayout;
import de.cau.cs.kieler.kiml.layout.options.LayoutDirection;
import de.cau.cs.kieler.kiml.layout.options.LayoutOptions;
import de.cau.cs.kieler.kiml.layout.options.PortConstraints;
import de.cau.cs.kieler.kiml.layout.util.KimlLayoutUtil;
import de.cau.cs.kieler.kiml.layout.util.LayoutGraphUtil;


/**
 * A layer element representing a node or a long edge in the layered graph.
 * 
 * @author <a href="mailto:msp@informatik.uni-kiel.de">Miro Sp&ouml;nemann</a>
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
	private KGraphElement elemObj;
	/** the containing layer */
	private Layer layer;
	/** the corresponding node in the acyclic KIELER graph */
	private KSlimNode kNode;
	/** are the ports of this layer element fixed? */
	private boolean fixedPorts;
	/** number of rank numbers consumed by this layer element */
	private int rankWidth;
	/** the new position that is determined for this layer element */
	private KPoint position;
	/** the width of the contained object */
	private float realWidth;
	/** the height of the contained object */
	private float realHeight;
	/** the total crosswise dimension */
	private float totalCrosswiseDim = -1.0f;
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
	 * @param kNode the corresponding node in the acyclic KIELER graph
	 */
	public LayerElement(KGraphElement obj, Layer layer, KSlimNode kNode) {
		this.elemObj = obj;
		this.layer = layer;
		this.kNode = kNode;
		this.position = KLayoutDataFactory.eINSTANCE.createKPoint();
		
		if (obj instanceof KNode) {
			// the layer element is a layout node
		    KNode node = (KNode)obj;
		    KShapeLayout shapeLayout = KimlLayoutUtil.getShapeLayout(node);
            fixedPorts = LayoutOptions.getPortConstraints(shapeLayout)
                    == PortConstraints.FIXED_POS || node.getPorts().isEmpty();
			rankWidth = Math.max(node.getPorts().size(), 1);
			realWidth = shapeLayout.getWidth();
			realHeight = shapeLayout.getHeight();
		}
		else if (obj instanceof KPort) {
			// the layer element is a port
			KPort port= (KPort)obj;
			KShapeLayout shapeLayout = KimlLayoutUtil.getShapeLayout(port);
            fixedPorts = true;
			rankWidth = 1;
            realWidth = shapeLayout.getWidth();
            realHeight = shapeLayout.getHeight();
		}
		else if (obj instanceof KEdge) {
			// the layer element is a long edge
			fixedPorts = true;
			rankWidth = 1;
			realWidth = 0.0f;
			realHeight = 0.0f;
		}
		else
			throw new IllegalArgumentException("Unknown object type received.");
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		if (elemObj instanceof KNode) {
			KNode node = (KNode)elemObj;
			return node.getLabel().getText();
		}
		else if (elemObj instanceof KPort) {
			KPort port = (KPort)elemObj;
			return port.getLabel().getText();
		}
		else if (elemObj instanceof KEdge) {
			KEdge edge = (KEdge)elemObj;
			KNode source = edge.getSource();
			KNode target = edge.getTarget();
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
	public List<KSlimEdge> getOutgoingEdges() {
		if (kNode != null) {
			LinkedList<KSlimEdge> nonLoopEdges = new LinkedList<KSlimEdge>();
			for (KSlimNode.IncEntry edgeEntry : kNode.incidence) {
				// ignore loops over a single node
				if (edgeEntry.type == KSlimNode.IncEntry.Type.OUT
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
	public void addOutgoing(KEdge edge, LayerElement target) {
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
	 * @param insets insets of the containing parent layout node
	 */
	public void applyLayout(KPoint offset, KInsets insets) {
		position.setX(position.getX() + offset.getX());
		position.setY(position.getY() + offset.getY());
		if (elemObj instanceof KNode) {
			KShapeLayout shapeLayout = KimlLayoutUtil.getShapeLayout(elemObj);
			shapeLayout.setXpos(position.getX());
			shapeLayout.setYpos(position.getY());
		}
		else if (elemObj instanceof KPort) {
			KShapeLayout shapeLayout = KimlLayoutUtil.getShapeLayout(elemObj);
            switch (LayoutOptions.getPortSide(shapeLayout)) {
			case NORTH:
				if (layer.getLayeredGraph().areExternalPortsFixed())
				    shapeLayout.setXpos(position.getX());
				else
				    shapeLayout.setXpos(position.getX() + insets.getLeft());
				shapeLayout.setYpos(position.getY());
				break;
			case EAST:
			    shapeLayout.setXpos(position.getX() + insets.getLeft() + insets.getRight());
				if (layer.getLayeredGraph().areExternalPortsFixed())
				    shapeLayout.setYpos(position.getY());
				else
				    shapeLayout.setYpos(position.getY() + insets.getTop());
				break;
			case SOUTH:
				if (layer.getLayeredGraph().areExternalPortsFixed())
				    shapeLayout.setXpos(position.getX());
				else
				    shapeLayout.setXpos(position.getX() + insets.getLeft());
				shapeLayout.setYpos(position.getY() + insets.getTop() + insets.getBottom());
				break;
			case WEST:
			    shapeLayout.setXpos(position.getX());
				if (layer.getLayeredGraph().areExternalPortsFixed())
				    shapeLayout.setYpos(position.getY());
				else
				    shapeLayout.setYpos(position.getY() + insets.getTop());
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
	 * Returns the width of this layer element.
	 * 
	 * @return the width
	 */
	public float getRealWidth() {
		return realWidth;
	}
	
	/**
	 * Returns the height of this layer element.
	 * 
	 * @return the height
	 */
	public float getRealHeight() {
	    return realHeight;
	}
	
	/**
	 * Sets the crosswise position for this layer element, considering
	 * all edges that are routed before this element.
	 * 
	 * @param pos new crosswise position
	 * @param minDist minimal distance for routed edges
	 */
	public void setCrosswisePos(float pos, float minDist) {
		LayoutDirection layoutDirection = layer.getLayeredGraph().getLayoutDirection();
		if (layoutDirection == LayoutDirection.VERTICAL)
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
		    LayoutDirection layoutDirection = layer.getLayeredGraph().getLayoutDirection();
			if (layoutDirection == LayoutDirection.VERTICAL)
				totalCrosswiseDim = (westRanks + eastRanks)
					* minDist + realWidth;
			else
				totalCrosswiseDim = (northRanks + southRanks)
					* minDist + realHeight;
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
	public KSlimNode getKNode() {
		return kNode;
	}

	/**
	 * Gets the number of edges that are routed in front of this element.
	 * 
	 * @return number of edges in front
	 */
	public int getEdgesFront() {
	    LayoutDirection layoutDirection = layer.getLayeredGraph().getLayoutDirection();
		return layoutDirection == LayoutDirection.VERTICAL
			? northRanks : westRanks;
	}

	/**
	 * Gets the number of edges that are routed in the back of this element.
	 * 
	 * @return number of edges in the back
	 */
	public int getEdgesBack() {
	    LayoutDirection layoutDirection = layer.getLayeredGraph().getLayoutDirection();
		return layoutDirection == LayoutDirection.VERTICAL
			? southRanks : eastRanks;
	}

	/**
	 * Gets the port rank for a given port.
	 * 
	 * @param port port for which the rank shall be obtained
	 * @param forward if true, ranks are determined for a forward layer sweep,
	 *     else for a backwards layer sweep
	 * @return port rank, or 0 if {@code port == null}
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
		    if (elemObj instanceof KEdge && linearSegment.hasPreceding(this)) {
		        // only the preceding element of the linear segment may be considered
		        for (LayerConnection connection : incoming) {
		            LayerElement source = connection.getSourceElement();
		            if (source.elemObj instanceof KEdge) {
		                connectionRanks.add(Integer.valueOf(source.rank));
		                break;
		            }
		        }
		    }
		    else {
    			for (LayerConnection connection : incoming) {
    				if (connection.getSourcePort() != null) {
    					// the source is a node with ports or a port
    					connectionRanks.add(Integer.valueOf(connection.getSourceElement()
    						.getPortRank(connection.getSourcePort(), true)
    						+ connection.getSourceElement().rank));
    				}
    				else {
    					// the source is a node without ports or an edge
    					connectionRanks.add(Integer.valueOf(connection.getSourceElement().rank));
    				}
    			}
		    }
		}
		else {
		    if (elemObj instanceof KEdge && linearSegment.hasFollowing(this)) {
                // only the following element of the linear segment may be considered
                for (LayerConnection connection : outgoing) {
                    LayerElement target = connection.getTargetElement();
                    if (target.elemObj instanceof KEdge) {
                        connectionRanks.add(Integer.valueOf(target.rank));
                        break;
                    }
                }
            }
            else {
    			for (LayerConnection connection : outgoing) {
    				if (connection.getTargetPort() != null) {
    					// the target is a node with ports or a port
    					connectionRanks.add(Integer.valueOf(connection.getTargetElement()
    						.getPortRank(connection.getTargetPort(), false)
    						+ connection.getTargetElement().rank));
    				}
    				else {
    					// the target is a node without ports or an edge
    					connectionRanks.add(Integer.valueOf(connection.getTargetElement().rank));
    				}
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
	public Map<KPort, List<Integer>> getConnectionRanksByPort(boolean forward) {
		if (elemObj instanceof KNode) {
			KNode node = (KNode)elemObj;
			Map<KPort, List<Integer>> connectionRankMap = new LinkedHashMap<KPort, List<Integer>>();
			for (KPort port : node.getPorts()) {
				connectionRankMap.put(port, new LinkedList<Integer>());
			}
			
			if (forward) {
				for (LayerConnection connection : incoming) {
					List<Integer> portList = connectionRankMap.get(connection.getTargetPort());
					if (connection.getSourcePort() != null) {
						// the source is a node or a port
						portList.add(Integer.valueOf(connection.getSourceElement()
							.getPortRank(connection.getSourcePort(), forward)
							+ connection.getSourceElement().rank));
					}
					else {
						// the source is an edge
						portList.add(Integer.valueOf(connection.getSourceElement().rank));
					}
				}
			}
			else {
				for (LayerConnection connection : outgoing) {
					List<Integer> portList = connectionRankMap.get(connection.getSourcePort());
					if (connection.getTargetPort() != null) {
						// the target is a node or a port
						portList.add(Integer.valueOf(connection.getTargetElement()
							.getPortRank(connection.getTargetPort(), forward)
							+ connection.getTargetElement().rank));
					}
					else {
						// the target is an edge
						portList.add(Integer.valueOf(connection.getTargetElement().rank));
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
	public void sortPorts(final Map<KPort, Double> abstractPortRanks,
			boolean forward, boolean symmetric) {
		KNode node = (KNode)elemObj;
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
		
		LayoutDirection layoutDirection = layer.getLayeredGraph().getLayoutDirection();
		KShapeLayout shapeLayout = KimlLayoutUtil.getShapeLayout(node);
		LayoutGraphUtil.positionPortsByOrder(ports, shapeLayout.getWidth(),
		        shapeLayout.getHeight(), layoutDirection, forward, symmetric);
	}
	
	/**
	 * Determines the rank of each port of a layout node.
	 * 
	 * @param forward if true, ranks are determined for a forward layer sweep,
	 *     else for a backwards layer sweep
	 */
	private void calcPortRanks(boolean forward) {
		LayoutDirection layoutDirection = layer.getLayeredGraph().getLayoutDirection();
		if (forward)
			forwardPortRanks = new HashMap<KPort, Integer>();
		else
			backwardsPortRanks = new HashMap<KPort, Integer>();
		
		if (elemObj instanceof KNode) {
			// sort all ports by their relative position
			List<KPort> ports = ((KNode)elemObj).getPorts();
			KPort[] portArray = LayoutGraphUtil.sortPortsByPosition(ports,
					layoutDirection, forward);
			// set the ranks in the newly sorted list
			if (forward) {
				for (int i = 0; i < portArray.length; i++) {
					forwardPortRanks.put(portArray[i], Integer.valueOf(i));
				}
			}
			else {
				for (int i = 0; i < portArray.length; i++) {
					backwardsPortRanks.put(portArray[i], Integer.valueOf(i));
				}	
			}
		}
		else if (elemObj instanceof KPort) {
			if (forward)
				forwardPortRanks.put((KPort)elemObj, Integer.valueOf(0));
			else
				backwardsPortRanks.put((KPort)elemObj, Integer.valueOf(0));
		}
	}
	
}

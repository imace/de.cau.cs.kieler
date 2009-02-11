package de.cau.cs.kieler.klodd.orthogonal.structures;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutNode;
import de.cau.cs.kieler.klodd.orthogonal.impl.ec.EmbeddingConstraint;

/**
 * A node in the graph structure used for the topology-shape-metrics
 * approach.
 * 
 * @author msp
 */
public class TSMNode extends TSMGraphElement {

	/**
	 * Types of created node objects.
	 */
	public enum Type {
		/** node derived from the layout graph */
		LAYOUT,
		/** node created for EC expansion */
		ECEXPANSION,
		/** node created to replace an edge crossing */
		CROSSING,
		/** node created to replace an edge bend */
		BEND,
		/** node for normalization, north-east corner */
		NORM_NE,
		/** node for normalization, south-east corner */
		NORM_SE,
		/** node for normalization, south-west corner */
		NORM_SW,
		/** node for normalization, north-west corner */
		NORM_NW,
		/** node for normalization, port */
		NORM_PORT,
		/** node for refinement */
		REFINEMENT
	}
	
	/**
	 * Single entry of a incidence list. 
	 */
	public static class IncEntry {
		/** type of incidence entry: incoming or outgoing edge */
		public enum Type {
			IN,	OUT
		}
		
		/** the edge of this incidence entry */
		public TSMEdge edge;
		/** type of incidence: incoming or outgoing */
		public Type type;
		
		/**
		 * Creates an incidence list entry.
		 * 
		 * @param edge the edge
		 * @param type the incidence type
		 */
		public IncEntry(TSMEdge edge, Type type) {
			this.edge = edge;
			this.type = type;
		}
		
		/**
		 * Returns the endpoint of this incidence entry, as seen from the
		 * containing node.
		 * 
		 * @return the source of the edge if this is an incoming type,
		 *     else the target of the edge
		 */
		public TSMNode endpoint() {
			if (type == Type.IN)
				return edge.source;
			else
				return edge.target;
		}
		
		/**
		 * Returns the left face of this incidence entry, as seen from
		 * the containing node.
		 * 
		 * @return the right face of the edge if this is an incoming
		 *     type, else the left face of the edge
		 */
		public TSMFace leftFace() {
			if (type == Type.IN)
				return edge.rightFace;
			else
				return edge.leftFace;
		}
		
		/**
		 * Returns the side of the containing node on which this
		 * incidence entry lies.
		 * 
		 * @return the target side of the edge if this is an incoming
		 *     type, else the source side
		 */
		public Side side() {
			if (type == Type.IN)
				return edge.targetSide;
			else
				return edge.sourceSide;
		}
		
	}
	
	/**
	 * Definition of sides of a node. The order of side definitions
	 * ensures that the default enumeration comparator implementation
	 * respects the node sides found in clockwise order.
	 */
	public static enum Side {
		/** the side is undefined */
		UNDEFINED,
		/* side definitions in clockwise order */
		NORTH, EAST, SOUTH, WEST;
		
		/**
		 * Returns the next side in clockwise order.
		 * 
		 * @return the next side in clockwise order
		 */
		public Side right() {
			switch (this) {
			case NORTH:
				return EAST;
			case EAST:
				return SOUTH;
			case SOUTH:
				return WEST;
			case WEST:
				return NORTH;
			default:
				return UNDEFINED;
			}
		}
		
		/**
		 * Returns the next side in counter-clockwise order.
		 * 
		 * @return the next side in counter-clockwise order
		 */
		public Side left() {
			switch (this) {
			case NORTH:
				return WEST;
			case EAST:
				return NORTH;
			case SOUTH:
				return EAST;
			case WEST:
				return SOUTH;
			default:
				return UNDEFINED;
			}
		}
		
		/**
		 * Returns the opposed side.
		 * 
		 * @return the opposed side
		 */
		public Side opposed() {
			switch (this) {
			case NORTH:
				return SOUTH;
			case EAST:
				return WEST;
			case SOUTH:
				return NORTH;
			case WEST:
				return EAST;
			default:
				return UNDEFINED;
			}
		}
	}
	
	/** list of incident edges */
	public final List<IncEntry> incidence = new LinkedList<IncEntry>();
	/** object contained in this node, or null if there is none */
	public Object object;
	/** the type of this node */
	public Type type;
	/** the embedding constraint for planarization of this node */
	public EmbeddingConstraint embeddingConstraint;
	/** abstract x coordinate position */
	public int abstrXpos;
	/** abstract y coordinate position */
	public int abstrYpos;
	/** concrete x coordinate position */
	public float concrXpos;
	/** concrete y coordinate position */
	public float concrYpos;
	
	/**
	 * Creates a node containing the given object.
	 * 
	 * @param graph the graph to which the new node shall be added
	 * @param type node type
	 * @param obj the object to be contained
	 */
	public TSMNode(TSMGraph graph, Type type, Object obj) {
		graph.nodes.add(this);
		this.type = type;
		this.object = obj;
		this.id = graph.nextNodeId++;
	}
	
	/**
	 * Creates a node containing no object.
	 * 
	 * @param graph the graph to which the new node shall be added
	 * @param type node type
	 */
	public TSMNode(TSMGraph graph, Type type) {
		graph.nodes.add(this);
		this.type = type;
		this.object = null;
		this.id = graph.nextNodeId++;
	}
	
	/**
	 * Gets a list iterator for this node's incidence list, with the
	 * current position at the given edge. The returned list iterator
	 * has its cursor directly after the edge
	 * 
	 * @param edge edge at which the iterator shall point
	 * @param outgoing is the given edge an outgoing edge?
	 * @return iterator pointing at <code>edge</code>, or null if
	 *     the edge was not found
	 */
	public ListIterator<TSMNode.IncEntry> getIterator(TSMEdge edge,
			boolean outgoing) {
		ListIterator<IncEntry> edgeIter = incidence.listIterator();
		while (edgeIter.hasNext()) {
			IncEntry nextEntry = edgeIter.next();
			if (nextEntry.edge.id == edge.id && (nextEntry.type
					== IncEntry.Type.OUT) == outgoing)
				return edgeIter;
		}
		return null;
	}
	
	/**
	 * Applies the new layout to the original layout node.
	 * 
	 * @param offsetX x offset to be added
	 * @param offsetY y offset to be added
	 */
	public void applyLayout(float offsetX, float offsetY) {
		if (object instanceof KLayoutNode) {
			KLayoutNode layoutNode = (KLayoutNode)object;
			layoutNode.getLayout().getLocation().setX(concrXpos + offsetX);
			layoutNode.getLayout().getLocation().setY(concrYpos + offsetY);
		}
	}
	
}

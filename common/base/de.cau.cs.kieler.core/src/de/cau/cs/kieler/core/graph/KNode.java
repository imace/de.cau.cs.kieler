package de.cau.cs.kieler.core.graph;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * A node in the graph structure used for the topology-shape-metrics
 * approach.
 * 
 * @author msp
 */
public class KNode extends KGraphElement {

	/**
	 * Single entry of a incidence list. 
	 */
	public static class IncEntry {
		/** type of incidence entry: incoming or outgoing edge */
		public enum Type {
			IN,	OUT
		}
		
		/** the edge of this incidence entry */
		public KEdge edge;
		/** type of incidence: incoming or outgoing */
		public Type type;
		
		/**
		 * Creates an incidence list entry.
		 * 
		 * @param edge the edge
		 * @param type the incidence type
		 */
		public IncEntry(KEdge edge, Type type) {
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
		public KNode endpoint() {
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
		public KFace leftFace() {
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
		
		/*
		 * (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		public String toString() {
			return type.toString() + edge.id;
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
	/** concrete x coordinate position */
	public float concrXpos;
	/** concrete y coordinate position */
	public float concrYpos;
	
	/**
	 * Creates a node containing the given object.
	 * 
	 * @param graph the graph to which the new node shall be added
	 * @param obj the object to be contained
	 */
	public KNode(KGraph graph, Object obj) {
		graph.nodes.add(this);
		this.object = obj;
		this.id = graph.nextNodeId++;
	}
	
	/**
	 * Creates a node containing no object.
	 * 
	 * @param graph the graph to which the new node shall be added
	 */
	public KNode(KGraph graph) {
		graph.nodes.add(this);
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
	public ListIterator<KNode.IncEntry> getIterator(KEdge edge,
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
	
}

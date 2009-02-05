package de.cau.cs.kieler.klodd.orthogonal.structures;

import java.util.LinkedList;
import java.util.List;

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
		NORM_PORT
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
		
		/**
		 * Returns true if the edge is the first one on its corresponding
		 * side of the containing node.
		 * 
		 * @return true if the edge is first at its target node for
		 *     incoming types, or if it is first at its source node
		 *     for outgoing types
		 */
		public boolean isFirstEdge() {
			if (type == Type.IN)
				return edge.firstEdgeAtTarget;
			else
				return edge.firstEdgeAtSource;
		}
	}
	
	/**
	 * Definition of sides of a node.
	 */
	public static enum Side {
		UNDEFINED, NORTH, EAST, SOUTH, WEST;
		
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
	public List<IncEntry> incidence = new LinkedList<IncEntry>();
	/** object contained in this node, or null if there is none */
	public Object object;
	/** the type of this node */
	public Type type;
	
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
	
}

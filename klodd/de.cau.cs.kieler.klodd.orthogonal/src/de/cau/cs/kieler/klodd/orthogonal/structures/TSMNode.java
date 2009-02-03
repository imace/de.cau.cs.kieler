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

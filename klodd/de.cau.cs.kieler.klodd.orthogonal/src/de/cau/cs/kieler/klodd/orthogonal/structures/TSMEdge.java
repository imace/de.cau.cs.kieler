package de.cau.cs.kieler.klodd.orthogonal.structures;

import java.util.LinkedList;
import java.util.List;

import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KEdge;

/**
 * An edge in the graph structure used for the topology-shape-metrics
 * approach.
 * 
 * @author msp
 */
public class TSMEdge extends TSMGraphElement {

	/**
	 * Definition of an edge bend for orthogonal drawing.
	 */
	public static class Bend {
		/** Type of edge bend, from the perspective of the source node */
		public enum Type {
			LEFT, RIGHT
		}
		/** the type of edge bend */
		public Type type;
		/** the x coordinate position */
		public float xpos;
		/** the y coordinate position */
		public float ypos;
		
		/**
		 * Creates an edge bend of given type.
		 * @param type type of edge bend
		 */
		public Bend(Type type) {
			this.type = type;
		}
	}
	
	/** source node */
	public TSMNode source;
	/** target node */
	public TSMNode target;
	/** left face */
	public TSMFace leftFace;
	/** right face */
	public TSMFace rightFace;
	/** layout graph edge contained in this TSM edge, or null if there is none */
	public KEdge layoutEdge;
	/** the previous edge of a split edge */
	public TSMEdge previousEdge;
	/** the next edge of a split edge */
	public TSMEdge nextEdge;
	/** the bends of this edge */
	public List<Bend> bends = new LinkedList<Bend>();
	
	/**
	 * Creates an edge connecting two existing nodes, with a layout graph
	 * edge as reference.
	 * 
	 * @param graph the graph to which the new edge shall be added
	 * @param source source node
	 * @param target target node
	 * @param layoutEdge the layout graph edge to be contained
	 */
	public TSMEdge(TSMGraph graph, TSMNode source, TSMNode target,
			boolean connectNodes, KEdge layoutEdge) {
		graph.edges.add(this);
		this.id = graph.nextEdgeId++;
		this.source = source;
		this.target = target;
		this.layoutEdge = layoutEdge;
		if (connectNodes) {
			source.edges.add(this);
			target.edges.add(this);
		}
	}
	
	/**
	 * Creates an edge connecting two existing nodes.
	 * 
	 * @param graph the graph to which the new edge shall be added
	 * @param source source node
	 * @param target target node
	 */
	public TSMEdge(TSMGraph graph, TSMNode source, TSMNode target,
			boolean connectNodes) {
		this(graph, source, target, connectNodes, null);
	}
	
	/**
	 * Returns the other endpoint of this edge, given one endpoint. Nodes
	 * are compared by their identification number.
	 * 
	 * @param node must be either the source or the target of this edge
	 * @return the target if <code>node</code> is the source, else the source
	 */
	public TSMNode getEndpoint(TSMNode node) {
		if (node.id == source.id) {
			return target;
		}
		else {
			assert node.id == target.id;
			return source;
		}
	}
	
	/**
	 * Returns the other face of this edge, given one face. Faces are
	 * compared by their identification number.
	 * 
	 * @param face must be either the left or the right face of this edge
	 * @return the right face if <code>face</code> is the left face, else
	 *     the left face
	 */
	public TSMFace getOpposed(TSMFace face) {
		if (face.id == leftFace.id) {
			return rightFace;
		}
		else {
			assert face.id == rightFace.id;
			return leftFace;
		}
	}
	
	/**
	 * Returns the node that lies on the right of this edge from the
	 * point of view of the given face. Faces are compared by their
	 * identification number
	 * 
	 * @param face must be either the left or the right face of this edge
	 * @return the source node if <code>face</code> is the left face,
	 *     else the target node
	 */
	public TSMNode getRightNodeFrom(TSMFace face) {
		if (face.id == leftFace.id) {
			return source;
		}
		else {
			assert face.id == rightFace.id;
			return target;
		}
	}
	
	/**
	 * Returns the face that lies on the left of this edge from the point
	 * of view of the given node. Nodes are compared by their identification
	 * number.
	 * 
	 * @param node must be either the source or the target of this edge
	 * @return the left face if <code>node</code> is the source, else the
	 *     right face
	 */
	public TSMFace getLeftFaceFrom(TSMNode node) {
		if (node.id == source.id) {
			return leftFace;
		}
		else {
			assert node.id == target.id;
			return rightFace;
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object other) {
		return (other instanceof TSMEdge)
				&& ((TSMEdge)other).id == this.id;
	}
	
}

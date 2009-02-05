package de.cau.cs.kieler.klodd.orthogonal.structures;

import java.util.LinkedList;
import java.util.List;

import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutEdge;

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
	public KLayoutEdge layoutEdge;
	/** the previous edge of a split edge */
	public TSMEdge previousEdge;
	/** the next edge of a split edge */
	public TSMEdge nextEdge;
	/** the bends of this edge */
	public List<Bend> bends = new LinkedList<Bend>();
	/** the side on which the edge leaves the source */
	public TSMNode.Side sourceSide = TSMNode.Side.UNDEFINED;
	/** the side on which the edge reaches the target */
	public TSMNode.Side targetSide = TSMNode.Side.UNDEFINED;
	/** indicates whether this edge is the first edge on its side at source */
	public boolean firstEdgeAtSource = false;
	/** indicates whether this edge is the first edge on its side at target */
	public boolean firstEdgeAtTarget = false;
	
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
			KLayoutEdge layoutEdge) {
		graph.edges.add(this);
		this.id = graph.nextEdgeId++;
		this.source = source;
		this.target = target;
		this.layoutEdge = layoutEdge;
	}
	
	/**
	 * Creates an edge connecting two existing nodes.
	 * 
	 * @param graph the graph to which the new edge shall be added
	 * @param source source node
	 * @param target target node
	 */
	public TSMEdge(TSMGraph graph, TSMNode source, TSMNode target) {
		this(graph, source, target, null);
	}
	
	/**
	 * Connects this edge with the source and target. New incidence
	 * entries are created for the incidence lists of the source and
	 * the target.
	 */
	public void connectNodes() {
		source.incidence.add(new TSMNode.IncEntry(this,
				TSMNode.IncEntry.Type.OUT));
		target.incidence.add(new TSMNode.IncEntry(this,
				TSMNode.IncEntry.Type.IN));
	}
	
	/**
	 * Connects this edge with the source and target with given ranks.
	 * New incidence entries are created for the incidence lists of the
	 * source and the target.
	 * 
	 * @param sourceRank rank of the edge at source
	 * @param targetRank rank of the edge at target
	 * @param forwardSelfLoop for self-loops: is the target rank greater
	 *     than the source rank?
	 */
	public void connectNodes(int sourceRank, int targetRank, boolean
			forwardSelfLoop) {
		if (source.id == target.id && (sourceRank < targetRank
				|| (sourceRank == targetRank && forwardSelfLoop)))
			targetRank++;
		source.incidence.add(sourceRank, new TSMNode.IncEntry(this,
				TSMNode.IncEntry.Type.OUT));
		target.incidence.add(targetRank, new TSMNode.IncEntry(this,
				TSMNode.IncEntry.Type.IN));		
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

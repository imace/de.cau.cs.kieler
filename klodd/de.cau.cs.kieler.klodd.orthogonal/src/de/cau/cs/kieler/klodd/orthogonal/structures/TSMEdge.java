package de.cau.cs.kieler.klodd.orthogonal.structures;

import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KEdge;

/**
 * An edge in the graph structure used for the topology-shape-metrics
 * approach.
 * 
 * @author msp
 */
public class TSMEdge {

	/** source node */
	public TSMNode source;
	/** target node */
	public TSMNode target;
	/** layout graph edge contained in this TSM edge, or null if there is none */
	public KEdge layoutEdge;
	/** rank of this edge, used by various algorithms */
	public int rank = 0;
	
	/**
	 * Creates an edge connecting two existing nodes, with a layout graph
	 * edge as reference.
	 * 
	 * @param source source node
	 * @param target target node
	 * @param layoutEdge the layout graph edge to be contained
	 */
	public TSMEdge(TSMNode source, TSMNode target, KEdge layoutEdge) {
		this.source = source;
		this.target = target;
		this.layoutEdge = layoutEdge;
		source.edges.add(this);
		target.edges.add(this);
	}
	
	/**
	 * Creates an edge connecting two existing nodes.
	 * 
	 * @param source source node
	 * @param target target node
	 */
	public TSMEdge(TSMNode source, TSMNode target) {
		this.source = source;
		this.target = target;
		this.layoutEdge = null;
		source.edges.add(this);
		target.edges.add(this);
	}
	
	/**
	 * Returns the other endpoint of this edge, given one endpoint. Nodes
	 * are compared by their creation number.
	 * 
	 * @param node must be either the source or the target of this edge
	 * @return the target if <code>node</code> is the source, else the source
	 */
	public TSMNode getEndpoint(TSMNode node) {
		if (node.nr == source.nr) {
			return target;
		}
		else {
			assert node.nr == target.nr;
			return source;
		}
	}
	
}

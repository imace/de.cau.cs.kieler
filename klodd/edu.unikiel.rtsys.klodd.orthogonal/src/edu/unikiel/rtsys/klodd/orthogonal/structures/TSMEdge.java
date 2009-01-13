package edu.unikiel.rtsys.klodd.orthogonal.structures;

import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KEdge;

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
	
}

package edu.unikiel.rtsys.klodd.orthogonal.structures;

import java.util.LinkedList;
import java.util.List;

/**
 * A node in the graph structure used for the topology-shape-metrics
 * approach.
 * 
 * @author msp
 */
public class TSMNode implements Comparable<TSMNode> {

	/** list of incident edges */
	public List<TSMEdge> edges = new LinkedList<TSMEdge>();
	/** object contained in this node, or null if there is none */
	public Object object;
	/** creation number of this node, determined at creation time */
	public int nr;
	/** rank of this node, used by various algorithms */
	public int rank = 0;
	
	/**
	 * Creates a node containing the given object.
	 * 
	 * @param graph the graph to which the new node shall be added
	 * @param obj the object to be contained
	 */
	public TSMNode(TSMGraph graph, Object obj) {
		graph.nodes.add(this);
		this.object = obj;
		this.nr = graph.nextNodeNr++;
	}
	
	/**
	 * Creates a node containing the given object.
	 * 
	 * @param graph the graph to which the new node shall be added
	 */
	public TSMNode(TSMGraph graph) {
		graph.nodes.add(this);
		this.object = null;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(TSMNode other) {
		return this.nr > other.nr ? 1
				: (this.nr < other.nr ? -1
				: 0);
	}
	
}

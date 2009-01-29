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

	/** list of incident edges */
	public List<TSMEdge> edges = new LinkedList<TSMEdge>();
	/** object contained in this node, or null if there is none */
	public Object object;
	
	/**
	 * Creates a node containing the given object.
	 * 
	 * @param graph the graph to which the new node shall be added
	 * @param obj the object to be contained
	 */
	public TSMNode(TSMGraph graph, Object obj) {
		graph.nodes.add(this);
		this.object = obj;
		this.id = graph.nextNodeId++;
	}
	
	/**
	 * Creates a node containing no object.
	 * 
	 * @param graph the graph to which the new node shall be added
	 */
	public TSMNode(TSMGraph graph) {
		graph.nodes.add(this);
		this.object = null;
		this.id = graph.nextNodeId++;
	}
	
}

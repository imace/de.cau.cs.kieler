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
		CROSSING
	}
	
	/** list of incident edges */
	public List<TSMEdge> edges = new LinkedList<TSMEdge>();
	/** object contained in this node, or null if there is none */
	public Object object;
	
	/** the type of this node */
	private Type type;
	
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
	 * Returns the type of this node.
	 * 
	 * @return the node type
	 */
	public Type getType() {
		return type;
	}
	
}

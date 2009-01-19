package de.cau.cs.kieler.klodd.orthogonal.structures;

import java.util.LinkedList;
import java.util.List;

import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KNodeGroup;


/**
 * The graph structure used internally for the topology-shape-metrics
 * approach.
 * 
 * @author msp
 */
public class TSMGraph {

	/** list of nodes in this TSM graph */
	public List<TSMNode> nodes = new LinkedList<TSMNode>();

	/** next available creation number */
	int nextNodeNr = 0;
	
	/** parent node group from which this TSM graph was created */
	private KNodeGroup parentGroup;
	
	/**
	 * Creates a TSM graph from a given parent node group.
	 * 
	 * @param parentGroup parent node group
	 */
	public TSMGraph(KNodeGroup parentGroup) {
		this.parentGroup = parentGroup;
	}
	
	/**
	 * Applies all layout information to the contained layout graph objects.
	 */
	public void applyLayout() {
		// TODO apply layout
	}
	
}

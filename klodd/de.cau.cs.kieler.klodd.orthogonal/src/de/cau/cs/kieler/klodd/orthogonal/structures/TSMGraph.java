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
	/** list of edges in this TSM graph */
	public List<TSMEdge> edges = new LinkedList<TSMEdge>();
	/** list of internal faces in this TSM graph */
	public List<TSMFace> faces = new LinkedList<TSMFace>();
	/** the external face of this TSM graph */
	public TSMFace externalFace = new TSMFace(this);

	/** next available identifier for nodes */
	int nextNodeId = 0;
	/** next available identifier for edges */
	int nextEdgeId = 0;
	/** next available identifier for faces */
	int nextFaceId = 0;
	
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

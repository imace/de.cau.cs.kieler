package de.cau.cs.kieler.klodd.orthogonal.structures;

import java.util.LinkedList;
import java.util.List;


/**
 * The graph structure used internally for the topology-shape-metrics
 * approach.
 * 
 * @author msp
 */
public class TSMGraph {

	/** list of nodes in this TSM graph */
	public final List<TSMNode> nodes = new LinkedList<TSMNode>();
	/** list of edges in this TSM graph */
	public final List<TSMEdge> edges = new LinkedList<TSMEdge>();
	/** list of internal faces in this TSM graph */
	public final List<TSMFace> faces = new LinkedList<TSMFace>();
	/** the external face of this TSM graph */
	public TSMFace externalFace = new TSMFace(this, false);

	/** next available identifier for nodes */
	int nextNodeId = 0;
	/** next available identifier for edges */
	int nextEdgeId = 0;
	/** next available identifier for faces */
	int nextFaceId = 0;
	
	/** parent layout node from which this TSM graph was created */
	//private KLayoutNode parentNode;
	
	/**
	 * Creates a TSM graph from a given parent layout node.
	 * 
	 * @param parentNode parent layout node
	 */
	//public TSMGraph(KLayoutNode parentNode) {
	//	this.parentNode = parentNode;
	//}
	
	/**
	 * Applies all layout information to the contained layout graph objects.
	 */
	public void applyLayout() {
		// TODO apply layout
	}
	
}

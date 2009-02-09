package de.cau.cs.kieler.klodd.orthogonal.structures;

import java.util.LinkedList;
import java.util.List;

import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KInsets;


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
	
	/** total width of the graph */
	public float width;
	/** total height of the graph */
	public float height;

	/** next available identifier for nodes */
	int nextNodeId = 0;
	/** next available identifier for edges */
	int nextEdgeId = 0;
	/** next available identifier for faces */
	int nextFaceId = 0;
	
	/**
	 * Applies all layout information to the contained layout graph objects.
	 */
	public void applyLayout(float offsetX, float offsetY, KInsets insets) {
		float totalXoff = offsetX + insets.getLeft();
		float totalYoff = offsetY + insets.getTop();
		
		// apply node layout
		for (TSMNode node : nodes)
			node.applyLayout(totalXoff, totalYoff);
		
		// apply edge layout
		for (TSMEdge edge : edges)
			edge.rank = 0;
		for (TSMEdge edge : edges) {
			if (edge.rank == 0)
				edge.applyLayout(totalXoff, totalYoff);
		}
	}
	
}

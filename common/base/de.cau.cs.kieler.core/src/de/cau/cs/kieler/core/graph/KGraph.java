package de.cau.cs.kieler.core.graph;

import java.util.LinkedList;
import java.util.List;

/**
 * The general-purpose KIELER graph structure.
 * 
 * @author msp
 */
public class KGraph {

	/** list of nodes in this TSM graph */
	public final List<KNode> nodes = new LinkedList<KNode>();
	/** list of edges in this TSM graph */
	public final List<KEdge> edges = new LinkedList<KEdge>();
	/** list of internal faces in this TSM graph */
	public final List<KFace> faces = new LinkedList<KFace>();
	/** the external face of this TSM graph */
	public KFace externalFace = new KFace(this, false);
	
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
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "TSMGraph(" + nodes.size() + " nodes, " + edges.size()
				+ " edges, " + (faces.size() + 1) + " faces)";
	}
	
}

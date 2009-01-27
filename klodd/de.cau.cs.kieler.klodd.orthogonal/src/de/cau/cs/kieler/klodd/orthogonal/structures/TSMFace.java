package de.cau.cs.kieler.klodd.orthogonal.structures;

import java.util.LinkedList;
import java.util.List;

/**
 * A face in the graph structure used for the topology-shape-metrics
 * approach.
 * 
 * @author msp
 */
public class TSMFace extends TSMGraphElement {

	/** set of lists of bordering edges (can be multiple lists for the
	 *  external face) */
	public List<List<TSMEdge>> edgeLists = new LinkedList<List<TSMEdge>>();
	
	/**
	 * Creates a face and adds it to the given graph.
	 * 
	 * @param graph graph to which the new face shall be added
	 */
	public TSMFace(TSMGraph graph) {
		graph.faces.add(this);
		this.id = graph.nextFaceId++;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object other) {
		return (other instanceof TSMFace)
				&& ((TSMFace)other).id == this.id;
	}
	
}

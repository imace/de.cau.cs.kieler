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

	/**
	 * An entry of a list associated with a face.
	 */
	public static class BorderEntry {
		/** an edge bordering this face */
		public TSMEdge edge;
		/** the first node encountered when passing the edge with this
		 *  face on the right side */
		public TSMNode node;
		
		/**
		 * Creates a border entry for the given edge.
		 * 
		 * @param edge edge bordering the containing face
		 * @param node the first node encountered when passing the edge
		 *     with the containing face on the right side
		 */
		public BorderEntry(TSMEdge edge, TSMNode node) {
			this.edge = edge;
			this.node = node;
		}
	}
	
	/** set of lists of bordering edges (can be multiple lists for the
	 *  external face) */
	public List<List<BorderEntry>> borders = new LinkedList<List<BorderEntry>>();
	
	/**
	 * Creates a face and optionally adds it to the given graph.
	 * 
	 * @param graph graph to which the new face shall be added
	 * @param addToInternal if true, the new face is added to the
	 *     graph's list of internal faces 
	 */
	public TSMFace(TSMGraph graph, boolean addToInternal) {
		if (addToInternal)
			graph.faces.add(this);
		this.id = graph.nextFaceId++;
	}

	/**
	 * Creates a face and adds it to the given graph.
	 * 
	 * @param graph graph to which the new face shall be added
	 */
	public TSMFace(TSMGraph graph) {
		this(graph, true);
	}
	
}

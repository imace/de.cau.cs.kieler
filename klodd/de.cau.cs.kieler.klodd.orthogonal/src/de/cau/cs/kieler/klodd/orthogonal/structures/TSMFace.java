package de.cau.cs.kieler.klodd.orthogonal.structures;

import java.util.LinkedList;
import java.util.List;

/**
 * A face in the graph structure used for the topology-shape-metrics
 * approach.
 * 
 * @author msp
 */
public class TSMFace {

	/** list of bordering edges */
	public List<TSMEdge> edges = new LinkedList<TSMEdge>();
	
	/**
	 * Creates a face and adds it to the given graph.
	 * 
	 * @param graph graph to which the new face shall be added
	 */
	public TSMFace(TSMGraph graph) {
		graph.faces.add(this);
	}
	
}

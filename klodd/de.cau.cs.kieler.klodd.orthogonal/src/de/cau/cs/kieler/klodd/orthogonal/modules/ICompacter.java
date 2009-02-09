package de.cau.cs.kieler.klodd.orthogonal.modules;

import de.cau.cs.kieler.klodd.core.algorithms.IAlgorithm;
import de.cau.cs.kieler.klodd.orthogonal.structures.TSMGraph;

/**
 * Interface for algorithms that perform compaction of a graph.
 * 
 * @author msp
 */
public interface ICompacter extends IAlgorithm {

	/**
	 * Performs compaction of a given TSM graph.
	 * 
	 * @param graph TSM graph that is to be filled with metrics information.
	 * @param minDist minimal distance between elements
	 */
	public void compact(TSMGraph graph, float minDist);
	
}

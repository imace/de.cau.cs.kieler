package de.cau.cs.kieler.klodd.hierarchical.modules;

import de.cau.cs.kieler.core.alg.IAlgorithm;
import de.cau.cs.kieler.klodd.hierarchical.structures.LayeredGraph;

/**
 * Interface for algorithms that route edges in a layered graph.
 * 
 * @author msp
 */
public interface IEdgeRouter extends IAlgorithm {
	
	/**
	 * Route the edges of the given layered graph.
	 * 
	 * @param layeredGraph layered graph to process
	 * @param minDist minimal distance between two edges
	 */
	public void routeEdges(LayeredGraph layeredGraph, float minDist);

}

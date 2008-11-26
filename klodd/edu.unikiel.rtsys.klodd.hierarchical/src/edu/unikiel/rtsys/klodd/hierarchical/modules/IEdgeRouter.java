package edu.unikiel.rtsys.klodd.hierarchical.modules;

import edu.unikiel.rtsys.klodd.core.algorithms.IAlgorithm;
import edu.unikiel.rtsys.klodd.hierarchical.structures.LayeredGraph;

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

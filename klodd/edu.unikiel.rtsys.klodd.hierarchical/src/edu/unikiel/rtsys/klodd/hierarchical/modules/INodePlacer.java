package edu.unikiel.rtsys.klodd.hierarchical.modules;

import edu.unikiel.rtsys.klodd.core.algorithms.IAlgorithm;
import edu.unikiel.rtsys.klodd.hierarchical.structures.LayeredGraph;

/**
 * Interface for algorithms that determine a placement for each node
 * in a layered graph.
 * 
 * @author msp
 */
public interface INodePlacer extends IAlgorithm {

	/**
	 * Determine a placement for each node in the given layered graph.
	 * 
	 * @param layeredGraph layered graph to process
	 * @param minDist minimal distance between two nodes or edges in each layer
	 */
	public void placeNodes(LayeredGraph layeredGraph, float minDist);
	
}

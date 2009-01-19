package de.cau.cs.kieler.klodd.hierarchical.modules;

import de.cau.cs.kieler.klodd.core.algorithms.IAlgorithm;
import de.cau.cs.kieler.klodd.hierarchical.structures.LayeredGraph;

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

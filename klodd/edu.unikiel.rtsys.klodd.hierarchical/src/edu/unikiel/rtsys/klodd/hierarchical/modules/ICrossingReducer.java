package edu.unikiel.rtsys.klodd.hierarchical.modules;

import edu.unikiel.rtsys.klodd.core.algorithms.IAlgorithm;
import edu.unikiel.rtsys.klodd.hierarchical.structures.LayeredGraph;

/**
 * Interface for algorithms that reduce crossings in a layered graph.
 * 
 * @author msp
 */
public interface ICrossingReducer extends IAlgorithm {

	/**
	 * Reduces the number of crossings in a given layered directed
	 * graph by changing the order of nodes in each layer.
	 * 
	 * @param layeredGraph layered graph to process
	 */
	public void reduceCrossings(LayeredGraph layeredGraph);
	
}

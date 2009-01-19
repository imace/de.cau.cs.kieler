package de.cau.cs.kieler.klodd.hierarchical.modules;

import de.cau.cs.kieler.klodd.core.algorithms.IAlgorithm;
import de.cau.cs.kieler.klodd.hierarchical.structures.LayeredGraph;

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

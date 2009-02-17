package de.cau.cs.kieler.klodd.hierarchical.modules;

import de.cau.cs.kieler.core.alg.IAlgorithm;
import de.cau.cs.kieler.klodd.hierarchical.structures.LayeredGraph;

/**
 * Interface for algorithms that calculate routing slots for connections
 * starting and ending at regular nodes.
 * 
 * @author msp
 */
public interface INodewiseEdgePlacer extends IAlgorithm {

	/**
	 * Determine placement for all edges starting or ending at
	 * regular nodes of the given layered graph.
	 * 
	 * @param layeredGraph
	 */
	public void placeEdges(LayeredGraph layeredGraph);
	
}

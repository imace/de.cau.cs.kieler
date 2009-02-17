package de.cau.cs.kieler.klodd.orthogonal.modules;

import de.cau.cs.kieler.core.alg.IAlgorithm;
import de.cau.cs.kieler.klodd.orthogonal.structures.TSMGraph;

/**
 * Interface for algorithms that perform planarization of a graph.
 * 
 * @author msp
 */
public interface IPlanarizer extends IAlgorithm {

	/**
	 * Performs planarization of the given graph. This is done by adding
	 * dummy nodes to replace edge crossings.
	 * 
	 * @param graph graph to be planarized
	 */
	public void planarize(TSMGraph graph);
	
}

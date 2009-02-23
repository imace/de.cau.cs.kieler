package de.cau.cs.kieler.klodd.orthogonal.modules;

import de.cau.cs.kieler.core.alg.IAlgorithm;
import de.cau.cs.kieler.core.graph.KGraph;

/**
 * Interface for algorithms that perform orthogonalization of a graph.
 * 
 * @author msp
 */
public interface IOrthogonalizer extends IAlgorithm {
	
	/**
	 * Performs orthogonalization of a given TSM graph.
	 * 
	 * @param graph TSM graph that is to be filled with shape information
	 */
	public void orthogonalize(KGraph graph);

}

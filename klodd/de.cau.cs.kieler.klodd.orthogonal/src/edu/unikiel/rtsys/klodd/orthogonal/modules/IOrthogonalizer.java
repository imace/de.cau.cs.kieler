package edu.unikiel.rtsys.klodd.orthogonal.modules;

import edu.unikiel.rtsys.klodd.core.algorithms.IAlgorithm;
import edu.unikiel.rtsys.klodd.orthogonal.structures.TSMGraph;

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
	public void orthogonalize(TSMGraph graph);

}

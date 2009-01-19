package edu.unikiel.rtsys.klodd.orthogonal.modules;

import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KNodeGroup;
import edu.unikiel.rtsys.klodd.core.algorithms.IAlgorithm;
import edu.unikiel.rtsys.klodd.orthogonal.structures.TSMGraph;

/**
 * Interface for algorithms that perform planarization of a graph.
 * 
 * @author msp
 */
public interface IPlanarizer extends IAlgorithm {

	/**
	 * Performs planarization of the given layout graph.
	 * 
	 * @param nodeGroup KIML layout graph to be planarized
	 * @return a TSM graph with topology information
	 */
	public TSMGraph planarize(KNodeGroup nodeGroup);
	
}

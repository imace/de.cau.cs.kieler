package de.cau.cs.kieler.klodd.orthogonal.modules;

import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KNodeGroup;
import de.cau.cs.kieler.klodd.core.algorithms.IAlgorithm;
import de.cau.cs.kieler.klodd.orthogonal.structures.TSMGraph;

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

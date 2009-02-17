package de.cau.cs.kieler.klodd.orthogonal.modules;

import de.cau.cs.kieler.core.alg.IAlgorithm;
import de.cau.cs.kieler.klodd.orthogonal.structures.GraphSection;

/**
 * Interface for algorithms that test planarity of a biconnected graph.
 * 
 * @author msp
 */
public interface IPlanarityTester extends IAlgorithm {

	/**
	 * Tests planarity of the given biconnected graph section. Any edge
	 * that is found to be incident with a node of the given section,
	 * but not part of the section itself, is removed from the graph.
	 * 
	 * @param biconnectedSection biconnected graph section
	 * @return true if the input graph is planar
	 */
	public boolean isPlanar(GraphSection biconnectedSection);
	
}

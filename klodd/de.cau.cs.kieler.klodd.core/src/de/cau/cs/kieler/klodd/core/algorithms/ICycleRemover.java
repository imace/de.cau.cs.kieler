package de.cau.cs.kieler.klodd.core.algorithms;

import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutNode;

/**
 * Interface for algorithms for removal of cycles in a layout graph.
 * 
 * @author msp
 */
public interface ICycleRemover extends IAlgorithm {

	/**
	 * Remove cycles in a given graph. Loops on a single node are
	 * ignored and have to be processed properly in later steps.
	 * 
	 * @param parentNode set of nodes to be processed
	 */
	public void removeCycles(KLayoutNode parentNode);
	
	/**
	 * Restore the original graph after cycles have been removed.
	 */
	public void restoreGraph();
	
}

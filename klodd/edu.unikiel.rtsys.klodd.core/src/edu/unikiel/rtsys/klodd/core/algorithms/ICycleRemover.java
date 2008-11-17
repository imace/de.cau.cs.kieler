package edu.unikiel.rtsys.klodd.core.algorithms;

import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KNodeGroup;

/**
 * Interface for algorithms for removal of cycles in a layout graph.
 * 
 * @author msp
 */
public interface ICycleRemover {

	/**
	 * Remove cycles in a given graph.
	 * 
	 * @param parentGroup set of nodes to be processed
	 */
	public void removeCycles(KNodeGroup parentGroup);
	
	/**
	 * Restore the original graph after cycles have been removed.
	 */
	public void restoreGraph();
	
}

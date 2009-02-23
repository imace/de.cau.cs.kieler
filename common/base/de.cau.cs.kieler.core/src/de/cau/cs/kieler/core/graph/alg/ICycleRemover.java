package de.cau.cs.kieler.core.graph.alg;

import java.util.List;

import de.cau.cs.kieler.core.alg.IAlgorithm;
import de.cau.cs.kieler.core.graph.KEdge;
import de.cau.cs.kieler.core.graph.KGraph;

/**
 * Interface for algorithms for removal of cycles in a layout graph.
 * 
 * @author msp
 */
public interface ICycleRemover extends IAlgorithm {

	/** rank value for edges that were reversed */
	public static final int REVERSED = 1;
	
	/**
	 * Remove cycles in a given graph. Loops on a single node are
	 * ignored and have to be processed properly in later steps. Each
	 * edge is assigned a rank with value <code>REVERSED</code> if and
	 * only if the edge was reversed for cycle removal.
	 * 
	 * @param graph graph to be processed
	 */
	public void removeCycles(KGraph graph);
	
	/**
	 * Restore the original graph after cycles have been removed.
	 */
	public void restoreGraph();
	
	/**
	 * Returns the list of edges that were reversed for cycle removal;
	 * 
	 * @return list of reversed edges
	 * @throws IllegalStateException if <code>removeCycles</code> was not
	 *     called prior to this method call
	 */
	public List<KEdge> getReversedEdges() throws IllegalStateException;
	
}

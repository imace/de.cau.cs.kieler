package de.cau.cs.kieler.klodd.hierarchical.modules;

import de.cau.cs.kieler.core.alg.IAlgorithm;
import de.cau.cs.kieler.klodd.hierarchical.structures.Layer;

/**
 * Interface for algorithms that offer heuristics for the 2-layer
 * and 3-layer crossing reduction problem.
 * 
 * @author msp
 */
public interface ISingleLayerCrossingReducer extends IAlgorithm {
	
	/**
	 * Reduce crossings by changing the order of nodes in the given
	 * layer. Only one other layer is considered for crossings reduction.
	 * 
	 * @param layer layer to be ordered
	 * @param forward if true, connections go to the given layer,
	 *     else from the given layer
	 */
	public void reduceCrossings(Layer layer, boolean forward);
	
	/**
	 * Reduce crossings by changing the order of nodes in the given
	 * layer. Both the preceding and the succeeding layers are considered
	 * for crossings reduction.
	 * 
	 * @param layer layer to be ordered
	 */
	public void reduceCrossings(Layer layer);

}

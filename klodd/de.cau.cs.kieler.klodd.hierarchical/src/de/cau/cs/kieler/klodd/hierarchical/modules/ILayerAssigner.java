package de.cau.cs.kieler.klodd.hierarchical.modules;

import de.cau.cs.kieler.core.alg.IAlgorithm;
import de.cau.cs.kieler.core.graph.KGraph;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutNode;
import de.cau.cs.kieler.klodd.hierarchical.structures.LayeredGraph;

/**
 * Interface for algorithms that assign layers to each node of a graph.
 * 
 * @author msp
 */
public interface ILayerAssigner extends IAlgorithm {
	
	/**
	 * Create a layered graph and assign layers to each node. The input
	 * ports must be put into the first layer (rank == 0), the output
	 * ports into the last layer (height == 0).
	 * 
	 * @param kGraph graph structure that contains no directed cycles
	 * @param parentNode the parent layout node
	 * @return a layered graph
	 */
	public LayeredGraph assignLayers(KGraph kGraph, KLayoutNode parentNode);

}

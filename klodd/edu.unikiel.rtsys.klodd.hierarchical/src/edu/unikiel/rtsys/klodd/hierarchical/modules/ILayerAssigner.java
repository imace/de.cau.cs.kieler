package edu.unikiel.rtsys.klodd.hierarchical.modules;

import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KNodeGroup;
import edu.unikiel.rtsys.klodd.core.algorithms.IAlgorithm;
import edu.unikiel.rtsys.klodd.hierarchical.structures.LayeredGraph;

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
	 * @param parentGroup
	 * @return
	 */
	public LayeredGraph assignLayers(KNodeGroup parentGroup);

}

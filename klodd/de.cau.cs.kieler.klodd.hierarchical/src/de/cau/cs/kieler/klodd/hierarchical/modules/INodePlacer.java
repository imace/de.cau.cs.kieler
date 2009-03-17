/******************************************************************************
 * KIELER - Kiel Integrated Environment for Layout for the Eclipse RCP
 *
 * http://www.informatik.uni-kiel.de/rtsys/kieler/
 * 
 * Copyright 2008 by
 * + Christian-Albrechts-University of Kiel
 *   + Department of Computer Science
 *     + Real-Time and Embedded Systems Group
 * 
 * This code is provided under the terms of the Eclipse Public License (EPL).
 * See the file epl-v10.html for the license text.
 */
package de.cau.cs.kieler.klodd.hierarchical.modules;

import de.cau.cs.kieler.core.alg.IAlgorithm;
import de.cau.cs.kieler.klodd.hierarchical.structures.LayeredGraph;

/**
 * Interface for algorithms that determine a placement for each node
 * in a layered graph.
 * 
 * @author msp
 */
public interface INodePlacer extends IAlgorithm {

	/**
	 * Determine a placement for each node in the given layered graph.
	 * 
	 * @param layeredGraph layered graph to process
	 * @param minDist minimal distance between two nodes or edges in each layer
	 */
	public void placeNodes(LayeredGraph layeredGraph, float minDist);
	
}

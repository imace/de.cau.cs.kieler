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
package de.cau.cs.kieler.klodd.hierarchical.impl;

import java.util.ListIterator;

import de.cau.cs.kieler.core.alg.AbstractAlgorithm;
import de.cau.cs.kieler.kiml.layout.options.PortConstraints;
import de.cau.cs.kieler.klodd.hierarchical.modules.ICrossingReducer;
import de.cau.cs.kieler.klodd.hierarchical.modules.ISingleLayerCrossingReducer;
import de.cau.cs.kieler.klodd.hierarchical.structures.*;


/**
 * Implementation of a crossing reducer that performs a layer-by-layer
 * sweep with a 2-layer crossing reducer.
 * 
 * @author <a href="mailto:msp@informatik.uni-kiel.de">Miro Sp&ouml;nemann</a>
 */
public class LayerSweepCrossingReducer extends AbstractAlgorithm implements
		ICrossingReducer {

	/** the algorithm used to reduce crossings between two or three layers */
	private ISingleLayerCrossingReducer layerReducer;
	
	/**
	 * Creates a layer-by-layer sweep crossing reducer with given single
	 * layer crossing reducer.
	 * 
	 * @param layerReducer the single layer crossing reducer
	 */
	public LayerSweepCrossingReducer(ISingleLayerCrossingReducer layerReducer) {
		this.layerReducer = layerReducer;
	}
	
	/* (non-Javadoc)
	 * @see de.cau.cs.kieler.klodd.hierarchical.modules.ICrossingReducer#reduceCrossings(de.cau.cs.kieler.klodd.hierarchical.structures.LayeredGraph)
	 */
	public void reduceCrossings(LayeredGraph layeredGraph) {
		int layerCount = layeredGraph.getLayers().size();
		int firstLayerIx = 0, lastLayerIx = layerCount - 1;
		getMonitor().begin("Crossing reduction", 2 * (layerCount - 1));
		PortConstraints externalConstraints = layeredGraph.getExternalPortConstraints();
		
		if (externalConstraints != PortConstraints.FREE_PORTS) {
			// sort input and output ports by their relative position
		    Layer firstLayer = layeredGraph.getLayers().get(firstLayerIx); 
	        if (firstLayer.rank == 0) {
				firstLayer.sortByPorts(false);
				if (externalConstraints != PortConstraints.FIXED_SIDE)
				    firstLayerIx += 2;
			}
			
			Layer lastLayer = layeredGraph.getLayers().get(lastLayerIx);
			if (lastLayer.height == 0) {
				lastLayer.sortByPorts(false);
				if (externalConstraints != PortConstraints.FIXED_SIDE)
	                lastLayerIx -= 2;
			}
		}
		
		// process all but the port layers and the last layer
		ListIterator<Layer> layerIter = layeredGraph.getLayers().listIterator(1);
		while (layerIter.nextIndex() <= lastLayerIx) {
			layerReducer.reset(getMonitor().subTask(1));
			layerReducer.reduceCrossings(layerIter.next(), true);
		}
		
		if (lastLayerIx < layerCount - 1) {
			// order the last layer by the preceding layer and the output ports layer
			layerReducer.reset(getMonitor().subTask(1));
			layerReducer.reduceCrossings(layerIter.next());
		}
		else {
		    if (externalConstraints == PortConstraints.FIXED_SIDE)
		        layeredGraph.getLayers().get(lastLayerIx).sortByPorts(true);
			layerIter.previous();
		}
		
		// process all but the port layers and the first layer again
		while (layerIter.previousIndex() >= firstLayerIx) {
			layerReducer.reset(getMonitor().subTask(1));
			layerReducer.reduceCrossings(layerIter.previous(), false);
		}
		
		if (firstLayerIx > 0) {
			// order the first layer by the subsequent layer and the input ports layer
			layerReducer.reset(getMonitor().subTask(1));
			layerReducer.reduceCrossings(layerIter.previous());
		}
		else {
		    if (externalConstraints == PortConstraints.FIXED_SIDE)
                layeredGraph.getLayers().get(firstLayerIx).sortByPorts(true);
            layerIter.next();
		}
		
		// find placements for all ports in the graph
		for (Layer layer : layeredGraph.getLayers()) {
		    for (LayerElement element : layer.getElements()) {
		        element.placePorts();
		    }
		}

		getMonitor().done();
	}

}

package edu.unikiel.rtsys.klodd.hierarchical.impl;

import java.util.ListIterator;

import edu.unikiel.rtsys.klodd.core.algorithms.AbstractAlgorithm;
import edu.unikiel.rtsys.klodd.core.util.LayoutGraphs;
import edu.unikiel.rtsys.klodd.hierarchical.modules.ICrossingReducer;
import edu.unikiel.rtsys.klodd.hierarchical.modules.ISingleLayerCrossingReducer;
import edu.unikiel.rtsys.klodd.hierarchical.structures.*;

/**
 * Implementation of a crossing reducer that performs a layer-by-layer
 * sweep with a 2-layer crossing reducer.
 * 
 * @author msp
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
	 * @see edu.unikiel.rtsys.klodd.hierarchical.modules.ICrossingReducer#reduceCrossings(edu.unikiel.rtsys.klodd.hierarchical.structures.LayeredGraph)
	 */
	public void reduceCrossings(LayeredGraph layeredGraph) {
		if (layeredGraph.areExternalPortsFixed()) {
			
		}
		else {
			// find arbitrary ranking of the first layer
			Layer firstLayer = layeredGraph.getLayers().get(0);
			firstLayer.calcElemRanks();
			
			// process the other layers normally
			ListIterator<Layer> layerIter = layeredGraph.getLayers().listIterator(1);
			while (layerIter.hasNext()) {
				layerReducer.reduceCrossings(layerIter.next(), true);
			}
			
			// reorder the first layer
			if (layeredGraph.getLayers().size() > 1) {
				layerReducer.reduceCrossings(firstLayer, false);
			}
			
			// TODO position external ports
		}
	}

}

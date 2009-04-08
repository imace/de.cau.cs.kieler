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

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import de.cau.cs.kieler.core.alg.AbstractAlgorithm;
import de.cau.cs.kieler.core.kgraph.KPort;
import de.cau.cs.kieler.core.kgraph.KPortType;
import de.cau.cs.kieler.kiml.layout.util.LayoutGraphUtil;
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
		int firstLayer = 0, lastLayer = layerCount - 1;
		getMonitor().begin("Crossing reduction", 2 * (layerCount - 1));
		
		if (layeredGraph.areExternalPortsFixed()) {
			// sort input and output ports by their relative position
			List<KPort> inputPorts = new LinkedList<KPort>();
			List<KPort> outputPorts = new LinkedList<KPort>();
			for (KPort port : layeredGraph.getParentNode().getPorts()) {
				if (port.getType() == KPortType.INPUT)
					inputPorts.add(port);
				else
					outputPorts.add(port);
			}
			
			// apply ports ordering to the layer ranking
			if (!inputPorts.isEmpty()) {
				KPort[] sortedInputPorts = LayoutGraphUtil.sortPortsByPosition(inputPorts,
						layeredGraph.getLayoutDirection(), false);
				int rank = 0;
				for (KPort port : sortedInputPorts) {
					LayerElement element = layeredGraph.getLayerElement(port);
					element.rank = rank;
					rank += element.getRankWidth();
				}
				layeredGraph.getLayers().get(firstLayer).sortConcrete();
				firstLayer += 2;
			}
			else {
				// find arbitrary ranking of the first layer
				layeredGraph.getLayers().get(0).calcElemRanks();
			}
			if (!outputPorts.isEmpty()) {
				KPort[] sortedOutputPorts = LayoutGraphUtil.sortPortsByPosition(outputPorts,
						layeredGraph.getLayoutDirection(), true);
				int rank = 0;
				for (KPort port : sortedOutputPorts) {
					LayerElement element = layeredGraph.getLayerElement(port);
					element.rank = rank;
					rank += element.getRankWidth();
				}
				layeredGraph.getLayers().get(lastLayer).sortConcrete();
				lastLayer -= 2;
			}
		}
		else {
			// find arbitrary ranking of the first layer
			layeredGraph.getLayers().get(0).calcElemRanks();
		}
		
		// process all but the port layers and the last layer
		ListIterator<Layer> layerIter = layeredGraph.getLayers().listIterator(1);
		while (layerIter.nextIndex() <= lastLayer) {
			layerReducer.reset(getMonitor().subTask(1));
			layerReducer.reduceCrossings(layerIter.next(), true);
		}
		
		if (lastLayer < layerCount - 1) {
			// order the last layer by the preceding layer and the output ports layer
			layerReducer.reset(getMonitor().subTask(1));
			layerReducer.reduceCrossings(layerIter.next());
		}
		else
			layerIter.previous();
		
		// process all but the port layers and the first layer again
		while (layerIter.previousIndex() >= firstLayer) {
			layerReducer.reset(getMonitor().subTask(1));
			layerReducer.reduceCrossings(layerIter.previous(), false);
		}
		
		if (firstLayer > 0) {
			// order the first layer by the subsequent layer and the input ports layer
			layerReducer.reset(getMonitor().subTask(1));
			layerReducer.reduceCrossings(layerIter.previous());
		}

		getMonitor().done();
	}

}

package de.cau.cs.kieler.klodd.hierarchical.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutPort;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KPortType;
import de.cau.cs.kieler.klodd.core.algorithms.AbstractAlgorithm;
import de.cau.cs.kieler.klodd.core.util.LayoutGraphs;
import de.cau.cs.kieler.klodd.hierarchical.modules.ICrossingReducer;
import de.cau.cs.kieler.klodd.hierarchical.modules.ISingleLayerCrossingReducer;
import de.cau.cs.kieler.klodd.hierarchical.structures.*;


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
	
	/*
	 * (non-Javadoc)
	 * @see de.cau.cs.kieler.klodd.core.algorithms.AbstractAlgorithm#reset()
	 */
	public void reset() {
		layerReducer.reset();
	}
	
	/* (non-Javadoc)
	 * @see de.cau.cs.kieler.klodd.hierarchical.modules.ICrossingReducer#reduceCrossings(de.cau.cs.kieler.klodd.hierarchical.structures.LayeredGraph)
	 */
	public void reduceCrossings(LayeredGraph layeredGraph) {
		if (layeredGraph.areExternalPortsFixed()) {
			// sort input and output ports by their relative position
			List<KLayoutPort> inputPorts = new LinkedList<KLayoutPort>();
			List<KLayoutPort> outputPorts = new LinkedList<KLayoutPort>();
			for (KLayoutPort port : layeredGraph.getParentGroup().getPorts()) {
				if (port.getType() == KPortType.INPUT)
					inputPorts.add(port);
				else
					outputPorts.add(port);
			}
			
			// apply ports ordering to the layer ranking
			int firstLayer = 0, lastLayer = layeredGraph.getLayers().size() - 1;
			if (!inputPorts.isEmpty()) {
				KLayoutPort[] sortedInputPorts = LayoutGraphs.sortPortsByPosition(inputPorts,
						layeredGraph.getLayoutDirection(), false);
				int rank = 0;
				for (KLayoutPort port : sortedInputPorts) {
					LayerElement element = layeredGraph.getLayerElement(port);
					element.rank = rank;
					rank += element.getRankWidth();
				}
				layeredGraph.getLayers().get(firstLayer).sortConcrete();
				firstLayer++;
			}
			else {
				// find arbitrary ranking of the first layer
				layeredGraph.getLayers().get(0).calcElemRanks();
			}
			if (!outputPorts.isEmpty()) {
				KLayoutPort[] sortedOutputPorts = LayoutGraphs.sortPortsByPosition(outputPorts,
						layeredGraph.getLayoutDirection(), true);
				int rank = 0;
				for (KLayoutPort port : sortedOutputPorts) {
					LayerElement element = layeredGraph.getLayerElement(port);
					element.rank = rank;
					rank += element.getRankWidth();
				}
				layeredGraph.getLayers().get(lastLayer).sortConcrete();
				lastLayer--;
			}
			
			// process all but the port layers and the last layer
			ListIterator<Layer> layerIter = layeredGraph.getLayers().listIterator(firstLayer);
			int layerIndex = firstLayer;
			while (layerIndex < lastLayer) {
				layerReducer.reduceCrossings(layerIter.next(), true);
				layerIndex++;
			}
			
			// order the last layer by the preceding layer and the output ports layer
			if (lastLayer < layeredGraph.getLayers().size() - 1) {
				layerReducer.reduceCrossings(layerIter.next());
			}
			else {
				layerReducer.reduceCrossings(layerIter.next(), true);
			}
		}
		
		else {
			// find arbitrary ranking of the first layer
			Layer firstLayer = layeredGraph.getLayers().get(0);
			firstLayer.calcElemRanks();
			
			// process the other layers in forward direction
			ListIterator<Layer> layerIter = layeredGraph.getLayers().listIterator(1);
			while (layerIter.hasNext()) {
				layerReducer.reduceCrossings(layerIter.next(), true);
			}
			
			// process all layers again in backwards direction
			layerIter.previous();
			while (layerIter.hasPrevious()) {
				layerReducer.reduceCrossings(layerIter.previous(), false);
			}
		}
	}

}

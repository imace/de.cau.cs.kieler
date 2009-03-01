package de.cau.cs.kieler.klodd.hierarchical.impl;

import java.util.ListIterator;

import de.cau.cs.kieler.core.alg.AbstractAlgorithm;
import de.cau.cs.kieler.core.graph.KGraph;
import de.cau.cs.kieler.core.graph.KNode;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutNode;
import de.cau.cs.kieler.klodd.hierarchical.modules.ILayerAssigner;
import de.cau.cs.kieler.klodd.hierarchical.structures.*;

/**
 * Layer assigner that balances the output of a basic layer assigner.
 * 
 * @author msp
 */
public class BalancingLayerAssigner extends AbstractAlgorithm implements
		ILayerAssigner {

	/** the basic layer assigner instance */
	private ILayerAssigner basicLayerAssigner;
	
	/**
	 * Creates a balancing layer assigner using a basic layer assigner.
	 * 
	 * @param basicLayerAssigner basic layer assigner
	 */
	public BalancingLayerAssigner(ILayerAssigner basicLayerAssigner) {
		this.basicLayerAssigner = basicLayerAssigner;
	}
	
	/* (non-Javadoc)
	 * @see de.cau.cs.kieler.klodd.hierarchical.modules.ILayerAssigner#assignLayers(de.cau.cs.kieler.core.graph.KGraph, de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutNode)
	 */
	public LayeredGraph assignLayers(KGraph graph, KLayoutNode parentNode) {
		getMonitor().begin("Balancing layer assignment", 1);
		basicLayerAssigner.reset(getMonitor().subTask(1));
		LayeredGraph layeredGraph = basicLayerAssigner.assignLayers(
				graph, parentNode);
		
		// balance layer assignment of each element in the layering
		if (layeredGraph.getLayers().size() >= 3) {
			ListIterator<Layer> layerIter = layeredGraph.getLayers().listIterator(2);
			while (layerIter.hasNext()) {
				Layer layer = layerIter.next();
				if (layer.height > 0) {
					ListIterator<LayerElement> elemIter = layer.getElements().listIterator();
					while (elemIter.hasNext()) {
						balanceElement(layeredGraph, elemIter);
					}
				}
			}
		}
		
		getMonitor().done();
		return layeredGraph;
	}
	
	/**
	 * Balances the given element by finding a possibly better layer
	 * above the element.
	 * 
	 * @param layeredGraph layered graph
	 * @param elemIter iterator whose next element shall be balanced
	 */
	private void balanceElement(LayeredGraph layeredGraph,
			ListIterator<LayerElement> elemIter) {
		LayerElement element = elemIter.next();
		Layer currentLayer = element.getLayer();
		KNode kNode = element.getKNode();
		int incoming = 0, outgoing = 0, minShiftRank = 0;
		for (KNode.IncEntry edgeEntry : kNode.incidence) {
			if (edgeEntry.type == KNode.IncEntry.Type.OUT)
				outgoing++;
			else {
				incoming++;
				int shiftRank = layeredGraph.getLayerElement(
						edgeEntry.endpoint().object).getLayer().rank + 1;
				minShiftRank = Math.max(minShiftRank, shiftRank);
			}
		}
		if (minShiftRank > 0 && incoming >= outgoing) {
			int layerOffset = layeredGraph.getLayers().get(0).rank;
			ListIterator<Layer> layerIter = layeredGraph.getLayers()
					.listIterator(minShiftRank - layerOffset);
			int currentSize = currentLayer.getElements().size();
			while (layerIter.nextIndex() < currentLayer.rank - layerOffset) {
				Layer layer = layerIter.next();
				if (layer.getElements().size() <= currentSize) {
					// move the current element to the new layer
					elemIter.remove();
					element.setLayer(layer);
					break;
				}
			}
		}
	}

}

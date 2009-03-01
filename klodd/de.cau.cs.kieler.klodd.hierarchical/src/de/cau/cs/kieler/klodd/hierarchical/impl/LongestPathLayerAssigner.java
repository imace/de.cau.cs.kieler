package de.cau.cs.kieler.klodd.hierarchical.impl;

import java.util.ListIterator;

import de.cau.cs.kieler.core.alg.AbstractAlgorithm;
import de.cau.cs.kieler.core.graph.KGraph;
import de.cau.cs.kieler.core.graph.KNode;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutNode;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutPort;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KPortType;
import de.cau.cs.kieler.klodd.hierarchical.modules.ILayerAssigner;
import de.cau.cs.kieler.klodd.hierarchical.structures.*;

/**
 * Layer assigner working with the longest path layering algorithm.
 * 
 * @author msp
 */
public class LongestPathLayerAssigner extends AbstractAlgorithm implements
		ILayerAssigner {
	
	/** the layered graph that is created by the layer assigner */
	private LayeredGraph layeredGraph = null;

	/* (non-Javadoc)
	 * @see de.cau.cs.kieler.klodd.core.algorithms.AbstractAlgorithm#reset()
	 */
	public void reset() {
		super.reset();
		layeredGraph = null;
	}

	/*
	 * (non-Javadoc)
	 * @see de.cau.cs.kieler.klodd.hierarchical.modules.ILayerAssigner#assignLayers(de.cau.cs.kieler.core.graph.KGraph, de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutNode)
	 */
	public LayeredGraph assignLayers(KGraph kGraph, KLayoutNode parentNode) {
		getMonitor().begin("Longest path layering", 1);
		layeredGraph = new LayeredGraph(parentNode);
		
		// process child nodes
		for (KNode node : kGraph.nodes) {
			visit(node);
		}
		
		// fill rank information for all layers
		ListIterator<Layer> layerIter = layeredGraph.getLayers().listIterator();
		Layer currentLayer = layerIter.next();
		int rank = currentLayer.rank;
		if (rank == Layer.UNDEF_RANK) {
			rank = 1;
			currentLayer.rank = rank;
		}
		while (layerIter.hasNext()) {
			Layer nextLayer = layerIter.next();
			nextLayer.rank = ++rank;
			currentLayer.next = nextLayer;
			currentLayer = nextLayer;
		}
		
		getMonitor().done();
		return layeredGraph;
	}
	
	/**
	 * Visit a node: if not already visited, find the longest path
	 * to a sink.
	 * 
	 * @param node node to visit
	 * @return height of the given node in the layered graph
	 */
	private int visit(KNode node) {
		LayerElement layerElement = layeredGraph.getLayerElement(node.object);
		if (layerElement != null) {
			// the node was already visited
			return layerElement.getLayer().height;
		}
		else if (node.object instanceof KLayoutPort) {
			KLayoutPort port = (KLayoutPort)node.object;
			if (port.getType() == KPortType.INPUT) {
				layeredGraph.putFront(port, 0, node);
				return Layer.UNDEF_HEIGHT;
			}
			else {
				layeredGraph.putBack(port, 0, node);
				return 0;
			}
		}
		else
		{
			int maxHeight = 1;
			for (KNode.IncEntry edgeEntry : node.incidence) {
				if (edgeEntry.type == KNode.IncEntry.Type.OUT) {
					KNode targetNode = edgeEntry.edge.target;
					// do not follow loops over a single node
					if (targetNode.id != node.id) {
						int height = visit(targetNode) + 1;
						maxHeight = Math.max(height, maxHeight);
					}
				}
			}
			layeredGraph.putBack(node.object, maxHeight, node);
			return maxHeight;
		}
	}

}

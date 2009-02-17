package de.cau.cs.kieler.klodd.hierarchical.impl;

import de.cau.cs.kieler.core.alg.AbstractAlgorithm;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutEdge;
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
		layeredGraph = null;
	}

	/* (non-Javadoc)
	 * @see de.cau.cs.kieler.klodd.hierarchical.modules.ILayerAssigner#assignLayers(de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutNode)
	 */
	public LayeredGraph assignLayers(KLayoutNode parentNode) {
		layeredGraph = new LayeredGraph(LayeredGraph.Type.BUILD_BACK, parentNode);
		
		// process output ports
		for (KLayoutPort port : parentNode.getPorts()) {
			if (port.getType() == KPortType.OUTPUT) {
				layeredGraph.putBack(port, 0);
			}
		}
		
		// process child nodes
		for (KLayoutNode node : parentNode.getChildNodes()) {
			visit(node);
		}
		
		// process input ports
		for (KLayoutPort port : parentNode.getPorts()) {
			if (port.getType() == KPortType.INPUT) {
				layeredGraph.putFront(port, 0);
			}
		}
		
		return layeredGraph;
	}
	
	/**
	 * Visit a node: if not already visited, find the longest path
	 * to a sink.
	 * 
	 * @param node node to visit
	 * @return height of the given node in the layered graph
	 */
	private int visit(KLayoutNode node) {
		LayerElement layerElement = layeredGraph.getLayerElement(node);
		if (layerElement != null) {
			// the node was already visited
			return layerElement.getLayer().height;
		}
		else
		{
			int maxHeight = 1;
			for (KLayoutEdge edge : node.getOutgoingEdges()) {
				KLayoutNode targetNode = edge.getTarget();
				// do not follow loops over a single node
				if (targetNode != null && targetNode != node) {
					int height = visit(targetNode) + 1;
					maxHeight = Math.max(height, maxHeight);
				}
			}
			layeredGraph.putBack(node, maxHeight);
			return maxHeight;
		}
	}

}

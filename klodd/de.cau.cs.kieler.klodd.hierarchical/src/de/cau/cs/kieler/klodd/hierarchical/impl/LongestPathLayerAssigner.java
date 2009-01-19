package de.cau.cs.kieler.klodd.hierarchical.impl;

import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KEdge;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KNodeGroup;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KPort;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.PORT_TYPE;
import de.cau.cs.kieler.klodd.core.algorithms.AbstractAlgorithm;
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
	 * @see de.cau.cs.kieler.klodd.hierarchical.modules.ILayerAssigner#assignLayers(de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KNodeGroup)
	 */
	public LayeredGraph assignLayers(KNodeGroup parentGroup) {
		layeredGraph = new LayeredGraph(LayeredGraph.Type.BUILD_BACK, parentGroup);
		
		// process output ports
		for (KPort port : parentGroup.getPorts()) {
			if (port.getType() == PORT_TYPE.OUTPUT) {
				layeredGraph.putBack(port, 0);
			}
		}
		
		// process child nodes
		for (KNodeGroup node : parentGroup.getSubNodeGroups()) {
			visit(node);
		}
		
		// process input ports
		for (KPort port : parentGroup.getPorts()) {
			if (port.getType() == PORT_TYPE.INPUT) {
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
	private int visit(KNodeGroup node) {
		LayerElement layerElement = layeredGraph.getLayerElement(node);
		if (layerElement != null) {
			// the node was already visited
			return layerElement.getLayer().height;
		}
		else
		{
			int maxHeight = 1;
			for (KEdge edge : node.getOutgoingEdges()) {
				KNodeGroup targetNode = edge.getTarget();
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

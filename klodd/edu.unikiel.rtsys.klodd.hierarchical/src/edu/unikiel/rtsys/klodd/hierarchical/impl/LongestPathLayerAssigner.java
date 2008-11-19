package edu.unikiel.rtsys.klodd.hierarchical.impl;

import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KEdge;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KNodeGroup;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KPort;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.PORT_TYPE;
import edu.unikiel.rtsys.klodd.core.algorithms.AbstractAlgorithm;
import edu.unikiel.rtsys.klodd.hierarchical.modules.ILayerAssigner;
import edu.unikiel.rtsys.klodd.hierarchical.structures.*;

/**
 * Layer assigner working with the longest path layering algorithm.
 * 
 * @author msp
 */
public class LongestPathLayerAssigner extends AbstractAlgorithm implements
		ILayerAssigner {
	
	// the layered graph that is created by the layer assigner
	private LayeredGraph layeredGraph = null;

	/* (non-Javadoc)
	 * @see edu.unikiel.rtsys.klodd.core.algorithms.AbstractAlgorithm#reset()
	 */
	public void reset() {
		layeredGraph = null;
	}

	/* (non-Javadoc)
	 * @see edu.unikiel.rtsys.klodd.hierarchical.modules.ILayerAssigner#assignLayers(edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KNodeGroup)
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
		Layer layer = layeredGraph.getLayer(node);
		if (layer != null) {
			// the node was already visited
			return layer.height;
		}
		else
		{
			int maxHeight = 1;
			for (KEdge edge : node.getOutgoingEdges()) {
				KNodeGroup targetNode = edge.getTarget();
				if (targetNode != null) {
					int height = visit(targetNode) + 1;
					maxHeight = Math.max(height, maxHeight);
				}
			}
			layeredGraph.putBack(node, maxHeight);
			return maxHeight;
		}
	}

}

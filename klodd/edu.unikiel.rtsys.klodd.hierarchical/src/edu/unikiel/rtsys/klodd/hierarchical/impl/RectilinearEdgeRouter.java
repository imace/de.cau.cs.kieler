package edu.unikiel.rtsys.klodd.hierarchical.impl;

import java.util.HashMap;
import java.util.ListIterator;
import java.util.Map;

import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KPort;
import edu.unikiel.rtsys.klodd.core.algorithms.AbstractAlgorithm;
import edu.unikiel.rtsys.klodd.hierarchical.modules.IEdgeRouter;
import edu.unikiel.rtsys.klodd.hierarchical.structures.Layer;
import edu.unikiel.rtsys.klodd.hierarchical.structures.LayerConnection;
import edu.unikiel.rtsys.klodd.hierarchical.structures.LayerElement;
import edu.unikiel.rtsys.klodd.hierarchical.structures.LayeredGraph;

/**
 * Edge routing algorithm that makes rectilinear edges.
 * 
 * @author msp
 */
public class RectilinearEdgeRouter extends AbstractAlgorithm implements
		IEdgeRouter {
	
	/**
	 * This inner type is used to define the starting and ending position
	 * of a lengthwise routing slot. 
	 */
	private class RoutingSlot {
		int rank, start, end;
	}

	/** lengthwise routing position for incoming connections of each port */
	private Map<KPort, RoutingSlot> incomingSlotMap = new HashMap<KPort, RoutingSlot>();
	/** lengthwise routing position for outgoing connections of each port */
	private Map<KPort, RoutingSlot> outgoingSlotMap = new HashMap<KPort, RoutingSlot>();
	
	/*
	 * (non-Javadoc)
	 * @see edu.unikiel.rtsys.klodd.core.algorithms.AbstractAlgorithm#reset()
	 */
	public void reset() {
		incomingSlotMap.clear();
		outgoingSlotMap.clear();
	}
	
	/* (non-Javadoc)
	 * @see edu.unikiel.rtsys.klodd.hierarchical.modules.IEdgeRouter#routeEdges(edu.unikiel.rtsys.klodd.hierarchical.structures.LayeredGraph, float)
	 */
	public void routeEdges(LayeredGraph layeredGraph, float minDist) {
		ListIterator<Layer> layerIter = layeredGraph.getLayers().listIterator();
		while (layerIter.hasNext()) {
			Layer layer = layerIter.next();
			if (layer.rank == 0) {
				// process connections from the input ports
			}
			else if (layer.height == 1) {
				if (layerIter.hasNext()) {
					// process connections to the output ports
				}
			}
			else {
				// process connections between normal layer elements
				for (LayerElement element : layer.getElements()) {
					for (LayerConnection connection : element.getOutgoingConnections()) {
						
					}
				}
			}
		}
	}
	
	private void calcRoutingSlots(Layer layer) {
		
	}
	

}

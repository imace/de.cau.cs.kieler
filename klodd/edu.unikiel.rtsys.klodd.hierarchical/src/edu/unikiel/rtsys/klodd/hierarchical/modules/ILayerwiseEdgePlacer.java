package edu.unikiel.rtsys.klodd.hierarchical.modules;

import java.util.Map;

import edu.unikiel.rtsys.klodd.core.algorithms.IAlgorithm;
import edu.unikiel.rtsys.klodd.hierarchical.structures.Layer;
import edu.unikiel.rtsys.klodd.hierarchical.structures.RoutingSlot;

/**
 * Interface for algorithms that calculate routing slots for connections
 * going from a layer to the subsequent one.
 * 
 * @author msp
 */
public interface ILayerwiseEdgePlacer extends IAlgorithm {

	/**
	 * Determines a placement for each outgoing edge of the given layer.
	 * 
	 * @param layer layer to process
	 * @param minDist minimal distance between elements
	 * @return number of assigned slot ranks
	 */
	public int placeEdges(Layer layer, float minDist);
	
	/**
	 * Returns the map of layer elements to their corresponding routing
	 * slots that was constructed during the last run of <code>placeEdges</code>.
	 * 
	 * @return the slot map
	 */
	public Map<Object, RoutingSlot> getSlotMap();
	
}

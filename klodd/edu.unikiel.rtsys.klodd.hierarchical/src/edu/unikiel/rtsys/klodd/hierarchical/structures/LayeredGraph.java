package edu.unikiel.rtsys.klodd.hierarchical.structures;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KNodeGroup;
import edu.unikiel.rtsys.klodd.core.util.FixedArrayList;

/**
 * This structure manages the layering of an acyclic directed graph.
 * 
 * @author msp
 */
public class LayeredGraph {
	
	/**
	 * Types of layered graphs.
	 */
	public enum Type
	{
		/** the layered graph is built up from the front */
		BUILD_FRONT,
		/** the layered graph is built up from the back */
		BUILD_BACK
	}
	
	// list of layers in this layered graph
	private List<Layer> layers;
	// map of objects to their corresponding layer
	private Map<Object, Layer> obj2LayerMap = new HashMap<Object, Layer>();
	
	/**
	 * Creates a new layered graph. Choosing the right type can be important
	 * for efficiency; BUILD_FRONT should be chosen if putFront is used to
	 * put normal nodes, and BUILD_BACK should be chosen if putBack is used
	 * to put normal nodes.
	 * 
	 * @param type type of layered graph building: from front or from back
	 * @param parentGroup parent node group
	 */
	public LayeredGraph(Type type, KNodeGroup parentGroup)
	{
		layers = new FixedArrayList<Layer>(parentGroup.getSubNodeGroups().size() + 2,
				type == Type.BUILD_FRONT ? FixedArrayList.Type.ALIGN_FRONT
						: FixedArrayList.Type.ALIGN_BACK);
	}
	
	/**
	 * Put the given object into a layer with specified rank. The search
	 * for the right layer begins at the front of the internal list.
	 * 
	 * @param obj object to put
	 * @param rank rank of the object
	 */
	public void putFront(Object obj, int rank)
	{
		for (int i = 0; i < layers.size(); i++)
		{
			int currentRank = layers.get(i).rank;
			if (currentRank < 0 || currentRank > rank)
			{
				// insert a new layer into the list
				Layer newLayer = new Layer(rank, Layer.UNDEF_HEIGHT);
				doPut(obj, newLayer);
				layers.add(i, newLayer);
				return;
			}
			else if (currentRank == rank)
			{
				// the right layer was found
				doPut(obj, layers.get(i));
				return;
			}
		}
		
		// add a new layer at the end of the list
		Layer newLayer = new Layer(rank, Layer.UNDEF_HEIGHT);
		doPut(obj, newLayer);
		layers.add(newLayer);
	}

	/**
	 * Put the given object into a layer with specified height. The search
	 * for the right layer begins at the back of the internal list.
	 * 
	 * @param obj object to put
	 * @param height height of the object
	 */
	public void putBack(Object obj, int height)
	{
		for (int i = layers.size() - 1; i >= 0; i--)
		{
			int currentHeight = layers.get(i).height;
			if (currentHeight < 0 || currentHeight > height)
			{
				// insert a new layer into the list
				Layer newLayer = new Layer(Layer.UNDEF_RANK, height);
				doPut(obj, newLayer);
				layers.add(i, newLayer);
				return;
			}
			else if (currentHeight == height)
			{
				// the right layer was found
				doPut(obj, layers.get(i));
				return;
			}
		}
		
		// add a new layer at the start of the list
		Layer newLayer = new Layer(Layer.UNDEF_RANK, height);
		doPut(obj, newLayer);
		layers.add(0, newLayer);
	}
	
	/**
	 * Gets the layer that holds the given object.
	 * 
	 * @param obj the object
	 * @return the corresponding layer
	 */
	public Layer getLayer(Object obj)
	{
		return obj2LayerMap.get(obj);
	}
	
	/**
	 * Fills rank and height information for all layers and creates
	 * long edges. This method should be called after all nodes and ports
	 * have been put into the layered graph.
	 */
	public void createLongEdges()
	{
		// fill rank and height information
		int layerCount = layers.size();
		for (int i = 0; i < layerCount; i++)
		{
			Layer layer = layers.get(i);
			layer.rank = i;
			layer.height = layerCount - 1 - i;
		}
		
		// create long edges
	}
	
	/**
	 * Puts an object into a given layer.
	 * 
	 * @param obj object to put
	 * @param layer the layer
	 */
	private void doPut(Object obj, Layer layer)
	{
		layer.put(obj);
		obj2LayerMap.put(obj, layer);
	}
	
}

package edu.unikiel.rtsys.klodd.hierarchical.structures;

import java.util.List;
import java.util.LinkedList;

/**
 * A single Layer used in a layered graph.
 * 
 * @author msp
 */
public class Layer {
	
	/** value to use if the rank is undefined */
	public static final int UNDEF_RANK = -1;
	/** value to use if the height is undefined */
	public static final int UNDEF_HEIGHT = -1;

	/** the rank of this layer */
	public int rank;
	/** the height of this layer */
	public int height;
	
	// list of elements in this layer
	private List<LayerElement> elements = new LinkedList<LayerElement>(); 
	
	/**
	 * Creates a new layer with given rank and height.
	 * 
	 * @param rank the rank, may be UNDEF_RANK
	 * @param height the height, may be UNDEF_HEIGHT
	 */
	public Layer(int rank, int height) {
		this.rank = rank;
		this.height = height;
	}
	
	/**
	 * Puts an object into this layer.
	 * 
	 * @param obj the element object
	 * @return the new layer element
	 */
	public LayerElement put(Object obj) {
		LayerElement element = new LayerElement(obj, this);
		elements.add(element);
		return element;
	}
	
	/**
	 * Gets the elements of this layer.
	 * 
	 * @return the layer elements
	 */
	public List<LayerElement> getElements() {
		return elements;
	}
	
}

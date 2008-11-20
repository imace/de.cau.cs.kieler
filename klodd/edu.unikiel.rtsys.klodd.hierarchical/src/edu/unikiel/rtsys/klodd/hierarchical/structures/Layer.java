package edu.unikiel.rtsys.klodd.hierarchical.structures;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.LinkedList;
import java.util.Map;

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
	
	/** the containing layered graph */
	private LayeredGraph layeredGraph;
	/** list of elements in this layer */
	private List<LayerElement> elements = new LinkedList<LayerElement>(); 
	
	/**
	 * Creates a new layer with given rank and height.
	 * 
	 * @param rank the rank, may be UNDEF_RANK
	 * @param height the height, may be UNDEF_HEIGHT
	 */
	public Layer(int rank, int height, LayeredGraph layeredGraph) {
		this.rank = rank;
		this.height = height;
		this.layeredGraph = layeredGraph;
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
	
	/**
	 * Gets the layered graph.
	 * 
	 * @return the layeredGraph
	 */
	public LayeredGraph getLayeredGraph() {
		return layeredGraph;
	}
	
	/**
	 * Sorts the elements in this layer and assigns them new rank values.
	 * 
	 * @param abstractRanks map of abstract ranks used as base for sorting
	 */
	public void sort(final Map<LayerElement, Double> abstractRanks) {
		Collections.sort(elements, new Comparator<LayerElement>() {
			public int compare(LayerElement elem1, LayerElement elem2) {
				return abstractRanks.get(elem1).compareTo(abstractRanks.get(elem2));
			}
		});
		
		calcElemRanks();
	}
	
	/**
	 * Calculates the element rank of each element in this layer. The rank
	 * is mainly influenced by the order of elements in the internal list.
	 */
	private void calcElemRanks() {
		int rank = 0;
		for (LayerElement element : elements) {
			element.rank = rank;
			rank += element.getRankWidth();
		}
	}
	
}

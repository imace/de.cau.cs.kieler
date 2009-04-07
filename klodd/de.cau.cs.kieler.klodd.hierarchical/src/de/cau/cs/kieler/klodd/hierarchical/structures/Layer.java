/******************************************************************************
 * KIELER - Kiel Integrated Environment for Layout for the Eclipse RCP
 *
 * http://www.informatik.uni-kiel.de/rtsys/kieler/
 * 
 * Copyright 2008 by
 * + Christian-Albrechts-University of Kiel
 *   + Department of Computer Science
 *     + Real-Time and Embedded Systems Group
 * 
 * This code is provided under the terms of the Eclipse Public License (EPL).
 * See the file epl-v10.html for the license text.
 */
package de.cau.cs.kieler.klodd.hierarchical.structures;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.LinkedList;
import java.util.Map;

import de.cau.cs.kieler.core.kgraph.KGraphElement;
import de.cau.cs.kieler.core.slimgraph.KSlimNode;
import de.cau.cs.kieler.kiml.layout.options.LayoutDirection;


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
	/** lengthwise position of this layer */
	public float lengthwisePos = 0.0f;
	/** crosswise dimension of this layer */
	public float crosswiseDim = 0.0f;
	/** lengthwise dimension of this layer */
	public float lengthwiseDim = 0.0f;
	/** next layer in the layered graph */
	public Layer next;
	
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
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return elements.toString();
	}
	
	/**
	 * Puts an object into this layer.
	 * 
	 * @param obj the element object
	 * @param kNode the corresponding node in the acyclic KIELER graph
	 * @return the new layer element
	 */
	public LayerElement put(KGraphElement obj, KSlimNode kNode) {
		LayerElement element = new LayerElement(obj, this, kNode);
		elements.add(element);
		return element;
	}
	
	/**
	 * Sets the lengthwise position of this layer and all layer elements.
	 * 
	 * @param layerPos starting lengthwise position of this layer
	 * @param minDist minimal distance between nodes and connections
	 */
	public void layoutElements(float layerPos, float minDist) {
		LayoutDirection layoutDirection = layeredGraph.getLayoutDirection();
		float backPadding = 0.0f;
		float frontPadding = 0.0f;
		
		// determine padding values
		for (LayerElement element : elements) {
			float sideSpace = (lengthwiseDim - (layoutDirection == LayoutDirection.VERTICAL
					? element.getRealHeight() : element.getRealWidth())) / 2;
			backPadding = Math.max(backPadding,
					element.getEdgesBack() * minDist - sideSpace);
			frontPadding = Math.max(frontPadding,
					element.getEdgesFront() * minDist - sideSpace);
		}
		lengthwisePos = layerPos + frontPadding;
		
		// set the lengthwise position of each node
		for (LayerElement element : elements) {
			if (rank > 0 && height > 0) {
				if (layoutDirection == LayoutDirection.VERTICAL) {
					float sideSpace = (lengthwiseDim - element.getRealHeight()) / 2;
					element.getPosition().setY(lengthwisePos + sideSpace);
				}
				else {
					float sideSpace = (lengthwiseDim - element.getRealWidth()) / 2;
					element.getPosition().setX(lengthwisePos + sideSpace);
				}
			}
		}
		
		lengthwiseDim += backPadding;
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
	 * Sorts the elements in this layer and assigns them new rank values
	 * based on a map of abstract ranks.
	 * 
	 * @param abstractRanks map of abstract ranks used as base for sorting
	 */
	public void sortAbstract(final Map<LayerElement, Double> abstractRanks) {
		Collections.sort(elements, new Comparator<LayerElement>() {
			public int compare(LayerElement elem1, LayerElement elem2) {
				return abstractRanks.get(elem1).compareTo(abstractRanks.get(elem2));
			}
		});
		
		// calculate concrete rank values
		calcElemRanks();
	}

	/**
	 * Sorts the elements in this layer by concrete rank values that are
	 * already assigned to each element.
	 */
	public void sortConcrete() {
		Collections.sort(elements, new Comparator<LayerElement>() {
			public int compare(LayerElement elem1, LayerElement elem2) {
				return elem1.rank == elem2.rank ? 0
						: (elem1.rank > elem2.rank ? 1
						: -1);
			}
		});
	}
	
	/**
	 * Calculates the element rank of each element in this layer. The rank
	 * is induced by the order of elements in the internal list and the
	 * rank width of each element.
	 */
	public void calcElemRanks() {
		int rank = 0;
		for (LayerElement element : elements) {
			element.rank = rank;
			rank += element.getRankWidth();
		}
	}
	
}

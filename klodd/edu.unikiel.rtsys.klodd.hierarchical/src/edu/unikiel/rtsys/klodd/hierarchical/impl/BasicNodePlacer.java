package edu.unikiel.rtsys.klodd.hierarchical.impl;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KDimension;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KPoint;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.LAYOUT_OPTION;
import edu.unikiel.rtsys.klodd.core.algorithms.AbstractAlgorithm;
import edu.unikiel.rtsys.klodd.hierarchical.modules.INodePlacer;
import edu.unikiel.rtsys.klodd.hierarchical.structures.Layer;
import edu.unikiel.rtsys.klodd.hierarchical.structures.LayerElement;
import edu.unikiel.rtsys.klodd.hierarchical.structures.LayeredGraph;
import edu.unikiel.rtsys.klodd.hierarchical.structures.LinearSegment;

/**
 * Node placing algorithm that orders all linear segments and creates an
 * unbalanced placement
 * 
 * @author msp
 */
public class BasicNodePlacer extends AbstractAlgorithm implements INodePlacer {

	/** minimal distance between two nodes or edges in each layer */
	private float minDist;
	/** layout direction for this algorithm instance */
	private LAYOUT_OPTION layoutDirection;
	/** array of sorted segments */
	private LinearSegment[] sortedSegments = null;
	
	/*
	 * (non-Javadoc)
	 * @see edu.unikiel.rtsys.klodd.core.algorithms.AbstractAlgorithm#reset()
	 */
	public void reset() {
		sortedSegments = null;
	}
	
	/*
	 * (non-Javadoc)
	 * @see edu.unikiel.rtsys.klodd.hierarchical.modules.INodePlacer#placeNodes(edu.unikiel.rtsys.klodd.hierarchical.structures.LayeredGraph, float)
	 */
	public void placeNodes(LayeredGraph layeredGraph, float minDist) {
		this.minDist = minDist;
		this.layoutDirection = layeredGraph.getLayoutDirection();
		
		// sort the linear segments of the layered graph
		sortedSegments = sortLinearSegments(layeredGraph);
		// create an unbalanced placement from the sorted segments
		createUnbalancedPlacement(sortedSegments);
		
		// process fixed external ports
		if (layeredGraph.areExternalPortsFixed()) {
			Layer layer = layeredGraph.getLayers().get(0);
			if (layer.rank == 0) {
				for (LayerElement element : layer.getElements()) {
					element.takePortPos();
					KPoint position = element.getPosition();
					KDimension size = element.getRealDim();
					if (layoutDirection == LAYOUT_OPTION.VERTICAL) {
						layer.crosswiseDim = Math.max(layer.crosswiseDim,
								position.getX() + size.getWidth());
						layer.lengthwiseDim = Math.max(layer.lengthwiseDim,
								size.getHeight());
						layeredGraph.lengthwiseDim = Math.max(layeredGraph.lengthwiseDim,
								position.getY());
					}
					else {
						layer.crosswiseDim = Math.max(layer.crosswiseDim,
								position.getY() + size.getHeight());
						layer.lengthwiseDim = Math.max(layer.lengthwiseDim,
								size.getWidth());
						layeredGraph.lengthwiseDim = Math.max(layeredGraph.lengthwiseDim,
								position.getX());
					}
				}
			}
		}
		
		// set the proper crosswise dimension for the whole graph
		for (Layer layer : layeredGraph.getLayers()) {
			layer.crosswiseDim += minDist;
			layeredGraph.crosswiseDim = Math.max(layeredGraph.crosswiseDim,
					layer.crosswiseDim); 
		}
	}
	
	/**
	 * Gets the array of movable linear segments. This excludes the external
	 * ports if their position is to be held fixed.
	 * 
	 * @return movable linear segments
	 */
	public LinearSegment[] getMovableSegments() {
		return sortedSegments;
	}
	
	/**
	 * Sorts the linear segments of the given layered graph by finding
	 * a topological ordering in the corresponding segment ordering graph.
	 * 
	 * @param layeredGraph layered graph to process
	 * @return a sorted array of linear segments
	 */
	@SuppressWarnings("unchecked")
	private LinearSegment[] sortLinearSegments(LayeredGraph layeredGraph) {
		// create and initialize segment ordering graph
		LinearSegment[] linearSegments;
		if (layeredGraph.areExternalPortsFixed()) {
			List<LinearSegment> filteredSegments = new LinkedList<LinearSegment>();
			for (LinearSegment segment : layeredGraph.getLinearSegments()) {
				if (segment.elements.size() == 1) {
					Layer layer = segment.elements.get(0).getLayer();
					if (layer.rank != 0 && layer.height != 0)
						filteredSegments.add(segment);
				}
				else
					filteredSegments.add(segment);
			}
			linearSegments = filteredSegments.toArray(new LinearSegment[0]);
		}
		else
			linearSegments = layeredGraph.getLinearSegments().toArray(new LinearSegment[0]);
		List<LinearSegment>[] outgoing = new List[linearSegments.length];
		int[] incomingCount = new int[linearSegments.length];
		int[] newRanks = new int[linearSegments.length];
		for (int i = 0; i < linearSegments.length; i++) {
			linearSegments[i].rank = i;
			outgoing[i] = new LinkedList<LinearSegment>();
			incomingCount[i] = 0;
		}
		
		// create edges in the segment ordering graph
		for (Layer layer : layeredGraph.getLayers()) {
			Iterator<LayerElement> elemIter = layer.getElements().iterator();
			LayerElement elem1 = elemIter.next();
			while (elemIter.hasNext()) {
				LayerElement elem2 = elemIter.next();
				outgoing[elem1.linearSegment.rank].add(elem2.linearSegment);
				incomingCount[elem2.linearSegment.rank]++;
				elem1 = elem2;
			}
		}
		
		// find a topological ordering of the segment ordering graph
		int nextRank = 0;
		List<LinearSegment> noIncoming = new LinkedList<LinearSegment>();
		for (int i = 0; i < linearSegments.length; i++) {
			if (incomingCount[i] == 0)
				noIncoming.add(linearSegments[i]);
		}
		while (!noIncoming.isEmpty()) {
			LinearSegment segment = noIncoming.remove(0);
			newRanks[segment.rank] = nextRank++;
			while (!outgoing[segment.rank].isEmpty()) {
				LinearSegment target = outgoing[segment.rank].remove(0);
				incomingCount[target.rank]--;
				if (incomingCount[target.rank] == 0)
					noIncoming.add(target);
			}
		}
		
		// apply the new ordering to the array of linear segments
		for (int i = 0; i < linearSegments.length; i++) {
			linearSegments[i].rank = newRanks[i];
		}
		Arrays.sort(linearSegments);
		return linearSegments;
	}
	
	/**
	 * Creates an unbalanced placement for the input graph.
	 * 
	 * @param sortedSegments array of sorted linear segments
	 */
	private void createUnbalancedPlacement(LinearSegment[] sortedSegments) {
		for (LinearSegment segment : sortedSegments) {
			// determine the leftmost / uppermost placement for the linear segment
			float leftmostPlace = 0.0f;
			for (LayerElement element : segment.elements) {
				leftmostPlace = Math.max(leftmostPlace,
						element.getLayer().crosswiseDim);
			}
			// apply the leftmost / uppermost placement to all elements
			float newPos = leftmostPlace + minDist;
			for (LayerElement element : segment.elements) {
				Layer layer = element.getLayer();
				KDimension elemDim = element.getRealDim();
				element.setCrosswisePos(newPos, minDist);
				float totalCrosswiseDim = element.getTotalCrosswiseDim(minDist);
				if (layoutDirection == LAYOUT_OPTION.VERTICAL) {
					layer.crosswiseDim = newPos + totalCrosswiseDim;
					layer.lengthwiseDim = Math.max(layer.lengthwiseDim, elemDim.getHeight());
				}
				else {
					layer.crosswiseDim = newPos + totalCrosswiseDim;
					layer.lengthwiseDim = Math.max(layer.lengthwiseDim, elemDim.getWidth());
				}
			}
		}
	}

}

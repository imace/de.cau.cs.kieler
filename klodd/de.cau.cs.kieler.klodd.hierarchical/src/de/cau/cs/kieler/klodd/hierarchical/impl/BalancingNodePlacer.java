package de.cau.cs.kieler.klodd.hierarchical.impl;

import java.util.ListIterator;

import de.cau.cs.kieler.core.alg.AbstractAlgorithm;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KPoint;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutOption;
import de.cau.cs.kieler.klodd.hierarchical.modules.INodePlacer;
import de.cau.cs.kieler.klodd.hierarchical.structures.Layer;
import de.cau.cs.kieler.klodd.hierarchical.structures.LayerConnection;
import de.cau.cs.kieler.klodd.hierarchical.structures.LayerElement;
import de.cau.cs.kieler.klodd.hierarchical.structures.LayeredGraph;
import de.cau.cs.kieler.klodd.hierarchical.structures.LinearSegment;


/**
 * Node placing algorithm that improves the overall balance of the graph
 * after executing a basic node placer.
 * 
 * @author msp
 */
public class BalancingNodePlacer extends AbstractAlgorithm implements
		INodePlacer {

	/** basic node placer that is executed before this algorithm begins */
	private BasicNodePlacer basicNodePlacer;
	/** minimal distance between two nodes or edges in each layer */
	private float minDist;
	/** maximal crosswise dimension of the layered graph */
	private float maxWidth;
	/** layout direction for this algorithm instance */
	private KLayoutOption layoutDirection;
	/** array of move requests for the linear segments */
	float[] moveRequests;
	
	/**
	 * Creates a balancing node placer using a basic node placer. The
	 * basic node placer is expected to create a layout where all layer
	 * elements are aligned to the top for horizontal layout or to the
	 * left for vertical layout.
	 * 
	 * @param basicNodePlacer node placing algorithm that creates an
	 *     initial unbalanced placement for each node
	 */
	public BalancingNodePlacer(BasicNodePlacer basicNodePlacer) {
		this.basicNodePlacer = basicNodePlacer;
	}
	
	/* (non-Javadoc)
	 * @see de.cau.cs.kieler.klodd.hierarchical.modules.INodePlacer#placeNodes(de.cau.cs.kieler.klodd.hierarchical.structures.LayeredGraph, float)
	 */
	public void placeNodes(LayeredGraph layeredGraph, float minDist) {
		getMonitor().begin("Balancing node placement", 2);
		
		this.minDist = minDist;
		this.layoutDirection = layeredGraph.getLayoutDirection();
		// apply the basic node placement
		basicNodePlacer.reset(getMonitor().subTask(1));
		basicNodePlacer.placeNodes(layeredGraph, minDist);
		int movableCount = basicNodePlacer.getMovableSegments().length;
		
		// create array of move requests
		moveRequests = new float[movableCount];
		for (int i = 0; i < movableCount; i++)
			moveRequests[i] = Float.NaN;
		// find the layer with the greatest crosswise dimension
		maxWidth = 0.0f;
		int referenceRank = 0;
		Layer referenceLayer = null;
		for (Layer layer : layeredGraph.getLayers()) {
			if (isMovable(layer) && layer.crosswiseDim > maxWidth) {
				maxWidth = layer.crosswiseDim;
				referenceRank = layer.rank;
				referenceLayer = layer;
			}
		}
		// initialize move requests for the reference layer
		for (LayerElement element : referenceLayer.getElements()) {
			moveRequests[element.linearSegment.rank] = 0.0f;
		}
		ListIterator<Layer> layerIter = layeredGraph.getLayers().listIterator();
		Layer layer;
		while (layerIter.hasNext() && layerIter.next().rank < referenceRank);
		
		// create move requests below the reference layer
		while (layerIter.hasNext()) {
			layer = layerIter.next();
			if (isMovable(layer)) {
				createRequests(layer, true);
				validateRequests(layer);
			}
		}
		
		// revalidate all requests below the reference layer
		while (layerIter.hasPrevious()
				&& (layer = layerIter.previous()).rank > referenceRank) {
			if (isMovable(layer))
				validateRequests(layer);
		}
		
		// create move requests above the reference layer
		while (layerIter.hasPrevious()) {
			layer = layerIter.previous();
			if (isMovable(layer)) {
				createRequests(layer, false);
				validateRequests(layer);
			}
		}
		
		// revalidate all requests above the reference layer
		while (layerIter.hasNext()
				&& (layer = layerIter.next()).rank < referenceRank) {
			if (isMovable(layer))
				validateRequests(layer);
		}

		// apply all move requests
		for (LinearSegment linearSegment : basicNodePlacer.getMovableSegments()) {
			float moveDelta = moveRequests[linearSegment.rank];
			if (moveDelta != Float.NaN) {
				for (LayerElement element : linearSegment.elements) {
					KPoint pos = element.getPosition();
					if (layoutDirection == KLayoutOption.VERTICAL) {
						pos.setX(pos.getX() + moveDelta);
					}
					else {
						pos.setY(pos.getY() + moveDelta);
					}
				}
			}
		}
		
		getMonitor().done();
	}
	
	/**
	 * Creates move requests for the elements of a given layer.
	 * 
	 * @param layer layer to process
	 * @param forward if true, incoming connections are considered, else
	 *     outgoing connections are considered
	 */
	private void createRequests(Layer layer, boolean forward) {
		float lastRequest = 0.0f;
		for (LayerElement element : layer.getElements()) {
			if (Float.isNaN(moveRequests[element.linearSegment.rank])) {
				// calculate preferred centered position as barycenter
				float sum = 0.0f;
				int edgeCount = 0;
				for (LayerConnection connection :
					(forward ? element.getIncomingConnections() : element.getOutgoingConnections())) {
					sum += calcPosDelta(connection, forward);
					edgeCount++;
				}
				if (edgeCount == 0) {
					moveRequests[element.linearSegment.rank] = lastRequest;
				}
				else {
					float moveRequest = sum / edgeCount;
					moveRequests[element.linearSegment.rank] = moveRequest;
					lastRequest = moveRequest;
				}
			}
		}
	}
	
	/**
	 * Validate the requests of a layer.
	 * 
	 * @param layer layer to process
	 */
	private void validateRequests(Layer layer) {
		ListIterator<LayerElement> elemIter = layer.getElements().listIterator(
				layer.getElements().size());
		float maxMove = maxWidth - layer.crosswiseDim;
		while (elemIter.hasPrevious()) {
			LayerElement element = elemIter.previous();
			float elemRequest = moveRequests[element.linearSegment.rank];
			elemRequest = Math.max(elemRequest, 0.0f);
			maxMove = Math.min(elemRequest, maxMove);
			moveRequests[element.linearSegment.rank] = maxMove;
		}
	}
	
	/**
	 * Determines the difference between the endpoint positions of the
	 * source and target of a connection.
	 * 
	 * @param connection connection to process
	 * @param forward if true the source position is taken positively,
	 *     else negatively
	 * @return position difference
	 */
	private float calcPosDelta(LayerConnection connection, boolean forward) {
		float sourcePos = connection.calcSourcePos(minDist);
		float targetPos = connection.calcTargetPos(minDist);
		
		// determine position delta, considering previous move requests
		if (forward) {
			float sourceRequest = moveRequests[connection.getSourceElement()
			                                   .linearSegment.rank];
			if (Float.isNaN(sourceRequest))
				return sourcePos - targetPos;
			else
				return sourcePos + sourceRequest - targetPos;
		}
		else {
			float targetRequest = moveRequests[connection.getTargetElement()
			                                   .linearSegment.rank];
			if (Float.isNaN(targetRequest))
				return targetPos - sourcePos;
			else
				return targetPos + targetRequest - sourcePos;
		}
	}
	
	/**
	 * Returns whether a given layer is movable or fixed
	 * 
	 * @param layer
	 * @return
	 */
	private boolean isMovable(Layer layer) {
		return !(layer.getLayeredGraph().areExternalPortsFixed()
			&& (layer.rank == 0 || layer.height == 0));
	}

}

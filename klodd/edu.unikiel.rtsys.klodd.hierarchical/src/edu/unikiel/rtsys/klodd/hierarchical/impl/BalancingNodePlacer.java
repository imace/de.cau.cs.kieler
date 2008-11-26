package edu.unikiel.rtsys.klodd.hierarchical.impl;

import java.util.ListIterator;

import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KPoint;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KPort;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KPortLayout;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.LAYOUT_OPTION;
import edu.unikiel.rtsys.klodd.core.algorithms.AbstractAlgorithm;
import edu.unikiel.rtsys.klodd.hierarchical.modules.INodePlacer;
import edu.unikiel.rtsys.klodd.hierarchical.structures.Layer;
import edu.unikiel.rtsys.klodd.hierarchical.structures.LayerConnection;
import edu.unikiel.rtsys.klodd.hierarchical.structures.LayerElement;
import edu.unikiel.rtsys.klodd.hierarchical.structures.LayeredGraph;
import edu.unikiel.rtsys.klodd.hierarchical.structures.LinearSegment;

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
	/** the layered graph that is currenlty processed */
	private LayeredGraph layeredGraph;
	/** layout direction for this algorithm instance */
	private LAYOUT_OPTION layoutDirection;
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
	
	/*
	 * (non-Javadoc)
	 * @see edu.unikiel.rtsys.klodd.core.algorithms.AbstractAlgorithm#reset()
	 */
	public void reset() {
		basicNodePlacer.reset();
	}
	
	/* (non-Javadoc)
	 * @see edu.unikiel.rtsys.klodd.hierarchical.modules.INodePlacer#placeNodes(edu.unikiel.rtsys.klodd.hierarchical.structures.LayeredGraph, float)
	 */
	public void placeNodes(LayeredGraph layeredGraph, float minDist) {
		this.minDist = minDist;
		this.layeredGraph = layeredGraph;
		this.layoutDirection = layeredGraph.getLayoutDirection();
		// apply the basic node placement
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
			for (LayerElement element : linearSegment.elements) {
				KPoint pos = element.getPosition();
				if (layoutDirection == LAYOUT_OPTION.VERTICAL) {
					pos.setX(pos.getX() + moveDelta);
				}
				else {
					pos.setY(pos.getY() + moveDelta);
				}
			}
		}
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
		// determine source position of this connection
		float sourcePos = layoutDirection == LAYOUT_OPTION.VERTICAL
				? connection.getSourceElement().getPosition().getX()
				: connection.getSourceElement().getPosition().getY();
		if (connection.sourceRoutePos == 0) {
			KPort sourcePort = connection.getSourcePort();
			if (sourcePort != null) {
				KPortLayout portLayout = sourcePort.getLayout();
				sourcePos += layoutDirection == LAYOUT_OPTION.VERTICAL
						? portLayout.getSize().getWidth() / 2
						: portLayout.getSize().getHeight() / 2;
				if (sourcePort.getNodeGroup() != layeredGraph.getParentGroup()) {
					sourcePos += layoutDirection == LAYOUT_OPTION.VERTICAL
							? portLayout.getLocation().getX()
							: portLayout.getLocation().getY();
				}
			}
		}
		else if (connection.sourceRoutePos > 0) {
			sourcePos += (layoutDirection == LAYOUT_OPTION.VERTICAL
					? connection.getSourceElement().getRealDim().getWidth()
					: connection.getSourceElement().getRealDim().getHeight())
					+ connection.sourceRoutePos * minDist;
		}
		else if (connection.sourceRoutePos < 0) {
			sourcePos += connection.sourceRoutePos * minDist;
		}
		
		// determine target position of this connection
		float targetPos = layoutDirection == LAYOUT_OPTION.VERTICAL
				? connection.getTargetElement().getPosition().getX()
				: connection.getTargetElement().getPosition().getY();
		if (connection.targetRoutePos == 0) {
			KPort targetPort = connection.getTargetPort();
			if (targetPort != null) {
				KPortLayout portLayout = targetPort.getLayout();
				targetPos += layoutDirection == LAYOUT_OPTION.VERTICAL
						? portLayout.getSize().getWidth() / 2
						: portLayout.getSize().getHeight() / 2;
				if (targetPort.getNodeGroup() != layeredGraph.getParentGroup()) {
					targetPos += layoutDirection == LAYOUT_OPTION.VERTICAL
							? portLayout.getLocation().getX()
							: portLayout.getLocation().getY();
				}
			}
		}
		else if (connection.targetRoutePos > 0) {
			targetPos += (layoutDirection == LAYOUT_OPTION.VERTICAL
					? connection.getTargetElement().getRealDim().getWidth()
					: connection.getTargetElement().getRealDim().getHeight())
					+ connection.targetRoutePos * minDist;
		}
		else if (connection.targetRoutePos < 0) {
			targetPos += connection.targetRoutePos * minDist;
		}
		
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

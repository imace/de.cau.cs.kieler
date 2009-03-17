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
package de.cau.cs.kieler.klodd.hierarchical.impl;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import de.cau.cs.kieler.core.alg.AbstractAlgorithm;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.*;
import de.cau.cs.kieler.kiml.layout.util.LayoutGraphUtil;
import de.cau.cs.kieler.klodd.hierarchical.modules.IEdgeRouter;
import de.cau.cs.kieler.klodd.hierarchical.modules.ILayerwiseEdgePlacer;
import de.cau.cs.kieler.klodd.hierarchical.structures.*;


/**
 * Edge routing algorithm that makes rectilinear edges.
 * 
 * @author msp
 */
public class RectilinearEdgeRouter extends AbstractAlgorithm implements
		IEdgeRouter {
	
	/**
	 * Enumeration for types of routing of connections to or from
	 * external ports of a layered graph.
	 */
	private enum ExternalRouting {
		NORMAL, FIRST, LAST, AROUND
	}

	/** layerwise edge placer used to route layer connections */
	private ILayerwiseEdgePlacer layerwiseEdgePlacer;
	/** minimal distance between elements of the layered graph */
	private float minDist;
	/** lengthwise position of the currently processed layer */
	private float layerPos;
	/** maximal crosswise layout position of routed edges to external ports */
	private float maxCrosswisePos;
	/** maximal lengthwise layout position to be added to the total size */
	private float maxLengthwiseAddPos;
	
	/**
	 * Creates a rectilinear edge router using a layerwise edge placer.
	 * 
	 * @param layerwiseEdgePlacer layerwise edge placer used to route layer connections
	 */
	public RectilinearEdgeRouter(ILayerwiseEdgePlacer layerwiseEdgePlacer) {
		this.layerwiseEdgePlacer = layerwiseEdgePlacer;
	}

	/* (non-Javadoc)
	 * @see de.cau.cs.kieler.klodd.hierarchical.modules.IEdgeRouter#routeEdges(de.cau.cs.kieler.klodd.hierarchical.structures.LayeredGraph, float)
	 */
	public void routeEdges(LayeredGraph layeredGraph, float minDist) {
		getMonitor().begin("Rectilinear edge routing",
				layeredGraph.getLayers().size() - 1);
		
		this.minDist = minDist;
		this.layerPos = 0.0f; 
		this.maxCrosswisePos = layeredGraph.crosswiseDim;
		this.maxLengthwiseAddPos = 0.0f;

		// add a left border if there are no input ports
		Layer firstLayer = layeredGraph.getLayers().get(0); 
		if (firstLayer.rank != 0)
			layerPos = minDist;
		// layout elements of the first layer
		firstLayer.layoutElements(layerPos, minDist);
		
		// process all outgoing connections from each layer
		ListIterator<Layer> layerIter = layeredGraph.getLayers().listIterator();
		while (layerIter.hasNext()) {
			Layer layer = layerIter.next();
			if (layerIter.hasNext()) {
				// layout all outgoing connections of the current layer 
				processOutgoing(layer);
			}
			// layout element loops of the current layer
			processLoops(layer);
		}
		
		// update dimension of the whole graph
		Layer lastLayer = layeredGraph.getLayers().get(layeredGraph.getLayers().size() - 1);
		layerPos = lastLayer.lengthwisePos + lastLayer.lengthwiseDim + minDist;
		if (layeredGraph.getLayoutDirection() == KLayoutOption.VERTICAL) {
			layeredGraph.crosswiseDim = maxCrosswisePos
				+ layeredGraph.getPosition().getX();
			layeredGraph.lengthwiseDim = Math.max(layeredGraph.lengthwiseDim,
				layerPos + maxLengthwiseAddPos + layeredGraph.getPosition().getY());
		}
		else {
			layeredGraph.crosswiseDim = maxCrosswisePos
				+ layeredGraph.getPosition().getY();
			layeredGraph.lengthwiseDim = Math.max(layeredGraph.lengthwiseDim,
				layerPos + maxLengthwiseAddPos + layeredGraph.getPosition().getX());
		}
		
		// process external ports
		processExternalPorts(layeredGraph);
		getMonitor().done();
	}
	
	/**
	 * Processes connections from a given layer to the subsequent one.
	 * 
	 * @param layer layer to be processed
	 */
	private void processOutgoing(Layer layer) {
		KLayoutOption layoutDirection = layer.getLayeredGraph().getLayoutDirection();

		// determine external routing options
		Map<LayerConnection, ExternalRouting> routingMap = new HashMap<LayerConnection, ExternalRouting>();
		int firstExtEdges = 0, lastExtEdges = 0, aroundExtEdges = 0;
		for (LayerElement element : layer.getElements()) {
			for (LayerConnection connection : element.getOutgoingConnections()) {
				// determine source and target positions
				ExternalRouting externalRouting = ExternalRouting.NORMAL;
				if (layer.rank == 0) {
					KPortPlacement placement = connection.getSourcePort().getLayout().getPlacement();
					if (layoutDirection == KLayoutOption.VERTICAL) {
						if (placement == KPortPlacement.WEST) {
							externalRouting = ExternalRouting.FIRST;
							firstExtEdges++;
						}
						else if (placement == KPortPlacement.EAST) {
							externalRouting = ExternalRouting.LAST;
							lastExtEdges++;
						}
						else if (placement == KPortPlacement.SOUTH) {
							externalRouting = ExternalRouting.AROUND;
							aroundExtEdges++;
						}
					}
					else {
						if (placement == KPortPlacement.NORTH) {
							externalRouting = ExternalRouting.FIRST;
							firstExtEdges++;
						}
						else if (placement == KPortPlacement.SOUTH) {
							externalRouting = ExternalRouting.LAST;
							lastExtEdges++;
						}
						else if (placement == KPortPlacement.EAST) {
							externalRouting = ExternalRouting.AROUND;
							aroundExtEdges++;
						}
					}
				}
				else if (layer.height == 1) {
					KPortPlacement placement = connection.getTargetPort().getLayout().getPlacement();
					if (layoutDirection == KLayoutOption.VERTICAL) {
						if (placement == KPortPlacement.WEST) {
							externalRouting = ExternalRouting.FIRST;
							firstExtEdges++;
						}
						else if (placement == KPortPlacement.EAST) {
							externalRouting = ExternalRouting.LAST;
							lastExtEdges++;
						}
						else if (placement == KPortPlacement.NORTH) {
							externalRouting = ExternalRouting.AROUND;
							aroundExtEdges++;
						}
					}
					else {
						if (placement == KPortPlacement.NORTH) {
							externalRouting = ExternalRouting.FIRST;
							firstExtEdges++;
						}
						else if (placement == KPortPlacement.SOUTH) {
							externalRouting = ExternalRouting.LAST;
							lastExtEdges++;
						}
						else if (placement == KPortPlacement.WEST) {
							externalRouting = ExternalRouting.AROUND;
							aroundExtEdges++;
						}
					}
				}
				routingMap.put(connection, externalRouting);
			}
		}
		
		// determine placement for all layer connections
		layerwiseEdgePlacer.reset(getMonitor().subTask(1));
		int slotRanks = layerwiseEdgePlacer.placeEdges(layer, minDist);
		Map<Object, RoutingSlot> slotMap = layerwiseEdgePlacer.getSlotMap();
		
		// layout all movable elements of the next layer
		KPoint layeredGraphPos = layer.getLayeredGraph().getPosition();
		float connectionsPos = layer.lengthwisePos + layer.lengthwiseDim + minDist;
		layerPos = connectionsPos + slotRanks * minDist;
		layer.next.layoutElements(layerPos, minDist);
		int firstExtIndex = 0, lastExtIndex = 0, aroundExtIndex = 0;
		
		// route connections from the current layer to the next one
		for (LayerElement element : layer.getElements()) {
			KPoint sourcePos = element.getPosition();
			for (LayerConnection connection : element.getOutgoingConnections()) {
				// add back routing at source if needed
				if (connection.sourceBackPos > 0) {
					KPoint point1 = KimlLayoutGraphFactory.eINSTANCE.createKPoint();
					KPoint point2 = KimlLayoutGraphFactory.eINSTANCE.createKPoint();
					KPortLayout portLayout = connection.getSourcePort().getLayout();
					if (layoutDirection == KLayoutOption.VERTICAL) {
						point1.setX(sourcePos.getX()
								+ portLayout.getLocation().getX()
								+ portLayout.getSize().getWidth() / 2);
						point1.setY(sourcePos.getY()
								- connection.sourceBackPos * minDist);
						point2.setX(connection.sourceAnchorPos);
						point2.setY(point1.getY());
					}
					else {
						point1.setY(sourcePos.getY()
								+ portLayout.getLocation().getY()
								+ portLayout.getSize().getHeight() / 2);
						point1.setX(sourcePos.getX()
								- connection.sourceBackPos * minDist);
						point2.setY(connection.sourceAnchorPos);
						point2.setX(point1.getX());
					}
					connection.bendPoints.add(point1);
					connection.bendPoints.add(point2);
				}
				
				// add side routing at source if needed
				else if (connection.sourceSidePos != 0) {
					KPoint point = KimlLayoutGraphFactory.eINSTANCE.createKPoint();
					KPortLayout portLayout = connection.getSourcePort().getLayout();
					if (layoutDirection == KLayoutOption.VERTICAL) {
						point.setX(connection.sourceAnchorPos);
						point.setY(sourcePos.getY()
								+ portLayout.getLocation().getY()
								+ portLayout.getSize().getHeight() / 2);
					}
					else {
						point.setY(connection.sourceAnchorPos);
						point.setX(sourcePos.getX()
								+ portLayout.getLocation().getX()
								+ portLayout.getSize().getWidth() / 2);
					}
					connection.bendPoints.add(point);
				}
				
				Object key = connection.getSourcePort();
				if (key == null)
					key = element;
				RoutingSlot slot = slotMap.get(key);
				if (slot == null) {
					key = connection.getTargetPort();
					if (key == null)
						key = connection.getTargetElement();
					slot = slotMap.get(key);
				}
				ExternalRouting externalRouting = routingMap.get(connection);
				if (externalRouting == ExternalRouting.FIRST
						|| externalRouting == ExternalRouting.LAST) {
					// perform routing to external port beside the layered graph
					KPoint point1 = KimlLayoutGraphFactory.eINSTANCE.createKPoint();
					KPoint point2 = KimlLayoutGraphFactory.eINSTANCE.createKPoint();
					KPoint point3 = KimlLayoutGraphFactory.eINSTANCE.createKPoint();
					if (layoutDirection == KLayoutOption.VERTICAL) {
						if (externalRouting == ExternalRouting.FIRST) {
							point1.setX(-(layeredGraphPos.getX() + firstExtIndex * minDist));
							firstExtIndex++;
						}
						else {
							point1.setX(maxCrosswisePos + (lastExtEdges
									- lastExtIndex - 1) * minDist);
							lastExtIndex++;
						}
						point2.setX(point1.getX());
						point2.setY(connectionsPos + slot.rank * minDist);
						point3.setX(layer.rank == 0 ? connection.targetAnchorPos
								: connection.sourceAnchorPos);
						point3.setY(point2.getY());
					}
					else {
						if (externalRouting == ExternalRouting.FIRST) {
							point1.setY(-(layeredGraphPos.getY() + firstExtIndex * minDist));
							firstExtIndex++;
						}
						else {
							point1.setY(maxCrosswisePos + (lastExtEdges
									- lastExtIndex - 1) * minDist);
							lastExtIndex++;
						}
						point2.setY(point1.getY());
						point2.setX(connectionsPos + slot.rank * minDist);
						point3.setY(layer.rank == 0 ? connection.targetAnchorPos
								: connection.sourceAnchorPos);
						point3.setX(point2.getX());
					}
					if (layer.rank == 0) {
						connection.bendPoints.add(point1);
						connection.bendPoints.add(point2);
						connection.bendPoints.add(point3);
					}
					else if (layer.height == 1) {
						connection.bendPoints.add(point3);
						connection.bendPoints.add(point2);
						connection.bendPoints.add(point1);
					}
				}
				else if (externalRouting == ExternalRouting.AROUND) {
					// perform routing to external port on the opposite side
					KPoint point1 = KimlLayoutGraphFactory.eINSTANCE.createKPoint();
					KPoint point2 = KimlLayoutGraphFactory.eINSTANCE.createKPoint();
					KPoint point3 = KimlLayoutGraphFactory.eINSTANCE.createKPoint();
					KPoint point4 = KimlLayoutGraphFactory.eINSTANCE.createKPoint();
					if (layoutDirection == KLayoutOption.VERTICAL) {
						point1.setY(-aroundExtIndex * minDist);
						point2.setY(point1.getY());
						if (layer.rank == 0)
							point4.setX(connection.targetAnchorPos);
						else
							point4.setX(connection.sourceAnchorPos);
						point2.setX(maxCrosswisePos + (lastExtEdges + aroundExtEdges
								- aroundExtIndex - 1) * minDist);
						point3.setX(point2.getX());
						point3.setY(connectionsPos + slot.rank * minDist);
						point4.setY(point3.getY());
					}
					else {
						point1.setX(-aroundExtIndex * minDist);
						point2.setX(point1.getX());
						if (layer.rank == 0)
							point4.setY(connection.targetAnchorPos);
						else
							point4.setY(connection.sourceAnchorPos);
						point2.setY(maxCrosswisePos + (lastExtEdges + aroundExtEdges
								- aroundExtIndex - 1) * minDist);
						point3.setY(point2.getY());
						point3.setX(connectionsPos + slot.rank * minDist);
						point4.setX(point3.getX());
					}
					aroundExtIndex++;
					if (layer.rank == 0) {
						connection.bendPoints.add(point1);
						connection.bendPoints.add(point2);
						connection.bendPoints.add(point3);
						connection.bendPoints.add(point4);
					}
					else if (layer.height == 1) {
						connection.bendPoints.add(point4);
						connection.bendPoints.add(point3);
						connection.bendPoints.add(point2);
						connection.bendPoints.add(point1);
					}
					
				}
				else if (connection.sourceAnchorPos != connection.targetAnchorPos) {
					// perform normal routing between anchor points
					KPoint point1 = KimlLayoutGraphFactory.eINSTANCE.createKPoint();
					KPoint point2 = KimlLayoutGraphFactory.eINSTANCE.createKPoint();
					if (layoutDirection == KLayoutOption.VERTICAL) {
						point1.setX(connection.sourceAnchorPos);
						point1.setY(connectionsPos + slot.rank * minDist);
						point2.setX(connection.targetAnchorPos);
						point2.setY(point1.getY());
					}
					else {
						point1.setY(connection.sourceAnchorPos);
						point1.setX(connectionsPos + slot.rank * minDist);
						point2.setY(connection.targetAnchorPos);
						point2.setX(point1.getX());
					}
					connection.bendPoints.add(point1);
					connection.bendPoints.add(point2);
				}
				
				// add front routing at target if needed
				KPoint targetPos = connection.getTargetElement().getPosition();
				if (connection.targetFrontPos > 0) {
					KPoint point1 = KimlLayoutGraphFactory.eINSTANCE.createKPoint();
					KPoint point2 = KimlLayoutGraphFactory.eINSTANCE.createKPoint();
					KPortLayout portLayout = connection.getTargetPort().getLayout();
					KDimension targetDim = connection.getTargetElement().getRealDim();
					if (layoutDirection == KLayoutOption.VERTICAL) {
						point1.setX(connection.targetAnchorPos);
						point1.setY(targetPos.getY() + targetDim.getHeight()
								+ connection.targetFrontPos * minDist);
						point2.setX(connection.getTargetElement().getPosition().getX()
								+ portLayout.getLocation().getX()
								+ portLayout.getSize().getWidth() / 2);
						point2.setY(point1.getY());
					}
					else {
						point1.setY(connection.targetAnchorPos);
						point1.setX(targetPos.getX() + targetDim.getWidth()
								+ connection.targetFrontPos * minDist);
						point2.setY(connection.getTargetElement().getPosition().getY()
								+ portLayout.getLocation().getY()
								+ portLayout.getSize().getHeight() / 2);
						point2.setX(point1.getX());
					}
					connection.bendPoints.add(point1);
					connection.bendPoints.add(point2);
				}
				
				// add side routing at target if needed
				else if (connection.targetSidePos != 0) {
					KPoint point = KimlLayoutGraphFactory.eINSTANCE.createKPoint();
					KPortLayout portLayout = connection.getTargetPort().getLayout();
					if (layoutDirection == KLayoutOption.VERTICAL) {
						point.setX(connection.targetAnchorPos);
						point.setY(connection.getTargetElement().getPosition().getY()
								+ portLayout.getLocation().getY()
								+ portLayout.getSize().getHeight() / 2);
					}
					else {
						point.setY(connection.targetAnchorPos);
						point.setX(connection.getTargetElement().getPosition().getX()
								+ portLayout.getLocation().getX()
								+ portLayout.getSize().getWidth() / 2);
					}
					connection.bendPoints.add(point);
				}
			}			
		}
		
		// update dimension of the layered graph
		if (layoutDirection == KLayoutOption.VERTICAL) {
			layeredGraphPos.setX(layeredGraphPos.getX() + firstExtEdges * minDist);
			if (layer.height == 0)
				layeredGraphPos.setY(layeredGraphPos.getY() + aroundExtEdges * minDist);
		}
		else {
			layeredGraphPos.setY(layeredGraphPos.getY() + firstExtEdges * minDist);
			if (layer.height == 0)
				layeredGraphPos.setX(layeredGraphPos.getX() + aroundExtEdges * minDist);
		}
		maxCrosswisePos += (lastExtEdges + aroundExtEdges) * minDist;
		if (layer.rank == 0)
			maxLengthwiseAddPos = aroundExtEdges * minDist;
	}
	
	/**
	 * Routes element loops in a given layer.
	 * 
	 * @param layer layer to process
	 */
	private void processLoops(Layer layer) {
		for (LayerElement element : layer.getElements()) {
			for (ElementLoop loop : element.getLoops()) {
				KPoint point1 = createPointFor(loop.getSourcePort(), element, loop);
				KPoint point4 = createPointFor(loop.getTargetPort(), element, loop);
				loop.bendPoints.add(point1);
				
				KPortPlacement placement1 = loop.getSourcePort().getLayout().getPlacement();
				KPortPlacement placement2 = loop.getTargetPort().getLayout().getPlacement();
				if (placement1 != placement2) {
					KPoint point2 = KimlLayoutGraphFactory.eINSTANCE.createKPoint();
					KPoint point3 = KimlLayoutGraphFactory.eINSTANCE.createKPoint();
					if (placement1 == KPortPlacement.NORTH && placement2 == KPortPlacement.SOUTH
							|| placement1 == KPortPlacement.SOUTH && placement2 == KPortPlacement.NORTH) {
						point2.setX(element.getPosition().getX()
								+ element.getRealDim().getWidth()
								+ loop.eastRoutePos * minDist);
						point2.setY(point1.getY());
						point3.setX(point2.getX());
						point3.setY(point4.getY());
						loop.bendPoints.add(point2);
					}
					else if (placement1 == KPortPlacement.EAST && placement2 == KPortPlacement.WEST
							|| placement1 == KPortPlacement.WEST && placement2 == KPortPlacement.EAST) {
						point2.setX(point1.getX());
						point2.setY(element.getPosition().getY()
								+ element.getRealDim().getHeight()
								+ loop.southRoutePos * minDist);
						point3.setX(point4.getX());
						point3.setY(point2.getY());
						loop.bendPoints.add(point2);
					}
					else if (placement1 == KPortPlacement.NORTH || placement1 == KPortPlacement.SOUTH) {
						point3.setX(point4.getX());
						point3.setY(point1.getY());
					}
					else {
						point3.setX(point1.getX());
						point3.setY(point4.getY());
					}
					loop.bendPoints.add(point3);
				}
				loop.bendPoints.add(point4);
			}
		}
	}

	/**
	 * Process the external ports of a given layered graph by assigning
	 * missing coordinates.
	 * 
	 * @param layeredGraph layered graph to process
	 */
	private void processExternalPorts(LayeredGraph layeredGraph) {
		KLayoutOption layoutDirection = layeredGraph.getLayoutDirection();
		Layer inputLayer = layeredGraph.getLayers().get(0);
		Layer outputLayer = layeredGraph.getLayers().get(layeredGraph.getLayers().size() - 1);
		
		// determine maximal crosswise positions of input and output ports
		float maxInputPos = 0.0f;
		float maxOutputPos = 0.0f;
		if (inputLayer.rank == 0) {
			if (layoutDirection == KLayoutOption.VERTICAL) {
				for (LayerElement element : inputLayer.getElements()) {
					KLayoutPort port = (KLayoutPort)element.getElemObj();
					if (port.getLayout().getPlacement() == KPortPlacement.NORTH)
						maxInputPos = Math.max(maxInputPos, element.getPosition().getX());
				}
			}
			else {
				for (LayerElement element : inputLayer.getElements()) {
					KLayoutPort port = (KLayoutPort)element.getElemObj();
					if (port.getLayout().getPlacement() == KPortPlacement.WEST)
						maxInputPos = Math.max(maxInputPos, element.getPosition().getY());
				}
			}
		}
		if (outputLayer.height == 0) {
			if (layoutDirection == KLayoutOption.VERTICAL) {
				for (LayerElement element : outputLayer.getElements()) {
					KLayoutPort port = (KLayoutPort)element.getElemObj();
					if (port.getLayout().getPlacement() == KPortPlacement.SOUTH)
						maxOutputPos = Math.max(maxOutputPos, element.getPosition().getX());
				}
			}
			else {
				for (LayerElement element : outputLayer.getElements()) {
					KLayoutPort port = (KLayoutPort)element.getElemObj();
					if (port.getLayout().getPlacement() == KPortPlacement.EAST)
						maxOutputPos = Math.max(maxOutputPos, element.getPosition().getY());
				}
			}
		}
		
		// process input and output ports
		if (inputLayer.rank == 0)
			processExternalLayer(layeredGraph, inputLayer, maxInputPos, maxOutputPos);
		if (outputLayer.height == 0)
			processExternalLayer(layeredGraph, outputLayer, maxInputPos, maxOutputPos);
	}
	
	/**
	 * Process a layer with external ports.
	 * 
	 * @param layeredGraph the layered graph
	 * @param layer external layer
	 * @param maxInputPos maximal position of an input port on its home side
	 * @param maxOutputPos maximal position of an output port on its home side
	 */
	private void processExternalLayer(LayeredGraph layeredGraph, Layer layer,
			float maxInputPos, float maxOutputPos) {
		KLayoutOption layoutDirection = layeredGraph.getLayoutDirection();
		float offsetX = -layeredGraph.getPosition().getX();
		float offsetY = -layeredGraph.getPosition().getY();
		
		// choose a placement for non-fixed ports
		if (!layeredGraph.areExternalPortsFixed()) {
			List<KPoint> northPorts = new LinkedList<KPoint>();
			List<KPoint> eastPorts = new LinkedList<KPoint>();
			List<KPoint> southPorts = new LinkedList<KPoint>();
			List<KPoint> westPorts = new LinkedList<KPoint>();
			for (LayerElement element : layer.getElements()) {
				KLayoutPort port = (KLayoutPort)element.getElemObj();
				switch (port.getLayout().getPlacement()) {
				case NORTH:
					northPorts.add(element.getPosition());
					break;
				case EAST:
					eastPorts.add(element.getPosition());
					break;
				case SOUTH:
					southPorts.add(element.getPosition());
					break;
				case WEST:
					westPorts.add(element.getPosition());
					break;
				}
			}
			if (layoutDirection == KLayoutOption.VERTICAL) {
				if (layer.rank == 0) {
					LayoutGraphUtil.placePoints(westPorts, 0.0f,
							layeredGraph.lengthwiseDim / 2, offsetY, true, true);
					LayoutGraphUtil.placePoints(eastPorts, 0.0f,
							layeredGraph.lengthwiseDim / 2, offsetY, true, false);
					LayoutGraphUtil.placePoints(southPorts, maxOutputPos,
							layeredGraph.crosswiseDim + offsetX, 0.0f, false, true);
				}
				else {
					LayoutGraphUtil.placePoints(westPorts, layeredGraph.lengthwiseDim / 2,
							layeredGraph.lengthwiseDim, offsetY, true, true);
					LayoutGraphUtil.placePoints(eastPorts, layeredGraph.lengthwiseDim / 2,
							layeredGraph.lengthwiseDim, offsetY, true, false);
					LayoutGraphUtil.placePoints(northPorts, maxInputPos,
							layeredGraph.crosswiseDim + offsetX, 0.0f, false, true);
				}
			}
			else {
				if (layer.rank == 0) {
					LayoutGraphUtil.placePoints(northPorts, 0.0f,
							layeredGraph.lengthwiseDim / 2, offsetX, false, false);
					LayoutGraphUtil.placePoints(southPorts, 0.0f,
							layeredGraph.lengthwiseDim / 2, offsetX, false, true);
					LayoutGraphUtil.placePoints(eastPorts, maxOutputPos,
							layeredGraph.crosswiseDim + offsetY, 0.0f, true, false);
				}
				else {
					LayoutGraphUtil.placePoints(northPorts, layeredGraph.lengthwiseDim / 2,
							layeredGraph.lengthwiseDim, offsetX, false, true);
					LayoutGraphUtil.placePoints(southPorts, layeredGraph.lengthwiseDim / 2,
							layeredGraph.lengthwiseDim, offsetX, false, false);
					LayoutGraphUtil.placePoints(westPorts, maxInputPos,
							layeredGraph.crosswiseDim + offsetY, 0.0f, true, false);
				}
			}
		}
		
		// adjust the position of each external port
		if (layoutDirection == KLayoutOption.VERTICAL) {
			for (LayerElement element : layer.getElements()) {
				KLayoutPort port = (KLayoutPort)element.getElemObj();
				KPoint position = element.getPosition();
				KDimension size = port.getLayout().getSize();
				switch (port.getLayout().getPlacement()) {
				case NORTH:
					position.setY(offsetY - size.getHeight());
					if (layer.height == 0) {
						float posX = position.getX() + size.getWidth() / 2;
						for (LayerConnection connection : element.getIncomingConnections()) {
							connection.bendPoints.get(connection.bendPoints.size()-1)
								.setX(posX);
						}
					}
					break;
				case EAST:
					position.setX(layeredGraph.crosswiseDim + offsetX);
					float posY = position.getY() + size.getHeight() / 2;
					if (layer.rank == 0) {
						for (LayerConnection connection : element.getOutgoingConnections()) {
							connection.bendPoints.get(0).setY(posY);
						}
					}
					else {
						for (LayerConnection connection : element.getIncomingConnections()) {
							connection.bendPoints.get(connection.bendPoints.size()-1)
								.setY(posY);
						}
					}
					break;
				case SOUTH:
					position.setY(layeredGraph.lengthwiseDim + offsetY);
					if (layer.rank == 0) {
						float posX = position.getX() + size.getWidth() / 2;
						for (LayerConnection connection : element.getOutgoingConnections()) {
							KPoint point1 = connection.bendPoints.get(0);
							KPoint point2 = connection.bendPoints.get(1);
							point1.setX(posX);
							point1.setY(position.getY() + point1.getY()); 
							point2.setY(point1.getY());
						}
					}
					break;
				case WEST:
					position.setX(offsetX - size.getWidth());
					posY = position.getY() + size.getHeight() / 2;
					if (layer.rank == 0) {
						for (LayerConnection connection : element.getOutgoingConnections()) {
							connection.bendPoints.get(0).setY(posY);
						}
					}
					else {
						for (LayerConnection connection : element.getIncomingConnections()) {
							connection.bendPoints.get(connection.bendPoints.size()-1)
								.setY(posY);
						}
					}
					break;
				}
			}
		}
		else {
			for (LayerElement element : layer.getElements()) {
				KLayoutPort port = (KLayoutPort)element.getElemObj();
				KPoint position = element.getPosition();
				KDimension size = port.getLayout().getSize();
				switch (port.getLayout().getPlacement()) {
				case NORTH:
					position.setY(offsetY - size.getHeight());
					float posX = position.getX() + size.getWidth() / 2;
					if (layer.rank == 0) {
						for (LayerConnection connection : element.getOutgoingConnections()) {
							connection.bendPoints.get(0).setX(posX);
						}
					}
					else {
						for (LayerConnection connection : element.getIncomingConnections()) {
							connection.bendPoints.get(connection.bendPoints.size()-1)
								.setX(posX);
						}
					}
					break;
				case EAST:
					position.setX(layeredGraph.lengthwiseDim + offsetX);
					if (layer.rank == 0) {
						float posY = position.getY() + size.getHeight() / 2;
						for (LayerConnection connection : element.getOutgoingConnections()) {
							KPoint point1 = connection.bendPoints.get(0);
							KPoint point2 = connection.bendPoints.get(1);
							point1.setY(posY);
							point1.setX(position.getX() + point1.getX()); 
							point2.setX(point1.getX());
						}
					}
					break;
				case SOUTH:
					position.setY(layeredGraph.crosswiseDim + offsetY);
					posX = position.getX() + size.getWidth() / 2;
					if (layer.rank == 0) {
						for (LayerConnection connection : element.getOutgoingConnections()) {
							connection.bendPoints.get(0).setX(posX);
						}
					}
					else {
						for (LayerConnection connection : element.getIncomingConnections()) {
							connection.bendPoints.get(connection.bendPoints.size()-1)
								.setX(posX);
						}
					}
					break;
				case WEST:
					position.setX(offsetX - size.getWidth());
					if (layer.height == 0) {
						float posY = position.getY() + size.getHeight() / 2;
						for (LayerConnection connection : element.getIncomingConnections()) {
							connection.bendPoints.get(connection.bendPoints.size()-1)
								.setY(posY);
						}
					}
					break;
				}
			}
		}
	}
	
	/**
	 * Creates a point for routing of an element loop.
	 * 
	 * @param port port where a point shall be created
	 * @param element the layer element
	 * @param loop element loop to be routed
	 * @return a point for edges starting or ending at the specified port
	 */
	private KPoint createPointFor(KLayoutPort port, LayerElement element,
			ElementLoop loop) {
		KPoint elemPos = element.getPosition();
		KDimension elemDim = element.getRealDim();
		KPoint point = KimlLayoutGraphFactory.eINSTANCE.createKPoint();
		switch (port.getLayout().getPlacement()) {
		case NORTH:
			point.setX(elemPos.getX()
					+ port.getLayout().getLocation().getX()
					+ port.getLayout().getSize().getWidth() / 2);
			point.setY(elemPos.getY() - loop.northRoutePos * minDist);
			break;
		case EAST:
			point.setX(elemPos.getX() + elemDim.getWidth()
					+ loop.eastRoutePos * minDist);
			point.setY(elemPos.getY()
					+ port.getLayout().getLocation().getY()
					+ port.getLayout().getSize().getHeight() / 2);
			break;
		case SOUTH:
			point.setX(elemPos.getX()
					+ port.getLayout().getLocation().getX()
					+ port.getLayout().getSize().getWidth() / 2);
			point.setY(elemPos.getY() + elemDim.getHeight()
					+ loop.southRoutePos * minDist);
			break;
		case WEST:
			point.setX(elemPos.getX() - loop.westRoutePos * minDist);
			point.setY(elemPos.getY()
					+ port.getLayout().getLocation().getY()
					+ port.getLayout().getSize().getHeight() / 2);
			break;
		}
		return point;
	}
	
}

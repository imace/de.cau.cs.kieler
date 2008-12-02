package edu.unikiel.rtsys.klodd.hierarchical.impl;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.*;
import edu.unikiel.rtsys.klodd.core.algorithms.AbstractAlgorithm;
import edu.unikiel.rtsys.klodd.core.util.LayoutGraphs;
import edu.unikiel.rtsys.klodd.hierarchical.modules.IEdgeRouter;
import edu.unikiel.rtsys.klodd.hierarchical.structures.*;

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
	
	/**
	 * This inner type is used to define the starting and ending position
	 * of a lengthwise routing slot. 
	 */
	private class RoutingSlot {
		int rank;
		float start, end;
	}
	
	/** minimal distance of two edges to make them feasible in the same
	 *  routing layer */
	private static final float EDGE_DIST = 2.0f;

	/** minimal distance between elements of the layered graph */
	private float minDist;
	/** lengthwise position of the currently processed layer */
	private float layerPos;
	/** maximal crosswise layout position of routed edges to external ports */
	private float maxCrosswisePos;
	/** maximal lengthwise layout position to be added to the total size */
	private float maxLengthwiseAddPos;

	/* (non-Javadoc)
	 * @see edu.unikiel.rtsys.klodd.hierarchical.modules.IEdgeRouter#routeEdges(edu.unikiel.rtsys.klodd.hierarchical.structures.LayeredGraph, float)
	 */
	public void routeEdges(LayeredGraph layeredGraph, float minDist) {
		this.minDist = minDist;
		this.layerPos = 0.0f; 
		this.maxCrosswisePos = layeredGraph.crosswiseDim;
		this.maxLengthwiseAddPos = 0.0f;

		// add a left border if there are no input ports
		if (layeredGraph.getLayers().get(0).rank != 0)
			layerPos = minDist;
		
		// process all outgoing connections from each layer
		ListIterator<Layer> layerIter = layeredGraph.getLayers().listIterator();
		while (layerIter.hasNext()) {
			Layer layer = layerIter.next();
			// layout all movable elements of the current layer
			float frontPadding = layer.layoutElements(layerPos, minDist);
			if (layerIter.hasNext()) {
				// layout all outgoing connections of the current layer 
				processLayer(layer, frontPadding);
			}
		}
		if (layeredGraph.getLayoutDirection() == LAYOUT_OPTION.VERTICAL) {
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
	}
	
	/**
	 * Processes connections from a given layer to the subsequent one.
	 * 
	 * @param layer layer to be processed
	 * @param frontPadding amount of space to leave in front of the layer
	 */
	private void processLayer(Layer layer, float frontPadding) {
		LAYOUT_OPTION layoutDirection = layer.getLayeredGraph().getLayoutDirection();
		// determine number of outgoing connections for each port
		Map<KPort, Integer> outgoing = new HashMap<KPort, Integer>();
		for (LayerElement element : layer.getElements()) {
			// count outgoing connections
			for (LayerConnection connection : element.getOutgoingConnections()) {
				KPort sourcePort = connection.getSourcePort();
				if (sourcePort != null) {
					Integer value = outgoing.get(sourcePort);
					if (value == null) {
						outgoing.put(sourcePort, Integer.valueOf(1));
					}
					else {
						outgoing.put(sourcePort, Integer.valueOf(value.intValue() + 1));
					}
				}
			}
		}
		
		// create routing slots for each port
		Map<KPort, RoutingSlot> slotMap = new LinkedHashMap<KPort, RoutingSlot>();
		Map<LayerConnection, ExternalRouting> routingMap = new HashMap<LayerConnection, ExternalRouting>();
		for (LayerElement element : layer.getElements()) {		
			for (LayerConnection connection : element.getOutgoingConnections()) {
				// choose source or target port for routing
				Integer sourceValue = outgoing.get(connection.getSourcePort());
				KPort port;
				if (sourceValue == null || sourceValue.intValue() <= 1)
					port = connection.getTargetPort();
				else
					port = connection.getSourcePort();
				
				// determine source and target positions
				float sourcePos = connection.calcSourcePos(minDist);
				float targetPos = connection.calcTargetPos(minDist);
				ExternalRouting externalRouting = ExternalRouting.NORMAL;
				if (layer.rank == 0) {
					PORT_PLACEMENT placement = connection.getSourcePort().getLayout().getPlacement();
					if (layoutDirection == LAYOUT_OPTION.VERTICAL) {
						if (placement == PORT_PLACEMENT.WEST) {
							sourcePos = 0.0f;
							externalRouting = ExternalRouting.FIRST;
						}
						else if (placement == PORT_PLACEMENT.EAST) {
							sourcePos = layer.crosswiseDim;
							externalRouting = ExternalRouting.LAST;
						}
						else if (placement == PORT_PLACEMENT.SOUTH) {
							sourcePos = layer.crosswiseDim;
							externalRouting = ExternalRouting.AROUND;
						}
					}
					else {
						if (placement == PORT_PLACEMENT.NORTH) {
							sourcePos = 0.0f;
							externalRouting = ExternalRouting.FIRST;
						}
						else if (placement == PORT_PLACEMENT.SOUTH) {
							sourcePos = layer.crosswiseDim;
							externalRouting = ExternalRouting.LAST;
						}
						else if (placement == PORT_PLACEMENT.EAST) {
							sourcePos = layer.crosswiseDim;
							externalRouting = ExternalRouting.AROUND;
						}
					}
				}
				else if (layer.height == 1) {
					PORT_PLACEMENT placement = connection.getTargetPort().getLayout().getPlacement();
					if (layoutDirection == LAYOUT_OPTION.VERTICAL) {
						if (placement == PORT_PLACEMENT.WEST) {
							targetPos = 0.0f;
							externalRouting = ExternalRouting.FIRST;
						}
						else if (placement == PORT_PLACEMENT.EAST) {
							targetPos = layer.crosswiseDim;
							externalRouting = ExternalRouting.LAST;
						}
						else if (placement == PORT_PLACEMENT.NORTH) {
							targetPos = layer.crosswiseDim;
							externalRouting = ExternalRouting.AROUND;
						}
					}
					else {
						if (placement == PORT_PLACEMENT.NORTH) {
							targetPos = 0.0f;
							externalRouting = ExternalRouting.FIRST;
						}
						else if (placement == PORT_PLACEMENT.SOUTH) {
							targetPos = layer.crosswiseDim;
							externalRouting = ExternalRouting.LAST;
						}
						else if (placement == PORT_PLACEMENT.WEST) {
							targetPos = layer.crosswiseDim;
							externalRouting = ExternalRouting.AROUND;
						}
					}
				}
				float startPos = Math.min(sourcePos, targetPos) - EDGE_DIST;
				float endPos  = Math.max(sourcePos, targetPos) + EDGE_DIST;
				
				// get routing slot and insert connection area
				routingMap.put(connection, externalRouting);
				RoutingSlot slot = slotMap.get(port);
				if (slot == null) {
					slot = new RoutingSlot();
					slot.start = startPos;
					slot.end = endPos;
					slotMap.put(port, slot);
				}
				else {
					slot.start = Math.min(slot.start, startPos);
					slot.end = Math.max(slot.end, endPos);
				}
			}
		}
		
		// assign ranks to each routing slot
		int slotRanks = 0;
		List<List<RoutingSlot>> routingLayers = new LinkedList<List<RoutingSlot>>();
		for (RoutingSlot slot : slotMap.values()) {
			boolean foundPlace = false;
			int rank = 0;
			for (List<RoutingSlot> routingLayer : routingLayers) {
				boolean feasible = true;
				for (RoutingSlot layerSlot : routingLayer) {
					if (slot.start < layerSlot.end && slot.end > layerSlot.start) {
						feasible = false;
						break;
					}
				}
				if (feasible) {
					slot.rank = rank;
					routingLayer.add(slot);
					foundPlace = true;
					break;
				}
				rank++;
			}
			if (!foundPlace) {
				slot.rank = rank;
				List<RoutingSlot> routingLayer = new LinkedList<RoutingSlot>();
				routingLayer.add(slot);
				routingLayers.add(routingLayer);
				slotRanks++;
			}
		}
		
		// route connections
		KPoint layeredGraphPos = layer.getLayeredGraph().getPosition();
		float connectionsPos = layer.lengthwisePos + layer.lengthwiseDim
				+ frontPadding + minDist;
		layerPos = connectionsPos + slotRanks * minDist;
		for (LayerElement element : layer.getElements()) {
			KPoint sourcePos = element.getPosition();
			for (LayerConnection connection : element.getOutgoingConnections()) {
				// add back routing at source if needed
				if (connection.sourceBackPos > 0) {
					KPoint point1 = KimlLayoutGraphFactory.eINSTANCE.createKPoint();
					KPoint point2 = KimlLayoutGraphFactory.eINSTANCE.createKPoint();
					KPortLayout portLayout = connection.getSourcePort().getLayout();
					if (layoutDirection == LAYOUT_OPTION.VERTICAL) {
						point1.setX(portLayout.getLocation().getX()
								+ portLayout.getSize().getWidth() / 2);
						point1.setY(sourcePos.getY()
								- connection.sourceBackPos * minDist);
						point2.setX(connection.sourceAnchorPos);
						point2.setY(point1.getY());
					}
					else {
						point1.setY(portLayout.getLocation().getY()
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
					if (layoutDirection == LAYOUT_OPTION.VERTICAL) {
						point.setX(connection.sourceAnchorPos);
						point.setY(portLayout.getLocation().getY()
								+ portLayout.getSize().getHeight());
					}
					else {
						point.setY(connection.sourceAnchorPos);
						point.setX(portLayout.getLocation().getX()
								+ portLayout.getSize().getWidth());
					}
					connection.bendPoints.add(point);
				}
				
				RoutingSlot slot = slotMap.get(connection.getSourcePort());
				if (slot == null) {
					slot = slotMap.get(connection.getTargetPort());
				}
				ExternalRouting externalRouting = routingMap.get(connection);
				if (externalRouting == ExternalRouting.FIRST
						|| externalRouting == ExternalRouting.LAST) {
					// perform routing to external port beside the layered graph
					KPoint point1 = KimlLayoutGraphFactory.eINSTANCE.createKPoint();
					KPoint point2 = KimlLayoutGraphFactory.eINSTANCE.createKPoint();
					KPoint point3 = KimlLayoutGraphFactory.eINSTANCE.createKPoint();
					if (layoutDirection == LAYOUT_OPTION.VERTICAL) {
						if (externalRouting == ExternalRouting.FIRST) {
							point1.setX((slot.rank - slotRanks) * minDist);
							layeredGraphPos.setX(Math.max(layeredGraphPos.getX(),
									-point1.getX() + minDist));
						}
						else {
							point1.setX(layer.getLayeredGraph().crosswiseDim
									+ (slotRanks - slot.rank) * minDist);
							maxCrosswisePos = Math.max(maxCrosswisePos,
									point1.getX() + minDist);
						}
						point2.setX(point1.getX());
						point2.setY(connectionsPos + slot.rank * minDist);
						point3.setX(layer.rank == 0 ? connection.targetAnchorPos
								: connection.sourceAnchorPos);
						point3.setY(point2.getY());
					}
					else {
						if (externalRouting == ExternalRouting.FIRST) {
							point1.setY((slot.rank - slotRanks) * minDist);
							layeredGraphPos.setY(Math.max(layeredGraphPos.getY(),
									-point1.getY() + minDist));
						}
						else {
							point1.setY(layer.getLayeredGraph().crosswiseDim
									+ (slotRanks - slot.rank) * minDist);
							maxCrosswisePos = Math.max(maxCrosswisePos,
									point1.getY() + minDist);
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
					if (layoutDirection == LAYOUT_OPTION.VERTICAL) {
						point1.setY((slot.rank - slotRanks) * minDist);
						point2.setY(point1.getY());
						if (layer.rank == 0) {
							maxLengthwiseAddPos = Math.max(maxLengthwiseAddPos,
									point1.getY());
							point4.setX(connection.targetAnchorPos);
						}
						else {
							layeredGraphPos.setY(Math.max(layeredGraphPos.getY(),
									-point1.getY() + minDist));
							point4.setX(connection.sourceAnchorPos);
						}
						point2.setX(layer.getLayeredGraph().crosswiseDim
								+ (slotRanks - slot.rank) * minDist);
						maxCrosswisePos = Math.max(maxCrosswisePos,
								point2.getX() + minDist);
						point3.setX(point2.getX());
						point3.setY(connectionsPos + slot.rank * minDist);
						point4.setY(point3.getY());
					}
					else {
						point1.setX((slot.rank - slotRanks) * minDist);
						point2.setX(point1.getY());
						if (layer.rank == 0) {
							maxLengthwiseAddPos = Math.max(maxLengthwiseAddPos,
									point1.getX());
							point4.setY(connection.targetAnchorPos);
						}
						else {
							layeredGraphPos.setX(Math.max(layeredGraphPos.getX(),
									-point1.getX() + minDist));
							point4.setY(connection.sourceAnchorPos);
						}
						point2.setY(layer.getLayeredGraph().crosswiseDim
								+ (slotRanks - slot.rank) * minDist);
						maxCrosswisePos = Math.max(maxCrosswisePos,
								point2.getY() + minDist);
						point3.setY(point2.getY());
						point3.setX(connectionsPos + slot.rank * minDist);
						point4.setX(point3.getX());
					}
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
					if (layoutDirection == LAYOUT_OPTION.VERTICAL) {
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
					if (layoutDirection == LAYOUT_OPTION.VERTICAL) {
						point1.setX(connection.targetAnchorPos);
						point1.setY(targetPos.getY() + targetDim.getHeight()
								+ connection.targetFrontPos * minDist);
						point2.setX(portLayout.getLocation().getX()
								+ portLayout.getSize().getWidth() / 2);
						point2.setY(point1.getY());
					}
					else {
						point1.setY(connection.targetAnchorPos);
						point1.setX(targetPos.getX() + targetDim.getWidth()
								+ connection.targetFrontPos * minDist);
						point2.setY(portLayout.getLocation().getY()
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
					if (layoutDirection == LAYOUT_OPTION.VERTICAL) {
						point.setX(connection.targetAnchorPos);
						point.setY(portLayout.getLocation().getY()
								+ portLayout.getSize().getHeight());
					}
					else {
						point.setY(connection.targetAnchorPos);
						point.setX(portLayout.getLocation().getX()
								+ portLayout.getSize().getWidth());
					}
					connection.bendPoints.add(point);
				}
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
		LAYOUT_OPTION layoutDirection = layeredGraph.getLayoutDirection();
		Layer inputLayer = layeredGraph.getLayers().get(0);
		Layer outputLayer = layeredGraph.getLayers().get(layeredGraph.getLayers().size() - 1);
		
		// determine maximal crosswise positions of input and output ports
		float maxInputPos = 0.0f;
		float maxOutputPos = 0.0f;
		if (inputLayer.rank == 0) {
			if (layoutDirection == LAYOUT_OPTION.VERTICAL) {
				for (LayerElement element : inputLayer.getElements()) {
					KPort port = (KPort)element.getElemObj();
					if (port.getLayout().getPlacement() == PORT_PLACEMENT.NORTH)
						maxInputPos = Math.max(maxInputPos, element.getPosition().getX());
				}
			}
			else {
				for (LayerElement element : inputLayer.getElements()) {
					KPort port = (KPort)element.getElemObj();
					if (port.getLayout().getPlacement() == PORT_PLACEMENT.WEST)
						maxInputPos = Math.max(maxInputPos, element.getPosition().getY());
				}
			}
		}
		if (outputLayer.height == 0) {
			if (layoutDirection == LAYOUT_OPTION.VERTICAL) {
				for (LayerElement element : outputLayer.getElements()) {
					KPort port = (KPort)element.getElemObj();
					if (port.getLayout().getPlacement() == PORT_PLACEMENT.SOUTH)
						maxOutputPos = Math.max(maxOutputPos, element.getPosition().getX());
				}
			}
			else {
				for (LayerElement element : outputLayer.getElements()) {
					KPort port = (KPort)element.getElemObj();
					if (port.getLayout().getPlacement() == PORT_PLACEMENT.EAST)
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
		LAYOUT_OPTION layoutDirection = layeredGraph.getLayoutDirection();
		float offsetX = -layeredGraph.getPosition().getX();
		float offsetY = -layeredGraph.getPosition().getY();
		
		// choose a placement for non-fixed ports
		if (!layeredGraph.areExternalPortsFixed()) {
			List<KPoint> northPorts = new LinkedList<KPoint>();
			List<KPoint> eastPorts = new LinkedList<KPoint>();
			List<KPoint> southPorts = new LinkedList<KPoint>();
			List<KPoint> westPorts = new LinkedList<KPoint>();
			for (LayerElement element : layer.getElements()) {
				KPort port = (KPort)element.getElemObj();
				switch (port.getLayout().getPlacement()) {
				case NORTH:
					northPorts.add(element.getPosition());
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
			if (layoutDirection == LAYOUT_OPTION.VERTICAL) {
				if (layer.rank == 0) {
					LayoutGraphs.placePoints(westPorts, 0.0f,
							layeredGraph.lengthwiseDim / 2, offsetY, true, true);
					LayoutGraphs.placePoints(eastPorts, 0.0f,
							layeredGraph.lengthwiseDim / 2, offsetY, true, false);
					LayoutGraphs.placePoints(southPorts, maxOutputPos,
							layeredGraph.crosswiseDim + offsetX, 0.0f, false, true);
				}
				else {
					LayoutGraphs.placePoints(westPorts, layeredGraph.lengthwiseDim / 2,
							layeredGraph.lengthwiseDim, offsetY, true, true);
					LayoutGraphs.placePoints(eastPorts, layeredGraph.lengthwiseDim / 2,
							layeredGraph.lengthwiseDim, offsetY, true, false);
					LayoutGraphs.placePoints(northPorts, maxInputPos,
							layeredGraph.crosswiseDim + offsetX, 0.0f, false, true);
				}
			}
			else {
				if (layer.rank == 0) {
					LayoutGraphs.placePoints(northPorts, 0.0f,
							layeredGraph.lengthwiseDim / 2, offsetX, false, false);
					LayoutGraphs.placePoints(southPorts, 0.0f,
							layeredGraph.lengthwiseDim / 2, offsetX, false, true);
					LayoutGraphs.placePoints(eastPorts, maxOutputPos,
							layeredGraph.crosswiseDim + offsetY, 0.0f, true, false);
				}
				else {
					LayoutGraphs.placePoints(northPorts, layeredGraph.lengthwiseDim / 2,
							layeredGraph.lengthwiseDim, offsetX, false, true);
					LayoutGraphs.placePoints(southPorts, layeredGraph.lengthwiseDim / 2,
							layeredGraph.lengthwiseDim, offsetX, false, false);
					LayoutGraphs.placePoints(westPorts, maxInputPos,
							layeredGraph.crosswiseDim + offsetY, 0.0f, true, false);
				}
			}
		}
		
		// adjust the position of each external port
		if (layoutDirection == LAYOUT_OPTION.VERTICAL) {
			for (LayerElement element : layer.getElements()) {
				KPort port = (KPort)element.getElemObj();
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
							point1.setY(position.getY() - point1.getY()); 
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
				KPort port = (KPort)element.getElemObj();
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
							point1.setX(position.getX() - point1.getX()); 
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
	
}

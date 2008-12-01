package edu.unikiel.rtsys.klodd.hierarchical.impl;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KDimension;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KPoint;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KPort;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KPortLayout;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphFactory;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.LAYOUT_OPTION;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.PORT_PLACEMENT;
import edu.unikiel.rtsys.klodd.core.algorithms.AbstractAlgorithm;
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
		ExternalRouting externalRouting;
	}
	
	/** minimal distance of two edges to make them feasible in the same
	 *  routing layer */
	private static final float EDGE_DIST = 2.0f;

	/** minimal distance between elements of the layered graph */
	private float minDist;
	/** lengthwise position of the currently processed layer */
	private float layerPos;

	/* (non-Javadoc)
	 * @see edu.unikiel.rtsys.klodd.hierarchical.modules.IEdgeRouter#routeEdges(edu.unikiel.rtsys.klodd.hierarchical.structures.LayeredGraph, float)
	 */
	public void routeEdges(LayeredGraph layeredGraph, float minDist) {
		this.minDist = minDist;
		this.layerPos = 0.0f; 
		ListIterator<Layer> layerIter = layeredGraph.getLayers().listIterator();
		while (layerIter.hasNext()) {
			Layer layer = layerIter.next();
			if (layerIter.hasNext()) {
				processLayer(layer);
			}
		}
	}
	
	/**
	 * Processes connections from a given layer to the subsequent one.
	 * 
	 * @param layer layer to be processed
	 */
	private void processLayer(Layer layer) {
		LAYOUT_OPTION layoutDirection = layer.getLayeredGraph().getLayoutDirection();
		// determine number of outgoing connections for each port and padding values
		Map<KPort, Integer> outgoing = new HashMap<KPort, Integer>();
		float backPadding = 0.0f;
		float frontPadding = 0.0f;
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
			// determine padding values
			float sideSpace = (layer.lengthwiseDim - (layoutDirection == LAYOUT_OPTION.VERTICAL
					? element.getRealDim().getHeight() : element.getRealDim().getWidth())) / 2;
			backPadding = Math.max(backPadding,
					element.getEdgesBack() * minDist - sideSpace);
			frontPadding = Math.max(frontPadding,
					element.getEdgesFront() * minDist - sideSpace);
		}
		
		// create routing slots for each port and set node positions
		Map<KPort, RoutingSlot> slotMap = new LinkedHashMap<KPort, RoutingSlot>();
		layer.lengthwisePos = layerPos + backPadding;
		for (LayerElement element : layer.getElements()) {
			if (layer.rank > 0) {
				// set the lengthwise position of each node
				if (layoutDirection == LAYOUT_OPTION.VERTICAL) {
					float sideSpace = (layer.lengthwiseDim - element.getRealDim().getHeight()) / 2;
					element.getPosition().setY(layer.lengthwisePos + sideSpace);
				}
				else {
					float sideSpace = (layer.lengthwiseDim - element.getRealDim().getWidth()) / 2;
					element.getPosition().setX(layer.lengthwisePos + sideSpace);
				}
			}
			
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
						if (placement == PORT_PLACEMENT.WEST)
							sourcePos = 0.0f;
						else if (placement == PORT_PLACEMENT.EAST
								|| placement == PORT_PLACEMENT.SOUTH)
							sourcePos = layer.crosswiseDim;
					}
					else {
						if (placement == PORT_PLACEMENT.NORTH)
							sourcePos = 0.0f;
						else if (placement == PORT_PLACEMENT.SOUTH
								|| placement == PORT_PLACEMENT.EAST)
							sourcePos = layer.crosswiseDim;
					}
				}
				else if (layer.height == 1) {
					PORT_PLACEMENT placement = connection.getTargetPort().getLayout().getPlacement();
					if (layoutDirection == LAYOUT_OPTION.VERTICAL) {
						if (placement == PORT_PLACEMENT.WEST)
							targetPos = 0.0f;
						else if (placement == PORT_PLACEMENT.EAST
								|| placement == PORT_PLACEMENT.NORTH)
							targetPos = layer.crosswiseDim;
					}
					else {
						if (placement == PORT_PLACEMENT.NORTH)
							targetPos = 0.0f;
						else if (placement == PORT_PLACEMENT.SOUTH
								|| placement == PORT_PLACEMENT.WEST)
							targetPos = layer.crosswiseDim;
					}
				}
				float startPos = Math.min(sourcePos, targetPos) - EDGE_DIST;
				float endPos  = Math.max(sourcePos, targetPos) + EDGE_DIST;
				
				// get routing slot and insert connection area
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
		float connectionsPos = layer.lengthwisePos + layer.lengthwiseDim
				+ frontPadding + minDist;
		layerPos = connectionsPos;
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
				layerPos += minDist;
			}
		}
		layerPos += minDist;
		
		// route connections
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
				
				// perform normal routing between anchor points
				if (connection.sourceAnchorPos != connection.targetAnchorPos) {
					RoutingSlot slot = slotMap.get(connection.getSourcePort());
					if (slot == null) {
						slot = slotMap.get(connection.getTargetPort());
					}
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
	
}

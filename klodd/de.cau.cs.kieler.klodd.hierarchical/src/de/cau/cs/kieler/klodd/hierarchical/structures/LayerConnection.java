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

import java.util.LinkedList;
import java.util.List;

import de.cau.cs.kieler.core.kgraph.KEdge;
import de.cau.cs.kieler.core.kgraph.KPort;
import de.cau.cs.kieler.kiml.layout.klayoutdata.KEdgeLayout;
import de.cau.cs.kieler.kiml.layout.klayoutdata.KInsets;
import de.cau.cs.kieler.kiml.layout.klayoutdata.KLayoutDataFactory;
import de.cau.cs.kieler.kiml.layout.klayoutdata.KPoint;
import de.cau.cs.kieler.kiml.layout.klayoutdata.KShapeLayout;
import de.cau.cs.kieler.kiml.layout.options.LayoutDirection;
import de.cau.cs.kieler.kiml.layout.options.LayoutOptions;
import de.cau.cs.kieler.kiml.layout.options.PortSide;
import de.cau.cs.kieler.kiml.layout.util.KimlLayoutUtil;


/**
 * Connection between two layer elements in a layered graph.
 * 
 * @author msp
 */
public class LayerConnection {
	
	/** side routing position at the source of this connection */
	public int sourceSidePos = 0;
	/** side routing position at the target of this connection */
	public int targetSidePos = 0;
	/** back routing position at the source of this connection */
	public int sourceBackPos = 0;
	/** front routing position at the target of this connection */
	public int targetFrontPos = 0;
	/** crosswise position of the connection anchor at source */
	public float sourceAnchorPos = 0.0f;
	/** crosswise position of the connection anchor at target */
	public float targetAnchorPos = 0.0f;
	/** list of bend points of this connection */
	public List<KPoint> bendPoints = new LinkedList<KPoint>();
	
	/** the contained edge object */
	private KEdge edge;
	/** the source element */
	private LayerElement sourceElement;
	/** the source port */
	private KPort sourcePort;
	/** the target element */
	private LayerElement targetElement;
	/** the target port */
	private KPort targetPort;

	/**
	 * Creates a layer connection with given source and target.
	 * 
	 * @param edge the edge that is to be contained in this layer connection
	 * @param sourceElem the source element
	 * @param sourcePort the source port
	 * @param targetElem the target element
	 * @param targetPort the target port
	 */
	public LayerConnection(KEdge edge, LayerElement sourceElem,
			KPort sourcePort, LayerElement targetElem,
			KPort targetPort) {
		this.edge = edge;
		this.sourceElement = sourceElem;
		this.sourcePort = sourcePort;
		this.targetElement = targetElem;
		this.targetPort = targetPort;
		KimlLayoutUtil.getEdgeLayout(edge).getBendPoints().clear();
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "[" + sourceElement.toString() + "] > ["
			+ targetElement.toString() + "]";
	}
	
	/**
	 * Applies the layout of this layer connection to the contained edge.
	 * 
	 * @param offset offset to be added to each bend point
	 * @param insets insets of the containing parent layout node
	 */
	public void applyLayout(KPoint offset, KInsets insets) {
		LayeredGraph layeredGraph = sourceElement.getLayer().getLayeredGraph();
		KShapeLayout sourcePortLayout = (sourcePort == null ? null
		        : KimlLayoutUtil.getShapeLayout(sourcePort));
		KShapeLayout targetPortLayout = (targetPort == null ? null
		        : KimlLayoutUtil.getShapeLayout(targetPort));
		KEdgeLayout edgeLayout = KimlLayoutUtil.getEdgeLayout(edge);
		
		// subtract insets values from bend points near fixed external ports
		boolean subSourceXInset = false, subSourceYInset = false,
			subTargetXInset = false, subTargetYInset = false;
		if (layeredGraph.areExternalPortsFixed()) {
			if (sourcePort != null && sourcePort.getNode()
			        == layeredGraph.getParentNode()) {
			    PortSide sourceSide = LayoutOptions.getPortSide(sourcePortLayout);
				if (sourceSide == PortSide.NORTH
				        || sourceSide == PortSide.SOUTH) {
					subSourceXInset = true;
				}
				else {
					subSourceYInset = true;
				}
			}
			if (targetPort != null && targetPort.getNode()
			        == layeredGraph.getParentNode()) {
			    PortSide targetSide = LayoutOptions.getPortSide(targetPortLayout);
				if (targetSide == PortSide.NORTH
						|| targetSide == PortSide.SOUTH) {
					subTargetXInset = true;
				}
				else {
					subTargetYInset = true;
				}
			}
		}
		
		// set bend points
		for (KPoint point : bendPoints) {
			point.setX(point.getX() + offset.getX());
			point.setY(point.getY() + offset.getY());
			edgeLayout.getBendPoints().add(point);
		}
		
		// calculate position of source point
		KPoint sourcePoint = KLayoutDataFactory.eINSTANCE.createKPoint();
		if (sourcePort != null) {
			if (sourcePort.getNode() == layeredGraph.getParentNode()) {
				sourcePoint.setX(sourceElement.getPosition().getX()
						+ sourcePortLayout.getWidth() / 2);
				if (subSourceXInset) {
					sourcePoint.setX(sourcePoint.getX() - insets.getLeft());
					if (!bendPoints.isEmpty()) {
						KPoint bendPoint = bendPoints.get(0);
						bendPoint.setX(bendPoint.getX() - insets.getLeft());
					}
				}
				sourcePoint.setY(sourceElement.getPosition().getY()
						+ sourcePortLayout.getHeight() / 2);
				if (subSourceYInset) {
					sourcePoint.setY(sourcePoint.getY() - insets.getTop());
					if (!bendPoints.isEmpty()) {
						KPoint bendPoint = bendPoints.get(0);
						bendPoint.setY(bendPoint.getY() - insets.getTop());
					}
				}
				toExternalEndpoint(sourcePoint,
				        LayoutOptions.getPortSide(sourcePortLayout), insets);
			}
			else {
				sourcePoint.setX(sourcePortLayout.getXpos()
						+ sourcePortLayout.getWidth() / 2
						+ sourceElement.getPosition().getX());
				sourcePoint.setY(sourcePortLayout.getYpos()
						+ sourcePortLayout.getHeight() / 2
						+ sourceElement.getPosition().getY());
			}
		}
		else {
			sourcePoint.setX(sourceElement.getPosition().getX());
			sourcePoint.setY(sourceElement.getPosition().getY());
		}
		
		// calculate position of target point
		KPoint targetPoint = KLayoutDataFactory.eINSTANCE.createKPoint();
		if (targetPort != null) {
			if (targetPort.getNode() == layeredGraph.getParentNode()) {
				targetPoint.setX(targetElement.getPosition().getX()
						+ targetPortLayout.getWidth() / 2);
				if (subTargetXInset) {
					targetPoint.setX(targetPoint.getX() - insets.getLeft());
					if (!bendPoints.isEmpty()) {
						KPoint bendPoint = bendPoints.get(bendPoints.size()-1);
						bendPoint.setX(bendPoint.getX() - insets.getLeft());
					}
				}
				targetPoint.setY(targetElement.getPosition().getY()
						+ targetPortLayout.getHeight() / 2);
				if (subTargetYInset) {
					targetPoint.setY(targetPoint.getY() - insets.getTop());
					if (!bendPoints.isEmpty()) {
						KPoint bendPoint = bendPoints.get(bendPoints.size()-1);
						bendPoint.setY(bendPoint.getY() - insets.getTop());
					}
				}
				toExternalEndpoint(targetPoint,
				        LayoutOptions.getPortSide(targetPortLayout), insets);
			}
			else {
				targetPoint.setX(targetPortLayout.getXpos()
						+ targetPortLayout.getWidth() / 2
						+ targetElement.getPosition().getX());
				targetPoint.setY(targetPortLayout.getYpos()
						+ targetPortLayout.getHeight() / 2
						+ targetElement.getPosition().getY());
			}
		}
		else {
			targetPoint.setX(targetElement.getPosition().getX());
			targetPoint.setY(targetElement.getPosition().getY());
		}
		
		if (sourcePort != null) {
			alignEndpoint(sourcePoint, bendPoints.isEmpty()
					? targetPoint : bendPoints.get(0),
					sourcePortLayout.getWidth(), sourcePortLayout.getHeight());
			edgeLayout.setSourcePoint(sourcePoint);
		}
		
		if (targetPort != null) {
			alignEndpoint(targetPoint, bendPoints.isEmpty()
					? sourcePoint : bendPoints.get(bendPoints.size()-1),
					targetPortLayout.getWidth(), targetPortLayout.getHeight());
			edgeLayout.setTargetPoint(targetPoint);
		}
	}

	/**
	 * Gets the source element.
	 * 
	 * @return the sourceElement
	 */
	public LayerElement getSourceElement() {
		return sourceElement;
	}

	/**
	 * Gets the source port.
	 * 
	 * @return the sourcePort
	 */
	public KPort getSourcePort() {
		return sourcePort;
	}

	/**
	 * Gets the target element.
	 * 
	 * @return the targetElement
	 */
	public LayerElement getTargetElement() {
		return targetElement;
	}

	/**
	 * Gets the target port.
	 * 
	 * @return the targetPort
	 */
	public KPort getTargetPort() {
		return targetPort;
	}
	
	/**
	 * Determines the source position of this edge from the current layout
	 * position.
	 * 
	 * @param minDist minimal distance between elements
	 * @return position
	 */
	public float calcSourcePos(float minDist) {
		LayeredGraph layeredGraph = sourceElement.getLayer().getLayeredGraph();
		LayoutDirection layoutDirection = layeredGraph.getLayoutDirection();
		sourceAnchorPos = layoutDirection == LayoutDirection.VERTICAL
				? sourceElement.getPosition().getX()
				: sourceElement.getPosition().getY();
		if (sourceSidePos == 0) {
			if (sourcePort != null) {
				KShapeLayout portLayout = KimlLayoutUtil.getShapeLayout(sourcePort);
				sourceAnchorPos += layoutDirection == LayoutDirection.VERTICAL
						? portLayout.getWidth() / 2
						: portLayout.getHeight() / 2;
				if (sourcePort.getNode() != layeredGraph.getParentNode()) {
					sourceAnchorPos += layoutDirection == LayoutDirection.VERTICAL
							? portLayout.getXpos()
							: portLayout.getYpos();
				}
			}
		}
		else if (sourceSidePos > 0) {
			sourceAnchorPos += (layoutDirection == LayoutDirection.VERTICAL
					? sourceElement.getRealWidth()
					: sourceElement.getRealHeight())
					+ sourceSidePos * minDist;
		}
		else if (sourceSidePos < 0) {
			sourceAnchorPos += sourceSidePos * minDist;
		}
		return sourceAnchorPos;
	}
	
	/**
	 * Determines the target position of this edge from the current layout
	 * position.
	 * 
	 * @param minDist minimal distance between elements
	 * @return position
	 */
	public float calcTargetPos(float minDist) {
		LayeredGraph layeredGraph = sourceElement.getLayer().getLayeredGraph();
		LayoutDirection layoutDirection = layeredGraph.getLayoutDirection();
		targetAnchorPos = layoutDirection == LayoutDirection.VERTICAL
				? targetElement.getPosition().getX()
				: targetElement.getPosition().getY();
		if (targetSidePos == 0) {
			if (targetPort != null) {
			    KShapeLayout portLayout = KimlLayoutUtil.getShapeLayout(targetPort);
                targetAnchorPos += layoutDirection == LayoutDirection.VERTICAL
						? portLayout.getWidth() / 2
						: portLayout.getHeight() / 2;
				if (targetPort.getNode() != layeredGraph.getParentNode()) {
					targetAnchorPos += layoutDirection == LayoutDirection.VERTICAL
							? portLayout.getXpos()
							: portLayout.getYpos();
				}
			}
		}
		else if (targetSidePos > 0) {
			targetAnchorPos += (layoutDirection == LayoutDirection.VERTICAL
					? targetElement.getRealWidth()
					: targetElement.getRealHeight())
					+ targetSidePos * minDist;
		}
		else if (targetSidePos < 0) {
			targetAnchorPos += targetSidePos * minDist;
		}
		return targetAnchorPos;
	}
	
	/**
	 * Sets the proper position of an endpoint that goes to an external port.
	 * 
	 * @param endpoint endpoint to align
	 * @param portSide side of external port used as endpoint
	 * @param insets insets of the parent layout node
	 */
	private void toExternalEndpoint(KPoint endpoint, PortSide portSide,
	        KInsets insets) {
		switch (portSide) {
		case NORTH:
			endpoint.setY(endpoint.getY() - insets.getTop());
			break;
		case EAST:
			endpoint.setX(endpoint.getX() + insets.getRight());
			break;
		case SOUTH:
			endpoint.setY(endpoint.getY() + insets.getBottom());
			break;
		case WEST:
			endpoint.setX(endpoint.getX() - insets.getLeft());
			break;
		}
	}
	
	/**
	 * Adds or subtracts the width or height of the given endpoint size,
	 * depending on the relative position of the next point.
	 * 
	 * @param endpoint endpoint to align
	 * @param next next point on the edge
	 * @param width width of the endpoint object
	 * @param height height of the endpoint object
	 */
	private void alignEndpoint(KPoint endpoint, KPoint next, float width,
	        float height) {
		if (next.getX() > endpoint.getX())
			endpoint.setX(endpoint.getX() + width / 2);
		else if (next.getY() > endpoint.getY())
			endpoint.setY(endpoint.getY() + height / 2);
		else if (next.getX() < endpoint.getX())
			endpoint.setX(endpoint.getX() - width / 2);
		else if (next.getY() < endpoint.getY())
			endpoint.setY(endpoint.getY() - height / 2);
	}
	
}

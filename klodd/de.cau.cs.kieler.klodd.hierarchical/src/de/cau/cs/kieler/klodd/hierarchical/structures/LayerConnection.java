package de.cau.cs.kieler.klodd.hierarchical.structures;

import java.util.LinkedList;
import java.util.List;

import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KDimension;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutEdge;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KInsets;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KPoint;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutPort;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KPortLayout;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphFactory;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutOption;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KPortPlacement;


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
	private KLayoutEdge edge;
	/** the source element */
	private LayerElement sourceElement;
	/** the source port */
	private KLayoutPort sourcePort;
	/** the target element */
	private LayerElement targetElement;
	/** the target port */
	private KLayoutPort targetPort;

	/**
	 * Creates a layer connection with given source and target.
	 * 
	 * @param edge the edge that is to be contained in this layer connection
	 * @param sourceElem the source element
	 * @param sourcePort the source port
	 * @param targetElem the target element
	 * @param targetPort the target port
	 */
	public LayerConnection(KLayoutEdge edge, LayerElement sourceElem, KLayoutPort sourcePort,
			LayerElement targetElem, KLayoutPort targetPort) {
		this.edge = edge;
		this.sourceElement = sourceElem;
		this.sourcePort = sourcePort;
		this.targetElement = targetElem;
		this.targetPort = targetPort;
		edge.getLayout().getBendPoints().clear();
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
		
		// subtract insets values from bend points near fixed external ports
		boolean subSourceXInset = false, subSourceYInset = false,
			subTargetXInset = false, subTargetYInset = false;
		if (layeredGraph.areExternalPortsFixed()) {
			if (sourcePort != null && sourcePort.getNode() == layeredGraph.getParentGroup()) {
				if (sourcePort.getLayout().getPlacement() == KPortPlacement.NORTH
						|| sourcePort.getLayout().getPlacement() == KPortPlacement.SOUTH) {
					subSourceXInset = true;
				}
				else {
					subSourceYInset = true;
				}
			}
			if (targetPort != null && targetPort.getNode() == layeredGraph.getParentGroup()) {
				if (targetPort.getLayout().getPlacement() == KPortPlacement.NORTH
						|| targetPort.getLayout().getPlacement() == KPortPlacement.SOUTH) {
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
			edge.getLayout().getBendPoints().add(point);
		}
		
		// calculate position of source point
		KPoint sourcePoint = KimlLayoutGraphFactory.eINSTANCE.createKPoint();
		if (sourcePort != null) {
			if (sourcePort.getNode() == layeredGraph.parentNode) {
				sourcePoint.setX(sourceElement.getPosition().getX()
						+ sourcePort.getLayout().getSize().getWidth() / 2);
				if (subSourceXInset) {
					sourcePoint.setX(sourcePoint.getX() - insets.getLeft());
					if (!bendPoints.isEmpty()) {
						KPoint bendPoint = bendPoints.get(0);
						bendPoint.setX(bendPoint.getX() - insets.getLeft());
					}
				}
				sourcePoint.setY(sourceElement.getPosition().getY()
						+ sourcePort.getLayout().getSize().getHeight() / 2);
				if (subSourceYInset) {
					sourcePoint.setY(sourcePoint.getY() - insets.getTop());
					if (!bendPoints.isEmpty()) {
						KPoint bendPoint = bendPoints.get(0);
						bendPoint.setY(bendPoint.getY() - insets.getTop());
					}
				}
				toExternalEndpoint(sourcePoint, sourcePort, insets);
			}
			else {
				sourcePoint.setX(sourcePort.getLayout().getLocation().getX()
						+ sourcePort.getLayout().getSize().getWidth() / 2
						+ sourceElement.getPosition().getX());
				sourcePoint.setY(sourcePort.getLayout().getLocation().getY()
						+ sourcePort.getLayout().getSize().getHeight() / 2
						+ sourceElement.getPosition().getY());
			}
		}
		else {
			sourcePoint.setX(sourceElement.getPosition().getX());
			sourcePoint.setY(sourceElement.getPosition().getY());
		}
		
		// calculate position of target point
		KPoint targetPoint = KimlLayoutGraphFactory.eINSTANCE.createKPoint();
		if (targetPort != null) {
			if (targetPort.getNode() == layeredGraph.parentNode) {
				targetPoint.setX(targetElement.getPosition().getX()
						+ targetPort.getLayout().getSize().getWidth() / 2);
				if (subTargetXInset) {
					targetPoint.setX(targetPoint.getX() - insets.getLeft());
					if (!bendPoints.isEmpty()) {
						KPoint bendPoint = bendPoints.get(bendPoints.size()-1);
						bendPoint.setX(bendPoint.getX() - insets.getLeft());
					}
				}
				targetPoint.setY(targetElement.getPosition().getY()
						+ targetPort.getLayout().getSize().getHeight() / 2);
				if (subTargetYInset) {
					targetPoint.setY(targetPoint.getY() - insets.getTop());
					if (!bendPoints.isEmpty()) {
						KPoint bendPoint = bendPoints.get(bendPoints.size()-1);
						bendPoint.setY(bendPoint.getY() - insets.getTop());
					}
				}
				toExternalEndpoint(targetPoint, targetPort, insets);
			}
			else {
				targetPoint.setX(targetPort.getLayout().getLocation().getX()
						+ targetPort.getLayout().getSize().getWidth() / 2
						+ targetElement.getPosition().getX());
				targetPoint.setY(targetPort.getLayout().getLocation().getY()
						+ targetPort.getLayout().getSize().getHeight() / 2
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
					sourcePort.getLayout().getSize());
			edge.getLayout().setSourcePoint(sourcePoint);
		}
		
		if (targetPort != null) {
			alignEndpoint(targetPoint, bendPoints.isEmpty()
					? sourcePoint : bendPoints.get(bendPoints.size()-1),
					targetPort.getLayout().getSize());
			edge.getLayout().setTargetPoint(targetPoint);
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
	public KLayoutPort getSourcePort() {
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
	public KLayoutPort getTargetPort() {
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
		KLayoutOption layoutDirection = layeredGraph.getLayoutDirection();
		sourceAnchorPos = layoutDirection == KLayoutOption.VERTICAL
				? sourceElement.getPosition().getX()
				: sourceElement.getPosition().getY();
		if (sourceSidePos == 0) {
			if (sourcePort != null) {
				KPortLayout portLayout = sourcePort.getLayout();
				sourceAnchorPos += layoutDirection == KLayoutOption.VERTICAL
						? portLayout.getSize().getWidth() / 2
						: portLayout.getSize().getHeight() / 2;
				if (sourcePort.getNode() != layeredGraph.getParentGroup()) {
					sourceAnchorPos += layoutDirection == KLayoutOption.VERTICAL
							? portLayout.getLocation().getX()
							: portLayout.getLocation().getY();
				}
			}
		}
		else if (sourceSidePos > 0) {
			sourceAnchorPos += (layoutDirection == KLayoutOption.VERTICAL
					? sourceElement.getRealDim().getWidth()
					: sourceElement.getRealDim().getHeight())
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
		KLayoutOption layoutDirection = layeredGraph.getLayoutDirection();
		targetAnchorPos = layoutDirection == KLayoutOption.VERTICAL
				? targetElement.getPosition().getX()
				: targetElement.getPosition().getY();
		if (targetSidePos == 0) {
			if (targetPort != null) {
				KPortLayout portLayout = targetPort.getLayout();
				targetAnchorPos += layoutDirection == KLayoutOption.VERTICAL
						? portLayout.getSize().getWidth() / 2
						: portLayout.getSize().getHeight() / 2;
				if (targetPort.getNode() != layeredGraph.getParentGroup()) {
					targetAnchorPos += layoutDirection == KLayoutOption.VERTICAL
							? portLayout.getLocation().getX()
							: portLayout.getLocation().getY();
				}
			}
		}
		else if (targetSidePos > 0) {
			targetAnchorPos += (layoutDirection == KLayoutOption.VERTICAL
					? targetElement.getRealDim().getWidth()
					: targetElement.getRealDim().getHeight())
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
	 * @param port external port used as endpoint
	 * @param insets insets of the parent layout node
	 */
	private void toExternalEndpoint(KPoint endpoint, KLayoutPort port, KInsets insets) {
		switch (port.getLayout().getPlacement()) {
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
	 * @param size size of the endpoint object
	 */
	private void alignEndpoint(KPoint endpoint, KPoint next, KDimension size) {
		if (next.getX() > endpoint.getX())
			endpoint.setX(endpoint.getX() + size.getWidth() / 2);
		else if (next.getY() > endpoint.getY())
			endpoint.setY(endpoint.getY() + size.getHeight() / 2);
		else if (next.getX() < endpoint.getX())
			endpoint.setX(endpoint.getX() - size.getWidth() / 2);
		else if (next.getY() < endpoint.getY())
			endpoint.setY(endpoint.getY() - size.getHeight() / 2);
	}
	
}

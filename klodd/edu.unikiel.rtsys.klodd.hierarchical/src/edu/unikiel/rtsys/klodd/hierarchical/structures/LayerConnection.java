package edu.unikiel.rtsys.klodd.hierarchical.structures;

import java.util.LinkedList;
import java.util.List;

import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KEdge;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KPoint;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KPort;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KPortLayout;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphFactory;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.LAYOUT_OPTION;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.PORT_PLACEMENT;

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
	public LayerConnection(KEdge edge, LayerElement sourceElem, KPort sourcePort,
			LayerElement targetElem, KPort targetPort) {
		this.edge = edge;
		this.sourceElement = sourceElem;
		this.sourcePort = sourcePort;
		this.targetElement = targetElem;
		this.targetPort = targetPort;
	}

	/**
	 * Creates a layer connection with given source and target.
	 * 
	 * @param edge the edge that is to be contained in this layer connection
	 * @param sourceElem the source element
	 * @param targetElem the target element
	 */
	public LayerConnection(KEdge edge, LayerElement sourceElem, LayerElement targetElem) {
		this(edge, sourceElem, null, targetElem, null);
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
	 */
	public void applyLayout(KPoint offset) {
		LayeredGraph layeredGraph = sourceElement.getLayer().getLayeredGraph();
		
		// don't add offset values to bend points near fixed external ports
		int omitXOffset = -1, omitYOffset = -1;
		boolean fixedSourcePort = false, fixedTargetPort = false;
		if (sourcePort != null && sourcePort.getNodeGroup() == layeredGraph.getParentGroup()
				&& layeredGraph.areExternalPortsFixed()) {
			if (sourcePort.getLayout().getPlacement() == PORT_PLACEMENT.NORTH
					|| sourcePort.getLayout().getPlacement() == PORT_PLACEMENT.SOUTH) {
				omitXOffset = 0;
			}
			else {
				omitYOffset = 0;
			}
			fixedSourcePort = true;
		}
		else if (targetPort != null && targetPort.getNodeGroup() == layeredGraph.getParentGroup()
				&& layeredGraph.areExternalPortsFixed()) {
			if (sourcePort.getLayout().getPlacement() == PORT_PLACEMENT.NORTH
					|| sourcePort.getLayout().getPlacement() == PORT_PLACEMENT.SOUTH) {
				omitXOffset = edge.getLayout().getGridPoints().size()-1;
			}
			else {
				omitYOffset = edge.getLayout().getGridPoints().size()-1;
			}
			fixedTargetPort = true;
		}
		
		// set bend points
		int i = 0;
		for (KPoint point : bendPoints) {
			if (i != omitXOffset)
				point.setX(point.getX() + offset.getX());
			if (i != omitYOffset)
				point.setY(point.getY() + offset.getY());
			edge.getLayout().getGridPoints().add(point);
			i++;
		}
		
		// set start and end points
		if (sourcePort != null) {
			KPoint point = KimlLayoutGraphFactory.eINSTANCE.createKPoint();
			if (sourcePort.getNodeGroup() == layeredGraph.parentGroup) {
				point.setX(sourceElement.getPosition().getX()
						+ sourcePort.getLayout().getSize().getWidth() / 2);
				point.setY(sourceElement.getPosition().getY()
						+ sourcePort.getLayout().getSize().getHeight() / 2);
			}
			else {
				point.setX(sourcePort.getLayout().getLocation().getX()
						+ sourcePort.getLayout().getSize().getWidth() / 2
						+ sourceElement.getPosition().getX());
				point.setY(sourcePort.getLayout().getLocation().getY()
						+ sourcePort.getLayout().getSize().getHeight() / 2
						+ sourceElement.getPosition().getY());
			}
			if (!fixedSourcePort) {
				point.setX(point.getX() + offset.getX());
				point.setY(point.getY() + offset.getY());
			}
			edge.getLayout().setSourcePoint(point);
		}
		if (targetPort != null) {
			KPoint point = KimlLayoutGraphFactory.eINSTANCE.createKPoint();
			if (targetPort.getNodeGroup() == layeredGraph.parentGroup) {
				point.setX(targetElement.getPosition().getX()
						+ targetPort.getLayout().getSize().getWidth() / 2);
				point.setY(targetElement.getPosition().getY()
						+ targetPort.getLayout().getSize().getHeight() / 2);
			}
			else {
				point.setX(targetPort.getLayout().getLocation().getX()
						+ targetPort.getLayout().getSize().getWidth() / 2
						+ targetElement.getPosition().getX());
				point.setY(targetPort.getLayout().getLocation().getY()
						+ targetPort.getLayout().getSize().getHeight() / 2
						+ targetElement.getPosition().getY());
			}
			if (!fixedTargetPort) {
				point.setX(point.getX() + offset.getX());
				point.setY(point.getY() + offset.getY());
			}
			edge.getLayout().setTargetPoint(point);
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
		LAYOUT_OPTION layoutDirection = layeredGraph.getLayoutDirection();
		sourceAnchorPos = layoutDirection == LAYOUT_OPTION.VERTICAL
				? sourceElement.getPosition().getX()
				: sourceElement.getPosition().getY();
		if (sourceSidePos == 0) {
			if (sourcePort != null) {
				KPortLayout portLayout = sourcePort.getLayout();
				sourceAnchorPos += layoutDirection == LAYOUT_OPTION.VERTICAL
						? portLayout.getSize().getWidth() / 2
						: portLayout.getSize().getHeight() / 2;
				if (sourcePort.getNodeGroup() != layeredGraph.getParentGroup()) {
					sourceAnchorPos += layoutDirection == LAYOUT_OPTION.VERTICAL
							? portLayout.getLocation().getX()
							: portLayout.getLocation().getY();
				}
			}
		}
		else if (sourceSidePos > 0) {
			sourceAnchorPos += (layoutDirection == LAYOUT_OPTION.VERTICAL
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
		LAYOUT_OPTION layoutDirection = layeredGraph.getLayoutDirection();
		targetAnchorPos = layoutDirection == LAYOUT_OPTION.VERTICAL
				? targetElement.getPosition().getX()
				: targetElement.getPosition().getY();
		if (targetSidePos == 0) {
			if (targetPort != null) {
				KPortLayout portLayout = targetPort.getLayout();
				targetAnchorPos += layoutDirection == LAYOUT_OPTION.VERTICAL
						? portLayout.getSize().getWidth() / 2
						: portLayout.getSize().getHeight() / 2;
				if (targetPort.getNodeGroup() != layeredGraph.getParentGroup()) {
					targetAnchorPos += layoutDirection == LAYOUT_OPTION.VERTICAL
							? portLayout.getLocation().getX()
							: portLayout.getLocation().getY();
				}
			}
		}
		else if (targetSidePos > 0) {
			targetAnchorPos += (layoutDirection == LAYOUT_OPTION.VERTICAL
					? targetElement.getRealDim().getWidth()
					: targetElement.getRealDim().getHeight())
					+ targetSidePos * minDist;
		}
		else if (targetSidePos < 0) {
			targetAnchorPos += targetSidePos * minDist;
		}
		return targetAnchorPos;
	}
	
}

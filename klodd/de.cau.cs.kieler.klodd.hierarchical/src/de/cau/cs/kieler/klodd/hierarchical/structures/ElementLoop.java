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

import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutEdge;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KPoint;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutPort;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphFactory;


/**
 * Loop over a single layer element in a layered graph.
 * 
 * @author msp
 */
public class ElementLoop {
	
	/** routing position at north side */
	public int northRoutePos = 0;
	/** routing position at east side */
	public int eastRoutePos = 0;
	/** routing position at south side */
	public int southRoutePos = 0;
	/** routing position at west side */
	public int westRoutePos = 0;
	/** list of bend points of this connection */
	public List<KPoint> bendPoints = new LinkedList<KPoint>();
	
	/** the contained edge object */
	private KLayoutEdge edge;
	/** the layer element */
	private LayerElement element;
	/** the source port */
	private KLayoutPort sourcePort;
	/** the target port */
	private KLayoutPort targetPort;
	
	/**
	 * Creates an element loop with given source and target port.
	 * 
	 * @param edge the edge that is to be contained in this element loop
	 * @param elem the layer element of this loop
	 * @param sourcePort the source port
	 * @param targetPort the target port
	 */
	public ElementLoop(KLayoutEdge edge, LayerElement elem, KLayoutPort sourcePort,
			KLayoutPort targetPort) {
		this.edge = edge;
		this.element = elem;
		this.sourcePort = sourcePort;
		this.targetPort = targetPort;
		edge.getLayout().getBendPoints().clear();
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "[" + element.toString() + "] > [" + element.toString() + "]";
	}

	/**
	 * Gets the source port of this element loop.
	 * 
	 * @return the source port
	 */
	public KLayoutPort getSourcePort() {
		return sourcePort;
	}

	/**
	 * Gets the target port of this element loop.
	 * 
	 * @return the target port
	 */
	public KLayoutPort getTargetPort() {
		return targetPort;
	}
	
	/**
	 * Applies the layout of this element loop to the contained edge.
	 * 
	 * @param offset offset to be added to each bend point
	 */
	public void applyLayout(KPoint offset) {
		// set bend points
		for (KPoint point : bendPoints) {
			point.setX(point.getX() + offset.getX());
			point.setY(point.getY() + offset.getY());
			edge.getLayout().getBendPoints().add(point);
		}
		
		// set start and end points
		if (sourcePort != null) {
			KPoint point = KimlLayoutGraphFactory.eINSTANCE.createKPoint();
			point.setX(sourcePort.getLayout().getLocation().getX()
					+ sourcePort.getLayout().getSize().getWidth() / 2
					+ element.getPosition().getX());
			point.setY(sourcePort.getLayout().getLocation().getY()
					+ sourcePort.getLayout().getSize().getHeight() / 2
					+ element.getPosition().getY());
			edge.getLayout().setSourcePoint(point);
		}
		if (targetPort != null) {
			KPoint point = KimlLayoutGraphFactory.eINSTANCE.createKPoint();
			point.setX(targetPort.getLayout().getLocation().getX()
					+ targetPort.getLayout().getSize().getWidth() / 2
					+ element.getPosition().getX());
			point.setY(targetPort.getLayout().getLocation().getY()
					+ targetPort.getLayout().getSize().getHeight() / 2
					+ element.getPosition().getY());
			edge.getLayout().setTargetPoint(point);
		}
	}

}

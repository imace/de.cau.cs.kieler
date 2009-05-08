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
import de.cau.cs.kieler.kiml.layout.klayoutdata.KLayoutDataFactory;
import de.cau.cs.kieler.kiml.layout.klayoutdata.KPoint;
import de.cau.cs.kieler.kiml.layout.klayoutdata.KShapeLayout;
import de.cau.cs.kieler.kiml.layout.util.KimlLayoutUtil;


/**
 * Loop over a single layer element in a layered graph.
 * 
 * @author <a href="mailto:msp@informatik.uni-kiel.de">Miro Sp&ouml;nemann</a>
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
	private KEdge edge;
	/** the layer element */
	private LayerElement element;
	/** the source port */
	private KPort sourcePort;
	/** the target port */
	private KPort targetPort;
	
	/**
	 * Creates an element loop with given source and target port.
	 * 
	 * @param edge the edge that is to be contained in this element loop
	 * @param elem the layer element of this loop
	 * @param sourcePort the source port
	 * @param targetPort the target port
	 */
	public ElementLoop(KEdge edge, LayerElement elem, KPort sourcePort,
			KPort targetPort) {
		this.edge = edge;
		this.element = elem;
		this.sourcePort = sourcePort;
		this.targetPort = targetPort;
		KimlLayoutUtil.getEdgeLayout(edge).getBendPoints().clear();
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
	public KPort getSourcePort() {
		return sourcePort;
	}

	/**
	 * Gets the target port of this element loop.
	 * 
	 * @return the target port
	 */
	public KPort getTargetPort() {
		return targetPort;
	}
	
	/**
	 * Applies the layout of this element loop to the contained edge.
	 * 
	 * @param offset offset to be added to each bend point
	 */
	public void applyLayout(KPoint offset) {
	    KShapeLayout sourcePortLayout = KimlLayoutUtil.getShapeLayout(sourcePort);
        KShapeLayout targetPortLayout = KimlLayoutUtil.getShapeLayout(targetPort);
        KEdgeLayout edgeLayout = KimlLayoutUtil.getEdgeLayout(edge);
        
        // set bend points
		for (KPoint point : bendPoints) {
			point.setX(point.getX() + offset.getX());
			point.setY(point.getY() + offset.getY());
			edgeLayout.getBendPoints().add(point);
		}
		
		// set start and end points
		float xbase = element.getPosition().getX() + element.getPosOffset().getX();
		float ybase = element.getPosition().getY() + element.getPosOffset().getY();
		if (sourcePort != null) {
			KPoint point = KLayoutDataFactory.eINSTANCE.createKPoint();
			point.setX(sourcePortLayout.getXpos()
					+ sourcePortLayout.getWidth() / 2 + xbase);
			point.setY(sourcePortLayout.getYpos()
					+ sourcePortLayout.getHeight() / 2 + ybase);
			edgeLayout.setSourcePoint(point);
		}
		if (targetPort != null) {
			KPoint point = KLayoutDataFactory.eINSTANCE.createKPoint();
			point.setX(targetPortLayout.getXpos()
					+ targetPortLayout.getWidth() / 2 + xbase);
			point.setY(targetPortLayout.getYpos()
					+ targetPortLayout.getHeight() / 2 + ybase);
			edgeLayout.setTargetPoint(point);
		}
	}

}

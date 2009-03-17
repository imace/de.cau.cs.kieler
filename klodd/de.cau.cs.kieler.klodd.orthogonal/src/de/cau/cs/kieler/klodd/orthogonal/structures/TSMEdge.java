/******************************************************************************
 * KIELER - Kiel Integrated Environment for Layout for the Eclipse RCP
 *
 * http://www.informatik.uni-kiel.de/rtsys/kieler/
 * 
 * Copyright 2009 by
 * + Christian-Albrechts-University of Kiel
 *   + Department of Computer Science
 *     + Real-Time and Embedded Systems Group
 * 
 * This code is provided under the terms of the Eclipse Public License (EPL).
 * See the file epl-v10.html for the license text.
 */
package de.cau.cs.kieler.klodd.orthogonal.structures;

import java.util.List;

import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutEdge;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KPoint;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphFactory;
import de.cau.cs.kieler.core.slimgraph.*;

/**
 * An edge in the graph structure used for the topology-shape-metrics
 * approach.
 * 
 * @author msp
 */
public class TSMEdge extends KSlimEdge {

	/** layout graph edge contained in this TSM edge, or null if there is none */
	public KLayoutEdge layoutEdge;
	/** the previous edge of a split edge */
	public TSMEdge previousEdge;
	/** the next edge of a split edge */
	public TSMEdge nextEdge;
	
	/**
	 * Creates an edge connecting two existing nodes, with a layout graph
	 * edge as reference.
	 * 
	 * @param graph the graph to which the new edge shall be added
	 * @param source source node
	 * @param target target node
	 * @param layoutEdge the layout graph edge to be contained
	 */
	public TSMEdge(KSlimGraph graph, KSlimNode source, KSlimNode target,
			KLayoutEdge layoutEdge) {
		super(graph, source, target);
		this.layoutEdge = layoutEdge;
	}
	
	/**
	 * Creates an edge connecting two existing nodes.
	 * 
	 * @param graph the graph to which the new edge shall be added
	 * @param source source node
	 * @param target target node
	 */
	public TSMEdge(KSlimGraph graph, KSlimNode source, KSlimNode target) {
		super(graph, source, target);
	}
	
	/**
	 * Applies the layout to the original layout edge.
	 * 
	 * @param offsetX x offset to be added
	 * @param offsetY y offset to be added
	 */
	public void applyLayout(float offsetX, float offsetY) {
		// find the first edge in a series of edges
		TSMEdge currentEdge = this;
		while (currentEdge.previousEdge != null)
			currentEdge = currentEdge.previousEdge;
		TSMEdge firstEdge = currentEdge, lastEdge;
		
		// add all bend points of the edge
		List<KPoint> bendPoints = layoutEdge.getLayout().getBendPoints();
		bendPoints.clear();
		do {
			for (Bend bend : currentEdge.bends) {
				KPoint newPoint = KimlLayoutGraphFactory.eINSTANCE.createKPoint();
				newPoint.setX(bend.xpos + offsetX);
				newPoint.setY(bend.ypos + offsetY);
				bendPoints.add(newPoint);
			}
			lastEdge = currentEdge;
			// mark the edge as visited
			currentEdge.rank = 1;
			currentEdge = currentEdge.nextEdge;
		} while (currentEdge != null);
		
		// set start point
		KPoint newPoint = KimlLayoutGraphFactory.eINSTANCE.createKPoint();
		float xpos = layoutEdge.getSource().getLayout().getLocation().getX()
				+ layoutEdge.getSourcePort().getLayout().getLocation().getX();
		float ypos = layoutEdge.getSource().getLayout().getLocation().getY()
				+ layoutEdge.getSourcePort().getLayout().getLocation().getY();
		switch (firstEdge.sourceSide) {
		case NORTH:
			xpos += layoutEdge.getSourcePort().getLayout().getSize().getWidth() / 2;
			break;
		case EAST:
			xpos += layoutEdge.getSourcePort().getLayout().getSize().getWidth();
			ypos += layoutEdge.getSourcePort().getLayout().getSize().getHeight() / 2;
			break;
		case SOUTH:
			xpos += layoutEdge.getSourcePort().getLayout().getSize().getWidth() / 2;
			ypos += layoutEdge.getSourcePort().getLayout().getSize().getHeight();
			break;
		case WEST:
			ypos += layoutEdge.getSourcePort().getLayout().getSize().getHeight() / 2;
			break;
		}
		newPoint.setX(xpos);
		newPoint.setY(ypos);
		layoutEdge.getLayout().setSourcePoint(newPoint);
		
		// set end point
		newPoint = KimlLayoutGraphFactory.eINSTANCE.createKPoint();
		xpos = layoutEdge.getTarget().getLayout().getLocation().getX()
				+ layoutEdge.getTargetPort().getLayout().getLocation().getX();
		ypos = layoutEdge.getTarget().getLayout().getLocation().getY()
				+ layoutEdge.getTargetPort().getLayout().getLocation().getY();
		switch (lastEdge.targetSide) {
		case NORTH:
			xpos += layoutEdge.getTargetPort().getLayout().getSize().getWidth() / 2;
			break;
		case EAST:
			xpos += layoutEdge.getTargetPort().getLayout().getSize().getWidth();
			ypos += layoutEdge.getTargetPort().getLayout().getSize().getHeight() / 2;
			break;
		case SOUTH:
			xpos += layoutEdge.getTargetPort().getLayout().getSize().getWidth() / 2;
			ypos += layoutEdge.getTargetPort().getLayout().getSize().getHeight();
			break;
		case WEST:
			ypos += layoutEdge.getTargetPort().getLayout().getSize().getHeight() / 2;
			break;
		}
		newPoint.setX(xpos);
		newPoint.setY(ypos);
		layoutEdge.getLayout().setTargetPoint(newPoint);
	}
	
}

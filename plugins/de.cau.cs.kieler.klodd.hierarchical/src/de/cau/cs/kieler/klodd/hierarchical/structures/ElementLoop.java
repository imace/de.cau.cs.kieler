/*
 * KIELER - Kiel Integrated Environment for Layout Eclipse RichClient
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
import de.cau.cs.kieler.kiml.layout.options.PortSide;
import de.cau.cs.kieler.kiml.layout.util.KimlLayoutUtil;

/**
 * Loop over a single layer element in a layered graph.
 * 
 * @author <a href="mailto:msp@informatik.uni-kiel.de">Miro Sp&ouml;nemann</a>
 */
public class ElementLoop {

    /** routing position at north side. */
    private int northRoutePos = 0;
    /** routing position at east side. */
    private int eastRoutePos = 0;
    /** routing position at south side. */
    private int southRoutePos = 0;
    /** routing position at west side. */
    private int westRoutePos = 0;
    /** list of bend points of this connection. */
    private List<KPoint> bendPoints = new LinkedList<KPoint>();
    /** the contained edge object. */
    private KEdge edge;
    /** the layer element. */
    private LayerElement element;
    /** the source port. */
    private KPort sourcePort;
    /** the target port. */
    private KPort targetPort;

    /**
     * Creates an element loop with given source and target port.
     * 
     * @param theedge the edge that is to be contained in this element loop
     * @param elem the layer element of this loop
     * @param thesourcePort the source port
     * @param thetargetPort the target port
     */
    public ElementLoop(final KEdge theedge, final LayerElement elem, final KPort thesourcePort,
            final KPort thetargetPort) {
        this.edge = theedge;
        this.element = elem;
        this.sourcePort = thesourcePort;
        this.targetPort = thetargetPort;
        KimlLayoutUtil.getEdgeLayout(theedge).getBendPoints().clear();
    }

    /**
     * {@inheritDoc}
     */
    @Override
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
    public void applyLayout(final KPoint offset) {
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
            float sourcePortWidth = sourcePortLayout.getWidth();
            float sourcePortHeight = sourcePortLayout.getHeight();
            point.setX(sourcePortLayout.getXpos() + sourcePortWidth / 2 + xbase);
            point.setY(sourcePortLayout.getYpos() + sourcePortHeight / 2 + ybase);
            alignEndpoint(point, edgeLayout.getBendPoints().get(0), sourcePortWidth, sourcePortHeight);
            edgeLayout.setSourcePoint(point);
        }
        if (targetPort != null) {
            KPoint point = KLayoutDataFactory.eINSTANCE.createKPoint();
            float targetPortWidth = targetPortLayout.getWidth();
            float targetPortHeight = targetPortLayout.getHeight();
            point.setX(targetPortLayout.getXpos() + targetPortWidth / 2 + xbase);
            point.setY(targetPortLayout.getYpos() + targetPortHeight / 2 + ybase);
            alignEndpoint(point, edgeLayout.getBendPoints().get(edgeLayout.getBendPoints().size() - 1),
                    targetPortWidth, targetPortHeight);
            edgeLayout.setTargetPoint(point);
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
    private void alignEndpoint(final KPoint endpoint, final KPoint next, final float width,
            final float height) {
        if (next.getX() > endpoint.getX()) {
            endpoint.setX(endpoint.getX() + width / 2);
        } else if (next.getY() > endpoint.getY()) {
            endpoint.setY(endpoint.getY() + height / 2);
        } else if (next.getX() < endpoint.getX()) {
            endpoint.setX(endpoint.getX() - width / 2);
        } else if (next.getY() < endpoint.getY()) {
            endpoint.setY(endpoint.getY() - height / 2);
        }
    }

    /**
     * Returns the bendPoints.
     *
     * @return the bendPoints
     */
    public List<KPoint> getBendPoints() {
        return bendPoints;
    }
    
    /**
     * Sets the route position for a specific side.
     * 
     * @param routePos the route position to set
     * @param side the side for the route position
     */
    public void setRoutePos(final int routePos, final PortSide side) {
        switch (side) {
        case NORTH:
            this.northRoutePos = routePos;
            break;
        case EAST:
            this.eastRoutePos = routePos;
            break;
        case SOUTH:
            this.southRoutePos = routePos;
            break;
        case WEST:
            this.westRoutePos = routePos;
            break;
        }
    }
    
    /**
     * Gets the route position for a specific side.
     * 
     * @param side the side for the route position
     * @return the route position for the given side
     */
    public int getRoutePos(final PortSide side) {
        switch (side) {
        case NORTH:
            return northRoutePos;
        case EAST:
            return eastRoutePos;
        case SOUTH:
            return southRoutePos;
        case WEST:
            return westRoutePos;
        }
        return 0;
    }

}

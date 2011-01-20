/*
 * KIELER - Kiel Integrated Environment for Layout Eclipse RichClient
 *
 * http://www.informatik.uni-kiel.de/rtsys/kieler/
 * 
 * Copyright 2011 by
 * + Christian-Albrechts-University of Kiel
 *   + Department of Computer Science
 *     + Real-Time and Embedded Systems Group
 * 
 * This code is provided under the terms of the Eclipse Public License (EPL).
 * See the file epl-v10.html for the license text.
 */
package de.cau.cs.kieler.kiml.graphiti;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.impl.LayoutContext;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.pictograms.BoxRelativeAnchor;
import org.eclipse.graphiti.mm.pictograms.ChopboxAnchor;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.mm.pictograms.FreeFormConnection;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;

import de.cau.cs.kieler.core.kgraph.KEdge;
import de.cau.cs.kieler.core.kgraph.KGraphElement;
import de.cau.cs.kieler.core.kgraph.KLabel;
import de.cau.cs.kieler.core.kgraph.KNode;
import de.cau.cs.kieler.core.kgraph.KPort;
import de.cau.cs.kieler.core.math.KVector;
import de.cau.cs.kieler.core.math.KVectorChain;
import de.cau.cs.kieler.core.util.Pair;
import de.cau.cs.kieler.kiml.klayoutdata.KEdgeLayout;
import de.cau.cs.kieler.kiml.klayoutdata.KPoint;
import de.cau.cs.kieler.kiml.klayoutdata.KShapeLayout;
import de.cau.cs.kieler.kiml.util.KimlUtil;

/**
 * A command for applying the result of automatic layout to a Graphiti diagram.
 * 
 * @author msp
 */
public class GraphitiLayoutCommand extends RecordingCommand {

    /** list of graph elements and pictogram elements to layout. */
    private List<Pair<KGraphElement, PictogramElement>> elements =
            new LinkedList<Pair<KGraphElement, PictogramElement>>();
    /** the feature provider for layout support. */
    private IFeatureProvider featureProvider;
    /** map of edge layouts to corresponding vector chains. */
    private Map<KEdgeLayout, KVectorChain> bendpointsMap =
            new HashMap<KEdgeLayout, KVectorChain>();

    /**
     * Creates a Graphiti layout command.
     * 
     * @param domain
     *            the transactional editing domain
     * @param thefeatureProvider
     *            the feature provider
     */
    public GraphitiLayoutCommand(final TransactionalEditingDomain domain,
            final IFeatureProvider thefeatureProvider) {
        super(domain, "Automatic Layout");
        this.featureProvider = thefeatureProvider;
    }

    /**
     * Adds the given element to this command.
     * 
     * @param graphElement
     *            an element of the layout graph
     * @param pictogramElement
     *            the corresponding pictogram element
     */
    public void add(final KGraphElement graphElement,
            final PictogramElement pictogramElement) {
        elements.add(new Pair<KGraphElement, PictogramElement>(graphElement,
                pictogramElement));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void doExecute() {
        for (Pair<KGraphElement, PictogramElement> entry : elements) {
            KGraphElement element = entry.getFirst();
            if (element instanceof KPort) {
                applyPortLayout((KPort) element, entry.getSecond());
            } else if (element instanceof KNode) {
                applyNodeLayout((KNode) element, entry.getSecond());
            } else if (element instanceof KEdge) {
                applyEdgeLayout((KEdge) element, entry.getSecond());
            } else if (element instanceof KLabel
                    && ((KLabel) element).getParent() instanceof KEdge) {
                applyEdgeLabelLayout((KLabel) element, entry.getSecond());
            }
        }
        bendpointsMap.clear();
    }

    /**
     * Apply layout for a port.
     * 
     * @param kport
     *            a port
     * @param pelem
     *            the corresponding pictogram element
     */
    private void
            applyPortLayout(final KPort kport, final PictogramElement pelem) {
        KShapeLayout shapeLayout = kport.getData(KShapeLayout.class);
        if (pelem instanceof BoxRelativeAnchor) {
            BoxRelativeAnchor anchor = (BoxRelativeAnchor) pelem;
            GraphicsAlgorithm ga = anchor.getReferencedGraphicsAlgorithm();
            double parentWidth = ga.getWidth();
            double parentHeight = ga.getHeight();
            double offsetx = anchor.getGraphicsAlgorithm().getX() + ga.getX();
            double offsety = anchor.getGraphicsAlgorithm().getY() + ga.getY();
            double x = shapeLayout.getXpos();
            double y = shapeLayout.getYpos();
            double relWidth = (x - offsetx) / parentWidth;
            double relHeight = (y - offsety) / parentHeight;

            anchor.setRelativeWidth(relWidth);
            anchor.setRelativeHeight(relHeight);

            featureProvider.layoutIfPossible(new LayoutContext(pelem));
        }
    }

    /**
     * Apply layout for a node.
     * 
     * @param knode
     *            a node
     * @param pelem
     *            the corresponding pictogram element
     */
    private void
            applyNodeLayout(final KNode knode, final PictogramElement pelem) {
        KShapeLayout shapeLayout = knode.getData(KShapeLayout.class);
        GraphicsAlgorithm ga = pelem.getGraphicsAlgorithm();
        ga.setX(Math.round(shapeLayout.getXpos()));
        ga.setY(Math.round(shapeLayout.getYpos()));
        ga.setHeight(Math.round(shapeLayout.getHeight()));
        ga.setWidth(Math.round(shapeLayout.getWidth()));
        featureProvider.layoutIfPossible(new LayoutContext(pelem));
    }

    /**
     * Apply layout for an edge.
     * 
     * @param kedge
     *            an edge
     * @param pelem
     *            the corresponding pictogram element
     */
    private void
            applyEdgeLayout(final KEdge kedge, final PictogramElement pelem) {
        KEdgeLayout edgeLayout = kedge.getData(KEdgeLayout.class);
        FreeFormConnection conn = (FreeFormConnection) pelem;
        List<org.eclipse.graphiti.mm.algorithms.styles.Point> pointList =
                conn.getBendpoints();
        pointList.clear();

        // determine the offset for all bend points
        KNode parent = kedge.getSource();
        if (!KimlUtil.isDescendant(kedge.getTarget(), parent)) {
            parent = parent.getParent();
        }
        KVector offset = new KVector();
        KimlUtil.toAbsolute(offset, parent);

        // gather the bend points of the edge
        List<KPoint> allPoints =
                new ArrayList<KPoint>(edgeLayout.getBendPoints().size() + 2);
        if (conn.getStart() instanceof ChopboxAnchor) {
            allPoints.add(edgeLayout.getSourcePoint());
            moveBendpointOutofNode(kedge.getSource(), allPoints.get(0), offset);
        } else if (conn.getStart() instanceof BoxRelativeAnchor) {
            allPoints.add(edgeLayout.getSourcePoint());
            fixFirstBendPoint(edgeLayout.getSourcePoint(),
                    (BoxRelativeAnchor) conn.getStart());
        }
        allPoints.addAll(edgeLayout.getBendPoints());
        if (conn.getEnd() instanceof ChopboxAnchor) {
            allPoints.add(edgeLayout.getTargetPoint());
            moveBendpointOutofNode(kedge.getTarget(),
                    allPoints.get(allPoints.size() - 1), offset);
        }

        // add the bend points to the connection
        for (KPoint kpoint : allPoints) {
            org.eclipse.graphiti.mm.algorithms.styles.Point point =
                    Graphiti.getGaService().createPoint(
                            (int) Math.round(kpoint.getX() + offset.x),
                            (int) Math.round(kpoint.getY() + offset.y));
            pointList.add(point);
        }
    }

    /**
     * moves the first bend point back onto the edge of the port.
     * 
     * @param sourcePoint
     *            the point to move
     * @param start
     *            the port
     */
    private void fixFirstBendPoint(final KPoint sourcePoint,
            final BoxRelativeAnchor start) {
        // undo port center trickery
        if (start.getRelativeWidth() == 0) {
            sourcePoint.setX(sourcePoint.getX()
                    - start.getGraphicsAlgorithm().getX());
        } else if (start.getRelativeWidth() == 1) {
            sourcePoint.setX(sourcePoint.getX()
                    + start.getGraphicsAlgorithm().getX());
        }
        if (start.getRelativeHeight() == 0) {
            sourcePoint.setY(sourcePoint.getY()
                    - start.getGraphicsAlgorithm().getY());
        } else if (start.getRelativeHeight() == 1) {
            sourcePoint.setY(sourcePoint.getY()
                    + start.getGraphicsAlgorithm().getY());
        }
    }

    /** how much to move bend points out of the source or target node. */
    private static final float ENDPOINT_MOVE = 2.0f;

    /**
     * Move the given bend point out of the node in order to approximate a
     * source or target point for chopbox anchors.
     * 
     * @param node
     *            the node that contains the anchor
     * @param point
     *            the bend point to move
     * @param offset
     *            the vector by which to move the bendpoint
     */
    private void moveBendpointOutofNode(final KNode node, final KPoint point,
            final KVector offset) {
        KShapeLayout nodeLayout = node.getData(KShapeLayout.class);
        KVector relPos =
                new KVector(point.getX() + offset.x, point.getY() + offset.y);
        KimlUtil.toRelative(relPos, node);
        float widthPercent = (float) relPos.x / nodeLayout.getWidth();
        float heightPercent = (float) relPos.y / nodeLayout.getHeight();
        if (widthPercent + heightPercent <= 1
                && widthPercent - heightPercent <= 0) {
            // bend point is put to the left
            point.setX(point.getX() - ENDPOINT_MOVE);
        } else if (widthPercent + heightPercent >= 1
                && widthPercent - heightPercent >= 0) {
            // bend point is put to the right
            point.setX(point.getX() + ENDPOINT_MOVE);
        } else if (heightPercent < 1.0f / 2) {
            // bend point is put to the top
            point.setY(point.getY() - ENDPOINT_MOVE);
        } else {
            // bend point is put to the bottom
            point.setY(point.getY() + ENDPOINT_MOVE);
        }
    }

    /**
     * Apply layout for an edge label.
     * 
     * @param klabel
     *            an edge label
     * @param pelem
     *            the corresponding pictogram element
     */
    private void applyEdgeLabelLayout(final KLabel klabel,
            final PictogramElement pelem) {
        GraphicsAlgorithm ga = pelem.getGraphicsAlgorithm();
        ConnectionDecorator decorator = (ConnectionDecorator) pelem;
        KEdge kedge = (KEdge) klabel.getParent();

        // get vector chain for the bend points of the edge
        KEdgeLayout edgeLayout = kedge.getData(KEdgeLayout.class);
        KVectorChain bendPoints = bendpointsMap.get(edgeLayout);
        if (bendPoints == null) {
            bendPoints = KimlUtil.toVectorChain(edgeLayout);
            bendpointsMap.put(edgeLayout, bendPoints);
        }

        // calculate reference point for the label
        KVector referencePoint;
        if (decorator.isLocationRelative()) {
            referencePoint =
                    bendPoints.getPointOnLine(decorator.getLocation()
                            * bendPoints.getLength());
        } else {
            referencePoint = bendPoints.getPointOnLine(decorator.getLocation());
        }

        KShapeLayout shapeLayout = klabel.getData(KShapeLayout.class);
        ga.setX((int) Math.round(shapeLayout.getXpos() - referencePoint.x));
        ga.setY((int) Math.round(shapeLayout.getYpos() - referencePoint.y));
    }

}

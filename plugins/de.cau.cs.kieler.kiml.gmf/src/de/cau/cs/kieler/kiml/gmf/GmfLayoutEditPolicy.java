/*
 * KIELER - Kiel Integrated Environment for Layout Eclipse RichClient
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
 * 
 *****************************************************************************/
package de.cau.cs.kieler.kiml.gmf;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.ConnectionLocator;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.PrecisionPoint;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.AbstractEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.INodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.LabelEditPart;
import org.eclipse.gmf.runtime.draw2d.ui.geometry.LineSeg;
import org.eclipse.gmf.runtime.draw2d.ui.geometry.PointListUtilities;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.gef.ui.figures.SlidableAnchor;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.preference.IPreferenceStore;

import de.cau.cs.kieler.core.kgraph.KEdge;
import de.cau.cs.kieler.core.kgraph.KGraphElement;
import de.cau.cs.kieler.core.kgraph.KLabel;
import de.cau.cs.kieler.core.kgraph.KNode;
import de.cau.cs.kieler.core.kgraph.KPort;
import de.cau.cs.kieler.core.math.KVector;
import de.cau.cs.kieler.core.ui.figures.SplineConnection;
import de.cau.cs.kieler.core.ui.util.SplineUtilities;
import de.cau.cs.kieler.core.util.Pair;
import de.cau.cs.kieler.kiml.klayoutdata.KEdgeLayout;
import de.cau.cs.kieler.kiml.klayoutdata.KInsets;
import de.cau.cs.kieler.kiml.klayoutdata.KPoint;
import de.cau.cs.kieler.kiml.klayoutdata.KShapeLayout;
import de.cau.cs.kieler.kiml.options.EdgeLabelPlacement;
import de.cau.cs.kieler.kiml.options.EdgeRouting;
import de.cau.cs.kieler.kiml.options.LayoutOptions;
import de.cau.cs.kieler.kiml.ui.KimlUiPlugin;
import de.cau.cs.kieler.kiml.ui.Messages;
import de.cau.cs.kieler.kiml.ui.layout.ApplyLayoutRequest;
import de.cau.cs.kieler.kiml.ui.layout.EclipseLayoutServices;
import de.cau.cs.kieler.kiml.util.KimlUtil;

/**
 * Edit policy used to apply layout. This edit policy creates a {@link GmfLayoutCommand} to directly
 * manipulate layout data in the GMF notation model.
 * 
 * @kieler.rating 2009-12-11 proposed yellow msp
 * @author msp
 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.XYLayoutEditPolicy
 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.ConnectionBendpointEditPolicy
 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.GraphicalNodeEditPolicy
 */
public class GmfLayoutEditPolicy extends AbstractEditPolicy {

    /** map of edge layouts to existing point lists. */
    private Map<KEdgeLayout, PointList> pointListMap = new HashMap<KEdgeLayout, PointList>();

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean understandsRequest(final Request req) {
        return (ApplyLayoutRequest.REQ_APPLY_LAYOUT.equals(req.getType()));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Command getCommand(final Request request) {
        if (ApplyLayoutRequest.REQ_APPLY_LAYOUT.equals(request.getType())) {
            if (request instanceof ApplyLayoutRequest) {
                ApplyLayoutRequest layoutRequest = (ApplyLayoutRequest) request;
                IGraphicalEditPart hostEditPart = (IGraphicalEditPart) getHost();
                GmfLayoutCommand command = new GmfLayoutCommand(hostEditPart.getEditingDomain(),
                        Messages.getString("kiml.ui.5"), //$NON-NLS-1$
                        new EObjectAdapter((View) hostEditPart.getModel()));
                float xbound = layoutRequest.getXBound();
                float ybound = layoutRequest.getYBound();

                // retrieve layout data from the request and compute layout data
                // for the command
                for (Pair<KGraphElement, GraphicalEditPart> layoutPair : layoutRequest
                        .getElements()) {
                    if (layoutPair.getFirst() instanceof KNode) {
                        addShapeLayout(command, layoutPair.getFirst(), layoutPair.getSecond(), null);
                    } else if (layoutPair.getFirst() instanceof KPort) {
                        addShapeLayout(
                                command,
                                layoutPair.getFirst(),
                                layoutPair.getSecond(),
                                ((KPort) layoutPair.getFirst()).getNode().getData(
                                        KShapeLayout.class));
                    } else if (layoutPair.getFirst() instanceof KEdge) {
                        addEdgeLayout(command, (KEdge) layoutPair.getFirst(),
                                (ConnectionEditPart) layoutPair.getSecond());
                    } else if (layoutPair.getFirst() instanceof KLabel) {
                        addEdgeLabelLayout(command, (KLabel) layoutPair.getFirst(),
                                (LabelEditPart) layoutPair.getSecond(), xbound, ybound);
                    }
                }

                // set further options
                IPreferenceStore preferenceStore = KimlUiPlugin.getDefault().getPreferenceStore();
                command.setObliqueRouting(preferenceStore
                        .getBoolean(EclipseLayoutServices.PREF_OBLIQUE_ROUTE));

                pointListMap.clear();
                return new ICommandProxy(command);
            } else {
                return null;
            }
        } else {
            return super.getCommand(request);
        }
    }

    /**
     * Adds a shape layout to the given command.
     * 
     * @param command
     *            command to which a shape layout shall be added
     * @param kgraphElement
     *            graph element with layout data
     * @param editPart
     *            edit part to which layout is applied
     * @param offsetLayout
     *            layout data of the graph element whose position is added as offset to the current
     *            shape, or {@code null} if no offset shall be added
     */
    private void addShapeLayout(final GmfLayoutCommand command, final KGraphElement kgraphElement,
            final GraphicalEditPart editPart, final KShapeLayout offsetLayout) {
        KShapeLayout layoutData = kgraphElement.getData(KShapeLayout.class);
        Rectangle oldBounds = editPart.getFigure().getBounds();
        Point newLocation = new Point((int) layoutData.getXpos(), (int) layoutData.getYpos());
        int offsetx = offsetLayout == null ? 0 : (int) offsetLayout.getXpos();
        int offsety = offsetLayout == null ? 0 : (int) offsetLayout.getYpos();
        if (newLocation.x + offsetx == oldBounds.x && newLocation.y + offsety == oldBounds.y) {
            newLocation = null;
        }
        Dimension newSize = new Dimension((int) layoutData.getWidth(), (int) layoutData.getHeight());
        if (newSize.width == oldBounds.width && newSize.height == oldBounds.height) {
            newSize = null;
        }
        if (newLocation != null || newSize != null) {
            View view = (View) editPart.getModel();
            command.addShapeLayout(view, newLocation, newSize);
        }
    }

    /**
     * Adds an edge layout to the given command.
     * 
     * @param command
     *            command to which an edge layout shall be added
     * @param kedge
     *            edge with layout data
     * @param connectionEditPart
     *            edit part to which layout is applied
     */
    private void addEdgeLayout(final GmfLayoutCommand command, final KEdge kedge,
            final ConnectionEditPart connectionEditPart) {
        // create source terminal identifier
        KVector sourceRel = getRelativeSourcePoint(kedge);
        INodeEditPart sourceEditPart = (INodeEditPart) connectionEditPart.getSource();
        ConnectionAnchor sourceAnchor = new SlidableAnchor(sourceEditPart.getFigure(),
                new PrecisionPoint(sourceRel.x, sourceRel.y));
        String sourceTerminal = sourceEditPart.mapConnectionAnchorToTerminal(sourceAnchor);
        
        // create target terminal identifier
        KVector targetRel = getRelativeTargetPoint(kedge);
        INodeEditPart targetEditPart = (INodeEditPart) connectionEditPart.getTarget();
        ConnectionAnchor targetAnchor = new SlidableAnchor(targetEditPart.getFigure(),
                new PrecisionPoint(targetRel.x, targetRel.y));
        String targetTerminal = targetEditPart.mapConnectionAnchorToTerminal(targetAnchor);

        PointList bendPoints = getBendPoints(kedge, connectionEditPart.getFigure());
        
        // check whether the connection is a note attachment to an edge, then remove bend points
        if (sourceEditPart instanceof ConnectionEditPart
                || targetEditPart instanceof ConnectionEditPart) {
            while (bendPoints.size() > 2) {
                bendPoints.removePoint(1);
            }
        }
        command.addEdgeLayout((Edge) connectionEditPart.getModel(), bendPoints, sourceTerminal,
                targetTerminal);
    }
    
    /**
     * Create a vector that contains the relative position of the source point to the corresponding
     * source node or port.
     * 
     * @param edge an edge
     * @return the relative source point
     */
    private KVector getRelativeSourcePoint(final KEdge edge) {
        KEdgeLayout edgeLayout = edge.getData(KEdgeLayout.class);
        KNode sourceNode = edge.getSource(), targetNode = edge.getTarget();
        KPoint sourcePoint = edgeLayout.getSourcePoint();
        KVector sourceRel = new KVector(sourcePoint.getX(), sourcePoint.getY());
        KShapeLayout sourceLayout = sourceNode.getData(KShapeLayout.class);
        
        if (KimlUtil.isDescendant(targetNode, sourceNode)) {
            // in this case the edge points are given without the source insets, so add them
            KInsets insets = sourceLayout.getInsets();
            double width = Math.max(sourceLayout.getWidth() - insets.getLeft()
                    - insets.getRight(), 1);
            double widthPercent = sourceRel.x / width;
            double height = Math.max(sourceLayout.getHeight() - insets.getTop()
                    - insets.getBottom(), 1);
            double heightPercent = sourceRel.y / height;
            if (widthPercent + heightPercent <= 1
                    && widthPercent - heightPercent <= 0) {
                // source point is on the left
                sourceRel.y += insets.getTop();
            } else if (widthPercent + heightPercent >= 1
                    && widthPercent - heightPercent >= 0) {
                // source point is on the right
                sourceRel.x += insets.getLeft() + insets.getRight();
                sourceRel.y += insets.getTop();
            } else if (heightPercent < 1.0f / 2) {
                // source point is on the top
                sourceRel.x += insets.getLeft();
            } else {
                // source point is on the bottom
                sourceRel.x += insets.getLeft();
                sourceRel.y += insets.getTop() + insets.getBottom();
            }
        } else {
            sourceRel.translate(-sourceLayout.getXpos(), -sourceLayout.getYpos());
        }
        
        if (edge.getSourcePort() != null) {
            // calculate the relative position to the port size
            KShapeLayout portLayout = edge.getSourcePort().getData(KShapeLayout.class);
            if (portLayout.getWidth() == 0) {
                sourceRel.x = 0;
            } else {
                sourceRel.x = (sourceRel.x - portLayout.getXpos()) / portLayout.getWidth();
            }
            if (portLayout.getHeight() == 0) {
                sourceRel.y = 0;
            } else {
                sourceRel.y = (sourceRel.y - portLayout.getYpos()) / portLayout.getHeight();
            }
        } else {
            // calculate the relative position to the node size, which is assumed to be greater than 0
            sourceRel.x /= sourceLayout.getWidth();
            sourceRel.y /= sourceLayout.getHeight();
        }
        
        // check the bound of the relative position
        return sourceRel.applyBounds(0, 0, 1, 1);
    }
    
    /**
     * Create a vector that contains the relative position of the target point to the corresponding
     * target node or port.
     * 
     * @param edge an edge
     * @return the relative target point
     */
    private KVector getRelativeTargetPoint(final KEdge edge) {
        KEdgeLayout edgeLayout = edge.getData(KEdgeLayout.class);
        KNode sourceNode = edge.getSource(), targetNode = edge.getTarget();
        KPoint targetPoint = edgeLayout.getTargetPoint();
        KVector targetRel = new KVector(targetPoint.getX(), targetPoint.getY());
        KShapeLayout targetLayout = targetNode.getData(KShapeLayout.class);
        
        if (sourceNode.getParent() != targetNode.getParent() && sourceNode != targetNode.getParent()) {
            // the reference point of the target is different from the source
            KimlUtil.toAbsolute(targetRel, sourceNode.getParent());
            KimlUtil.toRelative(targetRel, targetNode.getParent());
        }
        targetRel.translate(-targetLayout.getXpos(), -targetLayout.getYpos());
        
        if (KimlUtil.isDescendant(sourceNode, targetNode)) {
            // in this case the edge points are given without the target insets, so add them
            KInsets insets = targetLayout.getInsets();
            double width = Math.max(targetLayout.getWidth() - insets.getLeft()
                    - insets.getRight(), 1);
            double widthPercent = (targetRel.x - insets.getLeft()) / width;
            double height = Math.max(targetLayout.getHeight() - insets.getTop()
                    - insets.getBottom(), 1);
            double heightPercent = (targetRel.y - insets.getTop()) / height;
            if (widthPercent + heightPercent >= 1) {
                if (widthPercent - heightPercent >= 0) {
                    // target point is on the right
                    targetRel.x += insets.getRight();
                } else {
                    // target point is on the bottom
                    targetRel.y += insets.getBottom();
                }
            }
        }
        
        if (edge.getTargetPort() != null) {
            // calculate the relative position to the port size
            KShapeLayout portLayout = edge.getTargetPort().getData(KShapeLayout.class);
            if (portLayout.getWidth() == 0) {
                targetRel.x = 0;
            } else {
                targetRel.x = (targetRel.x - portLayout.getXpos()) / portLayout.getWidth();
            }
            if (portLayout.getHeight() == 0) {
                targetRel.y = 0;
            } else {
                targetRel.y = (targetRel.y - portLayout.getYpos()) / portLayout.getHeight();
            }
        } else {
            // calculate the relative position to the node size, which is assumed to be greater than 0
            targetRel.x /= targetLayout.getWidth();
            targetRel.y /= targetLayout.getHeight();
        }
        
        // check the bound of the relative position
        return targetRel.applyBounds(0, 0, 1, 1);
    }

    /** see LabelViewConstants.TARGET_LOCATION. */
    private static final int SOURCE_LOCATION = 85;
    /** see LabelViewConstants.MIDDLE_LOCATION. */
    private static final int MIDDLE_LOCATION = 50;
    /** see LabelViewConstants.SOURCE_LOCATION. */
    private static final int TARGET_LOCATION = 15;

    /**
     * Adds an edge label layout to the given command.
     * 
     * @param command
     *            command to which the edge label layout shall be added
     * @param klabel
     *            label with layout data
     * @param labelEditPart
     *            edit part to which layout is applied
     */
    private void addEdgeLabelLayout(final GmfLayoutCommand command, final KLabel klabel,
            final LabelEditPart labelEditPart, final float xbound, final float ybound) {
        // calculate direct new location of the label
        KShapeLayout labelLayout = klabel.getData(KShapeLayout.class);
        Rectangle targetBounds = new Rectangle(labelEditPart.getFigure().getBounds());
        targetBounds.x = (int) labelLayout.getXpos();
        targetBounds.y = (int) labelLayout.getYpos();
        KGraphElement kedge = klabel.getParent();
        if (targetBounds.x < 0 || targetBounds.y < 0 || targetBounds.x > xbound
                || targetBounds.y > ybound || !(kedge instanceof KEdge)) {
            // empty labels are just positioned near their reference point
            command.addShapeLayout((View) labelEditPart.getModel(), new Point(), null);
            return;
        }
        
        ConnectionEditPart connectionEditPart = (ConnectionEditPart) labelEditPart.getParent();
        PointList bendPoints = getBendPoints((KEdge) kedge, connectionEditPart.getFigure());
        EObject modelElement = connectionEditPart.getNotationView().getElement();
        EdgeLabelPlacement labelPlacement = labelLayout
                .getProperty(LayoutOptions.EDGE_LABEL_PLACEMENT);
        // for labels of the opposite reference of an ecore reference,
        // the list of bend points must be reversed
        if (modelElement instanceof EReference && labelPlacement == EdgeLabelPlacement.TAIL) {
            bendPoints = bendPoints.getCopy();
            bendPoints.reverse();
        }

        // get the referencePoint for the label
        int fromEnd;
        switch (labelEditPart.getKeyPoint()) {
        case ConnectionLocator.SOURCE:
            fromEnd = SOURCE_LOCATION;
            break;
        case ConnectionLocator.TARGET:
            fromEnd = TARGET_LOCATION;
            break;
        default:
            fromEnd = MIDDLE_LOCATION;
            break;
        }
        Point refPoint = PointListUtilities.calculatePointRelativeToLine(bendPoints, 0, fromEnd, true);

        // get the new relative location
        Point normalPoint = offsetFromRelativeCoordinate(targetBounds, bendPoints, refPoint);
        if (normalPoint != null) {
            command.addShapeLayout((View) labelEditPart.getModel(), normalPoint, null);
        }
    }

    /**
     * Transform the bend points of the given edge layout into a point list, reusing existing ones
     * if possible. The source and target points of the edge layout are included in the point list.
     * 
     * @param edge
     *            the edge for which to fetch bend points
     * @param isSplineEdge
     *            indicates whether the connection supports splines
     * @return point list with the bend points of the edge layout
     */
    private PointList getBendPoints(final KEdge edge, final IFigure edgeFigure) {
        KEdgeLayout edgeLayout = edge.getData(KEdgeLayout.class);
        PointList pointList = pointListMap.get(edgeLayout);
        if (pointList == null) {
            KPoint sourcePoint = edgeLayout.getSourcePoint();
            KPoint targetPoint = edgeLayout.getTargetPoint();
            List<KPoint> bendPoints = edgeLayout.getBendPoints();

            EdgeRouting edgeRouting = edgeLayout.getProperty(LayoutOptions.EDGE_ROUTING);
            boolean splineActive = false;
            if (edgeFigure instanceof SplineConnection) {
                if (((SplineConnection) edgeFigure).getSplineMode() != SplineConnection.SPLINE_OFF) {
                    splineActive = true;
                }
            }
            // for connections that support splines the control points are passed without change
            if (edgeRouting == EdgeRouting.SPLINES && bendPoints.size() >= 1 && !splineActive) {
                // treat the edge points as control points for splines
                PointList control = new PointList(bendPoints.size() + 2);
                control.addPoint(new Point(sourcePoint.getX(), sourcePoint.getY()));
                for (KPoint bendPoint : bendPoints) {
                    control.addPoint(new Point(bendPoint.getX(), bendPoint.getY()));
                }
                control.addPoint(new Point(targetPoint.getX(), targetPoint.getY()));
                pointList = SplineUtilities.approximateSpline(control);
                
            } else {
                // treat the edge points as normal bend points
                pointList = new PointList();
                KNode sourceNode = edge.getSource(), targetNode = edge.getTarget();
                if (KimlUtil.isDescendant(targetNode, sourceNode)) {
                    // in this case the insets are not yet considered in the source point
                    KVector point = new KVector(sourcePoint.getX(), sourcePoint.getY());
                    translatePoint(point, point, sourceNode);
                    pointList.addPoint((int) point.x, (int) point.y);
                } else {
                    pointList.addPoint((int) sourcePoint.getX(), (int) sourcePoint.getY());
                }
                for (KPoint bendPoint : bendPoints) {
                    pointList.addPoint((int) bendPoint.getX(), (int) bendPoint.getY());
                }
                if (KimlUtil.isDescendant(sourceNode, targetNode)) {
                    // in this case the insets are not yet considered in the target point
                    KVector point = new KVector(targetPoint.getX(), targetPoint.getY());
                    KVector referencePoint = new KVector(point);
                    KNode node = sourceNode;
                    while (node.getParent() != targetNode) {
                        node = node.getParent();
                        KShapeLayout nodeLayout = node.getData(KShapeLayout.class);
                        KInsets insets = nodeLayout.getInsets();
                        referencePoint.translate(nodeLayout.getXpos() + insets.getLeft(),
                                nodeLayout.getYpos() + insets.getTop());
                    }
                    translatePoint(referencePoint, point, targetNode);
                    pointList.addPoint((int) point.x, (int) point.y);
                } else {
                    pointList.addPoint((int) targetPoint.getX(), (int) targetPoint.getY());
                }
            }

            pointListMap.put(edgeLayout, pointList);
        }
        return pointList;
    }
    
    /**
     * Translate the given point by the parent insets towards the node border.
     * 
     * @param referencePoint the reference point relative to the given parent node
     * @param objectPoint the point that shall be translated
     * @param parentNode a parent node
     */
    private void translatePoint(final KVector referencePoint, final KVector objectPoint,
            final KNode parentNode) {
        KShapeLayout parentLayout = parentNode.getData(KShapeLayout.class);
        KInsets insets = parentLayout.getInsets();
        double widthPercent = referencePoint.x / parentLayout.getWidth();
        double heightPercent = referencePoint.y / parentLayout.getHeight();
        if (widthPercent + heightPercent <= 1
                && widthPercent - heightPercent <= 0) {
            // point is on the left
            objectPoint.x -= insets.getLeft();
        } else if (widthPercent + heightPercent >= 1
                && widthPercent - heightPercent >= 0) {
            // point is on the right
            objectPoint.x += insets.getRight();
        } else if (heightPercent < 1.0f / 2) {
            // point is on the top
            objectPoint.y -= insets.getTop();
        } else {
            // point is on the bottom
            objectPoint.y += insets.getBottom();
        }
    }

    /**
     * Calculates the label offset from the reference point given the label bounds and a points
     * list.
     * 
     * @param bounds
     *            the {@code Rectangle} that is the bounding box of the label
     * @param points
     *            the {@code PointList} that the label offset is relative to
     * @param therefPoint
     *            the {@code Point} that is the reference point that the offset is based on, or
     *            {@code null}
     * @return a {@code Point} which represents a value offset from the {@code refPoint} point
     *         oriented based on the nearest line segment, or {@code null} if no such point can be
     *         determined
     */
    public static Point offsetFromRelativeCoordinate(final Rectangle bounds,
            final PointList points, final Point therefPoint) {
        Point refPoint = therefPoint;
        if (refPoint == null) {
            refPoint = points.getFirstPoint();
        }
        // compensate for the fact that we are using the figure center
        bounds.translate(bounds.width / 2, bounds.height / 2);
        Point offset = new Point(bounds.x - refPoint.x, bounds.y - refPoint.y);
        // calculate slope of line
        if (points.size() == 1) {
            // this is a node...
            return offset;
        } else if (points.size() >= 2) {
            // this is an edge...
            int segIndex = PointListUtilities.findNearestLineSegIndexOfPoint(points, refPoint);
            @SuppressWarnings("rawtypes")
            List segmentsList = PointListUtilities.getLineSegments(points);
            if (segIndex <= 0) {
                segIndex = 0;
            } else if (segIndex > segmentsList.size()) {
                segIndex = segmentsList.size() - 1;
            } else {
                segIndex--;
            }
            LineSeg segment = (LineSeg) segmentsList.get(segIndex);
            Point normalOffset = null;
            if (segment.isHorizontal()) {
                if (segment.getOrigin().x > segment.getTerminus().x) {
                    normalOffset = offset.getNegated();
                    return normalOffset;
                } else {
                    normalOffset = offset;
                    return normalOffset;
                }
            } else if (segment.isVertical()) {
                if (segment.getOrigin().y < segment.getTerminus().y) {
                    normalOffset = offset.scale(-1, 1).transpose();
                    return normalOffset;
                } else {
                    normalOffset = offset.scale(1, -1).transpose();
                    return normalOffset;
                }
            } else {
                Point offsetRefPoint = refPoint.getTranslated(offset);
                LineSeg parallelSeg = segment.getParallelLineSegThroughPoint(offsetRefPoint);
                Point p1 = parallelSeg.perpIntersect(refPoint.x, refPoint.y);
                double dx = p1.getDistance(offsetRefPoint) * ((p1.x > offsetRefPoint.x) ? -1 : 1);
                double dy = p1.getDistance(refPoint) * ((p1.y < refPoint.y) ? -1 : 1);
                Point orth = new Point(dx, dy);
                // reflection in the y axis
                if (segment.getOrigin().x > segment.getTerminus().x) {
                    orth = orth.scale(-1, -1);
                }
                return orth;
            }
        }
        return null;
    }

}

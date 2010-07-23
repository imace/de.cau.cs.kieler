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
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramRootEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.INodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.LabelEditPart;
import org.eclipse.gmf.runtime.draw2d.ui.figures.IAnchorableFigure;
import org.eclipse.gmf.runtime.draw2d.ui.geometry.LineSeg;
import org.eclipse.gmf.runtime.draw2d.ui.geometry.PointListUtilities;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.preference.IPreferenceStore;

import de.cau.cs.kieler.core.kgraph.KEdge;
import de.cau.cs.kieler.core.kgraph.KGraphElement;
import de.cau.cs.kieler.core.kgraph.KLabel;
import de.cau.cs.kieler.core.kgraph.KNode;
import de.cau.cs.kieler.core.kgraph.KPort;
import de.cau.cs.kieler.core.ui.figures.SplineConnection;
import de.cau.cs.kieler.core.ui.util.SplineUtilities;
import de.cau.cs.kieler.core.util.Pair;
import de.cau.cs.kieler.kiml.klayoutdata.KEdgeLayout;
import de.cau.cs.kieler.kiml.klayoutdata.KPoint;
import de.cau.cs.kieler.kiml.klayoutdata.KShapeLayout;
import de.cau.cs.kieler.kiml.options.EdgeLabelPlacement;
import de.cau.cs.kieler.kiml.options.EdgeRouting;
import de.cau.cs.kieler.kiml.options.LayoutOptions;
import de.cau.cs.kieler.kiml.ui.KimlUiPlugin;
import de.cau.cs.kieler.kiml.ui.Messages;
import de.cau.cs.kieler.kiml.ui.layout.ApplyLayoutRequest;
import de.cau.cs.kieler.kiml.ui.layout.EclipseLayoutServices;
import de.cau.cs.kieler.kiml.util.KimlLayoutUtil;

/**
 * Edit policy used to apply layout. This edit policy creates a
 * {@link GmfLayoutCommand} to directly manipulate layout data in the
 * GMF notation model.
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
    
    /* (non-Javadoc)
     * @see org.eclipse.gef.editpolicies.AbstractEditPolicy#understandsRequest(org.eclipse.gef.Request)
     */
    @Override
    public boolean understandsRequest(final Request req) {
        return (ApplyLayoutRequest.REQ_APPLY_LAYOUT.equals(req.getType()));
    }
    
    /* (non-Javadoc)
     * @see org.eclipse.gef.editpolicies.AbstractEditPolicy#getCommand(org.eclipse.gef.Request)
     */
    @Override
    public Command getCommand(final Request request) {
        if (ApplyLayoutRequest.REQ_APPLY_LAYOUT.equals(request.getType())) {
            if (request instanceof ApplyLayoutRequest) {
                ApplyLayoutRequest layoutRequest = (ApplyLayoutRequest) request;
                IGraphicalEditPart hostEditPart = (IGraphicalEditPart) getHost();
                GmfLayoutCommand command = new GmfLayoutCommand(
                        hostEditPart.getEditingDomain(), Messages.getString("kiml.ui.5"), //$NON-NLS-1$
                        new EObjectAdapter((View) hostEditPart.getModel()));
                
                // retrieve layout data from the request and compute layout data for the command
                for (Pair<KGraphElement, GraphicalEditPart> layoutPair : layoutRequest.getElements()) {
                    if (layoutPair.getFirst() instanceof KNode) {
                        addShapeLayout(command, layoutPair.getFirst(), layoutPair.getSecond(), null);
                    } else if (layoutPair.getFirst() instanceof KPort) {
                        addShapeLayout(command, layoutPair.getFirst(), layoutPair.getSecond(),
                                KimlLayoutUtil.getShapeLayout(
                                ((KPort) layoutPair.getFirst()).getNode()));
                    } else if (layoutPair.getFirst() instanceof KEdge) {
                        addEdgeLayout(command, (KEdge) layoutPair.getFirst(),
                                (ConnectionEditPart) layoutPair.getSecond());
                    } else if (layoutPair.getFirst() instanceof KLabel) {
                        addEdgeLabelLayout(command, (KLabel) layoutPair.getFirst(),
                                (LabelEditPart) layoutPair.getSecond());
                    }
                }
                
                // set further options
                IPreferenceStore preferenceStore = KimlUiPlugin.getDefault().getPreferenceStore();
                command.setObliqueRouting(preferenceStore.getBoolean(
                        EclipseLayoutServices.PREF_OBLIQUE_ROUTE));
                
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
     * @param command command to which a shape layout shall be added
     * @param kgraphElement graph element with layout data
     * @param editPart edit part to which layout is applied
     * @param offsetLayout layout data of the graph element whose position is added
     *     as offset to the current shape, or {@code null} if no offset shall be added
     */
    private void addShapeLayout(final GmfLayoutCommand command, final KGraphElement kgraphElement,
            final GraphicalEditPart editPart, final KShapeLayout offsetLayout) {
        KShapeLayout layoutData = KimlLayoutUtil.getShapeLayout(kgraphElement);
        Rectangle oldBounds = editPart.getFigure().getBounds();
        Point newLocation = new Point((int) layoutData.getXpos(),
                (int) layoutData.getYpos());
        int offsetx = offsetLayout == null ? 0 : (int) offsetLayout.getXpos();
        int offsety = offsetLayout == null ? 0 : (int) offsetLayout.getYpos();
        if (newLocation.x + offsetx == oldBounds.x && newLocation.y + offsety == oldBounds.y) {
            newLocation = null;
        }
        Dimension newSize = new Dimension((int) layoutData.getWidth(),
                (int) layoutData.getHeight());
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
     * @param command command to which an edge layout shall be added
     * @param kedge edge with layout data
     * @param connectionEditPart edit part to which layout is applied
     */
    private void addEdgeLayout(final GmfLayoutCommand command, final KEdge kedge,
            final ConnectionEditPart connectionEditPart) {
        KEdgeLayout edgeLayout = KimlLayoutUtil.getEdgeLayout(kedge);
        PointList bendPoints = getBendPoints(edgeLayout, connectionEditPart.getFigure());
        Rectangle sourceExt, targetExt;

        KShapeLayout sourceLayout = KimlLayoutUtil.getShapeLayout(kedge.getSource());
        KPort sourcePort = kedge.getSourcePort();
        INodeEditPart sourceEditPart = (INodeEditPart) connectionEditPart.getSource();
        if (sourcePort != null) {
            KShapeLayout portLayout = KimlLayoutUtil.getShapeLayout(sourcePort);
            sourceExt = new Rectangle((int) (portLayout.getXpos()
                    + sourceLayout.getXpos()), (int) (portLayout.getYpos()
                    + sourceLayout.getYpos()), (int) portLayout.getWidth(),
                    (int) portLayout.getHeight());
        } else {
            sourceExt = new Rectangle((int) sourceLayout.getXpos(),
                    (int) sourceLayout.getYpos(),
                    (int) sourceLayout.getWidth(),
                    (int) sourceLayout.getHeight());
        }
        PrecisionPoint sourceRatio = new PrecisionPoint((edgeLayout.getSourcePoint().getX()
                - sourceExt.preciseX()) / sourceExt.preciseWidth(),
                (edgeLayout.getSourcePoint().getY() - sourceExt.preciseY())
                / sourceExt.preciseHeight());
        IFigure sourceFigure = sourceEditPart.getFigure();
        Rectangle sourceBounds = sourceFigure.getBounds();
        Point sourceAnchorReference = new PrecisionPoint(sourceBounds.preciseX()
                + sourceRatio.preciseX() * sourceBounds.preciseWidth(),
                sourceBounds.preciseY() + sourceRatio.preciseY() * sourceBounds.preciseHeight());
        sourceFigure.translateToAbsolute(sourceAnchorReference);
        ConnectionAnchor sourceAnchor = ((IAnchorableFigure) sourceFigure)
                .getSourceConnectionAnchorAt(sourceAnchorReference);
        String sourceTerminal = sourceEditPart.mapConnectionAnchorToTerminal(sourceAnchor);

        KShapeLayout targetLayout = KimlLayoutUtil.getShapeLayout(kedge.getTarget());
        KPort targetPort = kedge.getTargetPort();
        INodeEditPart targetEditPart = (INodeEditPart) connectionEditPart.getTarget();
        if (targetPort != null) {
            KShapeLayout portLayout = KimlLayoutUtil.getShapeLayout(targetPort);
            targetExt = new Rectangle((int) (portLayout.getXpos()
                    + targetLayout.getXpos()), (int) (portLayout.getYpos()
                    + targetLayout.getYpos()), (int) portLayout.getWidth(),
                    (int) portLayout.getHeight());
        } else {
            targetExt = new Rectangle((int) targetLayout.getXpos(),
                    (int) targetLayout.getYpos(),
                    (int) targetLayout.getWidth(),
                    (int) targetLayout.getHeight());
        }
        PrecisionPoint targetRatio = new PrecisionPoint((edgeLayout.getTargetPoint().getX()
                - targetExt.preciseX()) / targetExt.preciseWidth(),
                (edgeLayout.getTargetPoint().getY() - targetExt.preciseY())
                / targetExt.preciseHeight());
        IFigure targetFigure = targetEditPart.getFigure();
        Rectangle targetBounds = targetFigure.getBounds();
        Point targetAnchorReference = new PrecisionPoint(targetBounds.preciseX()
                + targetRatio.preciseX() * targetBounds.preciseWidth(),
                targetBounds.preciseY() + targetRatio.preciseY() * targetBounds.preciseHeight());
        targetFigure.translateToAbsolute(targetAnchorReference);
        ConnectionAnchor targetAnchor = ((IAnchorableFigure) targetFigure)
                .getTargetConnectionAnchorAt(targetAnchorReference);
        String targetTerminal = targetEditPart.mapConnectionAnchorToTerminal(targetAnchor);

        // check whether the connection is a note attachment to an edge
        if (sourceEditPart instanceof ConnectionEditPart
                || targetEditPart instanceof ConnectionEditPart) {
            while (bendPoints.size() > 2) {
                bendPoints.removePoint(1);
            }
        }
        command.addEdgeLayout((Edge) connectionEditPart.getModel(),
                bendPoints, sourceTerminal, targetTerminal);
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
     * @param command command to which the edge label layout shall be added
     * @param klabel label with layout data
     * @param labelEditPart edit part to which layout is applied
     */
    private void addEdgeLabelLayout(final GmfLayoutCommand command, final KLabel klabel,
            final LabelEditPart labelEditPart) {
        // get zoom level for offset compensation
        double zoomLevel = 1.0;
        if (labelEditPart.getRoot() instanceof DiagramRootEditPart) {
            zoomLevel = ((DiagramRootEditPart) labelEditPart.getRoot())
                    .getZoomManager().getZoom();
        }

        // calculate direct new location of the label
        KShapeLayout labelLayout = KimlLayoutUtil.getShapeLayout(klabel);
        ConnectionEditPart connectionEditPart = (ConnectionEditPart) labelEditPart.getParent();
        IFigure sourceFigure = ((GraphicalEditPart) connectionEditPart.getSource()).getFigure();
        Point newLocation = new Point(labelLayout.getXpos(), labelLayout.getYpos());
        sourceFigure.translateToAbsolute(newLocation);
        newLocation.scale(1 / zoomLevel);
        Rectangle targetBounds = labelEditPart.getFigure().getBounds();
        targetBounds.x = newLocation.x;
        targetBounds.y = newLocation.y;

        // get new bend points for the parent edge
        KEdge kedge = (KEdge) klabel.getParent();
        KEdgeLayout edgeLayout = KimlLayoutUtil.getEdgeLayout(kedge);
        PointList bendPoints = getBendPoints(edgeLayout, connectionEditPart.getFigure());
        EObject modelElement = connectionEditPart.getNotationView().getElement();
        EdgeLabelPlacement labelPlacement = LayoutOptions.getEnum(labelLayout,
                EdgeLabelPlacement.class);
        PointList absoluteBendPoints = new PointList();
        // for labels of the opposite reference of an ecore reference,
        // the list of bend points must be reversed
        if (modelElement instanceof EReference
                && labelPlacement == EdgeLabelPlacement.TAIL) {
            for (int i = bendPoints.size() - 1; i >= 0; i--) {
                Point point = bendPoints.getPoint(i);
                sourceFigure.translateToAbsolute(point);
                absoluteBendPoints.addPoint(point.scale(1 / zoomLevel));
            }
        } else {
            for (int i = 0; i < bendPoints.size(); i++) {
                Point point = bendPoints.getPoint(i);
                sourceFigure.translateToAbsolute(point);
                absoluteBendPoints.addPoint(point.scale(1 / zoomLevel));
            }
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
        Point refPoint = PointListUtilities.calculatePointRelativeToLine(
                absoluteBendPoints, 0, fromEnd, true);
        
        // get the new relative location
        Point normalPoint = offsetFromRelativeCoordinate(targetBounds,
                absoluteBendPoints, refPoint);
        command.addShapeLayout((View) labelEditPart.getModel(), normalPoint, null);
        
        // invalidate the figure to be sure that it is redrawn
        labelEditPart.getFigure().invalidate();
    }
    
    /**
     * Transform the bend points of the given edge layout into a
     * point list, reusing existing ones if possible. The source and
     * target points of the edge layout are included in the point
     * list.
     * 
     * @param edgeLayout the edge layout
     * @param isSplineEdge indicates whether the connection supports splines
     * @return point list with the bend points of the edge layout
     */
    private PointList getBendPoints(final KEdgeLayout edgeLayout, final IFigure edgeFigure) {
        PointList pointList = pointListMap.get(edgeLayout);
        if (pointList == null) {
            KPoint sourcePoint = edgeLayout.getSourcePoint();
            KPoint targetPoint = edgeLayout.getTargetPoint();
            List<KPoint> bendPoints = edgeLayout.getBendPoints();
            
            EdgeRouting edgeRouting = LayoutOptions.getEnum(edgeLayout, EdgeRouting.class);
            boolean splineActive = false;
            if (edgeFigure instanceof SplineConnection) {
                if (((SplineConnection) edgeFigure).getSplineMode() != SplineConnection.SPLINE_OFF) {
                    splineActive = true;
                }
            }
            // for connections that support splines the control points are passed without change
            if (edgeRouting == EdgeRouting.SPLINES && bendPoints.size() >= 1
                    && !splineActive) {
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
                pointList.addPoint((int) sourcePoint.getX(), (int) sourcePoint.getY());
                for (KPoint bendPoint : bendPoints) {
                    pointList.addPoint((int) bendPoint.getX(), (int) bendPoint.getY());
                }
                pointList.addPoint((int) targetPoint.getX(), (int) targetPoint.getY());
            }
            
            pointListMap.put(edgeLayout, pointList);
        }
        return pointList;
    }
    
    /**
     * Calculates the label offset from the reference point given the label bounds
     * and a points list.  
     * 
     * @param bounds the {@code Rectangle} that is the bounding box of the label
     * @param points the {@code PointList} that the label offset is relative to
     * @param therefPoint the {@code Point} that is the reference point that the offset
     *     is based on, or {@code null}
     * @return a {@code Point} which represents a value offset from the {@code refPoint}
     *     point oriented based on the nearest line segment
     */
    public static Point offsetFromRelativeCoordinate(final Rectangle bounds,
            final PointList points, final Point therefPoint) {
        Point refPoint = therefPoint;
        if (refPoint == null) {
            refPoint = points.getFirstPoint();
        }
        Rectangle rect = new Rectangle(bounds);
        // compensate for the fact that we are using the figure center
        rect.translate(rect.width / 2, rect.height / 2);
        Point offset = new Point(rect.x - refPoint.x, rect.y - refPoint.y);
        // calculate slope of line
        if (points.size() == 1) {
            // this is a node...
            return offset;
        } else if (points.size() >= 2) {
            // this is an edge...
            int index = PointListUtilities.findNearestLineSegIndexOfPoint(points, refPoint);
            if (index <= 0) {
                index = 1;
            }
            LineSeg segment = (LineSeg) PointListUtilities.getLineSegments(points).get(index - 1);
            Point normalOffset = null;
            if (segment != null) {
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
                    double dx = p1.getDistance(offsetRefPoint)
                            * ((p1.x > offsetRefPoint.x) ? -1 : 1);
                    double dy = p1.getDistance(refPoint) * ((p1.y < refPoint.y) ? -1 : 1);
                    Point orth = new Point(dx, dy);
                    // reflection in the y axis
                    if (segment.getOrigin().x > segment.getTerminus().x) {
                        orth = orth.scale(-1, -1);
                    }
                    return orth;
                }
            }
        }
        return null;
    }

}

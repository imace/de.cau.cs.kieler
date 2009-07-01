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
package de.cau.cs.kieler.kiml.ui.layout;

import java.util.Iterator;

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.ConnectionLayer;
import org.eclipse.draw2d.ConnectionLocator;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.PrecisionDimension;
import org.eclipse.draw2d.geometry.PrecisionPoint;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.editparts.ScalableFreeformRootEditPart;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gef.requests.ReconnectRequest;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.core.commands.SetConnectionAnchorsCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.SetBoundsCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramRootEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.LabelEditPart;
import org.eclipse.gmf.runtime.diagram.ui.internal.util.LabelViewConstants;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramUIMessages;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramCommandStack;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.gmf.runtime.diagram.ui.requests.SetAllBendpointRequest;
import org.eclipse.gmf.runtime.draw2d.ui.figures.BaseSlidableAnchor;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.draw2d.ui.geometry.LineSeg;
import org.eclipse.gmf.runtime.draw2d.ui.geometry.PointListUtilities;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.SWT;

import de.cau.cs.kieler.core.kgraph.KEdge;
import de.cau.cs.kieler.core.kgraph.KLabel;
import de.cau.cs.kieler.core.kgraph.KNode;
import de.cau.cs.kieler.core.kgraph.KPort;
import de.cau.cs.kieler.kiml.layout.klayoutdata.KEdgeLayout;
import de.cau.cs.kieler.kiml.layout.klayoutdata.KPoint;
import de.cau.cs.kieler.kiml.layout.klayoutdata.KShapeLayout;
import de.cau.cs.kieler.kiml.layout.util.KimlLayoutUtil;
import de.cau.cs.kieler.kiml.ui.helpers.LabelHelper;
import de.cau.cs.kieler.kiml.ui.policies.LayoutEditPolicy;

/**
 * A generic implementation of the {@link AbstractLayoutGraphApplier}.
 * 
 * @author <a href="mailto:ars@informatik.uni-kiel.de">Arne Schipper</a>
 * @author <a href="mailto:msp@informatik.uni-kiel.de">Miro Spönemann</a>
 */
public class GenericLayoutGraphApplier extends
        AbstractLayoutGraphApplier {

    /* preference settings */
    private boolean prefUseGMFLabelLocation = false;
    private boolean prefSmoothTransitions = false;

    /* zoom level and connection layer */
    private double zoomLevel = 1.0;
    private ConnectionLayer connectionLayer = null;

    /*
     * (non-Javadoc)
     * 
     * @see
     * de.cau.cs.kieler.kiml.ui.layout.AbstractLayoutGraphApplier
     * #doApplyLayoutGraph()
     */
    @Override
    protected void doApplyLayoutGraph() {

        /* gets zoom level */
        ScalableFreeformRootEditPart sfrep = (ScalableFreeformRootEditPart) layoutRootPart
                .getRoot();
        zoomLevel = sfrep.getZoomManager().getZoom();

        /* gets connection layer */
        connectionLayer = (ConnectionLayer) sfrep
                .getLayer(DiagramRootEditPart.CONNECTION_LAYER);
        connectionLayer.setAntialias(SWT.ON);

        /* gets the diagram command stack */
        DiagramCommandStack commandStack = null;
        Object adapter = sfrep.getAdapter(CommandStack.class);
        if (adapter instanceof DiagramCommandStack) {
            commandStack = (DiagramCommandStack) adapter;
        } else {
            commandStack = new DiagramCommandStack(null);
        }

        /* applies node layouts */
        CompoundCommand nodesCompoundCommand = doApplyNodeLayout();

        /* applies port layouts */
        CompoundCommand portsCompoundCommand = doApplyPortLayout();

        /* applies edge layouts */
        CompoundCommand edgesCompoundCommand = doApplyEdgeLayout();

        /* applies node label layouts */
        CompoundCommand nodeLabelsCompoundCommand = doApplyNodeLabelLayout();

        /* applies port label layouts */
        CompoundCommand portLabelsCompoundCommand = doApplyPortLabelLayout();

        /* applies edge label layouts */
        CompoundCommand edgeLabelsCompoundCommand = doApplyEdgeLabelLayout();

        /*
         * collects all single commands and executes them; the check if the
         * command size is zero is necessary, otherwise all following commands
         * won't be executed.
         */
        CompoundCommand compoundCommand = new CompoundCommand();
        compoundCommand.setLabel("Layout"); //$NON-NLS-1$
        if (nodesCompoundCommand.size() != 0)
            compoundCommand.add(nodesCompoundCommand);
        if (portsCompoundCommand.size() != 0)
            compoundCommand.add(portsCompoundCommand);
        if (edgesCompoundCommand.size() != 0)
            compoundCommand.add(edgesCompoundCommand);
        if (nodeLabelsCompoundCommand.size() != 0)
            compoundCommand.add(nodeLabelsCompoundCommand);
        if (portLabelsCompoundCommand.size() != 0)
            compoundCommand.add(portLabelsCompoundCommand);
        if (edgeLabelsCompoundCommand.size() != 0)
            compoundCommand.add(edgeLabelsCompoundCommand);
        commandStack.execute(compoundCommand);
    }

    /**
     * This functions builds the CompoundCommand which is responsible to lay out
     * the nodes of the diagram. The information is taken from the mappings
     * provided to the class through the function <code>applyLayoutGraph</code>
     * of the abstract parent class.
     * 
     * @return A CompoundCommand which lays out the nodes of the diagram
     */
    private CompoundCommand doApplyNodeLayout() {
        CompoundCommand nodesCompoundCommand = new CompoundCommand();
        for (KNode layoutNode : layoutNode2EditPart.keySet()) {
            GraphicalEditPart nodeEditPart = layoutNode2EditPart
                    .get(layoutNode);
            KShapeLayout nodeLayout = KimlLayoutUtil.getShapeLayout(layoutNode);
            ChangeBoundsRequest changeBoundsRequest = new ChangeBoundsRequest(
                    RequestConstants.REQ_RESIZE);
            changeBoundsRequest.setEditParts(nodeEditPart);

            Dimension oldSize = nodeEditPart.getFigure().getBounds().getSize();
            PrecisionDimension newSize = new PrecisionDimension(nodeLayout
                    .getWidth(), nodeLayout.getHeight());

            Dimension sizeDelta = new PrecisionDimension(newSize.preciseWidth
                    - oldSize.width, newSize.preciseHeight - oldSize.height);
            changeBoundsRequest.setResizeDirection(PositionConstants.CENTER);
            sizeDelta.performScale(zoomLevel);
            changeBoundsRequest.setSizeDelta(sizeDelta);
            
            Point oldLocation = nodeEditPart.getFigure().getBounds()
                    .getLocation();
            PrecisionPoint newLocation = new PrecisionPoint(nodeLayout
                    .getXpos(), nodeLayout.getYpos());

            Point moveDelta = new PrecisionPoint(newLocation.preciseX
                    - oldLocation.x, newLocation.preciseY - oldLocation.y);
            moveDelta.performScale(zoomLevel);
            changeBoundsRequest.setMoveDelta(moveDelta);
            changeBoundsRequest.setLocation(newLocation);

            nodesCompoundCommand.add(nodeEditPart
                    .getCommand(changeBoundsRequest));
        }
        return nodesCompoundCommand;
    }

    /**
     * This functions builds the CompoundCommand which is responsible to lay out
     * the ports of the diagram. The information is taken from the mappings
     * provided to the class through the function <code>applyLayoutGraph</code>
     * of the abstract parent class.
     * 
     * @return A CompoundCommand which lays out the ports of the diagram
     */
    @SuppressWarnings("unchecked")
    private CompoundCommand doApplyPortLayout() {
        CompoundCommand portsCompoundCommand = new CompoundCommand();
        for (KPort port : layoutPort2EditPart.keySet()) {
            GraphicalEditPart portEditPart = layoutPort2EditPart.get(port);
            KShapeLayout portLayout = KimlLayoutUtil.getShapeLayout(port);
            Point nodeLocation = layoutNode2EditPart.get(port.getNode())
                    .getFigure().getBounds().getLocation();
            ChangeBoundsRequest changeBoundsRequest = new ChangeBoundsRequest(
                    RequestConstants.REQ_MOVE);
            changeBoundsRequest.setEditParts(portEditPart);

            Point oldLocation = portEditPart.getFigure().getBounds()
                    .getLocation();
            PrecisionPoint newLocation = new PrecisionPoint(portLayout.getXpos()
                    + nodeLocation.x, portLayout.getYpos() + nodeLocation.y);

            Point moveDelta = new PrecisionPoint(newLocation.preciseX
                    - oldLocation.x, newLocation.preciseY - oldLocation.y);
            moveDelta.performScale(zoomLevel);
            changeBoundsRequest.setMoveDelta(moveDelta);
            changeBoundsRequest.setLocation(newLocation);

            // set the automatic layout option in the extended data
            changeBoundsRequest.getExtendedData().put(
                    LayoutEditPolicy.AUTO_LAYOUT_KEY, Boolean.TRUE);
            portsCompoundCommand.add(portEditPart
                    .getCommand(changeBoundsRequest));
        }
        return portsCompoundCommand;
    }

    /**
     * This functions builds the CompoundCommand which is responsible to lay out
     * the edges of the diagram. The information is taken from the mappings
     * provided to the class through the function <code>applyLayoutGraph</code>
     * of the abstract parent class.
     * 
     * @return A CompoundCommand which lays out the edges of the diagram
     */
    private CompoundCommand doApplyEdgeLayout() {
        final CompoundCommand edgesCompoundCommand = new CompoundCommand();
        for (KEdge edge : layoutEdge2EditPart.keySet()) {
            ConnectionEditPart connectionEditPart = layoutEdge2EditPart
                    .get(edge);

            /*
             * if this connection is a polyline connection, see if it should be
             * routed smoothly. This is an attribute of a polyline connection.
             */
            if (connectionEditPart.getFigure() instanceof PolylineConnectionEx) {
                PolylineConnectionEx polyline = ((PolylineConnectionEx) connectionEditPart
                        .getFigure());

                if (prefSmoothTransitions) {
                    polyline.setSmoothness(PolylineConnectionEx.SMOOTH_NORMAL);
                } else {
                    polyline.setSmoothness(PolylineConnectionEx.SMOOTH_NONE);
                }
            }

            PointList pointList = new PointList();
            pointList = getBendpoints(edge);

            // create request and add it
            SetAllBendpointRequest request = new SetAllBendpointRequest(
                    RequestConstants.REQ_SET_ALL_BENDPOINT, pointList,
                    pointList.getFirstPoint(), pointList.getLastPoint());
            edgesCompoundCommand.add(connectionEditPart.getCommand(request));

            addAnchorsCommands(edgesCompoundCommand, pointList.getFirstPoint(),
                    pointList.getLastPoint(), edge);

        }
        return edgesCompoundCommand;
    }
    
    /**
     * Translates the given KPoint into a Draw2D Point.
     * 
     * @param kPoint KPoint to translate
     * @return new Point with the same coordinates
     */
    private static Point kPoint2Point(KPoint kPoint) {
        return new Point((int) kPoint.getX(), (int) kPoint.getY());
    }

    /**
     * Retrieve the list of bendpoints of an KEdge in a PointList that is
     * understood by GMF Requests.
     * 
     * @author haf
     * 
     * @param edge
     *            the KEdge that stores the new bendpoints
     * @return PointList with the new bendpoints
     */
    private PointList getBendpoints(KEdge edge) {
        KEdgeLayout edgeLayout = KimlLayoutUtil.getEdgeLayout(edge);
        PointList pointList = new PointList();

        // set start point
        Point startPoint = kPoint2Point(edgeLayout.getSourcePoint());
        pointList.addPoint(startPoint);

        // set grid points
        for (KPoint gridPoint : edgeLayout.getBendPoints()) {
            Point point = kPoint2Point(gridPoint);
            pointList.addPoint(point);
        }

        // set end point
        Point endPoint = kPoint2Point(edgeLayout.getTargetPoint());
        pointList.addPoint(endPoint);

        return pointList;
    }
    
    /**
     * Retrieve the list of bendpoints in absolute ConnectionLayer
     * coordinates. 
     * 
     * @author haf
     * 
     * @see getBendpoints()
     * @param edge 
     * @param source A figure on the same coordinate system as the edge for the
     *               translation between the coordinate systems.
     * @return
     */
    private PointList getAbsoluteBendPoints(KEdge edge, IFigure source){
        PointList bendPoints = getBendpoints(edge);
        PointList absolutePoints = new PointList();
        
        for( int i = 0; i < bendPoints.size(); i++ ){
            Point ap = translateFromTo(bendPoints.getPoint(i), source, connectionLayer);
            absolutePoints.addPoint(ap);
        }
        return absolutePoints;
    }

    /**
     * This functions builds the CompoundCommand which is responsible to lay out
     * the nodes labels of the diagram. The information is taken from the
     * mappings provided to the class through the function
     * <code>applyLayoutGraph</code> of the abstract parent class.
     * 
     * @return A CompoundCommand which lays out the node labels of the diagram
     */
    private CompoundCommand doApplyNodeLabelLayout() {
        CompoundCommand nodeLabelsCompoundCommand = new CompoundCommand();
        // TODO Auto-generated method stub
        return nodeLabelsCompoundCommand;
    }

    /**
     * This functions builds the CompoundCommand which is responsible to lay out
     * the port labels of the diagram. The information is taken from the
     * mappings provided to the class through the function
     * <code>applyLayoutGraph</code> of the abstract parent class.
     * 
     * @return A CompoundCommand which lays out the port labels of the diagram
     */
    private CompoundCommand doApplyPortLabelLayout() {
        CompoundCommand portLabelsCompoundCommand = new CompoundCommand();
        // TODO Auto-generated method stub
        return portLabelsCompoundCommand;
    }

    /**
     * This functions builds the CompoundCommand which is responsible to lay out
     * the edge labels of the diagram. The information is taken from the
     * mappings provided to the class through the function
     * <code>applyLayoutGraph</code> of the abstract parent class.
     * 
     * @return A CompoundCommand which lays out the edge labels of the diagram
     */
    private CompoundCommand doApplyEdgeLabelLayout() {
        CompoundCommand edgeLabelsCompoundCommand = new CompoundCommand();
        for (KLabel edgeLabel : edgeLabel2EditPart.keySet()) {
            LabelEditPart edgeLabelEditPart = edgeLabel2EditPart.get(edgeLabel);
            KShapeLayout edgeLabelLayout = KimlLayoutUtil.getShapeLayout(edgeLabel);
            ChangeBoundsRequest changeBoundsRequest = new ChangeBoundsRequest(
                    RequestConstants.REQ_MOVE);
            changeBoundsRequest.setEditParts(edgeLabelEditPart);

            Point oldLocation = edgeLabelEditPart.getFigure().getBounds()
                    .getLocation();
            PrecisionPoint newLocation = null;

            /*
             * easy if GMF should position the transition labels. Takes also
             * into account, if the the label in the EMF model was set as
             * beginning, mid or end label
             */
            if (prefUseGMFLabelLocation) {
                newLocation = new PrecisionPoint(edgeLabelEditPart
                        .getReferencePoint().x, edgeLabelEditPart
                        .getReferencePoint().y);
            }
            /*
             * some more work if the layout provider position information should
             * be used
             */
            else {
                EditPart parentEditPart = edgeLabelEditPart.getParent();
                IFigure sourceFigure = connectionLayer;
                if (parentEditPart instanceof ConnectionEditPart) {
                    GraphicalEditPart sourceEditPart = (GraphicalEditPart) ((ConnectionEditPart) parentEditPart)
                            .getSource();
                    sourceFigure = sourceEditPart.getFigure();
                }
                Point labelLocation = new Point(edgeLabelLayout.getXpos(),
                        edgeLabelLayout.getYpos());

                /**
                 * IF THE LAYOUT ALG. DOES NOT PROVIDE VALID LABEL POS, USE
                 * THEN ALSO GMF TO POSITION LABELS
                 */
                if (labelLocation.x == 0 && labelLocation.y == 0) {
                    newLocation = new PrecisionPoint(edgeLabelEditPart
                            .getReferencePoint().x, edgeLabelEditPart
                            .getReferencePoint().y);
                } else {
                    Point newLocationNormal = translateFromTo(labelLocation,
                            sourceFigure, connectionLayer);
                    newLocation = new PrecisionPoint(newLocationNormal.x,
                            newLocationNormal.y);
                }

                Point moveDelta = new PrecisionPoint(newLocation.preciseX
                        - oldLocation.x, newLocation.preciseY - oldLocation.y);
                moveDelta.performScale(zoomLevel);
                changeBoundsRequest.setMoveDelta(moveDelta);
                changeBoundsRequest.setLocation(newLocation);

                // haf - 2009-03-27
                // Don't use the setBoundsCommand given from the
                // GMF edit parts from the changeBoundsRequest. It
                // will create a new relative position relative to the
                // OLD position of the edge. This will result in wrong
                // coordinates if the edge is moved too. Hence it only
                // works if the edge is not moved, e.g. if the whole
                // layout procedure is done twice.
                // The wrong command is returned by the
                // NonResizableLabelEditPolicy.
                //
                // Here we have to build the command manually which means
                // we have to calculate the future relative position to the
                // future reference point of the parent edge. We use some
                // internal helper classes of GMF for that.

                // TODO: Put this in an EditPolicy and use a Request to get the
                // Command

                // get NEW bend points for the parent edge
                PointList parentBendPoints = getAbsoluteBendPoints(
                        (KEdge)edgeLabel.getParent(), sourceFigure);
                // get the referencePoint for the label in the future
                Point refPoint = PointListUtilities
                        .calculatePointRelativeToLine(parentBendPoints, 0,
                                getLocation(edgeLabelEditPart), true);
                // the Figure is required
                IFigure labelFigure = edgeLabelEditPart.getFigure();
                // get the future bounds of the label
                Rectangle targetBounds = labelFigure.getBounds();
                targetBounds.x = newLocation.x;
                targetBounds.y = newLocation.y;
                // get the new relative location
                Point normalPoint = LabelHelper
                        .offsetFromRelativeCoordinate(labelFigure,
                                targetBounds, parentBendPoints, refPoint);
                // manually create a SetBoundsCommand
                ICommand moveCommand = new SetBoundsCommand(
                        edgeLabelEditPart.getEditingDomain(),
                        DiagramUIMessages.MoveLabelCommand_Label_Location,
                        new EObjectAdapter((View) edgeLabelEditPart.getModel()),
                        normalPoint);
                edgeLabelsCompoundCommand.add(new ICommandProxy(moveCommand));
                // refresh the label such that the label content's bounds get updated
                edgeLabelsCompoundCommand.add(refreshLabel(labelFigure));
            }
        }
        return edgeLabelsCompoundCommand;
    }

    /**
     * Creates a Command to call the layout() method to a
     * figure if it is a WrappingLabel. This is intended
     * to refresh the bounds of the children of the WrappingLabel.
     * Otherwise the text contents of the label might not be redrawn
     * correctly. The command does nothing if the figure is not
     * a WrappingLabel.
     * @author haf
     * @param labelFigure any IFigure
     * @return Command that will call layout()
     */
    private Command refreshLabel(final IFigure labelFigure) {
        Command cmd = new Command() {
            @Override
            public void execute() {
                super.execute();
                // mark the figure as dirty in order that the UpdateManager will redraw it
                labelFigure.invalidate();
                }
        };
        return cmd;
    }

    /**
     * Maps the keypoint of an LabelEditPart to the distance on its associated
     * edge in percent. E.g. a label with keypoint ConnectionLocator.MIDDLE will
     * return 50%.
     * 
     * @param labelEditPart
     * @return percentage of the distance of the label on its associated edge
     */
    private int getLocation(LabelEditPart labelEditPart) {
        switch (labelEditPart.getKeyPoint()) {
        case ConnectionLocator.SOURCE:
            return LabelViewConstants.TARGET_LOCATION;
        case ConnectionLocator.TARGET:
            return LabelViewConstants.SOURCE_LOCATION;
        case ConnectionLocator.MIDDLE:
            return LabelViewConstants.MIDDLE_LOCATION;
        default:
            return LabelViewConstants.MIDDLE_LOCATION;
        }
    }
    
    

    /*
     * (non-Javadoc)
     * @see de.cau.cs.kieler.kiml.ui.layout.AbstractLayoutGraphApplier#updatePreferences()
     */
    protected void updatePreferences() {

        // FIXME no preferences here!
        prefUseGMFLabelLocation = false;
        prefSmoothTransitions = false;

    }

    /**
     * Creates source and target anchor commands and appends them to the
     * compound command passed in. Returns a line segment ends of which are the
     * new source and target anchor reference points for further use in the
     * command setting the bend points.
     * 
     * This code is taken from the Eclipse internal ArrangeAll action
     * implemented in the DefaultProvider and slightly modified to KIML needs.
     * Notice that KIML does not have to do anything with the Eclipse internal
     * arrange mechanism.
     * 
     * @see org.eclipse.gmf.runtime.diagram.ui.providers.internal.DefaultProvider
     * 
     * @author haf
     * 
     * @param cc
     *            command to add anchors commands to
     * @param sourceAnchorLocation
     *            the source anchor location coordinates
     * @param targetAnchorLocation
     *            the target anchor location coordinates
     * @param source
     *            source node
     * @param target
     *            target node
     * @param cep
     *            connection edit part
     * @param diffX
     *            x axis offset
     * @param diffY
     *            y axis offset
     * @return <code>LineSeg</code> origin is the new source anchor reference
     *         point and origin is the new target anchor reference point
     */
    protected LineSeg addAnchorsCommands(CompoundCommand cc,
            Point sourceAnchorLocation, Point targetAnchorLocation,
            KEdge edge) {
        ConnectionEditPart cep = layoutEdge2EditPart.get(edge);

        // Edit Parts that the connection should dock to
        GraphicalEditPart sourceEP = null;
        GraphicalEditPart targetEP = null;
        // Bounds of the element at that the connection should dock to
        Rectangle sourceExt = null;
        Rectangle targetExt = null;

        KNode sourceNode = edge.getSource();
        KShapeLayout sourceLayout = KimlLayoutUtil.getShapeLayout(sourceNode);
        KNode targetNode = edge.getTarget();
        KShapeLayout targetLayout = KimlLayoutUtil.getShapeLayout(targetNode);

        /*
         * Set the EditPart at that the anchors should dock to the source and
         * target nodes.
         */
        sourceEP = layoutNode2EditPart.get(sourceNode);
        sourceExt = new Rectangle((int) sourceLayout.getXpos(),
                (int) sourceLayout.getYpos(),
                (int) sourceLayout.getWidth(),
                (int) sourceLayout.getHeight());
        targetEP = layoutNode2EditPart.get(targetNode);
        targetExt = new Rectangle((int) targetLayout.getXpos(),
                (int) targetLayout.getYpos(),
                (int) targetLayout.getWidth(),
                (int) targetLayout.getHeight());

        // determine whether we have ports or not
        // if yes, use ports instead of the nodes
        KPort sourcePort = edge.getSourcePort();
        KPort targetPort = edge.getTargetPort();
        if (sourcePort != null) {
            // get the parent node because location of ports is relative to its
            // parent
            KShapeLayout portLayout = KimlLayoutUtil.getShapeLayout(sourcePort);
            KNode parentNode = sourcePort.getNode();
            KShapeLayout nodeLayout = KimlLayoutUtil.getShapeLayout(parentNode);
            sourceEP = layoutPort2EditPart.get(sourcePort);
            sourceExt = new Rectangle((int) (portLayout.getXpos()
                    + nodeLayout.getXpos()), (int) (portLayout.getYpos()
                    + nodeLayout.getYpos()), (int) portLayout.getWidth(),
                    (int) portLayout.getHeight());
        }
        if (targetPort != null) {
            KShapeLayout portLayout = KimlLayoutUtil.getShapeLayout(targetPort);
            KNode parentNode = targetPort.getNode();
            KShapeLayout nodeLayout = KimlLayoutUtil.getShapeLayout(parentNode);
            targetEP = layoutPort2EditPart.get(targetPort);
            targetExt = new Rectangle((int) (portLayout.getXpos()
                    + nodeLayout.getXpos()), (int) (portLayout.getYpos()
                    + nodeLayout.getYpos()), (int) portLayout.getWidth(),
                    (int) portLayout.getHeight());
        }

        // check whether any valid source and target was set
        if (sourceEP == null || sourceExt == null || targetEP == null
                || targetExt == null)
            return null;

        /*
         * If source or target anchor command won't be created or will be
         * non-executable, source or target reference point is assumed to be the
         * geometric center of a shape.
         */
        Point resultantSourceAnchorReference = sourceExt.getCenter();
        Point resultantTargetAnchorReference = targetExt.getCenter();

        PrecisionPoint sourceRatio = new PrecisionPoint((sourceAnchorLocation
                .preciseX() - sourceExt.preciseX())
                / sourceExt.preciseWidth(),
                (sourceAnchorLocation.preciseY() - sourceExt.preciseY())
                        / sourceExt.preciseHeight());
        PrecisionPoint targetRatio = new PrecisionPoint((targetAnchorLocation
                .preciseX() - targetExt.preciseX())
                / targetExt.preciseWidth(),
                (targetAnchorLocation.preciseY() - targetExt.preciseY())
                        / targetExt.preciseHeight());

        /*
         * Need to fake reconnection of the ends of the connection. Currently
         * existing figure coordinates (old coordinates) needs to be used for
         * this, since the reconnection location is passed in absolute
         * coordinates.
         */
        if (cep.getSource().equals(sourceEP)) {
            ReconnectRequest reconnectRequest = new ReconnectRequest(
                    org.eclipse.gef.RequestConstants.REQ_RECONNECT_SOURCE);
            reconnectRequest.setConnectionEditPart(cep);
            reconnectRequest.setTargetEditPart(cep.getSource());
            IFigure sourceFig = ((GraphicalEditPart) cep.getSource())
                    .getFigure();
            Point sourceAnchorReference = new PrecisionPoint(sourceFig
                    .getBounds().preciseX()
                    + sourceRatio.preciseX()
                    * sourceFig.getBounds().preciseWidth(), sourceFig
                    .getBounds().preciseY()
                    + sourceRatio.preciseY()
                    * sourceFig.getBounds().preciseHeight());
            sourceFig.translateToAbsolute(sourceAnchorReference);
            reconnectRequest.setLocation(sourceAnchorReference);
            Command sourceAnchorCommand = cep.getSource().getCommand(
                    reconnectRequest);
            if (sourceAnchorCommand != null && sourceAnchorCommand.canExecute()) {
                cc.add(sourceAnchorCommand);
                if (((Connection) cep.getFigure()).getSourceAnchor() instanceof BaseSlidableAnchor) {
                    if (sourceAnchorCommand instanceof ICommandProxy) {
                        updateNewSlidingAnchorReferenceRatio(
                                (ICommandProxy) sourceAnchorCommand, true,
                                sourceRatio);
                    }
                    resultantSourceAnchorReference = new PrecisionPoint(
                            sourceExt.preciseWidth() * sourceRatio.preciseX()
                                    + sourceExt.preciseX(), sourceExt
                                    .preciseHeight()
                                    * sourceRatio.preciseY()
                                    + sourceExt.preciseY());
                }
            }
        } else {
            resultantSourceAnchorReference = getNewAnchorReferencePoint(
                    sourceEP, sourceExt, ((Connection) cep.getFigure())
                            .getSourceAnchor().getReferencePoint());
        }

        if (cep.getTarget().equals(targetEP)) {
            ReconnectRequest reconnectRequest = new ReconnectRequest(
                    org.eclipse.gef.RequestConstants.REQ_RECONNECT_TARGET);
            reconnectRequest.setConnectionEditPart(cep);
            reconnectRequest.setTargetEditPart(cep.getTarget());
            IFigure targetFig = ((GraphicalEditPart) cep.getTarget())
                    .getFigure();
            Point targetAnchorReference = new PrecisionPoint(targetFig
                    .getBounds().preciseX()
                    + targetRatio.preciseX()
                    * targetFig.getBounds().preciseWidth(), targetFig
                    .getBounds().preciseY()
                    + targetRatio.preciseY()
                    * targetFig.getBounds().preciseHeight());
            targetFig.translateToAbsolute(targetAnchorReference);
            reconnectRequest.setLocation(targetAnchorReference);
            Command targetAnchorCommand = cep.getTarget().getCommand(
                    reconnectRequest);
            if (targetAnchorCommand != null && targetAnchorCommand.canExecute()) {
                cc.add(targetAnchorCommand);
                if (((Connection) cep.getFigure()).getTargetAnchor() instanceof BaseSlidableAnchor) {
                    if (targetAnchorCommand instanceof ICommandProxy) {
                        updateNewSlidingAnchorReferenceRatio(
                                (ICommandProxy) targetAnchorCommand, false,
                                targetRatio);
                    }
                    resultantTargetAnchorReference = new PrecisionPoint(
                            targetExt.preciseWidth() * targetRatio.preciseX()
                                    + targetExt.preciseX(), targetExt
                                    .preciseHeight()
                                    * targetRatio.preciseY()
                                    + targetExt.preciseY());
                }
            }
        } else {
            resultantTargetAnchorReference = getNewAnchorReferencePoint(
                    targetEP, targetExt, ((Connection) cep.getFigure())
                            .getTargetAnchor().getReferencePoint());
        }
        return new LineSeg(resultantSourceAnchorReference,
                resultantTargetAnchorReference);
    }

    private void updateNewSlidingAnchorReferenceRatio(
            ICommandProxy setAnchorCommand, boolean source, PrecisionPoint ratio) {
        /*
         * Find the SetConnectionAnchorsCommand
         */
        SetConnectionAnchorsCommand cmd = findSetConnectionAnchorsCommand(setAnchorCommand
                .getICommand());
        if (cmd != null) {
            PrecisionPoint newRatio = null;
            if (source) {
                newRatio = cmd.getNewSourceTerminal() == null ? new PrecisionPoint(
                        0.5, 0.5)
                        : BaseSlidableAnchor.parseTerminalString(cmd
                                .getNewSourceTerminal());
            } else {
                newRatio = cmd.getNewTargetTerminal() == null ? new PrecisionPoint(
                        0.5, 0.5)
                        : BaseSlidableAnchor.parseTerminalString(cmd
                                .getNewTargetTerminal());
            }
            if (newRatio != null) {
                ratio.preciseX = newRatio.preciseX;
                ratio.preciseY = newRatio.preciseY;
                ratio.updateInts();
            }
        }
    }

    private SetConnectionAnchorsCommand findSetConnectionAnchorsCommand(
            ICommand cmd) {
        if (cmd instanceof SetConnectionAnchorsCommand) {
            return (SetConnectionAnchorsCommand) cmd;
        } else if (cmd instanceof CompositeCommand) {
            for (Iterator<?> itr = ((CompositeCommand) cmd).listIterator(); itr
                    .hasNext();) {
                ICommand childCmd = (ICommand) itr.next();
                SetConnectionAnchorsCommand setAnchorsCmd = findSetConnectionAnchorsCommand(childCmd);
                if (setAnchorsCmd != null) {
                    return setAnchorsCmd;
                }
            }
        }
        return null;
    }

    private Point getNewAnchorReferencePoint(GraphicalEditPart gep,
            Rectangle nodeBoundsOnDiagram, Point oldAbsReference) {
        PrecisionPoint parentLocation = new PrecisionPoint(gep.getFigure()
                .getBounds().getLocation());
        gep.getFigure().translateToAbsolute(parentLocation);
        PrecisionDimension diff = new PrecisionDimension(oldAbsReference
                .preciseX()
                - parentLocation.preciseX(), oldAbsReference.preciseY()
                - parentLocation.preciseY());
        return nodeBoundsOnDiagram.getLocation().translate(diff);
    }

}

package de.cau.cs.kieler.kiml.ui.diagramlayouter;

import org.eclipse.draw2d.ConnectionLayer;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.PrecisionDimension;
import org.eclipse.draw2d.geometry.PrecisionPoint;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.editparts.ScalableFreeformRootEditPart;
import org.eclipse.gef.editparts.ZoomManager;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramRootEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.LabelEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramCommandStack;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.gmf.runtime.diagram.ui.requests.SetAllBendpointRequest;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;
import org.eclipse.swt.SWT;
import org.eclipse.ui.PlatformUI;

import de.cau.cs.kieler.kiml.layout.KimlLayoutPlugin;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KEdgeLabel;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KEdgeLabelLayout;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KEdgeLayout;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutEdge;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutNode;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutPort;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KNodeLayout;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KPoint;
import de.cau.cs.kieler.kiml.layout.util.KimlLayoutPreferenceConstants;
import de.cau.cs.kieler.kiml.ui.helpers.KimlMetricsHelper;
import de.cau.cs.kieler.kiml.ui.policies.LayoutEditPolicy;

public class KimlGenericLayoutGraphApplier extends KimlAbstractLayoutGraphApplier {

	/* preference settings */
	private boolean prefUseGMFLabelLocation = false;
	private boolean prefSmoothTransitions = false;
	
	@Override
	protected void doApplyLayoutGraph() {
		
		// get zoom level
		double zoomLevel = 1.0;
		ZoomManager zm = (ZoomManager) PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getActivePage().getActiveEditor()
				.getAdapter(ZoomManager.class);
		if (zm != null)
			zoomLevel = zm.getZoom();
		ScalableFreeformRootEditPart sfrep = (ScalableFreeformRootEditPart) layoutRootPart
				.getRoot();
		ConnectionLayer connectionLayer = (ConnectionLayer) sfrep
				.getLayer(DiagramRootEditPart.CONNECTION_LAYER);
		connectionLayer.setAntialias(SWT.ON);

		// apply node layouts
		CompoundCommand nodesCC = new CompoundCommand();
		for (KLayoutNode layoutNode : layoutNode2EditPart.keySet()) {
			GraphicalEditPart nodeItem = layoutNode2EditPart.get(layoutNode);
			KNodeLayout nodeLayout = layoutNode.getLayout();
			ChangeBoundsRequest changeBoundsRequest = new ChangeBoundsRequest(
					RequestConstants.REQ_RESIZE);
			changeBoundsRequest.setEditParts(nodeItem);

			Dimension oldSize = nodeItem.getFigure().getBounds().getSize();
			PrecisionDimension newSize = new PrecisionDimension(nodeLayout
					.getSize().getWidth(), nodeLayout.getSize().getHeight());

			Dimension sizeDelta = new PrecisionDimension(newSize.preciseWidth
					- oldSize.width, newSize.preciseHeight - oldSize.height);
			changeBoundsRequest.setResizeDirection(PositionConstants.CENTER);
			changeBoundsRequest.setSizeDelta(sizeDelta.scale(zoomLevel));

			Point oldLocation = nodeItem.getFigure().getBounds().getLocation();
			PrecisionPoint newLocation = new PrecisionPoint(nodeLayout
					.getLocation().getX(), nodeLayout.getLocation().getY());

			Point moveDelta = new PrecisionPoint(newLocation.preciseX
					- oldLocation.x, newLocation.preciseY - oldLocation.y);
			changeBoundsRequest.setMoveDelta(moveDelta.scale(zoomLevel));
			changeBoundsRequest.setLocation(newLocation);

			nodesCC.add(nodeItem.getCommand(changeBoundsRequest));
		}

		// apply port layouts
		CompoundCommand portsCC = new CompoundCommand();
		for (KLayoutPort port : layoutPort2EditPart.keySet()) {
			GraphicalEditPart portItem = layoutPort2EditPart.get(port);
			KPoint portLocation = port.getLayout().getLocation();
			Point nodeLocation = layoutNode2EditPart.get(port.getNode())
					.getFigure().getBounds().getLocation();
			ChangeBoundsRequest changeBoundsRequest = new ChangeBoundsRequest(
					RequestConstants.REQ_MOVE);
			changeBoundsRequest.setEditParts(portItem);

			Point oldLocation = portItem.getFigure().getBounds().getLocation();
			PrecisionPoint newLocation = new PrecisionPoint(portLocation.getX()
					+ nodeLocation.x, portLocation.getY() + nodeLocation.y);

			Point moveDelta = new PrecisionPoint(newLocation.preciseX
					- oldLocation.x, newLocation.preciseY - oldLocation.y);
			changeBoundsRequest.setMoveDelta(moveDelta.scale(zoomLevel));
			changeBoundsRequest.setLocation(newLocation);

			// set the automatic layout option in the extended data
			changeBoundsRequest.getExtendedData().put(
					LayoutEditPolicy.AUTO_LAYOUT_KEY, Boolean.TRUE);
			portsCC.add(portItem.getCommand(changeBoundsRequest));
		}

		// apply edge layouts
		final CompoundCommand edgesCC = new CompoundCommand();
		for (KLayoutEdge edge : layoutEdge2EditPart.keySet()) {
			ConnectionEditPart connectionItem = layoutEdge2EditPart.get(edge);

			/*
			 * if this connection is a polyline connection, see if it should be
			 * routed smoothly. This is an attribute of a polyline connection.
			 */
			if (connectionItem.getFigure() instanceof PolylineConnectionEx) {
				PolylineConnectionEx polyline = ((PolylineConnectionEx) connectionItem
						.getFigure());

				if (prefSmoothTransitions) {
					polyline.setSmoothness(PolylineConnectionEx.SMOOTH_NORMAL);
				} else {
					polyline.setSmoothness(PolylineConnectionEx.SMOOTH_NONE);
				}
			}

			KEdgeLayout edgeLayout = edge.getLayout();
			PointList pointList = new PointList();

			// set start point
			Point startPoint = KimlMetricsHelper.kPoint2Point(edgeLayout
					.getSourcePoint());
			pointList.addPoint(startPoint);

			// set grid points
			for (KPoint gridPoint : edgeLayout.getGridPoints()) {
				Point point = KimlMetricsHelper.kPoint2Point(gridPoint);
				pointList.addPoint(point);
			}

			// set end point
			Point endPoint = KimlMetricsHelper.kPoint2Point(edgeLayout
					.getTargetPoint());
			pointList.addPoint(endPoint);

			// create request and add it
			SetAllBendpointRequest request = new SetAllBendpointRequest(
					RequestConstants.REQ_SET_ALL_BENDPOINT, pointList,
					startPoint, endPoint);
			edgesCC.add(connectionItem.getCommand(request));
		}

		// apply edge label layouts
		CompoundCommand edgeLabelsCC = new CompoundCommand();
		for (KEdgeLabel edgeLabel : edgeLabel2EditPart.keySet()) {
			LabelEditPart edgeLabelEditPart = edgeLabel2EditPart.get(edgeLabel);
			KEdgeLabelLayout edgeLabelLayout = edgeLabel.getLabelLayout();
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
				Point newLocationNormal = translateFromTo(KimlMetricsHelper
						.kPoint2Point(edgeLabelLayout.getLocation()),
						sourceFigure, connectionLayer);
				newLocation = new PrecisionPoint(newLocationNormal.x,
						newLocationNormal.y);
			}

			Point moveDelta = new PrecisionPoint(newLocation.preciseX
					- oldLocation.x, newLocation.preciseY - oldLocation.y);
			changeBoundsRequest.setMoveDelta(moveDelta.scale(zoomLevel));
			changeBoundsRequest.setLocation(newLocation);

			edgeLabelsCC.add(edgeLabelEditPart.getCommand(changeBoundsRequest));
		}

		Object adapter = PlatformUI.getWorkbench().getActiveWorkbenchWindow()
				.getActivePage().getActiveEditor().getAdapter(
						CommandStack.class);

		if (adapter instanceof DiagramCommandStack) {
			final DiagramCommandStack commandStack = (DiagramCommandStack) adapter;
			CompoundCommand compoundCommand = new CompoundCommand();
			compoundCommand.setLabel("Layout"); //$NON-NLS-1$
			if (nodesCC.size() != 0)
				compoundCommand.add(nodesCC);
			if (portsCC.size() != 0)
				compoundCommand.add(portsCC);
			if (edgesCC.size() != 0)
				compoundCommand.add(edgesCC);
			if (edgeLabelsCC.size() != 0)
				compoundCommand.add(edgeLabelsCC);
			commandStack.execute(compoundCommand);
		}
	}

	protected void updatePreferences() {
		
		/* fetch preferences */
		prefUseGMFLabelLocation = KimlLayoutPlugin
				.getDefault()
				.getPreferenceStore()
				.getBoolean(
						KimlLayoutPreferenceConstants.PREF_DIAGRAMLAYOUTERS_USE_GMF_TO_LAYOUT_CONNECTION_LABELS);

		prefSmoothTransitions = KimlLayoutPlugin
				.getDefault()
				.getPreferenceStore()
				.getBoolean(
						KimlLayoutPreferenceConstants.PREF_DIAGRAMLAYOUTERS_SMOOTHEN_EDGES);

	}

	/**
	 * Helper function used when translating the location for a connection or a
	 * connection label as provided by the layout provider to the connection
	 * layer. The layout provider returns relative positions for the connection
	 * points for every level of a possible hierarchy, whereas in the GMF
	 * diagram all the connections are draw plainly on the special connection
	 * layer with absolute coordinates.
	 * 
	 * @param point
	 *            The Point which should be translated
	 * @param from
	 *            The Figure with the coordinate system from which the given
	 *            Point should be translated
	 * @param to
	 *            The Figure with the coordinate system to which the given Point
	 *            should be translated
	 * @return The translated Point with its location now in the coordinate
	 *         system of the <b>to</b> Figure
	 */
	private Point translateFromTo(Point point, IFigure from, IFigure to) {
		from.translateToAbsolute(point);
		to.translateToRelative(point);
		return point;
	}

}

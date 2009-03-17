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
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramRootEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.LabelEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramCommandStack;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.gmf.runtime.diagram.ui.requests.SetAllBendpointRequest;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;
import org.eclipse.swt.SWT;

import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KEdgeLabel;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KEdgeLabelLayout;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KEdgeLayout;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutEdge;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutNode;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutPort;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KNodeLayout;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KPoint;
import de.cau.cs.kieler.kiml.layout.util.KimlLayoutPreferenceConstants;
import de.cau.cs.kieler.kiml.ui.KimlUiPlugin;
import de.cau.cs.kieler.kiml.ui.helpers.KimlMetricsHelper;
import de.cau.cs.kieler.kiml.ui.policies.LayoutEditPolicy;

/**
 * A generic implementation of the {@link KimlAbstractLayoutGraphApplier}.
 * 
 * @author <a href="mailto:ars@informatik.uni-kiel.de">Arne Schipper</a>
 * @author <a href="mailto:msp@informatik.uni-kiel.de">Miro Spönemann</a>
 */
public class KimlGenericLayoutGraphApplier extends
		KimlAbstractLayoutGraphApplier {

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
	 * de.cau.cs.kieler.kiml.ui.diagramlayouter.KimlAbstractLayoutGraphApplier
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
		for (KLayoutNode layoutNode : layoutNode2EditPart.keySet()) {
			GraphicalEditPart nodeEditPart = layoutNode2EditPart
					.get(layoutNode);
			KNodeLayout nodeLayout = layoutNode.getLayout();
			ChangeBoundsRequest changeBoundsRequest = new ChangeBoundsRequest(
					RequestConstants.REQ_RESIZE);
			changeBoundsRequest.setEditParts(nodeEditPart);

			Dimension oldSize = nodeEditPart.getFigure().getBounds().getSize();
			PrecisionDimension newSize = new PrecisionDimension(nodeLayout
					.getSize().getWidth(), nodeLayout.getSize().getHeight());

			Dimension sizeDelta = new PrecisionDimension(newSize.preciseWidth
					- oldSize.width, newSize.preciseHeight - oldSize.height);
			changeBoundsRequest.setResizeDirection(PositionConstants.CENTER);
			changeBoundsRequest.setSizeDelta(sizeDelta.scale(zoomLevel));

			Point oldLocation = nodeEditPart.getFigure().getBounds()
					.getLocation();
			PrecisionPoint newLocation = new PrecisionPoint(nodeLayout
					.getLocation().getX(), nodeLayout.getLocation().getY());

			Point moveDelta = new PrecisionPoint(newLocation.preciseX
					- oldLocation.x, newLocation.preciseY - oldLocation.y);
			changeBoundsRequest.setMoveDelta(moveDelta.scale(zoomLevel));
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
	private CompoundCommand doApplyPortLayout() {
		CompoundCommand portsCompoundCommand = new CompoundCommand();
		for (KLayoutPort port : layoutPort2EditPart.keySet()) {
			GraphicalEditPart portEditPart = layoutPort2EditPart.get(port);
			KPoint portLocation = port.getLayout().getLocation();
			Point nodeLocation = layoutNode2EditPart.get(port.getNode())
					.getFigure().getBounds().getLocation();
			ChangeBoundsRequest changeBoundsRequest = new ChangeBoundsRequest(
					RequestConstants.REQ_MOVE);
			changeBoundsRequest.setEditParts(portEditPart);

			Point oldLocation = portEditPart.getFigure().getBounds()
					.getLocation();
			PrecisionPoint newLocation = new PrecisionPoint(portLocation.getX()
					+ nodeLocation.x, portLocation.getY() + nodeLocation.y);

			Point moveDelta = new PrecisionPoint(newLocation.preciseX
					- oldLocation.x, newLocation.preciseY - oldLocation.y);
			changeBoundsRequest.setMoveDelta(moveDelta.scale(zoomLevel));
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
		for (KLayoutEdge edge : layoutEdge2EditPart.keySet()) {
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

			KEdgeLayout edgeLayout = edge.getLayout();
			PointList pointList = new PointList();

			// set start point
			Point startPoint = KimlMetricsHelper.kPoint2Point(edgeLayout
					.getSourcePoint());
			pointList.addPoint(startPoint);

			// set grid points
			for (KPoint gridPoint : edgeLayout.getBendPoints()) {
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
			edgesCompoundCommand.add(connectionEditPart.getCommand(request));
		}
		return edgesCompoundCommand;
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
				Point labelLocation = KimlMetricsHelper
						.kPoint2Point(edgeLabelLayout.getLocation());

				/**
				 * HACK IF THE LAYOUT ALG. DOES NOT PROVIDE VALID LABEL POS, USE
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
			}

			Point moveDelta = new PrecisionPoint(newLocation.preciseX
					- oldLocation.x, newLocation.preciseY - oldLocation.y);
			changeBoundsRequest.setMoveDelta(moveDelta.scale(zoomLevel));
			changeBoundsRequest.setLocation(newLocation);

			edgeLabelsCompoundCommand.add(edgeLabelEditPart
					.getCommand(changeBoundsRequest));
		}
		return edgeLabelsCompoundCommand;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.cau.cs.kieler.kiml.ui.diagramlayouter.KimlAbstractLayoutGraphApplier
	 * #updatePreferences()
	 */
	protected void updatePreferences() {

		/* fetch preferences */
		prefUseGMFLabelLocation = KimlUiPlugin
				.getDefault()
				.getPreferenceStore()
				.getBoolean(
						KimlLayoutPreferenceConstants.PREF_DIAGRAMLAYOUTERS_USE_GMF_TO_LAYOUT_CONNECTION_LABELS);

		prefSmoothTransitions = KimlUiPlugin
				.getDefault()
				.getPreferenceStore()
				.getBoolean(
						KimlLayoutPreferenceConstants.PREF_DIAGRAMLAYOUTERS_SMOOTHEN_EDGES);

	}
}

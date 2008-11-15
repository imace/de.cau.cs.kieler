package edu.unikiel.rtsys.kieler.ssm.gmf.diagram.layouter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.draw2d.ConnectionLocator;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.NodeEditPart;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.editparts.ScalableFreeformRootEditPart;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.CompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramRootEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.LabelEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.figures.BorderItemsAwareFreeFormLayer;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramCommandStack;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramGraphicalViewer;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.gmf.runtime.diagram.ui.requests.SetAllBendpointRequest;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;
import org.eclipse.jface.viewers.IStructuredSelection;

import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutPlugin;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.EDGE_LABEL_PLACEMENT;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KDimension;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KEdge;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KEdgeLabel;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KEdgeLayout;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KLabel;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KLayoutGraph;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KNodeGroup;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KPoint;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphFactory;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.LAYOUT_TYPE;
import edu.unikiel.rtsys.kieler.kiml.layout.services.KimlAbstractLayouter;
import edu.unikiel.rtsys.kieler.kiml.layout.util.KimlLayoutPreferenceConstants;
import edu.unikiel.rtsys.kieler.kiml.layout.util.KimlLayoutUtil;
import edu.unikiel.rtsys.kieler.kiml.ui.helpers.KimlCommonHelper;
import edu.unikiel.rtsys.kieler.kiml.ui.helpers.KimlGMFLayoutHintHelper;
import edu.unikiel.rtsys.kieler.ssm.diagram.edit.parts.CompositeState2EditPart;
import edu.unikiel.rtsys.kieler.ssm.diagram.edit.parts.CompositeStateEditPart;
import edu.unikiel.rtsys.kieler.ssm.diagram.edit.parts.InitialStateEditPart;
import edu.unikiel.rtsys.kieler.ssm.diagram.edit.parts.RegionEditPart;
import edu.unikiel.rtsys.kieler.ssm.diagram.edit.parts.SafeStateMachineEditPart;
import edu.unikiel.rtsys.kieler.ssm.diagram.edit.parts.SimpleStateEditPart;

public class KimlSSMDiagramLayouter extends KimlAbstractLayouter {

	private Map<GraphicalEditPart, KNodeGroup> nodeEditPart2NodeGroup = new HashMap<GraphicalEditPart, KNodeGroup>();
	private Map<KNodeGroup, GraphicalEditPart> nodeGroup2NodeEditPart = new HashMap<KNodeGroup, GraphicalEditPart>();
	private Map<KEdge, ConnectionEditPart> edge2ConnectionEditPart = new HashMap<KEdge, ConnectionEditPart>();
	private Map<KLabel, LabelEditPart> label2LabelEditPart = new HashMap<KLabel, LabelEditPart>();
	private CommandStack commandStack = null;

	private GraphicalEditPart rootPart;
	private KLayoutGraph layoutGraph;
	private double zoomLevel = 1.0;
	private boolean prefUseGMFLabelLocation;
	private boolean prefSmoothTransitions = false;
	private BorderItemsAwareFreeFormLayer primaryLayer;
	private boolean toggleVisible;


	/*------------------------------------------------------------------------------*/
	/*-----------------------------APPLICATION OF LAYOUT----------------------------*/
	/*------------------------------------------------------------------------------*/

	@Override
	protected void applyLayout() {

		CompoundCommand compoundCommand = new CompoundCommand();
		compoundCommand.setLabel("SSM Diagram Layout");

		GraphicalEditPart gep = nodeGroup2NodeEditPart.get(layoutGraph
				.getTopGroup());

		if (gep != null) {
			ChangeBoundsRequest changeBoundsRequest = new ChangeBoundsRequest(
					RequestConstants.REQ_RESIZE);
			changeBoundsRequest.setEditParts(gep);

			Dimension oldSize = gep.getFigure().getBounds().getSize();
			Dimension newSize = KimlCommonHelper
					.kDimension2Dimension(layoutGraph.getTopGroup().getLayout()
							.getSize());

			if (newSize != null && newSize.height != 0 && newSize.width != 0) {
				Dimension sizeDelta = newSize.getExpanded(oldSize.negate());
				changeBoundsRequest
						.setResizeDirection(PositionConstants.CENTER);
				changeBoundsRequest.setSizeDelta(sizeDelta.scale(zoomLevel));
			}

			compoundCommand.add(gep.getCommand(changeBoundsRequest));
		}

		applyNodeLayoutRecursively(layoutGraph.getTopGroup(), compoundCommand);

		commandStack.execute(compoundCommand);

	}

	/**
	 * Recursive function to wander through the children of a node.
	 * 
	 * @param currentGroup
	 *            The parent group containing the children to be processed.
	 * @param compoundCommand
	 *            Command accumulator
	 * @param offset
	 *            Offset of previously laid out groups if intermediate groups
	 *            were created that do not belong to actual 'physical' nodes in
	 *            the source document
	 */
	private void applyNodeLayoutRecursively(KNodeGroup currentGroup,
			CompoundCommand compoundCommand) {

		for (KNodeGroup childGroup : currentGroup.getSubNodeGroups()) {
			GraphicalEditPart gep = nodeGroup2NodeEditPart.get(childGroup);

			/*
			 * There is a GraphicalEditPart for this NodeGroup. Apply the
			 * layout.
			 */
			if (gep != null) {

				ChangeBoundsRequest changeBoundsRequest = new ChangeBoundsRequest(
						RequestConstants.REQ_RESIZE);
				changeBoundsRequest.setEditParts(gep);

				Dimension oldSize = gep.getFigure().getBounds().getSize();
				Dimension newSize = KimlCommonHelper
						.kDimension2Dimension(childGroup.getLayout().getSize());

				if (newSize != null) {
					Dimension sizeDelta = newSize.getExpanded(oldSize.negate());
					changeBoundsRequest
							.setResizeDirection(PositionConstants.CENTER);
					changeBoundsRequest
							.setSizeDelta(sizeDelta.scale(zoomLevel));
				}

				Point oldLocation = gep.getFigure().getBounds().getLocation();
				Point newLocation = KimlCommonHelper.kPoint2Point(childGroup
						.getLayout().getLocation());

				if (newLocation != null) {
					Point moveDelta = newLocation.getTranslated(oldLocation
							.negate());
					changeBoundsRequest
							.setMoveDelta(moveDelta.scale(zoomLevel));
				}

				compoundCommand.add(gep.getCommand(changeBoundsRequest));

				// do not forget the edges
				applyEdgeLayout(childGroup, compoundCommand);

				// do the same for the children of the children
				applyNodeLayoutRecursively(childGroup, compoundCommand);

			}
		}
	}

	/**
	 * Function to lay out the edges correctly. Is just taken out of the
	 * <code>applyNodeLayoutRecursively</code> for readability reasons.
	 * 
	 * @param childGroup
	 *            This group's outgoing edges are processed
	 * @param compoundCommand
	 *            Command accumulator
	 * @param offset
	 *            Offset of previously laid out groups if intermediate groups
	 *            were created that do not belong to actual 'physical' nodes in
	 *            the source document
	 */
	private void applyEdgeLayout(KNodeGroup childGroup,
			CompoundCommand compoundCommand) {
		GraphicalEditPart sourceEditPart = nodeGroup2NodeEditPart
				.get(childGroup);
		for (KEdge edge : childGroup.getOutgoingEdges()) {
			ConnectionEditPart connection = edge2ConnectionEditPart.get(edge);

			if (connection.getFigure() instanceof PolylineConnectionEx) {
				PolylineConnectionEx polyline = ((PolylineConnectionEx) connection
						.getFigure());
				if (prefSmoothTransitions) {
					polyline.setSmoothness(PolylineConnectionEx.SMOOTH_NORMAL);
				} else {
					polyline.setSmoothness(PolylineConnectionEx.SMOOTH_NONE);
				}
				polyline.validate();
			}
			KEdgeLayout edgeLayout = edge.getLayout();
			PointList pointList = new PointList();

			// set start point
			Point startPoint = KimlCommonHelper.kPoint2Point(edgeLayout
					.getSourcePoint());
			pointList.addPoint(startPoint);

			// set grid points
			for (KPoint gridPoint : edgeLayout.getGridPoints()) {
				Point point = KimlCommonHelper.kPoint2Point(gridPoint);
				pointList.addPoint(point);
			}

			// set end point
			Point endPoint = KimlCommonHelper.kPoint2Point(edgeLayout
					.getTargetPoint());
			pointList.addPoint(endPoint);

			/*
			 * hack for the labels if set via GraphViz' location information.
			 * The transistions have to be set before, and not via a request
			 */
			if (!prefUseGMFLabelLocation) {
				Point translatedStartPoint = translateFromTo(KimlCommonHelper
						.kPoint2Point(edgeLayout.getSourcePoint()),
						sourceEditPart.getFigure(), primaryLayer);
				Point translatedEndPoint = translateFromTo(KimlCommonHelper
						.kPoint2Point(edgeLayout.getTargetPoint()),
						sourceEditPart.getFigure(), primaryLayer);
				/*
				 * setting of the endpoints works
				 */
				if (connection.getFigure() instanceof PolylineConnectionEx) {
					PolylineConnectionEx connFig = (PolylineConnectionEx) connection
							.getFigure();
					connFig.setStart(translatedStartPoint);
					connFig.setEnd(translatedEndPoint);
					connFig.revalidate();
				}
			}

			// create request and add it
			SetAllBendpointRequest request = new SetAllBendpointRequest(
					RequestConstants.REQ_SET_ALL_BENDPOINT, pointList,
					startPoint, endPoint);
			compoundCommand.add(connection.getCommand(request));

			// take also care of the labels
			applyEdgeLabelLayout(edge, compoundCommand);
		}
	}

	/**
	 * Function to lay out the edges correctly. Is just taken out of the
	 * <code>applyEdgeLayout</code> for readability reasons.
	 * 
	 * @param edge
	 *            The edge which labels should be laid out
	 * @param compound
	 *            Command accumulator
	 * @param offset
	 *            Offset of previously laid out groups if intermediate groups
	 *            were created that do not belong to actual 'physical' nodes in
	 *            the source document
	 */
	private void applyEdgeLabelLayout(KEdge edge,
			CompoundCommand compoundCommand) {

		KNodeGroup sourceNode = edge.getSource();
		GraphicalEditPart sourceEditPart = nodeGroup2NodeEditPart
				.get(sourceNode);

		for (KEdgeLabel edgeLabel : edge.getLabel()) {

			LabelEditPart labelEditPart = label2LabelEditPart.get(edgeLabel);
			// some sanity checks can not be bad
			if (labelEditPart != null) {

				Point oldLocation = labelEditPart.getFigure().getBounds()
						.getLocation();

				Point newLocation = new Point();

				if (prefUseGMFLabelLocation || toggleVisible) {
					newLocation = labelEditPart.getReferencePoint();
				} else {
					oldLocation = translateFromTo(labelEditPart.getFigure(),
							sourceEditPart.getFigure());
					newLocation = KimlCommonHelper.kPoint2Point(edgeLabel
							.getLabelLayout().getLocation());
				}

				Point moveDelta = newLocation.getTranslated(oldLocation
						.negate());

				ChangeBoundsRequest changeBoundsRequest = new ChangeBoundsRequest(
						RequestConstants.REQ_MOVE);
				changeBoundsRequest.setEditParts(labelEditPart);

				if (newLocation != null) {
					changeBoundsRequest
							.setMoveDelta(moveDelta.scale(zoomLevel));
				}

				compoundCommand.add(labelEditPart
						.getCommand(changeBoundsRequest));
			}
		}

	}

	@Override
	protected KLayoutGraph buildLayoutGraph() {
		layoutGraph = KimlLayoutGraphFactory.eINSTANCE.createKLayoutGraph();

		// set at least this to have a top node in the layout graph which is not
		KNodeGroup topNodeGroup = KimlLayoutUtil.createInitializedNodeGroup();
		layoutGraph.setTopGroup(topNodeGroup);

		if (rootPart.getClass().equals(CompositeState2EditPart.class)
				|| rootPart.getClass().equals(CompositeStateEditPart.class)
				|| rootPart.getClass().equals(RegionEditPart.class)) {
			processCommon(rootPart, topNodeGroup,
					new ArrayList<ConnectionEditPart>());
			processLayoutHints(rootPart, topNodeGroup);

			nodeEditPart2NodeGroup.put(rootPart, topNodeGroup);
			nodeGroup2NodeEditPart.put(topNodeGroup, rootPart);

			buildLayoutGraphRecursively(rootPart, topNodeGroup);
		} else if (rootPart.getClass().equals(SafeStateMachineEditPart.class)) {
			buildLayoutGraphRecursively(rootPart, topNodeGroup);
		}
		return layoutGraph;
	}

	/**
	 * Recursive helper function. This one is complicated as hell. So if you
	 * understand this, congratulations.
	 * 
	 * @param currentEditPart
	 *            The GraphicalEditPart which children will be processed
	 * @param currentNodeGroup
	 *            The corresponding KNodeGroup
	 */
	private void buildLayoutGraphRecursively(GraphicalEditPart currentEditPart,
			KNodeGroup currentNodeGroup) {

		// List to save some intermediate information. Is newly created
		// and populated each recursive call.
		ArrayList<ConnectionEditPart> connections = new ArrayList<ConnectionEditPart>();

		for (Object childEditPart : currentEditPart.getChildren()) {

			/* Simple State */
			if (childEditPart.getClass().equals(SimpleStateEditPart.class)) {
				KNodeGroup childNodeGroup = processGetNewSubNode(currentNodeGroup);
				processCommon((GraphicalEditPart) childEditPart,
						childNodeGroup, connections);
			}
			/* Initial State */
			else if (childEditPart.getClass()
					.equals(InitialStateEditPart.class)) {
				KNodeGroup childNodeGroup = processGetNewSubNode(currentNodeGroup);
				processCommon((GraphicalEditPart) childEditPart,
						childNodeGroup, connections);
			}
			/* Composite State */
			else if (childEditPart.getClass().equals(
					CompositeState2EditPart.class)) {
				KNodeGroup childNodeGroup = processGetNewSubNode(currentNodeGroup);
				processCommon((GraphicalEditPart) childEditPart,
						childNodeGroup, connections);
				processLayoutHints((GraphicalEditPart) childEditPart,
						childNodeGroup);
				buildLayoutGraphRecursively((GraphicalEditPart) childEditPart,
						childNodeGroup);
			}

			/* Region */
			else if (childEditPart.getClass().equals(RegionEditPart.class)) {
				KNodeGroup childNodeGroup = processGetNewSubNode(currentNodeGroup);
				processCommon((GraphicalEditPart) childEditPart,
						childNodeGroup, connections);
				processLayoutHints((GraphicalEditPart) childEditPart,
						childNodeGroup);
				buildLayoutGraphRecursively((GraphicalEditPart) childEditPart,
						childNodeGroup);
			} else {
				/* compartment EditPart, fetch the children */
				buildLayoutGraphRecursively((GraphicalEditPart) childEditPart,
						currentNodeGroup);
			}
		}

		/*
		 * Finally process all the connections, as Emma has build all the needed
		 * KNodeGroups which act as source and target.
		 */
		processConnections(connections);
	}

	private KNodeGroup processGetNewSubNode(KNodeGroup currentNodeGroup) {
		KNodeGroup childNodeGroup = KimlLayoutUtil.createInitializedNodeGroup();
		currentNodeGroup.getSubNodeGroups().add(childNodeGroup);
		return childNodeGroup;
	}

	private KNodeGroup processCommon(GraphicalEditPart currentEditPart,
			KNodeGroup currenNodegroup,
			ArrayList<ConnectionEditPart> connections) {

		Rectangle childBounds = currentEditPart.getFigure().getBounds();

		// store all the connections to process them later
		for (Object conn : currentEditPart.getTargetConnections()) {
			if (conn instanceof ConnectionEditPart) {
				connections.add((ConnectionEditPart) conn);
			}
		}
		// set location
		currenNodegroup.getLayout().getLocation().setX(childBounds.x);
		currenNodegroup.getLayout().getLocation().setY(childBounds.y);

		// set size
		currenNodegroup.getLayout().getSize().setHeight(childBounds.height);
		currenNodegroup.getLayout().getSize().setWidth(childBounds.width);

		// set label and ID
		currenNodegroup.getLabel().setText(
				KimlCommonHelper.getShortLabel(currentEditPart));
		currenNodegroup.setIdString(KimlCommonHelper
				.getLongLabel(currentEditPart));

		// keep track of mapping between elements
		nodeEditPart2NodeGroup.put(currentEditPart, currenNodegroup);
		nodeGroup2NodeEditPart.put(currenNodegroup, currentEditPart);

		return currenNodegroup;
	}

	private void processLayoutHints(GraphicalEditPart currentEditPart,
			KNodeGroup currentNodeGroup) {
		LAYOUT_TYPE layoutType = LAYOUT_TYPE.DEFAULT;
		String layouterName = "";
		layoutType = KimlGMFLayoutHintHelper
				.getContainedElementsLayoutType((ShapeNodeEditPart) currentEditPart);
		layouterName = KimlGMFLayoutHintHelper
				.getContainedElementsLayouterName((ShapeNodeEditPart) currentEditPart);
		currentNodeGroup.getLayout().setLayoutType(layoutType);
		currentNodeGroup.getLayout().setLayouterName(layouterName);
		if (currentEditPart.getClass().equals(CompositeState2EditPart.class)
				|| currentEditPart.getClass().equals(
						CompositeStateEditPart.class)) {
			currentNodeGroup.getLayout().getInsets().setTop(25f);
		}
	}

	/**
	 * This function creates new KEdges and takes care of the labels for each
	 * connection identified in the <code>buildLayoutGraphRecursively</code>
	 * step before.
	 * 
	 * @param connections
	 *            The connections that were build for a certain Node before.
	 */
	private void processConnections(ArrayList<ConnectionEditPart> connections) {

		for (ConnectionEditPart connection : connections) {

			KEdge edge = KimlLayoutUtil.createInitializedEdge();
			edge.setSource(nodeEditPart2NodeGroup.get(connection.getSource()));
			edge.setTarget(nodeEditPart2NodeGroup.get(connection.getTarget()));
			edge2ConnectionEditPart.put(edge, connection);

			/*
			 * Process the label, at the moment 3 are hard coded. Actually no
			 * possibility to get the location of the head label from GraphViz.
			 * 
			 * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
			 * SOURCE and TARGET is exchanged when defining it in the.gmfgen
			 * file. So if Emma sets a label to be placed as TARGET on a
			 * connection (transition in the SSM case), then the label will show
			 * up next to the source node in the diagram editor. So correct it
			 * here, very ugly.
			 * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
			 */
			for (Object obj : connection.getChildren()) {
				if (obj instanceof LabelEditPart) {
					LabelEditPart labelEditPart = (LabelEditPart) obj;
					// labelEditPart.getFigure().setLocation(new Point());
					KDimension labelSize = KimlCommonHelper
							.dimension2KDimension(labelEditPart.getFigure()
									.getBounds().getSize());

					// head label
					if (labelEditPart.getKeyPoint() == ConnectionLocator.SOURCE) {
						String headLabel = KimlCommonHelper
								.getHeadLabel(connection);
						if (headLabel != null) {
							KEdgeLabel hLabel = KimlLayoutUtil
									.createInitializedEdgeLabel();
							hLabel.getLabelLayout().setLabelPlacement(
									EDGE_LABEL_PLACEMENT.HEAD);
							hLabel.getLabelLayout().setSize(labelSize);
							hLabel.setText(headLabel);
							edge.getLabel().add(hLabel);
							label2LabelEditPart.put(hLabel, labelEditPart);
						}
					}

					// middle label
					if (labelEditPart.getKeyPoint() == ConnectionLocator.MIDDLE) {
						String midLabel = KimlCommonHelper
								.getMidLabel(connection);
						if (midLabel != null) {
							KEdgeLabel mLabel = KimlLayoutUtil
									.createInitializedEdgeLabel();
							mLabel.getLabelLayout().setLabelPlacement(
									EDGE_LABEL_PLACEMENT.CENTER);
							mLabel.getLabelLayout().setSize(labelSize);
							mLabel.setText(midLabel);
							edge.getLabel().add(mLabel);
							label2LabelEditPart.put(mLabel, labelEditPart);
						}
					}

					// tail label
					if (labelEditPart.getKeyPoint() == ConnectionLocator.TARGET) {
						String tailLabel = KimlCommonHelper
								.getTailLabel(connection);
						if (tailLabel != null) {
							KEdgeLabel tLabel = KimlLayoutUtil
									.createInitializedEdgeLabel();
							tLabel.getLabelLayout().setLabelPlacement(
									EDGE_LABEL_PLACEMENT.TAIL);
							tLabel.getLabelLayout().setSize(labelSize);
							tLabel.setText(tailLabel);
							edge.getLabel().add(tLabel);
							label2LabelEditPart.put(tLabel, labelEditPart);
						}
					}
				}
			}
		}
	}

	@Override
	protected boolean init(Object target) {

		// get root part provided object
		rootPart = getRootPart(target);

		// get zooming level
		if (rootPart instanceof GraphicalEditPart
				&& ((GraphicalEditPart) rootPart).getRoot() instanceof ScalableFreeformRootEditPart) {
			GraphicalEditPart gep = (GraphicalEditPart) rootPart;
			// commandStack = gep.getViewer().getEditDomain().getCommandStack();
			commandStack = new DiagramCommandStack(null);
			ScalableFreeformRootEditPart sfrep = (ScalableFreeformRootEditPart) gep
					.getRoot();
			zoomLevel = sfrep.getZoomManager().getZoom();
			primaryLayer = (BorderItemsAwareFreeFormLayer) sfrep
					.getLayer(DiagramRootEditPart.PRIMARY_LAYER);
		} else {
			System.err.println("KimlSSMDiagramLayouter: Error: '" + rootPart
					+ "' is no an instance of GraphicalEditPart: ");
			return false;
		}
		if (commandStack == null) {
			System.err
					.println("KimlSSMDiagramLayouter: Error: commandStack == null");
			return false;
		}
		// handle edge label placement
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
		return true;
	}

	private GraphicalEditPart getRootPart(Object object) {
		GraphicalEditPart root = null;

		// no matter how much was selected, get the first element
		if (object instanceof IStructuredSelection) {
			IStructuredSelection selection = (IStructuredSelection) object;

			Object selectedObject = selection.getFirstElement();
			// if just one element was selected, use this, if NodeEditPart
			if (selection.size() == 1) {
				if (selectedObject instanceof NodeEditPart) {
					root = (NodeEditPart) selectedObject;
				} else if (selectedObject instanceof DiagramEditPart) {
					root = (GraphicalEditPart) ((DiagramEditPart) selectedObject)
							.getChildren().get(0);
				} else if (selectedObject instanceof CompartmentEditPart) {
					root = (GraphicalEditPart) ((CompartmentEditPart) selectedObject)
							.getParent();
				}
			}
			// more selected, find parent thereof
			else {
				root = findParentNode(selectedObject);
			}

		}
		if (object instanceof DiagramGraphicalViewer) {
			DiagramGraphicalViewer viewer = (DiagramGraphicalViewer) object;
			root = (GraphicalEditPart) viewer.getRootEditPart().getChildren()
					.get(0);
		}
		if (object instanceof DiagramEditor) {
			DiagramEditor editor = (DiagramEditor) object;
			root = (GraphicalEditPart) editor.getDiagramEditPart()
					.getChildren().get(0);
		}
		if (object instanceof DiagramEditPart) {
			DiagramEditPart dep = (DiagramEditPart) object;
			root = (GraphicalEditPart) dep.getChildren().get(0);
		}
		if (object instanceof GraphicalEditPart) {
			root = (GraphicalEditPart) root;
		}
		return root;
	}

	/*
	 * Recursive helper function to get a NodeEditPart parent for an object.
	 */
	private GraphicalEditPart findParentNode(Object current) {
		if (current instanceof GraphicalEditPart) {
			GraphicalEditPart aep = (GraphicalEditPart) current;
			if (aep.getParent() instanceof NodeEditPart)
				return (NodeEditPart) aep.getParent();
			else {
				GraphicalEditPart parent = findParentNode(aep.getParent());
				if (parent == null) {
					DiagramGraphicalViewer viewer = (DiagramGraphicalViewer) aep
							.getViewer();
					return (GraphicalEditPart) viewer.getRootEditPart()
							.getChildren().get(0);
				} else
					return parent;
			}
		} else
			return null;
	}

	private Point translateFromTo(IFigure from, IFigure to) {
		Rectangle newBounds = from.getBounds().getCopy();
		from.translateToAbsolute(newBounds);
		to.translateToRelative(newBounds);
		return newBounds.getLocation();
	}

	private Point translateFromTo(Point point, IFigure from, IFigure to) {
		from.translateToAbsolute(point);
		to.translateToRelative(point);
		return point;
	}
}

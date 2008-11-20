/*******************************************************************************
 * Copyright (c) 2008 Real-Time and Embedded Systems group
 *
 * INSERT LICENCE HERE
 *
 *
 * Author: Arne Schipper, ars@informatik.uni-kiel.de 
 *
 *******************************************************************************/
package edu.unikiel.rtsys.kieler.ssm.gmf.diagram.layouter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.draw2d.ConnectionLayer;
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
import org.eclipse.gmf.runtime.diagram.ui.figures.ShapeCompartmentFigure;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramCommandStack;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramGraphicalViewer;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.gmf.runtime.diagram.ui.requests.SetAllBendpointRequest;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;
import org.eclipse.gmf.runtime.draw2d.ui.internal.figures.AnimatableScrollPane;
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
import edu.unikiel.rtsys.kieler.ssm.diagram.edit.parts.CompositeStateCompositeStateCompartment2EditPart;
import edu.unikiel.rtsys.kieler.ssm.diagram.edit.parts.CompositeStateCompositeStateCompartmentEditPart;
import edu.unikiel.rtsys.kieler.ssm.diagram.edit.parts.CompositeStateEditPart;
import edu.unikiel.rtsys.kieler.ssm.diagram.edit.parts.InitialStateEditPart;
import edu.unikiel.rtsys.kieler.ssm.diagram.edit.parts.RegionEditPart;
import edu.unikiel.rtsys.kieler.ssm.diagram.edit.parts.RegionRegionCompartmentEditPart;
import edu.unikiel.rtsys.kieler.ssm.diagram.edit.parts.SafeStateMachineEditPart;
import edu.unikiel.rtsys.kieler.ssm.diagram.edit.parts.SimpleStateEditPart;
import edu.unikiel.rtsys.kieler.ssm.diagram.part.SafeStateMachineDiagramEditor;

/**
 * The layouter for SafeStateMachines as defined and used by the
 * {@link SafeStateMachineDiagramEditor}. This class implements the methods of
 * the {@link KimlAbstractLayouter} to perform the translation of a
 * SafeStateMachine diagram, or parts thereof, to the {@link KLayoutGraph} and
 * back, as well as some setup functions.
 * <p/>
 * The transformation is able to identify collapsed Regions and CompositeStates
 * and will treat them as such in the further layout process.
 * <p/>
 * This version is a simplified one which can just layout the main composite
 * elements, that are Regions and CompositeStates as a whole. However, this is
 * general what you want. If you want to layout parts of Regions and
 * CompositeStates separately, take a look at the
 * {@link KimlSSMDiagramGroupingLayouter}.
 * 
 * @author <a href="mailto:ars@informatik.uni-kiel.de">Arne Schipper</a>
 * @see KimlAbstractLayouter
 * @see KimlSSMDiagramGroupingLayouter
 */
public class KimlSSMDiagramLayouter extends KimlAbstractLayouter {

	/*
	 * HashMaps to keep track of the various mappings of EditParts to
	 * KLayoutGraph objects and vice versa
	 */
	private Map<GraphicalEditPart, KNodeGroup> nodeEditPart2NodeGroup = new HashMap<GraphicalEditPart, KNodeGroup>();
	private Map<KNodeGroup, GraphicalEditPart> nodeGroup2NodeEditPart = new HashMap<KNodeGroup, GraphicalEditPart>();
	private Map<KEdge, ConnectionEditPart> edge2ConnectionEditPart = new HashMap<KEdge, ConnectionEditPart>();
	private Map<KLabel, LabelEditPart> label2LabelEditPart = new HashMap<KLabel, LabelEditPart>();

	/* preference settings */
	private boolean prefUseGMFLabelLocation;
	private boolean prefSmoothTransitions = false;

	/* corresponding root parts */
	private GraphicalEditPart rootPart;
	private KLayoutGraph layoutGraph;

	/* defaults when collapsing composite states */
	private float widthCollapsed = 80f;
	private float heightCollapsed = 60f;

	/* some used objects */
	private CommandStack commandStack = null;
	private double zoomLevel = 1.0;
	private ConnectionLayer connectionLayer = null;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.unikiel.rtsys.kieler.kiml.layout.services.KimlAbstractLayouter#layout
	 * (java.lang.Object)
	 */
	public void layout(Object target) {
		super.layout(target);
		connectionLayer.revalidate();
		rootPart.refresh();
		super.layout(target);

	}

	/*------------------------------------------------------------------------------*/
	/*-----------------------------APPLICATION OF LAYOUT----------------------------*/
	/*------------------------------------------------------------------------------*/

	/**
	 * Performs the translation of the KLayoutGraph with position and size
	 * attributes back to the SSM Diagram. Uses several recursive helper methods
	 * to achieve this.
	 */
	@Override
	protected void applyLayout() {

		/*
		 * Emma is in the GMF environment, she uses commands to alter position
		 * and size attributes
		 */
		CompoundCommand compoundCommand = new CompoundCommand();
		compoundCommand.setLabel("SSM Diagram Layout");

		/* start with the top KNodeGroup */
		GraphicalEditPart gep = nodeGroup2NodeEditPart.get(layoutGraph
				.getTopGroup());

		if (gep != null) {

			/* create request for this EditPart */
			ChangeBoundsRequest changeBoundsRequest = new ChangeBoundsRequest(
					RequestConstants.REQ_RESIZE);
			changeBoundsRequest.setEditParts(gep);

			/* handle size, be aware of zoom level */
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

			/* handle position, be aware of zoom level */
			Point oldLocation = gep.getFigure().getBounds().getLocation();
			Point newLocation = KimlCommonHelper.kPoint2Point(layoutGraph
					.getTopGroup().getLayout().getLocation());

			if (newLocation != null) {
				Point moveDelta = newLocation.getTranslated(oldLocation
						.negate());
				changeBoundsRequest.setMoveDelta(moveDelta.scale(zoomLevel));
			}

			/* add command for this EditPart to list of commands */
			compoundCommand.add(gep.getCommand(changeBoundsRequest));
		}

		/* do this recursively for the the sub KNodeGroups of the top KNodeGroup */
		applyNodeLayoutRecursively(layoutGraph.getTopGroup(), compoundCommand);

		/* finally, execute all the commands */
		commandStack.execute(compoundCommand);
	}

	/**
	 * Recursive function to wander through the children of a KNodeGroup and
	 * collect all the resizing and reposition commands for the respective
	 * EditParts in the command accumulator.
	 * 
	 * @param currentGroup
	 *            The current parent group containing the children to be
	 *            processed.
	 * @param compoundCommand
	 *            Command accumulator
	 */
	private void applyNodeLayoutRecursively(KNodeGroup currentGroup,
			CompoundCommand compoundCommand) {

		/* process all the children */
		for (KNodeGroup childGroup : currentGroup.getSubNodeGroups()) {
			GraphicalEditPart gep = nodeGroup2NodeEditPart.get(childGroup);

			/*
			 * There is a GraphicalEditPart for this NodeGroup. Apply the
			 * layout. Same mechanism as in the non-recursive case.
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

				/* do not forget the edges */
				applyEdgeLayout(childGroup, compoundCommand);

				/* do the same for the children of the children */
				applyNodeLayoutRecursively(childGroup, compoundCommand);
			}
		}
	}

	/**
	 * Function to lay out the edges correctly. Is just taken out of the
	 * <code>applyNodeLayoutRecursively</code> for readability reasons.
	 * 
	 * @param currentGroup
	 *            This KNodeGroup's outgoing edges are processed
	 * @param compoundCommand
	 *            Command accumulator
	 */
	private void applyEdgeLayout(KNodeGroup currentGroup,
			CompoundCommand compoundCommand) {

		/* iterate through all the edges of the current KNodeGroup */
		for (KEdge edge : currentGroup.getOutgoingEdges()) {

			/* fetch corresponding EditPart for the KEdge */
			ConnectionEditPart connection = edge2ConnectionEditPart.get(edge);

			/*
			 * if this EditPart is a polyline connection, see if it should be
			 * routed smoothly. This is an attribute of a polyline connection.
			 */
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

			/* fetch layout information of the current KEdge */
			KEdgeLayout edgeLayout = edge.getLayout();

			/*
			 * edge grid points consist of a start and an end point, as well as
			 * an arbitrary number of helper points building up a polyline. No
			 * scaling is needed when settings the points of the edge. This
			 * seems to result out of the fact that the transitions are drawn
			 * directly on the connection layer, which has the same size as the
			 * primary layer.
			 */
			PointList pointList = new PointList();

			/* fetch start point */
			Point startPoint = KimlCommonHelper.kPoint2Point(edgeLayout
					.getSourcePoint());
			pointList.addPoint(startPoint);

			/* fetch grid/helper points */
			for (KPoint gridPoint : edgeLayout.getGridPoints()) {
				Point point = KimlCommonHelper.kPoint2Point(gridPoint);
				pointList.addPoint(point);
			}

			/* set end point */
			Point endPoint = KimlCommonHelper.kPoint2Point(edgeLayout
					.getTargetPoint());
			pointList.addPoint(endPoint);

			/*
			 * If Emma does not want the GMF internals to set the label
			 * position, but wants to use the label positions provided by the
			 * layout provider, some work and tricks are needed. If laying out a
			 * diagram from scratch, the edges/transitions may change
			 * considerably. The labels for the edges are connected to them and
			 * are moved together from the GMF framework when rearranging the
			 * edges. But this is done in one step when this translation
			 * algorithm has finished. Labels can, as all other parts, not be
			 * moved absolutely to a certain position, but must be moved
			 * relatively to their actual position to the new position through a
			 * delta. As said before, the position of the edge changes, affects
			 * the position of the label, and the delta of the label move is
			 * invalid. The workaround is to set the positions of the start and
			 * end point of the transition with 'brute force'. This moves the
			 * label beforehand to a reasonable position and yields relatively
			 * satisfying results.
			 */
			if (!prefUseGMFLabelLocation) {
				/*
				 * The connections are positioned, in contrast to States, which
				 * can be nested, absolutely on the connection layer, no matter
				 * to which sub state they belong. So they relative positions,
				 * relative to the current sub state, have to be translated to
				 * the primary layer.
				 */
				GraphicalEditPart sourceEditPart = nodeGroup2NodeEditPart
						.get(currentGroup);
				Point translatedStartPoint = translateFromTo(KimlCommonHelper
						.kPoint2Point(edgeLayout.getSourcePoint()),
						sourceEditPart.getFigure(), connectionLayer);
				Point translatedEndPoint = translateFromTo(KimlCommonHelper
						.kPoint2Point(edgeLayout.getTargetPoint()),
						sourceEditPart.getFigure(), connectionLayer);
				/*
				 * Now set the end points with 'brute force' and perform a
				 * validation of the positions now
				 */
				if (connection.getFigure() instanceof PolylineConnectionEx) {
					PolylineConnectionEx connFig = (PolylineConnectionEx) connection
							.getFigure();
					connFig.setStart(translatedStartPoint);
					connFig.setEnd(translatedEndPoint);
					connFig.revalidate();
				}
			}

			/* create request and add it */
			SetAllBendpointRequest request = new SetAllBendpointRequest(
					RequestConstants.REQ_SET_ALL_BENDPOINT, pointList,
					startPoint, endPoint);
			compoundCommand.add(connection.getCommand(request));

			/* take also care of the labels */
			applyEdgeLabelLayout(edge, compoundCommand);
		}
	}

	/**
	 * Function to lay out the edges correctly. Is just taken out of the
	 * <code>applyEdgeLayout</code> for readability reasons.
	 * 
	 * @param edge
	 *            The KEdge which labels should be laid out
	 * @param compoundCommand
	 *            The command accumulator
	 */
	private void applyEdgeLabelLayout(KEdge edge,
			CompoundCommand compoundCommand) {

		/* iterate through all the edges of a label */
		for (KEdgeLabel edgeLabel : edge.getLabel()) {

			/* fetch corresponding EditPart */
			LabelEditPart labelEditPart = label2LabelEditPart.get(edgeLabel);

			/* some sanity checks can not be bad */
			if (labelEditPart != null) {

				Point oldLocation = labelEditPart.getFigure().getBounds()
						.getLocation();

				Point newLocation = new Point();

				/*
				 * easy if GMF should position the transition labels. Takes also
				 * into account, if the the label in the EMF model was set as
				 * beginning, mid or end label
				 */
				if (prefUseGMFLabelLocation) {
					newLocation = labelEditPart.getReferencePoint();
				}
				/*
				 * some more work if the layout provider position information
				 * should be used
				 */
				else {
					KNodeGroup sourceNode = edge.getSource();
					GraphicalEditPart sourceEditPart = nodeGroup2NodeEditPart
							.get(sourceNode);
					oldLocation = labelEditPart.getFigure().getBounds()
							.getLocation();
					newLocation = translateFromTo(KimlCommonHelper
							.kPoint2Point(edgeLabel.getLabelLayout()
									.getLocation()),
							sourceEditPart.getFigure(), connectionLayer);
				}

				/* create move request */
				ChangeBoundsRequest changeBoundsRequest = new ChangeBoundsRequest(
						RequestConstants.REQ_MOVE);
				changeBoundsRequest.setEditParts(labelEditPart);

				/* create the movement, be aware of the zoom level */
				Point moveDelta = newLocation.getTranslated(oldLocation
						.negate());
				changeBoundsRequest.setMoveDelta(moveDelta.scale(zoomLevel));

				/* add move command */
				compoundCommand.add(labelEditPart
						.getCommand(changeBoundsRequest));
			}
		}
	}

	/*------------------------------------------------------------------------------*/
	/*------------------------- BUILDING OF KLAYOUTGRAPH ---------------------------*/
	/*------------------------------------------------------------------------------*/

	/**
	 * Builds up the KLayoutGraph out of the SSM Diagram.
	 * 
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.services.KimlAbstractLayouter#buildLayoutGraph()
	 *      KimlAbstractLayouter.buildLayoutGraph()
	 */
	@Override
	protected KLayoutGraph buildLayoutGraph() {
		layoutGraph = KimlLayoutGraphFactory.eINSTANCE.createKLayoutGraph();

		/*
		 * set at least this to have a top node in the layout graph which is not
		 * null
		 */
		KNodeGroup topNodeGroup = KimlLayoutUtil.createInitializedNodeGroup();
		layoutGraph.setTopGroup(topNodeGroup);

		/*
		 * process the provided root according to its type. A
		 * CompositeState2EditPart corresponds to a normal CompositeState, a
		 * CompositeStateEditPart corresponds to the one Top CompositeState of a
		 * SSM.
		 */
		if (rootPart.getClass().equals(CompositeState2EditPart.class)
				|| rootPart.getClass().equals(CompositeStateEditPart.class)
				|| rootPart.getClass().equals(RegionEditPart.class)) {

			/* do the common translation, that is position, size and label, ... */
			processCommon(rootPart, topNodeGroup,
					new ArrayList<ConnectionEditPart>());

			/*
			 * fetch the layout hints for this element, that are, for example,
			 * user settings concerning the desired layout provider
			 */
			processLayoutHints(rootPart, topNodeGroup);

			/*
			 * If Emma wants to lay out the Top Composite State, that is also
			 * the top figure of the StateMachine, move the upper left corner to
			 * (10,10)
			 */
			if (rootPart.getClass().equals(CompositeStateEditPart.class)) {
				KPoint location = KimlLayoutGraphFactory.eINSTANCE
						.createKPoint();
				location.setX(10);
				location.setY(10);
				topNodeGroup.getLayout().setLocation(location);
			}

			/* maintain the mapping of elements for the applyLayout function */
			nodeEditPart2NodeGroup.put(rootPart, topNodeGroup);
			nodeGroup2NodeEditPart.put(topNodeGroup, rootPart);

			/* do the same for all children */
			buildLayoutGraphRecursively(rootPart, topNodeGroup);
		}
		/*
		 * if the rootPart was a complete SSM, that is when clicked into the
		 * empty diagram background space, start with its children
		 */
		else if (rootPart.getClass().equals(SafeStateMachineEditPart.class)) {
			buildLayoutGraphRecursively(rootPart, topNodeGroup);
		}

		/* once finished, return the KLayoutGraph */
		return layoutGraph;
	}

	/**
	 * Recursive helper function for the sub elements of a CompositeState or
	 * Region.
	 * 
	 * @param currentEditPart
	 *            The GraphicalEditPart which children will be processed
	 * @param currentNodeGroup
	 *            The corresponding KNodeGroup
	 */
	private void buildLayoutGraphRecursively(GraphicalEditPart currentEditPart,
			KNodeGroup currentNodeGroup) {

		/*
		 * List to save the information about the connection. Connection can
		 * only be added, when source AND target state is in the KLayoutGraph,
		 * so process the connection when all sub states of a region have been
		 * added.
		 */
		ArrayList<ConnectionEditPart> connections = new ArrayList<ConnectionEditPart>();

		/*
		 * iterate through the children of the element, children may exist in a
		 * Region and in a CompositeState. Check what Emma found.
		 */
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
			}

			/* if CompartmentEditPart, fetch the children */
			else if (childEditPart.getClass().equals(
					RegionRegionCompartmentEditPart.class)
					|| childEditPart
							.getClass()
							.equals(
									CompositeStateCompositeStateCompartment2EditPart.class)
					|| childEditPart
							.getClass()
							.equals(
									CompositeStateCompositeStateCompartmentEditPart.class)) {
				/* check if Compartment is expanded */
				ShapeCompartmentFigure scf = (ShapeCompartmentFigure) ((GraphicalEditPart) childEditPart)
						.getFigure();
				AnimatableScrollPane asp = (AnimatableScrollPane) scf
						.getScrollPane();
				if (asp.isExpanded()) {
					/* if expanded, do also process the children */
					buildLayoutGraphRecursively(
							(GraphicalEditPart) childEditPart, currentNodeGroup);
				} else {
					/*
					 * if collapsed, force the compartment to be layouted with
					 * the size to default values and omit all the cildren
					 */
					currentNodeGroup.getLayout().getSize().setHeight(
							heightCollapsed);
					currentNodeGroup.getLayout().getSize().setWidth(
							widthCollapsed);
					/*
					 * extend the label string to handle the node label of a
					 * composite state correctly
					 */
					String text = currentNodeGroup.getLabel().getText();
					currentNodeGroup.getLabel().setText(text.concat("XX"));
				}
			}
		}

		/*
		 * Finally process all the connections, as Emma has build all the needed
		 * KNodeGroups which act as source and target.
		 */
		processConnections(connections);
	}

	/**
	 * Creates a new initialized KNodeGroup for the provided KNodeGroup and
	 * returns it.
	 * 
	 * @param currentNodeGroup
	 *            A KNodeGroup for which an initialized sub KNodeGroup should be
	 *            created.
	 * @return An initialized KNodeGroup which is a subnode of the provided one
	 */
	private KNodeGroup processGetNewSubNode(KNodeGroup currentNodeGroup) {
		KNodeGroup childNodeGroup = KimlLayoutUtil.createInitializedNodeGroup();
		currentNodeGroup.getSubNodeGroups().add(childNodeGroup);
		return childNodeGroup;
	}

	/**
	 * Takes a KNodeGroup and an EditPart and fills the layout information of
	 * the EditPart into the KNodeGroup. Fills also the global maps which keep
	 * track of the mapping between EditParts and KNodeGroups.
	 * 
	 * @param currentEditPart
	 *            The EditPart whose information should be filled into the
	 *            KNodeGroup
	 * @param currenNodegroup
	 *            The respective KNodeGroup
	 * @param connections
	 *            A list to which all the connections of the EditPart are added.
	 */
	private void processCommon(GraphicalEditPart currentEditPart,
			KNodeGroup currenNodegroup,
			ArrayList<ConnectionEditPart> connections) {

		Rectangle currentBounds = currentEditPart.getFigure().getBounds();

		// store all the connections to process them later
		for (Object conn : currentEditPart.getTargetConnections()) {
			if (conn instanceof ConnectionEditPart) {
				connections.add((ConnectionEditPart) conn);
			}
		}
		// set location
		currenNodegroup.getLayout().getLocation().setX(currentBounds.x);
		currenNodegroup.getLayout().getLocation().setY(currentBounds.y);

		// set size
		currenNodegroup.getLayout().getSize().setHeight(currentBounds.height);
		currenNodegroup.getLayout().getSize().setWidth(currentBounds.width);

		// set label and ID
		currenNodegroup.getLabel().setText(
				KimlCommonHelper.getShortLabel(currentEditPart));
		currenNodegroup.setIdString(KimlCommonHelper
				.getLongLabel(currentEditPart));

		// keep track of mapping between elements
		nodeEditPart2NodeGroup.put(currentEditPart, currenNodegroup);
		nodeGroup2NodeEditPart.put(currenNodegroup, currentEditPart);

		return;
	}

	/**
	 * Takes a KNodeGroup and an EditPart and fills the layout hint information
	 * of the EditPart into the KNodeGroup. Layout hints are only applicable to
	 * certain elements of a SSM, that are Regions and CompositeStates, so
	 * therefore the distinction from <code>processCommon</code>.
	 * 
	 * @param currentEditPart
	 *            The EditPart whose layout hint information should be filled
	 *            into the KNodeGroup
	 * @param currentNodeGroup
	 *            The respective KNodeGroup
	 */
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
	 *            The connections that were build for a certain KNode before.
	 */
	private void processConnections(ArrayList<ConnectionEditPart> connections) {

		/* iterate through all the connections of an element (that is a Region) */
		for (ConnectionEditPart connection : connections) {

			/*
			 * create the KEdge. The KEdge does not need to be added explicitely
			 * to the KLayoutGraph, but exists in it through the
			 * EOppositeReference of EMF.
			 */
			KEdge edge = KimlLayoutUtil.createInitializedEdge();
			edge.setSource(nodeEditPart2NodeGroup.get(connection.getSource()));
			edge.setTarget(nodeEditPart2NodeGroup.get(connection.getTarget()));

			/* keep track of the mapping */
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

	/*------------------------------------------------------------------------------*/
	/*-------------------------------- INITIALIZING --------------------------------*/
	/*------------------------------------------------------------------------------*/

	/**
	 * Does the setup before the transformations can start. Fetches an
	 * appropriate rootPart from the provided target object. Sets up the zoom,
	 * fetches the connection layer which is needed later for the correct layout
	 * of the connections and request a new CommandStack. Fetches the
	 * preferences as set in the preference page for the SSM Diagram Layouter.
	 * 
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.services.KimlAbstractLayouter#init(java.lang.Object)
	 */
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
			connectionLayer = (ConnectionLayer) sfrep
					.getLayer(DiagramRootEditPart.CONNECTION_LAYER);
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

	/*------------------------------------------------------------------------------*/
	/*-------------------------------- HELPERS -------------------------------------*/
	/*------------------------------------------------------------------------------*/

	/**
	 * Fetches an appropriate EditPart that can be laid out corresponding to the
	 * target Object that was provided in the {@link layout} function.
	 * 
	 * @param target
	 *            The Object which was provided to this SSM Diagram Layouter and
	 *            which should be laid out.
	 * @return A fitting EditPart for this target Object which can be laid out
	 *         (that is translated) by the SSM Diagram Layouter
	 */
	private GraphicalEditPart getRootPart(Object target) {
		GraphicalEditPart root = null;

		// no matter how much was selected, get the first element
		if (target instanceof IStructuredSelection) {
			IStructuredSelection selection = (IStructuredSelection) target;

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
		if (target instanceof DiagramGraphicalViewer) {
			DiagramGraphicalViewer viewer = (DiagramGraphicalViewer) target;
			root = (GraphicalEditPart) viewer.getRootEditPart().getChildren()
					.get(0);
		}
		if (target instanceof DiagramEditor) {
			DiagramEditor editor = (DiagramEditor) target;
			root = (GraphicalEditPart) editor.getDiagramEditPart()
					.getChildren().get(0);
		}
		if (target instanceof DiagramEditPart) {
			DiagramEditPart dep = (DiagramEditPart) target;
			root = (GraphicalEditPart) dep.getChildren().get(0);
		}
		if (target instanceof GraphicalEditPart) {
			root = (GraphicalEditPart) root;
		}

		return root;
	}

	/**
	 * Recursive helper function to get a GraphicalEditPart parent for an
	 * object.
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

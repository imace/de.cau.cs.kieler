/*******************************************************************************
 * Copyright (c) 2008 Real-Time and Embedded Systems group
 *
 * INSERT LICENCE HERE
 *
 *
 * Author: Arne Schipper, ars@informatik.uni-kiel.de 
 *
 *******************************************************************************/
package edu.unikiel.rtsys.kieler.kiml.ui.diagramlayouter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.draw2d.ChopboxAnchor;
import org.eclipse.draw2d.ConnectionLayer;
import org.eclipse.draw2d.ConnectionLocator;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
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
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeCompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramCommandStack;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramGraphicalViewer;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.gmf.runtime.diagram.ui.requests.SetAllBendpointRequest;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.viewers.IStructuredSelection;

import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutPlugin;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.EDGE_LABEL_PLACEMENT;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KDimension;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KEdge;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KEdgeLabel;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KEdgeLayout;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KInsets;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KLabel;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KLayoutGraph;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KNodeGroup;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KPoint;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphFactory;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.LAYOUT_TYPE;
import edu.unikiel.rtsys.kieler.kiml.layout.services.KimlAbstractLayouter;
import edu.unikiel.rtsys.kieler.kiml.layout.util.KimlLayoutPreferenceConstants;
import edu.unikiel.rtsys.kieler.kiml.layout.util.KimlLayoutUtil;
import edu.unikiel.rtsys.kieler.kiml.ui.KimlUiPlugin;
import edu.unikiel.rtsys.kieler.kiml.ui.helpers.KimlCommonHelper;
import edu.unikiel.rtsys.kieler.kiml.ui.helpers.KimlGMFLayoutHintHelper;
import edu.unikiel.rtsys.kieler.kiml.ui.preferences.PreferenceConstants;

/**
 * The diagram layouter for all general types of GMF Diagrams for which no
 * special layouter was registered through the <code>kimlDiagramLayouter</code>
 * extension point. 
 * <p/>
 * This class implements the methods of the
 * {@link KimlAbstractLayouter} to perform the translation of a GMF diagram, or
 * parts thereof, to the {@link KLayoutGraph} and back, as well as some setup
 * functions.
 * 
 * @author <a href="mailto:ars@informatik.uni-kiel.de">Arne Schipper</a>
 * @see KimlAbstractLayouter
 */
public class KimlGenericDiagramLayouter extends KimlAbstractLayouter {

	/*
	 * HashMaps to keep track of the various mappings of EditParts to
	 * KLayoutGraph objects and vice versa
	 */
	private Map<GraphicalEditPart, KNodeGroup> graphicalEditPart2NodeGroup = new HashMap<GraphicalEditPart, KNodeGroup>();
	private Map<KNodeGroup, GraphicalEditPart> nodeGroup2GraphicalEditPart = new HashMap<KNodeGroup, GraphicalEditPart>();
	private Map<KEdge, ConnectionEditPart> edge2ConnectionEditPart = new HashMap<KEdge, ConnectionEditPart>();
	private Map<KLabel, LabelEditPart> label2LabelEditPart = new HashMap<KLabel, LabelEditPart>();

	/* corresponding root parts */
	private GraphicalEditPart rootPart = null;
	private KLayoutGraph layoutGraph = null;

	/* preference setting */
	private boolean prefUseGMFLabelLocation = false;
	private boolean prefSmoothTransitions = false;
	private boolean prefMultipleLayoutRuns = false;
	private int prefInsetsTop = 0;
	private int prefInsetsLeft = 0;
	private int prefInsetsBottom = 0;
	private int prefInsetsRight = 0;

	/* some useful other objects */
	private CommandStack commandStack = null;
	private double zoomLevel = 1.0;
	private ConnectionLayer connectionLayer = null;

	/*------------------------------------------------------------------------------*/
	/*-----------------------------APPLICATION OF LAYOUT----------------------------*/
	/*------------------------------------------------------------------------------*/

	/**
	 * Performs the translation of the KLayoutGraph with position and size
	 * attributes back to the GMF Diagram. Uses several recursive helper methods
	 * to achieve this.
	 */
	@Override
	protected void applyLayout() {

		CompoundCommand compoundCommand = new CompoundCommand();
		compoundCommand.setLabel("Generic Diagram Layout");

		/* set position of top element */
		KPoint topLocation = KimlLayoutGraphFactory.eINSTANCE.createKPoint();
		topLocation.setX(10f);
		topLocation.setY(10f);
		layoutGraph.getTopGroup().getLayout().setLocation(topLocation);

		/* wander through hierarchy */
		applyLayoutRecursively(layoutGraph.getTopGroup(), compoundCommand);

		/* execute all changes */
		commandStack.execute(compoundCommand);
	}

	/**
	 * Recursive function to wander through the children of a node.
	 * 
	 * @param currentGroup
	 *            The parent group containing the children to be processed.
	 * @param compoundCommand
	 *            Command accumulator
	 */
	private void applyLayoutRecursively(KNodeGroup currentGroup,
			CompoundCommand compoundCommand) {

		applyNodeLayout(currentGroup, compoundCommand);

		applyEdgeLayout(currentGroup, compoundCommand);

		for (KNodeGroup childGroup : currentGroup.getSubNodeGroups()) {
			applyLayoutRecursively(childGroup, compoundCommand);
		}

	}

	/**
	 * Function to lay out the nodes correctly. Is just taken out of the
	 * <code>applyLayoutRecursively</code> for readability reasons. Uses one of
	 * the maps to find the corresponding EditPart for the KNodeGroup.
	 * 
	 * @param currentGroup
	 *            The KNodeGroup to process
	 * @param compoundCommand
	 *            Command accumulator
	 */
	private void applyNodeLayout(KNodeGroup currentGroup,
			CompoundCommand compoundCommand) {

		GraphicalEditPart gep = nodeGroup2GraphicalEditPart.get(currentGroup);

		/* create the move and resize request */
		ChangeBoundsRequest changeBoundsRequest = new ChangeBoundsRequest(
				RequestConstants.REQ_RESIZE);
		changeBoundsRequest.setEditParts(gep);

		/* stuff for the size, mind the zoom level */
		Dimension oldSize = gep.getFigure().getBounds().getSize();
		Dimension newSize = KimlCommonHelper.kDimension2Dimension(currentGroup
				.getLayout().getSize());

		if (newSize != null && newSize.height != 0 && newSize.width != 0) {
			Dimension sizeDelta = newSize.getExpanded(oldSize.negate());
			changeBoundsRequest.setResizeDirection(PositionConstants.CENTER);
			changeBoundsRequest.setSizeDelta(sizeDelta.scale(zoomLevel));
		}

		/* stuff for the location, mind the zoom level */
		Point oldLocation = gep.getFigure().getBounds().getLocation();
		Point newLocation = KimlCommonHelper.kPoint2Point(currentGroup
				.getLayout().getLocation());

		if (newLocation != null) {
			Point moveDelta = newLocation.getTranslated(oldLocation.negate());
			changeBoundsRequest.setMoveDelta(moveDelta.scale(zoomLevel));
		}

		/* add command to accumulator */
		compoundCommand.add(gep.getCommand(changeBoundsRequest));
	}

	/**
	 * Function to lay out the edges correctly. Is just taken out of the
	 * <code>applyLayoutRecursively</code> for readability reasons. Uses one of
	 * the maps to find the corresponding ConnectionEditPart for the KEdges of
	 * the provided KNodeGroup.
	 * 
	 * @param currentGroup
	 *            This group's outgoing edges are processed
	 * @param compoundCommand
	 *            Command accumulator
	 */
	private void applyEdgeLayout(KNodeGroup currentGroup,
			CompoundCommand compoundCommand) {

		/* iterate through all the edges of the current KNodeGroup */
		for (KEdge edge : currentGroup.getOutgoingEdges()) {

			/* fetch corresponding EditPart for the KEdge */
			ConnectionEditPart connection = edge2ConnectionEditPart.get(edge);

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
			 * if this EditPart is a polyline connection, see if it should be
			 * routed smoothly. This is an attribute of a polyline connection.
			 * Also set the ChopBoxAnchors.
			 */
			if (connection.getFigure() instanceof PolylineConnectionEx) {
				PolylineConnectionEx polyline = ((PolylineConnectionEx) connection
						.getFigure());
				if (prefSmoothTransitions) {
					polyline.setSmoothness(PolylineConnectionEx.SMOOTH_NORMAL);
				} else {
					polyline.setSmoothness(PolylineConnectionEx.SMOOTH_NONE);
				}

				polyline.setSourceAnchor(new ChopboxAnchor(
						((GraphicalEditPart) connection.getSource())
								.getFigure()));
				polyline.setTargetAnchor(new ChopboxAnchor(
						((GraphicalEditPart) connection.getTarget())
								.getFigure()));

			}

			/* create request and add it */
			SetAllBendpointRequest request = new SetAllBendpointRequest(
					RequestConstants.REQ_SET_ALL_BENDPOINT, pointList);
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
					GraphicalEditPart sourceEditPart = nodeGroup2GraphicalEditPart
							.get(sourceNode);
					newLocation = translateFromTo(KimlCommonHelper
							.kPoint2Point(edgeLabel.getLabelLayout()
									.getLocation()),
							sourceEditPart.getFigure(), connectionLayer);
					/* let GMF handle label if no new location provided */
					if (newLocation.equals(new Point())){
						newLocation = labelEditPart.getReferencePoint();
					}
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
	 * Builds up the KLayoutGraph out of the GMF Diagram.
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

		if (rootPart instanceof NodeEditPart) {
			NodeEditPart rootEditPart = (NodeEditPart) rootPart;

			/* set label and ID */
			topNodeGroup.getLabel().setText(
					KimlCommonHelper.getShortLabel(rootEditPart));
			topNodeGroup.setIdString(KimlCommonHelper
					.getLongLabel(rootEditPart));

			/* set location */
			topNodeGroup.getLayout().getLocation().setX(
					rootEditPart.getFigure().getBounds().x);
			topNodeGroup.getLayout().getLocation().setY(
					rootEditPart.getFigure().getBounds().y);

			/* set size */
			topNodeGroup.getLayout().getSize().setHeight(
					rootEditPart.getFigure().getBounds().height);
			topNodeGroup.getLayout().getSize().setWidth(
					rootEditPart.getFigure().getBounds().width);

			/* set LayouterName and LayoutType if root is ShapeNodeEditPart */
			if (rootEditPart instanceof ShapeNodeEditPart) {
				topNodeGroup
						.getLayout()
						.setLayouterName(
								KimlGMFLayoutHintHelper
										.getContainedElementsLayouterName((ShapeNodeEditPart) rootEditPart));
				topNodeGroup
						.getLayout()
						.setLayoutType(
								KimlGMFLayoutHintHelper
										.getContainedElementsLayoutType((ShapeNodeEditPart) rootEditPart));
			}

			/* map the root EditPart to the top KNodeGroup */
			graphicalEditPart2NodeGroup.put(rootEditPart, topNodeGroup);
			nodeGroup2GraphicalEditPart.put(topNodeGroup, rootEditPart);

			/* wander recursively through the diagram */
			buildLayoutGraphRecursively(rootEditPart, topNodeGroup);
		}
		/*
		 * if the rootPart was a complete Diagram, that is when clicked into the
		 * empty diagram background space, start with its children.
		 */
		else if (rootPart instanceof DiagramEditPart) {
			graphicalEditPart2NodeGroup.put(rootPart, topNodeGroup);
			nodeGroup2GraphicalEditPart.put(topNodeGroup, rootPart);
			buildLayoutGraphRecursively(rootPart, topNodeGroup);
		}

		/* finally, return the diagram translated into a KLayoutGraph */
		return layoutGraph;
	}

	/**
	 * Recursive helper function for the sub elements of a composite element.
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

		/* iterate through the children of the element */
		for (Object obj : currentEditPart.getChildren()) {

			/* if true, Emma has a real EditPart with contents. */
			if (obj instanceof NodeEditPart) {

				NodeEditPart childNodeEditPart = (NodeEditPart) obj;
				KNodeGroup childKNodeGroup = KimlLayoutUtil
						.createInitializedNodeGroup();
				Rectangle childBounds = childNodeEditPart.getFigure()
						.getBounds();

				/* store all the connections to process them later */
				for (Object conn : childNodeEditPart.getTargetConnections()) {
					if (conn instanceof ConnectionEditPart) {
						connections.add((ConnectionEditPart) conn);
					}
				}

				/* set location */
				childKNodeGroup.getLayout().getLocation().setX(childBounds.x);
				childKNodeGroup.getLayout().getLocation().setY(childBounds.y);

				/* set size */
				childKNodeGroup.getLayout().getSize().setHeight(
						childBounds.height);
				childKNodeGroup.getLayout().getSize().setWidth(
						childBounds.width);

				/* set label and ID */
				childKNodeGroup.getLabel().setText(
						KimlCommonHelper.getShortLabel(childNodeEditPart));
				childKNodeGroup.setIdString(KimlCommonHelper
						.getLongLabel(childNodeEditPart));

				/*
				 * set information about LayouterName and LayoutType
				 */
				LAYOUT_TYPE layoutType = LAYOUT_TYPE.DEFAULT;
				String layouterName = "";
				layoutType = KimlGMFLayoutHintHelper
						.getContainedElementsLayoutType((ShapeNodeEditPart) childNodeEditPart);
				layouterName = KimlGMFLayoutHintHelper
						.getContainedElementsLayouterName((ShapeNodeEditPart) childNodeEditPart);
				childKNodeGroup.getLayout().setLayoutType(layoutType);
				childKNodeGroup.getLayout().setLayouterName(layouterName);

				/* add node */
				currentNodeGroup.getSubNodeGroups().add(childKNodeGroup);

				/* keep track of mapping between elements */
				graphicalEditPart2NodeGroup.put(childNodeEditPart,
						childKNodeGroup);
				nodeGroup2GraphicalEditPart.put(childKNodeGroup,
						childNodeEditPart);

				/* and process the child as new current */
				buildLayoutGraphRecursively(childNodeEditPart, childKNodeGroup);
			}

			/*
			 * If it is ShapeCompartmentEditPart, Emma needs the children of it
			 * to add to new KNodeGroups. She handles possible insets, which may
			 * result from labels and other stuff.
			 */
			if (obj instanceof ShapeCompartmentEditPart
					&& ((ShapeCompartmentEditPart) obj).getChildren().size() != 0) {

				KInsets parentInsets = graphicalEditPart2NodeGroup.get(
						((GraphicalEditPart) obj).getParent()).getLayout()
						.getInsets();
				parentInsets.setTop(prefInsetsTop);
				parentInsets.setLeft(prefInsetsLeft);
				parentInsets.setBottom(prefInsetsBottom);
				parentInsets.setRight(prefInsetsRight);

				buildLayoutGraphRecursively((GraphicalEditPart) obj,
						currentNodeGroup);

			}
			/* label handling */
			if (obj instanceof GraphicalEditPart) {

				GraphicalEditPart graphicalEditPart = (GraphicalEditPart) obj;
				IFigure labelFigure = graphicalEditPart.getFigure();
				if (labelFigure instanceof WrappingLabel) {

					/*
					 * handling of the label, in most cases a small symbol is
					 * drawn left to the label. Emma must enlarge the
					 * label(text), to let the layout provider set the size
					 * properly.
					 */
					String text = ((WrappingLabel) labelFigure).getText();

					graphicalEditPart2NodeGroup.get(
							graphicalEditPart.getParent()).getLabel().setText(
							text.concat("XX"));
					graphicalEditPart2NodeGroup.get(
							graphicalEditPart.getParent()).setIdString(text);
				} else if (labelFigure instanceof Label) {
					String text = ((Label) labelFigure).getText();

					graphicalEditPart2NodeGroup.get(
							graphicalEditPart.getParent()).getLabel().setText(
							text.concat("XX"));
					graphicalEditPart2NodeGroup.get(
							graphicalEditPart.getParent()).setIdString(text);
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
	 * This function creates new KEdges and takes care of the labels for each
	 * connection identified in the <code>buildLayoutGraphRecursively</code>
	 * step before.
	 * 
	 * @param connections
	 *            The connections that were build for a certain Node before.
	 */
	private void processConnections(ArrayList<ConnectionEditPart> connections) {

		/* iterate through all the connections of an compartment element */
		for (ConnectionEditPart connection : connections) {

			/*
			 * create the KEdge. The KEdge does not need to be added explicitly
			 * to the KLayoutGraph, but exists in it through the
			 * EOppositeReference of EMF.
			 */
			KEdge edge = KimlLayoutUtil.createInitializedEdge();
			edge.setSource(graphicalEditPart2NodeGroup.get(connection
					.getSource()));
			edge.setTarget(graphicalEditPart2NodeGroup.get(connection
					.getTarget()));
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
					KDimension labelSize = KimlCommonHelper
							.dimension2KDimension(labelEditPart.getFigure()
									.getBounds().getSize());

					// head label
					if (labelEditPart.getKeyPoint() == ConnectionLocator.SOURCE) {
						String headLabel = KimlCommonHelper
								.getHeadLabel(connection);

						if ((headLabel.equals(""))
								&& (labelEditPart.getFigure() instanceof WrappingLabel))
							headLabel = ((WrappingLabel) labelEditPart.getFigure()).getText();

						if (!headLabel.equals("")) {
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

						if ((midLabel.equals(""))
								&& (labelEditPart.getFigure() instanceof WrappingLabel))
							midLabel = ((WrappingLabel) labelEditPart.getFigure()).getText();

						if (!midLabel.equals("")) {
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

						if ((tailLabel.equals(""))
								&& (labelEditPart.getFigure() instanceof WrappingLabel))
							tailLabel = ((WrappingLabel) labelEditPart.getFigure()).getText();

						if (!tailLabel.equals("")) {
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
	 * preferences as set in the preference page for the Generic Diagram
	 * Layouter.
	 * 
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.services.KimlAbstractLayouter#init(java.lang.Object)
	 */
	@Override
	protected boolean init(Object target) {

		/* get root part of provided object */
		rootPart = getRootPart(target);

		/* get zoom level, CommandStack and connection layer */
		if (rootPart instanceof GraphicalEditPart
				&& ((GraphicalEditPart) rootPart).getRoot() instanceof ScalableFreeformRootEditPart) {
			GraphicalEditPart gep = (GraphicalEditPart) rootPart;
			commandStack = new DiagramCommandStack(null);
			ScalableFreeformRootEditPart sfrep = (ScalableFreeformRootEditPart) gep
					.getRoot();
			zoomLevel = sfrep.getZoomManager().getZoom();
			connectionLayer = (ConnectionLayer) sfrep
					.getLayer(DiagramRootEditPart.CONNECTION_LAYER);
		}
		if (commandStack == null) {
			System.out.println(getClass().getSimpleName()
					+ ": Error: commandStack == null");
			return false;
		}

		/* get preference values */
		prefMultipleLayoutRuns = KimlLayoutPlugin
				.getDefault()
				.getPreferenceStore()
				.getBoolean(
						KimlLayoutPreferenceConstants.PREF_DIAGRAMLAYOUTERS_MULTIPLE_LAYOUT_RUNS);
		prefSmoothTransitions = KimlLayoutPlugin
				.getDefault()
				.getPreferenceStore()
				.getBoolean(
						KimlLayoutPreferenceConstants.PREF_DIAGRAMLAYOUTERS_SMOOTHEN_EDGES);
		prefUseGMFLabelLocation = KimlLayoutPlugin
				.getDefault()
				.getPreferenceStore()
				.getBoolean(
						KimlLayoutPreferenceConstants.PREF_DIAGRAMLAYOUTERS_USE_GMF_TO_LAYOUT_CONNECTION_LABELS);
		IPreferenceStore kimlUiPreferenceStore = KimlUiPlugin.getDefault()
				.getPreferenceStore();
		prefInsetsTop = kimlUiPreferenceStore
				.getInt(PreferenceConstants.PREF_GENERIC_DIAGRAM_LAYOUTER_INSET_TOP);
		prefInsetsLeft = kimlUiPreferenceStore
				.getInt(PreferenceConstants.PREF_GENERIC_DIAGRAM_LAYOUTER_INSET_LEFT);
		prefInsetsBottom = kimlUiPreferenceStore
				.getInt(PreferenceConstants.PREF_GENERIC_DIAGRAM_LAYOUTER_INSET_BOTTOM);
		prefInsetsRight = kimlUiPreferenceStore
				.getInt(PreferenceConstants.PREF_GENERIC_DIAGRAM_LAYOUTER_INSET_RIGHT);
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
	 *            The Object which was provided to this Generic Diagram Layouter
	 *            and which should be laid out.
	 * @return A fitting EditPart for this target Object which can be laid out
	 *         (that is translated) by the Generic Diagram Layouter
	 */
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
					root = (GraphicalEditPart) ((DiagramEditPart) selectedObject);
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
			root = (DiagramEditPart) editor.getDiagramEditPart();
		}
		if (object instanceof DiagramEditPart) {
			root = (DiagramEditPart) object;
		}
		if (object instanceof GraphicalEditPart) {
			root = (GraphicalEditPart) object;
		}
		return root;
	}

	/**
	 * Recursive helper function to get a NodeEditPart parent for an object.
	 */
	private NodeEditPart findParentNode(Object current) {
		if (current instanceof GraphicalEditPart) {
			GraphicalEditPart aep = (GraphicalEditPart) current;
			if (aep.getParent() instanceof NodeEditPart)
				return (NodeEditPart) aep.getParent();
			else
				return findParentNode(aep.getParent());
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

	/**
	 * If something strange happens during the layout which may result from the
	 * order the move and resize instructions are executed through the
	 * CommandStack, it may be an option to override the parent class' layout
	 * method to do the layout twice or thrice with a revalidation of the viewer
	 * in between.
	 * 
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.services.KimlAbstractLayouter#layout
	 *      (java.lang.Object) KimlAbstractLayouter.layout(java.lang.Object)
	 */
	public void layout(Object target) {
		super.layout(target);

		if (prefMultipleLayoutRuns) {
			rootPart.getViewer().flush();
			applyLayout();
			if (!prefUseGMFLabelLocation) {
				rootPart.getViewer().flush();
				applyLayout();
			}
		}
	}

}

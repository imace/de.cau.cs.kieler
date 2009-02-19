/*******************************************************************************
 * Copyright (c) 2008 Real-Time and Embedded Systems group
 *
 * INSERT LICENCE HERE
 *
 *
 * Author: Arne Schipper, ars@informatik.uni-kiel.de 
 *
 *******************************************************************************/
package ssm.diagram.custom;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.draw2d.ConnectionLocator;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.Viewport;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
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
import org.eclipse.gmf.runtime.diagram.ui.figures.BorderItemsAwareFreeFormLayer;
import org.eclipse.gmf.runtime.diagram.ui.figures.ShapeCompartmentFigure;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramCommandStack;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramGraphicalViewer;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.gmf.runtime.diagram.ui.requests.SetAllBendpointRequest;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;
import org.eclipse.gmf.runtime.draw2d.ui.internal.figures.AnimatableScrollPane;
import org.eclipse.gmf.runtime.notation.impl.ViewImpl;
import org.eclipse.jface.viewers.IStructuredSelection;

import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KDimension;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KEdgeLabel;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KEdgeLabelPlacement;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KEdgeLayout;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLabel;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutEdge;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutGraph;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutNode;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutType;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KNodeLayout;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KPoint;
import de.cau.cs.kieler.kiml.layout.services.KimlLayoutServices;
import de.cau.cs.kieler.kiml.layout.util.KimlLayoutPreferenceConstants;
import de.cau.cs.kieler.kiml.layout.util.KimlLayoutUtil;
import de.cau.cs.kieler.kiml.ui.helpers.KimlGMFLayoutHintHelper;
import de.cau.cs.kieler.kiml.ui.helpers.KimlMetricsHelper;
import de.cau.cs.kieler.kiml.ui.provider.KimlAdapterFactoryLabelProvider;
import de.cau.cs.kieler.ssm.diagram.part.SafeStateMachineDiagramEditor;

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
 * This version is a advanced, as it can layout groups of elements within
 * Regions and Composite States. Therefore offsets had to be introduced. It is
 * quite hard to understand and remains here just for the proof of concept. The
 * documentation of the source is brief.
 * <p/>
 * For the simplified, non grouping, standard and well documented version have a
 * look at the {@link KimlSSMDiagramLayouter}.
 * 
 * @author <a href="mailto:ars@informatik.uni-kiel.de">Arne Schipper</a>
 * @see KimlAbstractLayouter
 * @see KimlSSMDiagramLayouter
 */
public class KimlSSMDiagramGroupingLayouter {//extends KimlAbstractLayouter {

//	private boolean useGMFLabelLocation = true;
//	private double zoomLevel = 1.0;
//	private float widthCollapsed = 80f;
//	private float heightCollapsed = 40f;
//
//	private Map<NodeEditPart, KLayoutNode> nodeEditPart2layoutNode = new HashMap<NodeEditPart, KLayoutNode>();
//	private Map<KLayoutNode, GraphicalEditPart> layoutNode2nodeEditPart = new HashMap<KLayoutNode, GraphicalEditPart>();
//	private Map<KLayoutEdge, ConnectionEditPart> edge2ConnectionEditPart = new HashMap<KLayoutEdge, ConnectionEditPart>();
//	private Map<KLabel, LabelEditPart> label2LabelEditPart = new HashMap<KLabel, LabelEditPart>();
//	private CommandStack commandStack = null;
//
//	private GraphicalEditPart rootPart;
//	private KLayoutGraph layoutGraph;
//	private BorderItemsAwareFreeFormLayer primaryLayer = null;
//	private Viewport viewport;
//	private boolean groupEverySingleElement;
//	private KimlAdapterFactoryLabelProvider kimlAdapterLabelProvider = new KimlAdapterFactoryLabelProvider(
//			new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
//
//	/*------------------------------------------------------------------------------*/
//	/*-----------------------HACK DUE TO EDGES AND LABEL §$$/&%?--------------------*/
//	/*------------------------------------------------------------------------------*/
//	public void layout(Object target) {
//		long zstVorher;
//		long zstNachher;
//
//		zstVorher = System.currentTimeMillis();
//		/* first run to set positions of nodes */
//		super.layout(target);
//		if (rootPart != null)
//			rootPart.getFigure().validate();
//		/* second run to set positions of edges */
//		// super.layout(target);
//		// if (rootPart != null)
//		// rootPart.getFigure().validate();
//		/* third run to set positions of edge labels */
//		super.layout(target);
//		if (rootPart != null)
//			rootPart.getFigure().validate();
//		zstNachher = System.currentTimeMillis();
//		System.out.println("SSM Diagram Layouter");
//		System.out.println("Time for layout: " + (zstNachher - zstVorher)
//				+ " msec");
//	}
//
//	/*------------------------------------------------------------------------------*/
//	/*-----------------------------APPLICATION OF LAYOUT----------------------------*/
//	/*------------------------------------------------------------------------------*/
//
//	protected void applyLayout() {
//
//		CompoundCommand compoundCommand = new CompoundCommand();
//		compoundCommand.setLabel("SSM Diagram Layout");
//
//		Point offset = new Point();
//		GraphicalEditPart gep = layoutNode2nodeEditPart.get(layoutGraph);
//
//		if (gep != null) {
//			ChangeBoundsRequest changeBoundsRequest = new ChangeBoundsRequest(
//					RequestConstants.REQ_RESIZE);
//			changeBoundsRequest.setEditParts(gep);
//
//			Dimension oldSize = gep.getFigure().getBounds().getSize();
//			Dimension newSize = KimlMetricsHelper
//					.kDimension2Dimension(layoutGraph.getLayout()
//							.getSize());
//
//			if (newSize != null && newSize.height != 0 && newSize.width != 0) {
//				Dimension sizeDelta = newSize.getExpanded(oldSize.negate());
//				changeBoundsRequest
//						.setResizeDirection(PositionConstants.CENTER);
//				changeBoundsRequest.setSizeDelta(sizeDelta.scale(zoomLevel));
//			}
//
//			compoundCommand.add(gep.getCommand(changeBoundsRequest));
//		}
//
//		applyNodeLayoutRecursively(layoutGraph, compoundCommand,
//				offset);
//
//		commandStack.execute(compoundCommand);
//
//	}
//
//	/**
//	 * Recursive function to wander through the children of a node.
//	 * 
//	 * @param currentGroup
//	 *            The parent group containing the children to be processed.
//	 * @param compoundCommand
//	 *            Command accumulator
//	 * @param offset
//	 *            Offset of previously laid out groups if intermediate groups
//	 *            were created that do not belong to actual 'physical' nodes in
//	 *            the source document
//	 */
//	private void applyNodeLayoutRecursively(KLayoutNode currentGroup,
//			CompoundCommand compoundCommand, Point offset) {
//
//		for (KLayoutNode childGroup : currentGroup.getChildNodes()) {
//			GraphicalEditPart gep = layoutNode2nodeEditPart.get(childGroup);
//
//			/*
//			 * There is a GraphicalEditPart for this layout node. Apply the
//			 * layout.
//			 */
//			if (gep != null) {
//
//				ChangeBoundsRequest changeBoundsRequest = new ChangeBoundsRequest(
//						RequestConstants.REQ_RESIZE);
//				changeBoundsRequest.setEditParts(gep);
//
//				Dimension oldSize = gep.getFigure().getBounds().getSize();
//				Dimension newSize = KimlMetricsHelper
//						.kDimension2Dimension(childGroup.getLayout().getSize());
//
//				if (newSize != null) {
//					Dimension sizeDelta = newSize.getExpanded(oldSize.negate());
//					changeBoundsRequest
//							.setResizeDirection(PositionConstants.CENTER);
//					changeBoundsRequest
//							.setSizeDelta(sizeDelta.scale(zoomLevel));
//				}
//
//				Point oldLocation = gep.getFigure().getBounds().getLocation();
//				Point newLocation = KimlMetricsHelper.kPoint2Point(childGroup
//						.getLayout().getLocation());
//
//				if (newLocation != null) {
//					Point moveDelta = newLocation.getTranslated(oldLocation
//							.negate());
//					moveDelta.translate(offset);
//					changeBoundsRequest
//							.setMoveDelta(moveDelta.scale(zoomLevel));
//				}
//
//				compoundCommand.add(gep.getCommand(changeBoundsRequest));
//
//				// do not forget the edges
//				applyEdgeLayout(childGroup, compoundCommand, offset);
//
//				// do the same for the children of the children
//				Point zeroOffset = new Point();
//				applyNodeLayoutRecursively(childGroup, compoundCommand,
//						zeroOffset);
//
//			}
//
//			/*
//			 * There is no GraphicalEditPart for this layout node in the model. So
//			 * this node must have been created as an intermediate layout node
//			 * (see above in buildLayoutGraphRecursively). Now Emma must take
//			 * care of a proper layout of those intermediate layout nodes within
//			 * one GraphicalEditPart. This is done by an offset which is passed
//			 * to the children.
//			 */
//			else {
//				offset = KimlMetricsHelper.kPoint2Point(childGroup.getLayout()
//						.getLocation());
//				applyNodeLayoutRecursively(childGroup, compoundCommand, offset);
//			}
//		}
//	}
//
//	/**
//	 * Function to lay out the edges correctly. Is just taken out of the
//	 * <code>applyNodeLayoutRecursively</code> for readability reasons.
//	 * 
//	 * @param childGroup
//	 *            This group's outgoing edges are processed
//	 * @param compoundCommand
//	 *            Command accumulator
//	 * @param offset
//	 *            Offset of previously laid out groups if intermediate groups
//	 *            were created that do not belong to actual 'physical' nodes in
//	 *            the source document
//	 */
//	private void applyEdgeLayout(KLayoutNode childGroup,
//			CompoundCommand compoundCommand, Point offset) {
//
//		GraphicalEditPart sourceEditPart = layoutNode2nodeEditPart
//				.get(childGroup);
//		for (KLayoutEdge edge : childGroup.getOutgoingEdges()) {
//			ConnectionEditPart connection = edge2ConnectionEditPart.get(edge);
//			KEdgeLayout edgeLayout = edge.getLayout();
//			PointList pointList = new PointList();
//
//			// set start point, mind the offset
//			Point startPoint = KimlMetricsHelper.kPoint2Point(
//					edgeLayout.getSourcePoint()).translate(offset);
//			Point translatedStartPoint = translateFromTo(KimlMetricsHelper
//					.kPoint2Point(edgeLayout.getSourcePoint())
//					.translate(offset), sourceEditPart.getFigure(),
//					primaryLayer);
//			pointList.addPoint(startPoint);
//
//			// set grid points, mind the offset (GraphViz: Bezier)
//			for (KPoint gridPoint : edgeLayout.getBendPoints()) {
//				Point point = KimlMetricsHelper.kPoint2Point(gridPoint)
//						.translate(offset);
//				Point translatedPoint = translateFromTo(KimlMetricsHelper
//						.kPoint2Point(gridPoint).translate(offset),
//						((GraphicalEditPart) sourceEditPart.getParent())
//								.getFigure(), primaryLayer);
//				pointList.addPoint(point);
//			}
//
//			// set end point, mind the offset
//			Point endPoint = KimlMetricsHelper.kPoint2Point(
//					edgeLayout.getTargetPoint()).translate(offset);
//			Point translatedEndPoint = translateFromTo(KimlMetricsHelper
//					.kPoint2Point(edgeLayout.getTargetPoint())
//					.translate(offset), sourceEditPart.getFigure(),
//					primaryLayer);
//			pointList.addPoint(endPoint);
//
//			/* little try if setting the endpoints works, result: not really ;( */
//			if (connection.getFigure() instanceof PolylineConnectionEx) {
//				PolylineConnectionEx connFig = (PolylineConnectionEx) connection
//						.getFigure();
//				connFig.setStart(translatedStartPoint);
//				connFig.setEnd(translatedEndPoint);
//				connFig.validate();
//			}
//
//			// create request and add it
//			SetAllBendpointRequest request = new SetAllBendpointRequest(
//					RequestConstants.REQ_SET_ALL_BENDPOINT, pointList);
//			compoundCommand.add(connection.getCommand(request));
//
//			// take also care of the labels
//			applyEdgeLabelLayout(edge, compoundCommand, offset);
//		}
//	}
//
//	/**
//	 * Function to lay out the edges correctly. Is just taken out of the
//	 * <code>applyEdgeLayout</code> for readability reasons.
//	 * 
//	 * @param edge
//	 *            The edge which labels should be laid out
//	 * @param compound
//	 *            Command accumulator
//	 * @param offset
//	 *            Offset of previously laid out groups if intermediate groups
//	 *            were created that do not belong to actual 'physical' nodes in
//	 *            the source document
//	 */
//	private void applyEdgeLabelLayout(KLayoutEdge edge,
//			CompoundCommand compoundCommand, Point offset) {
//
//		KLayoutNode sourceNode = edge.getSource();
//		GraphicalEditPart sourceEditPart = layoutNode2nodeEditPart
//				.get(sourceNode);
//
//		for (KEdgeLabel edgeLabel : edge.getLabel()) {
//
//			LabelEditPart labelEditPart = label2LabelEditPart.get(edgeLabel);
//			// some sanity checks can not be bad
//			if (labelEditPart != null) {
//
//				Point oldLocation = labelEditPart.getFigure().getBounds()
//						.getLocation();
//
//				Point newLocation = new Point();
//
//				// TODO: fix it
//				if (useGMFLabelLocation
//						|| (oldLocation.x == 0 && oldLocation.y == 0)) {
//					newLocation = labelEditPart.getReferencePoint();
//				} else {
//					oldLocation = translateFromTo(labelEditPart.getFigure(),
//							sourceEditPart.getFigure());
//					newLocation = KimlMetricsHelper.kPoint2Point(edgeLabel
//							.getLabelLayout().getLocation());
//					newLocation.translate(offset);
//				}
//
//				Point moveDelta = newLocation.getTranslated(oldLocation
//						.negate());
//
//				ChangeBoundsRequest changeBoundsRequest = new ChangeBoundsRequest(
//						RequestConstants.REQ_MOVE);
//				changeBoundsRequest.setEditParts(labelEditPart);
//
//				if (newLocation != null) {
//					changeBoundsRequest
//							.setMoveDelta(moveDelta.scale(zoomLevel));
//				}
//
//				compoundCommand.add(labelEditPart
//						.getCommand(changeBoundsRequest));
//			}
//		}
//
//	}
//
//	/*------------------------------------------------------------------------------*/
//	/*------------------------BUILDING OF LAYOUT GRAPH------------------------------*/
//	/*------------------------------------------------------------------------------*/
//
//	protected KLayoutGraph buildLayoutGraph() {
//		// create an initialized layout graph, which is also the top node
//		layoutGraph = KimlLayoutUtil.createInitializedLayoutGraph();
//
//		// init took care that rootPart is instance of NodeEditPart
//		NodeEditPart rootEditPart = (NodeEditPart) rootPart;
//
//		// set label and ID
//		EObject currentEObject = ((ViewImpl)rootEditPart.getModel()).getElement();
//		layoutGraph.getLabel().setText(kimlAdapterLabelProvider.getKimlShortLabel(currentEObject));
//		layoutGraph.setIdString(kimlAdapterLabelProvider.getKimlLongLabel(currentEObject));
//		
//		if (!groupEverySingleElement) {
//			layoutGraph.setIdString(kimlAdapterLabelProvider.getKimlLongLabel(currentEObject));
//			layoutGraph
//					.getLayout()
//					.setLayouterName(
//							KimlGMFLayoutHintHelper
//									.getContainedElementsLayouterName((ShapeNodeEditPart) rootEditPart));
//			layoutGraph
//					.getLayout()
//					.setLayoutType(
//							KimlGMFLayoutHintHelper
//									.getContainedElementsLayoutType((ShapeNodeEditPart) rootEditPart));
//
//		}
//
//		nodeEditPart2layoutNode.put(rootEditPart, layoutGraph);
//		layoutNode2nodeEditPart.put(layoutGraph, rootEditPart);
//
//		buildLayoutGraphRecursively(rootEditPart, layoutGraph);
//		return layoutGraph;
//	}
//
//	/**
//	 * Recursive helper function. This one is complicated as hell. So if you
//	 * understand this, congratulations.
//	 * 
//	 * @param current
//	 *            The GraphicalEditPart which children will be processed
//	 * @param currentLayoutNode
//	 *            The corresponding KLayoutNode
//	 */
//	private void buildLayoutGraphRecursively(GraphicalEditPart current,
//			KLayoutNode currentLayoutNode) {
//
//		// List and Map to save some intermediate information. Are newly created
//		// and populated each recursive call.
//		ArrayList<ConnectionEditPart> connections = new ArrayList<ConnectionEditPart>();
//		Map<String, ArrayList<KLayoutNode>> nodes2Groups = new HashMap<String, ArrayList<KLayoutNode>>();
//
//		boolean isExpanded = true;
//
//		// Hack, at the moment for SSMs to take care of the 'header' of an
//		// CompositeState.
//		if (current instanceof ShapeCompartmentEditPart) {
//			ShapeCompartmentEditPart currentSCEP = (ShapeCompartmentEditPart) current;
//			// Insets, if Compartment has "header", for example
//			float insetsLeft;
//			float insetsTop = (((GraphicalEditPart) currentSCEP.getParent())
//					.getFigure().getBounds().getSize().height - currentSCEP
//					.getContentPane().getBounds().height);
//			// TODO: dirty hack to keep the header in CompositeState constant at
//			// 33 pixel after layout.
//			insetsTop = 33f;
//			insetsLeft = 15f;
//
//			// check if compartment is collapsed
//			ShapeCompartmentFigure scf = (ShapeCompartmentFigure) currentSCEP
//					.getFigure();
//			AnimatableScrollPane asp = (AnimatableScrollPane) scf
//					.getScrollPane();
//			isExpanded = asp.isExpanded();
//			try {
//				nodeEditPart2layoutNode.get(current.getParent()).getLayout()
//						.getInsets().setTop(insetsTop);
//				nodeEditPart2layoutNode.get(current.getParent()).getLayout()
//						.getInsets().setLeft(insetsLeft);
//				if (!isExpanded) {
//					// setting the size to default values
//					nodeEditPart2layoutNode.get(current.getParent()).getLayout()
//							.getSize().setHeight(heightCollapsed);
//					nodeEditPart2layoutNode.get(current.getParent()).getLayout()
//							.getSize().setWidth(widthCollapsed);
//					// extend the label string to handle the node label of a
//					// composite state correctly
//					String text = nodeEditPart2layoutNode.get(
//							current.getParent()).getLabel().getText();
//					nodeEditPart2layoutNode.get(current.getParent()).getLabel()
//							.setText(text.concat("XX"));
//				}
//			} catch (Exception e) {
//				;
//			}
//		}
//
//		if (isExpanded) {
//			// Process each child.
//			for (Object obj : current.getChildren()) {
//
//				// if true, Emma has a real EditPart with contents.
//				if (obj instanceof NodeEditPart) {
//					NodeEditPart childNodeEditPart = (NodeEditPart) obj;
//					KLayoutNode childLayoutNode = KimlLayoutUtil
//							.createInitializedLayoutNode();
//					KNodeLayout kLayout = childLayoutNode.getLayout();
//
//					Rectangle childBounds = childNodeEditPart.getFigure()
//							.getBounds();
//
//					// store all the connections to process them later
//					for (Object conn : childNodeEditPart.getTargetConnections()) {
//						if (conn instanceof ConnectionEditPart) {
//							connections.add((ConnectionEditPart) conn);
//						}
//					}
//					// set location
//					kLayout.getLocation().setX(childBounds.x);
//					kLayout.getLocation().setY(childBounds.y);
//
//					// set size
//					kLayout.getSize().setHeight(childBounds.height);
//					kLayout.getSize().setWidth(childBounds.width);
//
//					// set label and ID
//					EObject currentEObject = ((ViewImpl)childNodeEditPart.getModel()).getElement();
//					childLayoutNode.getLabel().setText(kimlAdapterLabelProvider.getKimlShortLabel(currentEObject));
//					childLayoutNode.setIdString(kimlAdapterLabelProvider.getKimlLongLabel(currentEObject));
//					
//
//					// now process the layout groups correctly, as there may be
//					// more than one in each editPart itself
//					if (groupEverySingleElement) {
//						addNode2Group(nodes2Groups, childNodeEditPart,
//								childLayoutNode);
//					} else {
//						kLayout
//								.setLayouterName(KimlGMFLayoutHintHelper
//										.getContainedElementsLayouterName((ShapeNodeEditPart) childNodeEditPart));
//						kLayout
//								.setLayoutType(KimlGMFLayoutHintHelper
//										.getContainedElementsLayoutType((ShapeNodeEditPart) childNodeEditPart));
//						childLayoutNode.setIdString(kimlAdapterLabelProvider.getKimlLongLabel(currentEObject));
//						currentLayoutNode.getChildNodes()
//								.add(childLayoutNode);
//					}
//					// keep track of mapping between elements
//					nodeEditPart2layoutNode.put(childNodeEditPart,
//							childLayoutNode);
//					layoutNode2nodeEditPart.put(childLayoutNode,
//							childNodeEditPart);
//
//					// and process the child as new current
//					buildLayoutGraphRecursively(childNodeEditPart,
//							childLayoutNode);
//				}
//
//				// If it is just a graphical edit part, it may be the
//				// compartment
//				// inside a composite edit part or other esoteric stuff, as Emma
//				// loves reality, she does not need this, as she already
//				// has the parent of it, but needs the direct children.
//				else if (obj instanceof GraphicalEditPart) {
//					GraphicalEditPart childPart = (GraphicalEditPart) obj;
//					buildLayoutGraphRecursively(childPart, currentLayoutNode);
//				}
//			}
//
//			/*
//			 * Now process the children correctly to add them to newly created
//			 * groups which are added as K-subgroups to the parent layout node.
//			 */
//			processLayoutNodes(nodes2Groups, currentLayoutNode);
//
//			/*
//			 * Finally process all the connections, as Emma has build all the
//			 * needed KLayoutNodes which act as source and target.
//			 */
//			processConnections(connections);
//		}
//	}
//
//	/**
//	 * This function takes care of adding the layout nodes correctly to some
//	 * parent node. If inside of an node in, for example, a graphical editor
//	 * some nodes are grouped together, then this grouping itself will result in
//	 * a new intermediate KLayoutNode, to which the actual grouped nodes are
//	 * added as children. This intermediate KLayoutNode is then added to the
//	 * current (=parent) group.
//	 * 
//	 * @param nodes2Groups
//	 *            A map with the grouping information of different nodes
//	 * @param currentLayoutNode
//	 *            The actually processed KLayoutNode from the
//	 *            <code>buildLayoutGraphRecursively</code> step before.
//	 */
//	private void processLayoutNodes(
//			Map<String, ArrayList<KLayoutNode>> nodes2Groups,
//			KLayoutNode currentLayoutNode) {
//
//		EObject currentEObject = ((ViewImpl)layoutNode2nodeEditPart
//				.get(currentLayoutNode).getModel()).getElement();
//		
//		/*
//		 * If there is just one group, Emma does not need to create a new
//		 * intermediate group, just store this group and its layout information
//		 * in the current one (as child). This is the case, for example, if all
//		 * nodes inside a composite node are grouped with the same layout
//		 * information.
//		 */
//		if (nodes2Groups.size() == 1) {
//			for (ArrayList<KLayoutNode> nodesInGroup : nodes2Groups.values()) {
//				for (KLayoutNode childGroup : nodesInGroup) {
//					KLayoutType layoutType = KLayoutType.DEFAULT;
//					String layouterName = "";
//					if (layoutNode2nodeEditPart.get(childGroup) instanceof ShapeNodeEditPart) {
//						layoutType = KimlGMFLayoutHintHelper
//								.getLayoutType((ShapeNodeEditPart) layoutNode2nodeEditPart
//										.get(childGroup));
//						layouterName = KimlGMFLayoutHintHelper
//								.getLayouterName((ShapeNodeEditPart) layoutNode2nodeEditPart
//										.get(childGroup));
//					}
//					
//					currentLayoutNode.getLayout().setLayoutType(layoutType);
//					currentLayoutNode.getLayout().setLayouterName(layouterName);
//					currentLayoutNode.setIdString(kimlAdapterLabelProvider.getKimlLongLabel(currentEObject));
//					
//					currentLayoutNode.getChildNodes().add(childGroup);
//				}
//			}
//		}
//		/*
//		 * More than one subgroup inside a composite node. Create for each
//		 * layout group a new intermediate KLayoutNode. Add the elements with the
//		 * same layout groupID to the intermediate groups and than add the
//		 * intermediate groups as children to the current one.
//		 */
//		else {
//			int i = 0;
//			for (ArrayList<KLayoutNode> nodesInGroup : nodes2Groups.values()) {
//				i++;
//				KLayoutNode intermediateLayoutNode = KimlLayoutUtil
//						.createInitializedLayoutNode();
//
//				for (KLayoutNode childGroup : nodesInGroup) {
//					intermediateLayoutNode.getChildNodes().add(childGroup);
//				}
//
//				KLayoutType layoutType = KLayoutType.DEFAULT;
//				String layouterName = "";
//				if (layoutNode2nodeEditPart.get(intermediateLayoutNode
//						.getChildNodes().get(0)) instanceof ShapeNodeEditPart) {
//					layoutType = KimlGMFLayoutHintHelper
//							.getLayoutType((ShapeNodeEditPart) layoutNode2nodeEditPart
//									.get(intermediateLayoutNode
//											.getChildNodes().get(0)));
//					layouterName = KimlGMFLayoutHintHelper
//							.getLayouterName((ShapeNodeEditPart) layoutNode2nodeEditPart
//									.get(intermediateLayoutNode
//											.getChildNodes().get(0)));
//				}
//				intermediateLayoutNode.getLayout().setLayoutType(layoutType);
//				intermediateLayoutNode.getLayout().setLayouterName(layouterName);
//				intermediateLayoutNode
//						.setIdString(i
//								+ ". Group of a "
//								+ kimlAdapterLabelProvider.getKimlLongLabel(currentEObject));
//				// set the layout type of the current layout node, i.e. the
//				// type
//				// how the child intermediate layout nodes, to which no
//				// corresponding element an an editor exists, should be laid
//				// out.
//				currentLayoutNode.getLayout().setLayoutType(KLayoutType.DEFAULT);
//				currentLayoutNode.getLayout().setLayouterName("");
//				currentLayoutNode
//						.setIdString(kimlAdapterLabelProvider.getKimlLongLabel(currentEObject));
//				currentLayoutNode.getChildNodes().add(intermediateLayoutNode);
//			}
//		}
//
//	}
//
//	/**
//	 * This function creates new KEdges and takes care of the labels for each
//	 * connection identified in the <code>buildLayoutGraphRecursively</code>
//	 * step before.
//	 * 
//	 * @param connections
//	 *            The connections that were build for a certain Node before.
//	 */
//	private void processConnections(ArrayList<ConnectionEditPart> connections) {
//
//		for (ConnectionEditPart connection : connections) {
//
//			KLayoutEdge edge = KimlLayoutUtil.createInitializedEdge();
//			edge.setSource(nodeEditPart2layoutNode.get(connection.getSource()));
//			edge.setTarget(nodeEditPart2layoutNode.get(connection.getTarget()));
//			edge2ConnectionEditPart.put(edge, connection);
//
//			/*
//			 * Process the label, at the moment 3 are hard coded. Actually no
//			 * possibility to get the location of the head label from GraphViz.
//			 * 
//			 * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//			 * SOURCE and TARGET is exchanged when defining it in the.gmfgen
//			 * file. So if Emma sets a label to be placed as TARGET on a
//			 * connection (transition in the SSM case), then the label will show
//			 * up next to the source node in the diagram editor. So correct it
//			 * here, very ugly.
//			 * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//			 */
//			for (Object obj : connection.getChildren()) {
//				if (obj instanceof LabelEditPart) {
//					LabelEditPart labelEditPart = (LabelEditPart) obj;
//					KDimension labelSize = KimlMetricsHelper
//							.dimension2KDimension(labelEditPart.getFigure()
//									.getBounds().getSize());
//
//					EObject transition = ((ViewImpl)connection.getModel()).getElement();
//					
//					// head label
//					if (labelEditPart.getKeyPoint() == ConnectionLocator.SOURCE) {
//						String headLabel = kimlAdapterLabelProvider.getKimlHeadLabel(transition);
//						if (headLabel != null) {
//							KEdgeLabel hLabel = KimlLayoutUtil
//									.createInitializedEdgeLabel();
//							hLabel.getLabelLayout().setLabelPlacement(
//									KEdgeLabelPlacement.HEAD);
//							hLabel.getLabelLayout().setSize(labelSize);
//							hLabel.setText(headLabel);
//							edge.getLabel().add(hLabel);
//							label2LabelEditPart.put(hLabel, labelEditPart);
//						}
//					}
//
//					// middle label
//					if (labelEditPart.getKeyPoint() == ConnectionLocator.MIDDLE) {
//						String midLabel = kimlAdapterLabelProvider.getKimlCenterLabel(transition);
//						if (midLabel != null) {
//							KEdgeLabel mLabel = KimlLayoutUtil
//									.createInitializedEdgeLabel();
//							mLabel.getLabelLayout().setLabelPlacement(
//									KEdgeLabelPlacement.CENTER);
//							mLabel.getLabelLayout().setSize(labelSize);
//							mLabel.setText(midLabel);
//							edge.getLabel().add(mLabel);
//							label2LabelEditPart.put(mLabel, labelEditPart);
//						}
//					}
//
//					// tail label
//					if (labelEditPart.getKeyPoint() == ConnectionLocator.TARGET) {
//						String tailLabel = kimlAdapterLabelProvider.getKimlTailLabel(transition);
//						if (tailLabel != null) {
//							KEdgeLabel tLabel = KimlLayoutUtil
//									.createInitializedEdgeLabel();
//							tLabel.getLabelLayout().setLabelPlacement(
//									KEdgeLabelPlacement.TAIL);
//							tLabel.getLabelLayout().setSize(labelSize);
//							tLabel.setText(tailLabel);
//							edge.getLabel().add(tLabel);
//							label2LabelEditPart.put(tLabel, labelEditPart);
//						}
//					}
//				}
//			}
//		}
//	}
//
//	/**
//	 * Takes all subNodes of a composite node and maps them according to their
//	 * grouping information into logical groups inside the composite node. Is in
//	 * a separate function for readability reasons, is just called once.
//	 * 
//	 * @param nodes2Groups
//	 * @param childNode
//	 * @param childGroup
//	 */
//	private void addNode2Group(Map<String, ArrayList<KLayoutNode>> nodes2Groups,
//			NodeEditPart childNode, KLayoutNode childGroup) {
//
//		String groupID = KimlGMFLayoutHintHelper
//				.getLayoutGroup((ShapeNodeEditPart) childNode);
//		if (nodes2Groups.containsKey(groupID)) {
//			ArrayList<KLayoutNode> nodesInGroup = nodes2Groups.get(groupID);
//			nodesInGroup.add(childGroup);
//		} else {
//			ArrayList<KLayoutNode> nodesInGroup = new ArrayList<KLayoutNode>();
//			nodesInGroup.add(childGroup);
//			nodes2Groups.put(groupID, nodesInGroup);
//		}
//	}
//
//	/*------------------------------------------------------------------------------*/
//	/*------------------------------INIT FUNCTION-----------------------------------*/
//	/*------------------------------------------------------------------------------*/
//
//	protected void init(Object object) {
//		// get root part provided object
//		rootPart = getRootPart(object);
//
//		// get zooming level
//		if (rootPart instanceof GraphicalEditPart
//				&& ((GraphicalEditPart) rootPart).getRoot() instanceof ScalableFreeformRootEditPart) {
//			GraphicalEditPart gep = (GraphicalEditPart) rootPart;
//			// commandStack = gep.getViewer().getEditDomain().getCommandStack();
//			commandStack = new DiagramCommandStack(null);
//			ScalableFreeformRootEditPart sfrep = (ScalableFreeformRootEditPart) gep
//					.getRoot();
//			primaryLayer = (BorderItemsAwareFreeFormLayer) sfrep
//					.getLayer(DiagramRootEditPart.PRIMARY_LAYER);
//			viewport = sfrep.getZoomManager().getViewport();
//			zoomLevel = sfrep.getZoomManager().getZoom();
//		} else {
//			throw new IllegalArgumentException(rootPart
//					+ "' is not an instance of GraphicalEditPart: ");
//		}
//		if (commandStack == null) {
//			throw new IllegalArgumentException("commandStack == null");
//		}
//		// handle edge label placement
//		useGMFLabelLocation = KimlLayoutServices.getInstance()
//				.getPreferenceStore().getBoolean(
//						KimlLayoutPreferenceConstants.PREF_DIAGRAMLAYOUTERS_USE_GMF_TO_LAYOUT_CONNECTION_LABELS);
//
//		groupEverySingleElement = KimlLayoutServices.getInstance()
//				.getPreferenceStore().getBoolean(
//						KimlLayoutPreferenceConstants.PREF_GROUP_EVERY_SINGLE_ELEMENT);
//	}
//
//	/*------------------------------------------------------------------------------*/
//	/*----------------------------HELPER FUNCTIONS----------------------------------*/
//	/*------------------------------------------------------------------------------*/
//
//	private GraphicalEditPart getRootPart(Object object) {
//		GraphicalEditPart root = null;
//
//		// no matter how much was selected, get the first element
//		if (object instanceof IStructuredSelection) {
//			IStructuredSelection selection = (IStructuredSelection) object;
//
//			Object selectedObject = selection.getFirstElement();
//			// if just one element was selected, use this, if NodeEditPart
//			if (selection.size() == 1) {
//				if (selectedObject instanceof NodeEditPart) {
//					root = (NodeEditPart) selectedObject;
//				} else if (selectedObject instanceof DiagramEditPart
//						&& ((DiagramEditPart) selectedObject).getChildren() != null
//						&& ((DiagramEditPart) selectedObject).getChildren()
//								.size() > 0) {
//					root = (GraphicalEditPart) ((DiagramEditPart) selectedObject)
//							.getChildren().get(0);
//				} else if (selectedObject instanceof CompartmentEditPart) {
//					root = (GraphicalEditPart) ((CompartmentEditPart) selectedObject)
//							.getParent();
//				}
//			}
//			// more selected, find parent thereof
//			else {
//				root = findParentNode(selectedObject);
//			}
//
//		}
//		if (object instanceof DiagramGraphicalViewer) {
//			DiagramGraphicalViewer viewer = (DiagramGraphicalViewer) object;
//			root = (GraphicalEditPart) viewer.getRootEditPart().getChildren()
//					.get(0);
//		}
//		if (object instanceof DiagramEditor) {
//			DiagramEditor editor = (DiagramEditor) object;
//			root = (GraphicalEditPart) editor.getDiagramEditPart()
//					.getChildren().get(0);
//		}
//		if (object instanceof DiagramEditPart) {
//			DiagramEditPart dep = (DiagramEditPart) object;
//			root = (GraphicalEditPart) dep.getChildren().get(0);
//		}
//		if (object instanceof GraphicalEditPart) {
//			root = (GraphicalEditPart) root;
//		}
//		return root;
//	}
//
//	/*
//	 * Recursive helper function to get a NodeEditPart parent for an object.
//	 */
//	private NodeEditPart findParentNode(Object current) {
//		if (current instanceof GraphicalEditPart) {
//			GraphicalEditPart aep = (GraphicalEditPart) current;
//			if (aep.getParent() instanceof NodeEditPart)
//				return (NodeEditPart) aep.getParent();
//			else
//				return findParentNode(aep.getParent());
//		} else
//			return null;
//	}
//
//	private Point translateFromTo(IFigure from, IFigure to) {
//		Rectangle newBounds = from.getBounds().getCopy();
//		from.translateToAbsolute(newBounds);
//		to.translateToRelative(newBounds);
//		return newBounds.getLocation();
//	}
//
//	private Point translateFromTo(Point point, IFigure from, IFigure to) {
//		from.translateToAbsolute(point);
//		to.translateToRelative(point);
//		return point;
//	}
//
//	public Map<String, String> getSettings() {
//		HashMap<String, String> settings = new HashMap<String, String>();
//		boolean groupEverySingleElement = KimlLayoutServices.getInstance()
//				.getPreferenceStore().getBoolean(
//						KimlLayoutPreferenceConstants.PREF_GROUP_EVERY_SINGLE_ELEMENT);
//		settings.put(
//				KimlLayoutPreferenceConstants.PREF_GROUP_EVERY_SINGLE_ELEMENT,
//				Boolean.toString(groupEverySingleElement));
//		return settings;
//	}
}

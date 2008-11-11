package edu.unikiel.rtsys.kieler.kiml.ui.diagramlayouter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.draw2d.ConnectionLocator;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Insets;
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
import org.eclipse.gmf.runtime.diagram.ui.editparts.LabelEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeCompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramCommandStack;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramGraphicalViewer;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.gmf.runtime.diagram.ui.requests.SetAllBendpointRequest;
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

public class KimlGenericDiagramLayouter extends KimlAbstractLayouter {

	private Map<NodeEditPart, KNodeGroup> nodeEditPart2NodeGroup = new HashMap<NodeEditPart, KNodeGroup>();
	private Map<KNodeGroup, GraphicalEditPart> nodeGroup2NodeEditPart = new HashMap<KNodeGroup, GraphicalEditPart>();
	private Map<KEdge, ConnectionEditPart> edge2ConnectionEditPart = new HashMap<KEdge, ConnectionEditPart>();
	private Map<KLabel, LabelEditPart> label2LabelEditPart = new HashMap<KLabel, LabelEditPart>();
	private CommandStack commandStack = null;

	private GraphicalEditPart rootPart;
	private KLayoutGraph layoutGraph;
	private double zoomLevel = 1.0;
	private boolean useGMFLabelLocation;

	/*------------------------------------------------------------------------------*/
	/*-----------------------HACK DUE TO EDGES AND LABEL §$$/&%?--------------------*/
	/*------------------------------------------------------------------------------*/
	public void layout(Object target) {
		/* first run to set positions of nodes */
		super.layout(target);
		rootPart.getFigure().validate();
		/* second run to set positions of edges */
		//super.layout(target);
		//rootPart.getFigure().validate();
		/* third run to set positions of edge labels */
		//super.layout(target);
		//rootPart.getFigure().validate();
	}

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

	private void applyNodeLayout(KNodeGroup currentGroup,
			CompoundCommand compoundCommand) {

		GraphicalEditPart gep = nodeGroup2NodeEditPart.get(currentGroup);

		ChangeBoundsRequest changeBoundsRequest = new ChangeBoundsRequest(
				RequestConstants.REQ_RESIZE);
		changeBoundsRequest.setEditParts(gep);

		Dimension oldSize = gep.getFigure().getBounds().getSize();
		Insets insets = KimlCommonHelper.kInsets2Insets(currentGroup
				.getLayout().getInsets());
		Dimension newSize = KimlCommonHelper.kDimension2Dimension(currentGroup
				.getLayout().getSize());

		if (insets.top != 0) {
			ChangeBoundsRequest changeCompartmentBoundsRequest = new ChangeBoundsRequest(
					RequestConstants.REQ_RESIZE);
			changeBoundsRequest.setEditParts(gep);
			KNodeGroup firstChild = currentGroup.getSubNodeGroups().get(0);
			GraphicalEditPart childEditPart = nodeGroup2NodeEditPart
					.get(firstChild);
			GraphicalEditPart compartment = (GraphicalEditPart) childEditPart
					.getParent();
			Dimension compartmentOldSize = compartment.getFigure().getBounds()
					.getSize();
			Dimension compartmentNewSize = KimlCommonHelper
					.kDimension2Dimension(currentGroup.getLayout().getSize());
			compartmentNewSize.expand(-insets.left, -insets.top);
			Dimension sizeDelta = compartmentNewSize
					.getExpanded(compartmentOldSize.negate());
			changeCompartmentBoundsRequest
					.setResizeDirection(PositionConstants.CENTER);
			changeCompartmentBoundsRequest.setSizeDelta(sizeDelta
					.scale(zoomLevel));

		}
		if (newSize != null && newSize.height != 0 && newSize.width != 0) {
			Dimension sizeDelta = newSize.getExpanded(oldSize.negate());
			changeBoundsRequest.setResizeDirection(PositionConstants.CENTER);
			changeBoundsRequest.setSizeDelta(sizeDelta.scale(zoomLevel));
		}

		Point oldLocation = gep.getFigure().getBounds().getLocation();
		Point newLocation = KimlCommonHelper.kPoint2Point(currentGroup
				.getLayout().getLocation());

		if (newLocation != null) {
			Point moveDelta = newLocation.getTranslated(oldLocation.negate());
			changeBoundsRequest.setMoveDelta(moveDelta.scale(zoomLevel));
		}

		compoundCommand.add(gep.getCommand(changeBoundsRequest));

	}

	/**
	 * Function to lay out the edges correctly. Is just taken out of the
	 * <code>applyNodeLayoutRecursively</code> for readability reasons.
	 * 
	 * @param childGroup
	 *            This group's outgoing edges are processed
	 * @param compoundCommand
	 *            Command accumulator
	 */
	private void applyEdgeLayout(KNodeGroup childGroup,
			CompoundCommand compoundCommand) {

		for (KEdge edge : childGroup.getOutgoingEdges()) {
			ConnectionEditPart connection = edge2ConnectionEditPart.get(edge);
			KEdgeLayout edgeLayout = edge.getLayout();
			PointList pointList = new PointList();

			// set start point, mind the offset
			Point startPoint = KimlCommonHelper.kPoint2Point(edgeLayout
					.getSourcePoint());
			pointList.addPoint(startPoint);

			// set grid points, mind the offset (GraphViz: Bezier)
			for (KPoint gridPoint : edgeLayout.getGridPoints()) {
				Point point = KimlCommonHelper.kPoint2Point(gridPoint);
				pointList.addPoint(point);
			}

			// set end point, mind the offset
			Point endPoint = KimlCommonHelper.kPoint2Point(edgeLayout
					.getTargetPoint());
			pointList.addPoint(endPoint);

			// create request and add it
			SetAllBendpointRequest request = new SetAllBendpointRequest(
					RequestConstants.REQ_SET_ALL_BENDPOINT, pointList);
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

				// TODO: fix it
				if (useGMFLabelLocation
						|| (oldLocation.x == 0 && oldLocation.y == 0)) {
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
		// null
		KNodeGroup topNodeGroup = KimlLayoutUtil.createInitializedNodeGroup();
		layoutGraph.setTopGroup(topNodeGroup);

		// init took care that rootPart is instance of NodeEditPart
		NodeEditPart rootEditPart = (NodeEditPart) rootPart;

		// set label and ID
		topNodeGroup.getLabel().setText(
				KimlCommonHelper.getShortLabel(rootEditPart));
		topNodeGroup.setIdString(KimlCommonHelper.getLongLabel(rootEditPart));
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
		nodeEditPart2NodeGroup.put(rootEditPart, topNodeGroup);
		nodeGroup2NodeEditPart.put(topNodeGroup, rootEditPart);

		buildLayoutGraphRecursively(rootEditPart, topNodeGroup);
		return layoutGraph;
	}

	/**
	 * Recursive helper function. This one is complicated as hell. So if you
	 * understand this, congratulations.
	 * 
	 * @param current
	 *            The GraphicalEditPart which children will be processed
	 * @param currentNodeGroup
	 *            The corresponding KNodeGroup
	 */
	private void buildLayoutGraphRecursively(GraphicalEditPart current,
			KNodeGroup currentNodeGroup) {

		// List and Map to save some intermediate information. Are newly created
		// and populated each recursive call.
		ArrayList<ConnectionEditPart> connections = new ArrayList<ConnectionEditPart>();

		// Process each child.
		for (Object obj : current.getChildren()) {

			// if true, Emma has a real EditPart with contents.
			if (obj instanceof NodeEditPart) {

				NodeEditPart childNodeEditPart = (NodeEditPart) obj;
				KNodeGroup childKNodeGroup = KimlLayoutUtil
						.createInitializedNodeGroup();
				Rectangle childBounds = childNodeEditPart.getFigure()
						.getBounds();

				// store all the connections to process them later
				for (Object conn : childNodeEditPart.getTargetConnections()) {
					if (conn instanceof ConnectionEditPart) {
						connections.add((ConnectionEditPart) conn);
					}
				}
				// set location
				childKNodeGroup.getLayout().getLocation().setX(childBounds.x);
				childKNodeGroup.getLayout().getLocation().setY(childBounds.y);

				// set size
				childKNodeGroup.getLayout().getSize().setHeight(
						childBounds.height);
				childKNodeGroup.getLayout().getSize().setWidth(
						childBounds.width);

				// set label and ID
				childKNodeGroup.getLabel().setText(
						KimlCommonHelper.getShortLabel(childNodeEditPart));
				childKNodeGroup.setIdString(KimlCommonHelper
						.getLongLabel(childNodeEditPart));

				// add node
				if (childNodeEditPart instanceof ShapeNodeEditPart) {
					LAYOUT_TYPE layoutType = LAYOUT_TYPE.DEFAULT;
					String layouterName = "";
					layoutType = KimlGMFLayoutHintHelper
							.getLayoutType((ShapeNodeEditPart) childNodeEditPart);
					layouterName = KimlGMFLayoutHintHelper
							.getLayouterName((ShapeNodeEditPart) childNodeEditPart);
					childKNodeGroup.getLayout().setLayoutType(layoutType);
					childKNodeGroup.getLayout().setLayouterName(layouterName);
					childKNodeGroup.setIdString(KimlCommonHelper
							.getLongLabel(childNodeEditPart));
				}
				currentNodeGroup.getSubNodeGroups().add(childKNodeGroup);

				// keep track of mapping between elements
				nodeEditPart2NodeGroup.put(childNodeEditPart, childKNodeGroup);
				nodeGroup2NodeEditPart.put(childKNodeGroup, childNodeEditPart);

				// and process the child as new current
				buildLayoutGraphRecursively(childNodeEditPart, childKNodeGroup);
			}

			/*
			 * If it is ShapeCompartmentEditPart, Emma needs the children of it
			 * to add to new KNodeGroups. But Emma handles possible insets,
			 * which may result from labels and other stuff.
			 */
			if (obj instanceof ShapeCompartmentEditPart
					&& ((ShapeCompartmentEditPart) obj).getChildren().size() != 0) {

				/* use variable sizes */
				/*
				 * ShapeCompartmentEditPart currentSCEP =
				 * (ShapeCompartmentEditPart) current; ShapeCompartmentFigure
				 * containedFigure = (ShapeCompartmentFigure) currentSCEP
				 * .getFigure(); IFigure containerFigure = ((GraphicalEditPart)
				 * currentSCEP .getParent()).getFigure(); float insetsTop =
				 * containedFigure.getBounds().getTop().y -
				 * containerFigure.getBounds().getTop().y; float insetsLeft =
				 * containedFigure.getBounds().getLeft().x -
				 * containerFigure.getBounds().getLeft().x; float insetsBottom =
				 * containerFigure.getBounds().getBottom().y -
				 * containedFigure.getBounds().getBottom().y; float insetsRight
				 * = containerFigure.getBounds().getRight().x -
				 * containedFigure.getBounds().getRight().x;
				 */
				/* use fix sizes */
				IPreferenceStore kimlUiPreferenceStore = KimlUiPlugin
						.getDefault().getPreferenceStore();
				float insetsTop = kimlUiPreferenceStore
						.getInt(PreferenceConstants.PREF_GENERIC_DIAGRAM_LAYOUTER_INSET_TOP);
				float insetsLeft = kimlUiPreferenceStore
						.getInt(PreferenceConstants.PREF_GENERIC_DIAGRAM_LAYOUTER_INSET_LEFT);
				float insetsBottom = kimlUiPreferenceStore
						.getInt(PreferenceConstants.PREF_GENERIC_DIAGRAM_LAYOUTER_INSET_BOTTOM);
				float insetsRight = kimlUiPreferenceStore
						.getInt(PreferenceConstants.PREF_GENERIC_DIAGRAM_LAYOUTER_INSET_RIGHT);

				KInsets parentInsets = nodeEditPart2NodeGroup.get(
						((GraphicalEditPart) obj).getParent()).getLayout().getInsets();
				parentInsets.setTop(insetsTop);
				parentInsets.setLeft(insetsLeft);
				parentInsets.setBottom(insetsBottom);
				parentInsets.setRight(insetsRight);

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
					
					nodeEditPart2NodeGroup.get(graphicalEditPart.getParent()).getLabel()
							.setText(text.concat("XX"));
					nodeEditPart2NodeGroup.get(graphicalEditPart.getParent()).setIdString(text);
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

		// get root part of provided object
		rootPart = getRootPart(target);

		if (!(rootPart instanceof NodeEditPart)) {
			return false;
		}
		// get zooming level
		if (rootPart instanceof GraphicalEditPart
				&& ((GraphicalEditPart) rootPart).getRoot() instanceof ScalableFreeformRootEditPart) {
			GraphicalEditPart gep = (GraphicalEditPart) rootPart;
			// commandStack = gep.getViewer().getEditDomain().getCommandStack();
			commandStack = new DiagramCommandStack(null);
			ScalableFreeformRootEditPart sfrep = (ScalableFreeformRootEditPart) gep
					.getRoot();
			zoomLevel = sfrep.getZoomManager().getZoom();
		}
		commandStack = new DiagramCommandStack(null);
		if (commandStack == null) {
			System.out.println(getClass().getSimpleName()
					+ ": Error: commandStack == null");
			return false;
		}
		// handle edge label placement
		useGMFLabelLocation = KimlLayoutPlugin
				.getDefault()
				.getPreferenceStore()
				.getBoolean(
						KimlLayoutPreferenceConstants.PREF_DIAGRAMLAYOUTERS_DO_NOT_LAYOUT_CONNECTION_LABELS);
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

	private Point translateFromTo(IFigure from, IFigure to) {
		Rectangle newBounds = from.getBounds().getCopy();
		from.translateToAbsolute(newBounds);
		to.translateToRelative(newBounds);
		return newBounds.getLocation();
	}

}

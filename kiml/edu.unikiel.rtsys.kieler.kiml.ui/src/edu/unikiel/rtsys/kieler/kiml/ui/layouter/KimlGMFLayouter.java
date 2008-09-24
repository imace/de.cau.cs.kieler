package edu.unikiel.rtsys.kieler.kiml.ui.layouter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.draw2d.ConnectionLocator;
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
import org.eclipse.gmf.runtime.diagram.ui.editparts.LabelEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeCompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.gmf.runtime.diagram.ui.requests.SetAllBendpointRequest;

import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.EDGE_LABEL_PLACEMENT;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KDimension;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KEdge;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KEdgeLabel;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KEdgeLayout;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KLabel;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KNodeGroup;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KPoint;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.LAYOUT_TYPE;
import edu.unikiel.rtsys.kieler.kiml.layout.services.KimlAbstractLayouter;
import edu.unikiel.rtsys.kieler.kiml.layout.util.KimlLayoutUtil;
import edu.unikiel.rtsys.kieler.kiml.ui.KimlUiPlugin;
import edu.unikiel.rtsys.kieler.kiml.ui.helpers.KimlCommonHelper;
import edu.unikiel.rtsys.kieler.kiml.ui.helpers.KimlGMFLayoutHintHelper;
import edu.unikiel.rtsys.kieler.kiml.ui.preferences.PreferenceConstants;

/**
 * This class enables layout for GMF Editors. The layout hints are used.
 * 
 * @author ars
 * 
 */
public class KimlGMFLayouter extends KimlAbstractLayouter {

	private boolean useGMFLabelLocation = true;
	private double zoomLevel = 1.0;

	private Map<NodeEditPart, KNodeGroup> nodeEditPart2NodeGroup = new HashMap<NodeEditPart, KNodeGroup>();
	private Map<KNodeGroup, GraphicalEditPart> nodeGroup2NodeEditPart = new HashMap<KNodeGroup, GraphicalEditPart>();
	private Map<KEdge, ConnectionEditPart> edge2ConnectionEditPart = new HashMap<KEdge, ConnectionEditPart>();
	private Map<KLabel, LabelEditPart> label2LabelEditPart = new HashMap<KLabel, LabelEditPart>();
	private CommandStack commandStack = null;

	/**
	 * Translates the actual model representation in the editor to the
	 * KLayoutGraph structure which is passed to the layout engine.
	 */
	public boolean buildLayoutGraph() {

		// set at least this to have a top node in the layout graph which is not
		// null
		KNodeGroup topNodeGroup = KimlLayoutUtil.createInitializedNodeGroup();
		layoutGraph.setTopGroup(topNodeGroup);

		// But if Emma has a NodeEditPart, then do more.
		if (root instanceof NodeEditPart) {
			NodeEditPart rootEditPart = (NodeEditPart) root;

			// set label and ID
			topNodeGroup.getLabel().setText(
					KimlCommonHelper.getShortLabel(rootEditPart));
			topNodeGroup.setIdString(KimlCommonHelper
					.getLongLabel(rootEditPart));

			nodeEditPart2NodeGroup.put(rootEditPart, topNodeGroup);
			nodeGroup2NodeEditPart.put(topNodeGroup, rootEditPart);

			buildLayoutGraphRecursively(rootEditPart, topNodeGroup);
			return true;
		} else {
			return false;
		}
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
		Map<String, ArrayList<KNodeGroup>> nodes2Groups = new HashMap<String, ArrayList<KNodeGroup>>();

		// Hack, at the moment for SSMs to take care of the 'header' of an
		// CompositeState.
		if (current instanceof ShapeCompartmentEditPart) {
			// Insets, if Compartment has "header", for example
			float insetsTop = (((GraphicalEditPart) current.getParent())
					.getFigure().getBounds().getSize().height - current
					.getContentPane().getBounds().height);
			// TODO: dirty hack to keep the header in CompositeState constant at
			// 33 pixel after layout.
			insetsTop = 33f;
			try {
				nodeEditPart2NodeGroup.get(current.getParent()).getLayout()
						.getInsets().setTop(insetsTop);
			} catch (Exception e) {
				;
			}
		}

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

				System.out.println("------------------" + childBounds);
				// set label and ID
				childKNodeGroup.getLabel().setText(
						KimlCommonHelper.getShortLabel(childNodeEditPart));
				childKNodeGroup.setIdString(KimlCommonHelper
						.getLongLabel(childNodeEditPart));

				// now process the layout groups correctly, as there may be
				// more than one in each editPart itself
				addNode2Group(nodes2Groups, childNodeEditPart, childKNodeGroup);

				// keep track of mapping between elements
				nodeEditPart2NodeGroup.put(childNodeEditPart, childKNodeGroup);
				nodeGroup2NodeEditPart.put(childKNodeGroup, childNodeEditPart);

				// and process the child as new current
				buildLayoutGraphRecursively(childNodeEditPart, childKNodeGroup);
			}

			// If it is just a graphical edit part, it may be the compartment
			// inside a composite edit part or other esoteric stuff, as Emma
			// loves reality, she does not need this, as she already
			// has the parent of it, but needs the direct children.
			else if (obj instanceof GraphicalEditPart) {
				GraphicalEditPart childPart = (GraphicalEditPart) obj;
				buildLayoutGraphRecursively(childPart, currentNodeGroup);
			}
		}

		/*
		 * Now process the children correctly to add them to newly created
		 * groups which are added as K-subgroups to the parent node group.
		 */
		processNodeGroups(nodes2Groups, currentNodeGroup);

		/*
		 * Finally process all the connections, as Emma has build all the needed
		 * KNodeGroups which act as source and target.
		 */
		processConnections(connections);

	}

	/**
	 * This function takes care of adding the node groups correctly to some
	 * parent node. If inside of an node in, for example, a graphical editor
	 * some nodes are grouped together, then this grouping itself will result in
	 * a new intermediate KNodeGroup, to which the actual grouped nodes are
	 * added as children. This intermediate KNodeGroup is then added to the
	 * current (=parent) group.
	 * 
	 * @param nodes2Groups
	 *            A map with the grouping information of different nodes
	 * @param currentNodeGroup
	 *            The actually processed KNodeGroup from the
	 *            <code>buildLayoutGraphRecursively</code> step before.
	 */
	private void processNodeGroups(
			Map<String, ArrayList<KNodeGroup>> nodes2Groups,
			KNodeGroup currentNodeGroup) {
		/*
		 * If there is just one group, Emma does not need to create a new
		 * intermediate group, just store this group and its layout information
		 * in the current one (as child). This is the case, for example, if all
		 * nodes inside a composite node are grouped with the same layout
		 * information.
		 */
		if (nodes2Groups.size() == 1) {
			for (ArrayList<KNodeGroup> nodesInGroup : nodes2Groups.values()) {
				for (KNodeGroup childGroup : nodesInGroup) {
					LAYOUT_TYPE layoutType = LAYOUT_TYPE.DEFAULT;
					String layouterName = "";
					if (nodeGroup2NodeEditPart.get(childGroup) instanceof ShapeNodeEditPart) {
						layoutType = KimlGMFLayoutHintHelper
								.getLayoutType((ShapeNodeEditPart) nodeGroup2NodeEditPart
										.get(childGroup));
						layouterName = KimlGMFLayoutHintHelper
								.getLayouterName((ShapeNodeEditPart) nodeGroup2NodeEditPart
										.get(childGroup));
					}
					currentNodeGroup.getLayout().setLayoutType(layoutType);
					currentNodeGroup.getLayout().setLayouterName(layouterName);
					currentNodeGroup.setIdString(KimlCommonHelper
							.getLongLabel(nodeGroup2NodeEditPart
									.get(currentNodeGroup)));
					currentNodeGroup.getSubNodeGroups().add(childGroup);
				}
			}
		}
		/*
		 * More than one subgroup inside a composite node. Create for each
		 * layout group a new intermediate KNodeGroup. Add the elements with the
		 * same layout groupID to the intermediate groups and than add the
		 * intermediate groups as children to the current one.
		 */
		else {
			int i = 0;
			for (ArrayList<KNodeGroup> nodesInGroup : nodes2Groups.values()) {
				i++;
				KNodeGroup intermediateNodeGroup = KimlLayoutUtil
						.createInitializedNodeGroup();

				for (KNodeGroup childGroup : nodesInGroup) {
					intermediateNodeGroup.getSubNodeGroups().add(childGroup);
				}

				LAYOUT_TYPE layoutType = LAYOUT_TYPE.DEFAULT;
				String layouterName = "";
				if (nodeGroup2NodeEditPart.get(intermediateNodeGroup
						.getSubNodeGroups().get(0)) instanceof ShapeNodeEditPart) {
					layoutType = KimlGMFLayoutHintHelper
							.getLayoutType((ShapeNodeEditPart) nodeGroup2NodeEditPart
									.get(intermediateNodeGroup
											.getSubNodeGroups().get(0)));
					layouterName = KimlGMFLayoutHintHelper
							.getLayouterName((ShapeNodeEditPart) nodeGroup2NodeEditPart
									.get(intermediateNodeGroup
											.getSubNodeGroups().get(0)));
				}
				intermediateNodeGroup.getLayout().setLayoutType(layoutType);
				intermediateNodeGroup.getLayout().setLayouterName(layouterName);
				intermediateNodeGroup
						.setIdString(i
								+ ". Group of a "
								+ KimlCommonHelper
										.getLongLabel((ShapeNodeEditPart) nodeGroup2NodeEditPart
												.get(currentNodeGroup)));
				// set the layout type of the current node group, i.e. the type
				// how the child intermediate node groups, to which no
				// corresponding element an an editor exists, should be laid
				// out.
				currentNodeGroup.getLayout().setLayoutType(LAYOUT_TYPE.DEFAULT);
				currentNodeGroup.getLayout().setLayouterName("");
				currentNodeGroup
						.setIdString(KimlCommonHelper
								.getLongLabel((ShapeNodeEditPart) nodeGroup2NodeEditPart
										.get(currentNodeGroup)));
				currentNodeGroup.getSubNodeGroups().add(intermediateNodeGroup);
			}
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

	/**
	 * Takes all subNodes of a composite node and maps them according to their
	 * grouping information into logical groups inside the composite node. Is in
	 * a separate function for readability reasons, is just called once.
	 * 
	 * @param nodes2Groups
	 * @param childNode
	 * @param childGroup
	 */
	private void addNode2Group(Map<String, ArrayList<KNodeGroup>> nodes2Groups,
			NodeEditPart childNode, KNodeGroup childGroup) {

		String groupID = KimlGMFLayoutHintHelper
				.getLayoutGroup((ShapeNodeEditPart) childNode);
		if (nodes2Groups.containsKey(groupID)) {
			ArrayList<KNodeGroup> nodesInGroup = nodes2Groups.get(groupID);
			nodesInGroup.add(childGroup);
		} else {
			ArrayList<KNodeGroup> nodesInGroup = new ArrayList<KNodeGroup>();
			nodesInGroup.add(childGroup);
			nodes2Groups.put(groupID, nodesInGroup);
		}
	}

	/**
	 * Performs the re-translation from the now laid out KLayoutGraph to
	 * Commands that the GEF editor will understand.
	 */
	public boolean applyLayout() {

		if (commandStack == null) {
			System.out.println("KimlGMFLayouter: Error: commandStack == null");
			return false;
		}

		CompoundCommand compoundCommand = new CompoundCommand();
		compoundCommand.setLabel("GMF Layout");

		Point offset = new Point();
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

		applyNodeLayoutRecursively(layoutGraph.getTopGroup(), compoundCommand,
				offset);
		commandStack.execute(compoundCommand);
		return true;
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
			CompoundCommand compoundCommand, Point offset) {

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
					moveDelta.translate(offset);
					changeBoundsRequest
							.setMoveDelta(moveDelta.scale(zoomLevel));
				}

				compoundCommand.add(gep.getCommand(changeBoundsRequest));

				// do not forget the edges
				applyEdgeLayout(childGroup, compoundCommand, offset);

				// do the same for the children of the children
				Point zeroOffset = new Point();
				applyNodeLayoutRecursively(childGroup, compoundCommand,
						zeroOffset);

			}

			/*
			 * There is no GraphicalEditPart for this nodeGroup in the model. So
			 * this node must have been created as an intermediate node group
			 * (see above in buildLayoutGraphRecursively). Now Emma must take
			 * care of a proper layout of those intermediate nodeGroups within
			 * one GraphicalEditPart. This is done by an offset which is passed
			 * to the children.
			 */
			else {
				offset = KimlCommonHelper.kPoint2Point(childGroup.getLayout()
						.getLocation());
				applyNodeLayoutRecursively(childGroup, compoundCommand, offset);
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
			CompoundCommand compoundCommand, Point offset) {

		for (KEdge edge : childGroup.getOutgoingEdges()) {
			ConnectionEditPart connection = edge2ConnectionEditPart.get(edge);
			KEdgeLayout edgeLayout = edge.getLayout();
			PointList pointList = new PointList();

			// set start point, mind the offset
			pointList.addPoint(KimlCommonHelper.kPoint2Point(
					edgeLayout.getSourcePoint()).translate(offset));

			// set grid points, mind the offset (GraphViz: Bezier)
			for (KPoint gridPoint : edgeLayout.getGridPoints()) {
				pointList.addPoint(KimlCommonHelper.kPoint2Point(gridPoint)
						.translate(offset));
			}

			// set end point, mind the offset
			pointList.addPoint(KimlCommonHelper.kPoint2Point(
					edgeLayout.getTargetPoint()).translate(offset));

			// create request and add it
			SetAllBendpointRequest request = new SetAllBendpointRequest(
					RequestConstants.REQ_SET_ALL_BENDPOINT, pointList);
			compoundCommand.add(connection.getCommand(request));

			// take also care of the labels
			applyEdgeLabelLayout(edge, compoundCommand, offset);
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
			CompoundCommand compoundCommand, Point offset) {

		for (KEdgeLabel edgeLabel : edge.getLabel()) {

			LabelEditPart labelEditPart = label2LabelEditPart.get(edgeLabel);

			// some sanity checks can not be bad
			if (labelEditPart != null) {

				Point oldLocation = labelEditPart.getFigure().getBounds()
						.getLocation();
				Point newLocation = new Point();

				// TODO: fix it
				if (useGMFLabelLocation) {
					newLocation = labelEditPart.getReferencePoint();
				} else {
					newLocation = KimlCommonHelper.kPoint2Point(edgeLabel
							.getLabelLayout().getLocation());
					newLocation.translate(offset);
				}
				// XXX: syso
				// System.out.println(
				// "-------------------------------------------");
				// System.out.println("NEWG: " +
				// labelEditPart.getReferencePoint());
				// System.out.println("NEWL: " + newLocation);
				// System.out.println("OLD:  " + oldLocation);
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

	/*
	 * (non-Javadoc)
	 * 
	 * @seeedu.unikiel.rtsys.kieler.kiml.layout.services.KimlAbstractLayouter#
	 * init()
	 */
	public boolean init() {
		// get zooming level
		if (root instanceof GraphicalEditPart
				&& ((GraphicalEditPart) root).getRoot() instanceof ScalableFreeformRootEditPart) {
			GraphicalEditPart gep = (GraphicalEditPart) root;
			commandStack = gep.getViewer().getEditDomain().getCommandStack();
			ScalableFreeformRootEditPart sfrep = (ScalableFreeformRootEditPart) gep
					.getRoot();
			zoomLevel = sfrep.getZoomManager().getZoom();
		} else {
			System.out
					.println("KimlGMFLayouter: Error: not instanceof GraphicalEditPart: " + root.getClass());
			return false;
		}
		if (commandStack == null) {
			System.out.println("KimlGMFLayouter: Error: commandStack == null");
			return false;
		}
		// handle edge label placement
		useGMFLabelLocation = KimlUiPlugin
				.getDefault()
				.getPreferenceStore()
				.getBoolean(
						PreferenceConstants.PREF_UI_DO_NOT_LAYOUT_CONNECTION_LABELS);
		return true;
	}

}

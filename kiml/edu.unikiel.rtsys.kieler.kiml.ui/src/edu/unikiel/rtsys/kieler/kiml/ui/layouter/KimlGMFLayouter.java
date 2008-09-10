package edu.unikiel.rtsys.kieler.kiml.ui.layouter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.NodeEditPart;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.editparts.ScalableFreeformRootEditPart;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeCompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.ui.IEditorPart;

import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KDimension;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KEdge;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KInsets;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KNodeGroup;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KNodeGroupLabel;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KNodeGroupLayout;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KPoint;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphFactory;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.LAYOUT_TYPE;
import edu.unikiel.rtsys.kieler.kiml.layout.services.KimlAbstractLayouter;
import edu.unikiel.rtsys.kieler.kiml.ui.helpers.KimlGMFLayoutHintHelper;

/**
 * This class enables layouting for GMF Editors. The layout hints are used.
 * 
 * @author ars
 * 
 */
public class KimlGMFLayouter extends KimlAbstractLayouter {

	private double zoomLevel = 1.0;
	private Map<GraphicalEditPart, KNodeGroup> nodeEditPart2NodeGroup = new HashMap<GraphicalEditPart, KNodeGroup>();
	private Map<KNodeGroup, GraphicalEditPart> nodeGroup2NodeEditPart = new HashMap<KNodeGroup, GraphicalEditPart>();
	private IEditorPart editor;

	/**
	 * Translates the actual model representation in the editor to the
	 * KLayoutGraph structure which is passed to the layouters.
	 */
	public void buildLayoutGraph() {
		if (root instanceof GraphicalEditPart) {
			GraphicalEditPart rootEditPart = (GraphicalEditPart) root;

			KNodeGroup topNodeGroup = createInitializedNodeGroup();
			Rectangle rootBounds = rootEditPart.getFigure().getBounds();

			// set location
			topNodeGroup.getLayout().getLocation().setX(rootBounds.x);
			topNodeGroup.getLayout().getLocation().setY(rootBounds.y);

			// set size
			topNodeGroup.getLayout().getSize().setHeight(rootBounds.height);
			topNodeGroup.getLayout().getSize().setWidth(rootBounds.width);

			// set label
			Map<String, String> labelMap = (Map<String, String>) rootEditPart
					.getAdapter(Map.class);
			if (labelMap != null && labelMap.get("SHORT_LABEL") != null) {
				topNodeGroup.getLabel().setText(labelMap.get("SHORT_LABEL"));
			}

			layoutGraph.setTopGroup(topNodeGroup);
			nodeEditPart2NodeGroup.put(rootEditPart, topNodeGroup);
			nodeGroup2NodeEditPart.put(topNodeGroup, rootEditPart);

			buildLayoutGraphRecursive(rootEditPart, topNodeGroup);
		}
	}

	/**
	 * Recursive helper function. This one is complicated as hell.
	 * 
	 * @param current
	 * @param currentNodeGroup
	 */
	private void buildLayoutGraphRecursive(GraphicalEditPart current,
			KNodeGroup currentNodeGroup) {
		ArrayList<ConnectionEditPart> connections = new ArrayList<ConnectionEditPart>();
		Map<String, ArrayList<KNodeGroup>> nodes2Groups = new HashMap<String, ArrayList<KNodeGroup>>();

		if (current instanceof ShapeCompartmentEditPart) {
			// Insets, if Compartment has "header", for example
			float insetsTop = (((GraphicalEditPart) current.getParent())
					.getFigure().getBounds().getSize().height - current
					.getContentPane().getBounds().height);
			// TODO: dirty hack to keep the header in CompositeState constant at
			// 16 pixel after layouting
			insetsTop = 16f;
			try {
				nodeEditPart2NodeGroup.get(current.getParent()).getLayout()
						.getInsets().setTop(insetsTop);
			} catch (Exception e) {
				;
			}
		}

		for (Object obj : current.getChildren()) {
			if (obj instanceof NodeEditPart) {
				NodeEditPart childNodeEditPart = (NodeEditPart) obj;
				KNodeGroup childKNodeGroup = createInitializedNodeGroup();
				Rectangle childBounds = childNodeEditPart.getFigure()
						.getBounds();
				/*
				 * semantic stuff, store all the connections to process them
				 * later
				 */
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

				// set label
				Map<String, String> labelMap = (Map<String, String>) childNodeEditPart
						.getAdapter(Map.class);
				if (labelMap != null && labelMap.get("SHORT_LABEL") != null) {
					childKNodeGroup.getLabel().setText(
							labelMap.get("SHORT_LABEL"));
				}

				addNode2Group(nodes2Groups, childNodeEditPart, childKNodeGroup);
				nodeEditPart2NodeGroup.put(childNodeEditPart, childKNodeGroup);
				nodeGroup2NodeEditPart.put(childKNodeGroup, childNodeEditPart);
				buildLayoutGraphRecursive(childNodeEditPart, childKNodeGroup);

			} else if (obj instanceof GraphicalEditPart) {
				GraphicalEditPart childPart = (GraphicalEditPart) obj;
				buildLayoutGraphRecursive(childPart, currentNodeGroup);
			}

		}

		/*
		 * now process the children correctly to add them to newly created
		 * groups which are added as subgroups to the parent node group
		 */
		if (nodes2Groups.size() == 1) {
			for (ArrayList<KNodeGroup> nodesInGroup : nodes2Groups.values()) {
				for (KNodeGroup childGroup : nodesInGroup) {
					LAYOUT_TYPE layoutType = KimlGMFLayoutHintHelper
							.getLayoutType((ShapeNodeEditPart) nodeGroup2NodeEditPart
									.get(childGroup));
					currentNodeGroup.getLayout().setLayouterName(
							layoutType.getName());
					currentNodeGroup.getLayout().setLayoutType(layoutType);
					currentNodeGroup.getSubNodeGroups().add(childGroup);
				}
			}
		} else {
			for (ArrayList<KNodeGroup> nodesInGroup : nodes2Groups.values()) {
				if (nodesInGroup.size() == 1) {
					for (KNodeGroup childGroup : nodesInGroup) {
						LAYOUT_TYPE layoutType = KimlGMFLayoutHintHelper
								.getLayoutType((ShapeNodeEditPart) nodeGroup2NodeEditPart
										.get(childGroup));
						currentNodeGroup.getLayout().setLayouterName(
								layoutType.getName());
						currentNodeGroup.getLayout().setLayoutType(layoutType);
						currentNodeGroup.getSubNodeGroups().add(childGroup);
					}
				} else {
					KNodeGroup intermediateNodeGroup = createInitializedNodeGroup();

					for (KNodeGroup childGroup : nodesInGroup) {
						intermediateNodeGroup.getSubNodeGroups()
								.add(childGroup);
					}

					LAYOUT_TYPE layoutType = KimlGMFLayoutHintHelper
							.getLayoutType((ShapeNodeEditPart) nodeGroup2NodeEditPart
									.get(intermediateNodeGroup
											.getSubNodeGroups().get(0)));
					intermediateNodeGroup.getLayout().setLayouterName(
							layoutType.getName());
					currentNodeGroup.getSubNodeGroups().add(
							intermediateNodeGroup);
				}
			}
		}

		/*
		 * now process the connections, as Emma has build all the needed
		 * KNodeGroups
		 */
		for (ConnectionEditPart connection : connections) {
			KEdge edge = KimlLayoutGraphFactory.eINSTANCE.createKEdge();
			edge.setSource(nodeEditPart2NodeGroup.get(connection.getSource()));
			edge.setTarget(nodeEditPart2NodeGroup.get(connection.getTarget()));
		}
	}

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
	 * Performs the retranslation from the now layouted KLayoutGraph to Commands
	 * that the GEF layouter will understand.
	 */
	public void applyLayout() {
		CompoundCommand compoundCommand = new CompoundCommand();
		compoundCommand.setLabel("Layout");
		CommandStack commandStack = (CommandStack) editor
				.getAdapter(CommandStack.class);

		for (GraphicalEditPart gep : nodeEditPart2NodeGroup.keySet()) {
			Rectangle oldBounds = gep.getFigure().getBounds();

			ChangeBoundsRequest changeBoundsRequest = new ChangeBoundsRequest(
					RequestConstants.REQ_RESIZE);
			changeBoundsRequest.setEditParts(gep);

			KDimension newSize = nodeEditPart2NodeGroup.get(gep).getLayout()
					.getSize();
			if (newSize != null) {
				int newWidth = (int) (newSize.getWidth() - oldBounds.width);
				int newHeight = (int) (newSize.getHeight() - oldBounds.height);
				changeBoundsRequest
						.setResizeDirection(PositionConstants.CENTER);
				changeBoundsRequest.setSizeDelta(new Dimension(newWidth,
						newHeight).scale(zoomLevel));
			}

			KPoint newLocation = nodeEditPart2NodeGroup.get(gep).getLayout()
					.getLocation();
			if (newLocation != null) {
				changeBoundsRequest.setMoveDelta(new Point(newLocation.getX()
						- oldBounds.x, newLocation.getY() - oldBounds.y)
						.scale(zoomLevel));
			}
			compoundCommand.add(gep.getCommand(changeBoundsRequest));

		}
		commandStack.execute(compoundCommand);

	}

	@Override
	public void chooseLayouter(String layouterHint) {
		// TODO Auto-generated method stub
	}

	@Override
	public void setupOptions() {
		if (root instanceof GraphicalEditPart
				&& ((GraphicalEditPart) root).getRoot() instanceof ScalableFreeformRootEditPart) {
			ScalableFreeformRootEditPart sfrep = (ScalableFreeformRootEditPart) ((GraphicalEditPart) root)
					.getRoot();
			zoomLevel = sfrep.getZoomManager().getZoom();
		}
	}

	public void setEditor(IEditorPart activeEditor) {
		this.editor = activeEditor;
	}

	private KNodeGroup createInitializedNodeGroup() {
		KNodeGroup nodeGroup = KimlLayoutGraphFactory.eINSTANCE
				.createKNodeGroup();
		KNodeGroupLayout layout = KimlLayoutGraphFactory.eINSTANCE
				.createKNodeGroupLayout();
		KPoint location = KimlLayoutGraphFactory.eINSTANCE.createKPoint();
		KDimension size = KimlLayoutGraphFactory.eINSTANCE.createKDimension();
		KInsets insets = KimlLayoutGraphFactory.eINSTANCE.createKInsets();
		KNodeGroupLabel nodeGroupLabel = KimlLayoutGraphFactory.eINSTANCE
				.createKNodeGroupLabel();
		layout.setLocation(location);
		layout.setSize(size);
		layout.setInsets(insets);
		nodeGroup.setLayout(layout);
		nodeGroup.setLabel(nodeGroupLabel);
		return nodeGroup;
	}
}

package edu.unikiel.rtsys.kieler.kiml.ui.layouter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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

import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KDimension;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KEdge;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KNodeGroup;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KNodeGroupLayout;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KPoint;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphFactory;
import edu.unikiel.rtsys.kieler.kiml.layout.services.KimlAbstractLayouter;

/**
 * This class enables layouting for GEF Editors.
 * 
 * @author ars
 * 
 */
public class KimlGEFLayouter extends KimlAbstractLayouter {

	private double zoomLevel = 1.0;
	private Map<GraphicalEditPart, KNodeGroup> editPart2Node = new HashMap<GraphicalEditPart, KNodeGroup>();
	private CommandStack commandStack = null;

	/**
	 * Translates the actual model representaion in the editor to the
	 * KLayoutGraph structure which is passed to the layouters.
	 */
	public boolean buildLayoutGraph() {
		if (root instanceof GraphicalEditPart) {
			GraphicalEditPart rootEditPart = (GraphicalEditPart) root;
			KNodeGroup topNodeGroup = KimlLayoutGraphFactory.eINSTANCE
					.createKNodeGroup();

			KNodeGroupLayout topNodeGroupLayout = KimlLayoutGraphFactory.eINSTANCE
					.createKNodeGroupLayout();
			/*
			 * Location stuff
			 */
			KPoint location = KimlLayoutGraphFactory.eINSTANCE.createKPoint();
			location.setX(rootEditPart.getFigure().getBounds().getLocation().x);
			location.setY(rootEditPart.getFigure().getBounds().getLocation().y);
			topNodeGroupLayout.setLocation(location);

			/*
			 * size stuff
			 */
			KDimension size = KimlLayoutGraphFactory.eINSTANCE
					.createKDimension();
			size.setHeight(rootEditPart.getFigure().getSize().height);
			size.setWidth(rootEditPart.getFigure().getSize().width);
			topNodeGroupLayout.setSize(size);

			topNodeGroup.setLayout(topNodeGroupLayout);

			layoutGraph.setTopGroup(topNodeGroup);
			editPart2Node.put(rootEditPart, topNodeGroup);
			buildLayoutGraphRecursive(rootEditPart, topNodeGroup);
			return true;
		} else
			return false;
	}

	/**
	 * Recursive helper function
	 * 
	 * @param parent
	 * @param parentNodeGroup
	 */
	public void buildLayoutGraphRecursive(GraphicalEditPart parent,
			KNodeGroup parentNodeGroup) {
		ArrayList<ConnectionEditPart> connections = new ArrayList<ConnectionEditPart>();

		for (Object obj : parent.getChildren()) {
			if (obj instanceof NodeEditPart) {
				NodeEditPart childNode = (NodeEditPart) obj;
				KNodeGroup childGroup = KimlLayoutGraphFactory.eINSTANCE
						.createKNodeGroup();
				KNodeGroupLayout childNodeGroupLayout = KimlLayoutGraphFactory.eINSTANCE
						.createKNodeGroupLayout();

				/*
				 * semantic stuff, store all the connections to process them
				 * later
				 */
				for (Object conn : childNode.getTargetConnections()) {
					if (conn instanceof ConnectionEditPart) {
						connections.add((ConnectionEditPart) conn);
					}
				}

				/*
				 * location stuff
				 */
				KPoint location = KimlLayoutGraphFactory.eINSTANCE
						.createKPoint();
				location
						.setX(childNode.getFigure().getBounds().getLocation().x);
				location
						.setY(childNode.getFigure().getBounds().getLocation().y);
				childNodeGroupLayout.setLocation(location);

				/*
				 * size stuff
				 */
				KDimension size = KimlLayoutGraphFactory.eINSTANCE
						.createKDimension();
				size.setHeight(childNode.getFigure().getSize().height);
				size.setWidth(childNode.getFigure().getSize().width);
				childNodeGroupLayout.setSize(size);

				childGroup.setLayout(childNodeGroupLayout);
				parentNodeGroup.getSubNodeGroups().add(childGroup);
				editPart2Node.put(childNode, childGroup);
				buildLayoutGraphRecursive(childNode, childGroup);
			} else if (obj instanceof GraphicalEditPart) {
				GraphicalEditPart childPart = (GraphicalEditPart) obj;
				buildLayoutGraphRecursive(childPart, parentNodeGroup);
			}
		}

		/*
		 * now process the connections, as Emma has build all the needed
		 * KNodeGroups
		 */
		for (ConnectionEditPart connection : connections) {
			KEdge edge = KimlLayoutGraphFactory.eINSTANCE.createKEdge();
			edge.setSource(editPart2Node.get(connection.getSource()));
			edge.setTarget(editPart2Node.get(connection.getTarget()));
		}
	}

	/**
	 * Performs the retranslation from the now layouted KLayoutGraph to Commands
	 * that the GEF layouter will understand.
	 */
	public boolean applyLayout() {
		CompoundCommand compoundCommand = new CompoundCommand();
		compoundCommand.setLabel("Layout");

		for (GraphicalEditPart gep : editPart2Node.keySet()) {
			Rectangle oldBounds = gep.getFigure().getBounds();

			/*
			 * size stuff, must be done first
			 */
			// KDimension newSize = editPart2Node.get(gep).getNodeGroupLayout()
			// .getSize();
			// if (newSize != null) {
			// ChangeBoundsRequest sizeRequest = new ChangeBoundsRequest(
			// RequestConstants.REQ_RESIZE);
			// int newWidth = (int) (newSize.getWidth() - oldBounds.width);
			// int newHeight = (int) (newSize.getHeight() - oldBounds.height);
			// sizeRequest.setSizeDelta(new Dimension(newWidth, newHeight));
			// compoundCommand.add(gep.getCommand(sizeRequest));
			// }
			/*
			 * location stuff
			 */
			KPoint newLocation = editPart2Node.get(gep).getLayout()
					.getLocation();
			if (newLocation != null) {
				System.out.println("Old: " + oldBounds);
				System.out.println("New: " + newLocation);

				ChangeBoundsRequest locationRequest = new ChangeBoundsRequest(
						RequestConstants.REQ_MOVE);
				locationRequest.setEditParts(gep);
				locationRequest.setMoveDelta(new Point(newLocation.getX()
						- oldBounds.x, newLocation.getY() - oldBounds.y)
						.scale(zoomLevel));
				compoundCommand.add(gep.getCommand(locationRequest));
			}
		}
		commandStack.execute(compoundCommand);
		return true;
	}

	public boolean init() {
		// get zooming level
		if (root instanceof GraphicalEditPart
				&& ((GraphicalEditPart) root).getRoot() instanceof ScalableFreeformRootEditPart) {
			GraphicalEditPart gep = (GraphicalEditPart) root;
			commandStack = gep.getViewer().getEditDomain().getCommandStack();
			ScalableFreeformRootEditPart sfrep = (ScalableFreeformRootEditPart) gep
					.getRoot();
			zoomLevel = sfrep.getZoomManager().getZoom();
		}
		if (commandStack == null)
			return false;
		return true;
	}

}

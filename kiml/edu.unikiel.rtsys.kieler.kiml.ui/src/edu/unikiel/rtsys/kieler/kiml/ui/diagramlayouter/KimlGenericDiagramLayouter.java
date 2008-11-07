package edu.unikiel.rtsys.kieler.kiml.ui.diagramlayouter;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.NodeEditPart;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.LabelEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramCommandStack;
import org.eclipse.jface.viewers.IStructuredSelection;

import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KEdge;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KLabel;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KLayoutGraph;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KNodeGroup;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphFactory;
import edu.unikiel.rtsys.kieler.kiml.layout.services.KimlAbstractLayouter;

public class KimlGenericDiagramLayouter extends KimlAbstractLayouter {

	private Map<NodeEditPart, KNodeGroup> nodeEditPart2NodeGroup = new HashMap<NodeEditPart, KNodeGroup>();
	private Map<KNodeGroup, GraphicalEditPart> nodeGroup2NodeEditPart = new HashMap<KNodeGroup, GraphicalEditPart>();
	private Map<KEdge, ConnectionEditPart> edge2ConnectionEditPart = new HashMap<KEdge, ConnectionEditPart>();
	private Map<KLabel, LabelEditPart> label2LabelEditPart = new HashMap<KLabel, LabelEditPart>();
	private CommandStack commandStack = null;

	private GraphicalEditPart rootPart;
	private KLayoutGraph layoutGraph;

	@Override
	protected void applyLayout() {
		if (commandStack == null) {
			// TODO error handling
			System.out.println(getClass().getSimpleName()
					+ ": Error: commandStack == null");
			return;
		}
		CompoundCommand compoundCommand = new CompoundCommand();
		compoundCommand.setLabel("Generic Diagram Layout");

		commandStack.execute(compoundCommand);
	}

	@Override
	protected KLayoutGraph buildLayoutGraph() {
		// init() took care that rootPart is not null and instance of
		// NodeEditPart
		NodeEditPart rootEditPart = (NodeEditPart) rootPart;

		layoutGraph = KimlLayoutGraphFactory.eINSTANCE.createKLayoutGraph();
		return layoutGraph;
	}

	@Override
	protected boolean init(Object target) {

		// get root part of provided object
		rootPart = getRootPart(target);

		if (!(rootPart instanceof NodeEditPart)) {
			return false;
		}
		commandStack = new DiagramCommandStack(null);
		if (commandStack == null) {
			System.out.println(getClass().getSimpleName()
					+ ": Error: commandStack == null");
			return false;
		}

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
				}
			}
			// more selected, find parent thereof
			else {
				root = findParentNode(selectedObject);
			}

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
}

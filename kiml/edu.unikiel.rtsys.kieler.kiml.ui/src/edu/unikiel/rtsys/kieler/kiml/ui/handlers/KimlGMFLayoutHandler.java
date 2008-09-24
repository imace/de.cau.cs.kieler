package edu.unikiel.rtsys.kieler.kiml.ui.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.NodeEditPart;
import org.eclipse.gef.editparts.AbstractEditPart;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;

import edu.unikiel.rtsys.kieler.kiml.ui.layouter.KimlGMFLayouter;

public class KimlGMFLayoutHandler extends AbstractHandler implements IHandler {

	public KimlGMFLayoutHandler() {
		super();
	}

	public Object execute(ExecutionEvent event) throws ExecutionException {

		GraphicalEditPart root = null;

		/*
		 * As this handler is activated from a menu, Emma needs to get the
		 * active menu selection. Just calling selection does not work when
		 * calling from within a view, for example. If called from a menu in the
		 * menu bar - not a context menu - Emma needs to use the
		 * currrentSelection.
		 */

		ISelection selection = HandlerUtil.getActiveMenuSelection(event);
		if (selection == null)
			selection = HandlerUtil.getCurrentSelection(event);
		if (selection != null && selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection) selection;

			// no matter how much was selected, get the first element
			Object selectedObject = structuredSelection.getFirstElement();

			// if just one element was selected, use this, if NodeEditPart
			if (structuredSelection.size() == 1) {
				if (selectedObject instanceof NodeEditPart) {
					root = (NodeEditPart) selectedObject;
				} else {
					root = findParentNode(selectedObject);
				}
			}
			// more selected, find parent thereof
			else {
				root = findParentNode(selectedObject);
			}
		}

		/*
		 * If Emma found an appropriate element to apply a layout on, then do
		 * it.
		 */
		if (root != null) {

			/*
			 * Check if Emma wants to layout just the selected element(s), or
			 * the entire diagram in the editor.
			 */
			String commandID = event.getCommand().getId();
			if (commandID
					.equals("edu.unikiel.rtsys.kieler.kiml.ui.command.kimlGMFLayoutAll")) {
				if (root.getViewer().getRootEditPart().getContents()
						.getChildren().get(0) instanceof NodeEditPart) {
					root = (NodeEditPart) root.getViewer().getRootEditPart()
							.getContents().getChildren().get(0);
				}
			}

			/*
			 * Finally, start layout process
			 */
			KimlGMFLayouter kimlGMFLayouter = new KimlGMFLayouter();
			kimlGMFLayouter.setRoot(root);
			kimlGMFLayouter.layout();
		}
		return null;
	}

	/*
	 * Recursive helper function to get a NodeEditPart parent for an object.
	 */
	private NodeEditPart findParentNode(Object current) {
		if (current instanceof AbstractEditPart) {
			AbstractEditPart aep = (AbstractEditPart) current;
			if (aep.getParent() instanceof NodeEditPart)
				return (NodeEditPart) aep.getParent();
			else
				return findParentNode(aep.getParent());
		} else
			return null;
	}
}

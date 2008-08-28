package edu.unikiel.rtsys.kieler.kiml.ui.popup.actions;

import java.util.ArrayList;

import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.IActionDelegate;

import edu.unikiel.rtsys.kieler.kiml.ui.custom.KimlColorHelper;
import edu.unikiel.rtsys.kieler.kiml.ui.custom.KimlLayoutHintHelper;

public class FunctionHighlightGroupMembers extends KimlAbstractAction {

	private KimlColorHelper colorHelper = new KimlColorHelper();

	/**
	 * @see IActionDelegate#run(IAction)
	 */
	public void run(IAction action) {
		// According to the semantic of the context menu, it should be
		// one ShapeNodeEditPart selected, but to play it safe
		if (selectedNodeElements.size() == 1) {
			ShapeNodeEditPart shapeNodeEditPart = selectedNodeElements.get(0);
			ArrayList<ShapeNodeEditPart> inSameGroup = KimlLayoutHintHelper
					.getGroupMembersByElement(shapeNodeEditPart);

			// there are some nodes in the same group
			if (inSameGroup.size() != 0) {

				// highlight all ShapeNodeEditParts red and select them
				shapeNodeEditPart.getViewer().deselectAll();

				colorHelper.highlightBackgrounds(inSameGroup);

				// inform the user with a message dialog
				MessageDialog
						.openInformation(
								shell,
								"KIEL Infrastructure for Meta Layout UI Plug-in",
								"The highlighted elements belong to the group "
										+ KimlLayoutHintHelper
												.getLayoutGroup(shapeNodeEditPart)
										+ " and have the layout hint "
										+ KimlLayoutHintHelper
												.getLayoutType(shapeNodeEditPart)
										+ ".");

				// after closing the dialog set color back
				colorHelper.restoreAllBackgrounds();

				// this node is not grouped
			} else {
				MessageDialog.openInformation(shell,
						"KIEL Infrastructure for Meta Layout UI Plug-in",
						"This element is not grouped.");

			}
		}
	}
}

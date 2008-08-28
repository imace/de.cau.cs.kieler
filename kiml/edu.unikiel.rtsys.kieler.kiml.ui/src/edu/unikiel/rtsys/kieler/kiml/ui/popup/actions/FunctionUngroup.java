package edu.unikiel.rtsys.kieler.kiml.ui.popup.actions;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;

import edu.unikiel.rtsys.kieler.kiml.ui.custom.KimlLayoutHintHelper;

public class FunctionUngroup extends KimlAbstractAction {

	/**
	 * TODO: If, after removing the selected element from a group, there is just
	 * one element left, also remove the grouping information thereof. This must
	 * be done in
	 * {@link KimlLayoutHintHelper#unsetLayoutHint(org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart[])}
	 * 
	 */
	public void run(IAction action) {
		KimlLayoutHintHelper.unsetLayoutHint(selectedNodeElements);

		MessageDialog.openInformation(shell,
				"KIEL Infrastructure for Meta Layout UI Plug-in",
				"Layout hints removed for an element/a group of elements.");
	}
}

package edu.unikiel.rtsys.kieler.kiml.ui.popup.actions;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.IActionDelegate;

import edu.unikiel.rtsys.kieler.kiml.ui.KimlLayoutHintConstants;
import edu.unikiel.rtsys.kieler.kiml.ui.custom.KimlLayoutHintHelper;

public class GroupAsVertical extends KimlAbstractAction {

	private String layoutType = KimlLayoutHintConstants.VERTICAL;

	/**
	 * @see IActionDelegate#run(IAction)
	 */
	public void run(IAction action) {
		String groupID = KimlLayoutHintHelper
				.generateLayoutGroupID(selectedNodeElements);
		KimlLayoutHintHelper.setLayoutHint(selectedNodeElements, groupID,
				layoutType);

		MessageDialog.openInformation(shell,
				"KIEL Infrastructure for Meta Layout UI Plug-in",
				KimlLayoutHintHelper.buildGroupAsMessage(layoutType, groupID,
						selectedNodeElements.size()));
	}

}

package edu.unikiel.rtsys.kieler.kiml.ui.handlers;

import java.util.ArrayList;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;

import edu.unikiel.rtsys.kieler.kiml.ui.custom.KimlColorHelper;
import edu.unikiel.rtsys.kieler.kiml.ui.custom.KimlLayoutHintHelper;

/**
 * @author ars
 * 
 */
public class GroupFunctionHandler extends AbstractHandler implements IHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection selection = HandlerUtil.getActiveMenuSelection(event);
		/*
		 * Filter out ShapeNodeEditParts. According to the menu.extension in
		 * plugin.xml it should just be ShapeNodeEditParts selected anyway, but
		 * right know Emma doesn't know how to do this properly. And later it
		 * should by possible for all kinds of (Node)EditParts.
		 */
		ArrayList<ShapeNodeEditPart> selectedNodeElements = new ArrayList<ShapeNodeEditPart>();
		if (selection != null && selection instanceof IStructuredSelection) {
			for (Object element : ((IStructuredSelection) selection).toList()) {
				if (element instanceof ShapeNodeEditPart)
					selectedNodeElements.add((ShapeNodeEditPart) element);
			}
		}

		String commandID = event.getCommand().getId(); 
		
		
		if (commandID.equals("edu.unikiel.rtsys.kieler.kiml.ui.command.selectGroupMembers")){
			if (selectedNodeElements.size() == 1) {
				ShapeNodeEditPart shapeNodeEditPart = selectedNodeElements.get(0);
				ArrayList<ShapeNodeEditPart> inSameGroup = KimlLayoutHintHelper
						.getGroupMembersByElement(shapeNodeEditPart);
		
				// there are some nodes in the same group
				if (inSameGroup.size() != 0) {

					// deselect all ShapeNodeEditParts
					shapeNodeEditPart.getViewer().deselectAll();
					// select group members
					for (ShapeNodeEditPart editpart : inSameGroup) {
						shapeNodeEditPart.getViewer().appendSelection(editpart);
					}

					// this node is not grouped
				} else {
					MessageDialog.openInformation(HandlerUtil.getActiveShell(event),
							"KIEL Infrastructure for Meta Layout UI Plug-in",
							"This element is not grouped.");
				}
			}
		}
		
		
		if (commandID.equals("edu.unikiel.rtsys.kieler.kiml.ui.command.highlightGroupMembers")){
			if (selectedNodeElements.size() == 1) {
				KimlColorHelper colorHelper = new KimlColorHelper();
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
									HandlerUtil.getActiveShell(event),
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
					MessageDialog.openInformation(HandlerUtil.getActiveShell(event),
							"KIEL Infrastructure for Meta Layout UI Plug-in",
							"This element is not grouped.");
				}
			}
		}
		
		
		
		if (commandID.equals("edu.unikiel.rtsys.kieler.kiml.ui.command.ungroupElements")){
			KimlLayoutHintHelper.unsetLayoutHint(selectedNodeElements);
			MessageDialog.openInformation(HandlerUtil.getActiveShell(event),
					"KIEL Infrastructure for Meta Layout UI Plug-in",
					"Layout hints removed for an element/a group of elements.");
		}
		
		
		return null;
	}

}

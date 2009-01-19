/*******************************************************************************
 * Copyright (c) 2008 Real-Time and Embedded Systems group
 *
 * INSERT LICENCE HERE
 *
 *
 * Author: Arne Schipper, ars@informatik.uni-kiel.de 
 *
 *******************************************************************************/
package edu.unikiel.rtsys.kieler.kiml.ui.handlers;

import java.util.ArrayList;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;

import edu.unikiel.rtsys.kieler.kiml.ui.ContributionItemGroupFunctions;
import edu.unikiel.rtsys.kieler.kiml.ui.helpers.KimlGMFColorHelper;
import edu.unikiel.rtsys.kieler.kiml.ui.helpers.KimlGMFLayoutHintHelper;
import edu.unikiel.rtsys.kieler.kiml.ui.views.KimlLayoutHintView;

/**
 * The handler which is responsible for the functions applicable to layout
 * groups. Handler is called when executing a command. This is set in the
 * plugin.xml file. The commands can only be issued through a menu, when the
 * grouping of single elements is enabled. At the moment, this covers the
 * following functions:
 * <ul>
 * <li>Select all group members of one element</li>
 * <li>Highlight all group members of one element</li>
 * <li>Remove one or more elements from a group</li>
 * </ul>
 * 
 * @author <a href="mailto:ars@informatik.uni-kiel.de">Arne Schipper</a>
 * @see LayoutAsHandler
 * @see GroupAsHandler
 * @see ContributionItemGroupFunctions
 * @see KimlLayoutHintView
 * @deprecated This method was introduced to support grouping of single elements
 *             within one compartment. It should be moved/changed to a somehow
 *             better place and name and the implementation is about to change.
 *             Full support for laying out (and grouping) is given in
 *             {@link LayoutAsHandler}. Though this just works with <b>all</b>
 *             elements of a compartment as a whole, this is in most cases what
 *             you want.
 * 
 */
public class GroupFunctionHandler extends AbstractHandler implements IHandler {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands
	 * .ExecutionEvent)
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {

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

		/*
		 * The code to mark all group members as selected.
		 */
		if (commandID
				.equals("edu.unikiel.rtsys.kieler.kiml.ui.command.selectGroupMembers")) {
			if (selectedNodeElements.size() == 1) {
				ShapeNodeEditPart shapeNodeEditPart = selectedNodeElements
						.get(0);
				ArrayList<GraphicalEditPart> inSameGroup = (ArrayList<GraphicalEditPart>) KimlGMFLayoutHintHelper
						.getGroupMembersByElement(shapeNodeEditPart);

				// there are some nodes in the same group
				if (inSameGroup.size() != 0) {

					// unselect all ShapeNodeEditParts
					shapeNodeEditPart.getViewer().deselectAll();
					// select group members
					for (GraphicalEditPart editpart : inSameGroup) {
						shapeNodeEditPart.getViewer().appendSelection(editpart);
					}

					// this node is not grouped
				} else {
					MessageDialog.openInformation(HandlerUtil
							.getActiveShell(event),
							"KIEL Infrastructure for Meta Layout UI Plug-in",
							"This element is not grouped.");
				}
			}
		}

		/*
		 * The code to highlight the group members.
		 */
		if (commandID
				.equals("edu.unikiel.rtsys.kieler.kiml.ui.command.highlightGroupMembers")) {
			if (selectedNodeElements.size() == 1) {
				KimlGMFColorHelper colorHelper = new KimlGMFColorHelper();
				ShapeNodeEditPart shapeNodeEditPart = selectedNodeElements
						.get(0);
				ArrayList<GraphicalEditPart> inSameGroup = KimlGMFLayoutHintHelper
						.getGroupMembersByElement(shapeNodeEditPart);

				// there are some nodes in the same group
				if (inSameGroup.size() != 0) {

					// highlight all ShapeNodeEditParts red and select them
					shapeNodeEditPart.getViewer().deselectAll();

					colorHelper.highlightBackgrounds(inSameGroup);

					// inform the user with a message dialog
					MessageDialog.openInformation(HandlerUtil
							.getActiveShell(event),
							"KIEL Infrastructure for Meta Layout UI Plug-in",
							"The highlighted elements belong to the group "
									+ KimlGMFLayoutHintHelper
											.getLayoutGroup(shapeNodeEditPart)
									+ " and have the layout hint "
									+ KimlGMFLayoutHintHelper
											.getLayoutType(shapeNodeEditPart)
									+ ".");

					// after closing the dialog set color back
					colorHelper.restoreAllBackgrounds();

					// this node is not grouped
				} else {
					MessageDialog.openInformation(HandlerUtil
							.getActiveShell(event),
							"KIEL Infrastructure for Meta Layout UI Plug-in",
							"This element is not grouped.");
				}
			}
		}

		/*
		 * The code to ungroup the selected elements.
		 */
		if (commandID
				.equals("edu.unikiel.rtsys.kieler.kiml.ui.command.ungroupElements")) {
			KimlGMFLayoutHintHelper.unsetLayoutHint(selectedNodeElements);
			MessageDialog.openInformation(HandlerUtil.getActiveShell(event),
					"KIEL Infrastructure for Meta Layout UI Plug-in",
					"Layout hints removed for an element/a group of elements.");
		}

		return null;
	}

}

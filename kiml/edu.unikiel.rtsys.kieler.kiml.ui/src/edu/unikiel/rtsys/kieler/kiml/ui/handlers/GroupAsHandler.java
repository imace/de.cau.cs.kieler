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

import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.LAYOUT_TYPE;
import edu.unikiel.rtsys.kieler.kiml.ui.helpers.KimlGMFLayoutHintHelper;


/**
 * The handler which is responsible for the functions to group the selected
 * elements. At the moment, this covers the following functions:
 * <ul>
 * <li>...</li>
 * </ul>
 * 
 * @author ars
 * 
 */
public class GroupAsHandler extends AbstractHandler implements IHandler {

	@Override
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

		/*
		 * Another plausibility check, should also be covered once in plugin.xml
		 */
		if (selectedNodeElements.size() >= 2) {
			LAYOUT_TYPE layoutType = LAYOUT_TYPE.DEFAULT;
			String commandID = event.getCommand().getId();
			if (commandID
					.equals("edu.unikiel.rtsys.kieler.kiml.ui.command.groupAsDefault")) {
				layoutType = LAYOUT_TYPE.DEFAULT;
			}
			if (commandID
					.equals("edu.unikiel.rtsys.kieler.kiml.ui.command.groupAsOther")) {
				layoutType = LAYOUT_TYPE.OTHER;
			}
			if (commandID
					.equals("edu.unikiel.rtsys.kieler.kiml.ui.command.groupAsCircle")) {
				layoutType = LAYOUT_TYPE.CIRCLE;
			}
			if (commandID
					.equals("edu.unikiel.rtsys.kieler.kiml.ui.command.groupAsDot")) {
				layoutType = LAYOUT_TYPE.HIERARCHICAL;
			}
			if (commandID
					.equals("edu.unikiel.rtsys.kieler.kiml.ui.command.groupAsRadial")) {
				layoutType = LAYOUT_TYPE.RADIAL;
			}
			if (commandID
					.equals("edu.unikiel.rtsys.kieler.kiml.ui.command.groupAsSpringModel")) {
				layoutType = LAYOUT_TYPE.SPRING_MODEL;
			}

			String groupID = KimlGMFLayoutHintHelper
					.generateLayoutGroupID(selectedNodeElements);
			KimlGMFLayoutHintHelper.setLayoutHint(selectedNodeElements, groupID,
					layoutType);

			MessageDialog.openInformation(HandlerUtil.getActiveShell(event),
					"KIEL Infrastructure for Meta Layout UI Plug-in",
					KimlGMFLayoutHintHelper.buildGroupAsMessage(layoutType.getLiteral(),
							groupID, selectedNodeElements.size()));
		}
		return null;
	}

}

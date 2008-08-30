package edu.unikiel.rtsys.kieler.kiml.ui.handlers;

import java.util.ArrayList;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.commands.common.NotDefinedException;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;
import org.eclipse.ui.handlers.HandlerUtil;

import edu.unikiel.rtsys.kieler.kiml.ui.KimlLayoutHintConstants;
import edu.unikiel.rtsys.kieler.kiml.ui.custom.KimlLayoutHintHelper;

/**
 * @author ars
 * 
 */
public class GroupAsHandler extends AbstractHandler implements IHandler {
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection selection = HandlerUtil.getActiveMenuSelection(event);
		//getActiveWorkbenchWindow(event).getSelectionService().getSelection();
//		.getActivePage().getSelection();
		//ISelection selection = HandlerUtil.getCurrentSelection(event);
		System.out.println(event);
		System.out.println(event.getCommand());
		try {
			System.out.println(event.getCommand().getParameters());
		} catch (NotDefinedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
			String layoutType = KimlLayoutHintConstants.NONE;
			String commandID = event.getCommand().getId(); 
			if (commandID.equals("edu.unikiel.rtsys.kieler.kiml.ui.command.groupAsNone")){
				layoutType = KimlLayoutHintConstants.NONE;
			}
			if (commandID.equals("edu.unikiel.rtsys.kieler.kiml.ui.command.groupAsCustom")){
				layoutType = KimlLayoutHintConstants.CUSTOM;
			}
			if (commandID.equals("edu.unikiel.rtsys.kieler.kiml.ui.command.groupAsCircle")){
				layoutType = KimlLayoutHintConstants.CIRCLE;
			}
			if (commandID.equals("edu.unikiel.rtsys.kieler.kiml.ui.command.groupAsDot")){
				layoutType = KimlLayoutHintConstants.DOT;
			}
			if (commandID.equals("edu.unikiel.rtsys.kieler.kiml.ui.command.groupAsHorizontal")){
				layoutType = KimlLayoutHintConstants.HORIZONTAL;
			}
			if (commandID.equals("edu.unikiel.rtsys.kieler.kiml.ui.command.groupAsVertical")){
				layoutType = KimlLayoutHintConstants.VERTICAL;
			}
			
			String groupID = KimlLayoutHintHelper
					.generateLayoutGroupID(selectedNodeElements);
			KimlLayoutHintHelper.setLayoutHint(selectedNodeElements, groupID,
					layoutType);

			MessageDialog.openInformation(HandlerUtil.getActiveShell(event),
					"KIEL Infrastructure for Meta Layout UI Plug-in",
					KimlLayoutHintHelper.buildGroupAsMessage(layoutType,
							groupID, selectedNodeElements.size()));
		}
		return null;
	}

}

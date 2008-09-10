package edu.unikiel.rtsys.kieler.kiml.ui.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;

import edu.unikiel.rtsys.kieler.kiml.layout.services.KimlRecursiveGroupLayouterEngine;
import edu.unikiel.rtsys.kieler.kiml.ui.layouter.KimlGMFLayouter;

public class KimlGMFLayoutHandler extends AbstractHandler implements IHandler {

	public KimlGMFLayoutHandler() {
		super();
	}

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
		if (selection != null && selection instanceof IStructuredSelection) {
			GraphicalEditPart root = (GraphicalEditPart) ((IStructuredSelection)selection).toList().get(0);
			KimlGMFLayouter kimlGMFLayouter = new KimlGMFLayouter();
			kimlGMFLayouter.setRoot(root);
			kimlGMFLayouter.setEditor(HandlerUtil.getActiveEditor(event));
			kimlGMFLayouter.setLayouter(new KimlRecursiveGroupLayouterEngine());
			kimlGMFLayouter.layout();
		}
		return null;
	}

}

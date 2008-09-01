package edu.unikiel.rtsys.kieler.kiml.ui.handlers;

import kiel.layouter.graphviz.GEFGraphvizLayoutProvider;
import kiel.layouter.graphviz.GraphvizLayoutProvider;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.internal.dialogs.AdaptableForwarder;

import edu.unikiel.rtsys.layouter.LayoutType;

/**
 * An Action that will execute a KIELER arrange layouting command for any type
 * of GEF editor. Will be only available for GEF based editors, e.g. GMF or GEMS
 * editors.
 * 
 * This is intended to replace the KimlArrangeAction, which is an GMF specific
 * action contribution.
 * 
 * @author haf, ars
 * 
 */
public class LayoutGEFHandler extends AbstractHandler implements IHandler {

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
			IStructuredSelection structuredSelection = (IStructuredSelection) selection;
			Object first = structuredSelection.getFirstElement();
			if (first instanceof GraphicalEditPart) {
				System.out.println("inside");
				GraphicalEditPart containerEditPart = (GraphicalEditPart) first;
				GEFGraphvizLayoutProvider glp = new GEFGraphvizLayoutProvider();
				String layoutType = LayoutType.GRAPHVIZ_DOT;
				IAdaptable layoutHint = new AdaptableForwarder(layoutType);
				Command layoutCommand = glp.layoutEditParts(containerEditPart,
						layoutHint);
				if (layoutCommand != null)
					layoutCommand.execute();
			}

		}
		// TODO implement GEF layouting
		System.out.println("KIML: Layout GEF.");

		return null;
	}
}

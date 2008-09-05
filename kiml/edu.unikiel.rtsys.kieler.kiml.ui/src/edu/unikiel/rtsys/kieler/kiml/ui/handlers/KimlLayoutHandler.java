package edu.unikiel.rtsys.kieler.kiml.ui.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.gef.NodeEditPart;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;

import edu.unikiel.rtsys.kieler.kiml.layout.services.KimlLayoutProvider;
import edu.unikiel.rtsys.kieler.kiml.layout.services.KimlRecursiveGroupLayoutProvider;

public class KimlLayoutHandler extends AbstractHandler implements IHandler {

	public KimlLayoutHandler() {
		super();
		// TODO Auto-generated constructor stub
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
			System.out.println("UI: KimlLayoutHandler.");
			NodeEditPart topNode = (NodeEditPart) ((IStructuredSelection)selection).toList().get(0);
			KimlRecursiveGroupLayoutProvider kimlLayoutProvider = new KimlRecursiveGroupLayoutProvider();
			kimlLayoutProvider.layout(topNode);
		}

		// TODO Auto-generated method stub
		return null;
	}

}

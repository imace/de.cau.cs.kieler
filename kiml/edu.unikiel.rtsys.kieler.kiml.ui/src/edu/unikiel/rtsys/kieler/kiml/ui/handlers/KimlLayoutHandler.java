package edu.unikiel.rtsys.kieler.kiml.ui.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;

import edu.unikiel.rtsys.kieler.kiml.layout.services.DiagramLayouters;
import edu.unikiel.rtsys.kieler.kiml.layout.services.KimlAbstractLayouter;

public class KimlLayoutHandler extends AbstractHandler implements IHandler {

	public KimlLayoutHandler() {
		super();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException
	{
		/* As this handler is activated from a menu, Emma needs to get the
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

			// get command ID
			String commandId = event.getCommand().getId();
			// find a layouter
			String editorId = HandlerUtil.getActiveEditor(event).getEditorSite().getId();
			KimlAbstractLayouter diagramLayouter = DiagramLayouters.getInstance().getDiagramLayouter(editorId);
			// start layout process
			if (diagramLayouter != null)
			{
				diagramLayouter.layout(structuredSelection, commandId);
			}
			else
			{
				// TODO error handling
				System.err.println("KimlLayoutHandler: No diagram layouter found for the given editor.");
			}
		}
		return null;
	}
	
}

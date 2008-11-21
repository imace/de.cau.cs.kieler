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

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.draw2d.Animation;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.handlers.HandlerUtil;

import edu.unikiel.rtsys.kieler.kiml.layout.services.DiagramLayouters;
import edu.unikiel.rtsys.kieler.kiml.layout.services.KimlAbstractLayouter;
import edu.unikiel.rtsys.kieler.kiml.ui.ContributionItemLayoutAs;

/**
 * The handler which is responsible to lay out the diagram or parts thereof.
 * <p/>
 * According to the command provided, the handler lays out the whole diagram or
 * just the selected part of it. Handler is called when executing a command,
 * which is set in the plugin.xml file. Animation is enabled.
 * 
 * @author <a href="mailto:ars@informatik.uni-kiel.de">Arne Schipper</a>
 * @see LayoutAsHandler
 * @see ContributionItemLayoutAs
 */
public class KimlLayoutHandler extends AbstractHandler implements IHandler {

	/* must be the same String as defined in the plugin.xml under the command */
	private static final String COMMAND_ID_LAYOUT_ALL = "edu.unikiel.rtsys.kieler.kiml.ui.command.kimlLayoutAll";

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands
	 * .ExecutionEvent)
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		// get the active editor
		IEditorPart editorPart = HandlerUtil.getActiveEditor(event);
		// find a layouter
		String editorId = editorPart.getEditorSite().getId();
		KimlAbstractLayouter diagramLayouter = DiagramLayouters.getInstance()
				.getDiagramLayouter(editorId);

		if (diagramLayouter != null) {
			// get command ID
			String commandId = event.getCommand().getId();

			/*
			 * As this handler is activated from a menu, Emma needs to get the
			 * active menu selection. Just calling selection does not work when
			 * calling from within a view, for example. If called from a menu in
			 * the menu bar - not a context menu - Emma needs to use the
			 * currrentSelection.
			 */
			ISelection selection = HandlerUtil.getActiveMenuSelection(event);
			if (selection == null)
				selection = HandlerUtil.getCurrentSelection(event);

			/* see what Emma wants to do */
			if (selection == null
					|| (selection instanceof IStructuredSelection && ((IStructuredSelection) selection)
							.size() == 0)
					|| commandId.equals(COMMAND_ID_LAYOUT_ALL)) {
				// start layout process with editor part
				Animation.markBegin();
				diagramLayouter.layout(editorPart);
				Animation.run(1000);
			} else {
				// start layout process with selection
				Animation.markBegin();
				diagramLayouter.layout(selection);
				Animation.run(1000);
			}
		} else {
			/*
			 * TODO: error handling, actually that should not happen, as there is
			 * the GenericDiagramLayouter
			 */
			System.err.println(getClass().getSimpleName()
					+ ": No diagram layouter found for the given editor.");
		}
		return null;
	}

}

/******************************************************************************
 * KIELER - Kiel Integrated Environment for Layout for the Eclipse RCP
 *
 * http://www.informatik.uni-kiel.de/rtsys/kieler/
 * 
 * Copyright 2008 by
 * + Christian-Albrechts-University of Kiel
 *   + Department of Computer Science
 *     + Real-Time and Embedded Systems Group
 * 
 * This code is provided under the terms of the Eclipse Public License (EPL).
 * See the file epl-v10.html for the license text.
 */
package de.cau.cs.kieler.kiml.ui.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.handlers.HandlerUtil;

import de.cau.cs.kieler.kiml.ui.ContributionItemLayoutAs;
import de.cau.cs.kieler.kiml.ui.diagramlayouter.KimlDiagramLayouter;

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
	private static final String COMMAND_ID_LAYOUT_ALL = "de.cau.cs.kieler.kiml.ui.command.kimlLayoutAll";

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
	
		String commandId = event.getCommand().getId();

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

		/* see what Emma wants to do */
		if (selection == null
				|| (selection instanceof IStructuredSelection && ((IStructuredSelection) selection)
						.size() == 0)
				|| commandId.equals(COMMAND_ID_LAYOUT_ALL)) {
			// start layout process with editor part
			KimlDiagramLayouter.layout(editorPart, true, true);
		} else {
			// start layout process with selection
			KimlDiagramLayouter.layout(selection, true, true);
		}

		return null;
	}

}

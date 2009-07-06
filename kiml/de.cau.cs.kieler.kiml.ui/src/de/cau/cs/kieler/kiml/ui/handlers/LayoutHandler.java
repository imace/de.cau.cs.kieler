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
import org.eclipse.gef.EditPart;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.handlers.HandlerUtil;

import de.cau.cs.kieler.kiml.ui.layout.DiagramLayoutManager;

/**
 * The handler which is responsible to perform layout.
 * 
 * @author <a href="mailto:ars@informatik.uni-kiel.de">Arne Schipper</a>
 */
public class LayoutHandler extends AbstractHandler implements IHandler {

    /** parameter identifier for the scope of automatic layout */
    public static final String PARAM_LAYOUT_SCOPE = "de.cau.cs.kieler.kiml.ui.layoutScope";
    /** value for diagram scope */
	public static final String VAL_DIAGRAM = "diagram";
	/** value for selection scope */
	public static final String VAL_SELECTION = "selection";

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection selection = null;
		
		// check parameter for layout scope, default is diagram scope
		String layoutScope = event.getParameter(PARAM_LAYOUT_SCOPE);
		if (layoutScope != null && layoutScope.equals(VAL_SELECTION)) {
		     selection = HandlerUtil.getActiveMenuSelection(event);
		        if (selection == null)
		            selection = HandlerUtil.getCurrentSelection(event);
		}
		
        IEditorPart editorPart = HandlerUtil.getActiveEditor(event);
		if (selection instanceof IStructuredSelection && !selection.isEmpty()) {
		    IStructuredSelection structuredSelection = (IStructuredSelection) selection;
		    EditPart selectedElement = null;
		    if (structuredSelection.getFirstElement() instanceof EditPart)
		        selectedElement = (EditPart)structuredSelection.getFirstElement();
    		DiagramLayoutManager.layout(editorPart, selectedElement, true);
		}
		else
		    DiagramLayoutManager.layout(editorPart, null, true);

		return null;
	}

}

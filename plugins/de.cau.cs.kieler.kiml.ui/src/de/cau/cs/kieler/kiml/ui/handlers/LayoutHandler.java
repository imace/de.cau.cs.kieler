/*
 * KIELER - Kiel Integrated Environment for Layout Eclipse RichClient
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
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.handlers.HandlerUtil;

import de.cau.cs.kieler.kiml.ui.layout.LayoutEffect;

/**
 * The handler which is responsible to perform layout in a graphical diagram.
 * 
 * @kieler.rating 2009-12-11 proposed yellow msp
 * @author msp
 */
public class LayoutHandler extends AbstractHandler {

    /** parameter identifier for the scope of automatic layout. */
    public static final String PARAM_LAYOUT_SCOPE = "de.cau.cs.kieler.kiml.ui.layoutScope";
    /** value for diagram scope. */
    public static final String VAL_DIAGRAM = "diagram";
    /** value for selection scope. */
    public static final String VAL_SELECTION = "selection";

    /**
     * {@inheritDoc}
     */
    public Object execute(final ExecutionEvent event) throws ExecutionException {
        ISelection selection = null;

        // check parameter for layout scope, default is diagram scope
        String layoutScope = event.getParameter(PARAM_LAYOUT_SCOPE);
        if (layoutScope != null && layoutScope.equals(VAL_SELECTION)) {
            selection = HandlerUtil.getActiveMenuSelection(event);
            if (selection == null) {
                selection = HandlerUtil.getCurrentSelection(event);
            }
        }

        // get the active editor, use the help of an external connector if necessary
        IEditorPart editorPart = HandlerUtil.getActiveEditor(event);
        if (selection instanceof IStructuredSelection && !selection.isEmpty()) {
            // perform layout with the given selection
            IStructuredSelection structuredSelection = (IStructuredSelection) selection;
            if (structuredSelection.getFirstElement() instanceof EditPart) {
                EditPart selectedElement = (EditPart) structuredSelection.getFirstElement();
                // EclipseLayoutServices.getInstance().layout(
                // editorPart, selectedElement, true, true);
                // FIXME quick & dirty way of using the effect with the proper thread
                new LayoutEffect(editorPart, ((View) selectedElement.getModel()).getElement())
                        .schedule();
                return null;
            }
        }
//        EclipseLayoutServices.getInstance().layout(editorPart, null, true, true);
        new LayoutEffect(editorPart, null).schedule();
        return null;
    }

}

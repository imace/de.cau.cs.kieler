/******************************************************************************
 * KIELER - Kiel Integrated Environment for Layout Eclipse RichClient
 *
 * http://www.informatik.uni-kiel.de/rtsys/kieler/
 * 
 * Copyright 2009 by
 * + Christian-Albrechts-University of Kiel
 *   + Department of Computer Science
 *     + Real-Time and Embedded Systems Group
 * 
 * This code is provided under the terms of the Eclipse Public License (EPL).
 * See the file epl-v10.html for the license text.
 * 
 *****************************************************************************/
package de.cau.cs.kieler.viewmanagement.effects;

import org.eclipse.gef.EditPart;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;

import de.cau.cs.kieler.kiml.ui.layout.DiagramLayoutManager;
import de.cau.cs.kieler.viewmanagement.AEffect;

/**
 * The effect that is used to perform auto layout
 * 
 * @author Michael Matzen
 * 
 */
public class LayoutEffect extends AEffect {

    EditPart editPart; // the edit part for the auto layout method
    IEditorPart editorPart; // the editor part for the auto layout method

    /**
     * Performs auto layout by simply calling the layout method from
     * {@link DiagramLayoutManager}. It must be called in a safe thread, because
     * it changes the notation model and hence must go through the EMF transaction
     * mechanism. When this execute is called from a weird thread, e.g. when
     * the notation model is in a read-only context, you might otherwise get an
     * IllegalStateException. So here layout is called from within the 
     * display thread.
     */
    @Override
    public void execute() {
        final IWorkbench workbench = PlatformUI.getWorkbench();
        workbench.getDisplay().asyncExec(new Runnable() {
          public void run() {
              DiagramLayoutManager.layout(editorPart, editPart, true, false);
          }});
    }

    /**
     * Sets the effect parameters. In this special case the parameter is an
     * IEditorPart
     */
    @Override
    public void setParameters(Object parameters) {
        if (parameters instanceof IEditorPart)
            this.editorPart = (IEditorPart) parameters;
    }

    /**
     * Sets the target ShapeEditPart
     */
    @Override
    public void setTarget(EditPart target) {
        this.editPart = (EditPart) target;
        this.editorPart=PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
    }

}


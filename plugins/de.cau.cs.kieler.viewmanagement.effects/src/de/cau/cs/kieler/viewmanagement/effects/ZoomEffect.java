/*
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

import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;

import de.cau.cs.kieler.core.ui.handler.ZoomToFitHandler;
import de.cau.cs.kieler.viewmanagement.AEffect;

/**
 * @author haf
 * 
 *         The ZoomEffect performs a Zoom-To-Fit action on the current editor.
 */
public class ZoomEffect extends AEffect {

    /**
     * Enqueue zooming for the GUI thread.
     */
    public final void execute() {
        // get active editor
        IWorkbench workbench = PlatformUI.getWorkbench();

        final IEditorPart editor = workbench.getActiveWorkbenchWindow().getActivePage()
                .getActiveEditor();

        // use GUI thread to honor the order of effects
        workbench.getDisplay().asyncExec(new Runnable() {
            public void run() {
                ZoomToFitHandler.zoomToFitAllNodes(editor);
                ZoomToFitHandler.resetViewLocation(editor);
            }
        });
    }
}

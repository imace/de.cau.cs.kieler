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

import org.eclipse.gef.editparts.ZoomManager;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.gmf.runtime.diagram.ui.render.editparts.RenderedDiagramRootEditPart;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import de.cau.cs.kieler.viewmanagement.AEffect;

/**
 * @author nbe
 * 
 *         The ZoomEffect performs a Zoom-To-Fit action on the current editor.
 */
public class ZoomEffect extends AEffect {

    private ZoomManager zoomManager;

    public final void execute() {
        // get active editor
        IEditorPart editor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
                .getActiveEditor();
        if (editor instanceof DiagramEditor) {
            // get its zoom manager
            DiagramEditPart diagramEdit = ((DiagramEditor) editor).getDiagramEditPart();
            zoomManager = ((RenderedDiagramRootEditPart) diagramEdit.getRoot()).getZoomManager();
        }
        // set zoom to zoom-to-fit value
        zoomManager.setZoomAsText(ZoomManager.FIT_ALL);

    }

}

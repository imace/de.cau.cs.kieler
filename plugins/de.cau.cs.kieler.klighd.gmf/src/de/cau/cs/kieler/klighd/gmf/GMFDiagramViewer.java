/*
 * KIELER - Kiel Integrated Environment for Layout Eclipse RichClient
 *
 * http://www.informatik.uni-kiel.de/rtsys/kieler/
 * 
 * Copyright 2011 by
 * + Christian-Albrechts-University of Kiel
 *   + Department of Computer Science
 *     + Real-Time and Embedded Systems Group
 * 
 * This code is provided under the terms of the Eclipse Public License (EPL).
 * See the file epl-v10.html for the license text.
 */
package de.cau.cs.kieler.klighd.gmf;

import org.eclipse.gef.RootEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramGraphicalViewer;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.EditPartService;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.swt.widgets.Control;

import de.cau.cs.kieler.klighd.AbstractViewer;

/**
 * A wrapper for a {@code DiagramGraphicalViewer} to fit the {@code IViewer} interface.
 * 
 * @author mri
 */
public class GMFDiagramViewer extends AbstractViewer<Diagram> {

    /** the graphical viewer. */
    private DiagramGraphicalViewer graphicalViewer;

    /**
     * Constructs a GMFDiagramViewer wrapping a {@code DiagramGraphicalViewer}.
     * 
     * @param graphicalViewer
     *            the graphical viewer
     */
    public GMFDiagramViewer(final DiagramGraphicalViewer graphicalViewer) {
        this.graphicalViewer = graphicalViewer;
    }

    /**
     * {@inheritDoc}
     */
    public Control getControl() {
        return graphicalViewer.getControl();
    }

    /**
     * {@inheritDoc}
     */
    public void setModel(final Diagram model) {
        // configure the viewer
        RootEditPart rootEditPart = EditPartService.getInstance().createRootEditPart(model);
        graphicalViewer.setRootEditPart(rootEditPart);
        // set the content
        graphicalViewer.setContents(model);
        // disable the edit mode
        ((DiagramEditPart) graphicalViewer.getContents()).disableEditMode();
    }

}

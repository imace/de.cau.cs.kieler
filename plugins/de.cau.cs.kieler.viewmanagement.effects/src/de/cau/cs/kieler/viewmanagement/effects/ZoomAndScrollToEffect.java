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

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Viewport;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.RootEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.render.editparts.RenderedDiagramRootEditPart;

import de.cau.cs.kieler.viewmanagement.AEffect;

/**
 * @author nbe
 * 
 *         The ZoomAndScrollToEffect scrolls to the affectedObject and zooms in, in order to enlarge
 *         it as much as possible. The limit is the maximum zoom value (4.00), zoom values larger
 *         than that will be ignored.
 */
public class ZoomAndScrollToEffect extends AEffect {

    private ShapeEditPart objectToHighlight;
    // offset is used to move the object somewhat away from the border of the editor,
    // the value is arbitrary and should be set in a better way
    private int offset = 25;

    /**
     * default constructor, nothing to be done here
     */
    public ZoomAndScrollToEffect() {

    }

    public final void execute() {

        // determine bounds of the object that should be focused on
        RootEditPart rootEP = objectToHighlight.getRoot();
        IFigure selectedFigure = objectToHighlight.getFigure();
        Rectangle bounds = selectedFigure.getBounds().getCopy();
        // get top-most viewport to set the scroll values
        Viewport viewport = null;
        IFigure parentFigure = selectedFigure.getParent();
        while (parentFigure != null) {
            if (parentFigure instanceof Viewport) {
                viewport = (Viewport) parentFigure;

            }
            parentFigure = parentFigure.getParent();

        }
        // add offset to bounds
        bounds.height = bounds.height + offset;
        bounds.width = bounds.width + offset;
        // get current size of editor window
        double maxHeight = viewport.getBounds().height;
        double maxWidth = viewport.getBounds().width;
        // determine which dimension limits the enlargement of the object and set zoom factor
        // accordingly
        double zoomFactor1 = maxHeight / bounds.height;
        double zoomFactor2 = maxWidth / bounds.width;

        double zoomFactor;
        if (zoomFactor1 < zoomFactor2) {
            zoomFactor = zoomFactor1;
        } else {
            zoomFactor = zoomFactor2;
        }
        // set zoom factor
        selectedFigure.translateToAbsolute(bounds);
        double newZoomValue = zoomFactor;
        ((RenderedDiagramRootEditPart) rootEP).getZoomManager().setZoom(newZoomValue);
        // get new bounds of the enlarged object
        bounds.scale(1 / newZoomValue);
        // scroll to the object (maybe there should be added some additional offset to precisely
        // center this)
        viewport.getHorizontalRangeModel().setValue(bounds.x);
        viewport.getVerticalRangeModel().setValue(bounds.y);

    }

    /**
     * Sets the target of the effect
     * 
     * @param target
     *            the target
     */
    public final void setTarget(EditPart target) {
        this.objectToHighlight = (ShapeEditPart) target;
    }

}

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

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.Viewport;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.RootEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.render.editparts.RenderedDiagramRootEditPart;
import org.eclipse.swt.graphics.Color;

import de.cau.cs.kieler.viewmanagement.AEffect;

/**
 * @author nbe
 * 
 */
public class HighlightEffect extends AEffect {

    ShapeEditPart objectToHighlight;
    RectangleFigure highlightFigure;

    int lineWidth = 3;
    Color color = ColorConstants.red;

    /**
     * default constructor, highlighting figure is initially defined here
     */
    public HighlightEffect() {

        this.highlightFigure = new RectangleFigure();
        highlightFigure.setLineWidth(lineWidth);
        highlightFigure.setForegroundColor(color);
        highlightFigure.setFill(false);
        highlightFigure.setFillXOR(false);
        highlightFigure.setOutline(true);
        highlightFigure.setOutlineXOR(false);
        highlightFigure.setOpaque(false);

    }

    public void execute() {

        // search a layer we can draw on
        RootEditPart rootEP = objectToHighlight.getRoot();

        if (rootEP instanceof RenderedDiagramRootEditPart) {

            IFigure layer = ((RenderedDiagramRootEditPart) rootEP)
                    .getLayer(RenderedDiagramRootEditPart.PAGE_BREAKS_LAYER);

            // get Figure to the EditPart

            IFigure selectedFigure = objectToHighlight.getFigure();

            highlightFigure.setLineWidth(lineWidth);
            highlightFigure.setForegroundColor(color);

            // get same bounds as the selected figure ...
            Rectangle bounds = selectedFigure.getBounds().getCopy();
            // ... but in absolute coordinates

            // translateToAbsolute is really bothersome, can't cope with either scrolling or zooming
            selectedFigure.translateToAbsolute(bounds);
            double zoomValue = ((RenderedDiagramRootEditPart) rootEP).getZoomManager().getZoom();
            // Add correction for Zooming-related translation error
            bounds.scale(1 / zoomValue);
            // get the top-most Viewport to determine the scroll value and apply for correction
            // this still has a zooming-related error in it, another correction is needed
            IFigure parentFigure = selectedFigure.getParent();
            while (parentFigure != null) {
                if (parentFigure instanceof Viewport) {
                    Viewport viewport = (Viewport) parentFigure;
                    bounds.translate((int) ((1 / zoomValue) * viewport.getHorizontalRangeModel()
                            .getValue()), (int) ((1 / zoomValue) * viewport.getVerticalRangeModel()
                            .getValue()));

                }

                parentFigure = parentFigure.getParent();

            }

            // set the bounds of the Figure that will do the highlighting

            highlightFigure.setBounds(bounds);
           
            // add the new highlight figure to the layer

            layer.add(highlightFigure);

            // schedule a repaint of the feedback layer
            layer.invalidate();
        }
     
    }

    /**
     * Undo the effect. Here the highlighting will be removed.
     */
    public void undo() {
        try {
            
                this.highlightFigure.getParent().remove(this.highlightFigure);
        } catch (Exception e) {
         /*invalid highlightFigure may be submitted, in that case there is nothing to remove*/
        }
    }

    /**
     * Sets the target of the effect
     * @param target the target
     */
    public void setTarget(EditPart target) {
        this.objectToHighlight = (ShapeEditPart) target;
    }

    /**
     * Changes parameters of highlight figure. Will be re-read on every execute() call.
     * 
     * @param width the width of the of the highlight figure
     * @param lineColor the color of the line of the highlight figure
     */
    public void setHighlightFigure(int width, Color lineColor) {
        this.lineWidth = width;
        this.color = lineColor;
    }

}

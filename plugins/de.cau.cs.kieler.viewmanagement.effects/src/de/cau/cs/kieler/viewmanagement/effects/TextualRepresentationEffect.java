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
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.PositionConstants;
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
 *         The textual representation effect adds a text figure to the affectedObject. The content
 *         of the text is delivered through the parameters.
 */

public class TextualRepresentationEffect extends AEffect {

    ShapeEditPart objectToText;
    Object objectParameters;
    Label textualFigure;

    /**
     * default constructor, the effect is initalized here
     */
    public TextualRepresentationEffect() {

        this.textualFigure = new Label();
        // positioning of the effect, needs improvement
        textualFigure.setTextAlignment(PositionConstants.ALWAYS_RIGHT);
        textualFigure.setText(null);
        textualFigure.setForegroundColor(ColorConstants.blue);

    }

    public void execute() {

        RootEditPart rootEP = objectToText.getRoot();
        // get layer to draw effect on
        if (rootEP instanceof RenderedDiagramRootEditPart) {
            IFigure layer = ((RenderedDiagramRootEditPart) rootEP)
                    .getLayer(RenderedDiagramRootEditPart.FEEDBACK_LAYER);
            IFigure selectedFigure = objectToText.getFigure();
            // determine coordinates to draw effect
            Rectangle bounds = selectedFigure.getBounds().getCopy();

            selectedFigure.translateToAbsolute(bounds);
            // translateToAbsolute is really bothersome, can't cope with either scrolling or zooming
            selectedFigure.translateToAbsolute(bounds);
            double zoomValue = ((RenderedDiagramRootEditPart) rootEP).getZoomManager().getZoom();
            // Add correction for Zooming-related translation error
            bounds.scale(1 / zoomValue);
            // get the top-most Viewport to determine the scroll value and apply for correction
            // this still has a zooming-related error in it, another corretion is needed
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
            // Little adjustment to not paint it over the figure. Should be done somehow better
            bounds.width = bounds.width + 25;
            // set the actual text to be displayed
            textualFigure.setText((String) objectParameters);
            textualFigure.setBounds(bounds);
            // add the effect
            layer.add(textualFigure);
            // invalidate to schedule a repaint
            layer.invalidate();
        }

    }

    /**
     * Undo the effect. Here the effect will be removed.
     */
    public void undo() {
        this.textualFigure.getParent().remove(this.textualFigure);
    }

    /**
     * Sets the target of the effect
     * 
     * @param target
     *            the target
     */
    public void setTarget(EditPart target) {
        this.objectToText = (ShapeEditPart) target;
    }

    public void setParameters(Object parameters) {
        objectParameters = parameters;

    }

}

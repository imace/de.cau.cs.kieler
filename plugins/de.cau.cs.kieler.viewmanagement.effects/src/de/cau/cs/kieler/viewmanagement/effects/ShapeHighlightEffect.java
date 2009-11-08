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
import org.eclipse.draw2d.Shape;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.swt.graphics.Color;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;

import de.cau.cs.kieler.viewmanagement.AEffect;

/**
 * @author nbe The ShapeHighLightEffect will modify the affected object itself by changing its
 *         colors.
 */
public class ShapeHighlightEffect extends AEffect {

    EditPart objectToHighlight;

    Color color = ColorConstants.red;
    Color backColor = ColorConstants.white;

    Boolean originalOpaque;
    Color originalColorForeground;
    Color originalColorBackground;

    /**
     * default constructor, nothing done here
     */
    public ShapeHighlightEffect() {

    }

    public void execute() {

        objectToHighlight.getRoot();
        IFigure figure = ((GraphicalEditPart) objectToHighlight).getFigure();
        if (figure instanceof DefaultSizeNodeFigure) {
            figure = (IFigure) figure.getChildren().get(0);
        }
        // save current values for later undo
        if (this.originalColorForeground == null)
            this.originalColorForeground = figure.getForegroundColor();
        if (this.originalColorBackground == null)
            this.originalColorBackground = figure.getBackgroundColor();
        if (this.originalOpaque == null)
            this.originalOpaque = figure.isOpaque();
        // set new colors
        figure.setForegroundColor(this.color);
        figure.setBackgroundColor(this.backColor);

        if (figure instanceof Shape) {
            ((Shape) figure).setFill(true);
        }
        figure.setOpaque(true);
        // schedule repaint to make changes visible
        figure.repaint();

    }

    /**
     * Undo the effect. Here the highlighting will be removed.
     */
    public void undo() {
        // undo the highlight colors
        objectToHighlight.getRoot();
        IFigure figure = ((GraphicalEditPart) objectToHighlight).getFigure();
        if (figure instanceof DefaultSizeNodeFigure) {
            figure = (IFigure) figure.getChildren().get(0);
        }
        // apply saved original colors
        figure.setForegroundColor(originalColorForeground);
        figure.setOpaque(this.originalOpaque);
        figure.setBackgroundColor(originalColorBackground);
        // schedule repaint to make changes visible
        figure.repaint();
        // reset backup date
        originalColorForeground = null;
        originalColorBackground = null;
    }

    /**
     * Sets the target object of the effect
     * 
     * @param target
     *            the object to be highlighted
     */
    public void setTarget(EditPart target) {
        this.objectToHighlight = target;
    }

    public void setParameters(Object objectParameters) {

    }

    /**
     * Changes parameters of highlight figure. Will be re-read on every execute() call
     * 
     * @param foregroundColor
     *            color for the foreground
     * @param backgroundColor
     *            color for the background
     * 
     */
    public void setColors(Color foregroundColor, Color backgroundColor) {
        this.color = foregroundColor;
        this.backColor = backgroundColor;
    }

}

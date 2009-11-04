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
 * @author nbe
 * 
 */
public class ShapeHighlightEffect extends AEffect {

    EditPart objectToHighlight;

    Color color = ColorConstants.red;
    Color backColor = ColorConstants.white;

    Boolean originalOpaque;
    Color originalColorForeground;
    Color originalColorBackground;
    int originalLineWidth;

    /**
     * default constructor, highlighting figure is initially defined here
     */
    public ShapeHighlightEffect() {

    }

    public void execute() {

        objectToHighlight.getRoot();
        IFigure figure = ((GraphicalEditPart) objectToHighlight).getFigure();
        if (figure instanceof DefaultSizeNodeFigure) {
            figure = (IFigure) figure.getChildren().get(0);
        }

        if (this.originalColorForeground == null)
            this.originalColorForeground = figure.getForegroundColor();
        if (this.originalColorBackground == null)
            this.originalColorBackground = figure.getBackgroundColor();
        if (this.originalOpaque == null)
            this.originalOpaque = figure.isOpaque();

        figure.setForegroundColor(this.color);
        figure.setBackgroundColor(this.backColor);

        if (figure instanceof Shape) {
            ((Shape) figure).setFill(true);
        }
        figure.setOpaque(true);

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
        figure.setForegroundColor(originalColorForeground);
        figure.setOpaque(this.originalOpaque);
        figure.setBackgroundColor(originalColorBackground);

        figure.repaint();
        // reset backup date
        originalColorForeground = null;
        originalColorBackground = null;
    }


    /**
     * @param target
     */
    public void setTarget(EditPart target) {
        this.objectToHighlight = target;
    }

    public void setParameters(Object objectParameters) {
        

    }


    /**
     * Changes parameters of highlight figure. Will be re-read on every execute() call
     * 
     * @param width
     * @param lineColor
     */
    public void setColors(Color lineColor, Color backgroundColor) {
        this.color = lineColor;
        this.backColor = backgroundColor;
    }



}

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
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeEditPart;

import de.cau.cs.kieler.viewmanagement.AEffect;

/**
 * The filter effect hides the affected object.
 * 
 * @author nbe
 * 
 */

public class FilterEffect extends AEffect {

    private IFigure undoFigure;
    private ShapeEditPart objectToFilter;

    /**
     * default constructor, nothing to be done here
     */
    public FilterEffect() {

    }

    /**
     * executes the filter effect. Will get the figure of objectToFilter and set it to invisible.
     */
    public final void execute() {
        IFigure selectedFigure = ((ShapeEditPart) objectToFilter).getFigure();

        if (selectedFigure.isVisible()) {
            undoFigure = selectedFigure;

            selectedFigure.setVisible(false);
        }

    }

    /**
     * Undo the effect.
     */
    public final void undo() {
        if ((this.undoFigure != null)) {

            this.undoFigure.setVisible(true);
        }
    }

    /**
     * Sets the target of the effect.
     * 
     * @param target
     *            the target
     */
    public final void setTarget(final EditPart target) {
        this.objectToFilter = (ShapeEditPart) target;
    }

}

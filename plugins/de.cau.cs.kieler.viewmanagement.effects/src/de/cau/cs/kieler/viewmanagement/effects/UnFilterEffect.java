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
 * @author nbe
 * 
 *         The UnFilterEffect makes objects visible again that were earlier hidden by the
 *         FilterEffect.
 */
public class UnFilterEffect extends AEffect {

    private ShapeEditPart objectToUnFilter;
    /**
     * default constructor, nothing to be done here.
     */
    public UnFilterEffect() {

    }

    /**
     * Executes the unfilter effect. Will get the figure of objectToFilter and set it to visible.
     */
    public final void execute() {
        final IFigure selectedFigure = ((ShapeEditPart) objectToUnFilter).getFigure();

        if (selectedFigure.isVisible()) {

            selectedFigure.setVisible(true);
        }

    }
    /**
     * Sets the target of the effect
     * @param target the target
     */
    public final void setTarget(final EditPart target) {
        this.objectToUnFilter = (ShapeEditPart) target;
    }

}

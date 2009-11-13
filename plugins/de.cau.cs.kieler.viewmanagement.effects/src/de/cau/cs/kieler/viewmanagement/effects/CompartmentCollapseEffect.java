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

import java.util.ArrayList;
import java.util.List;
import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.figures.ResizableCompartmentFigure;
import de.cau.cs.kieler.viewmanagement.AEffect;

/**
 * Effect that collapses all compartments that are collapsable, starting from the given object and
 * searching through all its children as well.
 * 
 * @author nbe
 * 
 */

public class CompartmentCollapseEffect extends AEffect {

    private ShapeEditPart objectToCollapse;

    /**
     * Default constructor of the collapse effect. Will take the target and determine whether it or
     * any of tis children are collapseable (of type ResizeableCompartmentFigure) and then collapse
     * them.
     */
    public CompartmentCollapseEffect() {

    }

    @Override
    public final void execute() {
        IFigure selectedFigure = objectToCollapse.getFigure();

        List<IFigure> resizableFigures = new ArrayList<IFigure>();
        // determine which of the objects is actually resizeable
        getResizeableCompartments(selectedFigure, resizableFigures);
        List<IFigure> collapsedComps = new ArrayList<IFigure>();
        // collapse the objects
        for (int i = 0; i < resizableFigures.size(); i++) {
            ResizableCompartmentFigure tempfig = (ResizableCompartmentFigure) resizableFigures
                    .get(i);
            collapsedComps.add(tempfig);
            tempfig.collapse();
        }

    }

    /**
     * Method to search recursively for resizeable compartments. Examines not only the given figure,
     * but also its children.
     * 
     * @param f
     *            the initial figure to be examined
     * @param resizableFigures
     *            list of resizeable compartments
     */
    public final void getResizeableCompartments(final IFigure f,
            final List<IFigure> resizableFigures) {

        if (f instanceof ResizableCompartmentFigure) {
            resizableFigures.add(f);

        }

        for (int i = 0; i < f.getChildren().size(); i++) {
            getResizeableCompartments((IFigure) f.getChildren().get(i), resizableFigures);
        }

        return;
    }

    /**
     * Sets the target of the effect
     * 
     * @param target
     *            the target
     */
    public final void setTarget(final EditPart target) {
        this.objectToCollapse = (ShapeEditPart) target;
    }

}

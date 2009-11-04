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
 * @author nbe
 * 
 */

public class CompartmentCollapseEffect extends AEffect {

    ShapeEditPart objectToCollapse;

    /**
     * default constructor
     */
    public CompartmentCollapseEffect() {

    }

    @Override
    public void execute() {
        IFigure selectedFigure = objectToCollapse.getFigure();

        List<IFigure> resizableFigures = new ArrayList<IFigure>();
        getResizeableCompartments(selectedFigure, resizableFigures);
        List<IFigure> collapsedComps = new ArrayList<IFigure>();
        // Here could be added some more refined method, like collapsing only some objects
        for (int i = 0; i < resizableFigures.size(); i++) {
            ResizableCompartmentFigure tempfig = (ResizableCompartmentFigure) resizableFigures
                    .get(i);
            collapsedComps.add(tempfig);
            tempfig.collapse();
        }

    }

    /**
     * @param f
     * @param resizableFigures
     */
    public void getResizeableCompartments(IFigure f, List<IFigure> resizableFigures) {

        if (f instanceof ResizableCompartmentFigure) {
            resizableFigures.add(f);

        }

        for (int i = 0; i < f.getChildren().size(); i++)
            getResizeableCompartments((IFigure) f.getChildren().get(i), resizableFigures);

        return;
    }

    /**
     * Undo the effect. Here the highlighting will be removed.
     */
    public void undo() {

    }

    /**
     * @param target
     */
    public void setTarget(EditPart target) {
        this.objectToCollapse = (ShapeEditPart) target;
    }

    @Override
    public void setParameters(Object parameters) {
        // TODO Auto-generated method stub

    }

}

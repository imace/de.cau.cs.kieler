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
package de.cau.cs.kieler.viewmanagement.combination;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeEditPart;
import org.eclipse.swt.graphics.Color;
import de.cau.cs.kieler.viewmanagement.ACombination;
import de.cau.cs.kieler.viewmanagement.ATrigger;
import de.cau.cs.kieler.viewmanagement.effects.HighlightEffect;
import de.cau.cs.kieler.viewmanagement.triggers.SelectionTrigger;
import de.cau.cs.kieler.viewmanagement.*;

/**
 * @author nbe Combination that highlights the affected object by drawing a rectangle around it.
 *         Listens to the SelectionTrigger, so the selected object in the editor will get
 *         highlighted.
 */
public class SelectionHighlightCombination extends ACombination {

    HighlightEffect effect;
    SelectionTrigger st;

    ShapeEditPart objectToHighlight;
    Object objectParameters;

    Color lineColor = ColorConstants.red;
    int linewidth = 5;

    @Override
    public List<ATrigger> getTriggers() {
        this.st = (SelectionTrigger) RunLogic.getTrigger("SelectionTrigger");
        List<ATrigger> myTriggers = new ArrayList<ATrigger>();
        myTriggers.add(st);
        return myTriggers;
    }

    /*
     * (non-Javadoc)
     * 
     * @see de.cau.cs.kieler.viewmanagement.ACombination#evaluate()
     */
    @Override
    public boolean evaluate(TriggerEventObject triggerEvent) {

        EditPart affectedObject = getEditPart(triggerEvent.getAffectedObject());
        if (affectedObject instanceof ShapeEditPart) {
            this.objectToHighlight = (ShapeEditPart) affectedObject;
            this.objectParameters = triggerEvent.getParameters();

            return true;
        } else
            return false;
    }

    /*
     * (non-Javadoc)
     * 
     * @see de.cau.cs.kieler.viewmanagement.ACombination#execute()
     */
    @Override
    public void execute() {
        if (effect == null)
            effect = new HighlightEffect();

        effect.setTarget(this.objectToHighlight);
        effect.setParameters(this.objectParameters);
        effect.setHighlightFigure(linewidth, lineColor);
        effect.execute();

    }

    public void undoLastEffect() {
        if (effect != null)
            effect.undo();

    }

    /**
     * @param newcolor
     *            Color that the HighlightEffect should be changed to
     * @param newlinewidth
     *            Linewidth that the HighlightEffect should be changed to
     */
    public void setHighlightEffect(Color newcolor, int newlinewidth) {
        lineColor = newcolor;
        linewidth = newlinewidth;
    }

}

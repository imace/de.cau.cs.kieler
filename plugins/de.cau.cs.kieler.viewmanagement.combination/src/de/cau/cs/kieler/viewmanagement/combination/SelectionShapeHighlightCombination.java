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
import org.eclipse.swt.graphics.Color;
import de.cau.cs.kieler.viewmanagement.ACombination;
import de.cau.cs.kieler.viewmanagement.ATrigger;
import de.cau.cs.kieler.viewmanagement.effects.ShapeHighlightEffect;
import de.cau.cs.kieler.viewmanagement.triggers.SelectionTrigger;
import de.cau.cs.kieler.viewmanagement.*;

/**
 * @author nbe
 * 
 *         Combination that highlights the affected object by drawing its shape in lineColor (by
 *         default red). Listens to SelectionTrigger so the object selected in the editor will get
 *         highlighted.
 */
public class SelectionShapeHighlightCombination extends ACombination {

    private ShapeHighlightEffect effect;
    private SelectionTrigger st;

    private EditPart objectToHighlight;
    private Object objectParameters;
    private boolean triggerActive;
    private Color lineColor = ColorConstants.red;

    @Override
    public final List<ATrigger> getTriggers() {
        this.st = (SelectionTrigger) RunLogic.getInstance().getTrigger("SelectionTrigger");
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
    public final boolean evaluate(final TriggerEventObject triggerEvent) {
        // parent may be set if wanted. Will else be RootEP

        EditPart affectedObject = getEditPart(triggerEvent.getAffectedObject());

        this.objectToHighlight = affectedObject;
        this.objectParameters = triggerEvent.getParameters();
        this.triggerActive = triggerEvent.getTriggerState();

        return true;
    }

    /*
     * (non-Javadoc)
     * 
     * @see de.cau.cs.kieler.viewmanagement.ACombination#execute()
     */
    @Override
    public final void execute() {
        if (this.triggerActive == false) {
            effect.undo();
        } else {
            if (effect == null) {
                effect = new ShapeHighlightEffect();
            }

            effect.setTarget(this.objectToHighlight);
            effect.setParameters(this.objectParameters);
            effect.execute();
            effect.setColors(lineColor, null);
        }

    }

    @Override
    public final void undoEffects() {
        if (effect != null) {

            effect.undo();
        }
    }

}

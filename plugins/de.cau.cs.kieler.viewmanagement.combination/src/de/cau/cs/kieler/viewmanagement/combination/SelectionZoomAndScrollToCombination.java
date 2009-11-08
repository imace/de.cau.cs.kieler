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
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeEditPart;
import de.cau.cs.kieler.viewmanagement.ACombination;
import de.cau.cs.kieler.viewmanagement.ATrigger;
import de.cau.cs.kieler.viewmanagement.effects.ZoomAndScrollToEffect;
import de.cau.cs.kieler.viewmanagement.triggers.SelectionTrigger;
import de.cau.cs.kieler.viewmanagement.*;

/**
 * @author nbe
 * 
 *         Combination that performs a focus on the affected object by scrolling to its location and
 *         zooming in on it. Listens to SelectionTrigger so objects selected in the editor will be
 *         focused.
 */
public class SelectionZoomAndScrollToCombination extends ACombination {

    private ZoomAndScrollToEffect effect;
    private SelectionTrigger st;

    private ShapeEditPart objectToHighlight;
    private Object objectParameters;

    @Override
    public final List<ATrigger> getTriggers() {
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
    public final boolean evaluate(final TriggerEventObject triggerEvent) {
        // parent may be set if wanted. Will else be RootEP
        if (triggerEvent.getTriggerState()) {
            EditPart affectedObject = getEditPart(triggerEvent.getAffectedObject());
            if (affectedObject instanceof ShapeEditPart) {
                this.objectToHighlight = (ShapeEditPart) affectedObject;
                this.objectParameters = triggerEvent.getParameters();

                return true;} else {
                return false;
            }
        } else {
            return false;
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see de.cau.cs.kieler.viewmanagement.ACombination#execute()
     */
    @Override
    public final void execute() {
        if (effect == null) {
            effect = new ZoomAndScrollToEffect();
        }

        effect.setTarget(this.objectToHighlight);
        effect.setParameters(this.objectParameters);
        effect.execute();

    }

}

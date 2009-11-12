/*
 * KIELER - Kiel Integrated Environment for Layout for the Eclipse RCP
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
 */
package de.cau.cs.kieler.viewmanagement.combination;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeEditPart;

import de.cau.cs.kieler.viewmanagement.ACombination;
import de.cau.cs.kieler.viewmanagement.ATrigger;
import de.cau.cs.kieler.viewmanagement.RunLogic;
import de.cau.cs.kieler.viewmanagement.TriggerEventObject;
import de.cau.cs.kieler.viewmanagement.effects.UnFilterEffect;
import de.cau.cs.kieler.viewmanagement.triggers.SelectionTrigger;

/**
 * @author nbe
 * 
 *         Combination that unhides object that were previously hidden, e.g. by the
 *         SelectionFilterCombination. Listens to SelectionTrigger, so objects selected in the
 *         editor will become visible again.
 */
public class SelectionUnFilterCombination extends ACombination {

    private UnFilterEffect effect;
    private SelectionTrigger st;
    private ShapeEditPart affectedObject;
    private Object objectParameters;

    @Override
    public final boolean evaluate(final TriggerEventObject triggerEvent) {
        final EditPart affectedObject = getEditPart(triggerEvent.getAffectedObject());
        if (affectedObject instanceof ShapeEditPart) {
            this.affectedObject = (ShapeEditPart) affectedObject;
            this.objectParameters = triggerEvent.getParameters();

            return true;
        } else {
            return false;
        }

    }

    @Override
    public final void execute() {
        if (effect == null) {
            effect = new UnFilterEffect();
        }

        effect.setTarget(this.affectedObject);
        effect.setParameters(this.objectParameters);
        effect.execute();

    }

    @Override
    public final List<ATrigger> getTriggers() {
        this.st = (SelectionTrigger) RunLogic.getInstance().getTrigger("SelectionTrigger");
        final List<ATrigger> myTriggers = new ArrayList<ATrigger>();
        myTriggers.add(st);
        return myTriggers;

    }

}

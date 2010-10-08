/*
 * KIELER - Kiel Integrated Environment for Layout Eclipse RichClient
 *
 * http://www.informatik.uni-kiel.de/rtsys/kieler/
 * 
 * Copyright 2010 by
 * + Christian-Albrechts-University of Kiel
 *   + Department of Computer Science
 *     + Real-Time and Embedded Systems Group
 * 
 * This code is provided under the terms of the Eclipse Public License (EPL).
 * See the file epl-v10.html for the license text.
 */
package de.cau.cs.kieler.synccharts.kivi;

import de.cau.cs.kieler.core.kivi.AbstractCombination;
import de.cau.cs.kieler.kiml.ui.layout.LayoutEffect;
import de.cau.cs.kieler.synccharts.kivi.LabelChangedTrigger.LabelChangedState;

/**
 * foo.
 * @author mmu
 *
 */
public class LayoutAfterLabelChangedCombination extends AbstractCombination {

    /**
     * foo.
     * 
     * @param state state
     */
    public void execute(final LabelChangedState state) {
        dontUndo();
        schedule(new LayoutEffect(state.getDiagramEditor(), state.getEObject()));
    }
}

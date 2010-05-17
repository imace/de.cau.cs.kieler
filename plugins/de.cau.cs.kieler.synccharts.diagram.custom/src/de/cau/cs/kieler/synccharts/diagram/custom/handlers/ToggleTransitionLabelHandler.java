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
 */
package de.cau.cs.kieler.synccharts.diagram.custom.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.Command;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.handlers.HandlerUtil;

import de.cau.cs.kieler.synccharts.diagram.custom.triggerlisteners.RedundantLabelTriggerListener;

/**
 * Handler for toggling between hiding all labels and only handling the
 * redundant ones.
 * 
 * @author soh
 */
public class ToggleTransitionLabelHandler extends AbstractHandler {

    /**
     * {@inheritDoc}
     */
    public Object execute(final ExecutionEvent event) throws ExecutionException {
        Command command = event.getCommand();
        boolean oldValue = HandlerUtil.toggleCommandState(command);

        if (oldValue) {
            RedundantLabelTriggerListener.hideRedundant();
        } else {
            RedundantLabelTriggerListener.hideAll();
        }
        RedundantLabelTriggerListener.hideRedundantLabels();
        return null;
    }

}

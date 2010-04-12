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
package de.cau.cs.kieler.sim.kiem.automated.ui.ui;

import org.eclipse.jface.action.IAction;

import de.cau.cs.kieler.sim.kiem.automated.execution.CancelManager;
import de.cau.cs.kieler.sim.kiem.automated.execution.CancelManager.CancelStatus;

/**
 * Stop the currently running automated execution run.
 * 
 * @author soh
 * @kieler.rating 2010-02-08 proposed yellow
 */
public class SkipExecutionAction extends SkipAction {

    /**
     * {@inheritDoc}
     */
    public void run(final IAction action) {
        CancelManager.getInstance().cancelExecution(CancelStatus.USER_CANCELED);
    }

}

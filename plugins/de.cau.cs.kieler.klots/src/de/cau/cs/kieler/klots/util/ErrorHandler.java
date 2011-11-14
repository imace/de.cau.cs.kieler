/*
 * KIELER - Kiel Integrated Environment for Layout Eclipse Rich Client
 *
 * http://www.informatik.uni-kiel.de/rtsys/kieler/
 * 
 * Copyright 2011 by
 * + Christian-Albrechts-University of Kiel
 *   + Department of Computer Science
 *     + Real-Time and Embedded Systems Group
 * 
 * This code is provided under the terms of the Eclipse Public License (EPL).
 * See the file epl-v10.html for the license text.
 */
package de.cau.cs.kieler.klots.util;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.swt.widgets.Display;

/**
 * @author ybe
 * 
 */
public class ErrorHandler {

	private String info;

	/**
	 * @param info 
	 */
	public ErrorHandler(final String info) {
		this.info = info;
	}

	/**
     * 
     */
	public void showResults() {
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				getCompletedAction().run();
			}
		});
	}

	private Action getCompletedAction() {
		return new Action() {
			public void run() {
				ErrorDialog.openError(null, "KLOTS", info, null);
			}
		};
	}
}

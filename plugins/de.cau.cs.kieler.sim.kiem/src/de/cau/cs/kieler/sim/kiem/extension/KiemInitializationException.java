/******************************************************************************
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
 ******************************************************************************/

package de.cau.cs.kieler.sim.kiem.extension;

/**
 * @author cmot
 *
 */
public class KiemInitializationException extends Exception {

	private static final long serialVersionUID = -8183839879570123277L;

	private boolean mustStop;
	
	public KiemInitializationException(String message, boolean mustStop) {
		super(message);
		this.mustStop = mustStop;
	}

	public boolean isMustStop() {
		return this.mustStop;
	}

}

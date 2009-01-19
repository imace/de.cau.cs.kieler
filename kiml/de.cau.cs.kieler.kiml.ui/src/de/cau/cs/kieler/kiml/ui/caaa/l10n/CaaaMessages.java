/*******************************************************************************
 * Copyright (c) 2008 Real-Time and Embedded Systems group
 *
 * INSERT LICENCE HERE
 *
 *
 * Author: Christoph Wulf, cwu@informatik.uni-kiel.de
 *         Johannes Hedtrich, jhed@informatik.uni-kiel.de
 *
 *******************************************************************************/
package de.cau.cs.kieler.kiml.ui.caaa.l10n;

import org.eclipse.osgi.util.NLS;

/**
 * An accessor class for externalized strings.
 * 
 * @author <a href="mailto:cwu@informatik.uni-kiel.de">Christoph Wulf</a>
 * @author <a href="mailto:jhed@informatik.uni-kiel.de">Johannes Hedtrich</a> 
 */
public final class CaaaMessages extends NLS {

	private static final String BUNDLE_NAME = "de.cau.cs.kieler.kiml.ui.caaa.l10n.CaaaMessages";//$NON-NLS-1$

	private CaaaMessages() {
		// Do not instantiate
	}

	public static String AutoArrangeAll_textLabel;
	public static String AutoArrangeAll_toolTip;

	static {
		NLS.initializeMessages(BUNDLE_NAME, CaaaMessages.class);
	}
}
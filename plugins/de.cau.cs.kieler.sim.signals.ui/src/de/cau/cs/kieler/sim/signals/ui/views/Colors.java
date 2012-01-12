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

package de.cau.cs.kieler.sim.signals.ui.views;

import java.util.HashMap;

import org.eclipse.swt.graphics.RGB;

/**
 * The Colors can be used to customize the colors for the SignalsPlotter.
 * 
 * @author Christian Motika - cmot AT informatik.uni-kiel.de
 */
public class Colors {
	
	/** The color constants. */
	private RGB backgroundColor = new RGB(0, 0, 0); // black
	private RGB signalColor1 = new RGB(100, 100, 255); // light blue
	private RGB signalColor2 = new RGB(200, 200, 255); // lighter blue
	private RGB signalColor0 = new RGB(0, 0, 50); // dark blue
	private RGB signalColorMarker = new RGB(255, 0, 0); // red

	/** The variable signal color hashmap. */
	private HashMap<String, RGB> signalColor = new HashMap<String, RGB>();

	// -------------------------------------------------------------------------
	
	/**
	 * Gets the background color.
	 * 
	 * @return the background color
	 */
	public RGB getBackgroundColor() {
		return backgroundColor;
	}

	// -------------------------------------------------------------------------

	/**
	 * Sets the background color.
	 * 
	 * @param backgroundColor
	 *            the new background color
	 */
	public void setBackgroundColor(RGB backgroundColor) {
		this.backgroundColor = backgroundColor;
	}

	// -------------------------------------------------------------------------

	/**
	 * Gets the signal color1. Signals are displayed alternately in two colors
	 * color1 and color2.
	 * 
	 * @return the signal color1
	 */
	public RGB getSignalColor1() {
		return signalColor1;
	}

	// -------------------------------------------------------------------------

	/**
	 * Sets the signal color1. Signals are displayed alternately in two colors
	 * color1 and color2.
	 * 
	 * @param signalColor1
	 *            the new signal color1
	 */
	public void setSignalColor1(RGB signalColor1) {
		this.signalColor1 = signalColor1;
	}

	// -------------------------------------------------------------------------

	/**
	 * Gets the signal color2.
	 * 
	 * @return the signalColor2. Signals are displayed alternately in two colors
	 *         color1 and color2.
	 */
	public RGB getSignalColor2() {
		return signalColor2;
	}

	// -------------------------------------------------------------------------

	/**
	 * Sets the signal color2. Signals are displayed alternately in two colors
	 * color1 and color2.
	 * 
	 * @param signalColor2
	 *            the new signal color2
	 */
	public void setSignalColor2(RGB signalColor2) {
		this.signalColor2 = signalColor2;
	}

	// -------------------------------------------------------------------------

	/**
	 * Gets the signal spare color that is used for absent signals.
	 * 
	 * @return the signal spare color
	 */
	public RGB getSignalSpareColor() {
		return signalColor0;
	}

	// -------------------------------------------------------------------------

	/**
	 * Sets the signal spare color that is used for absent signals.
	 * 
	 * @param signalSpareColor
	 *            the new signal spare color
	 */
	public void setSignalSpareColor(RGB signalSpareColor) {
		this.signalColor0 = signalSpareColor;
	}

	// -------------------------------------------------------------------------

	/**
	 * Gets the signal color marker that is used to mark the currently active
	 * signal.
	 * 
	 * @return the signalColorMarker
	 */
	public RGB getSignalColorMarker() {
		return signalColorMarker;
	}

	// -------------------------------------------------------------------------

	/**
	 * Sets the signal color marker that is used to mark the currently active
	 * signal.
	 * 
	 * @param signalColorMarker
	 *            the signalColorMarker to set
	 */
	public void setSignalColorMarker(RGB signalColorMarker) {
		this.signalColorMarker = signalColorMarker;
	}

	// -------------------------------------------------------------------------

	/**
	 * Gets the signal color HashMap with individual signal colors.
	 *
	 * @return the signalColor
	 */
	public HashMap<String, RGB> getSignalColor() {
		return signalColor;
	}

	// -------------------------------------------------------------------------

	/**
	 * Sets the signal color HashMap with individual signal colors.
	 *
	 * @param signalColor the signalColor to set
	 */
	public void setSignalColor(HashMap<String, RGB> signalColor) {
		this.signalColor = signalColor;
	}

	// -------------------------------------------------------------------------

	/**
	 * Sets a specific individual color for a signal identified by its name.
	 *
	 * @param signalColor the signalColor to set
	 */
	public void setSignalColor(String signalName, RGB signalColor) {
		this.signalColor.put(signalName, signalColor);
	}

	// -------------------------------------------------------------------------
	
}

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
 */
package de.cau.cs.kieler.kiml.ui.provider;

/**
 * This is the interface implemented to provide various labels related to the
 * use in KIELER and KIML.
 * 
 * @author <a href="mailto:ars@informatik.uni-kiel.de">Arne Schipper</a>
 */
public interface IKimlLabelProvider {

	/**
	 * 
	 * @param object The object to obtain the long label for
	 * @return A longer label describing the provided object
	 */
	public String getKimlLongLabel(Object object);

	/**
	 * @param object The object to obtain the short label for
	 * @return A shorter label describing the provided object
	 */
	public String getKimlShortLabel(Object object);

	/**
	 * @param object The object to obtain the head label for
	 * @return A head label for the provided object
	 */
	public String getKimlHeadLabel(Object object);

	/**
	 * @param object The object to obtain the center label for
	 * @return A center label for the provided object
	 */
	public String getKimlCenterLabel(Object object);

	/**
	 * @param object The object to obtain the tail label for
	 * @return A tail label for the provided object
	 */
	public String getKimlTailLabel(Object object);

}

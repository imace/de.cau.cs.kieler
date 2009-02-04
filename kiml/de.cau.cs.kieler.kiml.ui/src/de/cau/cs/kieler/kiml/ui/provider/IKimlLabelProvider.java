/*******************************************************************************
 * Copyright (c) 2009 Real-Time and Embedded Systems group
 *
 * INSERT LICENCE HERE
 *
 *
 * Author: Arne Schipper, ars@informatik.uni-kiel.de 
 *
 *******************************************************************************/
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

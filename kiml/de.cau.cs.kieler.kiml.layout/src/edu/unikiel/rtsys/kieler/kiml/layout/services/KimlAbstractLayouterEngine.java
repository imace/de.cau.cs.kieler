/*******************************************************************************
 * Copyright (c) 2008 Real-Time and Embedded Systems group
 *
 * INSERT LICENCE HERE
 *
 *
 * Author: Arne Schipper, ars@informatik.uni-kiel.de 
 *
 *******************************************************************************/
package edu.unikiel.rtsys.kieler.kiml.layout.services;

import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KLayoutGraph;

/**
 * Abstract class every concrete layouter engine has to extend. Pushes the
 * KLayoutGraph with hierarchy to the concrete LayoutProviders which can or
 * cannot handle hierarchy. One implementation is
 * {@link KimlRecursiveGroupLayouterEngine}.
 * <p/>
 * 
 * @author <a href="mailto:ars@informatik.uni-kiel.de">Arne Schipper</a>
 * @see KimlRecursiveGroupLayouterEngine
 */
public abstract class KimlAbstractLayouterEngine {

	/* caches the call to the LayoutProviders for the implementing classes */
	protected LayoutProviders layoutProviderHolder = LayoutProviders
			.getInstance();

	/**
	 * Lays out a KLayoutGraph with hierarchy, that is attaches layout
	 * information to the description of the KLayoutGraph.
	 * 
	 * @param layoutGraph
	 *            A KLayoutGraph with hierarchy which is laid out by this method
	 */
	public abstract void layout(KLayoutGraph layoutGraph);

}
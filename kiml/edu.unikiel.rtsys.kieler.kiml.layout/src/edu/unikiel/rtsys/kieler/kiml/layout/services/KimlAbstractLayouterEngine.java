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

public abstract class KimlAbstractLayouterEngine {

	protected LayoutProviders layoutProviderHolder = LayoutProviders.getInstance();

	public abstract void layout(KLayoutGraph layoutGraph);

}
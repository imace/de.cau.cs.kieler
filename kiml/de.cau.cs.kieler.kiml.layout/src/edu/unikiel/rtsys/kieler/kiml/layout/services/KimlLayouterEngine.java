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
 * One possible implementation of {@link KimlAbstractLayouterEngine} to transfer
 * the KLayoutGraph to a layout provider. This engine calls the layout provider
 * just once with the top node group. Most layout providers will just be able to
 * cope with a hierarchy level of 1, so actually this implementation has not
 * much sense.
 * <p/>
 * It is here just to demonstrate how a layouter engine could be implemented in
 * the simplest way, and for cases where the layout provider can handle
 * hierarchy. Note that not the entire KLayoutGraph is passed to the layout
 * provider, but just the top KNodeGroup (and hence all the sub KNodeGroups).
 * <p/>
 * An implementation making more sense is shown in
 * {@link KimlRecursiveGroupLayouterEngine}.
 * 
 * @author <a href="mailto:ars@informatik.uni-kiel.de">Arne Schipper</a>
 * @see LayoutProviders
 * @see KimlAbstractLayouterEngine
 * @see KimlRecursiveGroupLayouterEngine
 */
public class KimlLayouterEngine extends KimlAbstractLayouterEngine {

	/* (non-Javadoc)
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.services.KimlAbstractLayouterEngine#layout(edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KLayoutGraph)
	 */
	public void layout(KLayoutGraph layoutGraph) {
		layoutProviderHolder.getLayoutProvider(layoutGraph.getTopGroup())
				.doLayout(layoutGraph.getTopGroup());
	}
}

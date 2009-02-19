/*******************************************************************************
 * Copyright (c) 2008 Real-Time and Embedded Systems group
 *
 * INSERT LICENCE HERE
 *
 *
 * Author: Arne Schipper, ars@informatik.uni-kiel.de 
 *
 *******************************************************************************/
package de.cau.cs.kieler.kiml.layout.services;

import de.cau.cs.kieler.core.KielerException;
import de.cau.cs.kieler.core.alg.IKielerProgressMonitor;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutGraph;

/**
 * One possible implementation of {@link KimlAbstractLayouterEngine} to transfer
 * the KLayoutGraph to a layout provider. This engine calls the layout provider
 * just once with the top layout node. Most layout providers will just be able to
 * cope with a hierarchy level of 1, so actually this implementation has not
 * much sense.
 * <p/>
 * It is here just to demonstrate how a layouter engine could be implemented in
 * the simplest way, and for cases where the layout provider can handle
 * hierarchy. Note that not the entire KLayoutGraph is passed to the layout
 * provider, but just the top KLayoutNode (and hence all the sub KLayoutNodes).
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

	/** the last used layout provider */
	private KimlAbstractLayoutProvider lastLayoutProvider;
	
	/*
	 * (non-Javadoc)
	 * @see de.cau.cs.kieler.kiml.layout.services.KimlAbstractLayouterEngine#layout(de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutGraph, de.cau.cs.kieler.core.alg.IKielerProgressMonitor)
	 */
	public void layout(KLayoutGraph layoutGraph,
			IKielerProgressMonitor progressMonitor) throws KielerException {
		lastLayoutProvider = layoutServices.getLayoutProvider(layoutGraph);
		lastLayoutProvider.doLayout(layoutGraph, progressMonitor);
	}

	/*
	 * (non-Javadoc)
	 * @see de.cau.cs.kieler.kiml.layout.services.KimlAbstractLayouterEngine#getLastLayoutProvider()
	 */
	public KimlAbstractLayoutProvider getLastLayoutProvider() {
		return lastLayoutProvider;
	}
	
}

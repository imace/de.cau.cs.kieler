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

import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutGraph;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutNode;

/**
 * One possible implementation to cope with hierarchy in a KLayoutGraph, though
 * all LayoutProviders (for example GraphViz, Zest) can not handle hierarchy
 * properly.
 * <p/>
 * For every level in the hierarchy of the KLayoutNodes, a separate call to a
 * LayoutProvider is performed. This is done recursively from the leafs to the
 * root of the KLayoutNodes in the KLayoutGraph, using the size information from
 * a lower level in the level above to generate a smooth hierarchically layout.
 * 
 * @author <a href="mailto:ars@informatik.uni-kiel.de">Arne Schipper</a>
 * @see LayoutProviders
 */
public class KimlRecursiveGroupLayouterEngine extends
		KimlAbstractLayouterEngine {

	/** the last used layout provider */
	private KimlAbstractLayoutProvider lastLayoutProvider;
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.cau.cs.kieler.kiml.layout.services.KimlAbstractLayouterEngine
	 * #layout
	 * (de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutGraph)
	 */
	public void layout(KLayoutGraph layoutGraph) {
		lastLayoutProvider = null;
		if (layoutGraph != null)
			layoutRecursively(layoutGraph);
	}

	/**
	 * Recursive function to enable hierarchically layout. The leafs are laid
	 * out first to use the size information gained in the level above.
	 * 
	 * @param layoutNode
	 *            The KLayoutNode with sub KLayoutNodes to be laid out.
	 */
	private void layoutRecursively(KLayoutNode layoutNode) {
		for (KLayoutNode childNodes : layoutNode.getChildNodes()) {
			layoutRecursively(childNodes);
		}

		if (layoutNode.getChildNodes().size() > 0) {
			lastLayoutProvider = layoutProviderHolder.getLayoutProvider(layoutNode);
			lastLayoutProvider.doLayout(layoutNode);
		}
	}

	/*
	 * (non-Javadoc)
	 * @see de.cau.cs.kieler.kiml.layout.services.KimlAbstractLayouterEngine#getLastLayoutProvider()
	 */
	public KimlAbstractLayoutProvider getLastLayoutProvider() {
		return lastLayoutProvider;
	}

}

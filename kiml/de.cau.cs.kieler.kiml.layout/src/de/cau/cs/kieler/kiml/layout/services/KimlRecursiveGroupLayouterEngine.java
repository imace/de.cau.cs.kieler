/******************************************************************************
 * KIELER - Kiel Integrated Environment for Layout for the Eclipse RCP
 *
 * http://www.informatik.uni-kiel.de/rtsys/kieler/
 * 
 * Copyright 2008 by
 * + Christian-Albrechts-University of Kiel
 *   + Department of Computer Science
 *     + Real-Time and Embedded Systems Group
 * 
 * This code is provided under the terms of the Eclipse Public License (EPL).
 * See the file epl-v10.html for the license text.
 */
package de.cau.cs.kieler.kiml.layout.services;

import de.cau.cs.kieler.core.KielerException;
import de.cau.cs.kieler.core.alg.IKielerProgressMonitor;
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
	 * @see de.cau.cs.kieler.kiml.layout.services.KimlAbstractLayouterEngine#layout(de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutGraph, de.cau.cs.kieler.core.alg.IKielerProgressMonitor)
	 */
	public void layout(KLayoutGraph layoutGraph,
			IKielerProgressMonitor progressMonitor) throws KielerException {
		lastLayoutProvider = null;
		int nodeCount = countNodes(layoutGraph);
		progressMonitor.begin("Recursive graph layout", nodeCount);
		if (layoutGraph != null)
			layoutRecursively(layoutGraph, progressMonitor);
		progressMonitor.done();
	}

	/**
	 * Recursive function to enable hierarchically layout. The leafs are laid
	 * out first to use the size information gained in the level above.
	 * 
	 * @param layoutNode the KLayoutNode with sub KLayoutNodes to be laid out
	 * @param progressMonitor monitor used to keep track of progress
	 * @throws KielerException if one of the layout providers fails
	 */
	private void layoutRecursively(KLayoutNode layoutNode,
			IKielerProgressMonitor progressMonitor) throws KielerException {
		for (KLayoutNode childNodes : layoutNode.getChildNodes()) {
			layoutRecursively(childNodes, progressMonitor);
		}

		if (!layoutNode.getChildNodes().isEmpty()) {
			lastLayoutProvider = layoutServices.getLayoutProvider(layoutNode);
			lastLayoutProvider.doLayout(layoutNode,
					progressMonitor.subTask(layoutNode.getChildNodes().size()));
		}
	}
	
	/**
	 * Determines the total number of layout nodes in the given layout
	 * graph.
	 * 
	 * @param layoutNode parent layout node to examine
	 * @return total number of child layout nodes
	 */
	private int countNodes(KLayoutNode layoutNode) {
		int count = layoutNode.getChildNodes().size();
		for (KLayoutNode childNode : layoutNode.getChildNodes()) {
			if (!childNode.getChildNodes().isEmpty())
				count += countNodes(childNode);
		}
		return count;
	}

	/*
	 * (non-Javadoc)
	 * @see de.cau.cs.kieler.kiml.layout.services.KimlAbstractLayouterEngine#getLastLayoutProvider()
	 */
	public KimlAbstractLayoutProvider getLastLayoutProvider() {
		return lastLayoutProvider;
	}

}

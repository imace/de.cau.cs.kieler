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
import de.cau.cs.kieler.core.kgraph.KNode;

/**
 * One possible implementation to cope with hierarchy in a KLayoutGraph, though
 * all LayoutProviders (for example GraphViz, Zest) can not handle hierarchy
 * properly.
 * <p/>
 * For every level in the hierarchy of the KNodes, a separate call to a
 * LayoutProvider is performed. This is done recursively from the leafs to the
 * root of the KNodes in the KLayoutGraph, using the size information from
 * a lower level in the level above to generate a smooth hierarchically layout.
 * 
 * @author <a href="mailto:ars@informatik.uni-kiel.de">Arne Schipper</a>
 * @see LayoutProviders
 */
public class RecursiveGroupLayouterEngine extends
		AbstractLayouterEngine {

	/** the last used layout provider */
	private AbstractLayoutProvider lastLayoutProvider;
	
	/*
	 * (non-Javadoc)
	 * @see de.cau.cs.kieler.kiml.layout.services.AbstractLayouterEngine#layout(de.cau.cs.kieler.core.kgraph.KNode, de.cau.cs.kieler.core.alg.IKielerProgressMonitor)
	 */
	public void layout(KNode layoutGraph,
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
	 * @param layoutNode the node with children to be laid out
	 * @param progressMonitor monitor used to keep track of progress
	 * @throws KielerException if one of the layout providers fails
	 */
	private void layoutRecursively(KNode layoutNode,
			IKielerProgressMonitor progressMonitor) throws KielerException {
		for (KNode child : layoutNode.getChildren()) {
			layoutRecursively(child, progressMonitor);
		}

		if (!layoutNode.getChildren().isEmpty()) {
			lastLayoutProvider = layoutServices.getLayoutProvider(layoutNode);
			lastLayoutProvider.doLayout(layoutNode,
					progressMonitor.subTask(layoutNode.getChildren().size()));
		}
	}
	
	/**
	 * Determines the total number of layout nodes in the given layout
	 * graph.
	 * 
	 * @param layoutNode parent layout node to examine
	 * @return total number of child layout nodes
	 */
	private int countNodes(KNode layoutNode) {
		int count = layoutNode.getChildren().size();
		for (KNode childNode : layoutNode.getChildren()) {
			if (!childNode.getChildren().isEmpty())
				count += countNodes(childNode);
		}
		return count;
	}

	/*
	 * (non-Javadoc)
	 * @see de.cau.cs.kieler.kiml.layout.services.AbstractLayouterEngine#getLastLayoutProvider()
	 */
	public AbstractLayoutProvider getLastLayoutProvider() {
		return lastLayoutProvider;
	}

}

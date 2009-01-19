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
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KNodeGroup;

/**
 * One possible implementation to cope with hierarchy in a KLayoutGraph, though
 * all LayoutProviders (for example GraphViz, Zest) can not handle hierarchy
 * properly.
 * <p/>
 * For every level in the hierarchy of the KNodeGroups, a separate call to a
 * LayoutProvider is performed. This is done recursively from the leafs to the
 * root of the KNodeGroups in the KLayoutGraph, using the size information from
 * a lower level in the level above to generate a smooth hierarchically layout.
 * 
 * @author <a href="mailto:ars@informatik.uni-kiel.de">Arne Schipper</a>
 * @see LayoutProviders
 */
public class KimlRecursiveGroupLayouterEngine extends
		KimlAbstractLayouterEngine {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.cau.cs.kieler.kiml.layout.services.KimlAbstractLayouterEngine
	 * #layout
	 * (de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutGraph)
	 */
	public void layout(KLayoutGraph layoutGraph) {
		if (layoutGraph.getTopGroup() != null)
			layoutRecursively(layoutGraph.getTopGroup());
	}

	/**
	 * Recursive function to enable hierarchically layout. The leafs are laid
	 * out first to use the size information gained in the level above.
	 * 
	 * @param nodeGroup
	 *            The KNodeGroup with sub KNodeGroups to be laid out.
	 */
	private void layoutRecursively(KNodeGroup nodeGroup) {
		for (KNodeGroup subGroups : nodeGroup.getSubNodeGroups()) {
			layoutRecursively(subGroups);
		}

		if (nodeGroup.getSubNodeGroups().size() > 0) {
			layoutProviderHolder.getLayoutProvider(nodeGroup).doLayout(
					nodeGroup);
		}
	}

}

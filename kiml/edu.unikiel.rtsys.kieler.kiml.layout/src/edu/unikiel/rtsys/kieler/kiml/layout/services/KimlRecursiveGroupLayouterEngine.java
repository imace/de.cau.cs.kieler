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
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KNodeGroup;

/**
 * @author ars
 * 
 */
public class KimlRecursiveGroupLayouterEngine extends
		KimlAbstractLayouterEngine {

	public void layout(KLayoutGraph layoutGraph) {
		if (layoutGraph.getTopGroup() != null)
			layoutRecursively(layoutGraph.getTopGroup());
	}

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

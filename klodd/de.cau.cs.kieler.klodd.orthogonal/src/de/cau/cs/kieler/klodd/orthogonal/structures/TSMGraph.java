package de.cau.cs.kieler.klodd.orthogonal.structures;

import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KInsets;
import de.cau.cs.kieler.core.graph.*;


/**
 * The graph structure used internally for the topology-shape-metrics
 * approach.
 * 
 * @author msp
 */
public class TSMGraph extends KGraph {

	/**
	 * Applies all layout information to the contained layout graph objects.
	 */
	public void applyLayout(float offsetX, float offsetY, KInsets insets) {
		float totalXoff = offsetX + insets.getLeft();
		float totalYoff = offsetY + insets.getTop();
		
		// apply node layout
		for (KNode node : nodes)
			((TSMNode)node).applyLayout(totalXoff, totalYoff);
		
		// apply edge layout
		for (KEdge edge : edges)
			edge.rank = 0;
		for (KEdge edge : edges) {
			if (edge.rank == 0)
				((TSMEdge)edge).applyLayout(totalXoff, totalYoff);
		}
	}
	
}

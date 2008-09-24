package edu.unikiel.rtsys.kieler.kiml.layout.services;

import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KLayoutGraph;

/**
 * @author ars
 * 
 */
public class KimlLayouterEngine extends KimlAbstractLayouterEngine {

	/**
	 * 
	 */
	public void layout(KLayoutGraph layoutGraph) {
		layoutProviderHolder.getLayoutProvider(layoutGraph.getTopGroup())
				.doLayout(layoutGraph.getTopGroup());
	}
}

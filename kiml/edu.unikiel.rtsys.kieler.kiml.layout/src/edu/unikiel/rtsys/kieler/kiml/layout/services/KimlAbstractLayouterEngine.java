package edu.unikiel.rtsys.kieler.kiml.layout.services;

import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KLayoutGraph;

public abstract class KimlAbstractLayouterEngine {

	protected LayoutProviders layoutProviderHolder = LayoutProviders.getInstance();

	public abstract void layout(KLayoutGraph layoutGraph);

}
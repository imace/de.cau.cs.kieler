/*******************************************************************************
 * Copyright (c) 2008 Real-Time and Embedded Systems group
 *
 * INSERT LICENCE HERE
 *
 *
 * Author: Arne Schipper, ars@informatik.uni-kiel.de 
 *
 *******************************************************************************/
package kiel.layouter.graphviz;

import de.cau.cs.kieler.core.KielerException;
import de.cau.cs.kieler.core.alg.IKielerProgressMonitor;
import de.cau.cs.kieler.core.kgraph.KNode;
import de.cau.cs.kieler.kiml.layout.options.LayoutType;
import de.cau.cs.kieler.kiml.layout.services.AbstractLayoutProvider;

/**
 * Implements the Circo layouter of the GraphViz suite. As this class extends
 * the {@link AbstractLayoutProvider}, the most relevant method is
 * <code>doLayout</code>, which performs the actual layout, that is annotating
 * the provided KLayoutNode with the Circo layout information.
 * <p/>
 * This class acts as a wrapper to the {@link GraphvizLayouterLibrary}. Is uses the
 * {@link GraphvizLayouterLibrary} with the Circo engine and publishes the Circo
 * specific capabilities trough <code>getLayouterInfo</code>.
 * 
 * @author <a href="mailto:ars@informatik.uni-kiel.de">Arne Schipper</a>
 */
public class CircoLayoutProvider extends AbstractLayoutProvider {

	/* some Strings used here */
	private final String LAYOUT_PROVIDER_NAME = GraphvizLayoutProviderNames.GRAPHVIZ_CIRCO;
	private final LayoutType LAYOUT_PROVIDER_LAYOUT_TYPE = LayoutType.CIRCLE;

	/* real GraphViz layouter Emma uses to do the layout */
	private GraphvizLayouter graphvizLayouter = null;

	/*
	 * (non-Javadoc)
	 * @see de.cau.cs.kieler.kiml.layout.services.AbstractLayoutProvider#doLayout(de.cau.cs.kieler.core.kgraph.KNode, de.cau.cs.kieler.core.alg.IKielerProgressMonitor)
	 */
	public void doLayout(KNode layoutNode,
			IKielerProgressMonitor progressMonitor) throws KielerException {
		if (graphvizLayouter == null)
			graphvizLayouter = new GraphvizLayouterBinary(LAYOUT_PROVIDER_NAME);
		graphvizLayouter.visit(layoutNode, progressMonitor);
	}

    /* (non-Javadoc)
     * @see de.cau.cs.kieler.kiml.layout.services.AbstractLayoutProvider#getCollection()
     */
    public String getCollection() {
        return GraphvizLayoutProviderNames.LAYOUT_PROVIDER_COLLECTION_ID;
    }

    /* (non-Javadoc)
     * @see de.cau.cs.kieler.kiml.layout.services.AbstractLayoutProvider#getName()
     */
    public String getName() {
        return LAYOUT_PROVIDER_NAME;
    }

    /* (non-Javadoc)
     * @see de.cau.cs.kieler.kiml.layout.services.AbstractLayoutProvider#getType()
     */
    public LayoutType getType() {
        return LAYOUT_PROVIDER_LAYOUT_TYPE;
    }
    
}

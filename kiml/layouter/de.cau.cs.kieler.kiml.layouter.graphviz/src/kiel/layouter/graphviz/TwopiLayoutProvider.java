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
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutNode;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphFactory;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayouterInfo;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutOption;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutType;
import de.cau.cs.kieler.kiml.layout.services.AbstractLayoutProvider;

/**
 * Implements the Twopi layouter of the GraphViz suite. As this class extends
 * the {@link AbstractLayoutProvider}, the most relevant method is
 * <code>doLayout</code>, which performs the actual layout, that is annotating
 * the provided KLayoutNode with the Twopi layout information.
 * <p/>
 * This class acts as a wrapper to the {@link GraphvizLayouterLibrary}. Is uses the
 * {@link GraphvizLayouterLibrary} with the Twopi engine and publishes the Twopi
 * specific capabilities trough <code>getLayouterInfo</code>.
 * 
 * @author <a href="mailto:ars@informatik.uni-kiel.de">Arne Schipper</a>
 */
public class TwopiLayoutProvider extends AbstractLayoutProvider {

	/* some Strings used here */
	private final String LAYOUT_PROVIDER_NAME = GraphvizLayoutProviderNames.GRAPHVIZ_TWOPI;
	private final KLayoutType LAYOUT_PROVIDER_LAYOUT_TYPE = KLayoutType.SPRING_MODEL;
	private final KLayoutOption LAYOUT_PROVIDER_LAYOUT_OPTION = KLayoutOption.DEFAULT;

	/* real GraphViz layouter Emma uses to do the layout */
	private GraphvizLayouter graphvizLayouter = null;

	/*
	 * (non-Javadoc)
	 * @see de.cau.cs.kieler.kiml.layout.services.AbstractLayoutProvider#doLayout(de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutNode, de.cau.cs.kieler.core.alg.IKielerProgressMonitor)
	 */
	public void doLayout(KLayoutNode layoutNode,
			IKielerProgressMonitor progressMonitor) throws KielerException {
		if (graphvizLayouter == null)
			graphvizLayouter = new GraphvizLayouterBinary(LAYOUT_PROVIDER_NAME);
		graphvizLayouter.visit(layoutNode, progressMonitor);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.cau.cs.kieler.kiml.layout.services.AbstractLayoutProvider
	 * #getLayouterInfo()
	 */
	public final KLayouterInfo getLayouterInfo() {
		KLayouterInfo info = KimlLayoutGraphFactory.eINSTANCE
				.createKLayouterInfo();
		info.setLayouterName(LAYOUT_PROVIDER_NAME);
		info.setLayoutType(LAYOUT_PROVIDER_LAYOUT_TYPE);
		info.setLayoutOption(LAYOUT_PROVIDER_LAYOUT_OPTION);
		info
				.setLayouterCollectionID(GraphvizLayoutProviderNames.LAYOUT_PROVIDER_COLLECTION_ID);
		return info;
	}

}

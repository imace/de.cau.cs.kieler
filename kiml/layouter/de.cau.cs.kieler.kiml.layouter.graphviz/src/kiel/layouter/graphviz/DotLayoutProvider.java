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

import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutNode;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphFactory;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayouterInfo;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutOption;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutType;
import de.cau.cs.kieler.kiml.layout.services.KimlAbstractLayoutProvider;

/**
 * Implements the Dot layouter of the GraphViz suite. As this class extends
 * the {@link KimlAbstractLayoutProvider}, the most relevant method is
 * <code>doLayout</code>, which performs the actual layout, that is annotating
 * the provided KLayoutNode with the Dot layout information.
 * <p/>
 * This class acts as a wrapper to the {@link GraphvizLayouter}. Is uses the
 * {@link GraphvizLayouter} with the Dot engine and publishes the Dot
 * specific capabilities trough <code>getLayouterInfo</code>.
 * 
 * @author <a href="mailto:ars@informatik.uni-kiel.de">Arne Schipper</a>
 */
public class DotLayoutProvider extends KimlAbstractLayoutProvider {

	/* some Strings used here */
	private final String LAYOUT_PROVIDER_NAME = GraphvizLayoutProviderNames.GRAPHVIZ_DOT;
	private final KLayoutType LAYOUT_PROVIDER_LAYOUT_TYPE = KLayoutType.HIERARCHICAL;
	private final KLayoutOption LAYOUT_PROVIDER_LAYOUT_OPTION = KLayoutOption.DEFAULT;
	
	/* real GraphViz layouter Emma uses to do the layout */
	private GraphvizLayouter graphvizLayouter = null;

	/* (non-Javadoc)
	 * @see de.cau.cs.kieler.kiml.layout.services.KimlAbstractLayoutProvider#doLayout(de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutNode)
	 */
	public void doLayout(KLayoutNode layoutNode) {
		if (graphvizLayouter == null)
			graphvizLayouter = new GraphvizLayouter(LAYOUT_PROVIDER_NAME);
		graphvizLayouter.visit(layoutNode);
	}

	/* (non-Javadoc)
	 * @see de.cau.cs.kieler.kiml.layout.services.KimlAbstractLayoutProvider#getLayouterInfo()
	 */
	public final KLayouterInfo getLayouterInfo() {
		KLayouterInfo info = KimlLayoutGraphFactory.eINSTANCE
				.createKLayouterInfo();
		info.setLayouterName(LAYOUT_PROVIDER_NAME);
		info.setLayoutType(LAYOUT_PROVIDER_LAYOUT_TYPE);
		info.setLayoutOption(LAYOUT_PROVIDER_LAYOUT_OPTION);
		info.setLayouterCollectionID(GraphvizLayoutProviderNames.LAYOUT_PROVIDER_COLLECTION_ID);
		return info;
	}
}

package de.cau.cs.kieler.kiml.layouter.zest;

import org.eclipse.zest.layouts.algorithms.DirectedGraphLayoutAlgorithm;

import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KNodeGroup;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphFactory;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.LAYOUTER_INFO;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.LAYOUT_OPTION;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.LAYOUT_TYPE;
import de.cau.cs.kieler.kiml.layout.services.KimlAbstractLayoutProvider;


/**
 * Layout provider that uses the Zest directed graph layout algorithm.
 * 
 * @author msp
 */
public class ZestDirectedLayoutProvider extends KimlAbstractLayoutProvider {

	public static final String LAYOUTER_NAME = "Zest Directed Graph Layout";
	
	/* (non-Javadoc)
	 * @see de.cau.cs.kieler.kiml.layout.services.KimlAbstractLayoutProvider#doLayout(de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KNodeGroup)
	 */
	public void doLayout(KNodeGroup nodeGroup) {
		ZestAlgorithmWrapper wrapper = new ZestAlgorithmWrapper(
				new DirectedGraphLayoutAlgorithm(0));
		wrapper.doLayout(nodeGroup);
	}

	/* (non-Javadoc)
	 * @see de.cau.cs.kieler.kiml.layout.services.KimlAbstractLayoutProvider#getLayouterInfo()
	 */
	public LAYOUTER_INFO getLayouterInfo() {
		LAYOUTER_INFO info = KimlLayoutGraphFactory.eINSTANCE.createLAYOUTER_INFO();
		info.setLayouterName(LAYOUTER_NAME);
		info.setLayoutType(LAYOUT_TYPE.HIERARCHICAL);
		info.setLayoutOption(LAYOUT_OPTION.DEFAULT);
		info.setLayouterCollectionID(ZestAlgorithmWrapper.COLLECTION_NAME);
		return info;
	}

}

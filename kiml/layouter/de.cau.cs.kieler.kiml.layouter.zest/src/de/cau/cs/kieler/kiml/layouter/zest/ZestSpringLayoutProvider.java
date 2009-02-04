package de.cau.cs.kieler.kiml.layouter.zest;

import org.eclipse.zest.layouts.algorithms.SpringLayoutAlgorithm;

import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutNode;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphFactory;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayouterInfo;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutOption;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutType;
import de.cau.cs.kieler.kiml.layout.services.KimlAbstractLayoutProvider;


/**
 * Layout provider that uses the Zest spring layout algorithm.
 * 
 * @author msp
 */
public class ZestSpringLayoutProvider extends KimlAbstractLayoutProvider {
	
	public static final String LAYOUTER_NAME = "Zest Spring Layout";

	/* (non-Javadoc)
	 * @see de.cau.cs.kieler.kiml.layout.services.KimlAbstractLayoutProvider#doLayout(de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutNode)
	 */
	public void doLayout(KLayoutNode layoutNode) {
		SpringLayoutAlgorithm springAlgo = new SpringLayoutAlgorithm();
		springAlgo.setRandom(false);
		ZestAlgorithmWrapper wrapper = new ZestAlgorithmWrapper(springAlgo);
		wrapper.doLayout(layoutNode);
	}

	/* (non-Javadoc)
	 * @see de.cau.cs.kieler.kiml.layout.services.KimlAbstractLayoutProvider#getLayouterInfo()
	 */
	public KLayouterInfo getLayouterInfo() {
		KLayouterInfo info = KimlLayoutGraphFactory.eINSTANCE.createKLayouterInfo();
		info.setLayouterName(LAYOUTER_NAME);
		info.setLayoutType(KLayoutType.SPRING_MODEL);
		info.setLayoutOption(KLayoutOption.DEFAULT);
		info.setLayouterCollectionID(ZestAlgorithmWrapper.COLLECTION_NAME);
		return info;
	}

}

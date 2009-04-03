package de.cau.cs.kieler.kiml.layouter.zest;

import org.eclipse.zest.layouts.algorithms.SpringLayoutAlgorithm;

import de.cau.cs.kieler.core.KielerException;
import de.cau.cs.kieler.core.alg.IKielerProgressMonitor;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutNode;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphFactory;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayouterInfo;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutOption;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutType;
import de.cau.cs.kieler.kiml.layout.services.AbstractLayoutProvider;


/**
 * Layout provider that uses the Zest spring layout algorithm.
 * 
 * @author msp
 */
public class ZestSpringLayoutProvider extends AbstractLayoutProvider {
	
	public static final String LAYOUTER_NAME = "Zest Spring Layout";

	/* (non-Javadoc)
	 * @see de.cau.cs.kieler.kiml.layout.services.AbstractLayoutProvider#doLayout(de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutNode)
	 */
	public void doLayout(KLayoutNode layoutNode,
			IKielerProgressMonitor progressMonitor) throws KielerException {
		SpringLayoutAlgorithm springAlgo = new SpringLayoutAlgorithm();
		springAlgo.setRandom(false);
		ZestAlgorithmWrapper wrapper = new ZestAlgorithmWrapper(springAlgo);
		wrapper.doLayout(layoutNode, progressMonitor);
	}

	/* (non-Javadoc)
	 * @see de.cau.cs.kieler.kiml.layout.services.AbstractLayoutProvider#getLayouterInfo()
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

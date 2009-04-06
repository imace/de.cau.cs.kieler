package de.cau.cs.kieler.kiml.layouter.zest;

import org.eclipse.zest.layouts.algorithms.GridLayoutAlgorithm;

import de.cau.cs.kieler.core.KielerException;
import de.cau.cs.kieler.core.alg.IKielerProgressMonitor;
import de.cau.cs.kieler.core.kgraph.KNode;
import de.cau.cs.kieler.kiml.layout.options.LayoutType;
import de.cau.cs.kieler.kiml.layout.services.AbstractLayoutProvider;


/**
 * Layout provider that uses the Zest grid layout algorithm.
 * 
 * @author msp
 */
public class ZestGridLayoutProvider extends AbstractLayoutProvider {

	public static final String LAYOUTER_NAME = "Zest Grid Layout";
	
	/*
	 * (non-Javadoc)
	 * @see de.cau.cs.kieler.kiml.layout.services.AbstractLayoutProvider#doLayout(de.cau.cs.kieler.core.kgraph.KNode, de.cau.cs.kieler.core.alg.IKielerProgressMonitor)
	 */
	public void doLayout(KNode layoutNode,
			IKielerProgressMonitor progressMonitor) throws KielerException {
		ZestAlgorithmWrapper wrapper = new ZestAlgorithmWrapper(
				new GridLayoutAlgorithm());
		wrapper.doLayout(layoutNode, progressMonitor);
	}

    /* (non-Javadoc)
     * @see de.cau.cs.kieler.kiml.layout.services.AbstractLayoutProvider#getCollection()
     */
    public String getCollection() {
        return ZestAlgorithmWrapper.COLLECTION_NAME;
    }

    /* (non-Javadoc)
     * @see de.cau.cs.kieler.kiml.layout.services.AbstractLayoutProvider#getName()
     */
    public String getName() {
        return LAYOUTER_NAME;
    }

    /* (non-Javadoc)
     * @see de.cau.cs.kieler.kiml.layout.services.AbstractLayoutProvider#getType()
     */
    public LayoutType getType() {
        return LayoutType.OTHER;
    }

}

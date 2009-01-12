package edu.unikiel.rtsys.klodd.orthogonal;

import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KNodeGroup;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphFactory;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.LAYOUTER_INFO;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.LAYOUT_OPTION;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.LAYOUT_TYPE;
import edu.unikiel.rtsys.kieler.kiml.layout.services.KimlAbstractLayoutProvider;
import edu.unikiel.rtsys.klodd.core.KloddCorePlugin;
import edu.unikiel.rtsys.klodd.orthogonal.impl.*;
import edu.unikiel.rtsys.klodd.orthogonal.modules.*;
import edu.unikiel.rtsys.klodd.orthogonal.structures.TSMGraph;

/**
 * Layout provider for the KLoDD orthogonal dataflow diagram layouter.
 * 
 * @author msp
 */
public class OrthogonalDataflowLayoutProvider extends
		KimlAbstractLayoutProvider {

	/** displayed name of this layout provider */
	public static final String LAYOUTER_NAME = "KLoDD Orthogonal";
	
	/** the planarization module */
	private IPlanarizer planarizer;
	/** the orthogonalization module */
	private IOrthogonalizer orthogonalizer;
	/** the compaction module */
	private ICompacter compacter;
	
	/* (non-Javadoc)
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.services.KimlAbstractLayoutProvider#doLayout(edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KNodeGroup)
	 */
	public void doLayout(KNodeGroup nodeGroup) {
		// get the currently configured modules
		updateModules();

		// perform the planarization phase
		TSMGraph tsmGraph = planarizer.planarize(nodeGroup);
		// perform the orthogonalization phase
		orthogonalizer.orthogonalize(tsmGraph);
		// perform the compaction phase
		//compacter.compact(tsmGraph);
		// apply layout information to the original graph
		tsmGraph.applyLayout();
	}

	/* (non-Javadoc)
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.services.KimlAbstractLayoutProvider#getLayouterInfo()
	 */
	public LAYOUTER_INFO getLayouterInfo() {
		LAYOUTER_INFO info = KimlLayoutGraphFactory.eINSTANCE.createLAYOUTER_INFO();
		info.setLayouterName(LAYOUTER_NAME);
		info.setLayoutType(LAYOUT_TYPE.ORTHOGONAL);
		info.setLayoutOption(LAYOUT_OPTION.DEFAULT);
		info.setLayouterCollectionID(KloddCorePlugin.COLLECTION_NAME);
		return info;
	}
	
	/**
	 * Sets the internally used algorithm modules to the current configuration.
	 */
	private void updateModules() {
		planarizer = new ECEmbeddingPlanarizer();
		orthogonalizer = new KandinskyLPOrthogonalizer();
		compacter = null;
	}

}

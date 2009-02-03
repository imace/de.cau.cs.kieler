package de.cau.cs.kieler.klodd.orthogonal;

import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KNodeGroup;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphFactory;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.LAYOUTER_INFO;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.LAYOUT_OPTION;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.LAYOUT_TYPE;
import de.cau.cs.kieler.kiml.layout.services.KimlAbstractLayoutProvider;
import de.cau.cs.kieler.klodd.core.KloddCorePlugin;
import de.cau.cs.kieler.klodd.orthogonal.impl.*;
import de.cau.cs.kieler.klodd.orthogonal.impl.ec.EdgeInsertionECPlanarizer;
import de.cau.cs.kieler.klodd.orthogonal.modules.*;
import de.cau.cs.kieler.klodd.orthogonal.structures.TSMGraph;

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
	 * @see de.cau.cs.kieler.kiml.layout.services.KimlAbstractLayoutProvider#doLayout(de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KNodeGroup)
	 */
	public void doLayout(KNodeGroup nodeGroup) {
		// get the currently configured modules
		updateModules();
		
		long startTime = System.nanoTime();

		// perform the planarization phase
		TSMGraph tsmGraph = planarizer.planarize(nodeGroup);
		// perform the orthogonalization phase
		orthogonalizer.orthogonalize(tsmGraph);
		// perform the compaction phase
		compacter.compact(tsmGraph);
		// apply layout information to the original graph
		tsmGraph.applyLayout();
		
		double executionTime = (double)(System.nanoTime() - startTime) * 1e-9;
		if (executionTime >= 1.0)
			System.out.println("Execution time (" + nodeGroup.getSubNodeGroups().size() + " nodes): " + executionTime + " s");
		else
			System.out.println("Execution time (" + nodeGroup.getSubNodeGroups().size() + " nodes): " + executionTime * 1000 + " ms");
	}

	/* (non-Javadoc)
	 * @see de.cau.cs.kieler.kiml.layout.services.KimlAbstractLayoutProvider#getLayouterInfo()
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
		planarizer = new PortConstraintsPlanarizer(new EdgeInsertionECPlanarizer());
		orthogonalizer = new KandinskyLPOrthogonalizer();
		compacter = new NormalizingCompacter(new RefiningCompacter(
				new FastRefinedCompacter()));
	}

}

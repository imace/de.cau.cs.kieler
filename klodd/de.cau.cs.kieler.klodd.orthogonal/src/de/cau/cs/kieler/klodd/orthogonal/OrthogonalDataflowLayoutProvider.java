package de.cau.cs.kieler.klodd.orthogonal;

import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutNode;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphFactory;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayouterInfo;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutOption;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutType;
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
	 * @see de.cau.cs.kieler.kiml.layout.services.KimlAbstractLayoutProvider#doLayout(de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutNode)
	 */
	public void doLayout(KLayoutNode layoutNode) {
		// get the currently configured modules
		updateModules();
		
		long startTime = System.nanoTime();

		// perform the planarization phase
		TSMGraph tsmGraph = planarizer.planarize(layoutNode);
		// perform the orthogonalization phase
		orthogonalizer.orthogonalize(tsmGraph);
		// perform the compaction phase
		compacter.compact(tsmGraph);
		// apply layout information to the original graph
		tsmGraph.applyLayout();
		
		double executionTime = (double)(System.nanoTime() - startTime) * 1e-9;
		if (executionTime >= 1.0)
			System.out.println("Execution time (" + layoutNode.getChildNodes().size() + " nodes): " + executionTime + " s");
		else
			System.out.println("Execution time (" + layoutNode.getChildNodes().size() + " nodes): " + executionTime * 1000 + " ms");
	}

	/* (non-Javadoc)
	 * @see de.cau.cs.kieler.kiml.layout.services.KimlAbstractLayoutProvider#getLayouterInfo()
	 */
	public KLayouterInfo getLayouterInfo() {
		KLayouterInfo info = KimlLayoutGraphFactory.eINSTANCE.createKLayouterInfo();
		info.setLayouterName(LAYOUTER_NAME);
		info.setLayoutType(KLayoutType.ORTHOGONAL);
		info.setLayoutOption(KLayoutOption.DEFAULT);
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
				new LayeringCompacter()));
	}

}

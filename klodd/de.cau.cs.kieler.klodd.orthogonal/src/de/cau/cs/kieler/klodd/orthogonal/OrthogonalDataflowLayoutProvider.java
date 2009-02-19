package de.cau.cs.kieler.klodd.orthogonal;

import java.util.List;

import de.cau.cs.kieler.core.KielerException;
import de.cau.cs.kieler.core.alg.IKielerProgressMonitor;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KInsets;
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
	
	/** minimal distance between elements */
	private static final float MIN_DIST = 15.0f;
	
	/** the planarization module */
	private IPlanarizer planarizer;
	/** the orthogonalization module */
	private IOrthogonalizer orthogonalizer;
	/** the compaction module */
	private ICompacter compacter;
	
	/*
	 * (non-Javadoc)
	 * @see de.cau.cs.kieler.kiml.layout.services.KimlAbstractLayoutProvider#doLayout(de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutNode, de.cau.cs.kieler.core.alg.IKielerProgressMonitor)
	 */
	public void doLayout(KLayoutNode layoutNode,
			IKielerProgressMonitor progressMonitor) throws KielerException {
		progressMonitor.begin("Orthogonal layout", 100);
		// get the currently configured modules
		updateModules();
		
		// split the graph into connected components
		ConnectedComponents componentsSplitter = new ConnectedComponents();
		List<TSMGraph> components = componentsSplitter.findComponents(layoutNode);
		for (TSMGraph tsmGraph : components) {
			// perform the planarization phase
			planarizer.reset();
			planarizer.planarize(tsmGraph);
			// perform the orthogonalization phase
			orthogonalizer.reset();
			orthogonalizer.orthogonalize(tsmGraph);
			// perform the compaction phase
			compacter.reset();
			compacter.compact(tsmGraph, MIN_DIST);
		}
		// apply layout information to the original graph
		applyLayout(components, layoutNode);
		progressMonitor.done();
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
	
	/**
	 * Applies layout to the given list of connected components of a graph.
	 * 
	 * @param components list of connected components
	 * @param parentNode parent layout node
	 */
	private void applyLayout(List<TSMGraph> components, KLayoutNode parentNode) {
		KInsets insets = parentNode.getLayout().getInsets();
		float currentYpos = 0.0f, maxWidth = 0.0f;
		for (TSMGraph component : components) {
			component.applyLayout(0.0f, currentYpos, insets);
			currentYpos += component.height;
			maxWidth = Math.max(maxWidth, component.width);
		}
		
		// update the size of the parent layout node
		parentNode.getLayout().getSize().setWidth(insets.getLeft()
				+ maxWidth + insets.getRight());
		parentNode.getLayout().getSize().setHeight(insets.getTop()
				+ currentYpos + insets.getBottom());
		
		// update layout options of the parent layout node
		List<KLayoutOption> layoutOptions = parentNode.getLayout().getLayoutOptions();
		if (!layoutOptions.contains(KLayoutOption.FIXED_SIZE))
			layoutOptions.add(KLayoutOption.FIXED_SIZE);
		if (!layoutOptions.contains(KLayoutOption.FIXED_PORTS))
			layoutOptions.add(KLayoutOption.FIXED_PORTS);
	}

}

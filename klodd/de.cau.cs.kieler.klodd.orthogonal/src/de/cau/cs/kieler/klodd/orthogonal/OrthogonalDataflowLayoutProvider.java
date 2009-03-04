package de.cau.cs.kieler.klodd.orthogonal;

import java.util.List;

import de.cau.cs.kieler.core.IKielerPreferenceStore;
import de.cau.cs.kieler.core.KielerException;
import de.cau.cs.kieler.core.alg.IKielerProgressMonitor;
import de.cau.cs.kieler.core.graph.KGraph;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KInsets;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutNode;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphFactory;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayouterInfo;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutOption;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutType;
import de.cau.cs.kieler.kiml.layout.services.KimlAbstractLayoutProvider;
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
	/** name of the KLoDD layouters collection */
	public static final String COLLECTION_NAME = "KLoDD Layouters";
	
	/** preference identifier for minimal distance */
	public static final String PREF_MIN_DIST = "klodd.orthogonal.minDist";
	/** default value for minimal distance */
	public static final float DEF_MIN_DIST = 15.0f;
	
	/** the preference store for this layouter */
	private static IKielerPreferenceStore preferenceStore;

	/**
	 * Sets the preference store.
	 * 
	 * @param preferenceStore the preference store to set
	 */
	public static void setPreferenceStore(IKielerPreferenceStore preferenceStore) {
		OrthogonalDataflowLayoutProvider.preferenceStore = preferenceStore;
	}

	/** the minimal distance between two nodes or edges */
	private float minDist;
	
	/** the planarization module */
	private IPlanarizer planarizer = null;
	/** the orthogonalization module */
	private IOrthogonalizer orthogonalizer = null;
	/** the compaction module */
	private ICompacter compacter = null;
	
	/*
	 * (non-Javadoc)
	 * @see de.cau.cs.kieler.kiml.layout.services.KimlAbstractLayoutProvider#doLayout(de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutNode, de.cau.cs.kieler.core.alg.IKielerProgressMonitor)
	 */
	public void doLayout(KLayoutNode layoutNode,
			IKielerProgressMonitor progressMonitor) throws KielerException {
		// get the currently configured modules
		updateModules();
		
		// split the graph into connected components
		ConnectedComponents componentsSplitter = new ConnectedComponents();
		List<TSMGraph> components = componentsSplitter.findComponents(layoutNode);
		progressMonitor.begin("Orthogonal layout", components.size() * 30 + 2);
		
		for (KGraph tsmGraph : components) {
			// perform the planarization phase
			planarizer.reset(progressMonitor.subTask(10));
			planarizer.planarize(tsmGraph);
			// perform the orthogonalization phase
			orthogonalizer.reset(progressMonitor.subTask(10));
			orthogonalizer.orthogonalize(tsmGraph);
			// perform the compaction phase
			compacter.reset(progressMonitor.subTask(10));
			compacter.compact(tsmGraph, minDist);
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
		info.setLayouterCollectionID(COLLECTION_NAME);
		return info;
	}
	
	/**
	 * Sets the internally used algorithm modules to the current configuration.
	 */
	private void updateModules() {
		if (planarizer == null)
			planarizer = new PortConstraintsPlanarizer(
					new EdgeInsertionECPlanarizer());
		if (orthogonalizer == null)
			orthogonalizer = new KandinskyLPOrthogonalizer();
		if (compacter == null)
			compacter = new NormalizingCompacter(new RefiningCompacter(
					new LayeringCompacter()));
		
		if (preferenceStore == null)
			minDist = DEF_MIN_DIST;
		else
			minDist = preferenceStore.getFloat(PREF_MIN_DIST);
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

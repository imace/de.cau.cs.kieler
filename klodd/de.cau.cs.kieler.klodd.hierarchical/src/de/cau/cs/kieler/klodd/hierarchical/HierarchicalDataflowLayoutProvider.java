package de.cau.cs.kieler.klodd.hierarchical;

import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutNode;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphFactory;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayouterInfo;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutOption;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutType;
import de.cau.cs.kieler.kiml.layout.services.KimlAbstractLayoutProvider;
import de.cau.cs.kieler.klodd.core.KloddCorePlugin;
import de.cau.cs.kieler.klodd.core.algorithms.*;
import de.cau.cs.kieler.klodd.core.preferences.KloddLayoutPreferences;
import de.cau.cs.kieler.klodd.core.util.LayoutGraphs;
import de.cau.cs.kieler.klodd.hierarchical.impl.*;
import de.cau.cs.kieler.klodd.hierarchical.modules.*;
import de.cau.cs.kieler.klodd.hierarchical.structures.LayeredGraph;

/**
 * Layout provider for the KLoDD hierarchical dataflow diagram layouter.
 * 
 * @author msp
 */
public class HierarchicalDataflowLayoutProvider extends
		KimlAbstractLayoutProvider {
	
	/** displayed name of this layout provider */
	public static final String LAYOUTER_NAME = "KLoDD Hierarchical";
	
	/** the minimal distance between two nodes or edges */
	private float minDist;
	
	/** the cycle remover module */
	private ICycleRemover cycleRemover = null;
	/** the layer assigner module */
	private ILayerAssigner layerAssigner = null;
	/** the crossing reducer module */
	private ICrossingReducer crossingReducer = null;
	/** the nodewise edge placer module */
	private INodewiseEdgePlacer nodewiseEdgePlacer = null;
	/** the node placer module */
	private INodePlacer nodePlacer = null;
	/** the edge router module */
	private IEdgeRouter edgeRouter = null;
	
	/* (non-Javadoc)
	 * @see de.cau.cs.kieler.kiml.layout.services.KimlAbstractLayoutProvider#doLayout(de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutNode)
	 */
	public void doLayout(KLayoutNode layoutNode) {
		// get the currently configured modules
		updateModules();
	
		long startTime = System.nanoTime();

		// set the size of each non-empty node
		setNodeSizes(layoutNode);
		// remove cycles in the input graph
		cycleRemover.removeCycles(layoutNode);
		// put each node into a layer and get a layered graph
		LayeredGraph layeredGraph = layerAssigner.assignLayers(layoutNode);
		if (!layeredGraph.getLayers().isEmpty()) {
			layeredGraph.createConnections();
			// optimize the order of nodes in each layer
			crossingReducer.reduceCrossings(layeredGraph);
			// determine a placement for all edge endpoints
			nodewiseEdgePlacer.placeEdges(layeredGraph);
			// determine a crosswise placement for each node
			nodePlacer.placeNodes(layeredGraph, minDist);
			// route edges between nodes
			edgeRouter.routeEdges(layeredGraph, minDist);
		}
		layeredGraph.applyLayout();
		cycleRemover.restoreGraph();
		
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
		info.setLayoutType(KLayoutType.HIERARCHICAL);
		info.setLayoutOption(KLayoutOption.DEFAULT);
		info.setLayouterCollectionID(KloddCorePlugin.COLLECTION_NAME);
		return info;
	}
	
	/**
	 * Sets the internally used algorithm modules to the current configuration.
	 */
	private void updateModules() {
		KloddLayoutPreferences pref = KloddCorePlugin.getLayoutPreferences();
		
		cycleRemover = new DFSCycleRemover();
		layerAssigner = new LongestPathLayerAssigner();
		crossingReducer = new LayerSweepCrossingReducer(new BarycenterCrossingReducer());
		nodewiseEdgePlacer = new SortingNodewiseEdgePlacer();
		nodePlacer = new BalancingNodePlacer(new BasicNodePlacer());
		edgeRouter = new RectilinearEdgeRouter(new SortingLayerwiseEdgePlacer());
		
		minDist = ((Float)pref.get(KloddLayoutPreferences.MIN_DIST)).floatValue();
	}
	
	/**
	 * Sets the size of each non-empty node, depending on its layout options.
	 * 
	 * @param parentNode parent layout node
	 */
	private void setNodeSizes(KLayoutNode parentNode) {
		for (KLayoutNode node : parentNode.getChildNodes()) {
			if (!node.getLayout().getLayoutOptions().contains(KLayoutOption.FIXED_SIZE)
					&& node.getChildNodes().isEmpty()) {
				LayoutGraphs.resizeNode(node);
			}
		}
	}
	
}

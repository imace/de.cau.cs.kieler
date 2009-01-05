package edu.unikiel.rtsys.klodd.hierarchical;

import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KNodeGroup;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphFactory;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.LAYOUTER_INFO;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.LAYOUT_OPTION;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.LAYOUT_TYPE;
import edu.unikiel.rtsys.kieler.kiml.layout.services.KimlAbstractLayoutProvider;
import edu.unikiel.rtsys.klodd.core.KloddCorePlugin;
import edu.unikiel.rtsys.klodd.core.algorithms.*;
import edu.unikiel.rtsys.klodd.core.preferences.KloddLayoutPreferences;
import edu.unikiel.rtsys.klodd.core.util.LayoutGraphs;
import edu.unikiel.rtsys.klodd.hierarchical.impl.*;
import edu.unikiel.rtsys.klodd.hierarchical.modules.*;
import edu.unikiel.rtsys.klodd.hierarchical.structures.LayeredGraph;

/**
 * Layout provider for the KIELER hierarchical dataflow diagram layouter.
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
	/** the node placer module */
	private INodePlacer nodePlacer = null;
	/** the edge router module */
	private IEdgeRouter edgeRouter = null;
	
	/* (non-Javadoc)
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.services.KimlAbstractLayoutProvider#doLayout(edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KNodeGroup)
	 */
	public void doLayout(KNodeGroup nodeGroup) {
		// get the currently configured modules
		updateModules();
	
		long startTime = System.nanoTime();

		// set the size of each non-empty node
		setNodeSizes(nodeGroup);
		// remove cycles in the input graph
		cycleRemover.removeCycles(nodeGroup);
		// put each node into a layer and get a layered graph
		LayeredGraph layeredGraph = layerAssigner.assignLayers(nodeGroup);
		if (!layeredGraph.getLayers().isEmpty()) {
			layeredGraph.createConnections();
			// optimize the order of nodes in each layer
			crossingReducer.reduceCrossings(layeredGraph);
			layeredGraph.calcConnectionRouting();
			// determine a crosswise placement for each node
			nodePlacer.placeNodes(layeredGraph, minDist);
			// route edges between nodes
			edgeRouter.routeEdges(layeredGraph, minDist);
		}
		layeredGraph.applyLayout();
		cycleRemover.restoreGraph();
		
		double executionTime = (double)(System.nanoTime() - startTime) * 1e-9;
		if (executionTime >= 1.0)
			System.out.println("Execution time (" + nodeGroup.getSubNodeGroups().size() + " nodes): " + executionTime + " s");
		else
			System.out.println("Execution time (" + nodeGroup.getSubNodeGroups().size() + " nodes): " + executionTime * 1000 + " ms");
	}

	/* (non-Javadoc)
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.services.KimlAbstractLayoutProvider#getLayouterInfo()
	 */
	public LAYOUTER_INFO getLayouterInfo() {
		LAYOUTER_INFO info = KimlLayoutGraphFactory.eINSTANCE.createLAYOUTER_INFO();
		info.setLayouterName(LAYOUTER_NAME);
		info.setLayoutType(LAYOUT_TYPE.HIERARCHICAL);
		info.setLayoutOption(LAYOUT_OPTION.DEFAULT);
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
		nodePlacer = new BalancingNodePlacer(new BasicNodePlacer());
		edgeRouter = new RectilinearEdgeRouter();
		
		minDist = ((Float)pref.get(KloddLayoutPreferences.MIN_DIST)).floatValue();
	}
	
	/**
	 * Sets the size of each non-empty node, depending on its layout options.
	 * 
	 * @param parentGroup parent node group
	 */
	private void setNodeSizes(KNodeGroup parentGroup) {
		for (KNodeGroup node : parentGroup.getSubNodeGroups()) {
			if (!node.getLayout().getLayoutOptions().contains(LAYOUT_OPTION.FIXED_SIZE)
					&& node.getSubNodeGroups().isEmpty()) {
				LayoutGraphs.resizeNode(node);
			}
		}
	}
	
}

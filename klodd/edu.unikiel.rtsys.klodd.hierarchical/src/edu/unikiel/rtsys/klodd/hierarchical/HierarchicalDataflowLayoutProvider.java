package edu.unikiel.rtsys.klodd.hierarchical;

import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KNodeGroup;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphFactory;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.LAYOUTER_INFO;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.LAYOUT_OPTION;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.LAYOUT_TYPE;
import edu.unikiel.rtsys.kieler.kiml.layout.services.KimlAbstractLayoutProvider;
import edu.unikiel.rtsys.klodd.core.algorithms.*;
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
	
	/** Displayed name of this layout provider */
	public static final String LAYOUTER_NAME = "KLoDD Hierarchical";
	/** Name of the KLoDD layouters collection */
	public static final String COLLECTION_NAME = "KLoDD Layouters";
	
	// the cycle remover module
	private ICycleRemover cycleRemover = null;
	// the layer assigner module
	private ILayerAssigner layerAssigner = null;
	// the crossing reducer module
	private ICrossingReducer crossingReducer = null;
	
	/* (non-Javadoc)
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.services.KimlAbstractLayoutProvider#doLayout(edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KNodeGroup)
	 */
	public void doLayout(KNodeGroup nodeGroup) {
		// get the currently configured modules
		updateModules();
		// set the size of each non-empty node
		setNodeSizes(nodeGroup);
		
		long startTime = System.nanoTime();
		
		cycleRemover.removeCycles(nodeGroup);
		LayeredGraph layeredGraph = layerAssigner.assignLayers(nodeGroup);
		if (!layeredGraph.getLayers().isEmpty()) {
			layeredGraph.createConnections();
			crossingReducer.reduceCrossings(layeredGraph);
			// TODO remaining modules
		}
		cycleRemover.restoreGraph();
		
		double executionTime = (double)(System.nanoTime() - startTime) * 1e-9;
		if (executionTime > 1.0)
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
		info.setLayouterCollectionID(COLLECTION_NAME);
		return info;
	}
	
	/**
	 * Sets the internally used algorithm modules to the current configuration.
	 */
	private void updateModules() {
		cycleRemover = new DFSCycleRemover();
		layerAssigner = new LongestPathLayerAssigner();
		crossingReducer = new LayerSweepCrossingReducer(new BarycenterCrossingReducer());
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

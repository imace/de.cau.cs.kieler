/******************************************************************************
 * KIELER - Kiel Integrated Environment for Layout for the Eclipse RCP
 *
 * http://www.informatik.uni-kiel.de/rtsys/kieler/
 * 
 * Copyright 2008 by
 * + Christian-Albrechts-University of Kiel
 *   + Department of Computer Science
 *     + Real-Time and Embedded Systems Group
 * 
 * This code is provided under the terms of the Eclipse Public License (EPL).
 * See the file epl-v10.html for the license text.
 */
package de.cau.cs.kieler.klodd.hierarchical;

import java.util.LinkedList;
import java.util.List;

import de.cau.cs.kieler.core.IKielerPreferenceStore;
import de.cau.cs.kieler.core.KielerException;
import de.cau.cs.kieler.core.alg.IKielerProgressMonitor;
import de.cau.cs.kieler.core.slimgraph.KSlimEdge;
import de.cau.cs.kieler.core.slimgraph.KSlimGraph;
import de.cau.cs.kieler.core.slimgraph.alg.DFSCycleRemover;
import de.cau.cs.kieler.core.slimgraph.alg.GreedyCycleRemover;
import de.cau.cs.kieler.core.slimgraph.alg.ICycleRemover;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutEdge;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutNode;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutPort;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KPoint;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KPortPlacement;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KPortType;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphFactory;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayouterInfo;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutOption;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutType;
import de.cau.cs.kieler.kiml.layout.services.KimlAbstractLayoutProvider;
import de.cau.cs.kieler.kiml.layout.util.GraphConverter;
import de.cau.cs.kieler.kiml.layout.util.LayoutGraphUtil;
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
	/** name of the KLoDD layouters collection */
	public static final String COLLECTION_NAME = "KLoDD Layouters";
	
	/** preference identifier for minimal distance */
	public static final String PREF_MIN_DIST = "klodd.hierarchical.minDist";
	/** default value for minimal distance */
	public static final float DEF_MIN_DIST = 15.0f; 
	/** preference identifier for cycle remover module */
	public static final String PREF_CYCLE_REM = "klodd.hierarchical.cycleRem";
	/** value for DFS cycle remover module */
	public static final String VAL_DFS_CYCLE_REM = "dfs";
	/** value for greedy cycle remover module */
	public static final String VAL_GREEDY_CYCLE_REM = "greedy";
	/** preference identifier for layer assignment module */
	public static final String PREF_LAYER_ASS = "klodd.hierarchical.layerAss";
	/** value for longest path layer assignment module */
	public static final String VAL_LONGP_LAYER_ASS = "longp";
	/** value for balancing layer assignment module */
	public static final String VAL_BAL_LAYER_ASS = "bal";

	/** the preference store for this layouter */
	private static IKielerPreferenceStore preferenceStore;
	
	/**
	 * Sets the preference store
	 * 
	 * @param preferenceStore the preference store to set
	 */
	public static void setPreferenceStore(IKielerPreferenceStore preferenceStore) {
		HierarchicalDataflowLayoutProvider.preferenceStore = preferenceStore;
	}

	/** the minimal distance between two nodes or edges */
	private float minDist;
	
	/** the graph converter module */
	private GraphConverter graphConverter = new GraphConverter();
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
	
	/*
	 * (non-Javadoc)
	 * @see de.cau.cs.kieler.kiml.layout.services.KimlAbstractLayoutProvider#doLayout(de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutNode, de.cau.cs.kieler.core.alg.IKielerProgressMonitor)
	 */
	public void doLayout(KLayoutNode layoutNode,
			IKielerProgressMonitor progressMonitor) throws KielerException {
		progressMonitor.begin("Hierarchical layout", 75);
		// get the currently configured modules
		updateModules();

		// set the size of each non-empty node
		setNodeSizes(layoutNode);
		// create a KIELER graph for cycle removal
		graphConverter.reset(progressMonitor.subTask(5));
		KSlimGraph kGraph = graphConverter.convertGraph(layoutNode, true);
		// remove cycles in the input graph
		cycleRemover.reset(progressMonitor.subTask(5));
		cycleRemover.removeCycles(kGraph);
		// put each node into a layer and get a layered graph
		layerAssigner.reset(progressMonitor.subTask(10));
		LayeredGraph layeredGraph = layerAssigner.assignLayers(
				kGraph, layoutNode);
		if (!layeredGraph.getLayers().isEmpty()) {
			layeredGraph.createConnections(kGraph);
			// optimize the order of nodes in each layer
			crossingReducer.reset(progressMonitor.subTask(15));
			crossingReducer.reduceCrossings(layeredGraph);
			// determine a placement for all edge endpoints
			nodewiseEdgePlacer.reset(progressMonitor.subTask(10));
			nodewiseEdgePlacer.placeEdges(layeredGraph);
			// determine a crosswise placement for each node
			nodePlacer.reset(progressMonitor.subTask(10));
			nodePlacer.placeNodes(layeredGraph, minDist);
			// route edges between nodes
			edgeRouter.reset(progressMonitor.subTask(10));
			edgeRouter.routeEdges(layeredGraph, minDist);
		}
		layeredGraph.applyLayout();
		restoreCycles();
		
		progressMonitor.done();
	}

	/* (non-Javadoc)
	 * @see de.cau.cs.kieler.kiml.layout.services.KimlAbstractLayoutProvider#getLayouterInfo()
	 */
	public KLayouterInfo getLayouterInfo() {
		KLayouterInfo info = KimlLayoutGraphFactory.eINSTANCE.createKLayouterInfo();
		info.setLayouterName(LAYOUTER_NAME);
		info.setLayoutType(KLayoutType.HIERARCHICAL);
		info.setLayoutOption(KLayoutOption.DEFAULT);
		info.setLayouterCollectionID(COLLECTION_NAME);
		return info;
	}
	
	/**
	 * Sets the internally used algorithm modules to the current configuration.
	 */
	private void updateModules() {
		// choose cycle remover module
		if (preferenceStore != null && preferenceStore.getString(PREF_CYCLE_REM)
				.equals(VAL_DFS_CYCLE_REM)) {
			if (!(cycleRemover instanceof DFSCycleRemover))
				cycleRemover = new DFSCycleRemover();
		}
		else {
			if (!(cycleRemover instanceof GreedyCycleRemover))
				cycleRemover = new GreedyCycleRemover();
		}
		
		// choose layer assignment module
		if (preferenceStore != null && preferenceStore.getString(PREF_LAYER_ASS)
				.equals(VAL_LONGP_LAYER_ASS)) {
			if (!(layerAssigner instanceof LongestPathLayerAssigner))
				layerAssigner = new LongestPathLayerAssigner();
		}
		else {
			if (!(layerAssigner instanceof BalancingLayerAssigner))
				layerAssigner = new BalancingLayerAssigner(
						new LongestPathLayerAssigner());
		}
		
		if (crossingReducer == null)
			crossingReducer = new LayerSweepCrossingReducer(
					new BarycenterCrossingReducer());
		if (nodewiseEdgePlacer == null)
			nodewiseEdgePlacer = new SortingNodewiseEdgePlacer();
		if (nodePlacer == null)
			nodePlacer = new BalancingNodePlacer(new BasicNodePlacer());
		if (edgeRouter == null)
			edgeRouter = new RectilinearEdgeRouter(new SortingLayerwiseEdgePlacer());
		
		if (preferenceStore != null)
			minDist = preferenceStore.getFloat(PREF_MIN_DIST);
		else
			minDist = DEF_MIN_DIST;
	}
	
	/**
	 * Sets the size of each non-empty node, depending on its layout options.
	 * 
	 * @param parentNode parent layout node
	 */
	private void setNodeSizes(KLayoutNode parentNode) {
		for (KLayoutNode node : parentNode.getChildNodes()) {
			// set port sides if not fixed
			if (node.getChildNodes().isEmpty()
					&& !node.getLayout().getLayoutOptions().contains(
					KLayoutOption.FIXED_PORTS)
					&& !node.getLayout().getLayoutOptions().contains(
					KLayoutOption.FIXED_PORT_SIDES)) {
				if (parentNode.getLayout().getLayoutOptions().contains(
						KLayoutOption.VERTICAL)) {
					for (KLayoutPort port : node.getPorts()) {
						port.getLayout().setPlacement(port.getType()
								== KPortType.INPUT ? KPortPlacement.NORTH
								: KPortPlacement.SOUTH);
					}
				}
				else {
					for (KLayoutPort port : node.getPorts()) {
						port.getLayout().setPlacement(port.getType()
								== KPortType.INPUT ? KPortPlacement.WEST
								: KPortPlacement.EAST);
					}
				}
			}
			// set node sizes if not fixed
			if (node.getChildNodes().isEmpty()
					&& !node.getLayout().getLayoutOptions().contains(
					KLayoutOption.FIXED_SIZE)) {
				LayoutGraphUtil.resizeNode(node);
			}
		}
	}
	
	/**
	 * Restores the edges that were reversed for cycle removal.
	 */
	private void restoreCycles() {
		List<KSlimEdge> reversedEdges = cycleRemover.getReversedEdges();
		for (KSlimEdge kEdge : reversedEdges) {
			KLayoutEdge layoutEdge = (KLayoutEdge)kEdge.object;
			// reverse bend points
			List<KPoint> bendPoints = new LinkedList<KPoint>();
			for (KPoint point : layoutEdge.getLayout().getBendPoints()) {
				bendPoints.add(0, point);
			}
			layoutEdge.getLayout().getBendPoints().clear();
			for (KPoint point : bendPoints) {
				layoutEdge.getLayout().getBendPoints().add(point);
			}
			// reverse source and target point
			KPoint sourcePoint = layoutEdge.getLayout().getSourcePoint();
			layoutEdge.getLayout().setSourcePoint(layoutEdge
					.getLayout().getTargetPoint());
			layoutEdge.getLayout().setTargetPoint(sourcePoint);
		}
	}
	
}

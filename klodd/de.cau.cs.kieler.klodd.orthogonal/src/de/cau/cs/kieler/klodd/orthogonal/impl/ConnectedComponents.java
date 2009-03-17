/******************************************************************************
 * KIELER - Kiel Integrated Environment for Layout for the Eclipse RCP
 *
 * http://www.informatik.uni-kiel.de/rtsys/kieler/
 * 
 * Copyright 2009 by
 * + Christian-Albrechts-University of Kiel
 *   + Department of Computer Science
 *     + Real-Time and Embedded Systems Group
 * 
 * This code is provided under the terms of the Eclipse Public License (EPL).
 * See the file epl-v10.html for the license text.
 */
package de.cau.cs.kieler.klodd.orthogonal.impl;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import de.cau.cs.kieler.core.alg.AbstractAlgorithm;
import de.cau.cs.kieler.core.slimgraph.KSlimEdge;
import de.cau.cs.kieler.core.slimgraph.KSlimNode;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutEdge;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutNode;
import de.cau.cs.kieler.klodd.orthogonal.structures.*;

/**
 * Algorithm that finds the connected components for a layout graph
 * and outputs them as separate TSM graphs.
 * 
 * @author msp
 */
public class ConnectedComponents extends AbstractAlgorithm {

	/** stack of layout edges for BFS */
	private LinkedList<KLayoutEdge> edgeStack = new LinkedList<KLayoutEdge>();
	/** mapping of layout nodes to TSM nodes */
	private Map<KLayoutNode, KSlimNode> nodeMap = new HashMap<KLayoutNode, KSlimNode>();
	/** mapping of layout edges to TSM edges */
	private Map<KLayoutEdge, KSlimEdge> edgeMap = new HashMap<KLayoutEdge, KSlimEdge>();
	
	/*
	 * (non-Javadoc)
	 * @see de.cau.cs.kieler.klodd.core.algorithms.AbstractAlgorithm#reset()
	 */
	public void reset() {
		super.reset();
		edgeStack.clear();
		nodeMap.clear();
		edgeMap.clear();
	}
	
	/**
	 * Finds the connected components of a layout graph and returns
	 * them as separate TSM graphs.
	 * 
	 * @param parentNode parent layout node
	 * @return list of connected components
	 */
	public List<TSMGraph> findComponents(KLayoutNode parentNode) {
		List<TSMGraph> components = new LinkedList<TSMGraph>();
		
		for (KLayoutNode child : parentNode.getChildNodes()) {
			if (!nodeMap.containsKey(child))
				components.add(findComponent(child));
		}
		return components;
	}
	
	/**
	 * Finds the connected component that contains the given node.
	 * 
	 * @param startLayoutNode node to use as start for the new component
	 * @return a graph representing the connected component
	 */
	private TSMGraph findComponent(KLayoutNode startLayoutNode) {
		TSMGraph graph = new TSMGraph();
		KSlimNode newTsmNode = new TSMNode(graph, TSMNode.Type.LAYOUT, startLayoutNode);
		nodeMap.put(startLayoutNode, newTsmNode);
		edgeStack.addAll(startLayoutNode.getOutgoingEdges());
		edgeStack.addAll(startLayoutNode.getIncomingEdges());
		
		while (!edgeStack.isEmpty()) {
			KLayoutEdge layoutEdge = edgeStack.removeFirst();
			// TODO add support for external ports
			if (layoutEdge.getSource() != null && layoutEdge.getTarget() != null) {
				if (!edgeMap.containsKey(layoutEdge)) {
					KLayoutNode currentLayoutNode = layoutEdge.getSource();
					KSlimNode sourceNode = nodeMap.get(currentLayoutNode);
					if (sourceNode == null) {
						sourceNode = new TSMNode(graph, TSMNode.Type.LAYOUT,
								currentLayoutNode);
						nodeMap.put(currentLayoutNode, sourceNode);
						edgeStack.addAll(currentLayoutNode.getOutgoingEdges());
						edgeStack.addAll(currentLayoutNode.getIncomingEdges());
					}
					currentLayoutNode = layoutEdge.getTarget();
					KSlimNode targetNode = nodeMap.get(currentLayoutNode);
					if (targetNode == null) {
						targetNode = new TSMNode(graph, TSMNode.Type.LAYOUT,
								currentLayoutNode);
						nodeMap.put(currentLayoutNode, targetNode);
						edgeStack.addAll(currentLayoutNode.getOutgoingEdges());
						edgeStack.addAll(currentLayoutNode.getIncomingEdges());
					}
					KSlimEdge tsmEdge = new TSMEdge(graph, sourceNode, targetNode,
							layoutEdge);
					tsmEdge.connectNodes();
					edgeMap.put(layoutEdge, tsmEdge);
				}
			}
		}
		return graph;
	}
	
}

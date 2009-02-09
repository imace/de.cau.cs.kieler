package de.cau.cs.kieler.klodd.orthogonal.impl;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutEdge;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutNode;
import de.cau.cs.kieler.klodd.core.algorithms.AbstractAlgorithm;
import de.cau.cs.kieler.klodd.orthogonal.structures.*;

/**
 * Algorithm that finds the connected components for a layout graph
 * and outputs them as separate TSM graphs.
 * 
 * @author msp
 */
public class ConnectedComponents extends AbstractAlgorithm {

	/** stack of layout edges for BFS */
	private Deque<KLayoutEdge> edgeStack = new LinkedList<KLayoutEdge>();
	/** mapping of layout nodes to TSM nodes */
	private Map<KLayoutNode, TSMNode> nodeMap = new HashMap<KLayoutNode, TSMNode>();
	/** mapping of layout edges to TSM edges */
	private Map<KLayoutEdge, TSMEdge> edgeMap = new HashMap<KLayoutEdge, TSMEdge>();
	
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
		TSMNode newTsmNode = new TSMNode(graph, TSMNode.Type.LAYOUT, startLayoutNode);
		nodeMap.put(startLayoutNode, newTsmNode);
		edgeStack.addAll(startLayoutNode.getOutgoingEdges());
		edgeStack.addAll(startLayoutNode.getIncomingEdges());
		
		while (!edgeStack.isEmpty()) {
			KLayoutEdge layoutEdge = edgeStack.removeFirst();
			// TODO add support for external ports
			if (layoutEdge.getSource() != null && layoutEdge.getTarget() != null) {
				if (!edgeMap.containsKey(layoutEdge)) {
					KLayoutNode currentLayoutNode = layoutEdge.getSource();
					TSMNode sourceNode = nodeMap.get(currentLayoutNode);
					if (sourceNode == null) {
						sourceNode = new TSMNode(graph, TSMNode.Type.LAYOUT,
								currentLayoutNode);
						nodeMap.put(currentLayoutNode, sourceNode);
						edgeStack.addAll(currentLayoutNode.getOutgoingEdges());
						edgeStack.addAll(currentLayoutNode.getIncomingEdges());
					}
					TSMNode targetNode = nodeMap.get(currentLayoutNode);
					if (targetNode == null) {
						targetNode = new TSMNode(graph, TSMNode.Type.LAYOUT,
								currentLayoutNode);
						nodeMap.put(currentLayoutNode, targetNode);
						edgeStack.addAll(currentLayoutNode.getOutgoingEdges());
						edgeStack.addAll(currentLayoutNode.getIncomingEdges());
					}
					TSMEdge tsmEdge = new TSMEdge(graph, sourceNode, targetNode,
							layoutEdge);
					tsmEdge.connectNodes();
					edgeMap.put(layoutEdge, tsmEdge);
				}
			}
		}
		return graph;
	}
	
}

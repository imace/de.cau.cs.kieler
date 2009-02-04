package de.cau.cs.kieler.klodd.orthogonal.impl.ec;

import java.util.HashMap;
import java.util.Map;

import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutEdge;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutNode;
import de.cau.cs.kieler.klodd.core.algorithms.AbstractAlgorithm;
import de.cau.cs.kieler.klodd.orthogonal.modules.IECPlanarizer;
import de.cau.cs.kieler.klodd.orthogonal.structures.*;


/**
 * Planarizer implementation that handles embedding constraints by
 * inserting all edges with an EC edge inserter.
 * 
 * @author msp
 */
public class EdgeInsertionECPlanarizer extends AbstractAlgorithm implements
		IECPlanarizer {

	/** map of embedding constraints */
	private Map<KLayoutNode, EmbeddingConstraint> constraintsMap = null;
	
	/** TSM graph that is currently processed */
	private TSMGraph tsmGraph;
	/** map of layout nodes to corresponding TSM nodes */
	private Map<KLayoutNode, TSMNode> layoutNode2TSMNodeMap;
	/** numbers assigned during DFS */
	private int[] dfsNum;
	/** next DFS number to be assigned */
	private int nextDfsNum;
	
	/*
	 * (non-Javadoc)
	 * @see de.cau.cs.kieler.klodd.core.algorithms.AbstractAlgorithm#reset()
	 */
	public void reset() {
		super.reset();
		constraintsMap = null;
	}
	
	/* (non-Javadoc)
	 * @see de.cau.cs.kieler.klodd.orthogonal.modules.IECPlanarizer#setConstraints(java.util.Map)
	 */
	public void setConstraints(
			Map<KLayoutNode, EmbeddingConstraint> constraintsMap) {
		this.constraintsMap = constraintsMap;
	}

	/* (non-Javadoc)
	 * @see de.cau.cs.kieler.klodd.orthogonal.modules.IPlanarizer#planarize(de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutNode)
	 */
	public TSMGraph planarize(KLayoutNode layoutNode) {
		if (constraintsMap == null)
			throw new IllegalStateException("The method setConstraints() must be called first.");
		
		// build normal graph without edges
		tsmGraph = buildGraph(layoutNode);
		// insert the stored edges, one by one, and preserve planarity
		ECEdgeInserter edgeInserter = new ECEdgeInserter();
		edgeInserter.setGraph(tsmGraph);
		for (TSMEdge edge : tsmGraph.edges) {
			EmbeddingConstraint sourceConstraint = constraintsMap.get(
					edge.source.object);
			EmbeddingConstraint targetConstraint = constraintsMap.get(
					edge.target.object);
			edgeInserter.insertEdge(edge, sourceConstraint, targetConstraint);
		}
		
		return tsmGraph;
	}
	
	/**
	 * Builds a TSM graph from a parent layout node. The edges are inserted
	 * into the local list of edges, but not into the created graph. The
	 * edges are created in the order of a DFS run.
	 * 
	 * @param parentNode parent layout node
	 * @return the new TSM graph
	 */
	private TSMGraph buildGraph(KLayoutNode parentNode) {
		TSMGraph tsmGraph = new TSMGraph();
		// create TSM nodes
		layoutNode2TSMNodeMap = new HashMap<KLayoutNode, TSMNode>();
		for (KLayoutNode child : parentNode.getChildNodes()) {
			TSMNode tsmNode = new TSMNode(tsmGraph, TSMNode.Type.LAYOUT, child);
			layoutNode2TSMNodeMap.put(child, tsmNode);
		}
		// create TSM edges
		int nodeCount = parentNode.getChildNodes().size();
		dfsNum = new int[nodeCount];
		for (int i = 0; i < nodeCount; i++)
			dfsNum[i] = -1;
		nextDfsNum = 0;
		for (KLayoutNode child : parentNode.getChildNodes()) {
			TSMNode childTsmNode = layoutNode2TSMNodeMap.get(child);
			if (dfsNum[childTsmNode.id] < 0)
				dfsVisit(child, childTsmNode);
		}
		return tsmGraph;
	}
	
	/**
	 * Performs a DFS starting at the given node, creating new edges
	 * in the order they are found.
	 * 
	 * @param layoutNode layout node to process
	 * @param tsmNode TSM node that corresponds to the given layout node
	 */
	private void dfsVisit(KLayoutNode layoutNode, TSMNode tsmNode) {
		dfsNum[tsmNode.id] = nextDfsNum++;
		for (KLayoutEdge edge : layoutNode.getOutgoingEdges()) {
			KLayoutNode targetLayoutNode = edge.getTarget();
			// TODO external ports need to be considered
			if (targetLayoutNode != null) {
				TSMNode targetTsmNode = layoutNode2TSMNodeMap.get(targetLayoutNode);
				new TSMEdge(tsmGraph, tsmNode, targetTsmNode);
				if (dfsNum[targetTsmNode.id] < 0) {
					dfsVisit(targetLayoutNode, targetTsmNode);
				}
			}
		}
	}

}

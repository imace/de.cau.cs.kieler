package de.cau.cs.kieler.klodd.orthogonal.impl.ec;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KEdge;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KNodeGroup;
import de.cau.cs.kieler.klodd.core.algorithms.AbstractAlgorithm;
import de.cau.cs.kieler.klodd.orthogonal.modules.IECPlanarizer;
import de.cau.cs.kieler.klodd.orthogonal.structures.*;


/**
 * 
 * @author msp
 */
public class EdgeInsertionECPlanarizer extends AbstractAlgorithm implements
		IECPlanarizer {

	/** map of embedding constraints */
	private Map<KNodeGroup, EmbeddingConstraint> constraintsMap = null;
	/** list of edges that are inserted */
	private List<TSMEdge> edges = new LinkedList<TSMEdge>();
	
	/** map of node groups to corresponding TSM nodes */
	private Map<KNodeGroup, TSMNode> nodeGroup2TSMNodeMap;
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
		edges.clear();
	}
	
	/* (non-Javadoc)
	 * @see de.cau.cs.kieler.klodd.orthogonal.modules.IECPlanarizer#setConstraints(java.util.Map)
	 */
	public void setConstraints(
			Map<KNodeGroup, EmbeddingConstraint> constraintsMap) {
		this.constraintsMap = constraintsMap;
	}

	/* (non-Javadoc)
	 * @see de.cau.cs.kieler.klodd.orthogonal.modules.IPlanarizer#planarize(de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KNodeGroup)
	 */
	public TSMGraph planarize(KNodeGroup nodeGroup) {
		if (constraintsMap == null)
			throw new IllegalStateException("The method setConstraints() must be called first.");
		
		// build normal graph without edges
		TSMGraph tsmGraph = buildGraph(nodeGroup);
		// insert the stored edges, one by one, and preserve planarity
		ECEdgeInserter edgeInserter = new ECEdgeInserter();
		edgeInserter.setGraph(tsmGraph);
		for (TSMEdge edge : edges) {
			EmbeddingConstraint sourceConstraint = constraintsMap.get(
					edge.source.object);
			EmbeddingConstraint targetConstraint = constraintsMap.get(
					edge.target.object);
			edgeInserter.insertEdge(edge, sourceConstraint, targetConstraint);
		}
		
		return tsmGraph;
	}
	
	/**
	 * Builds a TSM graph from a parent node group. The edges are inserted
	 * into the local list of edges, but not into the created graph. The
	 * edges are created in the order of a DFS run.
	 * 
	 * @param parentGroup parent node group
	 * @return the new TSM graph
	 */
	private TSMGraph buildGraph(KNodeGroup parentGroup) {
		TSMGraph tsmGraph = new TSMGraph(parentGroup);
		// create TSM nodes
		nodeGroup2TSMNodeMap = new HashMap<KNodeGroup, TSMNode>();
		for (KNodeGroup child : parentGroup.getSubNodeGroups()) {
			TSMNode tsmNode = new TSMNode(tsmGraph, child);
			nodeGroup2TSMNodeMap.put(child, tsmNode);
		}
		// create TSM edges
		int nodeCount = parentGroup.getSubNodeGroups().size();
		dfsNum = new int[nodeCount];
		for (int i = 0; i < nodeCount; i++)
			dfsNum[i] = -1;
		nextDfsNum = 0;
		for (KNodeGroup child : parentGroup.getSubNodeGroups()) {
			TSMNode childTsmNode = nodeGroup2TSMNodeMap.get(child);
			if (dfsNum[childTsmNode.nr] < 0)
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
	private void dfsVisit(KNodeGroup layoutNode, TSMNode tsmNode) {
		dfsNum[tsmNode.nr] = nextDfsNum++;
		for (KEdge edge : layoutNode.getOutgoingEdges()) {
			KNodeGroup targetLayoutNode = edge.getTarget();
			// TODO external ports need to be considered
			if (targetLayoutNode != null) {
				TSMNode targetTsmNode = nodeGroup2TSMNodeMap.get(targetLayoutNode);
				TSMEdge tsmEdge = new TSMEdge(tsmNode, targetTsmNode);
				edges.add(tsmEdge);
				if (dfsNum[targetTsmNode.nr] < 0) {
					dfsVisit(targetLayoutNode, targetTsmNode);
				}
			}
		}
	}

}

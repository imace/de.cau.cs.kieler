package de.cau.cs.kieler.klodd.orthogonal.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import de.cau.cs.kieler.core.alg.AbstractAlgorithm;
import de.cau.cs.kieler.core.graph.KGraph;
import de.cau.cs.kieler.core.graph.KNode;
import de.cau.cs.kieler.klodd.orthogonal.structures.*;


/**
 * Algorithm that determines the biconnected components of a graph
 * with a DFS.
 * 
 * @author msp
 */
public class BiconnectedComponents extends AbstractAlgorithm {

	/** list of biconnected components calculated by the algorithm */
	private List<GraphSection> components = new LinkedList<GraphSection>();
	/** next DFS number to assign */
	private int nextDfsnum = 0;
	/** list of lowest point numbers */
	private int[] lowpt;
	/** list of parent nodes */
	private KNode[] parent;
	/** stack with unfinished nodes */
	private Stack<KNode> unfinished = new Stack<KNode>();
	
	/*
	 * (non-Javadoc)
	 * @see de.cau.cs.kieler.klodd.core.algorithms.AbstractAlgorithm#reset()
	 */
	public void reset() {
		super.reset();
		components.clear();
		unfinished.clear();
		nextDfsnum = 0;
	}
	
	/**
	 * Calculates the biconnected components of the given graph.
	 * The input graph is considered as undirected.
	 * 
	 * @param graph graph to be processed
	 * @return list of biconnected components
	 */
	public List<GraphSection> findComponents(KGraph graph) {
		// initialize DFS variables
		int graphSize = graph.nodes.size();
		lowpt = new int[graphSize];
		parent = new KNode[graphSize];
		for (KNode node : graph.nodes) {
			node.rank = -1;
		}
		
		// perform DFS on all nodes of the graph
		for (KNode node : graph.nodes) {
			if (node.rank < 0)
				dfsVisit(node);
		}
		
		return components;
	}
	
	/**
	 * Performs a DFS starting at the given node.
	 * 
	 * @param node node to visit
	 */
	private void dfsVisit(KNode node) {
		node.rank = nextDfsnum++;
		lowpt[node.id] = node.rank;
		unfinished.push(node);
		for (KNode.IncEntry edgeEntry : node.incidence) {
			KNode endpoint = edgeEntry.endpoint();
			if (endpoint.rank < 0) {
				parent[endpoint.id] = node;
				dfsVisit(endpoint);
				lowpt[node.id] = Math.min(lowpt[node.id], lowpt[endpoint.id]);
			}
			else {
				lowpt[node.id] = Math.min(lowpt[node.id], endpoint.rank);
			}
		}
		if (node.rank >= 2 && lowpt[node.id] == parent[node.id].rank) {
			GraphSection graphSection = new GraphSection();
			KNode sectionNode;
			do {
				sectionNode = unfinished.pop();
				graphSection.nodes.add(sectionNode);
			} while (sectionNode != node);
			graphSection.nodes.add(parent[node.id]);
			graphSection.sortNodes();
			components.add(graphSection);
		}
	}
	
}

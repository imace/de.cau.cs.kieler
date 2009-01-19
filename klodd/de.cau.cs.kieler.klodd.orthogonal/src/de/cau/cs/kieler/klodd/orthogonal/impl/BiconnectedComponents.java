package de.cau.cs.kieler.klodd.orthogonal.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import de.cau.cs.kieler.klodd.core.algorithms.AbstractAlgorithm;
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
	private TSMNode[] parent;
	/** stack with unfinished nodes */
	private Stack<TSMNode> unfinished = new Stack<TSMNode>();
	
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
	public List<GraphSection> calcComponents(TSMGraph graph) {
		// initialize DFS variables
		int graphSize = graph.nodes.size();
		lowpt = new int[graphSize];
		parent = new TSMNode[graphSize];
		for (TSMNode node : graph.nodes) {
			node.rank = -1;
		}
		
		// perform DFS on all nodes of the graph
		for (TSMNode node : graph.nodes) {
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
	private void dfsVisit(TSMNode node) {
		node.rank = nextDfsnum++;
		lowpt[node.nr] = node.rank;
		unfinished.push(node);
		for (TSMEdge edge : node.edges) {
			TSMNode endpoint = edge.getEndpoint(node);
			if (endpoint.rank < 0) {
				parent[endpoint.nr] = node;
				dfsVisit(endpoint);
				lowpt[node.nr] = Math.min(lowpt[node.nr], lowpt[endpoint.nr]);
			}
			else {
				lowpt[node.nr] = Math.min(lowpt[node.nr], endpoint.rank);
			}
		}
		if (node.rank >= 2 && lowpt[node.nr] == parent[node.nr].rank) {
			GraphSection graphSection = new GraphSection();
			TSMNode sectionNode;
			do {
				sectionNode = unfinished.pop();
				graphSection.nodes.add(sectionNode);
			} while (sectionNode != node);
			graphSection.nodes.add(parent[node.nr]);
			graphSection.sortNodes();
			components.add(graphSection);
		}
	}
	
}

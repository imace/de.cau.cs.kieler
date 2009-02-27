package de.cau.cs.kieler.core.graph.alg;

import java.util.LinkedList;

import de.cau.cs.kieler.core.graph.*;

/**
 * Cycle remover implementation that uses a greedy algorithm.
 * 
 * @author msp
 */
public class GreedyCycleRemover extends AbstractCycleRemover {

	/** indegree values for the nodes */
	private int indeg[];
	/** outdegree values for the nodes */
	private int outdeg[];
	/** list of source nodes */
	LinkedList<KNode> sources = new LinkedList<KNode>();
	/** list of sink nodes */
	LinkedList<KNode> sinks = new LinkedList<KNode>();
	
	/*
	 * (non-Javadoc)
	 * @see de.cau.cs.kieler.core.graph.alg.AbstractCycleRemover#reset()
	 */
	public void reset() {
		super.reset();
		sources.clear();
		sinks.clear();
	}
	
	/* (non-Javadoc)
	 * @see de.cau.cs.kieler.core.graph.alg.ICycleRemover#removeCycles(de.cau.cs.kieler.core.graph.KGraph)
	 */
	public void removeCycles(KGraph graph) {
		getMonitor().begin("Greedy cycle removal", 1);
		reversedEdges = new LinkedList<KEdge>();

		// initialize values for the algorithm
		int unprocessedNodes = graph.nodes.size();
		indeg = new int[unprocessedNodes];
		outdeg = new int[unprocessedNodes];
		int nextRight = -1, nextLeft = 1;
		for (KNode node : graph.nodes) {
			node.rank = 0;
			for (KNode.IncEntry edgeEntry : node.incidence) {
				if (edgeEntry.type == KNode.IncEntry.Type.OUT)
					outdeg[node.id]++;
				else
					indeg[node.id]++;
			}
			if (outdeg[node.id] == 0)
				sinks.add(node);
			else if (indeg[node.id] == 0)
				sources.add(node);
		}
		
		// assign ranks to all nodes
		while (unprocessedNodes > 0) {
			while (!sinks.isEmpty()) {
				KNode sink = sinks.removeFirst();
				sink.rank = nextRight--;
				updateNeighbors(sink);
				unprocessedNodes--;
			}
			while (!sources.isEmpty()) {
				KNode source = sources.removeFirst();
				source.rank = nextLeft++;
				updateNeighbors(source);
				unprocessedNodes--;
			}
			if (unprocessedNodes != 0) {
				int maxOutflow = Integer.MIN_VALUE;
				KNode maxNode = null;
				for (KNode node : graph.nodes) {
					if (node.rank == 0) {
						int outflow = outdeg[node.id] - indeg[node.id];
						if (outflow > maxOutflow) {
							maxOutflow = outflow;
							maxNode = node;
						}
					}
				}
				maxNode.rank = nextLeft++;
				updateNeighbors(maxNode);
				unprocessedNodes--;
			}
		}
		
		// shift negative ranks
		int shiftBase = graph.nodes.size() + 1;
		for (KNode node : graph.nodes)
			if (node.rank < 0)
				node.rank += shiftBase;
		
		// mark edges that point left
		for (KEdge edge : graph.edges) {
			if (edge.source.rank > edge.target.rank)
				reversedEdges.add(edge);
		}
		
		// reverse all marked edges
		reverseEdges();
		
		getMonitor().done();
	}

	/**
	 * Updates indegree and outdegree values of the neighbors of the
	 * given node, simulating its removal from the graph. the sources and
	 * sinks lists are also updated.
	 * 
	 * @param node node for which neighbors are updated
	 */
	private void updateNeighbors(KNode node) {
		for (KNode.IncEntry edgeEntry : node.incidence) {
			KNode endpoint = edgeEntry.endpoint();
			if (endpoint.rank == 0) {
				if (edgeEntry.type == KNode.IncEntry.Type.OUT) {
					indeg[endpoint.id]--;
					if (indeg[endpoint.id] == 0 && outdeg[endpoint.id] != 0)
						sources.add(endpoint);
				}
				else {
					outdeg[endpoint.id]--;
					if (outdeg[endpoint.id] == 0 && indeg[endpoint.id] != 0)
						sinks.add(endpoint);
				}
			}
		}
	}

}

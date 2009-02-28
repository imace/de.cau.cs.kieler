package de.cau.cs.kieler.core.graph.alg;

import java.util.Iterator;
import java.util.LinkedList;

import de.cau.cs.kieler.core.graph.*;

/**
 * Cycle remover that uses a depth first search to remove cycles.
 * 
 * @author msp
 */
public class DFSCycleRemover extends AbstractCycleRemover {

	/** next DFS number to use */
	private int nextDfs;
	
	/*
	 * (non-Javadoc)
	 * @see de.cau.cs.kieler.core.graph.alg.ICycleRemover#removeCycles(de.cau.cs.kieler.core.graph.KGraph)
	 */
	public void removeCycles(KGraph graph) {
		getMonitor().begin("DFS cycle removal", 1);
		reversedEdges = new LinkedList<KEdge>();
		nextDfs = 1;
		
		// initialize node ranks
		for (KNode node : graph.nodes)
			node.rank = -1;
		
		// mark back edges of the DFS run
		Iterator<KNode> nodeIter = graph.nodes.iterator(); 
		while (nodeIter.hasNext()) {
			KNode node = nodeIter.next();
			if (node.rank < 0) {
				// node was not visited yet
				dfsVisit(node);
			}
		}
		// reverse all marked edges
		reverseEdges();
		
		getMonitor().done();
	}
	
	/**
	 * Visits a node in the DFS algorithm. This method is recursive.
	 * 
	 * @param node node to visit
	 */
	private void dfsVisit(KNode node) {
		// put DFS mark on the new node
		node.rank = nextDfs++;
		
		// process all outgoing edges
		for (KNode.IncEntry edgeEntry : node.incidence) {
			if (edgeEntry.type == KNode.IncEntry.Type.OUT) {
				KNode targetNode = edgeEntry.edge.target;
				if (targetNode.rank >= 0) {
					if (targetNode.rank > 0 && targetNode.id != node.id) {
						// a cycle was found, break it
						reversedEdges.add(edgeEntry.edge);
					}
				}
				else {
					// target node was not visited yet
					dfsVisit(targetNode);
					edgeEntry.edge.rank = 0;
				}
			}
		}
		// backtracking: set this node's number to 0
		node.rank = 0;
	}

}

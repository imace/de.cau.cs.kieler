package edu.unikiel.rtsys.klodd.core.algorithms;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KEdge;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KNodeGroup;

/**
 * Cycle remover that uses a depth first search to remove cycles.
 * 
 * @author msp
 */
public class DFSCycleRemover extends AbstractCycleRemover {

	/** map of marked vertices */
	private Map<KNodeGroup, Integer> markedMap = new HashMap<KNodeGroup, Integer>();
	/** next DFS number to use */
	private int nextDfs;
	
	/*
	 * (non-Javadoc)
	 * @see edu.unikiel.rtsys.klodd.core.algorithms.AbstractCycleRemover#reset()
	 */
	public void reset() {
		super.reset();
		markedMap.clear();
	}
	
	/*
	 * (non-Javadoc)
	 * @see edu.unikiel.rtsys.klodd.core.algorithms.ICycleRemover#removeCycles(edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KNodeGroup)
	 */
	public void removeCycles(KNodeGroup parentGroup) {
		Iterator<KNodeGroup> nodeIter = parentGroup.getSubNodeGroups().iterator(); 
		while (nodeIter.hasNext()) {
			KNodeGroup node = nodeIter.next();
			if (markedMap.get(node) == null) {
				// node was not visited yet
				dfsVisit(node);
			}
		}
		// reverse all marked edges
		reverseEdges();
	}
	
	/**
	 * Visits a node group in the DFS algorithm. This method
	 * is recursive.
	 * 
	 * @param node node group to visit
	 */
	private void dfsVisit(KNodeGroup node) {
		// put DFS mark on the new node
		int myDfs = nextDfs++;
		markedMap.put(node, new Integer(myDfs));
		
		// process all outgoing edges
		for (KEdge edge : node.getOutgoingEdges()) {
			KNodeGroup targetNode = edge.getTarget();
			if (targetNode != null) {
				Integer targetDfs = markedMap.get(targetNode);
				if (targetDfs != null) {
					if (targetDfs.intValue() != -1 && targetNode != node) {
						// a cycle was found, break it
						reversedEdges.add(edge);
					}
				}
				else {
					// target node was not visited yet
					dfsVisit(targetNode);
				}
			}
		}
		// backtracking: set this node's number to -1
		markedMap.put(node, new Integer(-1));
	}

}

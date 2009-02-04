package de.cau.cs.kieler.klodd.core.algorithms;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutEdge;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutNode;


/**
 * Cycle remover that uses a depth first search to remove cycles.
 * 
 * @author msp
 */
public class DFSCycleRemover extends AbstractCycleRemover {

	/** map of marked vertices */
	private Map<KLayoutNode, Integer> markedMap = new HashMap<KLayoutNode, Integer>();
	/** next DFS number to use */
	private int nextDfs;
	
	/*
	 * (non-Javadoc)
	 * @see de.cau.cs.kieler.klodd.core.algorithms.AbstractCycleRemover#reset()
	 */
	public void reset() {
		super.reset();
		markedMap.clear();
	}
	
	/*
	 * (non-Javadoc)
	 * @see de.cau.cs.kieler.klodd.core.algorithms.ICycleRemover#removeCycles(de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutNode)
	 */
	public void removeCycles(KLayoutNode parentNode) {
		Iterator<KLayoutNode> nodeIter = parentNode.getChildNodes().iterator(); 
		while (nodeIter.hasNext()) {
			KLayoutNode node = nodeIter.next();
			if (markedMap.get(node) == null) {
				// node was not visited yet
				dfsVisit(node);
			}
		}
		// reverse all marked edges
		reverseEdges();
	}
	
	/**
	 * Visits a layout node in the DFS algorithm. This method
	 * is recursive.
	 * 
	 * @param node layout node to visit
	 */
	private void dfsVisit(KLayoutNode node) {
		// put DFS mark on the new node
		int myDfs = nextDfs++;
		markedMap.put(node, new Integer(myDfs));
		
		// process all outgoing edges
		for (KLayoutEdge edge : node.getOutgoingEdges()) {
			KLayoutNode targetNode = edge.getTarget();
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

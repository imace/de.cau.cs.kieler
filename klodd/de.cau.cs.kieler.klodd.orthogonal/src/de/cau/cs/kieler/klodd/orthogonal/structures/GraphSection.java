package de.cau.cs.kieler.klodd.orthogonal.structures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Section of a TSM graph.
 * 
 * @author msp
 */
public class GraphSection {

	/** nodes of this graph section, sorted by their creation number */
	public List<TSMNode> nodes = new ArrayList<TSMNode>();
	
	/** list of edges that were removed */
	private List<TSMEdge> removedEdges = new LinkedList<TSMEdge>();

	/**
	 * Sorts the nodes of this graph section. This method must be called
	 * prior to any use of <code>contains(TSMNode)</code>.
	 */
	public void sortNodes() {
		Collections.sort(nodes);
	}
	
	/**
	 * Checks whether this graph section contains the given node by
	 * performing a binary search in the sorted list of contained nodes.
	 * 
	 * @param node node to lookup
	 * @return true if the given node is contained in <code>nodes</code>
	 */
	public boolean contains(TSMNode node) {
		int start = 0, end = nodes.size(), pos;
		while (start != end) {
			pos = start + (end - start) / 2;
			int currentNr = nodes.get(pos).nr;
			if (node.nr < currentNr)
				end = pos;
			else if (node.nr > currentNr)
				start = pos + 1;
			else return true;
		}
		return false;
	}
	
	/**
	 * Removes the given edge from the incidence lists of its source
	 * and target.
	 * 
	 * @param edge edge to remove from this graph section.
	 */
	public void removeEdge(TSMEdge edge) {
		edge.source.edges.remove(edge);
		edge.target.edges.remove(edge);
		removedEdges.add(edge);
	}
	
	/**
	 * Restores all edges that were removed.
	 */
	public void restoreEdges() {
		for (TSMEdge edge : removedEdges) {
			edge.source.edges.add(edge);
			edge.target.edges.add(edge);
		}
		removedEdges.clear();
	}
	
}

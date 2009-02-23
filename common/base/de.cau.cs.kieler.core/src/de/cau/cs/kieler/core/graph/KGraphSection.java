package de.cau.cs.kieler.core.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


/**
 * Section of a TSM graph.
 * TODO change the whole concept of subgraphs! this approach here is not good
 * 
 * @author msp
 */
public class KGraphSection {

	/** nodes of this graph section, sorted by their creation number */
	public List<KNode> nodes = new ArrayList<KNode>();
	
	/** list of edges that were removed */
	private List<KEdge> removedEdges = new LinkedList<KEdge>();

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
	public boolean contains(KNode node) {
		int start = 0, end = nodes.size(), pos;
		while (start != end) {
			pos = start + (end - start) / 2;
			int currentNr = nodes.get(pos).id;
			if (node.id < currentNr)
				end = pos;
			else if (node.id > currentNr)
				start = pos + 1;
			else return true;
		}
		return false;
	}
	
	/**
	 * Removes the given edge from the incidence lists of its source
	 * and target.
	 * 
	 * @param edgeEntry edge entry to remove from this graph section
	 */
	public void removeEdge(KNode.IncEntry edgeEntry) {
		edgeEntry.edge.source.incidence.remove(edgeEntry);
		edgeEntry.edge.target.incidence.remove(edgeEntry);
		removedEdges.add(edgeEntry.edge);
	}
	
	/**
	 * Restores all edges that were removed.
	 */
	public void restoreEdges() {
		for (KEdge edge : removedEdges) {
			edge.connectNodes();
		}
		removedEdges.clear();
	}
	
}

package de.cau.cs.kieler.klodd.orthogonal.impl;

import java.util.LinkedList;
import java.util.List;

import de.cau.cs.kieler.klodd.core.algorithms.AbstractAlgorithm;
import de.cau.cs.kieler.klodd.orthogonal.modules.ICompacter;
import de.cau.cs.kieler.klodd.orthogonal.structures.*;

/**
 * Compacter implementation that performs fast compaction for refined
 * orthogonal representations using topological numbering. This compacter
 * determines only abstract positions instead of concrete positions.
 * 
 * @author msp
 */
public class LayeringCompacter extends AbstractAlgorithm implements
		ICompacter {

	/**
	 * Structure describing a horizontal or vertical bar used for
	 * topological numbering.
	 */
	private class TopoBar {
		/** list of nodes contained in this bar */
		List<TSMNode> nodes = new LinkedList<TSMNode>();
		/** rank of this bar obtained by topological numbering */
		int rank = -1;
	}
	
	/** array of horizontal or vertical bars */
	private TopoBar[] topoBars;
	
	/*
	 * (non-Javadoc)
	 * @see de.cau.cs.kieler.klodd.orthogonal.modules.ICompacter#compact(de.cau.cs.kieler.klodd.orthogonal.structures.TSMGraph, float)
	 */
	public void compact(TSMGraph graph, float minDist) {
		// determine horizontal numbering: build vertical bars
		int maxXrank = 0;
		buildTopoBars(graph, false);
		for (TopoBar topoBar : topoBars) {
			if (topoBar.rank < 0)
				visit(topoBar, TSMNode.Side.WEST);
			for (TSMNode node : topoBar.nodes)
				node.abstrXpos = topoBar.rank;
			maxXrank = Math.max(maxXrank, topoBar.rank);
		}
		graph.width = maxXrank + 1;
		
		// determine vertical numbering: build horizontal bars
		int maxYrank = 0;
		buildTopoBars(graph, true);
		for (TopoBar topoBar : topoBars) {
			if (topoBar.rank < 0)
				visit(topoBar, TSMNode.Side.NORTH);
			for (TSMNode node : topoBar.nodes)
				node.abstrYpos = topoBar.rank;
			maxYrank = Math.max(maxYrank, topoBar.rank);
		}
		graph.height = maxYrank + 1;
	}
	
	/**
	 * Constructs all bars for a given orientation, horizontal or vertical.
	 * 
	 * @param graph graph for which bars are created
	 * @param horizontal if true, horizontal bars are created
	 * @return a list of bars for topological numbering
	 */
	private void buildTopoBars(TSMGraph graph, boolean horizontal) {
		// reset node ranks
		for (TSMNode node : graph.nodes)
			node.rank = -1;
		
		int currentIndex = 0;
		List<TopoBar> topoBarList = new LinkedList<TopoBar>();
		for (TSMNode node : graph.nodes) {
			if (node.rank < 0)
				topoBarList.add(getTopoBar(node, horizontal, currentIndex++));
		}
		topoBars = topoBarList.toArray(new TopoBar[0]);
	}
	
	/**
	 * Constructs a bar for the given node.
	 * 
	 * @param node first node included in the new bar
	 * @param horizontal if true, a horizontal bar is constructed
	 * @param index index of the constructed bar
	 * @return a horizontal or vertical bar
	 */
	private TopoBar getTopoBar(TSMNode node, boolean horizontal, int index) {
		TopoBar topoBar = new TopoBar();
		topoBar.nodes.add(node);
		node.rank = index;
		
		TSMNode currentNode = node;
		TSMNode.Side direction = horizontal ? TSMNode.Side.EAST
				: TSMNode.Side.SOUTH;
		while ((currentNode = nextNode(currentNode, direction)) != null) {
			topoBar.nodes.add(currentNode);
			currentNode.rank = index;
		}
		currentNode = node;
		direction = horizontal ? TSMNode.Side.WEST : TSMNode.Side.NORTH;
		while ((currentNode = nextNode(currentNode, direction)) != null) {
			topoBar.nodes.add(currentNode);
			currentNode.rank = index;
		}
		return topoBar;
	}
	
	/**
	 * Returns the first endpoint of an edge that is incident at the
	 * given side for the given node. For a normalized graph there
	 * is at most one such node.
	 * 
	 * @param node the node
	 * @param side the side
	 * @return the first node adjacent on the side of the node
	 */
	private TSMNode nextNode(TSMNode node, TSMNode.Side side) {
		for (TSMNode.IncEntry edgeEntry : node.incidence) {
			if (edgeEntry.side() == side)
				return edgeEntry.endpoint();
		}
		return null;
	}

	/**
	 * Visit a bar: determine its rank by finding the longest path to
	 * the single source bar.
	 * 
	 * @param topoBar bar to process
	 * @param direction direction to go for the source
	 */
	private void visit(TopoBar topoBar, TSMNode.Side direction) {
		int minRank = 0;
		for (TSMNode node : topoBar.nodes) {
			TSMNode connectedNode = nextNode(node, direction);
			if (connectedNode != null) {
				TopoBar connectedBar = topoBars[connectedNode.rank];
				if (connectedBar.rank < 0)
					visit(connectedBar, direction);
				minRank = Math.max(minRank, connectedBar.rank + 1);
			}
		}
		topoBar.rank = minRank;
	}

}

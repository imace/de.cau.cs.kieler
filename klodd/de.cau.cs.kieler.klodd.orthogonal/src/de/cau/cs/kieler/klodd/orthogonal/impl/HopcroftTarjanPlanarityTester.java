package de.cau.cs.kieler.klodd.orthogonal.impl;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Stack;

import de.cau.cs.kieler.core.alg.AbstractAlgorithm;
import de.cau.cs.kieler.core.graph.KEdge;
import de.cau.cs.kieler.core.graph.KNode;
import de.cau.cs.kieler.klodd.core.util.ConcatenableList;
import de.cau.cs.kieler.klodd.orthogonal.modules.IPlanarityTester;
import de.cau.cs.kieler.klodd.orthogonal.structures.*;


/**
 * Implementation of the Hopcroft & Tarjan planarity test.
 * 
 * @author msp
 */
public class HopcroftTarjanPlanarityTester extends AbstractAlgorithm implements
		IPlanarityTester {

	/** rank value used for tree edges */
	private static final int TREE_EDGE = 1;
	/** rank value used for back edges */
	private static final int BACK_EDGE = 0;
	
	/** the biconnected section that is being processed */
	private GraphSection biconnectedSection;
	/** the next DFS number that is assigned */
	private int nextDfsnum = 0;
	/** the lowest point values */
	private int[] lowpt;
	/** the second lowest point values */
	private int[] lowpt2;
	
	/*
	 * (non-Javadoc)
	 * @see de.cau.cs.kieler.klodd.core.algorithms.AbstractAlgorithm#reset()
	 */
	public void reset() {
		super.reset();
		nextDfsnum = 0;
	}
	
	/* (non-Javadoc)
	 * @see de.cau.cs.kieler.klodd.orthogonal.modules.IPlanarityTester#isPlanar(de.cau.cs.kieler.klodd.orthogonal.structures.GraphSection)
	 */
	public boolean isPlanar(GraphSection biconnectedSection) {
		int sectionSize = biconnectedSection.nodes.size();
		this.biconnectedSection = biconnectedSection;
		this.lowpt = new int[sectionSize];
		this.lowpt2 = new int[sectionSize];
		
		// initialize DFS numbers of each node
		for (KNode node : biconnectedSection.nodes) {
			node.rank = -1;
		}
		// perform DFS on the biconnected section
		KNode node0 = biconnectedSection.nodes.get(0);
		int edgeCount = dfsVisit(node0);
		
		// check number of edges: if the graph is planar, then m <= 3*n - 6
		if (edgeCount > 3 * biconnectedSection.nodes.size() - 6)
			return false;
		
		// reorder all edges of the biconnected section according to lowpt values
		reorderEdges();
		
		// the first edge of the first DFS node is used as start for
		// the recursive subroutine
		KEdge edge0 = node0.incidence.get(0).edge;
		List<KNode> attachments = stronglyPlanar(edge0, node0);
		
		return attachments != null;
	}
	
	/**
	 * Performs a DFS starting with the given node. Each edge is declared
	 * as tree edge or back edge.
	 * 
	 * @param node node to processed
	 * @return number of edges found in the subgraph starting at <code>node</code
	 */
	private int dfsVisit(KNode node) {
		int edgeCount = 0;
		node.rank = nextDfsnum++;
		lowpt[node.rank] = node.rank;
		lowpt2[node.rank] = node.rank;
		List<KNode.IncEntry> edgesToRemove = null;
		for (KNode.IncEntry edgeEntry : node.incidence) {
			KNode endpoint = edgeEntry.endpoint();
			if (biconnectedSection.contains(endpoint)) {
				if (endpoint.rank < 0) {
					edgeEntry.edge.rank = TREE_EDGE;
					edgeCount = dfsVisit(endpoint) + 1;
					if (lowpt[endpoint.rank] < lowpt[node.rank]) {
						lowpt2[node.rank] = lowpt[node.rank];
						lowpt[node.rank] = lowpt[endpoint.rank];
					}
				}
				else if (endpoint.rank >= node.rank) {
					edgeEntry.edge.rank = BACK_EDGE;
					edgeCount++;
					if (node.rank < lowpt[endpoint.rank]) {
						lowpt2[endpoint.rank] = lowpt[endpoint.rank];
						lowpt[endpoint.rank] = node.rank;
					}
				}
			}
			else {
				if (edgesToRemove == null)
					edgesToRemove = new LinkedList<KNode.IncEntry>();
				edgesToRemove.add(edgeEntry);
			}
		}
		// remove marked edges
		if (edgesToRemove != null) {
			for (KNode.IncEntry edgeEntry : edgesToRemove) {
				biconnectedSection.removeEdge(edgeEntry);
			}
		}
		return edgeCount;
	}
	
	/**
	 * Reorders all edges of the biconnected section according to
	 * some rules on the <code>lowpt</code> and <code>lowpt2</code> values.
	 */
	private void reorderEdges() {
		for (final KNode node : biconnectedSection.nodes) {
			Collections.sort(node.incidence, new Comparator<KNode.IncEntry>() {
				public int compare(KNode.IncEntry edge1, KNode.IncEntry edge2) {
					int value1 = value(edge1);
					int value2 = value(edge2);
					return value1 > value2 ? 1
							: (value1 < value2 ? -1
							: 0);
				}
				private int value(KNode.IncEntry edgeEntry) {
					KNode endpoint = edgeEntry.endpoint();
					if (edgeEntry.edge.rank == TREE_EDGE) {
						if (node.rank < endpoint.rank) {
							if (lowpt2[endpoint.rank] >= node.rank)
								return 2 * lowpt[endpoint.rank];
							else
								return 2 * lowpt[endpoint.rank] + 1;
						}
						else return Integer.MAX_VALUE;
					}
					else {
						assert edgeEntry.edge.rank == BACK_EDGE;
						if (node.rank >= endpoint.rank)
							return 2 * endpoint.rank;
						else return Integer.MAX_VALUE;
					}
				}
			});
		}
	}
	
	/**
	 * Object representing a connected component of the interlacing graph
	 * associated with the current step in the algorithm.
	 */
	private static class InterlacingBlock {
		ConcatenableList<KNode> left, right;
		
		InterlacingBlock(ConcatenableList<KNode> left,
				ConcatenableList<KNode> right) {
			this.left = left;
			this.right = right;
		}
	}
	
	/**
	 * Checks whether the segment S(edge0) is strongly planar. This
	 * algorithm is taken from chapter 4 of
	 * <p>
	 * K. Mehlhorn, <i>Data Structures and Efficient Algorithms</i>, Springer
	 * Verlag, EATCS Monographs, 1984
	 * 
	 * @param edge0 the edge from which the next cycle is constructed
	 * @param x0 the first endpoint of the edge <code>edge0 = (x0, y0)</code>
	 * @return ordered list of attachments to the new cycle, or null if the
	 *     current segment is not strongly planar 
	 */
	private ConcatenableList<KNode> stronglyPlanar(KEdge edge0, KNode x0) {
		KNode y0;
		if (edge0.source.id == x0.id)
			y0 = edge0.target;
		else {
			assert edge0.target.id == x0.id;
			y0 = edge0.source;
		}
		// construct the spine of a cycle that starts at (x0, y0)
		LinkedList<KNode> spine = buildSpine(x0, y0);
		spine.addFirst(x0);
		
		Stack<InterlacingBlock> blockStack = new Stack<InterlacingBlock>();
		ListIterator<KNode> spineIter = spine.listIterator(spine.size());
		while (spineIter.previousIndex() > 0) {
			KNode spineNode = spineIter.previous();
			ListIterator<KNode.IncEntry> edgeIter = spineNode.incidence.listIterator(1);
			while (edgeIter.hasNext()) {
				KNode.IncEntry emanatingEdge = edgeIter.next();
				KNode nextNode = emanatingEdge.endpoint();
				// check whether the current edge is taken in the proper direction
				if (emanatingEdge.edge.rank == TREE_EDGE
						&& nextNode.rank > spineNode.rank
						|| emanatingEdge.edge.rank == BACK_EDGE
						&& nextNode.rank <= spineNode.rank) {
					// recursive check of strong planarity
					ConcatenableList<KNode> attachments =
						stronglyPlanar(emanatingEdge.edge, spineNode);
					if (attachments == null)
						return null;
					// update the stack of interlacing blocks
					int lowpte;
					if (emanatingEdge.edge.rank == BACK_EDGE)
						lowpte = nextNode.rank;
					else
						lowpte = lowpt[nextNode.rank];
					attachments.remove(spineNode);
					boolean nonPlanar = updateBlockStack(blockStack,
							attachments, lowpte);
					if (nonPlanar)
						return null;
				}
				// all non-proper edges were put to the end of the incidence list
				else break;
			}
			KNode previousNode = spineIter.previous();
			while (!blockStack.isEmpty()) {
				InterlacingBlock block = blockStack.peek();
				int leftMax = block.left.isEmpty() ? -1 : block.left.getLast().rank;
				int rightMax = block.right.isEmpty() ? -1 : block.right.getLast().rank;
				if (Math.max(leftMax, rightMax) != previousNode.rank)
					break;
				block.left.removeLast();
				block.right.removeLast();
				if (block.left.isEmpty() && block.right.isEmpty()) {
					blockStack.pop();
				}
			}
			spineIter.next();
		}
		
		// compute list of attachments for the given edge
		ConcatenableList<KNode> attachments = new ConcatenableList<KNode>();
		int w1 = lowpt[y0.rank] + 1;
		for (InterlacingBlock block : blockStack) {
			int leftMax = block.left.isEmpty() ? -1 : block.left.getLast().rank;
			int rightMax = block.right.isEmpty() ? -1 : block.right.getLast().rank;
			if (leftMax >= w1 && rightMax >= w1)
				return null;
			if (leftMax >= w1) {
				attachments.addAll(block.right);
				attachments.addAll(block.left);
			}
			else {
				attachments.addAll(block.left);
				attachments.addAll(block.right);
			}
		}
		return attachments;
	}

	/**
	 * Builds the spine of a cycle on the edge (x0, y0).
	 * 
	 * @param x0 first node of the edge on which a spine is built
	 * @param y0 second node of the edge on which a spine is built
	 * @return list of nodes in the spine of the created cycle
	 */
	private LinkedList<KNode> buildSpine(KNode x0, KNode y0) {
		LinkedList<KNode> spine = new LinkedList<KNode>();
		KNode nextNode = y0;
		while (nextNode.rank > x0.rank) {
			spine.addLast(nextNode);
			nextNode = nextNode.incidence.get(0).endpoint();
		}
		return spine;
	}
	
	/**
	 * Updates the block stack for the strong planarity algorithm.
	 * 
	 * @param blockStack stack of connected components of the interlacing graph
	 * @param attachments list of attachment nodes found in the last recursive call
	 * @param lowpte lowpt value of the last used edge
	 * @return true if evidence for non-planarity was found
	 */
	private boolean updateBlockStack(Stack<InterlacingBlock> blockStack,
			ConcatenableList<KNode> attachments, int lowpte) {
		LinkedList<InterlacingBlock> poppedBlocks = new LinkedList<InterlacingBlock>();
		while (!blockStack.isEmpty()) {
			InterlacingBlock block = blockStack.peek();
			int leftMax = block.left.isEmpty() ? -1 : block.left.getLast().rank;
			int rightMax = block.right.isEmpty() ? -1 : block.right.getLast().rank;
			if (Math.max(leftMax, rightMax) <= lowpte)
				break;
			if (leftMax > lowpte) {
				ConcatenableList<KNode> temp = block.left;
				block.left = block.right;
				block.right = temp;
			}
			if (leftMax > lowpte) {
				return true;
			}
			poppedBlocks.addLast(blockStack.pop());
		}
		ConcatenableList<KNode> newLeft = new ConcatenableList<KNode>();
		ConcatenableList<KNode> newRight = new ConcatenableList<KNode>();
		for (InterlacingBlock block : poppedBlocks) {
			newLeft.concatenate(block.left);
			newRight.concatenate(block.right);
		}
		newLeft.concatenate(attachments);
		blockStack.push(new InterlacingBlock(newLeft, newRight));
		return false;
	}

}

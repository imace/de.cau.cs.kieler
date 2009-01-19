package edu.unikiel.rtsys.klodd.orthogonal.impl;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Stack;

import edu.unikiel.rtsys.klodd.core.algorithms.AbstractAlgorithm;
import edu.unikiel.rtsys.klodd.core.util.ConcatenableList;
import edu.unikiel.rtsys.klodd.orthogonal.modules.IPlanarityTester;
import edu.unikiel.rtsys.klodd.orthogonal.structures.*;

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
	 * @see edu.unikiel.rtsys.klodd.core.algorithms.AbstractAlgorithm#reset()
	 */
	public void reset() {
		super.reset();
		nextDfsnum = 0;
	}
	
	/* (non-Javadoc)
	 * @see edu.unikiel.rtsys.klodd.orthogonal.modules.IPlanarityTester#isPlanar(edu.unikiel.rtsys.klodd.orthogonal.structures.GraphSection)
	 */
	public boolean isPlanar(GraphSection biconnectedSection) {
		int sectionSize = biconnectedSection.nodes.size();
		this.biconnectedSection = biconnectedSection;
		this.lowpt = new int[sectionSize];
		this.lowpt2 = new int[sectionSize];
		
		// initialize DFS numbers of each node
		for (TSMNode node : biconnectedSection.nodes) {
			node.rank = -1;
		}
		// perform DFS on the biconnected section
		TSMNode node0 = biconnectedSection.nodes.get(0);
		int edgeCount = dfsVisit(node0);
		
		// check number of edges: if the graph is planar, then m <= 3*n - 6
		if (edgeCount > 3 * biconnectedSection.nodes.size() - 6)
			return false;
		
		// reorder all edges of the biconnected section according to lowpt values
		reorderEdges();
		
		// the first edge of the first DFS node is used as start for
		// the recursive subroutine
		TSMEdge edge0 = node0.edges.get(0);
		List<TSMNode> attachments = stronglyPlanar(edge0, node0);
		
		return attachments != null;
	}
	
	/**
	 * Performs a DFS starting with the given node. Each edge is declared
	 * as tree edge or back edge.
	 * 
	 * @param node node to processed
	 * @return number of edges found in the subgraph starting at <code>node</code
	 */
	private int dfsVisit(TSMNode node) {
		int edgeCount = 0;
		node.rank = nextDfsnum++;
		lowpt[node.rank] = node.rank;
		lowpt2[node.rank] = node.rank;
		List<TSMEdge> edgesToRemove = null;
		for (TSMEdge edge : node.edges) {
			TSMNode endpoint = edge.getEndpoint(node);
			if (biconnectedSection.contains(endpoint)) {
				if (endpoint.rank < 0) {
					edge.rank = TREE_EDGE;
					edgeCount = dfsVisit(endpoint) + 1;
					if (lowpt[endpoint.rank] < lowpt[node.rank]) {
						lowpt2[node.rank] = lowpt[node.rank];
						lowpt[node.rank] = lowpt[endpoint.rank];
					}
				}
				else if (endpoint.rank >= node.rank) {
					edge.rank = BACK_EDGE;
					edgeCount++;
					if (node.rank < lowpt[endpoint.rank]) {
						lowpt2[endpoint.rank] = lowpt[endpoint.rank];
						lowpt[endpoint.rank] = node.rank;
					}
				}
			}
			else {
				if (edgesToRemove == null)
					edgesToRemove = new LinkedList<TSMEdge>();
				edgesToRemove.add(edge);
			}
		}
		// remove marked edges
		if (edgesToRemove != null) {
			for (TSMEdge edge : edgesToRemove) {
				biconnectedSection.removeEdge(edge);
			}
		}
		return edgeCount;
	}
	
	/**
	 * Reorders all edges of the biconnected section according to
	 * some rules on the <code>lowpt</code> and <code>lowpt2</code> values.
	 */
	private void reorderEdges() {
		for (final TSMNode node : biconnectedSection.nodes) {
			Collections.sort(node.edges, new Comparator<TSMEdge>() {
				public int compare(TSMEdge edge1, TSMEdge edge2) {
					int value1 = value(edge1);
					int value2 = value(edge2);
					return value1 > value2 ? 1
							: (value1 < value2 ? -1
							: 0);
				}
				private int value(TSMEdge edge) {
					TSMNode endpoint = edge.getEndpoint(node);
					if (edge.rank == TREE_EDGE) {
						if (node.rank < endpoint.rank) {
							if (lowpt2[endpoint.rank] >= node.rank)
								return 2 * lowpt[endpoint.rank];
							else
								return 2 * lowpt[endpoint.rank] + 1;
						}
						else return Integer.MAX_VALUE;
					}
					else {
						assert edge.rank == BACK_EDGE;
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
		ConcatenableList<TSMNode> left, right;
		
		InterlacingBlock(ConcatenableList<TSMNode> left,
				ConcatenableList<TSMNode> right) {
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
	private ConcatenableList<TSMNode> stronglyPlanar(TSMEdge edge0, TSMNode x0) {
		TSMNode y0 = edge0.getEndpoint(x0);
		// construct the spine of a cycle that starts at (x0, y0)
		LinkedList<TSMNode> spine = buildSpine(x0, y0);
		spine.addFirst(x0);
		
		Stack<InterlacingBlock> blockStack = new Stack<InterlacingBlock>();
		ListIterator<TSMNode> spineIter = spine.listIterator(spine.size());
		while (spineIter.previousIndex() > 0) {
			TSMNode spineNode = spineIter.previous();
			ListIterator<TSMEdge> edgeIter = spineNode.edges.listIterator(1);
			while (edgeIter.hasNext()) {
				TSMEdge emanatingEdge = edgeIter.next();
				TSMNode nextNode = emanatingEdge.getEndpoint(spineNode);
				// check whether the current edge is taken in the proper direction
				if (emanatingEdge.rank == TREE_EDGE && nextNode.rank > spineNode.rank
						|| emanatingEdge.rank == BACK_EDGE && nextNode.rank <= spineNode.rank) {
					// recursive check of strong planarity
					ConcatenableList<TSMNode> attachments = stronglyPlanar(emanatingEdge, spineNode);
					if (attachments == null)
						return null;
					// update the stack of interlacing blocks
					int lowpte;
					if (emanatingEdge.rank == BACK_EDGE)
						lowpte = nextNode.rank;
					else
						lowpte = lowpt[nextNode.rank];
					attachments.remove(spineNode);
					boolean nonPlanar = updateBlockStack(blockStack, attachments, lowpte);
					if (nonPlanar)
						return null;
				}
				// all non-proper edges were put to the end of the incidence list
				else break;
			}
			TSMNode previousNode = spineIter.previous();
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
		ConcatenableList<TSMNode> attachments = new ConcatenableList<TSMNode>();
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
	private LinkedList<TSMNode> buildSpine(TSMNode x0, TSMNode y0) {
		LinkedList<TSMNode> spine = new LinkedList<TSMNode>();
		TSMNode nextNode = y0;
		while (nextNode.rank > x0.rank) {
			spine.addLast(nextNode);
			TSMEdge edge = nextNode.edges.get(0);
			nextNode = edge.getEndpoint(nextNode);
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
			ConcatenableList<TSMNode> attachments, int lowpte) {
		LinkedList<InterlacingBlock> poppedBlocks = new LinkedList<InterlacingBlock>();
		while (!blockStack.isEmpty()) {
			InterlacingBlock block = blockStack.peek();
			int leftMax = block.left.isEmpty() ? -1 : block.left.getLast().rank;
			int rightMax = block.right.isEmpty() ? -1 : block.right.getLast().rank;
			if (Math.max(leftMax, rightMax) <= lowpte)
				break;
			if (leftMax > lowpte) {
				ConcatenableList<TSMNode> temp = block.left;
				block.left = block.right;
				block.right = temp;
			}
			if (leftMax > lowpte) {
				return true;
			}
			poppedBlocks.addLast(blockStack.pop());
		}
		ConcatenableList<TSMNode> newLeft = new ConcatenableList<TSMNode>();
		ConcatenableList<TSMNode> newRight = new ConcatenableList<TSMNode>();
		for (InterlacingBlock block : poppedBlocks) {
			newLeft.concatenate(block.left);
			newRight.concatenate(block.right);
		}
		newLeft.concatenate(attachments);
		blockStack.push(new InterlacingBlock(newLeft, newRight));
		return false;
	}

}

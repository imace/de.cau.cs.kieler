package de.cau.cs.kieler.klodd.orthogonal.impl.ec;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Queue;

import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KEdge;
import de.cau.cs.kieler.klodd.core.algorithms.AbstractAlgorithm;
import de.cau.cs.kieler.klodd.orthogonal.structures.*;

/**
 * Algorithm that inserts an edge into a planar embedding and creates a
 * new planar embedding according to embedding constraints.
 * 
 * @author msp
 */
public class ECEdgeInserter extends AbstractAlgorithm {

	/**
	 * Admissible placing of an edge.
	 */
	private class EdgePlacing {
		/** rank of this placing in the clockwise order of edges */
		int rank;
		/** face related to this placing */
		TSMFace face = null;
		
		/**
		 * Creates an edge placing with given rank.
		 * @param rank the rank
		 */
		EdgePlacing(int rank) {
			this.rank = rank;
		}
	}
	
	/**
	 * Entry of a path in the dual graph.
	 */
	private class DualPathEntry {
		/** the edge to take for this entry of a path */
		TSMEdge edge;
		/** the target face of the edge*/
		TSMFace targetFace;
		
		/**
		 * Creates a dual path entry with given edge and target face.
		 * @param edge the edge
		 * @param targetFace the target face
		 */
		DualPathEntry(TSMEdge edge, TSMFace targetFace) {
			this.edge = edge;
			this.targetFace = targetFace;
		}
	}
	
	/**
	 * A path in the dual graph.
	 */
	private class DualPath {
		/** the path consists of entries with crossed edges */
		List<DualPathEntry> entries = null;
		/** edge placing for insertion at source */
		EdgePlacing sourcePlacing;
		/** edge placing for insertion at target */
		EdgePlacing targetPlacing;
	}
	
	/**
	 * Object returned as result of recursive constraint analysis.
	 */
	private class ConstraintResult {
		/** number of edges that are already placed */
		int edgeCount = 0;
		/** rank of the first edge */
		int firstEdgeRank = 0;
		/** set of admissible placings */
		List<EdgePlacing> placings = null;
	}
	
	/** TSM graph that is currently processed */
	private TSMGraph graph = null;
	
	/*
	 * (non-Javadoc)
	 * @see de.cau.cs.kieler.klodd.core.algorithms.AbstractAlgorithm#reset()
	 */
	public void reset() {
		super.reset();
		graph = null;
	}
	
	/**
	 * Sets the graph in which edges are inserted.
	 * 
	 * @param graph TSM graph
	 */
	public void setGraph(TSMGraph graph) {
		this.graph = graph;
	}
	
	/**
	 * Inserts an edge into the given graph, preserving its planarity.
	 * The new edge is assumed to already exist in the graph's list of edges.
	 * The graph must have a planar embedding, i.e. each existing edge
	 * has its corresponding left and right face. Planarity is preserved
	 * by creating new nodes to avoid crossings.
	 * 
	 * @param edge edge to be inserted
	 * @param sourceConstraint embedding constraint at the source
	 * @param targetConstraint embedding constraint at the target
	 */
	public void insertEdge(TSMEdge edge, EmbeddingConstraint sourceConstraint,
			EmbeddingConstraint targetConstraint) {
		if (graph == null)
			throw new IllegalStateException("The method setGraph() must be called first.");
		
		// determine the admissible placings at source and target
		List<EdgePlacing> sourcePlacings = getEdgePlacings(edge,
				edge.source, sourceConstraint);
		List<EdgePlacing> targetPlacings = getEdgePlacings(edge,
				edge.target, targetConstraint);
		// determine a shortest path from a source face to a target face
		DualPath path = shortestPath(edge, sourcePlacings, targetPlacings);
		// insert the edge through the new path
		insertEdge(edge, path);
	}
	
	/**
	 * Determines the set of placings that can be used for an edge under
	 * certain embedding constraints.
	 * 
	 * @param insEdge edge that is to be inserted
	 * @param node node incident with <code>edge</code>
	 * @param constraint embedding constraint for <code>node</code>
	 * @return array of placings that are admissible for the given edge
	 */
	private List<EdgePlacing> getEdgePlacings(TSMEdge insEdge, TSMNode node,
			EmbeddingConstraint constraint) {
		int placingsCount = node.edges.size();
		if (placingsCount <= 1) {
			EdgePlacing placing = new EdgePlacing(0);
			if (placingsCount == 0)
				// TODO find an initial face more intelligently
				placing.face = graph.externalFace;
			List<EdgePlacing> placings = new LinkedList<EdgePlacing>();
			placings.add(placing);
			return placings;
		}
		else {
			// assign ranks to already placed edges
			Map<KEdge, TSMEdge> edgeMap = new HashMap<KEdge, TSMEdge>();
			int nextRank = 0;
			for (TSMEdge tsmEdge : node.edges) {
				tsmEdge.rank = nextRank++;
				edgeMap.put(tsmEdge.layoutEdge, tsmEdge);
			}
			// the edge that is to be inserted gets a negative rank
			insEdge.rank = -1;
			edgeMap.put(insEdge.layoutEdge, insEdge);
			
			// traverse the constraint tree recursively
			ConstraintResult constraintResult = analyzeConstraint(edgeMap,
					constraint);
			return constraintResult.placings;
		}
	}
	
	/**
	 * Analyzes a given constraint by traversing its constraint tree
	 * recursively and collecting information. This is used to get
	 * the set of admissible placements for an edge.
	 * 
	 * @param edgeMap map of layout edges to corresponding TSM edges
	 * @param constraint embedding constraint to analyze
	 * @return constraint information with a list of admissible placements
	 */
	private ConstraintResult analyzeConstraint(Map<KEdge, TSMEdge> edgeMap,
			EmbeddingConstraint constraint) {
		ConstraintResult result = new ConstraintResult();
		switch (constraint.type) {
		case EDGE:
			KEdge layoutEdge = (KEdge)constraint.object;
			TSMEdge tsmEdge = edgeMap.get(layoutEdge);
			if (tsmEdge != null) {
				if (tsmEdge.rank < 0) {
					// the insertion edge was found
					result.placings = new LinkedList<EdgePlacing>();
					result.placings.add(new EdgePlacing(0));
				}
				else {
					// an already inserted edge was found
					result.edgeCount = 1;
					result.firstEdgeRank = tsmEdge.rank;
				}
			}
			break;
		case ORIENTED:
			boolean firstEdgeFound = false;
			for (EmbeddingConstraint childConstraint : constraint.children) {
				ConstraintResult childResult = analyzeConstraint(edgeMap,
						childConstraint);
				if (childResult.placings != null) {
					assert result.placings == null;
					result.placings = childResult.placings;
					for (EdgePlacing placing : result.placings) {
						placing.rank += result.edgeCount;
					}
				}
				result.edgeCount += childResult.edgeCount;
				if (!firstEdgeFound && childResult.edgeCount > 0) {
					result.firstEdgeRank = childResult.firstEdgeRank;
					firstEdgeFound = true;
				}
			}
			break;
		case MIRROR:
			int firstRank = -1, lastRank = -1, leftCount = 0, rightCount = 0;
			for (EmbeddingConstraint childConstraint : constraint.children) {
				ConstraintResult childResult = analyzeConstraint(edgeMap,
						childConstraint);
				if (result.placings == null)
					leftCount = result.edgeCount;
				else
					rightCount += childResult.edgeCount;
				if (childResult.placings != null) {
					assert result.placings == null;
					result.placings = childResult.placings;
				}
				lastRank = childResult.firstEdgeRank;
				if (firstRank < 0 && childResult.edgeCount > 0)
					firstRank = lastRank;
				result.edgeCount += childResult.edgeCount;
			}
			if (firstRank < lastRank) {
				result.firstEdgeRank = firstRank;
				if (result.placings != null) {
					for (EdgePlacing placing : result.placings) {
						placing.rank += leftCount;
					}
				}
			}
			else if (firstRank > lastRank) {
				result.firstEdgeRank = lastRank;
				if (result.placings != null) {
					for (EdgePlacing placing : result.placings) {
						placing.rank += rightCount;
					}
				}
			}
			else {
				if (firstRank >= 0) {
					result.firstEdgeRank = firstRank;
					EdgePlacing[] placings = result.placings.toArray(new EdgePlacing[0]);
					for (EdgePlacing placing : placings) {
						result.placings.add(new EdgePlacing(
								placing.rank + leftCount));
					}
				}
			}
			break;
		case GROUPING:
			LinkedList<ConstraintResult> sortedResults = new LinkedList<ConstraintResult>();
			boolean insBlockNonEmpty = false;
			for (EmbeddingConstraint childConstraint : constraint.children) {
				ConstraintResult childResult = analyzeConstraint(edgeMap,
						childConstraint);
				result.edgeCount += childResult.edgeCount;
				if (childResult.placings != null) {
					assert result.placings == null;
					result.placings = childResult.placings;
					insBlockNonEmpty = (result.edgeCount != 0);
				}
				ListIterator<ConstraintResult> resultsIter = sortedResults.listIterator();
				while (resultsIter.hasNext() && resultsIter.next().firstEdgeRank
						< childResult.firstEdgeRank);
				if (resultsIter.hasPrevious())
					resultsIter.previous();
				resultsIter.add(childResult);
			}
			result.firstEdgeRank = sortedResults.getFirst().firstEdgeRank;
			if (result.placings != null) {
				if (insBlockNonEmpty) {
					int position = 0;
					for (ConstraintResult childResult : sortedResults) {
						if (childResult.placings != null)
							break;
						position += childResult.edgeCount;
					}
					for (EdgePlacing placing : result.placings) {
						placing.rank += position;
					}
				}
				else {
					EdgePlacing[] placings = result.placings.toArray(new EdgePlacing[0]);
					int position = 0;
					for (ConstraintResult childResult : sortedResults) {
						position += childResult.edgeCount;
						for (EdgePlacing placing : placings) {
							result.placings.add(new EdgePlacing(placing.rank + position));
						}
					}
				}
			}
			break;
		}
		return result;
	}
	
	/**
	 * Find a shortest path from one of the source placings to one of the
	 * target placings.
	 * 
	 * @param insEdge insertion edge
	 * @param sourcePlacings set of admissible source placings
	 * @param targetPlacings set of admissible target placings
	 * @return path leading from the source placing to the target placing
	 */
	private DualPath shortestPath(TSMEdge insEdge, List<EdgePlacing> sourcePlacings,
			List<EdgePlacing> targetPlacings) {
		// determine the set of target faces
		List<TSMFace> targetFaces = new LinkedList<TSMFace>();
		for (EdgePlacing placing : targetPlacings) {
			if (placing.face == null)
				placing.face = insEdge.target.edges.get(placing.rank)
						.getLeftFaceFrom(insEdge.target);
			targetFaces.add(placing.face);
		}
		
		// find the shortest path
		DualPath shortestPath = new DualPath();
		int shortestLength = Integer.MAX_VALUE;
		for (EdgePlacing placing : sourcePlacings) {
			if (placing.face == null)
				placing.face = insEdge.source.edges.get(placing.rank)
						.getLeftFaceFrom(insEdge.source);
			List<DualPathEntry> path = bfsPath(placing.face, targetFaces);
			if (path.size() < shortestLength) {
				shortestPath.entries = path;
				shortestLength = path.size();
				shortestPath.sourcePlacing = placing;
			}
		}
		
		// get a placing for the selected target face
		TSMFace targetFace = shortestPath.entries.isEmpty()
				? shortestPath.sourcePlacing.face
				: shortestPath.entries.get(shortestLength-1).targetFace;
		for (EdgePlacing placing : targetPlacings) {
			if (placing.face.id == targetFace.id)
				shortestPath.targetPlacing = placing;
		}
		return shortestPath;
	}
	
	/**
	 * Performs a BFS to find the shortest path from a given source Face to
	 * any of the target faces.
	 * 
	 * @param sourceFace source face for the BFS
	 * @param targetFaces set of target faces
	 * @return shortest path from the source face to one of the target faces
	 */
	private List<DualPathEntry> bfsPath(TSMFace sourceFace, List<TSMFace> targetFaces) {
		DualPathEntry[] parentPath = new DualPathEntry[graph.faces.size()];
		Queue<DualPathEntry> bfsQueue = new LinkedList<DualPathEntry>();
		TSMFace currentFace = sourceFace;
		do {
			if (targetFaces.contains(currentFace)) {
				break;
			}
			for (List<TSMEdge> edgeList : currentFace.edgeLists) {
				for (TSMEdge edge : edgeList)
					bfsQueue.add(new DualPathEntry(edge, edge.getOpposed(currentFace)));
			}
			DualPathEntry currentEntry = null;
			do {
				currentEntry = bfsQueue.poll();
				if (currentEntry != null) {
					currentFace = currentEntry.targetFace;
					if (parentPath[currentFace.id] == null
							&& currentFace.id != sourceFace.id) {
						parentPath[currentFace.id] = currentEntry;
					}
					else
						currentEntry = null;
				}
			} while (currentEntry != null);
		} while (!bfsQueue.isEmpty());
		
		// construct a shortest path to the current element
		LinkedList<DualPathEntry> path = new LinkedList<DualPathEntry>();
		while (parentPath[currentFace.id] != null) {
			DualPathEntry pathEntry = parentPath[currentFace.id];
			path.addFirst(pathEntry);
			currentFace = pathEntry.edge.getOpposed(currentFace);
		}
		return path;
	}
	
	/**
	 * Insert an edge through the given path of the dual graph.
	 * 
	 * @param insEdge edge to be inserted
	 * @param path path of the dual graph
	 */
	private void insertEdge(TSMEdge insEdge, DualPath path) {
		TSMNode currentNode = insEdge.source;
		TSMFace currentFace = path.sourcePlacing.face;
		int currentRank = path.sourcePlacing.rank;
		TSMEdge previousEdge = null;
		for (DualPathEntry pathEntry : path.entries) {
			// insert a pseudo node into the currently crossed edge
			TSMNode pseudoNode = new TSMNode(graph);
			TSMEdge edge1 = pathEntry.edge;
			TSMNode oldTarget = edge1.target;
			edge1.target = pseudoNode;
			ListIterator<TSMEdge> oldTargetIter = getIteratorFor(oldTarget.edges, edge1);
			oldTargetIter.remove();
			TSMEdge edge2 = new TSMEdge(graph, pseudoNode, oldTarget,
					false, edge1.layoutEdge);
			oldTargetIter.add(edge2);
			pseudoNode.edges.add(edge1);
			pseudoNode.edges.add(edge2);
			int firstRank, secondRank;
			if (currentFace.id == edge1.leftFace.id) {
				firstRank = 1;
				secondRank = 0;
			}
			else {
				assert currentFace.id == edge1.rightFace.id;
				firstRank = 0;
				secondRank = 2;
			}
			edge2.leftFace = edge1.leftFace;
			edge2.rightFace = edge1.rightFace;
			edge2.nextEdge = edge1.nextEdge;
			edge1.nextEdge = edge2;
			edge2.previousEdge = edge1;
			// insert an edge from the current node to the new pseudo node
			previousEdge = insertEdge(currentNode, currentRank, pseudoNode,
					firstRank, currentFace, null, previousEdge,
					insEdge.layoutEdge);
			currentNode = pseudoNode;
			currentRank = secondRank;
			currentFace = pathEntry.targetFace;
		}
		// insert a final edge from the current node to the target node
		insertEdge(currentNode, currentRank, insEdge.target,
				path.targetPlacing.rank, path.targetPlacing.face, insEdge,
				previousEdge, insEdge.layoutEdge);
	}
	
	/**
	 * 
	 * @param sourceNode
	 * @param sourceRank
	 * @param targetNode
	 * @param targetRank
	 * @param face
	 * @param edge
	 * @param previousEdge
	 * @param layoutEdge
	 * @return
	 */
	private TSMEdge insertEdge(TSMNode sourceNode, int sourceRank,
			TSMNode targetNode, int targetRank, TSMFace face, TSMEdge edge,
			TSMEdge previousEdge, KEdge layoutEdge) {
		if (edge == null) {
			edge = new TSMEdge(graph, sourceNode, targetNode, false, layoutEdge);
		}
		else {
			edge.source = sourceNode;
			edge.target = targetNode;
		}
		if (previousEdge != null) {
			previousEdge.nextEdge = edge;
			edge.previousEdge = previousEdge;
		}
		
		// insert the edge at the proper placings
		sourceNode.edges.add(sourceRank, edge);
		targetNode.edges.add(targetRank, edge);
		
		// update the crossed face
		// TODO traverse all edges of the given face and look for the
		//      source and target nodes
		return edge;
	}
	
	/**
	 * Gets a list iterator for the given list of edges, with the
	 * current position after the given edge.
	 * 
	 * @param edgeList list for which the iterator shall be created
	 * @param edge edge at which the iterator shall point
	 *     (with <code>previous()</code>)
	 * @return iterator pointing at <code>edge</code>, or null if
	 *     the edge was not found
	 */
	private ListIterator<TSMEdge> getIteratorFor(List<TSMEdge> edgeList,
			TSMEdge edge) {
		ListIterator<TSMEdge> edgeIter = edgeList.listIterator();
		while (edgeIter.hasNext()) {
			if (edgeIter.next() == edge)
				return edgeIter;
		}
		return null;
	}
	
}

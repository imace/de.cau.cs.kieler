package de.cau.cs.kieler.klodd.orthogonal.impl.ec;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

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
		
		/**
		 * Creates an edge placing with given rank
		 * @param rank the rank
		 */
		EdgePlacing(int rank) {
			this.rank = rank;
		}
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
	/** faces on the path that was chosen for insertion */
	private List<TSMFace> facePath = new LinkedList<TSMFace>();
	/** edges on the path that was chosen for insertion */
	private List<TSMEdge> pathEdges = new LinkedList<TSMEdge>();
	/** edge placing for insertion at source */
	private EdgePlacing sourcePlacing;
	/** edge placing for insertion at target */
	private EdgePlacing targetPlacing;
	
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
		shortestPath(edge, sourcePlacings, targetPlacings);
		// insert the edge through the new path
		insertEdge(edge);
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
					result.placings = new LinkedList<EdgePlacing>();
					result.placings.add(new EdgePlacing(0));
				}
				else {
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
	
	private void shortestPath(TSMEdge edge, List<EdgePlacing> sourcePlacings,
			List<EdgePlacing> targetPlacings) {
		facePath.clear();
		pathEdges.clear();
		// perform a BFS!
	}
	
	private void insertEdge(TSMEdge edge) {
		
	}
	
}

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
		int placingsCount = node.incidence.size();
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
			for (TSMNode.IncEntry tsmEdgeEntry : node.incidence) {
				tsmEdgeEntry.edge.rank = nextRank++;
				edgeMap.put(tsmEdgeEntry.edge.layoutEdge, tsmEdgeEntry.edge);
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
		DualPath shortestPath = new DualPath();
		// determine the sets of source and target faces
		List<TSMFace> targetFaces = new LinkedList<TSMFace>();
		boolean sourceEmpty = insEdge.source.incidence.isEmpty();
		boolean targetEmpty = insEdge.target.incidence.isEmpty();
		if (!sourceEmpty) {
			for (EdgePlacing placing : sourcePlacings) {
				if (placing.face == null)
					placing.face = insEdge.source.incidence.get(placing.rank)
							.leftFace();
			}
		}
		if (!targetEmpty) {
			for (EdgePlacing placing : targetPlacings) {
				if (placing.face == null)
					placing.face = insEdge.target.incidence.get(placing.rank)
							.leftFace();
				targetFaces.add(placing.face);
			}
		}
		
		if (sourceEmpty && targetEmpty) {
			// put both the source and the target onto the external face
			shortestPath.entries = new LinkedList<DualPathEntry>();
			shortestPath.sourcePlacing = sourcePlacings.get(0);
			shortestPath.sourcePlacing.face = graph.externalFace;
			shortestPath.targetPlacing = targetPlacings.get(0);
			shortestPath.targetPlacing.face = graph.externalFace;
		}
		else if (sourceEmpty) {
			// choose an arbitrary placing of the target
			shortestPath.entries = new LinkedList<DualPathEntry>();
			shortestPath.sourcePlacing = sourcePlacings.get(0);
			shortestPath.targetPlacing = targetPlacings.get(0);
			shortestPath.sourcePlacing.face = shortestPath.targetPlacing.face;
		}
		else if (targetEmpty) {
			// choose an arbitrary placing of the source
			shortestPath.entries = new LinkedList<DualPathEntry>();
			shortestPath.sourcePlacing = sourcePlacings.get(0);
			shortestPath.targetPlacing = targetPlacings.get(0);
			shortestPath.targetPlacing.face = shortestPath.sourcePlacing.face;
		}
		else {
			// find the shortest path
			int shortestLength = Integer.MAX_VALUE;
			for (EdgePlacing placing : sourcePlacings) {
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
			for (List<TSMFace.BorderEntry> border : currentFace.borders) {
				for (TSMFace.BorderEntry entry : border)
					bfsQueue.add(new DualPathEntry(entry.edge,
							entry.opposed()));
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
			//currentFace = pathEntry.edge;
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
			// insert a dummy node into the currently crossed edge
			TSMNode dummyNode = new TSMNode(graph, TSMNode.Type.CROSSING);
			TSMEdge edge1 = pathEntry.edge;
			TSMNode oldTarget = edge1.target;
			edge1.target = dummyNode;
			ListIterator<TSMNode.IncEntry> oldTargetIter = getIteratorFor(
					oldTarget.incidence, edge1);
			oldTargetIter.remove();
			TSMEdge edge2 = new TSMEdge(graph, dummyNode, oldTarget,
					edge1.layoutEdge);
			oldTargetIter.add(new TSMNode.IncEntry(edge2,
					TSMNode.IncEntry.Type.IN));
			dummyNode.incidence.add(new TSMNode.IncEntry(edge1,
					TSMNode.IncEntry.Type.IN));
			dummyNode.incidence.add(new TSMNode.IncEntry(edge2,
					TSMNode.IncEntry.Type.OUT));
			int firstRank, secondRank;
			boolean insertForward;
			if (currentFace.id == edge1.leftFace.id) {
				firstRank = 1;
				secondRank = 0;
				insertForward = false;
			}
			else {
				assert currentFace.id == edge1.rightFace.id;
				firstRank = 0;
				secondRank = 2;
				insertForward = true;
			}
			edge2.nextEdge = edge1.nextEdge;
			edge1.nextEdge = edge2;
			edge2.previousEdge = edge1;
			// update faces left and right of edge1
			edge2.leftFace = edge1.leftFace;
			edge2.rightFace = edge1.rightFace;
			for (List<TSMFace.BorderEntry> border : currentFace.borders) {
				ListIterator<TSMFace.BorderEntry> currentFaceIter =
					getIteratorFor(border, edge1, insertForward);
				if (currentFaceIter != null) {
					if (insertForward)
						currentFaceIter.add(currentFace.new BorderEntry(edge2,
								edge2.source));
					else
						currentFaceIter.add(currentFace.new BorderEntry(edge2,
								edge2.target));
					break;
				}
			}
			for (List<TSMFace.BorderEntry> border : pathEntry.targetFace.borders) {
				ListIterator<TSMFace.BorderEntry> currentFaceIter =
					getIteratorFor(border, edge1, !insertForward);
				if (currentFaceIter != null) {
					if (insertForward)
						currentFaceIter.add(pathEntry.targetFace.new BorderEntry(
								edge2, edge2.target));
					else
						currentFaceIter.add(pathEntry.targetFace.new BorderEntry(
								edge2, edge2.source));
					break;
				}
			}
			// insert an edge from the current node to the new pseudo node
			previousEdge = insertEdge(currentNode, currentRank, dummyNode,
					firstRank, currentFace, null, previousEdge,
					insEdge.layoutEdge);
			currentNode = dummyNode;
			currentRank = secondRank;
			currentFace = pathEntry.targetFace;
		}
		// insert a final edge from the current node to the target node
		insertEdge(currentNode, currentRank, insEdge.target,
				path.targetPlacing.rank, path.targetPlacing.face, insEdge,
				previousEdge, insEdge.layoutEdge);
	}
	
	/**
	 * Inserts an edge between two nodes and updates the affected faces.
	 * 
	 * @param sourceNode source node of the new edge
	 * @param sourceRank rank of the new edge at the source node
	 * @param targetNode target node of the new edge
	 * @param targetRank rank of the new edge at the target node
	 * @param face face which is crossed by the new edge
	 * @param insEdge new edge object, or null if it shall be created
	 * @param previousEdge previous edge in a series of edges
	 * @param layoutEdge reference to the layout edge from which the new
	 *     edge is created
	 * @return the new inserted edge
	 */
	private TSMEdge insertEdge(TSMNode sourceNode, int sourceRank,
			TSMNode targetNode, int targetRank, TSMFace face, TSMEdge insEdge,
			TSMEdge previousEdge, KEdge layoutEdge) {
		if (insEdge == null) {
			insEdge = new TSMEdge(graph, sourceNode, targetNode, layoutEdge);
		}
		else {
			insEdge.source = sourceNode;
			insEdge.target = targetNode;
		}
		if (previousEdge != null) {
			previousEdge.nextEdge = insEdge;
			insEdge.previousEdge = previousEdge;
		}
		
		// update the crossed face
		int sourceBorderIndex = getBorderIndexFor(face.borders, sourceNode);
		int targetBorderIndex = getBorderIndexFor(face.borders, targetNode);
		List<TSMFace.BorderEntry> sourceBorder = null, targetBorder = null;
		ListIterator<TSMFace.BorderEntry> sourceIter = null, targetIter = null;
		if (sourceBorderIndex > 0) {
			sourceBorder = face.borders.get(sourceBorderIndex);
			sourceIter = getIteratorFor(sourceBorder, sourceNode, sourceRank);
		}
		if (targetBorderIndex > 0) {
			targetBorder = face.borders.get(targetBorderIndex);
			targetIter = getIteratorFor(targetBorder, targetNode, targetRank);
		}
		
		if (sourceBorder == null && targetBorder == null) {
			List<TSMFace.BorderEntry> newBorder = new LinkedList<TSMFace.BorderEntry>();
			newBorder.add(face.new BorderEntry(insEdge, insEdge.source));
			newBorder.add(face.new BorderEntry(insEdge, insEdge.target));
			face.borders.add(newBorder);
			insEdge.leftFace = face;
			insEdge.rightFace = face;
		}
		else if (sourceBorder == null) {
			targetIter.add(face.new BorderEntry(insEdge, insEdge.target));
			targetIter.add(face.new BorderEntry(insEdge, insEdge.source));
			insEdge.leftFace = face;
			insEdge.rightFace = face;
		}
		else if (targetBorder == null) {
			sourceIter.add(face.new BorderEntry(insEdge, insEdge.source));
			sourceIter.add(face.new BorderEntry(insEdge, insEdge.target));
			insEdge.leftFace = face;
			insEdge.rightFace = face;
		}
		else if (sourceBorder == targetBorder) {
			int sourceIndex = sourceIter.nextIndex();
			targetIter.add(face.new BorderEntry(insEdge, insEdge.target));
			TSMFace newFace = new TSMFace(graph);
			List<TSMFace.BorderEntry> newBorder = new LinkedList<TSMFace.BorderEntry>();
			while (targetIter.hasNext() && targetIter.nextIndex() != sourceIndex) {
				newBorder.add(newFace.new BorderEntry(targetIter.next()));
				targetIter.remove();
			}
			if (targetIter.nextIndex() != sourceIndex) {
				targetIter = targetBorder.listIterator();
				while (targetIter.nextIndex() < sourceIndex) {
					newBorder.add(newFace.new BorderEntry(targetIter.next()));
					targetIter.remove();
				}
			}
			newBorder.add(newFace.new BorderEntry(insEdge, insEdge.source));
			newFace.borders.add(newBorder);
			insEdge.leftFace = face;
			insEdge.rightFace = newFace;
		}
		else {
			int targetIndex = targetIter.nextIndex();
			sourceIter.add(face.new BorderEntry(insEdge, insEdge.source));
			while (targetIter.hasNext()) {
				sourceIter.add(targetIter.next());
			}
			targetIter = targetBorder.listIterator();
			while (targetIter.nextIndex() < targetIndex) {
				sourceIter.add(targetIter.next());
			}
			sourceIter.add(face.new BorderEntry(insEdge, insEdge.target));
			insEdge.leftFace = face;
			insEdge.rightFace = face;
			face.borders.remove(targetBorderIndex);
		}
		
		// insert the edge at the proper placings
		insEdge.connectNodes(sourceRank, targetRank);
		
		return insEdge;
	}
	
	/**
	 * Gets a list iterator for the given incidence list, with the
	 * current position before or after the given edge.
	 * 
	 * @param incList list for which the iterator shall be created
	 * @param edge edge at which the iterator shall point
	 * @return iterator pointing at <code>edge</code>, or null if
	 *     the edge was not found
	 */
	private ListIterator<TSMNode.IncEntry> getIteratorFor(
			List<TSMNode.IncEntry> incList,	TSMEdge edge) {
		ListIterator<TSMNode.IncEntry> edgeIter = incList.listIterator();
		while (edgeIter.hasNext()) {
			if (edgeIter.next().edge.id == edge.id)
				return edgeIter;
		}
		return null;
	}
	
	/**
	 * Gets a list iterator for the given list of face border entries,
	 * with the current position before or after the given edge.
	 * 
	 * @param border list of face border entries for which the iterator
	 *     shall be created
	 * @param edge edge at which the iterator shall point
	 * @param forward if true, the list is traversed in forward direction,
	 *     else backwards
	 * @return iterator pointing at <code>edge</code>, or null if the
	 *     edge was not found
	 */
	private ListIterator<TSMFace.BorderEntry> getIteratorFor(
			List<TSMFace.BorderEntry> border, TSMEdge edge, boolean forward) {
		if (forward) {
			ListIterator<TSMFace.BorderEntry> borderIter = border.listIterator();
			while (borderIter.hasNext()) {
				if (borderIter.next().edge.id == edge.id)
					return borderIter;
			}
		}
		else {
			ListIterator<TSMFace.BorderEntry> borderIter = border.listIterator(border.size());
			while (borderIter.hasPrevious()) {
				if (borderIter.previous().edge.id == edge.id)
					return borderIter;
			}
		}
		return null;
	}

	/**
	 * Gets a list iterator for the given face border, with the current
	 * position at the given rank. The list must not be empty.
	 * 
	 * @param border list for which the iterator shall be created
	 * @param node node for which the rank shall be valid
	 * @param rank rank of the edge that is returned by calling
	 *     <code>next()</code> on the resulting iterator
	 * @return iterator pointing at the edge with rank <code>rank</code>
	 *     of node <code>node</code>
	 */
	private ListIterator<TSMFace.BorderEntry> getIteratorFor(
			List<TSMFace.BorderEntry> border, TSMNode node, int rank) {
		int edge1id, edge2id;
		if (rank == 0) {
			edge2id = node.incidence.get(node.incidence.size()-1).edge.id;
			edge1id = node.incidence.get(0).edge.id;
		}
		else {
			ListIterator<TSMNode.IncEntry> nodeEdgeIter = node.incidence
					.listIterator(rank - 1);
			edge2id = nodeEdgeIter.next().edge.id;
			edge1id = nodeEdgeIter.next().edge.id;
		}
		
		ListIterator<TSMFace.BorderEntry> borderIter = border.listIterator();
		boolean placingFound = false;
		// the list is assumed to be non-empty
		TSMFace.BorderEntry currentEntry = borderIter.next();
		while (borderIter.hasNext()) {
			TSMFace.BorderEntry nextEntry = borderIter.next();
			if (currentEntry.edge.id == edge1id && nextEntry.edge.id == edge2id
					&& currentEntry.node.id == node.id) {
				borderIter.previous();
				placingFound = true;
				break;
			}
			currentEntry = nextEntry;
		}
		if (placingFound)
			return borderIter;
		else {
			// return the last possible position
			assert currentEntry.edge.id == edge1id
					&& border.get(0).edge.id == edge2id;
			return border.listIterator();
		}
	}
	
	/**
	 * Finds the index of the face border that contains an edge with the
	 * given node as endpoint.
	 * 
	 * @param borders list of face borders
	 * @param node node to look up
	 * @return index of the face border containing <code>node</code>,
	 *     or -1 if the node was not found
	 */
	private int getBorderIndexFor(List<List<TSMFace.BorderEntry>> borders,
			TSMNode node) {
		ListIterator<List<TSMFace.BorderEntry>> borderIter = borders.listIterator();
		while (borderIter.hasNext()) {
			List<TSMFace.BorderEntry> nextBorder = borderIter.next();
			for (TSMFace.BorderEntry entry : nextBorder) {
				if (entry.node.id == node.id) {
					return borderIter.previousIndex();
				}
			}
		}
		return -1;
	}
	
}

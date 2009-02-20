package de.cau.cs.kieler.klodd.orthogonal.impl.ec;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Queue;

import de.cau.cs.kieler.core.alg.AbstractAlgorithm;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutEdge;
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
	private static class EdgePlacing {
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
	private static class DualPathEntry {
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
	private static class DualPath {
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
	private static class ConstraintResult {
		/** number of edges that are already placed */
		int edgeCount = 0;
		/** rank of the first edge */
		int firstEdgeRank = 0;
		/** set of admissible placings */
		List<EdgePlacing> placings = null;
		/** relative position of the other endpoint: < 0 for lesser,
		 *  > 0 for greater, 0 for not found */
		int endpoint = 0;
	}
	
	/** TSM graph that is currently processed */
	private TSMGraph graph = null;
	/** array of markers of already inserted edges */
	private boolean[] inserted;
	/** for self-loops: is the target rank greater than the source rank? */
	private boolean forwardSelfLoop;
	
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
		inserted = new boolean[graph.edges.size()];
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
		
		getMonitor().begin("EC edge insertion", 1);
		
		// determine the admissible placings at source and target
		List<EdgePlacing> sourcePlacings = getEdgePlacings(edge,
				edge.source, sourceConstraint, true);
		List<EdgePlacing> targetPlacings = getEdgePlacings(edge,
				edge.target, targetConstraint, false);
		// determine a shortest path from a source face to a target face
		DualPath path = shortestPath(edge, sourcePlacings, targetPlacings);
		// insert the edge through the new path
		insertEdge(edge, path);
		
		getMonitor().done();
	}
	
	/**
	 * Determines the set of placings that can be used for an edge under
	 * certain embedding constraints.
	 * 
	 * @param insEdge edge that is to be inserted
	 * @param node node incident with <code>edge</code>
	 * @param constraint embedding constraint for <code>node</code>
	 * @param outgoing indicates whether the edge is outgoing for the node
	 * @return array of placings that are admissible for the given edge
	 */
	private List<EdgePlacing> getEdgePlacings(TSMEdge insEdge, TSMNode node,
			EmbeddingConstraint constraint, boolean outgoing) {
		int placingsCount = node.incidence.size();
		if (placingsCount == 0) {
			EdgePlacing placing = new EdgePlacing(0);
			List<EdgePlacing> placings = new LinkedList<EdgePlacing>();
			placings.add(placing);
			return placings;
		}
		else {
			// assign ranks to already placed edges
			int nextRank = 0;
			for (TSMNode.IncEntry edgeEntry : node.incidence) {
				edgeEntry.edge.rank = nextRank++;
				inserted[edgeEntry.edge.id] = true;
			}
			// the edge that is to be inserted gets a negative rank
			insEdge.rank = -1;
			inserted[insEdge.id] = true;
			
			// traverse the constraint tree recursively
			ConstraintResult constraintResult = analyzeConstraint(constraint,
					outgoing);
			forwardSelfLoop = outgoing && (constraintResult.endpoint > 0)
					|| !outgoing && constraintResult.endpoint < 0;
			return constraintResult.placings;
		}
	}
	
	/**
	 * Analyzes a given constraint by traversing its constraint tree
	 * recursively and collecting information. This is used to get
	 * the set of admissible placements for an edge.
	 * 
	 * @param constraint embedding constraint to analyze
	 * @param outgoing indicates whether the edge is outgoing for the node
	 * @return constraint information with a list of admissible placements
	 */
	private ConstraintResult analyzeConstraint(EmbeddingConstraint constraint,
			boolean outgoing) {
		ConstraintResult result = new ConstraintResult();
		switch (constraint.type) {
		case OUT_EDGE:
		case IN_EDGE:
			TSMEdge edge = (TSMEdge)constraint.object;
			if (inserted[edge.id]) {
				if (edge.rank < 0) {
					if (outgoing == (constraint.type
							== EmbeddingConstraint.Type.OUT_EDGE)) {
						// the insertion edge was found
						result.placings = new LinkedList<EdgePlacing>();
						result.placings.add(new EdgePlacing(0));
					}
					else
						result.endpoint = 1;
				}
				else {
					// an already inserted edge was found
					result.edgeCount = 1;
					result.firstEdgeRank = edge.rank;
				}
			}
			break;
		case ORIENTED:
			boolean firstEdgeFound = false;
			for (EmbeddingConstraint childConstraint : constraint.children) {
				ConstraintResult childResult = analyzeConstraint(
						childConstraint, outgoing);
				
				if (childResult.placings != null) {
					assert result.placings == null;
					result.placings = childResult.placings;
					for (EdgePlacing placing : result.placings) {
						placing.rank += result.edgeCount;
					}
					if (childResult.endpoint != 0)
						result.endpoint = childResult.endpoint;
				}
				else if (childResult.endpoint != 0) {
					if (result.placings == null)
						result.endpoint = -1;
					else
						result.endpoint = 1;
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
				ConstraintResult childResult = analyzeConstraint(
						childConstraint, outgoing);
				if (result.placings == null)
					leftCount = result.edgeCount;
				else
					rightCount += childResult.edgeCount;
				
				if (childResult.placings != null) {
					assert result.placings == null;
					result.placings = childResult.placings;
					if (childResult.endpoint != 0)
						result.endpoint = 2 * childResult.endpoint;
				}
				else if (childResult.endpoint != 0) {
					if (result.placings == null)
						result.endpoint = -1;
					else
						result.endpoint = 1;
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
				if (result.endpoint == 1 || result.endpoint == 1)
					result.endpoint = -result.endpoint;
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
				ConstraintResult childResult = analyzeConstraint(
						childConstraint, outgoing);
				result.edgeCount += childResult.edgeCount;
				
				if (childResult.placings != null) {
					assert result.placings == null;
					result.placings = childResult.placings;
					insBlockNonEmpty = (result.edgeCount != 0);
				}
				
				if (childResult.endpoint != 0)
					result.endpoint = childResult.endpoint;
				
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
						if (childResult.edgeCount > 0) {
							position += childResult.edgeCount;
							for (EdgePlacing placing : placings) {
								result.placings.add(new EdgePlacing(placing.rank + position));
							}
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
				if (placing.face == null) {
					int index = (placing.rank >= insEdge.source.incidence.size()
							? 0 : placing.rank);
					placing.face = insEdge.source.incidence.get(index)
							.leftFace();
				}
			}
		}
		if (!targetEmpty) {
			for (EdgePlacing placing : targetPlacings) {
				if (placing.face == null) {
					int index = (placing.rank >= insEdge.target.incidence.size()
							? 0 : placing.rank);
					placing.face = insEdge.target.incidence.get(index)
							.leftFace();
				}
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
		DualPathEntry[] parentPath = new DualPathEntry[graph.faces.size() + 1];
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
			ListIterator<TSMNode.IncEntry> oldTargetIter = oldTarget.getIterator(
					edge1, false);
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
			ListIterator<TSMFace.BorderEntry> currentFaceIter = currentFace
					.getIterator(edge1, insertForward);
			if (!insertForward)
				currentFaceIter.previous();
			currentFaceIter.add(new TSMFace.BorderEntry(edge2, insertForward));
			ListIterator<TSMFace.BorderEntry> targetFaceIter = pathEntry
					.targetFace.getIterator(edge1, !insertForward);
			if (insertForward)
				targetFaceIter.previous();
			targetFaceIter.add(new TSMFace.BorderEntry(edge2, !insertForward));

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
			TSMEdge previousEdge, KLayoutEdge layoutEdge) {
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
		if (sourceBorderIndex >= 0) {
			sourceBorder = face.borders.get(sourceBorderIndex);
			sourceIter = getIteratorFor(sourceBorder, sourceNode, sourceRank);
		}
		if (targetBorderIndex >= 0) {
			targetBorder = face.borders.get(targetBorderIndex);
			targetIter = getIteratorFor(targetBorder, targetNode, targetRank);
		}
		
		if (sourceBorder == null && targetBorder == null) {
			List<TSMFace.BorderEntry> newBorder = new LinkedList<TSMFace.BorderEntry>();
			if (insEdge.source.id == insEdge.target.id) {
				if (sourceRank < targetRank || sourceRank == targetRank
						&& forwardSelfLoop) {
					newBorder.add(new TSMFace.BorderEntry(insEdge, false));
					insEdge.leftFace = face;
					TSMFace innerFace = new TSMFace(graph, true);
					List<TSMFace.BorderEntry> innerBorder = new LinkedList<TSMFace.BorderEntry>();
					innerBorder.add(new TSMFace.BorderEntry(insEdge, true));
					innerFace.borders.add(innerBorder);
					insEdge.rightFace = innerFace;
				}
				else {
					newBorder.add(new TSMFace.BorderEntry(insEdge, true));
					insEdge.rightFace = face;
					TSMFace innerFace = new TSMFace(graph, true);
					List<TSMFace.BorderEntry> innerBorder = new LinkedList<TSMFace.BorderEntry>();
					innerBorder.add(new TSMFace.BorderEntry(insEdge, false));
					innerFace.borders.add(innerBorder);
					insEdge.leftFace = innerFace;
				}
			}
			else {
				newBorder.add(new TSMFace.BorderEntry(insEdge, true));
				newBorder.add(new TSMFace.BorderEntry(insEdge, false));
				insEdge.leftFace = face;
				insEdge.rightFace = face;
			}
			face.borders.add(newBorder);
		}
		else if (sourceBorder == null) {
			targetIter.add(new TSMFace.BorderEntry(insEdge, true));
			targetIter.add(new TSMFace.BorderEntry(insEdge, false));
			insEdge.leftFace = face;
			insEdge.rightFace = face;
		}
		else if (targetBorder == null) {
			sourceIter.add(new TSMFace.BorderEntry(insEdge, true));
			sourceIter.add(new TSMFace.BorderEntry(insEdge, false));
			insEdge.leftFace = face;
			insEdge.rightFace = face;
		}
		else if (sourceBorder == targetBorder) {
			TSMFace newFace = new TSMFace(graph, true);
			List<TSMFace.BorderEntry> newBorder = new LinkedList<TSMFace.BorderEntry>();
			if (insEdge.source.id == insEdge.target.id) {
				if (sourceRank < targetRank || sourceRank == targetRank
						&& forwardSelfLoop) {
					sourceIter.add(new TSMFace.BorderEntry(insEdge, false));
					insEdge.leftFace = face;
					newBorder.add(new TSMFace.BorderEntry(insEdge, true));
					insEdge.rightFace = newFace;
				}
				else {
					sourceIter.add(new TSMFace.BorderEntry(insEdge, true));
					insEdge.rightFace = face;
					newBorder.add(new TSMFace.BorderEntry(insEdge, false));
					insEdge.leftFace = newFace;
				}
			}
			else {
				int sourceIndex = sourceIter.nextIndex();
				int nextIndex = targetIter.nextIndex();
				targetIter.add(new TSMFace.BorderEntry(insEdge, false));
				while (nextIndex != sourceIndex) {
					if (!targetIter.hasNext()) {
						targetIter = targetBorder.listIterator();
						nextIndex = 0;
						if (nextIndex == sourceIndex)
							break;
					}
					TSMFace.BorderEntry nextEntry = targetIter.next();
					newBorder.add(new TSMFace.BorderEntry(nextEntry));
					targetIter.remove();
					if (nextEntry.forward)
						nextEntry.edge.rightFace = newFace;
					else
						nextEntry.edge.leftFace = newFace;
					nextIndex++;
				}
				newBorder.add(new TSMFace.BorderEntry(insEdge, true));
				insEdge.leftFace = face;
				insEdge.rightFace = newFace;
			}
			newFace.borders.add(newBorder);
		}
		else {
			int targetIndex = targetIter.nextIndex();
			sourceIter.add(new TSMFace.BorderEntry(insEdge, true));
			while (targetIter.hasNext()) {
				sourceIter.add(targetIter.next());
			}
			targetIter = targetBorder.listIterator();
			while (targetIter.nextIndex() < targetIndex) {
				sourceIter.add(targetIter.next());
			}
			sourceIter.add(new TSMFace.BorderEntry(insEdge, false));
			insEdge.leftFace = face;
			insEdge.rightFace = face;
			face.borders.remove(targetBorderIndex);
		}
		
		// insert the edge at the proper placings
		insEdge.connectNodes(sourceRank, targetRank, forwardSelfLoop);
		
		return insEdge;
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
		if (rank == 0 || rank >= node.incidence.size()) {
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
					&& currentEntry.secondNode().id == node.id
					&& nextEntry.firstNode().id == node.id) {
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
				if (entry.edge.source.id == node.id
						|| entry.edge.target.id == node.id) {
					return borderIter.previousIndex();
				}
			}
		}
		return -1;
	}
	
}

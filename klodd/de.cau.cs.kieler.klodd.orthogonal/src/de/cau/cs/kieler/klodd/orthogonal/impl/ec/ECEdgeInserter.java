package de.cau.cs.kieler.klodd.orthogonal.impl.ec;

import java.util.LinkedList;
import java.util.List;

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

	/** TSM graph that is currently processed */
	private TSMGraph graph = null;
	/** faces on the path that was chosen for insertion */
	private List<TSMFace> facePath = new LinkedList<TSMFace>();
	/** edges on the path that was chosen for insertion */
	private List<TSMEdge> pathEdges = new LinkedList<TSMEdge>();
	/** edge placing for insertion at source */
	private int sourcePlacing;
	/** edge placing for insertion at target */
	private int targetPlacing;
	
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
		int[] sourcePlacings = getEdgePlacings(edge, edge.source, sourceConstraint);
		int[] targetPlacings = getEdgePlacings(edge, edge.target, targetConstraint);
		// determine a shortest path from a source face to a target face
		shortestPath(sourcePlacings, targetPlacings);
		// insert the edge through the new path
		insertEdge(edge);
	}
	
	/**
	 * Determines the set of placings that can be used for an edge under
	 * certain embedding constraints.
	 * 
	 * @param edge edge that is to be inserted
	 * @param node node incident with <code>edge</code>
	 * @param constraint embedding constraint for <code>node</code>
	 * @return array of placings that are admissible for the given edge
	 */
	private int[] getEdgePlacings(TSMEdge edge, TSMNode node,
			EmbeddingConstraint constraint) {
		int placingsCount = node.edges.size();
		if (placingsCount <= 1) {
			return new int[] { 0 };
		}
		else {
			List<Integer> placings = new LinkedList<Integer>();
			
			for (int placing = 0; placing < placingsCount; placing++) {
				if (admissible(edge, node, placing, constraint) < 0)
					placings.add(new Integer(placing));
			}
			
			int[] plainPlacings = new int[placings.size()];
			int i = 0;
			for (Integer placing : placings) {
				plainPlacings[i] = placing.intValue();
			}
			return plainPlacings;
		}
	}
	
	private int admissible(TSMEdge edge, TSMNode node, int placing,
			EmbeddingConstraint constraint) {
		switch (constraint.type) {
		case EDGE:
			KEdge layoutEdge = (KEdge)constraint.object;
			return layoutEdge == edge.layoutEdge ? -1 : 1;
		case ORIENTED:
		case MIRROR:
			break;
		case GROUPING:
			break;
		}return 0;
	}
	
	private void shortestPath(int[] sourcePlacings, int[] targetPlacings) {
		facePath.clear();
		pathEdges.clear();
	}
	
	private void insertEdge(TSMEdge edge) {
		
	}
	
}

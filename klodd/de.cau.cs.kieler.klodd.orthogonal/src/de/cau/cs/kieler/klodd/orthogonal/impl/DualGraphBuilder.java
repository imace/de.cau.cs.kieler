package de.cau.cs.kieler.klodd.orthogonal.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import de.cau.cs.kieler.core.alg.AbstractAlgorithm;
import de.cau.cs.kieler.klodd.orthogonal.structures.*;

/**
 * Algorithm that constructs the dual graph of a given graph.
 * 
 * @author msp
 */
public class DualGraphBuilder extends AbstractAlgorithm {

	/**
	 * Interface for detectors of external faces.
	 */
	public interface ExternalFaceDetector {
		/**
		 * Determines whether the given face border is external.
		 * 
		 * @param border face border to test
		 * @return true if the given face border is external
		 */
		public boolean isExternal(List<TSMFace.BorderEntry> border);
	}
	
	/** indicates whether each edge has been seen on the left side */
	private boolean[] seenLeft;
	/** indicates whether each edge has been seen on the right side */
	private boolean[] seenRight;
	/** detector for external faces */
	private ExternalFaceDetector externalFaceDetector;
	
	/**
	 * Constructs the dual graph for a given graph.
	 * <p>
	 * The external faces are detected using the given detector class.
	 * All faces that are determined to be external are put together,
	 * forming the borders of the external face.
	 * <p>
	 * The given graph may not have any faces in its list prior to
	 * calling this method.
	 * 
	 * @param graph graph for which the dual graph shall be constructed
	 * @param externalFaceDetector detector for external faces
	 */
	public void buildDual(TSMGraph graph,
			ExternalFaceDetector externalFaceDetector) {
		this.externalFaceDetector = externalFaceDetector;
		seenLeft = new boolean[graph.edges.size()];
		seenRight = new boolean[graph.edges.size()];

		for (TSMEdge edge : graph.edges) {
			if (!seenRight[edge.id])
				buildBorder(graph, edge, true);
			if (!seenLeft[edge.id])
				buildBorder(graph, edge, false);
		}
	}
	
	/**
	 * Build the border for the given edge.
	 * 
	 * @param graph graph that is currently processed
	 * @param edge starting edge for the border to create
	 * @param forward if true, the right side of the given edge
	 *     is taken to build the border
	 */
	private void buildBorder(TSMGraph graph, TSMEdge edge, boolean forward) {
		List<TSMFace.BorderEntry> border = new LinkedList<TSMFace.BorderEntry>();
		visit(edge, border, forward);
		TSMFace face;
		if (externalFaceDetector.isExternal(border))
			face = graph.externalFace;
		else
			face = new TSMFace(graph, true);
		face.borders.add(border);
		for (TSMFace.BorderEntry borderEntry : border) {
			if (borderEntry.forward)
				borderEntry.edge.rightFace = face;
			else
				borderEntry.edge.leftFace = face;
		}
	}
	
	/**
	 * Visit an edge to mark it and determine the next edge on the
	 * current face border.
	 * 
	 * @param edge edge to visit
	 * @param border current face border
	 * @param forward indicates whether the given edge is traversed
	 *     in forward direction
	 */
	private void visit(TSMEdge edge, List<TSMFace.BorderEntry> border,
			boolean forward) {
		TSMNode secondNode;
		if (forward) {
			seenRight[edge.id] = true;
			secondNode = edge.target;
		}
		else {
			seenLeft[edge.id] = true;
			secondNode = edge.source;
		}
		border.add(new TSMFace.BorderEntry(edge, forward));
		TSMNode.IncEntry nextEdge = getNextEdge(secondNode, edge, forward);
		boolean nextForward = (nextEdge.type == TSMNode.IncEntry.Type.OUT);
		if (nextForward && !seenRight[nextEdge.edge.id]
				|| !nextForward && !seenLeft[nextEdge.edge.id])
			visit(nextEdge.edge, border, nextForward);
	}
	
	/**
	 * Determines the next edge on the current face border.
	 * 
	 * @param node current node, common to both the previous and the
	 *     next edge
	 * @param prevEdge previous edge on the face border
	 * @param prevIncoming indicates whether the previous edge was
	 *     of incoming type for the given node 
	 * @return the next incidence list entry as seen from the previous
	 *     edge in counter-clockwise order
	 */
	private TSMNode.IncEntry getNextEdge(TSMNode node, TSMEdge prevEdge,
			boolean prevIncoming) {
		ListIterator<TSMNode.IncEntry> edgeIter = node.incidence
				.listIterator(node.incidence.size());
		while (edgeIter.hasPrevious()) {
			TSMNode.IncEntry entry = edgeIter.previous();
			if (entry.edge.id == prevEdge.id && prevIncoming
					== (entry.type == TSMNode.IncEntry.Type.IN))
				break;
		}
		if (edgeIter.hasPrevious())
			return edgeIter.previous();
		else
			return node.incidence.get(node.incidence.size() - 1);
	}
	
}

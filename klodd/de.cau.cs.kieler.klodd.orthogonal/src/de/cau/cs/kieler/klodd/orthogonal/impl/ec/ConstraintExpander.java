package de.cau.cs.kieler.klodd.orthogonal.impl.ec;

import java.util.HashMap;
import java.util.Map;

import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutEdge;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutNode;
import de.cau.cs.kieler.klodd.core.algorithms.AbstractAlgorithm;
import de.cau.cs.kieler.klodd.orthogonal.structures.*;


/**
 * Algorithm for the expansion of embedding constraints.
 * 
 * @author msp
 */
public class ConstraintExpander extends AbstractAlgorithm {

	/** mapping of unfinished outgoing edges to their already created endpoint */
	private Map<KLayoutEdge, TSMNode> outgoing2NodeMap = new HashMap<KLayoutEdge, TSMNode>();
	/** mapping of unfinished incoming edges to their already created endpoint */
	private Map<KLayoutEdge, TSMNode> incoming2NodeMap = new HashMap<KLayoutEdge, TSMNode>();
	/** TSM graph created in the expansion step */
	private TSMGraph tsmGraph;
	
	/*
	 * (non-Javadoc)
	 * @see de.cau.cs.kieler.klodd.core.algorithms.AbstractAlgorithm#reset()
	 */
	public void reset() {
		super.reset();
		outgoing2NodeMap.clear();
		incoming2NodeMap.clear();
	}
	
	/**
	 * Creates a TSM graph from a given parent layout node and
	 * expands all embedding constraints.
	 * 
	 * @param parentNode parent layout node
	 * @param constraintsMap constraints for the child nodes
	 * @return expanded TSM graph
	 */
	public TSMGraph expand(KLayoutNode parentNode,
			Map<KLayoutNode, EmbeddingConstraint> constraintsMap) {
		tsmGraph = new TSMGraph();
		
		for (KLayoutNode child : parentNode.getChildNodes()) {
			EmbeddingConstraint constraint = constraintsMap.get(child);
			if (constraint == null) {
				expandNode(child);
			}
			else {
				expandConstraint(constraint, null);
			}
		}
		
		return tsmGraph;
	}
	
	/**
	 * Creates a TSM node for the given layout node and registers all
	 * incident edges.
	 * 
	 * @param layoutNode layout node to process
	 */
	private void expandNode(KLayoutNode layoutNode) {
		TSMNode tsmNode = new TSMNode(tsmGraph, TSMNode.Type.LAYOUT, layoutNode);
		for (KLayoutEdge edge : layoutNode.getOutgoingEdges()) {
			registerEdge(tsmNode, edge, true);
		}
		for (KLayoutEdge edge : layoutNode.getIncomingEdges()) {
			registerEdge(tsmNode, edge, false);
		}
	}
	
	/**
	 * Expands a given embedding constraint and connects the expansion with
	 * the given TSM node.
	 * 
	 * @param constraint embedding constraint to expand
	 * @param parentNode TSM node to connect, or null if there is none
	 */
	private void expandConstraint(EmbeddingConstraint constraint, TSMNode parentNode) {
		switch (constraint.type) {
		case OUT_EDGE:
		case IN_EDGE:
			// connect an edge with the parent constraint
			assert parentNode != null;
			KLayoutEdge edge = (KLayoutEdge)constraint.object;
			registerEdge(parentNode, edge, constraint.type
					== EmbeddingConstraint.Type.OUT_EDGE);
			break;
		case GROUPING:
			// create a single node and connect children with it
			TSMNode groupingNode = new TSMNode(tsmGraph, TSMNode.Type.ECEXPANSION,
					constraint);
			if (parentNode != null) {
				TSMEdge newEdge = new TSMEdge(tsmGraph, parentNode, groupingNode);
				newEdge.connectNodes();
			}
			for (EmbeddingConstraint childConstraint : constraint.children) {
				expandConstraint(childConstraint, groupingNode);
			}
			break;
		case ORIENTED:
		case MIRROR:
			// for oriented and mirrored constraints a wheel gadget is created
			TSMNode hubNode = new TSMNode(tsmGraph, TSMNode.Type.ECEXPANSION,
					constraint);
			TSMNode firstNode = null, lastNode = null;
			if (parentNode != null) {
				firstNode = new TSMNode(tsmGraph, TSMNode.Type.ECEXPANSION);
				TSMEdge newEdge = new TSMEdge(tsmGraph, firstNode, hubNode);
				newEdge.connectNodes();
				lastNode = new TSMNode(tsmGraph, TSMNode.Type.ECEXPANSION);
				newEdge = new TSMEdge(tsmGraph, hubNode, lastNode);
				newEdge.connectNodes();
				newEdge = new TSMEdge(tsmGraph, firstNode, lastNode);
				newEdge.connectNodes();
				newEdge = new TSMEdge(tsmGraph, parentNode, firstNode);
				newEdge.connectNodes();
			}
			for (EmbeddingConstraint childConstraint : constraint.children) {
				TSMNode xNode = new TSMNode(tsmGraph, TSMNode.Type.ECEXPANSION);
				TSMEdge newEdge = new TSMEdge(tsmGraph, xNode, hubNode);
				newEdge.connectNodes();
				TSMNode yNode = new TSMNode(tsmGraph, TSMNode.Type.ECEXPANSION);
				newEdge = new TSMEdge(tsmGraph, hubNode, yNode);
				newEdge.connectNodes();
				newEdge = new TSMEdge(tsmGraph, xNode, yNode);
				newEdge.connectNodes();
				if (lastNode == null)
					firstNode = xNode;
				else {
					newEdge = new TSMEdge(tsmGraph, lastNode, xNode);
					newEdge.connectNodes();
				}
				expandConstraint(childConstraint, xNode);
				lastNode = yNode;
			}
			if (lastNode != null) {
				TSMEdge newEdge = new TSMEdge(tsmGraph, lastNode, firstNode);
				newEdge.connectNodes();
			}
			break;
		}
	}
	
	/**
	 * Registers a given layout graph edge. If the other endpoint of the
	 * edge is already registered, a new TSM edge connecting the corresponding
	 * TSM nodes is created.
	 * 
	 * @param tsmNode TSM node incident to the given edge
	 * @param kEdge layout graph edge
	 * @param forward if true, the edge goes out of the given TSM node,
	 *     else it comes into the given TSM node
	 */
	private void registerEdge(TSMNode tsmNode, KLayoutEdge kEdge, boolean forward) {
		if (forward) {
			TSMNode endPoint = incoming2NodeMap.get(kEdge);
			if (endPoint == null) {
				outgoing2NodeMap.put(kEdge, tsmNode);
			}
			else {
				TSMEdge edge = new TSMEdge(tsmGraph, tsmNode, endPoint, kEdge);
				edge.connectNodes();
			}
		}
		else {
			TSMNode endPoint = outgoing2NodeMap.get(kEdge);
			if (endPoint == null) {
				incoming2NodeMap.put(kEdge, tsmNode);
			}
			else {
				TSMEdge edge = new TSMEdge(tsmGraph, endPoint, tsmNode, kEdge);
				edge.connectNodes();
			}
		}
	}
	
}

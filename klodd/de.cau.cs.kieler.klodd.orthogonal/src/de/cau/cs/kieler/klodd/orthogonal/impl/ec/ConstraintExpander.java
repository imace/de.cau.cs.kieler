package de.cau.cs.kieler.klodd.orthogonal.impl.ec;

import java.util.HashMap;
import java.util.Map;

import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KEdge;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KNodeGroup;
import de.cau.cs.kieler.klodd.core.algorithms.AbstractAlgorithm;
import de.cau.cs.kieler.klodd.orthogonal.structures.*;


/**
 * Algorithm for the expansion of embedding constraints.
 * 
 * @author msp
 */
public class ConstraintExpander extends AbstractAlgorithm {

	/** mapping of unfinished outgoing edges to their already created endpoint */
	private Map<KEdge, TSMNode> outgoing2NodeMap = new HashMap<KEdge, TSMNode>();
	/** mapping of unfinished incoming edges to their already created endpoint */
	private Map<KEdge, TSMNode> incoming2NodeMap = new HashMap<KEdge, TSMNode>();
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
	 * Creates a TSM graph from a given parent node group and
	 * expands all embedding constraints.
	 * 
	 * @param parentGroup parent node group
	 * @param constraintsMap constraints for the child nodes
	 * @return expanded TSM graph
	 */
	public TSMGraph expand(KNodeGroup parentGroup,
			Map<KNodeGroup, EmbeddingConstraint> constraintsMap) {
		tsmGraph = new TSMGraph(parentGroup);
		
		for (KNodeGroup child : parentGroup.getSubNodeGroups()) {
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
	 * @param nodeGroup layout node to process
	 */
	private void expandNode(KNodeGroup nodeGroup) {
		TSMNode tsmNode = new TSMNode(tsmGraph, nodeGroup);
		for (KEdge edge : nodeGroup.getOutgoingEdges()) {
			registerEdge(tsmNode, edge, true);
		}
		for (KEdge edge : nodeGroup.getIncomingEdges()) {
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
		case EDGE:
			// connect an edge with the parent constraint
			assert parentNode != null;
			KEdge edge = (KEdge)constraint.object;
			boolean forward = edge.getSourcePort() == constraint.parent.object;
			registerEdge(parentNode, edge, forward);
			break;
		case GROUPING:
			// create a single node and connect children with it
			TSMNode groupingNode = new TSMNode(tsmGraph, constraint);
			if (parentNode != null) {
				new TSMEdge(tsmGraph, parentNode, groupingNode);
			}
			for (EmbeddingConstraint childConstraint : constraint.children) {
				expandConstraint(childConstraint, groupingNode);
			}
			break;
		case ORIENTED:
		case MIRROR:
			// for oriented and mirrored constraints a wheel gadget is created
			TSMNode hubNode = new TSMNode(tsmGraph, constraint);
			TSMNode firstNode = null, lastNode = null;
			if (parentNode != null) {
				firstNode = new TSMNode(tsmGraph);
				new TSMEdge(tsmGraph, firstNode, hubNode);
				lastNode = new TSMNode(tsmGraph);
				new TSMEdge(tsmGraph, hubNode, lastNode);
				new TSMEdge(tsmGraph, firstNode, lastNode);
				new TSMEdge(tsmGraph, parentNode, firstNode);
			}
			for (EmbeddingConstraint childConstraint : constraint.children) {
				TSMNode xNode = new TSMNode(tsmGraph);
				new TSMEdge(tsmGraph, xNode, hubNode);
				TSMNode yNode = new TSMNode(tsmGraph);
				new TSMEdge(tsmGraph, hubNode, yNode);
				new TSMEdge(tsmGraph, xNode, yNode);
				if (lastNode == null)
					firstNode = xNode;
				else
					new TSMEdge(tsmGraph, lastNode, xNode);
				expandConstraint(childConstraint, xNode);
				lastNode = yNode;
			}
			if (lastNode != null)
				new TSMEdge(tsmGraph, lastNode, firstNode);
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
	private void registerEdge(TSMNode tsmNode, KEdge kEdge, boolean forward) {
		if (forward) {
			TSMNode endPoint = incoming2NodeMap.get(kEdge);
			if (endPoint == null) {
				outgoing2NodeMap.put(kEdge, tsmNode);
			}
			else {
				new TSMEdge(tsmGraph, tsmNode, endPoint, kEdge);
			}
		}
		else {
			TSMNode endPoint = outgoing2NodeMap.get(kEdge);
			if (endPoint == null) {
				incoming2NodeMap.put(kEdge, tsmNode);
			}
			else {
				new TSMEdge(tsmGraph, endPoint, tsmNode, kEdge);
			}
		}
	}
	
}

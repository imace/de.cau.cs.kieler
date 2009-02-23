package de.cau.cs.kieler.klodd.orthogonal.impl.ec;

import java.util.HashMap;
import java.util.Map;

import de.cau.cs.kieler.core.alg.AbstractAlgorithm;
import de.cau.cs.kieler.core.graph.KEdge;
import de.cau.cs.kieler.core.graph.KGraph;
import de.cau.cs.kieler.core.graph.KNode;
import de.cau.cs.kieler.klodd.orthogonal.structures.*;


/**
 * Algorithm for the expansion of embedding constraints.
 * 
 * @author msp
 */
public class ConstraintExpander extends AbstractAlgorithm {
	
	/** the new graph created during EC expansion */
	private TSMGraph expandedGraph;
	private Map<KEdge, TSMNode> incoming2NodeMap = new HashMap<KEdge, TSMNode>();
	private Map<KEdge, TSMNode> outgoing2NodeMap = new HashMap<KEdge, TSMNode>();
	
	/**
	 * Creates a TSM graph from a given parent layout node and
	 * expands all embedding constraints.
	 * 
	 * @param parentNode parent layout node
	 * @param constraintsMap constraints for the child nodes
	 * @return expanded TSM graph
	 */
	public TSMGraph expand(KGraph graph) {
		expandedGraph = new TSMGraph();
		
		for (KNode node : graph.nodes) {
			TSMNode tsmNode = (TSMNode)node;
			if (tsmNode.embeddingConstraint == null) {
				expandNode(node);
			}
			else {
				expandConstraint(tsmNode.embeddingConstraint, null);
			}
		}
		
		return expandedGraph;
	}
	
	/**
	 * Creates a new node for the given node of the input graph and
	 * registers all incident edges.
	 * 
	 * @param node node of the input graph
	 */
	private void expandNode(KNode node) {
		TSMNode newNode = new TSMNode(expandedGraph, TSMNode.Type.ECEXPANSION, node);
		for (KNode.IncEntry edgeEntry : node.incidence) {
			registerEdge(newNode, (TSMEdge)edgeEntry.edge,
					edgeEntry.type == KNode.IncEntry.Type.OUT);
		}
	}
	
	/**
	 * Expands a given embedding constraint and connects the expansion with
	 * the given node.
	 * 
	 * @param constraint embedding constraint to expand
	 * @param parentNode node to connect, or null if there is none
	 */
	private void expandConstraint(EmbeddingConstraint constraint,
			TSMNode parentNode) {
		switch (constraint.type) {
		case OUT_EDGE:
		case IN_EDGE:
			// connect an edge with the parent constraint
			assert parentNode != null;
			TSMEdge edge = (TSMEdge)constraint.object;
			registerEdge(parentNode, edge, constraint.type
					== EmbeddingConstraint.Type.OUT_EDGE);
			break;
		case GROUPING:
			// create a single node and connect children with it
			TSMNode groupingNode = new TSMNode(expandedGraph, TSMNode.Type.ECEXPANSION,
					constraint);
			if (parentNode != null) {
				KEdge newEdge = new KEdge(expandedGraph, parentNode, groupingNode);
				newEdge.connectNodes();
			}
			for (EmbeddingConstraint childConstraint : constraint.children) {
				expandConstraint(childConstraint, groupingNode);
			}
			break;
		case ORIENTED:
		case MIRROR:
			// for oriented and mirrored constraints a wheel gadget is created
			KNode hubNode = new TSMNode(expandedGraph, TSMNode.Type.ECEXPANSION,
					constraint);
			KNode firstNode = null, lastNode = null;
			if (parentNode != null) {
				firstNode = new TSMNode(expandedGraph, TSMNode.Type.ECEXPANSION);
				KEdge newEdge = new KEdge(expandedGraph, firstNode, hubNode);
				newEdge.connectNodes();
				lastNode = new TSMNode(expandedGraph, TSMNode.Type.ECEXPANSION);
				newEdge = new KEdge(expandedGraph, hubNode, lastNode);
				newEdge.connectNodes();
				newEdge = new KEdge(expandedGraph, firstNode, lastNode);
				newEdge.connectNodes();
				newEdge = new KEdge(expandedGraph, parentNode, firstNode);
				newEdge.connectNodes();
			}
			for (EmbeddingConstraint childConstraint : constraint.children) {
				TSMNode xNode = new TSMNode(expandedGraph, TSMNode.Type.ECEXPANSION);
				KEdge newEdge = new KEdge(expandedGraph, xNode, hubNode);
				newEdge.connectNodes();
				KNode yNode = new TSMNode(expandedGraph, TSMNode.Type.ECEXPANSION);
				newEdge = new KEdge(expandedGraph, hubNode, yNode);
				newEdge.connectNodes();
				newEdge = new KEdge(expandedGraph, xNode, yNode);
				newEdge.connectNodes();
				if (lastNode == null)
					firstNode = xNode;
				else {
					newEdge = new KEdge(expandedGraph, lastNode, xNode);
					newEdge.connectNodes();
				}
				expandConstraint(childConstraint, xNode);
				lastNode = yNode;
			}
			if (lastNode != null) {
				KEdge newEdge = new KEdge(expandedGraph, lastNode, firstNode);
				newEdge.connectNodes();
			}
			break;
		}
	}
	
	/**
	 * Registers a given edge of the input graph. If the other endpoint of the
	 * edge is already registered, a new edge connecting the corresponding
	 * expanded nodes is created.
	 * 
	 * @param node node incident to the given edge in the expanded graph
	 * @param edge edge of the input graph
	 * @param forward if true, the edge goes out of the given node,
	 *     else it comes into the given node
	 */
	private void registerEdge(TSMNode node, TSMEdge edge, boolean forward) {
		if (forward) {
			TSMNode endPoint = incoming2NodeMap.get(edge);
			if (endPoint == null) {
				outgoing2NodeMap.put(edge, node);
			}
			else {
				KEdge newEdge = new TSMEdge(expandedGraph, node, endPoint,
						edge.layoutEdge);
				newEdge.connectNodes();
			}
		}
		else {
			KNode endPoint = outgoing2NodeMap.get(edge);
			if (endPoint == null) {
				incoming2NodeMap.put(edge, node);
			}
			else {
				KEdge newEdge = new TSMEdge(expandedGraph, endPoint, node,
						edge.layoutEdge);
				newEdge.connectNodes();
			}
		}
	}
	
}

package de.cau.cs.kieler.klodd.orthogonal.impl.ec;

import de.cau.cs.kieler.core.alg.AbstractAlgorithm;
import de.cau.cs.kieler.klodd.orthogonal.modules.IPlanarizer;
import de.cau.cs.kieler.klodd.orthogonal.structures.*;


/**
 * Planarizer implementation that handles embedding constraints by
 * inserting all edges with an EC edge inserter.
 * 
 * @author msp
 */
public class EdgeInsertionECPlanarizer extends AbstractAlgorithm implements
		IPlanarizer {
	
	/*
	 * (non-Javadoc)
	 * @see de.cau.cs.kieler.klodd.orthogonal.modules.IPlanarizer#planarize(de.cau.cs.kieler.klodd.orthogonal.structures.TSMGraph)
	 */
	public void planarize(TSMGraph graph) {
		// remove all edges from the incidence lists
		for (TSMNode node : graph.nodes)
			node.incidence.clear();
		
		// insert the stored edges, one by one, and preserve planarity
		ECEdgeInserter edgeInserter = new ECEdgeInserter();
		edgeInserter.setGraph(graph);
		for (TSMEdge edge : graph.edges) {
			EmbeddingConstraint sourceConstraint = edge.source.embeddingConstraint;
			EmbeddingConstraint targetConstraint = edge.target.embeddingConstraint;
			edgeInserter.insertEdge(edge, sourceConstraint, targetConstraint);
		}
	}

}

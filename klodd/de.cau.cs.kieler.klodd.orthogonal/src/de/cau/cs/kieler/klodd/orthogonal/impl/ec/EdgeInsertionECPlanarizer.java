package de.cau.cs.kieler.klodd.orthogonal.impl.ec;

import de.cau.cs.kieler.core.alg.AbstractAlgorithm;
import de.cau.cs.kieler.core.graph.KEdge;
import de.cau.cs.kieler.core.graph.KGraph;
import de.cau.cs.kieler.core.graph.KNode;
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
	public void planarize(KGraph graph) {
		getMonitor().begin("Edge insertion planarization", graph.edges.size());
		// remove all edges from the incidence lists
		for (KNode node : graph.nodes)
			node.incidence.clear();
		
		// insert the stored edges, one by one, and preserve planarity
		ECEdgeInserter edgeInserter = new ECEdgeInserter();
		edgeInserter.setGraph(graph);
		for (KEdge edge : graph.edges) {
			EmbeddingConstraint sourceConstraint = ((TSMNode)edge.source)
					.embeddingConstraint;
			EmbeddingConstraint targetConstraint = ((TSMNode)edge.target)
					.embeddingConstraint;
			edgeInserter.setProgressMonitor(getMonitor().subTask(1));
			edgeInserter.insertEdge(edge, sourceConstraint, targetConstraint);
		}
		
		getMonitor().done();
	}

}

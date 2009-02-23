package de.cau.cs.kieler.klodd.orthogonal.impl.ec;

import java.util.Map;

import de.cau.cs.kieler.core.alg.AbstractAlgorithm;
import de.cau.cs.kieler.core.graph.KGraph;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutNode;
import de.cau.cs.kieler.klodd.orthogonal.modules.IPlanarizer;


/**
 * Planarizer implementation that handles embedding constraints by
 * performing EC expansion and EC planarity test.
 * 
 * @author msp
 */
public class ExpansionECPlanarizer extends AbstractAlgorithm implements
		IPlanarizer {

	/*
	 * (non-Javadoc)
	 * @see de.cau.cs.kieler.klodd.orthogonal.modules.IPlanarizer#planarize(de.cau.cs.kieler.klodd.orthogonal.structures.TSMGraph)
	 */
	public void planarize(KGraph graph) {
		getMonitor().begin("EC Expansion planarization", 1);
		
		// expand the given embedding constraints
		ConstraintExpander constraintExpander = new ConstraintExpander();
		constraintExpander.expand(graph);

		// TODO implement EC-planarization of the expanded graph
		
		getMonitor().done();
	}

}

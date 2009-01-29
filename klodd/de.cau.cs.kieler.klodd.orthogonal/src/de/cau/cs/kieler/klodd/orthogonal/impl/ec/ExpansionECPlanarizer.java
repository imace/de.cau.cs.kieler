package de.cau.cs.kieler.klodd.orthogonal.impl.ec;

import java.util.Map;

import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KNodeGroup;
import de.cau.cs.kieler.klodd.core.algorithms.AbstractAlgorithm;
import de.cau.cs.kieler.klodd.orthogonal.modules.IECPlanarizer;
import de.cau.cs.kieler.klodd.orthogonal.structures.TSMGraph;


/**
 * Planarizer implementation that handles embedding constraints by
 * performing EC expansion and EC planarity test.
 * 
 * @author msp
 */
public class ExpansionECPlanarizer extends AbstractAlgorithm implements
		IECPlanarizer {

	/** map of embedding constraints */
	private Map<KNodeGroup, EmbeddingConstraint> constraintsMap = null;
	
	/*
	 * (non-Javadoc)
	 * @see de.cau.cs.kieler.klodd.core.algorithms.AbstractAlgorithm#reset()
	 */
	public void reset() {
		super.reset();
		constraintsMap = null;
	}
	
	/* (non-Javadoc)
	 * @see de.cau.cs.kieler.klodd.orthogonal.modules.IECPlanarizer#setConstraints(java.util.Map)
	 */
	public void setConstraints(
			Map<KNodeGroup, EmbeddingConstraint> constraintsMap) {
		this.constraintsMap = constraintsMap;
	}

	/* (non-Javadoc)
	 * @see de.cau.cs.kieler.klodd.orthogonal.modules.IPlanarizer#planarize(de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KNodeGroup)
	 */
	public TSMGraph planarize(KNodeGroup nodeGroup) {
		if (constraintsMap == null)
			throw new IllegalStateException("The method setConstraints() must be called first.");
		
		// expand the given embedding constraints
		ConstraintExpander constraintExpander = new ConstraintExpander();
		TSMGraph expandedGraph = constraintExpander.expand(nodeGroup, constraintsMap);

		// TODO implement EC-planarization of the expanded graph
		
		return null;
	}

}

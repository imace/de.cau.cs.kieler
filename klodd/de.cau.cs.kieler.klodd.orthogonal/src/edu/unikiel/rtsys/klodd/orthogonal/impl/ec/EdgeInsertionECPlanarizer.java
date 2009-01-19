package edu.unikiel.rtsys.klodd.orthogonal.impl.ec;

import java.util.Map;

import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KNodeGroup;
import edu.unikiel.rtsys.klodd.core.algorithms.AbstractAlgorithm;
import edu.unikiel.rtsys.klodd.orthogonal.modules.IECPlanarizer;
import edu.unikiel.rtsys.klodd.orthogonal.structures.TSMGraph;

/**
 * 
 * @author msp
 */
public class EdgeInsertionECPlanarizer extends AbstractAlgorithm implements
		IECPlanarizer {

	/** map of embedding constraints */
	private Map<KNodeGroup, EmbeddingConstraint> constraintsMap = null;
	
	/*
	 * (non-Javadoc)
	 * @see edu.unikiel.rtsys.klodd.core.algorithms.AbstractAlgorithm#reset()
	 */
	public void reset() {
		super.reset();
		constraintsMap = null;
	}
	
	/* (non-Javadoc)
	 * @see edu.unikiel.rtsys.klodd.orthogonal.modules.IECPlanarizer#setConstraints(java.util.Map)
	 */
	public void setConstraints(
			Map<KNodeGroup, EmbeddingConstraint> constraintsMap) {
		this.constraintsMap = constraintsMap;
	}

	/* (non-Javadoc)
	 * @see edu.unikiel.rtsys.klodd.orthogonal.modules.IPlanarizer#planarize(edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KNodeGroup)
	 */
	public TSMGraph planarize(KNodeGroup nodeGroup) {
		if (constraintsMap == null)
			throw new IllegalStateException("The method setConstraints() must be called first.");
		
		// TODO implement planarization through edge insertion
		// build normal graph without edges, store edges in a list
		// build dual graph with exactly one (external) face
		// insert the stored edges, one by one, and preserve planarity
		
		return null;
	}

}

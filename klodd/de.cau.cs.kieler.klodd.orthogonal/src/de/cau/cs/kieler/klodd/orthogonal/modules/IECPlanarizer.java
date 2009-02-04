package de.cau.cs.kieler.klodd.orthogonal.modules;

import java.util.Map;

import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutNode;
import de.cau.cs.kieler.klodd.orthogonal.impl.ec.EmbeddingConstraint;


/**
 * Interface for algorithms that perform planarization of a graph considering
 * embedding constraints.
 * 
 * @author msp
 */
public interface IECPlanarizer extends IPlanarizer {

	/**
	 * Set the embedding constraints to use for planarization. This method
	 * must be called before <code>planarize</code>.
	 * 
	 * @param constraintsMap
	 */
	public void setConstraints(Map<KLayoutNode, EmbeddingConstraint> constraintsMap);
	
}

package de.cau.cs.kieler.klodd.orthogonal.structures;

/**
 * An element of a TSM graph, which can be a node, an edge or a face.
 * 
 * @author msp
 */
public abstract class TSMGraphElement {

	/** identifier of this element, determined at creation time */
	public int id;
	/** rank of this element, used by various algorithms */
	public int rank = 0;
	
}

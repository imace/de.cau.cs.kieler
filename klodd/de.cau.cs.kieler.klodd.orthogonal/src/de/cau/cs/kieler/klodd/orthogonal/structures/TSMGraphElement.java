package de.cau.cs.kieler.klodd.orthogonal.structures;

/**
 * An element of a TSM graph, which can be a node, an edge or a face.
 * 
 * @author msp
 */
public abstract class TSMGraphElement implements Comparable<TSMGraphElement> {

	/** identifier of this element, determined at creation time */
	public int id;
	/** rank of this element, used by various algorithms */
	public int rank = 0;
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(TSMGraphElement other) {
		return this.id > other.id ? 1
				: (this.id < other.id ? -1
				: 0);
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object other) {
		return (other.getClass() == this.getClass())
				&& ((TSMGraphElement)other).id == this.id;
	}
	
}

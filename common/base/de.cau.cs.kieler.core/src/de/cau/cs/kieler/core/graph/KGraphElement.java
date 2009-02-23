package de.cau.cs.kieler.core.graph;

/**
 * An element of a KIELER graph, which can be a node, an edge or a face.
 * 
 * @author msp
 */
public abstract class KGraphElement implements Comparable<KGraphElement> {

	/** identifier of this element, determined at creation time */
	public int id;
	/** rank of this element, used by various algorithms */
	public int rank = 0;
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(KGraphElement other) {
		return this.id - other.id;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object other) {
		return (other.getClass() == this.getClass())
				&& ((KGraphElement)other).id == this.id;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return getClass().getSimpleName() + "(" + id + ")";
	}
	
}

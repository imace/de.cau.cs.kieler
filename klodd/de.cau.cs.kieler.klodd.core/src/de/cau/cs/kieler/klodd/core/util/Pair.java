package de.cau.cs.kieler.klodd.core.util;

/**
 * A simple pair implementation.
 * 
 * @author msp
 */
public class Pair <F, S> {

	/** the first element */
	public F first;
	/** the second element */
	public S second;
	
	/**
	 * Constructs a pair given both elements.
	 * 
	 * @param first the first element
	 * @param second the second element
	 */
	public Pair (F first, S second) {
		this.first = first;
		this.second = second;
	}
	
}

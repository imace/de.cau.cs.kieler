package edu.unikiel.rtsys.klodd.hierarchical.structures;

import java.util.LinkedList;
import java.util.List;

/**
 * A linear segment of layer elements that represents a long edge in
 * a layered graph.
 * 
 * @author msp
 */
public class LinearSegment implements Comparable<LinearSegment> {
	
	/** list of layer elements contained in this linear segment */
	public List<LayerElement> elements = new LinkedList<LayerElement>();
	/** current rank of the linear segment */
	public int rank = 0;
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(LinearSegment other) {
		return this.rank == other.rank ? 0
				: (this.rank > other.rank ? 1
				: -1);
	}
	
}

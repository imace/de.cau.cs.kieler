/******************************************************************************
 * KIELER - Kiel Integrated Environment for Layout for the Eclipse RCP
 *
 * http://www.informatik.uni-kiel.de/rtsys/kieler/
 * 
 * Copyright 2008 by
 * + Christian-Albrechts-University of Kiel
 *   + Department of Computer Science
 *     + Real-Time and Embedded Systems Group
 * 
 * This code is provided under the terms of the Eclipse Public License (EPL).
 * See the file epl-v10.html for the license text.
 */
package de.cau.cs.kieler.klodd.hierarchical.structures;

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
	public int rank = -1;
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return elements.toString();
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(LinearSegment other) {
		return this.rank == other.rank ? 0
				: (this.rank > other.rank ? 1
				: -1);
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object obj) {
		return obj instanceof LinearSegment
				&& ((LinearSegment)obj).rank == this.rank;
	}
	
}

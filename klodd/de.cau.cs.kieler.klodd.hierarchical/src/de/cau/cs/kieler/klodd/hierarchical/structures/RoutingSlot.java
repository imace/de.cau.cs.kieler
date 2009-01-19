package de.cau.cs.kieler.klodd.hierarchical.structures;

/**
 * A routing slot is a place in which layer connections can be routed. 
 * 
 * @author msp
 */
public class RoutingSlot {
	
	/** the slot rank determines the lengthwise distance to the preceding layer */
	public int rank;
	
	/** crosswise starting and ending position of this slot */
	public float start, end;
	
}

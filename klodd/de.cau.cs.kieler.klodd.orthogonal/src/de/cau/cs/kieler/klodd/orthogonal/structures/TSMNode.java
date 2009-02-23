package de.cau.cs.kieler.klodd.orthogonal.structures;

import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutNode;
import de.cau.cs.kieler.klodd.orthogonal.impl.ec.EmbeddingConstraint;
import de.cau.cs.kieler.core.graph.*;

/**
 * A node in the graph structure used for the topology-shape-metrics
 * approach.
 * 
 * @author msp
 */
public class TSMNode extends KNode {

	/**
	 * Types of created node objects.
	 */
	public enum Type {
		/** node derived from the layout graph */
		LAYOUT,
		/** node created for EC expansion */
		ECEXPANSION,
		/** node created to replace an edge crossing */
		CROSSING,
		/** node created to replace an edge bend */
		BEND,
		/** node for normalization, north-east corner */
		NORM_NE,
		/** node for normalization, south-east corner */
		NORM_SE,
		/** node for normalization, south-west corner */
		NORM_SW,
		/** node for normalization, north-west corner */
		NORM_NW,
		/** node for normalization, port */
		NORM_PORT,
		/** node for refinement */
		REFINEMENT
	}
	
	/** the type of this node */
	public Type type;
	/** the embedding constraint for planarization of this node */
	public EmbeddingConstraint embeddingConstraint;
	/** abstract x coordinate position */
	public int abstrXpos;
	/** abstract y coordinate position */
	public int abstrYpos;
	
	/**
	 * Creates a node containing the given object.
	 * 
	 * @param graph the graph to which the new node shall be added
	 * @param type node type
	 * @param obj the object to be contained
	 */
	public TSMNode(KGraph graph, Type type, Object obj) {
		super(graph, obj);
		this.type = type;
	}
	
	/**
	 * Creates a node containing no object.
	 * 
	 * @param graph the graph to which the new node shall be added
	 * @param type node type
	 */
	public TSMNode(KGraph graph, Type type) {
		super(graph);
		this.type = type;
	}
	
	/**
	 * Applies the new layout to the original layout node.
	 * 
	 * @param offsetX x offset to be added
	 * @param offsetY y offset to be added
	 */
	public void applyLayout(float offsetX, float offsetY) {
		if (object instanceof KLayoutNode) {
			KLayoutNode layoutNode = (KLayoutNode)object;
			layoutNode.getLayout().getLocation().setX(xpos + offsetX);
			layoutNode.getLayout().getLocation().setY(ypos + offsetY);
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see de.cau.cs.kieler.klodd.orthogonal.structures.TSMGraphElement#toString()
	 */
	public String toString() {
		String baseString = super.toString();
		if (object instanceof KLayoutNode)
			return baseString + " \"" + ((KLayoutNode)object).getLabel().getText() + "\"";
		else return baseString + " " + type.toString();
	}
	
}

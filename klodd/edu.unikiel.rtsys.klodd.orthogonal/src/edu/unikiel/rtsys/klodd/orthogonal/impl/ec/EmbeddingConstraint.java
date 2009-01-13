package edu.unikiel.rtsys.klodd.orthogonal.impl.ec;

import java.util.LinkedList;
import java.util.List;

/**
 * Embedding constraint used by the EC embedding planarizer.
 * 
 * @author msp
 */
public class EmbeddingConstraint {

	/**
	 * Definition of constraint types.
	 */
	public enum Type {
		/** this constraint object contains an edge */
		EDGE,
		/** the order of children is fixed */
		ORIENTED,
		/** the order of children may be reversed */
		MIRROR,
		/** the order of children may be arbitrarily permuted */
		GROUPING
	}

	/** the type of embedding constraint */
	public Type type;
	/** the children of this embedding constraint */
	public List<EmbeddingConstraint> children = null;
	/** the parent of this embedding constraint */
	public EmbeddingConstraint parent;
	/** the contained object */
	public Object object;
	
	/**
	 * Creates an embedding constraint of given type.
	 * 
	 * @param type the type of embedding constraint
	 * @param parent the parent constraint, or null if there is no parent
	 * @param the object to be contained
	 */
	public EmbeddingConstraint(Type type, EmbeddingConstraint parent, Object obj) {
		this.type = type;
		this.parent = parent;
		this.object = obj;
		if (type != Type.EDGE)
			this.children = new LinkedList<EmbeddingConstraint>();
	}
	
}

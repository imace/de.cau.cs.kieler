package de.cau.cs.kieler.core.graph.alg;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import de.cau.cs.kieler.core.alg.AbstractAlgorithm;
import de.cau.cs.kieler.core.graph.KEdge;
import de.cau.cs.kieler.core.graph.KNode;


/**
 * Abstract superclass that can be used for implementations of cycle
 * remover algorithms which operate by reversing edges.
 * 
 * @author msp
 */
public abstract class AbstractCycleRemover extends AbstractAlgorithm
		implements ICycleRemover {
	
	/**	list of edges that are reversed and later restored */
	protected LinkedList<KEdge> reversedEdges = null;

	/*
	 * (non-Javadoc)
	 * @see de.cau.cs.kieler.core.alg.AbstractAlgorithm#reset()
	 */
	public void reset() {
		super.reset();
		reversedEdges = null;
	}
	
	/*
	 * (non-Javadoc)
	 * @see de.cau.cs.kieler.core.graph.alg.ICycleRemover#restoreGraph()
	 */
	public void restoreGraph() {
		if (reversedEdges != null)
			reverseEdges();
	}
	
	/*
	 * (non-Javadoc)
	 * @see de.cau.cs.kieler.core.graph.alg.ICycleRemover#getReversedEdges()
	 */
	public List<KEdge> getReversedEdges() throws IllegalStateException {
		if (reversedEdges == null)
			throw new IllegalStateException("removeCycles must be called before getReversedEdges.");
		else return reversedEdges;
	}
	
	/**
	 * Switches the source and target of all edges marked in the
	 * <code>reversedEdges</code> list.
	 */
	protected void reverseEdges() {
		for (KEdge edge : reversedEdges) {
			edge.rank = ICycleRemover.REVERSED;
			// change incidence type at source and target
			ListIterator<KNode.IncEntry> sourceIter = edge.source
					.getIterator(edge, true);
			ListIterator<KNode.IncEntry> targetIter = edge.target
					.getIterator(edge, false);
			if (sourceIter != null)
				sourceIter.previous().type = KNode.IncEntry.Type.IN;
			if (targetIter != null)
				targetIter.previous().type = KNode.IncEntry.Type.OUT;
			
			// reverse source and target node
			KNode source = edge.source;
			KNode.Side sourceSide = edge.sourceSide;
			KNode target = edge.target;
			KNode.Side targetSide = edge.targetSide;
			edge.source = target;
			edge.sourceSide = targetSide;
			edge.target = source;
			edge.targetSide = sourceSide;
		}
	}
	
}

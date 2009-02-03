package de.cau.cs.kieler.klodd.orthogonal.impl;

import de.cau.cs.kieler.klodd.core.algorithms.AbstractAlgorithm;
import de.cau.cs.kieler.klodd.orthogonal.modules.ICompacter;
import de.cau.cs.kieler.klodd.orthogonal.structures.TSMGraph;

/**
 * Compacter implementation that refines the graph and executes
 * another compacter for refined orthogonal representations. This
 * compacter expects a normalized orthogonal representation as input.
 * 
 * @author msp
 */
public class RefiningCompacter extends AbstractAlgorithm implements ICompacter {
	
	/** the embedded compacter for refined orthogonal representations */
	private ICompacter refinedCompacter;
	
	/*
	 * (non-Javadoc)
	 * @see de.cau.cs.kieler.klodd.core.algorithms.AbstractAlgorithm#reset()
	 */
	public void reset() {
		super.reset();
		refinedCompacter.reset();
	}
	
	/**
	 * Creates a refining compacter based on the given compacter,
	 * which should work on a refined orthogonal representation.
	 * 
	 * @param refinedCompacter compacter that expects a refined
	 *     orthogonal representation
	 */
	public RefiningCompacter(ICompacter refinedCompacter) {
		this.refinedCompacter = refinedCompacter;
	}
	
	/* (non-Javadoc)
	 * @see de.cau.cs.kieler.klodd.orthogonal.modules.ICompacter#compact(de.cau.cs.kieler.klodd.orthogonal.structures.TSMGraph)
	 */
	public void compact(TSMGraph graph) {
		// TODO Auto-generated method stub

	}

}

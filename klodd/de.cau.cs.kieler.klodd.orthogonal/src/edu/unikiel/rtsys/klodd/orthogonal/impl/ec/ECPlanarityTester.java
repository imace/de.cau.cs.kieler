package edu.unikiel.rtsys.klodd.orthogonal.impl.ec;

import edu.unikiel.rtsys.klodd.core.algorithms.AbstractAlgorithm;
import edu.unikiel.rtsys.klodd.orthogonal.modules.IPlanarityTester;
import edu.unikiel.rtsys.klodd.orthogonal.structures.GraphSection;

/**
 * Planarity tester that checks for normal planarity and EC-planarity.
 * 
 * @author msp
 */
public class ECPlanarityTester extends AbstractAlgorithm implements
		IPlanarityTester {

	/** basic planarity tester */
	private IPlanarityTester basicPlanarityTester;
	
	/*
	 * (non-Javadoc)
	 * @see edu.unikiel.rtsys.klodd.core.algorithms.AbstractAlgorithm#reset()
	 */
	public void reset() {
		super.reset();
		basicPlanarityTester.reset();
	}
	
	/**
	 * Creates an EC planarity tester using a basic planarity tester.
	 * 
	 * @param basicPlanarityTester basic planarity tester
	 */
	public ECPlanarityTester(IPlanarityTester basicPlanarityTester) {
		this.basicPlanarityTester = basicPlanarityTester;
	}
	
	/**
	 * Tests the given biconnected graph section for EC-planarity.
	 * The graph is expected to be already EC-expanded.
	 * 
	 * @param biconnectedSection graph section to be tested
	 */
	public boolean isPlanar(GraphSection biconnectedSection) {
		try {
			// test for basic planarity
			boolean basicPlanar = basicPlanarityTester.isPlanar(biconnectedSection);
			if (!basicPlanar)
				return false;
			
			// TODO construction of SPQR-tree, test for EC-planarity
			
			return true;
		}
		finally {
			biconnectedSection.restoreEdges();
		}
	}

}

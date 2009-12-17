/*
 * KIELER - Kiel Integrated Environment for Layout Eclipse RichClient
 *
 * http://www.informatik.uni-kiel.de/rtsys/kieler/
 * 
 * Copyright 2009 by
 * + Christian-Albrechts-University of Kiel
 *   + Department of Computer Science
 *     + Real-Time and Embedded Systems Group
 * 
 * This code is provided under the terms of the Eclipse Public License (EPL).
 * See the file epl-v10.html for the license text.
 */
package de.cau.cs.kieler.klodd.orthogonal.impl.ec;

import de.cau.cs.kieler.core.alg.AbstractAlgorithm;
import de.cau.cs.kieler.core.slimgraph.KGraphSection;
import de.cau.cs.kieler.core.slimgraph.alg.IPlanarityTester;

/**
 * Planarity tester that checks for normal planarity and EC-planarity.
 * 
 * @author msp
 */
public class ECPlanarityTester extends AbstractAlgorithm implements IPlanarityTester {

    /** basic planarity tester. */
    private IPlanarityTester basicPlanarityTester;

    /**
     * {@inheritDoc}
     */
    @Override
    public void reset() {
        super.reset();
        basicPlanarityTester.reset();
    }

    /**
     * Creates an EC planarity tester using a basic planarity tester.
     * 
     * @param thebasicPlanarityTester basic planarity tester
     */
    public ECPlanarityTester(final IPlanarityTester thebasicPlanarityTester) {
        this.basicPlanarityTester = thebasicPlanarityTester;
    }

    /**
     * Tests the given biconnected graph section for EC-planarity. The graph is
     * expected to be already EC-expanded.
     * 
     * @param biconnectedSection graph section to be tested
     * @return true if the graph section is planar
     */
    public boolean isPlanar(final KGraphSection biconnectedSection) {
        getMonitor().begin("EC planarity test", 1);

        try {
            // test for basic planarity
            boolean basicPlanar = basicPlanarityTester.isPlanar(biconnectedSection);
            if (!basicPlanar) {
                return false;
            }

            // TODO construction of SPQR-tree, test for EC-planarity

            return true;
        } finally {
            biconnectedSection.restoreEdges();
            getMonitor().done();
        }
    }

}

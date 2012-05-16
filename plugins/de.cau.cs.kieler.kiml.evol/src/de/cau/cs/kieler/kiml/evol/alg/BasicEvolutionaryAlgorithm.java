/*
 * KIELER - Kiel Integrated Environment for Layout Eclipse RichClient
 *
 * http://www.informatik.uni-kiel.de/rtsys/kieler/
 *
 * Copyright 2010 by
 * + Christian-Albrechts-University of Kiel
 *   + Department of Computer Science
 *     + Real-Time and Embedded Systems Group
 *
 * This code is provided under the terms of the Eclipse Public License (EPL).
 * See the file epl-v10.html for the license text.
 */

package de.cau.cs.kieler.kiml.evol.alg;

import de.cau.cs.kieler.kiml.evol.genetic.Population;

/**
 * Implementation of an evolutionary algorithm.
 *
 * @author bdu
 */
public class BasicEvolutionaryAlgorithm extends AbstractEvolutionaryAlgorithm {

    /**
     * Constructor for an evolutionary algorithm with the given initial
     * population. Creates and initializes the algorithm instance.
     *
     * @param thePopulation
     *            initial population
     */
    public BasicEvolutionaryAlgorithm(final Population thePopulation) {
        Population population = getPopulation();

        population.clear();
        population.addAll(0, thePopulation.getGenomes());

        setSelectionOperation(new SelectionOperation());
        setCrossoverOperation(new CrossOverOperation());
        setMutationOperation(new MutationOperation());
        setSurvivalOperation(new SurvivalOperation());
        setEvaluationOperation(new EvaluationOperation());

        reset();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final boolean isDone() {
        // no stop criterion here -- algorithm shall be able run forever
        return false;
    }

}

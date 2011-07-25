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
/**
 *
 */
package de.cau.cs.kieler.kiml.evol.alg;

import de.cau.cs.kieler.kiml.evol.genetic.Genome;
import de.cau.cs.kieler.kiml.evol.genetic.Population;

/**
 * @author bdu
 *
 */
public class MutationOperation implements IEvolutionaryOperation {
    /**
     * The mutation application probability. This is the probability for each
     * individual to be subject to mutation.
     */
    private static final double MUTATION_APPLICATION_PROBABILITY = 0.6;

    /**
     * {@inheritDoc}
     */
    public final void process(final Population population) {

        final double prob = MUTATION_APPLICATION_PROBABILITY;
        System.out.println(" -- mutate all " + population.size() + ", each with probability of "
                + prob);
        Population mutations = new Population();
        for (final Genome ind : population) {
            Genome mutation = ind.newMutation(prob);
            if (mutation != null) {
                // individual has mutated --> rating is outdated
                mutation.fadeUserRating();
                mutations.add(mutation);
                System.out.println("-- Mutation performed: " + ind);
            } else {
                mutations.add(ind);
            }
        }
        population.clear();

        population.addAll(0, mutations.getGenomes());
    }

}
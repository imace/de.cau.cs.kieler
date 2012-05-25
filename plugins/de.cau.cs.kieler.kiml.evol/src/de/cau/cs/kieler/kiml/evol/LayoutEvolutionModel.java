/*
 * KIELER - Kiel Integrated Environment for Layout Eclipse RichClient
 *
 * http://www.informatik.uni-kiel.de/rtsys/kieler/
 * 
 * Copyright 2012 by
 * + Christian-Albrechts-University of Kiel
 *   + Department of Computer Science
 *     + Real-Time and Embedded Systems Group
 * 
 * This code is provided under the terms of the Eclipse Public License (EPL).
 * See the file epl-v10.html for the license text.
 */
package de.cau.cs.kieler.kiml.evol;

import java.util.Random;

import de.cau.cs.kieler.core.kgraph.KNode;
import de.cau.cs.kieler.core.util.Pair;
import de.cau.cs.kieler.kiml.LayoutContext;
import de.cau.cs.kieler.kiml.config.ILayoutConfig;
import de.cau.cs.kieler.kiml.evol.alg.AbstractEvolutionaryAlgorithm;
import de.cau.cs.kieler.kiml.evol.alg.CrossoverOperation;
import de.cau.cs.kieler.kiml.evol.alg.EvaluationOperation;
import de.cau.cs.kieler.kiml.evol.alg.MutationOperation;
import de.cau.cs.kieler.kiml.evol.alg.SurvivalOperation;
import de.cau.cs.kieler.kiml.evol.genetic.Genome;
import de.cau.cs.kieler.kiml.evol.genetic.Population;
import de.cau.cs.kieler.kiml.ui.diagram.LayoutMapping;

/**
 * The main class for access to evolutionary meta layout.
 * This class is a singleton: at most one evolution model is active at any time. This is a
 * great limitation, and it should be extended in the future: it should be possible to
 * link an evolution model with specific diagrams, diagram types, or use cases. View management
 * might be a feasible approach for this.
 *
 * @author msp
 */
public final class LayoutEvolutionModel extends AbstractEvolutionaryAlgorithm {
    
    /** the initial number of individuals to create. */
    private static final int INITIAL_POPULATION = 20;
    
    /** the singleton instance. */
    private static LayoutEvolutionModel instance = new LayoutEvolutionModel();
    
    /**
     * Returns the active evolution model instance.
     * 
     * @return the active instance
     */
    public static LayoutEvolutionModel getInstance() {
        return instance;
    }
    
    /** the individual that was selected for meta layout. */
    private Genome selectedIndividual;
    
    /**
     * Hidden constructor to prevent instantiation from outside this class.
     */
    private LayoutEvolutionModel() {
        setCrossoverOperation(new CrossoverOperation());
        setMutationOperation(new MutationOperation());
        setSurvivalOperation(new SurvivalOperation());
        setEvaluationOperation(new EvaluationOperation());
        setRandom(new Random());
    }
    
    /**
     * Returns the last individual that was selected for meta layout.
     * 
     * @return the last selected individual
     */
    public Genome getSelected() {
        return selectedIndividual;
    }
    
    /**
     * Initialize the population of the evolution model.
     * 
     * @param layoutMapping a layout mapping from which to derive an initial configuration
     */
    public void initializePopulation(final LayoutMapping<?> layoutMapping) {
        Population population = new Population(2 * INITIAL_POPULATION);
        KNode graph = layoutMapping.getLayoutGraph();
        population.setProperty(Population.EVALUATION_GRAPH, graph);
        
        // create an initial gene, the patriarch
        Pair<ILayoutConfig, LayoutContext> configPair = GenomeFactory.createConfig(layoutMapping);
        population.setProperty(Population.DEFAULT_CONFIG, configPair.getFirst());
        population.setProperty(Population.DEFAULT_CONTEXT, configPair.getSecond());
        Genome patriarch = GenomeFactory.createInitialGenome(layoutMapping, configPair.getFirst(),
                configPair.getSecond());
        population.add(patriarch);
        
        // mutate the patriarch to create an initial population
        MutationOperation mutationOperation = (MutationOperation) getMutationOperation();
        for (int i = 1; i < INITIAL_POPULATION; i++) {
            Genome mutation = mutationOperation.mutate(patriarch, configPair.getFirst(),
                    configPair.getSecond());
            population.add(mutation);
        }
        
        // reset and evaluate the population
        setPopulation(population);
    }

}

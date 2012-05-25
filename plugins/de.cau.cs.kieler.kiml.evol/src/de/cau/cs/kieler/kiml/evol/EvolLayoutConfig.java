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

import de.cau.cs.kieler.core.kgraph.KGraphData;
import de.cau.cs.kieler.core.properties.Property;
import de.cau.cs.kieler.kiml.LayoutContext;
import de.cau.cs.kieler.kiml.LayoutDataService;
import de.cau.cs.kieler.kiml.LayoutOptionData;
import de.cau.cs.kieler.kiml.config.ILayoutConfig;
import de.cau.cs.kieler.kiml.evol.genetic.Gene;

/**
 * Evolutionary layout configurator. Uses evolutionary algorithms together with graph drawing
 * analysis to derive layout option values.
 *
 * @author msp
 */
public class EvolLayoutConfig implements ILayoutConfig {
    
    /** the priority for the evolutionary layout configurator. */
    public static final int PRIORITY = 16;
    
    /** property for activation of the evolutionary layout config. */
    public static final Property<Boolean> ACTIVATION = new Property<Boolean>(
            "de.cau.cs.kieler.kiml.evol", false);
    
    /** property for the evolution model stored in the layout context. */
    private static final Property<LayoutEvolutionModel> EVOL_MODEL = new Property<LayoutEvolutionModel>(
            "evol.model");

    /**
     * {@inheritDoc}
     */
    public int getPriority() {
        return PRIORITY;
    }

    /**
     * {@inheritDoc}
     */
    public void enrich(final LayoutContext context) {
        LayoutEvolutionModel model = LayoutEvolutionModel.getInstance();
        if (model.getSelected() != null) {
            context.setProperty(EVOL_MODEL, model);
        }
    }

    /**
     * {@inheritDoc}
     */
    public Object getValue(final LayoutOptionData<?> optionData, final LayoutContext context) {
        LayoutEvolutionModel model = context.getProperty(EVOL_MODEL);
        if (model != null) {
            Gene<?> gene = model.getSelected().find(optionData.getId());
            if (gene != null) {
                return GenomeFactory.translateFromGene(gene);
            }
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    public void transferValues(final KGraphData graphData, final LayoutContext context) {
        LayoutEvolutionModel model = context.getProperty(EVOL_MODEL);
        if (model != null) {
            LayoutDataService dataService = LayoutDataService.getInstance();
            for (Gene<?> gene : model.getSelected().getGenes()) {
                LayoutOptionData<?> optionData = dataService.getOptionData(gene.getId());
                if (optionData != null) {
                    graphData.setProperty(optionData, GenomeFactory.translateFromGene(gene));
                }
            }
        }
    }

}

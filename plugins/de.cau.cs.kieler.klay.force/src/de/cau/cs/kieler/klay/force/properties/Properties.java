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
package de.cau.cs.kieler.klay.force.properties;

import java.util.Random;

import de.cau.cs.kieler.core.properties.IProperty;
import de.cau.cs.kieler.core.properties.Property;
import de.cau.cs.kieler.kiml.options.LayoutOptions;
import de.cau.cs.kieler.klay.force.model.ForceModelStrategy;

/**
 * Property definitions for the force layouter.
 * 
 * @author msp
 */
public final class Properties {
    
    /** the original object from which a graph element was created. */
    public static final IProperty<Object> ORIGIN = new Property<Object>("origin");
    
    /** random number generator for the algorithm. */
    public static final IProperty<Random> RANDOM = new Property<Random>("random");
    
    ///////////////////////////////////////////////////////////////////////////////
    // USER INTERFACE OPTIONS

    /** force model property identifier. */
    public static final String FORCE_MODEL_ID = "de.cau.cs.kieler.klay.force.model";
    /** force model property. */
    public static final Property<ForceModelStrategy> FORCE_MODEL = new Property<ForceModelStrategy>(
            FORCE_MODEL_ID, ForceModelStrategy.FRUCHTERMAN_REINGOLD);
    
    /** default value for object spacing. */
    public static final float DEF_SPACING = 80.0f;
    /** minimal spacing between objects. */
    public static final Property<Float> SPACING = new Property<Float>(
            LayoutOptions.SPACING, DEF_SPACING);
    
    /** priority of nodes or edges. */
    public static final Property<Integer> PRIORITY = new Property<Integer>(LayoutOptions.PRIORITY, 1);
    
    /** default value for label spacing. */
    public static final float DEF_LABEL_SPACING = 5.0f;
    /** label spacing property. */
    public static final Property<Float> LABEL_SPACING = new Property<Float>(
            LayoutOptions.LABEL_SPACING, DEF_LABEL_SPACING, 0.0f);
    
    /** default value for temperature. */
    public static final float DEF_TEMPERATURE = 0.001f;
    /** temperature property identifier. */
    public static final String TEMPERATURE_ID = "de.cau.cs.kieler.klay.force.temperature";
    /** temperature property. */
    public static final Property<Float> TEMPERATURE = new Property<Float>(TEMPERATURE_ID,
            DEF_TEMPERATURE, 0.0f);
    
    /** default value for iterations. */
    public static final int DEF_ITERATIONS = 100;
    /** iterations property identifier. */
    public static final String ITERATIONS_ID = "de.cau.cs.kieler.klay.force.iterations";
    /** iterations property. */
    public static final Property<Integer> ITERATIONS = new Property<Integer>(ITERATIONS_ID,
            DEF_ITERATIONS, 1);
    
    /** edge repulsive power property identifier. */
    public static final String EDGE_REP_ID = "de.cau.cs.kieler.klay.force.repulsivePower";
    /** edge repulsive power property. */
    public static final Property<Integer> EDGE_REP = new Property<Integer>(EDGE_REP_ID, 0, 0);
    
    /** default value for repulsion factor. */
    public static final float DEF_REPULSION = 5.0f;
    /** repulsion factor property identifier. */
    public static final String REPULSION_ID = "de.cau.cs.kieler.klay.force.repulsion";
    /** repulsion factor property. */
    public static final Property<Float> REPULSION = new Property<Float>(REPULSION_ID,
            DEF_REPULSION, 0.0f);
    
    ///////////////////////////////////////////////////////////////////////////////
    // CONSTRUCTOR
    
    /**
     * Hidden default constructor.
     */
    private Properties() {
    }

}

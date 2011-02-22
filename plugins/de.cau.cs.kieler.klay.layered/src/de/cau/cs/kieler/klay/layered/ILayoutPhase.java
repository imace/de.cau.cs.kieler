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
package de.cau.cs.kieler.klay.layered;

import de.cau.cs.kieler.core.alg.IAlgorithm;
import de.cau.cs.kieler.klay.layered.graph.LayeredGraph;

//CHECKSTYLEOFF JavadocStyle

/**
 * Interface for layout phases. Layout phases are the backbone of Klay Layered.
 *
 * @author cds
 */
public interface ILayoutPhase extends IAlgorithm {
    
    /**
     * Performs the phase's work on the given graph.
     * 
     * @param layeredGraph a layered graph
     */
    void execute(LayeredGraph layeredGraph);
    
}

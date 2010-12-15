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
package de.cau.cs.kieler.kiml.grana.visualizers;

import de.cau.cs.kieler.kiml.grana.AbstractInfoAnalysis;
import de.cau.cs.kieler.kiml.grana.visualization.AbstractSimpleVisualizer;

/**
 * A special visualizer for arrays.
 * 
 * @author mri
 */
public class ArrayResultVisualizer extends AbstractSimpleVisualizer<String> {

    /**
     * {@inheritDoc}
     */
    public boolean canVisualize(final Object result) {
        return (result instanceof Object[]);
    }

    /**
     * {@inheritDoc}
     */
    public String visualize(final AbstractInfoAnalysis analysis,
            final Object result) {
        if (result instanceof Object[]) {
            Object[] objects = (Object[]) result;
            String vis = "(";
            boolean first = true;
            for (Object object : objects) {
                if (first) {
                    first = false;
                } else {
                    vis += ", ";
                }
                vis += object.toString();
            }
            vis += ")";
            return vis;
        } else {
            return result.toString();
        }
    }
}
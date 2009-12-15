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
 * 
 *****************************************************************************/
package de.cau.cs.kieler.synccharts.custom;

import java.util.List;

import org.eclipse.draw2d.Figure;

/**
 * Represents figures that are to be drawn under certain conditions.
 * It consists of a list of conditions and a figure that is to be drawn if the
 * conditions are fulfilled.
 * 
 * @author schm
 */
public class ConditionalFigure {
    
    private List<Condition> conditions;
    private Figure figure;

    /**
     * The constructor.
     * 
     * @param c A list of conditions.
     * @param f A figure.
     */
    public ConditionalFigure(final List<Condition> c, final Figure f) {
        conditions = c;
        figure = f;
    }

    /**
     * Return the list of conditions.
     * 
     * @return List of conditions.
     */
    public List<Condition> getConditions() {
        return conditions;
    }

    /**
     * Return the figure.
     * 
     * @return The figure.
     */
    public Figure getFigure() {
        return figure;
    }
}

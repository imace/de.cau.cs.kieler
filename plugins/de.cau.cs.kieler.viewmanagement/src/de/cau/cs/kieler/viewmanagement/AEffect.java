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
package de.cau.cs.kieler.viewmanagement;

import org.eclipse.gef.EditPart;

/**
 * Abstract definition of an effect. An effect is a visual alteration of the affectedObject in order to make
 * it more appealing or useful to the human observer. It has one main method, execute(). Here, the effect will
 * be e.g. set up (colours, line width and so on) placed and painted. Methods setTarget and setParameters are there
 * to set the target of the effect (or affectedObject) and parameters (e.g. text to be displayed).  
 * @author nbe
 * 
 */

public abstract class AEffect {

    private EditPart affectedObject;

    /**
     * Abstract method to execute a specific effect. Must be implemented by the developer of the
     * effect. Here, you will have to implement the exact behaviour of the effect.
     */
    public abstract void execute();

    /**
     * Method to set the target of the effect. This is the EditPart that will be modified or
     * otherwise worked with by the effect.
     * 
     * @param target
     *            the target of the effect
     */
    public void setTarget(final EditPart target) {
        this.affectedObject= target;
    }

    /**
     * Method to set the parameters of an effect. This may be used to transport additional
     * information such as text to be displayed in an effect, parameters for the visual appearance
     * of the effect, e.g. line width, colors and so on.
     * 
     * @param parameters
     *            the parameters
     */
    public void setParameters(final Object parameters) {
    }

  

    /**
     * @return the affectedObject
     */
    protected EditPart getAffectedObject() {
        return affectedObject;
    }

}

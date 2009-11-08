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

import org.eclipse.emf.ecore.EObject;

/**
 * Object that is used to exchange information on an event between triggers, combinations and
 * effects. Carries triggerActive, an indicator whether or not the event is present, affectedObject,
 * which represents the object that should be affected by the resulting effect and parameters, an
 * optional object that may carry additional information, e.g. the text to be displayed in a textual
 * effect. The TriggerEventObject should be set by the trigger and only read by combination and
 * effect.
 * 
 * @author nbe
 * 
 */
public class TriggerEventObject {

    private boolean triggerActive;
    private EObject affectedObject;
    private Object parameters;

    /**
     * getter method for the triggerActive parameter. The triggerActive determines, whether or not the event
     * is present or absent. The trigger should set it to true to indicate an event has just occurred and to false
     * to indicate the event is now invalid. This gives the combination the ability to react accordingly, if needed
     * 
     * @return the state
     */
    public final boolean getTriggerState() {
        return triggerActive;
    }

    /**
     * setter method for the triggerActive method
     * @see TriggerEventObject#getTriggerState()
     * @param newState
     *            the new state
     */
    public final void setTriggerActive(final boolean newState) {
        triggerActive = newState;

    }

    /**
     * getter method for the affectedObject. The affectedObject is the object a combination and later an
     * effect will work with. To be set properly by the trigger. 
     * 
     * @return the affectedObject
     */
    public final EObject getAffectedObject() {
        return affectedObject;
    }

    /**
     * setter method for the affectedObject
     * @see TriggerEventObject#getAffectedObject()
     * @param eObject
     *            the new affectedObject
     */
    public final void setAffectedObject(final EObject eObject) {
        affectedObject = eObject;

    }

    /**
     * getter method for the parameters. The parameters can be used to transport additional information such
     * as text to be displayed or parameters for the later effect. It is up to the combination whether or
     * not the parameters are optional and how they are used.
     * 
     * @return the parameters
     */
    public final Object getParameters() {
        return parameters;

    }

    /**
     * setter method for the parameters
     * @see TriggerEventObject#getParameters()
     * @param newParameters
     *            the new parameters
     */
    public final void setParameters(final Object newParameters) {
        parameters = newParameters;
    }

}

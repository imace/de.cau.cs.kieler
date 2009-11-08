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

import java.util.EventListener;

/**
 * @author nbe
 * 
 */

public interface ITriggerListener extends EventListener {

    /**
     * Notifies all listeners registered with the TriggerEventObject when the trigger fires.
     * 
     * @param triggerEvent
     *            the object to be delivered
     */
    void notifyTrigger(TriggerEventObject triggerEvent);

}

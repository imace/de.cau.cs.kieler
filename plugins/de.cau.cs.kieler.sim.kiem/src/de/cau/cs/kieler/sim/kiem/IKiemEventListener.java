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

package de.cau.cs.kieler.sim.kiem;

/**
 * Classes implementing this interface can listen to
 * events happening anywhere in KIEM.
 * <BR><BR>
 * When an event successfully completes somewhere inside
 * the KIEM plugin, the plugin may choose to notify the listeners
 * of this event.
 * <BR><BR>
 * 
 * {@link #de.cau.cs.kieler.sim.kiem.KiemEvent}
 * 
 * @author soh
 *
 */
public interface IKiemEventListener {

    /**
     * This is the basic notify method that is called by KIEM whenever an event occurs for which
     * this EventListener is registered (see {@link #provideEventOfInterest()}).
     * 
     * @param event
     *            the KiemEvent with additional attached information, depending on the specific
     *            event
     */
    void notifyEvent(final KiemEvent event);
    
    /**
     * Return a KiemEvent type (integer value) that represents a number of events this component
     * wants to listen to.<BR>
     * <BR>
     * A KiemEvent can be a combination of several events. The simplest way to register for two
     * events that e.g., indicate a step-command and the removal of the component is to have the
     * following code:<BR>
     * <BR>
     * public KiemEvent provideEventOfInterest() { <BR>
     * return new KiemEvent(CMD_STEP+DELETED); <BR>
     * }
     * 
     * @return the KiemEvent type indicating the events of interest
     */
    KiemEvent provideEventOfInterest();
}

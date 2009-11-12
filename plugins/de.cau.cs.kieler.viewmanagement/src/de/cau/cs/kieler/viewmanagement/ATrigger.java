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

import javax.swing.event.EventListenerList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.notation.View;

/**
 * Abstract definition of a trigger. A trigger can have listeners which it will notify whenever an event occurs.
 * An event may be external (the trigger being a listener itself) or internal with the trigger generating events.
 * These events need to be packaged in an TriggerEventObject which will then will be argument for the notify method. 
 * @author nbe
 * 
 */

public abstract class ATrigger {

    private EventListenerList triggerListener = new EventListenerList();
    
    /**
     * Method to add a listener to a trigger. It will be notified with a TriggerEventObject in case
     * the trigger fires.
     * 
     * @param triggerlistener
     *            the listener to be added
     */
    public final void addListener(final ITriggerListener triggerlistener) {
        triggerListener.add(ITriggerListener.class, triggerlistener);
    }

    /**
     * Method to remove a listener from a trigger
     * 
     * @param triggerlistener
     *            the listener to be removed
     */
    public final void removeListener(final ITriggerListener triggerlistener) {
        triggerListener.remove(ITriggerListener.class, triggerlistener);
    }

    // notifies all listeners on the listener list with the triggerEvent
    protected synchronized void notifyTrigger(final TriggerEventObject triggerEvent) {

        for (ITriggerListener l : triggerListener.getListeners(ITriggerListener.class))
            l.notifyTrigger(triggerEvent);

    }

    /**
     * Method to read the number of listeners on a trigger.
     * 
     * @return number of listeners
     */
    public int getListenerQuantity() {
        final int number = triggerListener.getListenerCount();
        return number;
    }

    /**
     * Method to translate an EditPart to URIFragment. Note: To address the objects, URIFragments
     * should no longer be used. Addressing with EObjects provides a much better functionality, such
     * as sematical addressing, addressing of TransitionEditParts.
     * 
     * @param sourceObject
     *            EditPart that should be translated
     * @return String with URIFragment, if available
     */
    public String translateToURI(final EditPart sourceObject) {
        try {
            // get the view to the sourceObject
            View view = (View)  sourceObject.getModel();
            // get the corresponding EObject
            EObject modelElement = view.getElement();
            // read its URIFragment
            String result = modelElement.eResource().getURIFragment(modelElement);

            return result;
        } catch (Exception e) {
            /* If we can't find something we don't want to do anything */
            return null;
        }

    }

    /**
     * Method to translate an Editpart to EObject. This should be used instead of addressing with
     * URIFragements. EObjects are used to exchange the objects that are t be affected by effects of
     * the View Management between the plugins of the View Management or other plugins.
     * 
     * @param sourceObject
     *            EditPart that should be translated
     * @return EObject that represents the EditPart
     */
    public EObject translateToEObject(final EditPart sourceObject) {
        // get the view to the sourceObject
        View view = (View) sourceObject.getModel();
        // get the corresponding model element.
        EObject result = view.getElement();

        return result;

    }

    /**
     * Release all system resources for this object.
     */
    public void finalize() {

    }

}

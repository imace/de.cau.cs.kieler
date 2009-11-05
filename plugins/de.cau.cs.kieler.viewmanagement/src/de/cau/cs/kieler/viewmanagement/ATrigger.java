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
 * @author nbe
 * 
 */

public abstract class ATrigger {

    private EventListenerList triggerListener = new EventListenerList();
    private String result;
    private EObject result2;

    /**
     * Method to add a listener to a trigger.
     * @param triggerlistener the listener to be added
     */
    public void addTriggerListener(final ITriggerListener triggerlistener) {
        triggerListener.add(ITriggerListener.class, triggerlistener);
    }

    /**
     * Method to remove a listener from a trigger
     * @param triggerlistener the listener to be removed
     */
    public void removeTriggerListener(final ITriggerListener triggerlistener) {
        triggerListener.remove(ITriggerListener.class, triggerlistener);
    }

    protected synchronized void notifyTrigger(TriggerEventObject triggerEvent) {

        for (ITriggerListener l : triggerListener.getListeners(ITriggerListener.class))
            l.notifyTrigger(triggerEvent);

    }

    /**
     * Method to read the number of listeners on a trigger.
     * @return number of listeners
     */
    public int getListenerNumber() {
        final int number = triggerListener.getListenerCount();
        return number;
    }

    /**
     * Method to translate an EditPart to URIFragment.
     * @obsolete Use translateToEObejct now
     * @param sourceObject EditPart that should be translated
     * @return String with URIFragment, if available
     */
    public String translateToURI(final EditPart sourceObject) {
        try {

            View view = (View) ((EditPart) sourceObject).getModel();
            EObject modelElement = view.getElement();
            result = modelElement.eResource().getURIFragment(modelElement);

            return result;
        } catch (Exception e) {
            /* If we can't find something we don't want to do anything */
            return null;
        }

    }

    /**
     * Method to translate an Editpart to EObject
     * @param sourceObject EditPart that should be translated
     * @return EObject that represents the EditPart
     */
    public EObject translateToEObject(final EditPart sourceObject) {

        View view = (View) ((EditPart) sourceObject).getModel();
        result2 = view.getElement();

        return result2;

    }

    /**
     * Release all system resources for this object.
     */
    public void finalize() {
    }

}

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

    public void addTriggerListener(ITriggerListener triggerlistener) {
        triggerListener.add(ITriggerListener.class, triggerlistener);
    }

    public void removeTriggerListener(ITriggerListener triggerlistener) {
        triggerListener.remove(ITriggerListener.class, triggerlistener);
    }

    protected synchronized void notifyTrigger(TriggerEventObject triggerEvent) {

        for (ITriggerListener l : triggerListener.getListeners(ITriggerListener.class))
            l.notifyTrigger(triggerEvent);

    }

    public int getListenerNumber() {
        int number = triggerListener.getListenerCount();
        return number;
    }

    // returns URIFragment for given object
    public String translateToURI(Object sourceObject) {
        try {
            if (sourceObject instanceof EditPart) {

                View view = (View) ((EditPart) sourceObject).getModel();
                EObject modelElement = view.getElement();
                result = modelElement.eResource().getURIFragment(modelElement);

            }
            return result;
        } catch (Exception e) {
            /* If we can't find something we don't want to do anything */
            return null;
        }

    }

    public EObject translateToEObject(EditPart sourceObject) {
        

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

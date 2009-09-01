/******************************************************************************
 * KIELER - Kiel Integrated Environment for Layout for the Eclipse RCP
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

import java.util.HashMap;


import javax.swing.event.EventListenerList;


import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeEditPart;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @author nbe
 *
 */

public abstract class ATrigger {

    private EventListenerList triggerListener = new EventListenerList();
    private String result;
    
    public void addTriggerListener (ITriggerListener triggerlistener)
    {
    	triggerListener.add(ITriggerListener.class, triggerlistener);
    }
    
    public void removeTriggerListener (ITriggerListener triggerlistener){
    	triggerListener.remove(ITriggerListener.class, triggerlistener);
    }
    
    protected synchronized void notifyTrigger (TriggerEventObject triggerEvent){
    	
    	for (ITriggerListener l : triggerListener.getListeners(ITriggerListener.class))
    		l.notifyTrigger (triggerEvent);
    
    }
    //returns URIFragment for given object
    public String translateToURI(Object sourceObject){
    	if (sourceObject instanceof ShapeEditPart){
    
    	View view = (View) ((ShapeEditPart) sourceObject).getModel();
    	EObject modelElement = view.getElement();
    	result = modelElement.eResource().getURIFragment(modelElement);
    	
    	}
		return result;
		
    	
    }
   
    /**
     * Release all system resources for this object.
     */
    public abstract void finalize();
    	
    
}

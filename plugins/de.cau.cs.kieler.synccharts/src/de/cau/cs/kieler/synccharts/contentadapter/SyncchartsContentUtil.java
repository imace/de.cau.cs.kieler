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
package de.cau.cs.kieler.synccharts.contentadapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.ResourceSetListener;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.ui.statushandlers.StatusManager;

import de.cau.cs.kieler.synccharts.Transition;

/**
 * Static helper methods for Synccharts.
 * 
 * @author haf
 * 
 * @kieler.rating 2010-01-19 proposed yellow proposed by haf
 * 
 */
public final class SyncchartsContentUtil {

    /**
     * Private constructor for utility class. May not be instantiated.
     */
    private SyncchartsContentUtil() {
    }

    private final static Map<TransactionalEditingDomain,List<ResourceSetListener>> listeners = new HashMap<TransactionalEditingDomain,List<ResourceSetListener>>();
    
    /**
     * Add all TriggerListener classes that are registered via the corresponding
     * extension point as a listener to the passed TransactionalEditingDomain.
     * 
     * @param domain
     *            the given TransactionalEditingDomain
     */
    public static void addTriggerListeners(TransactionalEditingDomain domain) {
        IConfigurationElement[] elements = Platform.getExtensionRegistry()
                .getConfigurationElementsFor("de.cau.cs.kieler.synccharts.triggerListener");
        List<ResourceSetListener> tempListeners = new ArrayList<ResourceSetListener>(elements.length); 
        for (int i = 0; i < elements.length; i++) {
            IConfigurationElement element = elements[i];
            try {
                ResourceSetListener triggerListener = (ResourceSetListener) element
                        .createExecutableExtension("class");
                domain.addResourceSetListener(triggerListener);
                tempListeners.add(triggerListener);
            } catch (CoreException e) {
                Status myStatus = new Status(IStatus.ERROR, "de.cau.cs.kieler.synccharts",
                        "Error attaching registered TriggerListener", e);
                StatusManager.getManager().handle(myStatus, StatusManager.LOG);
            }
        }
        // cleanup the cache in order to avoid memory leaks
        List<TransactionalEditingDomain> stuffToRemove = new ArrayList<TransactionalEditingDomain>();
        for(TransactionalEditingDomain oldDomain : listeners.keySet()){
            if(oldDomain.getID() == null){
            	// avoid concurrent modification exception
            	stuffToRemove.add(oldDomain);
            }
        }
        for (TransactionalEditingDomain oldDomain : stuffToRemove) {
        	listeners.remove(oldDomain);
		}
        listeners.put(domain, tempListeners);
    }
    
    public static List<ResourceSetListener> getTriggerListeners(TransactionalEditingDomain domain){
        return listeners.get(domain);
    }

    /**
     * Determine a new unique ID for a given EObject (e.g. a Region or a State).
     * Will search siblings (e.g. regions within the same State) and compare
     * their IDs. Will return the next ID with the "PrefixN" where N is the next
     * free integer number available, e.g. R0, R1, R2...
     * 
     * @param target
     *            given EObject to look for a unique ID
     * @param attribute
     *            the feature in which the String is stored, e.g. a "name"
     *            feature of a State
     * @param prefix
     *            A String Prefix with which the unique String should start.
     * @return a new unique ID within the State
     */
    public static String getNewUniqueString(EObject target, EAttribute attribute, String prefix, UniqueStringCache cache) {
        String id = prefix;
        EObject parent = target.eContainer();
        if (parent == null) {
            return id;
        }
        EList<EObject> siblings = parent.eContents();
        List<String> ids = new ArrayList<String>();
        int counter = 0;
        for (EObject sibling : siblings) {
            Object val = sibling.eGet(attribute);
            if (val == null || !(val instanceof String)) {
                continue;
            } else {
                ids.add((String)val);
            }
        }
        if(cache!=null){
            ids.addAll(cache.getList());
        }
        
        for (String string : ids) {
                String siblingId = string.trim();
                if (siblingId.matches(prefix + "\\d+")) {
                    // matches e.g. S24 or R99
                    int i = siblingId.length();
                    // get the number
                    while (Character.isDigit(siblingId.charAt(i - 1))) {
                        i--;
                    }
                    if (siblingId.substring(0, i).equals(prefix)) {
                        // if id starts with prefix
                        i = Integer.parseInt(siblingId.substring(i));
                        if (i >= counter) {
                            counter = i + 1;
                        }
                    }
                }
            }
        id = id + counter;
        return id;
    }

    /**
     * Get a new unique priority to a given Transition. That is the current
     * priority will be changed if there is a conflict with any sibling
     * Transition. Set it to the max priority of all siblings plus one.
     * 
     * @param transition
     *            the input Transition whose prio will be changed
     * @return a new unique priority
     */
    public static int getUniquePrio(final Transition transition) {
        int currentPrio = transition.getPriority();
        if (currentPrio == 0) {
            currentPrio = 1; // Prios should start at 1
        }
        EList<Transition> transitions = transition.getSourceState().getOutgoingTransitions();
        // if multiple transitions have same priority, set the current prio to a
        // new value
        boolean changePrio = false;
        int newPrio = 1; // prios should start with 1
        for (Transition transition2 : transitions) {
            int otherPrio = transition2.getPriority();
            // search a new unique prio
            if (otherPrio >= newPrio) {
                newPrio = otherPrio + 1;
            }
            // check if there actually is a prio conflict
            if (otherPrio == currentPrio && transition != transition2) {
                changePrio = true;
            }
        }
        if (changePrio) {
            return newPrio;
        } else {
            return currentPrio;
        }
    }
    
   

}

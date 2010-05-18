/*
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
 */
package de.cau.cs.kieler.viewmanagement;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.gmf.runtime.notation.View;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;

/**
 * Abstract definition of a combination. The combination connects triggers and effects and is itself
 * a triggerlistener. Triggers will call its notifyTrigger() to inform a listening combination about
 * a new event. The combination will then receive a TriggerEventObject with information. A
 * combination has two main methods, evaluate() and execute(). evaluate() should determine whether
 * or not the combination should be executed. Here e.g. a number of triggers could be connected or
 * other conditions considered before executing. execute will be called if evaluate returns true.
 * execute() is the place where the desired effects should be initialized, set up and finally
 * executed themselves.
 * 
 * @author nbe
 * 
 * 
 */
public abstract class ACombination implements ITriggerListener {

    private List<ATrigger> triggersToEvaluate;
    private boolean comboActive = false;
    private HashMap<String, EditPart> cachedEditParts;
    private HashMap<EObject, EditPart> cachedEditParts2;

    /**
     * Abstract method to evaluate certain conditions chosen by the developer that should delay or
     * trigger the execution of the combination.
     * 
     * @param triggerEvent
     *            delivered by a trigger, contains necessary information for the combination
     * @return true if combination should be executed, false otherwise.
     */
    public abstract boolean evaluate(TriggerEventObject triggerEvent);

    /**
     * Abstract method to execute the combination. Creation of desired effects and their setup is to
     * be done here.
     */
    public abstract void execute();

    /**
     * Abstract method that returns the triggers that are of importance for this combination. Will
     * be used when initializing or finalizing the combination and then register it as listeners to
     * the triggers returned in the list.
     * 
     * @return List of triggers to be observed
     */
    protected abstract List<ATrigger> getTriggers();

    /**
     * Removes the last effect when shutting down the View Management, if needed. In that case, it
     * should be overridden.
     */
    public void undoEffects() {
    }

    /**
     * @return Status of the combination, active or not
     */
    public final boolean isActive() {
        return comboActive;
    }

    /**
     * Sets the status of the combination
     * 
     * @param active
     *            new status
     */
    public final void setActive(final boolean active) {
        this.comboActive = active;
    }

    /**
     * Initializes the combination and registers it as listener to the triggers of interest.
     */
    public final void initialize() {
        // get triggers of interest
        triggersToEvaluate = getTriggers();
        // add as listener from those triggers
        for (int i = 0; i < triggersToEvaluate.size(); i++) {
            final ATrigger a = triggersToEvaluate.get(i);
            a.addListener(this);
        }

    }

    /**
     * Finalizes the combination, removes it as listener from its triggers.
     * 
     */
    public final void wrapup() {
        // this will remove remaining effects, if needed
        undoEffects();
        // get triggers of interest
        triggersToEvaluate = getTriggers();
        // remove as listener from those triggers
        for (int i = 0; i < triggersToEvaluate.size(); i++) {
            ATrigger a = triggersToEvaluate.get(i);
            a.removeListener(this);

        }

    }

    /**
     * Reset hashed edit parts. This is when reusing combination for e.g., a different editor.
     * (added by cmot)
     * 
     * This method is needed if you want to use the visualization effect for different editors
     * (after another). Reset of EditPartCache is necessary. (cmot, 09.11.09) Added a reset of the
     * second cache. (cmot, 10.11.09)
     * 
     */
    protected void resetHashedEditParts() {
        if (this.cachedEditParts != null)
            this.cachedEditParts.clear();
        if (this.cachedEditParts2 != null)
            this.cachedEditParts2.clear();
    }

    /**
     * This is called whenever a trigger the combination is listening to has a new event
     */
    public final void notifyTrigger(TriggerEventObject triggerEvent) {

        // call evaluate in concrete combo
        if (this.evaluate(triggerEvent)) {
            this.execute();
        }

    }

    /**
     * Helper method for translateToEditPart to get a parent element from which to start the search
     * 
     * @return rootEP, result of the search
     */
    public static final EditPart getRootEPAsParent() {
        EditPart rootEP = null;
        // get active editor
        final IEditorPart editor = PlatformUI.getWorkbench().getActiveWorkbenchWindow()
                .getActivePage().getActiveEditor();
        if (editor instanceof DiagramEditor) {
            // get root edit part of that editor
            rootEP = ((DiagramEditor) editor).getDiagramEditPart();
        }
        return rootEP;
    }

    /**
     * Translation method to convert the elementURIFragment to EditPart. Called by a combination to
     * convert a value given by a trigger to give it to a trigger. A Hashmap is used to cache search
     * results for later use. Note: This addressing method is discouraged and should not be used
     * anymore. Use EObjects and their addressing methods instead.
     * 
     * @author cmot
     * 
     * @param elementURIFragment
     *            given e.g. by a trigger
     * @param parent
     *            element from which to start the search. Can be specified if known in order to
     *            speed up the search, but may be null. Then it'll be replaced by the rootEditPart
     *            by calling getRootEPAsParent
     * @return the result of the search, in case of success the corresponding EditPart, otherwise
     *         null
     * @deprecated with this method, adressing of transitions is not possible. Adressing should be
     *             done with EObjects. Use getEditPart(EObject eObject) instead.
     */
    public final EditPart translateToEditPart(final String elementURIFragment, EditPart parent) {
        if (parent == null)
            parent = getRootEPAsParent();

        if (cachedEditParts == null) {
            // if hashmap is not initialized, create it
            cachedEditParts = new HashMap<String, EditPart>();
        } else {
            // try to get from hashmap first
            if (cachedEditParts.containsKey(elementURIFragment)) {
                return cachedEditParts.get(elementURIFragment);
            }
        }

        List<?> children = parent.getChildren();
        // search list of children for item with matching URIFragment
        for (Object child : children) {
            if (child instanceof EditPart) {
                View view = (View) ((EditPart) child).getModel();
                EObject modelElement = (EObject) view.getElement();
                if (modelElement.equals(modelElement.eResource().getEObject(elementURIFragment))) {
                    // cache for later calls
                    cachedEditParts.put(elementURIFragment, (EditPart) child);
                    return (EditPart) child;
                }

            }
            // if node was not found yet, search recursively
            if (child instanceof EditPart) {
                EditPart result = translateToEditPart(elementURIFragment, (EditPart) child);
                if (result != null) {
                    return result;
                }
            }
        }
        // we did not find anything in this trunk
        return null;
    }

    /**
     * Find an GEF EditPart that corresponds to an semantic model EObject. A Hashmap is used to
     * cache already found objects for better performance. EObjects are used to address objects that
     * are exchanged between the plugins of the View Management as well as other plugins. EObjects
     * provide the ability for semantical addressing of other objects such as children of an object
     * or similar cases.
     * 
     * @author haf
     * @param eObject
     *            the semantic object
     * @return the corresponding EditPart
     * 
     */
    public final EditPart getEditPart(EObject eObject) {
        if (cachedEditParts2 == null) {
            // if hashmap is not initialized, create it
            cachedEditParts2 = new HashMap<EObject, EditPart>();
        } else {
            // try to get from hashmap first
            if (cachedEditParts2.containsKey(eObject)) {
                return cachedEditParts2.get(eObject);
            }
        }

        try {
            DiagramEditor editor = (DiagramEditor) PlatformUI.getWorkbench()
                    .getActiveWorkbenchWindow().getActivePage().getActiveEditor();
            DiagramEditPart dep = editor.getDiagramEditPart();
            EditPart editPart = dep.findEditPart(dep, eObject);
            if (editPart == null) {
                dep.getViewer().getEditPartRegistry().get(eObject);
            }
            // have to search registry manually
            if (editPart == null) {
                @SuppressWarnings("unchecked")
                Collection<Object> editParts = dep.getViewer().getEditPartRegistry().values();
                for (Object object : editParts) {
                    editPart = (EditPart) object;
                    EObject model = ((View) ((EditPart) object).getModel()).getElement();
                    if (model == eObject) {
                        // search the most valid parent
                        // this is necessary because inner EditParts may also reference the same
                        // model, e.g.
                        // TransitionTriggerAndEffectsEditPart has TransitionImpl as model element
                        // however, the parent
                        // TransitionEditPart also has TransitionImpl as model element
                        // so there are multiple EditParts that have the same EObject. Here we will
                        // return only the outermost parent EditPart
                        while (editPart.getParent() != null) {
                            EditPart parentPart = editPart.getParent();
                            Object view = parentPart.getModel();
                            if (view instanceof View) {
                                EObject parentModel = ((View) view).getElement();
                                if (parentModel == eObject) {
                                    editPart = parentPart;
                                    System.out.println();
                                    ;
                                }
                            } else {
                                break;
                            } // a Root diagram edit part has no real view, so we will stop
                            // searching there
                        }
                        cachedEditParts2.put(eObject, editPart);
                        return editPart;
                    }
                }
            }
            cachedEditParts2.put(eObject, editPart);
            return editPart;
        } catch (Exception e) {
            /* nothing, we simply return null if it cannot be found */
        }
        return null;
    }

}

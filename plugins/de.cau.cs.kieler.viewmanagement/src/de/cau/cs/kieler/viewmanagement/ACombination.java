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
 * @author nbe
 * 
 */
public abstract class ACombination implements ITriggerListener {

    List<ATrigger> triggersToEvaluate;
    private boolean comboActive = false;
    private HashMap<String, EditPart> cachedEditParts;
    private HashMap<EObject, EditPart> cachedEditParts2;
    EditPart rootEP;
    /**
     * General parent element to be used for translation to EditParts.
     */
    public EditPart parent = null;

    /**
     * Abstract method to evaluate certain conditions choosen by the developer
     * that should delay or trigger the execution of the combination.  
     * @param triggerEvent delivered by a trigger, contains necessary information 
     * for the combination 
     * @return true if combination should be executed, false otherwise.
     */
    public abstract boolean evaluate(TriggerEventObject triggerEvent);

    /**
     * Abstract method to execute the combination. Creation of desired effects and their setup
     * is to be done here.
     */
    public abstract void execute();

    /**
     * Abstract method that returns the triggers that are of importance for this combination.
     * @return List of triggers to be observed
     */
    public abstract List<ATrigger> getTriggers();

    /**
     * Removes the last effect when shutting down the Viewmanagement, if needed.
     */
    public void undoLastEffect() {
    }

    /**
     * @return Status of the combination, active or not
     */
    public boolean getActive() {
        return comboActive;
    }

    
    /**
     * Sets the status of the combination
     * @param active new status
     */
    public void setActive(final boolean active) {
        this.comboActive = active;
    }

    /**
     * Initializes the combination and registers it as listener to the triggers of interest.
     */
    public void initialize() {
        triggersToEvaluate = getTriggers();
        for (int i = 0; i < triggersToEvaluate.size(); i++) {
            final ATrigger a = triggersToEvaluate.get(i);
            a.addTriggerListener(this);
        }
    }

    /**
     * Finalizes the combination, removes it as listener from its triggers and
     * also finalizes the trigger if it is its last listener.
     */
    public void finalize() {
        undoLastEffect();
        triggersToEvaluate = getTriggers();
        for (int i = 0; i < triggersToEvaluate.size(); i++) {
            ATrigger a = triggersToEvaluate.get(i);
            a.removeTriggerListener(this);
            if (a.getListenerNumber() == 0) {
                a.finalize();
            }
        }
    }

    /**
     * Reset hashed edit parts. This is when reusing combination for e.g., a different editor.
     * (added by cmot)
     */
    protected void resetHashedEditParts() {
        if (this.cachedEditParts != null)
            this.cachedEditParts.clear();
    }
/**
 * This method is called whenever a trigger the combination is listening to has a new event
 */
    public void notifyTrigger(TriggerEventObject triggerEvent) {
        

        // call evaluate in concrete combo
        if (this.evaluate(triggerEvent))
            this.execute();

    }

    /**
     * Helper method for translateToEditPart to get a parent element
     *  from which to start the search 
     * @return rootEP, result of the search
     */
    public EditPart getRootEPAsParent() {
        final IEditorPart editor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
                .getActiveEditor();
        if (editor instanceof DiagramEditor) {
            rootEP = ((DiagramEditor) editor).getDiagramEditPart();
        }
        return rootEP;
    }

    
    /**
     * Translation method to convert the elementURIFragment to EditPart. Called by a 
     * combination to convert a value given by a trigger to give it to a trigger. 
     * A Hashmap is used to cache search results for later use. 
     * @param elementURIFragment given e.g. by a trigger 
     * @param parent element from which to start the search. Can be specified if known 
     * in order to speed up the search, but may be null. Then it'll be replaced by the 
     * rootEditPart by calling getRootEPAsParent
     * @return the result of the search, in case of success the corresponding EditPart,
     *  otherwise null
     */
    public EditPart translateToEditPart(final String elementURIFragment, EditPart parent) {
        if (parent == null)
            parent = getRootEPAsParent();

        if (cachedEditParts == null) {
            // if hashmap is not initialized, create it
            cachedEditParts = new HashMap<String, EditPart>();
        } else {
            // try to get from hashmap first
            if (cachedEditParts.containsKey(elementURIFragment))
                return cachedEditParts.get(elementURIFragment);
        }

        List<?> children = parent.getChildren();
        //search list of children for item with matching URIFragment
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
     * Find an GEF EditPart that corresponds to an semantic model EObject.
     * 
     * @param eObject
     *            the semantic object
     * @return the corresponding EditPart
     * 
     *         TODO: search of transition edit parts iterates all edit parts and will take linear
     *         time. You should improve this, by maybe build a local cache hash map
     */
    public EditPart getEditPart(EObject eObject) {
        if (cachedEditParts2 == null) {
            // if hashmap is not initialized, create it
            cachedEditParts2 = new HashMap<EObject, EditPart>();
        } else {
            // try to get from hashmap first
            if (cachedEditParts2.containsKey(eObject))
                return cachedEditParts2.get(eObject);
        }
        
        try {
            DiagramEditor editor = (DiagramEditor) PlatformUI.getWorkbench()
                    .getActiveWorkbenchWindow().getActivePage().getActiveEditor();
            DiagramEditPart dep = editor.getDiagramEditPart();
            EditPart editPart = dep.findEditPart(dep, eObject);
            if (editPart == null)
                dep.getViewer().getEditPartRegistry().get(eObject);
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

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


import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.gmf.runtime.notation.View;
import java.util.HashMap;
import java.util.List;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.RootEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.render.editparts.RenderedDiagramRootEditPart;
/**
 * @author nbe
 *
 */
public abstract class ACombination implements ITriggerListener{



	List<ATrigger> triggers;
    List<AEffect> effects;
    ATrigger t;
    List<ATrigger> triggersToEvaluate;
    private boolean comboActive=false;
    private HashMap<String,EditPart> cachedEditParts;
    EditPart rootEP;
    public EditPart parent = null;
    
    public abstract boolean evaluate(TriggerEventObject triggerEvent);

    public abstract void execute();

    public abstract List<ATrigger> getTriggers();
    
    public void undoLastEffect() {
	}
    
    public boolean getActive(){
    	return comboActive;
    }
//    Activate or deactivate a combo
    public void setActive(boolean active){
    	this.comboActive= active;
    }

	public void initialize() {
		triggersToEvaluate=getTriggers();
		for (int i=0; i<triggersToEvaluate.size();i++){
			ATrigger a = triggersToEvaluate.get(i);
			a.addTriggerListener(this);
		}
	}
	
	public void finalize (){
		undoLastEffect();
		triggersToEvaluate=getTriggers();
		for (int i=0; i<triggersToEvaluate.size();i++){
			ATrigger a = triggersToEvaluate.get(i);
			a.removeTriggerListener(this);
			
			
	}
	}
	
	
	public void notifyTrigger(TriggerEventObject triggerEvent) {
	    // this is called whenever trigger want to notify
	    
	    // call evaluate in concrete combo
	    if( this.evaluate(triggerEvent) ) 
	        this.execute();
	    
	}
	public EditPart getRootEPAsParent(){
		IEditorPart editor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		        if (editor instanceof DiagramEditor) {
                    rootEP= ((DiagramEditor) editor)
                            .getDiagramEditPart();
                }
		        return rootEP;
            }
    
	
//parent may be null
	public EditPart translateToEditPart(String elementURIFragment,                                                                    
			EditPart parent) {
			if (parent==null)
				parent= getRootEPAsParent();
			
				
			
				
			            if (cachedEditParts == null) {
			                // if hashmap is not initialized, create it
			                    cachedEditParts = new HashMap<String,EditPart>();
			            }
			            else {
			                //try to get from hashmap first
			                    if (cachedEditParts.containsKey(elementURIFragment))
			                            return cachedEditParts.get(elementURIFragment);
			            }
			            
			        List children = parent.getChildren();
			        for (Object child : children) {
			            if (child instanceof EditPart) {
			                View view = (View) ((EditPart) child).getModel();
			                EObject modelElement = (EObject) view.getElement();
			                            if (modelElement.equals(
			                                    modelElement.eResource()
			                                .getEObject(elementURIFragment))) {
			                        //cache for later calls
			                        cachedEditParts.put(
			                                        elementURIFragment,
			                                        (EditPart) child);
			                        return (EditPart) child;
			                            }
			                            
			            }
			            // if node was not found yet, search recursively
			            if (child instanceof EditPart) {
			                EditPart result = translateToEditPart(elementURIFragment,
			                                                   (EditPart) child);
			                if (result != null) {
			                    return result;
			                }
			            }
			        }
			        // we did not find anything in this trunk
			        return null;
			    }
	

}


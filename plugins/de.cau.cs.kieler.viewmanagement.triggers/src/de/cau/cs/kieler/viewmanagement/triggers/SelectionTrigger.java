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
package de.cau.cs.kieler.viewmanagement.triggers;

import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeEditPart;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;

import de.cau.cs.kieler.viewmanagement.ATrigger;
import de.cau.cs.kieler.viewmanagement.TriggerEvent;
import de.cau.cs.kieler.viewmanagement.TriggerEventObject;
import de.cau.cs.kieler.viewmanagement.combination.SelectionHighlightCombination;

/**
 * @author haf
 *
 */




public class SelectionTrigger extends ATrigger implements ISelectionListener {

	TriggerEventObject selectionEvent;
    public SelectionTrigger() {
        // register this as a listener to the Eclipse selection service
        PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService().addSelectionListener(this);
    }

    /* Method will be called whenever the selection in Eclipse has changed.
     * 
     * (non-Javadoc)
     * @see org.eclipse.ui.ISelectionListener#selectionChanged(org.eclipse.ui.IWorkbenchPart, org.eclipse.jface.viewers.ISelection)
     */
    public void selectionChanged(IWorkbenchPart part, ISelection selection) {
        //System.out.println("Whoohoo, something was selected: "+part + " " + selection);
        
        // do something meaningful for testing
        // FIXME: solve this through some listener pattern or someway else more generic
        if(selection instanceof IStructuredSelection){
            Object selectedObject = ((IStructuredSelection) selection).getFirstElement();
         
		
			if( selectedObject instanceof ShapeEditPart )
				  
			selectionEvent.setAffectedObject((String) selectedObject);
            	
			notifyTrigger(selectionEvent);   	
            	
            //SelectionHighlightCombination.doSomething( (ShapeEditPart) selectedObject);
        }
    }
    
    public void finalize(){
        // unregister this as listener
        PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService().removeSelectionListener(this);
    }
    
}


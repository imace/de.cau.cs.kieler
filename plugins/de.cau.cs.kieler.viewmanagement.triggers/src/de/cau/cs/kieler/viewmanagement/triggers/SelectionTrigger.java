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

import java.util.List;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeEditPart;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IPageListener;
import org.eclipse.ui.IPerspectiveListener;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;

import de.cau.cs.kieler.viewmanagement.ATrigger;
import de.cau.cs.kieler.viewmanagement.RunLogic;
import de.cau.cs.kieler.viewmanagement.TriggerEvent;
import de.cau.cs.kieler.viewmanagement.TriggerEventObject;

/**
 * @author nbe
 * 
 */

public class SelectionTrigger extends ATrigger implements ISelectionListener {


	
	
	
	
    TriggerEventObject selectionEvent;
    Object currentSelection;
    
    

   
    
    public SelectionTrigger() {
        // register this as a listener to the Eclipse selection service
    	
    	PlatformUI.getWorkbench().getActiveWorkbenchWindow()
                .getSelectionService().addSelectionListener(this);
    	
    }

    /*
     * Method will be called whenever the selection in Eclipse has changed.
     * 
     * (non-Javadoc)
     * 
     * @seeorg.eclipse.ui.ISelectionListener#selectionChanged(org.eclipse.ui.
     * IWorkbenchPart, org.eclipse.jface.viewers.ISelection)
     */
    public void selectionChanged(IWorkbenchPart part, ISelection selection) {
       
        if (selection instanceof IStructuredSelection) {
            this.selectionEvent = new TriggerEventObject();
            List<?> selectionList = ((IStructuredSelection)selection).toList();
            Object selectedObject = selectionList.get(0);
            //Object selectedObject = ((IStructuredSelection) selection)
              //      .getFirstElement();
            if (selectedObject instanceof ShapeEditPart) {
                if (currentSelection != null) {
                    selectionEvent.setTriggerActive(false);
                    selectionEvent.setAffectedObject(translateToURI(currentSelection));
                    //selectionEvent.setParameters("Test");
                    notifyTrigger(selectionEvent);
                    
                }
                currentSelection = selectedObject;
                
                selectionEvent.setAffectedObject(translateToURI(selectedObject));
                selectionEvent.setTriggerActive(true);

                notifyTrigger(selectionEvent);

                // SelectionHighlightCombination.doSomething( (ShapeEditPart)
                // selectedObject);
            } else {
                if (currentSelection != null) {
                    selectionEvent.setTriggerActive(false);
                    selectionEvent.setAffectedObject(translateToURI(currentSelection));
                    selectionEvent.setParameters("Test");
                    notifyTrigger(selectionEvent);
                }
            }
        }
    }

    public void finalize() {
        // unregister this as listener
        PlatformUI.getWorkbench().getActiveWorkbenchWindow()
                .getSelectionService().removeSelectionListener(this);
    }

}

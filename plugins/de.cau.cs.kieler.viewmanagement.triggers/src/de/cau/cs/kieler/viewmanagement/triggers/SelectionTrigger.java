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
package de.cau.cs.kieler.viewmanagement.triggers;

import java.util.List;
import org.eclipse.gef.EditPart;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import de.cau.cs.kieler.viewmanagement.ATrigger;
import de.cau.cs.kieler.viewmanagement.TriggerEventObject;

/**
 * @author nbe
 * 
 */

public class SelectionTrigger extends ATrigger implements ISelectionListener {

    TriggerEventObject selectionEvent;
    Object currentSelection;

    /**
     * Sends Object(s) selected in workbench to listeners
     */
    public SelectionTrigger() {
        // register this as a listener to the Eclipse selection service

        PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService()
                .addSelectionListener(this);

    }

    /*
     * Method will be called whenever the selection in Eclipse has changed.
     * 
     * (non-Javadoc)
     * 
     * @seeorg.eclipse.ui.ISelectionListener#selectionChanged(org.eclipse.ui. IWorkbenchPart,
     * org.eclipse.jface.viewers.ISelection)
     */
    public void selectionChanged(IWorkbenchPart part, ISelection selection) {

        if ((selection instanceof IStructuredSelection) && !(selection instanceof TreeSelection)) {
            this.selectionEvent = new TriggerEventObject();
            List<?> selectionList = ((IStructuredSelection) selection).toList();
            Object selectedObject;

            if (!(selectionList.isEmpty())) {
                selectedObject = selectionList.get(0);

                if (selectedObject instanceof EditPart) {
                    if (currentSelection != null) {
                        selectionEvent.setTriggerActive(false);
                        selectionEvent.setAffectedObject(translateToEObject(currentSelection));
                        selectionEvent.setParameters("Test");
                        notifyTrigger(selectionEvent);

                    }
                    currentSelection = selectedObject;
                    selectionEvent.setAffectedObject(translateToEObject(selectedObject));
                    selectionEvent.setParameters("Test");
                    selectionEvent.setTriggerActive(true);
                    notifyTrigger(selectionEvent);

                } else {
                    if (currentSelection != null) {
                        selectionEvent.setTriggerActive(false);
                        selectionEvent.setAffectedObject(translateToEObject(currentSelection));
                        /* The following line is for testing of the TextualRepresentation only */
                        // selectionEvent.setParameters("Test");
                        notifyTrigger(selectionEvent);
                    }
                }
            }
        }
    }

    public void finalize() {

        PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService()
                .removeSelectionListener(this);
    }

}

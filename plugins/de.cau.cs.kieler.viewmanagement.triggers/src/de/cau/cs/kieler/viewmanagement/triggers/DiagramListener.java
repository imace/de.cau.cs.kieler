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
 * 
 *****************************************************************************/
package de.cau.cs.kieler.viewmanagement.triggers;

import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.EAttributeImpl;
import org.eclipse.emf.transaction.NotificationFilter;
import org.eclipse.emf.transaction.ResourceSetChangeEvent;
import org.eclipse.emf.transaction.ResourceSetListener;
import org.eclipse.emf.transaction.RollbackException;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IStartup;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

import de.cau.cs.kieler.viewmanagement.RunLogic;

/**
 * A generic listener, that listens to Diagram events of the currently active editor.
 * @author haf
 *
 */
public class DiagramListener implements IPartListener, IStartup, ResourceSetListener{

    /** Registers this class as a listener to changes of the active editor.
     * @see org.eclipse.ui.IStartup#earlyStartup()
     * @see #partActivated(IWorkbenchPart)
     */
    public void earlyStartup() {
        final IPartListener thisPartListener = this;
        final IWorkbench workbench = PlatformUI.getWorkbench();
        workbench.getDisplay().asyncExec(new Runnable() {
          public void run() {
            IWorkbenchWindow window = workbench.getActiveWorkbenchWindow();
            if (window != null) {
              window.getActivePage().addPartListener(thisPartListener);
              // already register for open editors
              IEditorReference[] editors = window.getActivePage().getEditorReferences();
              for (IEditorReference iEditorReference : editors) {
                IEditorPart editor = iEditorReference.getEditor(true);
                registerResourceSetListener(editor);
            }
            }
          }
        });
    }

    /** When the active editor changes to a DiagramEditor, this class
     * is added as a ResourceSetListener. This will notify this listener
     * about changes of the diagram, e.g. Collapse or Expand events.
     * @see org.eclipse.ui.IPartListener#partActivated(org.eclipse.ui.IWorkbenchPart)
     */
    public void partActivated(IWorkbenchPart part) {
        registerResourceSetListener(part);
    }

    /**
     * Remove previously added ResourceSetListener from the editor.
     */
    public void partDeactivated(IWorkbenchPart part) {
        removeResourceSetListener(part);
    }

    /**
     * Add this as a ResourceSetListener to the given part, iff it is
     * a DiagramEditor.
     * @param part the given Part, e.g. an Editor or View
     */
    private void registerResourceSetListener(IWorkbenchPart part){
        if (part instanceof DiagramEditor){
            DiagramEditor editor = (DiagramEditor)part;
            editor.getEditingDomain().addResourceSetListener(this);
        }
    }
    
    /**
     * Remove this as a ResourceSetListener to the given part, iff it is
     * a DiagramEditor.
     * @param part the given Part, e.g. an Editor or View
     */
    private void removeResourceSetListener(IWorkbenchPart part){
        if (part instanceof DiagramEditor){
            DiagramEditor editor = (DiagramEditor)part;
            editor.getEditingDomain().removeResourceSetListener(this);
        }
    }
    
    
    /* (non-Javadoc)
     * @see org.eclipse.emf.transaction.ResourceSetListener#resourceSetChanged(org.eclipse.emf.transaction.ResourceSetChangeEvent)
     */
    public void resourceSetChanged(ResourceSetChangeEvent event) {
        List<Notification> notifications = event.getNotifications();
        for (Notification notification : notifications) {
            Object feature = notification.getFeature();
            try{
                if(((EAttributeImpl) feature).getName().equals("collapsed")){
                    Object notifier = notification.getNotifier();
                    Object element = ((View) notifier).getElement();
                    CollapseExpandTrigger trigger = (CollapseExpandTrigger)RunLogic.getInstance().getTrigger("CollapseExpandTrigger");
                    trigger.notifyCollapse((EObject)element);
                }
            }catch(Exception e){ /*nothing*/}
            
        }
    }

    /* empty not implemented PartListener and ResourceSetListener methods */
    public void partBroughtToTop(IWorkbenchPart part) {}
    public void partClosed(IWorkbenchPart part) {}
    public void partOpened(IWorkbenchPart part) {}
    public NotificationFilter getFilter() {return null;}
    public boolean isAggregatePrecommitListener() {return false;}
    public boolean isPostcommitOnly() {return false;}
    public boolean isPrecommitOnly() {return false;}
    public Command transactionAboutToCommit(ResourceSetChangeEvent event)
    throws RollbackException {return null;}
}

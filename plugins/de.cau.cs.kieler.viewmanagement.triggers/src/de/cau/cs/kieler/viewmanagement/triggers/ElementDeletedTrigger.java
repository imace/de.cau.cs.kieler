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
 */
package de.cau.cs.kieler.viewmanagement.triggers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.NotificationFilter;
import org.eclipse.emf.transaction.ResourceSetChangeEvent;
import org.eclipse.emf.transaction.ResourceSetListener;
import org.eclipse.emf.transaction.RollbackException;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IWorkbenchPart;

import de.cau.cs.kieler.core.model.util.ModelingUtil;
import de.cau.cs.kieler.core.ui.util.CombinedWorkbenchListener;
import de.cau.cs.kieler.viewmanagement.ATrigger;
import de.cau.cs.kieler.viewmanagement.TriggerEventObject;

/**
 * A trigger listening for delete events on the diagram.
 * 
 * @author soh
 */
public class ElementDeletedTrigger extends ATrigger implements IPartListener {

    /**
     * 
     * Creates a new ElementDeletedTrigger.
     * 
     */
    public ElementDeletedTrigger() {
        CombinedWorkbenchListener.addPartListener(this);
        CombinedWorkbenchListener.receiveAlreadyOpenedParts(this);
    }

    /**
     * {@inheritDoc}
     */
    public void partActivated(final IWorkbenchPart part) {
    }

    /**
     * {@inheritDoc}
     */
    public void partBroughtToTop(final IWorkbenchPart part) {
    }

    /**
     * {@inheritDoc}
     */
    public void partClosed(final IWorkbenchPart part) {
    }

    /**
     * {@inheritDoc}
     */
    public void partDeactivated(final IWorkbenchPart part) {
    }

    /**
     * {@inheritDoc}
     */
    public void partOpened(final IWorkbenchPart part) {
        if (part instanceof DiagramEditor) {
            DiagramEditor ed = (DiagramEditor) part;
            ed.getEditingDomain().addResourceSetListener(
                    new DeleteObjectListener(this, ed));
        }
    }

    private static class DeleteObjectListener implements ResourceSetListener {

        private ElementDeletedTrigger trigger;

        private DiagramEditor editor;

        /**
         * Creates a new DeleteObjectListener.
         * 
         * @param triggerParam
         *            the parameter
         * @param editorParam
         *            the editor
         */
        public DeleteObjectListener(final ElementDeletedTrigger triggerParam,
                final DiagramEditor editorParam) {
            trigger = triggerParam;
            editor = editorParam;
        }

        /**
         * {@inheritDoc}
         */
        public NotificationFilter getFilter() {
            return NotificationFilter
                    .createEventTypeFilter(Notification.REMOVE)
                    .or(NotificationFilter
                            .createEventTypeFilter(Notification.REMOVE_MANY));
        }

        /**
         * {@inheritDoc}
         */
        public Command transactionAboutToCommit(
                final ResourceSetChangeEvent event) throws RollbackException {
            return null;
        }

        /**
         * {@inheritDoc}
         */
        public void resourceSetChanged(final ResourceSetChangeEvent event) {
            List<Notification> notifications = event.getNotifications();
            Set<EObject> found = new HashSet<EObject>();
            for (Notification n : notifications) {
                Object o = n.getNotifier();

                if (o instanceof EObject) {
                    EObject eObj = (EObject) o;
                    if (ModelingUtil.getEditPart(eObj,
                            editor.getDiagramEditPart()) != null) {
                        found.add(eObj);
                    }
                }
            }
            if (!found.isEmpty()) {
                for (EObject eObj : found) {
                    TriggerEventObject triggerEvent = new TriggerEventObject();
                    triggerEvent.setAffectedObject(eObj);
                    triggerEvent.setParameters(editor);
                    trigger.notifyTrigger(triggerEvent);
                }
            }
        }

        /**
         * {@inheritDoc}
         */
        public boolean isAggregatePrecommitListener() {
            return false;
        }

        /**
         * {@inheritDoc}
         */
        public boolean isPrecommitOnly() {
            return false;
        }

        /**
         * {@inheritDoc}
         */
        public boolean isPostcommitOnly() {
            return false;
        }
    }
}

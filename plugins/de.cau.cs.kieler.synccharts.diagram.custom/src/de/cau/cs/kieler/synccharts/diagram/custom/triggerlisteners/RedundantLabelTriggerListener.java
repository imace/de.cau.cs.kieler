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
package de.cau.cs.kieler.synccharts.diagram.custom.triggerlisteners;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.NotificationFilter;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.TriggerListener;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.progress.WorkbenchJob;

import de.cau.cs.kieler.synccharts.Region;
import de.cau.cs.kieler.synccharts.State;
import de.cau.cs.kieler.synccharts.SyncchartsPackage;
import de.cau.cs.kieler.synccharts.Transition;
import de.cau.cs.kieler.synccharts.diagram.custom.SyncchartsDiagramCustomPlugin;
import de.cau.cs.kieler.synccharts.diagram.edit.parts.RegionIdEditPart;
import de.cau.cs.kieler.synccharts.diagram.edit.parts.TransitionPriorityEditPart;
import de.cau.cs.kieler.synccharts.diagram.part.SyncchartsDiagramEditor;

/**
 * This class is responsible for hiding redundant labels.
 * 
 * For example it hides the region id label if the parent state only has one
 * region. It also hides the transition priority label if the source state only
 * has one outgoing transition.
 * 
 * @author soh
 */
public class RedundantLabelTriggerListener extends TriggerListener {

    /**
     * Creates a new RedundantLabelTriggerListener.
     * 
     */
    public RedundantLabelTriggerListener() {
        super(
                NotificationFilter.RESOURCE_LOADED
                        .or(NotificationFilter
                                .createFeatureFilter(
                                        SyncchartsPackage.eINSTANCE
                                                .getState_Regions())
                                .or(
                                        NotificationFilter
                                                .createFeatureFilter(SyncchartsPackage.eINSTANCE
                                                        .getState_OutgoingTransitions()))));
    }

    /**
     * Creates a new RedundantLabelTriggerListener.
     * 
     * @param filter
     *            the filter
     */
    public RedundantLabelTriggerListener(final NotificationFilter filter) {
        super(filter);
    }

    /**
     * Manually trigger the trigger listener.
     * 
     */
    public static void hideRedundantLabels() {
        new RedundantLabelTriggerListener().performCleanup();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Command trigger(TransactionalEditingDomain domain,
            Notification notification) {
        performCleanup();
        return null;
    }

    private static WorkbenchJob job;

    private static boolean waiting = false;

    private static final int JOB_DELAY = 1000;

    private void performCleanup() {
        try {
            if (waiting) {
                job.cancel();
            }
            job = new WorkbenchJob("Redundant Label Cleanup") {
                @Override
                public IStatus runInUIThread(final IProgressMonitor monitor) {
                    waiting = false;
                    try {
                        IEditorPart part = SyncchartsDiagramCustomPlugin.instance
                                .getActiveEditorPart();
                        IProgressMonitor dummyMonitor = new IProgressMonitor() {

                            public void worked(int work) {
                            }

                            public void subTask(String name) {
                            }

                            public void setTaskName(String name) {
                            }

                            public void setCanceled(boolean value) {
                            }

                            public boolean isCanceled() {
                                return false;
                            }

                            public void internalWorked(double work) {
                            }

                            public void done() {
                            }

                            public void beginTask(String name, int totalWork) {
                            }
                        };

                        if (part instanceof SyncchartsDiagramEditor) {
                            boolean save = !part.isDirty();
                            VisibilityManager
                                    .reset((SyncchartsDiagramEditor) part);
                            clean((SyncchartsDiagramEditor) part);
                            if (save) {
                                part.doSave(dummyMonitor);
                            }
                        } else {
                            List<SyncchartsDiagramEditor> list = SyncchartsDiagramCustomPlugin.instance
                                    .getOpenSyncchartsEditors();
                            if (!list.isEmpty()) {
                                for (SyncchartsDiagramEditor part2 : list) {
                                    boolean save = !part2.isDirty();
                                    VisibilityManager.reset(part2);
                                    clean(part2);
                                    if (save) {
                                        part2.doSave(dummyMonitor);
                                    }
                                }
                            }
                        }

                    } catch (RuntimeException e0) {
                        e0.printStackTrace();
                    }
                    return Status.OK_STATUS;
                }
            };
            waiting = true;
            job.schedule(JOB_DELAY);
        } catch (RuntimeException e0) {
            e0.printStackTrace();
        }
    }

    /**
     * Cleanup one particular editor.
     * 
     * @param part
     *            the editor part
     */
    private void clean(final SyncchartsDiagramEditor part) {
        DiagramEditPart dep = part.getDiagramEditPart();
        Collection<?> editParts = dep.getViewer().getEditPartRegistry()
                .values();
        List<Object> list = new LinkedList<Object>();
        for (Object o : editParts) {
            list.add(o);
        }
        Iterator<?> iter = list.iterator();
        while (iter.hasNext()) {
            Object o = iter.next();
            if (o instanceof TransitionPriorityEditPart
                    || o instanceof RegionIdEditPart) {
                EObject obj = ((View) ((EditPart) o).getModel()).getElement();
                if (o instanceof TransitionPriorityEditPart) {
                    Transition trans = (Transition) obj;
                    TransitionPriorityEditPart editPart = (TransitionPriorityEditPart) o;

                    int outgoing = trans.getSourceState() == null ? 0 : trans
                            .getSourceState().getOutgoingTransitions().size();
                    if (outgoing == 1) {
                        VisibilityManager.hide(part, editPart);
                        continue;
                    }
                } else if (o instanceof RegionIdEditPart) {
                    RegionIdEditPart editPart = (RegionIdEditPart) o;
                    Region region = (Region) obj;
                    State parent = region.getParentState();
                    if (parent != null) {
                        int regions = parent.getRegions().size();
                        if (regions == 1) {
                            VisibilityManager.hide(part, editPart);
                            continue;
                        }
                    }
                }
            }
        }
    }
}

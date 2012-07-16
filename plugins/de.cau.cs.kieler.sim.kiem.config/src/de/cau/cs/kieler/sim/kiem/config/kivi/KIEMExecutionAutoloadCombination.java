/*
 * KIELER - Kiel Integrated Environment for Layout Eclipse RichClient
 *
 * http://www.informatik.uni-kiel.de/rtsys/kieler/
 * 
 * Copyright 2011 by
 * + Christian-Albrechts-University of Kiel
 *   + Department of Computer Science
 *     + Real-Time and Embedded Systems Group
 * 
 * This code is provided under the terms of the Eclipse Public License (EPL).
 * See the file epl-v10.html for the license text.
 */
package de.cau.cs.kieler.sim.kiem.config.kivi;

import java.util.List;

import org.eclipse.ui.IEditorSite;

import de.cau.cs.kieler.core.kivi.AbstractCombination;
import de.cau.cs.kieler.core.model.triggers.PartTrigger.PartState;
import de.cau.cs.kieler.sim.kiem.IKiemEventListener;
import de.cau.cs.kieler.sim.kiem.KiemEvent;
import de.cau.cs.kieler.sim.kiem.KiemPlugin;
import de.cau.cs.kieler.sim.kiem.config.data.EditorIdWrapper;
import de.cau.cs.kieler.sim.kiem.config.data.ScheduleData;
import de.cau.cs.kieler.sim.kiem.config.exception.ScheduleFileMissingException;
import de.cau.cs.kieler.sim.kiem.config.managers.ScheduleManager;
import de.cau.cs.kieler.sim.kiem.internal.KiemProxyEditor;
import de.cau.cs.kieler.sim.kiem.util.KiemUtil;

/**
 * A KiVi Combination controlling the auto loading of execution files. While NO execution is
 * currently running when the user changes the editor the best fitting execution schedule is
 * selected.
 * 
 * Autoload triggered on startup, if the editor change or if KIEM execution stops.
 * 
 * @author cmot
 * 
 */
public class KIEMExecutionAutoloadCombination extends AbstractCombination implements IKiemEventListener {

    private EditorIdWrapper lastValidEditorId = null;

    /**
     * Instantiates a new kIEM execution autoload combination.
     */
    public KIEMExecutionAutoloadCombination() {
    }

    /**
     * Execute.
     *
     * @param partState the part state
     */
    public void execute(final PartState partState) {
        // to prevent UI thread deadlocks (editorIsActivePart) because during initialization
        // components may require UI access, do not execution at this point
        if (KiemPlugin.getDefault().isInitializingExecution()) {
            return;
        }

        // if currently active editor is also the active part
        if (partState != null && partState.getEditorPart() != null) {

            // this is a special editor and we do'nt want to adjust kiem when it is loaded
            if (partState.getEditorPart() instanceof KiemProxyEditor) {
                return;
            }

            // if no execution is running or is about to run
            if (!(KiemPlugin.getDefault().isInitializingExecution() || KiemPlugin.getDefault()
                    .getExecution() != null)) {

                autoloadExecutionSchedule();
            }
        }

    }
    
    private void autoloadExecutionSchedule() {
        EditorIdWrapper editorId = null;
        String editorName = null;

        // get the currently opened editor
        // this may throw a NullPointerException if no editor is open
        IEditorSite editor = KiemUtil.getActiveEditor(); 

        // if an editor is opened
        if (editor != null) {
            // get the attributes from the editor
            editorId = new EditorIdWrapper(editor.getId());
            editorName = editor.getRegisteredName();

            // only if editor has been changed to a valid one
            if (editorId == null || (!editorId.equals(lastValidEditorId))) {
                ScheduleManager scheduleManager = ScheduleManager.getInstance();
                List<ScheduleData> scheduleDataList = scheduleManager.getMatchingSchedules(
                        editorId, editorName);

                // if at least one matching schedule, take the first one
                if (scheduleDataList.size() > 0) {
                    lastValidEditorId = editorId;
                    ScheduleData scheduleData = scheduleDataList.get(0);
                    // open execution file
                    try {
                        scheduleManager.openSchedule(scheduleData);
                    } catch (ScheduleFileMissingException e) {
                        // fail silently if this does not work
                    }
                }
            }

        }

    }

    //-------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    public void notifyEvent(final KiemEvent event) {
      if (event.isEvent(KiemEvent.ERROR_STOP) || event.isEvent(KiemEvent.EXECUTION_STOP)) {
          // In case of erroneous or intended execution stops
          // trigger to re-auto select an appropriate schedule
          autoloadExecutionSchedule();
      }
    }
    
    //-------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    public KiemEvent provideEventOfInterest() {
        int[] events = { KiemEvent.EXECUTION_STOP, KiemEvent.ERROR_STOP};
        return new KiemEvent(events);
    }

}

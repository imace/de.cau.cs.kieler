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
package de.cau.cs.kieler.krep.evalbench.ui.views;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IStatusLineManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.part.ViewPart;

import de.cau.cs.kieler.krep.evalbench.Activator;
import de.cau.cs.kieler.krep.evalbench.trace.ITraceListener;
import de.cau.cs.kieler.krep.evalbench.trace.TraceList;
import de.cau.cs.kieler.krep.evalbench.ui.actions.ResetAction;
import de.cau.cs.kieler.krep.evalbench.ui.actions.RunAction;
import de.cau.cs.kieler.krep.evalbench.ui.actions.StepTraceAction;
import de.cau.cs.kieler.krep.evalbench.ui.actions.StopAction;

/**
 * A View for displaying a trace file.
 * 
 * @author ctr
 */
public class TraceView extends ViewPart implements ITraceListener {

    /** The identifier string for this view. */
    public static final String VIEW_ID = "de.cau.cs.kieler.krep.evalbench.ui.views.trace";

    /** Column identifiers for the embedded table. */
    public static final String[] COLUMN_NAMES = { "tick", "status", "values" };

    /**
     * status column.
     */
    public static final int COLUMN_STATUS = 3;

    /** Table viewer where inputs are listed. */
    private TableViewer viewer = null;
    private Table table = null;

    /** The reset action. */
    private IAction resetAction = null;

    /** The step action. */
    private IAction stepAction = null;

    /** The run action. */
    private IAction runAction = null;

    /** The stop action. */
    private IAction stopAction = null;

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.eclipse.ui.part.WorkbenchPart#createPartControl(org.eclipse.swt.widgets
     * .Composite)
     */
    @Override
    public final void createPartControl(final Composite parent) {
        // create table
        table = new Table(parent, SWT.NONE);

        TableColumn column0 = new TableColumn(table, SWT.NONE, 0);
        column0.setText("Inputs");
        column0.setToolTipText("Current Status and Values");
        column0.setWidth(150);

        TableColumn column1 = new TableColumn(table, SWT.NONE, 1);
        column1.setText("Outputs");
        column1.setToolTipText("Current Outputs");
        column1.setWidth(150);

        TableColumn column2 = new TableColumn(table, SWT.NONE, 2);
        column2.setText("Saved Outputs");
        column2.setToolTipText("Saved Outputs");
        column2.setWidth(150);

        TableColumn column3 = new TableColumn(table, SWT.NONE, 3);
        column3.setText("Checked");
        column3.setToolTipText("Checked");
        column3.setWidth(150);

        TableColumn column4 = new TableColumn(table, SWT.NONE, 4);
        column4.setText("RT");
        column4.setToolTipText("Reaction Time");
        column4.setWidth(150);

        table.setLinesVisible(true);
        table.setHeaderVisible(true);

        // create table viewer
        viewer = new TableViewer(table);
        viewer.setColumnProperties(COLUMN_NAMES);
        viewer.setContentProvider(new TraceContentProvider());
        viewer.setLabelProvider(new TraceLabelProvider());
        if (Activator.getDefault().getTraces() != null) {
            viewer.setInput(Activator.getDefault().getTraces().getTable()
                    .toArray(new String[0][0]));
            viewer.setSelection(new TraceSelectionProvider(), true);
            TraceList.addListener(this);
        }

        IToolBarManager toolBarManager = getViewSite().getActionBars()
                .getToolBarManager();
        IStatusLineManager statusLineManager = getViewSite().getActionBars()
                .getStatusLineManager();
        // create reset action
        resetAction = new ResetAction(statusLineManager, Activator.getDefault()
                .getTraces());
        toolBarManager.add(resetAction);
        resetAction.setEnabled(true);

        // create step action
        stepAction = new StepTraceAction(statusLineManager, Activator
                .getDefault().getTraces());
        toolBarManager.add(stepAction);
        stepAction.setEnabled(true);

        // create run action
        runAction = new RunAction(statusLineManager, Activator.getDefault()
                .getTraces());
        toolBarManager.add(runAction);
        runAction.setEnabled(true);

        // create stop action
        stopAction = new StopAction(statusLineManager);
        toolBarManager.add(stopAction);
        stopAction.setEnabled(false);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.ui.part.WorkbenchPart#setFocus()
     */
    @Override
    public final void setFocus() {
        viewer.getControl().setFocus();
        viewer.refresh();
    }

    /**
     * Enables or disables the control actions in this view.
     * 
     * @param enabled
     *            the new action state
     */
    public final void setActionsEnabled(final boolean enabled) {
        resetAction.setEnabled(enabled);
        stepAction.setEnabled(enabled);
        runAction.setEnabled(enabled);
        stopAction.setEnabled(enabled);
    }

    public final void traceChanged(final boolean newTrace) {
        if (newTrace) {
            viewer.setInput(Activator.getDefault().getTraces().getTable()
                    .toArray(new String[0][0]));
        }
        int[] selection = { Activator.getDefault().getTraces().getTablePos() };
        table.select(selection);
        viewer.refresh();

    }

    @Override
    public final void dispose() {
        super.dispose();
        TraceList.removeListener(this);
    }

}

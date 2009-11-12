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
package de.cau.cs.kieler.viewmanagement;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.ui.part.WorkbenchPart;

/**
 * Creates a new view "VM Control" to manually actuate the view management and its combinations. Will display a view
 * with a toggle button to turn the view management on or off. When on, it will list all the available combinations
 * and provide the ability to turn them on and off individually and on the fly by setting a checkbox infront of ot.
 * @author cmot
 * @author modified nbe
 * 
 * 
 */
public class VMControl extends ViewPart {

    private static VMControl vmControl;
    DataTableViewer viewer;
    private Action actionNew;

    /**
     * This implements a view with the VM Control table. All available combinations are listed here
     * together with their status. It provides also manual control over the single combinations as
     * well as the whole View Management.
     */
    public VMControl() {
        vmControl = this;

    }

    public void init(final IViewSite site) throws PartInitException {
        super.init(site);

    }

    /**
     * gets an instance of VMControl
     * 
     * @return the instance
     */
    public VMControl getInstance() {
        return vmControl;
    }

    public void createPartControl(final Composite parent) {
        createViewer(parent);
        viewer.setInput(new TableDataList(viewer));

        contributeToActionBars();

    }

    // create the viewer itself
    private void createViewer(final Composite parent) {
        viewer = new DataTableViewer(parent, SWT.HIDE_SELECTION | SWT.MULTI | SWT.H_SCROLL
                | SWT.V_SCROLL | SWT.FULL_SELECTION);
        createColumns(viewer);
        viewer.setContentProvider(new TableDataContentProvider());
        viewer.setLabelProvider(new TableDataLabelProvider());

    };

    // create the colums in the table
    private void createColumns(final DataTableViewer viewer) {
        final String[] titles = { "Active", "Combination" };
        final String[] toolTip = { "Status of Combination", "Name of Combination" };
        final int[] bounds = { 45, 450 };

        for (int i = 0; i < titles.length; i++) {
            final TreeViewerColumn column = new TreeViewerColumn(viewer, SWT.NONE);
            column.getColumn().setText(titles[i]);
            column.getColumn().setWidth(bounds[i]);
            column.getColumn().setToolTipText(toolTip[i]);
            column.getColumn().setResizable(true);
            column.getColumn().setMoveable(true);
            if (i == 0) {
                column.getColumn().setResizable(false);
                column.setEditingSupport(new TableDataEditing(viewer, i));
            }
        }
        final Tree tree = viewer.getTree();
        tree.setHeaderVisible(true);
        tree.setLinesVisible(true);
    }

    // add a button to the toolbar for control over the View Mangement
    private void contributeToActionBars() {
        final IActionBars bars = getViewSite().getActionBars();
        final IToolBarManager toolBarManager = bars.getToolBarManager();
        toolBarManager.add(vmOn());
        toolBarManager.add(new Separator());

    }

    /**
     * @see WorkbenchPart#setFocus()
     */
    public void setFocus() {
        viewer.getControl().setFocus();
    }

    // define an action to turn the View Management on or off
    private Action vmOn() {
        if (actionNew != null)
            return actionNew;
        actionNew = new Action() {
            public void run() {
                if (RunLogic.getInstance().getState() == false)
                    RunLogic.getInstance().registerListeners();
                else
                    RunLogic.getInstance().unregisterListeners();
            }
        };
        actionNew.setText("VM on/off");
        actionNew.setToolTipText("VM on/off");

        return actionNew;
    }

}

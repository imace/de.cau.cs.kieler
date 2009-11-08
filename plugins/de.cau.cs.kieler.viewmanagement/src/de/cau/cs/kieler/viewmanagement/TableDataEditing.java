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

package de.cau.cs.kieler.viewmanagement;

import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.CheckboxCellEditor;
import org.eclipse.swt.SWT;

/**
 * The class TableDataEditing implements the editing support for DataTable entries of the table.
 * Specifically it provides a check box CellEditor for the first (present) column and String
 * CellEditors for the second (key) and the third (value) column. <BR>
 * <BR>
 * It also sets a flag that the table is currently edited to prevent disturbing updates during an
 * ongoing editing action. Therefore it needs access to the DataTableViewer.
 * 
 * @author Christian Motika - cmot AT informatik.uni-kiel.de
 * @modified nbe
 */
public class TableDataEditing extends EditingSupport {

    /** The editor of this specific column. */
    private CellEditor editor;

    /** The column index. */
    private int columnIndex;




    // -------------------------------------------------------------------------

    /**
     * Instantiates a new table data editing.
     * 
     * @param viewer
     *            the viewer
     * @param columnIndex
     *            the column index
     */
    public TableDataEditing(DataTableViewer viewer, int columnIndex) {
        super(viewer);



        // Create the correct editor based on the column index
        switch (columnIndex) {
        case 0:
            editor = new CheckboxCellEditor(null, SWT.CHECK);
            break;
        case 1:
            // second column should not be edited
            break;

        default:
            throw new RuntimeException("columnIndex out of bounds (2)");
        }
        this.columnIndex = columnIndex;
    }

    // -------------------------------------------------------------------------

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.viewers.EditingSupport#canEdit(java.lang.Object)
     */
    @Override
    protected boolean canEdit(Object element) {
        /* editing should always be possible */
        return (true);
    }

    // -------------------------------------------------------------------------

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.viewers.EditingSupport#getCellEditor(java.lang.Object)
     */
    @Override
    protected CellEditor getCellEditor(Object element) {
        return editor;
    }

    // -------------------------------------------------------------------------

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.viewers.EditingSupport#getValue(java.lang.Object)
     */
    @Override
    protected Object getValue(Object element) {
        TableData tableData = (TableData) element;

        switch (this.columnIndex) {
        case 0:

            if (tableData.isComboActive()) {
                return true;

            } else
                return false;

        case 1:
            break;
        default:
            break;
        }
        return null;
    }

    // -------------------------------------------------------------------------

    @SuppressWarnings("static-access")
    protected void setValue(Object element, Object value) {
        TableData tableData = (TableData) element;

        switch (this.columnIndex) {
        case 0:
            // checkbox marked
            if (value.toString().equals("true")) {
                tableData.setComboActive(true);
                if (element instanceof TableData) {
                    TableData data = (TableData) element;
                    String comboToActivate = data.getComboName();
                    // Add combination to activeCombos for later finalization
                    RunLogic.getInstance().activeCombos.add(comboToActivate);
                    // Search for combination and initialize
                    for (ACombination oneCombination : (RunLogic.getInstance().combos)) {
                        if (oneCombination.getClass().getCanonicalName().equals(comboToActivate))
                            oneCombination.initialize();
                    }
                }
            } else {
                // checkbox unmarked
                tableData.setComboActive(false);
                if (element instanceof TableData) {
                    TableData data = (TableData) element;

                    String comboToDeactivate = data.getComboName();
                    // Remove combination from list of active combos
                    RunLogic.getInstance().activeCombos.remove(comboToDeactivate);
                    // Search for combination and finalize

                    for (ACombination oneCombination : (RunLogic.getInstance().combos)) {
                        if (oneCombination.getClass().getCanonicalName().equals(comboToDeactivate))
                            oneCombination.finalize();
                    }
                }
            }
            break;
        case 1:

            break;

        default:
            break;
        }

        // updates the table
        getViewer().update(element, null);

    }

}

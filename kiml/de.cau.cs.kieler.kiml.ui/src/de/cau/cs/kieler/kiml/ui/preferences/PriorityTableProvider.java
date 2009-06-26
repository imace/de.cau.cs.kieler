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
 */
package de.cau.cs.kieler.kiml.ui.preferences;

import org.eclipse.jface.viewers.ICellModifier;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.TableItem;

import de.cau.cs.kieler.kiml.layout.services.LayoutProviderData;

/**
 * Provider class for the layouter priorities table. Includes a content provider, a
 * label provider, and a cell modifier.
 * 
 * @author msp
 */
public class PriorityTableProvider extends LabelProvider
        implements IStructuredContentProvider, ITableLabelProvider, ICellModifier {

    /** property name of the layouters column */
    public final static String LAYOUTERS_PROPERTY = "layouters";
    
    /** table viewer that makes use of this provider */
    private TableViewer priorityTableViewer;

    /** data type for row entries in the table */
    public static class DataEntry {
        /** user friendly name of the layout provider */
        String layouterName;
        /** array of priorities for the layout provider */
        int[] priorities;
    }

    /**
     * Creates a table provider instance.
     */
    public PriorityTableProvider(TableViewer tableViewer) {
        this.priorityTableViewer = tableViewer;
    }
    
    /* (non-Javadoc)
     * @see org.eclipse.jface.viewers.IStructuredContentProvider#getElements(java.lang.Object)
     */
    public Object[] getElements(Object inputElement) {
        if (inputElement instanceof DataEntry[])
            return (DataEntry[])inputElement;
        else
            return null;
    }

    /* (non-Javadoc)
     * @see org.eclipse.jface.viewers.IContentProvider#inputChanged(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
     */
    public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
    }

    /* (non-Javadoc)
     * @see org.eclipse.jface.viewers.ITableLabelProvider#getColumnImage(java.lang.Object, int)
     */
    public Image getColumnImage(Object element, int columnIndex) {
        return null;
    }

    /* (non-Javadoc)
     * @see org.eclipse.jface.viewers.ITableLabelProvider#getColumnText(java.lang.Object, int)
     */
    public String getColumnText(Object element, int columnIndex) {
        if (element instanceof DataEntry) {
            DataEntry entry = (DataEntry)element;
            if (columnIndex == 0)
                return entry.layouterName;
            int prio = entry.priorities[columnIndex - 1];
            return prio <= LayoutProviderData.MIN_PRIORITY
                    ? null : Integer.toString(prio);
        }
        else return null;
    }

    /* (non-Javadoc)
     * @see org.eclipse.jface.viewers.ICellModifier#canModify(java.lang.Object, java.lang.String)
     */
    public boolean canModify(Object element, String property) {
        return !property.equals(LAYOUTERS_PROPERTY);
    }

    /* (non-Javadoc)
     * @see org.eclipse.jface.viewers.ICellModifier#getValue(java.lang.Object, java.lang.String)
     */
    public Object getValue(Object element, String property) {
        DataEntry entry = (DataEntry)element;
        try {
            int typeIndex = Integer.parseInt(property);
            int prio = entry.priorities[typeIndex];
            return prio <= LayoutProviderData.MIN_PRIORITY
                    ? "0" : Integer.toString(prio);
        }
        catch (NumberFormatException exception) {
            return null;
        }
    }

    /* (non-Javadoc)
     * @see org.eclipse.jface.viewers.ICellModifier#modify(java.lang.Object, java.lang.String, java.lang.Object)
     */
    public void modify(Object element, String property, Object value) {
        DataEntry entry = (DataEntry)((TableItem)element).getData();
        int typeIndex = Integer.parseInt(property);
        try {
            entry.priorities[typeIndex] = Integer.parseInt((String)value);
        }
        catch (NumberFormatException exception) {
            entry.priorities[typeIndex] = LayoutProviderData.MIN_PRIORITY;
        }
        priorityTableViewer.refresh();
    }

}

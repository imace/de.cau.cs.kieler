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

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ICellModifier;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.TableItem;

import de.cau.cs.kieler.kiml.ui.KimlUiPlugin;

/**
 * Provider class for the layouter priorities table. Includes a content provider, a
 * label provider, and a cell modifier.
 * 
 * @author msp
 */
public class PriorityTableProvider extends LabelProvider
        implements IStructuredContentProvider, ITableLabelProvider, ICellModifier {

    /** index of the 'Diagram Type' column */
    public final static int DIAGRAM_COLUMN = 0;
    /** property name of the 'Diagram Type' column */
    public final static String DIAGRAM_PROPERTY = "diagram";
    /** index of the 'Supported' column */
    public final static int SUPPORTED_COLUMN = 1;
    /** property name of the 'Supported' column */
    public final static String SUPPORTED_PROPERTY = "supported";
    /** index of the 'Priority' column */
    public final static int PRIORITY_COLUMN = 2;
    /** property name of the 'Priority' column */
    public final static String PRIORITY_PROPERTY = "priority";
    
    /** relative path to the image to use for checked objects */
    private final static String CHECKED_PATH = "icons/obj16/checked.gif";
    /** relative path to the image to use for unchecked objects */
    private final static String UNCHECKED_PATH = "icons/obj16/unchecked.gif";
    
    /** image to use for checked objects */
    private Image checkedImage;
    /** image to use for unchecked objects */
    private Image uncheckedImage;
    /** table viewer that makes use of this provider */
    private TableViewer priorityTableViewer;

    /** data type for row entries in the table */
    public static class DataEntry {
        /** user friendly name of the diagram type */
        String diagramTypeName;
        /** indicates whether the current layout provider supports the diagram type */
        boolean supported = false;
        /** the priority with which the diagram type is supported */
        int priority = 0;
    }

    /**
     * Creates a provider instance.
     */
    public PriorityTableProvider(TableViewer tableViewer) {
        this.priorityTableViewer = tableViewer;
        ImageDescriptor checkedImageDescriptor = KimlUiPlugin.imageDescriptorFromPlugin(
                KimlUiPlugin.PLUGIN_ID, CHECKED_PATH);
        checkedImage = checkedImageDescriptor.createImage();
        ImageDescriptor uncheckedImageDescriptor = KimlUiPlugin.imageDescriptorFromPlugin(
                KimlUiPlugin.PLUGIN_ID, UNCHECKED_PATH);
        uncheckedImage = uncheckedImageDescriptor.createImage();  
    }
    
    /*
     * (non-Javadoc)
     * @see org.eclipse.jface.viewers.BaseLabelProvider#dispose()
     */
    public void dispose() {
        checkedImage.dispose();
        uncheckedImage.dispose();
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
        if (element instanceof DataEntry && columnIndex == SUPPORTED_COLUMN) {
            return ((DataEntry)element).supported ? checkedImage : uncheckedImage;
        }
        else return null;
    }

    /* (non-Javadoc)
     * @see org.eclipse.jface.viewers.ITableLabelProvider#getColumnText(java.lang.Object, int)
     */
    public String getColumnText(Object element, int columnIndex) {
        if (element instanceof DataEntry) {
            DataEntry entry = (DataEntry)element;
            switch (columnIndex) {
            case DIAGRAM_COLUMN:
                return entry.diagramTypeName;
            case PRIORITY_COLUMN:
                return entry.supported ? Integer.toString(entry.priority) : "";
            }
        }
        return null;
    }

    /* (non-Javadoc)
     * @see org.eclipse.jface.viewers.ICellModifier#canModify(java.lang.Object, java.lang.String)
     */
    public boolean canModify(Object element, String property) {
        if (SUPPORTED_PROPERTY.equals(property))
            return true;
        if (PRIORITY_PROPERTY.equals(property)) {
            DataEntry entry = (DataEntry)element;
            return entry.supported;
        }
        return false;
    }

    /* (non-Javadoc)
     * @see org.eclipse.jface.viewers.ICellModifier#getValue(java.lang.Object, java.lang.String)
     */
    public Object getValue(Object element, String property) {
        DataEntry entry = (DataEntry)element;
        if (DIAGRAM_PROPERTY.equals(property))
            return entry.diagramTypeName;
        if (SUPPORTED_PROPERTY.equals(property))
            return Boolean.valueOf(entry.supported);
        if (PRIORITY_PROPERTY.equals(property))
            return Integer.toString(entry.priority);
        return null;
    }

    /* (non-Javadoc)
     * @see org.eclipse.jface.viewers.ICellModifier#modify(java.lang.Object, java.lang.String, java.lang.Object)
     */
    public void modify(Object element, String property, Object value) {
        DataEntry entry = (DataEntry)((TableItem)element).getData();
        if (SUPPORTED_PROPERTY.equals(property))
            entry.supported = ((Boolean)value).booleanValue();
        else if (PRIORITY_PROPERTY.equals(property)) {
            try {
                entry.priority = Integer.parseInt((String)value);
            }
            catch (NumberFormatException exception) {}
        }
        priorityTableViewer.refresh();
    }

}

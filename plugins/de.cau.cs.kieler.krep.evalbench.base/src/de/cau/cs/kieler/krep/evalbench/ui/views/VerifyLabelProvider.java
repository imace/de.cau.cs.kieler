/******************************************************************************
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
 ******************************************************************************/
package de.cau.cs.kieler.krep.evalbench.ui.views;

import java.util.LinkedList;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.swt.graphics.Image;

import de.cau.cs.kieler.krep.evalbench.Activator;

/**
 * Display data for verification table, i.e., name of benchmark and information
 * whether execution traces are equal.
 * 
 * @author ctr
 * 
 */
public class VerifyLabelProvider implements ITableLabelProvider {
    /** Relative path to the image to use for present signals. */
    private static final String PRESENT_PATH = "icons/present.gif";
    /** Relative path to the image to use for absent signals. */
    private static final String ABSENT_PATH = "icons/absent.gif";

    /** List of label provider listeners. */
    private LinkedList<ILabelProviderListener> listeners;

    /** Image to use for present signals. */
    private Image presentImage;
    /** Image to use for absent signals. */
    private Image absentImage;

    /**
     * Initializes the program label provider.
     */
    public VerifyLabelProvider() {
        // create list for label provider listeners
        listeners = new LinkedList<ILabelProviderListener>();
        // create images
        ImageDescriptor presentImageDescriptor = Activator
                .imageDescriptorFromPlugin(Activator.PLUGIN_ID, PRESENT_PATH);
        presentImage = presentImageDescriptor.createImage();
        ImageDescriptor absentImageDescriptor = Activator
                .imageDescriptorFromPlugin(Activator.PLUGIN_ID, ABSENT_PATH);
        absentImage = absentImageDescriptor.createImage();
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.eclipse.jface.viewers.ITableLabelProvider#getColumnImage(java.lang
     * .Object, int)
     */
    public Image getColumnImage(final Object element, final int columnIndex) {
        if (element instanceof String[]) {
            String t = ((String[]) element)[columnIndex];
            switch (columnIndex) {
            case 1:
                if (t == null) {
                    return null;
                }
                if (t.equals("true")) {
                    return presentImage;
                }
                if (t.equals("false")) {
                    return absentImage;
                }
                return null;
            default:
                return null;
            }
        } else {
            return null;
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.eclipse.jface.viewers.ITableLabelProvider#getColumnText(java.lang
     * .Object, int)
     */
    public final String getColumnText(final Object element,
            final int columnIndex) {
        if (element instanceof String[]) {
            String[] line = (String[]) element;
            return line[columnIndex];
        } else {
            return null;
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.eclipse.jface.viewers.IBaseLabelProvider#addListener(org.eclipse.
     * jface.viewers.ILabelProviderListener)
     */
    public void addListener(final ILabelProviderListener listener) {
        listeners.add(listener);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.eclipse.jface.viewers.IBaseLabelProvider#removeListener(org.eclipse
     * .jface.viewers.ILabelProviderListener)
     */
    public void removeListener(final ILabelProviderListener listener) {
        listeners.remove(listener);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.viewers.IBaseLabelProvider#dispose()
     */
    public void dispose() {
        // clear list of label provider listeners
        listeners.clear();
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.eclipse.jface.viewers.IBaseLabelProvider#isLabelProperty(java.lang
     * .Object, java.lang.String)
     */
    public boolean isLabelProperty(final Object element, final String property) {
        return true;
    }
}

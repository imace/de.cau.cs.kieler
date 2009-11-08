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

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

/**
 * The Class TableDataContentProvider.
 * 
 * @author Christian Motika - cmot AT informatik.uni-kiel.de
 */
public class TableDataContentProvider implements ITreeContentProvider {

    public final Object[] getElements(final Object inputElement) {
        return ((TableDataList) inputElement).getArray();
    }

    public void dispose() {
    }

    public final void inputChanged(final Viewer viewer, final Object oldInput, final Object newInput) {
    }

    public final Object[] getChildren(final Object parentElement) {

        return null;
    }

    public final Object getParent(final Object element) {

        return null;
    }

    public final boolean hasChildren(final Object element) {

        return false;
    }

}

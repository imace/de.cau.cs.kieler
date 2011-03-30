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

package de.cau.cs.kieler.klots.views;

import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.plugin.AbstractUIPlugin;

/**
 * The class TableDataLabelProvider provides the labels and images for the content of an TableData
 * entry within the table ViewPart.
 * 
 * @author Christian Motika - cmot AT informatik.uni-kiel.de
 */
public class SJInstructionsDataLabelProvider implements ITableLabelProvider {

//    // define icons
//    /** The Constant CHECKED. */
//    private static final Image CHECKED = AbstractUIPlugin.imageDescriptorFromPlugin(
//            "de.cau.cs.kieler.klots", "icons/checked.png").createImage();
//
//    /** The Constant CHECKED_DISABLED. */
//    private static final Image CHECKED_DISABLED = AbstractUIPlugin.imageDescriptorFromPlugin(
//            "de.cau.cs.kieler.klots", "icons/checkedDisabled.png").createImage();
//
//    /** The Constant UNCHECKED. */
//    private static final Image UNCHECKED = AbstractUIPlugin.imageDescriptorFromPlugin(
//            "de.cau.cs.kieler.klots", "icons/unchecked.png").createImage();
//
//    /** The Constant UNCHECKED_DISABLED. */
//    private static final Image UNCHECKED_DISABLED = AbstractUIPlugin.imageDescriptorFromPlugin(
//            "de.cau.cs.kieler.klots", "icons/uncheckedDisabled.png").createImage();
//
//    /** The Constant PERMANENT. */
//    private static final Image PERMANENT = AbstractUIPlugin.imageDescriptorFromPlugin(
//            "de.cau.cs.kieler.sim.table", "icons/permanent.png").createImage();
    
    /** The Constant COLUMN_0. */
    private static final int COLUMN_0 = 0;
    
    /** The Constant COLUMN_1. */
    private static final int COLUMN_1 = 1;
    
    /** The Constant COLUMN_2. */
    private static final int COLUMN_2 = 2;
    
    /** The Constant COLUMN_3. */
    private static final int COLUMN_3 = 3;
    
    /** The Constant COLUMN_4. */
    private static final int COLUMN_4 = 4;
    
    /** The Constant COLUMN_5. */
    private static final int COLUMN_5 = 5;
    
    /** The Constant COLUMN_6. */
    private static final int COLUMN_6 = 6;

    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    public Image getColumnImage(final Object element, final int columnIndex) {
    	SJInstructionsData sjInstructionsData = (SJInstructionsData) element;
//        if (columnIndex == 1) {
//            if (!tableData.isPermanent()) {
//                if (tableData.isPresent()) {
//                    return CHECKED;
//                } else if (tableData.isSignal()) {
//                    return UNCHECKED;
//                } else {
//                    return null;
//                }
//            } else {
//                if (tableData.isPresent()) {
//                    return CHECKED_DISABLED;
//                } else if (tableData.isSignal()) {
//                    return UNCHECKED_DISABLED;
//                } else {
//                    return null;
//                }
//            }
//        }
//        if (columnIndex == 2) {
//            if (tableData.isPermanent()) {
//                return PERMANENT;
//            }
//        }
        return null;
    }

    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    public String getColumnText(final Object element, final int columnIndex) {
    	SJInstructionsData sjInstructionsData = (SJInstructionsData) element;
        switch (columnIndex) {
        case COLUMN_0: // NOT_VISIBLE_COLUMN
            return "";
        case COLUMN_1: // INSTRUCTION_NAME_COLUMN
            return sjInstructionsData.getInstructionsName();
        case COLUMN_2: // LABEL_COLUMN
        	return sjInstructionsData.getLabel();
        case COLUMN_3: // PRIO_COLUMN
            return new Integer( sjInstructionsData.getPrio() ).toString();
        case COLUMN_4: // PARAM_COLUMN
        	if( sjInstructionsData.hasParam() ) {
        		return sjInstructionsData.getParam();
        	} else {
        		return "-";
        	}
        case COLUMN_5: // RETVAL_COLUMN
        	if( sjInstructionsData.hasRetval() ) {
        		return new Boolean( sjInstructionsData.getRetval() ).toString();
        	} else {
        		return "-";
        	}
        case COLUMN_6: // INIT_EXEC_COLUMN
        	if( sjInstructionsData.hasInitialExecution() ) {
        		return new Boolean( sjInstructionsData.getInitialExecution() ).toString();
        	} else {
        		return "-";
        	}
        default:
            throw new RuntimeException("columnIndex out of bounds (6)");
        }
    }

    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    public void addListener(final ILabelProviderListener listener) {
        // noop
    }

    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    public void dispose() {
        // noop
    }

    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    public boolean isLabelProperty(final Object element, final String property) {
        return false;
    }

    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    public void removeListener(final ILabelProviderListener listener) {
        // noop
    }

}

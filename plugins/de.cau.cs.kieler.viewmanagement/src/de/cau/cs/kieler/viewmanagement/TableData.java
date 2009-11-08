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

/**
 * The class TableData implements a single data entry that represents combination within the data
 * table. A combination can be active or not and has a String that represents its name.
 * 
 * @author Christian Motika - cmot AT informatik.uni-kiel.de
 * @modified nbe
 */
public class TableData {

    /* The parent TableDataList the entry contains to. */
    private TableDataList tableDataList;

    private boolean comboActive;

    /** The key of the entry. */
    private String comboName;

    // ---------------------------------------------------------------------

    /**
     * Gets the parent TableDataList.
     * 
     * @return the parent TableDataList
     */
    public final TableDataList getParentTableDataList() {
        return tableDataList;
    }

    // ---------------------------------------------------------------------

    /**
     * Instantiates a new TableData entry.
     * 
     * @param parentTableDataList
     *            the parent TableDataList
     * @param comboActive
     *            combination is active or not
     * @param comboName
     *            name of the combination
     */
    public TableData(TableDataList parentTableDataList, boolean comboActive, String comboName) {
        this.tableDataList = parentTableDataList;
        this.comboActive = comboActive;

        this.comboName = comboName;

    }

    /**
     * Gets the key of the entry.
     * 
     * @return the key
     */
    public final String getComboName() {
        return this.comboName;
    }

    /**
     * Sets the key of the entry.
     * 
     * @param comboName
     *            the new key
     * 
     * @throws Exception
     *             the exception if the key already exists in the parent TableDataList
     */

    /**
     * Sets the active flag for the combination.
     * 
     * @param active
     *            active state of the combination
     */
    public void setComboActive(final boolean active) {
        this.comboActive = active;

    }

    // ---------------------------------------------------------------------

    /**
     * Checks whether the combination is active
     * 
     * @return true, if combination is active
     */
    public final boolean isComboActive() {

        return (this.comboActive);
    }

}

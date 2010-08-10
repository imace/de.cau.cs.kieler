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

package de.cau.cs.kieler.viewmanagement.view;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.widgets.Display;

/**
 * The class TableDataList implements a list of TableData elements that are the
 * input of the DataTableViewer. This list is modified by the producer and
 * observer DataComponent.
 * 
 * @author Christian Motika - cmot AT informatik.uni-kiel.de
 * @author modified nbe
 * 
 */
public class TableDataList {

	/** The list of TableData entries. */
	private List<TableData> tableDataList;

	/** The one and only static instance of this class. */
	private static TableDataList instance;

	/** The parent viewer to trigger refreshes. */
	DataTableViewer viewer;

	// -------------------------------------------------------------------------

	/**
	 * Instantiates a new TableDataList.
	 * 
	 * @param viewer
	 *            the parent tree table viewer for refreshes
	 */
	public TableDataList(final DataTableViewer viewer) {
		this.viewer = viewer;
		tableDataList = new ArrayList<TableData>();
		instance = this;
	}

	// -------------------------------------------------------------------------

	/**
	 * Returns the index of an TableData entry.
	 * 
	 * @param tableData
	 *            the TableData entry
	 * 
	 * @return the index
	 */
	public final int indexOf(final TableData tableData) {
		return tableDataList.indexOf(tableData);
	}

	// -------------------------------------------------------------------------

	/**
	 * Updates the view of the parent tree table viewer asynchronously.
	 */
	public final void updateViewAsync() {
		// asynchronously update the table
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				if (viewer != null) {
					viewer.refresh();
				}
			}
		});
	}

	// -------------------------------------------------------------------------

	/**
	 * Adds a TableData entry to the list.
	 * 
	 * @param tableData
	 *            the TableData entry
	 */
	public final void add(final TableData tableData) {
		if (contains(tableData.getComboName())) {
			remove(tableData.getComboName());
		}
		tableDataList.add(tableData);
	}

	// -------------------------------------------------------------------------

	/**
	 * Gets a TableData entry with a specific key as an identifier.
	 * 
	 * @param key
	 *            the identifier key
	 * 
	 * @return the TableData entry
	 */
	public final TableData get(final String key) {
		for (int c = 0; c < tableDataList.size(); c++) {
			if (tableDataList.get(c).getComboName().equals(key)) {
				return tableDataList.get(c);
			}
		}
		return null;
	}

	// -------------------------------------------------------------------------

	/**
	 * Gets a TableData entry with a specific index as an identifier.
	 * 
	 * @param index
	 *            the identifier index
	 * 
	 * @return the TableData entry
	 */
	public final TableData get(final int index) {
		return tableDataList.get(index);
	}

	// -------------------------------------------------------------------------

	/**
	 * Checks whether the list contains a TableData entry with the specific key.
	 * 
	 * @param key
	 *            the identifier key
	 * 
	 * @return true, if list contains that TableData entry
	 */
	public final boolean contains(final String key) {
		return (get(key) != null);
	}

	// -------------------------------------------------------------------------

	/**
	 * Checks whether the list contains a duplicate TableData entry with the
	 * same key as the provided one.
	 * 
	 * @param key
	 *            the identifier key
	 * @param tableData
	 *            the TableData entry
	 * 
	 * @return true, if list contains another TableData entry
	 */
	public final boolean containsOther(final String key,
			final TableData tableData) {
		for (int c = 0; c < tableDataList.size(); c++) {
			if ((tableDataList.get(c).getComboName().equals(key))
					&& (tableData != tableDataList.get(c))) {
				return true;
			}
		}
		return false;
	}

	// -------------------------------------------------------------------------

	/**
	 * Removes the TableData entry with the specific key from list.
	 * 
	 * @param key
	 *            the identifier key
	 */
	public void remove(String key) {
		for (int c = 0; c < tableDataList.size(); c++) {
			if (tableDataList.get(c).getComboName().equals(key)) {
				tableDataList.remove(c);
			}
		}
	}

	// -------------------------------------------------------------------------

	/**
	 * Gets the single instance of this TableDataList class.
	 * 
	 * @return single instance of TableDataList
	 */
	public static synchronized TableDataList getInstance() {
		if (instance == null) {
			instance = new TableDataList(null);
		}
		return instance;
	}

	// -------------------------------------------------------------------------

	/**
	 * Gets the size of this list.
	 * 
	 * @return the size
	 */
	public final int size() {
		return tableDataList.size();
	}

	// -------------------------------------------------------------------------

	/**
	 * Gets the list of TableData entries as an array of TableData entries.
	 * 
	 * @return the TableData[] array
	 */
	public final TableData[] getArray() {
		TableData[] array = new TableData[this.size()];
		for (int c = 0; c < this.size(); c++) {
			array[c] = this.get(c);
		}
		return array;
	}

}

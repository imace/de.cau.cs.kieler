package de.cau.cs.kieler.krep.evalbench.ui.views;


import org.eclipse.jface.viewers.ICellModifier;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.widgets.Item;

import de.cau.cs.kieler.krep.evalbench.comm.*;

/**
 * Modifier for the table viewer that is embedded in the
 * input view.
 * 
 * @author msp
 */
public class InputSignalModifier implements ICellModifier {

	/** The table viewer that uses this modifier */
	private TableViewer parentViewer;
	
	/**
	 * Creates an input signal modifier.
	 * 
	 * @param parent the table viewer that uses this modifier
	 */
	public InputSignalModifier(TableViewer parent) {
		this.parentViewer = parent;
	}
	
	/**
	 * Finds the column index from a given column name.
	 * 
	 * @param property property name
	 * @return the column index, or -1 if the given property
	 *         was not found
	 */
	private static int getColumnIndex(String property) {
		for (int i = 0; i < InputView.COLUMN_NAMES.length; i++) {
			if (property.equals(InputView.COLUMN_NAMES[i]))
				return i;
		}
		return -1;
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.eclipse.jface.viewers.ICellModifier#canModify(java.lang.Object, java.lang.String)
	 */
	public boolean canModify(Object element, String property) {
		int columnIndex = getColumnIndex(property);
		// get signal to analyze
		Signal s;
		if (element instanceof Item)
			s = (Signal)((Item)element).getData();
		else
			s = (Signal)element;
		// return modifiability information
		switch (columnIndex) {
		case 1:
			return true;
		case 2:
			return s.isValued();
		default:
			return false;
		}
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.jface.viewers.ICellModifier#getValue(java.lang.Object, java.lang.String)
	 */
	public Object getValue(Object element, String property) {
		int columnIndex = getColumnIndex(property);
		// get signal to retrieve value
		Signal s;
		if (element instanceof Item)
			s = (Signal)((Item)element).getData();
		else
			s = (Signal)element;
		// get value from signal
		switch (columnIndex) {
		case 0:
			return s.getName();
		case 1:
			return new Boolean(s.getPresent());
		case 2:
			Object value = s.getValue();
			if (value != null)
				return value.toString();
			else
				return "";
		default:
			return null;
		}
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.jface.viewers.ICellModifier#modify(java.lang.Object, java.lang.String, java.lang.Object)
	 */
	public void modify(Object element, String property, Object value) {
		int columnIndex = getColumnIndex(property);
		// get signal to modify
		Signal s;
		if (element instanceof Item)
			s = (Signal)((Item)element).getData();
		else
			s = (Signal)element;
		// modify specified property
		switch (columnIndex) {
		case 1:
			s.setPresent(((Boolean)value).booleanValue());
			break;
		case 2:
			try {
				s.setValue(Integer.valueOf((String)value));
			} catch (NumberFormatException e) {
				s.setValue(new Integer(0));
			}
			break;
		}
		parentViewer.refresh();
	}

}

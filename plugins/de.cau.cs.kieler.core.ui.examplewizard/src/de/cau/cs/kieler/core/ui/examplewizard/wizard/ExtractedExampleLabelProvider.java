package de.cau.cs.kieler.core.ui.examplewizard.wizard;

import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;

import de.cau.cs.kieler.core.ui.examplewizard.util.Example;

/**
 * LabelProvider extracts the data for the table from the examples. 
 * @author omi
 * 
 */
public class ExtractedExampleLabelProvider extends LabelProvider implements
		ITableLabelProvider {

	/**
	 * @see org.eclipse.jface.viewers.ITableLabelProvider#getColumnImage(java.lang.Object, int)
	 */
	public Image getColumnImage(Object element, int columnIndex) {
		// no images used, so nothing to do
		return null;
	}

	/**
	 * @see org.eclipse.jface.viewers.ITableLabelProvider#getColumnText(java.lang.Object, int)
	 */
	public String getColumnText(Object element, int columnIndex) {
		Example example = (Example) element;
		switch (columnIndex) {
		case 0:
			return example.getName();
		case 1:
			return example.getVersion();
		case 2:
			return example.getDescription();
		default:
			return "unknown" + columnIndex;
		}
	}

}

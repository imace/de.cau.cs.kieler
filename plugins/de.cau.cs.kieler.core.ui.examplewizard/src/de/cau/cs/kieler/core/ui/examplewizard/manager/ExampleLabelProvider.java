package de.cau.cs.kieler.core.ui.examplewizard.manager;

import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;

import de.cau.cs.kieler.core.ui.examplewizard.util.Example;

public class ExampleLabelProvider extends LabelProvider implements
		ITableLabelProvider {

	@Override
	public Image getColumnImage(Object element, int columnIndex) {
		// no images used, so nothing to do.
		return null;
	}

	@Override
	public String getColumnText(Object element, int columnIndex) {
		Example example = (Example) element;
		String result;
		switch (columnIndex) {
		case 0:
			result = example.getName();
			break;
		case 1:
			result = example.getVersion();
			break;
		case 2:
			result = example.getPluginId();
			break;
		case 3:
			result = example.getDescription();
			break;
		default:
			result = "unknown" + columnIndex;
			break;
		}
		return result;
	}

}

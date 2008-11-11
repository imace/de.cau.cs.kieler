package edu.unikiel.rtsys.kieler.kiml.layout.util;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

import edu.unikiel.rtsys.kieler.kiml.layout.services.KimlAbstractLayoutProvider;

public class KimlLayoutUtilPreferencePage {

	/**
	 * Convenient function for all contributing layout providers to create the
	 * section in the preference page showing the available layouters.
	 * 
	 * @param parent
	 *            Parent composite to which the group should be added.
	 * @param layoutProvider
	 *            The concrete layout provider to get the LayoutInfo from
	 */
	public static void createLayouterTable(Composite parent,
			KimlAbstractLayoutProvider layoutProvider) {

		Table layouterTable = new Table(parent, SWT.BORDER);
		layouterTable.setLinesVisible(true);
		layouterTable.setHeaderVisible(true);
		// layouterTable.setEnabled(false);

		TableColumn layouterName = new TableColumn(layouterTable, SWT.NONE);
		layouterName.setText("Layouter name");
		TableColumn layoutType = new TableColumn(layouterTable, SWT.NONE);
		layoutType.setText("Layout type");
		TableColumn layoutOptions = new TableColumn(layouterTable, SWT.NONE);
		layoutOptions.setText("Layout options");

//		for (LAYOUTER_INFO layouterInfo : layoutProvider.getLayouterInfos()) {
//			TableItem item = new TableItem(layouterTable, SWT.NONE);
//			item.setText(0, layouterInfo.getLayouterName());
//			item.setText(1, layouterInfo.getLayoutType().getLiteral());
//			item.setText(2, layouterInfo.getLayoutOption().getLiteral());
//		}

		layouterName.pack();
		layoutType.pack();
	}
}

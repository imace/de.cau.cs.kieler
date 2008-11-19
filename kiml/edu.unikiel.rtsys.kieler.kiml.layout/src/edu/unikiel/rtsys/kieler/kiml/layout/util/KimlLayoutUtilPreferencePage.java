/*******************************************************************************
 * Copyright (c) 2008 Real-Time and Embedded Systems group
 *
 * INSERT LICENCE HERE
 *
 *
 * Author: Arne Schipper, ars@informatik.uni-kiel.de 
 *
 *******************************************************************************/
package edu.unikiel.rtsys.kieler.kiml.layout.util;

import java.util.ArrayList;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.FieldEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;

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
	public static ArrayList<FieldEditor> createLayouterTable(Composite parent,
			ArrayList<KimlAbstractLayoutProvider> layoutProviders) {

		ArrayList<FieldEditor> createdFieldEditors = new ArrayList<FieldEditor>();
		
		Group availableLayouters = new Group(parent, SWT.NONE);
		availableLayouters.setText("Available Layouters");
/*
		Table layouterTable = new Table(availableLayouters, SWT.BORDER
				| SWT.V_SCROLL | SWT.H_SCROLL);

		layouterTable.setLinesVisible(true);
		layouterTable.setHeaderVisible(true);
		layouterTable.setEnabled(true);

		TableColumn layouterActive = new TableColumn(layouterTable, SWT.NONE);
		layouterActive.setText("Active");
		TableColumn layouterName = new TableColumn(layouterTable, SWT.NONE);
		layouterName.setText("Layouter name");
		TableColumn layoutType = new TableColumn(layouterTable, SWT.NONE);
		layoutType.setText("Layout type");
		TableColumn layoutOptions = new TableColumn(layouterTable, SWT.NONE);
		layoutOptions.setText("Layout options");
*/
		Label description = new Label(availableLayouters, SWT.WRAP);
		description
				.setText("Enable the layouter you want to use:");
		description.setLayoutData(new GridData(GridData.FILL, GridData.FILL,
				true, true, 2, 1));
		for (KimlAbstractLayoutProvider layoutProvider : layoutProviders) {
			/*
			TableItem item = new TableItem(layouterTable, SWT.NONE);
			 
			item.setData(layoutProvider.getLayouterInfo().getLayouterName());
			item.setText(1, layoutProvider.getLayouterInfo().getLayouterName());
			item.setText(2, layoutProvider.getLayouterInfo().getLayoutType()
					.getLiteral());
			item.setText(3, layoutProvider.getLayouterInfo().getLayoutOption()
					.getLiteral());
			*/
			String label = layoutProvider.getLayouterInfo().getLayouterName() + ", " + layoutProvider.getLayouterInfo().getLayoutType();
			BooleanFieldEditor enable = new BooleanFieldEditor(layoutProvider
					.getLayouterInfo().getLayouterName(), label, availableLayouters);
			createdFieldEditors.add(enable);
		}
/*
		layouterActive.pack();
		layouterName.pack();
		layoutType.pack();
		layoutOptions.pack();

		layouterTable.setLayoutData(new GridData(GridData.FILL,
				GridData.FILL, true, false, 4, 1));
	*/	
		availableLayouters.setLayoutData(new GridData(GridData.FILL,
				GridData.FILL, true, false, 2, 1));
		GridLayout gl = new GridLayout();
		gl.marginWidth = 15;
		gl.marginHeight = 10;
		availableLayouters.setLayout(gl);

		return createdFieldEditors;
	}
}

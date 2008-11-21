/*******************************************************************************
 * Copyright (c) 2008 Real-Time and Embedded Systems group
 *
 * INSERT LICENCE HERE
 *
 *
 * Author: Arne Schipper, ars@informatik.uni-kiel.de 
 *
 *******************************************************************************/
package edu.unikiel.rtsys.kieler.kiml.ui.preferences;

import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.IntegerFieldEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Group;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import edu.unikiel.rtsys.kieler.kiml.ui.KimlUiPlugin;


public class GenericDiagramLayouterPreferencePage extends
		FieldEditorPreferencePage implements IWorkbenchPreferencePage {

	public GenericDiagramLayouterPreferencePage() {
		super(GRID);
		setPreferenceStore(KimlUiPlugin.getDefault().getPreferenceStore());
		setDescription("Set the options for the Generic Diagram Layouter");
	}
	@Override
	protected void createFieldEditors() {
		// define gl as GridLayout globally
		GridLayout gl = null;

		// options group
		Group insets = new Group(this.getFieldEditorParent(), SWT.NONE);
		insets.setText("Insets:");

		IntegerFieldEditor top = new IntegerFieldEditor(
				PreferenceConstants.PREF_GENERIC_DIAGRAM_LAYOUTER_INSET_TOP,
				"Inset top:", insets, 3);
		IntegerFieldEditor left = new IntegerFieldEditor(
				PreferenceConstants.PREF_GENERIC_DIAGRAM_LAYOUTER_INSET_LEFT,
				"Inset left:", insets, 3);
		IntegerFieldEditor right = new IntegerFieldEditor(
				PreferenceConstants.PREF_GENERIC_DIAGRAM_LAYOUTER_INSET_BOTTOM,
				"Inset bottom:", insets, 3);
		IntegerFieldEditor bottom = new IntegerFieldEditor(
				PreferenceConstants.PREF_GENERIC_DIAGRAM_LAYOUTER_INSET_RIGHT,
				"Inset right:", insets, 3);
		insets.setLayoutData(new GridData(GridData.FILL, GridData.FILL, true,
				false, 2, 1));
		gl = new GridLayout(2, true);
		gl.marginWidth = 15;
		gl.marginHeight = 10;
		insets.setLayout(gl);

		// now add all the stuff
		addField(top);
		addField(left);
		addField(right);
		addField(bottom);
	}

	@Override
	public void init(IWorkbench arg0) {
		// TODO Auto-generated method stub

	}

}

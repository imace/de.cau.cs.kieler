/*******************************************************************************
 * Copyright (c) 2008 Real-Time and Embedded Systems group
 *
 * INSERT LICENCE HERE
 *
 *
 * Author: Arne Schipper, ars@informatik.uni-kiel.de 
 *
 *******************************************************************************/
package de.cau.cs.kieler.kiml.layouter.example.preferences;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.IntegerFieldEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Group;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import de.cau.cs.kieler.kiml.layouter.example.Activator;
import de.cau.cs.kieler.kiml.ui.AbstractKimlLayoutProviderPreferencePage;


/**
 * The Example Layouter preference page. This page extends the
 * {@link de.cau.cs.kieler.kiml.ui.AbstractKimlLayoutProviderPreferencePage
 * AbstractKimlLayoutProviderPreferencePage} to draw the group for enabling and
 * disabling all the available Example layouters.
 * 
 * @author <a href="mailto:ars@informatik.uni-kiel.de">Arne Schipper</a>
 */
public class ExampleLayouterPreferencePage extends
		AbstractKimlLayoutProviderPreferencePage implements
		IWorkbenchPreferencePage {

	/**
	 * The constructor for the preference page, uses
	 * {@link de.cau.cs.kieler.kiml.ui.AbstractKimlLayoutProviderPreferencePage
	 * AbstractKimlLayoutProviderPreferencePage} to generate the fields for
	 * enabling and disabling the layouters of the Example Layouters suite
	 * (currently just one).
	 */
	public ExampleLayouterPreferencePage() {
		super(Activator.LAYOUT_PROVIDER_COLLECTION_ID, GRID);
		setPreferenceStore(Activator.getDefault().getPreferenceStore());
		setDescription("Set the options for the Example Layout engine:");
	}

	/**
	 * Creates the field editors. Field editors are abstractions of the common
	 * GUI blocks needed to manipulate various types of preferences. Each field
	 * editor knows how to save and restore itself.
	 */
	public void createFieldEditors() {
		super.createFieldEditors();
		// define gl as GridLayout globally
		GridLayout gl = null;

		// options group
		Group options = new Group(this.getFieldEditorParent(), SWT.NONE);
		options.setText("Options:");

		IntegerFieldEditor padx = new IntegerFieldEditor(
				PreferenceConstants.PREF_LAYOUTER_EXAMPLE_PADDING_X,
				"Padding X:", options, 2);
		IntegerFieldEditor pady = new IntegerFieldEditor(
				PreferenceConstants.PREF_LAYOUTER_EXAMPLE_PADDING_Y,
				"Padding Y:", options, 2);
		BooleanFieldEditor direction = new BooleanFieldEditor(
				PreferenceConstants.PREF_LAYOUTER_EXAMPLE_HORIZONTAL,
				"&Layout direction horizontal?", options);
		options.setLayoutData(new GridData(GridData.FILL, GridData.FILL, true,
				false, 2, 1));
		gl = new GridLayout(2, true);
		gl.marginWidth = 15;
		gl.marginHeight = 10;
		options.setLayout(gl);

		// now add all the stuff
		addField(padx);
		addField(pady);
		addField(direction);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.IWorkbenchPreferencePage#init(org.eclipse.ui.IWorkbench)
	 */
	public void init(IWorkbench workbench) {
	}
}
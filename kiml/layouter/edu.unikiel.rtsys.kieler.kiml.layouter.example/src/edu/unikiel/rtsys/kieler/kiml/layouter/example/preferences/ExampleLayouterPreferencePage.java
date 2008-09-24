package edu.unikiel.rtsys.kieler.kiml.layouter.example.preferences;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.IntegerFieldEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Group;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import edu.unikiel.rtsys.kieler.kiml.layout.util.KimlLayoutUtilPreferencePage;
import edu.unikiel.rtsys.kieler.kiml.layouter.example.Activator;
import edu.unikiel.rtsys.kieler.kiml.layouter.example.ExampleLayoutProvider;

/**
 * This class represents a preference page that is contributed to the
 * Preferences dialog. By subclassing <samp>FieldEditorPreferencePage</samp>, we
 * can use the field support built into JFace that allows us to create a page
 * that is small and knows how to save, restore and apply itself.
 * <p>
 * This page is used to modify preferences only. They are stored in the
 * preference store that belongs to the main plug-in class. That way,
 * preferences can be accessed directly via the preference store.
 */

public class ExampleLayouterPreferencePage extends FieldEditorPreferencePage
		implements IWorkbenchPreferencePage {

	public ExampleLayouterPreferencePage() {
		super(GRID);
		setPreferenceStore(Activator.getDefault().getPreferenceStore());
		setDescription("Set the options for the Example Layout engine");
	}

	/**
	 * Creates the field editors. Field editors are abstractions of the common
	 * GUI blocks needed to manipulate various types of preferences. Each field
	 * editor knows how to save and restore itself.
	 */
	public void createFieldEditors() {
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

		// layouters group
		Group availableLayouters = new Group(this.getFieldEditorParent(),
				SWT.NONE);
		availableLayouters.setText("Available Layouters");

		KimlLayoutUtilPreferencePage.createLayouterTable(availableLayouters,
				new ExampleLayoutProvider());
		availableLayouters.setLayoutData(new GridData(GridData.FILL,
				GridData.FILL, true, false, 2, 1));
		gl = new GridLayout();
		gl.marginWidth = 15;
		gl.marginHeight = 10;
		availableLayouters.setLayout(gl);

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
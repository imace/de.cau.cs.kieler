package edu.unikiel.rtsys.kieler.kiml.layouter.graphviz.preferences;

import kiel.layouter.graphviz.GraphvizLayoutProvider;

import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.IntegerFieldEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Group;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import edu.unikiel.rtsys.kieler.kiml.layout.util.KimlLayoutUtilPreferencePage;
import edu.unikiel.rtsys.kieler.kiml.layouter.graphviz.Activator;

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

public class GraphvizPreferencePage extends FieldEditorPreferencePage implements
		IWorkbenchPreferencePage {

	public GraphvizPreferencePage() {
		super(GRID);
		setPreferenceStore(Activator.getDefault().getPreferenceStore());
		setDescription("Set the options for the GraphViz layout engine");
	}

	/**
	 * Creates the field editors. Field editors are abstractions of the common
	 * GUI blocks needed to manipulate various types of preferences. Each field
	 * editor knows how to save and restore itself.
	 */
	public void createFieldEditors() {
		// define gl as GridLayout globally
		GridLayout gl = null;

		// padding group
		Group padding = new Group(this.getFieldEditorParent(), SWT.NONE);
		padding.setText("Padding:");

		IntegerFieldEditor padx = new IntegerFieldEditor(
				PreferenceConstants.PREF_GRAPHVIZ_PADDING_X, "Padding X:",
				padding, 2);

		IntegerFieldEditor pady = new IntegerFieldEditor(
				PreferenceConstants.PREF_GRAPHVIZ_PADDING_Y, "Padding Y:",
				padding, 2);
		padding.setLayoutData(new GridData(GridData.FILL, GridData.FILL, true,
				false, 2, 1));
		gl = new GridLayout(2, true);
		gl.marginWidth = 15;
		gl.marginHeight = 10;
		padding.setLayout(gl);

		// layouters group
		Group availableLayouters = new Group(this.getFieldEditorParent(),
				SWT.NONE);
		availableLayouters.setText("Available Layouters");
		KimlLayoutUtilPreferencePage.createLayouterTable(availableLayouters,
				new GraphvizLayoutProvider());
		availableLayouters.setLayoutData(new GridData(GridData.FILL,
				GridData.FILL, true, false, 2, 1));
		gl = new GridLayout();
		gl.marginWidth = 15;
		gl.marginHeight = 10;
		availableLayouters.setLayout(gl);

		// now add all the stuff
		addField(padx);
		addField(pady);
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
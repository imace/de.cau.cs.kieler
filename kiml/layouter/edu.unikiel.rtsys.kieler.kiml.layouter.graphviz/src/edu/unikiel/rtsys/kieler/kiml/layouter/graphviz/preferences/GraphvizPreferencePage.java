package edu.unikiel.rtsys.kieler.kiml.layouter.graphviz.preferences;

import java.util.ArrayList;

import kiel.layouter.graphviz.GraphvizLayoutProviderNames;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.DirectoryFieldEditor;
import org.eclipse.jface.preference.FieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.IntegerFieldEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import edu.unikiel.rtsys.kieler.kiml.layout.services.KimlAbstractLayoutProvider;
import edu.unikiel.rtsys.kieler.kiml.layout.services.LayoutProviders;
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
				false, 3, 1));
		gl = new GridLayout(3, true);
		gl.marginWidth = 15;
		gl.marginHeight = 10;
		padding.setLayout(gl);

		// layouters group
		ArrayList<FieldEditor> editorsToAdd = KimlLayoutUtilPreferencePage.createLayouterTable(this.getFieldEditorParent(),
				LayoutProviders.getInstance().getLayoutProvidersOfCollection(
						"GraphViz Collection"));

		// debug group
		Group debug = new Group(this.getFieldEditorParent(), SWT.NONE);
		debug.setText("Debug:");

		BooleanFieldEditor enableDebug = new BooleanFieldEditor(
				PreferenceConstants.PREF_GRAPHVIZ_ENABLE_DEBUG_OUTPUT,
				"Enable debug output (*.dot)", debug);
		DirectoryFieldEditor debugDir = new DirectoryFieldEditor(
				PreferenceConstants.PREF_GRAPHVIZ_DEBUG_DIR,
				"Debug directory:", debug);
		Label description = new Label(debug, SWT.WRAP);
		description
				.setText("If a directory is chosen, debug output of GraphViz (the *.dot files) go there. Otherwise the user home directory is chosen.");
		description.setLayoutData(new GridData(GridData.FILL, GridData.FILL,
				true, true, 2, 1));
		debug.setLayoutData(new GridData(GridData.FILL, GridData.FILL, true,
				false, 3, 2));
		gl = new GridLayout(3, false);
		gl.marginWidth = 15;
		gl.marginHeight = 10;
		debug.setLayout(gl);

		// now add all the stuff
		addField(padx);
		addField(pady);

		for (FieldEditor editorToAdd : editorsToAdd){
			addField(editorToAdd);
		}
		addField(enableDebug);
		addField(debugDir);
	}

	@Override
	public boolean performOk() {
		boolean retVal = super.performOk();
		for (KimlAbstractLayoutProvider exampleLayoutProvider : LayoutProviders
				.getInstance()
				.getLayoutProvidersOfCollection(
						GraphvizLayoutProviderNames.LAYOUT_PROVIDER_COLLECTION_ID)) {
			boolean state = getPreferenceStore().getBoolean(
					exampleLayoutProvider.getLayouterInfo().getLayouterName());
			exampleLayoutProvider.setEnabled(state);
		}
		return retVal;
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
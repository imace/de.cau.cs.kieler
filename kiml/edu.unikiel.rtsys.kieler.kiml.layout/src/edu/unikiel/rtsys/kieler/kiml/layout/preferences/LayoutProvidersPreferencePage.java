package edu.unikiel.rtsys.kieler.kiml.layout.preferences;

import java.util.ArrayList;

import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.RadioGroupFieldEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Group;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutPlugin;
import edu.unikiel.rtsys.kieler.kiml.layout.services.LayoutProviders;

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

public class LayoutProvidersPreferencePage extends FieldEditorPreferencePage implements
		IWorkbenchPreferencePage {

	public LayoutProvidersPreferencePage() {
		super(GRID);
		setPreferenceStore(KimlLayoutPlugin.getDefault().getPreferenceStore());
		setDescription("Set here the general layout options that do not apply to a specific layout engine");
	}

	/**
	 * Creates the field editors. Field editors are abstractions of the common
	 * GUI blocks needed to manipulate various types of preferences. Each field
	 * editor knows how to save and restore itself.
	 */
	public void createFieldEditors() {
		// define gl as GridLayout globally
		GridLayout gl = null;

		// default layouter group
		Group defaultLayouter = new Group(this.getFieldEditorParent(), SWT.NONE);
		defaultLayouter.setText("Default Layouter");
		String[][] options = getAvailableLayouterNames();
		addField(new RadioGroupFieldEditor(
				PreferenceConstants.PREF_LAYOUTPROVIDERS_DEFAULT_LAYOUTER, "Choose the default layouter:",
				2, options, defaultLayouter));

		gl = new GridLayout(1, true);
		gl.marginWidth = 15;
		gl.marginHeight = 10;
		defaultLayouter.setLayout(gl);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.IWorkbenchPreferencePage#init(org.eclipse.ui.IWorkbench)
	 */
	public void init(IWorkbench workbench) {
	}

	private String[][] getAvailableLayouterNames() {
		ArrayList<String> names = LayoutProviders.getInstance()
				.getAvailableLayouterNames();
		String[][] options = new String[names.size()][2];

		for (int i = 0; i < options.length; i++) {
			options[i][0] = names.get(i);
			options[i][1] = names.get(i);
		}
		return options;
	}
}
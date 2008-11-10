package edu.unikiel.rtsys.kieler.kiml.layout.preferences;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutPlugin;
import edu.unikiel.rtsys.kieler.kiml.layout.util.KimlLayoutPreferenceConstants;

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

public class DiagramLayoutersPreferencePage extends FieldEditorPreferencePage
		implements IWorkbenchPreferencePage {

	public DiagramLayoutersPreferencePage() {
		super(GRID);
		setPreferenceStore(KimlLayoutPlugin.getDefault().getPreferenceStore());
		setDescription("Set the options for the KIML Diagram Layouters");
	}

	/**
	 * Creates the field editors. Field editors are abstractions of the common
	 * GUI blocks needed to manipulate various types of preferences. Each field
	 * editor knows how to save and restore itself.
	 */
	public void createFieldEditors() {
		addField(new BooleanFieldEditor(
				KimlLayoutPreferenceConstants.PREF_DIAGRAMLAYOUTERS_DO_NOT_LAYOUT_CONNECTION_LABELS,
				"Use GMF to layout connection lables", getFieldEditorParent()));
		Label description = new Label(getFieldEditorParent(), SWT.WRAP);
		description
				.setText("If checked do not use the layout information provided by the layout engine to layout the labels. Use the internal functions of the graphical editor, if it has any. Might lead to a better placement.");

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
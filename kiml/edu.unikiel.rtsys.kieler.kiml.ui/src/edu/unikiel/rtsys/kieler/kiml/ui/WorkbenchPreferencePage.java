package edu.unikiel.rtsys.kieler.kiml.ui;

import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.IntegerFieldEditor;
import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

/**
 * This is a simple example preferences page. It extends the FieldEditorPreferencePage,
 * which provides very easy setup of standard values (boolean, String, Combos, Lists, 
 * Paths, Colors, etc.)
 * @author Hauke Fuhrmann, haf
 *
 */

public class WorkbenchPreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage{

	public static final String PREF_TEST = "ui.test";
	
	@Override
	protected void createFieldEditors() {
		this.setMessage("KIML: KIELER Infrastructure for Meta Layout");
		this.addField(new StringFieldEditor(PREF_TEST, "Test pref",StringFieldEditor.UNLIMITED,StringFieldEditor.VALIDATE_ON_KEY_STROKE, getFieldEditorParent()));
//		this.addField(new IntegerFieldEditor(PORT_EDITOR, "Port Number", getFieldEditorParent()));
	}

	@Override
	public void init(IWorkbench workbench) {
		// set the preference store
		IPreferenceStore preferenceStore = KimlUiPlugin.getDefault().getPreferenceStore();
		setPreferenceStore(preferenceStore);
	}

}

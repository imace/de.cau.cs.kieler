package edu.unikiel.rtsys.kieler.kev.extension.elevator;

import org.eclipse.jface.preference.ComboFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.IPreferenceStore;
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

	@Override
	protected void createFieldEditors() {
		String[][] namesAndIds = { {"name1", "id1"} , {"name2", "id2"} };
		this.addField(new ComboFieldEditor("ComboExampleEditor","Combo Example", namesAndIds, getFieldEditorParent()));
	}

	@Override
	public void init(IWorkbench workbench) {
		// set the preference store
		IPreferenceStore preferenceStore = Activator.getDefault().getPreferenceStore();
		setPreferenceStore(preferenceStore);
	}

}

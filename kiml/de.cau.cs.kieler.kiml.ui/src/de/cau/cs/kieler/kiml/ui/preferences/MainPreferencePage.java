/*******************************************************************************
 * Copyright (c) 2008 Real-Time and Embedded Systems group
 *
 * INSERT LICENCE HERE
 *
 *
 * Author: Hauke Fuhrmann, haf@informatik.uni-kiel.de 
 *
 *******************************************************************************/
package de.cau.cs.kieler.kiml.ui.preferences;

import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import de.cau.cs.kieler.kiml.ui.KimlUiPlugin;


/**
 * This is a simple example preferences page. It extends the FieldEditorPreferencePage,
 * which provides very easy setup of standard values (boolean, String, Combos, Lists, 
 * Paths, Colors, etc.)
 * @author Hauke Fuhrmann, haf
 *
 */

public class MainPreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage{

	public static final String PREF_TEST = "ui.test";
	
	@Override
	protected void createFieldEditors() {
		this.setMessage("KIML: KIELER Infrastructure for Meta Layout");
		this.addField(new StringFieldEditor(PREF_TEST, "Test pref",StringFieldEditor.UNLIMITED,StringFieldEditor.VALIDATE_ON_KEY_STROKE, getFieldEditorParent()));
//		this.addField(new IntegerFieldEditor(PORT_EDITOR, "Port Number", getFieldEditorParent()));
	}

	public void init(IWorkbench workbench) {
		// set the preference store
		IPreferenceStore preferenceStore = KimlUiPlugin.getDefault().getPreferenceStore();
		setPreferenceStore(preferenceStore);
	}

}

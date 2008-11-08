package edu.unikiel.rtsys.kieler.kivik.preferences;

import org.eclipse.jface.preference.*;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Group;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.dialogs.PreferenceLinkArea;
import org.eclipse.ui.preferences.IWorkbenchPreferenceContainer;

import edu.unikiel.rtsys.kieler.kivik.Activator;
import edu.unikiel.rtsys.kieler.kivik.KivikUIMessages;

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

public class KivikPreferencePage extends FieldEditorPreferencePage implements
		IWorkbenchPreferencePage {

	public KivikPreferencePage() {
		super(GRID);
		setPreferenceStore(Activator.getDefault().getPreferenceStore());
		setDescription(KivikUIMessages.getString("KivikPreferencePage.setKivikPreferencesHere")); //$NON-NLS-1$
	}

	/**
	 * Creates the field editors. Field editors are abstractions of the common
	 * GUI blocks needed to manipulate various types of preferences. Each field
	 * editor knows how to save and restore itself.
	 */
	public void createFieldEditors() {
		// Link to the content types page
		final PreferenceLinkArea link = new PreferenceLinkArea(getFieldEditorParent(), SWT.NONE,
				"org.eclipse.ui.preferencePages.ContentTypes", //$NON-NLS-1$
				"See <a>{0}</a> to define model types", //$NON-NLS-1$
				(IWorkbenchPreferenceContainer)getContainer(), null);
		// define gl as GridLayout globally
		GridLayout gl = null;

		// options group
		Group options = new Group(this.getFieldEditorParent(), SWT.NONE);
		options.setText(KivikUIMessages.getString("KivikPreferencePage.options")); //$NON-NLS-1$

		StringFieldEditor sfe = new StringFieldEditor(
				PreferenceConstants.P_STRING,
				KivikUIMessages.getString("KivikPreferencePage.paddingX"), options); //$NON-NLS-1$
		
		options.setLayoutData(new GridData(GridData.FILL, GridData.FILL, true,
				false, 2, 1));
		gl = new GridLayout(2, true);
		gl.marginWidth = 15;
		gl.marginHeight = 10;
		options.setLayout(gl);

				// now add all the stuff
		addField(sfe);

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
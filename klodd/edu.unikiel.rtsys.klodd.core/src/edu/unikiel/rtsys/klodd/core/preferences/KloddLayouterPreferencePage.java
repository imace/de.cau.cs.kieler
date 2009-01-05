package edu.unikiel.rtsys.klodd.core.preferences;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Group;
import org.eclipse.ui.IWorkbenchPreferencePage;

import edu.unikiel.rtsys.kieler.core.util.FloatFieldEditor;
import edu.unikiel.rtsys.kieler.kiml.ui.AbstractKimlLayoutProviderPreferencePage;
import edu.unikiel.rtsys.klodd.core.KloddCorePlugin;
import edu.unikiel.rtsys.klodd.core.Messages;

/**
 * Preference page for all KLoDD layout algorithms.
 * 
 * @author msp
 */
public class KloddLayouterPreferencePage extends
		AbstractKimlLayoutProviderPreferencePage implements
		IWorkbenchPreferencePage {
	
	/**
	 * Creates the KLoDD layouter preference page.
	 */
	public KloddLayouterPreferencePage() {
		super(KloddCorePlugin.COLLECTION_NAME, GRID);
		setPreferenceStore(KloddCorePlugin.getDefault().getPreferenceStore());
		setDescription(Messages.getString("klodd.core.0")); //$NON-NLS-1$
	}
	
	/*
	 * (non-Javadoc)
	 * @see edu.unikiel.rtsys.kieler.kiml.ui.AbstractKimlLayoutProviderPreferencePage#createFieldEditors()
	 */
	public void createFieldEditors() {
		super.createFieldEditors();

		// options group for hierarchical layouter
		Group hieraGroup = new Group(this.getFieldEditorParent(), SWT.NONE);
		hieraGroup.setText(Messages.getString("klodd.core.1")); //$NON-NLS-1$

		FloatFieldEditor minDistEditor = new FloatFieldEditor(
				KloddLayoutPreferences.MIN_DIST,
				Messages.getString("klodd.core.2"), hieraGroup); //$NON-NLS-1$
		hieraGroup.setLayoutData(new GridData(GridData.FILL, GridData.FILL, true,
				false, 2, 1));
		GridLayout gl = new GridLayout(2, true);
		gl.marginWidth = 15;
		gl.marginHeight = 10;
		hieraGroup.setLayout(gl);

		// add all field editors
		addField(minDistEditor);
	}

}

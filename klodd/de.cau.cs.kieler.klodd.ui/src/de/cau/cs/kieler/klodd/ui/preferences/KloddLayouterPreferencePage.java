package de.cau.cs.kieler.klodd.ui.preferences;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Group;
import org.eclipse.ui.IWorkbenchPreferencePage;

import de.cau.cs.kieler.core.ui.util.FloatFieldEditor;
import de.cau.cs.kieler.kiml.ui.AbstractKimlLayoutProviderPreferencePage;
import de.cau.cs.kieler.kiml.ui.KimlUiPlugin;
import de.cau.cs.kieler.klodd.hierarchical.HierarchicalDataflowLayoutProvider;
import de.cau.cs.kieler.klodd.orthogonal.OrthogonalDataflowLayoutProvider;
import de.cau.cs.kieler.klodd.ui.KloddUIPlugin;
import de.cau.cs.kieler.klodd.ui.Messages;


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
		super(KloddUIPlugin.COLLECTION_NAME, GRID);
		setPreferenceStore(KimlUiPlugin.getDefault().getPreferenceStore());
		setDescription(Messages.getString("klodd.ui.0")); //$NON-NLS-1$
	}
	
	/*
	 * (non-Javadoc)
	 * @see de.cau.cs.kieler.kiml.ui.AbstractKimlLayoutProviderPreferencePage#createFieldEditors()
	 */
	public void createFieldEditors() {
		super.createFieldEditors();

		// options group for hierarchical layouter
		Group hieraGroup = new Group(this.getFieldEditorParent(), SWT.NONE);
		hieraGroup.setText(Messages.getString("klodd.ui.1")); //$NON-NLS-1$

		FloatFieldEditor minDistEditor = new FloatFieldEditor(
				HierarchicalDataflowLayoutProvider.PREF_MIN_DIST,
				Messages.getString("klodd.ui.2"), hieraGroup); //$NON-NLS-1$
		addField(minDistEditor);
		
		hieraGroup.setLayoutData(new GridData(GridData.FILL, GridData.FILL, true,
				false, 2, 1));
		GridLayout gridLayout = new GridLayout(2, true);
		gridLayout.marginWidth = 15;
		gridLayout.marginHeight = 10;
		hieraGroup.setLayout(gridLayout);
		
		// options group for orthogonal layouter
		Group orthoGroup = new Group(this.getFieldEditorParent(), SWT.NONE);
		orthoGroup.setText(Messages.getString("klodd.ui.3")); //$NON-NLS-1$

		minDistEditor = new FloatFieldEditor(
				OrthogonalDataflowLayoutProvider.PREF_MIN_DIST,
				Messages.getString("klodd.ui.4"), orthoGroup); //$NON-NLS-1$
		addField(minDistEditor);
		
		orthoGroup.setLayoutData(new GridData(GridData.FILL, GridData.FILL, true,
				false, 2, 1));
		gridLayout = new GridLayout(2, true);
		gridLayout.marginWidth = 15;
		gridLayout.marginHeight = 10;
		orthoGroup.setLayout(gridLayout);
	}

}

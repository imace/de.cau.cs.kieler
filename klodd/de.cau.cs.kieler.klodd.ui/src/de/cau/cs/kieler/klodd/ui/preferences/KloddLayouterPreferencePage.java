/******************************************************************************
 * KIELER - Kiel Integrated Environment for Layout for the Eclipse RCP
 *
 * http://www.informatik.uni-kiel.de/rtsys/kieler/
 * 
 * Copyright 2009 by
 * + Christian-Albrechts-University of Kiel
 *   + Department of Computer Science
 *     + Real-Time and Embedded Systems Group
 * 
 * This code is provided under the terms of the Eclipse Public License (EPL).
 * See the file epl-v10.html for the license text.
 */
package de.cau.cs.kieler.klodd.ui.preferences;

import org.eclipse.jface.preference.FieldEditor;
import org.eclipse.jface.preference.IntegerFieldEditor;
import org.eclipse.jface.preference.RadioGroupFieldEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Group;
import org.eclipse.ui.IWorkbenchPreferencePage;

import de.cau.cs.kieler.kiml.ui.AbstractKimlLayoutProviderPreferencePage;
import de.cau.cs.kieler.klodd.hierarchical.HierarchicalDataflowLayoutProvider;
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
		setPreferenceStore(KloddUIPlugin.getDefault().getPreferenceStore());
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

		FieldEditor cycleRemEditor = new RadioGroupFieldEditor(
				HierarchicalDataflowLayoutProvider.PREF_CYCLE_REM,
				Messages.getString("klodd.ui.5"), 1, new String[][] { //$NON-NLS-1$
					{ Messages.getString("klodd.ui.6"), //$NON-NLS-1$
						HierarchicalDataflowLayoutProvider.VAL_DFS_CYCLE_REM},
					{ Messages.getString("klodd.ui.7"), //$NON-NLS-1$
						HierarchicalDataflowLayoutProvider.VAL_GREEDY_CYCLE_REM}
				}, hieraGroup, false);
		addField(cycleRemEditor);
		
		FieldEditor layerAssEditor = new RadioGroupFieldEditor(
				HierarchicalDataflowLayoutProvider.PREF_LAYER_ASS,
				Messages.getString("klodd.ui.8"), 1, new String[][] { //$NON-NLS-1$
					{ Messages.getString("klodd.ui.9"), //$NON-NLS-1$
						HierarchicalDataflowLayoutProvider.VAL_LONGP_LAYER_ASS},
					{ Messages.getString("klodd.ui.10"), //$NON-NLS-1$
						HierarchicalDataflowLayoutProvider.VAL_BAL_LAYER_ASS}
				}, hieraGroup, false);
		addField(layerAssEditor);
		
		IntegerFieldEditor crossRedPassesEditor = new IntegerFieldEditor(
		        HierarchicalDataflowLayoutProvider.PREF_CROSSRED_PASSES,
		        Messages.getString("klodd.ui.11"), hieraGroup, 3);
		crossRedPassesEditor.setValidRange(1, 999);
		addField(crossRedPassesEditor);
		
		hieraGroup.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, true,
				false, 2, 1));
		GridLayout gridLayout = new GridLayout(2, true);
		gridLayout.marginWidth = 15;
		gridLayout.marginHeight = 10;
		hieraGroup.setLayout(gridLayout);
		
		// options group for orthogonal layouter
		Group orthoGroup = new Group(this.getFieldEditorParent(), SWT.NONE);
		orthoGroup.setText(Messages.getString("klodd.ui.3")); //$NON-NLS-1$

		orthoGroup.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, true,
				false, 2, 1));
		gridLayout = new GridLayout(2, true);
		gridLayout.marginWidth = 15;
		gridLayout.marginHeight = 10;
		orthoGroup.setLayout(gridLayout);
	}

}

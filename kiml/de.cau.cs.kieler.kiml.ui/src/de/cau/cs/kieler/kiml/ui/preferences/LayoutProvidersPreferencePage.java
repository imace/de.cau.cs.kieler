/******************************************************************************
 * KIELER - Kiel Integrated Environment for Layout for the Eclipse RCP
 *
 * http://www.informatik.uni-kiel.de/rtsys/kieler/
 * 
 * Copyright 2008 by
 * + Christian-Albrechts-University of Kiel
 *   + Department of Computer Science
 *     + Real-Time and Embedded Systems Group
 * 
 * This code is provided under the terms of the Eclipse Public License (EPL).
 * See the file epl-v10.html for the license text.
 */
package de.cau.cs.kieler.kiml.ui.preferences;

import java.util.ArrayList;

import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.RadioGroupFieldEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Group;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import de.cau.cs.kieler.kiml.layout.services.KimlLayoutServices;
import de.cau.cs.kieler.kiml.layout.util.KimlLayoutPreferenceConstants;
import de.cau.cs.kieler.kiml.ui.KimlUiPlugin;


/**
 * The LayouterProviders preference page. This places a page into the KIML
 * preferences with options for all LayouterProviders. Specific LayoutProviders
 * should place their own preference page below this one. Settings for this can
 * be made in the respective plugin.xml file.
 * 
 * @author <a href="mailto:ars@informatik.uni-kiel.de">Arne Schipper</a>
 * @see de.cau.cs.kieler.kiml.ui.diagramlayouter.LayoutProviders
 *      LayoutProviders
 * @see de.cau.cs.kieler.kiml.layout.services.AbstractLayoutProvider
 *      AbstractLayoutProvider
 */
public class LayoutProvidersPreferencePage extends FieldEditorPreferencePage
		implements IWorkbenchPreferencePage {

	/**
	 * Creates a new preference page for the layout providers.
	 */
	public LayoutProvidersPreferencePage() {
		super(GRID);
		setPreferenceStore(KimlUiPlugin.getDefault().getPreferenceStore());
		getPreferenceStore().addPropertyChangeListener(this);
		setDescription("Set here the general layout options that do not apply to a specific layout provider");
	}

	/**
	 * Creates the field editors. Field editors are abstractions of the common
	 * GUI blocks needed to manipulate various types of preferences. Each field
	 * editor knows how to save and restore itself.
	 */
	public void createFieldEditors() {
		/* define gl as GridLayout globally */
		GridLayout gl = null;

		/* default layouter group */
		Group defaultLayouter = new Group(this.getFieldEditorParent(), SWT.NONE);
		defaultLayouter.setText("Default Layout Provider");
		String[][] options = getAvailableLayouterNames();
		RadioGroupFieldEditor radioGroupDefaultLayouter = new RadioGroupFieldEditor(
				KimlLayoutPreferenceConstants.PREF_LAYOUTPROVIDERS_DEFAULT_LAYOUT_PROVIDER,
				"Choose the default layout provider:", 2, options,
				defaultLayouter);

		addField(radioGroupDefaultLayouter);
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

	/*
	 * returns a string matrix as needed from a RadioGroupFieldEditor with the
	 * currently enabled layout provider
	 */
	private String[][] getAvailableLayouterNames() {
		ArrayList<String> names = KimlLayoutServices.getInstance()
				.getEnabledLayouterNames();
		String[][] options = new String[names.size()][2];

		for (int i = 0; i < options.length; i++) {
			options[i][0] = names.get(i);
			options[i][1] = names.get(i);
		}
		return options;
	}
}

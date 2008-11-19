/*******************************************************************************
 * Copyright (c) 2008 Real-Time and Embedded Systems group
 *
 * INSERT LICENCE HERE
 *
 *
 * Author: Arne Schipper, ars@informatik.uni-kiel.de 
 *
 *******************************************************************************/
package edu.unikiel.rtsys.kieler.kiml.layouter.graphviz.preferences;

import kiel.layouter.graphviz.GraphvizLayoutProviderNames;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.DirectoryFieldEditor;
import org.eclipse.jface.preference.IntegerFieldEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import edu.unikiel.rtsys.kieler.kiml.layouter.graphviz.Activator;
import edu.unikiel.rtsys.kieler.kiml.ui.AbstractKimlLayoutProviderPreferencePage;

/**
 * The GraphViz preference page. This page extends the
 * {@link edu.unikiel.rtsys.kieler.kiml.ui.AbstractKimlLayoutProviderPreferencePage}
 * to draw the group for enabling and disabling all the available GraphViz
 * layouters.
 * 
 * @author <a href="mailto:ars@informatik.uni-kiel.de">Arne Schipper</a>
 */
public class GraphvizPreferencePage extends
		AbstractKimlLayoutProviderPreferencePage implements
		IWorkbenchPreferencePage {

	/**
	 * The constructor for the preference page, uses
	 * {@link edu.unikiel.rtsys.kieler.kiml.ui.AbstractKimlLayoutProviderPreferencePage
	 * }
	 * to generate the fields for enabling and disabling the layouters of the
	 * GraphViz suite.
	 */
	public GraphvizPreferencePage() {
		super(GraphvizLayoutProviderNames.LAYOUT_PROVIDER_COLLECTION_ID, GRID);
		setPreferenceStore(Activator.getDefault().getPreferenceStore());
		setDescription("Set the options for the GraphViz layout engine:");
	}

	/**
	 * Creates the field editors for the GraphViz options
	 */
	public void createFieldEditors() {
		super.createFieldEditors();

		/* define gl as GridLayout globally once and for all */
		GridLayout gl = null;

		/* padding group */
		Group padding = new Group(this.getFieldEditorParent(), SWT.NONE);
		padding.setText("Padding:");

		IntegerFieldEditor padx = new IntegerFieldEditor(
				PreferenceConstants.PREF_GRAPHVIZ_PADDING_X, "Padding X:",
				padding, 2);

		IntegerFieldEditor pady = new IntegerFieldEditor(
				PreferenceConstants.PREF_GRAPHVIZ_PADDING_Y, "Padding Y:",
				padding, 2);
		padding.setLayoutData(new GridData(GridData.FILL, GridData.FILL, true,
				false, 3, 1));
		gl = new GridLayout(3, true);
		gl.marginWidth = 15;
		gl.marginHeight = 10;
		padding.setLayout(gl);

		/* debug group */
		Group debug = new Group(this.getFieldEditorParent(), SWT.NONE);
		debug.setText("Debug:");

		BooleanFieldEditor enableDebug = new BooleanFieldEditor(
				PreferenceConstants.PREF_GRAPHVIZ_ENABLE_DEBUG_OUTPUT,
				"Enable debug output (*.dot)", debug);
		DirectoryFieldEditor debugDir = new DirectoryFieldEditor(
				PreferenceConstants.PREF_GRAPHVIZ_DEBUG_DIR,
				"Debug directory:", debug);
		Label description = new Label(debug, SWT.WRAP);
		description
				.setText("If a directory is chosen, debug output of GraphViz (the *.dot files) go there. Otherwise the user home directory is chosen.");
		description.setLayoutData(new GridData(GridData.FILL, GridData.FILL,
				true, true, 2, 1));
		debug.setLayoutData(new GridData(GridData.FILL, GridData.FILL, true,
				false, 3, 2));
		gl = new GridLayout(3, false);
		gl.marginWidth = 15;
		gl.marginHeight = 10;
		debug.setLayout(gl);

		/* now add all the stuff */
		addField(padx);
		addField(pady);

		addField(enableDebug);
		addField(debugDir);
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
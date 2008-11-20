/*******************************************************************************
 * Copyright (c) 2008 Real-Time and Embedded Systems group
 *
 * INSERT LICENCE HERE
 *
 *
 * Author: Arne Schipper, ars@informatik.uni-kiel.de 
 *
 *******************************************************************************/
package edu.unikiel.rtsys.kieler.ssm.gmf.diagram.layouter.preferences;

/**
 * The SSM Diagram Layouter preference page. This places a page into the KIML -> Diagram Layouters
 * preferences with options for all the SSM Diagram Layouter.
 * 
 * @author <a href="mailto:ars@informatik.uni-kiel.de">Arne Schipper</a>
 */
import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.IntegerFieldEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import edu.unikiel.rtsys.kieler.kiml.layout.util.KimlLayoutPreferenceConstants;
import edu.unikiel.rtsys.kieler.ssm.gmf.diagram.layouter.KimlSSMDiagramLayouterPlugin;

public class PreferencePage extends FieldEditorPreferencePage implements
		IWorkbenchPreferencePage {

	/**
	 * Creates a new preference page for the layout providers.
	 */
	public PreferencePage() {
		super(GRID);
		setPreferenceStore(KimlSSMDiagramLayouterPlugin.getDefault()
				.getPreferenceStore());
		// setDescription("Options for the SSM Diagram Layouter:");
	}

	/**
	 * Creates the field editors. Field editors are abstractions of the common
	 * GUI blocks needed to manipulate various types of preferences. Each field
	 * editor knows how to save and restore itself.
	 */
	protected void createFieldEditors() {
		/* define gl as GridLayout globally */
		GridLayout gl = null;

		/* options group */
		Group options = new Group(this.getFieldEditorParent(), SWT.NONE);
		options.setText("General Options:");
		addField(new BooleanFieldEditor(
				KimlLayoutPreferenceConstants.PREF_GROUP_EVERY_SINGLE_ELEMENT,
				"Enable grouping for every single element", options));
		Label description = new Label(options, SWT.WRAP);
		description
				.setText("If checked, then it is possible to apply grouping and layout information to every single element. Note that this is then the only way to do this. Select several elemets and set grouping/layout information to them.");
		options.setLayoutData(new GridData(GridData.FILL, GridData.FILL, true,
				false, 2, 1));
		gl = new GridLayout(2, true);
		gl.marginWidth = 15;
		gl.marginHeight = 10;
		options.setLayout(gl);

		/* offsets group */
		Group offsets = new Group(this.getFieldEditorParent(), SWT.NONE);
		offsets.setText("Offset:");

		IntegerFieldEditor top = new IntegerFieldEditor(
				PreferenceConstants.PREF_OFFSET_TOP, "Diagram offset top:",
				offsets, 3);
		IntegerFieldEditor left = new IntegerFieldEditor(
				PreferenceConstants.PREF_OFFSET_LEFT, "Diagram offset left:",
				offsets, 3);
		offsets.setLayoutData(new GridData(GridData.FILL, GridData.FILL, true,
				false, 2, 1));
		gl = new GridLayout(2, true);
		gl.marginWidth = 15;
		gl.marginHeight = 10;
		offsets.setLayout(gl);

		/* now add all the stuff */
		addField(top);
		addField(left);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.IWorkbenchPreferencePage#init(org.eclipse.ui.IWorkbench)
	 */
	public void init(IWorkbench workbench) {
		;
	}

}

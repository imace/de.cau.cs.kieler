/*******************************************************************************
 * Copyright (c) 2008 Real-Time and Embedded Systems group
 *
 * INSERT LICENCE HERE
 *
 *
 * Author: Arne Schipper, ars@informatik.uni-kiel.de 
 *
 *******************************************************************************/
package ssm.diagram.custom.preferences;

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

import ssm.diagram.custom.SSMDiagramCustomPlugin;


public class PreferencePage extends FieldEditorPreferencePage implements
		IWorkbenchPreferencePage {

	/**
	 * Creates a new preference page for the layout providers.
	 */
	public PreferencePage() {
		super(GRID);
		setPreferenceStore(SSMDiagramCustomPlugin.getDefault()
				.getPreferenceStore());
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

		// addField(new BooleanFieldEditor(
		// KimlLayoutPreferenceConstants.PREF_GROUP_EVERY_SINGLE_ELEMENT,
		// "Enable grouping for every single element", options));
		// Label descriptionGroupSingle = new Label(options, SWT.WRAP);
		// descriptionGroupSingle
		// .setText("If checked, then it is possible to apply grouping and layout information to every single element. Note that this is then the only way to do this. Select several elemets and set grouping/layout information to them.");

		addField(new BooleanFieldEditor(
				PreferenceConstants.PREF_ALTERNATING_HV_LAYOUT,
				"Alternating HV layout", options));
		Label descriptionAHV = new Label(options, SWT.WRAP);
		descriptionAHV
				.setText("If checked, then the alternating HV layout is enabled. No layout of single regions is possible then; it is always the entire diagram rendered.");

		addField(new BooleanFieldEditor(
				PreferenceConstants.PREF_AUTOSIZE_EMPTY_ELEMENTS,
				"Autosize empty elements", options));
		Label descriptionAEE = new Label(options, SWT.WRAP);
		descriptionAEE
				.setText("If checked, all SimpleStates and empty CompositeStates will be resized to a default value.");

		options.setLayoutData(new GridData(GridData.FILL, GridData.FILL, true,
				false, 2, 1));
		gl = new GridLayout(2, true);
		gl.marginWidth = 15;
		gl.marginHeight = 10;
		options.setLayout(gl);

		/* collapsed sizes group */
		Group collapsedSizes = new Group(this.getFieldEditorParent(), SWT.NONE);
		collapsedSizes.setText("Collapsed sizes:");

		IntegerFieldEditor width = new IntegerFieldEditor(
				PreferenceConstants.PREF_WIDTH_COLLAPSED,
				"Collapsed element's width:", collapsedSizes, 3);
		width.setValidRange(20, 100);
		IntegerFieldEditor height = new IntegerFieldEditor(
				PreferenceConstants.PREF_HEIGHT_COLLAPSED,
				"Collapsed element's heigt:", collapsedSizes, 3);
		height.setValidRange(20, 100);

		collapsedSizes.setLayoutData(new GridData(GridData.FILL, GridData.FILL,
				true, false, 2, 1));
		gl = new GridLayout(2, true);
		gl.marginWidth = 15;
		gl.marginHeight = 10;
		collapsedSizes.setLayout(gl);

		/* now add all the stuff */
		addField(width);
		addField(height);
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

package edu.unikiel.rtsys.kieler.ssm.gmf.diagram.layouter.preferences;

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

import edu.unikiel.rtsys.kieler.kiml.layout.util.KimlLayoutConstants;
import edu.unikiel.rtsys.kieler.ssm.gmf.diagram.layouter.KimlSSMDiagramLayouterPlugin;

public class PreferencePage extends FieldEditorPreferencePage implements
		IWorkbenchPreferencePage {

	public PreferencePage() {
		super(GRID);
		setPreferenceStore(KimlSSMDiagramLayouterPlugin.getDefault().getPreferenceStore());
		//setDescription("Options for the SSM Diagram Layouter:");
	}
	
	@Override
	protected void createFieldEditors() {
		// define gl as GridLayout globally
		GridLayout gl = null;
		Group options = new Group(this.getFieldEditorParent(), SWT.NONE);
		options.setText("General Options:");
		addField(new BooleanFieldEditor(
				KimlLayoutConstants.SETTINGS_GROUP_EVERY_SINGLE_ELEMENT,
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
		
		// offsets group
		Group offsets = new Group(this.getFieldEditorParent(), SWT.NONE);
		offsets.setText("Offset:");

		IntegerFieldEditor top = new IntegerFieldEditor(
				PreferenceConstants.PREF_OFFSET_TOP,
				"Diagram offset top:", offsets, 3);
		IntegerFieldEditor left = new IntegerFieldEditor(
				PreferenceConstants.PREF_OFFSET_LEFT,
				"Diagram offset left:", offsets, 3);
		offsets.setLayoutData(new GridData(GridData.FILL, GridData.FILL, true,
				false, 2, 1));
		gl = new GridLayout(2, true);
		gl.marginWidth = 15;
		gl.marginHeight = 10;
		offsets.setLayout(gl);

		// now add all the stuff
		addField(top);
		addField(left);
	}

	@Override
	public void init(IWorkbench workbench) {
		// TODO Auto-generated method stub

	}

}

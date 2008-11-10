package edu.unikiel.rtsys.kieler.ssm.gmf.diagram.layouter.preferences;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutPlugin;
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
		addField(new BooleanFieldEditor(
				KimlLayoutConstants.SETTINGS_GROUP_EVERY_SINGLE_ELEMENT,
				"Enable grouping for every single element", getFieldEditorParent()));
		Label description = new Label(getFieldEditorParent(), SWT.WRAP);
		description
				.setText("If checked, then it is possible to apply grouping and layout information to every single element. Note that this is then the only way to do this. Select several elemets and set grouping/layout information to them.");

	}

	@Override
	public void init(IWorkbench workbench) {
		// TODO Auto-generated method stub

	}

}

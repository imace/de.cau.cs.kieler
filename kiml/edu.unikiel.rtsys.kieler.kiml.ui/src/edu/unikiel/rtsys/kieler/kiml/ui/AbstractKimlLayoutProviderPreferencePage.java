package edu.unikiel.rtsys.kieler.kiml.ui;

import java.util.ArrayList;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.FieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;

import edu.unikiel.rtsys.kieler.kiml.layout.services.KimlAbstractLayoutProvider;
import edu.unikiel.rtsys.kieler.kiml.layout.services.LayoutProviders;

public abstract class AbstractKimlLayoutProviderPreferencePage extends
		FieldEditorPreferencePage {

	private String LAYOUT_PROVIDER_COLLECTION_ID = null;

	public AbstractKimlLayoutProviderPreferencePage(String collectionID,
			int grid) {
		super(grid);
		LAYOUT_PROVIDER_COLLECTION_ID = collectionID;
	}

	protected void createFieldEditors() {
		ArrayList<FieldEditor> editorsToAdd = createLayouterTable(this
				.getFieldEditorParent(), LayoutProviders.getInstance()
				.getLayoutProvidersOfCollection(LAYOUT_PROVIDER_COLLECTION_ID));
		for (FieldEditor editorToAdd : editorsToAdd) {
			addField(editorToAdd);
		}
	}

	protected ArrayList<FieldEditor> createLayouterTable(Composite parent,
			ArrayList<KimlAbstractLayoutProvider> layoutProviders) {
		ArrayList<FieldEditor> createdFieldEditors = new ArrayList<FieldEditor>();

		Group availableLayouters = new Group(parent, SWT.NONE);
		availableLayouters.setText("Available Layouters");

		if (layoutProviders.size() == 0) {
			Label noLayouters = new Label(availableLayouters, SWT.WRAP);
			noLayouters.setText("No layouters found!");
		} else {
			Label description = new Label(availableLayouters, SWT.WRAP);
			description.setText("Enable the layouter you want to use:");
			description.setLayoutData(new GridData(GridData.FILL,
					GridData.FILL, true, true, 2, 1));
			for (KimlAbstractLayoutProvider layoutProvider : layoutProviders) {
				String label = layoutProvider.getLayouterInfo()
						.getLayouterName()
						+ " ("
						+ layoutProvider.getLayouterInfo().getLayoutType()
						+ ")";
				BooleanFieldEditor enable = new BooleanFieldEditor(
						layoutProvider.getLayouterInfo().getLayouterName(),
						label, availableLayouters);
				createdFieldEditors.add(enable);
			}
		}
		availableLayouters.setLayoutData(new GridData(GridData.FILL,
				GridData.FILL, true, false, 2, 1));
		GridLayout gl = new GridLayout();
		gl.marginWidth = 15;
		gl.marginHeight = 10;
		availableLayouters.setLayout(gl);

		return createdFieldEditors;
	}

	@Override
	public boolean performOk() {
		boolean retVal = super.performOk();

		ArrayList<KimlAbstractLayoutProvider> layouters = LayoutProviders
				.getInstance().getLayoutProvidersOfCollection(
						LAYOUT_PROVIDER_COLLECTION_ID);

		for (KimlAbstractLayoutProvider layouter : layouters) {
			layouter.setEnabled(getPreferenceStore().getBoolean(
					layouter.getLayouterInfo().getLayouterName()));
		}
		return retVal;
	}
}

/*******************************************************************************
 * Copyright (c) 2008 Real-Time and Embedded Systems group
 *
 * INSERT LICENCE HERE
 *
 *
 * Author: Arne Schipper, ars@informatik.uni-kiel.de 
 *
 *******************************************************************************/
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

/**
 * Provides means to build up easily a preference page for each layout provider
 * collection someone wants to contribute. Adds checkboxes for every single
 * layout provider of a layout provider collection to enable and disable them.
 * The respective status is then passed to the LayoutProvider singleton, which
 * makes it then available to the whole system.
 * 
 * @author <a href="mailto:ars@informatik.uni-kiel.de">Arne Schipper</a>
 * @see LayoutProviders
 */
public abstract class AbstractKimlLayoutProviderPreferencePage extends
		FieldEditorPreferencePage {

	private String LAYOUT_PROVIDER_COLLECTION_ID = null;

	/**
	 * Constructor which should be called with the Collection ID to be able to
	 * fetch the correct layout providers later on
	 */
	public AbstractKimlLayoutProviderPreferencePage(String collectionID,
			int grid) {
		super(grid);
		LAYOUT_PROVIDER_COLLECTION_ID = collectionID;
	}

	/**
	 * Creates add adds the status FieldEditor for every layout provider this
	 * layout provider collection provides. The concrete layout providers of
	 * this collection are read out from the {@link LayoutProviders} singleton.
	 * Implementing classes should call this method first via
	 * <code>super.createFiedEditors</code> in their own implementation of
	 * <code>createFiedEditors</code>
	 * 
	 * @see org.eclipse.jface.preference.FieldEditorPreferencePage#createFieldEditors
	 *      ()
	 * @see LayoutProviders
	 */
	protected void createFieldEditors() {
		ArrayList<FieldEditor> editorsToAdd = createLayouterTable(this
				.getFieldEditorParent(), LayoutProviders.getInstance()
				.getLayoutProvidersOfCollection(LAYOUT_PROVIDER_COLLECTION_ID));
		for (FieldEditor editorToAdd : editorsToAdd) {
			addField(editorToAdd);
		}
	}

	/**
	 * Creates the checkboxes for every layouter this layout provider passed.
	 * 
	 * @param parent
	 *            The parent composite where to add the controls.
	 * @param layoutProviders
	 *            A list of layout providers
	 * @return A list of field editors which must be added to a preference page
	 *         afterwards
	 */
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

	/**
	 * Override the <code>performOk</code> method of the superclass. The
	 * <code>performOk</code> method is called when clicking on <i>Apply</i>
	 * or<i>OK</i> in the preference page window. This function intercepts the
	 * call to do some additional processing; that is to inform the
	 * {@link LayoutProviders} singleton about the changes of the respective
	 * layout provider status.
	 * 
	 * @see org.eclipse.jface.preference.FieldEditorPreferencePage#performOk()
	 */
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

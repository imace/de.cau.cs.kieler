package de.cau.cs.kieler.kiml.layouter.zest.preferences;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Group;
import org.eclipse.ui.IWorkbenchPreferencePage;

import de.cau.cs.kieler.core.preferences.FloatFieldEditor;
import de.cau.cs.kieler.kiml.layouter.zest.Activator;
import de.cau.cs.kieler.kiml.layouter.zest.ZestAlgorithmWrapper;
import de.cau.cs.kieler.kiml.ui.AbstractKimlLayoutProviderPreferencePage;


/**
 * Preference page for the Zest layouters plugin.
 * 
 * @author msp
 */
public class ZestLayouterPreferencePage extends AbstractKimlLayoutProviderPreferencePage
		implements IWorkbenchPreferencePage {

	/** scale factor to use for the size of each parent node */
	public static final String SCALE_BASE = "zest.scale_base";

	/**
	 * Creates the zest layouter preference page.
	 */
	public ZestLayouterPreferencePage() {
		super(ZestAlgorithmWrapper.COLLECTION_NAME, GRID);
		setPreferenceStore(Activator.getDefault().getPreferenceStore());
		setDescription("Set the options for the Zest layout engine:");
	}
	
	/*
	 * (non-Javadoc)
	 * @see de.cau.cs.kieler.kiml.ui.AbstractKimlLayoutProviderPreferencePage#createFieldEditors()
	 */
	public void createFieldEditors() {
		super.createFieldEditors();

		// options group
		Group optionsGroup = new Group(this.getFieldEditorParent(), SWT.NONE);
		optionsGroup.setText("General Options:");

		FloatFieldEditor scaleBaseEditor = new FloatFieldEditor(
				SCALE_BASE,	"&Scale base for parent nodes:", optionsGroup);
		optionsGroup.setLayoutData(new GridData(GridData.FILL, GridData.FILL, true,
				false, 2, 1));
		GridLayout gl = new GridLayout(2, true);
		gl.marginWidth = 15;
		gl.marginHeight = 10;
		optionsGroup.setLayout(gl);

		// add all field editors
		addField(scaleBaseEditor);
	}

}

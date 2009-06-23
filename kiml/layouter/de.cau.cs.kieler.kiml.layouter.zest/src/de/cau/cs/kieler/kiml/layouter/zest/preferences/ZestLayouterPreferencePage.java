package de.cau.cs.kieler.kiml.layouter.zest.preferences;

import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Group;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import de.cau.cs.kieler.core.ui.util.FloatFieldEditor;
import de.cau.cs.kieler.kiml.layouter.zest.Activator;


/**
 * Preference page for the Zest layouters plugin.
 * 
 * @author msp
 */
public class ZestLayouterPreferencePage extends FieldEditorPreferencePage
        implements IWorkbenchPreferencePage {

	/** scale factor to use for the size of each parent node */
	public static final String PREF_SCALE_BASE = "zest.scale_base";

	/*
	 * (non-Javadoc)
	 * @see de.cau.cs.kieler.kiml.ui.AbstractMultiLayouterPreferencePage#createFieldEditors()
	 */
	public void createFieldEditors() {
		// options group
		Group optionsGroup = new Group(this.getFieldEditorParent(), SWT.NONE);
		optionsGroup.setText("General Options:");

		FloatFieldEditor scaleBaseEditor = new FloatFieldEditor(
				PREF_SCALE_BASE,	"&Scale base for parent nodes:", optionsGroup);
		optionsGroup.setLayoutData(new GridData(GridData.FILL, GridData.FILL, true,
				false, 2, 1));
		GridLayout gl = new GridLayout(2, true);
		gl.marginWidth = 15;
		gl.marginHeight = 10;
		optionsGroup.setLayout(gl);

		// add all field editors
		addField(scaleBaseEditor);
	}

    /* (non-Javadoc)
     * @see org.eclipse.ui.IWorkbenchPreferencePage#init(org.eclipse.ui.IWorkbench)
     */
    public void init(IWorkbench workbench) {
        setPreferenceStore(Activator.getDefault().getPreferenceStore());
    }

}

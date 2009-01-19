package edu.unikiel.rtsys.layouter.ui;

import kiel.layouter.graphviz.LayouterPlugin;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.swt.SWT;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import edu.unikiel.rtsys.kieler.core.preferences.DoubleFieldEditor;

/**
 * This is a simple example preferences page. It extends the FieldEditorPreferencePage,
 * which provides very easy setup of standard values (boolean, String, Combos, Lists, 
 * Paths, Colors, etc.)
 * @author Hauke Fuhrmann, haf
 *
 */

public class WorkbenchPreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage{

	/** Shall layouter be debugged? Will display debug graphics */
	public static final String PREF_LAYOUTER_DEBUG      = "layouter.layouter.debug";
	/** Shall edges be layouted? If not only nodes get placed */
	public static final String PREF_LAYOUTER_CONNECTION = "layouter.layouter.connection";
	/** Shall connections be debugged? Will display debug graphics for connections */
	public static final String PREF_CONNECTION_DEBUG    = "layouter.connection.debug";
	/** StepSize for spline curve control points. The smaller the more accurate the spline */
	public static final String PREF_CONNECTION_STEPSIZE = "layouter.connection.stepsize";
	
	
	public WorkbenchPreferencePage() {
		super(FieldEditorPreferencePage.GRID); // more appealing layout
	}
	
	@Override
	protected void createFieldEditors() {
		this.setMessage("Layouter");
		this.addField(new BooleanFieldEditor(PREF_LAYOUTER_DEBUG, "Debug Layout",SWT.DEFAULT, getFieldEditorParent()));
		this.addField(new BooleanFieldEditor(PREF_LAYOUTER_CONNECTION, "Layout Connections",SWT.DEFAULT, getFieldEditorParent()));
		DoubleFieldEditor dfe = new DoubleFieldEditor(PREF_CONNECTION_STEPSIZE, "Spline Stepsize", StringFieldEditor.UNLIMITED, StringFieldEditor.VALIDATE_ON_KEY_STROKE,getFieldEditorParent());
		dfe.setValidRange(0, 1);
		this.addField(dfe);
		this.addField(new BooleanFieldEditor(PREF_CONNECTION_DEBUG, "Debug Connection",SWT.DEFAULT, getFieldEditorParent()));
	}
	
	

	@Override
	public void init(IWorkbench workbench) {
		// set the preference store
		IPreferenceStore preferenceStore = LayouterPlugin.getDefault().getPreferenceStore();
		setPreferenceStore(preferenceStore);
	}
	
	/** Setting the default values. Must be called at startup before any value is read.
	 *  (E.g. by the Plugin Activator)
	 */
	static public void setDefaultValues(){
		IPreferenceStore preferenceStore = LayouterPlugin.getDefault().getPreferenceStore();
		preferenceStore.setDefault(PREF_LAYOUTER_DEBUG, true);
		preferenceStore.setDefault(PREF_LAYOUTER_CONNECTION, true);
		preferenceStore.setDefault(PREF_CONNECTION_DEBUG, true);
		preferenceStore.setDefault(PREF_CONNECTION_STEPSIZE, "0.1");
	}

}

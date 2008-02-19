package com.dlsc.batik.preferences;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.IntegerFieldEditor;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import com.dlsc.batik.viewer.BatikUIPlugin;
import com.dlsc.batik.viewer.Messages;

/**
 * This class represents a preference page that
 * is contributed to the Preferences dialog. By 
 * subclassing <samp>FieldEditorPreferencePage</samp>, we
 * can use the field support built into JFace that allows
 * us to create a page that is small and knows how to 
 * save, restore and apply itself.
 * <p>
 * This page is used to modify preferences only. They
 * are stored in the preference store that belongs to
 * the main plug-in class. That way, preferences can
 * be accessed directly via the preference store.
 */
public class SlideshowPreferencePage
	extends FieldEditorPreferencePage
	implements IWorkbenchPreferencePage {
	
	public static final String P_FULL_SCREEN ="fullScreen"; //$NON-NLS-1$
	public static final String P_WINDOW_WIDTH = "windowWidth"; //$NON-NLS-1$
	public static final String P_WINDOW_HEIGHT = "windowHeight"; //$NON-NLS-1$
	public static final String P_FRAME_TIME = "frameTime"; //$NON-NLS-1$
	public static final String P_TRANSITION_TIME = "transitionTime"; //$NON-NLS-1$

	public SlideshowPreferencePage() {
		super(GRID);
		setPreferenceStore(BatikUIPlugin.getDefault().getPreferenceStore());
		setDescription(Messages.getString("SlideshowPreferencePage.DESCRIPTION")); //$NON-NLS-1$
	}
	
	/**
	 * Creates the field editors. Field editors are abstractions of
	 * the common GUI blocks needed to manipulate various types
	 * of preferences. Each field editor knows how to save and
	 * restore itself.
	 */
	public void createFieldEditors() {
		addField(new BooleanFieldEditor(P_FULL_SCREEN, Messages.getString("SlideshowPreferencePage.FULL_SCREEN"), getFieldEditorParent())); //$NON-NLS-1$
		addField(new IntegerFieldEditor(P_WINDOW_WIDTH, Messages.getString("SlideshowPreferencePage.WINDOW_WIDTH"), getFieldEditorParent(), 4)); //$NON-NLS-1$
		addField(new IntegerFieldEditor(P_WINDOW_HEIGHT, Messages.getString("SlideshowPreferencePage.WINDOW_HEIGHT"), getFieldEditorParent(), 4)); //$NON-NLS-1$
		addField(new IntegerFieldEditor(P_FRAME_TIME, Messages.getString("SlideshowPreferencePage.FRAME_TIME"), getFieldEditorParent(), 2)); //$NON-NLS-1$
		addField(new IntegerFieldEditor(P_TRANSITION_TIME, Messages.getString("SlideshowPreferencePage.TRANSITION_TIME"), getFieldEditorParent(), 2)); //$NON-NLS-1$
	}
	
	public void init(IWorkbench workbench) {
	}
}
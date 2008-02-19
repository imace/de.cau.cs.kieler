package com.dlsc.batik.preferences;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.IntegerFieldEditor;
import org.eclipse.jface.preference.RadioGroupFieldEditor;
import org.eclipse.jface.preference.StringFieldEditor;
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
public class PrettyPrintPreferencePage
	extends FieldEditorPreferencePage
	implements IWorkbenchPreferencePage {

	public static final String P_NEWLINE  = "newlinePreference"; //$NON-NLS-1$
	public static final String P_TABWIDTH = "tabwidthPreference"; //$NON-NLS-1$
	public static final String P_DOCWIDTH = "docwidthPreference"; //$NON-NLS-1$
	public static final String P_NOFORMAT = "noformatPreference"; //$NON-NLS-1$
	public static final String P_XMLDECL  = "xmldeclPreference"; //$NON-NLS-1$
	public static final String P_DOCTYPE  = "doctypePreference"; //$NON-NLS-1$
	public static final String P_PUBLICID = "publicidPreference"; //$NON-NLS-1$
	public static final String P_SYSTEMID = "systemidPreference"; //$NON-NLS-1$
	
	public PrettyPrintPreferencePage() {
		super(GRID);
		setPreferenceStore(BatikUIPlugin.getDefault().getPreferenceStore());
		setDescription(Messages.getString("PrettyPrintPreferencePage.DESCRIPTION")); //$NON-NLS-1$
	}
		
	/**
	 * Creates the field editors. Field editors are abstractions of
	 * the common GUI blocks needed to manipulate various types
	 * of preferences. Each field editor knows how to save and
	 * restore itself.
	 */
	public void createFieldEditors() {		
		addField(new IntegerFieldEditor(P_DOCWIDTH, Messages.getString("PrettyPrintPreferencePage.DOC_WIDTH"), getFieldEditorParent(), 3)); //$NON-NLS-1$
		addField(new IntegerFieldEditor(P_TABWIDTH, Messages.getString("PrettyPrintPreferencePage.TAB_WIDTH"), getFieldEditorParent(), 2)); //$NON-NLS-1$
		addField(new StringFieldEditor(P_XMLDECL, Messages.getString("PrettyPrintPreferencePage.XML_DECLARATION"), getFieldEditorParent())); //$NON-NLS-1$
	
		addField(new RadioGroupFieldEditor(
				P_DOCTYPE,
				Messages.getString("PrettyPrintPreferencePage.DOCUMENT_TYPE"), //$NON-NLS-1$
				1,
				new String[][] { 
						{ Messages.getString("PrettyPrintPreferencePage.DOCUMENT_TYPE_LEAVE"), "leave" },  //$NON-NLS-1$ //$NON-NLS-2$
						{ Messages.getString("PrettyPrintPreferencePage.DOCUMENT_TYPE_CHANGE"), "change" }, //$NON-NLS-1$ //$NON-NLS-2$
						{ Messages.getString("PrettyPrintPreferencePage.DOCUMENT_TYPE_REMOVE"), "remove" }},  //$NON-NLS-1$ //$NON-NLS-2$
				getFieldEditorParent()));
		
		addField(new StringFieldEditor(P_PUBLICID, "Public-ID", getFieldEditorParent())); //$NON-NLS-1$
		addField(new StringFieldEditor(P_SYSTEMID, "System-ID", getFieldEditorParent())); //$NON-NLS-1$
		
		addField(
			new BooleanFieldEditor(
				P_NOFORMAT,
				Messages.getString("PrettyPrintPreferencePage.NO_FORMATTING"), //$NON-NLS-1$
				getFieldEditorParent()));

		addField(new RadioGroupFieldEditor(
			P_NEWLINE,
			Messages.getString("PrettyPrintPreferencePage.NEWLINE"), //$NON-NLS-1$
			1,
			new String[][] { 
				{ Messages.getString("PrettyPrintPreferencePage.LINEFEED"), "lf" }, //$NON-NLS-1$ //$NON-NLS-2$
				{ Messages.getString("PrettyPrintPreferencePage.CARRIAGE_RETURN"), "cr" },  //$NON-NLS-1$ //$NON-NLS-2$
				{ Messages.getString("PrettyPrintPreferencePage.CARRIAGE_RETURN_LINEFEED"), "cr-lf" } //$NON-NLS-1$ //$NON-NLS-2$
		}, getFieldEditorParent()));
	}
	
	public void init(IWorkbench workbench) {
	}
}
package de.cau.cs.kieler.ssm.diagram.preferences;

import org.eclipse.gmf.runtime.diagram.ui.preferences.ConnectionsPreferencePage;

import de.cau.cs.kieler.ssm.diagram.part.SafeStateMachineDiagramEditorPlugin;


/**
 * @generated
 */
public class DiagramConnectionsPreferencePage extends ConnectionsPreferencePage {

	/**
	 * @generated
	 */
	public DiagramConnectionsPreferencePage() {
		setPreferenceStore(SafeStateMachineDiagramEditorPlugin.getInstance()
				.getPreferenceStore());
	}
}

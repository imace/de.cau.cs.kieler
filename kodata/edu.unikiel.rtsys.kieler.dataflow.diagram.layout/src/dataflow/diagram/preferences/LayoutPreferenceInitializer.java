package dataflow.diagram.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;

import dataflow.diagram.DataflowDiagramLayoutPlugin;

/**
 * Initializer class for the layout preferences of the dataflow diagram editor.
 * 
 * @author msp
 */
public class LayoutPreferenceInitializer extends AbstractPreferenceInitializer {

	/* (non-Javadoc)
	 * @see org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer#initializeDefaultPreferences()
	 */
	public void initializeDefaultPreferences() {
		IPreferenceStore preferenceStore = DataflowDiagramLayoutPlugin.getDefault().getPreferenceStore();
		preferenceStore.setDefault(DiagramLayoutPreferencePage.FIXED_INNER_PORTS, true);
		preferenceStore.setDefault(DiagramLayoutPreferencePage.FIXED_OUTER_PORTS, false);
		preferenceStore.setDefault(DiagramLayoutPreferencePage.FIXED_NODE_SIZE, true);
		preferenceStore.setDefault(DiagramLayoutPreferencePage.STRICT_PORT_SIDE, false);
	}

}

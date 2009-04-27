package dataflow.diagram.layout.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;

import dataflow.diagram.layout.DataflowDiagramLayoutPlugin;

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
		preferenceStore.setDefault(DiagramLayoutPreferencePage.FIXED_NODE_SIZE, true);
		preferenceStore.setDefault(DiagramLayoutPreferencePage.EMPTY_PORT_CONSTRAINTS,
				DiagramLayoutPreferencePage.VAL_PORT_FIXED_POS);
        preferenceStore.setDefault(DiagramLayoutPreferencePage.NONEMPTY_PORT_CONSTRAINTS,
                DiagramLayoutPreferencePage.VAL_FREE_PORTS);
		preferenceStore.setDefault(DiagramLayoutPreferencePage.LAYOUT_DIRECTION,
				DiagramLayoutPreferencePage.VAL_HORIZONTAL);
	}

}

package edu.unikiel.rtsys.kieler.kiml.ui.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;

import edu.unikiel.rtsys.kieler.kiml.ui.KimlUiPlugin;


/**
 * Class used to initialize default preference values.
 */
public class PreferenceInitializer extends AbstractPreferenceInitializer {

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.eclipse.core.runtime.preferences.AbstractPreferenceInitializer#
	 * initializeDefaultPreferences()
	 */
	public void initializeDefaultPreferences() {
		IPreferenceStore store = KimlUiPlugin.getDefault().getPreferenceStore();
		store.setDefault(PreferenceConstants.PREF_UI_DO_NOT_LAYOUT_CONNECTION_LABELS,
				false);
	}

}

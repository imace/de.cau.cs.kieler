package edu.unikiel.rtsys.kieler.kivik.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;

import edu.unikiel.rtsys.kieler.kivik.KivikPlugin;

/**
 * Class used to initialize default preference values.
 */
public class PreferenceInitializer extends AbstractPreferenceInitializer {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer#initializeDefaultPreferences()
	 */
	public void initializeDefaultPreferences() {
		IPreferenceStore store = KivikPlugin.getDefault().getPreferenceStore();
		store.setDefault(PreferenceConstants.PREF_KIVIK_ENABLE_SELECTING_IN_DIAGRAM, true);
	}

}

package edu.unikiel.rtsys.kieler.kiml.layouter.example.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;

import edu.unikiel.rtsys.kieler.kiml.layouter.example.Activator;

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
		IPreferenceStore store = Activator.getDefault().getPreferenceStore();
		store.setDefault(PreferenceConstants.PREF_LAYOUTER_EXAMPLE_HORIZONTAL,
				true);
		store.setDefault(PreferenceConstants.PREF_LAYOUTER_EXAMPLE_PADDING_X,
				25);
		store.setDefault(PreferenceConstants.PREF_LAYOUTER_EXAMPLE_PADDING_Y,
				25);
	}

}

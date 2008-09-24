package edu.unikiel.rtsys.kieler.kiml.layout.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;

import edu.unikiel.rtsys.kieler.kiml.layout.Activator;
import edu.unikiel.rtsys.kieler.kiml.layout.services.KimlNullLayoutProvider;

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
		store
				.setDefault(
						PreferenceConstants.PREF_LAYOUT_LAYOUT_CONNECTION_LABELS,
						false);
		store.setDefault(PreferenceConstants.PREF_LAYOUT_DEFAULT_LAYOUTER,
				KimlNullLayoutProvider.NULL_LAYOUT);
	}

}

package edu.unikiel.rtsys.kieler.kiml.layout.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;

import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutPlugin;
import edu.unikiel.rtsys.kieler.kiml.layout.services.KimlNullLayoutProvider;
import edu.unikiel.rtsys.kieler.kiml.layout.util.KimlLayoutPreferenceConstants;

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
		IPreferenceStore store = KimlLayoutPlugin.getDefault().getPreferenceStore();
		store
				.setDefault(
						KimlLayoutPreferenceConstants.PREF_LAYOUTPROVIDERS_LAYOUT_CONNECTION_LABELS,
						false);
		store.setDefault(KimlLayoutPreferenceConstants.PREF_LAYOUTPROVIDERS_DEFAULT_LAYOUTER,
				KimlNullLayoutProvider.NULL_LAYOUT);
		store.setDefault(KimlLayoutPreferenceConstants.PREF_DIAGRAMLAYOUTERS_DO_NOT_LAYOUT_CONNECTION_LABELS,
				true);
	}

}

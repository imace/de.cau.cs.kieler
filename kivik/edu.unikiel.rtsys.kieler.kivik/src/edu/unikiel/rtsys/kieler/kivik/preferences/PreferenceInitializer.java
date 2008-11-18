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
	 * @seeorg.eclipse.core.runtime.preferences.AbstractPreferenceInitializer#
	 * initializeDefaultPreferences()
	 */
	public void initializeDefaultPreferences() {
		IPreferenceStore store = KivikPlugin.getDefault().getPreferenceStore();

		store.setDefault(PreferenceConstants.PREF_KIVIK_ENABLE_AUTO_LAYOUT,
				false);
		store
				.setDefault(
						PreferenceConstants.PREF_KIVIK_ENABLE_COLLAPSING_OF_UNCHANGED_ELEMENTS,
						false);
		store
				.setDefault(
						PreferenceConstants.PREF_KIVIK_ENABLE_SCROLLING_ANIMATION,
						true);
		store.setDefault(
				PreferenceConstants.PREF_KIVIK_ENABLE_SELECTING_IN_DIAGRAM,
				true);
		store
				.setDefault(
						PreferenceConstants.PREF_KIVIK_ENABLE_ZOOMING_TO_CHANGED_ELEMENTS,
						true);
		store.setDefault(PreferenceConstants.PREF_KIVIK_INITIAL_ZOOM_FACTOR,
				70);
	}

}

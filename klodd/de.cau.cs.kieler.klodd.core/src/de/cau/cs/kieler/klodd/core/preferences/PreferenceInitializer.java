package de.cau.cs.kieler.klodd.core.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;

import de.cau.cs.kieler.klodd.core.KloddCorePlugin;


/**
 * Initializer for the KLoDD layouter plugin preferences.
 * 
 * @author msp
 */
public class PreferenceInitializer extends AbstractPreferenceInitializer {

	/* (non-Javadoc)
	 * @see org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer#initializeDefaultPreferences()
	 */
	public void initializeDefaultPreferences() {
		IPreferenceStore store = KloddCorePlugin.getDefault().getPreferenceStore();

		/* initialize the layout options */
		store.setDefault(KloddLayoutPreferences.MIN_DIST, 15.0f);
	}

}

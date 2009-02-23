package de.cau.cs.kieler.klodd.ui.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;

import de.cau.cs.kieler.kiml.ui.KimlUiPlugin;
import de.cau.cs.kieler.klodd.hierarchical.HierarchicalDataflowLayoutProvider;
import de.cau.cs.kieler.klodd.orthogonal.OrthogonalDataflowLayoutProvider;


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
		IPreferenceStore store = KimlUiPlugin.getDefault().getPreferenceStore();

		// initialize options for hierarchical layout
		store.setDefault(HierarchicalDataflowLayoutProvider.PREF_MIN_DIST,
				HierarchicalDataflowLayoutProvider.DEF_MIN_DIST);
		// initialize options for orthogonal layout
		store.setDefault(OrthogonalDataflowLayoutProvider.PREF_MIN_DIST,
				OrthogonalDataflowLayoutProvider.DEF_MIN_DIST);
	}

}

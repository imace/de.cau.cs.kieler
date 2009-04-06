package de.cau.cs.kieler.kiml.layouter.zest.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;

import de.cau.cs.kieler.kiml.layouter.zest.Activator;
import de.cau.cs.kieler.kiml.layouter.zest.ZestGridLayoutProvider;
import de.cau.cs.kieler.kiml.layouter.zest.ZestSpringLayoutProvider;


/**
 * Initializer for the Zest layouter plugin preferences.
 * 
 * @author msp
 */
public class PreferenceInitializer extends AbstractPreferenceInitializer {

	/* (non-Javadoc)
	 * @see org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer#initializeDefaultPreferences()
	 */
	public void initializeDefaultPreferences() {
		IPreferenceStore store = Activator.getDefault().getPreferenceStore();
		
		/* initialize the layout providers */
		store.setDefault(ZestSpringLayoutProvider.LAYOUTER_NAME, true);
		store.setDefault(ZestGridLayoutProvider.LAYOUTER_NAME, true);
		
		/* initialize the layout options */
		store.setDefault(ZestLayouterPreferencePage.SCALE_BASE, 40.0f);
	}

}

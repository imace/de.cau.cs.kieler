/*******************************************************************************
 * Copyright (c) 2008 Real-Time and Embedded Systems group
 *
 * INSERT LICENCE HERE
 *
 *
 * Author: Arne Schipper, ars@informatik.uni-kiel.de 
 *
 *******************************************************************************/
package edu.unikiel.rtsys.kieler.kiml.layout.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;

import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutPlugin;
import edu.unikiel.rtsys.kieler.kiml.layout.util.KimlLayoutPreferenceConstants;

/**
 * Class used to initialize default preference values for the KimlLayout
 * plug-in.
 * 
 * @author <a href="mailto:ars@informatik.uni-kiel.de">Arne Schipper</a>
 */
public class PreferenceInitializer extends AbstractPreferenceInitializer {

	/**
	 * Sets the default preference settings for the Kiml Layout plug-in.
	 */
	public void initializeDefaultPreferences() {
		IPreferenceStore store = KimlLayoutPlugin.getDefault()
				.getPreferenceStore();
		store
				.setDefault(
						KimlLayoutPreferenceConstants.PREF_LAYOUTPROVIDERS_LAYOUT_CONNECTION_LABELS,
						false);
		store
				.setDefault(
						KimlLayoutPreferenceConstants.PREF_DIAGRAMLAYOUTERS_USE_GMF_TO_LAYOUT_CONNECTION_LABELS,
						true);
	}

}

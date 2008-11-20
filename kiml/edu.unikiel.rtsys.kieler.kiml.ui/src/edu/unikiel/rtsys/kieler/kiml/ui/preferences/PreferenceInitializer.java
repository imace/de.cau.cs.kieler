/*******************************************************************************
 * Copyright (c) 2008 Real-Time and Embedded Systems group
 *
 * INSERT LICENCE HERE
 *
 *
 * Author: Arne Schipper, ars@informatik.uni-kiel.de 
 *
 *******************************************************************************/
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

		/* set general UI preferences here */
		// ... nothing yet ...
		/* set defaults for GenericDiagramLayouter */
		store
				.setDefault(
						PreferenceConstants.PREF_GENERIC_DIAGRAM_LAYOUTER_INSET_TOP,
						25);
		store
				.setDefault(
						PreferenceConstants.PREF_GENERIC_DIAGRAM_LAYOUTER_INSET_LEFT,
						0);
		store.setDefault(
				PreferenceConstants.PREF_GENERIC_DIAGRAM_LAYOUTER_INSET_BOTTOM,
				0);
		store.setDefault(
				PreferenceConstants.PREF_GENERIC_DIAGRAM_LAYOUTER_INSET_RIGHT,
				0);
	}

}

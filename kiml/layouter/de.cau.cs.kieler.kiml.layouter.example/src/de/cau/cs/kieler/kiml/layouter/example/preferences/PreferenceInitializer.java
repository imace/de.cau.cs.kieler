/*******************************************************************************
 * Copyright (c) 2008 Real-Time and Embedded Systems group
 *
 * INSERT LICENCE HERE
 *
 *
 * Author: Arne Schipper, ars@informatik.uni-kiel.de 
 *
 *******************************************************************************/
package de.cau.cs.kieler.kiml.layouter.example.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;

import de.cau.cs.kieler.kiml.layouter.example.Activator;


/**
 * Class used to initialize default preference values for the Example layouter
 * plug-in.
 * 
 * @author <a href="mailto:ars@informatik.uni-kiel.de">Arne Schipper</a>
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
		
		/* initialize the layout providers */
		store.setDefault(Activator.LAYOUT_PROVIDER_NAME, true);
		
		/* set default options */
		store.setDefault(PreferenceConstants.PREF_LAYOUTER_EXAMPLE_HORIZONTAL,
				true);
		store.setDefault(PreferenceConstants.PREF_LAYOUTER_EXAMPLE_PADDING_X,
				25);
		store.setDefault(PreferenceConstants.PREF_LAYOUTER_EXAMPLE_PADDING_Y,
				25);
	}

}

/*******************************************************************************
 * Copyright (c) 2008 Real-Time and Embedded Systems group
 *
 * INSERT LICENCE HERE
 *
 *
 * Author: Arne Schipper, ars@informatik.uni-kiel.de 
 *
 *******************************************************************************/
package de.cau.cs.kieler.kiml.ui.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;

import de.cau.cs.kieler.kiml.layout.util.KimlLayoutPreferenceConstants;
import de.cau.cs.kieler.kiml.ui.KimlUiPlugin;


/**
 * Class used to initialize default preference values.
 * 
 * @author <a href="mailto:ars@informatik.uni-kiel.de">Arne Schipper</a>
 */
public class PreferenceInitializer extends AbstractPreferenceInitializer {

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer#initializeDefaultPreferences()
	 */
	public void initializeDefaultPreferences() {
		IPreferenceStore store = KimlUiPlugin.getDefault().getPreferenceStore();
		
		// set defaults for layout preferences
		store.setDefault(
				KimlLayoutPreferenceConstants.PREF_LAYOUTPROVIDERS_LAYOUT_CONNECTION_LABELS,
				false);
		store.setDefault(
				KimlLayoutPreferenceConstants.PREF_DIAGRAMLAYOUTERS_USE_GMF_TO_LAYOUT_CONNECTION_LABELS,
				true);

		// set defaults for GenericDiagramLayouter
		store.setDefault(
				PreferenceConstants.PREF_GENERIC_DIAGRAM_LAYOUTER_INSET_TOP,
				25);
		store.setDefault(
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

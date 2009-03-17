/******************************************************************************
 * KIELER - Kiel Integrated Environment for Layout for the Eclipse RCP
 *
 * http://www.informatik.uni-kiel.de/rtsys/kieler/
 * 
 * Copyright 2008 by
 * + Christian-Albrechts-University of Kiel
 *   + Department of Computer Science
 *     + Real-Time and Embedded Systems Group
 * 
 * This code is provided under the terms of the Eclipse Public License (EPL).
 * See the file epl-v10.html for the license text.
 */
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

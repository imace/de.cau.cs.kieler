/*******************************************************************************
 * Copyright (c) 2008 Real-Time and Embedded Systems group
 *
 * INSERT LICENCE HERE
 *
 *
 * Author: Arne Schipper, ars@informatik.uni-kiel.de 
 *
 *******************************************************************************/
package edu.unikiel.rtsys.kieler.kiml.layouter.graphviz.preferences;

import kiel.layouter.graphviz.GraphvizLayoutProviderNames;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;

import edu.unikiel.rtsys.kieler.kiml.layouter.graphviz.Activator;

/**
 * Class used to initialize default preference values for the GraphViz layouter
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
		store.setDefault(GraphvizLayoutProviderNames.GRAPHVIZ_CIRCO, true);
		store.setDefault(GraphvizLayoutProviderNames.GRAPHVIZ_DOT, true);
		store.setDefault(GraphvizLayoutProviderNames.GRAPHVIZ_NEATO, true);
		store.setDefault(GraphvizLayoutProviderNames.GRAPHVIZ_TWOPI, true);

		/* initialize defaults */
		store.setDefault(PreferenceConstants.PREF_GRAPHVIZ_PADDING_X, 15);
		store.setDefault(PreferenceConstants.PREF_GRAPHVIZ_PADDING_Y, 15);

	}

}

package edu.unikiel.rtsys.kieler.kiml.layouter.graphviz.preferences;

import kiel.layouter.graphviz.GraphvizLayoutProviderNames;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;

import edu.unikiel.rtsys.kieler.kiml.layouter.graphviz.Activator;

/**
 * Class used to initialize default preference values.
 */
public class PreferenceInitializer extends AbstractPreferenceInitializer {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer#initializeDefaultPreferences()
	 */
	public void initializeDefaultPreferences() {
		IPreferenceStore store = Activator.getDefault().getPreferenceStore();
		
		/* initialize the layout providers */
		store.setDefault(GraphvizLayoutProviderNames.GRAPHVIZ_CIRCO, true);
		store.setDefault(GraphvizLayoutProviderNames.GRAPHVIZ_DOT, true);
		store.setDefault(GraphvizLayoutProviderNames.GRAPHVIZ_NEATO, true);
		store.setDefault(GraphvizLayoutProviderNames.GRAPHVIZ_TWOPI, true);
		
		/* initialize defaults */
		store.setDefault(PreferenceConstants.PREF_GRAPHVIZ_PADDING_X,15);
		store.setDefault(PreferenceConstants.PREF_GRAPHVIZ_PADDING_Y,15);
	
	}

}

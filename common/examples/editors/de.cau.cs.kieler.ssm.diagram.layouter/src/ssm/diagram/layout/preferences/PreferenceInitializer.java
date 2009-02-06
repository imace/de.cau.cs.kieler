/*******************************************************************************
 * Copyright (c) 2008 Real-Time and Embedded Systems group
 *
 * INSERT LICENCE HERE
 *
 *
 * Author: Arne Schipper, ars@informatik.uni-kiel.de 
 *
 *******************************************************************************/
package ssm.diagram.layout.preferences;


import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;

import ssm.diagram.layout.KimlSSMDiagramLayouterPlugin;




/**
 * Class used to initialize default preference values.
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
		IPreferenceStore store = KimlSSMDiagramLayouterPlugin.getDefault().getPreferenceStore();

		store.setDefault(PreferenceConstants.PREF_HEIGHT_COLLAPSED,40);
		store
				.setDefault(
						PreferenceConstants.PREF_WIDTH_COLLAPSED, 80);
	}

}

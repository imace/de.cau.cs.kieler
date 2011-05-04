/*
 * KIELER - Kiel Integrated Environment for Layout Eclipse Rich Client
 *
 * http://www.informatik.uni-kiel.de/rtsys/kieler/
 * 
 * Copyright 2011 by
 * + Christian-Albrechts-University of Kiel
 *   + Department of Computer Science
 *     + Real-Time and Embedded Systems Group
 * 
 * This code is provided under the terms of the Eclipse Public License (EPL).
 * See the file epl-v10.html for the license text.
 */
package de.cau.cs.kieler.klots.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;

import de.cau.cs.kieler.klots.KlotsPlugin;

/**
 * Class used to initialize default preference values.
 * 
 * @author ybe
 * 
 */
public class KlotsPreferenceInitializer extends AbstractPreferenceInitializer {

    /**
     * {@inheritDoc}
     */
    public void initializeDefaultPreferences() {
        IPreferenceStore store = KlotsPlugin.getDefault()
                .getPreferenceStore();
        store.setDefault(KlotsPreferenceConstants.P_CONNECTION_TYPE, "b");
    }

}
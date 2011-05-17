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
import org.eclipse.jface.resource.StringConverter;

import de.cau.cs.kieler.klots.KlotsPlugin;
import de.cau.cs.kieler.klots.util.KlotsConstants;

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
        IPreferenceStore store = KlotsPlugin.getDefault().getPreferenceStore();
        
        // connections
        store.setDefault(KlotsPreferenceConstants.P_CONNECTION_CONNECTION_TYPE, "b");
        
        // colors
        store.setDefault(KlotsPreferenceConstants.P_COLOR_FOREGROUND_STANDARD,
                StringConverter.asString(KlotsConstants.COLOR_RGB_FOREGROUND_STANDARD));
        store.setDefault(KlotsPreferenceConstants.P_COLOR_BACKGROUND_STANDARD,
                StringConverter.asString(KlotsConstants.COLOR_RGB_BACKGROUND_STANDARD));
        store.setDefault(KlotsPreferenceConstants.P_COLOR_FOREGROUND_ALREADY_DONE_MICROSTEP,
                StringConverter.asString(KlotsConstants.COLOR_RGB_FOREGROUND_ALREADY_DONE_MICROSTEP));
        store.setDefault(KlotsPreferenceConstants.P_COLOR_BACKGROUND_ALREADY_DONE_MICROSTEP,
                StringConverter.asString(KlotsConstants.COLOR_RGB_BACKGROUND_ALREADY_DONE_MICROSTEP));
        store.setDefault(KlotsPreferenceConstants.P_COLOR_FOREGROUND_ACTIVE_MICROSTEP,
                StringConverter.asString(KlotsConstants.COLOR_RGB_FOREGROUND_ACTIVE_MICROSTEP));
        store.setDefault(KlotsPreferenceConstants.P_COLOR_BACKGROUND_ACTIVE_MICROSTEP,
                StringConverter.asString(KlotsConstants.COLOR_RGB_BACKGROUND_ACTIVE_MICROSTEP));
        store.setDefault(KlotsPreferenceConstants.P_COLOR_FOREGROUND_YET_TO_BE_DENE_MICROSTEP,
                StringConverter.asString(KlotsConstants.COLOR_RGB_FOREGROUND_YET_TO_BE_DONE_MICROSTEP));
        store.setDefault(KlotsPreferenceConstants.P_COLOR_BACKGROUND_YET_TO_BE_DENE_MICROSTEP,
                StringConverter.asString(KlotsConstants.COLOR_RGB_BACKGROUND_YET_TO_BE_DONE_MICROSTEP));
    }

}
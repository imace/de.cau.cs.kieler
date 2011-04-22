/*
 * KIELER - Kiel Integrated Environment for Layout Eclipse RichClient
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
package de.cau.cs.kieler.kiml.viewer;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * Generated class for externalization of strings.
 * 
 * @author msp
 */
public final class Messages {

    /**
     * Hidden constructor.
     */
    private Messages() {
    }

    private static final String BUNDLE_NAME = "de.cau.cs.kieler.kiml.viewer.messages"; //$NON-NLS-1$
    private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);

    /**
     * Gets the string associated with the given key.
     * 
     * @param key key to look up
     * @return the associated string
     */
    public static String getString(final String key) {
        try {
            return RESOURCE_BUNDLE.getString(key);
        } catch (MissingResourceException e) {
            return '!' + key + '!';
        }
    }
}

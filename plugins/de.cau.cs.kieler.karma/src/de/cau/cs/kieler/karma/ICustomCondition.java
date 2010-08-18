/*
 * KIELER - Kiel Integrated Environment for Layout Eclipse RichClient
 *
 * http://www.informatik.uni-kiel.de/rtsys/kieler/
 * 
 * Copyright 2009 by
 * + Christian-Albrechts-University of Kiel
 *   + Department of Computer Science
 *     + Real-Time and Embedded Systems Group
 * 
 * This code is provided under the terms of the Eclipse Public License (EPL).
 * See the file epl-v10.html for the license text.
 */

package de.cau.cs.kieler.karma;

import de.cau.cs.kieler.core.util.ICondition;

/**
 * Interface for conditions that can be used with an extension point.
 * 
 * @author ckru
 * 
 * @param <T>
 *            the type for which the condition is used
 */
public abstract class ICustomCondition<T> implements ICondition<T> {
    
    /**
     * Key for referencing the annotation.
     */
    protected String key;

    /**
     * Desired value of the annotation.
     */
    protected String value;

    /**
     * Feed the condition with some initial values because extension points support only the
     * standard constructor.
     * 
     * @param key
     *            a key for referencing something.
     * @param value
     *            the value the condition could evaluate for.
     */
    public void initialize(final String thekey, final String thevalue) {
        key = thekey;
        value = thevalue;
    }

}

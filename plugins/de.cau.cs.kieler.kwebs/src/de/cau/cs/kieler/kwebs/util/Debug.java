/*
 * KIELER - Kiel Integrated Environment for Layout Eclipse RichClient
 *
 * http://www.informatik.uni-kiel.de/rtsys/kieler/
 *
 * Copyright 2008 by
 * + Christian-Albrechts-University of Kiel
 *     + Department of Computer Science
 *         + Real-Time and Embedded Systems Group
 *
 * This code is provided under the terms of the Eclipse Public License (EPL).
 * See the file epl-v10.html for the license text.
 */

package de.cau.cs.kieler.kwebs.util;

import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * Debugging utilities, mostly for displaying objects.
 * 
 * @kieler.rating  2011-08-02 proposed yellow
 *     reviewed by ckru, mri, msp
 *     
 * @author  swe
 */
public final class Debug {

    /**
     * Displays contents of a map.
     * 
     * @param map
     *            the map from which the key/value pairs are to be displayed
     */
    public static void printMap(final Map<?, ?> map) {
        if (map != null) {
            StackTraceElement element = Thread.currentThread().getStackTrace()[2];
            String caller = element.getClassName() 
                            + ":" + element.getMethodName()
                            + ":" + Integer.toString(element.getLineNumber());
            String clas = map.getClass().getCanonicalName();
            StringBuffer content = new StringBuffer();
            @SuppressWarnings("unchecked")
            Set<Object> keys = (Set<Object>) map.keySet();
            if (!keys.isEmpty()) {
                boolean isComparable = false;
                for (Object object : keys) {
                    isComparable = Comparable.class.isAssignableFrom(object.getClass());
                    break;
                }
                if (isComparable) {
                    keys = new TreeSet<Object>(keys);
                }
                for (Object key : keys) {
                    content.append("   " + key + " = " + map.get(key) + "\n");
                }
            } else {
                content.append("Map is empty.");
            }
            System.out.println(
                "CALLER: " + caller 
                + "\nCLASS OF MAP: " + clas 
                + "\nCONTENT OF MAP:\n" + content.toString() 
                + "\n"
            );
        }
    }

    /**
     * Private Constructor. Utility class must not
     * be instantiated.
     */
    private Debug() {
    }

}

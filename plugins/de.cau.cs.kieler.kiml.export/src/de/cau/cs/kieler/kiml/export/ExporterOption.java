/*
 * KIELER - Kiel Integrated Environment for Layout Eclipse RichClient
 *
 * http://www.informatik.uni-kiel.de/rtsys/kieler/
 * 
 * Copyright 2010 by
 * + Christian-Albrechts-University of Kiel
 *   + Department of Computer Science
 *     + Real-Time and Embedded Systems Group
 * 
 * This code is provided under the terms of the Eclipse Public License (EPL).
 * See the file epl-v10.html for the license text.
 */
package de.cau.cs.kieler.kiml.export;

import de.cau.cs.kieler.core.properties.Property;

/**
 * An exporter option providing a description in addition to the
 * {@code Property} functionality.
 * 
 * @author mri
 * 
 * @param <T>
 *            the option type
 */
public class ExporterOption<T> extends Property<T> {

    /** the option description. */
    private String description;

    /**
     * Constructs an ExporterOption.
     * 
     * @param theId
     *            the option id
     * @param theDescription
     *            the option description
     * @param theDefaultValue
     *            the default value, has to be != null
     */
    public ExporterOption(final String theId, final String theDescription,
            final T theDefaultValue) {
        super(theId, theDefaultValue);
        description = theDescription;
    }

    /**
     * Returns the option description.
     * 
     * @return the description
     */
    public String getDescription() {
        return description;
    }
}

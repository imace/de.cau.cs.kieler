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
package de.cau.cs.kieler.kiml.grana;

/**
 * An analysis should return a subclass of this class if it failed to analyse the graph
 * and provide meaningful information through the {@code toString} method.
 * 
 * @author mri
 */
public class AnalysisFailed {

    /** the analysis failed types. */
    public enum Type {
        /** the type for an analysis which failed in general. */
        Failed,
        /** the type for a canceled analysis. */
        Canceled,
        /** the type for a missing or wrong typed dependency result. */
        Dependency
    }

    /** the message for a failed analysis. */
    private static final String MESSAGE_ANALYSIS_FAILED =
            "Analysis failed";
    /** the message for a canceled analysis. */
    private static final String MESSAGE_ANALYSIS_CANCELED = "Analysis canceled";
    /** the message for a missing or wrong typed dependency result. */
    private static final String MESSAGE_ANALYSIS_DEPENDENCY = "Analysis canceled";
    /** the analysis failed type. */
    private Type type;

    /**
     * Constructs a new analysis failed object.
     * 
     * @param theType
     *            the type
     */
    public AnalysisFailed(Type theType) {
        type = theType;
    }

    /**
     * Returns the type.
     * 
     * @return the type
     */
    public Type getType() {
        return type;
    }

    /**
     * {@inheritDoc}
     */
    public String toString() {
        switch(type) {
        case Canceled:
            return MESSAGE_ANALYSIS_CANCELED;
        case Dependency:
            return MESSAGE_ANALYSIS_DEPENDENCY;
        case Failed:
        default:
            return MESSAGE_ANALYSIS_FAILED;
        }
    }
}

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

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * An analysis bundle can provide several analyses. It is required to notify
 * registered {@code IBundleChangedListener} about any added or removed
 * analyses.
 * 
 * @author mri
 */
public abstract class AbstractAnalysisBundle {

    /** a list of all bundle changed listeners. */
    private List<IBundleChangedListener> listeners = new LinkedList<IBundleChangedListener>();

    /**
     * Returns a collection of all analyses provided by this bundle.
     * 
     * @return the analyses
     */
    public abstract Collection<AbstractInfoAnalysis> getAnalyses();

    /**
     * Adds a listener to the bundle.
     * 
     * @param listener
     *            the listener
     */
    public void addBundleChangedListener(final IBundleChangedListener listener) {
        if (listeners.contains(listener)) {
            listeners.add(listener);
        }
    }

    /**
     * Removes a listener from the bundle.
     * 
     * @param listener
     *            the listener
     */
    public void removeBundleChangedListener(
            final IBundleChangedListener listener) {
        listeners.remove(listener);
    }

    /**
     * Notifies all listeners that an analysis was added.
     * 
     * @param analysis
     *            the analysis
     */
    protected void notifyListenersAnalysisAdded(final AbstractInfoAnalysis analysis) {
        for (IBundleChangedListener listener : listeners) {
            listener.analysisAdded(this, analysis);
        }
    }

    /**
     * Notifes all listeners that an analysis was removed.
     * 
     * @param analysis
     *            the analysis
     */
    protected void notifyListenersAnalysisRemoved(final AbstractInfoAnalysis analysis) {
        for (IBundleChangedListener listener : listeners) {
            listener.analysisRemoved(this, analysis);
        }
    }
}

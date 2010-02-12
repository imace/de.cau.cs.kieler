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
package de.cau.cs.kieler.sim.esi;

import de.cau.cs.kieler.sim.esi.esi.tick;
import de.cau.cs.kieler.sim.esi.esi.trace;
import de.cau.cs.kieler.sim.esi.trace.ITrace;

/**
 * @author ctr
 * 
 */
public class EsiTrace implements ITrace {

    private trace trace;

    private tick current = null;

    private int pos;

    public EsiTrace(trace t) {
        pos = 0;
        this.trace = t;
    }

    /**
     * {@inheritDoc}
     */
    public tick current() {
        return current;
    }

    /**
     * {@inheritDoc}
     */
    public int getRemaining() {
        return trace.getTicks().size() - pos;
    }

    /**
     * {@inheritDoc}
     */
    public boolean hasNext() {
        // TODO Auto-generated method stub
        return getRemaining() > 0;
    }

    /**
     * {@inheritDoc}
     */
    public tick next() {

        if (trace.getTicks().size() > pos) {
            current = trace.getTicks().get(pos);
            pos++;
            return current;
        } else {
            return null;
        }
    }

    /**
     * {@inheritDoc}
     */
    public void reset() {
        pos = 0;
        current = null;
    }

}

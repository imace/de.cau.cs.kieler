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
package de.cau.cs.kieler.sim.eso;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import de.cau.cs.kieler.sim.eso.eso.kvpair;
import de.cau.cs.kieler.sim.eso.eso.signal;
import de.cau.cs.kieler.sim.eso.eso.tick;

/**
 * @author ctr
 * @author Sebastian Schäfer - ssc AT informatik.uni-kiel.de
 * @kieler.rating 2011-12-07 red
 * 
 */
public class EsoTick implements ITick {

    private tick tick;

    /**
     * @param t
     */
    public EsoTick(final tick t) {
        this.tick = t;
    }

    /**
     * {@inheritDoc}
     */
    public List<ISignal> getInputs() {
        LinkedList<ISignal> res = new LinkedList<ISignal>();
        for (signal s : tick.getInput()) {
            if (s.isValued()) {
                res.add(new EsoSignal(s.getName().trim(), s.getVal()));
            } else {
                res.add(new EsoSignal(s.getName().trim()));
            }
        }
        return res;
    }

    /**
     * {@inheritDoc}
     */
    public List<ISignal> getOutputs() {
        LinkedList<ISignal> res = new LinkedList<ISignal>();
        for (signal s : tick.getOutput()) {
            res.add(new EsoSignal(s.getName()));
        }
        return res;
    }

    /**
     * {@inheritDoc}
     */
    public Map<String, Object> getExtraInfos() {
        HashMap<String, Object> retval = new HashMap<String, Object>();
        for (kvpair kv : tick.getExtraInfos()) {
            retval.put(kv.getKey().trim(), kv.getValue());
        }
        
        return retval;
    }
}
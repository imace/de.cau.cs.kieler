/*
 * KIELER - Kiel Integrated Environment for Layout Eclipse RichClient
 *
 * http://www.informatik.uni-kiel.de/rtsys/kieler/
 * 
 * Copyright 2012 by
 * + Christian-Albrechts-University of Kiel
 *   + Department of Computer Science
 *     + Real-Time and Embedded Systems Group
 * 
 * This code is provided under the terms of the Eclipse Public License (EPL).
 * See the file epl-v10.html for the license text.
 */
package de.cau.cs.kieler.s.sim.sc.test;

import java.util.LinkedList;
import java.util.List;

import de.cau.cs.kieler.sim.kiem.test.KiemAutomatedJUnit;
import de.cau.cs.kieler.sim.kiem.test.KiemTestPlugin;

/**
 * The test plugin for testing the s-sc-simulator
 * 
 * @author cmot
 */
public class SSimSCAutomatedJUnit extends KiemAutomatedJUnit {

    
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    protected String getPluginId() {
        return SSimSCTestPlugin.PLUGIN_ID;
    }

    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    protected List<String> getPluginModelFiles() {
        return new LinkedList<String>();
    }

    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    protected String getPluginExecutionFile() {
        return "";
    }

    
}

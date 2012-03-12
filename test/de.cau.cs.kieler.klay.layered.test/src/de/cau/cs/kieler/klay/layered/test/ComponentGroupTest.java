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
package de.cau.cs.kieler.klay.layered.test;

import java.util.Set;

import static org.junit.Assert.*;
import org.junit.Test;

import de.cau.cs.kieler.kiml.options.PortSide;
import de.cau.cs.kieler.klay.layered.components.ComponentGroup;
import de.cau.cs.kieler.klay.layered.graph.LayeredGraph;
import de.cau.cs.kieler.klay.layered.properties.Properties;

/**
 * Tests the {@link de.cau.cs.kieler.klay.layered.components.ComponentGroup} class.
 * 
 * @author cds
 */
public class ComponentGroupTest {
    /**
     * Tests some valid combinations of layered graphs in a single component group.
     */
    @Test
    public void testValidConstraints() {
        // Add two N, E, W, S, and C components each to a single compound group
        ComponentGroup group = new ComponentGroup();
        
        assertTrue(group.add(generateGraph(ComponentGroup.CONN_N)));
        assertTrue(group.add(generateGraph(ComponentGroup.CONN_N)));
        assertTrue(group.add(generateGraph(ComponentGroup.CONN_S)));
        assertTrue(group.add(generateGraph(ComponentGroup.CONN_S)));
        assertTrue(group.add(generateGraph(ComponentGroup.CONN_W)));
        assertTrue(group.add(generateGraph(ComponentGroup.CONN_W)));
        assertTrue(group.add(generateGraph(ComponentGroup.CONN_E)));
        assertTrue(group.add(generateGraph(ComponentGroup.CONN_E)));
        assertTrue(group.add(generateGraph(ComponentGroup.CONN_C)));
        assertTrue(group.add(generateGraph(ComponentGroup.CONN_C)));
        
        // Add a horizontal and two E, W, and C components each to a single compound group
        group = new ComponentGroup();
        
        assertTrue(group.add(generateGraph(ComponentGroup.CONN_WE)));
        assertTrue(group.add(generateGraph(ComponentGroup.CONN_WE)));
        assertTrue(group.add(generateGraph(ComponentGroup.CONN_W)));
        assertTrue(group.add(generateGraph(ComponentGroup.CONN_W)));
        assertTrue(group.add(generateGraph(ComponentGroup.CONN_E)));
        assertTrue(group.add(generateGraph(ComponentGroup.CONN_E)));
        assertTrue(group.add(generateGraph(ComponentGroup.CONN_C)));
        assertTrue(group.add(generateGraph(ComponentGroup.CONN_C)));
        
        // Add a vertical and two N, S, and C components each to a single compound group
        group = new ComponentGroup();

        assertTrue(group.add(generateGraph(ComponentGroup.CONN_NS)));
        assertTrue(group.add(generateGraph(ComponentGroup.CONN_NS)));
        assertTrue(group.add(generateGraph(ComponentGroup.CONN_N)));
        assertTrue(group.add(generateGraph(ComponentGroup.CONN_N)));
        assertTrue(group.add(generateGraph(ComponentGroup.CONN_S)));
        assertTrue(group.add(generateGraph(ComponentGroup.CONN_S)));
        assertTrue(group.add(generateGraph(ComponentGroup.CONN_C)));
        assertTrue(group.add(generateGraph(ComponentGroup.CONN_C)));
        
        // TODO: Add more test cases.
    }
    
    /**
     * Tests the invalid combinations of layered graphs in a single component group.
     */
    @Test
    public void testInvalidConstraints() {
        // Add a horizontal and a vertical component to a single component group
        ComponentGroup group = new ComponentGroup();

        assertTrue(group.add(generateGraph(ComponentGroup.CONN_WE)));
        assertFalse(group.add(generateGraph(ComponentGroup.CONN_NS)));
        assertFalse(group.add(generateGraph(ComponentGroup.CONN_WNS)));
        assertFalse(group.add(generateGraph(ComponentGroup.CONN_ENS)));
        
        // Do the reverse
        group = new ComponentGroup();

        assertTrue(group.add(generateGraph(ComponentGroup.CONN_NS)));
        assertFalse(group.add(generateGraph(ComponentGroup.CONN_WE)));
        assertFalse(group.add(generateGraph(ComponentGroup.CONN_NWE)));
        assertFalse(group.add(generateGraph(ComponentGroup.CONN_SWE)));
        
        // TODO: Add more test cases.
    }
    
    
    /**
     * Creates a new layered graph with its external port side connections property set to the
     * given set of connections.
     * 
     * @param connections the set of connections.
     * @return the layered graph.
     */
    private static LayeredGraph generateGraph(final Set<PortSide> connections) {
        LayeredGraph graph = new LayeredGraph();
        graph.setProperty(Properties.EXT_PORT_CONNECTIONS, connections);
        
        return graph;
    }
}
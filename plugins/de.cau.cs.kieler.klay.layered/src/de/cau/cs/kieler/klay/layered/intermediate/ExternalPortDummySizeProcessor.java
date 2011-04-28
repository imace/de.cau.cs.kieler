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
package de.cau.cs.kieler.klay.layered.intermediate;

import java.util.LinkedList;
import java.util.List;

import de.cau.cs.kieler.core.alg.AbstractAlgorithm;
import de.cau.cs.kieler.kiml.options.PortSide;
import de.cau.cs.kieler.klay.layered.ILayoutProcessor;
import de.cau.cs.kieler.klay.layered.Properties;
import de.cau.cs.kieler.klay.layered.graph.LNode;
import de.cau.cs.kieler.klay.layered.graph.Layer;
import de.cau.cs.kieler.klay.layered.graph.LayeredGraph;

/**
 * Sets the width of external port dummies.
 * 
 * <p>To see why this is necessary, please refer to the processor's Wiki documentation.</p>
 * 
 * <dl>
 *   <dt>Precondition:</dt><dd>A layered graph with finished node placement; node order respects
 *     in-layer constraints.</dd>
 *   <dt>Postcondition:</dt><dd>External port dummies are assigned a width.</dd>
 *   <dt>Slots:</dt><dd>Before phase 5.</dd>
 *   <dt>Same-slot dependencies:</dt><dd>None.</dd>
 * </dl>
 * 
 * @see ExternalPortConstraintProcessor
 * @see ExternalPortOrthogonalEdgeRouter
 * @author cds
 */
public class ExternalPortDummySizeProcessor extends AbstractAlgorithm implements ILayoutProcessor {

    /**
     * {@inheritDoc}
     */
    public void process(final LayeredGraph layeredGraph) {
        getMonitor().begin("External port dummy size processing", 1);
        
        List<LNode> northernDummies = new LinkedList<LNode>();
        List<LNode> southernDummies = new LinkedList<LNode>();
        
        // Calculate the width difference (this assumes CENTER node alignment)
        double normalSpacing = layeredGraph.getProperty(Properties.OBJ_SPACING);
        double smallSpacing = normalSpacing * layeredGraph.getProperty(Properties.EDGE_SPACING_FACTOR);
        double delta = smallSpacing * 2;
        
        // Iterate through the layers
        for (Layer layer : layeredGraph.getLayers()) {
            northernDummies.clear();
            southernDummies.clear();
            
            // Collect northern and southern external port dummies
            for (LNode node : layer.getNodes()) {
                if (node.getProperty(Properties.NODE_TYPE) == Properties.NodeType.EXTERNAL_PORT) {
                    PortSide side = node.getProperty(Properties.EXT_PORT_SIDE);
                    
                    if (side == PortSide.NORTH) {
                        northernDummies.add(node);
                    } else if (side == PortSide.SOUTH) {
                        southernDummies.add(node);
                    }
                }
            }
            
            // Set widths
            setWidths(northernDummies, true, delta);
            setWidths(southernDummies, false, delta);
        }
        
        getMonitor().done();
    }
    
    /**
     * Sets the widths of the given list of nodes.
     * 
     * @param nodes the list of nodes.
     * @param topDown {@code true} if the nodes should widen with increasing index, {@code false}
     *                if it should be the other way round.
     * @param delta the width difference from one node to the next.
     */
    private void setWidths(final List<LNode> nodes, final boolean topDown, final double delta) {
        double currentWidth = 0.0;
        double step = delta;
        
        if (!topDown) {
            // Start with the widest node, decreasing node size
            currentWidth = delta * (nodes.size() - 1);
            step *= -1.0;
        }
        
        for (LNode node : nodes) {
            node.getSize().x = currentWidth;
            currentWidth += step;
        }
    }
    
}

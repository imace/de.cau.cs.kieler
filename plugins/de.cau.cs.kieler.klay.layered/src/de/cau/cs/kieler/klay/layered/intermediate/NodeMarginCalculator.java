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


import java.awt.geom.Rectangle2D;

import de.cau.cs.kieler.core.alg.AbstractAlgorithm;
import de.cau.cs.kieler.klay.layered.ILayoutProcessor;
import de.cau.cs.kieler.klay.layered.graph.LInsets;
import de.cau.cs.kieler.klay.layered.graph.LLabel;
import de.cau.cs.kieler.klay.layered.graph.LNode;
import de.cau.cs.kieler.klay.layered.graph.LPort;
import de.cau.cs.kieler.klay.layered.graph.Layer;
import de.cau.cs.kieler.klay.layered.graph.LayeredGraph;

/**
 * Sets the node margins. Node margins are influenced by both port positions and sizes
 * and label positions and sizes.
 * 
 * <dl>
 *   <dt>Precondition:</dt><dd>a layered graph; nodes have fixed port positions; labels
 *     have fixed positions.</dd>
 *   <dt>Postcondition:</dt><dd>the node margins are properly set to form a bounding box
 *     around the node and its ports and labels.</dd>
 *   <dt>Slots:</dt><dd>Before phase 4.</dd>
 *   <dt>Same-slot dependencies:</dt><dd>{@link PortPositionProcessor}</dd>
 * </dl>
 *
 * @see PortPositionProcessor
 * @author cds
 */
public class NodeMarginCalculator extends AbstractAlgorithm implements ILayoutProcessor {

    /**
     * {@inheritDoc}
     */
    public void process(final LayeredGraph layeredGraph) {
        getMonitor().begin("Node margin calculation", 1);
        
        // Iterate through the layers
        for (Layer layer : layeredGraph.getLayers()) {
            // Iterate through the layer's nodes
            for (LNode node : layer.getNodes()) {
                // This will be our bounding box. We'll start with one that's the same size
                // as our node, and at the same position.
                Rectangle2D.Double boundingBox = new Rectangle2D.Double(
                        node.getPosition().x,
                        node.getPosition().y,
                        node.getSize().x,
                        node.getSize().y);
                
                // We'll reuse this rectangle as our box for elements to add to the bounding box
                Rectangle2D.Double elementBox = new Rectangle2D.Double();
                
                // Put the node's label into the bounding box
                LLabel label = node.getLabel();
                if (label != null) {
                    elementBox.x = label.getPosition().x + node.getPosition().x;
                    elementBox.y = label.getPosition().y + node.getPosition().y;
                    elementBox.width = label.getSize().x;
                    elementBox.height = label.getSize().y;
                    
                    Rectangle2D.union(boundingBox, elementBox, boundingBox);
                }
                
                // Do the same for ports and their labels
                for (LPort port : node.getPorts()) {
                    // Calculate the port's upper left corner's x and y coordinate
                    double portX = port.getPosition().x - port.getSize().x / 2.0 + node.getPosition().x;
                    double portY = port.getPosition().y - port.getSize().y / 2.0 + node.getPosition().y;
                    
                    // The port itself
                    elementBox.x = portX;
                    elementBox.y = portY;
                    elementBox.width = port.getSize().x;
                    elementBox.height = port.getSize().y;
                    
                    Rectangle2D.union(boundingBox, elementBox, boundingBox);
                    
                    // The port's label, if any
                    label = port.getLabel();
                    if (label != null) {
                        elementBox.x = label.getPosition().x + portX;
                        elementBox.y = label.getPosition().y + portY;
                        elementBox.width = label.getSize().x;
                        elementBox.height = label.getSize().y;
                        
                        Rectangle2D.union(boundingBox, elementBox, boundingBox);
                    }
                }
                
                // Reset the margin
                LInsets.Double margin = node.getMargin();
                margin.top = node.getPosition().y - boundingBox.y;
                margin.bottom = boundingBox.getMaxY() - (node.getPosition().y + node.getSize().y);
                margin.left = node.getPosition().x - boundingBox.x;
                margin.right = boundingBox.getMaxX() - (node.getPosition().x + node.getSize().x);
            }
        }
        
        getMonitor().done();
    }
    
}

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
package de.cau.cs.kieler.klay.layered.impl.edges;

import de.cau.cs.kieler.core.alg.AbstractAlgorithm;
import de.cau.cs.kieler.core.alg.IKielerProgressMonitor;
import de.cau.cs.kieler.klay.layered.Properties;
import de.cau.cs.kieler.klay.layered.graph.Coord;
import de.cau.cs.kieler.klay.layered.graph.LEdge;
import de.cau.cs.kieler.klay.layered.graph.LLabel;
import de.cau.cs.kieler.klay.layered.graph.LNode;
import de.cau.cs.kieler.klay.layered.graph.LPort;
import de.cau.cs.kieler.klay.layered.graph.Layer;
import de.cau.cs.kieler.klay.layered.graph.LayeredGraph;
import de.cau.cs.kieler.klay.layered.modules.ILabelPlacer;

/**
 * A simple label placement implementation.
 * Places the labels in the middle between two ports.
 * 
 * @author jjc
 *
 */
public class SimpleLabelPlacer extends AbstractAlgorithm implements ILabelPlacer {

    /**
     * {@inheritDoc}
     */
    public void placeLabels(final LayeredGraph thelayeredGraph) {
        
        for (Layer layer : thelayeredGraph.getLayers()) {
            for (LNode node : layer.getNodes()) {
                for (LPort port : node.getPorts()) {
                    for (LEdge edge : port.getEdges()) {
                        for (LLabel label : edge.getLabels()) {
                            LongEdge longEdge = null;
                            if (edge.getTarget().getNode().getProperty(Properties.NODE_TYPE) == Properties.NodeType.LONG_EDGE) {
                                longEdge = new LongEdge(edge);
                                longEdge.initialize();
                            }
                            Coord source = new Coord(edge.getSource().getPos().x, edge.getSource()
                                    .getPos().y);
                            Coord target;
                            if (longEdge == null) {
                                target = new Coord(edge.getTarget().getPos().x, edge.getTarget()
                                        .getPos().y);
                            } else {
                                target = new Coord(longEdge.getTarget().getPos().x, longEdge
                                        .getTarget().getPos().y);
                            }
                            source = source.add(edge.getSource().getNode().getPos());
                            if (longEdge == null) {
                                target = target.add(edge.getTarget().getNode().getPos());
                            } else {
                                target = target.add(longEdge.getTarget().getNode().getPos());
                            }
                            label.getPos().x = Math.abs(source.x - target.x) / 2;
                            if (target.y <= source.y) {
                                label.getPos().y = (target.y - source.y) / 2;
                            } else {
                                label.getPos().y = Math.abs(source.y - target.y) / 2;
                            }
                            label.getPos().x -= label.getSize().x / 2;
                        }
                    }
                }
            }
        }

    }

    /**
     * {@inheritDoc}
     */
    public Coord sizeOfLongestLabel(final Layer thelayer) {
        Coord longest = new Coord(0, 0);
        for (LNode node : thelayer.getNodes()) {
            for (LPort port : node.getPorts()) {
                for (LEdge edge : port.getEdges()) {
                    for (LLabel label : edge.getLabels()) {
                        if (label.getSize().x > longest.x) {
                            longest = label.getSize();
                        }
                    }
                }
            }
        }
        return longest;
    }

    /**
     * {@inheritDoc}
     */
    public void reset() {
        super.reset();
    }


}

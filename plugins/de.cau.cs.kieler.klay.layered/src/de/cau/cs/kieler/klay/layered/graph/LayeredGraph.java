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
package de.cau.cs.kieler.klay.layered.graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * A layered graph has a set of layers that contain the nodes.
 *
 * @author msp
 */
public class LayeredGraph {

    /** the total size of the drawing, without offset. */
    private Coord size = new Coord();
    /** the offset to be added to all positions. */
    private Coord offset = new Coord();
    /** the original object from which the graph was created. */
    private Object origin;
    /** the layers of the layered graph. */
    private List<Layer> layers = new LinkedList<Layer>();

    /**
     * Creates a layered graph.
     * 
     * @param theorigin the original object for the graph
     */
    public LayeredGraph(final Object theorigin) {
        this.origin = theorigin;
    }

    /**
     * @return the size
     */
    public Coord getSize() {
        return size;
    }

    /**
     * @return the offset
     */
    public Coord getOffset() {
        return offset;
    }

    /**
     * @return the origin
     */
    public Object getOrigin() {
        return origin;
    }

    /**
     * @return the layers
     */
    public List<Layer> getLayers() {
        return layers;
    }

    /**
     * Creates an iterable to gather all nodes of the graph.
     * 
     * @return an iterable for all nodes
     */
    public Iterable<LNode> getNodes() {
        return new Iterable<LNode>() {
            public Iterator<LNode> iterator() {
                return new Iterator<LNode>() {
                    private Iterator<Layer> layerIter = layers.iterator();
                    private Iterator<LNode> nodeIter;
                    
                    public boolean hasNext() {
                        if (nodeIter != null && nodeIter.hasNext()) {
                            return true;
                        }
                        while (layerIter.hasNext()) {
                            nodeIter = layerIter.next().getNodes().iterator();
                            if (nodeIter.hasNext()) {
                                return true;
                            }
                        }
                        return false;
                    }

                    public LNode next() {
                        if (nodeIter != null && nodeIter.hasNext()) {
                            return nodeIter.next();
                        }
                        while (layerIter.hasNext()) {
                            nodeIter = layerIter.next().getNodes().iterator();
                            if (nodeIter.hasNext()) {
                                return nodeIter.next();
                            }
                        }
                        throw new NoSuchElementException();
                    }

                    public void remove() {
                        throw new UnsupportedOperationException();
                    }
                    
                };
            }
        };
    }
    
    /**
     * Split the long edges of the layered graph to obtain a proper layering.
     */
    public void splitEdges() {
        // FIXME to implement
    }
    
}

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

import de.cau.cs.kieler.core.util.ICondition;
import de.cau.cs.kieler.kiml.layout.options.PortSide;
import de.cau.cs.kieler.kiml.layout.options.PortType;

/**
 * A port in a layered graph.
 *
 * @author msp
 */
public class LPort implements Comparable<LPort> {

    /** the owning node. */
    private LNode owner;
    /** the port condType. */
    private PortType type;
    /** the port side. */
    private PortSide side = PortSide.UNDEFINED;
    /** the current position of the port. */
    private Coord pos = new Coord();
    /** the original object from which the port was created. */
    private Object origin;
    /** the edges connected to the port. */
    private List<LEdge> edges = new LinkedList<LEdge>();
    /** name of the port. */
    private String name;
    
    // CHECKSTYLEOFF VisibilityModifier
    /** Identifier value, may be arbitrarily used by algorithms. */
    public int id;
    // CHECKSTYLEON VisibilityModifier
    
    /** A condition that checks the type of ports. */
    public static class TypeCondition implements ICondition<LPort> {
        private PortType condType;
        /**
         * Creates a type condition.
         * @param thetype the type of port to admit
         */
        public TypeCondition(final PortType thetype) {
            this.condType = thetype;
        }
        
        /**
         * {@inheritDoc}
         */
        public boolean evaluate(final LPort object) {
            return object.type == condType;
        }
    }
    
    /** A condition that checks the side of ports. */
    public static class SideCondition implements ICondition<LPort> {
        private PortSide condSide;
        /**
         * Creates a side condition.
         * @param theside the side of port to admit
         */
        public SideCondition(final PortSide theside) {
            this.condSide = theside;
        }
        
        /**
         * {@inheritDoc}
         */
        public boolean evaluate(final LPort object) {
            return object.side == condSide;
        }
    }
    
    /**
     * Creates a port.
     * 
     * @param thetype the type of port
     * @param theorigin the original object for the port, or {@code null}
     * @param thename name of the port, or {@code null}
     */
    public LPort(final PortType thetype, final Object theorigin, final String thename) {
        this.type = thetype;
        this.origin = theorigin;
        this.name = thename;
    }
    
    /**
     * Creates a port.
     * 
     * @param thetype the type of port
     * @param theorigin the original object for the port, or {@code null}
     */
    public LPort(final PortType thetype, final Object theorigin) {
        this(thetype, theorigin, null);
    }
    
    /**
     * Creates a port.
     * 
     * @param thetype the type of port
     */
    public LPort(final PortType thetype) {
        this(thetype, null, null);
    }
    
    /**
     * Creates a port.
     */
    public LPort() {
        this(PortType.UNDEFINED, null, null);
    }

    /**
     * {@inheritDoc}
     */
    public String toString() {
        if (name == null) {
            return "p_" + id;
        } else {
            return "p_" + name;
        }
    }

    /**
     * {@inheritDoc}
     */
    public int compareTo(final LPort other) {
        return other.id - this.id;
    }

    /**
     * @return the owner
     */
    public LNode getOwner() {
        return owner;
    }

    /**
     * Sets the owning node and adds itself to the node's list of ports.
     * If the port was previously in another node, it is removed from that
     * node's list of ports.
     * 
     * @param theowner the owner to set
     */
    public void setOwner(final LNode theowner) {
        if (owner != null) {
            owner.getPorts().remove(this);
        }
        this.owner = theowner;
        owner.getPorts().add(this);
    }

    /**
     * @return the condType
     */
    public PortType getType() {
        return type;
    }

    /**
     * @param thetype the condType to set
     */
    public void setType(final PortType thetype) {
        this.type = thetype;
    }

    /**
     * @return the side
     */
    public PortSide getSide() {
        return side;
    }

    /**
     * @param theside the side to set
     */
    public void setSide(final PortSide theside) {
        this.side = theside;
    }

    /**
     * @return the pos
     */
    public Coord getPos() {
        return pos;
    }

    /**
     * @return the origin
     */
    public Object getOrigin() {
        return origin;
    }

    /**
     * @return the edges
     */
    public List<LEdge> getEdges() {
        return edges;
    }

    /**
     * Returns an iterable over all connected ports.
     * 
     * @return an iterable over the connected ports
     */
    public Iterable<LPort> getConnectedPorts() {
        return new Iterable<LPort>() {
            public Iterator<LPort> iterator() {
                final Iterator<LEdge> edgeIter = edges.iterator();
                return new Iterator<LPort>() {
                    public boolean hasNext() {
                        return edgeIter.hasNext();
                    }
                    public LPort next() {
                        LEdge nextEdge = edgeIter.next();
                        if (nextEdge.getSource() == LPort.this) {
                            return nextEdge.getTarget();
                        } else {
                            return nextEdge.getSource();
                        }
                    }
                    public void remove() {
                        edgeIter.remove();
                    }
                };
            }
            
        };
    }
    
    /**
     * @return the index of this port
     */
    public int getIndex() {
        if (owner == null) {
            return -1;
        } else {
            return owner.getPorts().indexOf(this);
        }
    }
    
}

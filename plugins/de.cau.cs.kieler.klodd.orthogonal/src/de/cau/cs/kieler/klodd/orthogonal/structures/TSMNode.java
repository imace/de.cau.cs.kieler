/*
 * KIELER - Kiel Integrated Environment for Layout Eclipse RichClient
 *
 * http://www.informatik.uni-kiel.de/rtsys/kieler/
 * 
 * Copyright 2009 by
 * + Christian-Albrechts-University of Kiel
 *   + Department of Computer Science
 *     + Real-Time and Embedded Systems Group
 * 
 * This code is provided under the terms of the Eclipse Public License (EPL).
 * See the file epl-v10.html for the license text.
 */
package de.cau.cs.kieler.klodd.orthogonal.structures;

import de.cau.cs.kieler.kiml.layout.klayoutdata.KShapeLayout;
import de.cau.cs.kieler.kiml.layout.util.KimlLayoutUtil;
import de.cau.cs.kieler.klodd.orthogonal.impl.ec.EmbeddingConstraint;
import de.cau.cs.kieler.core.kgraph.KNode;
import de.cau.cs.kieler.core.slimgraph.KSlimGraph;
import de.cau.cs.kieler.core.slimgraph.KSlimNode;

/**
 * A node in the graph structure used for the topology-shape-metrics approach.
 * 
 * @author <a href="mailto:msp@informatik.uni-kiel.de">Miro Sp&ouml;nemann</a>
 */
public class TSMNode extends KSlimNode {

    /**
     * Types of created node objects.
     */
    public enum Type {
        /** node derived from the layout graph. */
        LAYOUT,
        /** node created for EC expansion. */
        ECEXPANSION,
        /** node created to replace an edge crossing. */
        CROSSING,
        /** node created to replace an edge bend. */
        BEND,
        /** node for normalization, north-east corner. */
        NORM_NE,
        /** node for normalization, south-east corner. */
        NORM_SE,
        /** node for normalization, south-west corner. */
        NORM_SW,
        /** node for normalization, north-west corner. */
        NORM_NW,
        /** node for normalization, port. */
        NORM_PORT,
        /** node for refinement. */
        REFINEMENT
    }

    /** the type of this node. */
    public Type type;
    /** the embedding constraint for planarization of this node. */
    public EmbeddingConstraint embeddingConstraint;
    /** abstract x coordinate position. */
    public int abstrXpos;
    /** abstract y coordinate position. */
    public int abstrYpos;

    /**
     * Creates a node containing the given object.
     * 
     * @param graph the graph to which the new node shall be added
     * @param thetype node type
     * @param obj the object to be contained
     */
    public TSMNode(final KSlimGraph graph, final Type thetype, final Object obj) {
        super(graph, obj);
        this.type = thetype;
    }

    /**
     * Creates a node containing no object.
     * 
     * @param graph the graph to which the new node shall be added
     * @param thetype node type
     */
    public TSMNode(final KSlimGraph graph, final Type thetype) {
        super(graph);
        this.type = thetype;
    }

    /**
     * Applies the new layout to the original layout node.
     * 
     * @param offsetX x offset to be added
     * @param offsetY y offset to be added
     */
    public void applyLayout(final float offsetX, final float offsetY) {
        if (getObject() instanceof KNode) {
            KNode layoutNode = (KNode) getObject();
            KShapeLayout nodeLayout = KimlLayoutUtil.getShapeLayout(layoutNode);
            nodeLayout.setXpos(getXpos() + offsetX);
            nodeLayout.setYpos(getYpos() + offsetY);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        String baseString = super.toString();
        if (getObject() instanceof KNode) {
            return baseString + " \"" + ((KNode) getObject()).getLabel().getText() + "\"";
        } else {
            return baseString + " " + type.toString();
        }
    }

}

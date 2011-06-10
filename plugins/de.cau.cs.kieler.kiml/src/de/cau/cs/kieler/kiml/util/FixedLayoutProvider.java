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
package de.cau.cs.kieler.kiml.util;

import de.cau.cs.kieler.core.alg.IKielerProgressMonitor;
import de.cau.cs.kieler.core.kgraph.KEdge;
import de.cau.cs.kieler.core.kgraph.KLabel;
import de.cau.cs.kieler.core.kgraph.KNode;
import de.cau.cs.kieler.core.kgraph.KPort;
import de.cau.cs.kieler.core.math.KVector;
import de.cau.cs.kieler.core.math.KVectorChain;
import de.cau.cs.kieler.core.math.KielerMath;
import de.cau.cs.kieler.kiml.AbstractLayoutProvider;
import de.cau.cs.kieler.kiml.klayoutdata.KEdgeLayout;
import de.cau.cs.kieler.kiml.klayoutdata.KInsets;
import de.cau.cs.kieler.kiml.klayoutdata.KPoint;
import de.cau.cs.kieler.kiml.klayoutdata.KShapeLayout;
import de.cau.cs.kieler.kiml.options.LayoutOptions;

/**
 * A layout provider that sets fixed positions for all elements. Elements that have no position
 * option attached just stay where they are.
 *
 * @kieler.rating 2011-01-13 proposed yellow msp
 * @author msp
 */
public class FixedLayoutProvider extends AbstractLayoutProvider {

    /** the layout provider id. */
    public static final String ID = "de.cau.cs.kieler.fixed";
    
    /** default value for border spacing. */
    private static final float DEF_BORDER_SPACING = 15.0f;
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void doLayout(final KNode layoutNode, final IKielerProgressMonitor progressMonitor) {
        progressMonitor.begin("Fixed Layout", 1);
        float maxx = 0, maxy = 0;
        
        for (KNode node : layoutNode.getChildren()) {
            KShapeLayout nodeLayout = node.getData(KShapeLayout.class);
            // set the fixed position of the node, or leave it as it is
            KVector pos = nodeLayout.getProperty(LayoutOptions.POSITION);
            if (pos == null) {
                nodeLayout.setProperty(LayoutOptions.NO_LAYOUT, true);
            } else {
                nodeLayout.setXpos((float) pos.x);
                nodeLayout.setYpos((float) pos.y);
                // set the fixed size of the node
                if (!nodeLayout.getProperty(LayoutOptions.FIXED_SIZE)) {
                    float width = nodeLayout.getProperty(LayoutOptions.MIN_WIDTH);
                    if (width > 0) {
                        nodeLayout.setWidth(width);
                    }
                    float height = nodeLayout.getProperty(LayoutOptions.MIN_HEIGHT);
                    if (height > 0) {
                        nodeLayout.setHeight(height);
                    }
                }
            }
            
            // set the fixed position of the node label, or leave it as it is
            KShapeLayout labelLayout = node.getLabel().getData(KShapeLayout.class);
            pos = labelLayout.getProperty(LayoutOptions.POSITION);
            if (pos != null) {
                labelLayout.setXpos((float) pos.x);
                labelLayout.setYpos((float) pos.y);
                labelLayout.setProperty(LayoutOptions.NO_LAYOUT, false);
            }
            maxx = KielerMath.maxf(maxx, nodeLayout.getXpos() + nodeLayout.getWidth(),
                    nodeLayout.getXpos() + labelLayout.getXpos() + labelLayout.getWidth());
            maxy = KielerMath.maxf(maxy, nodeLayout.getYpos() + nodeLayout.getHeight(),
                    nodeLayout.getYpos() + labelLayout.getYpos() + labelLayout.getHeight());
            
            // set the fixed position of the ports, or leave them as they are
            for (KPort port : node.getPorts()) {
                KShapeLayout portLayout = port.getData(KShapeLayout.class);
                pos = portLayout.getProperty(LayoutOptions.POSITION);
                if (pos == null) {
                    portLayout.setProperty(LayoutOptions.NO_LAYOUT, true);
                } else {
                    portLayout.setXpos((float) pos.x);
                    portLayout.setYpos((float) pos.y);
                }
                
                // set the fixed position of the port label, or leave it as it is
                labelLayout = port.getLabel().getData(KShapeLayout.class);
                pos = labelLayout.getProperty(LayoutOptions.POSITION);
                if (pos != null) {
                    labelLayout.setXpos((float) pos.x);
                    labelLayout.setYpos((float) pos.y);
                    labelLayout.setProperty(LayoutOptions.NO_LAYOUT, false);
                }
                float portx = nodeLayout.getXpos() + portLayout.getXpos();
                float porty = nodeLayout.getYpos() + portLayout.getYpos();
                maxx = KielerMath.maxf(maxx, portx + portLayout.getWidth(),
                        portx + labelLayout.getXpos() + labelLayout.getWidth());
                maxy = KielerMath.maxf(maxy, porty + portLayout.getHeight(),
                        porty + labelLayout.getYpos() + labelLayout.getHeight());
            }
            
            // set fixed routing for the connected edges, or leave them as they are
            for (KEdge edge : node.getOutgoingEdges()) {
                KVector maxv = processEdge(edge);
                maxx = Math.max(maxx, (float) maxv.x);
                maxy = Math.max(maxy, (float) maxv.y);
            }
            for (KEdge edge : node.getIncomingEdges()) {
                if (edge.getSource().getParent() != layoutNode) {
                    KVector maxv = processEdge(edge);
                    maxx = Math.max(maxx, (float) maxv.x);
                    maxy = Math.max(maxy, (float) maxv.y);
                }
            }
        }
        
        // set size of the parent node
        KShapeLayout parentLayout = layoutNode.getData(KShapeLayout.class);
        float borderSpacing = parentLayout.getProperty(LayoutOptions.BORDER_SPACING);
        if (borderSpacing < 0) {
            borderSpacing = DEF_BORDER_SPACING;
        }
        KInsets insets = parentLayout.getInsets();
        parentLayout.setWidth(maxx + borderSpacing + insets.getLeft() + insets.getRight());
        parentLayout.setHeight(maxy + borderSpacing + insets.getTop() + insets.getBottom());
        
        progressMonitor.done();
    }
    
    /**
     * Process an edge and its labels.
     * 
     * @param edge an edge
     */
    private KVector processEdge(final KEdge edge) {
        KEdgeLayout edgeLayout = edge.getData(KEdgeLayout.class);
        KVectorChain bendPoints = edgeLayout.getProperty(LayoutOptions.BEND_POINTS);
        if (bendPoints == null || bendPoints.size() < 2) {
            edgeLayout.setProperty(LayoutOptions.NO_LAYOUT, true);
        } else {
            KimlUtil.applyVectorChain(edgeLayout, bendPoints);
        }
        
        // determine maximal coordinates
        KVector maxv = new KVector();
        for (KPoint point : edgeLayout.getBendPoints()) {
            maxv.x = Math.max(maxv.x, point.getX());
            maxv.y = Math.max(maxv.y, point.getY());
        }
        
        for (KLabel label : edge.getLabels()) {
            KShapeLayout labelLayout = label.getData(KShapeLayout.class);
            KVector pos = labelLayout.getProperty(LayoutOptions.POSITION);
            // edge labels are excluded from layout by default
            if (pos != null) {
                labelLayout.setXpos((float) pos.x);
                labelLayout.setYpos((float) pos.y);
                labelLayout.setProperty(LayoutOptions.NO_LAYOUT, false);
            }
            maxv.x = Math.max(maxv.x, labelLayout.getXpos() + labelLayout.getWidth());
            maxv.y = Math.max(maxv.y, labelLayout.getYpos() + labelLayout.getHeight());
        }
        return maxv;
    }

}

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
package de.cau.cs.kieler.kiml.grana.analyses;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import de.cau.cs.kieler.core.KielerException;
import de.cau.cs.kieler.core.alg.IKielerProgressMonitor;
import de.cau.cs.kieler.core.kgraph.KEdge;
import de.cau.cs.kieler.core.kgraph.KNode;
import de.cau.cs.kieler.kiml.grana.IAnalysis;
import de.cau.cs.kieler.kiml.grana.MinAvgMaxResult;
import de.cau.cs.kieler.kiml.klayoutdata.KEdgeLayout;
import de.cau.cs.kieler.kiml.klayoutdata.KPoint;
import de.cau.cs.kieler.kiml.util.KimlUtil;

/**
 * A graph analysis that computes the minimum, average and maximum edge length.
 * It assumes that the edge bend points describe polylines (splines are not
 * supported).
 * 
 * @author mri
 */
public class EdgeLengthAnalysis implements IAnalysis {

    /**
     * Computes the length of the given edge.
     * 
     * @param edge
     *            the edge
     * @return the length
     */
    private float computeEdgeLength(final KEdge edge) {
        KEdgeLayout edgeLayout = KimlUtil.getEdgeLayout(edge);
        float edgeLength = 0;
        KPoint current = edgeLayout.getSourcePoint();
        for (KPoint point : edgeLayout.getBendPoints()) {
            float deltaX = current.getX() - point.getX();
            float deltaY = current.getY() - point.getY();
            edgeLength += Math.sqrt(deltaX * deltaX + deltaY * deltaY);
            current = point;
        }
        float deltaX = current.getX() - edgeLayout.getTargetPoint().getX();
        float deltaY = current.getY() - edgeLayout.getTargetPoint().getY();
        edgeLength += Math.sqrt(deltaX * deltaX + deltaY * deltaY);
        return edgeLength;
    }

    /**
     * {@inheritDoc}
     */
    public Object doAnalysis(final KNode parentNode,
            final Map<String, Object> results,
            final IKielerProgressMonitor progressMonitor)
            throws KielerException {
        progressMonitor.begin("Edge Length analysis", 1);

        int numberOfEdges = 0;
        float overallEdgeLength = 0;
        float minEdgeLength = Float.MAX_VALUE;
        float maxEdgeLength = 0;
        List<KNode> nodes = new LinkedList<KNode>();
        nodes.add(parentNode);
        while (nodes.size() > 0) {
            // pop first element
            KNode node = nodes.remove(0);
            // compute edge length for all outgoing edges
            numberOfEdges += node.getOutgoingEdges().size();
            for (KEdge edge : node.getOutgoingEdges()) {
                float edgeLength = computeEdgeLength(edge);
                overallEdgeLength += edgeLength;
                // min edge length
                if (edgeLength < minEdgeLength) {
                    minEdgeLength = edgeLength;
                }
                // max edge length
                if (edgeLength > maxEdgeLength) {
                    maxEdgeLength = edgeLength;
                }
            }
            nodes.addAll(node.getChildren());
        }

        progressMonitor.done();

        if (numberOfEdges > 0) {
            return new MinAvgMaxResult<Float, Float>(minEdgeLength,
                    overallEdgeLength / (float) numberOfEdges, maxEdgeLength);
        } else {
            return new MinAvgMaxResult<Integer, Float>(0, 0.0f, 0);
        }
    }

}

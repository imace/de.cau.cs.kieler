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
/**
 *
 */
package de.cau.cs.kieler.kiml.evol.grana;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import org.eclipse.emf.common.util.EList;

import de.cau.cs.kieler.core.KielerException;
import de.cau.cs.kieler.core.alg.IKielerProgressMonitor;
import de.cau.cs.kieler.core.kgraph.KEdge;
import de.cau.cs.kieler.core.kgraph.KNode;
import de.cau.cs.kieler.kiml.grana.IAnalysis;
import de.cau.cs.kieler.kiml.klayoutdata.KShapeLayout;

/**
 * Experimental upwardness metric. Measures the fraction of upward edges. A more
 * sophisticated, fuzzy metric would take angles into account, so that for
 * example an edge that is pointing diagonally upward would be counted as a
 * "50% upward" edge.
 *
 * @author bdu
 *
 */
public class UpwardnessMetric implements IAnalysis {

    /**
     * {@inheritDoc}
     */
    public Object doAnalysis(
            final KNode parentNode, final Map<String, Object> results,
            final IKielerProgressMonitor progressMonitor) throws KielerException {

        progressMonitor.begin("Upwardness metric analysis", 1);

        final Float result;

        try {
            final Queue<KNode> nodes = new LinkedList<KNode>();
            final List<KEdge> totalEdges = new LinkedList<KEdge>();
            final List<KEdge> upwardEdges = new LinkedList<KEdge>();

            nodes.add(parentNode);
            while (!nodes.isEmpty()) {
                final KNode current = nodes.remove();

                final EList<KEdge> edges = current.getOutgoingEdges();

                final KShapeLayout currentLayout = current.getData(KShapeLayout.class);
                final float currentXpos = currentLayout.getXpos();
                final float currentYpos = currentLayout.getYpos();

                for (final KEdge edge : edges) {
                    totalEdges.add(edge);
                    final KNode target = edge.getTarget();

                    final KShapeLayout targetLayout = target.getData(KShapeLayout.class);
                    final float targetXpos = targetLayout.getXpos();
                    final float targetYpos = targetLayout.getYpos();

                    if (targetYpos < currentYpos) {
                        // this is an upward edge
                        upwardEdges.add(edge);
                    }
                }

                nodes.addAll(current.getChildren());
            }

            result = Float.valueOf(((float) upwardEdges.size() / totalEdges.size()));

        } finally {
            progressMonitor.done();
        }

        return result;
    }
}

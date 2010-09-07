/*
 * KIELER - Kiel Integrated Environment for Layout Eclipse RichClient
 *
 * http://www.informatik.uni-kiel.de/rtsys/kieler/
 *
 * Copyright 2010 by + Christian-Albrechts-University of Kiel + Department of
 * Computer Science + Real-Time and Embedded Systems Group
 *
 * This code is provided under the terms of the Eclipse Public License (EPL).
 * See the file epl-v10.html for the license text.
 */
package de.cau.cs.kieler.kiml.evol.grana;

import java.util.Map;

import org.eclipse.core.runtime.Assert;

import de.cau.cs.kieler.core.KielerException;
import de.cau.cs.kieler.core.alg.IKielerProgressMonitor;
import de.cau.cs.kieler.core.kgraph.KNode;
import de.cau.cs.kieler.kiml.grana.IAnalysis;

/**
 * Calculates a metric for the number of bends in the graph. This depends on
 * Grana edgeCount and Grana bendpointCount that care for hierarchies.
 *
 * @author mri
 * @author bdu
 */
public class BendsMetric implements IAnalysis {

    /**
     *
     */
    private static final String GRANA_BENDPOINT_COUNT =
            "de.cau.cs.kieler.kiml.grana.bendpointCount";
    /**
     *
     */
    private static final String GRANA_EDGE_COUNT = "de.cau.cs.kieler.kiml.grana.edgeCount";

    /**
     * {@inheritDoc}
     */
    public Object doAnalysis(
            final KNode parentNode, final Map<String, Object> results,
            final IKielerProgressMonitor progressMonitor) throws KielerException {

        progressMonitor.begin("Bend metric analysis", 1);

        Float result;
        try {
            // load numbers from analyses
            final Object edgesResult = results.get(GRANA_EDGE_COUNT);
            final Object bendsResult = results.get(GRANA_BENDPOINT_COUNT);
            final int edgesCount = ((Integer) edgesResult).intValue();
            final int bendsCount = ((Integer) bendsResult).intValue();

            // System.out.println("edges: " + edgesCount + " bends: " +
            // bendsCount);

            // FIXME: For some reason, the bends count in the layout graph may
            // be reduced after the layout is applied. This means the result
            // that is produced by auto-rating differs from the information
            // shown in the Grana dialog. However, this seems to happen only for
            // graphs that contain self-loops.

            // normalize
            if (edgesCount + bendsCount > 0) {
                result =
                        Float.valueOf(1.0f - (float) bendsCount
                                / (float) (edgesCount + bendsCount));
            } else {
                result = Float.valueOf(1.0f);
            }
            Assert.isTrue((0.0f <= result.floatValue()) && (result.floatValue() <= 1.0f),
                    "Metric result out of bounds: " + result);

        } finally {
            progressMonitor.done();
        }

        return result;
    }

}

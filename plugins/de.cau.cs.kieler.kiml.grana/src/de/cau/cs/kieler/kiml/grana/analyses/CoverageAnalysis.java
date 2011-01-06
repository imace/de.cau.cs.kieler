/*
 * KIELER - Kiel Integrated Environment for Layout Eclipse RichClient
 *
 * http://www.informatik.uni-kiel.de/rtsys/kieler/
 * 
 * Copyright 2011 by
 * + Christian-Albrechts-University of Kiel
 *   + Department of Computer Science
 *     + Real-Time and Embedded Systems Group
 * 
 * This code is provided under the terms of the Eclipse Public License (EPL).
 * See the file epl-v10.html for the license text.
 */

package de.cau.cs.kieler.kiml.grana.analyses;

import java.util.Map;

import org.eclipse.emf.common.util.EList;

import de.cau.cs.kieler.core.KielerException;
import de.cau.cs.kieler.core.alg.IKielerProgressMonitor;
import de.cau.cs.kieler.core.kgraph.KNode;
import de.cau.cs.kieler.kiml.grana.AnalysisFailed;
import de.cau.cs.kieler.kiml.grana.IAnalysis;


/**
 * An analysis that computes the percentage of the drawing area that is covered by nodes
 * and insets. The higher this value is to 1.0, the more effectively packed the layout is.
 * This analysis depends on {@link AreaAnalysis} and {@link NodeSizeAnalysis}. Returns a
 * single-component result {@code (float coverage)}.
 * 
 * @author cds
 */
public class CoverageAnalysis implements IAnalysis {

    /**
     * {@inheritDoc}
     */
    public Object doAnalysis(final KNode parentNode, final Map<String, Object> results,
            final IKielerProgressMonitor progressMonitor) throws KielerException {
        
        progressMonitor.begin("Node Coverage Analysis", 1);

        // Fetch the results of the area and node size analysis
        Object areaResult = results.get(AreaAnalysis.ANALYSIS_ID);
        Object nodeSizeResult = results.get(NodeSizeAnalysis.ANALYSIS_ID);
        if (areaResult == null || nodeSizeResult == null) {
            progressMonitor.done();
            
            return new AnalysisFailed(AnalysisFailed.Type.Dependency);
        }
        
        Object[] areaResultArray = (Object[]) areaResult;
        Object[] nodeSizeResultArray = (Object[]) nodeSizeResult;
        
        // Extract the values we need
        float area = ((Integer) areaResultArray[AreaAnalysis.INDEX_WIDTH])
            * ((Integer) areaResultArray[AreaAnalysis.INDEX_HEIGHT]);
        int nodes = (Integer) nodeSizeResultArray[NodeSizeAnalysis.INDEX_NODES];
        float avgNodeSize = (Float) nodeSizeResultArray[NodeSizeAnalysis.INDEX_AVG];
        
        // The only thing that this analysis don't capture are the area taken up by
        // compound nodes (the actual node graphics and the insets defining the area
        // where child nodes cannot be placed)
        float compoundArea = computeCompoundArea(parentNode);
        
        // Compute the node coverage
        float nodeCoverage = (avgNodeSize * nodes + compoundArea) / area;
        
        progressMonitor.done();
        
        return nodeCoverage;
    }

    /**
     * Computes the space taken up by compound nodes that cannot be used for child nodes.
     * 
     * @param parentNode the root of the graph.
     * @return the area taken up by insets.
     */
    private float computeCompoundArea(final KNode parentNode) {
        float insetsArea = 0.0f;
        EList<KNode> children = parentNode.getChildren();
        
        if (!children.isEmpty()) {
            // TODO The node is a compound node; compute its space requirements
            
            // Iterate through the children
            for (KNode child : children) {
                insetsArea += computeCompoundArea(child);
            }
        }
        
        return insetsArea;
    }
}

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
package de.cau.cs.kieler.klay.layered.p5edges;

import java.util.EnumSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import de.cau.cs.kieler.core.alg.AbstractAlgorithm;
import de.cau.cs.kieler.kiml.options.LayoutOptions;
import de.cau.cs.kieler.klay.layered.ILayoutPhase;
import de.cau.cs.kieler.klay.layered.IntermediateProcessingStrategy;
import de.cau.cs.kieler.klay.layered.graph.LNode;
import de.cau.cs.kieler.klay.layered.graph.Layer;
import de.cau.cs.kieler.klay.layered.graph.LayeredGraph;
import de.cau.cs.kieler.klay.layered.intermediate.IntermediateLayoutProcessor;
import de.cau.cs.kieler.klay.layered.properties.GraphProperties;
import de.cau.cs.kieler.klay.layered.properties.Properties;

/**
 * Edge routing implementation that creates orthogonal bend points. Inspired by
 * <ul>
 *   <li>Georg Sander. Layout of directed hypergraphs with orthogonal hyperedges. In
 *     <i>Proceedings of the 11th International Symposium on Graph Drawing (GD '03)</i>,
 *     volume 2912 of LNCS, pp. 381-386. Springer, 2004.</li>
 *   <li>Giuseppe di Battista, Peter Eades, Roberto Tamassia, Ioannis G. Tollis,
 *     <i>Graph Drawing: Algorithms for the Visualization of Graphs</i>,
 *     Prentice Hall, New Jersey, 1999 (Section 9.4, for cycle breaking in the
 *     hyperedge segment graph)
 * </ul>
 * 
 * <dl>
 *   <dt>Precondition:</dt><dd>the graph has a proper layering with
 *     assigned node and port positions; the size of each layer is
 *     correctly set; edges connected to ports on strange sides were
 *     processed</dd>
 *   <dt>Postcondition:</dt><dd>each node is assigned a horizontal coordinate;
 *     the bend points of each edge are set; the width of the whole graph is set</dd>
 * </dl>
 *
 * @author msp
 * @author cds
 */
public class OrthogonalEdgeRouter extends AbstractAlgorithm implements ILayoutPhase {
    
    /** intermediate processing strategy for basic graphs. */
    private static final IntermediateProcessingStrategy BASELINE_PROCESSING_STRATEGY =
        new IntermediateProcessingStrategy(
                // Before Phase 1
                null,
                
                // Before Phase 2
                null,
                
                // Before Phase 3
                /* For non-free ports:
                 *  - NORTH_SOUTH_PORT_PREPROCESSOR
                 *  - ODD_PORT_SIDE_PROCESSOR
                 * 
                 * For self-loops:
                 *  - EXTERNAL_PORT_CONSTRAINT_PROCESSOR
                 *  - SELF_LOOP_PROCESSOR
                 */
                null,
                
                // Before Phase 4
                EnumSet.of(
                        IntermediateLayoutProcessor.HYPEREDGE_DUMMY_MERGER,
                        IntermediateLayoutProcessor.NODE_MARGIN_CALCULATOR),
                
                // Before Phase 5
                /* For self-loops:
                 *  - EXTERNAL_PORT_DUMMY_SIZE_PROCESSOR
                 */
                null,
                
                // After Phase 5
                /* For non-free ports:
                 *  - NORTH_SOUTH_PORT_POSTPROCESSOR
                 * 
                 * For external ports:
                 *  - EXTERNAL_PORT_ORTHOGONAL_EDGE_ROUTER
                 */
                null);
    
    /** additional processor dependencies for graphs with non-free ports. */
    private static final IntermediateProcessingStrategy NON_FREE_PORT_PROCESSING_ADDITIONS =
        new IntermediateProcessingStrategy(IntermediateProcessingStrategy.BEFORE_PHASE_3,
                IntermediateLayoutProcessor.ODD_PORT_SIDE_PROCESSOR);
    
    /** additional processor dependencies for graphs with northern / southern non-free ports. */
    private static final IntermediateProcessingStrategy NORTH_SOUTH_PORT_PROCESSING_ADDITIONS =
        new IntermediateProcessingStrategy(
                // Before Phase 1
                null,
                
                // Before Phase 2
                null,
                
                // Before Phase 3
                EnumSet.of(IntermediateLayoutProcessor.NORTH_SOUTH_PORT_PREPROCESSOR),
                
                // Before Phase 4
                null,
                
                // Before Phase 5
                null,
                
                // After Phase 5
                EnumSet.of(IntermediateLayoutProcessor.NORTH_SOUTH_PORT_POSTPROCESSOR));
    
    /** additional processor dependencies for graphs with external ports. */
    private static final IntermediateProcessingStrategy EXTERNAL_PORT_PROCESSING_ADDITIONS =
        new IntermediateProcessingStrategy(
                // Before Phase 1
                null,
                
                // Before Phase 2
                null,
                
                // Before Phase 3
                EnumSet.of(IntermediateLayoutProcessor.EXTERNAL_PORT_CONSTRAINT_PROCESSOR),
                
                // Before Phase 4
                null,
                
                // Before Phase 5
                EnumSet.of(IntermediateLayoutProcessor.EXTERNAL_PORT_DUMMY_SIZE_PROCESSOR),
                
                // After Phase 5
                EnumSet.of(IntermediateLayoutProcessor.EXTERNAL_PORT_ORTHOGONAL_EDGE_ROUTER));
    
    /** additional processor dependencies for graphs with self-loops. */
    private static final IntermediateProcessingStrategy SELF_LOOP_PROCESSING_ADDITIONS =
        new IntermediateProcessingStrategy(IntermediateProcessingStrategy.BEFORE_PHASE_3,
                IntermediateLayoutProcessor.SELF_LOOP_PROCESSOR);
    
    
    /**
     * {@inheritDoc}
     */
    public IntermediateProcessingStrategy getIntermediateProcessingStrategy(final LayeredGraph graph) {
        Set<GraphProperties> graphProperties = graph.getProperty(Properties.GRAPH_PROPERTIES);
        
        // Basic strategy
        IntermediateProcessingStrategy strategy = new IntermediateProcessingStrategy(
                BASELINE_PROCESSING_STRATEGY);
        
        // Additional dependencies
        if (graphProperties.contains(GraphProperties.NON_FREE_PORTS)) {
            strategy.addAll(NON_FREE_PORT_PROCESSING_ADDITIONS);

            if (graphProperties.contains(GraphProperties.NORTH_SOUTH_PORTS)) {
                strategy.addAll(NORTH_SOUTH_PORT_PROCESSING_ADDITIONS);
            }
        }

        if (graphProperties.contains(GraphProperties.EXTERNAL_PORTS)) {
            strategy.addAll(EXTERNAL_PORT_PROCESSING_ADDITIONS);
        }

        if (graphProperties.contains(GraphProperties.SELF_LOOPS)) {
            strategy.addAll(SELF_LOOP_PROCESSING_ADDITIONS);
        }
        
        return strategy;
    }
    
    /**
     * {@inheritDoc}
     */
    public void process(final LayeredGraph layeredGraph) {
        getMonitor().begin("Orthogonal edge routing", 1);
        
        // Retrieve some generic values
        double nodeSpacing = layeredGraph.getProperty(Properties.OBJ_SPACING);
        double edgeSpacing = nodeSpacing * layeredGraph.getProperty(Properties.EDGE_SPACING_FACTOR);
        boolean debug = layeredGraph.getProperty(LayoutOptions.DEBUG_MODE);
        
        // Prepare for iteration!
        OrthogonalRoutingGenerator routingGenerator = new OrthogonalRoutingGenerator(
                new OrthogonalRoutingGenerator.WestToEastRoutingStrategy(), edgeSpacing,
                debug ? "phase5" : null);
        float xpos = 0.0f;
        ListIterator<Layer> layerIter = layeredGraph.getLayers().listIterator();
        Layer leftLayer = null;
        Layer rightLayer = null;
        List<LNode> leftLayerNodes = null;
        List<LNode> rightLayerNodes = null;
        int leftLayerIndex = -1;
        int rightLayerIndex = -1;
        
        // Iterate!
        do {
            int slotsCount;
            
            // Fetch the next layer, if any
            rightLayer = layerIter.hasNext() ? layerIter.next() : null;
            rightLayerNodes = rightLayer == null ? null : rightLayer.getNodes();
            rightLayerIndex = layerIter.previousIndex();
            
            // Place the left layer's nodes, if any
            if (leftLayer != null) {
                leftLayer.placeNodes(xpos);
                xpos += leftLayer.getSize().x + nodeSpacing;
            }
            
            // Route edges between the two layers
            slotsCount = routingGenerator.routeEdges(layeredGraph, leftLayerNodes, leftLayerIndex,
                    rightLayerNodes, xpos);
            if (slotsCount > 0) {
                xpos += slotsCount * edgeSpacing - edgeSpacing + nodeSpacing;
            }
            
            leftLayer = rightLayer;
            leftLayerNodes = rightLayerNodes;
            leftLayerIndex = rightLayerIndex;
        } while (rightLayer != null);
        
        layeredGraph.getSize().x = xpos;
        
        getMonitor().done();
    }
    
}

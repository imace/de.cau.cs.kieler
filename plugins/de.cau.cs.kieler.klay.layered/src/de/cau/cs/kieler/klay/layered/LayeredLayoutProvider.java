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
package de.cau.cs.kieler.klay.layered;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import de.cau.cs.kieler.core.alg.BasicProgressMonitor;
import de.cau.cs.kieler.core.alg.IKielerProgressMonitor;
import de.cau.cs.kieler.core.kgraph.KNode;
import de.cau.cs.kieler.kiml.AbstractLayoutProvider;
import de.cau.cs.kieler.kiml.klayoutdata.KShapeLayout;
import de.cau.cs.kieler.kiml.options.LayoutOptions;
import de.cau.cs.kieler.kiml.util.IDebugCanvas;
import de.cau.cs.kieler.klay.layered.graph.LayeredGraph;
import de.cau.cs.kieler.klay.layered.intermediate.IntermediateLayoutProcessor;
import de.cau.cs.kieler.klay.layered.p1cycles.GreedyCycleBreaker;
import de.cau.cs.kieler.klay.layered.p2layers.LongestPathLayerer;
import de.cau.cs.kieler.klay.layered.p2layers.NetworkSimplexLayerer;
import de.cau.cs.kieler.klay.layered.p2layers.LayeringStrategy;
import de.cau.cs.kieler.klay.layered.p3order.LayerSweepCrossingMinimizer;
import de.cau.cs.kieler.klay.layered.p4nodes.LinearSegmentsNodePlacer;
import de.cau.cs.kieler.klay.layered.p5edges.ComplexSplineEdgeRouter;
import de.cau.cs.kieler.klay.layered.p5edges.EdgeRoutingStrategy;
import de.cau.cs.kieler.klay.layered.p5edges.OrthogonalEdgeRouter;
import de.cau.cs.kieler.klay.layered.p5edges.PolylineEdgeRouter;
import de.cau.cs.kieler.klay.layered.p5edges.SimpleSplineEdgeRouter;
import de.cau.cs.kieler.klay.layered.properties.GraphProperties;
import de.cau.cs.kieler.klay.layered.properties.Properties;

/**
 * Layout provider to connect the layered layouter to the Eclipse based layout services.
 * 
 * <p>The layered layouter works with five main phases: cycle breaking, layering, crossing
 * minimization, node placement and edge routing. Before these phases and after the last
 * phase, so called intermediate layout processors can be inserted that do some kind of
 * pre or post processing. Implementations of the different main phases specify the
 * intermediate layout processors they require, which are automatically collected and
 * inserted between the main phases. The layout provider itself also specifies some
 * dependencies.</p>
 * 
 * <pre>
 *           Intermediate Layout Processors
 * ---------------------------------------------------
 * |         |         |         |         |         |
 * |   ---   |   ---   |   ---   |   ---   |   ---   |
 * |   | |   |   | |   |   | |   |   | |   |   | |   |
 * |   | |   |   | |   |   | |   |   | |   |   | |   |
 *     | |       | |       | |       | |       | |
 *     | |       | |       | |       | |       | |
 *     ---       ---       ---       ---       ---
 *   Phase 1   Phase 2   Phase 3   Phase 4   Phase 5
 * </pre>
 * 
 * @see ILayoutPhase
 * @see ILayoutProcessor
 * 
 * @author msp
 * @author cds
 */
public class LayeredLayoutProvider extends AbstractLayoutProvider {
    
    ///////////////////////////////////////////////////////////////////////////////
    // Processing Strategy Constants
    
    /** intermediate processing strategy for basic graphs. */
    private static final IntermediateProcessingStrategy BASELINE_PROCESSING_STRATEGY =
        new IntermediateProcessingStrategy(
                // Before Phase 1
                null,
                
                // Before Phase 2
                null,
                
                // Before Phase 3
                /* For flattened hierarchical graphs:
                 *  - COMPOUND_DUMMY_EDGE_REMOVER
                 */
                EnumSet.of(IntermediateLayoutProcessor.PORT_LIST_SORTER,
                           IntermediateLayoutProcessor.PORT_SIDE_PROCESSOR),
                
                // Before Phase 4
                EnumSet.of(IntermediateLayoutProcessor.NODE_MARGIN_CALCULATOR,
                           IntermediateLayoutProcessor.PORT_POSITION_PROCESSOR),
                
                // Before Phase 5
                null,
                
                // After Phase 5
                null);
    
    /** additional processor dependencies for flattened hierarchical graphs. */
    private static final IntermediateProcessingStrategy FLATTENED_HIERARCHY_PROCESSING_ADDITIONS =
        new IntermediateProcessingStrategy(IntermediateProcessingStrategy.BEFORE_PHASE_3,
                IntermediateLayoutProcessor.COMPOUND_DUMMY_EDGE_REMOVER);

    
    ///////////////////////////////////////////////////////////////////////////////
    // Variables

    /** phase 1: cycle breaking module. */
    private ILayoutPhase cycleBreaker = new GreedyCycleBreaker();
    /** phase 2: layering module. */
    private ILayoutPhase layerer;
    /** phase 3: crossing minimization module. */
    private ILayoutPhase crossingMinimizer = new LayerSweepCrossingMinimizer();
    /** phase 4: node placement module. */
    private ILayoutPhase nodePlacer = new LinearSegmentsNodePlacer();
    /** phase 5: Edge routing module. */
    private ILayoutPhase edgeRouter;
    
    /** connected components processor. */
    private ComponentsProcessor componentsProcessor = new ComponentsProcessor();
    /** intermediate layout processor strategy. */
    private IntermediateProcessingStrategy intermediateProcessingStrategy =
        new IntermediateProcessingStrategy();
    /** collection of instantiated intermediate modules. */
    private Map<IntermediateLayoutProcessor, ILayoutProcessor> intermediateLayoutProcessorCache =
        new HashMap<IntermediateLayoutProcessor, ILayoutProcessor>();
    
    /** list of layout processors that compose the current algorithm. */
    private List<ILayoutProcessor> algorithm = new LinkedList<ILayoutProcessor>();
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void doLayout(final KNode kgraph, final IKielerProgressMonitor progressMonitor) {
        progressMonitor.begin("Layered layout", 1);

        // transform the input graph
        IGraphImporter<KNode> graphImporter = new KGraphImporter();
        LayeredGraph layeredGraph = graphImporter.importGraph(kgraph);

        // set special properties for the layered graph
        setOptions(layeredGraph, kgraph);

        // update the modules depending on user options
        updateModules(layeredGraph, kgraph.getData(KShapeLayout.class));
        
        // split the input graph into components
        List<LayeredGraph> components = componentsProcessor.split(layeredGraph);

        // perform the actual layout
        for (LayeredGraph comp : components) {
            layout(comp, progressMonitor.subTask(1.0f / components.size()));
        }
        
        // pack the components back into one graph
        layeredGraph = componentsProcessor.pack(components);
        
        // apply the layout results to the original graph
        graphImporter.applyLayout(layeredGraph);

        progressMonitor.done();
    }

    
    ///////////////////////////////////////////////////////////////////////////////
    // Options and Modules Management
    
    /**
     * Set special layout options for the layered graph.
     * 
     * @param layeredGraph a new layered graph
     * @param parent the original parent node
     */
    private void setOptions(final LayeredGraph layeredGraph, final KNode parent) {
        // set the random number generator based on the random seed option
        Integer randomSeed = layeredGraph.getProperty(LayoutOptions.RANDOM_SEED);
        if (randomSeed != null) {
            int val = randomSeed;
            if (val == 0) {
                layeredGraph.setProperty(Properties.RANDOM, new Random());
            } else {
                layeredGraph.setProperty(Properties.RANDOM, new Random(val));
            }
        } else {
            layeredGraph.setProperty(Properties.RANDOM, new Random(1));
        }

        // set the debug canvas based on the debug mode option
        Boolean debugMode = layeredGraph.getProperty(LayoutOptions.DEBUG_MODE);
        if (debugMode) {
            IDebugCanvas debugCanvas = getDebugCanvas();
            layeredGraph.setProperty(Properties.DEBUG_CANVAS, debugCanvas);
            float borderSpacing = layeredGraph.getProperty(Properties.BORDER_SPACING);
            debugCanvas.setOffset(parent, borderSpacing, borderSpacing);
            debugCanvas.setBuffered(true);
        }
    }
    
    /**
     * Update the modules depending on user options.
     * 
     * @param graph the graph to be laid out.
     * @param parentLayout the parent layout data
     */
    private void updateModules(final LayeredGraph graph, final KShapeLayout parentLayout) {
        // check which layering strategy to use
        LayeringStrategy placing = parentLayout.getProperty(Properties.NODE_LAYERING);
        switch (placing) {
        case LONGEST_PATH:
            if (!(layerer instanceof LongestPathLayerer)) {
                layerer = new LongestPathLayerer();
            }
            break;
        default:
            if (!(layerer instanceof NetworkSimplexLayerer)) {
                layerer = new NetworkSimplexLayerer();
            }
        }
        
        // check which edge router to use
        EdgeRoutingStrategy routing = parentLayout.getProperty(Properties.EDGE_ROUTING);
        switch (routing) {
        case ORTHOGONAL:
            if (!(edgeRouter instanceof OrthogonalEdgeRouter)) {
                edgeRouter = new OrthogonalEdgeRouter();
            }
            break;
        case SIMPLE_SPLINES:
            if (!(edgeRouter instanceof SimpleSplineEdgeRouter)) {
                edgeRouter = new SimpleSplineEdgeRouter();
            }
            break;
        case COMPLEX_SPLINES:
            if (!(edgeRouter instanceof ComplexSplineEdgeRouter)) {
                edgeRouter = new ComplexSplineEdgeRouter();
            }
            break;
        default:
            if (!(edgeRouter instanceof PolylineEdgeRouter)) {
                edgeRouter = new PolylineEdgeRouter();
            }
        }
        
        // update intermediate processor strategy
        intermediateProcessingStrategy.clear();
        intermediateProcessingStrategy
            .addAll(cycleBreaker.getIntermediateProcessingStrategy(graph))
            .addAll(layerer.getIntermediateProcessingStrategy(graph))
            .addAll(crossingMinimizer.getIntermediateProcessingStrategy(graph))
            .addAll(nodePlacer.getIntermediateProcessingStrategy(graph))
            .addAll(edgeRouter.getIntermediateProcessingStrategy(graph))
            .addAll(this.getIntermediateProcessingStrategy(graph));
        
        // construct the list of processors that make up the algorithm
        algorithm.clear();
        algorithm.addAll(
                getIntermediateProcessorList(IntermediateProcessingStrategy.BEFORE_PHASE_1));
        algorithm.add(cycleBreaker);
        algorithm.addAll(
                getIntermediateProcessorList(IntermediateProcessingStrategy.BEFORE_PHASE_2));
        algorithm.add(layerer);
        algorithm.addAll(
                getIntermediateProcessorList(IntermediateProcessingStrategy.BEFORE_PHASE_3));
        algorithm.add(crossingMinimizer);
        algorithm.addAll(
                getIntermediateProcessorList(IntermediateProcessingStrategy.BEFORE_PHASE_4));
        algorithm.add(nodePlacer);
        algorithm.addAll(
                getIntermediateProcessorList(IntermediateProcessingStrategy.BEFORE_PHASE_5));
        algorithm.add(edgeRouter);
        algorithm.addAll(
                getIntermediateProcessorList(IntermediateProcessingStrategy.AFTER_PHASE_5));
    }
    
    /**
     * Returns a list of layout processor instances for the given intermediate layout
     * processing slot.
     * 
     * @param slotIndex the slot index. One of the constants defined in
     *                  {@link IntermediateProcessingStrategy}.
     * @return list of layout processors.
     */
    private List<ILayoutProcessor> getIntermediateProcessorList(final int slotIndex) {
        // fetch the set of layout processors configured for the given slot
        List<ILayoutProcessor> result = new LinkedList<ILayoutProcessor>();
        Set<IntermediateLayoutProcessor> processors =
            intermediateProcessingStrategy.getProcessors(slotIndex);
        
        // iterate through the layout processors and add them to the result list
        for (IntermediateLayoutProcessor processor : processors) {
            // check if an instance of the given layout processor is already in the cache
            ILayoutProcessor processorImpl = intermediateLayoutProcessorCache.get(processor);
            
            if (processorImpl == null) {
                // It's not in the cache, so create it and put it in the cache
                processorImpl = processor.create();
                intermediateLayoutProcessorCache.put(processor, processorImpl);
            }
            
            // add the layout processor to the list of processors for this slot
            result.add(processorImpl);
        }
        
        return result;
    }
    
    /**
     * Returns an intermediate processing strategy with processors not tied to
     * specific phases.
     * 
     * @param graph the layered graph to be processed. The strategy may vary
     *              depending on certain properties of the graph.
     * @return intermediate processing strategy. May be {@code null}.
     */
    private IntermediateProcessingStrategy getIntermediateProcessingStrategy(final LayeredGraph graph) {
        Set<GraphProperties> graphProperties = graph.getProperty(Properties.GRAPH_PROPERTIES);
        
        // Basic strategy
        IntermediateProcessingStrategy strategy = new IntermediateProcessingStrategy(
                BASELINE_PROCESSING_STRATEGY);
        
        // Additional dependencies
        if (graphProperties.contains(GraphProperties.FLAT_HIERARCHICAL)) {
            strategy.addAll(FLATTENED_HIERARCHY_PROCESSING_ADDITIONS);
        }
        
        return strategy;
    }

    
    ///////////////////////////////////////////////////////////////////////////////
    // Layout
    
    /**
     * Perform the five phases of the layered layouter.
     * 
     * @param graph
     *            the graph that is to be laid out
     * @param themonitor
     *            a progress monitor, or {@code null}
     */
    public void layout(final LayeredGraph graph, final IKielerProgressMonitor themonitor) {
        IKielerProgressMonitor monitor = themonitor;
        if (monitor == null) {
            monitor = new BasicProgressMonitor();
        }
        monitor.begin("Component Layout", algorithm.size());
        
        if (graph.getProperty(LayoutOptions.DEBUG_MODE)) {
            // Debug Mode!
            // Prints the algorithm configuration and outputs the whole graph to a file
            // before each slot execution
            
            System.out.println("KLay Layered uses the following " + algorithm.size() + " modules:");
            for (int i = 0; i < algorithm.size(); i++) {
                System.out.println("   Slot " + String.format("%1$02d", i) + ": "
                        + algorithm.get(i).getClass().getName());
            }

            // invoke each layout processor
            int slotIndex = 0;
            for (ILayoutProcessor processor : algorithm) {
                if (monitor.isCanceled()) {
                    return;
                }
                // Graph debug output
                try {
                    graph.writeDotGraph(createWriter(graph, slotIndex++));
                } catch (IOException e) {
                    // Do nothing.
                }
                
                processor.reset(monitor.subTask(1));
                processor.process(graph);
            }

            // Graph debug output
            try {
                graph.writeDotGraph(createWriter(graph, slotIndex++));
            } catch (IOException e) {
                // Do nothing.
            }
        } else {
            // invoke each layout processor
            for (ILayoutProcessor processor : algorithm) {
                if (monitor.isCanceled()) {
                    return;
                }
                processor.reset(monitor.subTask(1));
                processor.process(graph);
            }
        }

        monitor.done();
    }

    
    ///////////////////////////////////////////////////////////////////////////////
    // Debug
    
    /**
     * Creates a writer for the given graph. The file name to be written to is assembled
     * from the graph's hash code and the slot index.
     * 
     * @param graph the graph to be written.
     * @param slotIndex the slot before whose execution the graph is written.
     * @return file writer.
     * @throws IOException if anything goes wrong.
     */
    private Writer createWriter(final LayeredGraph graph, final int slotIndex) throws IOException {
        String path = Util.getDebugOutputPath();
        new File(path).mkdirs();
        
        String debugFileName = Util.getDebugOutputFileBaseName(graph)
                + "fulldebug-slot" + String.format("%1$02d", slotIndex);
        return new FileWriter(new File(path + File.separator + debugFileName + ".dot"));
    }

}

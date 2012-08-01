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
package de.cau.cs.kieler.klay.layered.p3order;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Random;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

import de.cau.cs.kieler.core.alg.AbstractAlgorithm;
import de.cau.cs.kieler.core.util.Pair;
import de.cau.cs.kieler.kiml.options.LayoutOptions;
import de.cau.cs.kieler.kiml.options.PortSide;
import de.cau.cs.kieler.klay.layered.ILayoutPhase;
import de.cau.cs.kieler.klay.layered.IntermediateProcessingConfiguration;
import de.cau.cs.kieler.klay.layered.graph.LEdge;
import de.cau.cs.kieler.klay.layered.graph.LNode;
import de.cau.cs.kieler.klay.layered.graph.LPort;
import de.cau.cs.kieler.klay.layered.graph.Layer;
import de.cau.cs.kieler.klay.layered.graph.LGraph;
import de.cau.cs.kieler.klay.layered.intermediate.LayoutProcessorStrategy;
import de.cau.cs.kieler.klay.layered.properties.NodeType;
import de.cau.cs.kieler.klay.layered.properties.PortType;
import de.cau.cs.kieler.klay.layered.properties.Properties;

/**
 * Crossing minimization module that performs one or more sweeps over the layers while applying a
 * two-layer crossing minimization heuristic on each pair of layers. Inspired by
 * <ul>
 * <li>Kozo Sugiyama, Shojiro Tagawa, and Mitsuhiko Toda. Methods for visual understanding of
 * hierarchical system structures. IEEE Transactions on Systems, Man and Cybernetics, 11(2):109–125,
 * February 1981.
 * <li>Michael Forster. A fast and simple heuristic for constrained two-level crossing reduction. In
 * <i>Graph Drawing</i>, volume 3383 of LNCS, pp. 206-216. Springer, 2005.</li>
 * </ul>
 * 
 * <dl>
 * <dt>Precondition:</dt>
 * <dd>The graph has a proper layering, i.e. all long edges have been splitted; all nodes have at
 * least fixed port sides.</dd>
 * <dt>Postcondition:</dt>
 * <dd>The order of nodes in each layer and the order of ports in each node are optimized to yield
 * as few edge crossings as possible</dd>
 * </dl>
 * 
 * @author msp
 * @author cds
 * @author ima
 * @kieler.design proposed by msp
 * @kieler.rating proposed yellow by msp
 */
public class LayerSweepCrossingMinimizer extends AbstractAlgorithm implements ILayoutPhase {

    /** intermediate processing configuration. */
    private static final IntermediateProcessingConfiguration INTERMEDIATE_PROCESSING_CONFIGURATION =
        new IntermediateProcessingConfiguration(
                // Before Phase 1
                null,
                // Before Phase 2
                null,
                // Before Phase 3
                EnumSet.of(LayoutProcessorStrategy.LONG_EDGE_SPLITTER),
                // Before Phase 4
                EnumSet.of(LayoutProcessorStrategy.IN_LAYER_CONSTRAINT_PROCESSOR),
                // Before Phase 5
                null,
                // After Phase 5
                EnumSet.of(LayoutProcessorStrategy.LONG_EDGE_JOINER));
    
    /**
     * {@inheritDoc}
     */
    public IntermediateProcessingConfiguration getIntermediateProcessingConfiguration(
            final LGraph graph) {
        
        return INTERMEDIATE_PROCESSING_CONFIGURATION;
    }
    
    /** array of port ranks used for sorting nodes and ports. */
    private float[] portRanks;
    /** port position array used for counting the number of edge crossings. */
    private int[] portPos;
    /** complete node order of the best layer sweep. */
    private NodeGroup[][] bestSweep;
    /** complete node order of the current layer sweep. */
    private NodeGroup[][] curSweep;
    /** complete node order of the previous layer sweep. */
    private NodeGroup[][] prevSweep;
    /** the number of in-layer edges for each layer. */
    private int[] inLayerEdgeCount;
    /** layout units represented by a single node. */
    private final Multimap<LNode, LNode> layoutUnits = HashMultimap.create();
    
    /**
     * Initialize all data for the layer sweep crossing minimizer.
     * 
     * @param layeredGraph a layered graph
     */
    private void initialize(final LGraph layeredGraph) {
        int layerCount = layeredGraph.getLayers().size();

        // Remember the best, current and previous sweep; they basically save the node oder
        // per layer for the different sweeps of the algorithm
        bestSweep = new NodeGroup[layerCount][];
        curSweep = new NodeGroup[layerCount][];
        prevSweep = new NodeGroup[layerCount][];

        inLayerEdgeCount = new int[layerCount];

        int nodeCount = 0;
        int portCount = 0;

        // Iterate through the layers, initializing port and node IDs, collecting
        // the nodes into the current sweep and building the layout unit map
        ListIterator<Layer> layerIter = layeredGraph.getLayers().listIterator();
        while (layerIter.hasNext()) {
            Layer layer = layerIter.next();

            int layerIndex = layerIter.previousIndex();
            int layerNodeCount = layer.getNodes().size();

            // Initialize this layer's node arrays in the different sweeps
            bestSweep[layerIndex] = new NodeGroup[layerNodeCount];
            prevSweep[layerIndex] = new NodeGroup[layerNodeCount];
            curSweep[layerIndex] = new NodeGroup[layerNodeCount];
            inLayerEdgeCount[layerIndex] = 0;

            ListIterator<LNode> nodeIter = layer.getNodes().listIterator();
            while (nodeIter.hasNext()) {
                LNode node = nodeIter.next();

                NodeGroup nodeGroup = new NodeGroup(node);
                curSweep[layerIndex][nodeIter.previousIndex()] = nodeGroup;
                node.id = nodeCount++;
                node.setProperty(Properties.NODE_GROUP, nodeGroup);
                LNode layoutUnit = node.getProperty(Properties.IN_LAYER_LAYOUT_UNIT);
                if (layoutUnit != null) {
                    layoutUnits.put(layoutUnit, node);
                }

                for (LPort port : node.getPorts()) {
                    port.id = portCount++;
                    for (LEdge edge : port.getOutgoingEdges()) {
                        if (edge.getTarget().getNode().getLayer() == layer) {
                            inLayerEdgeCount[layerIndex]++;
                        }
                    }
                }
            }
        }

        // Initialize the position arrays
        portRanks = new float[portCount];
        portPos = new int[portCount];
    }
    
    /**
     * Releases all created data so the GC can reap them.
     */
    private void dispose() {
        portRanks = null;
        portPos = null;
        bestSweep = null;
        curSweep = null;
        prevSweep = null;
        inLayerEdgeCount = null;
        layoutUnits.clear();
    }

    /**
     * {@inheritDoc}
     */
    public void process(final LGraph layeredGraph) {
        getMonitor().begin("Layer sweep crossing minimization", 1);

        // Fetch the graph's randomizer.
        Random random = layeredGraph.getProperty(Properties.RANDOM);

        // Find the number of layers. If there's only one, no crossing minimization is necessary.
        int layerCount = layeredGraph.getLayers().size();
        if (layerCount < 2) {
            getMonitor().done();
            return;
        }
        
        // Initialize the algorithm
        initialize(layeredGraph);
        int bestSweepCrossings = Integer.MAX_VALUE;
        int curSweepCrossings = Integer.MAX_VALUE;
        int prevSweepCrossings = Integer.MAX_VALUE;

        // Determine the requested number of runs
        int runCount = layeredGraph.getProperty(Properties.THOROUGHNESS);

        // Initialize the compound graph layer crossing minimizer
        IPortDistributor portDistributor = new NodeRelativePortDistributor(portRanks);
        IConstraintResolver constraintResolver = new ForsterConstraintResolver(layoutUnits);
        ICrossingMinimizationHeuristic heuristic = new BarycenterHeuristic(constraintResolver,
                random, portRanks);
        CompoundGraphLayerCrossingMinimizer compoundMinimizer
                = new CompoundGraphLayerCrossingMinimizer(layeredGraph, heuristic);

        // Perform the requested number of runs, each consisting of several sweeps
        // (alternating between forward and backward sweeps)
        for (int run = 0; run < runCount; run++) {
            // Each run is randomly determined to be a forward or a backward run
            boolean forward = random.nextBoolean();
            int fixedLayerIndex = forward ? 0 : layerCount - 1;
            NodeGroup[] fixedLayer = curSweep[fixedLayerIndex];

            // The fixed layer is randomized
            int totalEdges = 0;
            compoundMinimizer.compoundMinimizeCrossings(fixedLayer, fixedLayerIndex, forward,
                    false, true);
            portDistributor.calculatePortRanks(fixedLayer);

            // Reset last and current run crossing counters
            prevSweepCrossings = Integer.MAX_VALUE;
            curSweepCrossings = Integer.MAX_VALUE;

            // Do alternating forward and backward sweeps as long as the number of crossings
            // decreases with respect to the previous sweep.
            boolean firstSweep = true;
            do {
                // The formerly current sweep is now the previous sweep
                copySweep(curSweep, prevSweep);
                prevSweepCrossings = curSweepCrossings;
                curSweepCrossings = 0;

                if (forward) {
                    // Perform a forward sweep
                    for (int layerIndex = 1; layerIndex < layerCount; layerIndex++) {
                        NodeGroup[] freeLayer = curSweep[layerIndex];

                        totalEdges = compoundMinimizer.compoundMinimizeCrossings(freeLayer,
                                layerIndex, true, !firstSweep, false);
                        curSweepCrossings += countCrossings(fixedLayer, freeLayer, totalEdges);
                        if (inLayerEdgeCount[layerIndex] > 0) {
                            curSweepCrossings += countCrossings(freeLayer);
                        }
                        portDistributor.calculatePortRanks(freeLayer);

                        fixedLayer = freeLayer;
                    }
                } else {
                    // Perform a backward sweep
                    for (int layerIndex = layerCount - 2; layerIndex >= 0; layerIndex--) {
                        NodeGroup[] freeLayer = curSweep[layerIndex];

                        totalEdges = compoundMinimizer.compoundMinimizeCrossings(freeLayer,
                                layerIndex, false, !firstSweep, false);
                        curSweepCrossings += countCrossings(freeLayer, fixedLayer, totalEdges);
                        if (inLayerEdgeCount[layerIndex] > 0) {
                            curSweepCrossings += countCrossings(freeLayer);
                        }
                        portDistributor.calculatePortRanks(freeLayer);

                        fixedLayer = freeLayer;
                    }
                }

                // Switch the sweep direction
                firstSweep = false;
                forward = !forward;
            } while (curSweepCrossings < prevSweepCrossings);

            // Compare the current result with the best one
            if (curSweepCrossings < bestSweepCrossings || prevSweepCrossings < bestSweepCrossings) {
                // Restore the previous sweep's ordering if it has become worse
                if (curSweepCrossings < prevSweepCrossings) {
                    copySweep(curSweep, bestSweep);
                    bestSweepCrossings = curSweepCrossings;
                } else {
                    copySweep(prevSweep, bestSweep);
                    bestSweepCrossings = prevSweepCrossings;
                }
            }
        }

        // Distribute the ports of all nodes with free port constraints
        portDistributor.distributePorts(bestSweep);

        // Apply the ordering to the original layered graph
        ListIterator<Layer> layerIter = layeredGraph.getLayers().listIterator();
        while (layerIter.hasNext()) {
            Layer layer = layerIter.next();
            NodeGroup[] nodes = bestSweep[layerIter.previousIndex()];
            ListIterator<LNode> nodeIter = layer.getNodes().listIterator();
            while (nodeIter.hasNext()) {
                nodeIter.next();
                nodeIter.set(nodes[nodeIter.previousIndex()].getNode());
            }
        }

        dispose();
        getMonitor().done();
    }

    // /////////////////////////////////////////////////////////////////////////////
    // Cross Counting

    /**
     * Calculate the number of crossings between the two given layers.
     * 
     * Taken from W. Barth , M. Juenger, P. Mutzel: <em>Simple and efficient bilayer
     * cross counting</em>, LNCS 2528, pp. 331-360, 2002.
     * 
     * @param leftLayer
     *            the left layer
     * @param rightLayer
     *            the right layer
     * @param edgeCount
     *            the total number of edges in the layer
     * @return the number of edge crossings
     */
    private int countCrossings(final NodeGroup[] leftLayer, final NodeGroup[] rightLayer,
            final int edgeCount) {
        // Assign index values to the ports of the right layer
        int targetCount = 0;
        for (NodeGroup nodeGroup : rightLayer) {
            LNode node = nodeGroup.getNode();
            if (node.getProperty(LayoutOptions.PORT_CONSTRAINTS).isOrderFixed()) {
                List<LPort> inputPorts = NodeRelativePortDistributor.getSortedInputPorts(node);
                ListIterator<LPort> portIter = inputPorts.listIterator(inputPorts.size());
                while (portIter.hasPrevious()) {
                    portPos[portIter.previous().id] = targetCount++;
                }
            } else {
                for (LPort port : node.getPorts(PortType.INPUT)) {
                    portPos[port.id] = targetCount;
                }
                targetCount++;
            }
        }

        // Determine the sequence of edge target positions sorted by source and target index
        int[] southSequence = new int[edgeCount];
        int i = 0;
        for (NodeGroup nodeGroup : leftLayer) {
            LNode node = nodeGroup.getNode();
            if (node.getProperty(LayoutOptions.PORT_CONSTRAINTS).isOrderFixed()) {
                for (LPort port : node.getPorts()) {
                    int start = i;
                    for (LEdge edge : port.getOutgoingEdges()) {
                        LPort target = edge.getTarget();
                        if (node.getLayer() != target.getNode().getLayer()) {
                            insert(southSequence, start, i++, portPos[target.id]);
                        }
                    }
                }
            } else {
                int start = i;
                for (LPort port : node.getPorts()) {
                    for (LEdge edge : port.getOutgoingEdges()) {
                        LPort target = edge.getTarget();
                        if (node.getLayer() != target.getNode().getLayer()) {
                            insert(southSequence, start, i++, portPos[target.id]);
                        }
                    }
                }
            }
        }

        // Build the accumulator tree
        int firstIndex = 1;
        while (firstIndex < targetCount) {
            firstIndex *= 2;
        }
        int treeSize = 2 * firstIndex - 1;
        firstIndex -= 1;
        int[] tree = new int[treeSize];

        // Count the crossings
        int crossCount = 0;
        for (int k = 0; k < edgeCount; k++) {
            int index = southSequence[k] + firstIndex;
            tree[index]++;
            while (index > 0) {
                if (index % 2 > 0) {
                    crossCount += tree[index + 1];
                }
                index = (index - 1) / 2;
                tree[index]++;
            }
        }

        return crossCount;
    }

    /*
     * The algorithm used to count crossings within a layer implemented in the following method has
     * two parts:
     * 
     * Part 1 A normal node cannot be connected to another normal node in the same layer due to how
     * layering is performed. It remains that at least one of the two nodes must be a dummy node.
     * Currently, that can only happen due to odd port side handling. Because of the way dummies are
     * created, there are only two cases:
     * 
     * - An eastern port can be connected to another eastern port. - A western port can be connected
     * to another western port.
     * 
     * The algorithm now works by assigning numbers to eastern ports top-down, and to western ports
     * bottom-up, all the time dependent on their number of incident edges. (the link direction is
     * not important) Then we traverse the ports. If we find an eastern port connected to another
     * eastern port, the difference of their indices tells us how many other ports with incident
     * edges lie between them and can cause crossings.
     * 
     * Part 2 Additional crossings can happen due to nodes being placed between a node and its north
     * / south dummies. The idea here is to use the first node sweep from part 1 to count the number
     * of northern and southern North/South dummies for each node. Each north dummy is assigned a
     * position in the list of northern dummies for its node. South dummies are treated accordingly.
     * 
     * In a second sweep, for each non-north/south dummy, the most recently encountered north/south
     * dummy or normal node is retrieved. Its index is subtracted from the number of northern or
     * southern dummies of its node. The result gives the number of crossings caused by the node
     * being placed between a node and its north/south dummies.
     * 
     * Note that part two relies on information about layer layout units. If we find that they have
     * not been set, we can skip this part.
     */

    /**
     * Calculates the worst case for the number of crossings caused by in-layer edges in the given
     * layer. The actual number of crossings may be lower.
     * 
     * @param layer
     *            the layer whose in-layer crossings to estimate.
     * @return the worst possible number of crossings.
     */
    private int countCrossings(final NodeGroup[] layer) {
        int crossings = 0;

        // Number of north/south dummies and indices
        Map<LNode, Pair<Integer, Integer>> northSouthCrossingHints 
            = new HashMap<LNode, Pair<Integer, Integer>>();
        Map<LNode, Integer> dummyIndices = new HashMap<LNode, Integer>();

        // Assign numbers to the layer's eastern and western ports
        Map<LPort, Integer> easternPortNumbers = new HashMap<LPort, Integer>();
        Map<LPort, Integer> westernPortNumbers = new HashMap<LPort, Integer>();

        numberEastWestPorts(layer, easternPortNumbers, westernPortNumbers);

        // Iterate through the nodes
        LNode currentNormalNode = null;
        int northMaxCrossingHint = 0;
        int southMaxCrossingHint = 0;
        boolean northernSide = true;
        boolean layerLayoutUnitsSet = true;

        for (NodeGroup nodeGroup : layer) {
            LNode node = nodeGroup.getNode();
            // Part 1 of the crossing counting algorithm
            for (LPort port : node.getPorts()) {
                switch (port.getSide()) {
                case EAST:
                    crossings += countInLayerCrossings(port, easternPortNumbers);
                    break;

                case WEST:
                    crossings += countInLayerCrossings(port, westernPortNumbers);
                    break;
                }
            }

            // First sweep of part 2 of the crossing counting algorithm
            NodeType nodeType = node.getProperty(Properties.NODE_TYPE);
            if (layerLayoutUnitsSet
                    && (nodeType == NodeType.NORMAL || nodeType == NodeType.NORTH_SOUTH_PORT)) {

                LNode newNormalNode = node.getProperty(Properties.IN_LAYER_LAYOUT_UNIT);
                if (newNormalNode == null) {
                    // Layer layout units don't seem to have been set
                    layerLayoutUnitsSet = false;
                    continue;
                }

                // Check if this node belongs to a new normal node
                if (currentNormalNode != newNormalNode) {
                    // Save the old normal node's values
                    if (currentNormalNode != null) {
                        northSouthCrossingHints.put(currentNormalNode, new Pair<Integer, Integer>(
                                northMaxCrossingHint, southMaxCrossingHint));
                    }

                    // Reset the counters
                    currentNormalNode = newNormalNode;
                    northMaxCrossingHint = 0;
                    southMaxCrossingHint = 0;
                    northernSide = true;
                }

                // If the node is the normal node, we're entering its south side
                if (node == currentNormalNode) {
                    northernSide = false;
                }

                // Update and save crossing hints
                if (northernSide) {
                    northMaxCrossingHint += node.getProperty(Properties.CROSSING_HINT);
                    dummyIndices.put(node, northMaxCrossingHint);
                } else {
                    southMaxCrossingHint += node.getProperty(Properties.CROSSING_HINT);
                    dummyIndices.put(node, southMaxCrossingHint);
                }
            }
        }

        // Remember to save the values for the last normal node
        if (currentNormalNode != null) {
            northSouthCrossingHints.put(currentNormalNode, new Pair<Integer, Integer>(
                    northMaxCrossingHint, southMaxCrossingHint));
        }

        // Second sweep of Part 2 of the algorithm
        if (layerLayoutUnitsSet) {
            LNode lastDummyNormalNode = null;
            int lastDummyIndex = 0;
            int dummyCount = 0;

            for (NodeGroup nodeGroup : layer) {
                LNode node = nodeGroup.getNode();
                NodeType nodeType = node.getProperty(Properties.NODE_TYPE);

                switch (nodeType) {
                case NORMAL:
                    lastDummyIndex = dummyIndices.get(node);

                    lastDummyNormalNode = node;
                    dummyCount = northSouthCrossingHints.get(node).getSecond();
                    break;

                case NORTH_SOUTH_PORT:
                    lastDummyIndex = dummyIndices.get(node);

                    LNode newNormalNode = node.getProperty(Properties.IN_LAYER_LAYOUT_UNIT);
                    if (newNormalNode != lastDummyNormalNode) {
                        dummyCount = northSouthCrossingHints.get(newNormalNode).getFirst();
                        lastDummyNormalNode = newNormalNode;
                    }
                    break;

                default:
                    crossings += dummyCount - lastDummyIndex;
                }
            }
        }

        return crossings;
    }

    /**
     * Assigns numbers to the eastern ports of a layer, and to the western ports of a layer. A
     * number is assigned to a port if it has incident edges. Eastern ports are numbered top-down,
     * while western ports are numbered bottom-up.
     * 
     * @param layer
     *            the layer whose ports to index.
     * @param easternMap
     *            map to put the eastern ports' indices in.
     * @param westernMap
     *            map to put the western ports' indices in.
     */
    private void numberEastWestPorts(final NodeGroup[] layer, final Map<LPort, Integer> easternMap,
            final Map<LPort, Integer> westernMap) {

        int currentEasternNumber = 0;
        int currentWesternNumber = 0;

        // Assign numbers to eastern ports, top-down
        for (int nodeIndex = 0; nodeIndex < layer.length; nodeIndex++) {
            LNode node = layer[nodeIndex].getNode();

            if (node.getProperty(LayoutOptions.PORT_CONSTRAINTS).isOrderFixed()) {
                for (LPort easternPort : node.getPorts(PortSide.EAST)) {
                    if (easternPort.getDegree() > 0) {
                        currentEasternNumber += easternPort.getDegree();
                        easternMap.put(easternPort, currentEasternNumber);
                    }
                }
            } else {
                // Find the number of edges incident to eastern ports
                for (LPort easternPort : node.getPorts(PortSide.EAST)) {
                    currentEasternNumber += easternPort.getDegree();
                }

                // Assign the eastern number to all eastern ports
                for (LPort easternPort : node.getPorts(PortSide.EAST)) {
                    if (easternPort.getDegree() > 0) {
                        easternMap.put(easternPort, currentEasternNumber);
                    }
                }
            }
        }

        // Assign indices to western ports, bottom-up
        for (int nodeIndex = layer.length - 1; nodeIndex >= 0; nodeIndex--) {
            LNode node = layer[nodeIndex].getNode();

            if (node.getProperty(LayoutOptions.PORT_CONSTRAINTS).isOrderFixed()) {
                for (LPort westernPort : node.getPorts(PortSide.WEST)) {
                    if (westernPort.getDegree() > 0) {
                        currentWesternNumber += westernPort.getDegree();
                        westernMap.put(westernPort, currentWesternNumber);
                    }
                }
            } else {
                // Find the number of edges incident to western ports
                for (LPort westernPort : node.getPorts(PortSide.WEST)) {
                    currentWesternNumber += westernPort.getDegree();
                }

                // Assign the western number to all western ports
                for (LPort westernPort : node.getPorts(PortSide.WEST)) {
                    if (westernPort.getDegree() > 0) {
                        westernMap.put(westernPort, currentWesternNumber);
                    }
                }
            }
        }
    }

    /**
     * Counts the crossings caused by in-layer edges connected to the given port. An edge is only
     * counted once.
     * 
     * @param port
     *            the port whose edge crossings to count.
     * @param portIndices
     *            map of ports to their respective indices as calculated by
     *            {@link #numberEastWestPorts(LNode[], Map, Map)}.
     * @return the maximum number of crossings for this port.
     */
    private int countInLayerCrossings(final LPort port, final Map<LPort, Integer> portIndices) {
        int maxCrossings = 0;

        // Find this port's index
        Integer portIndex = portIndices.get(port);
        if (portIndex == null) {
            return 0;
        }

        // Find the maximum distance between two connected ports
        Integer connectedPortIndex = null;
        for (LEdge edge : port.getConnectedEdges()) {
            if (edge.getSource() == port) {
                connectedPortIndex = portIndices.get(edge.getTarget());
            } else {
                connectedPortIndex = portIndices.get(edge.getSource());
            }

            // Check if the edge is connected to another port in the same layer
            if (connectedPortIndex != null) {
                // Only count the edge once
                if (portIndex.intValue() > connectedPortIndex.intValue()) {
                    maxCrossings = Math.max(maxCrossings,
                            portIndex.intValue() - connectedPortIndex.intValue() - 1);
                }
            }
        }

        return maxCrossings;
    }

    // /////////////////////////////////////////////////////////////////////////////
    // Utility Methods

    /**
     * Copy the content of the source node array to the target node array.
     * 
     * @param source
     *            a layered graph
     * @param dest
     *            a node array to copy the graph into
     */
    private static void copySweep(final NodeGroup[][] source, final NodeGroup[][] dest) {
        for (int i = 0; i < dest.length; i++) {
            for (int j = 0; j < dest[i].length; j++) {
                dest[i][j] = source[i][j];
            }
        }
    }

    /**
     * Insert a number into a sorted range of an array.
     * 
     * @param array
     *            an integer array
     * @param start
     *            the start index of the search range (inclusive)
     * @param end
     *            the end index of the search range (exclusive)
     * @param n
     *            the number to insert
     */
    private static void insert(final int[] array, final int start, final int end, final int n) {
        int insx = binarySearch(array, start, end, n);
        if (insx < 0) {
            insx = -insx - 1;
        }
        for (int j = end - 1; j >= insx; j--) {
            array[j + 1] = array[j];
        }

        array[insx] = n;
    }

    /**
     * Searches a range of the specified array of ints for the specified value using the binary
     * search algorithm. The range must be sorted prior to making this call.
     * 
     * @param a
     *            the array to be searched
     * @param fromIndex
     *            the index of the first element (inclusive) to be searched
     * @param toIndex
     *            the index of the last element (exclusive) to be searched
     * @param key
     *            the value to be searched for
     * @return index of the search key
     */
    private static int binarySearch(final int[] a, final int fromIndex, final int toIndex,
            final int key) {
        int low = fromIndex;
        int high = toIndex - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = a[mid];

            if (midVal < key) {
                low = mid + 1;
            } else if (midVal > key) {
                high = mid - 1;
            } else {
                return mid; // key found
            }
        }
        return -(low + 1); // key not found
    }
    
}

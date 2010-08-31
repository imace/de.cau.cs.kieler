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
package de.cau.cs.kieler.klay.layered.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import de.cau.cs.kieler.core.alg.AbstractAlgorithm;
import de.cau.cs.kieler.core.util.Pair;
import de.cau.cs.kieler.kiml.options.PortType;
import de.cau.cs.kieler.klay.layered.Properties;
import de.cau.cs.kieler.klay.layered.graph.LEdge;
import de.cau.cs.kieler.klay.layered.graph.LNode;
import de.cau.cs.kieler.klay.layered.graph.LPort;
import de.cau.cs.kieler.klay.layered.graph.Layer;
import de.cau.cs.kieler.klay.layered.graph.LayeredGraph;
import de.cau.cs.kieler.klay.layered.modules.IBigNodeHandler;
import de.cau.cs.kieler.klay.layered.modules.ILayerer;

/**
 * The main class of the network simplex layerer component. It offers an algorithm to determine an
 * optimal layering of all nodes in the graph concerning a minimal length of all edges using the
 * network simplex algorithm described in
 * {@literal Emden R. Gansner, Eleftherios Koutsofios, Stephen
 * C. North, Kiem-Phong Vo: "A Technique for Drawing Directed Graphs", AT&T Bell Laboratories}.
 * 
 * @see de.cau.cs.kieler.klay.layered.modules.ILayerer ILayerer
 * 
 * @author pdo
 */
public class NetworkSimplexLayerer extends AbstractAlgorithm implements ILayerer {

    // ================================== Attributes ==============================================

    /** The layered graph all methods in this class operate on. */
    private LayeredGraph layeredGraph;

    /** A {@code Collection} containing all nodes in the graph to layer. */
    private Collection<LNode> nodes;

    /** A {@code LinkedList} containing all edges in the graph. */
    private LinkedList<LEdge> edges;

    /**
     * A {@code LinkedList} containing all nodes of the currently identified connected component by
     * {@code connectedComponents()}.
     * 
     * @see de.cau.cs.kieler.klay.layered.impl.NetworkSimplexLayerer#connectedComponents(Collection)
     *      connectedComponents()
     */
    private LinkedList<LNode> componentNodes;

    /**
     * A {@code LinkedList} containing all source nodes of the graph, i.e. all nodes that have no
     * incident incoming edges.
     */
    private LinkedList<LNode> sources;

    /**
     * A {@code LinkedList} containing all sink nodes of the graph, i.e. all nodes that have no
     * incident outgoing edges.
     */
    private LinkedList<LNode> sinks;

    /** The number of incoming edges incident to each node. */
    private int[] inDegree;

    /** The number of outgoing edges incident to each node. */
    private int[] outDegree;

    /**
     * The layer each node is currently assigned to. Note that during layerer execution, the lowest
     * layer is not necessary the zeroth layer. To fulfill this characteristic, a final call of
     * {@code normalize()} has to be performed.
     */
    private int[] layer;

    /**
     * The layer each node is assigned to in the reverse traversal of the graph in
     * {@code layeringDFS()}. Note that this determined layering is only necessary to compute the
     * minimal span of each edge in the layering. It will not be reused later.
     */
    private int[] revLayer;

    /** The minimal span (i.e. shortest possible length) of each edge in the layered graph. */
    private int[] minSpan;

    /**
     * A flag indicating whether a specified node is part of the spanning tree determined by
     * {@code tightTree()}.
     * 
     * @see de.cau.cs.kieler.klay.layered.impl.NetworkSimplexLayerer#tightTreeDFS() tightTreeDFS()
     */
    private boolean[] treeNode;

    /**
     * A flag indicating whether a specified edge is part of the spanning tree determined by
     * {@code tightTree()}.
     * 
     * @see de.cau.cs.kieler.klay.layered.impl.NetworkSimplexLayerer#tightTreeDFS(LNode)
     *      tightTreeDFS()
     */
    private boolean[] treeEdge;

    /**
     * A flag indicating whether a specified edge has been visited during DFS-traversal. This array
     * has to be filled with {@code false} each time, before a DFS-based method is invoked.
     */
    private boolean[] edgeVisited;

    /**
     * A flag indicating whether a specified node has been visited during DFS-traversal. This array
     * has to be filled with {@code false} each time, before a DFS-based method is invoked.
     */
    private boolean[] nodeVisited;

    /**
     * The current postorder traversal number used by {@code postorderTraversal()} to assign an
     * unique traversal ID to each node.
     * 
     * @see de.cau.cs.kieler.klay.layered.impl.NetworkSimplexLayerer#postorderTraversal(LNode)
     *      postorderTraversal()
     */
    private int postOrder;

    /**
     * The postorder traversal ID of each node determined by {@code postorderTraversal()}.
     * 
     * @see de.cau.cs.kieler.klay.layered.impl.NetworkSimplexLayerer#postorderTraversal(LNode)
     *      postorderTraversal()
     */
    private int[] poID;

    /**
     * The lowest postorder traversal ID of each nodes reachable through a node lower in the
     * traversal tree determined by {@code postorderTraversal}.
     * 
     * @see de.cau.cs.kieler.klay.layered.impl.NetworkSimplexLayerer#postorderTraversal(LNode)
     *      postorderTraversal()
     */
    private int[] lowestPoID;

    /**
     * The cut value of every edge defined as follows: If the edge is deleted, the spanning tree
     * breaks into two connected components, the head component containing the target node of the
     * edge and the tail component containing the source node of the edge. The cut value is the sum
     * of the weight (here {@code 1}) of all edges going from the tail to the head component,
     * including the tree edge, minus the sum of the weights of all edges from the head to the tail
     * component.
     * 
     * @see de.cau.cs.kieler.klay.layered.impl.NetworkSimplexLayerer#cutvalues() cutvalues()
     */
    private int[] cutvalue;

    // ================================== Constructor =============================================

    /**
     * Default Constructor for {@link NetworkSimplexLayerer}. It creates a new instance of this
     * class.
     */
    public NetworkSimplexLayerer() {
    }

    // =============================== Initialization Methods =====================================

    /**
     * Helper method for the network simplex layerer. It determines all connected components of the
     * graph given by a {@code Collection} containing all nodes of the graph.
     * 
     * @param theNodes
     *            a {@code Collection} containing all nodes of the graph to determine the connected
     *            components
     * @return an {@code LinkedList} of {@code LinkedLists} containing all nodes of every connected
     *         component
     * 
     * @see de.cau.cs.kieler.klay.layered.impl.NetworkSimplexLayerer#connectedComponentsDFS(LNode)
     *      connectedComponentsDFS()
     */
    private LinkedList<LinkedList<LNode>> connectedComponents(final Collection<LNode> theNodes) {

        // initialize required attributes
        if (nodeVisited == null || nodeVisited.length < theNodes.size()) {
            nodeVisited = new boolean[theNodes.size()];
        } else {
            Arrays.fill(nodeVisited, false);
        }
        componentNodes = new LinkedList<LNode>();

        // re-index nodes
        int counter = 0;
        for (LNode node : theNodes) {
            node.id = counter++;
        }
        // determine connected components
        LinkedList<LinkedList<LNode>> components = new LinkedList<LinkedList<LNode>>();
        for (LNode node : theNodes) {
            if (!nodeVisited[node.id]) {
                connectedComponentsDFS(node);
                // connected component with the most nodes should be layered first to guarantee
                // reusability of attribute instances
                if (components.isEmpty() || components.getFirst().size() < componentNodes.size()) {
                    components.addFirst(componentNodes);
                } else {
                    components.addLast(componentNodes);
                }
                componentNodes = new LinkedList<LNode>();
            }
        }
        return components;
    }

    /**
     * Helper method for the connected components determination. It determines all nodes, that are
     * connected with the input node (i.e. all nodes of that connected component the input node is
     * part of) and adds them to {@code componentNodes}.
     * 
     * @param node
     *            the root of the DFS-subtree
     * @return a {@code LinkedList} containing all nodes reachable through a path beginning at the
     *         input node (i.e. all nodes connected to the input node)
     * 
     * @see de.cau.cs.kieler.klay.layered.impl.NetworkSimplexLayerer#connectedComponents(Collection)
     *      connectedComponents()
     * @see de.cau.cs.kieler.klay.layered.impl.NetworkSimplexLayerer#componentNodes componentNodes
     */
    private void connectedComponentsDFS(final LNode node) {

        nodeVisited[node.id] = true;
        // node is part of the current connected component
        componentNodes.add(node);
        LNode opposite;
        // continue with next nodes, if not already visited
        for (LPort port : node.getPorts()) {
            for (LEdge edge : port.getEdges()) {
                opposite = getOpposite(port, edge).getNode();
                if (!nodeVisited[opposite.id]) {
                    connectedComponentsDFS(opposite);
                }
            }
        }
    }

    /**
     * Helper method for the network simplex layerer. It instantiates all necessary attributes for
     * the execution of the network simplex layerer and initializes them with their default values.
     * If the attributes already exist (i.e. they were created by a previous function call) and if
     * their size fits for the nodes of the current graph, then the old instances will be reused as
     * far as possible. Furthermore, all edges in the connected component given by the input
     * argument will be determined, as well as the number of incoming and outgoing edges of each
     * node ( {@code inDegree}, respectively {@code outDegree}). All sinks and source nodes in the
     * connected component identified in this step will be added to {@code sinks}, respectively
     * {@code sources}.
     * 
     * @param theNodes
     *            a {@code Collection} containing all nodes of the graph
     */
    private void initialize(final Collection<LNode> theNodes) {

        // initialize node attributes
        int numNodes = theNodes.size();
        if (inDegree == null || inDegree.length < numNodes) {
            inDegree = new int[numNodes];
            outDegree = new int[numNodes];
            layer = new int[numNodes];
            revLayer = new int[numNodes];
            Arrays.fill(revLayer, numNodes);
            treeNode = new boolean[numNodes];
            poID = new int[numNodes];
            lowestPoID = new int[numNodes];
        } else {
            Arrays.fill(inDegree, 0);
            Arrays.fill(outDegree, 0);
            Arrays.fill(layer, 0);
            Arrays.fill(revLayer, numNodes);
            Arrays.fill(treeNode, false);
        }
        sources = new LinkedList<LNode>();
        sinks = new LinkedList<LNode>();
        nodes = theNodes;

        // determine edges and re-index nodes
        int index = 0;
        LinkedList<LEdge> theEdges = new LinkedList<LEdge>();
        for (LNode node : theNodes) {
            node.id = index++;
            for (LPort port : node.getPorts()) {
                if (port.getType() == PortType.OUTPUT) {
                    theEdges.addAll(port.getEdges());
                    outDegree[node.id] += port.getEdges().size();
                } else if (port.getType() == PortType.INPUT) {
                    inDegree[node.id] += port.getEdges().size();
                }
            }
            // add node to sinks, resp. sources
            if (outDegree[node.id] == 0) {
                sinks.add(node);
            }
            if (inDegree[node.id] == 0) {
                sources.add(node);
            }
        }
        // re-index edges
        int counter = 0;
        for (LEdge edge : theEdges) {
            edge.id = counter++;
        }
        // initialize edge attributes
        int numEdges = theEdges.size();
        if (cutvalue == null || cutvalue.length < numEdges) {
            cutvalue = new int[numEdges];
            minSpan = new int[numEdges];
            treeEdge = new boolean[numEdges];
            edgeVisited = new boolean[numEdges];
        } else {
            Arrays.fill(treeEdge, false);
            Arrays.fill(edgeVisited, false);
        }
        edges = theEdges;
        postOrder = 1;
    }

    // ============================== Network-Simplex Algorithm ===================================

/**
     * The main method of the network simplex layerer. It determines an optimal layering of all
     * nodes in the graph concerning a minimal length of all edges by using the network simplex
     * algorithm described in {@literal Emden R. Gansner, Eleftherios Koutsofios, Stephen
     * C. North, Kiem-Phong Vo: "A Technique for Drawing Directed Graphs", AT&T Bell Laboratories.
     * Note that the execution time of this implemented algorithm has not been proven quadratic yet.
     * 
     * @param theNodes
     *            a {@code Collection} of all nodes of the graph to layer
     * @param theLayeredGraph
     *            an initially empty layered graph which is filled with layers
     *            
     * @see de.cau.cs.kieler.klay.layered.modules.ILayerer ILayerer
     */
    public void layer(final Collection<LNode> theNodes, final LayeredGraph theLayeredGraph) {

        if (theNodes == null) {
            throw new NullPointerException("Input collection of nodes is null.");
        }
        if (theLayeredGraph == null) {
            throw new NullPointerException("Input graph is null.");
        }

        getMonitor().begin("network-simplex layering", 1);
        if (theNodes.size() < 1) {
            getMonitor().done();
            return;
        }
        layeredGraph = theLayeredGraph;

        // support wide nodes, if requested
        IBigNodeHandler bigNodeHandler = new BigNodeHandler();
        if (layeredGraph.getProperty(Properties.DISTRIBUTE_NODES)) {
            bigNodeHandler.splitWideNodes(theNodes, theLayeredGraph);
        }
        
        // layer graph, each connected component separately
        for (LinkedList<LNode> connComp : connectedComponents(theNodes)) {
            
            initialize(connComp);
            // determine optimal layering
            feasibleTree();
            LEdge e = null;
            while ((e = leaveEdge()) != null) {
                // current layering is not optimal
                exchange(e, enterEdge(e));
            }
            
            if (layeredGraph.getProperty(Properties.DISTRIBUTE_NODES)) {
                normalize(false);
            } else {
                balance(normalize(false));
            }
            // put nodes into their assigned layers
            for (LNode node : nodes) {
                putNode(node);
            }
        }
        // correct layering concerning wide nodes
        if (layeredGraph.getProperty(Properties.DISTRIBUTE_NODES)) {
            bigNodeHandler.correctLayering();
        }

        getMonitor().done();
    }

    /**
     * Helper method for the network simplex layerer. It determines an initial feasible spanning
     * tree of the graph. This graph will be tight by construction. For determination, an initial
     * feasible tree is being computed. If all tree edges contained are tight (i.e. their minimal
     * length corresponds with their actual length), a tight tree has already been found. If not,
     * this method iteratively determines a non-tree edge incident to the tree with a minimal amount
     * of slack (i.e. the edge with the lowest difference between its current and minimal length)
     * and shifts all tree edges accordingly to shorten the edge to its minimal size. The edge has
     * become tight and will be added to the spanning tree together with all tight edges leading to
     * non-tree nodes as well. If all nodes of the graph are contained in the spanning tree, a tight
     * tree has been found. A concluding computation of each edge's initial cut value takes place.
     * 
     * @see de.cau.cs.kieler.klay.layered.impl.NetworkSimplexLayerer#tightTreeDFS(LNode)
     *      tightTreeDFS()
     */
    private void feasibleTree() {

        initLayering();
        if (edges.size() > 0) {
            Arrays.fill(edgeVisited, false);
            while (tightTreeDFS(nodes.iterator().next()) < nodes.size()) {
                // some nodes are still not part of the tree
                LEdge e = minimalSlack();
                int slack = layer[e.getTarget().getNode().id] - layer[e.getSource().getNode().id]
                        - minSpan[e.id];
                if (treeNode[e.getSource().getNode().id]) {
                    slack = -slack;
                }
                // update tree
                for (LNode node : nodes) {
                    if (treeNode[node.id]) {
                        layer[node.id] += slack;
                    }
                }
                Arrays.fill(edgeVisited, false);
            }
            // update tree-related attributes
            Arrays.fill(edgeVisited, false);
            postorderTraversal(nodes.iterator().next());
            cutvalues();
        }
    }

    /**
     * Helper method for the network simplex layerer. It determines an initial layering of all nodes
     * in the graph. The graph will be traversed by a depth-first-search assigning all nodes to
     * layers equivalent to its height in the thereby defined DFS-tree. Furthermore, the minimal
     * length of each node in the graph will be determined and, as a first optimization, all leafs
     * of the graph (i.e. sink and source nodes) will be assigned to a layer as close to their
     * adjacent nodes as possible.
     * 
     * @see de.cau.cs.kieler.klay.layered.impl.NetworkSimplexLayerer#layeringDFS(LNode, boolean)
     *      layeringDFS()
     * @see de.cau.cs.kieler.klay.layered.impl.NetworkSimplexLayerer#layer layer
     * @see de.cau.cs.kieler.klay.layered.impl.NetworkSimplexLayerer#minSpan minSpan
     */
    private void initLayering() {

        // determine initial layering
        for (LNode node : sources) {
            layeringDFS(node, false);
        }
        // determine second (reverse) layering
        for (LNode node : sinks) {
            layeringDFS(node, true);
        }
        // determine minimal length of each edge
        for (LEdge edge : edges) {
            minSpan[edge.id] = Math.min(layer[edge.getTarget().getNode().id]
                    - layer[edge.getSource().getNode().id], revLayer[edge.getTarget().getNode().id]
                    - revLayer[edge.getSource().getNode().id]);
        }
        // pull sources and sinks closer to their adjacent nodes
        shiftLeafs();
    }

    /**
     * Helper method for the network simplex layerer. It determines an (initial) feasible layering
     * for the graph by traversing it by a modified depth-first-search arranging the nodes to the
     * layer representing their height in a DFS-tree with the input node as its root. Dependently of
     * the chosen mode indicated by {@code reverse}, this method traverses incoming edges (if
     * {@code reverse = false}), or outgoing edges, if {@code reverse = true}, only. Therefore, this
     * method should only be called with source nodes as argument in the first-mentioned case and
     * only with sink nodes in the latter case.
     * 
     * @param node
     *            the root of the DFS-subtree
     * @param reverse
     *            the traversal direction of the depth-first-search. If {@code reverse = false}),
     *            this method only traverses incoming edges. Otherwise, if {@code reverse = true},
     *            only outgoing edges will be traversed
     * 
     * @see de.cau.cs.kieler.klay.layered.impl.NetworkSimplexLayerer#layer layer
     * @see de.cau.cs.kieler.klay.layered.impl.NetworkSimplexLayerer#revLayer revLayer
     */
    private void layeringDFS(final LNode node, final boolean reverse) {

        LNode target = null;
        if (reverse) {
            for (LPort port : node.getPorts(PortType.INPUT)) {
                for (LEdge edge : port.getEdges()) {
                    target = edge.getSource().getNode();
                    revLayer[target.id] = Math.min(revLayer[target.id], revLayer[node.id] - 1);
                    layeringDFS(target, true);
                }
            }
        } else {
            for (LPort port : node.getPorts(PortType.OUTPUT)) {
                for (LEdge edge : port.getEdges()) {
                    target = edge.getTarget().getNode();
                    layer[target.id] = Math.max(layer[target.id], layer[node.id] + 1);
                    layeringDFS(target, false);
                }
            }
        }
    }

    /**
     * Helper method for the network simplex layerer. It determines the length of the currently
     * shortest incoming respectively outgoing edge of the input node.
     * 
     * @param node
     *            the node to determine the length of its shortest incident incoming and outgoing
     *            edge
     * @return a pair containing the length of the shortest incoming (first element) and outgoing
     *         edge (second element) incident to the input node or {@code -1} as the length, if no
     *         such edge is incident
     * 
     * @see de.cau.cs.kieler.core.util.Pair Pair
     */
    private Pair<Integer, Integer> minimalSpan(final LNode node) {

        int minSpanOut = Integer.MAX_VALUE;
        int minSpanIn = Integer.MAX_VALUE;
        int currentSpan;

        for (LPort port : node.getPorts()) {
            for (LEdge edge : port.getEdges()) {
                currentSpan = layer[edge.getTarget().getNode().id]
                        - layer[edge.getSource().getNode().id];
                if (port.getType() == PortType.INPUT && currentSpan < minSpanIn) {
                    minSpanIn = currentSpan;
                } else if (currentSpan < minSpanOut) {
                    minSpanOut = currentSpan;
                }
            }
        }
        if (minSpanIn == Integer.MAX_VALUE) {
            minSpanIn = -1;
        }
        if (minSpanOut == Integer.MAX_VALUE) {
            minSpanOut = -1;
        }

        return new Pair<Integer, Integer>(minSpanIn, minSpanOut);
    }

    /**
     * Helper method for the network simplex layerer. It shifts all leafs (i.e. source or sink
     * nodes) as close to their adjacent nodes as possible (i.e. as the layering remains feasible).
     * Note that this method is originally not part of the network simplex approach. It serves as a
     * first optimization here to minimize the number of (potentially more expensive) iterations
     * necessary in the main algorithm.
     */
    private void shiftLeafs() {

        for (LNode node : sources) {
            layer[node.id] += minimalSpan(node).getSecond() - 1;
        }
        for (LNode node : sinks) {
            layer[node.id] -= minimalSpan(node).getFirst() - 1;
        }
    }

    /**
     * Helper method for the network simplex layerer. It determines a DFS-subtree of the graph by
     * traversing tight edges only (i.e. edges whose current length matches their minimal length in
     * the layering) and returns the number of nodes in this. If this number is equal to the total
     * number of nodes in the graph, a tight spanning tree has been determined.
     * 
     * @param node
     *            the root of the DFS-subtree
     * @return the number of nodes in the determined tight DFS-tree
     * 
     * @see de.cau.cs.kieler.klay.layered.impl.NetworkSimplexLayerer#treeEdge treeEdge
     * @see de.cau.cs.kieler.klay.layered.impl.NetworkSimplexLayerer#treeNode treeNode
     */
    private int tightTreeDFS(final LNode node) {

        int nodeCount = 1;
        treeNode[node.id] = true;
        LNode opposite = null;
        for (LPort port : node.getPorts()) {
            for (LEdge edge : port.getEdges()) {
                if (!edgeVisited[edge.id]) {
                    edgeVisited[edge.id] = true;
                    opposite = getOpposite(port, edge).getNode();
                    if (treeEdge[edge.id]) {
                        // edge is a tree edge already: follow this path
                        nodeCount += tightTreeDFS(opposite);
                    } else if (!treeNode[opposite.id]
                            && minSpan[edge.id] == layer[edge.getTarget().getNode().id]
                                    - layer[edge.getSource().getNode().id]) {
                        // edge is a tight non-tree edge
                        treeEdge[edge.id] = true;
                        nodeCount += tightTreeDFS(opposite);
                    }
                }
            }
        }
        return nodeCount;
    }

    /**
     * Helper method for the network simplex layerer. It returns the non-tree edge incident on the
     * tree and a non-tree node with a minimal amount of slack (i.e. an edge with the lowest
     * difference between its current and minimal length) or {@code null}, if no such edge exists.
     * Note, that the returned edge's slack is never {@code 0}, since otherwise, the edge would be a
     * tree-edge.
     * 
     * @return a non-tree edge incident on the tree with a minimal amount of slack or {@code null},
     *         if no such edge exists
     */
    private LEdge minimalSlack() {

        int minSlack = Integer.MAX_VALUE;
        LEdge minSlackEdge = null;
        int curSlack;
        for (LEdge edge : edges) {
            if (treeNode[edge.getSource().getNode().id] ^ treeNode[edge.getTarget().getNode().id]) {
                // edge is non-tree edge and incident on the tree
                curSlack = layer[edge.getTarget().getNode().id]
                        - layer[edge.getSource().getNode().id] - minSpan[edge.id];
                if (curSlack < minSlack) {
                    minSlack = curSlack;
                    minSlackEdge = edge;
                }
            }
        }
        return minSlackEdge;
    }

    /**
     * Helper method for the network simplex layerer. It performs a postorder DFS-traversal of the
     * graph beginning with the input node. Each node will be assigned a unique traversal ID, which
     * will be stored in {@code poID}. Furthermore, the lowest postorder traversal ID of any node in
     * a descending path relative to the input node will be computed and stored in
     * {@code lowestPoID}, which is also the return value of this method.
     * 
     * @param node
     *            the root of the DFS-subtree
     * @return the lowest post-order ID of any descending edge in the depth-first-search
     * 
     * @see de.cau.cs.kieler.klay.layered.impl.NetworkSimplexLayerer#poID poID
     * @see de.cau.cs.kieler.klay.layered.impl.NetworkSimplexLayerer#lowestPoID lowestPoID
     * @see de.cau.cs.kieler.klay.layered.impl.NetworkSimplexLayerer#postOrder postOrder
     */
    private int postorderTraversal(final LNode node) {

        int lowest = Integer.MAX_VALUE;
        for (LPort port : node.getPorts()) {
            for (LEdge edge : port.getEdges()) {
                if (treeEdge[edge.id] && !edgeVisited[edge.id]) {
                    edgeVisited[edge.id] = true;
                    lowest = Math
                            .min(lowest, postorderTraversal(getOpposite(port, edge).getNode()));
                }
            }
        }
        poID[node.id] = postOrder;
        lowestPoID[node.id] = Math.min(lowest, postOrder++);
        return lowestPoID[node.id];
    }

    /**
     * Helper method for the the network simplex layerer. It determines, whether an node is part of
     * the head component of the given edge defined as follows: If the input edge is deleted, the
     * spanning tree breaks into to connected components. The head component is that component,
     * which contains the edge's target node, and the tail component is the component, which
     * contains the edge's source node. Note that a node either belongs to the head or tail
     * component. Therefore, if the node is not part of the head component, it must be part of the
     * tail component and vice versa.
     * 
     * @param node
     *            the node to determine, whether it belongs to the edges head (or tail) component
     * @param edge
     *            the edge to determine, whether the node is in the head (or tail) component
     * @return {@code true}, if node is in the head component or {@code false}, if the node is in
     *         the tail component of the edge
     */
    private boolean isInHead(final LNode node, final LEdge edge) {

        LNode source = edge.getSource().getNode();
        LNode target = edge.getTarget().getNode();

        if (lowestPoID[source.id] <= poID[node.id] && poID[node.id] <= poID[source.id]
                && lowestPoID[target.id] <= poID[node.id] && poID[node.id] <= poID[target.id]) {
            // node is in a descending path in the DFS-Tree
            if (poID[source.id] < poID[target.id]) {
                // root is in the head component
                return false;
            }
            return true;
        }
        if (poID[source.id] < poID[target.id]) {
            // root is in the head component
            return true;
        }
        return false;
    }

    /**
     * Helper method for the network simplex layerer. It determines the cut value of each tree edge,
     * which is defined as follows: If the edge is deleted, the spanning tree breaks into two
     * connected components, the head component containing the target node of the edge and the tail
     * component containing the source node of the edge. The cut value is the sum of the weights of
     * all edges going from the tail to the head component, including the tree edge itself, minus
     * the sum of the weights of all edges from the head to the tail component.
     * 
     * @see de.cau.cs.kieler.klay.layered.impl.NetworkSimplexLayerer#cutvalue cutvalue
     */
    private void cutvalues() {

        // determine incident tree edges for each node
        LinkedList<LNode> leafs = new LinkedList<LNode>();
        int treeEdgeCount;
        ArrayList<HashSet<LEdge>> unknownCutvalues = new ArrayList<HashSet<LEdge>>(nodes.size());
        for (LNode node : nodes) {
            treeEdgeCount = 0;
            unknownCutvalues.add(new HashSet<LEdge>());
            for (LPort port : node.getPorts()) {
                for (LEdge edge : port.getEdges()) {
                    if (treeEdge[edge.id]) {
                        unknownCutvalues.get(node.id).add(edge);
                        treeEdgeCount++;
                    }
                }
            }
            if (treeEdgeCount == 1) {
                leafs.add(node);
            }
        }
        // determine cut values
        LEdge toDetermine;
        LNode source, target;
        for (LNode node : leafs) {
            while (unknownCutvalues.get(node.id).size() == 1) {
                // one tree edge with undetermined cut value is incident
                toDetermine = unknownCutvalues.get(node.id).iterator().next();
                cutvalue[toDetermine.id] = 1;
                source = toDetermine.getSource().getNode();
                target = toDetermine.getTarget().getNode();
                for (LPort port : node.getPorts()) {
                    for (LEdge edge : port.getEdges()) {
                        if (!edge.equals(toDetermine)) {
                            if (treeEdge[edge.id]) {
                                // edge is tree edge
                                if (source.equals(edge.getSource().getNode())
                                        || target.equals(edge.getTarget().getNode())) {
                                    // edge has the same direction as toDetermine
                                    cutvalue[toDetermine.id] -= cutvalue[edge.id] - 1;
                                } else {
                                    cutvalue[toDetermine.id] += cutvalue[edge.id] - 1;
                                }
                            } else {
                                // edge is non-tree edge
                                if (node.equals(source)) {
                                    if (edge.getSource().getNode().equals(node)) {
                                        cutvalue[toDetermine.id]++;
                                    } else {
                                        cutvalue[toDetermine.id]--;
                                    }
                                } else {
                                    if (edge.getSource().getNode().equals(node)) {
                                        cutvalue[toDetermine.id]--;
                                    } else {
                                        cutvalue[toDetermine.id]++;
                                    }
                                }
                            }
                        }
                    }
                }
                // remove edge from unknownCutvalues
                unknownCutvalues.get(source.id).remove(toDetermine);
                unknownCutvalues.get(target.id).remove(toDetermine);
                // proceed with next node
                if (source.equals(node)) {
                    node = toDetermine.getTarget().getNode();
                } else {
                    node = toDetermine.getSource().getNode();
                }
            }
        }
    }

    /**
     * Helper method for the network simplex layerer. It determines the cut value of each tree edge,
     * which is defined as follows: If the edge is deleted, the spanning tree breaks into two
     * connected components, the head component containing the target node of the edge and the tail
     * component containing the source node of the edge. The cut value is the sum of the weights of
     * all edges going from the tail to the head component, including the tree edge itself, minus
     * the sum of the weights of all edges from the head to the tail component.
     * 
     * @deprecated This method realizes a naive approach to compute the cut values with a
     *             performance of O(|E|^2). The method {@code cutvalues()} computes the cut values
     *             in linear time and therefore, should be used instead.
     * 
     * @see de.cau.cs.kieler.klay.layered.impl.NetworkSimplexLayerer#cutvalue cutvalue
     * @see de.cau.cs.kieler.klay.layered.impl.NetworkSimplexLayerer#cutvalues() cutvalues()
     */
    @SuppressWarnings("unused")
    private void naiveCutvalues() {

        boolean source, target;
        for (LEdge edge : edges) {
            if (treeEdge[edge.id]) {
                cutvalue[edge.id] = 1;
                for (LEdge cur : edges) {
                    if (!treeEdge[cur.id]) {
                        source = isInHead(cur.getSource().getNode(), edge);
                        target = isInHead(cur.getTarget().getNode(), edge);
                        if (target && !source) {
                            cutvalue[edge.id]++;
                        } else if (source && !target) {
                            cutvalue[edge.id]--;
                        }
                    }
                }
            }
        }
    }

    /**
     * Helper method for the network simplex layerer. It returns a tree edge with a negative cut
     * value or {@code null}, if no such edge exists, meaning that the current layer assignment of
     * all nodes is optimal. Note, that this method returns any edge with a negative cut value. A
     * special preference to an edge with lowest value will not be given.
     * 
     * @return a tree edge with negative cut value or {@code null}, if no such edge exists
     */
    private LEdge leaveEdge() {

        for (LEdge edge : edges) {
            if (treeEdge[edge.id] && cutvalue[edge.id] < 0) {
                return edge;
            }
        }
        return null;
    }

    /**
     * Helper method for the network simplex layerer. It determines an non-tree edge to replace the
     * given tree edge in the spanning tree. All edges going from the head component to the tail
     * component of the edge will be considered. The edge with a minimal amount of slack (i.e. the
     * lowest difference between its current to its minimal length) will be returned.
     * 
     * @param leave
     *            the tree edge to determine a non-tree edge to be replaced with
     * @return a non-tree edge with a minimal amount of slack to replace the given edge
     * @throws IllegalArgumentException
     *             if the input edge is not a tree edge
     */
    private LEdge enterEdge(final LEdge leave) {

        if (!treeEdge[leave.id]) {
            throw new IllegalArgumentException("The input edge is not a tree edge.");
        }

        LEdge replace = null;
        int repSlack = Integer.MAX_VALUE;
        int slack;
        LNode source, target;
        for (LEdge edge : edges) {
            source = edge.getSource().getNode();
            target = edge.getTarget().getNode();
            if (isInHead(source, leave) && !isInHead(target, leave)) {
                // edge is to consider
                slack = layer[target.id] - layer[source.id] - minSpan[edge.id];
                if (slack < repSlack) {
                    repSlack = slack;
                    replace = edge;
                }
            }
        }
        return replace;
    }

    /**
     * Helper method for the network simplex layerer. It exchanges the tree-edge {@code leave} by
     * the non-tree edge {@code enter} and updates all values based on the tree (i.e. performs a new
     * postorder DFS-traversal and updates the cut values).
     * 
     * @param leave
     *            the tree-edge to be replaced
     * @param enter
     *            the non-tree edge to replace the tree edge
     * @throws IllegalArgumentException
     *             if either {@code leave} is no tree edge or {@code enter} is a tree edge already
     * 
     * @see de.cau.cs.kieler.klay.layered.impl.NetworkSimplexLayerer#enterEdge(LEdge) enterEdge()
     * @see de.cau.cs.kieler.klay.layered.impl.NetworkSimplexLayerer#leaveEdge() leaveEdge()
     */
    private void exchange(final LEdge leave, final LEdge enter) {

        if (!treeEdge[leave.id]) {
            throw new IllegalArgumentException("Given leave edge is no tree edge.");
        }
        if (treeEdge[enter.id]) {
            throw new IllegalArgumentException("Given enter edge is a tree edge already.");
        }

        // update tree
        treeEdge[leave.id] = false;
        treeEdge[enter.id] = true;
        int delta = layer[enter.getTarget().getNode().id] - layer[enter.getSource().getNode().id]
                - minSpan[enter.id];
        if (!isInHead(enter.getTarget().getNode(), leave)) {
            delta = -delta;
        }
        for (LNode node : nodes) {
            if (!isInHead(node, leave)) {
                layer[node.id] += delta;
            }
        }
        // update tree-based values
        postOrder = 1;
        Arrays.fill(edgeVisited, false);
        postorderTraversal(nodes.iterator().next());
        cutvalues();
    }

    /**
     * Helper method for the network simplex layerer. It normalizes the layering, i.e. determines
     * the lowest layer assigned to a node and shifts all nodes up or down in the layers
     * accordingly. After termination, the lowest layer assigned to a node will be zeroth (and
     * therefore first) layer. This method returns an integer array indicating how many nodes are
     * assigned to which layer. Note that the total number of layers necessary to layer the graph is
     * indicated thereby, which is the size if the array.
     * 
     * @param mode
     *            if {@code false}, only the amount of nodes in the currently layered connected
     *            component will be considered for determining the layer's filling structure.
     *            Otherwise, all nodes, that have been layered already will be considered.
     * 
     * @return an integer array indicating how many nodes are assigned to which layer
     */
    private int[] normalize(final boolean mode) {

        // determine lowest assigned layer and layer count
        int highest = Integer.MIN_VALUE;
        int lowest = Integer.MAX_VALUE;
        for (LNode node : sources) {
            if (layer[node.id] < lowest) {
                lowest = layer[node.id];
            }
        }
        for (LNode node : sinks) {
            if (layer[node.id] > highest) {
                highest = layer[node.id];
            }
        }
        // normalize and determine layer filling
        int layerID = 0;
        int[] filling = new int[highest - lowest + 1];
        for (LNode node : nodes) {
            layer[node.id] -= lowest;
            filling[layer[node.id]]++;
        }
        if (mode) {
            // also consider nodes of already layered connected components of the graph
            for (Layer eLayer : layeredGraph.getLayers()) {
                filling[layerID++] += eLayer.getNodes().size();
                if (filling.length == layerID) {
                    break;
                }
            }
        }
        return filling;
    }

    /**
     * Helper method for the network simplex layerer. It balances the layering concerning its width,
     * i.e. the number of nodes in each layer. If the graph allows multiple optimal layerings
     * regarding a minimal edge length, this method moves separate nodes to a layer with a minimal
     * amount of currently contained nodes with respect to the retention of feasibility and
     * optimality of the given layering.
     * 
     * @param filling
     *            an integer array indicating how many nodes are currently assigned to each layer
     */
    private void balance(final int[] filling) {

        // determine possible layers
        int newLayer;
        Pair<Integer, Integer> range = null;
        for (LNode node : nodes) {
            if (inDegree[node.id] == outDegree[node.id]) {
                // node might get shifted
                newLayer = layer[node.id];
                range = minimalSpan(node);
                for (int i = layer[node.id] - range.getFirst() + 1; i < layer[node.id]
                        + range.getSecond(); i++) {
                    if (filling[i] < filling[newLayer]) {
                        newLayer = i;
                    }
                }
                // assign new layer
                if (filling[newLayer] < filling[layer[node.id]]) {
                    filling[layer[node.id]]--;
                    filling[newLayer]++;
                    layer[node.id] = newLayer;
                }
            }
        }
    }

    /**
     * Helper method for the network simplex layerer. It puts the specified node into its assigned
     * layer indicated by {@code layer} in the layered graph. If the layered graph does not contain
     * the specified layer (i.e. the number of layers in {@code layeredGraph} is less than the
     * supposed height in the layering), additional layers will be added to match the required
     * amount.
     * 
     * @param node
     *            the node to put into its assigned layer in the layered graph
     * 
     * @see de.cau.cs.kieler.klay.layered.impl.NetworkSimplexLayerer#layeredGraph layeredGraph
     * @see de.cau.cs.kieler.klay.layered.impl.NetworkSimplexLayerer#layer layer
     */
    private void putNode(final LNode node) {

        List<Layer> layers = layeredGraph.getLayers();
        // add additional layers to match required amount
        while (layers.size() <= layer[node.id]) {
            layers.add(layers.size(), new Layer(layeredGraph));
        }
        node.setLayer(layers.get(layer[node.id]));
    }

    /**
     * Helper method for the network simplex layerer. It returns the port that is connected to the
     * opposite side of the specified edge from the viewpoint of the input port.
     * 
     * @param port
     *            the port to get the opposite port from
     * @param edge
     *            the edge to consider when determining the opposite port
     * @return the opposite port from the viewpoint of the given port
     * 
     * @throws IllegalArgumentException
     *             if the input edge is not connected to the input port
     */
    private LPort getOpposite(final LPort port, final LEdge edge) {

        if (edge.getSource().equals(port)) {
            return edge.getTarget();
        } else if (edge.getTarget().equals(port)) {
            return edge.getSource();
        }
        throw new IllegalArgumentException("Input edge is not connected to the input port.");
    }

}

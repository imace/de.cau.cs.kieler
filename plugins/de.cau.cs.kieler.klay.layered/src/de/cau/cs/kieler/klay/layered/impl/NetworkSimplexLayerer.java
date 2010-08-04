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

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import de.cau.cs.kieler.core.alg.AbstractAlgorithm;
import de.cau.cs.kieler.kiml.options.PortType;
import de.cau.cs.kieler.klay.layered.graph.LEdge;
import de.cau.cs.kieler.klay.layered.graph.LNode;
import de.cau.cs.kieler.klay.layered.graph.LPort;
import de.cau.cs.kieler.klay.layered.graph.Layer;
import de.cau.cs.kieler.klay.layered.graph.LayeredGraph;
import de.cau.cs.kieler.klay.layered.modules.ILayerer;

/**
 * The main class of the network simplex layerer component. It offers an algorithm to determine an
 * optimal layering of all nodes in the graph concerning a minimal length of all edges by using the
 * network simplex algorithm described in
 * {@literal Emden R. Gansner, Eleftherios Koutsofios, Stephen
 * C. North, Kiem-Phong Vo: "A Technique for Drawing Directed Graphs", AT&T Bell Laboratories}.
 * 
 * @see de.cau.cs.kieler.klay.layered.modules.ILayerer ILayerer
 * 
 * @author pdo
 */
public class NetworkSimplexLayerer extends AbstractAlgorithm implements ILayerer {

    // ====================== Attributes ======================================

    /** the layered graph all methods in this class operate on. */
    private LayeredGraph layerGraph;

    /** A collection containing all nodes in the graph to layer. */
    private Collection<LNode> layerNodes;

    /** A collection containing all edges in the graph. */
    private Collection<LEdge> layerEdges;

    /**
     * The layer each node is currently assigned to. Note that during layerer execution, the lowest
     * layer is not necessary the zeroth layer. To fulfill this characteristic, a final call of
     * {@code normalize()} has to be performed.
     */
    private int[] layer;

    /**
     * The layer each node is assigned to in the reverse traversal of the graph in
     * {@code layeringDFS()}. Note that this determined layering is only needed to compute the
     * minimal span of each edge in the layering. It will not be reused later.
     */
    private int[] revLayer;

    /**
     * A flag indicating whether a specified node is part of the spanning tree determined by
     * {@code feasibleTree()}.
     */
    private boolean[] treeNode;

    /**
     * A flag indicating whether a specified edge is part of the spanning tree determined by
     * {@code feasibleTree()}.
     */
    private boolean[] treeEdge;

    /**
     * A flag indicating whether a specified edge has been visited during DFS-traversal.
     */
    private boolean[] visited;

    /** The postorder traversal ID of each node determined by {@code postorderTraversal()}. */
    private int[] poID;

    /**
     * The lowest postorder traversal ID of each nodes reachable through a node lower in the
     * traversal tree determined by {@code postorderTraversal}.
     */
    private int[] lowestPoID;

    /**
     * The current postorder traversal number used by {@code postorderTraversal()} used to assign an
     * unique traversal ID to each node.
     */
    private int postOrder;

    /**
     * A {@code LinkedList} containing all source nodes of the graph, i.e. all edges that have no
     * incident incoming edges.
     */
    private LinkedList<LNode> sources;

    /**
     * A {@code LinkedList} containing all sinks of the graph, i.e. all edges that have no incident
     * outgoing edges.
     */
    private LinkedList<LNode> sinks;

    /** The number of all incoming edges incident to each node. */
    private int[] inDegree;

    /** The number of all outgoing edges incident to each node. */
    private int[] outDegree;

    /**
     * The cut value of every edge defined as follows: If the edge is deleted, the spanning tree
     * breaks into two connected components, the head component containing the target node of the
     * edge and the tail component containing the source node of the edge. The cut value is the sum
     * of the weight (here {@code 1}) of all edges going from the tail to the head component,
     * including the tree edge, minus the sum of the weights of all edges from the head to the tail
     * component.
     */
    private int[] cutvalue;

    /** The minimal span of each edge in the layered graph. */
    private int[] tightness;

    // ====================== Constructor =====================================

    /**
     * Default Constructor for {@link NetworkSimplexLayerer}. It creates a new instance of this
     * class.
     */
    public NetworkSimplexLayerer() {
    }

    // ====================== Methods =====================================

    /**
     * Helper method for the network simplex layerer. It instantiates all necessary attributes of
     * this class and initializes them with their default values. If the attributes already exist
     * (i.e. they were created by a previous function call) and if their size fits for the nodes of
     * the current graph, then the old instances will be reused as far as possible.
     * 
     * @param nodes
     *            the nodes in the graph
     * @param edges
     *            the edges in the graph
     */
    private void initialize(final Collection<LNode> nodes, final Collection<LEdge> edges) {

        int numNodes = nodes.size();
        int numEdges = edges.size();

        // re-index nodes and edges
        int counter = 0;
        for (LNode node : nodes) {
            node.id = counter++;
        }
        counter = 0;
        for (LEdge edge : edges) {
            edge.id = counter++;
        }
        // initialize node attributes
        if (layer == null || layer.length < numNodes) {
            layer = new int[numNodes];
            revLayer = new int[numNodes];
            Arrays.fill(revLayer, numNodes);
            treeNode = new boolean[numNodes];
            poID = new int[numNodes];
            lowestPoID = new int[numNodes];
        } else {
            Arrays.fill(layer, 0);
            Arrays.fill(revLayer, numNodes);
            Arrays.fill(treeNode, false);
        }
        // initialize edge attributes
        if (cutvalue == null || cutvalue.length < numEdges) {
            cutvalue = new int[numEdges];
            tightness = new int[numEdges];
            treeEdge = new boolean[numEdges];
            visited = new boolean[numEdges];
        } else {
            Arrays.fill(treeEdge, false);
            Arrays.fill(visited, false);
        }
        postOrder = 1;
    }

/**
     * The main method of the network simplex layerer. It determines an optimal layering of all
     * nodes in the graph concerning a minimal length of all edges by using the network simplex
     * algorithm described in {@literal Emden R. Gansner, Eleftherios Koutsofios, Stephen
     * C. North, Kiem-Phong Vo: "A Technique for Drawing Directed Graphs", AT&T Bell Laboratories.
     * 
     * @param nodes
     *            a {@link Collection} of all nodes of the graph to layer
     * @param layeredGraph
     *            an initially empty layered graph which is filled with layers
     * 
     * @see de.cau.cs.kieler.klay.layered.modules.ILayerer ILayerer
     */
    public void layer(final Collection<LNode> nodes, final LayeredGraph layeredGraph) {

        getMonitor().begin("network simplex layering", 1);
        if (nodes.size() < 1) {
            getMonitor().done();
            return;
        }

        // initialize attributes
        layerGraph = layeredGraph;
        layerNodes = nodes;
        layerEdges = getEdges(nodes);
        initialize(layerNodes, layerEdges);

        // determine feasible tree
        feasibleTree();
        LEdge e = null;
        while ((e = leaveEdge()) != null) {
            // current layering is not optimal
            exchange(e, enterEdge(e));
        }
        normalize();
        balance();

        // put nodes into their assigned layers
        for (LNode node : layerNodes) {
            putNode(node);
        }

        getMonitor().done();
    }

    /**
     * Helper method for the network simplex layerer. It determines an initial feasible (and tight)
     * spanning tree of the graph. To do so, an initial feasible tree is being computed. If all tree
     * edges contained are tight (i.e. their minimal length corresponds with their actual length), a
     * tight tree has already been found. If not, this method iteratively determines a non-tree edge
     * incident to the tree with a minimal amount of slack (i.e. the edge with the lowest difference
     * between its current and minimal length) and shifts all tree edges accordingly to shorten this
     * edge to its minimal size. The edge has become tight and will be added to the spanning tree
     * together with all tight edges leading to non-tree nodes as well. If all nodes of the graph
     * are contained in the spanning tree, a tight tree has been found. A concluding computation of
     * each edge's initial cut value takes place.
     * 
     * @see de.cau.cs.kieler.klay.layered.impl.NetworkSimplexLayerer#tightTreeDFS(LNode)
     *      tightTreeDFS()
     */
    private void feasibleTree() {

        initLayering();
        int a;
        while ((a = tightTreeDFS(layerNodes.iterator().next())) < layerNodes.size()) {
            // not all nodes have been found
            LEdge e = minimalSlack();
            System.out.println("\n\n tightTreeNodes = " + a + " ,minSlackEdge = " + (e == null)
                    + "\n");
            // FIXME e is null here. Why?
            int delta = layer[e.getTarget().getNode().id] - layer[e.getSource().getNode().id]
                    - tightness[e.id];
            if (treeNode[e.getSource().getNode().id]) {
                delta = -delta;
            }
            for (LNode node : layerNodes) {
                if (treeNode[node.id]) {
                    layer[node.id] += delta;
                }
            }
            Arrays.fill(visited, false);
        }
        postorderTraversal(layerNodes.iterator().next());
        naiveCutvalues();
        // TODO change it back

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
     * @see de.cau.cs.kieler.klay.layered.impl.NetworkSimplexLayerer#shiftLeafs() shiftLeafs()
     */
    private void initLayering() {

        // determine initial layering
        for (LNode node : sources) {
            layeringDFS(node, false);
        }
        // determine minimal length of each edge
        for (LNode node : sinks) {
            layeringDFS(node, true);
        }
        for (LEdge edge : layerEdges) {
            tightness[edge.id] = Math.min(layer[edge.getTarget().getNode().id]
                    - layer[edge.getSource().getNode().id], revLayer[edge.getTarget().getNode().id]
                    - revLayer[edge.getSource().getNode().id]);
        }
        // pull sources and sinks closer to its adjacent nodes (first optimization)
        shiftLeafs();
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
     */
    private int tightTreeDFS(final LNode node) {

        int nodeCount = 1;
        treeNode[node.id] = true;
        LNode opposite = null;
        for (LPort port : node.getPorts()) {
            for (LEdge edge : port.getEdges()) {
                opposite = getOpposite(port, edge).getNode();
                if (!visited[edge.id]) {
                    if (treeEdge[edge.id]) {
                        // edge is a tree edge already
                        visited[edge.id] = true;
                        nodeCount += tightTreeDFS(opposite);
                    } else if (!treeNode[opposite.id]
                            && tightness[edge.id] == layer[edge.getTarget().getNode().id]
                                    - layer[edge.getSource().getNode().id]) {
                        // edge is a tight non-tree edge
                        treeEdge[edge.id] = true;
                        visited[edge.id] = true;
                        nodeCount += tightTreeDFS(node);
                    }
                }
            }
        }
        return nodeCount;
    }

    /**
     * Helper method for the network simplex layerer. It returns the non-tree edge incident on the
     * tree with a minimal amount of slack (i.e. an edge with the lowest difference between its
     * current and minimal length) or {@code null}, if no such edge exists.
     * 
     * @return a non-tree edge incident on the tree with a minimal amount of slack or {@code null},
     *         if no such edge exists
     */
    private LEdge minimalSlack() {

        int minSlack = Integer.MAX_VALUE;
        LEdge minSlackEdge = null;
        int curSlack;
        for (LEdge edge : layerEdges) {
            if (!treeEdge[edge.id]
                    && (treeNode[edge.getSource().getNode().id] ^ treeNode[edge.getTarget()
                            .getNode().id])) {
                // edge is non-tree edge and incident on the tree
                curSlack = layer[edge.getTarget().getNode().id]
                        - layer[edge.getSource().getNode().id] - tightness[edge.id];
                if (curSlack < minSlack) {
                    minSlack = curSlack;
                    minSlackEdge = edge;
                }
            }
        }
        return minSlackEdge;
    }

    /**
     * Helper method for the network simplex layerer. It determines the cut value of each tree edge,
     * which is defined as follows: If the edge is deleted, the spanning tree breaks into two
     * connected components, the head component containing the target node of the edge and the tail
     * component containing the source node of the edge. The cut value is the sum of the weight of
     * all edges going from the tail to the head component, including the tree edge itself, minus
     * the sum of the weights of all edges from the head to the tail component.
     */
    private void cutvalues() {
        // TODO
    }

    /**
     * A naive implementation of a cut value determination with a performance of O(|E|^2). For
     * testing only.
     */
    private void naiveCutvalues() {

        boolean source;
        boolean target;
        for (LEdge edge : layerEdges) {
            cutvalue[edge.id]++;
            for (LEdge cur : layerEdges) {
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

    /**
     * Helper method for the network simplex layerer. It shifts all leafs (i.e. source or sink
     * nodes) as close to their adjacent nodes as possible (i.e. the layering remains feasible).
     * Note, that this method is originally not part of the network simplex method. It serves as a
     * first optimization to minimize the number of (partially more expensive) iterations necessary
     * in the main algorithm.
     */
    private void shiftLeafs() {

        if (!sources.isEmpty()) {
            for (LNode node : sources) {
                layer[node.id] += minimalSpan(node, PortType.OUTPUT) - 1;
            }
        }
        if (!sinks.isEmpty()) {
            for (LNode node : sinks) {
                layer[node.id] -= minimalSpan(node, PortType.INPUT) - 1;
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

        for (LEdge edge : layerEdges) {
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
     * minimal difference between its current to its minimal length) will be returned.
     * 
     * @param the
     *            tree edge to determine a non-tree edge to replace with
     * @return a non-tree edge with a minimal amount of slack to replace the given edge
     * @throws IllegalArgumentException
     *             if the input edge is not a tree edge
     */
    private LEdge enterEdge(final LEdge edge) {

        if (!treeEdge[edge.id]) {
            throw new IllegalArgumentException("The input edge is not a tree edge.");
        }

        LEdge replace = null;
        int repSlack = Integer.MAX_VALUE;
        int slack;
        LNode source = null;
        LNode target = null;
        for (LEdge cons : layerEdges) {
            source = cons.getSource().getNode();
            target = cons.getTarget().getNode();
            if (isInHead(source, edge) && !isInHead(target, edge)) {
                // edge is to consider
                slack = layer[cons.getTarget().getNode().id] - layer[cons.getSource().getNode().id]
                        - tightness[cons.id];
                if (slack < repSlack) {
                    repSlack = slack;
                    replace = cons;
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
     * @see de.cau.cs.kieler.klay.layered.impl.NetworkSimplexLayerer#postorderTraversal(LNode)
     *      postorderTraversal()
     * @see de.cau.cs.kieler.klay.layered.impl.NetworkSimplexLayerer#cutvalues() cutvalues()
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
        // update values
        postOrder = 1;
        Arrays.fill(visited, false);
        postorderTraversal(layerNodes.iterator().next());
        naiveCutvalues();
        // TODO change it back
    }

    /**
     * Helper method for the network simplex layerer. It normalizes the layering, i.e. determines
     * the lowest layer assigned to a node and shifts all nodes up or down in the layers
     * accordingly. After termination, the lowest layer assigned to a node will be zeroth (and
     * therefore first) layer.
     */
    private void normalize() {

        // determine lowest assigned layer
        int lowest = Integer.MAX_VALUE;
        for (LNode node : sources) {
            if (layer[node.id] < lowest) {
                lowest = layer[node.id];
            }
        }
        // normalize
        for (LNode node : layerNodes) {
            layer[node.id] -= lowest;
        }
    }

    private void balance() {
        // TODO ??
    }

    /**
     * Helper method for the network simplex layerer. It determines all edges in the graph (i.e. all
     * edges linking two nodes of {@code layerNodes}) and returns them as a {@code Collection}.
     * Furthermore, it determines the number of incoming and outgoing edges of each node (
     * {@code inDegree}, respectively {@code outDegree}) and identifies all sinks and source nodes
     * in the graph and adds them to {@code sinks}, respectively {@code sources}.
     * 
     * @param nodes
     *            a {@code Collection} containing all nodes of the graph
     * @return a {@code Collection} containing all edges of the graph
     * 
     * @see java.util.Collection Collection
     */
    private Collection<LEdge> getEdges(final Collection<LNode> nodes) {

        // initialize required attributes
        if (inDegree == null || inDegree.length < nodes.size()) {
            inDegree = new int[nodes.size()];
            outDegree = new int[nodes.size()];
        } else {
            Arrays.fill(inDegree, 0);
            Arrays.fill(outDegree, 0);
        }
        if (sources == null) {
            sources = new LinkedList<LNode>();
            sinks = new LinkedList<LNode>();
        } else {
            sources.clear();
            sinks.clear();
        }
        // determine edges
        LinkedList<LEdge> edges = new LinkedList<LEdge>();
        for (LNode node : nodes) {
            for (LPort port : node.getPorts()) {
                if (port.getType() == PortType.OUTPUT) {
                    edges.addAll(port.getEdges());
                    outDegree[node.id] += port.getEdges().size();
                } else if (port.getType() == PortType.INPUT) {
                    inDegree[node.id] += port.getEdges().size();
                }
                // ports of type "UNDEFINED" are neglected and should not occur
            }
            if (outDegree[node.id] == 0) {
                sinks.add(node);
            }
            if (inDegree[node.id] == 0) {
                sources.add(node);
            }
        }
        return edges;
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
     */
    private void layeringDFS(final LNode node, final boolean reverse) {

        LNode target = null;
        if (reverse) {
            for (LPort port : node.getPorts(PortType.INPUT)) {
                for (LEdge edge : port.getEdges()) {
                    target = edge.getSource().getNode();
                    revLayer[target.id] = Math.min(revLayer[target.id], revLayer[node.id] - 1);
                    layeringDFS(target, reverse);
                }
            }
        } else {
            for (LPort port : node.getPorts(PortType.OUTPUT)) {
                for (LEdge edge : port.getEdges()) {
                    target = edge.getTarget().getNode();
                    layer[target.id] = Math.max(layer[target.id], layer[node.id] + 1);
                    layeringDFS(target, reverse);
                }
            }
        }
    }

    /**
     * Helper method for the network simplex layerer. It determines the length of the currently
     * shortest incoming respectively outgoing edge of the input node.
     * 
     * @param node
     *            the node to determine the length of its shortest incident edge
     * @param orientation
     *            the orientation of the incident edges. If {@code orientation = PortType.INPUT},
     *            only incoming edges will be considered, and if
     *            {@code orientation = PortType.OUTPUT}, only outgoing edges will be considered for
     *            the determination of the shortest edge length.
     * @return the minimal length all edges of the specified edge type incident to the input node or
     *         {@code -1}, if no such edge is incident
     */
    private int minimalSpan(final LNode node, final PortType orientation) {

        int minSpan = Integer.MAX_VALUE;
        int currentSpan;
        for (LPort port : node.getPorts(orientation)) {
            for (LEdge edge : port.getEdges()) {
                currentSpan = layer[edge.getTarget().getNode().id]
                        - layer[edge.getSource().getNode().id];
                if (currentSpan < minSpan) {
                    minSpan = currentSpan;
                }
            }
        }
        if (minSpan < Integer.MAX_VALUE) {
            return minSpan;
        }
        return -1;
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
     *             if the input port is not connected to the input edge
     */
    private LPort getOpposite(final LPort port, final LEdge edge) {

        if (edge.getSource().equals(port)) {
            return edge.getTarget();
        } else if (edge.getTarget().equals(port)) {
            return edge.getSource();
        }
        throw new IllegalArgumentException("Input port is not connected to the input edge.");
    }

    /**
     * Helper method for the network simplex layerer. It puts the specified node into its assigned
     * layer in the layered graph.
     * 
     * @param node
     *            the node to put into the layered graph
     */
    private void putNode(final LNode node) {

        List<Layer> layers = layerGraph.getLayers();
        for (int i = layers.size(); i < layer[node.id]; i++) {
            layers.add(0, new Layer(layerGraph));
        }
        node.setLayer(layers.get(layers.size() - layer[node.id]));
    }

    /**
     * Helper method for the network simplex layerer. It performs a postorder DFS-traversal of the
     * graph beginning with the first node in the Collection of all graph nodes. Each node will be
     * assigned a unique traversal ID, which will be stored in {@code poID}. Furthermore, the lowest
     * postorder traversal ID of any node in a descending path relative to the input node will be
     * computed and stored in {@code lowestPoID}, which is also the return value of this method.
     * 
     * @param node
     *            the root of the DFS-subtree
     * @return the lowest post-order ID of any descending edge in the depth-first-search
     */
    private int postorderTraversal(final LNode node) {

        int lowest = Integer.MAX_VALUE;
        for (LPort port : node.getPorts()) {
            for (LEdge edge : port.getEdges()) {
                if (treeEdge[edge.id] && !visited[edge.id]) {
                    visited[edge.id] = true;
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
     * component. A third possibility does not exist. Therefore, if the node is not part of the head
     * component, it must be part of the tail component and vice versa.
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
        if (poID[source.id] < poID[edge.getTarget().getNode().id]) {
            // root is in the head component
            if (lowestPoID[source.id] <= poID[node.id] && poID[node.id] <= poID[source.id]) {
                return false;
            }
            return true;
        }
        // root is in the tail component
        if (lowestPoID[source.id] >= poID[node.id] && poID[node.id] >= poID[source.id]) {
            return false;
        }
        return true;
    }

}

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
package de.cau.cs.rtprak.planarization.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import de.cau.cs.kieler.core.alg.AbstractAlgorithm;
import de.cau.cs.kieler.core.util.Pair;
import de.cau.cs.rtprak.planarization.IPlanarizer;
import de.cau.cs.rtprak.planarization.graph.IEdge;
import de.cau.cs.rtprak.planarization.graph.IFace;
import de.cau.cs.rtprak.planarization.graph.IGraph;
import de.cau.cs.rtprak.planarization.graph.INode;
import de.cau.cs.rtprak.planarization.graph.InconsistentGraphModelException;

/**
 * Inserts an edge in a planar graph by building the dual graph. In this graph shortest path is
 * determined. To get the shortest path we test diffrent start- and targetfaces. The algorithm
 * follow this path with the faces in the given graph and splits up every edge to cross with a new
 * node. Then these nodes get connected and build a path which presents the given insertion edge. So
 * the graph is still planar.
 * 
 * @author cku
 * 
 */
public class EdgeInsertionPlanarization extends AbstractAlgorithm implements IPlanarizer {

    /**
     * Inserts a list of given pairs of nodes (that presemt edges) into a given planar embedding of
     * a graph.
     * 
     * {@inheritDoc}
     * 
     * @see de.cau.cs.kieler.core.util.Pair Pair
     */
    @SuppressWarnings("static-access")
    public void planarize(final IGraph graph, final List<Pair<INode, INode>> edges)
            throws InconsistentGraphModelException {

        for (Pair<INode, INode> insertingEdge : edges) {

            IGraph dualGraph = graph.createDualGraph();
            LinkedList<INode> dualPath = new LinkedList<INode>();

            INode source = insertingEdge.getFirst();
            INode target = insertingEdge.getSecond();

            // assert sourceFaceID != targetFaceID : "nodes lie at the same face";

            INode dualStartNode = null;
            INode dualTargetNode = null;

            IFace targetFace = null;

            HashSet<IFace> sourceFaces = findSurroundingFaces(source);
            HashSet<IFace> targetFaces = findSurroundingFaces(target);

            ArrayList<IFace> facePath = new ArrayList<IFace>();
            ArrayList<IFace> shortestFacePath = new ArrayList<IFace>();
            LinkedList<INode> shortestDualPath = new LinkedList<INode>();

            int[] parent = new int[graph.getFaceCount()];

            // check all start nodes for BFS in dual graph
            for (IFace sourceFace : sourceFaces) {
                facePath.clear();

                dualStartNode = sourceFace.getData(graph.TODUALGRAPH);

                // run BFS for all possible target faces
                for (IFace itargetFace : targetFaces) {

                    dualTargetNode = itargetFace.getData(graph.TODUALGRAPH);

                    parent = bfs(dualStartNode, dualTargetNode, dualGraph);

                    // the path through the dual graph
                    dualPath = findPath(dualTargetNode.getID(), parent, dualGraph);

                    if (shortestDualPath.size() > dualPath.size() || shortestDualPath.isEmpty()) {
                        shortestDualPath.addAll(0, dualPath);
                        targetFace = itargetFace;
                    }
                }

                // same path with faces in the normal graph
                facePath.add(sourceFace);

                for (INode node : shortestDualPath) {
                    IFace face = dualNodeToFace(node, graph);
                    if (face.getID() != sourceFace.getID()) {
                        facePath.add(face);
                    }

                }
                if (!facePath.contains(targetFace)) {
                    facePath.add(targetFace);
                }

                // we found a better startface with shorter path
                if (shortestFacePath.size() > facePath.size() || shortestFacePath.isEmpty()) {
                    shortestFacePath.addAll(0, facePath);
                }

                // path can't be shorter then 1, search finished
                if (shortestFacePath.size() == 1) {
                    break;
                }
            }
            System.out.println("Der Face Path:");
            System.out.println(shortestFacePath.toString());

            // find the borders to cross
            LinkedList<IEdge> crossingBorders = new LinkedList<IEdge>();
            int faceCounter = 0;
            while (faceCounter < shortestFacePath.size() - 1) {
                IFace face1 = shortestFacePath.get(faceCounter);
                IFace face2 = shortestFacePath.get(faceCounter + 1);
                IEdge crossingEdge = findBorderEdge(face1, face2);
                crossingBorders.add(crossingEdge);
                faceCounter++;

            }

            // the node path with new nodes for the crossing edges
            ArrayList<INode> path = new ArrayList<INode>();
            path.add(source);
            for (IEdge crossingEdge : crossingBorders) {
                INode newNode = graph.addNode(crossingEdge);
                path.add(newNode);
            }
            path.add(target);

            // connect the node path
            int pathNodeCounter = 0;
            while (pathNodeCounter < path.size() - 1) {
                IEdge newEdge = graph.addEdge(path.get(pathNodeCounter), path
                        .get(pathNodeCounter + 1));

                reinsertEdges(shortestFacePath.get(pathNodeCounter), newEdge, path
                        .get(pathNodeCounter));
                pathNodeCounter++;
            }
        }
    }

    /**
     * finds all faces, that contact the node.
     * 
     * @param node
     *            , the given node
     * @return faces, all faces that contact the node
     * @throws InconsistentGraphModelException
     */
    private HashSet<IFace> findSurroundingFaces(final INode node)
            throws InconsistentGraphModelException {
        HashSet<IFace> faces = new HashSet<IFace>();
        for (IEdge edge : node.getAllEdges()) {
            faces.add(edge.getLeftFace());
            faces.add(edge.getRightFace());

        }
        return faces;
    }

    /**
     * brings the edges of a node in the right order for an embedding.
     * 
     * @param edge
     *            , the new edge
     * @param node
     *            , the given node
     * 
     * @throws InconsistentGraphModelException
     */
    private void reinsertEdges(final IFace face, final IEdge edge, final INode node)
            throws InconsistentGraphModelException {

        IEdge preNewEdge = findFirstFaceEdge(edge, node);
        List<IEdge> edges = new LinkedList<IEdge>();
        edges.addAll(node.getEdgeList());
        int index = 0;
        for (IEdge iedge : edges) {
            if (iedge == preNewEdge) {
                // move the given edge in right position
                edge.move(node, node);
                // move the rest of the edges after the given edge
                if (index < edges.size() - 1) {
                    for (IEdge iEdge : edges.subList(index + 1, edges.size() - 1)) {
                        iEdge.move(node, node);

                    }
                    break;
                }
            }
            index++;
        }
    }

    /**
     * returns the first clockwise edge of a face from a given node.
     * 
     * @param face
     *            , the given face
     * @param node
     *            , the gven node
     * @return edge, the clockwise first edge at this node
     * @throws InconsistentGraphModelException
     */
    private IEdge findFirstFaceEdge(final IEdge iedge, final INode node)
            throws InconsistentGraphModelException {
        IFace face = iedge.getLeftFace();
        for (IEdge edge : node.getAllEdges()) {
            if (edge.getRightFace() == face || edge.getLeftFace() == face) {
                return edge;
            }
        }
        return null;
    }

    /**
     * finds the borderEdge between 2 faces.
     * 
     * @param face1
     *            , the first face
     * @param face2
     *            , the second face
     * @return edge1, the borderEdge
     */
    private IEdge findBorderEdge(final IFace face1, final IFace face2) {
        for (IEdge edge1 : face1.getEdges()) {
            for (IEdge edge2 : face2.getEdges()) {
                if (edge1.getID() == edge2.getID()) {
                    return edge1;
                }
            }
        }
        return null;
    }

    /**
     * finds the suiting face in the graph with a given node from the dual graph.
     * 
     * @param node
     *            , the given node
     * @param graph
     *            , the given graph
     * @return face, the searched face
     * @throws InconsistentGraphModelException
     */
    private IFace dualNodeToFace(final INode node, final IGraph graph)
            throws InconsistentGraphModelException {
        for (IFace face : graph.getFaces()) {
            if (node.getID() == face.getID()) {
                return face;
            }
        }
        return null;
    }

    /**
     * builds a path from the target node to the source node.
     * 
     * @param sourceIndex
     *            , the index of the source node
     * @param targetIndex
     *            , the index of the target node
     * @param parent
     *            , the array of parents
     * @param graph
     *            , the given graph
     * 
     * @return path, a list of nodes from source to target
     */
    private LinkedList<INode> findPath(final int targetIndex, final int[] parent, final IGraph graph) {

        LinkedList<INode> path = new LinkedList<INode>();
        int nextID = parent[targetIndex];

        while (nextID != -1) {
            INode nextNode = findNode(nextID, graph.getNodes());
            path.add(nextNode);
            nextID = parent[nextNode.getID()];
        }
        return path;
    }

    /**
     * finds a node by his id in a given LinkedList.
     * 
     * @param index
     *            , the given index
     * @param iterable
     *            , the given list
     * @return node, the searched node
     */
    private INode findNode(final int nodeID, final Iterable<INode> iterable) {
        for (INode node : iterable) {
            if (node.getID() == nodeID) {
                return node;
            }

        }
        return null;
    }

    /**
     * searches all distances and parents from the root in the given graph.
     * 
     * @param root
     *            , the start node
     * @param graph
     *            , the given graph
     * @return parent , array with the parents from root to all nodes
     */
    private int[] bfs(final INode root, final INode target, final IGraph graph) {
        int size = graph.getNodeCount();
        int rootID = root.getID();
        int targetID = target.getID();

        // initialize arrays
        int[] parent = new int[size];
        int[] distance = new int[size];
        boolean[] visited = new boolean[size];

        for (int i = 0; i < size; i++) {
            parent[i] = -1;
            distance[i] = -1;
            visited[i] = false;
        }

        parent[rootID] = -1;
        visited[rootID] = true;
        distance[rootID] = 0;

        // start BFS
        LinkedList<INode> queue = new LinkedList<INode>();
        queue.add(root);

        while (!queue.isEmpty()) {

            INode currentNode = queue.poll();
            int currentID = currentNode.getID();

            // BFS can stop if we reached the target
            if (currentID == targetID) {
                return parent;
            }

            // find all neighbors and put them in an array
            INode[] neighbors = new INode[currentNode.getAdjacentEdgeCount()];
            int neighborCounter = 0;

            for (INode neighborNode : currentNode.getAdjacentNodes()) {
                neighbors[neighborCounter] = neighborNode;
                neighborCounter++;
            }

            // find the neighbors and get parent and distance
            for (int i = 0; i < neighbors.length; i++) {
                INode neighbor = neighbors[i];
                int neighborIndex = neighbor.getID();
                if (!visited[neighborIndex]) {
                    parent[neighborIndex] = currentID;
                    distance[neighborIndex] = distance[currentID] + 1;
                    visited[neighborIndex] = true;
                    queue.add(neighbor);
                }
                visited[currentID] = true;
            }
        }
        return parent;
    }

}

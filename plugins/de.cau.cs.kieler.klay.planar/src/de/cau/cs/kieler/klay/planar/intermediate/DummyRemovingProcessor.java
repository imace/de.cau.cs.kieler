/*
 * KIELER - Kiel Integrated Environment for Layout Eclipse RichClient
 *
 * http://www.informatik.uni-kiel.de/rtsys/kieler/
 * 
 * Copyright 2010 - 2012 by
 * + Christian-Albrechts-University of Kiel
 *   + Department of Computer Science
 *     + Real-Time and Embedded Systems Group
 * 
 * This code is provided under the terms of the Eclipse Public License (EPL).
 * See the file epl-v10.html for the license text.
 */
package de.cau.cs.kieler.klay.planar.intermediate;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.google.common.collect.Lists;

import de.cau.cs.kieler.core.alg.AbstractAlgorithm;
import de.cau.cs.kieler.core.kgraph.KEdge;
import de.cau.cs.kieler.core.math.KVector;
import de.cau.cs.kieler.core.math.KVectorChain;
import de.cau.cs.kieler.klay.planar.ILayoutProcessor;
import de.cau.cs.kieler.klay.planar.graph.InconsistentGraphModelException;
import de.cau.cs.kieler.klay.planar.graph.PEdge;
import de.cau.cs.kieler.klay.planar.graph.PGraph;
import de.cau.cs.kieler.klay.planar.graph.PNode;
import de.cau.cs.kieler.klay.planar.properties.Properties;

/**
 * Removes dummy nodes and dummy edges which are inserted while the algorithms. At the state of art
 * planar dummy nodes, rectangular shape dummy nodes and bend points dummies are removed. At the
 * beginning of the algorithm planar dummies are inserted, then bend point are added while the
 * orthogonalization step and then the rectangular shape dummies are added. The dummies have to be
 * removed in reversed order, meaning firstly rectangular shape dummies, secondly bend point dummies
 * and finally the planar dummy nodes.
 * 
 * @author pkl
 */
public class DummyRemovingProcessor extends AbstractAlgorithm implements ILayoutProcessor {

    /** The graph which is changed during the processor. */
    private PGraph graph;

    /** The grid that is changed during the processor. */
    private GridRepresentation grid;

    /**
     * {@inheritDoc}
     */
    public void process(final PGraph pGraph) {
        getMonitor().begin("Remove dummynodes", 1);

        this.graph = pGraph;
        this.grid = graph.getProperty(Properties.GRID_REPRESENTATION);

        removeRectShapeDummies();

        removeBendDummies();

        removePlanarDummies();

        getMonitor().done();
    }

    /**
     * Goes through the grid and constructs bend point for every dummy node.
     */
    private void removeBendDummies() {
        // construct bendpoints for each node for which there is no original node.
        for (int x = 0; x < grid.getWidth(); x++) {
            for (int y = 0; y < grid.getHeight(); y++) {
                if (grid.get(x, y) != null && grid.get(x, y).hasProperties()
                        && (grid.get(x, y).getProperty(Properties.BENDPOINT) != null)) {
                    constructBendPointEdge(x, y);
                }
            }
        }

    }

    /**
     * Removes a bend point dummy from the grid and adds it as bend point the edge, that is original
     * meaning contains a {@link KEdge} as property, otherwise choose a arbitrary one.
     * 
     * @param x
     *            index of the grid of the bend point dummy.
     * @param y
     *            index of the grid of the bend point dummy.
     */
    private void constructBendPointEdge(final int x, final int y) {
        PNode currentNode = grid.get(x, y);
        Iterator<PEdge> nodeIterator = currentNode.getEdges().iterator();

        PEdge first = nodeIterator.next();
        PNode firstNode = first.getOppositeNode(currentNode);
        PEdge second = nodeIterator.next();
        PNode secondNode = second.getOppositeNode(currentNode);

        if (first.hasProperties() && first.getProperty(Properties.ORIGIN) != null) {
            first.getBendPoints().add(x, y);
            this.graph.bridgeOverEdge(first, firstNode, secondNode);
            addBendsToEdge(first, second.getBendPoints(), null);
        } else {
            second.getBendPoints().add(x, y);
            this.graph.bridgeOverEdge(second, secondNode, firstNode);
            addBendsToEdge(second, first.getBendPoints(), null);
        }
        graph.removeNode(currentNode);
        grid.remove(currentNode);
    }

    /**
     * Searches rectangle shape dummy nodes. Remove the dummy edges around the dummy nodes and then
     * the dummy nodes themselves.
     */
    private void removeRectShapeDummies() {
        // Remove rectshape dummies
        List<PNode> dummyNodes = Lists.newLinkedList();
        for (PNode pNode : graph.getNodes()) {
            if (pNode.hasProperties() && pNode.getProperty(Properties.RECT_SHAPE_DUMMY) != null) {
                dummyNodes.add(pNode);
            }
        }

        PEdge removableEdge = null;
        for (PNode dummy : dummyNodes) {
            for (PEdge edge : dummy.adjacentEdges()) {
                if (edge.hasProperties() && edge.getProperty(Properties.RECT_SHAPE_DUMMY) != null) {
                    // Only the rect shape dummy edge has this property.
                    removableEdge = edge;
                    break;
                }
            }

            graph.removeEdge(removableEdge);
            Iterator<PEdge> edgeIt;
            switch (dummy.getAdjacentEdgeCount()) {
            case 0:
                // nothing to do
                break;
            case 1:
                edgeIt = dummy.adjacentEdges().iterator();
                graph.removeEdge(edgeIt.next());
                break;
            case 2:
                edgeIt = dummy.adjacentEdges().iterator();
                PEdge first = edgeIt.next();
                PEdge second = edgeIt.next();

                // Check for origin is needed, because the original edge should is kept.
                if (first.hasProperties() && first.getProperty(Properties.ORIGIN) != null) {
                    graph.bridgeOverEdge(first, first.getOppositeNode(dummy),
                            second.getOppositeNode(dummy));
                } else {
                    // Use the second edge otherwise, if it is origin or not.
                    graph.bridgeOverEdge(second, second.getOppositeNode(dummy),
                            first.getOppositeNode(dummy));
                }
                break;
            default:
                throw new InconsistentGraphModelException("This should not happen here! :-)");
            }
            grid.remove(dummy);
            graph.removeNode(dummy);
        }

        // Dummy edges can be exist without dummy nodes.
        List<PEdge> dummyEdges = new LinkedList<PEdge>();
        for (PEdge pEdge : graph.getEdges()) {
            if (pEdge.hasProperties() && pEdge.getProperty(Properties.RECT_SHAPE_DUMMY) != null) {
                dummyEdges.add(pEdge);
            }
        }

        for (PEdge dummy : dummyEdges) {
            graph.removeEdge(dummy);
        }

        // update grid.
        Boolean isExtFaceTransformed = this.graph.getProperty(Properties.RECT_SHAPE_TRANS_EXTERNAL);
        if (isExtFaceTransformed != null && isExtFaceTransformed.booleanValue()) {
            // The old grid is to big, the external nodes were dummies and has been removed in this
            // step. Create a new grid with smaller size.
            GridRepresentation newGrid = new GridRepresentation(this.grid.getWidth() - 2,
                    this.grid.getHeight() - 2);
            for (int x = 1; x < grid.getWidth() - 1; x++) {
                for (int y = 1; y < grid.getHeight() - 1; y++) {
                    newGrid.set(x - 1, y - 1, this.grid.get(x, y));
                }
            }

            this.grid = newGrid;
            this.graph.setProperty(Properties.GRID_REPRESENTATION, newGrid);

        }

    }

    /**
     * Searches for planar dummy nodes. Bridges the edges around that node and removes the node from
     * graph and grid.
     */
    private void removePlanarDummies() {
        List<PNode> planarDummynodes = new LinkedList<PNode>();
        for (PNode node : graph.getNodes()) {
            if (node.hasProperties() && node.getProperty(Properties.PLANAR_DUMMY_NODE) != null) {
                planarDummynodes.add(node);
            }
        }

        for (PNode dummyNode : planarDummynodes) {
            Iterator<PEdge> iterator = dummyNode.adjacentEdges().iterator();
            PEdge first = iterator.next();
            PEdge second = iterator.next();
            PEdge third = iterator.next();
            PEdge fourth = iterator.next();

            // move the original edge over the dummy node from source to new target or vice versa
            // according to the edge direction. Edge 0 and 2 are straight to each other so that
            // we can move the edge from source 0 to target 2 or vice versa.
            doPlanarRemoveStep(dummyNode, first, third);

            // do the same to the edges 1 and 3.
            doPlanarRemoveStep(dummyNode, second, fourth);

            graph.removeNode(dummyNode);
            grid.remove(dummyNode);
        }
    }

    /**
     * Bridge the edges of a dummy node. Thereby one of the edges is deleted and the other edge is
     * moved around the dummy node. The both parameter edges have to be straight to each other.
     * 
     * @param dummyNode
     *            {@link PNode}
     * @param first
     *            {@link PEdge} adjacent to dummy node
     * @param second
     *            {@link PEdge} adjacent to dummy node
     */
    private void doPlanarRemoveStep(final PNode dummyNode, final PEdge first, final PEdge second) {
        if (first.hasProperties() && first.getProperty(Properties.ORIGIN) != null) {
            first.getBendPoints().addAll(second.getBendPoints());
            graph.bridgeOverEdge(first, first.getOppositeNode(dummyNode),
                    second.getOppositeNode(dummyNode));
        } else if (second.hasProperties() && second.getProperty(Properties.ORIGIN) != null) {
            graph.bridgeOverEdge(second, second.getOppositeNode(dummyNode),
                    first.getOppositeNode(dummyNode));
            addBendsToEdge(second, first.getBendPoints(), dummyNode);
        } else {
            graph.bridgeOverEdge(first, first.getOppositeNode(dummyNode),
                    second.getOppositeNode(dummyNode));
            addBendsToEdge(first, second.getBendPoints(), dummyNode);

            List<PEdge> insertableEdges = graph.getProperty(Properties.INSERTABLE_EDGES);
            for (PEdge pEdge : insertableEdges) {
                if (first.getSource() == pEdge.getSource()
                        && first.getTarget() == pEdge.getTarget()) {
                    first.setProperty(Properties.ORIGIN, pEdge.getProperty(Properties.ORIGIN));
                    break;
                }
            }
        }
    }

    /**
     * Adds a {@link KVectorChain} of bendpoints to the edge bendpoints. Additionally orders them to
     * their correct positions.
     * 
     * @param edge
     *            the edge to that the bendpoints shell added.
     * @param newBendPoints
     *            the new bendpoints to add.
     * @param exceptionNode
     *            during the planarization, there is the dummynode on the road, this has to be
     *            ignored.
     */
    public void addBendsToEdge(final PEdge edge, final KVectorChain newBendPoints,
            final PNode exceptionNode) {
        edge.getBendPoints().addAll(newBendPoints);

        if (edge.getBendPoints().size() > 1) {

            int[] sourceCoordinates = this.grid.search(edge.getSource());

            double startX = (double) sourceCoordinates[0];
            double startY = (double) sourceCoordinates[1];

            KVectorChain myBendPoints = new KVectorChain(edge.getBendPoints());
            edge.removeBendPoints();

            double value = 0.0;
            double end = 0.0;

            KVector foundVec = null;
            boolean found = false;
            while (!myBendPoints.isEmpty()) {
                // Search the next bendpoint
                out: for (KVector vec : myBendPoints) {
                    found = false;
                    if (vec.x == startX) {
                        found = true;
                        if (vec.y < startY) {
                            value = vec.y;
                            end = startY;
                        } else {
                            value = startY;
                            end = vec.y;
                        }

                        value++;
                        while (value < end) {
                            PNode pNode = grid.get((int) startX, (int) value);
                            if (pNode != null && pNode != exceptionNode) {
                                // there is another node.
                                continue out;
                            }
                            value++;
                        }

                    } else if (vec.y == startY) {
                        found = true;
                        if (vec.x < startX) {
                            value = vec.x;
                            end = startX;
                        } else {
                            value = startX;
                            end = vec.x;
                        }

                        value++;
                        while (value < end) {
                            PNode pNode = grid.get((int) value, (int) startY);
                            if (pNode != null && (exceptionNode == null || pNode != exceptionNode)) {
                                // there is another node.
                                continue out;
                            }
                            value++;
                        }

                    }
                    if (found) {
                        foundVec = vec;
                        break;
                    }
                }
                if (!found) {
                    // TODO Assertion found has to be true here. Otherwise the graphmodel is
                    // inconsistent.
                }
                // If not continued add vec to bend data.
                startX = foundVec.x;
                startY = foundVec.y;
                edge.getBendPoints().add(foundVec);
                myBendPoints.remove(foundVec);
            }
        }
    }

}

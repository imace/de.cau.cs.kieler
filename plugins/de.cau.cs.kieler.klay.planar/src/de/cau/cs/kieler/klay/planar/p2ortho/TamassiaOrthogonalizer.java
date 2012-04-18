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
package de.cau.cs.kieler.klay.planar.p2ortho;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import de.cau.cs.kieler.core.alg.AbstractAlgorithm;
import de.cau.cs.kieler.core.properties.Property;
import de.cau.cs.kieler.core.util.Pair;
import de.cau.cs.kieler.klay.planar.ILayoutPhase;
import de.cau.cs.kieler.klay.planar.IntermediateProcessingStrategy;
import de.cau.cs.kieler.klay.planar.flownetwork.IFlowNetworkSolver;
import de.cau.cs.kieler.klay.planar.flownetwork.SuccessiveShortestPathFlowSolver;
import de.cau.cs.kieler.klay.planar.graph.IGraphFactory;
import de.cau.cs.kieler.klay.planar.graph.InconsistentGraphModelException;
import de.cau.cs.kieler.klay.planar.graph.PEdge;
import de.cau.cs.kieler.klay.planar.graph.PFace;
import de.cau.cs.kieler.klay.planar.graph.PGraph;
import de.cau.cs.kieler.klay.planar.graph.PGraphElement;
import de.cau.cs.kieler.klay.planar.graph.PGraphFactory;
import de.cau.cs.kieler.klay.planar.graph.PNode;
import de.cau.cs.kieler.klay.planar.p2ortho.OrthogonalRepresentation.OrthogonalAngle;
import de.cau.cs.kieler.klay.planar.pathfinding.IPathFinder;
import de.cau.cs.kieler.klay.planar.properties.Properties;

/**
 * Orthogonalizer based on the bend minimizing algorithm for 4-planar graphs by R. Tamassia. Note
 * that this orthogonalizer works only on planar graphs with a degree of at most 4.
 * 
 * @author ocl
 * @author pkl
 */
public class TamassiaOrthogonalizer extends AbstractAlgorithm implements ILayoutPhase {

    // ======================== Constants ==========================================================

    /** Property to convert a node in the flow network to a node or face in the graph. */
    public static final Property<PGraphElement> NETWORKTOGRAPH = new Property<PGraphElement>(
            "de.cau.cs.kieler.klay.planar.properties.networktograph");

    /** The maximal node degree in an orthogonal layout. */
    public static final int MAXDEGREE = 4;

    // ======================== Attributes =========================================================

    /** The graph the algorithm works on. */
    private PGraph graph;

    /**
     * The arcs in the flow network from a node to an adjacent face. The flow in these arcs specify
     * the sum of angles at the source node in the target face.
     */
    private LinkedList<PEdge> nodeArcs;

    /**
     * The arcs in the flow network from a face to an adjacent face. The flow in these arcs specify
     * the number of bends along the edge between the two faces. For every two faces, there are two
     * arcs, one for each direction.
     */
    private LinkedList<Pair<PEdge, PEdge>> faceArcs;

    // ======================== Algorithm ==========================================================

    /**
     * This takes a planar graph and computes an orthogonal representation defining the shape of the
     * orthogonal graph.
     * 
     * @param g
     *            the graph to draw as orthogonal graph
     * @return an orthogonal representation of the graph
     */
    public OrthogonalRepresentation orthogonalize(final PGraph g) {
        getMonitor().begin("Orthogonalization", 1);

        // Initialization
        this.graph = g;

        // Solve flow network and compute orthogonal representation
        PGraph network = this.createFlowNetwork();
        IFlowNetworkSolver solver = new SuccessiveShortestPathFlowSolver();
        solver.findFlow(network);
        OrthogonalRepresentation orthogonal = this.computeAngles(network);

        getMonitor().done();
        return orthogonal;
    }

    /**
     * Create the flow network base upon the graph. The flow network contains a source node for
     * every node in the graph and a sink node for every face. It contains an arc for every node and
     * every face adjacent to a face in the graph. The minimum cost flow problem on the resulting
     * network describe the bend minimizing problem on the graph
     * 
     * @return the flow network to compute the minimal number of bends
     */
    private PGraph createFlowNetwork() {
        IGraphFactory factory = new PGraphFactory();
        PGraph network = factory.createEmptyGraph();
        HashMap<PNode, PNode> nodes = new HashMap<PNode, PNode>();
        HashMap<PFace, PNode> faces = new HashMap<PFace, PNode>();
        this.nodeArcs = new LinkedList<PEdge>();
        this.faceArcs = new LinkedList<Pair<PEdge, PEdge>>();

        // Creating source nodes for every graph node
        for (PNode node : this.graph.getNodes()) {
            int supply = MAXDEGREE - node.getAdjacentEdgeCount();

            // Check if node has a valid degree
            if (supply < 0) {
                throw new IllegalArgumentException("The node " + node.id
                        + ") has a higher degree than the maximal allowed " + MAXDEGREE);
            }

            PNode newnode = network.addNode();
            newnode.setProperty(NETWORKTOGRAPH, node);
            newnode.setProperty(IFlowNetworkSolver.SUPPLY, supply);
            nodes.put(node, newnode);
        }

        // Creating sink nodes for every graph face
        boolean internal = false;
        for (PFace face : this.graph.getFaces()) {
            int supply = -1 * face.getAdjacentNodeCount();
            if (internal) {
                supply += MAXDEGREE;
            } else {
                internal = true;
                supply -= MAXDEGREE;
            }

            PNode newnode = network.addNode();
            newnode.setProperty(NETWORKTOGRAPH, face);
            newnode.setProperty(IFlowNetworkSolver.SUPPLY, supply);
            faces.put(face, newnode);
        }

        // Creating arcs for every node adjacent to the face
        for (PFace face : this.graph.getFaces()) {
            for (PNode node : face.adjacentNodes()) {
                if (!nodes.containsKey(node)) {
                    throw new InconsistentGraphModelException(
                            "Attempted to link non-existent nodes by an edge.");
                }
                PEdge newedge = network.addEdge(nodes.get(node), faces.get(face), true);
                newedge.setProperty(IFlowNetworkSolver.CAPACITY, MAXDEGREE);
                newedge.setProperty(IFlowNetworkSolver.FLOW, 1);
                newedge.setProperty(IPathFinder.PATHCOST, 0);
                this.nodeArcs.add(newedge);
            }
        }

        // Creating arcs for every face adjacent to the face
        for (PEdge edge : this.graph.getEdges()) {
            PFace left = edge.getLeftFace();
            PFace right = edge.getRightFace();

            if (!faces.containsKey(left) || !faces.containsKey(right)) {
                throw new InconsistentGraphModelException(
                        "Attempted to link non-existent nodes by an edge.");
            }

            PEdge edgeLeft = network.addEdge(faces.get(left), faces.get(right), true);
            edgeLeft.setProperty(IFlowNetworkSolver.CAPACITY, Integer.MAX_VALUE);
            edgeLeft.setProperty(IPathFinder.PATHCOST, 1);
            PEdge edgeRight = network.addEdge(faces.get(right), faces.get(left), true);
            edgeRight.setProperty(IFlowNetworkSolver.CAPACITY, Integer.MAX_VALUE);
            edgeRight.setProperty(IPathFinder.PATHCOST, 1);
            this.faceArcs.add(new Pair<PEdge, PEdge>(edgeLeft, edgeRight));
        }

        return network;
    }

    /**
     * Compute bend points and edge angles based on flow in flow network.
     * 
     * @return an orthogonal representation encoding the graph shape
     */
    private OrthogonalRepresentation computeAngles(final PGraph network) {
        OrthogonalRepresentation orthogonal = new OrthogonalRepresentation();

        // Flow in face arcs define bends in edges
        for (Pair<PEdge, PEdge> pair : this.faceArcs) {
            PFace face1 = (PFace) pair.getFirst().getSource().getProperty(NETWORKTOGRAPH);
            if (face1 != pair.getSecond().getTarget().getProperty(NETWORKTOGRAPH)) {
                throw new InconsistentGraphModelException(
                        "The flow network has not been build correctly.");
            }
            PFace face2 = (PFace) pair.getSecond().getSource().getProperty(NETWORKTOGRAPH);
            if (face2 != pair.getFirst().getTarget().getProperty(NETWORKTOGRAPH)) {
                throw new InconsistentGraphModelException(
                        "The flow network has not been build correctly.");
            }

            OrthogonalAngle[] bends1;
            OrthogonalAngle[] bends2;
            int flow1 = pair.getFirst().getProperty(IFlowNetworkSolver.FLOW);
            int flow2 = pair.getSecond().getProperty(IFlowNetworkSolver.FLOW);
            if (face1 == face2) {
                bends1 = new OrthogonalAngle[flow1];
                bends2 = new OrthogonalAngle[flow2];
                Arrays.fill(bends1, OrthogonalAngle.RIGHT);
                Arrays.fill(bends2, OrthogonalAngle.LEFT);
            } else {
                bends1 = new OrthogonalAngle[flow1 + flow2];
                for (int i = 0; i < flow1; i++) {
                    bends1[i] = OrthogonalAngle.RIGHT;
                }
                for (int i = flow1; i < bends1.length; i++) {
                    bends1[i] = OrthogonalAngle.LEFT;
                }
                bends2 = new OrthogonalAngle[flow2 + flow1];
                for (int i = 0; i < flow2; i++) {
                    bends2[i] = OrthogonalAngle.RIGHT;
                }
                for (int i = flow2; i < bends2.length; i++) {
                    bends2[i] = OrthogonalAngle.LEFT;
                }
            }

            boolean first = true;
            for (PEdge edge : face1.getEdges(face2)) {
                if (first) {
                    first = false;

                    if ((face1 == edge.getRightFace()) && (face2 == edge.getLeftFace())) {
                        orthogonal.setBends(edge, bends1);
                    } else if ((face1 == edge.getLeftFace()) && (face2 == edge.getRightFace())) {
                        orthogonal.setBends(edge, bends2);
                    } else {
                        throw new InconsistentGraphModelException(
                                "The flow network has not been build correctly.");
                    }
                } else {
                    OrthogonalAngle[] bends = new OrthogonalAngle[0];
                    orthogonal.setBends(edge, bends);
                }
            }
        }

        // Flow in node arcs define angles in nodes
        for (PEdge arc : this.nodeArcs) {
            PNode node = (PNode) arc.getSource().getProperty(NETWORKTOGRAPH);
            PFace face = (PFace) arc.getTarget().getProperty(NETWORKTOGRAPH);

            List<Pair<PEdge, OrthogonalAngle>> nodeList;
            nodeList = orthogonal.getAngles(node);
            if (nodeList == null) {
                nodeList = new LinkedList<Pair<PEdge, OrthogonalAngle>>();
                for (PEdge edge : node.adjacentEdges()) {
                    nodeList.add(new Pair<PEdge, OrthogonalAngle>(edge, null));
                }
                orthogonal.setAngles(node, nodeList);
            }

            int numEdges = 0;
            for (Pair<PEdge, OrthogonalAngle> pair : nodeList) {
                PEdge edge = pair.getFirst();
                if (((node == edge.getSource()) && (face == edge.getRightFace()))
                        || ((node == edge.getTarget()) && (face == edge.getLeftFace()))) {
                    numEdges++;
                }
            }

            int i = numEdges;
            for (Pair<PEdge, OrthogonalAngle> pair : nodeList) {
                PEdge edge = pair.getFirst();
                if (((node == edge.getSource()) && (face == edge.getRightFace()))
                        || ((node == edge.getTarget()) && (face == edge.getLeftFace()))) {
                    i--;
                    if (i > 0) {
                        pair.setSecond(OrthogonalAngle.LEFT);
                    } else {
                        int angle = arc.getProperty(IFlowNetworkSolver.FLOW) - numEdges;
                        pair.setSecond(OrthogonalAngle.values()[angle]);
                    }
                }
            }
        }

        return orthogonal;
    }

    /**
     * {@inheritDoc}
     */
    public void process(final PGraph pgraph) {
        getMonitor().begin("Orthogonalization", 1);

        // Initialization
        this.graph = pgraph;

        // Solve flow network and compute orthogonal representation
        PGraph network = this.createFlowNetwork();
        IFlowNetworkSolver solver = new SuccessiveShortestPathFlowSolver();
        solver.findFlow(network);
        OrthogonalRepresentation orthogonal = this.computeAngles(network);

        getMonitor().done();
        pgraph.setProperty(Properties.ORTHO_REPRESENTATION, orthogonal);
    }

    /**
     * {@inheritDoc}
     */
    public IntermediateProcessingStrategy getIntermediateProcessingStrategy(PGraph graph) {
        // TODO Auto-generated method stub
        return null;
    }

}

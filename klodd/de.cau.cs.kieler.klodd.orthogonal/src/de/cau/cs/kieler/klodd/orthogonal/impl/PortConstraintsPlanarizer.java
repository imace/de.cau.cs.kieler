package de.cau.cs.kieler.klodd.orthogonal.impl;

import java.util.LinkedList;
import java.util.List;

import de.cau.cs.kieler.core.alg.AbstractAlgorithm;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutNode;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutPort;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutOption;
import de.cau.cs.kieler.klodd.core.util.LayoutGraphs;
import de.cau.cs.kieler.klodd.orthogonal.impl.ec.EmbeddingConstraint;
import de.cau.cs.kieler.klodd.orthogonal.modules.IPlanarizer;
import de.cau.cs.kieler.klodd.orthogonal.structures.*;


/**
 * Planarizer implementation that uses an EC planarizer to handle port
 * constraints.
 * 
 * @author msp
 */
public class PortConstraintsPlanarizer extends AbstractAlgorithm implements
		IPlanarizer {

	/** the embedding constraints planarizer */
	private IPlanarizer ecPlanarizer;
	
	/**
	 * Creates a port constraints planarizer with a given embedding
	 * constraints planarizer.
	 * 
	 * @param ecPlanarizer EC planarizer
	 */
	public PortConstraintsPlanarizer(IPlanarizer ecPlanarizer) {
		this.ecPlanarizer = ecPlanarizer;
	}
	
	/*
	 * (non-Javadoc)
	 * @see de.cau.cs.kieler.klodd.orthogonal.modules.IPlanarizer#planarize(de.cau.cs.kieler.klodd.orthogonal.structures.TSMGraph)
	 */
	public void planarize(TSMGraph graph) {
		getMonitor().begin("Port constraints planarization", 1);
		// create constraints for the input graph
		createConstraints(graph);
		
		// planarize the input graph with embedding constraints
		ecPlanarizer.reset(getMonitor().subTask(1));
		ecPlanarizer.planarize(graph);
		getMonitor().done();
	}
	
	/**
	 * Creates embedding constraints for all nodes of a graph.
	 * 
	 * @param graph for which constraints shall be created
	 */
	private void createConstraints(TSMGraph graph) {
		for (TSMNode node : graph.nodes) {
			KLayoutNode layoutNode = (KLayoutNode)node.object;
			if (!layoutNode.getPorts().isEmpty()) {
				if (layoutNode.getLayout().getLayoutOptions()
						.contains(KLayoutOption.FIXED_PORTS)) {
					// create port constraints 
					KLayoutPort[] sortedPorts = LayoutGraphs.sortPortsByPosition(
							layoutNode.getPorts(), KLayoutOption.HORIZONTAL, true);
					EmbeddingConstraint portConstraint = new EmbeddingConstraint(
							EmbeddingConstraint.Type.ORIENTED, null, layoutNode);
					for (KLayoutPort port : sortedPorts) {
						EmbeddingConstraint constraint = createConstraintFor(port,
								portConstraint, node);
						if (constraint != null)
							portConstraint.children.add(constraint);
					}
					if (!portConstraint.children.isEmpty())
						node.embeddingConstraint = portConstraint;
				}
				else {
					// create side constraints
					EmbeddingConstraint sideConstraint = new EmbeddingConstraint(
							EmbeddingConstraint.Type.ORIENTED, null, layoutNode);
					EmbeddingConstraint northConstraint = null, eastConstraint = null,
							southConstraint = null, westConstraint = null;
					for (KLayoutPort port : layoutNode.getPorts()) {
						EmbeddingConstraint constraint = createConstraintFor(port,
								null, node);
						if (constraint != null) {
							switch (port.getLayout().getPlacement()) {
							case NORTH:
								if (northConstraint == null)
									northConstraint = new EmbeddingConstraint(
											EmbeddingConstraint.Type.GROUPING,
											sideConstraint, null);
								constraint.parent = northConstraint;
								northConstraint.children.add(constraint);
								break;
							case EAST:
								if (eastConstraint == null)
									eastConstraint = new EmbeddingConstraint(
											EmbeddingConstraint.Type.GROUPING,
											sideConstraint, null);
								constraint.parent = eastConstraint;
								eastConstraint.children.add(constraint);
								break;
							case SOUTH:
								if (southConstraint == null)
									southConstraint = new EmbeddingConstraint(
											EmbeddingConstraint.Type.GROUPING,
											sideConstraint, null);
								constraint.parent = southConstraint;
								southConstraint.children.add(constraint);
								break;
							case WEST:
								if (westConstraint == null)
									westConstraint = new EmbeddingConstraint(
											EmbeddingConstraint.Type.GROUPING,
											sideConstraint, null);
								constraint.parent = westConstraint;
								westConstraint.children.add(constraint);
								break;
							}
						}
					}
					if (northConstraint != null)
						sideConstraint.children.add(northConstraint);
					if (eastConstraint != null)
						sideConstraint.children.add(eastConstraint);
					if (southConstraint != null)
						sideConstraint.children.add(southConstraint);
					if (westConstraint != null)
						sideConstraint.children.add(westConstraint);
					if (!sideConstraint.children.isEmpty())
						node.embeddingConstraint = sideConstraint;
				}
			}
		}
	}
	
	/**
	 * Creates an embedding constraint for a given port.
	 * 
	 * @param port port to process
	 * @param parent constraint for new constraints, or null if not specified
	 * @param node the node that is currently processed
	 * @return a constraint for the given port, or null if the port has
	 *     no incoming or outgoing edges
	 */
	private EmbeddingConstraint createConstraintFor(KLayoutPort port,
			EmbeddingConstraint parent, TSMNode node) {
		// find edges connected with the given port
		List<TSMEdge> portEdges = new LinkedList<TSMEdge>();
		for (TSMNode.IncEntry edgeEntry : node.incidence) {
			if (edgeEntry.edge.layoutEdge.getSourcePort() == port
					|| edgeEntry.edge.layoutEdge.getTargetPort() == port)
				portEdges.add(edgeEntry.edge);
		}
		if (!portEdges.isEmpty()) {
			EmbeddingConstraint groupConstraint = new EmbeddingConstraint(
					EmbeddingConstraint.Type.GROUPING, parent, port);
			for (TSMEdge edge : portEdges) {
				EmbeddingConstraint.Type constraintType = edge.layoutEdge.getSourcePort()
						== port ? EmbeddingConstraint.Type.OUT_EDGE
						: EmbeddingConstraint.Type.IN_EDGE;
				EmbeddingConstraint edgeConstraint = new EmbeddingConstraint(
						constraintType, groupConstraint, edge);
				groupConstraint.children.add(edgeConstraint);
			}
			return groupConstraint;
		}
		else
			return null;
	}

}

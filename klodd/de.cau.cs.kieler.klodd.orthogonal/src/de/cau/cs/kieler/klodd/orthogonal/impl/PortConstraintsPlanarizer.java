package de.cau.cs.kieler.klodd.orthogonal.impl;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutEdge;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutNode;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutPort;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutOption;
import de.cau.cs.kieler.klodd.core.algorithms.AbstractAlgorithm;
import de.cau.cs.kieler.klodd.core.util.LayoutGraphs;
import de.cau.cs.kieler.klodd.orthogonal.impl.ec.*;
import de.cau.cs.kieler.klodd.orthogonal.modules.IECPlanarizer;
import de.cau.cs.kieler.klodd.orthogonal.modules.IPlanarizer;
import de.cau.cs.kieler.klodd.orthogonal.structures.TSMGraph;


/**
 * Planarizer implementation that uses the EC embedding method.
 * 
 * @author msp
 */
public class PortConstraintsPlanarizer extends AbstractAlgorithm implements
		IPlanarizer {

	/** the embedding constraints planarizer */
	private IECPlanarizer ecPlanarizer;
	
	/*
	 * (non-Javadoc)
	 * @see de.cau.cs.kieler.klodd.core.algorithms.AbstractAlgorithm#reset()
	 */
	public void reset() {
		super.reset();
		ecPlanarizer.reset();
	}
	
	/**
	 * Creates a port constraints planarizer with a given embedding
	 * constraints planarizer.
	 * 
	 * @param ecPlanarizer
	 */
	public PortConstraintsPlanarizer(IECPlanarizer ecPlanarizer) {
		this.ecPlanarizer = ecPlanarizer;
	}
	
	/*
	 * (non-Javadoc)
	 * @see de.cau.cs.kieler.klodd.orthogonal.modules.IPlanarizer#planarize(de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutNode)
	 */
	public TSMGraph planarize(KLayoutNode layoutNode) {
		// create constraints for the input graph
		Map<KLayoutNode, EmbeddingConstraint> constraintsMap = createConstraints(layoutNode);
		ecPlanarizer.setConstraints(constraintsMap);
		
		// planarize the input graph with embedding constraints
		TSMGraph graph = ecPlanarizer.planarize(layoutNode);
		return graph;
	}
	
	/**
	 * Creates embedding constraints for all children of a given layout node.
	 * 
	 * @param layoutNode parent layout node
	 * @return mapping of children nodes to their embedding constraints
	 */
	private Map<KLayoutNode, EmbeddingConstraint> createConstraints(KLayoutNode layoutNode) {
		Map<KLayoutNode, EmbeddingConstraint> constraintsMap = new HashMap<KLayoutNode, EmbeddingConstraint>();
		
		for (KLayoutNode child : layoutNode.getChildNodes()) {
			if (!child.getPorts().isEmpty()) {
				if (child.getLayout().getLayoutOptions()
						.contains(KLayoutOption.FIXED_PORTS)) {
					// create port constraints 
					KLayoutPort[] sortedPorts = LayoutGraphs.sortPortsByPosition(child.getPorts(),
							KLayoutOption.HORIZONTAL, true);
					EmbeddingConstraint portConstraint = new EmbeddingConstraint(
							EmbeddingConstraint.Type.ORIENTED, null, child);
					for (KLayoutPort port : sortedPorts) {
						EmbeddingConstraint constraint = createConstraintFor(port, portConstraint);
						if (constraint != null)
							portConstraint.children.add(constraint);
					}
					if (!portConstraint.children.isEmpty())
						constraintsMap.put(child, portConstraint);
				}
				else {
					// create side constraints
					EmbeddingConstraint sideConstraint = new EmbeddingConstraint(
							EmbeddingConstraint.Type.ORIENTED, null, child);
					EmbeddingConstraint northConstraint = null, eastConstraint = null,
							southConstraint = null, westConstraint = null;
					for (KLayoutPort port : child.getPorts()) {
						EmbeddingConstraint constraint = createConstraintFor(port, null);
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
						constraintsMap.put(child, sideConstraint);
				}
			}
		}
		
		return constraintsMap;
	}
	
	/**
	 * Creates an embedding constraint for a given port.
	 * 
	 * @param port port to process
	 * @param parent constraint for new constraints, or null if not specified
	 * @return a constraint for the given port, or null if the port has
	 *     no incoming or outgoing edges
	 */
	private EmbeddingConstraint createConstraintFor(KLayoutPort port,
			EmbeddingConstraint parent) {
		// filter edges that lead to child nodes
		List<KLayoutEdge> filteredEdges = new LinkedList<KLayoutEdge>();
		for (KLayoutEdge edge : port.getEdges()) {
			// TODO edges to external ports are not considered yet
			if (!(edge.getSource() == null || edge.getTarget() == null)
					&& edge.getSourcePort() != edge.getTargetPort())
				filteredEdges.add(edge);
		}
		if (!filteredEdges.isEmpty()) {
			EmbeddingConstraint groupConstraint = new EmbeddingConstraint(
					EmbeddingConstraint.Type.GROUPING, parent, port);
			for (KLayoutEdge edge : filteredEdges) {
				EmbeddingConstraint.Type constraintType = edge.getSourcePort()
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

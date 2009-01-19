package edu.unikiel.rtsys.klodd.orthogonal.impl;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KEdge;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KNodeGroup;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KPort;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.LAYOUT_OPTION;
import edu.unikiel.rtsys.klodd.core.algorithms.AbstractAlgorithm;
import edu.unikiel.rtsys.klodd.core.util.LayoutGraphs;
import edu.unikiel.rtsys.klodd.orthogonal.impl.ec.*;
import edu.unikiel.rtsys.klodd.orthogonal.modules.IECPlanarizer;
import edu.unikiel.rtsys.klodd.orthogonal.modules.IPlanarizer;
import edu.unikiel.rtsys.klodd.orthogonal.structures.TSMGraph;

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
	 * @see edu.unikiel.rtsys.klodd.core.algorithms.AbstractAlgorithm#reset()
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
	 * @see edu.unikiel.rtsys.klodd.orthogonal.modules.IPlanarizer#planarize(edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KNodeGroup)
	 */
	public TSMGraph planarize(KNodeGroup nodeGroup) {
		// create constraints for the input graph
		Map<KNodeGroup, EmbeddingConstraint> constraintsMap = createConstraints(nodeGroup);
		ecPlanarizer.setConstraints(constraintsMap);
		
		// planarize the input graph with embedding constraints
		TSMGraph graph = ecPlanarizer.planarize(nodeGroup);
		return graph;
	}
	
	/**
	 * Creates embedding constraints for all children of a given node group.
	 * 
	 * @param nodeGroup parent node group
	 * @return mapping of children nodes to their embedding constraints
	 */
	private Map<KNodeGroup, EmbeddingConstraint> createConstraints(KNodeGroup nodeGroup) {
		Map<KNodeGroup, EmbeddingConstraint> constraintsMap = new HashMap<KNodeGroup, EmbeddingConstraint>();
		
		for (KNodeGroup child : nodeGroup.getSubNodeGroups()) {
			if (!child.getPorts().isEmpty()) {
				if (child.getLayout().getLayoutOptions()
						.contains(LAYOUT_OPTION.FIXED_PORTS)) {
					// create port constraints 
					KPort[] sortedPorts = LayoutGraphs.sortPortsByPosition(child.getPorts(),
							LAYOUT_OPTION.HORIZONTAL, true);
					EmbeddingConstraint portConstraint = new EmbeddingConstraint(
							EmbeddingConstraint.Type.ORIENTED, null, child);
					for (KPort port : sortedPorts) {
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
					for (KPort port : child.getPorts()) {
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
	private EmbeddingConstraint createConstraintFor(KPort port,
			EmbeddingConstraint parent) {
		// filter edges that lead to child nodes
		List<KEdge> filteredEdges = new LinkedList<KEdge>();
		for (KEdge edge : port.getEdges()) {
			// TODO edges to external ports are not considered yet
			if (!(edge.getSource() == null || edge.getTarget() == null))
				filteredEdges.add(edge);
		}
		if (!filteredEdges.isEmpty()) {
			EmbeddingConstraint groupConstraint = new EmbeddingConstraint(
					EmbeddingConstraint.Type.GROUPING, parent, port);
			for (KEdge edge : filteredEdges) {
				EmbeddingConstraint edgeConstraint = new EmbeddingConstraint(
						EmbeddingConstraint.Type.EDGE, groupConstraint, edge);
				groupConstraint.children.add(edgeConstraint);
			}
			return groupConstraint;
		}
		else
			return null;
	}

}

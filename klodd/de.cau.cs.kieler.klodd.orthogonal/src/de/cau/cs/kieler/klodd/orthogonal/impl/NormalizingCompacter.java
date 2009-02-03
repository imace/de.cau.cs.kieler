package de.cau.cs.kieler.klodd.orthogonal.impl;

import java.util.HashMap;
import java.util.Map;

import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KPort;
import de.cau.cs.kieler.klodd.core.algorithms.AbstractAlgorithm;
import de.cau.cs.kieler.klodd.orthogonal.modules.ICompacter;
import de.cau.cs.kieler.klodd.orthogonal.structures.*;

/**
 * Compacter implementation that normalizes the graph and executes
 * another compacter for normalized orthogonal representations.
 * 
 * @author msp
 */
public class NormalizingCompacter extends AbstractAlgorithm implements
		ICompacter {

	/** the embedded compacter for normalized orthogonal representations */
	private ICompacter normalizedCompacter;
	
	/*
	 * (non-Javadoc)
	 * @see de.cau.cs.kieler.klodd.core.algorithms.AbstractAlgorithm#reset()
	 */
	public void reset() {
		super.reset();
		normalizedCompacter.reset();
	}
	
	/**
	 * Creates a normalizing compacter based on the given compacter,
	 * which should work on a normalized orthogonal representation.
	 * 
	 * @param normalizedCompacter compacter that expects a normalized
	 *     orthogonal representation
	 */
	public NormalizingCompacter(ICompacter normalizedCompacter) {
		this.normalizedCompacter = normalizedCompacter;
	}
	
	/* (non-Javadoc)
	 * @see de.cau.cs.kieler.klodd.orthogonal.modules.ICompacter#compact(de.cau.cs.kieler.klodd.orthogonal.structures.TSMGraph)
	 */
	public void compact(TSMGraph graph) {
		// create a normalized version of the input graph
		TSMGraph normalizedGraph = createNormalizedGraph(graph);
		// execute the embedded compacter
		normalizedCompacter.compact(normalizedGraph);
	}
	
	/**
	 * Creates a normalized version of the input graph.
	 * 
	 * @param inputGraph graph with orthogonal representation
	 * @return new graph with normalized orthogonal representation
	 */
	private TSMGraph createNormalizedGraph(TSMGraph inputGraph) {
		TSMGraph normalizedGraph = new TSMGraph();
		Map<KPort, TSMNode> portMap = new HashMap<KPort, TSMNode>();
		for (TSMNode node : inputGraph.nodes) {
			if (node.type == TSMNode.Type.LAYOUT) {
				for (TSMNode.IncEntry edgeEntry : node.incidence) {
					KPort port;
					/*if (edge.source.id == node.id)
						port = edge.layoutEdge.getSourcePort();
					else {
						assert edge.target.id == node.id;
						port = edge.layoutEdge.getTargetPort();
					}*/
				}
			}
		}
		return normalizedGraph;
	}

}

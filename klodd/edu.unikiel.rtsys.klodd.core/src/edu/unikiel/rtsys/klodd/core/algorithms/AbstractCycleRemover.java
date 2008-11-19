package edu.unikiel.rtsys.klodd.core.algorithms;

import java.util.LinkedList;

import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.*;

/**
 * Abstract superclass that can be used for implementations of cycle
 * remover algorithms which operate by reversing edges.
 * 
 * @author msp
 */
public abstract class AbstractCycleRemover extends AbstractAlgorithm
		implements ICycleRemover {
	
	private LinkedList<KEdge> reversedEdges = new LinkedList<KEdge>();

	/*
	 * (non-Javadoc)
	 * @see edu.unikiel.rtsys.klodd.core.algorithms.AbstractAlgorithm#reset()
	 */
	public void reset() {
		reversedEdges.clear();
	}
	
	/*
	 * (non-Javadoc)
	 * @see edu.unikiel.rtsys.klodd.core.algorithms.ICycleRemover#restoreGraph()
	 */
	public void restoreGraph() {
		for (KEdge edge : reversedEdges) {
			doReverseEdge(edge);
		}
	}
	
	/**
	 * Switches the source and target of an edge and stores the edge
	 * for later restoration.
	 * 
	 * @param edge edge to be reversed
	 */
	protected void reverseEdge(KEdge edge) {
		doReverseEdge(edge);
		reversedEdges.add(edge);
	}
	
	/**
	 * Switches the source and target of an edge.
	 * 
	 * @param edge edge to be reversed
	 */
	private void doReverseEdge(KEdge edge) {
		// reverse source and target node group
		KNodeGroup source = edge.getSource();
		KNodeGroup target = edge.getTarget();
		edge.setSource(target);
		edge.setTarget(source);
		// reverse source and target port
		KPort sourcePort = edge.getSourcePort();
		KPort targetPort = edge.getTargetPort();
		edge.setSourcePort(targetPort);
		edge.setTargetPort(sourcePort);
	}
	
}

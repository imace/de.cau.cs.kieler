package de.cau.cs.kieler.klodd.core.algorithms;

import java.util.LinkedList;
import java.util.List;

import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.*;


/**
 * Abstract superclass that can be used for implementations of cycle
 * remover algorithms which operate by reversing edges.
 * 
 * @author msp
 */
public abstract class AbstractCycleRemover extends AbstractAlgorithm
		implements ICycleRemover {
	
	/**	list of edges that are reversed and later restored */
	protected LinkedList<KLayoutEdge> reversedEdges = new LinkedList<KLayoutEdge>();

	/*
	 * (non-Javadoc)
	 * @see de.cau.cs.kieler.klodd.core.algorithms.AbstractAlgorithm#reset()
	 */
	public void reset() {
		reversedEdges.clear();
	}
	
	/*
	 * (non-Javadoc)
	 * @see de.cau.cs.kieler.klodd.core.algorithms.ICycleRemover#restoreGraph()
	 */
	public void restoreGraph() {
		reverseEdges();
	}
	
	/**
	 * Switches the source and target of all edges marked in the
	 * <code>reversedEdges</code> list.
	 */
	protected void reverseEdges() {
		for (KLayoutEdge edge : reversedEdges) {
			// reverse source and target layout node
			KLayoutNode source = edge.getSource();
			KLayoutNode target = edge.getTarget();
			edge.setSource(target);
			edge.setTarget(source);
			// reverse source and target port
			KLayoutPort sourcePort = edge.getSourcePort();
			KLayoutPort targetPort = edge.getTargetPort();
			edge.setSourcePort(targetPort);
			edge.setTargetPort(sourcePort);
			// reverse bend points
			List<KPoint> bendPoints = new LinkedList<KPoint>();
			for (KPoint point : edge.getLayout().getBendPoints()) {
				bendPoints.add(0, point);
			}
			edge.getLayout().getBendPoints().clear();
			for (KPoint point : bendPoints) {
				edge.getLayout().getBendPoints().add(point);
			}
			// reverse source and target point
			KPoint sourcePoint = edge.getLayout().getSourcePoint();
			edge.getLayout().setSourcePoint(edge.getLayout().getTargetPoint());
			edge.getLayout().setTargetPoint(sourcePoint);
		}
	}
	
}

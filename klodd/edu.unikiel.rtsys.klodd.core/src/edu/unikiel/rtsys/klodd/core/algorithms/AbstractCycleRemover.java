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
		implements ICycleRemover
{
	
	private LinkedList<KEdge> reversedEdges = new LinkedList<KEdge>();

	/*
	 * (non-Javadoc)
	 * @see edu.unikiel.rtsys.klodd.core.algorithms.ICycleRemover#restoreGraph()
	 */
	public void restoreGraph() {
		// TODO Auto-generated method stub
		
	}
	
	/*
	 * (non-Javadoc)
	 * @see edu.unikiel.rtsys.klodd.core.algorithms.AbstractAlgorithm#reset()
	 */
	public void reset()
	{
		reversedEdges.clear();
	}
	
	protected void reverseEdge(KEdge edge)
	{
		
	}
	
	private void doReverseEdge(KEdge edge)
	{
		KNodeGroup source = edge.getSource();
		KNodeGroup target = edge.getTarget();
		edge.setSource(target);
		edge.setTarget(source);
		if (edge.getSourcePort() != null)
		{
			
		}
	}
	
}

package edu.unikiel.rtsys.klodd.hierarchical.structures;

import java.util.LinkedList;
import java.util.List;

import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KEdge;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KNodeGroup;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KPort;

/**
 * A layer element representing a node or a long edge in the layered graph.
 * 
 * @author msp
 */
public class LayerElement {

	// the element object
	private Object elemObj;
	// the containing layer
	private Layer layer;
	// the list of source elements
	private List<LayerElement> sources = new LinkedList<LayerElement>();
	// the list of target elements
	private List<LayerElement> targets = new LinkedList<LayerElement>();
	
	/**
	 * Creates a layer element in an existing layer.
	 * 
	 * @param obj the element object
	 * @param layer the containing layer
	 */
	public LayerElement(Object obj, Layer layer)
	{
		this.elemObj = obj;
		this.layer = layer;
		
		if (obj instanceof KNodeGroup)
		{
			// the layer element is a node group
		}
		else if (obj instanceof KPort)
		{
			// the layer element is a port
		}
		else if (obj instanceof KEdge)
		{
			// the layer element is a long edge
		}
		else
			throw new ClassCastException("Unknown object type received.");
	}
	
	/**
	 * Get the element object.
	 * 
	 * @return the element object
	 */
	//public Object getObject()
	//{
	//	return elemObj;
	//} TODO needed?
	
	/**
	 * Get the containing layer.
	 * 
	 * @return the layer
	 */
	public Layer getLayer()
	{
		return layer;
	}
	
	/**
	 * Get the source elements.
	 * 
	 * @return the source elements
	 */
	//public List<LayerElement> getSourceElements()
	//{
	//	return sources;
	//} TODO needed?
	
	/**
	 * Get the target elements.
	 * 
	 * @return the target elements
	 */
	//public List<LayerElement> getTargetElements()
	//{
	//	return targets;
	//} TODO needed?
	
	/**
	 * Gets the outgoing edges of the contained object.
	 * 
	 * @return the list of outgoing edges, or null if the object is an edge
	 */
	public List<KEdge> getOutgoingEdges()
	{
		if (elemObj instanceof KNodeGroup)
		{
			return ((KNodeGroup)elemObj).getOutgoingEdges();
		}
		else if (elemObj instanceof KPort)
		{
			KPort port = (KPort)elemObj;
			LinkedList<KEdge> internalEdges = new LinkedList<KEdge>();
			for (KEdge edge : port.getEdges())
			{
				if (edge.getTarget() == port.getNodeGroup())
					internalEdges.add(edge);
			}
			return internalEdges;
		}
		else return null;
	}
	
	/**
	 * Adds another layer element to the list of targets, and adds this
	 * element to the target's list of sources.
	 * 
	 * @param target target layer element
	 */
	public void setTarget(LayerElement target)
	{
		targets.add(target);
		target.sources.add(this);
	}
	
}

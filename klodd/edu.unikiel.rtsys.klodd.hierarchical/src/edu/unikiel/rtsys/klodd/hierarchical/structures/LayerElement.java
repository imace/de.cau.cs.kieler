package edu.unikiel.rtsys.klodd.hierarchical.structures;

import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KEdge;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KNodeGroup;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KPort;

/**
 * A layer element representing a node or a long edge in the layered graph.
 * 
 * @author msp
 */
public class LayerElement {

	private Object elemObj;
	
	public LayerElement(Object obj)
	{
		this.elemObj = obj;
		
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
	public Object getObject()
	{
		return elemObj;
	}
	
}

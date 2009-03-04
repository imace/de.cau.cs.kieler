package de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.util;

import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutEdge;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutGraph;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutNode;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutPort;

/**
 * This is an ugly helper class to search a graph to an edge and
 * add the edge to the graph's containment reference. This 
 * is required to be able to serialize Graphs in any form, like for
 * persistent storage (XML serialization) and for cloning whole
 * graphs.
 * 
 * We expect the KLayoutGraph structure to change in the near future 
 * to better implement the containment reference such that this
 * hack becomes obsolete.
 * 
 * @author haf
 *
 */
public class KimlLayoutGraphEdgeInserter {
	
	/**
	 * Helper method to search the top-level graph of an edge
	 * and to add the edge to the graph's containment reference.
	 * @param edge
	 */
	public static void addEdgeContainment(KLayoutEdge edge){
		KLayoutGraph graph = getGraph(edge);
		if( graph!= null ){
			if( ! graph.getGraphEdges().contains(edge)){
				graph.getGraphEdges().add(edge);
			}
		}
	}
	
	private static KLayoutGraph getGraph(KLayoutEdge edge){
		if(edge != null){
			KLayoutNode node = edge.getSource();
			if(node != null)
				return getGraph(node);
			else{
				node = edge.getTarget();
				if(node != null)
					return getGraph(node);
				else
				{
					KLayoutPort port = edge.getSourcePort();
					if(port != null && port.getNode() != null){
							return getGraph(port.getNode());
					}
					else{
						port = edge.getTargetPort();
						if(port != null && port.getNode() != null){
							return getGraph(port.getNode());
						}
					}
						
				}
			}
			
		}
		return null;
	}
	
	private static KLayoutGraph getGraph(KLayoutNode node){
		while( node != null && ! (node instanceof KLayoutGraph))
			node = node.getParentNode();
		if(node == null)
			return null;
		else 
			return (KLayoutGraph)node;
	}
	
}

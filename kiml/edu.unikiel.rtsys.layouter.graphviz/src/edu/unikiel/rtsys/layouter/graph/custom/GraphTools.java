package edu.unikiel.rtsys.layouter.graph.custom;

import edu.unikiel.rtsys.layouter.graph.CompositeNode;
import edu.unikiel.rtsys.layouter.graph.Edge;
import edu.unikiel.rtsys.layouter.graph.Graph;
import edu.unikiel.rtsys.layouter.graph.Node;

public class GraphTools {

	private static String indent = "";
	
	/** 
	 * Iterates over a given graph and returns some String representation
	 * for debugging.
	 * @param g
	 * @return
	 */
	public static String graph2String(Graph g){
		StringBuffer sb = new StringBuffer();
		
		sb.append("Graph: "+g+"\n");
		appendNode(g,sb,0);
		
		return sb.toString();
	}
	
	/**
	 * Recursive function to append a CompositeNode String representation
	 * to a string buffer. This covers hierarchy of the given graph.
	 */
	private static void appendNode(CompositeNode node, StringBuffer sb, int level){
		sb.append("Node: "+node+"\n");
		sb.append("{\n");
		appendEdges(node,sb);
		for (Node child : node.getNodes()) {
			sb.append(level);
			sb.append(" Child: ");
			if(child instanceof CompositeNode){
				appendNode((CompositeNode)child,sb,level+1);
			}
		}
		sb.append("}\n");
	}
	
	/**
	 * Function to add Edges of a Composite Node to its String
	 * representation for debugging.
	 * @param node
	 * @param sb
	 */
	private static void appendEdges(CompositeNode node, StringBuffer sb){
		for (Edge edge : node.getEdges()) {
			sb.append("Edge: "+edge+"\n");
		}
	}
}

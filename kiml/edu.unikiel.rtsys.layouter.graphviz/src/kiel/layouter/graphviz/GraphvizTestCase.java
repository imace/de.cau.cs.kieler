package kiel.layouter.graphviz;

import java.util.Iterator;

import junit.framework.TestCase;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.graph.DirectedGraph;
import org.eclipse.draw2d.graph.Edge;
import org.eclipse.draw2d.graph.EdgeList;
import org.eclipse.draw2d.graph.Node;
import org.eclipse.draw2d.graph.NodeList;
/**
 * Simple JUnit Test to test the graphviz API with a preconstructed graph.
 * For this test here is the draw2d graph implementation used. 
 * @author haf
 * @deprecated Use better a new test case using the KIELER graph datastructure
 */
public class GraphvizTestCase extends TestCase {

	DirectedGraph graph;

	protected void setUp() throws Exception {
		NodeList nodes = new NodeList();
		EdgeList edges = new EdgeList();
		Dimension size = new Dimension(50, 50);
		Node node1 = new Node();
		node1.setSize(size);
		Node node2 = new Node();
		node2.setSize(size);
		Node node3 = new Node();
		node3.setSize(size);
		nodes.add(node1);
		nodes.add(node2);
		nodes.add(node3);
		Edge edge1 = new Edge(node1, node2);
		Edge edge2 = new Edge(node2, node3);
		Edge edge3 = new Edge(node3, node1);
		Edge edge4 = new Edge(node1, node3);
		edges.add(edge1);
		edges.add(edge2);
		edges.add(edge3);
		edges.add(edge4);

		graph = new DirectedGraph();
		graph.edges = edges;
		graph.nodes = nodes;

		GraphvizAPI.initialize();
	}

	public void testDoDotLayout() {
		final String name = "TestGraph";
		int g = GraphvizAPI.createGraph(name);
		
		int i = 0;
		for(Iterator iter = graph.nodes.iterator(); iter.hasNext();){
			i++;
			Node node = (Node)iter.next();
			int pointer = GraphvizAPI.createNode(g, "Node "+i);
			node.data = new Integer(pointer);
		}
		for(Iterator iter = graph.edges.iterator(); iter.hasNext();){
			Edge edge = (Edge)iter.next();
			int pointer = GraphvizAPI.createEdge(g, ((Integer)edge.source.data).intValue(), ((Integer)edge.target.data).intValue());
			edge.data = new Integer(pointer);
		}
		
		GraphvizAPI.doDotLayout(g);
		GraphvizAPI.attachAttributes(g);
		printGraph();
		

				
	}

	private void printGraph() {
		if (graph != null) {
			int i = 0;
			for (Iterator iter = graph.nodes.iterator(); iter.hasNext();) {
				i++;
				Node node = (Node) iter.next();
				try{
					int n = ((Integer)node.data).intValue();
					System.out.println("Node "+i+"("+n+")"+": "+
							GraphvizAPI.getAttribute(n, GraphvizAPI.ATTR_POS));
				}catch(Exception e){}

			}
			i=0;
			for (Iterator iter = graph.edges.iterator(); iter.hasNext();) {
				i++;
				Edge edge = (Edge) iter.next();
				try{
					int n = ((Integer)edge.data).intValue();
					System.out.println("Edge "+i+"("+n+")"+": "+
							GraphvizAPI.getAttribute(n, GraphvizAPI.ATTR_POS));
				}catch(Exception e){}
				
			}
		}
	}

	public void testDoCircoLayout() {
		fail("Not yet implemented");
	}

	public void testDoNeatoLayout() {
		fail("Not yet implemented");
	}

	public void testDoTwopiLayout() {
		fail("Not yet implemented");
	}

}

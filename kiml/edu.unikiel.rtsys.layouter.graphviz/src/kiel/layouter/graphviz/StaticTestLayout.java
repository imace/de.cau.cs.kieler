package kiel.layouter.graphviz;

import edu.unikiel.rtsys.layouter.graph.Coordinates;
import edu.unikiel.rtsys.layouter.graph.Edge;
import edu.unikiel.rtsys.layouter.graph.Graph;
import edu.unikiel.rtsys.layouter.graph.GraphFactory;
import edu.unikiel.rtsys.layouter.graph.Node;
import edu.unikiel.rtsys.layouter.graph.Size;

/**
 * Very simple static test layout, that sets coordinates of nodes
 * and the bendpoints of edges to static hard-coded values. This is used
 * to test the handover of layout information from KIML to gef.
 */
public class StaticTestLayout {

	public void visit(Graph graph) {
		int counter = 1;
		for (Node node : graph.getNodes()) {
				Coordinates coords = GraphFactory.eINSTANCE.createCoordinates();
				coords.setX(counter * 200);
				coords.setY(counter * 200);
				node.setPosition(coords);
				Size size = GraphFactory.eINSTANCE.createSize();
				size.setHeight(20);
				size.setWidth(20);
				node.setSize(size);
				counter++;
		}
		for (Edge edge : graph.getEdges()){
			addBendPoint(edge, 100, 100);
			addBendPoint(edge, 100, 150);
			addBendPoint(edge, 150, 100);
			addBendPoint(edge, 500, 500);
			addBendPoint(edge, 550, 500);
			addBendPoint(edge, 500, 550);
			
			{
				Coordinates coords = GraphFactory.eINSTANCE.createCoordinates();
				coords.setX(350);
				coords.setY(350);
				edge.getEdgeLabel().setPosition(coords);
			}
			
				
			
		}
	}

	void addBendPoint(Edge e, int x, int y){
		Coordinates coords = GraphFactory.eINSTANCE.createCoordinates();
		coords.setX(x);
		coords.setY(y);
		e.getBendpoints().add(coords);
	}
}

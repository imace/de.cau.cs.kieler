package kiel.layouter.graphviz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import edu.unikiel.rtsys.layouter.graph.Coordinates;
import edu.unikiel.rtsys.layouter.graph.Edge;
import edu.unikiel.rtsys.layouter.graph.Graph;
import edu.unikiel.rtsys.layouter.graph.GraphFactory;
import edu.unikiel.rtsys.layouter.graph.Node;
import edu.unikiel.rtsys.layouter.graph.Size;

public class GraphvizDraw2DGraphLayout {

	private HashMap<Node, Integer> mapNode2Pointer = new HashMap<Node, Integer>();
	private HashMap<Edge, Integer> mapEdge2Pointer = new HashMap<Edge, Integer>();
	
	private HashMap<EObject, Integer> mapObject2Pointer = new HashMap<EObject, Integer>();
	
	private int graphvizGraph;
	
	private final float dpi = 96.0f;
	
	// magic scaling factors to translate between GraphViz and other coordinate systems
	private final float scaleX = 1.33f;
	private final float scaleY = 1.33f;
	
	public GraphvizDraw2DGraphLayout() {
		GraphvizAPI.initialize();
		graphvizGraph = GraphvizAPI.createGraph("");
		//GraphvizAPI.setGraphAttribute(graphvizGraph, GraphvizAPI.ATTR_DPI, ""+dpi);
		// TODO: set correct shape for node corresponding to actual Draw2D shape
		GraphvizAPI.setGlobalNodeAttribute(graphvizGraph, GraphvizAPI.ATTR_SHAPE, "box");
	}
	
	public void visit(Graph graph) {
		mapGraph2Graphviz(graph);
		GraphvizAPI.doDotLayout(graphvizGraph);
		GraphvizAPI.attachAttributes(graphvizGraph);
		//System.out.println("dpi: "+GraphvizAPI.getAttribute(graphvizGraph, GraphvizAPI.ATTR_DPI));
		mapGraphviz2Graph(graph);
	}
	
	private void mapGraph2Graphviz(Graph graph){
		int i=0;
		// process all nodes in the Graph datastructure
		for(Iterator iter = graph.getNodes().iterator(); iter.hasNext();){
			Node node = (Node)iter.next();
			int pointer = GraphvizAPI.createNode(graphvizGraph, ""+i);
			System.out.println("put Node: "+pointer);
			mapNode2Pointer.put(node, new Integer(pointer));
			String height = ""+dot2Inch(node.getSize().getHeight()); // graphviz uses inch for sizes
			String width = ""+dot2Inch(node.getSize().getWidth());
			GraphvizAPI.setLocalNodeAttribute(graphvizGraph, pointer, "height", height);
			GraphvizAPI.setLocalNodeAttribute(graphvizGraph, pointer, "width", width);
			System.out.println("Size: "+height+" "+width+" "+GraphvizAPI.getAttribute(pointer, GraphvizAPI.ATTR_HEIGHT)+" "+node.getSize().getHeight()+" "+node.getSize().getWidth());
			i++;
		}
		// process all edges in the Graph datastructure
		for(Iterator iter = graph.getEdges().iterator(); iter.hasNext();){
			Edge edge = (Edge)iter.next();
			int pointer = GraphvizAPI.createEdge(graphvizGraph, mapNode2Pointer.get(edge.getSource()), mapNode2Pointer.get(edge.getTarget()));
			mapEdge2Pointer.put(edge, new Integer(pointer));
			// process label of edge
			if(edge.getEdgeLabel()!= null && edge.getEdgeLabel().getSize() != null){ // TODO: add calculation from text if size not available
				String labelString = widthToString(edge.getEdgeLabel().getSize().getWidth());
				GraphvizAPI.setLocalEdgeAttribute(graphvizGraph, pointer, GraphvizAPI.ATTR_LABEL, labelString);
			}
		}		
	}
	
	private void mapGraphviz2Graph(Graph graph){
		GraphvizAPI.writeDOT(graphvizGraph, "/home/haf/test.dot");
		// iterate over all nodes in the graphviz graph and copy their attributes to the Graph datastructure 
		for(Iterator iter = mapNode2Pointer.keySet().iterator(); iter.hasNext();){
			Node node = (Node)iter.next();
			int nodePointer = mapNode2Pointer.get(node);
			String posString = GraphvizAPI.getAttribute(nodePointer, GraphvizAPI.ATTR_POS);
			List<Integer> position = string2Ints(posString);
			Coordinates coords = GraphFactory.eINSTANCE.createCoordinates();
			coords.setX(0); coords.setY(0);
			try{
				// in Graphviz position is the center of the node
				// in draw2D it's the upper left corner
				coords.setX(position.get(0).intValue());
				coords.setY(position.get(1).intValue());
				coords = graphviz2Draw2D(coords, node.getSize());
			}catch(Exception e){
				/*nothing, might have been invalid String*/
				System.out.println(e.getMessage()+" "+posString);
				e.printStackTrace();
			}
			node.setPosition(coords);
			System.out.println("Node: "+node+" "+nodePointer+" "+posString+" "+node.getPosition().getX()+" "+node.getPosition().getY() );
		}
		// iterate over all edges in the graphviz graph and copy their attributes to the Graph datastructure
		for(Iterator iter = mapEdge2Pointer.keySet().iterator(); iter.hasNext();){
			Edge edge = (Edge)iter.next();
//			System.out.print("Edge: "+edge);
//			System.out.print("EdgeS: "+edge.getSource());
//			System.out.print("EdgeSP: "+edge.getSource().getPosition());
//			System.out.print("EdgeSPX: "+edge.getSource().getPosition().getX());
//			System.out.print("S:"+edge.getSource().getPosition().getX()+","+edge.getSource().getPosition().getY()+" ");
//			System.out.print("T:"+edge.getTarget().getPosition().getX()+","+edge.getTarget().getPosition().getY()+"\n");
			int edgePointer = mapEdge2Pointer.get(edge);
			String posString = GraphvizAPI.getAttribute(edgePointer, GraphvizAPI.ATTR_POS);
			System.out.println("Graphviz Bendpoints: "+posString);
			List<Integer> intList = string2Ints(posString);
			try{
				// unsafe because list size might be odd (not good, because list of point coordinates)
				for(int i=2; i<intList.size()-1; i+=2){
					// ignore first point pair					
					Coordinates point = GraphFactory.eINSTANCE.createCoordinates();
					point.setX(intList.get(i));
					point.setY(intList.get(i+1)); 
					point = graphviz2Draw2D(point);
					edge.getBendpoints().add(point);
					// System.out.println("bendpoint: "+point.getX()+" "+point.getY());
				}
				Coordinates endPoint = GraphFactory.eINSTANCE.createCoordinates();
				endPoint.setX(intList.get(0));
				endPoint.setY(intList.get(1));
				endPoint = graphviz2Draw2D(endPoint);
				edge.getBendpoints().add(endPoint);
			}catch(Exception e){/*in any failure, leave list empty*/}
			// process label
			if(edge.getEdgeLabel() != null){
				Coordinates coords = GraphFactory.eINSTANCE.createCoordinates();
				String labelLoc = GraphvizAPI.getAttribute(edgePointer, GraphvizAPI.ATTR_LP);
				System.out.println("LabelGraphViz: "+labelLoc+" size: "+edge.getEdgeLabel().getSize());
				List<Integer> ints = string2Ints(labelLoc);
				if(ints.size() == 2){
					// in Graphviz position is the center of the node
					// in draw2D it's the upper left corner
					// TODO: what if size not available?
					// TODO: optimize exact location (sometimes start is within connection)
					coords.setX(ints.get(0).intValue());// - (edge.getEdgeLabel().getSize().getWidth()/2));
					coords.setY(ints.get(1).intValue());// - (edge.getEdgeLabel().getSize().getHeight()/2));
					coords = graphviz2Draw2D(coords,edge.getEdgeLabel().getSize());
				}
				else{ // got strange String from Graphviz
					coords.setX(0); 
					coords.setY(0);
				}
				edge.getEdgeLabel().setPosition(coords);
			}
			
		}		
	}
	
	/**
	 * Given a size (width) in points, a String is returned, that tries to fill this
	 * size with some text. As default font size Times Roman in 14 point size is assumed
	 * (default of graphiz label text size).
	 * @param points
	 * @return
	 */
	private String widthToString(int points){
		int sizeOfLetter = 12; // TODO: remove magic number
		int amount = (points / sizeOfLetter);
		int offset = 4; // TODO: check magic offset number (due to icon in front of label)
		char letters[] = new char[amount+offset];
		for (int i = 0;i<letters.length;i++){
			letters[i] = 'T'; // TODO: check magic letter
		}
		return new String(letters);
	}
	
	private float dot2Inch(int dots){
		float inches = (dots/(float)dpi);
		//// System.out.println("dpi: "+dots+" "+inches);
		return inches;
	}
	
	private int Inch2Dot(float inch){
		return (int)(inch*dpi);
	}
	
	private Coordinates graphviz2Draw2D(Coordinates coords, Size size){
		Coordinates newCoords = GraphFactory.eINSTANCE.createCoordinates();
		newCoords.setX((int)(coords.getX()*scaleX) - (size.getWidth()/2));
		newCoords.setY((int)(coords.getY()*scaleY) - (size.getHeight()/2));
		return newCoords;
	}
	
	private Coordinates draw2D2Graphviz(Coordinates coords, Size size){
		Coordinates newCoords = GraphFactory.eINSTANCE.createCoordinates();
		newCoords.setX((int)(coords.getX()/scaleX) + (size.getWidth()/2));
		newCoords.setY((int)(coords.getY()/scaleY) + (size.getHeight()/2));
		return newCoords;
	}
	
	private Coordinates graphviz2Draw2D(Coordinates coords){
		Coordinates newCoords = GraphFactory.eINSTANCE.createCoordinates();
		newCoords.setX((int)(coords.getX()*scaleX));
		newCoords.setY((int)(coords.getY()*scaleY));
		return newCoords;
	}
	
	private Coordinates draw2D2Graphviz(Coordinates coords){
		Coordinates newCoords = GraphFactory.eINSTANCE.createCoordinates();
		newCoords.setX((int)(coords.getX()/scaleX));
		newCoords.setY((int)(coords.getY()/scaleY));
		return newCoords;
	}
	
	private List<Integer> string2Ints(String text){
		ArrayList intList = new ArrayList();
		if(text != null){
			String[] tokens = text.split(",|\\s"); // \s = any whitespace char
			for(int i=0;i<tokens.length;i++){
				try{
					intList.add(new Integer(tokens[i]));
				}catch(Exception e){/*nothing*/}	
			}
		}
		return intList;
	}	
}

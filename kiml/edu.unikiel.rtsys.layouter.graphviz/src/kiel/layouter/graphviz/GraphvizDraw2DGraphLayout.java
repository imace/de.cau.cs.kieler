package kiel.layouter.graphviz;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import edu.unikiel.rtsys.layouter.graph.CompositeNode;
import edu.unikiel.rtsys.layouter.graph.Coordinates;
import edu.unikiel.rtsys.layouter.graph.Edge;
import edu.unikiel.rtsys.layouter.graph.Graph;
import edu.unikiel.rtsys.layouter.graph.GraphFactory;
import edu.unikiel.rtsys.layouter.graph.Node;
import edu.unikiel.rtsys.layouter.graph.Size;

/**
 * Basic Layout Algorithm employing the Graphviz library (dot layout) to do a graphical
 * layout on a passed Graph datastructure. The basic principle is simple: (1) read the
 * graph datastructure and use the GraphvizAPI to fill a Graphviz internal (native) datastructure. 
 * (2) call a Graphviz layout engine (e.g. the dot layouter) on the Graphviz datastructure. The
 * datastructure will get augmented by positioning attributes. (3) Read the position attributes
 * from the Graphviz datastructure and write them back to the KIELER Graph datastructure.
 * 
 * Hierarchy is prepared (by visiting the graph recursively) but not tested yet.
 * @author haf
 *
 */
public class GraphvizDraw2DGraphLayout {

	/** Store the Graphviz internal C-Pointers of our nodes and edges*/
	private HashMap<Node, Integer> mapNode2Pointer = new HashMap<Node, Integer>();
	private HashMap<Edge, Integer> mapEdge2Pointer = new HashMap<Edge, Integer>();
	
	//private HashMap<EObject, Integer> mapObject2Pointer = new HashMap<EObject, Integer>();
	
	/** C-pointer to the root GraphvizGraph datastructure */
	private int graphvizGraph;
	
	/** dots per inch specification. Graphviz uses inch for some internal sizes (e.g. width, height)
	 * but not for all. Hence finding the right dpi is crucial for the layout. Setting the
	 * dpi attribute for a graph within Graphviz seems to have no effect.
	 */
	private final float dpi = 96.0f;
	
	// magic scaling factors to translate between GraphViz and other coordinate systems
	// difference between point and pica?
	private final float scaleX = 1.33f;
	private final float scaleY = 1.33f;
	
	// padding from the borders. pad attribute of graphviz has no effect
	private final int pad = 10;
	
	public GraphvizDraw2DGraphLayout() {
		init();
	}
	
	/**
	 * Initializes the GraphvizAPI. Creates a fresh graph and sets global attributes.
	 * Needs to be called before every layouting. Graphviz might crash otherwise...
	 */
	private void init(){
		GraphvizAPI.initialize();
		graphvizGraph = GraphvizAPI.createGraph("");
		//GraphvizAPI.setGraphAttribute(graphvizGraph, GraphvizAPI.ATTR_DPI, ""+dpi);
		// set layout direction (up/down vs. left/right)
		GraphvizAPI.setGraphAttribute(graphvizGraph, "rankdir", "LR");
		// set padding of the layout. seems to have no effect...
		GraphvizAPI.setGraphAttribute(graphvizGraph, "pad", ""+1);
		// TODO: set correct shape for node corresponding to actual Draw2D shape
		GraphvizAPI.setGlobalNodeAttribute(graphvizGraph, GraphvizAPI.ATTR_SHAPE, "box");
	}
	
	/**
	 * Main method to visit a Graph and to add layout information to it.
	 * @param graph the Graph object to visit
	 */
	public void visit(Graph graph) {
		visitRecursively(graph);
	}
	
	/**
	 * Recursive visit function that visits the given node as a parent node. First it
	 * calls itself recursively for the children in order to address the hierarchy.
	 * Then it adds the layout stuff to its children 
	 * 
	 * TODO: recursive feature highly experimental and not yet tested!
	 * 
	 * @param node parent Node to visit (maybe a Graph or a CompositeNode)
	 */
	public void visitRecursively(CompositeNode node){
		for (Node child : node.getNodes()) {
			if(child instanceof CompositeNode)
				visitRecursively((CompositeNode)child);
		}
		this.init();
		mapGraph2Graphviz(node);
		GraphvizAPI.doDotLayout(graphvizGraph);
		GraphvizAPI.attachAttributes(graphvizGraph);
		mapGraphviz2Graph(node);
	}
	
	/**
	 * Map a Graph object to the internal GraphvizAPI datastructure. This is stored
	 * in the GraphvizAPI internally.
	 * @param graph
	 */
	private void mapGraph2Graphviz(CompositeNode graph){
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
	
	/**
	 * Read the internal Graphviz datastructure that was filled by the Graphviz library and
	 * write the required parameters back to the Graph object. Hence the Graph object
	 * is the interface between layouter and parties who need layouted stuff.
	 * @param graph Graph object to fill with the layout information
	 */
	private void mapGraphviz2Graph(CompositeNode graph){
		GraphvizAPI.writeDOT(graphvizGraph, "/home/haf/test.dot");
		mapGraphvizNodes2Graph();
		mapGraphvizEdges2Graph();
		setNodeSize(graph);
	}

	/** Write all Node related information from Graphviz into the Graph datastructure */
	private void mapGraphvizNodes2Graph() {
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
		}
	}
	
	/** Write all Edge related information from Graphviz into the Graph datastructure */
	private void mapGraphvizEdges2Graph() {
		// iterate over all edges in the graphviz graph and copy their attributes to the Graph datastructure
		for(Iterator iter = mapEdge2Pointer.keySet().iterator(); iter.hasNext();){
			Edge edge = (Edge)iter.next();
			int edgePointer = mapEdge2Pointer.get(edge);
			String posString = GraphvizAPI.getAttribute(edgePointer, GraphvizAPI.ATTR_POS);
			List<Integer> intList = string2Ints(posString);
			try{
				/* haf, 2008-06-10
				 * Graphviz uses piecewise cubic beziercurves. Each part consists of: 
				 * Start point, bezier control point 1, bezier control point 2, End point.
				 * Start point of the next section is the same as the end point of the last.
				 * The control points are likely to be not part of the path but specify the
				 * bend of the curve.
				 * 
				 * Eclipse does not support bezier curves (yet). Standard thing are Polylines
				 * with only explicit bendpoints. I've implemented some cubic spline connection
				 * on top of that. But there all bendpoints are part of the curve.
				 * 
				 * First approximation: only use the start and end points of Graphviz' bezier
				 * parts as bendpoints for the eclipse splines.
				 * 
				 * TODO: Add proper bezier path handling when this is supported by Eclipse!
				 *       @see Eclipse bug: 234808 and 168307
				 */
				
				// unsafe because list size might be not a multiple of 6
				for(int i=2; i<intList.size()-1; i+=6){ 
					// i=2: ignore first point pair
					// i+=6: ignore bezier control points
					Coordinates point = GraphFactory.eINSTANCE.createCoordinates();
					point.setX(intList.get(i));
					point.setY(intList.get(i+1)); 
					point = graphviz2Draw2D(point);
					edge.getBendpoints().add(point);
					// System.out.println("bendpoint: "+point.getX()+" "+point.getY());
				}
				// first point in the Graphviz list is the end point
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
			}//if edgeLabel
			
		}// for edges	
	}
	
	/** Sets the required size of the node (i.e. a CompositeNode or a Graph) by
	 * obtaining the bounding box of the Graphviz Graph. Will leave the old sizes
	 * for simple Nodes and empty CompositeNodes.
	 * @param node
	 */
	private void setNodeSize(Node node){
		if(node instanceof CompositeNode){
			CompositeNode cnode = (CompositeNode)node;
			if(! cnode.getNodes().isEmpty()){
				Dimension bb = GraphvizAPI.getBoundingBox(graphvizGraph);
				Size size = GraphFactory.eINSTANCE.createSize();
				size.setWidth(bb.width);
				size.setHeight(bb.height);
				node.setSize(size);
			}
		}
	}
	
	/**
	 * Given a size (width) in points, a String is returned, that tries to fill this
	 * size with some text. As default font size Times Roman in 14 point size is assumed
	 * (default of graphiz label text size). Rationale: Eclipse uses an actual size (width+height)
	 * for labels, Graphviz knows only a specific text of a label and calculates its size
	 * internally.
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
	
	/** 
	 * Tranforms dots into inches, using the internal dpi factor. 
	 * @param dots
	 * @return inches
	 */
	private float dot2Inch(int dots){
		float inches = (dots/(float)dpi);
		//// System.out.println("dpi: "+dots+" "+inches);
		return inches;
	}
	
	/** 
	 * Tranforms inches into dots, using the internal dpi factor. 
	 * @param iches
	 * @return dots
	*/
	private int Inch2Dot(float inch){
		return (int)(inch*dpi);
	}
	
	/** Transforms GraphvizCoordinates to Draw2D (KIELER) coordinates of any sized object (e.g. nodes).
	 * There are some
	 * scaling factors between those twoo coordinate systems. Padding is also used.
	 * @param coords Graphviz Coordinates
	 * @param size Size of the item. Required because Graphviz coordinates are at the 
	 *             center of any item and Draw2D coordinates are at the upper left corner.
	 * @return Draw2D coordinates
	 */
	private Coordinates graphviz2Draw2D(Coordinates coords, Size size){
		Coordinates newCoords = GraphFactory.eINSTANCE.createCoordinates();
		newCoords.setX((int)(coords.getX()*scaleX) - (size.getWidth()/2)  + pad);
		newCoords.setY((int)(coords.getY()*scaleY) - (size.getHeight()/2) + pad);
		return newCoords;
	}
	
	/** Transforms Draw2D (KIELER) coordinates to Graphviz Coordinates of any sized object (e.g. nodes).
	 * There are some
	 * scaling factors between those twoo coordinate systems. Padding is also used.
	 * @param coords Draw2D Coordinates
	 * @param size Size of the item. Required because Graphviz coordinates are at the 
	 *             center of any item and Draw2D coordinates are at the upper left corner.
	 * @return Graphviz coordinates
	 */
	private Coordinates draw2D2Graphviz(Coordinates coords, Size size){
		Coordinates newCoords = GraphFactory.eINSTANCE.createCoordinates();
		newCoords.setX((int)(coords.getX()/scaleX) + (size.getWidth()/2)  - pad);
		newCoords.setY((int)(coords.getY()/scaleY) + (size.getHeight()/2) - pad);
		return newCoords;
	}
	
	/** Transforms GraphvizCoordinates to Draw2D (KIELER) coordinates only for unsized objects (points).
	 * There are some
	 * scaling factors between those two coordinate systems. Padding is also used.
	 * @param coords Graphviz Coordinates
	 * @return Draw2D coordinates
	 */
	private Coordinates graphviz2Draw2D(Coordinates coords){
		Coordinates newCoords = GraphFactory.eINSTANCE.createCoordinates();
		newCoords.setX((int)(coords.getX()*scaleX) + pad);
		newCoords.setY((int)(coords.getY()*scaleY) + pad);
		return newCoords;
	}

	/** Transforms Draw2D (KIELER) coordinates to Graphviz Coordinates only for unsized objects (points).
	 * There are some
	 * scaling factors between those twoo coordinate systems. Padding is also used.
	 * @param coords Draw2D Coordinates
	 * @return Graphviz coordinates
	 */
	private Coordinates draw2D2Graphviz(Coordinates coords){
		Coordinates newCoords = GraphFactory.eINSTANCE.createCoordinates();
		newCoords.setX((int)(coords.getX()/scaleX) - pad);
		newCoords.setY((int)(coords.getY()/scaleY) - pad);
		return newCoords;
	}
	
	/**
	 * Converts a String containing a list of integers into a List of Integer objects.
	 * Used for converting Graphviz position Strings (e.g. list of bendpoints) into 
	 * a real list.
	 * @param text
	 * @return
	 */
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

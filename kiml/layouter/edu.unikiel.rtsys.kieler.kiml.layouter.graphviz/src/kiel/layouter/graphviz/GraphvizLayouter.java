package kiel.layouter.graphviz;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.naming.Name;

import org.eclipse.draw2d.Label;
import org.eclipse.gef.EditPart;
import org.eclipse.ui.internal.util.Descriptors;

import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KDimension;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KEdge;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KNodeGroup;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KPoint;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphFactory;
import edu.unikiel.rtsys.kieler.kiml.layouter.graphviz.GraphvizLayoutProvider;

/**
 * Basic Layout Algorithm employing the Graphviz library (dot layout) to do a
 * graphical layout on a passed Graph datastructure. The basic principle is
 * simple: (1) read the graph datastructure and use the GraphvizAPI to fill a
 * Graphviz internal (native) datastructure. (2) call a Graphviz layout engine
 * (e.g. the dot layouter) on the Graphviz datastructure. The datastructure will
 * get augmented by positioning attributes. (3) Read the position attributes
 * from the Graphviz datastructure and write them back to the KIELER Graph
 * datastructure.
 * 
 * Hierarchy is prepared (by visiting the graph recursively) but not tested yet.
 * 
 * @author haf
 * 
 */
public class GraphvizLayouter {

	/** Store the Graphviz internal C-Pointers of our nodes and edges */
	private HashMap<KNodeGroup, Integer> mapNode2Pointer = new HashMap<KNodeGroup, Integer>();
	private HashMap<KEdge, Integer> mapEdge2Pointer = new HashMap<KEdge, Integer>();

	// private HashMap<EObject, Integer> mapObject2Pointer = new
	// HashMap<EObject, Integer>();

	/** C-pointer to the root GraphvizGraph datastructure */
	private int graphvizGraph;

	/**
	 * dots per inch specification. GraphViz uses inch for some internal sizes
	 * (e.g. width, height) but not for all. Hence finding the right dpi is
	 * crucial for the layout. Setting the dpi attribute for a graph within
	 * GraphViz seems to have no effect.
	 */
	private final float dpi = 96.0f;

	// magic scaling factors to translate between GraphViz and other coordinate
	// systems, difference between point and pica?
	private final float scaleX = 4f / 3f;
	private final float scaleY = 4f / 3f;

	// padding from the borders. pad attribute of GraphViz has no effect
	private final int pad = 10;
	private String layouterName;

	public GraphvizLayouter() {
		init();
	}

	/**
	 * Initializes the GraphvizAPI. Creates a fresh graph and sets global
	 * attributes. Needs to be called before every layouting. GraphViz might
	 * crash otherwise...
	 */
	private void init() {
		GraphvizAPI.initialize();
		graphvizGraph = GraphvizAPI.createGraph("");
		// GraphvizAPI.setGraphAttribute(graphvizGraph, GraphvizAPI.ATTR_DPI,
		// ""+dpi);
		// set layout direction (up/down vs. left/right)
		GraphvizAPI.setGraphAttribute(graphvizGraph, "rankdir", "LR");
		// set padding of the layout. seems to have no effect...
		GraphvizAPI.setGraphAttribute(graphvizGraph, "pad", "1");
		// TODO: set correct shape for node corresponding to actual Draw2D shape
		GraphvizAPI.setGlobalNodeAttribute(graphvizGraph,
				GraphvizAPI.ATTR_SHAPE, "box");
	}

	/**
	 * Recursive visit function that visits the given node as a parent node.
	 * First it calls itself recursively for the children in order to address
	 * the hierarchy. Then it adds the layout stuff to its children
	 * 
	 * TODO: recursive feature highly experimental and not yet tested!
	 * 
	 * @param node
	 *            parent Node to visit (maybe a Graph or a CompositeNode)
	 */
	public void visit(KNodeGroup nodeGroup) {
		this.init();
		mapNodeGroup2Graphviz(nodeGroup);

		if (layouterName.equals(GraphvizLayoutProvider.GRAPHVIZ_CIRCO))
			GraphvizAPI.doCircoLayout(graphvizGraph);
		else if (layouterName.equals(GraphvizLayoutProvider.GRAPHVIZ_NEATO))
			GraphvizAPI.doNeatoLayout(graphvizGraph);
		else if (layouterName.equals(GraphvizLayoutProvider.GRAPHVIZ_TWOPI))
			GraphvizAPI.doTwopiLayout(graphvizGraph);
		else
			GraphvizAPI.doDotLayout(graphvizGraph);

		GraphvizAPI.attachAttributes(graphvizGraph);
		mapGraphviz2NodeGroup(nodeGroup);
	}

	/**
	 * Map a Graph object to the internal GraphvizAPI datastructure. This is
	 * stored in the GraphvizAPI internally.
	 * 
	 * @param graph
	 */
	private void mapNodeGroup2Graphviz(KNodeGroup nodeGroup) {
		int i = 0;
		/*
		 * First process all node to have the pointers for them when creating
		 * the edges
		 */
		for (KNodeGroup subNodeGroup : nodeGroup.getSubNodeGroups()) {
			int pointer = GraphvizAPI.createNode(graphvizGraph, String
					.valueOf(i));
			mapNode2Pointer.put(subNodeGroup, new Integer(pointer));
			String label = subNodeGroup.getLabel().getText();
			if (label == null)
				label = "";
			String height = String.valueOf(dot2Inch((int) subNodeGroup
					.getLayout().getSize().getHeight()));
			String width = String.valueOf(dot2Inch((int) subNodeGroup
					.getLayout().getSize().getWidth()));
			GraphvizAPI.setLocalNodeAttribute(graphvizGraph, pointer, "label",
					label);
			GraphvizAPI.setLocalNodeAttribute(graphvizGraph, pointer, "height",
					height);
			GraphvizAPI.setLocalNodeAttribute(graphvizGraph, pointer, "width",
					width);
			i++;
		}

		/*
		 * Then create the edges
		 */
		for (KNodeGroup subNodeGroup : nodeGroup.getSubNodeGroups()) {
			for (KEdge outgoingEdge : subNodeGroup.getOutgoingEdges()) {
				if (mapNode2Pointer.get(outgoingEdge.getTarget()) != null) {
					int pointer = GraphvizAPI.createEdge(graphvizGraph,
							mapNode2Pointer.get(subNodeGroup), mapNode2Pointer
									.get(outgoingEdge.getTarget()));
					mapEdge2Pointer.put(subNodeGroup.getOutgoingEdges().get(0),
							new Integer(pointer));
					// process label of edge
					if (outgoingEdge.getLabel().size() != 0) {
						// TODO: add calculation from text if size not available
						String labelString = widthToString((int) outgoingEdge
								.getLabel().get(0).getLabelLayout().getSize()
								.getWidth());
						GraphvizAPI.setLocalEdgeAttribute(graphvizGraph,
								pointer, GraphvizAPI.ATTR_LABEL, labelString);
					}
				}
			}
		}
	}

	/**
	 * Read the internal GraphViz datastructure that was filled by the GraphViz
	 * library and write the required parameters back to the Graph object. Hence
	 * the Graph object is the interface between layouter and parties who need
	 * layouted stuff.
	 * 
	 * @param graph
	 *            Graph object to fill with the layout information
	 */
	private void mapGraphviz2NodeGroup(KNodeGroup nodeGroup) {
		GraphvizAPI.writeDOT(graphvizGraph, System.getProperty("user.home")
				+ "/test.dot");
		mapGraphvizNodes2Graph();
		mapGraphvizEdges2Graph();
		setNodeSize(nodeGroup);
	}

	/**
	 * Write all Node related information from GraphViz into the Graph
	 * datastructure
	 */
	private void mapGraphvizNodes2Graph() {
		// iterate over all nodes in the GraphViz graph and copy their
		// attributes to the Graph datastructure
		for (KNodeGroup nodeGroup : mapNode2Pointer.keySet()) {

			int nodePointer = mapNode2Pointer.get(nodeGroup);
			String posString = GraphvizAPI.getAttribute(nodePointer,
					GraphvizAPI.ATTR_POS);
			String heightString = GraphvizAPI.getAttribute(nodePointer,
					GraphvizAPI.ATTR_HEIGHT);
			String width = GraphvizAPI.getAttribute(nodePointer,
					GraphvizAPI.ATTR_WIDTH);
			KPoint location = KimlLayoutGraphFactory.eINSTANCE.createKPoint();
			KDimension size = KimlLayoutGraphFactory.eINSTANCE
					.createKDimension();
			try {
				List<Integer> position = string2Ints(posString);
				// in GraphViz position is the center of the node
				// in draw2D it's the upper left corner
				location = graphviz2Draw2D(position.get(0).intValue(), position
						.get(1).intValue(), nodeGroup.getLayout().getSize());
				size.setHeight(Inch2Dot(Float.parseFloat(heightString)));
				size.setWidth(Inch2Dot(Float.parseFloat(width)));
			} catch (Exception e) {
				/* nothing, might have been invalid String */
				System.out.println(e.getMessage() + " " + posString);
				e.printStackTrace();
			}
			nodeGroup.getLayout().setLocation(location);
			nodeGroup.getLayout().setSize(size);
		}
	}

	/**
	 * Write all Edge related information from GraphViz into the Graph
	 * datastructure
	 */
	private void mapGraphvizEdges2Graph() {
		// iterate over all edges in the GraphViz graph and copy their
		// attributes to the Graph datastructure
		// for (Iterator iter = mapEdge2Pointer.keySet().iterator(); iter
		// .hasNext();) {
		// Edge edge = (Edge) iter.next();
		// int edgePointer = mapEdge2Pointer.get(edge);
		// String posString = GraphvizAPI.getAttribute(edgePointer,
		// GraphvizAPI.ATTR_POS);
		// List<Integer> intList = string2Ints(posString);
		// try {
		// /*
		// * haf, 2008-06-10 GraphViz uses piecewise cubic beziercurves.
		// * Each part consists of: Start point, bezier control point 1,
		// * bezier control point 2, End point. Start point of the next
		// * section is the same as the end point of the last. The control
		// * points are likely to be not part of the path but specify the
		// * bend of the curve.
		// *
		// * Eclipse does not support bezier curves (yet). Standard thing
		// * are Polylines with only explicit bendpoints. I've implemented
		// * some cubic spline connection on top of that. But there all
		// * bendpoints are part of the curve.
		// *
		// * First approximation: only use the start and end points of
		// * GraphViz' bezier parts as bendpoints for the eclipse splines.
		// *
		// * TODO: Add proper bezier path handling when this is supported
		// * by Eclipse!
		// *
		// * @see Eclipse bug: 234808 and 168307
		// */
		//
		// // unsafe because list size might be not a multiple of 6
		// for (int i = 2; i < intList.size() - 1; i += 6) {
		// // i=2: ignore first point pair
		// // i+=6: ignore bezier control points
		// Coordinates point = GraphFactory.eINSTANCE
		// .createCoordinates();
		// point.setX(intList.get(i));
		// point.setY(intList.get(i + 1));
		// point = graphviz2Draw2D(point);
		// edge.getBendpoints().add(point);
		// // System.out.println("bendpoint: "+point.getX()+" "+point.
		// // getY());
		// }
		// // first point in the GraphViz list is the end point
		// Coordinates endPoint = GraphFactory.eINSTANCE
		// .createCoordinates();
		// endPoint.setX(intList.get(0));
		// endPoint.setY(intList.get(1));
		// endPoint = graphviz2Draw2D(endPoint);
		// edge.getBendpoints().add(endPoint);
		// } catch (Exception e) {/* in any failure, leave list empty */
		// }
		// // process label
		// if (edge.getEdgeLabel() != null) {
		// Coordinates coords = GraphFactory.eINSTANCE.createCoordinates();
		// String labelLoc = GraphvizAPI.getAttribute(edgePointer,
		// GraphvizAPI.ATTR_LP);
		// List<Integer> ints = string2Ints(labelLoc);
		// if (ints.size() == 2) {
		// // in GraphViz position is the center of the node
		// // in draw2D it's the upper left corner
		// // TODO: what if size not available?
		// // TODO: optimize exact location (sometimes start is within
		// // connection)
		// coords.setX(ints.get(0).intValue());// -
		// // (edge.getEdgeLabel()
		// // .getSize
		// // ().getWidth()/2));
		// coords.setY(ints.get(1).intValue());// -
		// // (edge.getEdgeLabel()
		// // .getSize
		// // ().getHeight()/2));
		// coords = graphviz2Draw2D(coords, edge.getEdgeLabel()
		// .getSize());
		// } else { // got strange String from GraphViz
		// coords.setX(0);
		// coords.setY(0);
		// }
		// edge.getEdgeLabel().setPosition(coords);
		// }// if edgeLabel
		//
		// }// for edges
	}

	/**
	 * Sets the required size of the node (i.e. a CompositeNode or a Graph) by
	 * obtaining the bounding box of the GraphViz Graph. Will leave the old
	 * sizes for simple Nodes and empty CompositeNodes.
	 * 
	 * @param node
	 */
	private void setNodeSize(KNodeGroup nodeGroup) {
		Dimension bb = GraphvizAPI.getBoundingBox(graphvizGraph);
		KDimension size = KimlLayoutGraphFactory.eINSTANCE.createKDimension();
		float left = 0, right = 0, bottom = 0, top = 0;
		try {
			top = nodeGroup.getLayout().getInsets().getTop();
			bottom = nodeGroup.getLayout().getInsets().getBottom();
			left = nodeGroup.getLayout().getInsets().getLeft();
			right = nodeGroup.getLayout().getInsets().getRight();
		} catch (Exception e) {
			// no insets available
		}
		size.setWidth(((bb.width + 2 * pad) * scaleX) + left + right);
		size.setHeight(((bb.height + 2 * pad) * scaleY) + top + bottom);
		nodeGroup.getLayout().setSize(size);
	}

	/**
	 * Given a size (width) in points, a String is returned, that tries to fill
	 * this size with some text. As default font size Times Roman in 14 point
	 * size is assumed (default of GraphViz label text size). Rationale: Eclipse
	 * uses an actual size (width+height) for labels, GraphViz knows only a
	 * specific text of a label and calculates its size internally.
	 * 
	 * @param points
	 * @return
	 */
	private String widthToString(int points) {
		int sizeOfLetter = 9; // TODO: remove magic number
		int amount = (points / sizeOfLetter);
		int offset = 4; // TODO: check magic offset number (due to icon in front
		// of label)
		char letters[] = new char[amount + offset];
		for (int i = 0; i < letters.length; i++) {
			letters[i] = 'T'; // TODO: check magic letter
		}
		return new String(letters);
	}

	/**
	 * Tranforms dots into inches, using the internal dpi factor.
	 * 
	 * @param dots
	 * @return inches
	 */
	private float dot2Inch(int dots) {
		float inches = (dots / (float) dpi);
		// // System.out.println("dpi: "+dots+" "+inches);
		return inches;
	}

	/**
	 * Tranforms inches into dots, using the internal dpi factor.
	 * 
	 * @param iches
	 * @return dots
	 */
	private int Inch2Dot(float inch) {
		return (int) (inch * dpi);
	}

	/**
	 * Transforms GraphvizCoordinates to Draw2D (KIELER) coordinates of any
	 * sized object (e.g. nodes). There are some scaling factors between those
	 * two coordinate systems. Padding is also used.
	 * 
	 * @param coords
	 *            GraphViz Coordinates
	 * @param size
	 *            Size of the item. Required because GraphViz coordinates are at
	 *            the center of any item and Draw2D coordinates are at the upper
	 *            left corner.
	 * @return Draw2D coordinates
	 */
	private KPoint graphviz2Draw2D(int x, int y, KDimension size) {
		KPoint newLocation = KimlLayoutGraphFactory.eINSTANCE.createKPoint();
		newLocation.setX((x * scaleX) - (size.getWidth() / 2) + pad);
		newLocation.setY((y * scaleY) - (size.getHeight() / 2) + pad);
		return newLocation;
	}

	/**
	 * Transforms Draw2D (KIELER) coordinates to GraphViz Coordinates of any
	 * sized object (e.g. nodes). There are some scaling factors between those
	 * two coordinate systems. Padding is also used.
	 * 
	 * @param coords
	 *            Draw2D Coordinates
	 * @param size
	 *            Size of the item. Required because GraphViz coordinates are at
	 *            the center of any item and Draw2D coordinates are at the upper
	 *            left corner.
	 * @return GraphViz coordinates
	 */
	private KPoint draw2D2Graphviz(KPoint location, KDimension size) {
		KPoint newLocation = KimlLayoutGraphFactory.eINSTANCE.createKPoint();
		newLocation.setX((int) (location.getX() / scaleX)
				+ (size.getWidth() / 2) - pad);
		newLocation.setY((int) (location.getY() / scaleY)
				+ (size.getHeight() / 2) - pad);
		return newLocation;
	}

	/**
	 * Transforms GraphvizCoordinates to Draw2D (KIELER) coordinates only for
	 * unsized objects (points). There are some scaling factors between those
	 * two coordinate systems. Padding is also used.
	 * 
	 * @param coords
	 *            GraphViz Coordinates
	 * @return Draw2D coordinates
	 */
	private KPoint graphviz2Draw2D(KPoint coords) {
		KPoint newLocation = KimlLayoutGraphFactory.eINSTANCE.createKPoint();
		newLocation.setX((int) (coords.getX() * scaleX) + pad);
		newLocation.setY((int) (coords.getY() * scaleY) + pad);
		return newLocation;
	}

	/**
	 * Transforms Draw2D (KIELER) coordinates to GraphViz Coordinates only for
	 * unsized objects (points). There are some scaling factors between those
	 * twoo coordinate systems. Padding is also used.
	 * 
	 * @param coords
	 *            () Draw2D Coordinates
	 * @return GraphViz coordinates
	 */
	private KPoint draw2D2Graphviz(KPoint coords) {
		KPoint newLocation = KimlLayoutGraphFactory.eINSTANCE.createKPoint();
		newLocation.setX((int) (coords.getX() / scaleX) - pad);
		newLocation.setY((int) (coords.getY() / scaleY) - pad);
		return newLocation;
	}

	/**
	 * Converts a String containing a list of integers into a List of Integer
	 * objects. Used for converting GraphViz position Strings (e.g. list of
	 * bendpoints) into a real list.
	 * 
	 * @param text
	 * @return
	 */
	private List<Integer> string2Ints(String text) {
		ArrayList intList = new ArrayList();
		if (text != null) {
			String[] tokens = text.split(",|\\s"); // \s = any whitespace char
			for (int i = 0; i < tokens.length; i++) {
				try {
					intList.add(new Integer(tokens[i]));
				} catch (Exception e) {/* nothing */
				}
			}
		}
		return intList;
	}

	public void setLayouterName(String layouterName) {
		this.layouterName = layouterName;
	}
}

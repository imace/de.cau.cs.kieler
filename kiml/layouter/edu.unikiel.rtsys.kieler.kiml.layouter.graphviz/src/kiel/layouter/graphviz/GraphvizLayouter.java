package kiel.layouter.graphviz;

import java.awt.Dimension;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.eclipse.jface.preference.IPreferenceStore;

import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.EDGE_LABEL_PLACEMENT;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KDimension;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KEdge;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KEdgeLabel;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KNodeGroup;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KPoint;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphFactory;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.LAYOUT_OPTION;
import edu.unikiel.rtsys.kieler.kiml.layouter.graphviz.Activator;
import edu.unikiel.rtsys.kieler.kiml.layouter.graphviz.preferences.PreferenceConstants;

/**
 * Basic Layout Algorithm employing the GraphViz library (e.g. dot layout) to do
 * a graphical layout on a passed Graph datastructure. The basic principle is
 * simple: (1) read the graph datastructure and use the GraphvizAPI to fill a
 * GraphViz internal (native) datastructure. (2) call a GraphViz layout engine
 * (e.g. the dot layouter) on the GraphViz datastructure. The datastructure will
 * get augmented by positioning attributes. (3) Read the position attributes
 * from the GraphViz datastructure and write them back to the KIELER Graph
 * datastructure.
 * 
 * Hierarchy is prepared (by visiting the graph recursively) but not tested yet.
 * 
 * @author haf, ars
 * 
 */
public class GraphvizLayouter {

	/** Store the Graphviz internal C-Pointers of our nodes and edges */
	private HashMap<KNodeGroup, Integer> mapNode2Pointer = new HashMap<KNodeGroup, Integer>();
	private HashMap<KEdge, Integer> mapEdge2Pointer = new HashMap<KEdge, Integer>();

	/** C-pointer to the root GraphvizGraph datastructure */
	private int graphvizGraph;

	/**
	 * dots per inch specification. GraphViz uses inch for some internal sizes
	 * (e.g. width, height) but not for all. Hence finding the right dpi is
	 * crucial for the layout. Setting the dpi attribute for a graph within
	 * GraphViz seems to have no effect.
	 */
	private final float dpi = 72.0f;

	// padding from the borders. pad attribute of GraphViz has no effect
	private int padX = 15;
	private int padY = 15;

	private String layouterName;

	public GraphvizLayouter() {
		layouterName=GraphvizLayoutProviderNames.GRAPHVIZ_DOT;
		init();
	}

	public GraphvizLayouter(String layoutProviderName) {
		layouterName = layoutProviderName;	
		init();
	}

	/**
	 * Initializes the GraphvizAPI. Creates a fresh graph and sets global
	 * attributes. Needs to be called before every layout operation. GraphViz
	 * might crash otherwise...
	 */
	private void init() {
		IPreferenceStore store = Activator.getDefault().getPreferenceStore();
		padX = store.getInt(PreferenceConstants.PREF_GRAPHVIZ_PADDING_X);
		padY = store.getInt(PreferenceConstants.PREF_GRAPHVIZ_PADDING_Y);
		GraphvizAPI.initialize();
	}

	/**
	 * TODO: Doc.
	 */
	public void visit(KNodeGroup nodeGroup) {
		// return if there is nothing in this group
		if (nodeGroup.getSubNodeGroups().size() == 0) {
			return;
		}
		graphvizGraph = GraphvizAPI.createGraph("");
		GraphvizAPI.setGlobalNodeAttribute(graphvizGraph,
				GraphvizAPI.ATTR_SHAPE, "box");
		
		mapNodeGroup2Graphviz(nodeGroup);
		if (nodeGroup.getLayout().getLayoutOptions().contains(
				LAYOUT_OPTION.VERTICAL)) {
			GraphvizAPI.setGraphAttribute(graphvizGraph, "rankdir", "BT");
		} else {
			GraphvizAPI.setGraphAttribute(graphvizGraph, "rankdir", "LR");
		}

		if (layouterName.equals(GraphvizLayoutProviderNames.GRAPHVIZ_CIRCO)) {
			// GraphvizAPI.circoCleanup(graphvizGraph);
			GraphvizAPI.doCircoLayout(graphvizGraph);
		} else if (layouterName
				.equals(GraphvizLayoutProviderNames.GRAPHVIZ_NEATO)) {// GraphvizAPI.neatoCleanup(graphvizGraph);
			GraphvizAPI.doNeatoLayout(graphvizGraph);
		} else if (layouterName
				.equals(GraphvizLayoutProviderNames.GRAPHVIZ_TWOPI)) {
			// GraphvizAPI.twopiCleanup(graphvizGraph);
			// GraphvizAPI.setGraphAttribute(graphvizGraph, "splines", "true");
			GraphvizAPI.doTwopiLayout(graphvizGraph);
		} else {
			// GraphvizAPI.dotCleanup(graphvizGraph);
			GraphvizAPI.doDotLayout(graphvizGraph);
		}
		GraphvizAPI.attachAttributes(graphvizGraph);
		mapGraphviz2NodeGroup(nodeGroup);

		/* should Emma debug? */
		if (Activator.getDefault().getPreferenceStore().getBoolean(
				PreferenceConstants.PREF_GRAPHVIZ_ENABLE_DEBUG_OUTPUT)) {

			String outputName = nodeGroup.getIdString().length() != 0 ?
					nodeGroup.getIdString() : "output";
			String outputDir = Activator.getDefault().getPreferenceStore()
					.getString(PreferenceConstants.PREF_GRAPHVIZ_DEBUG_DIR);
			if (outputDir.equals("")) {
				outputDir = System.getProperty("user.home");

			}
			GraphvizAPI.writeDOT(graphvizGraph, outputDir + "/" + outputName
					+ ".dot");
		}
	}

	/**
	 * Map a KNodeGroup object to the internal GraphvizAPI data structure. This
	 * is stored in the GraphvizAPI internally.
	 * 
	 * @param graph
	 */
	private void mapNodeGroup2Graphviz(KNodeGroup nodeGroup) {
		int i = 0;
		/*
		 * First process all nodes to have the pointers for them when creating
		 * the edges.
		 */
		for (KNodeGroup subNodeGroup : nodeGroup.getSubNodeGroups()) {
			int pointer = GraphvizAPI.createNode(graphvizGraph, String
					.valueOf(i));
			mapNode2Pointer.put(subNodeGroup, new Integer(pointer));
			String label = subNodeGroup.getLabel().getText();
			if (label == null)
				label = "";
			/*
			 * Use NumberFormat to format the number into a String to workaround
			 * different possible locales of machines on that Graphviz could run
			 * (could result in different number formats, e.g. 0.33 on english
			 * local, 0,33 on german)
			 */
			String height = pixel2GraphVizInches((int) subNodeGroup.getLayout()
					.getSize().getHeight());
			String width = pixel2GraphVizInches((int) subNodeGroup.getLayout()
					.getSize().getWidth());
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

					// create actual edge
					int pointer = GraphvizAPI.createEdge(graphvizGraph,
							mapNode2Pointer.get(subNodeGroup), mapNode2Pointer
									.get(outgoingEdge.getTarget()));

					// store edge in map
					mapEdge2Pointer.put(outgoingEdge, new Integer(pointer));

					// process labels of edge
					for (KEdgeLabel label : outgoingEdge.getLabel()) {

						/*
						 * As graphViz just handles three labels properly (well,
						 * actually just two, the mid and tail label), hard code
						 * it here. First 'normal' label.
						 */
						if (label.getLabelLayout().getLabelPlacement().equals(
								EDGE_LABEL_PLACEMENT.CENTER)) {
							String labelString = label.getText();

							GraphvizAPI.setLocalEdgeAttribute(graphvizGraph,
									pointer, GraphvizAPI.ATTR_LABEL,
									labelString);
						}
						/*
						 * Give a try for head label.
						 */
						if (label.getLabelLayout().getLabelPlacement().equals(
								EDGE_LABEL_PLACEMENT.HEAD)) {
							String labelString = label.getText();

							GraphvizAPI.setLocalEdgeAttribute(graphvizGraph,
									pointer, GraphvizAPI.ATTR_HEADLABEL,
									labelString);
						}
						/*
						 * Give a try for tail label.
						 */
						if (label.getLabelLayout().getLabelPlacement().equals(
								EDGE_LABEL_PLACEMENT.TAIL)) {
							String labelString = label.getText();

							GraphvizAPI.setLocalEdgeAttribute(graphvizGraph,
									pointer, GraphvizAPI.ATTR_TAILLABEL,
									labelString);
						}
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
		mapGraphvizNodes2KNodes();
		mapGraphvizEdges2KEdges();
		setNodeSize(nodeGroup);
	}

	/**
	 * Write all Node related information from GraphViz into the Graph
	 * datastructure
	 */
	private void mapGraphvizNodes2KNodes() {
		// iterate over all nodes in the GraphViz graph and copy their
		// attributes to the Graph datastructure
		for (KNodeGroup nodeGroup : mapNode2Pointer.keySet()) {

			int nodePointer = mapNode2Pointer.get(nodeGroup);
			String posString = GraphvizAPI.getAttribute(nodePointer,
					GraphvizAPI.ATTR_POS);
			String heightString = GraphvizAPI.getAttribute(nodePointer,
					GraphvizAPI.ATTR_HEIGHT);
			String widthString = GraphvizAPI.getAttribute(nodePointer,
					GraphvizAPI.ATTR_WIDTH);
			KPoint location = KimlLayoutGraphFactory.eINSTANCE.createKPoint();
			KDimension size = KimlLayoutGraphFactory.eINSTANCE
					.createKDimension();
			try {
				List<Integer> position = string2Ints(posString);
				// use NumberFormat for parsing, see respective methods below
				size.setHeight(graphVizInches2Pixel(heightString));
				size.setWidth(graphVizInches2Pixel(widthString));
				// in GraphViz position is the center of the node
				// in draw2D it's the upper left corner
				location = graphviz2Draw2D(position.get(0).intValue(), position
						.get(1).intValue(), size);

			} catch (Exception e) {
				/* nothing, might have been invalid String */
				/*
				 * FIXME: Better graphical Error Message! This can actually
				 * happen as we have seen (different locales)
				 */
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
	private void mapGraphvizEdges2KEdges() {
		// iterate over all edges in the GraphViz graph and copy their
		// attributes to the Graph datastructure
		for (KEdge edge : mapEdge2Pointer.keySet()) {

			int edgePointer = mapEdge2Pointer.get(edge);
			String posString = GraphvizAPI.getAttribute(edgePointer,
					GraphvizAPI.ATTR_POS);
			List<Integer> intList = string2Ints(posString);
			try {
				/*
				 * haf, 2008-06-10 GraphViz uses piecewise cubic beziercurves.
				 * Each part consists of: Start point, bezier control point 1,
				 * bezier control point 2, End point. Start point of the next
				 * section is the same as the end point of the last. The control
				 * points are likely to be not part of the path but specify the
				 * bend of the curve.
				 * 
				 * Eclipse does not support bezier curves (yet). Standard thing
				 * are Polylines with only explicit bendpoints. I've implemented
				 * some cubic spline connection on top of that. But there all
				 * bendpoints are part of the curve.
				 * 
				 * First approximation: only use the start and end points of
				 * GraphViz' bezier parts as bendpoints for the eclipse splines.
				 * 
				 * TODO: Add proper bezier path handling when this is supported
				 * by Eclipse!
				 * 
				 * @see Eclipse bug: 234808 and 168307
				 */

				// second point in list is the start point
				KPoint startPoint = KimlLayoutGraphFactory.eINSTANCE
						.createKPoint();
				startPoint.setX(intList.get(2));
				startPoint.setY(intList.get(3));
				edge.getLayout().setSourcePoint(graphviz2Draw2D(startPoint));

				// unsafe because list size might be not a multiple of 6
				for (int i = 8; i < intList.size() - 1; i += 6) {
					// i=2: ignore first point pair
					// i+=6: ignore bezier control points
					KPoint point = KimlLayoutGraphFactory.eINSTANCE
							.createKPoint();
					point.setX(intList.get(i));
					point.setY(intList.get(i + 1));
					if (startPoint.getY() != point.getY()) {
						edge.getLayout().getGridPoints().add(
								graphviz2Draw2D(point));
					}
				}
				// first point in the GraphViz list is the end point
				KPoint endPoint = KimlLayoutGraphFactory.eINSTANCE
						.createKPoint();
				endPoint.setX(intList.get(0));
				endPoint.setY(intList.get(1));
				edge.getLayout().setTargetPoint(graphviz2Draw2D(endPoint));

			} catch (Exception e) {/* in any failure, leave list empty */
				System.out.println("Some fault:--------------------- "
						+ e.toString());
			}
			/*
			 * Process labels, there is a maximum of three that can be handled
			 * by GraphViz. Well, actually two with locations.
			 */
			for (KEdgeLabel label : edge.getLabel()) {

				// head label
				if (label.getLabelLayout().getLabelPlacement().equals(
						EDGE_LABEL_PLACEMENT.HEAD)) {
					;// not possible to get the head label placement with
					// GraphViz.

				}

				// mid label
				if (label.getLabelLayout().getLabelPlacement().equals(
						EDGE_LABEL_PLACEMENT.CENTER)) {
					String midLoc = GraphvizAPI.getAttribute(edgePointer,
							GraphvizAPI.ATTR_LP);
					List<Integer> midInts = string2Ints(midLoc);
					KPoint midLocation = KimlLayoutGraphFactory.eINSTANCE
							.createKPoint();
					if (midInts.size() == 2) {
						KDimension labelSize = KimlLayoutGraphFactory.eINSTANCE
								.createKDimension();
						labelSize = label.getLabelLayout().getSize();
						labelSize.setHeight(10);
						midLocation = graphviz2Draw2D(
								midInts.get(0).intValue(), midInts.get(1)
										.intValue(), labelSize);
					}
					label.getLabelLayout().setLocation(midLocation);
				}

				// tail label
				if (label.getLabelLayout().getLabelPlacement().equals(
						EDGE_LABEL_PLACEMENT.TAIL)) {
					String tailLoc = GraphvizAPI.getAttribute(edgePointer,
							GraphvizAPI.ATTR_TAILLP);
					List<Integer> tailInts = string2Ints(tailLoc);
					KPoint tailLocation = KimlLayoutGraphFactory.eINSTANCE
							.createKPoint();
					if (tailInts.size() == 2) {
						KDimension labelSize = KimlLayoutGraphFactory.eINSTANCE
								.createKDimension();
						labelSize = label.getLabelLayout().getSize();
						labelSize.setHeight(-6);
						tailLocation = graphviz2Draw2D(tailInts.get(0)
								.intValue(), tailInts.get(1).intValue(),
								labelSize);
					}
					label.getLabelLayout().setLocation(tailLocation);
				}

			}

		}
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
		size.setWidth((bb.width + 2 * padX) + left + right);
		size.setHeight((bb.height + 2 * padY) + top + bottom);
		nodeGroup.getLayout().setSize(size);
	}

	/**
	 * Transforms pixel into a GraphViz inch string, taking care of the
	 * platform's current locale settings. Under different locales, the height
	 * and width values of GraphViz use dots, respective periods.
	 * 
	 * @param pixel
	 * @return localized inch string
	 */
	private String pixel2GraphVizInches(int pixel) {
		return NumberFormat.getInstance().format(pixel / (float) dpi);
	}

	/**
	 * Transforms GraphViz written inches into pixel, using the internal dpi
	 * factor and taking care of the platform's current locale settings. Under
	 * different locales, the height and width values of GraphViz use dots,
	 * respective periods.
	 * 
	 * @param graphViz
	 *            inches
	 * @return pixel
	 */
	private int graphVizInches2Pixel(String dotInches) throws ParseException {
		return (int) (NumberFormat.getInstance().parse(dotInches).floatValue() * dpi);
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
		newLocation.setX(x - (size.getWidth() / 2) + padX);
		newLocation.setY(y - (size.getHeight() / 2) + padY);
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
	private KPoint graphviz2Draw2D(KPoint location) {
		KPoint newLocation = KimlLayoutGraphFactory.eINSTANCE.createKPoint();
		newLocation.setX((int) location.getX() + padX);
		newLocation.setY((int) location.getY() + padY);
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
		ArrayList<Integer> intList = new ArrayList<Integer>();
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
}

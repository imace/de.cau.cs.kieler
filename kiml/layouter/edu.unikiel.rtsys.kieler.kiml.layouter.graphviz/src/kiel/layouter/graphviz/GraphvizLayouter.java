/*******************************************************************************
 * Copyright (c) 2008 Real-Time and Embedded Systems group
 *
 * INSERT LICENCE HERE
 *
 *
 * Author: Arne Schipper, ars@informatik.uni-kiel.de 
 *
 *******************************************************************************/
package kiel.layouter.graphviz;

import java.awt.Dimension;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.jface.preference.IPreferenceStore;

import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.EDGE_LABEL_PLACEMENT;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.EDGE_TYPE;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KDimension;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KEdge;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KEdgeLabel;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KEdgeLayout;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KNodeGroup;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KPoint;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphFactory;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.LAYOUT_OPTION;
import edu.unikiel.rtsys.kieler.kiml.layouter.graphviz.Activator;
import edu.unikiel.rtsys.kieler.kiml.layouter.graphviz.preferences.PreferenceConstants;

/**
 * Basic layout algorithm employing the GraphViz library (e.g. dot layout) to do
 * a graphical layout on the passed
 * {@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KLayoutGraph
 * KLayoutGraph} data structure. The basic principle is simple:
 * <ol>
 * <li>Read the KLayoutGraph data structure and use the {@link GraphvizAPI} to
 * fill a GraphViz internal (native) data structure.</li>
 * <li>Call a GraphViz layout engine (e.g. the dot layouter) on the GraphViz
 * data structure. The data structure will get augmented by positioning
 * attributes.</li>
 * <li>Read the position attributes from the GraphViz datastructure and write
 * them back to the KIELER Graph data structure.</li>
 * </ol>
 * <p/>
 * Supported features are node sizes and positions, tail and mid label
 * positions. Edges in GraphViz are described as B-splines curves. The bezier
 * curves are converted here to polyline to be able to work with an GEF/GMF
 * editor.
 * <p/>
 * No hierarchy is supported by this implementation. Rather, some preprocessing
 * should take care hierarchy handling. One possibility is to send every
 * hierarchy level separately to a new GraphViz layouter, using the size
 * information gained in a previous step as the size of the nodes in the current
 * step.
 * 
 * @author <a href="mailto:ars@informatik.uni-kiel.de">Arne Schipper</a>
 * @author <a href="mailto:haf@informatik.uni-kiel.de">Hauke Fuhrmann</a>
 * 
 */
public class GraphvizLayouter {

	/* Store the GraphViz internal C-Pointers of our nodes and edges */
	private HashMap<KNodeGroup, Integer> mapNode2Pointer = new HashMap<KNodeGroup, Integer>();
	private HashMap<KEdge, Integer> mapEdge2Pointer = new HashMap<KEdge, Integer>();

	/* C-pointer to the root GraphvizGraph data structure */
	private int graphvizGraph;

	/*
	 * Dots per inch specification. GraphViz uses inch for some internal sizes
	 * (e.g. width, height) but not for all. Hence finding the right DPI is
	 * crucial for the layout. Setting the DPI attribute for a graph within
	 * GraphViz seems to have no effect.
	 */
	private final float dpi = 72.0f;

	/* padding from the borders. pad attribute of GraphViz has no effect */
	private int prefPadX = 15;
	private int prefPadY = 15;

	/* holds the String denoting the desired layouter of the GraphViz suite */
	private String layouterName;

	/**
	 * Creates a new KIML GraphViz layouter using the dot layout engine. Loads
	 * the preference values.
	 * 
	 */
	public GraphvizLayouter() {
		layouterName = GraphvizLayoutProviderNames.GRAPHVIZ_DOT;
		GraphvizAPI.initialize();
	}

	/**
	 * Creates a new KIML GraphViz layouter with the specified concrete GraphViz
	 * layouter (e.g. GraphViz Circo). Loads the preference values.
	 * 
	 * @param layoutProviderName
	 *            A String denoting the layouter. Must be one of those declared
	 *            in {@link GraphvizLayoutProviderNames}.
	 */
	public GraphvizLayouter(String layoutProviderName) {
		layouterName = layoutProviderName;
		GraphvizAPI.initialize();
	}

	/**
	 * Updates the preferences for the GraphViz layouter. Is called from visit
	 * at the beginning.
	 */
	private void updatePreferences() {
		IPreferenceStore store = Activator.getDefault().getPreferenceStore();
		prefPadX = store.getInt(PreferenceConstants.PREF_GRAPHVIZ_PADDING_X);
		prefPadY = store.getInt(PreferenceConstants.PREF_GRAPHVIZ_PADDING_Y);
	}

	/**
	 * Performs the actual work of the layout process. Translates the
	 * {@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KNodeGroup
	 * KNodeGroup} into a structure GraphViz understands, calls the desired
	 * GraphViz layouter and annotates the KLayoutGraph with the position and
	 * size information provided by GraphViz.
	 * 
	 * @param nodeGroup
	 *            The KNodeGroup to process
	 */
	public void visit(KNodeGroup nodeGroup) {
		updatePreferences();

		/* return if there is nothing in this group */
		if (nodeGroup.getSubNodeGroups().size() == 0) {
			return;
		}

		/* create fresh internal GraphViz graph */
		graphvizGraph = GraphvizAPI.createGraph("");
		GraphvizAPI.setGlobalNodeAttribute(graphvizGraph,
				GraphvizAPI.ATTR_SHAPE, "box");

		/* translate the KLayoutGraph to GraphViz */
		mapNodeGroup2Graphviz(nodeGroup);

		/* check if Emma wants to layout horizontal */
		if (nodeGroup.getLayout().getLayoutOptions().contains(
				LAYOUT_OPTION.VERTICAL)) {
			GraphvizAPI.setGraphAttribute(graphvizGraph, "rankdir", "BT");
		} else {
			GraphvizAPI.setGraphAttribute(graphvizGraph, "rankdir", "LR");
		}

		/* pick up desired layouter */
		if (layouterName.equals(GraphvizLayoutProviderNames.GRAPHVIZ_CIRCO)) {
			GraphvizAPI.doCircoLayout(graphvizGraph);
			GraphvizAPI.attachAttributes(graphvizGraph);
			mapGraphviz2NodeGroup(nodeGroup);
			GraphvizAPI.circoCleanup(graphvizGraph);
		} else if (layouterName
				.equals(GraphvizLayoutProviderNames.GRAPHVIZ_NEATO)) {
			GraphvizAPI.doNeatoLayout(graphvizGraph);
			GraphvizAPI.attachAttributes(graphvizGraph);
			mapGraphviz2NodeGroup(nodeGroup);
			GraphvizAPI.neatoCleanup(graphvizGraph);
		} else if (layouterName
				.equals(GraphvizLayoutProviderNames.GRAPHVIZ_TWOPI)) {
			GraphvizAPI.doTwopiLayout(graphvizGraph);
			GraphvizAPI.attachAttributes(graphvizGraph);
			mapGraphviz2NodeGroup(nodeGroup);
			GraphvizAPI.twopiCleanup(graphvizGraph);
		} else {
			GraphvizAPI.doDotLayout(graphvizGraph);
			GraphvizAPI.attachAttributes(graphvizGraph);
			mapGraphviz2NodeGroup(nodeGroup);
			GraphvizAPI.dotCleanup(graphvizGraph);
		}

		/* should Emma debug? */
		if (Activator.getDefault().getPreferenceStore().getBoolean(
				PreferenceConstants.PREF_GRAPHVIZ_ENABLE_DEBUG_OUTPUT)) {

			String outputName = nodeGroup.getIdString().length() != 0 ? nodeGroup
					.getIdString()
					: "output";
			String outputDir = Activator.getDefault().getPreferenceStore()
					.getString(PreferenceConstants.PREF_GRAPHVIZ_DEBUG_DIR);
			if (outputDir.equals("")) {
				outputDir = System.getProperty("user.home");

			}
			GraphvizAPI.writeDOT(graphvizGraph, outputDir + "/" + outputName
					+ ".dot");
		}

		/* cleanup */
		mapNode2Pointer.clear();
		mapEdge2Pointer.clear();
	}

	/**
	 * Maps a
	 * {@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KNodeGroup
	 * KNodeGroup} to the internal GraphvizAPI data structure. This is stored in
	 * the GraphvizAPI internally.
	 * 
	 * @param nodeGroup
	 *            A KNodeGroup with the graph to lay out, the actual nodes of
	 *            the graph are stored as subgroups of the nodeGroup.
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
			 * different possible locales of machines on that GraphViz could run
			 * (could result in different number formats, e.g. 0.33 on English
			 * local, 0,33 on German)
			 */
			String height = pixels2GraphVizInches((int) subNodeGroup
					.getLayout().getSize().getHeight());
			String width = pixels2GraphVizInches((int) subNodeGroup.getLayout()
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
					GraphvizAPI.setLocalEdgeAttribute(graphvizGraph, pointer,
							"arrowhead", "none");
					GraphvizAPI.setLocalEdgeAttribute(graphvizGraph, pointer,
							"arrowtail", "none");
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
	 * Reads the internal GraphViz data structure that was filled by the
	 * GraphViz library and writes the required parameters back to the
	 * {@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KNodeGroup
	 * KNodeGroup}.
	 * 
	 * @param nodeGroup
	 *            The KNodeGroup to be filled with the layout information
	 */
	private void mapGraphviz2NodeGroup(KNodeGroup nodeGroup) {
		mapGraphvizNodes2KNodes();
		mapGraphvizEdges2KEdges();
		setTopNodeAttributes(nodeGroup);
	}

	/**
	 * Writes all node related information from GraphViz into the KNodeGroup.
	 * Uses HashMaps for the mapping.
	 */
	private void mapGraphvizNodes2KNodes() {
		/*
		 * iterate over all nodes in the GraphViz graph and copy their
		 * attributes to the Graph data structure
		 */
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
				size.setHeight(graphVizInches2Pixels(heightString));
				size.setWidth(graphVizInches2Pixels(widthString));
				// in GraphViz position is the center of the node
				// in draw2D it's the upper left corner
				location = graphviz2KPoint(position.get(0).intValue(), position
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
	 * Writes all edge related information from GraphViz into the the
	 * KNodeGroup. Uses HashMaps for the mapping.
	 */
	private void mapGraphvizEdges2KEdges() {
		/*
		 * iterate over all edges in the GraphViz graph and copy their
		 * attributes to the Graph data structure
		 */
		for (KEdge edge : mapEdge2Pointer.keySet()) {

			int edgePointer = mapEdge2Pointer.get(edge);
			String posString = GraphvizAPI.getAttribute(edgePointer,
					GraphvizAPI.ATTR_POS);
			List<Integer> intList = string2Ints(posString);
			try {
				/*
				 * ars, 2008-11-15: when setting arrowhead to 'none' than there
				 * is no seperate end coordinate for the edge given, as assumed
				 * before.
				 * 
				 * ars, 2008-11-21, GraphViz uses cubic B-Splines, some
				 * generalisation of Bezier Curves. The B-Splines are converted
				 * here to a polyline that Eclipse understands
				 * 
				 * Addressing bezier curves in eclipse:
				 * 
				 * @see Eclipse bug: 234808 and 168307
				 */

				/* first two points in list denote the start point */
				edge.getLayout().setSourcePoint(
						graphviz2KPoint(intList.get(0), intList.get(1)));

				for (int i = 0; i < intList.size() - 7; i += 6) {
					/* convert the bezier representation to a poly line */
					bezierToPolyline(edge.getLayout(), new Point(intList
							.get(i + 0), intList.get(i + 1)), new Point(intList
							.get(i + 2), intList.get(i + 3)), new Point(intList
							.get(i + 4), intList.get(i + 5)), new Point(intList
							.get(i + 6), intList.get(i + 7)));
				}
				/*
				 * need to remove the last grid point, as this is the same as
				 * the target point below
				 */
				edge.getLayout().getGridPoints().remove(
						edge.getLayout().getGridPoints().size() - 1);

				/* last two points in the GraphViz list denote the end point */
				edge.getLayout().setTargetPoint(
						graphviz2KPoint(intList.get(intList.size() - 2),
								intList.get(intList.size() - 1)));

				/* tell all users that we produced some sort of spline */
				edge.getLayout().setEdgeType(EDGE_TYPE.SPLINE);

			} catch (Exception e) {
				/* in any failure, leave list empty */
				/* FIXME: Graphical or at least better error handling */
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
					;/*
					 * not possible to get the head label (placement) with
					 * GraphViz
					 */
				}

				/* mid label */
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
						midLocation = graphviz2KPoint(
								midInts.get(0).intValue() + 2, midInts.get(1)
										.intValue(), labelSize);
					}
					label.getLabelLayout().setLocation(midLocation);
				}

				/* tail label */
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
						/* small adjust of size, and therefore of position */
						labelSize.setHeight(labelSize.getHeight() + 7);
						tailLocation = graphviz2KPoint(tailInts.get(0)
								.intValue(), tailInts.get(1).intValue(),
								labelSize);
					}
					label.getLabelLayout().setLocation(tailLocation);
				}
			}
		}
	}

	/**
	 * Sets the required size of the top KNodeGroup by obtaining the bounding
	 * box of the GraphViz Graph, resulting from the positions of the contained
	 * sub nodes. If insets are given in the top KNodeGroup, they are added to
	 * the size. Insets denote the difference between the resulting size of the
	 * area the contained elements cover after the layout process and the real
	 * size the composite node should have. An example is a compartment with a
	 * header. The size (height) of the header has to be added to the desired
	 * resulting size of the top KNodeGroup.
	 * 
	 * @param nodeGroup
	 *            The top KNodeGroup to set the size of
	 */
	private void setTopNodeAttributes(KNodeGroup nodeGroup) {
		Dimension bb = GraphvizAPI.getBoundingBox(graphvizGraph);
		KDimension size = KimlLayoutGraphFactory.eINSTANCE.createKDimension();
		float left = 0, right = 0, bottom = 0, top = 0;
		try {
			top = nodeGroup.getLayout().getInsets().getTop();
			bottom = nodeGroup.getLayout().getInsets().getBottom();
			left = nodeGroup.getLayout().getInsets().getLeft();
			right = nodeGroup.getLayout().getInsets().getRight();
		} catch (Exception e) {
			/* no insets available, stay silent */
		}
		size.setWidth((bb.width + 2 * prefPadX) + left + right);
		size.setHeight((bb.height + 2 * prefPadY) + top + bottom);
		nodeGroup.getLayout().setSize(size);
	}

	/**
	 * Transforms pixel into a GraphViz inch string, taking care of the
	 * platform's current locale settings. Under different locales, the height
	 * and width values of GraphViz use dots, respective periods.
	 * 
	 * @param pixels
	 *            the pixels to transform
	 * @return a localized inch string
	 */
	private String pixels2GraphVizInches(int pixels) {
		return NumberFormat.getInstance().format(pixels / (float) dpi);
	}

	/**
	 * Transforms GraphViz written inches into pixel, using the internal dpi
	 * factor and taking care of the platform's current locale settings. Under
	 * different locales, the height and width values of GraphViz use dots,
	 * respective periods.
	 * 
	 * @param dotInches
	 *            localized inches to transform into pixels
	 * @return pixel corresponding to the provided inches
	 */
	private int graphVizInches2Pixels(String dotInches) throws ParseException {
		return (int) (NumberFormat.getInstance().parse(dotInches).floatValue() * dpi);
	}

	/**
	 * Transforms GraphvizCoordinates to
	 * {@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KPoint
	 * KPoint} (KLayoutGraph) coordinates. The size of the provided item is used
	 * to adjust the resulting location. Padding is also used.
	 * 
	 * @param x
	 *            GraphViz x coordinate
	 * @param y
	 *            GraphViz y coordinate
	 * @param size
	 *            Size of the item. Required because GraphViz coordinates are at
	 *            the center of any item and KPoint coordinates are at the upper
	 *            left corner.
	 * @return KPoint the location of the item in terms of the upper left corner
	 */
	private KPoint graphviz2KPoint(int x, int y, KDimension size) {
		KPoint newLocation = KimlLayoutGraphFactory.eINSTANCE.createKPoint();
		newLocation.setX(x - (size.getWidth() / 2) + prefPadX);
		newLocation.setY(y - (size.getHeight() / 2) + prefPadY);
		return newLocation;
	}

	/**
	 * Transforms GraphvizCoordinates to
	 * {@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KPoint
	 * KPoint} (KLayoutGraph) coordinates. Padding is also used.
	 * 
	 * @param location
	 *            GraphViz Coordinates
	 * @return Draw2D coordinates
	 */
	private KPoint graphviz2KPoint(int x, int y) {
		KPoint newLocation = KimlLayoutGraphFactory.eINSTANCE.createKPoint();
		newLocation.setX(x + prefPadX);
		newLocation.setY(y + prefPadY);
		return newLocation;
	}

	private void bezierToPolyline(KEdgeLayout layout, Point p0, Point p1,
			Point p2, Point p3) {

		/*
		 * as the start point is not added below, that means the number of
		 * points added to the polyline are the integer below -1
		 */
		int numberOfPoints = 4;
		float dt;
		int i;

		dt = (float) (1.0 / (numberOfPoints - 1));
		float ax, bx, cx;
		float ay, by, cy;
		float tSquared, tCubed;

		cx = (float) (3.0 * (p1.x - p0.x));
		bx = (float) (3.0 * (p2.x - p1.x) - cx);
		ax = p3.x - p0.x - cx - bx;

		cy = (float) (3.0 * (p1.y - p0.y));
		by = (float) (3.0 * (p2.y - p1.y) - cy);
		ay = p3.y - p0.y - cy - by;

		for (i = 1; i < numberOfPoints; i++) {
			float t = i * dt;

			tSquared = t * t;
			tCubed = tSquared * t;
			int x = (int) (((ax * tCubed) + (bx * tSquared) + (cx * t)) + p0.x);
			int y = (int) (((ay * tCubed) + (by * tSquared) + (cy * t)) + p0.y);
			layout.getGridPoints().add(graphviz2KPoint(x, y));
		}
	}

	/**
	 * Converts a string containing a list of integers into a List of Integer
	 * objects. Used for converting GraphViz position Strings (e.g. list of
	 * bendpoints) into a real list.
	 * 
	 * @param integerStringList
	 *            A comma separated string with integers
	 * @return A list holding all the provided Integers of the string
	 */
	private List<Integer> string2Ints(String integerStringList) {
		ArrayList<Integer> intList = new ArrayList<Integer>();
		if (integerStringList != null) {
			/* \s = any whitespace char */
			String[] tokens = integerStringList.split(",|\\s");
			for (int i = 0; i < tokens.length; i++) {
				try {
					intList.add(new Integer(tokens[i]));
				} catch (Exception e) {
					/* nothing */
				}
			}
		}
		return intList;
	}
}

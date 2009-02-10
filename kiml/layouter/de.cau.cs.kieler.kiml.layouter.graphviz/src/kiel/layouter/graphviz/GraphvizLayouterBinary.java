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
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.ui.statushandlers.StatusManager;

import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KEdgeLabelPlacement;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KEdgeType;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KDimension;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutEdge;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KEdgeLabel;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KEdgeLayout;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutNode;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KPoint;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphFactory;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutOption;
import de.cau.cs.kieler.kiml.layouter.graphviz.Activator;
import de.cau.cs.kieler.kiml.layouter.graphviz.preferences.PreferenceConstants;


/**
 * Basic layout algorithm employing the GraphViz library (e.g. dot layout) to do
 * a graphical layout on the passed
 * {@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutGraph
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
public class GraphvizLayouterBinary {
	/**
	   * This is the dimension of bounding box from last read graph.
	   */
	  private Dimension boundingBox;

	 /**
	   * This is the stdin of dot process.
	   */
	  private PrintWriter dotInput;

	  /**
	   * This is the stdout of dot process.
	   */
	  private BufferedReader dotOutput;

	  /**
	   * This is the stderr of dot process.
	   */
	  private BufferedReader errorStream;
	  /**
	   * This is the dot process.
	   */
	  private Process graphvizProcess;

	  /**
	   * Maps the object id to the object itself.
	   */
	  private HashMap idToObject;

	
	/* Store the GraphViz internal C-Pointers of our nodes and edges */
	private HashMap<KLayoutNode, Integer> mapNode2Pointer = new HashMap<KLayoutNode, Integer>();
	private HashMap<KLayoutEdge, Integer> mapEdge2Pointer = new HashMap<KLayoutEdge, Integer>();


	
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
	public GraphvizLayouterBinary() {
		layouterName = GraphvizLayoutProviderNames.GRAPHVIZ_DOT;
		init();
	}

	/**
	 * Creates a new KIML GraphViz layouter with the specified concrete GraphViz
	 * layouter (e.g. GraphViz Circo). Loads the preference values.
	 * 
	 * @param layoutProviderName
	 *            A String denoting the layouter. Must be one of those declared
	 *            in {@link GraphvizLayoutProviderNames}.
	 */
	public GraphvizLayouterBinary(String layoutProviderName) {
		layouterName = layoutProviderName;
		init();
	}
	
	private void init(){
		  idToObject = new HashMap();
		  boundingBox = new Dimension();
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
	 * {@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutNode
	 * KLayoutNode} into a structure GraphViz understands, calls the desired
	 * GraphViz layouter and annotates the KLayoutGraph with the position and
	 * size information provided by GraphViz.
	 * 
	 * @param node
	 *            The KLayoutNode to process
	 */
	public void visit(KLayoutNode node) {
		updatePreferences();

		/* return if there is nothing in this group */
		if (node.getChildNodes().size() == 0) {
			return;
		}

		/* create fresh internal GraphViz graph */
		this.init();
		this.newGraph("KIELER");
		Map<String,String> graphAttributes = new HashMap<String,String>();
		graphAttributes.put(GraphvizAPI.ATTR_SHAPE, "box");

		/* translate the KLayoutGraph to GraphViz */
		mapNodeGroup2Graphviz(node);
		
		/* check if Emma wants to layout horizontal */
		if (node.getLayout().getLayoutOptions().contains(
				KLayoutOption.VERTICAL)) {
			graphAttributes.put("rankdir", "BT");
		} else {
			graphAttributes.put("rankdir", "LR");
		}

		// Apply graph attributes
		this.setGraphAttributes(graphAttributes);
		
		/* pick up desired layouter */
/*		if (layouterName.equals(GraphvizLayoutProviderNames.GRAPHVIZ_CIRCO)) {
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
*/
		
		/* should Emma debug? */
		if (Activator.getDefault().getPreferenceStore().getBoolean(
				PreferenceConstants.PREF_GRAPHVIZ_ENABLE_DEBUG_OUTPUT)) {

			String outputName = node.getIdString().length() != 0 ? node
					.getIdString()
					: "output";
			String outputDir = Activator.getDefault().getPreferenceStore()
					.getString(PreferenceConstants.PREF_GRAPHVIZ_DEBUG_DIR);
			if (outputDir.equals("")) {
				outputDir = System.getProperty("user.home");

			}
			System.out.println("Graphviz dot input:\n"+dotInput);
		}
	}

	/**
	 * Maps a
	 * {@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutNode
	 * KLayoutNode} to the internal GraphvizAPI data structure. This is stored in
	 * the GraphvizAPI internally.
	 * 
	 * @param node
	 *            A KLayoutNode with the graph to lay out, the actual nodes of
	 *            the graph are stored as subgroups of the nodeGroup.
	 */
	private void mapNodeGroup2Graphviz(KLayoutNode node) {
		int i = 0;
		/*
		 * First process all nodes to have the pointers for them when creating
		 * the edges.
		 */
		for (KLayoutNode childNode : node.getChildNodes()) {
			Map<String, String> nodeAttributes = new HashMap<String, String>();
			String label = childNode.getLabel().getText();
			if (label == null)
				label = "";
			/*
			 * Use NumberFormat to format the number into a String to workaround
			 * different possible locales of machines on that GraphViz could run
			 * (could result in different number formats, e.g. 0.33 on English
			 * local, 0,33 on German)
			 */
			String height = pixels2GraphVizInches((int) childNode
					.getLayout().getSize().getHeight());
			String width = pixels2GraphVizInches((int) childNode.getLayout()
					.getSize().getWidth());
			nodeAttributes.put("label", label);
			nodeAttributes.put("height", height);
			nodeAttributes.put("width", width);
			
			addNodeToGraph(childNode, nodeAttributes);
		}

		/*
		 * Then create the edges
		 */
		for (KLayoutNode childNode : node.getChildNodes()) {
			for (KLayoutEdge outgoingEdge : childNode.getOutgoingEdges()) {
				Map<String,String> edgeAttributes = new HashMap<String,String>();
				edgeAttributes.put("arrowhead", "none");
				edgeAttributes.put("arrowtail", "none");
				
				for (KEdgeLabel label : outgoingEdge.getLabel()) {
					/*
					 * As graphViz just handles three labels properly (well,
					 * actually just two, the mid and tail label), hard code
					 * it here. First 'normal' label.
					 */
					if (label.getLabelLayout().getLabelPlacement().equals(
							KEdgeLabelPlacement.CENTER)) {
						String labelString = label.getText();
						edgeAttributes.put(GraphvizAPI.ATTR_LABEL, labelString);
					}
					/*
					 * Give a try for head label.
					 */
					if (label.getLabelLayout().getLabelPlacement().equals(
							KEdgeLabelPlacement.HEAD)) {
						String labelString = label.getText();
						edgeAttributes.put(GraphvizAPI.ATTR_HEADLABEL, labelString);
					}
					/*
					 * Give a try for tail label.
					 */
					if (label.getLabelLayout().getLabelPlacement().equals(
							KEdgeLabelPlacement.TAIL)) {
						String labelString = label.getText();
						edgeAttributes.put(GraphvizAPI.ATTR_TAILLABEL, labelString);
					}
				}
				this.addEdgeToGraph(outgoingEdge, edgeAttributes);
			}
		}
	}

	/**
	 * Reads the internal GraphViz data structure that was filled by the
	 * GraphViz library and writes the required parameters back to the
	 * {@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutNode
	 * KLayoutNode}.
	 * 
	 * @param nodeGroup
	 *            The KLayoutNode to be filled with the layout information
	 */
	private void mapGraphviz2NodeGroup(KLayoutNode nodeGroup) {
		mapGraphvizNodes2KNodes();
		mapGraphvizEdges2KEdges();
		setTopNodeAttributes(nodeGroup);
	}

	/**
	 * Writes all node related information from GraphViz into the KLayoutNode.
	 * Uses HashMaps for the mapping.
	 */
	private void mapGraphvizNodes2KNodes() {
		/*
		 * iterate over all nodes in the GraphViz graph and copy their
		 * attributes to the Graph data structure
		 */
		for (KLayoutNode nodeGroup : mapNode2Pointer.keySet()) {

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

			} catch (Exception exception) {
				/* nothing, might have been invalid String */
				Status status = new Status(IStatus.ERROR, Activator.PLUGIN_ID,
						"Error while mapping nodes (" + posString + ")", exception);
				StatusManager.getManager().handle(status, StatusManager.SHOW);
			}
			nodeGroup.getLayout().setLocation(location);
			nodeGroup.getLayout().setSize(size);
		}
	}

	/**
	 * Writes all edge related information from GraphViz into the the
	 * KLayoutNode. Uses HashMaps for the mapping.
	 */
	private void mapGraphvizEdges2KEdges() {
		/*
		 * iterate over all edges in the GraphViz graph and copy their
		 * attributes to the Graph data structure
		 */
		for (KLayoutEdge edge : mapEdge2Pointer.keySet()) {

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
				edge.getLayout().setEdgeType(KEdgeType.SPLINE);

			} catch (Exception exception) {
				/* in any failure, leave list empty */
				Status status = new Status(IStatus.ERROR, Activator.PLUGIN_ID,
						"Error while mapping edges (" + posString + ")", exception);
				StatusManager.getManager().handle(status, StatusManager.SHOW);
			}
			/*
			 * Process labels, there is a maximum of three that can be handled
			 * by GraphViz. Well, actually two with locations.
			 */
			for (KEdgeLabel label : edge.getLabel()) {

				// head label
				if (label.getLabelLayout().getLabelPlacement().equals(
						KEdgeLabelPlacement.HEAD)) {
					;/*
					 * not possible to get the head label (placement) with
					 * GraphViz
					 */
				}

				/* mid label */
				if (label.getLabelLayout().getLabelPlacement().equals(
						KEdgeLabelPlacement.CENTER)) {
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
						KEdgeLabelPlacement.TAIL)) {
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
	 * Sets the required size of the top KLayoutNode by obtaining the bounding
	 * box of the GraphViz Graph, resulting from the positions of the contained
	 * sub nodes. If insets are given in the top KLayoutNode, they are added to
	 * the size. Insets denote the difference between the resulting size of the
	 * area the contained elements cover after the layout process and the real
	 * size the composite node should have. An example is a compartment with a
	 * header. The size (height) of the header has to be added to the desired
	 * resulting size of the top KLayoutNode.
	 * 
	 * @param nodeGroup
	 *            The top KLayoutNode to set the size of
	 */
	private void setTopNodeAttributes(KLayoutNode nodeGroup) {
		Dimension bb = this.boundingBox;
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
	 * {@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KPoint
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
	 * {@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KPoint
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
	
	 /**
	   * @see GraphvizLayouter#newGraph(String)
	   */
	  protected final void newGraph(final String name) {
	    idToObject.clear();
	    dotInput.println("digraph \"" + name + "\" {");
	  }
	  
	  /**
	   * @see GraphvizLayouter#setGraphAttributes(Map)
	   */
	  protected final void setGraphAttributes(final Map<String,String> attributes) {
	    Iterator iter = attributes.keySet().iterator();

	    dotInput.print("graph [");

	    while (iter.hasNext()) {
	      String key = (String) iter.next();

	      dotInput.print(key + "=\"" + attributes.get(key) + "\"");
	      if (iter.hasNext()) {
	        dotInput.print(", ");
	      }
	    }

	    dotInput.println("];");
	  }

	  /**
	   * @see GraphvizLayouter#addNodeToGraph(Node, Map)
	   */
	  protected final void addNodeToGraph(final KLayoutNode node, final Map<String,String> attributes) {
	    Iterator<String> iter = attributes.keySet().iterator();
	    
	    String nodeID = this.getNodeID(node);
	    dotInput.print("\"" + nodeID + "\" [");

	    while (iter.hasNext()) {
	      String key = (String) iter.next();

	      dotInput.print(key + "=\"" + attributes.get(key) + "\"");
	      if (iter.hasNext()) {
	        dotInput.print(", ");
	      }
	    }

	    dotInput.println("];");

	    idToObject.put(nodeID, node);
	  }
	  
	  /**
	   * @see GraphvizLayouter#addEdgeToGraph(Edge, Map)
	   */
	  protected final void addEdgeToGraph(final KLayoutEdge edge, final Map<String,String> attributes) {
	    Iterator<String> iter = attributes.keySet().iterator();
	    
	    dotInput.print("\"" + this.getNodeID(edge.getSource()) + "\" -> \""
	                   + this.getNodeID(edge.getTarget()) + "\" [");
	    while (iter.hasNext()) {
	      String key = (String) iter.next();
	      dotInput.print(key + "=\"" + ((String) attributes.get(key))
	                     .replaceAll("\n", "\\\\n") + "\"");
	      if (iter.hasNext()) {
	        dotInput.print(", ");
	      }
	    }
	    dotInput.println(", comment=\"" + getEdgeID(edge) + "\"];");
	    idToObject.put(getEdgeID(edge), edge);
	  }
	  
	  /** Create some temporary ID (hash code) */
	  private String getNodeID(KLayoutNode node){
		  String nodeID = "node"+node.hashCode();
		  return nodeID;
	  }
	  private String getEdgeID(KLayoutEdge edge){
		  String edgeID = "edge"+edge.hashCode();
		  return edgeID;
	  }

	  /**
	   * Parses the given attribute string.
	   *
	   * @param line line to be parsed
	   * @return a map of attribute <-> value pairs
	   */
	  private Map<String,String> readAttributes(final String line) {
	    HashMap<String,String> map = new HashMap<String,String>();
	    String attr = null;
	    String value = null;
	    int beginIndex = 0;
	    int i = 0;
	    boolean markedValue;

	    while (i < line.length()) {
	      attr = null;
	      value = null;

	      while ((line.charAt(i) == ',') || (line.charAt(i) == ' ')) {
	        i++;
	      }
	      beginIndex = i;

	      // looking for attribute
	      while (attr == null) {
	        if (line.charAt(i) == '=') {
	          attr = line.substring(beginIndex, i);
	          beginIndex = i + 1;
	        }
	        i++;
	      }

	      // looking for value
	      markedValue = false;
	      while (value == null) {
	        switch (line.charAt(i)) {
	        //case '\\':
	        // escape char, ignore next
	        //    i++;
	        //    break;
	        case '\"':
	          if (markedValue) {
	            value = line.substring(beginIndex, i);
	          } else {
	            beginIndex++;
	            markedValue = true;
	          }
	          break;
	        case ',':
	          if (!markedValue) {
	            value = line.substring(beginIndex, i);
	          }
	          break;
	        default:
	          // all other chars are element of the attribute
	        }

	        i++;
	        if ((i >= line.length()) && (value == null)) {
	          value = line.substring(beginIndex, i);
	        }
	      }
	      value = value.replaceAll("\\n", "\n");
	      map.put(attr, value);
	    }

	    return map;
	  }

	  /**
	   * @see GraphvizLayouter#retrieveLayoutInformations(Collection, View)
	   */
	  protected final void retrieveLayoutInformations(final KLayoutNode nodes) {
	    boolean endOfGraph;

	    // read error stream
	    try {
	      while (errorStream.ready()) {
	    	Status error = new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Graphviz: "+errorStream.readLine());
	    	StatusManager.getManager().handle(error, StatusManager.SHOW);
	      }
	    } catch (IOException e) {
	    	Status error = new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Graphviz: error while reading dot error stream. (" + e + ")");
	    	StatusManager.getManager().handle(error, StatusManager.SHOW);
	    }

	    // read output stream
	    try {
	      endOfGraph = false;
	      while (!endOfGraph) {
	        String line;
	        boolean endOfLine;

	        line = "";
	        endOfLine = false;
	        while (!endOfLine) {
	          String read = dotOutput.readLine();
	          StatusManager.getManager().handle(
	        	      new Status(IStatus.INFO, Activator.PLUGIN_ID, "read: "+read, null),
	        	      StatusManager.LOG);
	          if (read.endsWith("\\")) {
	            line += read.substring(0, read.length() - 1);
	          } else {
	            line += read;
	            endOfLine = true;
	          }
	        }

	        if (line.matches(".*->.*")) {
	          // edge found
	          Map<String,String> attributes;
	          KLayoutEdge edge;
	          attributes = readAttributes(line.substring(
	            line.indexOf('[') + 1, line.lastIndexOf(']')));
	          try{
	          edge = (KLayoutEdge) idToObject.get(attributes.get("comment"));
	          String posString =   (String) attributes.get("pos");
	          List<Integer> intList = string2Ints(posString);
				
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
					edge.getLayout().setEdgeType(KEdgeType.SPLINE);
				
	          
				/*
				 * Process labels, there is a maximum of three that can be handled
				 * by GraphViz. Well, actually two with locations.
				 */
				for (KEdgeLabel label : edge.getLabel()) {

					// head label
					if (label.getLabelLayout().getLabelPlacement().equals(
							KEdgeLabelPlacement.HEAD)) {
						;/*
						 * not possible to get the head label (placement) with
						 * GraphViz
						 */
					}

					/* mid label */
					if (label.getLabelLayout().getLabelPlacement().equals(
							KEdgeLabelPlacement.CENTER)) {
						String midLoc = attributes.get(GraphvizAPI.ATTR_LP);
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
							KEdgeLabelPlacement.TAIL)) {
						String tailLoc = attributes.get(GraphvizAPI.ATTR_TAILLP);
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
	          }catch(Exception e){
					Status myStatus = new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Graphviz Edge result reading problem.", e);
					StatusManager.getManager().handle(myStatus, StatusManager.SHOW);
				} 
	        } else if (line.matches(".*\".*\" \\[.*")) {
	          // node found
	        	try {
				StringTokenizer st = new StringTokenizer(line);
	        	Map<String,String> attributes;
	        	st.nextToken("\""); //
	        	KLayoutNode node = (KLayoutNode) idToObject.get(st.nextToken("\""));
		          st.nextToken("\"["); // " [
		          attributes = readAttributes(st.nextToken("[]"));
				String posString = attributes.get(GraphvizAPI.ATTR_POS); 
				String heightString = attributes.get(GraphvizAPI.ATTR_HEIGHT); 
				String widthString = attributes.get(GraphvizAPI.ATTR_WIDTH); 
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

				} catch (Exception exception) {
					/* nothing, might have been invalid String */
					Status status = new Status(IStatus.ERROR, Activator.PLUGIN_ID,
							"Error while reading node attributes from graphviz (" + posString + ")", exception);
					StatusManager.getManager().handle(status, StatusManager.SHOW);
				}
				node.getLayout().setLocation(location);
				node.getLayout().setSize(size);
	        	} catch (Exception e) {
					Status status = new Status(IStatus.ERROR, Activator.PLUGIN_ID,
							"Error while reading node attributes from graphviz:" , e);
					StatusManager.getManager().handle(status, StatusManager.SHOW);
	        	}
				        
	        } else if (line.matches(".*graph \\[bb.*")) {
	          // bounding box found
	          StringTokenizer st = new StringTokenizer(line, "=,\"");

	          st.nextToken(); // graph [bb
	          st.nextToken(); // 0
	          st.nextToken(); // 0
	          boundingBox.width = Integer.parseInt(st.nextToken());
	          boundingBox.height = Integer.parseInt(st.nextToken());
	        } else if (line.matches(".* \\[.*")
	                   && !(line.matches(".*graph \\[.*")
	                   || line.matches(".*node \\[.*"))) {
	          // node found without "..."
//	          StringTokenizer st = new StringTokenizer(line.trim());
//	          KLayoutNode node;
//	          Map<String,String> attributes;
//	          String id = st.nextToken("[").trim();
//	          node = (KLayoutNode) idToObject.get(id);
//	          if (node != null) {
//	        	  //	          st.nextToken("\"["); // " [
//	            attributes = readAttributes(st.nextToken("[]"));
//	            st = new StringTokenizer((String) attributes.get("pos"),
//	                                     ",");
//	            layoutInfo.setCenterPoint(new Point(
//	              Integer.parseInt(st.nextToken()),
//	              boundingBox.height
//	              - Integer.parseInt(st.nextToken())));
//	          }
	        } else if (line.startsWith("}")) {
	          endOfGraph = true;
	        }
	      }
	    } catch (IOException e) {
	    	Status status = new Status(IStatus.ERROR, Activator.PLUGIN_ID,
					"Error while reading dot output stream." , e);
			StatusManager.getManager().handle(status, StatusManager.SHOW);
	    }
	  }
}

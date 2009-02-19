/*
 *******************************************************************************
 * Copyright (c) 2008 Real-Time and Embedded Systems group
 *
 * INSERT LICENCE HERE
 *
 *
 * @author: Hauke Fuhrmann <haf@informatik.uni-kiel.de> 
 *
 *******************************************************************************/
package kiel.layouter.graphviz;

import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceDialog;
import org.eclipse.ui.dialogs.PreferencesUtil;
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
import de.cau.cs.kieler.kiml.layouter.graphviz.preferences.GraphvizPreferencePage;
import de.cau.cs.kieler.kiml.layouter.graphviz.preferences.PreferenceConstants;
import de.cau.cs.kieler.core.KielerException;
import de.cau.cs.kieler.core.alg.IKielerProgressMonitor;
import de.cau.cs.kieler.core.util.MapPrinter;


/**
 * Basic layout algorithm employing the GraphViz binary (e.g. dot layout) to do
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
public class GraphvizLayouterBinary implements GraphvizLayouter{
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
	  private HashMap<String, Object> idToObject;
	  
	  /**
	   * stores an instance of the preferences dialog.
	   * This is used to present the preferences at the right
	   * tab to the user whenever an error occurred that is likely
	   * caused by wrong preferences 
	   * TODO: put all UI stuff into seperate plugin
	   */
	  PreferenceDialog preferenceDialog;
	  
	/* Store the GraphViz internal C-Pointers of our nodes and edges */
	private HashMap<KLayoutNode, Integer> mapNode2Pointer = new HashMap<KLayoutNode, Integer>();
	private HashMap<KLayoutEdge, Integer> mapEdge2Pointer = new HashMap<KLayoutEdge, Integer>();

	/* internal file counter for debug output files */
	private int fileCounter = 0;
	
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
	
	/* holds the path to the dotExecutable. Will be read from the preferences */
	private String dotExecutable;
	private String dotArgument = GraphvizLayoutProviderNames.COMMAND_PARAMETER+GraphvizLayoutProviderNames.DOT_COMMAND;

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
		this.updatePreferences();
		  idToObject = new HashMap<String, Object>();
		  System.out.println(MapPrinter.toString(idToObject));
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
		dotExecutable = store.getString(PreferenceConstants.PREF_GRAPHVIZ_EXECUTABLE);
		System.out.println("Dot executable: "+dotExecutable);
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
	public void visit(KLayoutNode node, IKielerProgressMonitor progressMonitor)
			throws KielerException {
		progressMonitor.begin("GraphViz layout", 15);
		updatePreferences();

		try{
		/* return if there is nothing in this node */
		if (node.getChildNodes().size() == 0) {
			return;
		}

		/* create fresh internal GraphViz graph */
		this.init();
		
		// start the dot process
		this.startProcess();
		
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
		progressMonitor.worked(5);

		// Apply graph attributes
		this.setGraphAttributes(graphAttributes);
		// finalize graph input and flush it to graphviz
		this.flushGraph();
		progressMonitor.worked(5);
		
		/* pick up desired layouter */
		if (layouterName.equals(GraphvizLayoutProviderNames.GRAPHVIZ_CIRCO)) {
			dotArgument = GraphvizLayoutProviderNames.COMMAND_PARAMETER 
			               + GraphvizLayoutProviderNames.CIRCO_COMMAND;
		} else if (layouterName
				.equals(GraphvizLayoutProviderNames.GRAPHVIZ_NEATO)) {
			dotArgument = GraphvizLayoutProviderNames.COMMAND_PARAMETER 
            			   + GraphvizLayoutProviderNames.NEATO_COMMAND;
		} else if (layouterName
				.equals(GraphvizLayoutProviderNames.GRAPHVIZ_TWOPI)) {
			dotArgument  = GraphvizLayoutProviderNames.COMMAND_PARAMETER 
            + GraphvizLayoutProviderNames.TWOPI_COMMAND;
		} else if (layouterName
				.equals(GraphvizLayoutProviderNames.GRAPHVIZ_FDP)) {
			dotArgument  = GraphvizLayoutProviderNames.COMMAND_PARAMETER 
            + GraphvizLayoutProviderNames.FDP_COMMAND;
		} else {
			dotArgument  = GraphvizLayoutProviderNames.COMMAND_PARAMETER 
            + GraphvizLayoutProviderNames.DOT_COMMAND;
		}

		PrintWriter debugOut = null;
		FileWriter fw = null;
				
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
			try{
				fw = new FileWriter(outputDir+File.separator+outputName); 
				debugOut = new PrintWriter(fw);
				fileCounter++;
			}catch(IOException e){
				Status myStatus = new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Error writing Graphviz Dot file for debugging", e);
				StatusManager.getManager().handle(myStatus, StatusManager.SHOW);
			}
		}
		// Wait for the graphviz process to terminate. This requires that the 
		// input stream has been closed before, otherwise the process will run
		// forever. 
		// TODO: here should be some timeout...
		try {graphvizProcess.waitFor();} catch (InterruptedException e1) {/*nothing*/}
		// read graphviz output and apply layout information to KIELER datastructure
		this.retrieveLayoutInformations(debugOut);
		this.setTopNodeAttributes(node);
		this.killProcess(); // well, actually we know it has already finished, but destroy process anyway to be sure

		if(fw != null)
			try {fw.close();} catch (IOException e) {/*nothing*/}
		if(debugOut != null)
			debugOut.close();
		}catch(GraphvizException ge){
			// TODO move error handling out of the layouter using KielerException
			String message = "Error with the external GraphViz layouter library.";
			Status myStatus = new Status(IStatus.ERROR, Activator.PLUGIN_ID, message, ge);
			StatusManager.getManager().handle(myStatus, StatusManager.BLOCK);
			if(preferenceDialog == null || preferenceDialog.getTray() == null){
				preferenceDialog = PreferencesUtil.createPreferenceDialogOn(null, GraphvizPreferencePage.ID, null, null);
				preferenceDialog.open();
			}
		}
		
		progressMonitor.done();
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
			
			addNodeToGraph(childNode, nodeAttributes, i);
			i++;
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
		NumberFormat machineFormat = NumberFormat.getInstance(Locale.US);
		return machineFormat.format(pixels / (float) dpi);
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
		NumberFormat machineFormat = NumberFormat.getInstance(Locale.US);
		return (int) (machineFormat.parse(dotInches).floatValue() * dpi);
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
			//layout.getGridPoints().add(graphviz2KPoint(x, y));
			layout.getBendPoints().add(graphviz2KPoint(x, y));
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
	   * @see GraphvizLayouterLibrary#newGraph(String)
	   */
	  protected final void newGraph(final String name) {
	    idToObject.clear();
	    System.out.println(MapPrinter.toString(idToObject));
	    dotInput.println("digraph \"" + name + "\" {");
	  }
	  
	  /**
	   * @see GraphvizLayouter#layoutGraph()
	   */
	  protected final void flushGraph() {
	    dotInput.println("}");
	    dotInput.flush();
	    /* the dot process will immediately answer to graph strings
	     * in the input stream, but the process will stay open and
	     * responsive to new inputs, until the input stream is closed.
	     * Hence we close it and will start the process againfor the next 
	     * operation.
	     * TODO: instead of closing the process and starting a new one, 
	     * reusing the same process could be more efficient. This would
	     * require additional exception handling in order to make it
	     * stable and fault tolerant.
	     */
	    dotInput.close();
	  }
	  
	  /**
	   * @see GraphvizLayouterLibrary#setGraphAttributes(Map)
	   */
	  protected final void setGraphAttributes(final Map<String,String> attributes) {
	    Iterator<String> iter = attributes.keySet().iterator();

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
	   * @see GraphvizLayouterLibrary#addNodeToGraph(Node, Map)
	   */
	  protected final void addNodeToGraph(final KLayoutNode node, final Map<String,String> attributes, int number) {
	    Iterator<String> iter = attributes.keySet().iterator();
	    
	    //String nodeID = "node"+number;//this.getNodeID(node);
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
	   * @see GraphvizLayouterLibrary#addEdgeToGraph(Edge, Map)
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
	   * @see GraphvizLayouterLibrary#retrieveLayoutInformations(Collection, View)
	   */
	  protected final void retrieveLayoutInformations(PrintWriter debugWriter) throws GraphvizException{
	    boolean endOfGraph;

	    // read error stream
	    try {
	      while (errorStream.ready()) {
	    	Status error = new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Graphviz: "+errorStream.readLine());
	    	StatusManager.getManager().handle(error, StatusManager.SHOW);
	      }
	    } catch (IOException e) {
	    	throw new GraphvizException(e,"Graphviz: error while reading dot error stream.");
	    }

	    // read output stream
	    try {
	    	// FIXME: should check if dot output is ready somewhere. This would
	    	// require to wait until the dot process has finished. This was not implemented yet, because process.waitFor() does not terminate...
	    	if(!dotOutput.ready())
	    		throw new GraphvizException("Graphviz output stream empty. Most likely incompatible dot binary set.");
	      endOfGraph = false;
	      while (!endOfGraph) {
	        String line;
	        boolean endOfLine;

	        line = "";
	        endOfLine = false;
	        while (!endOfLine) {
	          String read = dotOutput.readLine();
	          //StatusManager.getManager().handle(
	        //	      new Status(IStatus.INFO, Activator.PLUGIN_ID, "read: "+read, null),
	        //	      StatusManager.LOG);
	          if (read.endsWith("\\")) {
	            line += read.substring(0, read.length() - 1);
	          } else {
	            line += read;
	            endOfLine = true;
	          }
	        }
	        if(debugWriter != null)
	        	debugWriter.println(line);

	        if (line.matches(".*->.*")) {
	          retrieveEdgeLayout(line); 
	        } else if (line.matches(".*\".*\" \\[.*")) {
	          // node found
	        	retrieveNodeLayout(line);
	        //} else if (line.matches(".*graph \\[bb.*")) {
	        } else if (line.matches(".*bb=.*")) {
	          // bounding box found
	          retrieveBoundingBox(line);
	        } else if (line.matches(".* \\[.*")
	                   && !(line.matches(".*graph \\[.*")
	                   || line.matches(".*node \\[.*"))) {
	          // node found without "..."
	        	retrieveNodeLayout(line);
	        } else if (line.startsWith("}")) {
	          endOfGraph = true;
	        }
	      }
	    } catch (IOException e) {
			throw new GraphvizException(e,"Error while reading dot output stream.");
	    }
	  }

	private void retrieveBoundingBox(String line) {
		StringTokenizer st = new StringTokenizer(line, "=,\"");

		  st.nextToken(); // graph [bb
		  st.nextToken(); // 0
		  st.nextToken(); // 0
		  boundingBox.width =  Integer.parseInt(st.nextToken());
		  boundingBox.height = Integer.parseInt(st.nextToken());
	}

	private void retrieveNodeLayout(String line) {
		try {
		StringTokenizer st = new StringTokenizer(line);
		Map<String,String> attributes;
		//st.nextToken("\""); // throw away leading " signs
		String nodeString = st.nextToken("[\t").trim(); 
		KLayoutNode node = (KLayoutNode) idToObject.get(nodeString);
		//st.nextToken("\"["); // " [
		String attributeString = st.nextToken("[]");
		attributes = readAttributes(attributeString);
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
			// if there are no valid layout informations, use default values
			size.setHeight(graphVizInches2Pixels("10"));
			size.setWidth(graphVizInches2Pixels("10"));
			location.setX(0);
			location.setY(0);
		}
		node.getLayout().setLocation(location);
		node.getLayout().setSize(size);
		} catch (Exception e) {
			Status status = new Status(IStatus.ERROR, Activator.PLUGIN_ID,
					"Error while reading node attributes from graphviz:" , e);
			StatusManager.getManager().handle(status, StatusManager.SHOW);
		}
	}

	private void retrieveEdgeLayout(String line) {
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
				 * ars, 2008-11-15: when setting arrowhead to 'none' then there
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
				edge.getLayout().getBendPoints().remove(
						edge.getLayout().getBendPoints().size() - 1);

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
	}
	
	/**
	   * Starts the dot process. 
	   * Sets an input and output and error stream to and from the dot
	   * process. The process itself will only terminate if it gets killed
	   * or the input stream gets closed. While it is active it will respond
	   * to new graph definitions in its input stream in the dot language
	   * and answer with the layouted graph definition in the output stream.
	   * Hence the same process could be used multiple times for multiple input
	   * graphs. So far this is not done. 
	   *  
	   * @author taken from KIEL classic
	   * @return returns true, if the dot process could be started
	   */
	  private void startProcess() throws GraphvizException{
	    
	    isGraphvizExecutableValid(); // might also throw GraphvizException
	    
	    String[] exp = {dotExecutable, dotArgument};
	    try {
	      graphvizProcess = Runtime.getRuntime().exec(exp);
	      dotOutput = new BufferedReader(new InputStreamReader(
	        graphvizProcess.getInputStream()));
	      errorStream = new BufferedReader(new InputStreamReader(
	        graphvizProcess.getErrorStream()));
	      dotInput = new PrintWriter(graphvizProcess.getOutputStream());
	    } catch (IOException e) {
	    	throw new GraphvizException(e,"Unable to start Graphviz process.");
	    }
	  }
	  
	  /**
	   * Closes the dot process. I.e. it should wait for it to terminate
	   * or kill it if it does not terminate.
	   * @return true iff process has ended
	   */
	  private boolean killProcess(){
		  // FIXME: should wait a timeout and then destroy the process
		  try {
			graphvizProcess.destroy();
			//graphvizProcess.waitFor();
		} catch (Exception e) {
		}
		  return true;
	  }
	  
	  /**
	   * Checks whether the GraphvizBinary path is valid or not. Will
	   * try to access the file and if it fails will show an error message.
	   * @return true iff dot executable can be read and executed
	   * @throws GraphvizException iff dot can not be executed
	   * @author haf
	   */
	  private boolean isGraphvizExecutableValid() throws GraphvizException{
		  try{
			  if (dotExecutable == null || dotExecutable.equals(""))
				  throw new GraphvizException("Path not set, path empty.");
			  File exec = new File(dotExecutable);
			  if(exec.exists())
				     return true;
			  else
				  throw new GraphvizException("File not found.");
		  }catch(IOException e){
			  // FIXME: put UI stuff in external package such that we can use the algorithm also standalone in headless environment
			  String message = "Error executing Graphviz dot binary: "+dotExecutable+" Please set the right path in the preferences!";
			  //Status myStatus = new Status(IStatus.ERROR, Activator.PLUGIN_ID, message, e);
			  //StatusManager.getManager().handle(myStatus, StatusManager.BLOCK);
			  //PreferenceDialog dialog = PreferencesUtil.createPreferenceDialogOn(null, GraphvizPreferencePage.ID, null, null);
			  //dialog.open();
			  throw new GraphvizException(e,message);
		  }
	  }
}

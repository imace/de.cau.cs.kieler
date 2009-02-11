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

/**
 * Class to provide the names of the several GraphViz layouters and the ID for
 * the GraphViz collection. Should be used by other classes of the plug-in to
 * remain consistent in naming. Available layouters are at the moment:
 * <ul>
 * <li>GRAPHVIZ_CIRCO = "GraphViz Circo"
 * </li>
 * <li>GRAPHVIZ_DOT = "GraphViz Dot"
 * </li>
 * <li>GRAPHVIZ_NEATO = "GraphViz Neato"
 * </li>
 * <li>GRAPHVIZ_TWOPI = "GraphViz Twopi"
 * </li>
 * </ul>
 * 
 * @author <a href="mailto:ars@informatik.uni-kiel.de">Arne Schipper</a>
 * 
 */
public class GraphvizLayoutProviderNames {

	public final static String LAYOUT_PROVIDER_COLLECTION_ID = "GraphViz Collection";
	public final static String GRAPHVIZ_CIRCO = "GraphViz Circo";
	public final static String GRAPHVIZ_DOT = "GraphViz Dot";
	public final static String GRAPHVIZ_NEATO = "GraphViz Neato";
	public final static String GRAPHVIZ_TWOPI = "GraphViz Twopi";
	public final static String GRAPHVIZ_FDP = "GraphViz FDP";

	/**
	 * Actual commands for the dot executable to call the different engines.
	 */
	public final static String DOT_COMMAND = "dot";
	public final static String NEATO_COMMAND = "neato";
	public final static String TWOPI_COMMAND = "twopi";
	public final static String FDP_COMMAND = "fdp";
	public final static String CIRCO_COMMAND = "circo";
	public final static String COMMAND_PARAMETER = "-K";



}

package edu.unikiel.rtsys.kieler.kiml.layout.services;

import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KLayoutGraph;

/**
 * Interface for listeners to the KIML layout.
 * 
 * @author msp
 */
public interface IKimlLayoutListener {

	/** the extension point identifier */
	public static final String EXTENSION_POINT_ID = "edu.unikiel.rtsys.kieler.kiml.layout.kimlLayoutListener";
	
	/**
	 * Called when layout is requested for the given layout graph.
	 * 
	 * @param layoutGraph layout graph that will be processed after
	 *     this method returns
	 */
	public void layoutRequested(KLayoutGraph layoutGraph);
	
	/**
	 * Called after layout was performed for the given layout graph.
	 * 
	 * @param layoutGraph layout graph that was layouted
	 */
	public void layoutPerformed(KLayoutGraph layoutGraph);
	
}

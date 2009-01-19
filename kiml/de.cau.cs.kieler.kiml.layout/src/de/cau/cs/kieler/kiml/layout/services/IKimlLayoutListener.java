package de.cau.cs.kieler.kiml.layout.services;

import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutGraph;

/**
 * Interface for listeners to the KIML layout.
 * 
 * @author msp
 */
public interface IKimlLayoutListener {

	/** the extension point identifier */
	public static final String EXTENSION_POINT_ID = "de.cau.cs.kieler.kiml.layout.kimlLayoutListener";
	/** the class attribute of the extension point */
	public static final String ATTRIBUTE_CLASS = "class";
	
	/**
	 * Called when layout is requested for the given layout graph.
	 * The given layout graph must not be modified by this method.
	 * 
	 * @param layoutGraph layout graph that will be processed after
	 *     this method returns
	 */
	public void layoutRequested(KLayoutGraph layoutGraph);
	
	/**
	 * Called after layout was performed for the given layout graph.
	 * The given layout graph must not be modified by this method.
	 * 
	 * @param layoutGraph layout graph that was layouted
	 */
	public void layoutPerformed(KLayoutGraph layoutGraph);
	
}

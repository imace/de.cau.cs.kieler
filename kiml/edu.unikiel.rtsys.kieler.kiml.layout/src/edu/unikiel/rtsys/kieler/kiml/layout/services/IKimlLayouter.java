package edu.unikiel.rtsys.kieler.kiml.layout.services;

import org.eclipse.core.runtime.IAdaptable;

import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kLayoutGraph;

public interface IKimlLayouter {

	public static final String EXTENSION_POINT_ID = "edu.unikiel.rtsys.kieler.kiml.layout.kimlLayoutProvider";
	public static final String ATTRIBUTE_ID = "id";
	public static final String ATTRIBUTE_CLASS = "class";
	public static final String ATTRIBUTE_NAME = "name";
	public static final String ATTRIBUTE_ICON = "icon";

	/**
	 * Layout providers must implement this method to perform the actual layout process.
	 * 
	 * @param layoutGraph
	 */
	public void doLayout(kLayoutGraph layoutGraph);
	
	public boolean canLayout(kLayoutGraph layoutGraph);
	
	public boolean providesLayout(IAdaptable layoutType);
	
}

package edu.unikiel.rtsys.kieler.kiml.layout.services;

import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KNodeGroup;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.LAYOUT_OPTION;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.LAYOUT_TYPE;

public interface IKimlLayoutProvider {

	public static final String EXTENSION_POINT_ID = "edu.unikiel.rtsys.kieler.kiml.layout.kimlLayoutProvider";
	public static final String ATTRIBUTE_ID = "id";
	public static final String ATTRIBUTE_CLASS = "class";
	public static final String ATTRIBUTE_NAME = "name";
	public static final String ATTRIBUTE_ICON = "icon";

	/**
	 * Layout providers must implement this methods to perform the actual layout process.
	 * 
	 * @param layoutGraph
	 */
	public void doLayout(KNodeGroup nodeGroup);
	
	public void doLayout(KNodeGroup nodeGroup, LAYOUT_TYPE layoutType, String layouterName);
	
	public boolean canLayout(KNodeGroup nodeGroup);
	
	public LAYOUT_TYPE[] providesLayoutTypes();
	
	public LAYOUT_OPTION[] providesLayoutOptions();
	
	public String[] providesLayouters();
	
	
}

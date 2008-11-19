/*******************************************************************************
 * Copyright (c) 2008 Real-Time and Embedded Systems group
 *
 * INSERT LICENCE HERE
 *
 *
 * Author: Arne Schipper, ars@informatik.uni-kiel.de 
 *
 *******************************************************************************/
package edu.unikiel.rtsys.kieler.kiml.layout.services;

import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KNodeGroup;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.LAYOUTER_INFO;

public abstract class KimlAbstractLayoutProvider {

	public static final String EXTENSION_POINT_ID = "edu.unikiel.rtsys.kieler.kiml.layout.kimlLayoutProvider";
	public static final String ATTRIBUTE_ID = "id";
	public static final String ATTRIBUTE_CLASS = "class";
	public static final String ATTRIBUTE_NAME = "name";
	public static final String ATTRIBUTE_ICON = "icon";
	private boolean enabled = true;	
	
	/**
	 * Layout providers must implement this methods to perform the actual layout
	 * process.
	 * 
	 * @param nodeGroup
	 *            The KNodeGroup which should be laid out
	 */
	public abstract void doLayout(KNodeGroup nodeGroup);


	/**
	 * This methods returns a LAYOUT_INFO, enriched
	 * with information of the types of layout the layout provider can handle
	 * options (can be more than one, combined by | ).
	 * 
	 * @return An ArrayList with information about the available layouters
	 */
	public abstract LAYOUTER_INFO getLayouterInfo();

	public void setEnabled(boolean state){
		enabled = state;
	}
	
	
	public boolean isEnabled(){
		return enabled;
	}
}

/******************************************************************************
 * KIELER - Kiel Integrated Environment for Layout for the Eclipse RCP
 *
 * http://www.informatik.uni-kiel.de/rtsys/kieler/
 * 
 * Copyright 2009 by
 * + Christian-Albrechts-University of Kiel
 *   + Department of Computer Science
 *     + Real-Time and Embedded Systems Group
 * 
 * This code is provided under the terms of the Eclipse Public License (EPL).
 * See the file epl-v10.html for the license text.
 */
package de.cau.cs.kieler.kiml.layout.options;

/**
 * Definition of keys used for layout options
 * 
 * @author msp
 */
public class LayoutOptions {

    /** type of layout method */
    public final static String LAYOUT_TYPE = "layoutType";
    /** direction of layout */
    public final static String LAYOUT_DIRECTION = "layoutDirection";
    /** name of selected layouter */
    public final static String LAYOUTER_NAME = "layouterName";
    /** distance of node contents to the top side */
    public final static String INSET_NORTH = "insetNorth";
    /** distance of node contents to the right side */
    public final static String INSET_EAST = "insetEast";
    /** distance of node contents to the bottom side */
    public final static String INSET_SOUTH = "insetSouth";
    /** distance of node contents to the left side */
    public final static String INSET_WEST = "insetWest";
    /** side of a port on its node's boundary */
    public final static String PORT_SIDE = "portSide";
    /** constraints for port positions */
    public final static String PORT_CONSTRAINTS = "portConstraints";
    
}

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

import de.cau.cs.kieler.core.kgraph.KGraphFactory;
import de.cau.cs.kieler.core.kgraph.KIntOption;
import de.cau.cs.kieler.core.kgraph.KObjectOption;
import de.cau.cs.kieler.core.kgraph.KOption;
import de.cau.cs.kieler.core.kgraph.KStringOption;
import de.cau.cs.kieler.kiml.layout.klayoutdata.KInsets;
import de.cau.cs.kieler.kiml.layout.klayoutdata.KLayoutData;
import de.cau.cs.kieler.kiml.layout.klayoutdata.KLayoutDataFactory;

/**
 * Definition of keys used for layout options
 * 
 * @author msp
 */
public class LayoutOptions {

    /** type of layout method */
    public final static String LAYOUT_TYPE = "layoutType";
    
    /**
     * Returns the layout type for a given layout data instance.
     * 
     * @param layoutData layout data for a parent node
     * @return the layout type for the given layout data
     */
    public static LayoutType getLayoutType(KLayoutData layoutData) {
        KIntOption typeOption = (KIntOption)layoutData.getOption(
                LAYOUT_TYPE);
        if (typeOption == null)
            return LayoutType.OTHER;
        else
            return LayoutType.valueOf(typeOption.getValue());
    }
    
    /**
     * Sets the layout type for the given layout data instance.
     * 
     * @param layoutData layout data for a parent node
     * @param layoutType layout type to set
     */
    public static void setLayoutType(KLayoutData layoutData,
            LayoutType layoutType) {
        KIntOption layoutTypeOption = KGraphFactory.eINSTANCE.createKIntOption();
        layoutTypeOption.setKey(LAYOUT_TYPE);
        layoutTypeOption.setValue(layoutType.ordinal());
        layoutData.getOptions().add(layoutTypeOption);
    }
    
    /** direction of layout */
    public final static String LAYOUT_DIRECTION = "layoutDirection";
    
    /**
     * Returns the layout direction for a given layout data instance.
     * 
     * @param layoutData layout data for a parent node
     * @return the layout direction for the given layout data
     */
    public static LayoutDirection getLayoutDirection(KLayoutData layoutData) {
        KIntOption directionOption = (KIntOption)layoutData.getOption(
                LAYOUT_DIRECTION);
        if (directionOption == null)
            return LayoutDirection.UNDEFINED;
        else
            return LayoutDirection.valueOf(directionOption.getValue());
    }
    
    /**
     * Sets the layout direction for the given layout data instance.
     * 
     * @param layoutData layout data for a parent node
     * @param layoutDirection layout direction to set
     */
    public static void setLayoutDirection(KLayoutData layoutData,
            LayoutDirection layoutDirection) {
        KIntOption directionOption = KGraphFactory.eINSTANCE.createKIntOption();
        directionOption.setKey(LAYOUT_DIRECTION);
        directionOption.setValue(layoutDirection.ordinal());
        layoutData.getOptions().add(directionOption);
    }
    
    /** name of selected layouter */
    public final static String LAYOUTER_NAME = "layouterName";
    
    /**
     * Sets the layouter name for the given layout data instance.
     * 
     * @param layoutData layout data for a parent node
     * @param layouterName layouter name to set
     */
    public static void setLayouterName(KLayoutData layoutData,
            String layouterName) {
        KStringOption layouterNameOption = KGraphFactory.eINSTANCE.createKStringOption();
        layouterNameOption.setKey(LAYOUTER_NAME);
        layouterNameOption.setValue(layouterName);
        layoutData.getOptions().add(layouterNameOption);
    }
    
    /** distance of node contents to the boundary */
    public final static String INSETS = "insets";
    
    /**
     * Returns the insets for a given layout data instance. If no
     * insets option is set, default values are created.
     * 
     * @param layoutData layout data for a parent node
     * @return the insets for the given layout data
     */
    public static KInsets getInsets(KLayoutData layoutData) {
        KObjectOption insetsOption = (KObjectOption)layoutData
                .getOption(INSETS);
        if (insetsOption == null || insetsOption.getValue() == null)
            return KLayoutDataFactory.eINSTANCE.createKInsets();
        else
            return (KInsets)insetsOption.getValue();
    }
    
    /** side of a port on its node's boundary */
    public final static String PORT_SIDE = "portSide";
    
    /**
     * Returns the port side for a given layout data instance.
     * 
     * @param layoutData layout data for a port
     * @return the port side for the given layout data
     */
    public static PortSide getPortSide(KLayoutData layoutData) {
        KIntOption sideOption = (KIntOption)layoutData.getOption(
                PORT_SIDE);
        if (sideOption == null)
            return PortSide.UNDEFINED;
        else
            return PortSide.valueOf(sideOption.getValue());
    }
    
    /**
     * Sets the port side for the given layout data instance.
     * 
     * @param layoutData layout data for a port
     * @param portSide port side to set
     */
    public static void setPortSide(KLayoutData layoutData,
            PortSide portSide) {
        KIntOption sideOption = KGraphFactory.eINSTANCE.createKIntOption();
        sideOption.setKey(PORT_SIDE);
        sideOption.setValue(portSide.ordinal());
        layoutData.getOptions().add(sideOption);
    }
    
    /** constraints for port positions */
    public final static String PORT_CONSTRAINTS = "portConstraints";

    /**
     * Returns the port constraints for a given layout data instance.
     * 
     * @param layoutData layout data for a node
     * @return the port constraints for the given layout data
     */
    public static PortConstraints getPortConstraints(KLayoutData layoutData) {
        KIntOption constraintsOption = (KIntOption)layoutData.getOption(
                PORT_CONSTRAINTS);
        if (constraintsOption == null)
            return PortConstraints.UNDEFINED;
        else
            return PortConstraints.valueOf(constraintsOption.getValue());
    }
    
    /**
     * Sets the port constraints for the given layout data instance.
     * 
     * @param layoutData layout data for a node
     * @param portConstraints port constraints to set
     */
    public static void setPortConstraints(KLayoutData layoutData,
            PortConstraints portConstraints) {
        KIntOption constraintsOption = KGraphFactory.eINSTANCE.createKIntOption();
        constraintsOption.setKey(PORT_CONSTRAINTS);
        constraintsOption.setValue(portConstraints.ordinal());
        layoutData.getOptions().add(constraintsOption);
    }
    
    /** placement positions for edge labels */
    public final static String EDGE_LABEL_PLACEMENT = "edgeLabelPlacement";
    
    /**
     * Returns the edge label placement for a given layout data instance.
     * 
     * @param layoutData layout data for an edge label
     * @return the edge label placement for the given layout data
     */
    public static EdgeLabelPlacement getEdgeLabelPlacement(KLayoutData layoutData) {
        KIntOption placementOption = (KIntOption)layoutData.getOption(
                EDGE_LABEL_PLACEMENT);
        if (placementOption == null)
            return EdgeLabelPlacement.UNDEFINED;
        else
            return EdgeLabelPlacement.valueOf(placementOption.getValue());
    }
    
    /**
     * Sets the edge label placement for the given layout data instance.
     * 
     * @param layoutData layout data for an edge label
     * @param placement edge label placement to set
     */
    public static void setEdgeLabelPlacement(KLayoutData layoutData,
            EdgeLabelPlacement placement) {
        KIntOption placementOption = KGraphFactory.eINSTANCE.createKIntOption();
        placementOption.setKey(EDGE_LABEL_PLACEMENT);
        placementOption.setValue(placement.ordinal());
        layoutData.getOptions().add(placementOption);
    }
    
    /** size constraint for nodes */
    public final static String FIXED_SIZE = "fixedSize";
    
    /**
     * Returns whether the fixed size option is active for the
     * given layout data instance.
     * 
     * @param layoutData layout data for a node
     * @return true if the fixed size option is active
     */
    public static boolean isFixedSize(KLayoutData layoutData) {
        KOption sizeOption = layoutData.getOption(FIXED_SIZE);
        return sizeOption != null;
    }

    /**
     * Activates the fixed size option for the given layout data
     * instance.
     * 
     * @param layoutData layout data for a node
     */
    public static void setFixedSize(KLayoutData layoutData) {
        KOption sizeOption = KGraphFactory.eINSTANCE.createKOption();
        sizeOption.setKey(FIXED_SIZE);
        layoutData.getOptions().add(sizeOption);
    }
    
}

/******************************************************************************
 * KIELER - Kiel Integrated Environment for Layout for the Eclipse RCP
 *
 * http://www.informatik.uni-kiel.de/rtsys/kieler/
 * 
 * Copyright 2008 by
 * + Christian-Albrechts-University of Kiel
 *   + Department of Computer Science
 *     + Real-Time and Embedded Systems Group
 * 
 * This code is provided under the terms of the Eclipse Public License (EPL).
 * See the file epl-v10.html for the license text.
 */
package de.cau.cs.kieler.kiml.layout.util;

import de.cau.cs.kieler.core.kgraph.KEdge;
import de.cau.cs.kieler.core.kgraph.KGraphElement;
import de.cau.cs.kieler.core.kgraph.KGraphFactory;
import de.cau.cs.kieler.core.kgraph.KLabel;
import de.cau.cs.kieler.core.kgraph.KNode;
import de.cau.cs.kieler.core.kgraph.KObjectOption;
import de.cau.cs.kieler.core.kgraph.KPort;
import de.cau.cs.kieler.kiml.layout.klayoutdata.KEdgeLayout;
import de.cau.cs.kieler.kiml.layout.klayoutdata.KInsets;
import de.cau.cs.kieler.kiml.layout.klayoutdata.KLayoutData;
import de.cau.cs.kieler.kiml.layout.klayoutdata.KLayoutDataFactory;
import de.cau.cs.kieler.kiml.layout.klayoutdata.KLayoutDataPackage;
import de.cau.cs.kieler.kiml.layout.klayoutdata.KShapeLayout;
import de.cau.cs.kieler.kiml.layout.options.LayoutOptions;

/**
 * Helper class with static convenience functions to create initialized
 * KLayoutGraph elements.
 * 
 * @author <a href="mailto:ars@informatik.uni-kiel.de">Arne Schipper</a>
 * @see KLayoutGraph
 * @see KLayoutNode
 * @see KLayoutEdge
 * @see KEdgeLabel
 */
public class KimlLayoutUtil {

    /**
     * Returns layout data for a given graph element.
     * 
     * @param graphElement the graph element
     * @return related layout data
     */
    public static KLayoutData getLayoutData(KGraphElement graphElement) {
        return (KLayoutData)graphElement.getData(KLayoutDataPackage
                .eINSTANCE.getKLayoutData());
    }
    
    /**
     * Returns shape layout data for a given graph element.
     * 
     * @param graphElement the graph element
     * @return related shape layout data
     */
    public static KShapeLayout getShapeLayout(KGraphElement graphElement) {
        return (KShapeLayout)graphElement.getData(KLayoutDataPackage
                .eINSTANCE.getKShapeLayout());
    }
    
    /**
     * Returns edge layout data for a given graph element.
     * 
     * @param graphElement the graph element
     * @return related edge layout data
     */
    public static KEdgeLayout getEdgeLayout(KGraphElement graphElement) {
        return (KEdgeLayout)graphElement.getData(KLayoutDataPackage
                .eINSTANCE.getKEdgeLayout());
    }
    
	/**
	 * Creates a KNode, initializes some defaults and returns it.
	 * 
	 * @return an initialized KLayoutNode
	 */
	public static KNode createInitializedNode() {
		KNode layoutNode = KGraphFactory.eINSTANCE.createKNode();
		KLabel nodeLabel = createInitializedLabel(layoutNode);
		layoutNode.setLabel(nodeLabel);
        KShapeLayout layout = KLayoutDataFactory.eINSTANCE.createKShapeLayout();
        KInsets insets = KLayoutDataFactory.eINSTANCE.createKInsets();
		KObjectOption insetsOption = KGraphFactory.eINSTANCE.createKObjectOption();
		insetsOption.setKey(LayoutOptions.INSETS);
		insetsOption.setValue(insets);
		layout.getOptions().add(insetsOption);
		layoutNode.getData().add(layout);
        return layoutNode;
	}

	/**
	 * Creates a KEdge, initializes some defaults and returns it.
	 * 
	 * @return an initialized KEdge
	 */
	public static KEdge createInitializedEdge() {
		KEdge edge = KGraphFactory.eINSTANCE.createKEdge();
		KEdgeLayout edgeLayout = KLayoutDataFactory.eINSTANCE.createKEdgeLayout();
		edgeLayout.setSourcePoint(KLayoutDataFactory.eINSTANCE.createKPoint());
		edgeLayout.setTargetPoint(KLayoutDataFactory.eINSTANCE.createKPoint());
		edge.getData().add(edgeLayout);
		return edge;
	}
	
	/**
     * Creates a KPort, initializes some defaults and returns it.
     * 
     * @return an initialized KPort
     */
    public static KPort createInitializedPort() {
        KPort port = KGraphFactory.eINSTANCE.createKPort();
        KLabel portLabel = createInitializedLabel(port);
        port.setLabel(portLabel);
        KShapeLayout labelLayout = KLayoutDataFactory.eINSTANCE.createKShapeLayout();
        port.getData().add(labelLayout);
        return port;
    }

	/**
	 * Creates a KLabel, initializes some defaults and returns it.
	 * 
	 * @param parent the parent graph element
	 * @return an initialized KLabel
	 */
	public static KLabel createInitializedLabel(KGraphElement parent) {
	    KLabel label = KGraphFactory.eINSTANCE.createKLabel();
	    KShapeLayout labelLayout = KLayoutDataFactory.eINSTANCE.createKShapeLayout();
	    label.getData().add(labelLayout);
	    label.setText("");
	    label.setParent(parent);
	    return label;
	}

}

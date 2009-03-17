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

import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KDimension;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutEdge;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KEdgeLabel;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KEdgeLabelLayout;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KEdgeLayout;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KInsets;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutGraph;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutNode;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KNodeLabel;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KNodeLayout;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KPoint;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphFactory;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutType;

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
	 * Creates a KLayoutGraph, initializes some defaults and returns it.
	 * Initialized values are:
	 * <ul>
	 * <li>IdString: ""</li>
	 * <li>Layout:
	 * <ul>
	 * <li>Location: Default KPoint object (0,0)</li>
	 * <li>Size: Default KDimension object (0,0)</li>
	 * <li>Insets: Default KInsets object (0,0,0,0)</li>
	 * <li>LayouterName: ""</li>
	 * <li>LayoutType: KLayoutType.DEFAULT</li>
	 * </ul>
	 * </li>
	 * <li>Label: Default KNodeLabel object</li>
	 * </ul>
	 * 
	 * @return An initialized KLayoutGraph
	 * @author <a href="mailto:msp@informatik.uni-kiel.de">Miro Sp&ouml;nemann</a>
	 */
	public static KLayoutGraph createInitializedLayoutGraph() {
		KLayoutGraph layoutGraph = KimlLayoutGraphFactory.eINSTANCE
				.createKLayoutGraph();
		KNodeLayout layout = KimlLayoutGraphFactory.eINSTANCE
				.createKNodeLayout();
		KPoint location = KimlLayoutGraphFactory.eINSTANCE.createKPoint();
		KDimension size = KimlLayoutGraphFactory.eINSTANCE.createKDimension();
		KInsets insets = KimlLayoutGraphFactory.eINSTANCE.createKInsets();
		KNodeLabel nodeLabel = KimlLayoutGraphFactory.eINSTANCE
				.createKNodeLabel();
		layout.setLocation(location);
		layout.setSize(size);
		layout.setInsets(insets);
		layout.setLayouterName("");
		layout.setLayoutType(KLayoutType.DEFAULT);
		layoutGraph.setLayout(layout);
		layoutGraph.setLabel(nodeLabel);
		layoutGraph.setIdString("");
		return layoutGraph;
	}
	
	/**
	 * Creates a KLayoutNode, initializes some defaults and returns it.
	 * Initialized values are:
	 * <ul>
	 * <li>IdString: ""</li>
	 * <li>Layout:
	 * <ul>
	 * <li>Location: Default KPoint object (0,0)</li>
	 * <li>Size: Default KDimension object (0,0)</li>
	 * <li>Insets: Default KInsets object (0,0,0,0)</li>
	 * <li>LayouterName: ""</li>
	 * <li>LayoutType: KLayoutType.DEFAULT</li>
	 * </ul>
	 * </li>
	 * <li>Label: Default KNodeLabel object</li>
	 * </ul>
	 * 
	 * @return An initialized KLayoutNode
	 * @author <a href="mailto:ars@informatik.uni-kiel.de">Arne Schipper</a>
	 */
	public static KLayoutNode createInitializedLayoutNode() {
		KLayoutNode layoutNode = KimlLayoutGraphFactory.eINSTANCE
				.createKLayoutNode();
		KNodeLayout layout = KimlLayoutGraphFactory.eINSTANCE
				.createKNodeLayout();
		KPoint location = KimlLayoutGraphFactory.eINSTANCE.createKPoint();
		KDimension size = KimlLayoutGraphFactory.eINSTANCE.createKDimension();
		KInsets insets = KimlLayoutGraphFactory.eINSTANCE.createKInsets();
		KNodeLabel nodeLabel = KimlLayoutGraphFactory.eINSTANCE
				.createKNodeLabel();
		layout.setLocation(location);
		layout.setSize(size);
		layout.setInsets(insets);
		layout.setLayouterName("");
		layout.setLayoutType(KLayoutType.DEFAULT);
		layoutNode.setLayout(layout);
		layoutNode.setLabel(nodeLabel);
		layoutNode.setIdString("");
		return layoutNode;
	}

	/**
	 * Creates a KLayoutEdge, initializes some defaults and returns it. Initialized
	 * values are:
	 * <ul>
	 * <li>Layout:
	 * <ul>
	 * <li>SourcePoint: Default KPoint object (0,0)</li>
	 * <li>TargetPoint: Default KPoint object (0,0)</li>
	 * </ul>
	 * </li>
	 * </ul>
	 * 
	 * @return An initialized KLayoutEdge
	 * @author <a href="mailto:ars@informatik.uni-kiel.de">Arne Schipper</a>
	 */
	public static KLayoutEdge createInitializedEdge() {
		KLayoutEdge edge = KimlLayoutGraphFactory.eINSTANCE.createKLayoutEdge();
		KEdgeLayout edgeLayout = KimlLayoutGraphFactory.eINSTANCE
				.createKEdgeLayout();

		edgeLayout.setSourcePoint(KimlLayoutGraphFactory.eINSTANCE
				.createKPoint());
		edgeLayout.setTargetPoint(KimlLayoutGraphFactory.eINSTANCE
				.createKPoint());

		edge.setLayout(edgeLayout);

		return edge;
	}

	/**
	 * Creates a KEdgeLabel, initializes some defaults and returns it.
	 * Initialized values are:
	 * <ul>
	 * <li>Text: ""</li>
	 * <li>LabelLayout:
	 * <ul>
	 * <li>SourcePoint: Default KPoint object (0,0)</li>
	 * <li>TargetPoint: Default KPoint object (0,0)</li>
	 * </ul>
	 * </li>
	 * </ul>
	 * 
	 * @return An initialized KEdgeLabel
	 * @author <a href="mailto:ars@informatik.uni-kiel.de">Arne Schipper</a>
	 */
	public static KEdgeLabel createInitializedEdgeLabel() {
		KEdgeLabel edgeLabel = KimlLayoutGraphFactory.eINSTANCE
				.createKEdgeLabel();
		KEdgeLabelLayout edgeLabelLayout = KimlLayoutGraphFactory.eINSTANCE
				.createKEdgeLabelLayout();

		edgeLabelLayout.setLocation(KimlLayoutGraphFactory.eINSTANCE
				.createKPoint());
		edgeLabelLayout.setSize(KimlLayoutGraphFactory.eINSTANCE
				.createKDimension());

		edgeLabel.setText("");
		edgeLabel.setLabelLayout(edgeLabelLayout);

		return edgeLabel;
	}

}

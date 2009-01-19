/*******************************************************************************
 * Copyright (c) 2008 Real-Time and Embedded Systems group
 *
 * INSERT LICENCE HERE
 *
 *
 * Author: Arne Schipper, ars@informatik.uni-kiel.de 
 *
 *******************************************************************************/
package edu.unikiel.rtsys.kieler.kiml.layout.util;

import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KDimension;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KEdge;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KEdgeLabel;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KEdgeLabelLayout;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KEdgeLayout;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KInsets;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KLayoutGraph;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KNodeGroup;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KNodeGroupLabel;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KNodeGroupLayout;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KPoint;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphFactory;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.LAYOUT_TYPE;

/**
 * Helper class with static convenience functions to create initialized
 * KLayoutGraph elements.
 * 
 * @author <a href="mailto:ars@informatik.uni-kiel.de">Arne Schipper</a>
 * @see KLayoutGraph
 * @see KNodeGroup
 * @see KEdge
 * @see KEdgeLabel
 */
public class KimlLayoutUtil {

	/**
	 * Creates a KNodeGroup, initializes some defaults and returns it.
	 * Initialized values are:
	 * <ul>
	 * <li>IdString: ""</li>
	 * <li>Layout:
	 * <ul>
	 * <li>Location: Default KPoint object (0,0)</li>
	 * <li>Size: Default KDimension object (0,0)</li>
	 * <li>Insets: Default KInsets object (0,0,0,0)</li>
	 * <li>LayouterName: ""</li>
	 * <li>LayoutType: LAYOUT_TYPE.DEFAULT</li>
	 * </ul>
	 * </li>
	 * <li>Label: Default KNodeGroupLabel object</li>
	 * </ul>
	 * 
	 * @return An initialized KNodeGroup
	 * @author <a href="mailto:ars@informatik.uni-kiel.de">Arne Schipper</a>
	 */
	public static KNodeGroup createInitializedNodeGroup() {
		KNodeGroup nodeGroup = KimlLayoutGraphFactory.eINSTANCE
				.createKNodeGroup();
		KNodeGroupLayout layout = KimlLayoutGraphFactory.eINSTANCE
				.createKNodeGroupLayout();
		KPoint location = KimlLayoutGraphFactory.eINSTANCE.createKPoint();
		KDimension size = KimlLayoutGraphFactory.eINSTANCE.createKDimension();
		KInsets insets = KimlLayoutGraphFactory.eINSTANCE.createKInsets();
		KNodeGroupLabel nodeGroupLabel = KimlLayoutGraphFactory.eINSTANCE
				.createKNodeGroupLabel();
		layout.setLocation(location);
		layout.setSize(size);
		layout.setInsets(insets);
		layout.setLayouterName("");
		layout.setLayoutType(LAYOUT_TYPE.DEFAULT);
		nodeGroup.setLayout(layout);
		nodeGroup.setLabel(nodeGroupLabel);
		nodeGroup.setIdString("");
		return nodeGroup;
	}

	/**
	 * Creates a KEdge, initializes some defaults and returns it. Initialized
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
	 * @return An initialized KEdge
	 * @author <a href="mailto:ars@informatik.uni-kiel.de">Arne Schipper</a>
	 */
	public static KEdge createInitializedEdge() {
		KEdge edge = KimlLayoutGraphFactory.eINSTANCE.createKEdge();
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

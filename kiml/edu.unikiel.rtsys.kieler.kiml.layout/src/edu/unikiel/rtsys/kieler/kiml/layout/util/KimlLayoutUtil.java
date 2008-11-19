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
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KNodeGroup;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KNodeGroupLabel;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KNodeGroupLayout;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KPoint;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphFactory;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.LAYOUT_TYPE;

public class KimlLayoutUtil {

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

	public static void printNodeGroupRecursively(KNodeGroup nodeGroup,
			String ident) {
		System.out.println(ident + "LType: "
				+ nodeGroup.getLayout().getLayoutType().getName() + ", "
				+ "LName: " + nodeGroup.getLayout().getLayouterName() + ", "
				+ "ID: " + nodeGroup.getIdString() + ", " + "Label:  "
				+ nodeGroup.getLabel().getText() + ", X: "
				+ nodeGroup.getLayout().getLocation().getX() + ", Y: "
				+ nodeGroup.getLayout().getLocation().getY() + ", W: "
				+ nodeGroup.getLayout().getSize().getWidth() + ", H: "
				+ nodeGroup.getLayout().getSize().getHeight());
		for (KNodeGroup subGroup : nodeGroup.getSubNodeGroups()) {
			printNodeGroupRecursively(subGroup, ident + "  ");
		}
	}

	
}

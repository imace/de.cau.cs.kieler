package edu.unikiel.rtsys.kieler.kiml.layout.util;

import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KDimension;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KInsets;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KNodeGroup;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KNodeGroupLabel;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KNodeGroupLayout;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KPoint;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphFactory;

public class KIMLLayoutUtil {

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
		nodeGroup.setLayout(layout);
		nodeGroup.setLabel(nodeGroupLabel);
		return nodeGroup;
	}
}

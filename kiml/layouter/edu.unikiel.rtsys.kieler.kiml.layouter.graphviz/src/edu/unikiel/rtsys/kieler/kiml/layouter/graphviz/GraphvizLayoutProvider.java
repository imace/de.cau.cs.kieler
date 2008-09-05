package edu.unikiel.rtsys.kieler.kiml.layouter.graphviz;

import org.eclipse.core.runtime.IAdaptable;

import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kLayoutGraph;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kNodeGroup;
import edu.unikiel.rtsys.kieler.kiml.layout.services.IKimlLayouter;

public class GraphvizLayoutProvider implements IKimlLayouter {

	public static final String GRAPHVIZ_DOT = "GRAPHVIZ_DOT";
	public static final String GRAPHVIZ_CIRCO = "GRAPHVIZ_CIRCO";
	public static final String GRAPHVIZ_NEATO = "GRAPHVIZ_NEATO";

	public void doLayout(kLayoutGraph layoutGraph) {
		// do something with the provided graph, i.e. layout it
		System.out.println("doLayout was called: " + layoutGraph);
		printLayoutGraph(layoutGraph);
	}

	private void printLayoutGraph(kLayoutGraph layoutGraph) {
		System.out.println(layoutGraph);
		recursivelyPrintLayoutGraph(layoutGraph.getTopGroup(), "");
	}

	private void recursivelyPrintLayoutGraph(kNodeGroup nodeGroup, String ident) {
		System.out.println(ident + nodeGroup.getNodeGroupLayout().getLocation());
		for (kNodeGroup subGroup : nodeGroup.getSubNodeGroups()) {
			recursivelyPrintLayoutGraph(subGroup, ident + "  ");
		}
	}

	@Override
	public boolean canLayout(kLayoutGraph layoutGraph) {
		return true;
	}

	@Override
	public boolean providesLayout(IAdaptable layoutType) {
		String layoutTypeString = (String) layoutType.getAdapter(String.class);
		if (layoutTypeString.equals(GRAPHVIZ_CIRCO)
				|| layoutTypeString.equals(GRAPHVIZ_DOT)
				|| layoutTypeString.equals(GRAPHVIZ_NEATO))
			return true;
		else
			return false;
	}
}

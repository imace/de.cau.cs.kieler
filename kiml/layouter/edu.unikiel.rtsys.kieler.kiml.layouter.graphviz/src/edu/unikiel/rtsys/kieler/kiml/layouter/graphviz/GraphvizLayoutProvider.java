package edu.unikiel.rtsys.kieler.kiml.layouter.graphviz;

import java.util.Arrays;

import kiel.layouter.graphviz.GraphvizLayouter;

import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KNodeGroup;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.LAYOUT_OPTION;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.LAYOUT_TYPE;
import edu.unikiel.rtsys.kieler.kiml.layout.services.IKimlLayoutProvider;

public class GraphvizLayoutProvider implements IKimlLayoutProvider {

	public static final String GRAPHVIZ_DOT = "GraphViz DOT";
	public static final String GRAPHVIZ_TWOPI = "GraphViz TWOPI";
	public static final String GRAPHVIZ_CIRCO = "GraphViz CIRCO";
	public static final String GRAPHVIZ_NEATO = "GraphViz NEATO";

	/*
	 * The default layout options if none are set
	 */
	public void doLayout(KNodeGroup nodeGroup) {
		doLayout(nodeGroup, LAYOUT_TYPE.HIERARCHICAL, GRAPHVIZ_DOT);
	}

	public void doLayout(KNodeGroup nodeGroup, LAYOUT_TYPE layoutType,
			String layouterName) {
		
		//recursivelyPrintNodeGroup(nodeGroup,"");
		GraphvizLayouter gl = new GraphvizLayouter();
		String correctLayouterName = getCorrectLayouterName(layoutType,
				layouterName);
		gl.setLayouterName(correctLayouterName);
		gl.visit(nodeGroup);
	}

	private String getCorrectLayouterName(LAYOUT_TYPE layoutType,
			String layouterName) {
		if (Arrays.asList(providesLayouters()).contains(layouterName))
			return layouterName;
		else if (layoutType.equals(LAYOUT_TYPE.CIRCLE))
			return GRAPHVIZ_CIRCO;
		else if (layoutType.equals(LAYOUT_TYPE.RADIAL))
			return GRAPHVIZ_TWOPI;
		else if (layoutType.equals(LAYOUT_TYPE.SPRING_MODEL))
			return GRAPHVIZ_NEATO;
		else // if default or nothing use dot
			return GRAPHVIZ_DOT;
	}

	private void recursivelyPrintNodeGroup(KNodeGroup nodeGroup, String ident) {
		System.out.println(ident
				+ "LType: " + nodeGroup.getLayout().getLayoutType().getName() + ", "
				+ "LName: " + nodeGroup.getLayout().getLayouterName() + ", "
				+ "Name:  " + nodeGroup.getLabel().getText());
		for (KNodeGroup subGroup : nodeGroup.getSubNodeGroups()) {
			recursivelyPrintNodeGroup(subGroup, ident + "  ");
		}
	}

	@Override
	public boolean canLayout(KNodeGroup nodeGroup) {
		return true;
	}

	@Override
	public String[] providesLayouters() {
		return new String[] { GRAPHVIZ_CIRCO, GRAPHVIZ_DOT, GRAPHVIZ_TWOPI,
				GRAPHVIZ_NEATO };
	}

	@Override
	public LAYOUT_OPTION[] providesLayoutOptions() {
		return new LAYOUT_OPTION[] { LAYOUT_OPTION.DEFAULT };
	}

	@Override
	public LAYOUT_TYPE[] providesLayoutTypes() {
		return new LAYOUT_TYPE[] { LAYOUT_TYPE.HIERARCHICAL,
				LAYOUT_TYPE.CIRCLE, LAYOUT_TYPE.RADIAL };
	}

}

package kiel.layouter.graphviz;

import java.util.ArrayList;

import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KNodeGroup;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphFactory;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.LAYOUTER_INFO;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.LAYOUT_OPTION;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.LAYOUT_TYPE;
import edu.unikiel.rtsys.kieler.kiml.layout.services.KimlAbstractLayoutProvider;

public class GraphvizLayoutProvider extends KimlAbstractLayoutProvider {

	static String LAYOUT_PROVIDER_ID = "GraphViz Layout Provider";
	static String GRAPHVIZ_DOT = "GraphViz Dot";
	static String GRAPHVIZ_CIRCO = "GraphViz Circo";
	static String GRAPHVIZ_TWOPI = "GraphViz Twopi";
	static String GRAPHVIZ_NEATO = "GraphViz Neato";

	public void doLayout(KNodeGroup nodeGroup) {
		GraphvizLayouter gl = new GraphvizLayouter();
		String correctLayouterName = getCorrectLayouterName(nodeGroup
				.getLayout().getLayoutType(), nodeGroup.getLayout()
				.getLayouterName());
		gl.setGraphvizLayouterName(correctLayouterName);
		gl.visit(nodeGroup);
	}

	private String getCorrectLayouterName(LAYOUT_TYPE layoutType,
			String layouterName) {

		if (providesLayouterName(layouterName))
			return layouterName;
		else if (getLayouterNamesForLayoutType(layoutType).size() != 0)
			return getLayouterNamesForLayoutType(layoutType).get(0);
		else
			// if default or nothing use dot
			return GRAPHVIZ_DOT;
	}

	public final ArrayList<LAYOUTER_INFO> getLayouterInfos() {
		ArrayList<LAYOUTER_INFO> layouterInfos = new ArrayList<LAYOUTER_INFO>();

		LAYOUTER_INFO dot = KimlLayoutGraphFactory.eINSTANCE
				.createLAYOUTER_INFO();
		dot.setLayouterName(GRAPHVIZ_DOT);
		dot.setLayoutType(LAYOUT_TYPE.HIERARCHICAL);
		dot.setLayoutOption(LAYOUT_OPTION.DEFAULT);
		layouterInfos.add(dot);

		LAYOUTER_INFO circo = KimlLayoutGraphFactory.eINSTANCE
				.createLAYOUTER_INFO();
		circo.setLayouterName(GRAPHVIZ_CIRCO);
		circo.setLayoutType(LAYOUT_TYPE.CIRCLE);
		circo.setLayoutOption(LAYOUT_OPTION.DEFAULT);
		layouterInfos.add(circo);

		LAYOUTER_INFO neato = KimlLayoutGraphFactory.eINSTANCE
				.createLAYOUTER_INFO();
		neato.setLayouterName(GRAPHVIZ_NEATO);
		neato.setLayoutType(LAYOUT_TYPE.RADIAL);
		neato.setLayoutOption(LAYOUT_OPTION.DEFAULT);
		layouterInfos.add(neato);

		LAYOUTER_INFO twopi = KimlLayoutGraphFactory.eINSTANCE
				.createLAYOUTER_INFO();
		twopi.setLayouterName(GRAPHVIZ_TWOPI);
		twopi.setLayoutType(LAYOUT_TYPE.SPRING_MODEL);
		twopi.setLayoutOption(LAYOUT_OPTION.DEFAULT);
		layouterInfos.add(twopi);

		return layouterInfos;
	}

	public String getLayoutProviderID() {
		return LAYOUT_PROVIDER_ID;
	}
}

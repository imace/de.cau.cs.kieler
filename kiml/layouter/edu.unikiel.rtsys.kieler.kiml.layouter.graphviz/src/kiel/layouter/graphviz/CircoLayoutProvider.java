package kiel.layouter.graphviz;

import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KNodeGroup;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphFactory;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.LAYOUTER_INFO;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.LAYOUT_OPTION;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.LAYOUT_TYPE;
import edu.unikiel.rtsys.kieler.kiml.layout.services.KimlAbstractLayoutProvider;

public class CircoLayoutProvider extends KimlAbstractLayoutProvider {

	public final static String LAYOUT_PROVIDER_NAME = GraphvizLayoutProviderNames.GRAPHVIZ_CIRCO;
	public final static LAYOUT_TYPE LAYOUT_PROVIDER_LAYOUT_TYPE = LAYOUT_TYPE.CIRCLE;
	public final static LAYOUT_OPTION LAYOUT_PROVIDER_LAYOUT_OPTION = LAYOUT_OPTION.DEFAULT;
	
	public void doLayout(KNodeGroup nodeGroup) {
		GraphvizLayouter gl = new GraphvizLayouter();
		gl.setGraphvizLayouterName(LAYOUT_PROVIDER_NAME);
		gl.visit(nodeGroup);
	}

	public final LAYOUTER_INFO getLayouterInfo() {
		
		LAYOUTER_INFO info = KimlLayoutGraphFactory.eINSTANCE
				.createLAYOUTER_INFO();
		info.setLayouterName(LAYOUT_PROVIDER_NAME);
		info.setLayoutType(LAYOUT_PROVIDER_LAYOUT_TYPE);
		info.setLayoutOption(LAYOUT_PROVIDER_LAYOUT_OPTION);
		return info;
	}
}
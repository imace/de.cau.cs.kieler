package edu.unikiel.rtsys.kieler.kiml.layouter.example;

import java.util.ArrayList;

import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KNodeGroup;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphFactory;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.LAYOUTER_INFO;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.LAYOUT_OPTION;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.LAYOUT_TYPE;
import edu.unikiel.rtsys.kieler.kiml.layout.services.KimlAbstractLayoutProvider;

public class ExampleLayoutProvider extends KimlAbstractLayoutProvider {

	public static final String LAYOUT_PROVIDER_ID = "Example Layout Provider";

	private static final String EXAMPLE_LAYOUT = "Example layout";

	public void doLayout(KNodeGroup nodeGroup) {

		ExampleLayouter el = new ExampleLayouter();
		el.visit(nodeGroup);
	}

	public String getLayoutProviderID() {
		return LAYOUT_PROVIDER_ID;
	}

	public final ArrayList<LAYOUTER_INFO> getLayouterInfos() {
		ArrayList<LAYOUTER_INFO> layouterInfos = new ArrayList<LAYOUTER_INFO>();

		LAYOUTER_INFO example = KimlLayoutGraphFactory.eINSTANCE
				.createLAYOUTER_INFO();
		example.setLayouterName(EXAMPLE_LAYOUT);
		example.setLayoutType(LAYOUT_TYPE.OTHER);
		example.setLayoutOption(LAYOUT_OPTION.DEFAULT);
		example.setLayoutProviderID(LAYOUT_PROVIDER_ID);
		
		layouterInfos.add(example);
		return layouterInfos;
	}

}

package edu.unikiel.rtsys.kieler.kiml.layouter.example;

import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KNodeGroup;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphFactory;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.LAYOUTER_INFO;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.LAYOUT_OPTION;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.LAYOUT_TYPE;
import edu.unikiel.rtsys.kieler.kiml.layout.services.KimlAbstractLayoutProvider;

public class ExampleLayoutProvider extends KimlAbstractLayoutProvider {

	private final static String LAYOUT_PROVIDER_NAME = "Example layouter";
	private final static LAYOUT_TYPE LAYOUT_PROVIDER_LAYOUT_TYPE = LAYOUT_TYPE.OTHER;
	private final static LAYOUT_OPTION LAYOUT_PROVIDER_LAYOUT_OPTION = LAYOUT_OPTION.DEFAULT;

	public void doLayout(KNodeGroup nodeGroup) {
		ExampleLayouter el = new ExampleLayouter();
		el.visit(nodeGroup);
	}

	public final LAYOUTER_INFO getLayouterInfo() {
		
		LAYOUTER_INFO info = KimlLayoutGraphFactory.eINSTANCE
				.createLAYOUTER_INFO();
		info.setLayouterName(LAYOUT_PROVIDER_NAME);
		info.setLayoutType(LAYOUT_PROVIDER_LAYOUT_TYPE);
		info.setLayoutOption(LAYOUT_PROVIDER_LAYOUT_OPTION);
		info.setLayouterCollectionID(Activator.LAYOUT_PROVIDER_COLLECTION_ID);
		return info;
	}

}

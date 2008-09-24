package edu.unikiel.rtsys.kieler.kiml.layout.services;

import java.util.ArrayList;

import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KNodeGroup;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphFactory;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.LAYOUTER_INFO;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.LAYOUT_OPTION;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.LAYOUT_TYPE;
import edu.unikiel.rtsys.kieler.kiml.layout.services.KimlAbstractLayoutProvider;

public class KimlNullLayoutProvider extends KimlAbstractLayoutProvider {

	public static final String LAYOUT_PROVIDER_ID = "Null Layout Provider";

	public static final String NULL_LAYOUT = "Null layout";

	public void doLayout(KNodeGroup nodeGroup) {
		;// NULL layouter, do nothing
	}

	public String getLayoutProviderID() {
		return LAYOUT_PROVIDER_ID;
	}

	public final ArrayList<LAYOUTER_INFO> getLayouterInfos() {
		ArrayList<LAYOUTER_INFO> layouterInfos = new ArrayList<LAYOUTER_INFO>();

		LAYOUTER_INFO nulll = KimlLayoutGraphFactory.eINSTANCE
				.createLAYOUTER_INFO();
		nulll.setLayouterName(NULL_LAYOUT);
		nulll.setLayoutType(LAYOUT_TYPE.OTHER);
		nulll.setLayoutOption(LAYOUT_OPTION.DEFAULT);
		nulll.setLayoutProviderID(LAYOUT_PROVIDER_ID);
		layouterInfos.add(nulll);
		return layouterInfos;
	}

}

/*******************************************************************************
 * Copyright (c) 2008 Real-Time and Embedded Systems group
 *
 * INSERT LICENCE HERE
 *
 *
 * Author: Arne Schipper, ars@informatik.uni-kiel.de 
 *
 *******************************************************************************/
package edu.unikiel.rtsys.kieler.kiml.layout.services;

import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KNodeGroup;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphFactory;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.LAYOUTER_INFO;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.LAYOUT_OPTION;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.LAYOUT_TYPE;

public class KimlNullLayoutProvider extends KimlAbstractLayoutProvider {

	public final static String LAYOUT_PROVIDER_NAME = "Null Layouter";
	public final static LAYOUT_TYPE LAYOUT_PROVIDER_LAYOUT_TYPE = LAYOUT_TYPE.OTHER;
	public final static LAYOUT_OPTION LAYOUT_PROVIDER_LAYOUT_OPTION = LAYOUT_OPTION.DEFAULT;

	public void doLayout(KNodeGroup nodeGroup) {
		;// NULL layouter, do nothing
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

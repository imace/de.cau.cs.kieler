/*******************************************************************************
 * Copyright (c) 2008 Real-Time and Embedded Systems group
 *
 * INSERT LICENCE HERE
 *
 *
 * Author: Arne Schipper, ars@informatik.uni-kiel.de 
 *
 *******************************************************************************/
package de.cau.cs.kieler.kiml.layout.services;

import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KNodeGroup;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphFactory;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.LAYOUTER_INFO;

/**
 * Implements the NullLayoutProvider. This layout provider just exists to
 * prevent NullPointerExceptions when someone requests a layouter and there is
 * none in the entire system. This layout provider is not registered through the
 * extension points as normal layout providers, but is instantiated and returned
 * from {@link LayoutProviders#getLayoutProvider(KNodeGroup)}, when no layout
 * provider is found.
 * 
 * @author <a href="mailto:ars@informatik.uni-kiel.de">Arne Schipper</a>
 * @see LayoutProviders
 */
public class KimlNullLayoutProvider extends KimlAbstractLayoutProvider {

	/**
	 * Does nothing, as this is the NullLayoutProvider.
	 * 
	 * @see de.cau.cs.kieler.kiml.layout.services.KimlAbstractLayoutProvider#doLayout(KNodeGroup)
	 *      KimlAbstractLayoutProvider.doLayout(KNodeGroup)
	 */
	public void doLayout(KNodeGroup nodeGroup) {
		;/* NULL layouter, does nothing */
	}

	/**
	 * Returns a to defaults initialized LAYOUTER_INFO, as this is the
	 * NullLayoutProvider.
	 * 
	 * @see de.cau.cs.kieler.kiml.layout.services.KimlAbstractLayoutProvider#getLayouterInfo() KimlAbstractLayoutProvider.getLayouterInfo()
	 */
	public final LAYOUTER_INFO getLayouterInfo() {
		return KimlLayoutGraphFactory.eINSTANCE.createLAYOUTER_INFO();
	}

}

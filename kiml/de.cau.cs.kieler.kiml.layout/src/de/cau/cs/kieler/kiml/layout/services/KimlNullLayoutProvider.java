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

import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutNode;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphFactory;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayouterInfo;

/**
 * Implements the NullLayoutProvider. This layout provider just exists to
 * prevent NullPointerExceptions when someone requests a layouter and there is
 * none in the entire system. This layout provider is not registered through the
 * extension points as normal layout providers, but is instantiated and returned
 * from {@link LayoutProviders#getLayoutProvider(KLayoutNode)}, when no layout
 * provider is found.
 * 
 * @author <a href="mailto:ars@informatik.uni-kiel.de">Arne Schipper</a>
 * @see LayoutProviders
 */
public class KimlNullLayoutProvider extends KimlAbstractLayoutProvider {

	/**
	 * Does nothing, as this is the NullLayoutProvider.
	 * 
	 * @see de.cau.cs.kieler.kiml.layout.services.KimlAbstractLayoutProvider#doLayout(KLayoutNode)
	 *      KimlAbstractLayoutProvider.doLayout(KLayoutNode)
	 */
	public void doLayout(KLayoutNode layoutNode) {
		;/* NULL layouter, does nothing */
	}

	/**
	 * Returns a to defaults initialized KLayouterInfo, as this is the
	 * NullLayoutProvider.
	 * 
	 * @see de.cau.cs.kieler.kiml.layout.services.KimlAbstractLayoutProvider#getLayouterInfo() KimlAbstractLayoutProvider.getLayouterInfo()
	 */
	public final KLayouterInfo getLayouterInfo() {
		return KimlLayoutGraphFactory.eINSTANCE.createKLayouterInfo();
	}

}

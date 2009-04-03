/******************************************************************************
 * KIELER - Kiel Integrated Environment for Layout for the Eclipse RCP
 *
 * http://www.informatik.uni-kiel.de/rtsys/kieler/
 * 
 * Copyright 2008 by
 * + Christian-Albrechts-University of Kiel
 *   + Department of Computer Science
 *     + Real-Time and Embedded Systems Group
 * 
 * This code is provided under the terms of the Eclipse Public License (EPL).
 * See the file epl-v10.html for the license text.
 */
package de.cau.cs.kieler.kiml.layout.services;

import de.cau.cs.kieler.core.KielerException;
import de.cau.cs.kieler.core.alg.IKielerProgressMonitor;
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
public class NullLayoutProvider extends AbstractLayoutProvider {

	/**
	 * Does nothing, as this is the NullLayoutProvider.
	 * 
	 * @see de.cau.cs.kieler.kiml.layout.services.AbstractLayoutProvider#doLayout(de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutNode, de.cau.cs.kieler.core.alg.IKielerProgressMonitor)
	 */
	public void doLayout(KLayoutNode layoutNode,
			IKielerProgressMonitor progressMonitor) throws KielerException {
		// notify the progress monitor of the start and immediate end
		progressMonitor.begin("Null layout", 1);
		progressMonitor.done();
	}

	/**
	 * Returns a to defaults initialized KLayouterInfo, as this is the
	 * NullLayoutProvider.
	 * 
	 * @see de.cau.cs.kieler.kiml.layout.services.AbstractLayoutProvider#getLayouterInfo() AbstractLayoutProvider.getLayouterInfo()
	 */
	public final KLayouterInfo getLayouterInfo() {
		return KimlLayoutGraphFactory.eINSTANCE.createKLayouterInfo();
	}

}

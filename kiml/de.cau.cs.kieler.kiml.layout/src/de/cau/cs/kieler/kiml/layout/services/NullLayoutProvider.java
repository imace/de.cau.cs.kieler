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
import de.cau.cs.kieler.core.kgraph.KNode;
import de.cau.cs.kieler.kiml.layout.options.LayoutType;

/**
 * Implements the NullLayoutProvider. This layout provider just exists to
 * prevent NullPointerExceptions when someone requests a layouter and there is
 * none in the entire system. This layout provider is not registered through the
 * extension points as normal layout providers, but is instantiated and returned
 * from {@link LayoutProviders#getLayoutProvider(KNode)}, when no layout
 * provider is found.
 * 
 * @author <a href="mailto:ars@informatik.uni-kiel.de">Arne Schipper</a>
 * @see LayoutProviders
 */
public class NullLayoutProvider extends AbstractLayoutProvider {

    /** the layouter name */
    private static final String LAYOUTER_NAME = "Null Layout";

	/**
	 * Does nothing, as this is the NullLayoutProvider.
	 * 
	 * @see de.cau.cs.kieler.kiml.layout.services.AbstractLayoutProvider#doLayout(de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KNode, de.cau.cs.kieler.core.alg.IKielerProgressMonitor)
	 */
	public void doLayout(KNode layoutNode,
			IKielerProgressMonitor progressMonitor) throws KielerException {
		// notify the progress monitor of the start and immediate end
		progressMonitor.begin("Null layout", 1);
		progressMonitor.done();
	}

    /* (non-Javadoc)
     * @see de.cau.cs.kieler.kiml.layout.services.AbstractLayoutProvider#getCollection()
     */
    public String getCollection() {
        return "";
    }

    /* (non-Javadoc)
     * @see de.cau.cs.kieler.kiml.layout.services.AbstractLayoutProvider#getName()
     */
    public String getName() {
        return LAYOUTER_NAME;
    }

    /* (non-Javadoc)
     * @see de.cau.cs.kieler.kiml.layout.services.AbstractLayoutProvider#getType()
     */
    public LayoutType getType() {
        return LayoutType.OTHER;
    }

}

/*******************************************************************************
 * Copyright (c) 2008 Real-Time and Embedded Systems group
 *
 * INSERT LICENCE HERE
 *
 *
 * Author: Arne Schipper, ars@informatik.uni-kiel.de 
 *
 *******************************************************************************/
package de.cau.cs.kieler.kiml.layouter.example;

import de.cau.cs.kieler.core.KielerException;
import de.cau.cs.kieler.core.alg.IKielerProgressMonitor;
import de.cau.cs.kieler.core.kgraph.KNode;
import de.cau.cs.kieler.kiml.layout.options.LayoutType;
import de.cau.cs.kieler.kiml.layout.services.AbstractLayoutProvider;

/**
 * Implements the Example layouter. As this class extends the
 * {@link AbstractLayoutProvider}, the most relevant method is
 * <code>doLayout</code>, which performs the actual layout, that is annotating
 * the provided KLayoutNode with the Example layouter layout information.
 * <p/>
 * This class acts as a wrapper to the {@link ExampleLayouter}. Is uses the
 * {@link ExampleLayouter} with the standard (and currently only) engine and
 * publishes the Example specific capabilities trough
 * <code>getLayouterInfo</code>.
 * <p/>
 * This layouter is not of great use. It was mainly written to demonstrate how
 * fast a new layout provider can be inserted into the KIML infrastructure and
 * to act as an, oh wonder, example for other developers intending to write
 * their own layouter.
 * 
 * @author <a href="mailto:ars@informatik.uni-kiel.de">Arne Schipper</a>
 */
public class ExampleLayoutProvider extends AbstractLayoutProvider {
	
	/*
	 * (non-Javadoc)
	 * @see de.cau.cs.kieler.kiml.layout.services.AbstractLayoutProvider#doLayout(de.cau.cs.kieler.core.kgraph.KNode, de.cau.cs.kieler.core.alg.IKielerProgressMonitor)
	 */
	public void doLayout(KNode layoutNode,
			IKielerProgressMonitor progressMonitor) throws KielerException {
		progressMonitor.begin("Example layout", 1);
		ExampleLayouter el = new ExampleLayouter();
		el.visit(layoutNode);
		progressMonitor.done();
	}

    /* (non-Javadoc)
     * @see de.cau.cs.kieler.kiml.layout.services.AbstractLayoutProvider#getCollection()
     */
    public String getCollection() {
        return Activator.LAYOUT_PROVIDER_COLLECTION_ID;
    }

    /* (non-Javadoc)
     * @see de.cau.cs.kieler.kiml.layout.services.AbstractLayoutProvider#getName()
     */
    public String getName() {
        return Activator.LAYOUT_PROVIDER_NAME;
    }

    /* (non-Javadoc)
     * @see de.cau.cs.kieler.kiml.layout.services.AbstractLayoutProvider#getType()
     */
    public LayoutType getType() {
        return LayoutType.OTHER;
    }

}

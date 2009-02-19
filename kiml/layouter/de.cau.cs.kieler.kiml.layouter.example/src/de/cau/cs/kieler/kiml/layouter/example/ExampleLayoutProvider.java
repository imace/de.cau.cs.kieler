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
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutNode;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphFactory;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayouterInfo;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutOption;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutType;
import de.cau.cs.kieler.kiml.layout.services.KimlAbstractLayoutProvider;

/**
 * Implements the Example layouter. As this class extends the
 * {@link KimlAbstractLayoutProvider}, the most relevant method is
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
public class ExampleLayoutProvider extends KimlAbstractLayoutProvider {
	
	/* some Strings used here */
	private final KLayoutType LAYOUT_PROVIDER_LAYOUT_TYPE = KLayoutType.OTHER;
	private final KLayoutOption LAYOUT_PROVIDER_LAYOUT_OPTION = KLayoutOption.DEFAULT;

	/* (non-Javadoc)
	 * @see de.cau.cs.kieler.kiml.layout.services.KimlAbstractLayoutProvider#doLayout(de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutNode)
	 */
	public void doLayout(KLayoutNode layoutNode,
			IKielerProgressMonitor progressMonitor) throws KielerException {
		progressMonitor.begin("Example layout", 1);
		ExampleLayouter el = new ExampleLayouter();
		el.visit(layoutNode);
		progressMonitor.done();
	}

	/* (non-Javadoc)
	 * @see de.cau.cs.kieler.kiml.layout.services.KimlAbstractLayoutProvider#getLayouterInfo()
	 */
	public final KLayouterInfo getLayouterInfo() {

		KLayouterInfo info = KimlLayoutGraphFactory.eINSTANCE
				.createKLayouterInfo();
		info.setLayouterName(Activator.LAYOUT_PROVIDER_NAME);
		info.setLayoutType(LAYOUT_PROVIDER_LAYOUT_TYPE);
		info.setLayoutOption(LAYOUT_PROVIDER_LAYOUT_OPTION);
		info.setLayouterCollectionID(Activator.LAYOUT_PROVIDER_COLLECTION_ID);
		return info;
	}

}

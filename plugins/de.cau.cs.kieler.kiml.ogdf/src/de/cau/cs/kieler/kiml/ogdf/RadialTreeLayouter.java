/*
 * KIELER - Kiel Integrated Environment for Layout Eclipse RichClient
 *
 * http://www.informatik.uni-kiel.de/rtsys/kieler/
 * 
 * Copyright 2009 by
 * + Christian-Albrechts-University of Kiel
 *   + Department of Computer Science
 *     + Real-Time and Embedded Systems Group
 * 
 * This code is provided under the terms of the Eclipse Public License (EPL).
 * See the file epl-v10.html for the license text.
 */
package de.cau.cs.kieler.kiml.ogdf;

import net.ogdf.bin.OgdfServer;
import de.cau.cs.kieler.core.kgraph.KNode;
import de.cau.cs.kieler.core.properties.IProperty;
import de.cau.cs.kieler.core.properties.Property;
import de.cau.cs.kieler.kiml.klayoutdata.KShapeLayout;

/**
 * The radial tree layouter from the OGDF library.
 * 
 * @author mri
 */
public class RadialTreeLayouter extends OgdfLayouter {

    /** the 'levelDistance' option identifier. */
    private static final String LEVEL_DISTANCE_ID =
            "de.cau.cs.kieler.kiml.ogdf.option.minDistLevel";
    /** 'levelDistance' property. */
    private static final IProperty<Float> LEVEL_DISTANCE = new Property<Float>(LEVEL_DISTANCE_ID,
            50.0f);
    /** the 'ccDistance' option identifier. */
    private static final String CC_DISTANCE_ID = "de.cau.cs.kieler.kiml.ogdf.option.minDistCC";
    /** 'ccDistance' property. */
    private static final IProperty<Float> CC_DISTANCE = new Property<Float>(CC_DISTANCE_ID, 50.0f);

    /** the self-loop router algorithm. */
    private SelfLoopRouter loopRouter = new SelfLoopRouter();

    /**
     * Constructs a RadialTreeLayouter.
     */
    public RadialTreeLayouter() {
        super("RADIAL_TREE");
    }

    /**
     * {@inheritDoc}
     */
    protected void prepareLayouter(final KNode layoutNode) {
        KShapeLayout parentLayout = layoutNode.getData(KShapeLayout.class);
        // levelDistance
        float levelDistance = parentLayout.getProperty(LEVEL_DISTANCE);
        addOption(OgdfServer.OPTION_LEVEL_DISTANCE, levelDistance);
        // ccDistance
        float ccDistance = parentLayout.getProperty(CC_DISTANCE);
        addOption(OgdfServer.OPTION_CC_DISTANCE, ccDistance);
        // remove self-loops from the graph
        loopRouter.preProcess(layoutNode);
    }

    /**
     * {@inheritDoc}
     */
    protected void postProcess(final KNode layoutNode) {
        loopRouter.exclude();
    }
}

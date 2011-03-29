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

import net.ogdf.bin.OgdfServerAPI;
import de.cau.cs.kieler.core.kgraph.KNode;
import de.cau.cs.kieler.core.properties.IProperty;
import de.cau.cs.kieler.core.properties.Property;
import de.cau.cs.kieler.kiml.klayoutdata.KShapeLayout;
import de.cau.cs.kieler.kiml.ogdf.options.QualityVsSpeed;
import de.cau.cs.kieler.kiml.options.LayoutOptions;

/**
 * The FMMM layouter from the OGDF library.
 * 
 * @author mri
 */
public class FMMMLayouter extends OgdfLayouter {

    /** default value for spacing. */
    public static final float DEF_SPACING = 30.0f;
    
    /** 'spacing' property. */
    private static final IProperty<Float> SPACING = new Property<Float>(LayoutOptions.SPACING,
            DEF_SPACING);
    /** the 'quality vs speed' option identifier. */
    private static final String QUALITY_VS_SPEED_ID =
            "de.cau.cs.kieler.kiml.ogdf.option.qualityVsSpeed";
    /** 'quality vs speed' property. */
    private static final IProperty<QualityVsSpeed> QUALITY_VS_SPEED = new Property<QualityVsSpeed>(
            QUALITY_VS_SPEED_ID, QualityVsSpeed.BEAUTIFULANDFAST);

    /** the 'new initial placement' option identifier. */
    private static final String NEW_INITIAL_PLACEMENT_ID =
            "de.cau.cs.kieler.kiml.ogdf.option.newInitialPlacement";
    /** 'new initial placement' property. */
    private static final IProperty<Boolean> NEW_INITIAL_PLACEMENT = new Property<Boolean>(
            NEW_INITIAL_PLACEMENT_ID, false);

    /** the self-loop router algorithm. */
    private SelfLoopRouter loopRouter = new SelfLoopRouter();

    /**
     * Constructs a FMMMLayouter.
     */
    public FMMMLayouter() {
        super("FRUCHTERMAN_REINGOLD");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void prepareLayouter(final KNode layoutNode) {
        KShapeLayout parentLayout = layoutNode.getData(KShapeLayout.class);
        // unitEdgeLength
        float unitEdgeLength = parentLayout.getProperty(SPACING);
        addOption(OgdfServerAPI.OPTION_EDGE_LENGTH, unitEdgeLength);
        // qualityVsSpeed
        QualityVsSpeed qualityVsSpeed = parentLayout.getProperty(QUALITY_VS_SPEED);
        int qvs;
        switch (qualityVsSpeed) {
        case GORGEOUSANDEFFICIENT:
            qvs = OgdfServerAPI.GORGEOUS_AND_EFFICIENT;
            break;
        case NICEANDINCREDIBLESPEED:
            qvs = OgdfServerAPI.NICE_AND_INCREDIBLE_SPEED;
            break;
        case BEAUTIFULANDFAST:
        default:
            qvs = OgdfServerAPI.BEAUTIFUL_AND_FAST;
            break;
        }
        addOption(OgdfServerAPI.OPTION_QUALITY_VS_SPEED, qvs);
        // newInitialPlacement
        boolean newInitialPlacement = parentLayout.getProperty(NEW_INITIAL_PLACEMENT);
        addOption(OgdfServerAPI.OPTION_NEW_INITIAL_PLACEMENT, newInitialPlacement);
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

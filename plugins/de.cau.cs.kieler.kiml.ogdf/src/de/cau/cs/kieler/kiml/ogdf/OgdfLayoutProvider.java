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
import net.ogdf.bin.OgdfServerPool;
import de.cau.cs.kieler.core.alg.IKielerProgressMonitor;
import de.cau.cs.kieler.core.kgraph.KNode;
import de.cau.cs.kieler.kiml.AbstractLayoutProvider;
import de.cau.cs.kieler.kiml.ogdf.options.LayoutAlgorithm;

/**
 * The OGDF layout provider, that is the entry class used by KIML to call individual layout
 * algorithms.
 * 
 * @author msp
 * @author mri
 */
public class OgdfLayoutProvider extends AbstractLayoutProvider {

    /** the selected layouter. */
    private OgdfLayouter layoutAlgorithm;

    /**
     * {@inheritDoc}
     * 
     * @throws KielerException
     */
    @Override
    public void initialize(final String parameter) {
        if (parameter == null) {
            throw new IllegalArgumentException("Could not initialize OGDF layouter.");
        }
        initialize(LayoutAlgorithm.valueOf(parameter));
    }

    /**
     * Initialize the layout provider with the given algorithm constant.
     * 
     * @param algo
     *            a layout algorithm constant
     */
    public void initialize(final LayoutAlgorithm algo) {
        switch (algo) {
        case SUGIYAMA:
            layoutAlgorithm = new SugiyamaLayouter();
            break;
        case PLANARIZATION:
            layoutAlgorithm = new PlanarizationLayouter();
            break;
        case FMMM:
            layoutAlgorithm = new FMMMLayouter();
            break;
        case DAVIDSON_HAREL:
            layoutAlgorithm = new DavidsonHarelLayouter();
            break;
        case FRUCHTERMAN_REINGOLD:
            layoutAlgorithm = new SpringEmbedderFRLayouter();
            break;
        case GEM:
            layoutAlgorithm = new GEMLayouter();
            break;
        case CIRCULAR:
            layoutAlgorithm = new CircularLayouter();
            break;
        case TREE:
            layoutAlgorithm = new TreeLayouter();
            break;
        case RADIAL_TREE:
            layoutAlgorithm = new RadialTreeLayouter();
            break;
        case UPWARD_PLANARIZATION:
            layoutAlgorithm = new UpwardPlanarizationLayouter();
            break;
        default:
            layoutAlgorithm = null;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doLayout(final KNode layoutNode,
            final IKielerProgressMonitor progressMonitor) {
        if (layoutAlgorithm == null) {
            throw new IllegalStateException("The OGDF layout algorithm is not configured correctly."
                    + " Please check the parameter in the extension point");
        }
        
        // create an OGDF server process instance or use an existing one
        OgdfServer ogdfServer = OgdfServerPool.INSTANCE.fetch();
        // layout the graph with the selected algorithm
        layoutAlgorithm.doLayout(layoutNode, progressMonitor, ogdfServer);
        // if everything worked well, release the used process instance
        OgdfServerPool.INSTANCE.release(ogdfServer);
    }
    
}

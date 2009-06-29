/******************************************************************************
 * KIELER - Kiel Integrated Environment for Layout for the Eclipse RCP
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
package de.cau.cs.kieler.klodd.orthogonal;

import java.util.List;

import de.cau.cs.kieler.core.IKielerPreferenceStore;
import de.cau.cs.kieler.core.KielerException;
import de.cau.cs.kieler.core.alg.IKielerProgressMonitor;
import de.cau.cs.kieler.core.kgraph.KNode;
import de.cau.cs.kieler.core.slimgraph.KSlimGraph;
import de.cau.cs.kieler.kiml.layout.klayoutdata.KFloatOption;
import de.cau.cs.kieler.kiml.layout.klayoutdata.KInsets;
import de.cau.cs.kieler.kiml.layout.klayoutdata.KOption;
import de.cau.cs.kieler.kiml.layout.klayoutdata.KShapeLayout;
import de.cau.cs.kieler.kiml.layout.options.LayoutOptions;
import de.cau.cs.kieler.kiml.layout.options.PortConstraints;
import de.cau.cs.kieler.kiml.layout.services.AbstractLayoutProvider;
import de.cau.cs.kieler.kiml.layout.util.KimlLayoutUtil;
import de.cau.cs.kieler.klodd.orthogonal.impl.*;
import de.cau.cs.kieler.klodd.orthogonal.impl.ec.EdgeInsertionECPlanarizer;
import de.cau.cs.kieler.klodd.orthogonal.modules.*;
import de.cau.cs.kieler.klodd.orthogonal.structures.TSMGraph;

/**
 * Layout provider for the KLoDD orthogonal dataflow diagram layouter.
 * 
 * @author msp
 */
public class OrthogonalDataflowLayoutProvider extends
		AbstractLayoutProvider {

	/** default value for minimal distance */
	public static final float DEF_MIN_DIST = 15.0f;
	
	/** the preference store for this layouter */
	private static IKielerPreferenceStore preferenceStore;

	/**
	 * Sets the preference store.
	 * 
	 * @param preferenceStore the preference store to set
	 */
	public static void setPreferenceStore(IKielerPreferenceStore preferenceStore) {
		OrthogonalDataflowLayoutProvider.preferenceStore = preferenceStore;
	}

	/** the planarization module */
	private IPlanarizer planarizer = null;
	/** the orthogonalization module */
	private IOrthogonalizer orthogonalizer = null;
	/** the compaction module */
	private ICompacter compacter = null;
	
	/*
	 * (non-Javadoc)
	 * @see de.cau.cs.kieler.kiml.layout.services.AbstractLayoutProvider#doLayout(de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KNode, de.cau.cs.kieler.core.alg.IKielerProgressMonitor)
	 */
	public void doLayout(KNode layoutNode,
			IKielerProgressMonitor progressMonitor) throws KielerException {
		// get the currently configured modules
		updateModules();
		// set option for minimal distance
        float minDist = LayoutOptions.getMinSpacing(
                KimlLayoutUtil.getShapeLayout(layoutNode));
        if (Float.isNaN(minDist)) {
            KOption spacingOption = getDefault(LayoutOptions.MIN_SPACING);
            if (spacingOption instanceof KFloatOption)
                minDist = ((KFloatOption)spacingOption).getValue();
            else
                minDist = DEF_MIN_DIST;
        }
		
		// split the graph into connected components
		ConnectedComponents componentsSplitter = new ConnectedComponents();
		List<TSMGraph> components = componentsSplitter.findComponents(layoutNode);
		progressMonitor.begin("Orthogonal layout", components.size() * 30 + 2);
		
		for (KSlimGraph tsmGraph : components) {
			// perform the planarization phase
			planarizer.reset(progressMonitor.subTask(10));
			planarizer.planarize(tsmGraph);
			// perform the orthogonalization phase
			orthogonalizer.reset(progressMonitor.subTask(10));
			orthogonalizer.orthogonalize(tsmGraph);
			// perform the compaction phase
			compacter.reset(progressMonitor.subTask(10));
			compacter.compact(tsmGraph, minDist);
		}
		// apply layout information to the original graph
		applyLayout(components, layoutNode);
		
		progressMonitor.done();
	}
	
	/**
	 * Sets the internally used algorithm modules to the current configuration.
	 */
	private void updateModules() {
		if (planarizer == null)
			planarizer = new PortConstraintsPlanarizer(
					new EdgeInsertionECPlanarizer());
		if (orthogonalizer == null)
			orthogonalizer = new KandinskyLPOrthogonalizer();
		if (compacter == null)
			compacter = new NormalizingCompacter(new RefiningCompacter(
					new LayeringCompacter()));
	}
	
	/**
	 * Applies layout to the given list of connected components of a graph.
	 * 
	 * @param components list of connected components
	 * @param parentNode parent layout node
	 */
	private void applyLayout(List<TSMGraph> components, KNode parentNode) {
		KShapeLayout parentLayout = KimlLayoutUtil.getShapeLayout(parentNode);
	    KInsets insets = LayoutOptions.getInsets(parentLayout);
		float currentYpos = 0.0f, maxWidth = 0.0f;
		for (TSMGraph component : components) {
			component.applyLayout(0.0f, currentYpos, insets);
			currentYpos += component.height;
			maxWidth = Math.max(maxWidth, component.width);
		}
		
		// update the size of the parent layout node
		parentLayout.setWidth(insets.getLeft()
				+ maxWidth + insets.getRight());
		parentLayout.setHeight(insets.getTop()
				+ currentYpos + insets.getBottom());
		
		// update layout options of the parent layout node
		LayoutOptions.setFixedSize(parentLayout, true);
		LayoutOptions.setPortConstraints(parentLayout,
		        PortConstraints.FIXED_POS);
	}

}

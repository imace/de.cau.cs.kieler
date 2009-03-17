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

import de.cau.cs.kieler.core.alg.IKielerProgressMonitor;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutGraph;

/**
 * Interface for listeners to the KIML layout.
 * 
 * @author msp
 */
public interface IKimlLayoutListener {

	/** the extension point identifier */
	public static final String EXTENSION_POINT_ID = "de.cau.cs.kieler.kiml.layout.kimlLayoutListener";
	/** the class attribute of the extension point */
	public static final String ATTRIBUTE_CLASS = "class";
	
	/**
	 * Called when layout is requested for the given layout graph.
	 * The given layout graph must not be modified by this method.
	 * 
	 * @param layoutGraph layout graph that will be processed after
	 *     this method returns
	 */
	public void layoutRequested(KLayoutGraph layoutGraph);
	
	/**
	 * Called after layout was performed for the given layout graph.
	 * The given layout graph must not be modified by this method.
	 * 
	 * @param layoutGraph layout graph that was layouted
	 * @param monitor progress monitor containing execution time results
	 */
	public void layoutPerformed(KLayoutGraph layoutGraph,
			IKielerProgressMonitor monitor);
	
}

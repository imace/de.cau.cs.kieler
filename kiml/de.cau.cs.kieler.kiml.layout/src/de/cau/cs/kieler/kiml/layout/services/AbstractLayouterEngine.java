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

/**
 * A layouter engine performs layout on a graph and handles hierarchy by
 * choosing appropriate layout providers and possibly executing them
 * repeatedly. The basic implementation is {@link RecursiveLayouterEngine},
 * which executes a layout provider for each non-empty node in the graph. 
 * 
 * @author <a href="mailto:ars@informatik.uni-kiel.de">Arne Schipper</a>
 */
public abstract class AbstractLayouterEngine {

	/** caches the call to the layout services class for subclasses */
	protected KimlLayoutServices layoutServices = KimlLayoutServices
			.getInstance();

	/**
	 * Lays out a parent node with hierarchy.
	 * 
	 * @param layoutNode a node with hierarchy which is laid out
	 * @param progressMonitor progress monitor used to keep track of progress
	 * @throws KielerException if the method fails to perform layout
	 */
	public abstract void layout(KNode layoutNode,
			IKielerProgressMonitor progressMonitor) throws KielerException;
	
	/**
	 * Returns the last layout provider that was used for layout. This
	 * can be used for error handling.
	 * 
	 * @return the last used layout provider, or null if none was used
	 */
	public abstract AbstractLayoutProvider getLastLayoutProvider();

}
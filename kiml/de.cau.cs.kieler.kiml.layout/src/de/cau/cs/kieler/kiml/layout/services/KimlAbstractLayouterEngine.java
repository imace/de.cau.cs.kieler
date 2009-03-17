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
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutGraph;

/**
 * Abstract class every concrete layouter engine has to extend. Pushes the
 * KLayoutGraph with hierarchy to the concrete LayoutProviders which can or
 * cannot handle hierarchy. One implementation is
 * {@link KimlRecursiveGroupLayouterEngine}.
 * <p/>
 * 
 * @author <a href="mailto:ars@informatik.uni-kiel.de">Arne Schipper</a>
 * @see KimlRecursiveGroupLayouterEngine
 */
public abstract class KimlAbstractLayouterEngine {

	/* caches the call to the layout services class for subclasses */
	protected KimlLayoutServices layoutServices = KimlLayoutServices
			.getInstance();

	/**
	 * Lays out a KLayoutGraph with hierarchy, that is attaches layout
	 * information to the description of the KLayoutGraph.
	 * 
	 * @param layoutGraph a KLayoutGraph with hierarchy which is laid out
	 *     by this method
	 * @param progressMonitor progress monitor used to keep track of progress
	 * @throws KielerException if the method fails to perform layout
	 */
	public abstract void layout(KLayoutGraph layoutGraph,
			IKielerProgressMonitor progressMonitor) throws KielerException;
	
	/**
	 * Returns the last layout provider that was used for layout. This
	 * can be used for error handling.
	 * 
	 * @return the last used layout provider, or null if none was used
	 */
	public abstract KimlAbstractLayoutProvider getLastLayoutProvider();

}
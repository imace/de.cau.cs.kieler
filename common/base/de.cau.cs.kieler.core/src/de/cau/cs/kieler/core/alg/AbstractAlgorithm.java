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
package de.cau.cs.kieler.core.alg;

/**
 * Superclass for algorithms used in the KIELER project.
 * 
 * @author msp
 */
public abstract class AbstractAlgorithm implements IAlgorithm {

	/** the associated progress monitor */
	private IKielerProgressMonitor progressMonitor = null;
	
	/**
	 * Removes the associated progress monitor. Any subclass that
	 * overrides this method should call <code>super.reset()</code>.
	 */
	public void reset() {
		progressMonitor = null;
	}
	
	/*
	 * (non-Javadoc)
	 * @see de.cau.cs.kieler.core.alg.IAlgorithm#reset(de.cau.cs.kieler.core.alg.IKielerProgressMonitor)
	 */
	public final void reset(IKielerProgressMonitor monitor) {
		reset();
		this.progressMonitor = monitor;
	}
	
	/*
	 * (non-Javadoc)
	 * @see de.cau.cs.kieler.core.alg.IAlgorithm#setProgressMonitor(de.cau.cs.kieler.core.alg.IKielerProgressMonitor)
	 */
	public final void setProgressMonitor(IKielerProgressMonitor monitor) {
		this.progressMonitor = monitor;
	}
	
	/**
	 * Returns a progress monitor that can be used by subclasses. This
	 * method does not return null.
	 * 
	 * @return the associated monitor, or a default implementation
	 *     if no progress monitor was set
	 */
	protected final IKielerProgressMonitor getMonitor() {
		if (progressMonitor == null)
			progressMonitor = new NullProgressMonitor();
		return progressMonitor;
	}
	
}

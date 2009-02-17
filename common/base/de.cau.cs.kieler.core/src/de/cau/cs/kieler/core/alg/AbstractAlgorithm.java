package de.cau.cs.kieler.core.alg;

/**
 * Superclass for algorithms used in the KIELER project.
 * 
 * @author msp
 */
public abstract class AbstractAlgorithm implements IAlgorithm {

	/** The associated progress monitor. Subclasses should check
	 *  for null-pointer before using this. */
	protected IKielerProgressMonitor progressMonitor = null;
	
	/**
	 * Removes the associated progress monitor. Any subclass that
	 * overrides this method should call <code>super.reset()</code>.
	 */
	public void reset() {
		progressMonitor = null;
	}
	
	/*
	 * (non-Javadoc)
	 * @see de.cau.cs.kieler.core.alg.IAlgorithm#setProgressMonitor(de.cau.cs.kieler.core.alg.IKielerProgressMonitor)
	 */
	public void setProgressMonitor(IKielerProgressMonitor monitor) {
		this.progressMonitor = monitor;
	}
	
}

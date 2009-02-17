package de.cau.cs.kieler.core.alg;

/**
 * Interface that serves as super-interface for all algorithm interfaces.
 * 
 * @author msp
 */
public interface IAlgorithm {
	
	/**
	 * Reset the internal state of the algorithm. Any associated
	 * progress monitor is lost, so a new one must be set before
	 * the next run of the algorithm.
	 */
	public void reset();
	
	/**
	 * Sets the progress monitor for the algorithm. Algorithm
	 * implementations should make proper use of the monitor by
	 * notifying at least the start and end of their task.
	 * 
	 * @param monitor the progress monitor
	 */
	public void setProgressMonitor(IKielerProgressMonitor monitor);

}

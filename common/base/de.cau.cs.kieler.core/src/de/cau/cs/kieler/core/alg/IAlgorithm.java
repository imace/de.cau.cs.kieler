package de.cau.cs.kieler.core.alg;

/**
 * Interface that serves as super-interface for all algorithm interfaces.
 * 
 * @author msp
 */
public interface IAlgorithm {
	
	/**
	 * Reset the internal state of the algorithm without a progress
	 * monitor.
	 */
	public void reset();
	
	/**
	 * Reset the internal state and set the progress monitor for
	 * the algorithm.
	 * 
	 * @param monitor the progress monitor
	 */
	public void reset(IKielerProgressMonitor monitor);
	
	/**
	 * Set the progress monitor for the algorithm. Algorithm
	 * implementations should make proper use of the monitor by
	 * notifying at least the start and end of their task.
	 * 
	 * @param monitor the progress monitor
	 */
	public void setProgressMonitor(IKielerProgressMonitor monitor);

}

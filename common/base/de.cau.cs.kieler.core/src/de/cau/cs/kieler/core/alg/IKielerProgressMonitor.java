package de.cau.cs.kieler.core.alg;

import java.util.List;

/**
 * Interface for monitors of progress of a job.
 * 
 * @author msp
 */
public interface IKielerProgressMonitor {

	/** constant indicating an unknown amount of work */
	public static final int UNKNOWN_WORK = -1;
	
	/**
	 * Notifies that the task will begin after this method has
	 * been called. This method will have no effect is the monitor is closed.
	 * 
	 * @param name readable name of the new task
	 * @param totalWork total amount of work units, or <code>UNKNOWN_WORK</code>
	 *     if this is not specified
	 */
	public void begin(String name, int totalWork);
	
	/**
	 * Notifies that the current task is done and closes the monitor.
	 * This method may be called multiple times, without any effect after
	 * the first time.
	 */
	public void done();
	
	/**
	 * Notifies that the given number of work units has been completed.
	 * This method will have no effect is the monitor is closed.
	 * 
	 * @param work number of work units
	 */
	public void worked(int work);
	
	/**
	 * Returns whether cancellation of the task has been requested. 
	 * 
	 * @return true if cancellation has been requested
	 */
	public boolean isCanceled();
	
	/**
	 * Creates a new sub-task that will complete the given amount of
	 * work units when it is done.
	 * 
	 * @param work number of work units
	 * @return a progress monitor for the new sub-task, or null if the
	 *     monitor is closed
	 */
	public IKielerProgressMonitor subTask(int work);
	
	/**
	 * Returns a list of all monitors associated with direct sub-tasks.
	 * 
	 * @return list of sub-task monitors
	 */
	public List<IKielerProgressMonitor> getSubMonitors();
	
	/**
	 * Returns the parent monitor.
	 * 
	 * @return the parent monitor, or null if there is none
	 */
	public IKielerProgressMonitor getParentMonitor();
	
	/**
	 * Returns the name of the task associated with this progress
	 * monitor.
	 * 
	 * @return task name
	 */
	public String getTaskName();
	
	/**
	 * Returns the measured execution time for the task associated
	 * with this monitor.
	 * 
	 * @return number of seconds used for execution
	 */
	public double getExecutionTime();
	
}

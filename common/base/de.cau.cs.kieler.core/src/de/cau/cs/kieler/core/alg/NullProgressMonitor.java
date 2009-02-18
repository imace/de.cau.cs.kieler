package de.cau.cs.kieler.core.alg;

import java.util.Collections;
import java.util.List;

/**
 * Progress monitor implementation that does nothing, except measuring
 * execution time.
 * 
 * @author msp
 */
public class NullProgressMonitor implements IKielerProgressMonitor {

	/** level of subtask nesting */
	private int nestingLevel = -1;
	/** the start time of the associated task, in nanoseconds */
	private long startTime;
	/** the total time of the associated task, in seconds */
	private double totalTime;
	/** the name of the associated task */
	private String taskName;
	
	/* (non-Javadoc)
	 * @see de.cau.cs.kieler.core.alg.IKielerProgressMonitor#begin(java.lang.String, int)
	 */
	public void begin(String name, int totalWork) {
		nestingLevel++;
		if (nestingLevel == 0) {
			this.taskName = name;
			startTime = System.nanoTime();
		}
	}

	/* (non-Javadoc)
	 * @see de.cau.cs.kieler.core.alg.IKielerProgressMonitor#done()
	 */
	public void done() {
		if (nestingLevel == 0)
			totalTime = (System.nanoTime() - startTime) * 1e-9;
		nestingLevel--;
	}

	/* (non-Javadoc)
	 * @see de.cau.cs.kieler.core.alg.IKielerProgressMonitor#getExecutionTime()
	 */
	public double getExecutionTime() {
		return totalTime;
	}

	/* (non-Javadoc)
	 * @see de.cau.cs.kieler.core.alg.IKielerProgressMonitor#getSubMonitors()
	 */
	public List<IKielerProgressMonitor> getSubMonitors() {
		return Collections.emptyList();
	}

	/* (non-Javadoc)
	 * @see de.cau.cs.kieler.core.alg.IKielerProgressMonitor#getTaskName()
	 */
	public String getTaskName() {
		return taskName;
	}

	/* (non-Javadoc)
	 * @see de.cau.cs.kieler.core.alg.IKielerProgressMonitor#isCanceled()
	 */
	public boolean isCanceled() {
		return false;
	}

	/* (non-Javadoc)
	 * @see de.cau.cs.kieler.core.alg.IKielerProgressMonitor#subTask(int)
	 */
	public IKielerProgressMonitor subTask(int work) {
		return this;
	}

	/* (non-Javadoc)
	 * @see de.cau.cs.kieler.core.alg.IKielerProgressMonitor#worked(int)
	 */
	public void worked(int work) {
	}

}

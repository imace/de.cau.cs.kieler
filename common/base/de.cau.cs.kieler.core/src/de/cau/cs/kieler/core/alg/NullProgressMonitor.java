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
	/** indicates whether the monitor is closed */
	private boolean closed = false;
	
	/* (non-Javadoc)
	 * @see de.cau.cs.kieler.core.alg.IKielerProgressMonitor#begin(java.lang.String, int)
	 */
	public void begin(String name, int totalWork) {
		if (!closed) {
			nestingLevel++;
			if (nestingLevel == 0) {
				this.taskName = name;
				startTime = System.nanoTime();
			}
		}
	}

	/* (non-Javadoc)
	 * @see de.cau.cs.kieler.core.alg.IKielerProgressMonitor#done()
	 */
	public void done() {
		if (!closed) {
			if (nestingLevel == 0) {
				totalTime = (System.nanoTime() - startTime) * 1e-9;
				closed = true;
			}
			nestingLevel--;
		}
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
	
	/*
	 * (non-Javadoc)
	 * @see de.cau.cs.kieler.core.alg.IKielerProgressMonitor#getParentMonitor()
	 */
	public IKielerProgressMonitor getParentMonitor() {
		return null;
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
		if (closed)
			return null;
		else return this;
	}

	/* (non-Javadoc)
	 * @see de.cau.cs.kieler.core.alg.IKielerProgressMonitor#worked(int)
	 */
	public void worked(int work) {
	}

}

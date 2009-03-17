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
package de.cau.cs.kieler.core.ui;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;

import de.cau.cs.kieler.core.alg.IKielerProgressMonitor;

/**
 * Wrapper class for Eclipse progress monitors.
 * 
 * @author msp
 */
public class KielerProgressMonitor implements IKielerProgressMonitor {

	/** the Eclipse progress monitor used by this monitor */
	private IProgressMonitor progressMonitor;
	/** the parent monitor */
	private KielerProgressMonitor parentMonitor = null;
	/** list of child monitors */
	private List<IKielerProgressMonitor> children = new LinkedList<IKielerProgressMonitor>();
	/** the number of work units that will be consumed after completion
	 *  of the currently active child task */
	private int currentChildWork = -1;
	/** the start time of the associated task, in nanoseconds */
	private long startTime;
	/** the total time of the associated task, in seconds */
	private double totalTime;
	/** the name of the associated task */
	private String taskName;
	/** the amount of work that is completed */
	private float completedWork = 0.0f;
	/** the number of work units that were already submitted */
	private int submittedWork = 0;
	/** the number of work units that can be completed in total */
	private int totalWork;
	/** indicates whether the monitor has been closed */
	private boolean closed = false;

	/**
	 * Creates a progress monitor wrapper for a given Eclipse progress
	 * monitor.
	 * 
	 * @param progressMonitor the progress monitor
	 */
	public KielerProgressMonitor(IProgressMonitor progressMonitor) {
		this.progressMonitor = progressMonitor;
	}
	
	/* (non-Javadoc)
	 * @see de.cau.cs.kieler.core.alg.IKielerProgressMonitor#begin(java.lang.String, int)
	 */
	public void begin(String name, int totalWork) {
		if (!closed) {
			this.taskName = name;
			this.totalWork = totalWork;
			if (parentMonitor == null)
				progressMonitor.beginTask(name, totalWork <= 0
						? IProgressMonitor.UNKNOWN : totalWork);
			else
				progressMonitor.subTask(name);
			
			startTime = System.nanoTime();
		}
	}

	/* (non-Javadoc)
	 * @see de.cau.cs.kieler.core.alg.IKielerProgressMonitor#done()
	 */
	public void done() {
		if (!closed) {
			totalTime = (System.nanoTime() - startTime) * 1e-9;
			
			if (completedWork < totalWork)
				internalWorked(totalWork - completedWork);
			if (parentMonitor == null)
				progressMonitor.done();
			
			closed = true;
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
		return children;
	}
	
	/*
	 * (non-Javadoc)
	 * @see de.cau.cs.kieler.core.alg.IKielerProgressMonitor#getParentMonitor()
	 */
	public IKielerProgressMonitor getParentMonitor() {
		return parentMonitor;
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
		return progressMonitor.isCanceled();
	}

	/* (non-Javadoc)
	 * @see de.cau.cs.kieler.core.alg.IKielerProgressMonitor#subTask(int)
	 */
	public IKielerProgressMonitor subTask(int work) {
		if (!closed) {
			KielerProgressMonitor subMonitor = new KielerProgressMonitor(progressMonitor);
			children.add(subMonitor);
			subMonitor.parentMonitor = this;
			currentChildWork = work;
			return subMonitor;
		}
		else return null;
	}

	/* (non-Javadoc)
	 * @see de.cau.cs.kieler.core.alg.IKielerProgressMonitor#worked(int)
	 */
	public void worked(int work) {
		if (work > 0 && !closed)
			internalWorked(work);
	}
	
	/**
	 * Sets the current work counters of this monitor and all
	 * parent monitors.
	 * 
	 * @param work amount of work that has been completed
	 */
	private void internalWorked(float work) {
		if (totalWork > 0 && completedWork < totalWork) {
			completedWork += work;
			if (parentMonitor == null) {
				int newWork = (int)completedWork;
				if (newWork > submittedWork) {
					progressMonitor.worked(newWork - submittedWork);
					submittedWork = newWork;
				}
			}
			else if (parentMonitor.currentChildWork > 0) {
				 parentMonitor.internalWorked(work / totalWork
						 * parentMonitor.currentChildWork);
			}
		}
	}

}

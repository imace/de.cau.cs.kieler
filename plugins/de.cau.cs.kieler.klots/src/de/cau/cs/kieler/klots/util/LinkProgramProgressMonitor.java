/*
 * KIELER - Kiel Integrated Environment for Layout Eclipse Rich Client
 *
 * http://www.informatik.uni-kiel.de/rtsys/kieler/
 * 
 * Copyright 2011 by
 * + Christian-Albrechts-University of Kiel
 *   + Department of Computer Science
 *     + Real-Time and Embedded Systems Group
 * 
 * This code is provided under the terms of the Eclipse Public License (EPL).
 * See the file epl-v10.html for the license text.
 */
package de.cau.cs.kieler.klots.util;

import js.common.ToolProgressMonitor;

/**
 * Simple implementation of ToolProgressMonitor.
 * 
 * @author ybe
 */
public class LinkProgramProgressMonitor implements ToolProgressMonitor {

    private final int maxProgress = 1000;
    private final int progressStep = 10;
    
    private boolean fVerbose = false;
    private StringBuffer fMessageBuffer;
    
    
    
    /**
     * @param messageBuffer 
     */
    public LinkProgramProgressMonitor(final StringBuffer messageBuffer) {
        fMessageBuffer = messageBuffer;
    }
    
    
    
    /**
     * Notification change of operation.
     * 
     * @param message human readable description of current operation
     */
    public void operation(final String message) {
        assert message != null : "Precondition: message != null";
        System.out.println(message);
    }

    
    
    /**
     * Notification about some progress information.
     * 
     * @param message human readable message about progress
     */
    public void log(final String message) {
        if (!fVerbose) {
            return;
        }
        assert message != null : "Precondition: message != null";
        fMessageBuffer.append(message + KlotsConstants.SEARATOR_STRING);
    }
    
    
    
    /**
     * Notification about progress.
     * 
     * @param progress progress (0-1000)
     */
    public void progress(final int progress) {
        assert progress >= 0 && progress <= maxProgress
        : "Precondition: progress >= 0 && progress <= " + maxProgress;
        String message = "\r  " + (progress / progressStep) + "%\r";
        System.out.print(message);
        if (progress >= maxProgress) {
            System.out.println();
        }
    }

    
    
    /**
     * Is tool canceled?.
     * @return boolean 
     */
    public boolean isCanceled() {
        return Thread.currentThread().isInterrupted();
    }

    
    
    /**
     * Be verbose?
     * 
     * @param verbose 
     */
    public void setVerbose(final boolean verbose) {
        fVerbose = verbose;
    }
    
}
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

import lejos.pc.tools.ToolsLogListener;


/**
 * Simple listener for leJOS NXJ log events.
 * 
 * @author ybe
 *
 */
public class CommandLogListener implements ToolsLogListener {

    private StringBuffer fMessageBuffer;
    
    
    
    /**
     * @param messageBuffer 
     */
    public CommandLogListener(final StringBuffer messageBuffer) {
        fMessageBuffer = messageBuffer;
    }
    
    
    
    /**
     * Notification about some progress information.
     * 
     * @param message human readable message about progress
     */
    public void logEvent(final String message) {
        System.out.println("leJOS NXJ> " + message);
        fMessageBuffer.append(message + KlotsConstants.SEARATOR_STRING);
    }

    
    
    /**
     * Notification about some progress information.
     * 
     * @param throwable throwable message about progress
     */
    public void logEvent(final Throwable throwable) {
        System.err.println("leJOS NXJ> " + throwable.getMessage());
        fMessageBuffer.append(throwable.getMessage() + KlotsConstants.SEARATOR_STRING);
    }
        
}

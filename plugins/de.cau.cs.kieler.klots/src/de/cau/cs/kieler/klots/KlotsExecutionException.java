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
package de.cau.cs.kieler.klots;

/**
 * @author ybe
 */
public class KlotsExecutionException extends Exception {

    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = 8489113228221903901L;
    
    
    /**
     * The silent flag indicates that the component handles the "error" and KLOTS should not display
     * any error or warning message.
     */
    private boolean silent;

    
    /**
     * The cause of this Exception.
     */
    private Exception cause;

    
    
    /**
     * Instantiates a new KlotsConnectionException.
     * 
     * @param message
     *            the message of this Exception to display to the user
     * @param causeParam
     *            the cause of this Exception if any, or null otherwise
     * @param silentParam
     *            the silent parameter flags that KLOTS omits any message dialog
     */
    public KlotsExecutionException(final String message, final boolean silentParam,
            final Exception causeParam) {
        super(message);
        this.silent = silentParam;
        this.cause = causeParam;
    }

    
    
    /**
     * Instantiates a new KlotsConnectionException.
     * 
     * @param message
     *            the message of this Exception to display to the user
     * @param causeParam
     *            the cause of this Exception if any, or null otherwise
     */
    public KlotsExecutionException(final String message, final Exception causeParam) {
        super(message);
        this.silent = false;
        this.cause = causeParam;
    }

    
    
    /**
     * Gets the cause of this Exception.
     * 
     * @return the cause of this Exception, if any
     */
    public Exception getCause() {
        return cause;
    }


    
    /**
     * Checks if KLOTS should omit an error or warning message dialog when this Exception occurs.
     * 
     * @return true, if KLOTS should omit any message dialog
     */
    public boolean isSilent() {
        return this.silent;
    }

}

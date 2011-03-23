/*
 * SJ - Synchronous Java.
 *
 * http://www.informatik.uni-kiel.de/rtsys/
 * 
 * Copyright 2010 by
 * + Christian-Albrechts-University of Kiel
 *   + Department of Computer Science
 *     + Real-Time and Embedded Systems Group
 * 
 * This code is provided under the terms of the Eclipse Public License (EPL).
 * See the file epl-v10.html for the license text.
 */
package sj.exceptions;

/**
 * Exception thrown if a already declared signal is declared again.
 * 
 * @author mhei
 * @see sj.Signal
 * @see sj.EmbeddedSJProgram#addSignals(sj.Signal...)
 * @see sj.SJProgram#initSignals()
 * 
 */
public class SignalAlreadyDeclaredException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * Creates a new signal-already-declared exception.
     */
    public SignalAlreadyDeclaredException() {
        super();
    }

    /**
     * Creates an new signal-already-declared exception with a given error message.
     * 
     * @param errMessage
     *            The error message for the exception.
     */
    public SignalAlreadyDeclaredException(final String errMessage) {
        super(errMessage);
    }

}
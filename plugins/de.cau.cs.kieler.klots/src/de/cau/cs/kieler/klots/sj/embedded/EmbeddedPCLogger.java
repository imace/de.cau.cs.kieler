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
package de.cau.cs.kieler.klots.sj.embedded;

import sj.SJLogger;


/**
 * @author root
 *
 */
public class EmbeddedPCLogger implements SJLogger {
    
    private EmbeddedPCCommunicator comm;

    
    
    /**
     * @param comm 
     */
    public EmbeddedPCLogger(final EmbeddedPCCommunicator comm) {
        this.comm = comm;
    }


    
    /**
     * {@inheritDoc}
     */
    public void log(final LogMsgTyp msgTyp, final String message) {
        if (msgTyp != LogMsgTyp.TICK_INFO) {
            comm.sendMessage(msgTyp.name() + " --> " + message
                    + EmbeddedConstants.MESSAGE_LINE_DELIMITER);
        } else {
            comm.sendMessage(message + EmbeddedConstants.MESSAGE_LINE_DELIMITER);
        }
    }
    
}
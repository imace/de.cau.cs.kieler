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


/**
 * @author root
 *
 */
public class EmbeddedRemoteConsole {

    private EmbeddedPCCommunicator comm = null;
    private boolean standaloneMode = false;

    
    
    /**
     * 
     */
    public EmbeddedRemoteConsole() {
    }


    
    /**
     * @param message 
     */
    public void print(final String message) {
        if (comm != null) {
            comm.sendMessage(EmbeddedConstants.PRINT_START_COMMAND_KEY);
            comm.sendMessage(message);
            comm.sendMessage(EmbeddedConstants.PRINT_END_COMMAND_KEY
                    + EmbeddedConstants.MESSAGE_LINE_DELIMITER);
        }
    }

    
    
    /**
     * @param message 
     */
    public void println(final String message) {
        print(message + EmbeddedConstants.MESSAGE_NEW_LINE + EmbeddedConstants.MESSAGE_LINE_DELIMITER);
    }


    
    /**
     * 
     */
    public void open() {
        comm = EmbeddedPCCommunicator.getInstance();
        comm.sendMessage(EmbeddedConstants.STANDALONE_PROGRAM_MODE_COMMAND_KEY
                + EmbeddedConstants.MESSAGE_LINE_DELIMITER
                + EmbeddedConstants.END_OF_MESSAGE_COMMAND_KEY
                + EmbeddedConstants.MESSAGE_LINE_DELIMITER);
        standaloneMode = true;
        String reply = comm.receiveMessage().toString();
        if (reply.indexOf(EmbeddedConstants.STANDALONE_PROGRAM_MODE_COMMAND_KEY) < 0) {
            close();
        }
    }


    
    /**
     * 
     */
    public void openSJMode() {
        comm = EmbeddedPCCommunicator.getInstance();
    }


    
    /**
     * 
     */
    public void close() {
        if (standaloneMode) {
            comm.sendMessage(EmbeddedConstants.END_OF_MESSAGE_COMMAND_KEY
                    + EmbeddedConstants.MESSAGE_LINE_DELIMITER);
        }
        if (comm != null) {
            comm.destroy();
        }
        comm = null;
    }

}
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

import lejos.nxt.Button;


/**
 * @author root
 *
 */
public class EmbeddedRemoteConsole {

    private EmbeddedPCCommunicator comm = null;

    
    
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
        System.out.println("     ");
        System.out.print("ESTABLISH PC\nCONNECTION?");
        int buttonPressed = Button.waitForPress();
        if (buttonPressed == Button.ID_ESCAPE) {
            System.out.println("  NO");
        } else if (buttonPressed == Button.ID_ENTER) {
            System.out.println("  YES");
            System.out.println("     ");
            System.out.println("Waiting for PC  connection...");
            comm = EmbeddedPCCommunicator.getInstance();
            if (comm.receiveMessage().toString()
                    .indexOf(EmbeddedConstants.EMBEDDED_JAVA_PROGRAM_MODE_COMMAND_KEY) > 0) {
                System.out.println("Connected!");
            } else {
                System.out.println("Connection ERROR");
            }
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
        if (comm != null) {
            comm.destroy();
        }
        comm = null;
    }

}
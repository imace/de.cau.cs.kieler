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


/**
 * @author root
 *
 */
public class RemotePrintReceiver extends Thread {

    private static KlotsConsole console = KlotsConsole.getInstance();
    private static RemotePrintReceiver printerInstance = new RemotePrintReceiver();
    private NXTCommunicator comm;

    
    
    /**
     * 
     */
    public RemotePrintReceiver() {
        this.comm = NXTCommunicator.getInstance();
    }
    
    
    
    /**
     * @return RemotePrintReceiver 
     */
    public static RemotePrintReceiver getInstance() {
        if (printerInstance == null) {
            printerInstance = new RemotePrintReceiver();
        }
        return printerInstance;
    }


    
    /**
     * 
     */
    @Override
    public void run() {
        String line = comm.receiveMessageLine();
        while (!line.equals(KlotsConstants.END_OF_TRANSMISSION_COMMAND_KEY)) {
            if (line.endsWith(KlotsConstants.MESSAGE_NEW_LINE)) {
                console.print(
                        line.replaceFirst(KlotsConstants.PRINT_TAG, "")
                        .replaceFirst(KlotsConstants.MESSAGE_NEW_LINE, "\n")
                        );
            } else {
                console.print(line.replaceFirst(KlotsConstants.PRINT_TAG, ""));
            }
            line = comm.receiveMessageLine();
        }
        comm.closeTransmission(false);
        printerInstance = null;
    }


    
    /**
     * 
     */
    @Override
    public void destroy() {
        comm.closeTransmission(false);
        printerInstance = null;
    }

}
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

import de.cau.cs.kieler.klots.KlotsConnectionException;
import de.cau.cs.kieler.klots.KlotsPlugin;


/**
 * @author root
 *
 */
/**
 * @author root
 *
 */
public class RemotePrintReceiver extends Thread {

    private static KlotsConsole console = KlotsConsole.getInstance();
    private static RemotePrintReceiver printerInstance = new RemotePrintReceiver();
    private NXTCommunicator comm;
    private static boolean isWaiting = false;
    private static boolean isStopping = false;

    
    
    /**
     * 
     */
    public RemotePrintReceiver() {
        this.comm = NXTCommunicator.getInstance();
        isWaiting = false;
        isStopping = false;
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
        try {
            String line = comm.receiveMessageLine();
            while (!isClosing()
                   && !line.equals(KlotsConstants.END_OF_TRANSMISSION_COMMAND_KEY)
                   && line != null) {
                if (line.endsWith(KlotsConstants.MESSAGE_NEW_LINE)) {
                    console.print(
                            line.replaceFirst(KlotsConstants.PRINT_TAG, "")
                            .replaceFirst(KlotsConstants.MESSAGE_NEW_LINE, "\n")
                            );
                } else {
                    console.print(line.replaceFirst(KlotsConstants.PRINT_TAG, ""));
                }
                synchronized (this) {
                    while (isWaiting) {
                        try {
                            wait();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
                line = comm.receiveMessageLine();
            }
        } catch (KlotsConnectionException e) {
            KlotsPlugin.getDefault().showError("Connection Error!", KlotsPlugin.PLUGIN_ID, e, false);
        }
        comm.closeTransmission(false);
        printerInstance = null;
    }


    
    /**
     * @return boolean 
     */
    public static synchronized boolean exists() {
        return (printerInstance != null);
    }
    
    
    
    /**
     * @return boolean 
     */
    public synchronized boolean isPaused() {
       return isWaiting; 
    }
    
    
    
    /**
     * 
     */
    public synchronized void pause() {
        isWaiting = true;
    }
    
    
    
    /**
     * 
     */
    public synchronized void proceed() {
        isWaiting = false;
        if (exists()) {
            notify();
        }
    }
    
    
    
    /**
     * 
     */
    public synchronized void close() {
        isStopping = true;
    }
    
    
    
    /**
     * @return boolean 
     */
    public synchronized boolean isClosing() {
        return isStopping;
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
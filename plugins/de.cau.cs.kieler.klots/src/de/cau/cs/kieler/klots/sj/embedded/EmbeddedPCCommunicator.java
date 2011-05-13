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

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import lejos.nxt.comm.BTConnection;
import lejos.nxt.comm.Bluetooth;



/**
 * @author root
 *
 */
public class EmbeddedPCCommunicator {
    
    private BTConnection btc;
    private DataInputStream dis;
    private DataOutputStream dos;

    private boolean closeTransmissionRequest = false;

    private static final EmbeddedPCCommunicator INSTANCE = new EmbeddedPCCommunicator();


    
    /**
     * 
     */
    public EmbeddedPCCommunicator() {
        btc = Bluetooth.waitForConnection();
        dis = btc.openDataInputStream();
        dos = btc.openDataOutputStream();
    }


    
    /**
     * @return EmbeddedPCCommunicator
     */
    public static EmbeddedPCCommunicator getInstance() {
        return INSTANCE;
    }


    
    /**
     * @param message 
     */
    public void sendMessage(final String message) {
        try {
            dos.writeBytes(message);
            dos.flush();
        } catch (IOException e) {
            e.getMessage();
        }
    }


    
    /**
     * @return StringBuffer 
     */
    public StringBuffer receiveMessage() {
        StringBuffer buf = new StringBuffer();
        try {
            String line = dis.readLine();   // FIXME: Find a way to use BufferedReader.readLine() instead!
            while(!line.equals(EmbeddedConstants.END_OF_MESSAGE_COMMAND_KEY)) {
                buf.append(line);
                if (line.equals(EmbeddedConstants.END_OF_TRANSMISSION_COMMAND_KEY)) {
                    closeTransmissionRequest = true;
                    destroy();
                    return buf;
                }
                line = dis.readLine();   // FIXME: Find a way to use BufferedReader.readLine() instead!
            }
        } catch (IOException ioe) {
            System.out.println("COMM ERR");
        }
        return buf;
    }


    
    /**
     * 
     */
    public void destroy() {
        try {
            if (!closeTransmissionRequest) {
                sendMessage(EmbeddedConstants.END_OF_TRANSMISSION_COMMAND_KEY
                        + EmbeddedConstants.MESSAGE_LINE_DELIMITER);
            }
            dis.close();
            dos.close();
            Thread.sleep(100); // wait for data to drain
            btc.close();
        } catch (IOException e) {
            e.getMessage();
        } catch (InterruptedException ie) {
            ie.getMessage();
        }
    }
    
}
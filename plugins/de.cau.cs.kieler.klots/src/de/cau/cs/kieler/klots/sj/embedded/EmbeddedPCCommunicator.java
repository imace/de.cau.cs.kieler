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

import javax.microedition.io.StreamConnection;

import lejos.nxt.Button;
import lejos.nxt.LCD;
import lejos.nxt.comm.Bluetooth;
import lejos.nxt.comm.USB;



/**
 * @author root
 *
 */
public class EmbeddedPCCommunicator {
    
    private StreamConnection connection;
    private DataInputStream dis;
    private DataOutputStream dos;
    private int protocol = 0;

    private boolean closeTransmissionRequest = false;

    private static final EmbeddedPCCommunicator INSTANCE = new EmbeddedPCCommunicator();
    
    /** The SLEEP_TIME to wait for a connection. */
    private static final int SLEEP_TIME = 1000;

    
    /**
     * 
     */
    public EmbeddedPCCommunicator() {
    }
    
    
    
    /**
     *  
     */
    public void init() {
        if (protocol == EmbeddedConstants.BLUETOOTH_CONNECTION) {
            connection = Bluetooth.waitForConnection();
        } else if (protocol == EmbeddedConstants.USB_CONNECTION) {
            connection = USB.waitForConnection();
        }
        try {
            dis = connection.openDataInputStream();
            dos = connection.openDataOutputStream();
        } catch (Exception e) {
            e.getMessage();
        }
    }
    
    
    
    /**
     * Inits the.
     *
     * @param protocolParam the protocol param
     */
    public void init(final int protocolParam) {
        setProtocol(protocolParam);
        init();
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
    @SuppressWarnings("deprecation")
    public StringBuffer receiveMessage() {
        StringBuffer buf = new StringBuffer();
        try {
            String line = dis.readLine();   
            // FIXME: Find a way to use BufferedReader.readLine() instead!
            while (!line.equals(EmbeddedConstants.END_OF_MESSAGE_COMMAND_KEY)) {
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
     * @param protocol 
     */
    public void setProtocol(final int protocol) {
        if (protocol == EmbeddedConstants.BLUETOOTH_CONNECTION
            || protocol == EmbeddedConstants.USB_CONNECTION) {
            this.protocol = protocol;
        } else {
            LCD.clearDisplay();
            System.out.println("================");
            System.out.println("# FATAL ERROR! #");
            System.out.println("================");
            System.out.println("Connection type ");
            System.out.println("mismatch! Protoc");
            System.out.println("ol type is >" + protocol + "<!");
            System.out.println("Press any button");
            System.out.println("to exit!");
            Button.waitForPress();
            LCD.clearDisplay();
            System.out.println("                ");
            System.out.println("                ");
            System.out.println("----------------");
            System.out.println("EXITING PROGRAM!");
            System.out.println("----------------");
            System.out.println("                ");
            System.out.println("                ");
            System.out.println("                ");
            try {
                java.lang.Thread.sleep(SLEEP_TIME);
            } catch (Exception e) {
                // ignore
            }
            destroy();
            System.exit(0);
        }
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
            Thread.sleep(SLEEP_TIME); // wait for data to drain
            connection.close();
        } catch (IOException e) {
            e.getMessage();
        } catch (InterruptedException ie) {
            ie.getMessage();
        }
    }
    
}
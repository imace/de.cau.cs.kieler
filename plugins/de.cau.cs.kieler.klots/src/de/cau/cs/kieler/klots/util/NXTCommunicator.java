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

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import org.eclipse.jface.preference.IPreferenceStore;

import de.cau.cs.kieler.klots.KlotsConnectionException;
import de.cau.cs.kieler.klots.KlotsPlugin;
import de.cau.cs.kieler.klots.preferences.KlotsPreferenceConstants;

import lejos.pc.comm.NXTCommFactory;
import lejos.pc.comm.NXTConnector;
import lejos.pc.comm.NXTInfo;
import lejos.pc.comm.NXTComm;


/**
 * @author root
 *
 */
public class NXTCommunicator {

    private static boolean consolePrint;

    private static NXTConnector conn;
    private static DataOutputStream dos;
    private static DataInputStream dis;
    private static boolean connected;
    private static NXTInfo nxtInfo;

    /** The instance of the distributor. */
    private static final NXTCommunicator INSTANCE = new NXTCommunicator();

    
    
    /**
     * 
     */
    public NXTCommunicator() {
        NXTCommunicator.updateNXTInfo();
        NXTCommunicator.connectToNXT();
    }


    
    /**
     * @return NXTCommunicator 
     */
    public static NXTCommunicator getInstance() {
        if (!connected) {
            System.out.println("Reconnecting to NXT... ");
            updateNXTInfo();
            connectToNXT();
        }
        return INSTANCE;
    }


    
    private static void connectToNXT() {
        // Connect to any NXT over Bluetooth
        conn = new NXTConnector();        
        boolean connOK = false;
        if (nxtInfo == null) {
            System.out.println("Searching for NXTs... ");
            connOK = conn.connectTo("btspp://", NXTComm.LCP);
        } else {
            System.out.println("Connecting to NXT >" + nxtInfo.name + "< ...");
            //connOK = conn.connectTo(nxtInfo, NXTComm.LCP);
            System.out.println("Connection data: >" + nxtInfo.name + ", " + nxtInfo.deviceAddress
                    + ", " + nxtInfo.protocol + "<");
            connOK = conn.connectTo(nxtInfo.name, nxtInfo.deviceAddress, nxtInfo.protocol);
        }
        if (!connOK) {
            System.out.println();
            System.err.println("Failed to connect to any NXT!");
            return;
        }
        System.out.println("Connected to NXT >" + conn.getNXTInfo().name + "<!");
        nxtInfo = conn.getNXTInfo();
        dos = conn.getDataOut();
        dis = conn.getDataIn();
        connected = true;
        consolePrint = false;
    }


    
    private static void updateNXTInfo() {
        IPreferenceStore prefStore = KlotsPlugin.getDefault().getPreferenceStore();
        nxtInfo = new NXTInfo(
                prefStore.getString(KlotsPreferenceConstants.P_CONNECTION_CONNECTION_TYPE)
                    .equals(KlotsPreferenceConstants.P_CONNECTION_PROTOCOL_USB)
                    ? NXTCommFactory.USB : NXTCommFactory.BLUETOOTH,
                prefStore.getBoolean(KlotsPreferenceConstants.P_CONNECTION_CONNECT_TO_NAMED_BRICK)
                    ? prefStore.getString(KlotsPreferenceConstants.P_CONNECTION_CONNECTION_BRICK_NAME)
                            : null,
                prefStore.getBoolean(KlotsPreferenceConstants.P_CONNECTION_CONNECT_TO_BRICK_ADDRESS)
                    ? prefStore.getString(KlotsPreferenceConstants.P_CONNECTION_CONNECTION_BRICK_ADDRESS)
                            : null);
    }
    
    
    
    /**
     * @return NXTInfo 
     */
    public NXTInfo getNXTInfo() {
        return conn.getNXTInfo();
    }


    
    
    /**
     * @return NXTConnector 
     */
    public NXTConnector getNXTConnector() {
        return conn;
    }


    
    /**
     * @param name 
     * @param address 
     * @param protocol 
     * @return NXTInfo[] 
     */
    public NXTInfo[] searchForNXTs(final String name, final String address, final int protocol) {
        return conn.search(name, address, protocol);
    }
    
    
    
    /**
     * @return NXTInfo[] 
     */
    public NXTInfo[] searchForNXTs() {
        return conn.search(null, null, NXTCommFactory.BLUETOOTH | NXTCommFactory.USB);
    }


    
    /**
     * @return NXTComm 
     */
    public NXTComm getNXTComm() {
        return conn.getNXTComm();
    }


    
    /**
     * @param msg 
     * @return int 
     */
    public int sendMessage(final String msg) {
        System.out.println("[+][+][+][+][+][+][+][+][+] SENDING MESSAGE TO NXT: >" + msg + "<");
        try {
            dos.writeBytes(
                    msg
                    + KlotsConstants.MESSAGE_LINE_DELIMITER
                    + KlotsConstants.END_OF_MESSAGE_COMMAND_KEY
                    + KlotsConstants.MESSAGE_LINE_DELIMITER);
            dos.flush();
            return 0;
        } catch (IOException ioe) {
            System.out.println("IO Exception writing message bytes:");
            System.out.println(ioe.getMessage());
            return 1;
        }
    }


    
    /**
     * @return StringBuffer 
     * @throws KlotsConnectionException 
     */
    public StringBuffer receiveMessage() throws KlotsConnectionException {
        StringBuffer buf = new StringBuffer();
        String line = this.receiveMessageLine();
        while (!line.equals(KlotsConstants.END_OF_MESSAGE_COMMAND_KEY)) {
            // do not process empty lines
            if (!line.equals(KlotsConstants.EMPTY_STRING)) {
                buf.append("{" + line + "},\n");
            }
            line = this.receiveMessageLine();
        }
        return buf.replace(buf.length() - 2, buf.length(), "]").insert(0, "[");
    }

    

    /**
     * @return String 
     * @throws KlotsConnectionException 
     */
    @SuppressWarnings("deprecation")
    public String receiveMessageLine() throws KlotsConnectionException {
        try {
            String line = "";
            try {
                line = dis.readLine();   //FIXME: Find a way to use BufferedReader.readLine() instead!
            } catch (NullPointerException e) {
                System.out.println(";;;;=======;;;; ERROR RECEIVING MESSAGE: NOT CONNECTED!!!");
                throw new KlotsConnectionException("Connection Error!\nKLOTS does not receive any info "
                        + "from the NXT!\nIs your NXT properly connected?", false, null);
            }
            System.out.println(";;;;=======;;;; RECEIVED MESSAGE LINE = >" + line + "<");
            if (line.equals(null)) {
                throw new KlotsConnectionException("Connection Error!\nKLOTS does not receive any info "
                        + "from the NXT!\nIs your NXT properly connected?", false, null);
            }

            // if in 'remote console print' mode
            if (consolePrint) {
                line = KlotsConstants.PRINT_TAG + line;
                if (line.endsWith(KlotsConstants.PRINT_END_COMMAND_KEY)) {
                    line = line.substring(0, line.lastIndexOf(KlotsConstants.PRINT_END_COMMAND_KEY));
                    consolePrint = false;
                }
                return line;
            }

            // if in 'normal' mode
            if (
                 line.startsWith(KlotsConstants.SIGNALS_TAG)
                 || line.startsWith(KlotsConstants.INSTRUCTION_TAG)
                ) {
                line = line.substring(line.indexOf(KlotsConstants.QUOTE_SIGN_CHAR));
                // if line is 'addedSignals:...' or 'removedSignals:...' do not process it
                // the newly added resp. removed signals are processed via the SIGNALS tag
            } else if (line.startsWith(KlotsConstants.PROGRAM_INFO_TAG)) {
                System.out.println(
                        ";;;;=======;;;; LINE CONTAINS THE PROGRAM_INFO TAG => DO NOT PROCESS IT");
                line = "";
                // initiate 'remote console print' mode
            } else if (line.startsWith(KlotsConstants.PRINT_START_COMMAND_KEY)) {
                line = KlotsConstants.PRINT_TAG
                + line.substring(KlotsConstants.PRINT_START_COMMAND_KEY.length());
                consolePrint = true;
                if (line.endsWith(KlotsConstants.PRINT_END_COMMAND_KEY)) {
                    line = line.substring(0, line.lastIndexOf(KlotsConstants.PRINT_END_COMMAND_KEY));
                    consolePrint = false;
                }
            }

            return line;
        } catch (IOException ioe) {
            System.out.println(">>> IO Exception reading message bytes:");
            System.out.println(ioe.getMessage());
            return ioe.getMessage();
        }
    }

    
    
    /**
     * @param notifyCommunicationPartner 
     */
    public void closeTransmission(final boolean notifyCommunicationPartner) {
        try {
            if (notifyCommunicationPartner) {
                sendMessage(KlotsConstants.END_OF_TRANSMISSION_COMMAND_KEY);
            }
            dis.close();
            dos.close();
            conn.close();
            connected = false;
        } catch (IOException ioe) {
            System.out.println("IOException closing connection:");
            System.out.println(ioe.getMessage());
        } catch (NullPointerException npe) {
            System.out.println(">>> Null Pointer Exception while closing connection! "
                + "No connection partner found?!");
        }
    }

}
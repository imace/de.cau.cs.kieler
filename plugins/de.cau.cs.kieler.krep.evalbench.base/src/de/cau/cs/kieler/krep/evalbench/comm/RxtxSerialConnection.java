/*
 * KIELER - Kiel Integrated Environment for Layout Eclipse RichClient
 *
 * http://www.informatik.uni-kiel.de/rtsys/kieler/
 * 
 * Copyright 2009 by
 * + Christian-Albrechts-University of Kiel
 *   + Department of Computer Science
 *     + Real-Time and Embedded Systems Group
 * 
 * This code is provided under the terms of the Eclipse Public License (EPL).
 * See the file epl-v10.html for the license text.
 */

package de.cau.cs.kieler.krep.evalbench.comm;

import java.io.InputStreamReader;
import java.io.OutputStream; //import java.util.Enumeration;
import java.util.LinkedList;

//import de.cau.cs.kieler.krep.evalbench.Activator;

//import gnu.io.*;

/**
 * Wrapper class for the RxTx package.
 * 
 * @author msp
 */
public class RxtxSerialConnection extends Connection {

    /** Baud rate used for serial connection */
    // private final static int BAUD_RATE = 115200;

    /** Instance of the used serial port */
    // private SerialPort serialPort;

    /**
     * Retrieves all available serial ports and returns a list of port names.
     * krep.evalbench.application.product
     * 
     * @return list of port names
     */
    public static String[] getSerialPorts() {
        LinkedList<String> portNames = new LinkedList<String>();
        /*
         * Enumeration<CommPortIdentifier> ports = CommPortIdentifier.getPortIdentifiers(); while
         * (ports.hasMoreElements()) { CommPortIdentifier identifier = ports.nextElement(); if
         * (identifier.getPortType() == CommPortIdentifier.PORT_SERIAL) {
         * portNames.add(identifier.getName()); } }
         */
        //portNames.add("no serial port available");
        return portNames.toArray(new String[portNames.size()]);
    }

    /**
     * @param device name of the serial port 
     * @throws CommunicationException 
     * 
     */
    public RxtxSerialConnection(final String device) throws CommunicationException {
        // TODO: implement
        /*
         * try { CommPortIdentifier portIdentifier = CommPortIdentifier.getPortIdentifier(device);
         * serialPort = (SerialPort)portIdentifier.open(Activator.PLUGIN_ID, 2000);
         * serialPort.setSerialPortParams(BAUD_RATE, SerialPort.DATABITS_8, SerialPort.STOPBITS_1,
         * SerialPort.PARITY_NONE); return "Serial port " + device + " set up for " + BAUD_RATE +
         * " baud, 8 data bits, 1 stop bit, no parity check."; } catch (Exception e) { throw new
         * CommunicationException("Error during initialization of port " + device + ": " +
         * e.getMessage()); }
         */
    }

    /**
     * {@inheritDoc}
     * 
     */
    public void dispose() {
        // serialPort.close();
    }

    /**
     * {@inheritDoc}
     * 
     */
    @Override
    protected InputStreamReader getInput() {
        /*
         * try { return serialPort.getInputStream(); } catch (IOException e) { return null; }
         */
        return null;
    }

    /**
     * {@inheritDoc}
     * 
     */
    @Override
    protected OutputStream getOutput() {
        /*
         * try { return serialPort.getOutputStream(); } catch (IOException e) { return null; }
         */
        return null;
    }
}

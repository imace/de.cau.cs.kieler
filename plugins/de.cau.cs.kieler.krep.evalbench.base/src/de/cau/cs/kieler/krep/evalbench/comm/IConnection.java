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

import java.util.LinkedList;


/**
 * Interface for connection protocol layers like TCP/IP and RS-232.
 * 
 * @kieler.rating 2009-12-10 proposed yellow ctr
 * 
 * @author msp, ctr
 */
public interface IConnection {


    
    /**
     * Closes connection and removes locks on the involved device.
     */
    void dispose();

    /**
     * Sends data to the target.
     * 
     * @param data
     *            data to be sent
     * @throws CommunicationException
     *             when an exception occurs while sending data
     */
    void send(String data) throws CommunicationException;

    /**
     * Sends data to the target.
     * 
     * @param data
     *            data to be sent
     * @throws CommunicationException
     *             when an exception occurs while sending data
     */
    void send(byte data) throws CommunicationException;

    /**
     * Sends data to the target.
     * 
     * @param data
     *            data to be sent
     * @throws CommunicationException
     *             when an exception occurs while sending data
     */
    void send(byte[] data) throws CommunicationException;

    /**
     * Tries to receive a sequence of characters until an exit character is read. The exit character
     * is included in the returned string.
     * 
     * @param exit
     *            the exit character
     * @return received data
     * @throws CommunicationException
     *             when a timeout is reached before the exit character is read
     */
    String receive(char exit) throws CommunicationException;

    /**
     * Tries to receive a fixed number of characters.
     * 
     * @param n
     *            the number of characters to be fetched
     * @return received data
     * @throws CommunicationException
     *             when a timeout is reached before the exit character is read
     */
    String receive(int n) throws CommunicationException;

    /**
     * Tries to receive a fixed number of characters.
     * 
     * @param n
     *            the number of characters to be fetched
     * @return received data
     * @throws CommunicationException
     *             when a timeout is reached before the exit character is read
     */
    LinkedList<Integer> receiveByte(int n) throws CommunicationException;

    /**
     * Harks to incoming data.
     * 
     * @param n
     *            maximal number of characters to receive
     * @return characters received in a specific time range
     * @throws CommunicationException
     *             when an exception occurs while receiving data
     */
    String hark(int n) throws CommunicationException;

    /**
     * Comment on the current communication. This information is used for log Files.
     * 
     * @param comment
     *            the comment to add to the log File
     */
    // void comment(String comment);

}

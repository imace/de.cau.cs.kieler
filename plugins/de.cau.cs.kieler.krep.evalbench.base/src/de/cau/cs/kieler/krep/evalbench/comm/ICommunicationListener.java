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

/**
 * Listener for communication events which occur when data is sent or received.
 * 
 * @kieler.rating 2010-01-28 proposed yellow ctr
 * 
 * @author msp, ctr
 */
public interface ICommunicationListener {

    /**
     * Executed when data is sent to the target.
     * 
     * @param data
     *            data to send
     */
    void dataSent(String data);

    /**
     * Executed when data is received from the target.
     * 
     * @param data
     *            that is received
     */
    void dataReceived(String data);

    /**
     * Write optional comment about the next transaction.
     * 
     * @param comment
     *            that describes the next transaction in the protocol.
     */
    void comment(String comment);

}

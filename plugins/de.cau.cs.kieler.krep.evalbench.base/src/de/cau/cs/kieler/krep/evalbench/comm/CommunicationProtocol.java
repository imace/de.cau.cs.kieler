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

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Abstract class, implements common protocol features.
 * 
 * @kieler.rating 2010-02-05 yellow 
 *   review by cmot, msp, tam
 * 
 * @author msp, ctr
 */
public abstract class CommunicationProtocol implements ICommunicationProtocol {

    /** List of communication listeners. */
    private LinkedList<ICommunicationListener> communicationListeners;

    /** The currently active connection protocol. */
    private IConnection connection;

    /**
     * Constructs a new instance of the KEP protocol.
     * 
     * @param connectionProtocol
     *            underlying connection protocol to be used; this protocol instance is expected to
     *            be already initialized
     */
    protected CommunicationProtocol(final IConnection connectionProtocol) {
        // create list of communication listeners
        setCommunicationListeners(new LinkedList<ICommunicationListener>());
        // store instance of connection protocol
        this.setConnection(connectionProtocol);
    }

    /**
     * Notifies all registered communication listeners about sent data.
     * 
     * @param data
     *            data that was sent
     */
    protected void notifySend(final String data) {
        Iterator<ICommunicationListener> iterator = getCommunicationListeners().iterator();
        while (iterator.hasNext()) {
            iterator.next().dataSent(data);
        }
    }

    /**
     * Notifies all registered communication listeners about received data.
     * 
     * @param data
     *            data that was received
     */
    protected void notifyReceive(final String data) {
        Iterator<ICommunicationListener> iterator = getCommunicationListeners().iterator();
        while (iterator.hasNext()) {
            iterator.next().dataReceived(data);
        }
    }

    /**
     * Notifies all registered communication listeners about a comment.
     * 
     * @param comment
     *            comment about the next transaction
     */
    protected void notifyComment(final String comment) {
        Iterator<ICommunicationListener> iterator = getCommunicationListeners().iterator();
        while (iterator.hasNext()) {
            iterator.next().comment(comment);
        }
    }

    /**
     * {@inheritDoc}
     */
    public void addCommunicationListener(final ICommunicationListener listener) {
        getCommunicationListeners().add(listener);
    }

    /**
     * {@inheritDoc}
     */
    public void removeCommunicationListener(final ICommunicationListener listener) {
        getCommunicationListeners().remove(listener);
    }

    /**
     * @param theCommunicationListeners
     *            the communicationListeners to set
     */
    protected void setCommunicationListeners(
            final LinkedList<ICommunicationListener> theCommunicationListeners) {
        this.communicationListeners = theCommunicationListeners;
    }

    /**
     * @return the communicationListeners
     */
    protected LinkedList<ICommunicationListener> getCommunicationListeners() {
        return communicationListeners;
    }

    /**
     * @param theConnection
     *            the connection to set
     */
    protected void setConnection(final IConnection theConnection) {
        this.connection = theConnection;
    }

    /**
     * @return the connection
     */
    protected IConnection getConnection() {
        return connection;
    }

}

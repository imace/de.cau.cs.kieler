/*
 * KIELER - Kiel Integrated Environment for Layout Eclipse RichClient
 *
 * http://www.informatik.uni-kiel.de/rtsys/kieler/
 *
 * Copyright 2008 by
 * + Christian-Albrechts-University of Kiel
 *   + Department of Computer Science
 *     + Real-Time and Embedded Systems Group
 *
 * This code is provided under the terms of the Eclipse Public License (EPL).
 * See the file epl-v10.html for the license text.
 */

package de.cau.cs.kieler.kwebs.client.ui.testers;

import java.util.Date;

import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;

import de.cau.cs.kieler.kwebs.client.Clients;
import de.cau.cs.kieler.kwebs.client.IWebServiceClient;
import de.cau.cs.kieler.kwebs.client.providers.Providers;
import de.cau.cs.kieler.kwebs.client.providers.Providers.Provider;
import de.cau.cs.kieler.kwebs.util.Uris;

/**
 * Utility class for testing availability of a provider with ui support.
 *
 * @kieler.rating 2011-05-03 red
 *
 * @author swe
 */
public final class Availability {

    /** Number of requests for determining response time. */
    private static final long RESPONSETIME_TESTCOUNT
        = 10;

    /**
     * Tests whether a given provider can be reached.
     * 
     * @param shell
     *            the parent shell for the dialog
     * @param provider
     *            the provider to be tested
     */
    public static void checkAvailability(final Shell shell, final Provider provider) {
        String name = provider.getName();
        String address = provider.getAddress();
        MessageBox box = new MessageBox(shell);
        if (Providers.isValidProvider(provider)) {
            IWebServiceClient client = Clients.createClientForProvider(provider);
            try {
                String version = null;
                Date start = null;
                Date stop = null;
                float responseTime = 0;
                // first call to getVersion() is ignored for response time
                // calculation since it involves establishing the connection
                // and therefore is not representative
                version = client.getVersion();
                start = new Date();
                for (int i = 0; i < RESPONSETIME_TESTCOUNT; i++) {
                    version = client.getVersion();
                }
                stop = new Date();
                responseTime = (stop.getTime() - start.getTime()) / RESPONSETIME_TESTCOUNT;
                box.setText("Provider Details");
                box.setMessage(
                    "The provider is running version "
                    + version
                    + ", the servers response time is "
                    + responseTime
                    + " milliseconds."
                );
                box.open();
            } catch (Exception e) {
                box.setText("Provider not reachable");
                box.setMessage("The Provider you selected is not reachable at the moment.");
                box.open();
            }
        } else {
            if (!Providers.isValidName(name)) {
                box.setText("Invalid Name");
                box.setMessage("The provider name is not valid.");
            } else if (!Uris.isValidURI(address)) {
                box.setText("Invalid Address");
                box.setMessage("The provider address is not valid:\n\n" + address);
            } else if (Uris.isHttpsURI(address)) {
                box.setText("Possibly Security Misconfigured");
                box.setMessage(
                    "Name and address seem to be ok."
                    + " Perhaps your security configuration is not correct?"
                    + " Please check the location of your trust store and the correctness"
                    + " of the given password."
                );
            } 
            box.open();
        }
    }

    /**
     * Private constructor for utility class.
     */
    private Availability() {
    }

}

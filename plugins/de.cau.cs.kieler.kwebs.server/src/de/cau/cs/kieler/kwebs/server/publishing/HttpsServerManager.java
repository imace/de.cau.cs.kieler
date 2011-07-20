/*
 * KIELER - Kiel Integrated Environment for Layout Eclipse RichClient
 *
 * http://www.informatik.uni-kiel.de/rtsys/kieler/
 *
 * Copyright 2008 by
 * + Christian-Albrechts-University of Kiel
 *     + Department of Computer Science
 *         + Real-Time and Embedded Systems Group
 *
 * This code is provided under the terms of the Eclipse Public License (EPL).
 * See the file epl-v10.html for the license text.
 */

package de.cau.cs.kieler.kwebs.server.publishing;

import java.io.FileInputStream;
import java.net.InetSocketAddress;
import java.security.KeyStore;
import java.security.SecureRandom;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;

import com.sun.net.httpserver.HttpsConfigurator;
import com.sun.net.httpserver.HttpsServer;

import de.cau.cs.kieler.kwebs.logging.Logger;
import de.cau.cs.kieler.kwebs.logging.Logger.Severity;
import de.cau.cs.kieler.kwebs.server.configuration.Configuration;
import de.cau.cs.kieler.kwebs.util.Uris;

/**
 * Manager for publishing a service object over HTTPS.
 * Concurrent safety has to be provided by using instance.
 *
 * @author swe
 *
 */
final class HttpsServerManager extends HttpServerManager {

    /** Default host for HTTPS connections. */
    private static final String HTTPS_DEFAULTHOST
        = "0.0.0.0";

    /** Default port for HTTPS connections. */
    private static final int HTTPS_DEFAULTPORT
        = 443;
    
    /**
     * Creates the {@code HttpsServer} instance configured to listen on the host and port specified by
     * the property {@code Configuration.HTTPS_ADDRESS}.
     */
    protected void createServer() {
        if (server != null) {
            throw new AlreadyPublishedException();
        }
        try {
            SSLContext sslContext
                = SSLContext.getInstance("TLS");
            KeyManagerFactory keyManagerFactory
                = KeyManagerFactory.getInstance(
                      KeyManagerFactory.getDefaultAlgorithm()
                  );
            KeyStore keyStore
                = KeyStore.getInstance("JKS");
            TrustManagerFactory trustManagerFactory
                = TrustManagerFactory.getInstance(
                      TrustManagerFactory.getDefaultAlgorithm()
                  );
            String keystoreFile = Configuration.getConfigProperty(
                Configuration.HTTPSKEYSTORE_JKS_PATH
            );
            String keystorePass = Configuration.getConfigProperty(
                Configuration.HTTPSKEYSTORE_JKS_PASS
            );
            keyStore.load(
                new FileInputStream(keystoreFile),
                keystorePass.toCharArray()
            );
            keyManagerFactory.init(
                keyStore, keystorePass.toCharArray()
            );
            trustManagerFactory.init(keyStore);
            sslContext.init(
                keyManagerFactory.getKeyManagers(),
                    trustManagerFactory.getTrustManagers(),
                        new SecureRandom()
            );
            HttpsConfigurator httpsConfigurator
                = new HttpsConfigurator(sslContext);
            String address = Configuration.getConfigProperty(Configuration.HTTPS_ADDRESS);
            String host = Uris.getHost(address);
            if (host == null) {
                Logger.log(Severity.WARNING, 
                    "The host you specified for the HTTPS server is invalid."
                    + " Using default host " + HTTPS_DEFAULTHOST + "."
                );
                host = HTTPS_DEFAULTHOST;
            }
            int port = Uris.getPort(address);
            if (port == -1) {
                Logger.log(Severity.WARNING, 
                    "The port you specified for the HTTPS server is invalid."
                    + " Using default port" + HTTPS_DEFAULTPORT + "."
                );
                port = HTTPS_DEFAULTPORT;
            }
            server = HttpsServer.create(
                new InetSocketAddress(host, port),
                Integer.parseInt(Configuration.getConfigProperty(Configuration.SERVER_BACKLOG))
            );
            ((HttpsServer) server).setHttpsConfigurator(httpsConfigurator);
        } catch (Exception e) {
            Logger.log(Severity.CRITICAL, "HTTPS server could not be created", e);
            throw new ServerNotCreatedException(e);
        }
    }

}

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

package de.cau.cs.kieler.kwebs.server.configuration;

/**
 * This class defines constants and default values for accessing
 * and storing layout service related configuration parameters.
 *
 * @kieler.rating  2011-05-04 red
 * @author  swe
 */
public final class Configuration {

    /** Common prefix for property identifiers. */
    private static final String PREFIX
        = "de.cau.cs.kieler.kwebs.";

    // Properties for HTTP based publishing

    /** Shall service be published via http? */
    public static final String PUBLISH_HTTP
        = PREFIX + "publishHttp";

    /** http service address. */
    public static final String HTTP_ADDRESS
        = PREFIX + "httpAddress";

    // Preferences for HTTPS based publishing

    /** Shall service be published via https? */
    public static final String PUBLISH_HTTPS
        = PREFIX + "publishHttps";

    /** https service address. */
    public static final String HTTPS_ADDRESS
        = PREFIX + "httpsAddress";

    /** Fully qualified path to the JKS formatted key store file. */
    public static final String HTTPSKEYSTORE_JKS_PATH
        = PREFIX + "httpsKeystore.jks.path";

    /** Password for the JKS key store. */
    public static final String HTTPSKEYSTORE_JKS_PASS
        = PREFIX + "httpsKeystore.jks.pass";

    // jETI properties

    /** Shall service be published via jETI? */
    public static final String PUBLISH_JETI
        = PREFIX + "publishJeti";

    /** . */
    public static final String JETI_PROVIDER_ID
        = PREFIX + "jeti.provider.id";

    /** . */
    public static final String JETI_SESSIONSTIMEOUT
        = PREFIX + "jeti.sessions.timeout";

    /** . */
    public static final String JETI_SESSIONSCHECKINTERVAL
        = PREFIX + "jeti.sessions.checkinterval";

    /** . */
    public static final String JETI_DEBUG
        = PREFIX + "jeti.debug";

    /** . */
    public static final String JETI_TOOLXML
        = PREFIX + "jeti.toolxml";

    /** . */
    public static final String JETI_SERVERHOSTNAME
        = PREFIX + "jeti.server.hostname";

    /** . */
    public static final String JETI_CONNECTORSEPPPORT
        = PREFIX + "jeti.connector.sepp.port";

    /** . */
    public static final String JETI_SESSIONSFOLDER
        = PREFIX + "jeti.sessions.folder";
    
    /** . */
    public static final String JETI_LOG4JCONFIG
        = PREFIX + "jeti.log4j.config";

    /** . */
    public static final String JETI_LOGPATH
        = PREFIX + "jeti.logpath";
    
    // Graphviz preferences

    /** Path to the graphviz executable. */
    public static final String GRAPHVIZ_PATH
        = PREFIX + "graphviz.path";

    /** Timeout for graphviz layout processes. */
    public static final String GRAPHVIZ_TIMEOUT
        = PREFIX + "graphviz.timeout";

    // OGDF preferences

    /** Timeout for ogdf layout processes. */
    public static final String OGDF_TIMEOUT
        = PREFIX + "ogdf.timeout";

    // Common preferences

    /** Size of executor pool for http/s server. */
    public static final String SERVER_POOLSIZE
        = PREFIX + "server.poolsize";
    
    /** Size of backlog for http/s server. */
    public static final String SERVER_BACKLOG
        = PREFIX + "server.backlog";

    /** Path to log file. */
    public static final String KWEBS_LOGPATH
        = PREFIX + "log.path";
    
    /** Roundttrip size of log file in mbytes. */
    public static final String KWEBS_LOGSIZE
        = PREFIX + "log.size";
    
    //

    /**
     * This is a container class for configuration identifiers so no
     * instantiation is required.
     */
    private Configuration() {
    }
    

}

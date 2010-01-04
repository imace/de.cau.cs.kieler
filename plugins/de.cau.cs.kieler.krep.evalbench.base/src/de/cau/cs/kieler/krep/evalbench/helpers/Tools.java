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
package de.cau.cs.kieler.krep.evalbench.helpers;

import java.net.URI;
import java.net.URISyntaxException;


/**
 * @author haf,ctr
 * 
 */
public final class Tools {

    private Tools() {
    }

    private static long time;


    /**
     * for time measurement purposes Should be called at start of measuring.
     */
    public static void tic() {
        time = System.currentTimeMillis();
    }

    /**
     * for time measurement purposes.
     * 
     * @return elapsed time since calling tic() in milliseconds.
     */
    public static long tac() {
        return System.currentTimeMillis() - time;
    }

    /**
     * for time measurement purposes.
     * 
     * @return elapsed time since calling tic() in human readable form.
     */
    public static String showTime() {
        long dTime = tac();
        final long sec = 1000;
        final long min = 60 * sec;
        final long hour = 60 * min;

        String res = "";
        if (dTime > hour) {
            res += dTime / hour + "h ";
            dTime = dTime % hour;
        }
        if (dTime > min) {
            res += dTime / min + "m ";
            dTime = dTime % min;
        }
        if (dTime > sec) {
            res += dTime / sec + ".";
            dTime = dTime % sec;
        }
        String ms = String.valueOf(dTime);
        while (ms.length() < "000".length()) {
            ms = "0" + ms;
        }
        res += ms + "s";

        return res;
    }

    /**
     * Takes a URI and exchanges the extension in the path segment with a new
     * one.
     * 
     * @param uri
     *            original uri
     * @param extension
     *            the new extension
     * @return uri with replaced extension
     * @throws URISyntaxException
     *             thrown when generated uri si not valid
     * 
     */
    public static URI exchangeExtension(final URI uri, final String extension)
            throws URISyntaxException {
        String path = uri.getPath();
        int index = path.lastIndexOf('.');
        String pathWithoutExtension = path.substring(0, index);
        String newPath = pathWithoutExtension + '.' + extension;
        // clone uri with adapted path segment
        URI newUri = new URI(uri.getScheme(), uri.getUserInfo(), uri.getHost(),
                uri.getPort(), newPath, uri.getQuery(), uri.getFragment());
        return newUri;
    }

    /**
     * @param i
     *            integer containing a byte
     * @return Hex String for this integer value
     */
    public static String toHex(final int i) {
        String res = Integer.toHexString(i);
        if (res.length() == 1) {
            res = "0" + res;
        }
        return res;
    }

    /**
     * @param name
     *            the name of a file
     * @return the suffix of file, containing its type
     */
    public static String getSuffix(final String name) {
        int pos = name.lastIndexOf('.');
        if (pos == -1) {
            return "";
        } else {
            String res = name.substring(pos);
            return res;
        }
    }

}


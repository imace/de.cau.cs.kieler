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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


/**
 * @author ctr
 * 
 *         Create new thread to print Input Stream to line by line to stdout.
 *         The input stream could come from another process, or an external
 *         program.
 */
public class StreamGobbler extends Thread {
    private InputStream is;

    private String type;

    /**
     * @param input
     *            input stream from which messages are read
     * @param tType
     *            this prefix is written before each line on stdout
     */
    public StreamGobbler(final InputStream input, final String tType) {
        this.is = input;
        this.type = tType;
    }

    @Override
    public final void run() {
        try {
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String line = null;
            while ((line = br.readLine()) != null) {
                System.out.println(type + ">" + line);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}

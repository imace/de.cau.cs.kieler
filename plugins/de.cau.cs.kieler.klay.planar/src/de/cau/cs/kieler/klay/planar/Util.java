/*
 * KIELER - Kiel Integrated Environment for Layout Eclipse RichClient
 *
 * http://www.informatik.uni-kiel.de/rtsys/kieler/
 * 
 * Copyright 2012 by
 * + Christian-Albrechts-University of Kiel
 *   + Department of Computer Science
 *     + Real-Time and Embedded Systems Group
 * 
 * This code is provided under the terms of the Eclipse Public License (EPL).
 * See the file epl-v10.html for the license text.
 */
package de.cau.cs.kieler.klay.planar;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import de.cau.cs.kieler.klay.planar.graph.PGraph;

/**
 * 
 * @author pkl
 */
public final class Util {

    /**
     * Private constructor.
     */
    private Util() {
        // This space intentionally left blank
    }

    // ======================== Debug Files ==========================================
    /**
     * Returns the path for debug output graphs.
     * 
     * @return the path for debug output graphs, without trailing separator.
     */
    public static String getDebugOutputPath() {
        String path = System.getProperty("user.home");
        if (path.endsWith(File.separator)) {
            path += "tmp" + File.separator + "klay";
        } else {
            path += File.separator + "tmp" + File.separator + "klay";
        }

        return path;
    }

    /**
     * Returns the beginning of the file name used for debug output graphs while layouting the given
     * layered graph. This will look something like {@code "143293-"}.
     * 
     * @param graph
     *            the graph to return the base debug file name for.
     * @return the base debug file name for the given graph.
     */
    public static String getDebugOutputFileBaseName(final PGraph graph) {
        return Integer.toString(graph.hashCode() & ((1 << (Integer.SIZE / 2)) - 1)) + "-";
    }

    /**
     * 
     */
    public static void clearTmpDir() {
        String path = Util.getDebugOutputPath();
        for (File innerFile : new File(path).listFiles()) {
            innerFile.delete();
        }

    }

    /**
     * Creates a writer for the given graph. The file name to be written to is assembled from the
     * graph's hash code and the slot index. Writes the graph in a dot output file.
     * 
     * @param graph
     *            the stored graph
     * 
     * @param slotIndex
     *            the slot before whose execution the graph is written
     * 
     * @param directed
     *            if the output graph should be stored as directed graph
     * 
     */
    public static void storeGraph(final PGraph graph, final int slotIndex, final boolean directed) {
        try {
            String path = Util.getDebugOutputPath();
            new File(path).mkdirs();

            String debugFileName = Util.getDebugOutputFileBaseName(graph) + "fulldebug-slot"
                    + String.format("%1$02d", slotIndex);

            graph.writeDotGraph(new FileWriter(new File(path + File.separator + debugFileName
                    + ".dot")), directed);
        } catch (IOException e) {
            // do nothing
        }
    }

}

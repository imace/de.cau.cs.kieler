/*
 * KIELER - Kiel Integrated Environment for Layout Eclipse RichClient
 *
 * http://www.informatik.uni-kiel.de/rtsys/kieler/
 * 
 * Copyright 2010 by
 * + Christian-Albrechts-University of Kiel
 *   + Department of Computer Science
 *     + Real-Time and Embedded Systems Group
 * 
 * This code is provided under the terms of the Eclipse Public License (EPL).
 * See the file epl-v10.html for the license text.
 */

package de.cau.cs.kieler.kaom.importer.ptolemy;


/**
 * Contains constants commonly used in the plug-in. This class is not to be instantiated.
 * 
 * @author cds
 */
public final class PtolemyImporterConstants {
    
    /** The possible extensions for Ptolemy diagram files. */
    public static final String[] PTOLEMY_FILE_EXTENSIONS = {"moml"};
    
    /** Our target file extension. */
    public static final String TARGET_FILE_EXTENSION = "kaom";
    
    
    /**
     * This class is not to be instantiated.
     */
    private PtolemyImporterConstants() {
        // This space intentionally left mostly blank
    }
    
}
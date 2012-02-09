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

package de.cau.cs.kieler.kaom.importer.ptolemy;


/**
 * Contains constants commonly used in the plug-in. This class is not to be instantiated.
 * 
 * @author cds
 */
public final class PtolemyImportConstants {
    
    /**
     * The possible extensions for Ptolemy diagram files.
     */
    public static final String[] PTOLEMY_FILE_EXTENSIONS = {"moml", "xml"}; //$NON-NLS-1$ //$NON-NLS-2$
    
    /**
     * The file extension internally used for temporary Ptolemy model files.
     */
    public static final String PTOLEMY_INTERNAL_FILE_EXTENSION = "moml"; //$NON-NLS-1$
    
    /**
     * Our target file extension for model files.
     */
    public static final String TARGET_MODEL_FILE_EXTENSION = "kaom"; //$NON-NLS-1$
    
    /**
     * Our target file extension for diagram files.
     */
    public static final String TARGET_DIAGRAM_FILE_EXTENSION = "kaod"; //$NON-NLS-1$
    
    
    /**
     * This class is not meant to be instantiated.
     */
    private PtolemyImportConstants() {
        // This space intentionally left mostly blank
    }
    
}

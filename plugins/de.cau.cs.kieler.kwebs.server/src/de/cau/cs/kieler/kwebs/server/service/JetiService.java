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

package de.cau.cs.kieler.kwebs.server.service;

import de.cau.cs.kieler.kwebs.server.layout.ServerLayoutDataService;
import de.cau.cs.kieler.kwebs.service.GraphLayouterOption;
import de.cau.cs.kieler.kwebs.util.Files;
import de.unido.ls5.eti.toolserver.InputFileReference;
import de.unido.ls5.eti.toolserver.OutputFileReference;

/**
 * Implementation of the jeti based layout service.
 * 
 * @kieler.rating  2011-05-04 red
 * @author  swe
 */
public class JetiService extends AbstractService {

    /**
     * Creates an instance of the jeti based layout service. This class is initialized
     * from the jeti tool server every time a layout request is being received.
     */
    public JetiService() {
        ServerLayoutDataService.create();
    }

    /**
     * Does layout on a given graph.
     * 
     * @param inRef
     *            reference to the input file in which the graph to do layout on is stored
     * @param outRef
     *            reference to the output file in which the graph which was layout done 
     *            on is to be stored
     * @param format
     *            the serial format of the graph {@see Formats}
     * @throws Exception
     */
    public final void graphLayout(final InputFileReference inRef,
        final OutputFileReference outRef, final String format) throws Exception {
        graphLayout(inRef, outRef, format, null);
    }

    /**
     * Does layout on a given graph.
     * 
     * @param inRef
     *            reference to the input file in which the graph to do layout on is stored
     * @param outRef
     *            reference to the output file in which the graph which was layout done 
     *            on is to be stored
     * @param format
     *            the serial format of the graph {@see Formats}
     * @param serializedOptions
     *            optional layout options in their serialized form {@see GraphLayouterOption}
     * @throws Exception
     */
    public final void graphLayout(final InputFileReference inRef,
        final OutputFileReference outRef, final String format,
        final String serializedOptions) throws Exception {
        String serializedGraph = Files.readFile(inRef.toString());
        GraphLayouterOption[] options = null;
        if (serializedOptions != null) {
            options = GraphLayouterOption.stringToArray(serializedOptions);
        }
        String serializedResult = layout(serializedGraph, format, options);
        Files.writeFile(outRef.toString(), serializedResult);
    }

    /**
     * Stores the meta data of the layout server in a file. 
     * 
     * @param outRef
     *            reference to the output file
     * @throws Exception
     */
    public final void getCapabilities(final OutputFileReference outRef)
        throws Exception {
        Files.writeFile(
            outRef.toString(),
            ServerLayoutDataService.getCapabilities()
        );
    }

    /**
     * Stores the version of the layout server in a file.
     *  
     * @param outRef
     *            reference to the output file
     * @throws Exception
     */
    public final void getVersion(final OutputFileReference outRef)
        throws Exception {
        Files.writeFile(
            outRef.toString(),
            ServerLayoutDataService.getVersion()
        );
    }

}

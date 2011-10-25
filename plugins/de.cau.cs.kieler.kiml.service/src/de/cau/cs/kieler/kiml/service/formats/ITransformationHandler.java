/*
 * KIELER - Kiel Integrated Environment for Layout Eclipse RichClient
 *
 * http://www.informatik.uni-kiel.de/rtsys/kieler/
 *
 * Copyright 2011 by
 * + Christian-Albrechts-University of Kiel
 *   + Department of Computer Science
 *     + Real-Time and Embedded Systems Group
 *
 * This code is provided under the terms of the Eclipse Public License (EPL).
 * See the file epl-v10.html for the license text.
 */

package de.cau.cs.kieler.kiml.service.formats;

import de.cau.cs.kieler.core.kgraph.KNode;

/**
 * Interface for handlers of graph format transformations. 
 *            
 * @param <T> type of handled graphs
 * @author msp
 */
public interface ITransformationHandler<T> {

    /**
     * Create a graph instance from serial representation. The returned object may actually
     * contain multiple graphs.
     *
     * @param serializedGraph the serialized graph
     * @return the graph instance
     */
    T deserialize(String serializedGraph);

    /**
     * Serialize the given graph instance in the format supported by this transformer.
     *
     * @param graph the graph instance
     *
     * @return serialization of the given graph
     */
    String serialize(T graph);
    
    /**
     * Return a graph transformer for importing graphs into the KGraph format.
     * 
     * @return a KGraph importer
     */
    IGraphTransformer<T, KNode> getImporter();
    
    /**
     * Return a graph transformer for exporting graphs from the KGraph format.
     * 
     * @return a KGraph exporter
     */
    IGraphTransformer<KNode, T> getExporter();

}

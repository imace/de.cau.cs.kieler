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
package de.cau.cs.kieler.kiml.service;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;

import de.cau.cs.kieler.kiml.service.formats.GraphFormatData;
import de.cau.cs.kieler.kiml.service.formats.ITransformationHandler;

/**
 * Service class for graph transformations.
 *
 * @author msp
 */
public abstract class TransformationService {
    
    /** identifier of the extension point for layout info. */
    public static final String EXTP_ID_GRAPH_TRANS = "de.cau.cs.kieler.kiml.service.graphTransformers";
    /** name of the 'handler' element in the 'graph transformer' extension point. */
    public static final String ELEMENT_HANDLER = "handler";
    /** name of the 'class' attribute in the extension points. */
    public static final String ATTRIBUTE_CLASS = "class";
    /** name of the 'description' attribute in the extension points. */
    public static final String ATTRIBUTE_DESCRIPTION = "description";
    /** name of the 'id' attribute in the extension points. */
    public static final String ATTRIBUTE_ID = "id";
    /** name of the 'name' attribute in the extension points. */
    public static final String ATTRIBUTE_NAME = "name";
    
    /** the singleton instance of the transformation service. */
    private static TransformationService instance;
    
    /**
     * Returns the singleton instance of the transformation service.
     * 
     * @return the singleton instance
     */
    public static TransformationService getInstance() {
        return instance;
    }

    /**
     * Protected constructor to enforce instantiation in subclasses.
     */
    protected TransformationService() {
        // the transformation service is supposed to exist exactly once
        instance = this;
    }
    
    /** mapping of graph format identifiers to their meta-data instances. */
    private Map<String, GraphFormatData> graphFormatMap
            = new LinkedHashMap<String, GraphFormatData>();

    /**
     * Report an error that occurred while reading extensions.
     * 
     * @param extensionPoint the identifier of the extension point
     * @param element the configuration element
     * @param attribute the attribute that contains an invalid entry
     * @param exception an optional exception that was caused by the invalid entry
     */
    protected abstract void reportError(String extensionPoint, IConfigurationElement element,
            String attribute, Throwable exception);

    /**
     * Report an error that occurred while reading extensions.
     * 
     * @param exception a core exception holding a status with further information
     */
    protected abstract void reportError(CoreException exception);
    
    /**
     * Loads and registers all graph transformer extensions from the extension point.
     */
    protected final void loadGraphTransExtensions() {
        IConfigurationElement[] extensions = Platform.getExtensionRegistry()
                .getConfigurationElementsFor(EXTP_ID_GRAPH_TRANS);

        for (IConfigurationElement element : extensions) {
            if (ELEMENT_HANDLER.equals(element.getName())) {
                // register a transformation handler from the extension
                try {
                    ITransformationHandler<?> handler = (ITransformationHandler<?>)
                            element.createExecutableExtension(ATTRIBUTE_CLASS);
                    String id = element.getAttribute(ATTRIBUTE_ID);
                    String name = element.getAttribute(ATTRIBUTE_NAME);
                    if (handler == null) {
                        reportError(EXTP_ID_GRAPH_TRANS, element, ATTRIBUTE_CLASS, null);
                    } else if (id == null || id.length() == 0) {
                        reportError(EXTP_ID_GRAPH_TRANS, element, ATTRIBUTE_ID, null);
                    } else if (name == null || name.length() == 0) {
                        reportError(EXTP_ID_GRAPH_TRANS, element, ATTRIBUTE_NAME, null);
                    } else {
                        GraphFormatData formatData = new GraphFormatData();
                        formatData.setId(id);
                        formatData.setName(name);
                        formatData.setDescription(element.getAttribute(ATTRIBUTE_DESCRIPTION));
                        formatData.setHandler(handler);
                        graphFormatMap.put(id, formatData);
                    }
                } catch (CoreException exception) {
                    reportError(exception);
                }
            }
        }
    }
    
    /**
     * Returns the graph format data for the given identifier.
     * 
     * @param id a graph format identifier
     * @return the corresponding identifier
     */
    public GraphFormatData getFormatData(final String id) {
        return graphFormatMap.get(id);
    }
    
    /**
     * Returns all registered graph format data. 
     * 
     * @return a collection of graph format data
     */
    public Collection<GraphFormatData> getFormatData() {
        return Collections.unmodifiableCollection(graphFormatMap.values());
    }

}

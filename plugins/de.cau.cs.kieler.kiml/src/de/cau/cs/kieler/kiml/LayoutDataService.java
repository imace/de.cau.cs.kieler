/*
 * KIELER - Kiel Integrated Environment for Layout Eclipse RichClient
 *
 * http://www.informatik.uni-kiel.de/rtsys/kieler/
 * 
 * Copyright 2008 by
 * + Christian-Albrechts-University of Kiel
 *   + Department of Computer Science
 *     + Real-Time and Embedded Systems Group
 * 
 * This code is provided under the terms of the Eclipse Public License (EPL).
 * See the file epl-v10.html for the license text.
 */
package de.cau.cs.kieler.kiml;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;

import de.cau.cs.kieler.core.util.Pair;
import de.cau.cs.kieler.kiml.options.LayoutOptions;

/**
 * Singleton class for access to the KIML layout data. This class is used
 * globally to retrieve data for automatic layout through KIML. The class cannot
 * be instantiated directly, but only through a subclass that calls
 * {@link createLayoutServices()}. The subclass is then responsible to add
 * appropriate data to the nested registry instance.
 * 
 * @kieler.rating 2011-03-14 yellow
 *     reviewed by cmot, cds
 * @author msp
 */
public class LayoutDataService {

    /** identifier of the 'general' diagram type, which applies to all diagrams. */
    public static final String DIAGRAM_TYPE_GENERAL = "de.cau.cs.kieler.layout.diagrams.general";

    /** the singleton instance of the layout service. */
    private static LayoutDataService instance = null;

    /** the instance of the registry class. */
    private Registry registry = null;
    /** mapping of layout provider identifiers to their data instances. */
    private Map<String, LayoutAlgorithmData> layoutAlgorithmMap
            = new LinkedHashMap<String, LayoutAlgorithmData>();
    /** mapping of layout option identifiers to their data instances. */
    private Map<String, LayoutOptionData<?>> layoutOptionMap
            = new LinkedHashMap<String, LayoutOptionData<?>>();
    /** mapping of layout type identifiers to their data instances. */
    private Map<String, LayoutTypeData> layoutTypeMap
            = new LinkedHashMap<String, LayoutTypeData>();
    /** mapping of category identifiers to their names. */
    private Map<String, String> categoryMap = new HashMap<String, String>();
    /** mapping of diagram type identifiers to their names. */
    private Map<String, String> diagramTypeMap = new LinkedHashMap<String, String>();
    /** mapping of object identifiers to associated options. */
    private Map<String, Map<String, Object>> id2OptionsMap
            = new HashMap<String, Map<String, Object>>();
    /** mapping of domain class names to semantic layout configurations. */
    private Map<String, SemanticLayoutConfig> semanticConfigMap
            = new HashMap<String, SemanticLayoutConfig>();

    /**
     * The default constructor is hidden to prevent others from instantiating
     * this singleton class.
     */
    protected LayoutDataService() {
    }

    /**
     * Creates an instance of the layout services and assigns the singleton
     * instance of the registry.
     */
    public static void createLayoutServices() {
        instance = new LayoutDataService();
        instance.registry = instance.new Registry();
    }
    
    /**
     * Sets a layout services instance created by a specific subclass and assigns
     * the singleton instance of the registry.
     * 
     * @param subclassInstance an instance created by a subclass
     */
    protected static void createLayoutServices(final LayoutDataService subclassInstance) {
        instance = subclassInstance;
        instance.registry = instance.new Registry();
    }

    /**
     * Returns the singleton instance of the layout services class.
     * 
     * @return the singleton instance, or {@code null} if no instance has been created yet
     */
    public static LayoutDataService getInstance() {
        return instance;
    }

    /**
     * Returns the singleton instance of the registry class.
     * 
     * @return the singleton registry
     */
    public static final Registry getRegistry() {
        return instance.registry;
    }

    /** Class used to register the layout services. */
    public final class Registry {

        /**
         * The default constructor is hidden to prevent others from
         * instantiating this singleton class.
         */
        private Registry() {
        }

        /**
         * Registers the given layout provider. If there is already a registered
         * provider data instance with the same identifier, it is overwritten.
         * 
         * @param providerData data instance of the layout provider to register
         */
        public void addLayoutProvider(final LayoutAlgorithmData providerData) {
            if (layoutAlgorithmMap.containsKey(providerData.getId())) {
                layoutAlgorithmMap.remove(providerData.getId());
            }
            layoutAlgorithmMap.put(providerData.getId(), providerData);
        }

        /**
         * Registers the given layout option. If there is already a registered
         * option data instance with the same identifier, it is overwritten.
         * 
         * @param optionData data instance of the layout option to register
         */
        public void addLayoutOption(final LayoutOptionData<?> optionData) {
            if (layoutOptionMap.containsKey(optionData.getId())) {
                layoutOptionMap.remove(optionData.getId());
            }
            layoutOptionMap.put(optionData.getId(), optionData);
        }

        /**
         * Registers the given layout type. If there is already a registered layout
         * type instance with the same identifier, it is overwritten, but its
         * contained layouters are copied.
         * 
         * @param typeData data instance of the layout type to register
         */
        public void addLayoutType(final LayoutTypeData typeData) {
            LayoutTypeData oldData = layoutTypeMap.get(typeData.getId());
            if (oldData != null) {
                typeData.getLayouters().addAll(oldData.getLayouters());
                layoutTypeMap.remove(typeData.getId());
            }
            layoutTypeMap.put(typeData.getId(), typeData);
        }

        /**
         * Registers the given category.
         * 
         * @param id identifier of the category
         * @param name user friendly name of the category
         */
        public void addCategory(final String id, final String name) {
            categoryMap.put(id, name);
        }

        /**
         * Registers the given diagram type.
         * 
         * @param id identifier of the diagram type
         * @param name user friendly name of the diagram type
         */
        public void addDiagramType(final String id, final String name) {
            diagramTypeMap.put(id, name);
        }
        
        /**
         * Adds the given option as default for an object identifier.
         * 
         * @param id identifier of the object to register
         * @param optionId identifier of a layout option
         * @param value value for the layout option
         */
        public void addOption(final String id, final String optionId,
                final Object value) {
            Map<String, Object> optionsMap = id2OptionsMap.get(id);
            if (optionsMap == null) {
                optionsMap = new LinkedHashMap<String, Object>();
                id2OptionsMap.put(id, optionsMap);
            }
            optionsMap.put(optionId, value);
        }
        
        /**
         * Remove the value of the given option.
         * 
         * @param id identifier of the object for which an option shall be removed
         * @param optionId identifier of a layout option
         */
        public void removeOption(final String id, final String optionId) {
            Map<String, Object> optionsMap = id2OptionsMap.get(id);
            if (optionsMap != null) {
                optionsMap.remove(optionId);
            }
        }
        
        /**
         * Registers the given semantic layout configuration.
         * 
         * @param clazzName domain model class name for which to register the configuration
         * @param config a semantic layout configuration
         */
        public void addSemanticConfig(final String clazzName, final SemanticLayoutConfig config) {
            semanticConfigMap.put(clazzName, config);
        }

    }

    /**
     * Returns the layout algorithm data associated with the given identifier.
     * 
     * @param id layout algorithm identifier
     * @return the corresponding layout algorithm data, or {@code null} if there
     *         is no algorithm with the given identifier
     */
    public final LayoutAlgorithmData getAlgorithmData(final String id) {
        return layoutAlgorithmMap.get(id);
    }

    /**
     * Returns a data collection for all registered layout algorithms. The collection
     * is unmodifiable.
     * 
     * @return collection of registered layout algorithms
     */
    public final Collection<LayoutAlgorithmData> getAlgorithmData() {
        return Collections.unmodifiableCollection(layoutAlgorithmMap.values());
    }

    /**
     * Returns the layout option data associated with the given identifier.
     * 
     * @param id layout option identifier
     * @return the corresponding layout option data, or {@code null} if there is
     *         no option with the given identifier
     */
    public final LayoutOptionData<?> getOptionData(final String id) {
        return layoutOptionMap.get(id);
    }

    /**
     * Returns a data collection for all registered layout options. The collection is
     * unmodifiable.
     * 
     * @return collection of registered layout options
     */
    public final Collection<LayoutOptionData<?>> getOptionData() {
        return Collections.unmodifiableCollection(layoutOptionMap.values());
    }

    /**
     * Returns a list of layout options that are suitable for the given layout
     * algorithm and layout option target. The layout algorithm must know the
     * layout options and at the target must be active for each option.
     * 
     * @param algorithmData layout algorithm data
     * @param targetType type of layout option target
     * @return list of suitable layout options
     */
    public final List<LayoutOptionData<?>> getOptionData(final LayoutAlgorithmData algorithmData,
            final LayoutOptionData.Target targetType) {
        List<LayoutOptionData<?>> optionDataList = new LinkedList<LayoutOptionData<?>>();
        for (LayoutOptionData<?> optionData : layoutOptionMap.values()) {
            if (algorithmData.knowsOption(optionData)
                    || LayoutOptions.ALGORITHM_ID.equals(optionData.getId())) {
                if (optionData.hasTarget(targetType)) {
                    optionDataList.add(optionData);
                }
            }
        }
        return optionDataList;
    }

    /**
     * Returns the data instance of the layout type with given identifier.
     * 
     * @param id identifier of the type
     * @return layout type data instance with given identifier, or {@code null} if the layout
     *         type is not registered
     */
    public final LayoutTypeData getTypeData(final String id) {
        return layoutTypeMap.get(id);
    }
    
    /**
     * Returns a list of layout type identifiers and names. The first string in each
     * entry is the identifier, and the second string is the name.
     * 
     * @return a list of all layout types
     */
    public final Collection<LayoutTypeData> getTypeData() {
        return Collections.unmodifiableCollection(layoutTypeMap.values());
    }

    /**
     * Returns the name of the given category.
     * 
     * @param id identifier of the category
     * @return user friendly name of the category, or {@code null} if there
     *         is no category with the given identifier
     */
    public final String getCategoryName(final String id) {
        return categoryMap.get(id);
    }

    /**
     * Returns the name of the given diagram type.
     * 
     * @param id identifier of the diagram type
     * @return user friendly name of the diagram type, or {@code null} if there
     *         is no diagram type with the given identifier
     */
    public final String getDiagramTypeName(final String id) {
        return diagramTypeMap.get(id);
    }

    /**
     * Returns a collection of registered diagram types. The first element of each
     * returned entry is a diagram type identifier, the second element is the
     * corresponding name.
     * 
     * @return the registered diagram types
     */
    public final List<Pair<String, String>> getDiagramTypes() {
        return Pair.fromMap(diagramTypeMap);
    }
    
    /**
     * Returns a map that contains all layout option values for an object identifier.
     * 
     * @param objectId an object identifier, such as an edit part class name, a domain model
     *     class name, or a diagram type id
     * @return a map of layout option identifiers to their values
     */
    public final Map<String, Object> getOptions(final String objectId) {
        Map<String, Object> optionsMap = id2OptionsMap.get(objectId);
        if (optionsMap != null) {
            return Collections.unmodifiableMap(optionsMap);
        }
        return Collections.emptyMap();
    }

    /**
     * Retrieves a layout option value for an object identifier.
     * 
     * @param objectId an object identifier, such as an edit part class name, a domain model
     *     class name, or a diagram type id
     * @param optionId a layout option identifier
     * @return the preconfigured value of the option, or {@code null} if the
     *         option is not set for the given object
     */
    public final Object getOption(final String objectId, final String optionId) {
        Map<String, Object> optionsMap = id2OptionsMap.get(objectId);
        if (optionsMap != null) {
            return optionsMap.get(optionId);
        }
        return null;
    }
    
    /**
     * Returns a map that contains all layout option values for a domain model class. This
     * involves options that are set for any superclass of the given one.
     * 
     * @param clazz a domain model class
     * @return a map of layout option identifiers to their values
     */
    public final Map<String, Object> getOptions(final EClass clazz) {
        if (clazz != null) {
            HashMap<String, Object> options = new HashMap<String, Object>();
            LinkedList<EClass> classes = new LinkedList<EClass>();
            classes.add(clazz);
            do {
                EClass c = classes.removeFirst();
                Map<String, Object> optionsMap = id2OptionsMap.get(c.getInstanceTypeName());
                if (optionsMap != null) {
                    options.putAll(optionsMap);
                }
                classes.addAll(c.getESuperTypes());
            } while (!classes.isEmpty());
            return options;
        }
        return Collections.emptyMap();
    }
    
    /**
     * Retrieves a layout option value for a domain model class. This involves options
     * that are set for any superclass of the given one.
     * 
     * @param clazz a domain model class
     * @param optionId a layout option identifier
     * @return the option value for the class or a superclass, or {@code null} if the option
     *     is not set for the class
     */
    public final Object getOption(final EClass clazz, final String optionId) {
        if (clazz != null) {
            LinkedList<EClass> classes = new LinkedList<EClass>();
            classes.add(clazz);
            do {
                EClass c = classes.removeFirst();
                Map<String, Object> optionsMap = id2OptionsMap.get(c.getInstanceTypeName());
                if (optionsMap != null) {
                    Object value = optionsMap.get(optionId);
                    if (value != null) {
                        return value;
                    }
                }
                classes.addAll(c.getESuperTypes());
            } while (!classes.isEmpty());
        }
        return null;
    }
    
    /**
     * Return the semantic layout configurations that are associated with the given domain model
     * class. This involves configurations that are set for any superclass of the given one.
     * 
     * @param clazz a domain model class
     * @return the semantic layout configurations for the class or a superclass
     */
    public final List<SemanticLayoutConfig> getSemanticConfigs(final EClass clazz) {
        if (clazz != null) {
            List<SemanticLayoutConfig> configs = new LinkedList<SemanticLayoutConfig>();
            LinkedList<EClass> classes = new LinkedList<EClass>();
            classes.add(clazz);
            do {
                EClass c = classes.removeFirst();
                SemanticLayoutConfig config = semanticConfigMap.get(c.getInstanceTypeName());
                if (config != null) {
                    configs.add(config);
                }
                classes.addAll(c.getESuperTypes());
            } while (!classes.isEmpty());
            return configs;
        }
        return Collections.emptyList();
    }

}
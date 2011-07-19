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

import de.cau.cs.kieler.kiml.options.LayoutOptions;

/**
 * Singleton class for access to the KIML layout data. This class is used globally to retrieve data
 * for automatic layout through KIML. The class cannot be instantiated directly, but only through a
 * subclass that calls {@link createLayoutServices()}. The subclass is then responsible to add
 * appropriate data to the nested registry instance. Multiple instances of subclasses can register
 * themselves by calling {@link createLayoutServices(subInstance)}, where subInstance is the
 * instance of the subclass, but only one instance per subclass is allowed. Registering another
 * instance will overwrite the prior instance. The different instances are identified by class name
 * and the currently used instance can be determined by calling {@link getMode()}. You can switch
 * between the different instances by calling {@link setMode(final Class<? extends
 * LayoutDataService> clas)} or {@link setMode(final Object object)}, where {@code object} has to be
 * an instance of a subclass of {@code LayoutDataService}.
 *
 * @kieler.rating 2011-03-14 yellow reviewed by cmot, cds
 * @author msp
 * @author swe
 */
public class LayoutDataService {

    /** identifier of the 'general' diagram type, which applies to all diagrams. */
    public static final String DIAGRAM_TYPE_GENERAL = "de.cau.cs.kieler.layout.diagrams.general";

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

    /** Mode constant for local data service instance. */
    public static final String ECLIPSEDATASERVICE
        = "de.cau.cs.kieler.kiml.ui.service.EclipseLayoutDataService"; //$NON-NLS-1$

    /** Mode constant for remote data service instance. */
    public static final String REMOTEDATASERVICE
        = "de.cau.cs.kieler.kwebs.client.layout.RemoteLayoutDataService"; //$NON-NLS-1$

    /** Mode constant for server data service instance. */
    public static final String SERVICEDATASERVICE
        = "de.cau.cs.kieler.kwebs.server.layout.ServerLayoutDataService"; //$NON-NLS-1$

    /** The list of valid layout data service identifiers. */
    private static List<String> validDataServices
        = new LinkedList<String>();

    /** Filling the identifier list. */
    static {
        validDataServices.add(ECLIPSEDATASERVICE);
        validDataServices.add(REMOTEDATASERVICE);
        validDataServices.add(SERVICEDATASERVICE);
    }

    /** Map of registered data services indexed by class name. */
    private static Map<String, LayoutDataService> instances
        = new HashMap<String, LayoutDataService>();

    /** the the currently used layout data service. */
    private static LayoutDataService current;

    /**
     * The default constructor is hidden to prevent others from instantiating this class.
     */
    protected LayoutDataService() {
    }

    /**
     *
     * @param object
     * @return
     */
    private static String getType(final Object object) {
        String type = null;
        if (object != null) {
            type = object.getClass().getCanonicalName();
        }
        return type;
    }

    /**
     * Registers a layout data service instance created by a specific subclass and assigns it an
     * instance of the registry.
     *
     * @param subInstance
     *            an instance created by a subclass
     */
    protected static synchronized void addService(final LayoutDataService subInstance) {
        String type = getType(subInstance);
        if (validDataServices.contains(type)) {
            if (!instances.containsKey(type)) {
                if (current == null) {
                    current = subInstance;
                }
                subInstance.registry = subInstance.new Registry();
                instances.put(type, subInstance);
            }
        }
    }

    /**
     * Removes a layout data service instance. The instance belonging to the currently selected
     * mode can not be removed.
     *
     * @param subInstance
     *            the sub instance to be removed
     * @throws IllegalArgumentException
     *             if the instance belonging to the currently selected mode is to be removed or
     *             the sub instance is not supported
     */
    public static synchronized void removeService(final LayoutDataService subInstance) {
        String type = getType(subInstance);
        if (!validDataServices.contains(type)) {
            throw new IllegalArgumentException(
                        "Layout data service instance of class " //$NON-NLS-1$
        		+ type
        		+ " not supported" //$NON-NLS-1$
        	);
        }
        if (subInstance == current) {
        	throw new IllegalArgumentException(
        		"Currently active layout data service cant be removed" //$NON-NLS-1$
        	);
        }
        instances.remove(type);        
    }

    /**
     * Returns the current operation mode of the layout data service. The returned
     * mode is either {@code LayoutDataService.ECLIPSEDATASERVICE},
     * {@code LayoutDataService.REMOTEDATASERVICE} or
     * {@code LayoutDataService.SERVERDATASERVICE} or {@code null} if no layout data service has
     * been registered yet.
     *
     * @return the mode of operation or {@code null}
     */
    public static synchronized String getMode() {
        return (current != null ? getType(current) : null);
    }

    /**
     * Sets the mode to {@code mode} where {@code mode} has to be an element of
     * {@code LayoutDataService.ECLIPSEDATASERVICE}, {@code LayoutDataService.REMOTEDATASERVICE} or
     * {@code LayoutDataService.SERVERDATASERVICE}.
     *
     * @param mode
     *            the mode to be set
     * 
     * @throws IllegalArgumentException
     *            if the given mode is not valid or the according layout data service has
     *            not been registered yet
     */
    public static synchronized void setMode(final String mode) {
        if (validDataServices.contains(mode) 
        	&& instances.containsKey(mode)) {
            current = instances.get(mode);
        } else {
        	throw new IllegalArgumentException(
        		"Mode " //$NON-NLS-1$ 
        		+ mode 
        		+ " not supported or layout data service was not" //$NON-NLS-1$
        		+ " registered before" //$NON-NLS-1$        		
        	);
        }
    }

    /**
     * Returns the layout data service instance belonging to the currently selected mode.
     *
     * @return the layout data service instance belonging to the currently selected mode
     */
    public static LayoutDataService getInstance() {
        return current;
    }

    /**
     *
     * @param <T>
     * @param type
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T extends LayoutDataService> T getInstanceOf(final String type) {
        if (validDataServices.contains(type)
        	&& instances.containsKey(type)) {
            return (T) instances.get(type);
        }
        return null;
    }

    /**
     * Returns the instance of the registry class associated with the current layout data service.
     *
     * @return the registry instance, or {@code null} if either no layout data service has been
     *         registered yet or it has been removed
     */
    public static final Registry getRegistry() {
        if (current != null) {
            return current.registry;
        }
        return null;
    }

    /** Class used to register the layout services. */
    public final class Registry {

        /**
         * The default constructor is hidden to prevent others from instantiating this class.
         */
        private Registry() {
        }

        /**
         * Registers the given layout provider. If there is already a registered provider data
         * instance with the same identifier, it is overwritten.
         *
         * @param providerData
         *            data instance of the layout provider to register
         */
        public void addLayoutProvider(final LayoutAlgorithmData providerData) {
            if (layoutAlgorithmMap.containsKey(providerData.getId())) {
                layoutAlgorithmMap.remove(providerData.getId());
            }
            layoutAlgorithmMap.put(providerData.getId(), providerData);
        }

        /**
         * Registers the given layout option. If there is already a registered option data instance
         * with the same identifier, it is overwritten.
         *
         * @param optionData
         *            data instance of the layout option to register
         */
        public void addLayoutOption(final LayoutOptionData<?> optionData) {
            if (layoutOptionMap.containsKey(optionData.getId())) {
                layoutOptionMap.remove(optionData.getId());
            }
            layoutOptionMap.put(optionData.getId(), optionData);
        }

        /**
         * Registers the given layout type. If there is already a registered layout type instance
         * with the same identifier, it is overwritten, but its contained layouters are copied.
         *
         * @param typeData
         *            data instance of the layout type to register
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
         * @param id
         *            identifier of the category
         * @param name
         *            user friendly name of the category
         */
        public void addCategory(final String id, final String name) {
            categoryMap.put(id, name);
        }

    }

    /**
     * Returns the layout algorithm data associated with the given identifier.
     *
     * @param id
     *            layout algorithm identifier
     * @return the corresponding layout algorithm data, or {@code null} if there is no algorithm
     *         with the given identifier
     */
    public final LayoutAlgorithmData getAlgorithmData(final String id) {
        return layoutAlgorithmMap.get(id);
    }

    /**
     * Returns a data collection for all registered layout algorithms. The collection is
     * unmodifiable.
     *
     * @return collection of registered layout algorithms
     */
    public final Collection<LayoutAlgorithmData> getAlgorithmData() {
        return Collections.unmodifiableCollection(layoutAlgorithmMap.values());
    }

    /**
     * Returns the layout option data associated with the given identifier.
     *
     * @param id
     *            layout option identifier
     * @return the corresponding layout option data, or {@code null} if there is no option with the
     *         given identifier
     */
    public final LayoutOptionData<?> getOptionData(final String id) {
        return layoutOptionMap.get(id);
    }

    /**
     * Returns a data collection for all registered layout options. The collection is unmodifiable.
     *
     * @return collection of registered layout options
     */
    public final Collection<LayoutOptionData<?>> getOptionData() {
        return Collections.unmodifiableCollection(layoutOptionMap.values());
    }

    /**
     * Returns a list of layout options that are suitable for the given layout algorithm and layout
     * option target. The layout algorithm must know the layout options and at the target must be
     * active for each option.
     *
     * @param algorithmData
     *            layout algorithm data
     * @param targetType
     *            type of layout option target
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
     * @param id
     *            identifier of the type
     * @return layout type data instance with given identifier, or {@code null} if the layout type
     *         is not registered
     */
    public final LayoutTypeData getTypeData(final String id) {
        return layoutTypeMap.get(id);
    }

    /**
     * Returns a list of layout type identifiers and names. The first string in each entry is the
     * identifier, and the second string is the name.
     *
     * @return a list of all layout types
     */
    public final Collection<LayoutTypeData> getTypeData() {
        return Collections.unmodifiableCollection(layoutTypeMap.values());
    }

    /**
     * Returns the name of the given category.
     *
     * @param id
     *            identifier of the category
     * @return user friendly name of the category, or {@code null} if there is no category with the
     *         given identifier
     */
    public final String getCategoryName(final String id) {
        return categoryMap.get(id);
    }

}

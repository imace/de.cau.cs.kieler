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
package de.cau.cs.kieler.kiml.ui.layout;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.StringTokenizer;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.ui.statushandlers.StatusManager;

import de.cau.cs.kieler.core.model.GraphicalFrameworkService;
import de.cau.cs.kieler.core.model.IGraphicalFrameworkBridge;
import de.cau.cs.kieler.core.util.Pair;
import de.cau.cs.kieler.kiml.LayoutOptionData;
import de.cau.cs.kieler.kiml.LayoutAlgorithmData;
import de.cau.cs.kieler.kiml.LayoutDataService;
import de.cau.cs.kieler.kiml.SemanticLayoutConfig;
import de.cau.cs.kieler.kiml.service.ExtensionLayoutDataService;
import de.cau.cs.kieler.kiml.ui.EclipseLayoutAlgorithmData;
import de.cau.cs.kieler.kiml.ui.KimlUiPlugin;

/**
 * A special layout data service for use in an Eclipse instance.
 * 
 * @kieler.rating 2009-12-11 proposed yellow msp
 * @author msp
 */
public class EclipseLayoutDataService extends ExtensionLayoutDataService {

    /** identifier of the extension point for layout info. */
    public static final String EXTP_ID_LAYOUT_INFO = "de.cau.cs.kieler.kiml.layoutInfo";
    /** identifier of the extension point for layout managers. */
    public static final String EXTP_ID_LAYOUT_MANAGERS = "de.cau.cs.kieler.kiml.ui.layoutManagers";
    /** name of the 'binding' element in the 'layout info' extension point. */
    public static final String ELEMENT_BINDING = "binding";
    /** name of the 'manager' element in the 'layout managers' extension point. */
    public static final String ELEMENT_MANAGER = "manager";
    /** name of the 'option' element in the 'layout info' extension point. */
    public static final String ELEMENT_OPTION = "option";
    /** name of the 'semantic option' element in the 'layout info' extension point. */
    public static final String ELEMENT_SEMANTIC_OPTION = "semanticOption";
    /** name of the 'config' attribute in the extension points. */
    public static final String ATTRIBUTE_CONFIG = "config";
    /** name of the 'preview' attribute in the extension points. */
    public static final String ATTRIBUTE_PREVIEW = "preview";
    /** name of the 'value' attribute in the extension points. */
    public static final String ATTRIBUTE_VALUE = "value";

    /** preference identifier for the list of registered diagram elements. */
    public static final String PREF_REG_ELEMENTS = "kiml.reg.elements";
    /** preference identifier for oblique edge routing. */
    public static final String PREF_OBLIQUE_ROUTE = "kiml.oblique.route";
    
    /** list of registered diagram layout managers. */
    private final List<DiagramLayoutManager<?>> managers = new LinkedList<DiagramLayoutManager<?>>();
    /** set of registered diagram elements. */
    private Set<String> registeredElements = new HashSet<String>();
    /** list of default options read from the extension point. */
    private List<String[]> defaultOptions = new LinkedList<String[]>();

    /**
     * Builds the layout services for the Eclipse platform.
     */
    public static void createLayoutServices() {
        // create instance of the layout service holder class
        EclipseLayoutDataService layoutServices = new EclipseLayoutDataService();
        LayoutDataService.createLayoutServices(layoutServices);
        // build layout services for all extension points
        layoutServices.loadLayoutProviderExtensions();
        layoutServices.loadLayoutInfoExtensions();
        layoutServices.loadLayoutManagerExtensions();
        layoutServices.loadDefaultOptions();
        // load preferences for KIML
        layoutServices.loadPreferences();
    }
    
    /**
     * Returns the singleton instance as Eclipse layout services.
     * 
     * @return the singleton instance, or {@code null} if the instance is not
     *         of Eclipse layout services
     */
    public static EclipseLayoutDataService getInstance() {
        LayoutDataService instance = LayoutDataService.getInstance();
        if (instance instanceof EclipseLayoutDataService) {
            return (EclipseLayoutDataService) instance;
        } else {
            return null;
        }
    }
    
    /**
     * Returns the most suitable layout manager for the given workbench and diagram part.
     * 
     * @param workbenchPart the workbench part for which the layout manager should be fetched
     * @param diagramPart the diagram part for which the layout manager should be
     *     fetched, or {@code null}
     * @return the most suitable diagram layout manager
     */
    public DiagramLayoutManager<?> getManager(final IWorkbenchPart workbenchPart,
            final Object diagramPart) {
        for (DiagramLayoutManager<?> manager : managers) {
            if (manager.supports(workbenchPart)
                    && (diagramPart == null || manager.supports(diagramPart))) {
                return manager;
            }
        }
        return null;
    }

    /**
     * Returns the preference name associated with the two identifiers.
     * 
     * @param id1 first identifier
     * @param id2 second identifier
     * @return a preference name for the combination of both identifiers
     */
    public static String getPreferenceName(final String id1, final String id2) {
        return id1 + "-" + id2; //$NON-NLS-1$
    }

    /**
     * Fills the given table of priorities with data from the extension point.
     * The number of rows in the table must be equal to the number of layout
     * providers, and the number of columns must be equal to the number of
     * diagram types.
     * 
     * @param priorityData two dimensional array that is filled with data
     * @param layoutProviders array of layout provider identifiers
     * @param diagramTypes array of diagram type identifiers
     */
    public static void readSupportPriorities(final int[][] priorityData,
            final String[] layoutProviders, final String[] diagramTypes) {
        List<String> layoutProviderList = Arrays.asList(layoutProviders);
        List<String> diagramTypesList = Arrays.asList(diagramTypes);
        for (int i = 0; i < layoutProviders.length; i++) {
            Arrays.fill(priorityData[i], LayoutAlgorithmData.MIN_PRIORITY);
        }

        IConfigurationElement[] extensions = Platform.getExtensionRegistry()
                .getConfigurationElementsFor(EXTP_ID_LAYOUT_PROVIDERS);
        for (IConfigurationElement element : extensions) {
            if (ELEMENT_LAYOUT_ALGORITHM.equals(element.getName())) {
                int providerIndex = layoutProviderList.indexOf(element.getAttribute(ATTRIBUTE_ID));
                if (providerIndex >= 0) {
                    for (IConfigurationElement child : element.getChildren()) {
                        if (ELEMENT_SUPPORTED_DIAGRAM.equals(child.getName())) {
                            int typeIndex = diagramTypesList.indexOf(child.getAttribute(ATTRIBUTE_TYPE));
                            if (typeIndex >= 0) {
                                String priority = child.getAttribute(ATTRIBUTE_PRIORITY);
                                try {
                                    priorityData[providerIndex][typeIndex] = Integer.parseInt(priority);
                                } catch (NumberFormatException exception) {
                                    // ignore exception
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    
    /**
     * Stores the layout option with given value for the diagram type.
     * 
     * @param diagramType a diagram type identifier
     * @param optionData a layout option data
     * @param valueString the value to store for the diagram type and option
     */
    public void storeOption(final String diagramType, final LayoutOptionData<?> optionData,
            final String valueString) {
        Object value = optionData.parseValue(valueString);
        if (value != null) {
            getRegistry().addOption(diagramType, optionData.getId(), value);
            IPreferenceStore preferenceStore = KimlUiPlugin.getDefault().getPreferenceStore();
            preferenceStore.setValue(getPreferenceName(diagramType, optionData.getId()), valueString);
        }
    }
    
    /**
     * Stores the layout option with given value for the edit part.
     * 
     * @param editPart an edit part
     * @param optionData a layout option data
     * @param valueString the value to store for the edit part and option
     * @param storeDomainModel if true, the option is stored for the domain model element
     *     associated with the edit part, else for the edit part itself
     */
    public void storeOption(final EditPart editPart, final LayoutOptionData<?> optionData,
            final String valueString, final boolean storeDomainModel) {
        Object value = optionData.parseValue(valueString);
        IGraphicalFrameworkBridge bridge = GraphicalFrameworkService.getInstance().getBridge(editPart);
        if (value != null && bridge != null) {
            String clazzName;
            if (storeDomainModel) {
                EObject model = bridge.getElement(editPart);
                clazzName = model == null ? null : model.eClass().getInstanceTypeName();
            } else {
                EditPart relevantPart = bridge.getEditPart(editPart);
                clazzName = relevantPart == null ? null : relevantPart.getClass().getName();
            }
            if (clazzName != null) {
                getRegistry().addOption(clazzName, optionData.getId(), value);
                registeredElements.add(clazzName);
                IPreferenceStore preferenceStore = KimlUiPlugin.getDefault().getPreferenceStore();
                preferenceStore.setValue(getPreferenceName(clazzName, optionData.getId()), valueString);
            }
        }
    }
    
    /**
     * Loads the default layout options from the extension point.
     */
    public void loadDefaultOptions() {
        for (String[] optionArray : defaultOptions) {
            String className = optionArray[0];
            String optionId = optionArray[1];
            LayoutOptionData<?> optionData = getInstance().getOptionData(optionId);
            if (optionData != null) {
                String valueString = optionArray[2];
                Object value = optionData.parseValue(valueString);
                if (value != null) {
                    getRegistry().addOption(className, optionId, value);
                }
            }
        }
    }
    
    /**
     * Retrieves the default value for the given element class and option
     * identifier from the extension point.
     * 
     * @param className name of a diagram element class
     * @param optionId layout option identifier
     * @return the default option value for the element class
     */
    public Object getDefault(final String className, final String optionId) {
        for (String[] optionArray : defaultOptions) {
            if (optionArray[0].equals(className) && optionArray[1].equals(optionId)) {
                LayoutOptionData<?> optionData = getInstance().getOptionData(optionId);
                if (optionData != null) {
                    String valueString = optionArray[2];
                    return optionData.parseValue(valueString);
                }
            }
        }
        return null;
    }
    
    /**
     * Returns the layout option data that matches the given user-friendly name and is known by the
     * given layout provider.
     * 
     * @param providerData a layout provider data
     * @param optionName user-friendly name of a layout option
     * @return the corresponding layout option data
     */
    public LayoutOptionData<?> getOptionData(final LayoutAlgorithmData providerData,
            final String optionName) {
        for (LayoutOptionData<?> data : getOptionData()) {
            if (data.getName().equals(optionName) && providerData.knowsOption(data)) {
                return data;
            }
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void reportError(final String extensionPoint,
            final IConfigurationElement element, final String attribute, final Throwable exception) {
        String message;
        if (element != null && attribute != null) {
            message = "Extension point " + extensionPoint + ": Invalid entry in attribute '"
                    + attribute + "' of element " + element.getName() + ", contributed by "
                    + element.getContributor().getName();
        } else {
            message = "Extension point " + extensionPoint
                    + ": An error occured while loading extensions.";
        }
        IStatus status = new Status(IStatus.WARNING, KimlUiPlugin.PLUGIN_ID, 0, message, exception);
        StatusManager.getManager().handle(status);
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    protected void reportError(final CoreException exception) {
        StatusManager.getManager().handle(exception, KimlUiPlugin.PLUGIN_ID);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected LayoutAlgorithmData createLayoutAlgorithmData(final IConfigurationElement element) {
        EclipseLayoutAlgorithmData algoData = new EclipseLayoutAlgorithmData();
        String previewPath = element.getAttribute(ATTRIBUTE_PREVIEW);
        if (previewPath != null) {
            algoData.setPreviewImage(AbstractUIPlugin.imageDescriptorFromPlugin(
                    element.getContributor().getName(), previewPath));
        }
        return algoData;
    }

    /**
     * Loads and registers all layout info extensions from the extension point.
     */
    private void loadLayoutInfoExtensions() {
        IConfigurationElement[] extensions = Platform.getExtensionRegistry()
                .getConfigurationElementsFor(EXTP_ID_LAYOUT_INFO);
        Registry registry = getRegistry();

        for (IConfigurationElement element : extensions) {
            if (ELEMENT_DIAGRAM_TYPE.equals(element.getName())) {
                // register a diagram type from the extension
                String id = element.getAttribute(ATTRIBUTE_ID);
                String name = element.getAttribute(ATTRIBUTE_NAME);
                if (id == null || id.length() == 0) {
                    reportError(EXTP_ID_LAYOUT_INFO, element, ATTRIBUTE_ID, null);
                } else if (name == null) {
                    reportError(EXTP_ID_LAYOUT_INFO, element, ATTRIBUTE_NAME, null);
                } else {
                    registry.addDiagramType(id, name);
                }
            } else if (ELEMENT_OPTION.equals(element.getName())) {
                // register a layout option from the extension
                String clazz = element.getAttribute(ATTRIBUTE_CLASS);
                String option = element.getAttribute(ATTRIBUTE_OPTION);
                String value = element.getAttribute(ATTRIBUTE_VALUE);
                if (clazz == null || clazz.length() == 0) {
                    reportError(EXTP_ID_LAYOUT_INFO, element, ATTRIBUTE_CLASS, null);
                } else if (option == null || option.length() == 0) {
                    reportError(EXTP_ID_LAYOUT_INFO, element, ATTRIBUTE_OPTION, null);
                } else {
                    defaultOptions.add(new String[] {clazz, option, value});
                }
            } else if (ELEMENT_SEMANTIC_OPTION.equals(element.getName())) {
                // register a semantic layout configuration from the extension
                try {
                    SemanticLayoutConfig config = (SemanticLayoutConfig)
                            element.createExecutableExtension(ATTRIBUTE_CONFIG);
                    String clazz = element.getAttribute(ATTRIBUTE_CLASS);
                    if (clazz == null || clazz.length() == 0) {
                        reportError(EXTP_ID_LAYOUT_INFO, element, ATTRIBUTE_CLASS, null);
                    } else {
                        registry.addSemanticConfig(clazz, config);
                    }
                } catch (CoreException exception) {
                    StatusManager.getManager().handle(exception, KimlUiPlugin.PLUGIN_ID);
                }
            }
        }
    }
    
    /**
     * Loads all diagram layout manager extensions from the extension point.
     */
    private void loadLayoutManagerExtensions() {
        IConfigurationElement[] extensions = Platform.getExtensionRegistry()
                .getConfigurationElementsFor(EXTP_ID_LAYOUT_MANAGERS);
        
        for (IConfigurationElement element : extensions) {
            if (ELEMENT_MANAGER.equals(element.getName())) {
                try {
                    DiagramLayoutManager<?> manager = (DiagramLayoutManager<?>)
                            element.createExecutableExtension(ATTRIBUTE_CLASS);
                    int priority = 0;
                    String prioEntry = element.getAttribute(ATTRIBUTE_PRIORITY);
                    if (prioEntry != null) {
                        try {
                            priority = Integer.parseInt(prioEntry);
                        } catch (NumberFormatException exception) {
                            // ignore exception
                        }
                    }
                    if (manager != null) {
                        insertManager(manager, priority);
                    }
                } catch (CoreException exception) {
                    StatusManager.getManager().handle(exception, KimlUiPlugin.PLUGIN_ID);
                }
            }
        }
    }
    
    /**
     * Insert the given diagram layout manager with a specific priority.
     * 
     * @param manager a diagram layout manager
     * @param priority priority at which the manager is inserted
     */
    private void insertManager(final DiagramLayoutManager<?> manager, final int priority) {
        ListIterator<DiagramLayoutManager<?>> iter = managers.listIterator();
        while (iter.hasNext()) {
            DiagramLayoutManager<?> next = iter.next();
            if (next.getPriority() <= priority) {
                iter.previous();
                break;
            }
        }
        iter.add(manager);
        manager.setPriority(priority);
    }

    /**
     * Loads preferences for KIML.
     */
    private void loadPreferences() {
        IPreferenceStore preferenceStore = KimlUiPlugin.getDefault().getPreferenceStore();
        Registry registry = getRegistry();
        
        // load default options for diagram types
        List<Pair<String, String>> diagramTypes = getDiagramTypes();
        Collection<LayoutOptionData<?>> layoutOptionData = getOptionData();
        for (Pair<String, String> diagramType : diagramTypes) {
            for (LayoutOptionData<?> data : layoutOptionData) {
                String preference = getPreferenceName(diagramType.getFirst(), data.getId());
                if (preferenceStore.contains(preference)) {
                    Object value = data.parseValue(preferenceStore.getString(preference));
                    if (value != null) {
                        registry.addOption(diagramType.getFirst(), data.getId(), value);
                    }
                }
            }
        }
        
        // load default options for diagram elements
        StringTokenizer editPartsTokenizer = new StringTokenizer(
                preferenceStore.getString(PREF_REG_ELEMENTS), ";");
        while (editPartsTokenizer.hasMoreTokens()) {
            registeredElements.add(editPartsTokenizer.nextToken());
        }
        for (String elementName : registeredElements) {
            for (LayoutOptionData<?> data : layoutOptionData) {
                String preference = getPreferenceName(elementName, data.getId());
                if (preferenceStore.contains(preference)) {
                    Object value = data.parseValue(preferenceStore.getString(preference));
                    if (value != null) {
                        registry.addOption(elementName, data.getId(), value);
                    }
                }
            }
        }
    }
    
    /**
     * Stores preferences for KIML.
     */
    public void storePreferences() {
        IPreferenceStore preferenceStore = KimlUiPlugin.getDefault().getPreferenceStore();

        // store set of registered diagram elements
        StringBuilder elementsString = new StringBuilder();
        for (String elementName : registeredElements) {
            elementsString.append(elementName + ";");
        }
        preferenceStore.setValue(PREF_REG_ELEMENTS, elementsString.toString());
    }

    /**
     * Returns the set of registered diagram elements.
     * 
     * @return the set of registered diagram elements
     */
    public Set<String> getRegisteredElements() {
        return registeredElements;
    }

}

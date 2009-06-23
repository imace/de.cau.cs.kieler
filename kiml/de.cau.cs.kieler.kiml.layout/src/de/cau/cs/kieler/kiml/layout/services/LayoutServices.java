/******************************************************************************
 * KIELER - Kiel Integrated Environment for Layout for the Eclipse RCP
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
package de.cau.cs.kieler.kiml.layout.services;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import de.cau.cs.kieler.core.alg.IKielerProgressMonitor;
import de.cau.cs.kieler.core.kgraph.KNode;
import de.cau.cs.kieler.kiml.layout.options.LayoutOptions;
import de.cau.cs.kieler.kiml.layout.util.KimlLayoutUtil;

/**
 * Main class for access to the layout services <em>layout provider</em> and
 * <em>layout listener</em>.
 * 
 * @author <a href="mailto:msp@informatik.uni-kiel.de">Miro Sp&ouml;nemann</a>
 */
public class LayoutServices {

    /** identifier of the extension point for layout providers */
    public static final String EXTP_ID_LAYOUT_PROVIDERS = "de.cau.cs.kieler.kiml.layout.layoutProviders";
    /** identifier of the extension point for layout listeners */
    public static final String EXTP_ID_LAYOUT_LISTENERS = "de.cau.cs.kieler.kiml.layout.layoutListeners";
    /** identifier of the extension point for layout info */
    public static final String EXTP_ID_LAYOUT_INFO = "de.cau.cs.kieler.kiml.layout.layoutInfo";
    /** name of the 'layoutProvider' element in the extension point */
    public static final String ELEMENT_LAYOUT_PROVIDER = "layoutProvider";
    /** name of the 'layoutType' element in the extension point */
    public static final String ELEMENT_LAYOUT_TYPE = "layoutType";
    /** name of the 'collection' element in the extension point */
    public static final String ELEMENT_COLLECTION = "collection";
    /** name of the 'layoutOption' element in the extension point */
    public static final String ELEMENT_LAYOUT_OPTION = "layoutOption";
    /** name of the 'knownOption' element in the extension point */
    public static final String ELEMENT_KNOWN_OPTION = "knownOption";
    /** name of the 'supportedDiagram' element in the extension point */
    public static final String ELEMENT_SUPPORTED_DIAGRAM = "supportedDiagram";
    /** name of the 'elementType' element in the extension point */
    public static final String ELEMENT_ELEMENT_TYPE = "elementType";
    /** name of the 'binding' element in the extension point */
    public static final String ELEMENT_BINDING = "binding";
    /** name of the 'layoutListener' element in the extension point */
    public static final String ELEMENT_LAYOUT_LISTENER = "layoutListener";
    /** name of the 'id' attribute in the extension point */
    public static final String ATTRIBUTE_ID = "id";
    /** name of the 'class' attribute in the extension point */
    public static final String ATTRIBUTE_CLASS = "class";
    /** name of the 'name' attribute in the extension point */
    public static final String ATTRIBUTE_NAME = "name";
    /** name of the 'type' attribute in the extension point */
    public static final String ATTRIBUTE_TYPE = "type";
    /** name of the 'collection' attribute in the extension point */
    public static final String ATTRIBUTE_COLLECTION = "collection";
    /** name of the 'description' attribute in the extension point */
    public static final String ATTRIBUTE_DESCRIPTION = "description";
    /** name of the 'option' attribute in the extension point */
    public static final String ATTRIBUTE_OPTION = "option";

    
	/** the singleton instance */
	public static LayoutServices INSTANCE = null;

	/** the list of layout listeners that have been loaded at startup */
	private List<ILayoutListener> listeners = new LinkedList<ILayoutListener>();
	/** mapping of layout provider identifiers to their data instances */
	private Map<String, LayoutProviderData> layoutProviderMap
			= new LinkedHashMap<String, LayoutProviderData>();
	/** mapping of layout type identifiers to their names */
	private Map<String, String> layoutTypeMap
	        = new HashMap<String, String>();

	/**
	 * Adds the given layout listener to the list of registered listeners.
	 * 
	 * @param listener layout listener to register
	 */
	public void addLayoutListener(ILayoutListener listener) {
		listeners.add(listener);
	}
	
	/**
	 * Removes the given layout listener from the list of registered
	 * listeners.
	 * 
	 * @param listener layout listener to remove
	 */
	public void removeLayoutListener(ILayoutListener listener) {
	    listeners.remove(listener);
	}
	
	/**
	 * Calls the {@link ILayoutListener#layoutRequested layoutRequested}
	 * method of all registered layout listeners.
	 * 
	 * @param layoutGraph layout graph for which layout is requested
	 */
	public void layoutRequested(KNode layoutGraph) {
		for (ILayoutListener listener : listeners) {
			listener.layoutRequested(layoutGraph);
		}
	}
	
	/**
	 * Calls the {@link ILayoutListener#layoutPerformed layoutPerformed}
	 * method of all registered layout listeners.
	 * 
	 * @param layoutGraph layout graph for which layout was performed
	 * @param monitor progress monitor containing execution time results
	 */
	public void layoutPerformed(KNode layoutGraph,
			IKielerProgressMonitor monitor) {
		for (ILayoutListener listener : listeners) {
			listener.layoutPerformed(layoutGraph, monitor);
		}
	}

	/**
	 * Registers the given layout provider. If there is already a
	 * registered provider data instance with the same identifier, it
	 * is overwritten.
	 * 
	 * @param providerData data instance of the layout provider to register
	 */
	public void addLayoutProvider(LayoutProviderData providerData) {
	    if (providerData.id != null)
	        layoutProviderMap.put(providerData.id, providerData);
	}
	
	/**
	 * Removes the layout provider with given id from the map of
	 * registered providers.
	 * 
	 * @param id identifier of the layout provider to remove
	 */
	public void removeLayoutProvider(String id) {
	    layoutProviderMap.remove(id);
	}

	/**
	 * Returns the layout provider data associated with the given
	 * identifier.
	 * 
	 * @param id layout provider identifier
	 * @return the corresponding layout provider data
	 */
	//public LayoutProviderData getLayoutProviderData(String id) {
	//    return layoutProviderMap.get(id);
	//}

	/**
	 * Returns a data collection for all registered layout providers.
	 * 
	 * @return collection of registered layout providers
	 */
    public Collection<LayoutProviderData> getLayoutProviderData() {
        return layoutProviderMap.values();
    }
	
	/**
	 * Returns the most appropriate layout provider for the given
	 * node.
	 * 
	 * @param layoutNode
	 * @return
	 */
	public AbstractLayoutProvider getLayoutProvider(KNode layoutNode) {
	    String layoutHint = LayoutOptions.getLayoutHint(
	            KimlLayoutUtil.getShapeLayout(layoutNode));
	    // try to get a specific provider for the given node
	    LayoutProviderData providerData = layoutProviderMap.get(layoutHint);
	    if (providerData != null)
	        return providerData.instance;
	    
	    // try to get a provider of specific type
	    for (LayoutProviderData data : layoutProviderMap.values()) {
	        if (data.type.equals(layoutHint))
	            return data.instance;
	    }
		
		return layoutProviderMap.values().iterator().next().instance;
	}
	
	/**
	 * Registers the given layout type.
	 * 
	 * @param id identifier of the type
	 * @param name readable name of the type
	 */
	public void addLayoutType(String id, String name) {
	    if (id != null && name != null)
	        layoutTypeMap.put(id, name);
	}
	
	/**
	 * Returns the name of the layout type with given identifier.
	 * 
	 * @param id identifier of the type
	 * @return readable name of the type
	 */
	public String getLayoutTypeName(String id) {
	    return layoutTypeMap.get(id);
	}
	
}

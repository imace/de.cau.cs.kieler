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

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import de.cau.cs.kieler.core.IKielerPreferenceStore;
import de.cau.cs.kieler.core.alg.IKielerProgressMonitor;
import de.cau.cs.kieler.core.kgraph.KNode;
import de.cau.cs.kieler.core.kgraph.KStringOption;
import de.cau.cs.kieler.kiml.layout.klayoutdata.KLayoutData;
import de.cau.cs.kieler.kiml.layout.options.LayoutOptions;
import de.cau.cs.kieler.kiml.layout.options.LayoutType;
import de.cau.cs.kieler.kiml.layout.util.KimlLayoutPreferenceConstants;
import de.cau.cs.kieler.kiml.layout.util.KimlLayoutUtil;

/**
 * Main class for access to the layout services layout provider and
 * layout listener.
 * 
 * @author msp
 */
public class KimlLayoutServices {

	/** singleton holder */
	private static KimlLayoutServices INSTANCE = null;

	/** the preference store */
	private IKielerPreferenceStore preferenceStore;
	/** the list of layout listeners that have been loaded at startup */
	private List<ILayoutListener> listeners = new LinkedList<ILayoutListener>();
	/** maps the name of a layout provider to the instantiated
	 *  layout provider object */
	private Map<String, AbstractLayoutProvider> layoutProviderMap
			= new LinkedHashMap<String, AbstractLayoutProvider>();


	/**
	 * @return the singleton instance of the LayoutListeners class
	 */
	public static KimlLayoutServices getInstance() {
		return INSTANCE;
	}
	
	/**
	 * Creates the layout services and registers it as the singleton
	 * instance. Any previously created instance is overwritten.
	 * 
	 * @param preferenceStore the preference store for layout services
	 */
	public KimlLayoutServices(IKielerPreferenceStore preferenceStore) {
		this.preferenceStore = preferenceStore;
		INSTANCE = this;
	}
	
	/**
	 * Returns the preference store for all layout services.
	 * 
	 * @return the preference store
	 */
	public IKielerPreferenceStore getPreferenceStore() {
		return preferenceStore;
	}
	
	/**
	 * Adds the given layout listener to the list of registered listeners.
	 * 
	 * @param listener layout listener to register
	 */
	public void addLayoutListener(ILayoutListener listener) {
		listeners.add(listener);
	}
	
	/**
	 * Calls the <code>layoutRequested</code> method of all registered
	 * layout listeners.
	 * 
	 * @param layoutGraph layout graph for which layout is requested
	 */
	public void layoutRequested(KNode layoutGraph) {
		for (ILayoutListener listener : listeners) {
			listener.layoutRequested(layoutGraph);
		}
	}
	
	/**
	 * Calls the <code>layoutPerformed</code> method of all registered
	 * layout listeners.
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
	 * Registers the given layout provider.
	 * 
	 * @param provider layout provider to register
	 */
	public void addLayoutProvider(AbstractLayoutProvider provider) {
		layoutProviderMap.put(provider.getName(), provider);
	}

    /**
     * Returns the layout provider with given name.
     * 
     * @param name name of a layout provider
     * @return the respective layout provider, or <code>null</code>
     *     if no provider with such name exists
     */
    public AbstractLayoutProvider getLayoutProvider(String name) {
        return layoutProviderMap.get(name);
    }
	
	/**
	 * Returns the best fitting {@link AbstractLayoutProvider} for the
	 * provided KLayoutNode. The layout provider is evaluated as follows:
	 * <ol>
	 * <li>If Layouter Name attribute of KLayoutNode is fitting a certain layout
	 * provider, return this layout provider</li>
	 * <li>If Layout Type attribute of KLayoutNode is fitting a certain layout
	 * provider, return this layout provider</li>
	 * <li>If not fitting so far, return the default layout provider. This can
	 * be adjusted in the preference page.</li>
	 * <li>If no default layout provider found, return the
	 * {@link NullLayoutProvider}, which does nothing, but does not trigger
	 * a NullPointerException.</li>
	 * </ol>
	 * 
	 * @param layoutNode
	 *            The KNode for which the fitting layout provider should be
	 *            returned
	 * @return The best fitting LayoutProvider for the provided KLayoutNode
	 * @see NullLayoutProvider
	 */
	public AbstractLayoutProvider getLayoutProvider(KNode layoutNode) {
		AbstractLayoutProvider layoutProvider = null;

		// if layouter name is fitting, use it
		KLayoutData layoutData = KimlLayoutUtil.getLayoutData(layoutNode);
		KStringOption layouterName = (KStringOption)layoutData
		        .getOption(LayoutOptions.LAYOUTER_NAME);
		if (layouterName != null && layoutProviderMap.containsKey(
		        layouterName.getValue())) {
			layoutProvider = layoutProviderMap.get(layouterName.getValue());
			if (layoutProvider.isEnabled())
				return layoutProvider;
		}

		// if no proper name, try same layout type
		LayoutType layoutType = LayoutOptions.getLayoutType(layoutData);
		if (layoutType != LayoutType.OTHER) {
    		for (AbstractLayoutProvider provider : layoutProviderMap.values()) {
    			if (provider.isEnabled()
    			        && provider.getType().equals(layoutType))
   					return provider;
    		}
		}

		// if still no success, use default layout provider ...
		String defaultLayoutProvider = preferenceStore
				.getString(KimlLayoutPreferenceConstants.PREF_LAYOUTPROVIDERS_DEFAULT_LAYOUT_PROVIDER);
		layoutProvider = layoutProviderMap.get(defaultLayoutProvider);

		// ... and if found return it
		if (layoutProvider != null && layoutProvider.isEnabled()) {
			return layoutProvider;
		}
		/*
		 * if still no layout provider found, return dummy null layout provider,
		 * so that no null pointer exception arises in other plugins.
		 */
		else {
			return new NullLayoutProvider();
		}
	}

	/**
	 * Returns a list of currently enabled layout providers.
	 * 
	 * @return list of enabled layout providers
	 */
	public List<AbstractLayoutProvider> getEnabledProviders() {
	    ArrayList<AbstractLayoutProvider> providers = new ArrayList<AbstractLayoutProvider>();
	    for (AbstractLayoutProvider layoutProvider : layoutProviderMap.values()) {
	        if (layoutProvider.isEnabled())
	            providers.add(layoutProvider);
	    }
	    return providers;
	}

	/**
	 * Returns a list of currently enabled layout providers that
	 * match the given type.
	 * 
	 * @param layoutType type of layout provider
	 * @return list of enabled layout providers of given type
	 */
	public List<AbstractLayoutProvider> getEnabledProviders(LayoutType layoutType) {
	    ArrayList<AbstractLayoutProvider> providers = new ArrayList<AbstractLayoutProvider>(); 
	    for (AbstractLayoutProvider layoutProvider : layoutProviderMap.values()) {
	        if (layoutProvider.isEnabled()
	                && layoutProvider.getType().equals(layoutType))
	            providers.add(layoutProvider);
        }
        return providers;
	}
	
	/**
	 * Returns a list of layout providers for the given collection name.
	 *
	 * @param collection collection name
	 * @return list of layout providers in the given collection
	 */
	public List<AbstractLayoutProvider> getLayoutProviders(String collection) {
		ArrayList<AbstractLayoutProvider> providers = new ArrayList<AbstractLayoutProvider>();
		for (AbstractLayoutProvider layoutProvider : layoutProviderMap.values()) {
			if (layoutProvider.getCollection().equals(collection)) {
			    providers.add(layoutProvider);
			}
		}
		return providers;
	}
	
}

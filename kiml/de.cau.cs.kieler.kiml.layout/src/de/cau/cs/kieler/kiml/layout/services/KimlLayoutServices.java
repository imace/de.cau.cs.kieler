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
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import de.cau.cs.kieler.core.IKielerPreferenceStore;
import de.cau.cs.kieler.core.alg.IKielerProgressMonitor;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutGraph;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutNode;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutType;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayouterInfo;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphFactory;
import de.cau.cs.kieler.kiml.layout.util.KimlLayoutPreferenceConstants;

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
	private List<IKimlLayoutListener> listeners = new LinkedList<IKimlLayoutListener>();
	/** maps the name of a layout provider to the instantiated
	 *  layout provider object */
	private HashMap<String, KimlAbstractLayoutProvider> layoutProviderMap
			= new HashMap<String, KimlAbstractLayoutProvider>();


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
	public void addLayoutListener(IKimlLayoutListener listener) {
		listeners.add(listener);
	}
	
	/**
	 * Calls the <code>layoutRequested</code> method of all registered
	 * layout listeners.
	 * 
	 * @param layoutGraph layout graph for which layout is requested
	 */
	public void layoutRequested(KLayoutGraph layoutGraph) {
		for (IKimlLayoutListener listener : listeners) {
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
	public void layoutPerformed(KLayoutGraph layoutGraph,
			IKielerProgressMonitor monitor) {
		for (IKimlLayoutListener listener : listeners) {
			listener.layoutPerformed(layoutGraph, monitor);
		}
	}

	/**
	 * Registers the given layout provider.
	 * 
	 * @param provider layout provider to register
	 */
	public void addLayoutProvider(KimlAbstractLayoutProvider provider) {
		layoutProviderMap.put(provider.getLayouterInfo().getLayouterName(),
				provider);
	}
	
	/**
	 * Returns the best fitting {@link KimlAbstractLayoutProvider} for the
	 * provided KLayoutNode. The layout provider is evaluated as follows:
	 * <ol>
	 * <li>If Layouter Name attribute of KLayoutNode is fitting a certain layout
	 * provider, return this layout provider</li>
	 * <li>If Layout Type attribute of KLayoutNode is fitting a certain layout
	 * provider, return this layout provider</li>
	 * <li>If not fitting so far, return the default layout provider. This can
	 * be adjusted in the preference page.</li>
	 * <li>If no default layout provider found, return the
	 * {@link KimlNullLayoutProvider}, which does nothing, but does not trigger
	 * a NullPointerException.</li>
	 * </ol>
	 * 
	 * @param layoutNode
	 *            The KLayoutNode for which the fitting layout provider should be
	 *            returned
	 * @return The best fitting LayoutProvider for the provided KLayoutNode
	 * @see KimlNullLayoutProvider
	 */
	public KimlAbstractLayoutProvider getLayoutProvider(KLayoutNode layoutNode) {
		KimlAbstractLayoutProvider layoutProvider = null;

		/* if layouter name is fitting, use it */
		String layouterName = layoutNode.getLayout().getLayouterName();
		if (layoutProviderMap.containsKey(layouterName)) {
			layoutProvider = layoutProviderMap.get(layouterName);
			if (layoutProvider.isEnabled())
				return layoutProvider;
		}

		/* if no proper name, try same layout type */
		else {
			for (KLayouterInfo layouterInfo : getEnabledLayouterInfos()) {
				if (layouterInfo.getLayoutType().equals(
						layoutNode.getLayout().getLayoutType())) {
					layoutProvider = layoutProviderMap.get(layouterInfo
							.getLayouterName());
					if (layoutProvider.isEnabled())
						return layoutProvider;
				}
			}
		}

		/* if still no success, use default layout provider ... */
		String defaultLayoutProvider = preferenceStore
				.getString(KimlLayoutPreferenceConstants.PREF_LAYOUTPROVIDERS_DEFAULT_LAYOUT_PROVIDER);
		layoutProvider = layoutProviderMap.get(defaultLayoutProvider);

		/* ... and if found return it */
		if (layoutProvider != null && layoutProvider.isEnabled()) {
			return layoutProvider;
		}
		/*
		 * if still no layout provider found, return dummy null layout provider,
		 * so that no null pointer exception arises in other plugins.
		 */
		else {
			return new KimlNullLayoutProvider();
		}
	}

	/**
	 * Returns a non null, possibly empty list of strings with the names of the
	 * currently enabled layout providers.
	 * 
	 * @return An possibly empty list of strings with the names of the currently
	 *         enabled layout providers
	 */
	public ArrayList<String> getEnabledLayouterNames() {
		ArrayList<String> enabledLayouterNames = new ArrayList<String>();

		for (String layouterName : layoutProviderMap.keySet()) {
			if (layoutProviderMap.get(layouterName).isEnabled())
				enabledLayouterNames.add(layouterName);
		}
		return enabledLayouterNames;
	}

	/**
	 * Returns a non null, possibly empty list of {@link KLayoutType}s,
	 * indicating all the LAYOUT_TYPEs all currently enabled layout providers
	 * can handle.
	 * 
	 * @return An possibly empty list of LAYOUT_TYPEs the currently enabled
	 *         layouters can handle
	 */
	public ArrayList<KLayoutType> getEnabledLayoutTypes() {
		ArrayList<KLayoutType> enabledLayoutTypes = new ArrayList<KLayoutType>();

		for (KimlAbstractLayoutProvider layoutProvider : layoutProviderMap
				.values()) {
			if (layoutProvider.isEnabled()) {
				KLayoutType type = layoutProvider.getLayouterInfo()
						.getLayoutType();
				if (!enabledLayoutTypes.contains(type)) {
					enabledLayoutTypes.add(type);
				}
			}
		}
		return enabledLayoutTypes;
	}

	/**
	 * Returns a non null, possibly empty list of {@link KLayouterInfo}s for all
	 * the enabled layout providers.
	 * 
	 * @return An possibly empty list of {@link KLayouterInfo}s for all the
	 *         enabled layout providers
	 */
	public ArrayList<KLayouterInfo> getEnabledLayouterInfos() {
		ArrayList<KLayouterInfo> enabledLayouterInfos = new ArrayList<KLayouterInfo>();

		for (KimlAbstractLayoutProvider layoutProvider : layoutProviderMap
				.values()) {
			if (layoutProvider.isEnabled()) {
				KLayouterInfo info = layoutProvider.getLayouterInfo();
				if (!enabledLayouterInfos.contains(info)) {
					enabledLayouterInfos.add(info);

				}
			}
		}
		return enabledLayouterInfos;
	}

	/**
	 * Returns the {@link KLayouterInfo} for the given layout provider.
	 * 
	 * @return The {@link KLayouterInfo} for the layout provider, or the
	 *         KLayouterInfo filled with the default values if layout provider
	 *         not found or not enabled.
	 */
	public KLayouterInfo getLayouterInfoForLayouterName(
			String layouterProviderName) {
		for (KLayouterInfo layouterInfo : getEnabledLayouterInfos()) {
			if (layouterInfo.getLayouterName().equals(layouterProviderName)) {
				return layouterInfo;
			}
		}
		return KimlLayoutGraphFactory.eINSTANCE.createKLayouterInfo();
	}

	/**
	 * Returns a non null, possibly empty list of enabled
	 * {@link KimlAbstractLayoutProvider}s for a given collectionID.
	 * 
	 * @return An possibly empty list of enabled
	 *         {@link KimlAbstractLayoutProvider}s for a given collectionID
	 */
	public ArrayList<KimlAbstractLayoutProvider> getLayoutProvidersOfCollection(
			String collectionID) {
		ArrayList<KimlAbstractLayoutProvider> collection = new ArrayList<KimlAbstractLayoutProvider>();
		for (KimlAbstractLayoutProvider layoutProvider : layoutProviderMap
				.values()) {
			if (layoutProvider.getLayouterInfo().getLayouterCollectionID()
					.equals(collectionID)) {
				collection.add(layoutProvider);
			}
		}
		return collection;
	}
	
}

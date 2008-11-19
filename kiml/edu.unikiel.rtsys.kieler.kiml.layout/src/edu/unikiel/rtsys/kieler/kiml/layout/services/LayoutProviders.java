/*******************************************************************************
 * Copyright (c) 2008 Real-Time and Embedded Systems group
 *
 * INSERT LICENCE HERE
 *
 *
 * Author: Arne Schipper, ars@informatik.uni-kiel.de 
 *
 *******************************************************************************/
package edu.unikiel.rtsys.kieler.kiml.layout.services;

import java.util.ArrayList;
import java.util.HashMap;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.jface.preference.IPreferenceStore;

import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutPlugin;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KNodeGroup;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphFactory;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.LAYOUTER_INFO;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.LAYOUT_TYPE;
import edu.unikiel.rtsys.kieler.kiml.layout.util.KimlLayoutPreferenceConstants;

/**
 * Controls all the layout providers, which are loaded at startup. Realized as a
 * singleton to allow easy access from anywhere and a fast processing.
 * <p/>
 * Collects the layout providers that extend {@link KimlAbstractLayoutProvider}
 * and register themselves at the <code>kimlLayoutProvider</code> extension
 * point.
 * <p/>
 * Provides a function to get a concrete layout provider, which is used in
 * {@link KimlRecursiveGroupLayouterEngine}, for example, and some convenience
 * functions to query the status.
 * <p/>
 * There is still no proper error handling, but that is a KIELER-wide issue.
 * 
 * @author <a href="mailto:ars@informatik.uni-kiel.de">Arne Schipper</a>
 * @see KimlAbstractLayoutProvider
 * @see KimlRecursiveGroupLayouterEngine
 */
public final class LayoutProviders {

	/* singleton holder */
	private static final LayoutProviders INSTANCE = new LayoutProviders();

	/*
	 * maps the name of a layout provider to the instantiated layout provider
	 * object
	 */
	private HashMap<String, KimlAbstractLayoutProvider> layoutProviderMap = new HashMap<String, KimlAbstractLayoutProvider>();

	/**
	 * Static method which returns the singleton LayoutProvider.
	 * 
	 * @return The LayoutProviders singleton
	 */
	public static LayoutProviders getInstance() {
		return INSTANCE;
	}

	/**
	 * Singleton constructor which loads all the layout providers once at
	 * startup.
	 * <p>
	 * TODO: Proper error handling, KIELER-wide.
	 */
	private LayoutProviders() {
		loadAvailableLayouters();
	};

	/*
	 * does the actual loading of the layout providers, which need to register
	 * themselves through the kimlLayoutProvider extension point.
	 * 
	 * TODO: Proper error handling, KIELER-wide
	 */
	private void loadAvailableLayouters() {

		IExtensionRegistry reg = Platform.getExtensionRegistry();
		IConfigurationElement[] extensions = reg
				.getConfigurationElementsFor(KimlAbstractLayoutProvider.EXTENSION_POINT_ID);

		for (IConfigurationElement element : extensions) {
			try {
				KimlAbstractLayoutProvider layoutProvider = (KimlAbstractLayoutProvider) element
						.createExecutableExtension(KimlAbstractLayoutProvider.ATTRIBUTE_CLASS);
				/*
				 * try to load every layout provider available on the system,
				 * but ...
				 */
				if (layoutProvider != null) {
					/*
					 * ... disable those, which were disabled by the user. This
					 * is set in the respective preference store of the user. As
					 * this function (loadAvailableLayouters) is performed just
					 * once during startup, Emma has to load all the layout
					 * provider nevertheless, but then takes a look in the
					 * preference store.
					 */
					String pluginName = element.getDeclaringExtension()
							.getContributor().getName();
					IEclipsePreferences pref = new InstanceScope()
							.getNode(pluginName);
					boolean state = pref.getBoolean(layoutProvider
							.getLayouterInfo().getLayouterName(), true);
					layoutProvider.setEnabled(state);
					layoutProviderMap.put(layoutProvider.getLayouterInfo()
							.getLayouterName(), layoutProvider);
				}
			} catch (Exception e) {
				// TODO error handling
				System.out
						.println("===================================================");
				System.out.println("Error creating layout providers.");
				e.printStackTrace();
				System.out
						.println("===================================================");
			}
		}
	}

	/**
	 * Returns the best fitting {@link KimlAbstractLayoutProvider} for the
	 * provided KNodeGroup. The layout provider is evaluated as follows:
	 * <ol>
	 * <li>If Layouter Name attribute of KNodeGroup is fitting a certain layout
	 * provider, return this layout provider</li>
	 * <li>If Layout Type attribute of KNodeGroup is fitting a certain layout
	 * provider, return this layout provider</li>
	 * <li>If not fitting so far, return the default layout provider. This can
	 * be adjusted in the preference page.</li>
	 * <li>If no default layout provider found, return the
	 * {@link KimlNullLayoutProvider}, which does nothing, but does not trigger
	 * a NullPointerException.</li>
	 * </ol>
	 * 
	 * @param nodeGroup
	 *            The KNodeGroup for which the fitting layout provider should be
	 *            returned
	 * @return The best fitting LayoutProvider for the provided KNodeGroup
	 * @see KimlNullLayoutProvider
	 */
	public KimlAbstractLayoutProvider getLayoutProvider(KNodeGroup nodeGroup) {
		KimlAbstractLayoutProvider layoutProvider = null;

		/* if layouter name is fitting, use it */
		String layouterName = nodeGroup.getLayout().getLayouterName();
		if (layoutProviderMap.containsKey(layouterName)) {
			layoutProvider = layoutProviderMap.get(layouterName);
			if (layoutProvider.isEnabled())
				return layoutProvider;
		}

		/* if no proper name, try same layout type */
		else {
			for (LAYOUTER_INFO layouterInfo : getEnabledLayouterInfos()) {
				if (layouterInfo.getLayoutType().equals(
						nodeGroup.getLayout().getLayoutType())) {
					layoutProvider = layoutProviderMap.get(layouterInfo
							.getLayouterName());
					if (layoutProvider.isEnabled())
						return layoutProvider;
				}
			}
		}

		/* if still no success, use default layout provider ... */
		IPreferenceStore store = KimlLayoutPlugin.getDefault()
				.getPreferenceStore();
		String defaultLayoutProvider = store
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
	 * Returns a non null, possibly empty list of {@link LAYOUT_TYPE}s,
	 * indicating all the LAYOUT_TYPEs all currently enabled layout providers
	 * can handle.
	 * 
	 * @return An possibly empty list of LAYOUT_TYPEs the currently enabled
	 *         layouters can handle
	 */
	public ArrayList<LAYOUT_TYPE> getEnabledLayoutTypes() {

		ArrayList<LAYOUT_TYPE> enabledLayoutTypes = new ArrayList<LAYOUT_TYPE>();

		for (KimlAbstractLayoutProvider layoutProvider : layoutProviderMap
				.values()) {
			if (layoutProvider.isEnabled()) {
				LAYOUT_TYPE type = layoutProvider.getLayouterInfo()
						.getLayoutType();
				if (!enabledLayoutTypes.contains(type)) {
					enabledLayoutTypes.add(type);
				}
			}
		}
		return enabledLayoutTypes;
	}

	/**
	 * Returns a non null, possibly empty list of {@link LAYOUTER_INFO}s for all
	 * the enabled layout providers.
	 * 
	 * @return An possibly empty list of {@link LAYOUTER_INFO}s for all the
	 *         enabled layout providers
	 */
	public ArrayList<LAYOUTER_INFO> getEnabledLayouterInfos() {

		ArrayList<LAYOUTER_INFO> enabledLayouterInfos = new ArrayList<LAYOUTER_INFO>();

		for (KimlAbstractLayoutProvider layoutProvider : layoutProviderMap
				.values()) {
			if (layoutProvider.isEnabled()) {
				LAYOUTER_INFO info = layoutProvider.getLayouterInfo();
				if (!enabledLayouterInfos.contains(info)) {
					enabledLayouterInfos.add(info);

				}
			}
		}
		return enabledLayouterInfos;
	}

	/**
	 * Returns the {@link LAYOUTER_INFO} for the given layout provider.
	 * 
	 * @return The {@link LAYOUTER_INFO} for the layout provider, or the
	 *         LAYOUTER_INFO filled with the default values if layout provider
	 *         not found or not enabled.
	 */
	public LAYOUTER_INFO getLayouterInfoForLayouterName(
			String layouterProviderName) {
		for (LAYOUTER_INFO layouterInfo : LayoutProviders.getInstance()
				.getEnabledLayouterInfos()) {
			if (layouterInfo.getLayouterName().equals(layouterProviderName)) {
				return layouterInfo;
			}
		}
		return KimlLayoutGraphFactory.eINSTANCE.createLAYOUTER_INFO();
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

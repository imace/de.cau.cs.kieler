package edu.unikiel.rtsys.kieler.kiml.layout.services;

import java.util.ArrayList;
import java.util.HashMap;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;

import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutPlugin;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KNodeGroup;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.LAYOUTER_INFO;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.LAYOUT_TYPE;
import edu.unikiel.rtsys.kieler.kiml.layout.util.KimlLayoutPreferenceConstants;

public final class LayoutProviders implements IPropertyChangeListener {

	private static final LayoutProviders INSTANCE = new LayoutProviders();
	private HashMap<String, KimlAbstractLayoutProvider> layoutProviderMap = new HashMap<String, KimlAbstractLayoutProvider>();

	public static LayoutProviders getInstance() {
		return INSTANCE;
	}

	private LayoutProviders() {
		KimlLayoutPlugin.getDefault().getPreferenceStore()
				.addPropertyChangeListener(this);
		loadAvailableLayouters();
	};

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
							.getLayouterInfo().getLayouterName(), false);
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

	public KimlAbstractLayoutProvider getLayoutProvider(KNodeGroup nodeGroup) {
		KimlAbstractLayoutProvider layoutProvider = null;

		// if layouter name is fitting, use it
		String layouterName = nodeGroup.getLayout().getLayouterName();
		if (layoutProviderMap.containsKey(layouterName)) {
			layoutProvider = layoutProviderMap.get(layouterName);
			if (layoutProvider.isEnabled())
				return layoutProvider;
		}

		// if no proper name, try same layout type
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

		// if still no success, use default layout provider ...
		IPreferenceStore store = KimlLayoutPlugin.getDefault()
				.getPreferenceStore();
		String defaultLayoutProvider = store
				.getString(KimlLayoutPreferenceConstants.PREF_LAYOUTPROVIDERS_DEFAULT_LAYOUT_PROVIDER);
		layoutProvider = layoutProviderMap.get(defaultLayoutProvider);

		// ... and if found return it
		if (layoutProvider != null && layoutProvider.isEnabled()) {
			return layoutProvider;
		}
		// if still no layout provider found, return dummy null layout provider,
		// so that no null pointer exception arises in other plugins.
		else {
			return new KimlNullLayoutProvider();
		}
	}

	public ArrayList<String> getEnabledLayouterNames() {

		ArrayList<String> enabledLayouterNames = new ArrayList<String>();

		for (String layouterName : layoutProviderMap.keySet()) {
			if (layoutProviderMap.get(layouterName).isEnabled())
				enabledLayouterNames.add(layouterName);
		}
		return enabledLayouterNames;
	}

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

	public LAYOUTER_INFO getLayouterInfoForLayouterName(String layouterName) {
		for (LAYOUTER_INFO layouterInfo : LayoutProviders.getInstance()
				.getEnabledLayouterInfos()) {
			if (layouterInfo.getLayouterName().equals(layouterName)) {
				return layouterInfo;
			}
		}
		return null;
	}

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

	@Override
	public void propertyChange(PropertyChangeEvent event) {
		String layouterName = event.getProperty();
		boolean state = Boolean.parseBoolean((String) event.getNewValue());
		if (layoutProviderMap.containsKey(layouterName))
			layoutProviderMap.get(layouterName).setEnabled(state);
	}
}

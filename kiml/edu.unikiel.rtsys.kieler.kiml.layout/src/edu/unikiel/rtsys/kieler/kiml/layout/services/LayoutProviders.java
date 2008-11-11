package edu.unikiel.rtsys.kieler.kiml.layout.services;

import java.util.ArrayList;
import java.util.HashMap;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.preference.IPreferenceStore;

import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutPlugin;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KNodeGroup;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.LAYOUTER_INFO;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.LAYOUT_TYPE;
import edu.unikiel.rtsys.kieler.kiml.layout.util.KimlLayoutPreferenceConstants;

public final class LayoutProviders {

	private static final LayoutProviders INSTANCE = new LayoutProviders();
	private HashMap<String, KimlAbstractLayoutProvider> layoutProviderMap = new HashMap<String, KimlAbstractLayoutProvider>();

	public static LayoutProviders getInstance() {
		return INSTANCE;
	}

	private LayoutProviders() {
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
				if (layoutProvider != null) {
					layoutProviderMap.put(layoutProvider.getLayouterInfo()
							.getLayouterName(), layoutProvider);
				}
			} catch (CoreException e) {
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
			return layoutProvider;
		}

		// if no proper name, try same layout type
		else {
			for (LAYOUTER_INFO layouterInfo : getAvailableLayouterInfos()) {
				if (layouterInfo.getLayoutType().equals(
						nodeGroup.getLayout().getLayoutType())) {
					layoutProvider = layoutProviderMap.get(layouterInfo
							.getLayouterName());
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
		if (layoutProvider != null) {
			return layoutProvider;
		}
		// if still no layout provider found, return dummy null layout provider,
		// so that no null pointer exception arises in other plugins.
		else {
			return new KimlNullLayoutProvider();
		}
	}

	public ArrayList<String> getAvailableLayouterNames() {

		ArrayList<String> availableLayouterNames = new ArrayList<String>();

		for (String layouterNames : layoutProviderMap.keySet()) {
			availableLayouterNames.add(layouterNames);
		}
		return availableLayouterNames;
	}

	public ArrayList<LAYOUT_TYPE> getAvailableLayoutTypes() {

		ArrayList<LAYOUT_TYPE> availableLayoutTypes = new ArrayList<LAYOUT_TYPE>();

		for (KimlAbstractLayoutProvider layoutProvider : layoutProviderMap
				.values()) {
			LAYOUT_TYPE type = layoutProvider.getLayouterInfo().getLayoutType();
			if (!availableLayoutTypes.contains(type)) {
				availableLayoutTypes.add(type);
			}
		}

		return availableLayoutTypes;
	}

	public ArrayList<LAYOUTER_INFO> getAvailableLayouterInfos() {

		ArrayList<LAYOUTER_INFO> availableLayouterInfos = new ArrayList<LAYOUTER_INFO>();

		for (KimlAbstractLayoutProvider layoutProvider : layoutProviderMap
				.values()) {
			LAYOUTER_INFO info = layoutProvider.getLayouterInfo();
			if (!availableLayouterInfos.contains(info)) {
				availableLayouterInfos.add(info);

			}
		}
		return availableLayouterInfos;
	}

	public LAYOUTER_INFO getLayouterInfoForLayouterName(String layouterName) {
		for (LAYOUTER_INFO layouterInfo : LayoutProviders.getInstance()
				.getAvailableLayouterInfos()) {
			if (layouterInfo.getLayouterName().equals(layouterName)) {
				return layouterInfo;
			}
		}
		return null;
	}

	public ArrayList<String> getAvailableLayoutProviderNames() {
		ArrayList<String> layoutProviderNames = new ArrayList<String>();
		for (KimlAbstractLayoutProvider layoutProvider : layoutProviderMap
				.values()) {
			layoutProviderNames.add(layoutProvider.getLayouterInfo().getLayouterName());
		}
		return layoutProviderNames;
	}
}

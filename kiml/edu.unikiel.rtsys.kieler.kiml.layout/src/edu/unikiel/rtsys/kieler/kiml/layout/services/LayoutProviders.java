package edu.unikiel.rtsys.kieler.kiml.layout.services;

import java.util.ArrayList;
import java.util.HashMap;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.preference.IPreferenceStore;

import edu.unikiel.rtsys.kieler.kiml.layout.Activator;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KNodeGroup;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.LAYOUTER_INFO;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.LAYOUT_TYPE;
import edu.unikiel.rtsys.kieler.kiml.layout.preferences.PreferenceConstants;

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
					for (LAYOUTER_INFO layouterInfo : layoutProvider
							.getLayouterInfos()) {
						layoutProviderMap.put(layouterInfo.getLayouterName(),
								layoutProvider);
					}
				}
			} catch (CoreException e) {
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

		// if layouter name is fitting, use it
		String layouterName = nodeGroup.getLayout().getLayouterName();
		if (layoutProviderMap.containsKey(layouterName)) {
			return layoutProviderMap.get(layouterName);
		}

		// if no proper name, try same layout type
		else {
			for (LAYOUTER_INFO layouterInfo : getAvailableLayouterInfos()) {
				if (layouterInfo.getLayoutType().equals(
						nodeGroup.getLayout().getLayoutType())) {
					return layoutProviderMap
							.get(layouterInfo.getLayouterName());
				}
			}
		}

		// if still no success, use default layout provider, there should at
		// least always be the null layout provider
		IPreferenceStore store = Activator.getDefault().getPreferenceStore();
		String defaultLayoutProvider = store
				.getString(PreferenceConstants.PREF_LAYOUT_DEFAULT_LAYOUTER);
		return layoutProviderMap.get(defaultLayoutProvider);
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
			for (LAYOUT_TYPE type : layoutProvider.getLayoutTypes()) {
				if (!availableLayoutTypes.contains(type)) {
					availableLayoutTypes.add(type);
				}
			}
		}
		return availableLayoutTypes;
	}

	public ArrayList<LAYOUTER_INFO> getAvailableLayouterInfos() {

		ArrayList<LAYOUTER_INFO> availableLayouterInfos = new ArrayList<LAYOUTER_INFO>();

		for (KimlAbstractLayoutProvider layoutProvider : layoutProviderMap
				.values()) {
			for (LAYOUTER_INFO info : layoutProvider.getLayouterInfos()) {
				if (!availableLayouterInfos.contains(info)) {
					availableLayouterInfos.add(info);
				}
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
}

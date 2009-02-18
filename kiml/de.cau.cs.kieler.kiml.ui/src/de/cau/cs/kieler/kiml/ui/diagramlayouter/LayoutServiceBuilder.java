package de.cau.cs.kieler.kiml.ui.diagramlayouter;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.ui.statushandlers.StatusManager;

import de.cau.cs.kieler.core.ui.KielerPreferenceStore;
import de.cau.cs.kieler.kiml.layout.services.IKimlLayoutListener;
import de.cau.cs.kieler.kiml.layout.services.KimlAbstractLayoutProvider;
import de.cau.cs.kieler.kiml.layout.services.KimlLayoutServices;
import de.cau.cs.kieler.kiml.ui.KimlUiPlugin;

/**
 * This class is responsible for reading all extension point elements
 * for layout services.
 * 
 * @author msp
 */
public class LayoutServiceBuilder {

	/**
	 * Build the layout services.
	 */
	public static void buildLayoutServices() {
		// create instance of layout service holder class
		new KimlLayoutServices(new KielerPreferenceStore(KimlUiPlugin
				.getDefault().getPreferenceStore()));
		// build layout services
		loadAvailableLayouters();
		loadAvailableListeners();
	}
	
	/**
	 * Does the actual loading of the layout providers, which need to register
	 * themselves through the kimlLayoutProvider extension point.
	 */
	private static void loadAvailableLayouters() {

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
					KimlLayoutServices.getInstance().addLayoutProvider(
							layoutProvider);
				}
			} catch (CoreException exception) {
				StatusManager.getManager().handle(exception, KimlUiPlugin.PLUGIN_ID);
			}
		}
	}
	
	/**
	 * Does the actual loading of the layout listeners, which need to register
	 * themselves through the kimlLayoutListener extension point.
	 */
	private static void loadAvailableListeners() {
		IExtensionRegistry reg = Platform.getExtensionRegistry();
		IConfigurationElement[] extensions = reg
				.getConfigurationElementsFor(IKimlLayoutListener.EXTENSION_POINT_ID);

		for (IConfigurationElement element : extensions) {
			try {
				IKimlLayoutListener layoutListener = (IKimlLayoutListener) element
						.createExecutableExtension(IKimlLayoutListener.ATTRIBUTE_CLASS);
				if (layoutListener != null) {
					KimlLayoutServices.getInstance().addLayoutListener(
							layoutListener);
				}
			} catch (CoreException exception) {
				StatusManager.getManager().handle(exception, KimlUiPlugin.PLUGIN_ID);
			}
		}
	}
	
}

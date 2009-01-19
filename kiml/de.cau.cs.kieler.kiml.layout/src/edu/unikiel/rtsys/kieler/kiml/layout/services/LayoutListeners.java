package edu.unikiel.rtsys.kieler.kiml.layout.services;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.ui.statushandlers.StatusManager;

import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutPlugin;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KLayoutGraph;

/**
 * Controls all layout listeners.
 * 
 * @author msp
 */
public class LayoutListeners implements IKimlLayoutListener {
	
	/** singleton holder */
	private static final LayoutListeners INSTANCE = new LayoutListeners();

	/** the list of layout listeners that have been loaded at startup */
	private List<IKimlLayoutListener> listeners = new LinkedList<IKimlLayoutListener>();
	
	/**
	 * @return the singleton instance of the LayoutListeners class
	 */
	public static LayoutListeners getInstance() {
		return INSTANCE;
	}

	/**
	 * On creation of the class all available extensions are loaded.
	 */
	private LayoutListeners() {
		loadAvailableListeners();
	};

	/**
	 * Does the actual loading of the layout listeners, which need to register
	 * themselves through the kimlLayoutListener extension point.
	 */
	private void loadAvailableListeners() {
		IExtensionRegistry reg = Platform.getExtensionRegistry();
		IConfigurationElement[] extensions = reg
				.getConfigurationElementsFor(IKimlLayoutListener.EXTENSION_POINT_ID);

		for (IConfigurationElement element : extensions) {
			try {
				IKimlLayoutListener layoutListener = (IKimlLayoutListener) element
						.createExecutableExtension(IKimlLayoutListener.ATTRIBUTE_CLASS);
				if (layoutListener != null) {
					listeners.add(layoutListener);
				}
			} catch (CoreException exception) {
				StatusManager.getManager().handle(exception, KimlLayoutPlugin.PLUGIN_ID);
			}
		}
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
	 */
	public void layoutPerformed(KLayoutGraph layoutGraph) {
		for (IKimlLayoutListener listener : listeners) {
			listener.layoutPerformed(layoutGraph);
		}
	}
	
}

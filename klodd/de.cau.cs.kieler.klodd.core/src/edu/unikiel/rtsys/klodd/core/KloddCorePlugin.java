package edu.unikiel.rtsys.klodd.core;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import edu.unikiel.rtsys.klodd.core.preferences.KloddLayoutPreferences;

/**
 * The activator class controls the plug-in life cycle
 */
public class KloddCorePlugin extends AbstractUIPlugin {

	/** the plug-in ID */
	public static final String PLUGIN_ID = "edu.unikiel.rtsys.klodd.core";
	/** name of the KLoDD layouters collection */
	public static final String COLLECTION_NAME = "KLoDD Layouters";
	
	/** the shared instance */
	private static KloddCorePlugin plugin;
	/** the layout preferences map */
	private static KloddLayoutPreferences layoutPreferences = null;
	
	/**
	 * The constructor
	 */
	public KloddCorePlugin() {
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance.
	 *
	 * @return the shared instance
	 */
	public static KloddCorePlugin getDefault() {
		return plugin;
	}
	
	/**
	 * Returns the layout preferences.
	 * 
	 * @return the layout preferences
	 */
	public static KloddLayoutPreferences getLayoutPreferences() {
		if (layoutPreferences == null)
			layoutPreferences = new KloddLayoutPreferences();
		return layoutPreferences;
	}

	/**
	 * Returns an image descriptor for the image file at the given
	 * plug-in relative path
	 *
	 * @param path the path
	 * @return the image descriptor
	 */
	public static ImageDescriptor getImageDescriptor(String path) {
		return imageDescriptorFromPlugin(PLUGIN_ID, path);
	}
}

package edu.unikiel.rtsys.kieler.kev.extension.scade;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class KevScadePlugin extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "edu.unikiel.rtsys.kieler.kev.extension.scade";

	// The shared instance
	private static KevScadePlugin plugin;
	
	/**
	 * The constructor
	 */
	public KevScadePlugin() {
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
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static KevScadePlugin getDefault() {
		return plugin;
	}

}

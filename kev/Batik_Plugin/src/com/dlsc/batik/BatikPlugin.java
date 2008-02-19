package com.dlsc.batik;

import org.eclipse.core.runtime.Plugin;

/**
 * The main plugin class to be used in the desktop.
 */
public class BatikPlugin extends Plugin {
	//The shared instance.
	private static BatikPlugin plugin;
	
	/**
	 * The constructor.
	 */
	public BatikPlugin() {
		super();
		plugin = this;
	}

	/**
	 * Returns the shared instance.
	 */
	public static BatikPlugin getDefault() {
		return plugin;
	}
}

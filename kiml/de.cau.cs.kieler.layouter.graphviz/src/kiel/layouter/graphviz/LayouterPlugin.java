package kiel.layouter.graphviz;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import de.cau.cs.kieler.layouter.ui.WorkbenchPreferencePage;


/**
 * The activator class controls the plug-in life cycle
 */
public class LayouterPlugin extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "de.cau.cs.kieler.layouter.graphviz";

	// The shared instance
	private static LayouterPlugin plugin;
	private CommonLayer commonLayer;
	
	/**
	 * The constructor
	 */
	public LayouterPlugin() {
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		WorkbenchPreferencePage.setDefaultValues();
		commonLayer = new CommonLayer();
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
	public static LayouterPlugin getDefault() {
		return plugin;
	}
	
	public CommonLayer getCommonLayer(){
		return plugin.commonLayer;
	}

}

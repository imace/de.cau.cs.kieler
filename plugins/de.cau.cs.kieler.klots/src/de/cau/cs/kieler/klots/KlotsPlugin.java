package de.cau.cs.kieler.klots;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

public class KlotsPlugin extends AbstractUIPlugin {

    /** The Constant PLUGIN_ID. */
    public static final String PLUGIN_ID = "de.cau.cs.kieler.klots";

    /** The plugin. */
    private static KlotsPlugin plugin;

    // -------------------------------------------------------------------------

    /**
     * The constructor of the ABRO plug-in.
     */
    public KlotsPlugin() {
    }

    // -------------------------------------------------------------------------


    /**
     * {@inheritDoc}
     */
    public void start(final BundleContext context) throws Exception {
        super.start(context);
        plugin = this;
    }

    // -------------------------------------------------------------------------


    /**
     * {@inheritDoc}
     */
    public void stop(final BundleContext context) throws Exception {
        plugin = null;
        super.stop(context);
    }

    // -------------------------------------------------------------------------

    /**
     * Returns the shared instance of this plug-in.
     * 
     * @return the shared instance
     */
    public static KlotsPlugin getDefault() {
        return plugin;
    }

}
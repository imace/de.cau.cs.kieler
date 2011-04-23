package de.cau.cs.kieler.klots;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import de.cau.cs.kieler.klots.views.SJInstructionsView;

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

    
    public static SJInstructionsView getSJInstructionsView() {
    	return de.cau.cs.kieler.klots.views.SJInstructionsView.getInstance();
    }
    
    
    public static String getSJEditorID() {
    	return de.cau.cs.kieler.klots.editor.SJEditor.ID;
    }
    
}
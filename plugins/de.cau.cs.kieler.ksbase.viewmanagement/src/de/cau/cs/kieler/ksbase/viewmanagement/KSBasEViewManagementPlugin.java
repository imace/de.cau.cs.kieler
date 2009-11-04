/**
 * KIELER - Kiel Integrated Environment for Layout Eclipse RichClient
 *
 * http://www.informatik.uni-kiel.de/rtsys/kieler/
 * 
 * Copyright 2009 by
 * + Christian-Albrechts-University of Kiel
 *   + Department of Computer Science
 *     + Real-Time and Embedded Systems Group
 * 
 * This code is provided under the terms of the Eclipse Public License (EPL).
 * See the file epl-v10.html for the license text.
 * 
 *****************************************************************************/
package de.cau.cs.kieler.ksbase.viewmanagement;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import de.cau.cs.kieler.ksbase.viewmanagement.combinations.KSBasECombination;

/**
 * The activator class controls the plug-in life cycle.
 * 
 * @author Michael Matzen - mim AT informatik.uni-kiel.de
 */
public class KSBasEViewManagementPlugin extends AbstractUIPlugin {

    /** The plug-in ID. **/
    public static final String PLUGIN_ID = "de.cau.cs.kieler.ksbase.viewmanagement";

    /** The shared instance. **/
    private static KSBasEViewManagementPlugin plugin;

    /**
     * The constructor.
     */
    public KSBasEViewManagementPlugin() {
    }

    /**
     * Starts the plug-in.
     * 
     * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
     * @param context
     *            The bundle context for this plug-in
     * @throws Exception
     *             When starting this plug-in fails.
     * 
     */
    public void start(final BundleContext context) throws Exception {
        super.start(context);
        System.out.println("ksbase vm active");
        KSBasEViewManagementPlugin.setPlugin(this);
        /* Does not work here
        //Check if VM is initialized
        if (!RunLogic.getInstance().getRunlogicState()) {
           
            RunLogic.getInstance().registerListeners();
            RunLogic.getCombination("KSBasECombination").setActive(true);
        }
        */
        // Initialize pref page to load all stored settings
        KSBasECombination.initalizeEffects(plugin.getPreferenceStore());
    }

    /**
     * Stops the plug-in.
     * 
     * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
     * @param context
     *            The bundle context for this plug-in
     * @throws Exception
     *             When stopping this plug-in fails.
     */
    public void stop(final BundleContext context) throws Exception {
        KSBasEViewManagementPlugin.setPlugin(null);
        super.stop(context);
    }

    /**
     * Returns the shared instance.
     * 
     * @return the shared instance
     */
    public static KSBasEViewManagementPlugin getDefault() {
        return plugin;
    }

    /**
     * Used to set the plug-in instance.
     * 
     * @param pluginValue
     *            The value to set.
     */
    public static void setPlugin(final KSBasEViewManagementPlugin pluginValue) {
        plugin = pluginValue;
    }
}

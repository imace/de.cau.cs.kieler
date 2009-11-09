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

package de.cau.cs.kieler.ksbase.ui;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import de.cau.cs.kieler.ksbase.ui.menus.DynamicBundleLoader;
import de.cau.cs.kieler.ksbase.ui.menus.DynamicMenuContributions;

/**
 * The activator class controls the plug-in life cycle.
 * 
 * @author Michael Matzen - mim AT informatik.uni-kiel.de
 */

public class KSBasEUIPlugin extends AbstractUIPlugin {

    /** The plug-in ID. **/
    public static final String PLUGIN_ID = "de.cau.cs.kieler.ksbase.ui";

    /** The shared instance. **/
    private static KSBasEUIPlugin plugin;

    /**
     * The constructor.
     */
    public KSBasEUIPlugin() {
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
        KSBasEUIPlugin.setPlugin(this);
        // Creating bundles
        DynamicMenuContributions.INSTANCE.createAllMenuContributions();
        // Temporary fix for "not loading features"-bug
        DynamicBundleLoader.INSTANCE.activateAllEditors();
        /*
         * // Adding a part listener to check when to activate a bundle
         * System.out.println("activated");
         * 
         * if (PlatformUI.getWorkbench() != null) {
         * System.out.println("workbench found");
         * System.out.println("work windows: " +
         * PlatformUI.getWorkbench().getWorkbenchWindows().length);
         * System.out.println("active: " +
         * PlatformUI.getWorkbench().getActiveWorkbenchWindow
         * ().getClass().getCanonicalName());
         * 
         * 
         * PlatformUI.getWorkbench().addWindowListener(DynamicBundleLoader.INSTANCE
         * ); }#
         */
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
        KSBasEUIPlugin.setPlugin(null);
        super.stop(context);
    }

    /**
     * Returns the shared instance.
     * 
     * @return the shared instance
     */
    public static KSBasEUIPlugin getDefault() {
        return plugin;
    }

    /**
     * Used to set the plug-in instance.
     * 
     * @param pluginValue
     *            The value to set.
     */
    public static void setPlugin(final KSBasEUIPlugin pluginValue) {
        plugin = pluginValue;
    }

}

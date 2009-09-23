/******************************************************************************
 * KIELER - Kiel Integrated Environment for Layout for the Eclipse RCP
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

import de.cau.cs.kieler.ksbase.ui.menus.DynamicMenuContributions;

/**
 * The activator class controls the plug-in life cycle
 */

public class KSBasEUIPlugin extends AbstractUIPlugin {

    // The plug-in ID
    public static final String PLUGIN_ID = "de.cau.cs.kieler.ksbase.ui";

    // The shared instance
    private static KSBasEUIPlugin plugin;

    /**
     * The constructor
     */
    public KSBasEUIPlugin() {
        System.out.println("ksbase activated");
        //create menu contributions on activation:
        DynamicMenuContributions.instance.createAllMenuContributions();
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext
     * )
     */
    public void start(BundleContext context) throws Exception {
        super.start(context);
        plugin = this;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext
     * )
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
    public static KSBasEUIPlugin getDefault() {
        return plugin;
    }

}

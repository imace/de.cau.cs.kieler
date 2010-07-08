/*
 * KIELER - Kiel Integrated Environment for Layout Eclipse RichClient
 *
 * http://www.informatik.uni-kiel.de/rtsys/kieler/
 *
 * Copyright 2010 by
 * + Christian-Albrechts-University of Kiel
 *   + Department of Computer Science
 *     + Real-Time and Embedded Systems Group
 *
 * This code is provided under the terms of the Eclipse Public License (EPL).
 * See the file epl-v10.html for the license text.
 */
package de.cau.cs.kieler.kiml.evol;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle.
 *
 * @author bdu
 */
public class EvolPlugin extends AbstractUIPlugin {
    /**
     * The plug-in ID.
     */
    public static final String PLUGIN_ID = "de.cau.cs.kieler.kiml.evol";
    // The shared instance
    private static EvolPlugin plugin;

    /**
     * The constructor.
     */
    public EvolPlugin() {
        // intentionally left empty.
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void start(final BundleContext context) throws Exception {
        super.start(context);
        plugin = this;
        EvolutionExtensionsUtil.createExtensionData();
        System.out.println(EvolutionExtensionsUtil.getInstance().getEvolutionDataIds());
        System.out.println(EvolutionExtensionsUtil.getInstance().getLayoutMetricsIds());
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public void stop(final BundleContext context) throws Exception {
        plugin = null;
        super.stop(context);
    }

    /**
     * Returns the shared instance.
     *
     * @return the shared instance
     */
    public static EvolPlugin getDefault() {
        return plugin;
    }
}
